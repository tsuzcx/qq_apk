package com.tencent.mobileqq.now.focusanchor.util;

import android.graphics.drawable.Drawable;
import android.support.v4.app.FragmentActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.now.netchannel.websso.UserInfoMgr;
import mqq.app.Constants.PropertiesKey;

public class QQDataUtil
{
  public static FaceDrawable a(FragmentActivity paramFragmentActivity)
  {
    String str = UserInfoMgr.a();
    Drawable localDrawable = FaceDrawable.getDefaultDrawable(1, 3);
    return FaceDrawable.getFaceDrawable(paramFragmentActivity.app, 1, str, 3, localDrawable, localDrawable, null);
  }
  
  public static String a()
  {
    return BaseApplicationImpl.getApplication().getProperty(Constants.PropertiesKey.nickName.toString() + UserInfoMgr.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.now.focusanchor.util.QQDataUtil
 * JD-Core Version:    0.7.0.1
 */