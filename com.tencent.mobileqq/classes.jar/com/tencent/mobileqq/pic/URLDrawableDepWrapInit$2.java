package com.tencent.mobileqq.pic;

import android.content.Context;
import com.tencent.commonsdk.soload.SoLoadUtilNew;
import com.tencent.image.api.ITool;
import com.tencent.qphone.base.util.BaseApplication;
import java.net.URLStreamHandlerFactory;

final class URLDrawableDepWrapInit$2
  extends ITool
{
  public Context getContext()
  {
    return BaseApplication.getContext();
  }
  
  public URLStreamHandlerFactory getFactory()
  {
    return null;
  }
  
  public boolean loadSoByName(Context paramContext, String paramString)
  {
    return SoLoadUtilNew.loadSoByName(BaseApplication.getContext(), paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.pic.URLDrawableDepWrapInit.2
 * JD-Core Version:    0.7.0.1
 */