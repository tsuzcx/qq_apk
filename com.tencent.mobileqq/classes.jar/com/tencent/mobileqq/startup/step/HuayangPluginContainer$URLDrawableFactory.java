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
  
  protected ProtocolDownloader doGetDownloader(String paramString, Object paramObject)
  {
    if ((("http".equals(paramString)) || ("https".equals(paramString))) && (this.a == null)) {
      this.a = new HttpDownloader();
    }
    return this.a;
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
    return BaseApplicationImpl.getContext().getResources().getDrawable(2130849738);
  }
  
  protected Drawable getDefualtFailedDrawable()
  {
    return BaseApplicationImpl.getContext().getResources().getDrawable(2130849738);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.HuayangPluginContainer.URLDrawableFactory
 * JD-Core Version:    0.7.0.1
 */