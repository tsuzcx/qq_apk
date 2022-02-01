package com.tencent.mobileqq.profilecard.vas.component.background;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.android.gldrawable.api.GLDrawableApi;
import com.tencent.android.gldrawable.api.IFactoryStub;
import com.tencent.android.gldrawable.api.IGLDrawable;
import com.tencent.mobileqq.profile.ProfileCardManager;
import com.tencent.mobileqq.vas.config.business.qvip.QVipSDKConfig;
import com.tencent.mobileqq.vas.config.business.qvip.QVipSDKProcessor;
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
    if (QVipSDKProcessor.e().a())
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(ProfileCardManager.a(VasProfileBackgroundComponent.access$000(this.this$0), this.bgId));
      ((StringBuilder)localObject).append("dynamicVideo.mp4");
      localObject = ((StringBuilder)localObject).toString();
      if (new File((String)localObject).exists()) {}
      do
      {
        bool = true;
        break;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(this.dynamicFileDirectory);
        ((StringBuilder)localObject).append("/video.mp4");
        localObject = ((StringBuilder)localObject).toString();
      } while (new File((String)localObject).exists());
      boolean bool = false;
      QLog.d(this.this$0.getTAG(), 2, String.format("initProfileCardBackground videoPath=%s videoExists=%s", new Object[] { localObject, Boolean.valueOf(bool) }));
      if (bool)
      {
        if ((VasProfileBackgroundComponent.access$100(this.this$0) != null) && (TextUtils.equals(VasProfileBackgroundComponent.access$200(this.this$0), (CharSequence)localObject)) && ((VasProfileBackgroundComponent.access$100(this.this$0) instanceof IGLDrawable)))
        {
          QLog.i(this.this$0.getTAG(), 2, "initProfileCardBackground use old video-drawable");
          this.myResult = true;
          return this;
        }
        this.bgDrawable = GLDrawableApi.factory().fromFile(new File((String)localObject));
        Drawable localDrawable = this.bgDrawable;
        if (localDrawable != null)
        {
          if ((localDrawable instanceof IGLDrawable)) {
            ((IGLDrawable)localDrawable).setLockWH(true);
          }
          VasProfileBackgroundComponent.access$202(this.this$0, (String)localObject);
          QLog.i(this.this$0.getTAG(), 2, "initProfileCardBackground use new video-drawable");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.vas.component.background.VasProfileBackgroundComponent.UserGldrawable
 * JD-Core Version:    0.7.0.1
 */