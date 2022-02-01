package com.tencent.mobileqq.profilecard.vas.component.background;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.mobileqq.config.business.qvip.QVipSDKConfig;
import com.tencent.mobileqq.config.business.qvip.QVipSDKProcessor;
import com.tencent.mobileqq.profile.ProfileCardManager;
import com.tencent.mobileqq.vas.gldrawable.GLDrawableWraper;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class VasProfileBackgroundComponent$UserGldrawable
{
  private Drawable bgDrawable;
  private long bgId;
  private String dynamicFileDirectory;
  private boolean myResult;
  
  public VasProfileBackgroundComponent$UserGldrawable(VasProfileBackgroundComponent paramVasProfileBackgroundComponent, long paramLong, String paramString, Drawable paramDrawable)
  {
    this.bgId = paramLong;
    this.dynamicFileDirectory = paramString;
    this.bgDrawable = paramDrawable;
  }
  
  public Drawable getBgDrawable()
  {
    return this.bgDrawable;
  }
  
  public UserGldrawable invoke()
  {
    String str;
    boolean bool;
    if (QVipSDKProcessor.c().a())
    {
      str = ProfileCardManager.a(VasProfileBackgroundComponent.access$000(this.this$0), this.bgId) + "dynamicVideo.mp4";
      if (new File(str).exists()) {
        bool = true;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.this$0.getTAG(), 2, String.format("initProfileCardBackground videoPath=%s videoExists=%s", new Object[] { str, Boolean.valueOf(bool) }));
      }
      if (bool)
      {
        if ((VasProfileBackgroundComponent.access$100(this.this$0) != null) && (TextUtils.equals(VasProfileBackgroundComponent.access$200(this.this$0), str)) && (GLDrawableWraper.a(VasProfileBackgroundComponent.access$100(this.this$0))))
        {
          if (QLog.isColorLevel()) {
            QLog.i(this.this$0.getTAG(), 2, "initProfileCardBackground use old video-drawable");
          }
          this.myResult = true;
          return this;
          str = this.dynamicFileDirectory + "/video.mp4";
          if (!new File(str).exists()) {
            break label276;
          }
          bool = true;
          continue;
        }
        this.bgDrawable = GLDrawableWraper.a().a(new File(str), true);
        if (this.bgDrawable != null)
        {
          GLDrawableWraper.a().a(this.bgDrawable, true);
          VasProfileBackgroundComponent.access$202(this.this$0, str);
          if (QLog.isColorLevel()) {
            QLog.i(this.this$0.getTAG(), 2, "initProfileCardBackground use new video-drawable");
          }
        }
      }
      this.myResult = false;
      return this;
      label276:
      bool = false;
    }
  }
  
  boolean is()
  {
    return this.myResult;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.vas.component.background.VasProfileBackgroundComponent.UserGldrawable
 * JD-Core Version:    0.7.0.1
 */