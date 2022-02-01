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
    if (!TextUtils.equals(paramMiniAppEvent.jdField_a_of_type_JavaLangString, "QGameApp")) {
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("receive event:");
      ((StringBuilder)localObject).append(paramMiniAppEvent.toString());
      QLog.d("QGameApp", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = (String)paramMiniAppEvent.jdField_a_of_type_ArrayOfJavaLangObject[0];
    if (paramMiniAppEvent.jdField_a_of_type_Int != 5) {
      return;
    }
    if (TextUtils.equals((CharSequence)localObject, "ak:3214"))
    {
      if (paramMiniAppEvent.jdField_a_of_type_Boolean)
      {
        localObject = (String)paramMiniAppEvent.jdField_a_of_type_ArrayOfJavaLangObject[3];
        if (TextUtils.isEmpty((CharSequence)localObject))
        {
          QGameApp.a(paramQGameApp, 1002);
          return;
        }
        int i = ((Integer)paramMiniAppEvent.jdField_a_of_type_ArrayOfJavaLangObject[2]).intValue();
        if (i != 1)
        {
          if (i != 2)
          {
            if (i != 3) {
              return;
            }
            QGameApp.a(paramQGameApp, false, (String)localObject);
            return;
          }
          QGameApp.jdField_a_of_type_Boolean = false;
          return;
        }
        QGameApp.a(paramQGameApp, true, (String)localObject);
        return;
      }
      QGameApp.a(paramQGameApp, 1002);
    }
  }
  
  public Class acceptEventClass()
  {
    return MiniAppEvent.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qg.qq.QGameApp.QGameLibsDownloadReceiver
 * JD-Core Version:    0.7.0.1
 */