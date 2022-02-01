package com.tencent.mobileqq.studyroom.shadow;

import android.content.Context;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.intervideo.PluginEnterManager;
import com.tencent.mobileqq.studyroom.StudyRoomManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.shadow.dynamic.host.DynamicPluginManager;
import com.tencent.shadow.dynamic.host.EnterCallback;

public class PluginManagerWrapper
  implements IVPluginManager
{
  private final DynamicPluginManager jdField_a_of_type_ComTencentShadowDynamicHostDynamicPluginManager;
  private final String jdField_a_of_type_JavaLangString = "shadow::PluginManagerWrapper";
  private final String b;
  
  public PluginManagerWrapper(String paramString, DynamicPluginManager paramDynamicPluginManager)
  {
    this.jdField_a_of_type_ComTencentShadowDynamicHostDynamicPluginManager = paramDynamicPluginManager;
    this.b = paramString;
  }
  
  public void enter(Context paramContext, long paramLong, Bundle paramBundle, EnterCallback paramEnterCallback)
  {
    if (QLog.isColorLevel()) {
      QLog.i("shadow::PluginManagerWrapper", 2, "enter formId:" + paramLong + " enterCallback:" + paramEnterCallback);
    }
    PluginEnterManager.a().a(this.b, this.jdField_a_of_type_ComTencentShadowDynamicHostDynamicPluginManager);
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface))
    {
      localObject = (StudyRoomManager)((QQAppInterface)localObject).getManager(QQManagerFactory.STUDY_ROOM_MANAGER);
      if (localObject != null) {
        ((StudyRoomManager)localObject).a(this.jdField_a_of_type_ComTencentShadowDynamicHostDynamicPluginManager);
      }
    }
    this.jdField_a_of_type_ComTencentShadowDynamicHostDynamicPluginManager.enter(paramContext, paramLong, paramBundle, paramEnterCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.studyroom.shadow.PluginManagerWrapper
 * JD-Core Version:    0.7.0.1
 */