package com.tencent.mobileqq.now.focusanchor.util;

import android.graphics.drawable.Drawable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.now.netchannel.websso.UserInfoMgr;
import mqq.app.Constants.PropertiesKey;

public class QQDataUtil
{
  public static FaceDrawable a(BaseActivity paramBaseActivity)
  {
    String str = UserInfoMgr.a();
    Drawable localDrawable = FaceDrawable.getDefaultDrawable(1, 3);
    return FaceDrawable.getFaceDrawable(paramBaseActivity.app, 1, str, 3, localDrawable, localDrawable, null);
  }
  
  public static String a()
  {
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Constants.PropertiesKey.nickName.toString());
    localStringBuilder.append(UserInfoMgr.a());
    return localBaseApplicationImpl.getProperty(localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.now.focusanchor.util.QQDataUtil
 * JD-Core Version:    0.7.0.1
 */