package com.tencent.mobileqq.startup.step;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.ApngSoLoader;
import com.tencent.image.ProtocolDownloader;
import com.tencent.image.URLDrawableParams;
import com.tencent.mobileqq.transfile.HttpDownloader;
import com.tencent.mobileqq.vas.VasApngIPCModule;
import com.tencent.qphone.base.util.BaseApplication;
import mqq.app.MobileQQ;

public class HuayangPluginContainer$URLDrawableFactory
  extends URLDrawableParams
{
  private ProtocolDownloader a;
  
  public HuayangPluginContainer$URLDrawableFactory(MobileQQ paramMobileQQ)
  {
    super(paramMobileQQ);
  }
  
  public ProtocolDownloader doGetDownloader(String paramString, Object paramObject)
  {
    if ((("http".equals(paramString)) || ("https".equals(paramString))) && (this.a == null)) {
      this.a = new HttpDownloader();
    }
    return this.a;
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
    return BaseApplicationImpl.getContext().getResources().getDrawable(2130848203);
  }
  
  public Drawable getDefualtFailedDrawable()
  {
    return BaseApplicationImpl.getContext().getResources().getDrawable(2130848203);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.HuayangPluginContainer.URLDrawableFactory
 * JD-Core Version:    0.7.0.1
 */