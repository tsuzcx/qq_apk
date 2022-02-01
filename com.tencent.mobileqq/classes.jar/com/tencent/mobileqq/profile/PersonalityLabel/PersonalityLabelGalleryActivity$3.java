package com.tencent.mobileqq.profile.PersonalityLabel;

import android.graphics.drawable.Drawable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.ApngSoLoader;
import com.tencent.image.ProtocolDownloader;
import com.tencent.image.URLDrawableParams;
import com.tencent.mobileqq.transfile.HttpDownloader;
import com.tencent.mobileqq.vas.VasApngIPCModule;

class PersonalityLabelGalleryActivity$3
  extends URLDrawableParams
{
  public ProtocolDownloader doGetDownloader(String paramString, Object paramObject)
  {
    boolean bool = true;
    if (("http".equals(paramString)) || ("https".equals(paramString)))
    {
      if (BaseApplicationImpl.sProcessId == 1) {}
      for (;;)
      {
        return new HttpDownloader(bool, paramObject);
        bool = false;
      }
    }
    return null;
  }
  
  public String doGetLocalFilePath(String paramString)
  {
    return null;
  }
  
  public ApngSoLoader getApngSoLoader()
  {
    return VasApngIPCModule.a();
  }
  
  public Drawable getDefaultLoadingDrawable()
  {
    return null;
  }
  
  public Drawable getDefualtFailedDrawable()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelGalleryActivity.3
 * JD-Core Version:    0.7.0.1
 */