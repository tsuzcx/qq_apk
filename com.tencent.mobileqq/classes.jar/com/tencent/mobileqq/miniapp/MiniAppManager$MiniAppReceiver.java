package com.tencent.mobileqq.miniapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.miniapp.ui.MiniAppActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.Map;

class MiniAppManager$MiniAppReceiver
  extends QQUIEventReceiver<MiniAppManager, MiniAppEvent>
{
  public MiniAppManager$MiniAppReceiver(@NonNull MiniAppManager paramMiniAppManager)
  {
    super(paramMiniAppManager);
  }
  
  public void a(@NonNull MiniAppManager paramMiniAppManager, @NonNull MiniAppEvent paramMiniAppEvent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppManager", 2, "receive event:" + paramMiniAppEvent.toString());
    }
    switch (paramMiniAppEvent.jdField_a_of_type_Int)
    {
    }
    do
    {
      do
      {
        return;
      } while ((!"MiniAppLauncher".equals(paramMiniAppEvent.jdField_a_of_type_JavaLangString)) || (IDownloader.a((String)paramMiniAppEvent.jdField_a_of_type_ArrayOfJavaLangObject[0]) != 1) || (((Integer)paramMiniAppEvent.jdField_a_of_type_ArrayOfJavaLangObject[2]).intValue() == 2));
      String str = (String)paramMiniAppEvent.jdField_a_of_type_ArrayOfJavaLangObject[1];
      if (paramMiniAppEvent.jdField_a_of_type_Boolean)
      {
        QQToast.a(BaseApplicationImpl.getApplication(), HardCodeUtil.a(2131706837), 0).a();
        MiniAppInfo localMiniAppInfo = MiniAppManager.a(paramMiniAppManager).a(str, 2, 0, false);
        if (localMiniAppInfo != null)
        {
          localMiniAppInfo.jdField_a_of_type_AndroidOsBundle.putString("unzipped_path", (String)paramMiniAppEvent.jdField_a_of_type_ArrayOfJavaLangObject[3]);
          MiniAppManager.b(paramMiniAppManager, (IApp)MiniAppManager.a(paramMiniAppManager).get(localMiniAppInfo.h));
          return;
        }
      }
      paramMiniAppEvent = MiniAppInfo.a(str);
      MiniAppManager.a(paramMiniAppManager, paramMiniAppEvent[1], Integer.parseInt(paramMiniAppEvent[0]), 1003);
      return;
      MiniAppManager.a(paramMiniAppManager, (MiniAppActivity)paramMiniAppEvent.jdField_a_of_type_ArrayOfJavaLangObject[0], (String)paramMiniAppEvent.jdField_a_of_type_ArrayOfJavaLangObject[1], ((Integer)paramMiniAppEvent.jdField_a_of_type_ArrayOfJavaLangObject[2]).intValue(), (MiniAppOptions)paramMiniAppEvent.jdField_a_of_type_ArrayOfJavaLangObject[3]);
      return;
      MiniAppManager.a(paramMiniAppManager, MiniAppInfo.a((String)paramMiniAppEvent.jdField_a_of_type_ArrayOfJavaLangObject[0], ((Integer)paramMiniAppEvent.jdField_a_of_type_ArrayOfJavaLangObject[1]).intValue()));
      return;
    } while (paramMiniAppEvent.jdField_a_of_type_Boolean);
    MiniAppManager.a(paramMiniAppManager, paramMiniAppEvent.jdField_a_of_type_ComTencentMobileqqMiniappMiniAppInfo.jdField_a_of_type_JavaLangString, paramMiniAppEvent.jdField_a_of_type_ComTencentMobileqqMiniappMiniAppInfo.jdField_a_of_type_Int, 1004);
  }
  
  public Class acceptEventClass()
  {
    return MiniAppEvent.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.miniapp.MiniAppManager.MiniAppReceiver
 * JD-Core Version:    0.7.0.1
 */