package com.tencent.mobileqq.notification.modularize;

import android.app.Notification;
import android.app.PendingIntent;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.notification.modularize.business.JumpSchemeFactory;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.nio.charset.Charset;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.s2c.msgtype0x210.submsgtype0x135.ModulePushPb.Content;
import tencent.im.s2c.msgtype0x210.submsgtype0x135.ModulePushPb.Forward;
import tencent.im.s2c.msgtype0x210.submsgtype0x135.ModulePushPb.Image;
import tencent.im.s2c.msgtype0x210.submsgtype0x135.ModulePushPb.MsgBody;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/notification/modularize/OnlineModulePushReceiver;", "", "app", "Lcom/tencent/mobileqq/app/QQAppInterface;", "(Lcom/tencent/mobileqq/app/QQAppInterface;)V", "convertPacket", "Lcom/tencent/mobileqq/notification/modularize/PushComponent;", "msgBody", "Ltencent/im/s2c/msgtype0x210/submsgtype0x135/ModulePushPb$MsgBody;", "createSystemNotification", "", "pushComponent", "notification", "Landroid/app/Notification;", "handleMsgBytes", "vProtobuf", "", "onPushReceived", "parseBytesExtData", "extData", "Lcom/tencent/mobileqq/pb/ByteStringMicro;", "revokePush", "sendPush", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class OnlineModulePushReceiver
{
  private final QQAppInterface a;
  
  public OnlineModulePushReceiver(@NotNull QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
  }
  
  private final void a(PushComponent paramPushComponent, Notification paramNotification)
  {
    QQNotificationManager.getInstance().notify("OnlineModulePushReceiver", paramPushComponent.jdField_d_of_type_Int, paramNotification);
    this.a.vibratorAndAudio();
    ((Map)OnlineModulePushReceiverKt.a()).put(Integer.valueOf(paramPushComponent.jdField_d_of_type_Int), Integer.valueOf(paramPushComponent.jdField_a_of_type_Int));
    ReportController.b(null, "dc00898", "", "", "0X800AE73", "0X800AE73", paramPushComponent.jdField_a_of_type_Int, 0, String.valueOf(paramPushComponent.jdField_b_of_type_Int), String.valueOf(paramPushComponent.jdField_c_of_type_Int), "", "");
    paramNotification = PushUtil.a;
    String str = this.a.getCurrentUin();
    Intrinsics.checkExpressionValueIsNotNull(str, "app.currentUin");
    paramNotification.a(str, 117, String.valueOf(paramPushComponent.jdField_c_of_type_Int), paramPushComponent.e);
  }
  
  private final void a(PushComponent paramPushComponent, ByteStringMicro paramByteStringMicro)
  {
    Object localObject;
    Charset localCharset;
    try
    {
      paramByteStringMicro = paramByteStringMicro.toByteArray();
      Intrinsics.checkExpressionValueIsNotNull(paramByteStringMicro, "extData.toByteArray()");
      localObject = new JSONObject(new String(paramByteStringMicro, Charsets.UTF_8));
      paramByteStringMicro = ((JSONObject)localObject).getString("tianshu_ext");
      localObject = ((JSONObject)localObject).getString("trigger_info");
      Intrinsics.checkExpressionValueIsNotNull(paramByteStringMicro, "tianShuExt");
      localCharset = Charsets.UTF_8;
      if (paramByteStringMicro == null) {
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
      }
    }
    catch (JSONException paramPushComponent)
    {
      QLog.e("OnlineModulePushReceiver", 1, paramPushComponent.getMessage());
      return;
    }
    paramByteStringMicro = paramByteStringMicro.getBytes(localCharset);
    Intrinsics.checkExpressionValueIsNotNull(paramByteStringMicro, "(this as java.lang.String).getBytes(charset)");
    paramPushComponent.jdField_a_of_type_ArrayOfByte = paramByteStringMicro;
    Intrinsics.checkExpressionValueIsNotNull(localObject, "triggerInfo");
    paramPushComponent.e = ((String)localObject);
  }
  
  private final void b(PushComponent paramPushComponent)
  {
    Object localObject = JumpSchemeFactory.a.a(paramPushComponent).b(paramPushComponent);
    localObject = NotificationBuilder.a.a((PendingIntent)localObject, paramPushComponent);
    boolean bool = OnlineModulePushReceiverKt.a(this.a);
    if (OnlineModulePushReceiverKt.b(this.a)) {
      if (QLog.isColorLevel()) {
        QLog.d("OnlineModulePushReceiver", 2, "sendPush: called. push need shield");
      }
    }
    do
    {
      return;
      if ((paramPushComponent.jdField_d_of_type_Boolean) && (paramPushComponent.jdField_c_of_type_Boolean))
      {
        a(paramPushComponent, (Notification)localObject);
        return;
      }
      if ((paramPushComponent.jdField_d_of_type_Boolean) && (bool))
      {
        a(paramPushComponent, (Notification)localObject);
        return;
      }
      if ((paramPushComponent.jdField_c_of_type_Boolean) && (!bool))
      {
        a(paramPushComponent, (Notification)localObject);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("OnlineModulePushReceiver", 2, new Object[] { "sendPush: called. ", "no need send push. isBackground: " + bool });
  }
  
  private final void c(PushComponent paramPushComponent)
  {
    QQNotificationManager.getInstance().cancel("OnlineModulePushReceiver", paramPushComponent.jdField_d_of_type_Int);
  }
  
  @NotNull
  public final PushComponent a(@NotNull ModulePushPb.MsgBody paramMsgBody)
  {
    boolean bool2 = false;
    Intrinsics.checkParameterIsNotNull(paramMsgBody, "msgBody");
    PushComponent localPushComponent = new PushComponent();
    Object localObject = paramMsgBody.msg_content.str_title.get();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "msgBody.msg_content.str_title.get()");
    localPushComponent.jdField_a_of_type_JavaLangString = ((String)localObject);
    localObject = paramMsgBody.msg_content.msg_image.str_url.get();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "msgBody.msg_content.msg_image.str_url.get()");
    localPushComponent.jdField_b_of_type_JavaLangString = ((String)localObject);
    localObject = paramMsgBody.msg_content.str_desc.get();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "msgBody.msg_content.str_desc.get()");
    localPushComponent.jdField_c_of_type_JavaLangString = ((String)localObject);
    localObject = paramMsgBody.msg_content.msg_forward.str_url.get();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "msgBody.msg_content.msg_forward.str_url.get()");
    localPushComponent.jdField_d_of_type_JavaLangString = ((String)localObject);
    label218:
    int i;
    if (paramMsgBody.msg_content.msg_forward.uint32_type.get() == 0)
    {
      bool1 = true;
      localPushComponent.jdField_a_of_type_Boolean = bool1;
      localPushComponent.jdField_a_of_type_Int = paramMsgBody.int32_service_id.get();
      localPushComponent.jdField_b_of_type_Int = paramMsgBody.int32_sub_service_id.get();
      localPushComponent.jdField_d_of_type_Int = paramMsgBody.int32_notify_id.get();
      localPushComponent.jdField_c_of_type_Int = paramMsgBody.int32_push_id.get();
      if (paramMsgBody.int32_recall_flag.get() != 1) {
        break label333;
      }
      bool1 = true;
      localPushComponent.jdField_b_of_type_Boolean = bool1;
      i = paramMsgBody.int32_type.get();
      if ((i != 1) && (i != 2)) {
        break label338;
      }
    }
    label333:
    label338:
    for (boolean bool1 = true;; bool1 = false)
    {
      localPushComponent.jdField_c_of_type_Boolean = bool1;
      if (i != 0)
      {
        bool1 = bool2;
        if (i != 2) {}
      }
      else
      {
        bool1 = true;
      }
      localPushComponent.jdField_d_of_type_Boolean = bool1;
      localObject = paramMsgBody.msg_content.bytes_ext_data.get().toByteArray();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "msgBody.msg_content.byte…_data.get().toByteArray()");
      localPushComponent.jdField_a_of_type_ArrayOfByte = ((byte[])localObject);
      paramMsgBody = paramMsgBody.msg_content.bytes_ext_data.get();
      Intrinsics.checkExpressionValueIsNotNull(paramMsgBody, "msgBody.msg_content.bytes_ext_data.get()");
      a(localPushComponent, paramMsgBody);
      return localPushComponent;
      bool1 = false;
      break;
      bool1 = false;
      break label218;
    }
  }
  
  public final void a(@NotNull PushComponent paramPushComponent)
  {
    Intrinsics.checkParameterIsNotNull(paramPushComponent, "pushComponent");
    if (QLog.isColorLevel()) {
      QLog.d("OnlineModulePushReceiver", 2, new Object[] { "onPushReceived: called. ", "pushComponent: " + paramPushComponent });
    }
    if (!paramPushComponent.a())
    {
      QLog.d("OnlineModulePushReceiver", 1, new Object[] { "onPushReceived: called. ", "invalid notify id. pushComponent: " + paramPushComponent });
      return;
    }
    if (paramPushComponent.jdField_b_of_type_Boolean)
    {
      c(paramPushComponent);
      return;
    }
    OnlineModulePushReceiverKt.a((Function0)new OnlineModulePushReceiver.onPushReceived.1(this, paramPushComponent));
  }
  
  public final void a(@NotNull byte[] paramArrayOfByte)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "vProtobuf");
    ModulePushPb.MsgBody localMsgBody = new ModulePushPb.MsgBody();
    try
    {
      localMsgBody.mergeFrom(paramArrayOfByte);
      a(a(localMsgBody));
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("OnlineModulePushReceiver", 2, "handleMsgBytes: failed. ", (Throwable)paramArrayOfByte);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.notification.modularize.OnlineModulePushReceiver
 * JD-Core Version:    0.7.0.1
 */