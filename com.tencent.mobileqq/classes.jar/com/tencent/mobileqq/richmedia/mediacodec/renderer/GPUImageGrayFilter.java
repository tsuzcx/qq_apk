package com.tencent.mobileqq.richmedia.mediacodec.renderer;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;

public class GPUImageGrayFilter
  extends GPUDrawPartFilter
{
  private static String a = GlUtil.readTextFromRawResource(BaseApplicationImpl.getContext(), 2131230756);
  
  public GPUImageGrayFilter()
  {
    super("uniform mat4 uMVPMatrix;\nuniform mat4 uTextureMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uTextureMatrix * aTextureCoord).xy;\n}\n", a);
    this.mFilterType = 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.mediacodec.renderer.GPUImageGrayFilter
 * JD-Core Version:    0.7.0.1
 */