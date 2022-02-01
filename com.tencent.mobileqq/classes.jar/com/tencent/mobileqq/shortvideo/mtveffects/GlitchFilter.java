package com.tencent.mobileqq.shortvideo.mtveffects;

import android.graphics.RectF;
import android.opengl.GLES20;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.ttpic.openapi.filter.GPUBaseFilter;
import java.nio.FloatBuffer;

public class GlitchFilter
  extends GPUBaseFilter
  implements VertexDataJobListener
{
  public static final int BYTES_PER_FLOAT = 4;
  public static final int COORDS_PER_VERTEX = 2;
  public static final int DISPLACE_COLOR_BLUE = 2;
  public static final int DISPLACE_COLOR_GREEN = 1;
  public static final int DISPLACE_COLOR_NONE = -1;
  public static final int DISPLACE_COLOR_RED = 0;
  public static final String GLITCH_FRAGMENT_SHADER = "precision highp float;\nvarying vec2 vTextureCoord;\nuniform sampler2D inputImageTexture;//!素材图片\nuniform vec4 dstColor; //!素材图片颜色替换 x 是否启用 y z w 颜色值 alpha不改变\n\nvoid main()\n{\n    vec4 v4DstColor = texture2D(inputImageTexture, vTextureCoord);\n    if (dstColor.x > 0.0)\n    {\n        //!需要颜色替换\n        gl_FragColor = vec4(dstColor.yzw, v4DstColor.a);\n    }\n    else\n    {\n        gl_FragColor = v4DstColor;\n    }\n}\n";
  public static final String GLITCH_VERTEX_SHADER = "precision highp float;\nuniform int nHorizontalColor; //!水平置换颜色(-1=无效,0=R,1=G,2=B)\nuniform vec2 vDisParamH; //!x:最大水平置换 y:水平偏移\nuniform int nVerticalColor; //!垂直置换颜色((-1=无效,0=R,1=G,2=B)\nuniform vec2 vDisParamV; //!x:最大水平置换 y:垂直偏移\nuniform sampler2D uGlitchTexture;\nattribute vec4 aPosition;\nvarying vec2 vTextureCoord;\n\nfloat getDisplacementValue(vec4 v4Glitch, int nColor, vec2 v2Param)\n{\n    if (nColor < 0){\n        return 0.0;\n    }\n    //!水平置换有效\n    float fValue = 0.0;\n    if (nColor == 0)\n    {\n        fValue = v4Glitch.r;\n    }\n    else if (nColor == 1)\n    {\n        fValue = v4Glitch.g;\n    }\n    else if (nColor == 2)\n    {\n        fValue = v4Glitch.b;\n    }\n\n    return (fValue * 2.0 - 1.0) * v2Param.x + v2Param.y * 2.0;\n}\n\nvoid main()\n {\n    vTextureCoord = vec2((aPosition.x + 1.0) / 2.0, (aPosition.y + 1.0) / 2.0);\n    vec4 v4Glitch = texture2DLod(uGlitchTexture, aPosition.xy, 0.0);\n\n    float fDisHor = getDisplacementValue(v4Glitch, nHorizontalColor, vDisParamH);\n    float fDisVer = getDisplacementValue(v4Glitch, nVerticalColor, vDisParamV);\n    gl_Position = vec4(aPosition.x + fDisHor, aPosition.y + fDisVer, aPosition.zw);\n}\n";
  private static final String TAG = "GlitchFilter";
  private static final FloatBuffer mTextureData = GlUtil.createFloatBuffer(TEXUTURE_COORDS);
  private int[] mArrayBuffers = null;
  private int mAttrPosition = -1;
  private int mAttrTextureCoord = -1;
  private int mDisColorH = -1;
  private int mDisColorV = -1;
  private RectF mGlitchAraea = null;
  private float mMaxDisH = 0.5F;
  private float mMaxDisV = 0.5F;
  private float mShiftH = 0.0F;
  private float mShiftY = 0.0F;
  private int mUniDisParamH = -1;
  private int mUniDisParamV = -1;
  private int mUniDstColor = -1;
  private int mUniGlitchTexture = -1;
  private int mUniHorColor = -1;
  private int mUniInputTexture = -1;
  private int mUniVerColor = -1;
  private FloatBuffer mVertexData;
  
  public GlitchFilter(RectF paramRectF)
  {
    super("precision highp float;\nuniform int nHorizontalColor; //!水平置换颜色(-1=无效,0=R,1=G,2=B)\nuniform vec2 vDisParamH; //!x:最大水平置换 y:水平偏移\nuniform int nVerticalColor; //!垂直置换颜色((-1=无效,0=R,1=G,2=B)\nuniform vec2 vDisParamV; //!x:最大水平置换 y:垂直偏移\nuniform sampler2D uGlitchTexture;\nattribute vec4 aPosition;\nvarying vec2 vTextureCoord;\n\nfloat getDisplacementValue(vec4 v4Glitch, int nColor, vec2 v2Param)\n{\n    if (nColor < 0){\n        return 0.0;\n    }\n    //!水平置换有效\n    float fValue = 0.0;\n    if (nColor == 0)\n    {\n        fValue = v4Glitch.r;\n    }\n    else if (nColor == 1)\n    {\n        fValue = v4Glitch.g;\n    }\n    else if (nColor == 2)\n    {\n        fValue = v4Glitch.b;\n    }\n\n    return (fValue * 2.0 - 1.0) * v2Param.x + v2Param.y * 2.0;\n}\n\nvoid main()\n {\n    vTextureCoord = vec2((aPosition.x + 1.0) / 2.0, (aPosition.y + 1.0) / 2.0);\n    vec4 v4Glitch = texture2DLod(uGlitchTexture, aPosition.xy, 0.0);\n\n    float fDisHor = getDisplacementValue(v4Glitch, nHorizontalColor, vDisParamH);\n    float fDisVer = getDisplacementValue(v4Glitch, nVerticalColor, vDisParamV);\n    gl_Position = vec4(aPosition.x + fDisHor, aPosition.y + fDisVer, aPosition.zw);\n}\n", "precision highp float;\nvarying vec2 vTextureCoord;\nuniform sampler2D inputImageTexture;//!素材图片\nuniform vec4 dstColor; //!素材图片颜色替换 x 是否启用 y z w 颜色值 alpha不改变\n\nvoid main()\n{\n    vec4 v4DstColor = texture2D(inputImageTexture, vTextureCoord);\n    if (dstColor.x > 0.0)\n    {\n        //!需要颜色替换\n        gl_FragColor = vec4(dstColor.yzw, v4DstColor.a);\n    }\n    else\n    {\n        gl_FragColor = v4DstColor;\n    }\n}\n");
    this.mGlitchAraea = paramRectF;
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    int[] arrayOfInt = this.mArrayBuffers;
    if (arrayOfInt != null)
    {
      GLES20.glDeleteBuffers(arrayOfInt.length, arrayOfInt, 0);
      this.mArrayBuffers = null;
    }
  }
  
  protected void onInitialized()
  {
    super.onInitialized();
    int i = getProgram();
    if (i <= 0) {
      return;
    }
    GLES20.glUseProgram(i);
    this.mAttrPosition = GLES20.glGetAttribLocation(i, "aPosition");
    this.mUniGlitchTexture = GLES20.glGetUniformLocation(i, "uGlitchTexture");
    this.mUniVerColor = GLES20.glGetUniformLocation(i, "nVerticalColor");
    this.mUniDisParamV = GLES20.glGetUniformLocation(i, "vDisParamV");
    this.mUniHorColor = GLES20.glGetUniformLocation(i, "nHorizontalColor");
    this.mUniDisParamH = GLES20.glGetUniformLocation(i, "vDisParamH");
    this.mUniInputTexture = GLES20.glGetUniformLocation(i, "inputImageTexture");
    this.mUniDstColor = GLES20.glGetUniformLocation(i, "dstColor");
  }
  
  public void onOutputSizeChanged(int paramInt1, int paramInt2)
  {
    super.onOutputSizeChanged(paramInt1, paramInt2);
    if (paramInt1 != 0)
    {
      if (paramInt2 == 0) {
        return;
      }
      RectF localRectF = this.mGlitchAraea;
      if (localRectF == null) {
        return;
      }
      int i = (int)Math.abs(localRectF.width() * paramInt1);
      int j = (int)Math.abs(this.mGlitchAraea.height() * paramInt2);
      try
      {
        if ((this.mVertexData != null) && (this.mVertexData.limit() == i * 2 * j)) {
          return;
        }
        this.mVertexData = null;
        new Thread(new VertexDataJob(this.mGlitchAraea, i, j, paramInt1, paramInt2, this)).start();
        return;
      }
      finally {}
    }
  }
  
  public void onResult(FloatBuffer paramFloatBuffer)
  {
    try
    {
      this.mVertexData = paramFloatBuffer;
      return;
    }
    finally {}
  }
  
  public boolean process(int paramInt1, int paramInt2, boolean paramBoolean1, int paramInt3, boolean paramBoolean2)
  {
    if (paramInt2 >= 0)
    {
      if (paramInt1 < 0) {
        return false;
      }
      int i = getProgram();
      if (i <= 0) {
        return false;
      }
      GLES20.glUseProgram(i);
      if (this.mArrayBuffers == null)
      {
        try
        {
          if (this.mVertexData == null) {
            return false;
          }
          this.mArrayBuffers = new int[2];
          GLES20.glGenBuffers(2, this.mArrayBuffers, 0);
          GLES20.glBindBuffer(34962, this.mArrayBuffers[0]);
          this.mVertexData.rewind();
          GLES20.glBufferData(34962, this.mVertexData.limit() * 4, this.mVertexData, 35044);
          GLES20.glEnableVertexAttribArray(this.mAttrPosition);
          GLES20.glBindBuffer(34962, this.mArrayBuffers[0]);
          GLES20.glVertexAttribPointer(this.mAttrPosition, 2, 5126, false, 0, 0);
          GLES20.glBindBuffer(34962, this.mArrayBuffers[1]);
          mTextureData.rewind();
          GLES20.glBufferData(34962, mTextureData.limit() * 4, mTextureData, 35044);
          GLES20.glEnableVertexAttribArray(this.mAttrTextureCoord);
          GLES20.glBindBuffer(34962, this.mArrayBuffers[1]);
          GLES20.glVertexAttribPointer(this.mAttrTextureCoord, 2, 5126, false, 0, 0);
        }
        finally {}
      }
      else
      {
        GLES20.glEnableVertexAttribArray(this.mAttrPosition);
        GLES20.glBindBuffer(34962, this.mArrayBuffers[0]);
        GLES20.glVertexAttribPointer(this.mAttrPosition, 2, 5126, false, 0, 0);
        GLES20.glEnableVertexAttribArray(this.mAttrTextureCoord);
        GLES20.glBindBuffer(34962, this.mArrayBuffers[1]);
        GLES20.glVertexAttribPointer(this.mAttrTextureCoord, 2, 5126, false, 0, 0);
      }
      GLES20.glUniform1i(this.mUniHorColor, this.mDisColorH);
      GLES20.glUniform2f(this.mUniDisParamH, this.mMaxDisH, this.mShiftH);
      GLES20.glUniform1i(this.mUniVerColor, this.mDisColorV);
      GLES20.glUniform2f(this.mUniDisParamV, this.mMaxDisV, this.mShiftY);
      GLES20.glActiveTexture(33984);
      GLES20.glBindTexture(this.mTextureType, paramInt2);
      GLES20.glUniform1i(this.mUniInputTexture, 0);
      GLES20.glActiveTexture(33985);
      GLES20.glBindTexture(this.mTextureType, paramInt1);
      GLES20.glUniform1i(this.mUniGlitchTexture, 1);
      paramInt1 = this.mUniDstColor;
      float f;
      if (paramBoolean1) {
        f = 1.0F;
      } else {
        f = 0.0F;
      }
      GLES20.glUniform4f(paramInt1, f, LayerRenderBase.getRed(paramInt3), LayerRenderBase.getGreen(paramInt3), LayerRenderBase.getBlue(paramInt3));
      if (paramBoolean2)
      {
        GLES20.glEnable(3042);
        GLES20.glBlendFunc(770, 771);
      }
      GLES20.glDrawArrays(0, 0, this.mVertexData.limit() / 2);
      GLES20.glDisableVertexAttribArray(this.mAttrPosition);
      GLES20.glDisableVertexAttribArray(this.mAttrTextureCoord);
      GLES20.glBindBuffer(34962, 0);
      GLES20.glActiveTexture(33984);
      GLES20.glBindTexture(this.mTextureType, 0);
      GLES20.glActiveTexture(33985);
      GLES20.glBindTexture(this.mTextureType, 0);
      if (paramBoolean2) {
        GLES20.glDisable(3042);
      }
      return true;
    }
    return false;
  }
  
  public void updateData(int paramInt1, float paramFloat1, float paramFloat2, int paramInt2, float paramFloat3, float paramFloat4)
  {
    this.mDisColorH = paramInt1;
    this.mDisColorV = paramInt2;
    this.mMaxDisH = paramFloat1;
    this.mMaxDisV = paramFloat3;
    this.mShiftH = paramFloat2;
    this.mShiftY = paramFloat4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.mtveffects.GlitchFilter
 * JD-Core Version:    0.7.0.1
 */