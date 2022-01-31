package com.tencent.ttpic.filter;

import android.opengl.GLES20;
import android.text.TextUtils;
import com.tencent.aekit.openrender.AttributeParam;
import com.tencent.aekit.openrender.util.GlUtil;
import com.tencent.filter.BaseFilter;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class FrameBaseFilter
  extends BaseFilter
{
  public static final String FRAGMENT_SHADER = " precision highp float;\n \n varying vec2 textureCoordinate;\n \n uniform sampler2D inputImageTexture;\n \n void main()\n {\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n }";
  public static final String VERTEX_SHADER = "precision highp float;\nattribute vec4 position;\nattribute vec2 inputTextureCoordinate;\nvarying vec2 textureCoordinate;\nvoid main(void)\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate;\n}";
  private Map<String, AttributeParam> mAttrParams;
  private int mRenderMode;
  private int mSTextureHandle;
  
  public FrameBaseFilter()
  {
    super("precision highp float;\nattribute vec4 position;\nattribute vec2 inputTextureCoordinate;\nvarying vec2 textureCoordinate;\nvoid main(void)\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate;\n}", " precision highp float;\n \n varying vec2 textureCoordinate;\n \n uniform sampler2D inputImageTexture;\n \n void main()\n {\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n }");
    init();
  }
  
  public FrameBaseFilter(String paramString)
  {
    super("precision highp float;\nattribute vec4 position;\nattribute vec2 inputTextureCoordinate;\nvarying vec2 textureCoordinate;\nvoid main(void)\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate;\n}", paramString);
    init();
  }
  
  public FrameBaseFilter(String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
    init();
  }
  
  private void addAttribParam(String paramString, float[] paramArrayOfFloat)
  {
    addAttribParam(paramString, paramArrayOfFloat, false);
  }
  
  private void addAttribParam(String paramString, float[] paramArrayOfFloat, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    AttributeParam localAttributeParam2 = (AttributeParam)this.mAttrParams.get(paramString);
    AttributeParam localAttributeParam1 = localAttributeParam2;
    if (localAttributeParam2 == null)
    {
      localAttributeParam1 = new AttributeParam(paramString, paramArrayOfFloat, paramBoolean);
      this.mAttrParams.put(paramString, localAttributeParam1);
    }
    localAttributeParam1.setVertices(paramArrayOfFloat);
  }
  
  private void init()
  {
    this.mAttrParams = new HashMap();
    this.mSTextureHandle = -1;
  }
  
  public void OnDrawFrameGLSL()
  {
    super.OnDrawFrameGLSL();
    Iterator localIterator = this.mAttrParams.values().iterator();
    while (localIterator.hasNext()) {
      ((AttributeParam)localIterator.next()).setParams(getProgramIds());
    }
  }
  
  public void apply()
  {
    initAttribParams();
    super.apply();
    Iterator localIterator = this.mAttrParams.values().iterator();
    while (localIterator.hasNext()) {
      ((AttributeParam)localIterator.next()).initialParams(getProgramIds());
    }
    this.mSTextureHandle = GLES20.glGetUniformLocation(getProgramIds(), "inputImageTexture");
  }
  
  public void clearGLSLSelf()
  {
    super.clearGLSLSelf();
    Iterator localIterator = this.mAttrParams.values().iterator();
    while (localIterator.hasNext()) {
      ((AttributeParam)localIterator.next()).clear();
    }
  }
  
  public void initAttribParams()
  {
    setPositions(GlUtil.ORIGIN_POSITION_COORDS);
    setTexCords(GlUtil.ORIGIN_TEX_COORDS);
  }
  
  public boolean renderTexture(int paramInt1, int paramInt2, int paramInt3)
  {
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(3553, paramInt1);
    GLES20.glTexParameterf(3553, 10241, 9729.0F);
    GLES20.glTexParameterf(3553, 10240, 9729.0F);
    GLES20.glTexParameterf(3553, 10242, 33071.0F);
    GLES20.glTexParameterf(3553, 10243, 33071.0F);
    GLES20.glUniform1i(this.mSTextureHandle, 0);
    GLES20.glDrawArrays(6, 0, 4);
    if (this.mRenderMode == 0) {
      GLES20.glFinish();
    }
    while (this.mRenderMode != 1) {
      return true;
    }
    GLES20.glFlush();
    return true;
  }
  
  public boolean setPositions(float[] paramArrayOfFloat)
  {
    addAttribParam("position", paramArrayOfFloat);
    return true;
  }
  
  public boolean setRenderMode(int paramInt)
  {
    this.mRenderMode = paramInt;
    return true;
  }
  
  public boolean setTexCords(float[] paramArrayOfFloat)
  {
    addAttribParam("inputTextureCoordinate", paramArrayOfFloat);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.filter.FrameBaseFilter
 * JD-Core Version:    0.7.0.1
 */