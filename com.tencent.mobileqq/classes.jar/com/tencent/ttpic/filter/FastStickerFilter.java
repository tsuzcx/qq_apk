package com.tencent.ttpic.filter;

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
import com.tencent.ttpic.openapi.model.RedPacketPosition;
import com.tencent.ttpic.openapi.model.StickerItem;
import com.tencent.ttpic.openapi.shader.ShaderCreateFactory.PROGRAM_TYPE;
import com.tencent.ttpic.openapi.shader.ShaderManager;
import com.tencent.ttpic.openapi.util.MatrixUtil;
import com.tencent.ttpic.trigger.TriggerCtrlItem;
import com.tencent.ttpic.util.AlgoUtils;
import com.tencent.ttpic.util.PersonParam;
import com.tencent.ttpic.util.VideoFilterFactory.POSITION_TYPE;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class FastStickerFilter
  extends VideoFilterBase
{
  private static final String TAG = FastStickerFilter.class.getSimpleName();
  private int faceCount;
  private List<RenderParam> renderParams = new ArrayList();
  private RenderParam srcRenderParam;
  private List<FastSticker> stickerList = new ArrayList();
  
  public FastStickerFilter()
  {
    super(ShaderManager.getInstance().getShader(ShaderCreateFactory.PROGRAM_TYPE.FAST_STICKER));
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
  
  public void Render(Frame paramFrame)
  {
    if (((!this.renderParams.isEmpty()) && (this.faceCount > 0)) || (this.srcRenderParam != null)) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        mergeRenderParam(this.srcRenderParam, this.renderParams);
        RenderProcess(paramFrame.getTextureId(), paramFrame.width, paramFrame.height, -1, 0.0D, paramFrame);
      }
      this.renderParams.clear();
      this.srcRenderParam = null;
      return;
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
  }
  
  public void destroyAudio()
  {
    Iterator localIterator = this.stickerList.iterator();
    while (localIterator.hasNext()) {
      ((FastSticker)localIterator.next()).destroyAudio();
    }
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
  
  public void setHotArea(ArrayList<RedPacketPosition> paramArrayList)
  {
    if (this.stickerList != null)
    {
      Iterator localIterator = this.stickerList.iterator();
      while (localIterator.hasNext()) {
        ((FastSticker)localIterator.next()).setHotAreaPosition(paramArrayList);
      }
    }
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
  
  public void setTriggerCtrlItemMap(HashMap<String, TriggerCtrlItem> paramHashMap)
  {
    if (paramHashMap != null)
    {
      Iterator localIterator = this.stickerList.iterator();
      while (localIterator.hasNext())
      {
        FastSticker localFastSticker = (FastSticker)localIterator.next();
        TriggerCtrlItem localTriggerCtrlItem = (TriggerCtrlItem)paramHashMap.get(localFastSticker.getItemID());
        if (localTriggerCtrlItem != null) {
          localFastSticker.setTriggerCtrlItem(localTriggerCtrlItem);
        }
      }
    }
  }
  
  public void updatePreview(Object paramObject)
  {
    if ((paramObject instanceof PTDetectInfo))
    {
      paramObject = (PTDetectInfo)paramObject;
      Iterator localIterator = this.stickerList.iterator();
      while (localIterator.hasNext()) {
        ((FastSticker)localIterator.next()).updatePreview(paramObject);
      }
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
 * Qualified Name:     com.tencent.ttpic.filter.FastStickerFilter
 * JD-Core Version:    0.7.0.1
 */