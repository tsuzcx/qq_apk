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
  protected ProtocolDownloader doGetDownloader(String paramString, Object paramObject)
  {
    if ((!"http".equals(paramString)) && (!"https".equals(paramString))) {
      return null;
    }
    int i = BaseApplicationImpl.sProcessId;
    boolean bool = true;
    if (i != 1) {
      bool = false;
    }
    return new HttpDownloader(bool, paramObject);
  }
  
  protected String doGetLocalFilePath(String paramString)
  {
    return null;
  }
  
  protected ApngSoLoader getApngSoLoader()
  {
    return VasApngIPCModule.a();
  }
  
  protected Drawable getDefaultLoadingDrawable()
  {
    return null;
  }
  
  protected Drawable getDefualtFailedDrawable()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelGalleryActivity.3
 * JD-Core Version:    0.7.0.1
 */