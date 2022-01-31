import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.av.AVFunChat.AVFunChatMessage;
import com.tencent.av.core.VcControllerImpl;
import com.tencent.av.report.AVReport;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

@SuppressLint({"HandlerLeak"})
public class lbi
  extends Handler
{
  private final String jdField_a_of_type_JavaLangString = "VcControllerImpl_NativeEventHandler";
  
  public lbi(VcControllerImpl paramVcControllerImpl, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    boolean bool = true;
    int i;
    Object localObject1;
    Object localObject2;
    long l1;
    for (;;)
    {
      byte[] arrayOfByte;
      try
      {
        i = paramMessage.what;
        localObject1 = (lbj)paramMessage.obj;
        if (localObject1 == null)
        {
          krx.e("VcControllerImpl_NativeEventHandler", "p is null");
          return;
        }
        localObject2 = ((lbj)localObject1).jdField_a_of_type_ArrayOfByte;
        l1 = ((lbj)localObject1).jdField_a_of_type_Long;
        paramMessage = mfy.a(((lbj)localObject1).jdField_b_of_type_Long);
        arrayOfByte = ((lbj)localObject1).jdField_b_of_type_ArrayOfByte;
        if ((i != 16) && (i != 100) && (i != 117) && (i != 120)) {
          krx.d("VcControllerImpl_NativeEventHandler", "handleMessage eventId: " + i + ", info: " + l1 + ", fromUin:" + paramMessage);
        }
        QLog.d("Native-Event", 1, "<-- Native_Event_Handler() eventId = " + i);
        switch (i)
        {
        case 71: 
        case 1: 
        case 2: 
        case 60: 
        case 61: 
          VcControllerImpl.access$000(this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl, i, (lbj)localObject1);
          break;
        case 3: 
          this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.d(paramMessage);
        }
      }
      finally {}
      continue;
      if (l1 > 1000L) {}
      for (this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mfAudio2VideoFlag = true;; this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mfAudio2VideoFlag = false)
      {
        this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.e(paramMessage);
        break;
      }
      long l2 = ((lbj)localObject1).c;
      long l3 = ((lbj)localObject1).d;
      if (l1 == 1L) {
        this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.a(paramMessage, arrayOfByte, 1L);
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.b(l2, l3, l1);
        break;
        this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.a(paramMessage, (byte[])localObject2, 0L);
      }
      this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.b(((lbj)localObject1).c, ((lbj)localObject1).d, ((lbj)localObject1).jdField_a_of_type_ArrayOfByte);
      continue;
      i = (int)l1;
      localObject2 = new StringBuilder().append("EV_VOIP_CLOSED, Param0[").append(((lbj)localObject1).c).append("], Param1[").append(((lbj)localObject1).d).append("], Param2[").append(((lbj)localObject1).jdField_a_of_type_JavaLangString).append("], Param3[").append(((lbj)localObject1).jdField_a_of_type_Int).append("], Param4[").append(((lbj)localObject1).jdField_b_of_type_Int).append("], extraBuf[");
      if (((lbj)localObject1).jdField_b_of_type_ArrayOfByte == null) {
        break;
      }
      label936:
      QLog.w("VcControllerImpl", 1, bool + "], reason[" + i + "]");
      switch (i)
      {
      case 13: 
        label984:
        this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.a(paramMessage, i, ((lbj)localObject1).c);
        for (;;)
        {
          kyh.a(i, ((lbj)localObject1).c, ((lbj)localObject1).d, ((lbj)localObject1).jdField_a_of_type_JavaLangString);
          break;
          this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.j(paramMessage);
        }
        this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.a(paramMessage, 12, 0L);
        continue;
        this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.f(paramMessage);
        continue;
        this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.g(paramMessage);
        continue;
        this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.h(paramMessage);
        continue;
        this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.i(paramMessage);
        continue;
        this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.k(paramMessage);
        continue;
        this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.m(paramMessage);
        continue;
        this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.n(paramMessage);
        continue;
        this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.a(i - 19, paramMessage);
        continue;
        this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.a(paramMessage, true);
        continue;
        this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.a(paramMessage, false);
        continue;
        this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.o(paramMessage);
        continue;
        this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.p(paramMessage);
        continue;
        this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.q(paramMessage);
        continue;
        this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.r(paramMessage);
        continue;
        this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.c(true);
        continue;
        this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.c(false);
        continue;
        if (AVReport.a().a) {
          AVReport.a().k = SystemClock.elapsedRealtime();
        }
        for (;;)
        {
          this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.d(true);
          break;
          AVReport.a().z = SystemClock.elapsedRealtime();
        }
        this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.b((byte[])localObject2, l1);
        continue;
        this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.v(paramMessage);
        continue;
        this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.b(paramMessage, (int)l1, ((lbj)localObject1).c, ((lbj)localObject1).jdField_a_of_type_ArrayOfByte);
        continue;
        this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.a(paramMessage, (int)l1, ((lbj)localObject1).c, ((lbj)localObject1).jdField_a_of_type_ArrayOfByte);
        continue;
        this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.b(paramMessage, (byte[])localObject2, l1);
        continue;
        this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.c(paramMessage, (byte[])localObject2, l1);
        continue;
        switch ((int)((lbj)localObject1).c)
        {
        default: 
          label1528:
          QLog.i("VcControllerImpl", 1, "EV_VOIP_OTHER_TER_CHATING_STAUTS, extraParam0=" + ((lbj)localObject1).c);
          this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.a(paramMessage, ((lbj)localObject1).d, i);
          continue;
          this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.l(paramMessage);
          continue;
          this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.e(paramMessage, (int)l1);
          continue;
          this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.c(paramMessage, (int)l1);
          continue;
          this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.d(paramMessage, (int)l1);
          continue;
          this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.w(paramMessage);
          this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.g(2048);
          continue;
          this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.g(3);
          continue;
          this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.g(4);
          continue;
          i = (int)((lbj)localObject1).jdField_a_of_type_Long;
          if (QLog.isColorLevel()) {
            QLog.d("NativeEventHandler", 2, "SharpConfigPayload. version = " + i);
          }
          BaseApplicationImpl.getContext().sendBroadcast(new Intent("com.tencent.av.ui.ConfigInfoTips.ACTION_IS_GETTED_SHARP_CONFIG_PAYLOAD").putExtra("version", i));
          lll.a().a("load", i);
          continue;
          this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.b(paramMessage, l1, (byte[])localObject2);
          continue;
          this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.onAudioData((byte[])localObject2);
          continue;
          this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.b(paramMessage, (int)l1, ((lbj)localObject1).jdField_a_of_type_ArrayOfByte);
        }
        break;
      }
    }
    for (;;)
    {
      for (;;)
      {
        this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.a(paramMessage, (int)l1, (byte[])localObject2);
        break;
        this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.c((int)l1, new String((byte[])localObject2));
        break;
        this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.d((int)l1, new String((byte[])localObject2));
        break;
        this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.e((byte[])localObject2);
        break;
        this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.s(new String((byte[])localObject2));
        break;
        this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.u(new String((byte[])localObject2));
        break;
        this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.t(new String((byte[])localObject2));
        break;
        this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.a(paramMessage, new String((byte[])localObject2));
        break;
        try
        {
          localObject1 = new AVFunChat.AVFunChatMessage();
          ((AVFunChat.AVFunChatMessage)localObject1).mergeFrom((byte[])localObject2);
          this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.a(paramMessage, (AVFunChat.AVFunChatMessage)localObject1);
        }
        catch (InvalidProtocolBufferMicroException paramMessage)
        {
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.i("VcControllerImpl", 2, "EM_AVFUNCHATTYPE_CreativeCop InvalidProtocolBufferMicroException fail", paramMessage);
        }
        catch (Throwable paramMessage) {}
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("VcControllerImpl", 2, "EM_AVFUNCHATTYPE_CreativeCop parse fail", paramMessage);
      break;
      i = (int)l1;
      this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.g(paramMessage, i);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("NativeEventHandler", 2, "EM_SDK_EVENT_ID_GROUND_GLASS_SWITCH. nSwitch = " + i + ", fromUin=" + paramMessage);
      break;
      i = (int)l1;
      this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.h(paramMessage, i);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("NativeEventHandler", 2, "EM_SDK_EVENT_ID_GROUND_GLASS_WAIT_TIME. nTime = " + i + ", fromUin=" + paramMessage);
      break;
      i = (int)l1;
      this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.f(i);
      break;
      QLog.d("NativeEventHandler", 1, "EM_SDK_EVENT_ID_CUSTOM_COMMAND: recv SDKCustomCommand from SDK, peerUin = " + paramMessage);
      this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.a(paramMessage, ((lbj)localObject1).c, ((lbj)localObject1).d, ((lbj)localObject1).jdField_b_of_type_Int);
      break;
      QLog.d("NativeEventHandler", 1, "NETWORK_CHECK: recv send network check request from SDK, peerUin = " + paramMessage);
      this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.H();
      break;
      awqx.b(null, "CliOper", "", "", "0X800A7A4", "0X800A7A4", 0, (int)((lbj)localObject1).c, "", "", "", "");
      break;
      awqx.b(null, "CliOper", "", "", "0X800A7A5", "0X800A7A5", 0, (int)((lbj)localObject1).c, "", "", "", "");
      break;
      break;
      break label984;
      bool = false;
      break label936;
      i = 0;
      break label1528;
      i = 2;
      break label1528;
      i = 1;
      break label1528;
      switch ((int)l1)
      {
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lbi
 * JD-Core Version:    0.7.0.1
 */