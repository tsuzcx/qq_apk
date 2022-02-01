package com.tencent.mobileqq.vip.diy.template;

import android.graphics.Bitmap;
import com.tencent.image.DownloadParams;
import com.tencent.image.DownloadParams.DecodeHandler;
import com.tencent.mobileqq.utils.QVipUtils;

public class ProfileTemplateBase$NinePatchDecoderHandler
  implements DownloadParams.DecodeHandler
{
  private int a;
  private int b;
  
  @Deprecated
  public ProfileTemplateBase$NinePatchDecoderHandler() {}
  
  public ProfileTemplateBase$NinePatchDecoderHandler(int paramInt1, int paramInt2)
  {
    this.a = paramInt1;
    this.b = paramInt2;
  }
  
  @Deprecated
  public void a(int paramInt1, int paramInt2)
  {
    this.a = paramInt1;
    this.b = paramInt2;
  }
  
  public Bitmap run(DownloadParams paramDownloadParams, Bitmap paramBitmap)
  {
    return QVipUtils.a(paramBitmap, this.a, this.b);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("NinePatchDecoderHandler{reqW=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", reqH=");
    localStringBuilder.append(this.b);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vip.diy.template.ProfileTemplateBase.NinePatchDecoderHandler
 * JD-Core Version:    0.7.0.1
 */