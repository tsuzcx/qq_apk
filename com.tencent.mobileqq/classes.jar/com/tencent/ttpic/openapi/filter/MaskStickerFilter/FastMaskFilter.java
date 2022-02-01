package com.tencent.ttpic.openapi.filter.MaskStickerFilter;

import com.tencent.aekit.openrender.AEOpenRenderConfig.DRAW_MODE;
import com.tencent.aekit.openrender.AttributeParam;
import com.tencent.aekit.openrender.UniformParam.Float2fParam;
import com.tencent.aekit.openrender.UniformParam.IntParam;
import com.tencent.aekit.openrender.UniformParam.Mat4Param;
import com.tencent.aekit.openrender.UniformParam.TextureParam;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.openrender.internal.VideoFilterBase;
import com.tencent.aekit.openrender.util.GlUtil;
import com.tencent.ttpic.baseutils.fps.BenchUtil;
import com.tencent.ttpic.model.FastDynamicSticker;
import com.tencent.ttpic.model.FastStaticSticker;
import com.tencent.ttpic.model.FastSticker;
import com.tencent.ttpic.model.RenderParam;
import com.tencent.ttpic.openapi.PTDetectInfo;
import com.tencent.ttpic.openapi.model.StickerItem;
import com.tencent.ttpic.openapi.util.MatrixUtil;
import com.tencent.ttpic.util.AlgoUtils;
import com.tencent.ttpic.util.FrameUtil;
import com.tencent.ttpic.util.PersonParam;
import com.tencent.ttpic.util.VideoFilterFactory.POSITION_TYPE;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class FastMaskFilter
  extends VideoFilterBase
{
  private static final String FRAGMENT_SHADER = "precision highp float;\nvarying vec2 canvasCoordinate;\nvarying vec2 textureCoordinate;\nvarying float stickerIndex;\nuniform sampler2D canvas;\nuniform sampler2D inputImageTexture0;\nuniform sampler2D inputImageTexture1;\nuniform sampler2D inputImageTexture2;\nuniform sampler2D inputImageTexture3;\nuniform sampler2D inputImageTexture4;\nuniform sampler2D inputImageTexture5;\nuniform sampler2D inputImageTexture6;\nuniform sampler2D inputImageTexture7;\nuniform int blendMode;\nuniform int maskType;\nvec4 blendColor(vec4 texColor, vec4 canvasColor)\n {\n     vec3 resultFore = texColor.rgb;\n     if (maskType == 1) {\n         resultFore.rgb = min(canvasColor.rgb, texColor.rgb);\n     } else if (maskType == 2) {\n         resultFore.rgb = max(canvasColor.rgb, texColor.rgb);\n     } else {\n     }\n     texColor.a = resultFore.r;\n     vec4 resultColor = vec4(resultFore, texColor.a);\n     return resultColor;\n }\nvoid main(void)\n{\n    vec4 canvasColor = vec4(1.0, 1.0, 1.0, 1.0);\n     if (maskType == 1) {\n         canvasColor = vec4(1.0, 1.0, 1.0, 1.0);\n     } else if (maskType == 2) {\n         canvasColor = vec4(0.0, 0.0, 0.0, 0.0);;\n     } else {\n         canvasColor = vec4(1.0, 1.0, 1.0, 1.0);\n     }\n    vec4 texColor = vec4(0.0, 0.0, 0.0, 0.0);\n    if (0.0 <= stickerIndex && stickerIndex <= 1.0 ) {\n        texColor = texture2D(inputImageTexture0, textureCoordinate);\n    } else if (1.0 <= stickerIndex && stickerIndex <= 2.0) {\n        texColor = texture2D(inputImageTexture1, textureCoordinate);\n    } else if (2.0 <= stickerIndex && stickerIndex <= 3.0) {\n        texColor = texture2D(inputImageTexture2, textureCoordinate);\n    } else if (3.0 <= stickerIndex && stickerIndex <= 4.0) {\n        texColor = texture2D(inputImageTexture3, textureCoordinate);\n    } else if (4.0 <= stickerIndex && stickerIndex <= 5.0) {\n        texColor = texture2D(inputImageTexture4, textureCoordinate);\n    } else if (5.0 <= stickerIndex && stickerIndex <= 6.0) {\n        texColor = texture2D(inputImageTexture5, textureCoordinate);\n    } else if (6.0 <= stickerIndex && stickerIndex <= 7.0) {\n        texColor = texture2D(inputImageTexture6, textureCoordinate);\n    } else {\n        texColor = texture2D(inputImageTexture7, textureCoordinate);\n    }\n    gl_FragColor = blendColor(texColor, canvasColor);\n}\n";
  private static final String VERTEX_SHADER = "   attribute float a_stickerIndex;\n   attribute vec4 position;\n   attribute vec2 inputTextureCoordinate;\n   attribute vec2 texAnchor;\n   attribute float texScale;\n   attribute vec3 texRotate;\n   varying vec2 canvasCoordinate;\n   varying vec2 textureCoordinate;\n   varying float stickerIndex;\n   uniform vec2 canvasSize;\n   uniform mat4 u_MVPMatrix;\n   uniform int texNeedTransform;\n   mat4 texMatTranslateBefore = mat4(1.0, 0.0, 0.0, 0.0,\n           0.0, 1.0, 0.0, 0.0,\n           0.0, 0.0, 1.0, 0.0,\n           0.0, 0.0, 0.0, 1.0);\n   mat4 texMatScale = mat4(1.0, 0.0, 0.0, 0.0,\n           0.0, 1.0, 0.0, 0.0,\n           0.0, 0.0, 1.0, 0.0,\n           0.0, 0.0, 0.0, 1.0);\n   mat4 texMatRotate = mat4(1.0, 0.0, 0.0, 0.0,\n           0.0, 1.0, 0.0, 0.0,\n           0.0, 0.0, 1.0, 0.0,\n           0.0, 0.0, 0.0, 1.0);\n   mat4 texMatRotateXY = mat4(1.0, 0.0, 0.0, 0.0,\n           0.0, 1.0, 0.0, 0.0,\n           0.0, 0.0, 1.0, 0.0,\n           0.0, 0.0, 0.0, 1.0);\n   mat4 texMatTranslateAfter = mat4(1.0, 0.0, 0.0, 0.0,\n           0.0, 1.0, 0.0, 0.0,\n           0.0, 0.0, 1.0, 0.0,\n           0.0, 0.0, 0.0, 1.0);\n   mat4 mat4RotationYXZ(mat4 m, float xRadians, float yRadians, float zRadians) {\n   /*\n    |  cycz + sxsysz   czsxsy - cysz   cxsy  0 |\nM = |  cxsz            cxcz           -sx    0 |\n    |  cysxsz - czsy   cyczsx + sysz   cxcy  0 |\n    |  0               0               0     1 |\n    where cA = cos(A), sA = sin(A) for A = x,y,z\n    */\n       float cx = cos(xRadians);\n       float sx = sin(xRadians);\n       float cy = cos(yRadians);\n       float sy = sin(yRadians);\n       float cz = cos(zRadians);\n       float sz = sin(zRadians);\n       m[0][0] = (cy * cz) + (sx * sy * sz);\n       m[0][1] = cx * sz;\n       m[0][2] = (cy * sx * sz) - (cz * sy);\n       m[0][3] = 0.0;\n       m[1][0] = (cz * sx * sy) - (cy * sz);\n       m[1][1] = cx * cz;\n       m[1][2] = (cy * cz * sx) + (sy * sz);\n       m[1][3] = 0.0;\n       m[2][0] = cx * sy;\n       m[2][1] = -sx;\n       m[2][2] = cx * cy;\n       m[2][3] = 0.0;\n       m[3][0] = 0.0;\n       m[3][1] = 0.0;\n       m[3][2] = 0.0;\n       m[3][3] = 1.0;\n       return m;\n   }\n   void main(){\n       vec4 framePos = position;\n       if (texNeedTransform > 0) {\n           framePos.x = framePos.x * canvasSize.x * 0.5;\n           framePos.y = framePos.y * canvasSize.y * 0.5;\n           texMatTranslateBefore[3][0] = -texAnchor.x;\n           texMatTranslateBefore[3][1] = -texAnchor.y;\n           texMatScale[0][0] = texScale;\n           texMatScale[1][1] = texScale;\n           texMatRotate = mat4RotationYXZ(texMatRotate, 0.0, 0.0, texRotate.z);\n           texMatRotateXY = mat4RotationYXZ(texMatRotateXY, texRotate.x, texRotate.y, 0.0);\n           texMatTranslateAfter[3][0] = texAnchor.x;\n           texMatTranslateAfter[3][1] = texAnchor.y;\n           framePos = texMatRotate * texMatScale * texMatTranslateBefore * framePos;\n           framePos.x = framePos.x * 2.0 / canvasSize.x;\n           framePos.y = framePos.y * 2.0 / canvasSize.y;\n           framePos = texMatRotateXY * framePos;\n           framePos.x = framePos.x * canvasSize.x * 0.5;\n           framePos.y = framePos.y * canvasSize.y * 0.5;\n           framePos = texMatTranslateAfter * framePos;\n           framePos.x = framePos.x * 2.0 / canvasSize.x;\n           framePos.y = framePos.y * 2.0 / canvasSize.y;\n           framePos.x = framePos.x * 1.5 ;\n           framePos.y = framePos.y * 1.5 ;\n           framePos = u_MVPMatrix * framePos;\n       }\n       gl_Position = framePos;\n       canvasCoordinate = vec2(framePos.x / framePos.w * 0.5 + 0.5, framePos.y / framePos.w * 0.5 + 0.5);\n       textureCoordinate = inputTextureCoordinate;\n       stickerIndex = a_stickerIndex;\n   }\n";
  private String TAG = FastMaskFilter.class.getSimpleName();
  private int faceCount;
  private Frame mCopyFrame = new Frame();
  private int maskType;
  private List<RenderParam> renderParams = new ArrayList();
  private RenderParam srcRenderParam;
  private List<FastSticker> stickerList = new ArrayList();
  
  public FastMaskFilter(int paramInt)
  {
    super("   attribute float a_stickerIndex;\n   attribute vec4 position;\n   attribute vec2 inputTextureCoordinate;\n   attribute vec2 texAnchor;\n   attribute float texScale;\n   attribute vec3 texRotate;\n   varying vec2 canvasCoordinate;\n   varying vec2 textureCoordinate;\n   varying float stickerIndex;\n   uniform vec2 canvasSize;\n   uniform mat4 u_MVPMatrix;\n   uniform int texNeedTransform;\n   mat4 texMatTranslateBefore = mat4(1.0, 0.0, 0.0, 0.0,\n           0.0, 1.0, 0.0, 0.0,\n           0.0, 0.0, 1.0, 0.0,\n           0.0, 0.0, 0.0, 1.0);\n   mat4 texMatScale = mat4(1.0, 0.0, 0.0, 0.0,\n           0.0, 1.0, 0.0, 0.0,\n           0.0, 0.0, 1.0, 0.0,\n           0.0, 0.0, 0.0, 1.0);\n   mat4 texMatRotate = mat4(1.0, 0.0, 0.0, 0.0,\n           0.0, 1.0, 0.0, 0.0,\n           0.0, 0.0, 1.0, 0.0,\n           0.0, 0.0, 0.0, 1.0);\n   mat4 texMatRotateXY = mat4(1.0, 0.0, 0.0, 0.0,\n           0.0, 1.0, 0.0, 0.0,\n           0.0, 0.0, 1.0, 0.0,\n           0.0, 0.0, 0.0, 1.0);\n   mat4 texMatTranslateAfter = mat4(1.0, 0.0, 0.0, 0.0,\n           0.0, 1.0, 0.0, 0.0,\n           0.0, 0.0, 1.0, 0.0,\n           0.0, 0.0, 0.0, 1.0);\n   mat4 mat4RotationYXZ(mat4 m, float xRadians, float yRadians, float zRadians) {\n   /*\n    |  cycz + sxsysz   czsxsy - cysz   cxsy  0 |\nM = |  cxsz            cxcz           -sx    0 |\n    |  cysxsz - czsy   cyczsx + sysz   cxcy  0 |\n    |  0               0               0     1 |\n    where cA = cos(A), sA = sin(A) for A = x,y,z\n    */\n       float cx = cos(xRadians);\n       float sx = sin(xRadians);\n       float cy = cos(yRadians);\n       float sy = sin(yRadians);\n       float cz = cos(zRadians);\n       float sz = sin(zRadians);\n       m[0][0] = (cy * cz) + (sx * sy * sz);\n       m[0][1] = cx * sz;\n       m[0][2] = (cy * sx * sz) - (cz * sy);\n       m[0][3] = 0.0;\n       m[1][0] = (cz * sx * sy) - (cy * sz);\n       m[1][1] = cx * cz;\n       m[1][2] = (cy * cz * sx) + (sy * sz);\n       m[1][3] = 0.0;\n       m[2][0] = cx * sy;\n       m[2][1] = -sx;\n       m[2][2] = cx * cy;\n       m[2][3] = 0.0;\n       m[3][0] = 0.0;\n       m[3][1] = 0.0;\n       m[3][2] = 0.0;\n       m[3][3] = 1.0;\n       return m;\n   }\n   void main(){\n       vec4 framePos = position;\n       if (texNeedTransform > 0) {\n           framePos.x = framePos.x * canvasSize.x * 0.5;\n           framePos.y = framePos.y * canvasSize.y * 0.5;\n           texMatTranslateBefore[3][0] = -texAnchor.x;\n           texMatTranslateBefore[3][1] = -texAnchor.y;\n           texMatScale[0][0] = texScale;\n           texMatScale[1][1] = texScale;\n           texMatRotate = mat4RotationYXZ(texMatRotate, 0.0, 0.0, texRotate.z);\n           texMatRotateXY = mat4RotationYXZ(texMatRotateXY, texRotate.x, texRotate.y, 0.0);\n           texMatTranslateAfter[3][0] = texAnchor.x;\n           texMatTranslateAfter[3][1] = texAnchor.y;\n           framePos = texMatRotate * texMatScale * texMatTranslateBefore * framePos;\n           framePos.x = framePos.x * 2.0 / canvasSize.x;\n           framePos.y = framePos.y * 2.0 / canvasSize.y;\n           framePos = texMatRotateXY * framePos;\n           framePos.x = framePos.x * canvasSize.x * 0.5;\n           framePos.y = framePos.y * canvasSize.y * 0.5;\n           framePos = texMatTranslateAfter * framePos;\n           framePos.x = framePos.x * 2.0 / canvasSize.x;\n           framePos.y = framePos.y * 2.0 / canvasSize.y;\n           framePos.x = framePos.x * 1.5 ;\n           framePos.y = framePos.y * 1.5 ;\n           framePos = u_MVPMatrix * framePos;\n       }\n       gl_Position = framePos;\n       canvasCoordinate = vec2(framePos.x / framePos.w * 0.5 + 0.5, framePos.y / framePos.w * 0.5 + 0.5);\n       textureCoordinate = inputTextureCoordinate;\n       stickerIndex = a_stickerIndex;\n   }\n", "precision highp float;\nvarying vec2 canvasCoordinate;\nvarying vec2 textureCoordinate;\nvarying float stickerIndex;\nuniform sampler2D canvas;\nuniform sampler2D inputImageTexture0;\nuniform sampler2D inputImageTexture1;\nuniform sampler2D inputImageTexture2;\nuniform sampler2D inputImageTexture3;\nuniform sampler2D inputImageTexture4;\nuniform sampler2D inputImageTexture5;\nuniform sampler2D inputImageTexture6;\nuniform sampler2D inputImageTexture7;\nuniform int blendMode;\nuniform int maskType;\nvec4 blendColor(vec4 texColor, vec4 canvasColor)\n {\n     vec3 resultFore = texColor.rgb;\n     if (maskType == 1) {\n         resultFore.rgb = min(canvasColor.rgb, texColor.rgb);\n     } else if (maskType == 2) {\n         resultFore.rgb = max(canvasColor.rgb, texColor.rgb);\n     } else {\n     }\n     texColor.a = resultFore.r;\n     vec4 resultColor = vec4(resultFore, texColor.a);\n     return resultColor;\n }\nvoid main(void)\n{\n    vec4 canvasColor = vec4(1.0, 1.0, 1.0, 1.0);\n     if (maskType == 1) {\n         canvasColor = vec4(1.0, 1.0, 1.0, 1.0);\n     } else if (maskType == 2) {\n         canvasColor = vec4(0.0, 0.0, 0.0, 0.0);;\n     } else {\n         canvasColor = vec4(1.0, 1.0, 1.0, 1.0);\n     }\n    vec4 texColor = vec4(0.0, 0.0, 0.0, 0.0);\n    if (0.0 <= stickerIndex && stickerIndex <= 1.0 ) {\n        texColor = texture2D(inputImageTexture0, textureCoordinate);\n    } else if (1.0 <= stickerIndex && stickerIndex <= 2.0) {\n        texColor = texture2D(inputImageTexture1, textureCoordinate);\n    } else if (2.0 <= stickerIndex && stickerIndex <= 3.0) {\n        texColor = texture2D(inputImageTexture2, textureCoordinate);\n    } else if (3.0 <= stickerIndex && stickerIndex <= 4.0) {\n        texColor = texture2D(inputImageTexture3, textureCoordinate);\n    } else if (4.0 <= stickerIndex && stickerIndex <= 5.0) {\n        texColor = texture2D(inputImageTexture4, textureCoordinate);\n    } else if (5.0 <= stickerIndex && stickerIndex <= 6.0) {\n        texColor = texture2D(inputImageTexture5, textureCoordinate);\n    } else if (6.0 <= stickerIndex && stickerIndex <= 7.0) {\n        texColor = texture2D(inputImageTexture6, textureCoordinate);\n    } else {\n        texColor = texture2D(inputImageTexture7, textureCoordinate);\n    }\n    gl_FragColor = blendColor(texColor, canvasColor);\n}\n");
    this.maskType = paramInt;
    initParams();
    setDrawMode(AEOpenRenderConfig.DRAW_MODE.TRIANGLES);
  }
  
  private void mergeRenderParam(RenderParam paramRenderParam, List<RenderParam> paramList)
  {
    BenchUtil.benchStart("mergeRenderParam");
    if (paramRenderParam != null) {}
    float[] arrayOfFloat1;
    float[] arrayOfFloat2;
    float[] arrayOfFloat3;
    float[] arrayOfFloat4;
    float[] arrayOfFloat5;
    float[] arrayOfFloat6;
    for (int j = 1;; j = 0)
    {
      arrayOfFloat1 = new float[(paramList.size() + j) * GlUtil.EMPTY_POSITIONS_TRIANGLES.length];
      arrayOfFloat2 = new float[(paramList.size() + j) * GlUtil.ORIGIN_TEX_COORDS_TRIANGLES.length];
      arrayOfFloat3 = new float[(paramList.size() + j) * 6];
      arrayOfFloat4 = new float[(paramList.size() + j) * 6 * 2];
      arrayOfFloat5 = new float[(paramList.size() + j) * 6 * 1];
      arrayOfFloat6 = new float[(paramList.size() + j) * 6 * 3];
      if (paramRenderParam == null) {
        break label1024;
      }
      i = 0;
      while (i < paramRenderParam.position.length)
      {
        arrayOfFloat1[i] = paramRenderParam.position[i];
        i += 1;
      }
    }
    int i = 0;
    while (i < GlUtil.ORIGIN_TEX_COORDS_TRIANGLES.length)
    {
      arrayOfFloat2[i] = GlUtil.ORIGIN_TEX_COORDS_TRIANGLES[i];
      i += 1;
    }
    i = 0;
    while (i < 6)
    {
      arrayOfFloat3[i] = 0.5F;
      i += 1;
    }
    i = 0;
    while (i < 12)
    {
      arrayOfFloat4[i] = paramRenderParam.texAnchor[(i % 2)];
      i += 1;
    }
    i = 0;
    while (i < 6)
    {
      arrayOfFloat5[i] = paramRenderParam.texScale;
      i += 1;
    }
    i = 0;
    while (i < 18)
    {
      arrayOfFloat6[i] = paramRenderParam.texRotate[(i % 3)];
      i += 1;
    }
    addParam(new UniformParam.TextureParam("inputImageTexture0", paramRenderParam.texture, 33985));
    label1024:
    for (i = 1;; i = 0)
    {
      if (!paramList.isEmpty())
      {
        paramRenderParam = new HashMap();
        int k = 0;
        int m = i;
        int n;
        while (k < paramList.size())
        {
          RenderParam localRenderParam = (RenderParam)paramList.get(k);
          if (!paramRenderParam.containsKey(localRenderParam.id))
          {
            paramRenderParam.put(localRenderParam.id, Integer.valueOf(m));
            addParam(new UniformParam.TextureParam("inputImageTexture" + m, ((RenderParam)paramList.get(k)).texture, 33985 + m));
          }
          n = 0;
          while (n < 6)
          {
            arrayOfFloat3[(m * 6 + n)] = (((Integer)paramRenderParam.get(((RenderParam)paramList.get(k)).id)).intValue() + 0.5F);
            n += 1;
          }
          m += 1;
          k += 1;
        }
        k = 0;
        m = i;
        while (k < paramList.size())
        {
          n = 0;
          while (n < ((RenderParam)paramList.get(k)).position.length)
          {
            arrayOfFloat1[(((RenderParam)paramList.get(k)).position.length * m + n)] = ((RenderParam)paramList.get(k)).position[n];
            n += 1;
          }
          m += 1;
          k += 1;
        }
        k = 0;
        m = i;
        while (k < paramList.size())
        {
          n = 0;
          while (n < GlUtil.ORIGIN_TEX_COORDS_TRIANGLES.length)
          {
            arrayOfFloat2[(GlUtil.ORIGIN_TEX_COORDS_TRIANGLES.length * m + n)] = GlUtil.ORIGIN_TEX_COORDS_TRIANGLES[n];
            n += 1;
          }
          m += 1;
          k += 1;
        }
        k = 0;
        m = i;
        while (k < paramList.size())
        {
          n = 0;
          while (n < 12)
          {
            arrayOfFloat4[(m * 6 * 2 + n)] = ((RenderParam)paramList.get(k)).texAnchor[(n % 2)];
            n += 1;
          }
          m += 1;
          k += 1;
        }
        k = 0;
        m = i;
        while (k < paramList.size())
        {
          n = 0;
          while (n < 6)
          {
            arrayOfFloat5[(m * 6 + n)] = ((RenderParam)paramList.get(k)).texScale;
            n += 1;
          }
          m += 1;
          k += 1;
        }
        m = 0;
        k = i;
        i = m;
        while (i < paramList.size())
        {
          m = 0;
          while (m < 18)
          {
            arrayOfFloat6[(k * 6 * 3 + m)] = ((RenderParam)paramList.get(i)).texRotate[(m % 3)];
            m += 1;
          }
          k += 1;
          i += 1;
        }
      }
      setPositions(arrayOfFloat1);
      setTexCords(arrayOfFloat2);
      setCoordNum((paramList.size() + j) * 6);
      addAttribParam(new AttributeParam("a_stickerIndex", arrayOfFloat3, 1));
      addAttribParam(new AttributeParam("texAnchor", arrayOfFloat4, 2));
      addAttribParam(new AttributeParam("texScale", arrayOfFloat5, 1));
      addAttribParam(new AttributeParam("texRotate", arrayOfFloat6, 3));
      BenchUtil.benchEnd("mergeRenderParam");
      return;
    }
  }
  
  public void ApplyGLSLFilter()
  {
    super.ApplyGLSLFilter();
    Iterator localIterator = this.stickerList.iterator();
    while (localIterator.hasNext()) {
      ((FastSticker)localIterator.next()).ApplyGLSLFilter();
    }
  }
  
  public void addSrcTexture(int paramInt)
  {
    if (paramInt > 0)
    {
      this.srcRenderParam = new RenderParam();
      this.srcRenderParam.texture = paramInt;
      this.srcRenderParam.position = AlgoUtils.calPositionsTriangles(0.0F, this.height, this.width, 0.0F, this.width, this.height);
      this.srcRenderParam.texScale = 1.0F;
    }
  }
  
  public void addSticker(StickerItem paramStickerItem, String paramString)
  {
    if ((paramStickerItem.type == VideoFilterFactory.POSITION_TYPE.STATIC.type) || (paramStickerItem.type == VideoFilterFactory.POSITION_TYPE.RELATIVE.type)) {
      this.stickerList.add(new FastStaticSticker(paramStickerItem, paramString));
    }
    while ((paramStickerItem.type != VideoFilterFactory.POSITION_TYPE.DYNAMIC.type) && (paramStickerItem.type != VideoFilterFactory.POSITION_TYPE.GESTURE.type) && (paramStickerItem.type != VideoFilterFactory.POSITION_TYPE.BODY.type)) {
      return;
    }
    this.stickerList.add(new FastDynamicSticker(paramStickerItem, paramString));
  }
  
  public void clearGLSLSelf()
  {
    super.clearGLSLSelf();
    Iterator localIterator = this.stickerList.iterator();
    while (localIterator.hasNext()) {
      ((FastSticker)localIterator.next()).destroy();
    }
    if (this.mCopyFrame != null) {
      this.mCopyFrame.clear();
    }
  }
  
  public void destroyAudio()
  {
    Iterator localIterator = this.stickerList.iterator();
    while (localIterator.hasNext()) {
      ((FastSticker)localIterator.next()).destroyAudio();
    }
  }
  
  public int getMaskType()
  {
    return this.maskType;
  }
  
  public int getStickerListSize()
  {
    return this.stickerList.size();
  }
  
  public void initAttribParams()
  {
    setPositions(GlUtil.ORIGIN_TEX_COORDS_TRIANGLES);
    setTexCords(new float[] { 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 1.0F, 1.0F });
    setCoordNum(4);
    addAttribParam(new AttributeParam("a_stickerIndex", new float[] { 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F }, 1));
    addAttribParam(new AttributeParam("texAnchor", new float[] { 0.0F, 0.0F }, 2));
    addAttribParam(new AttributeParam("texScale", new float[] { 0.0F }, 1));
    addAttribParam(new AttributeParam("texRotate", new float[] { 0.0F, 0.0F, 0.0F }, 3));
  }
  
  public void initParams()
  {
    addParam(new UniformParam.IntParam("maskType", this.maskType));
    addParam(new UniformParam.IntParam("texNeedTransform", 1));
    addParam(new UniformParam.Float2fParam("canvasSize", 0.0F, 0.0F));
    addParam(new UniformParam.Mat4Param("u_MVPMatrix", MatrixUtil.getMVPMatrix(6.0F, 4.0F, 10.0F)));
    int i = 0;
    while (i <= 7)
    {
      addParam(new UniformParam.TextureParam("inputImageTexture" + i, 0, 33986));
      i += 1;
    }
  }
  
  public Frame render(Frame paramFrame)
  {
    if (((!this.renderParams.isEmpty()) && (this.faceCount > 0)) || (this.srcRenderParam != null)) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        mergeRenderParam(this.srcRenderParam, this.renderParams);
        FrameUtil.clearFrame(this.mCopyFrame, 0.0F, 0.0F, 0.0F, 0.0F, paramFrame.width, paramFrame.height);
        RenderProcess(paramFrame.getTextureId(), paramFrame.width, paramFrame.height, -1, 0.0D, this.mCopyFrame);
      }
      this.renderParams.clear();
      this.srcRenderParam = null;
      return this.mCopyFrame;
    }
  }
  
  public void reset()
  {
    Iterator localIterator = this.stickerList.iterator();
    while (localIterator.hasNext()) {
      ((FastSticker)localIterator.next()).reset();
    }
  }
  
  public void setAudioPause(boolean paramBoolean)
  {
    Iterator localIterator = this.stickerList.iterator();
    while (localIterator.hasNext()) {
      ((FastSticker)localIterator.next()).setAudioPause(paramBoolean);
    }
  }
  
  public void setFaceCount(int paramInt)
  {
    this.faceCount = paramInt;
  }
  
  public boolean setPositions(float[] paramArrayOfFloat)
  {
    addAttribParam("position", paramArrayOfFloat);
    return true;
  }
  
  public void setRatio(float paramFloat)
  {
    Iterator localIterator = this.stickerList.iterator();
    while (localIterator.hasNext())
    {
      FastSticker localFastSticker = (FastSticker)localIterator.next();
      if ((localFastSticker instanceof FastStaticSticker)) {
        ((FastStaticSticker)localFastSticker).setRatio(paramFloat);
      }
    }
  }
  
  public void setRenderParams(int paramInt)
  {
    Iterator localIterator = this.stickerList.iterator();
    while (localIterator.hasNext())
    {
      FastSticker localFastSticker = (FastSticker)localIterator.next();
      if (localFastSticker.needRender(paramInt)) {
        this.renderParams.add(localFastSticker.getRenderParam().copy());
      }
    }
  }
  
  public void setRenderParams(PersonParam paramPersonParam)
  {
    if (paramPersonParam == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.stickerList.iterator();
      while (localIterator.hasNext())
      {
        FastSticker localFastSticker = (FastSticker)localIterator.next();
        if ((localFastSticker.needRender(paramPersonParam.getPersonID())) && (localFastSticker.isMatchGender(paramPersonParam))) {
          this.renderParams.add(localFastSticker.getRenderParam().copy());
        }
      }
    }
  }
  
  public boolean setTexCords(float[] paramArrayOfFloat)
  {
    addAttribParam("inputTextureCoordinate", paramArrayOfFloat);
    return true;
  }
  
  public void updatePreview(PTDetectInfo paramPTDetectInfo)
  {
    Iterator localIterator = this.stickerList.iterator();
    while (localIterator.hasNext()) {
      ((FastSticker)localIterator.next()).updatePreview(paramPTDetectInfo);
    }
  }
  
  public void updateVideoSize(int paramInt1, int paramInt2, double paramDouble)
  {
    this.width = paramInt1;
    this.height = paramInt2;
    addParam(new UniformParam.Float2fParam("canvasSize", paramInt1, paramInt2));
    Iterator localIterator = this.stickerList.iterator();
    while (localIterator.hasNext()) {
      ((FastSticker)localIterator.next()).updateVideoSize(paramInt1, paramInt2, paramDouble);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.MaskStickerFilter.FastMaskFilter
 * JD-Core Version:    0.7.0.1
 */