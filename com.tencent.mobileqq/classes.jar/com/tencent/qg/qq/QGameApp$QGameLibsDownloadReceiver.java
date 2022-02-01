package com.tencent.qg.qq;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.mobileqq.miniapp.MiniAppEvent;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class QGameApp$QGameLibsDownloadReceiver
  extends QQUIEventReceiver<QGameApp, MiniAppEvent>
{
  public QGameApp$QGameLibsDownloadReceiver(@NonNull QGameApp paramQGameApp)
  {
    super(paramQGameApp);
  }
  
  public void a(@NonNull QGameApp paramQGameApp, @NonNull MiniAppEvent paramMiniAppEvent)
  {
    if (!TextUtils.equals(paramMiniAppEvent.jdField_a_of_type_JavaLangString, "QGameApp")) {}
    String str;
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("QGameApp", 2, "receive event:" + paramMiniAppEvent.toString());
      }
      str = (String)paramMiniAppEvent.jdField_a_of_type_ArrayOfJavaLangObject[0];
      switch (paramMiniAppEvent.jdField_a_of_type_Int)
      {
      default: 
        return;
      }
    } while (!TextUtils.equals(str, "ak:3214"));
    if (paramMiniAppEvent.jdField_a_of_type_Boolean)
    {
      str = (String)paramMiniAppEvent.jdField_a_of_type_ArrayOfJavaLangObject[3];
      if (TextUtils.isEmpty(str))
      {
        QGameApp.a(paramQGameApp, 1002);
        return;
      }
      switch (((Integer)paramMiniAppEvent.jdField_a_of_type_ArrayOfJavaLangObject[2]).intValue())
      {
      default: 
        return;
      case 1: 
        QGameApp.a(paramQGameApp, true, str);
        return;
      case 2: 
        QGameApp.jdField_a_of_type_Boolean = false;
        return;
      }
      QGameApp.a(paramQGameApp, false, str);
      return;
    }
    QGameApp.a(paramQGameApp, 1002);
  }
  
  public Class acceptEventClass()
  {
    return MiniAppEvent.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qg.qq.QGameApp.QGameLibsDownloadReceiver
 * JD-Core Version:    0.7.0.1
 */