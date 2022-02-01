package com.tencent.mobileqq.profilecard.vas.component.background;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.mobileqq.config.business.qvip.QVipSDKConfig;
import com.tencent.mobileqq.config.business.qvip.QVipSDKProcessor;
import com.tencent.mobileqq.vas.gldrawable.GLDrawableWraper;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class VasProfileBackgroundComponent$UseEtcDrawable
{
  private File backgroundFile;
  private Drawable bgDrawable;
  private String dynamicFileDirectory;
  private boolean myResult;
  
  public VasProfileBackgroundComponent$UseEtcDrawable(VasProfileBackgroundComponent paramVasProfileBackgroundComponent, String paramString, File paramFile, Drawable paramDrawable)
  {
    this.dynamicFileDirectory = paramString;
    this.backgroundFile = paramFile;
    this.bgDrawable = paramDrawable;
  }
  
  public Drawable getBgDrawable()
  {
    return this.bgDrawable;
  }
  
  public UseEtcDrawable invoke()
  {
    if ((this.bgDrawable == null) && (TextUtils.isEmpty(this.dynamicFileDirectory)) && (QVipSDKProcessor.c().b()))
    {
      String str = this.backgroundFile.getAbsolutePath();
      if ((VasProfileBackgroundComponent.access$100(this.this$0) != null) && (TextUtils.equals(VasProfileBackgroundComponent.access$200(this.this$0), str)) && (GLDrawableWraper.a(VasProfileBackgroundComponent.access$100(this.this$0))))
      {
        if (QLog.isColorLevel()) {
          QLog.i(this.this$0.getTAG(), 2, "initProfileCardBackground: use old etc-drawable");
        }
        this.myResult = true;
        return this;
      }
      this.bgDrawable = GLDrawableWraper.a().a(this.backgroundFile, true);
      if (this.bgDrawable != null)
      {
        GLDrawableWraper.a().a(this.bgDrawable, true);
        VasProfileBackgroundComponent.access$202(this.this$0, str);
        if (QLog.isColorLevel()) {
          QLog.i(this.this$0.getTAG(), 2, "initProfileCardBackground use new etc-drawable");
        }
      }
    }
    this.myResult = false;
    return this;
  }
  
  boolean is()
  {
    return this.myResult;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.vas.component.background.VasProfileBackgroundComponent.UseEtcDrawable
 * JD-Core Version:    0.7.0.1
 */