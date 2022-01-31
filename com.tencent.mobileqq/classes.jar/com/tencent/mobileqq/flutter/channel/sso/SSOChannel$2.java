package com.tencent.mobileqq.flutter.channel.sso;

import apzq;
import com.tencent.mobileqq.flutter.channel.model.ResponsePacket;
import com.tencent.qphone.base.util.QLog;
import io.flutter.plugin.common.MethodChannel.Result;
import java.util.Map;

public class SSOChannel$2
  implements Runnable
{
  public SSOChannel$2(apzq paramapzq, ResponsePacket paramResponsePacket, String paramString, MethodChannel.Result paramResult) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      if (this.jdField_a_of_type_ComTencentMobileqqFlutterChannelModelResponsePacket == null) {
        break label79;
      }
    }
    label79:
    for (boolean bool = this.jdField_a_of_type_ComTencentMobileqqFlutterChannelModelResponsePacket.isSuc.booleanValue();; bool = false)
    {
      QLog.d("QFlutter.SSOChannel", 2, String.format("notifyResult, cmd: %s, isSuc: %s", new Object[] { this.jdField_a_of_type_JavaLangString, Boolean.valueOf(bool) }));
      if (this.jdField_a_of_type_IoFlutterPluginCommonMethodChannel$Result == null) {
        break;
      }
      Map localMap = ResponsePacket.toMap(this.jdField_a_of_type_ComTencentMobileqqFlutterChannelModelResponsePacket);
      this.jdField_a_of_type_IoFlutterPluginCommonMethodChannel$Result.success(localMap);
      return;
    }
    QLog.d("QFlutter.SSOChannel", 1, String.format("notifyResult, cmd: %s result method is null", new Object[] { this.jdField_a_of_type_JavaLangString }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.channel.sso.SSOChannel.2
 * JD-Core Version:    0.7.0.1
 */