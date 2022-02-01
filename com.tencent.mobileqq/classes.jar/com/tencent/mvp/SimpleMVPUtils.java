package com.tencent.mvp;

import com.tencent.qphone.base.util.QLog;

public class SimpleMVPUtils
{
  public static void a(IBasePresenterView paramIBasePresenterView, String paramString)
  {
    a(paramIBasePresenterView, paramString, null);
  }
  
  public static void a(IBasePresenterView paramIBasePresenterView, String paramString, Object paramObject)
  {
    if (paramIBasePresenterView != null)
    {
      IBasePresenter localIBasePresenter = paramIBasePresenterView.getPresenter();
      if ((localIBasePresenter != null) && ((localIBasePresenter instanceof ISimplePresenter)))
      {
        ((ISimplePresenter)localIBasePresenter).a(paramString, paramIBasePresenterView, paramObject);
        return;
      }
      paramString = new StringBuilder();
      paramString.append(paramIBasePresenterView.getClass().toString());
      paramString.append(" notifyPresentAction can not find presenter");
      QLog.e("SimpleMVPUtils", 2, paramString.toString());
      return;
    }
    throw new NullPointerException("notifyPresentAction on view null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mvp.SimpleMVPUtils
 * JD-Core Version:    0.7.0.1
 */