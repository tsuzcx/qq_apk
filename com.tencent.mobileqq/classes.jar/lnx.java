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
import java.io.UnsupportedEncodingException;

@SuppressLint({"HandlerLeak"})
public class lnx
  extends Handler
{
  private final String jdField_a_of_type_JavaLangString = "VcControllerImpl_NativeEventHandler";
  
  public lnx(VcControllerImpl paramVcControllerImpl, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    int i;
    Object localObject;
    long l1;
    String str;
    label774:
    boolean bool;
    for (;;)
    {
      byte[] arrayOfByte;
      try
      {
        i = paramMessage.what;
        localObject = (lny)paramMessage.obj;
        if (localObject == null)
        {
          lek.e("VcControllerImpl_NativeEventHandler", "p is null");
          return;
        }
        paramMessage = ((lny)localObject).jdField_a_of_type_ArrayOfByte;
        l1 = ((lny)localObject).jdField_a_of_type_Long;
        str = mto.a(((lny)localObject).jdField_b_of_type_Long);
        arrayOfByte = ((lny)localObject).jdField_b_of_type_ArrayOfByte;
        if ((i != 16) && (i != 100) && (i != 117) && (i != 120) && (i != 124)) {
          lek.d("VcControllerImpl_NativeEventHandler", "handleMessage eventId: " + i + ", info: " + l1 + ", fromUin:" + str);
        }
        QLog.d("Native-Event", 1, "<-- Native_Event_Handler() eventId = " + i);
        switch (i)
        {
        case 71: 
        case 1: 
        case 2: 
        case 60: 
        case 61: 
          VcControllerImpl.access$300(this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl, i, (lny)localObject);
          break;
        case 3: 
          this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.d(str);
        }
      }
      finally {}
      continue;
      if (l1 > 1000L) {}
      int j;
      for (this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mfAudio2VideoFlag = true;; this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mfAudio2VideoFlag = false)
      {
        i = (int)((lny)localObject).c;
        j = (int)((lny)localObject).d;
        l1 = ((lny)localObject).e;
        if (((lny)localObject).jdField_b_of_type_ArrayOfByte == null) {
          break label2730;
        }
        paramMessage = new String(((lny)localObject).jdField_b_of_type_ArrayOfByte);
        this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.a(str, i, j, paramMessage, l1);
        break;
      }
      long l2 = ((lny)localObject).c;
      long l3 = ((lny)localObject).d;
      if (l1 == 1L) {
        this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.a(str, arrayOfByte, 1L);
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.b(l2, l3, l1);
        break;
        this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.a(str, paramMessage, 0L);
      }
      if (((lny)localObject).c != 1L) {
        break label2736;
      }
      bool = true;
      label898:
      i = (int)((lny)localObject).d;
      try
      {
        paramMessage = new String(((lny)localObject).jdField_a_of_type_ArrayOfByte, "utf-8");
        j = ((lny)localObject).jdField_a_of_type_Int;
        this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.a(bool, i, paramMessage, j);
      }
      catch (UnsupportedEncodingException paramMessage)
      {
        for (;;)
        {
          paramMessage.printStackTrace();
          paramMessage = "";
        }
      }
      l1 = ((lny)localObject).c;
      this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.c(l1, 0L, 100L);
      continue;
      i = (int)l1;
      paramMessage = new StringBuilder().append("EV_VOIP_CLOSED, Param0[").append(((lny)localObject).c).append("], Param1[").append(((lny)localObject).d).append("], Param2[").append(((lny)localObject).jdField_a_of_type_JavaLangString).append("], Param3[").append(((lny)localObject).jdField_a_of_type_Int).append("], Param4[").append(((lny)localObject).jdField_b_of_type_Int).append("], Param5[").append(((lny)localObject).e).append("], extraBuf[");
      if (((lny)localObject).jdField_b_of_type_ArrayOfByte == null) {
        break label2745;
      }
      bool = true;
      label1091:
      QLog.w("VcControllerImpl", 1, bool + "], reason[" + i + "]");
      switch (i)
      {
      case 13: 
        label1140:
        this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.a(str, i, ((lny)localObject).c);
        for (;;)
        {
          lkv.a(i, ((lny)localObject).c, ((lny)localObject).d, ((lny)localObject).jdField_a_of_type_JavaLangString);
          break;
          this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.i(str);
        }
        this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.a(str, 12, 0L);
        continue;
        this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.e(str);
        continue;
        this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.f(str);
        continue;
        this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.g(str);
        continue;
        this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.h(str);
        continue;
        this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.j(str);
        continue;
        this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.k(str);
        continue;
        this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.l(str);
        continue;
        this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.a(i - 19, str);
        continue;
        this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.a(str, true);
        continue;
        this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.a(str, false);
        continue;
        this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.m(str);
        continue;
        this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.n(str);
        continue;
        this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.o(str);
        continue;
        this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.p(str);
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
        this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.b(paramMessage, l1);
        continue;
        this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.t(str);
        continue;
        this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.b(str, (int)l1, ((lny)localObject).c, ((lny)localObject).jdField_a_of_type_ArrayOfByte);
        continue;
        this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.a(str, (int)l1, ((lny)localObject).c, ((lny)localObject).jdField_a_of_type_ArrayOfByte);
        continue;
        this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.b(str, paramMessage, l1);
        continue;
        this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.d(str, paramMessage, l1);
        continue;
        this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.c(str, paramMessage, l1);
        continue;
        switch ((int)((lny)localObject).c)
        {
        default: 
          label1724:
          QLog.i("VcControllerImpl", 1, "EV_VOIP_OTHER_TER_CHATING_STAUTS, extraParam0=" + ((lny)localObject).c);
          this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.a(str, ((lny)localObject).d, i);
          continue;
          i = (int)((lny)localObject).c;
          j = (int)((lny)localObject).d;
          l1 = ((lny)localObject).e;
          this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.a(str, i, j, l1);
          continue;
          this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.d(str, (int)l1);
          continue;
          i = (int)((lny)localObject).c;
          j = (int)((lny)localObject).d;
          l2 = ((lny)localObject).e;
          if (((lny)localObject).jdField_b_of_type_ArrayOfByte == null) {
            break label2766;
          }
          paramMessage = new String(((lny)localObject).jdField_b_of_type_ArrayOfByte);
          label1881:
          this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.a(str, (int)l1, i, j, paramMessage, l2);
          continue;
          this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.c(str, (int)l1);
          continue;
          this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.u(str);
          this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.h(2048);
          continue;
          this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.h(3);
          continue;
          this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.h(4);
          continue;
          i = (int)((lny)localObject).jdField_a_of_type_Long;
          if (QLog.isColorLevel()) {
            QLog.d("NativeEventHandler", 2, "SharpConfigPayload. version = " + i);
          }
          BaseApplicationImpl.getContext().sendBroadcast(new Intent("com.tencent.av.ui.ConfigInfoTips.ACTION_IS_GETTED_SHARP_CONFIG_PAYLOAD").putExtra("version", i));
          lyf.a().a("load", i);
          continue;
          this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.b(str, l1, paramMessage);
          continue;
          this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.onAudioData(paramMessage);
          continue;
          this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.b(str, (int)l1, ((lny)localObject).jdField_a_of_type_ArrayOfByte);
        }
        break;
      }
    }
    for (;;)
    {
      for (;;)
      {
        this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.a(str, (int)l1, paramMessage);
        break;
        this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.c((int)l1, new String(paramMessage));
        break;
        this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.d((int)l1, new String(paramMessage));
        break;
        this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.e(paramMessage);
        break;
        this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.q(new String(paramMessage));
        break;
        this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.s(new String(paramMessage));
        break;
        this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.r(new String(paramMessage));
        break;
        this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.a(str, new String(paramMessage));
        break;
        try
        {
          localObject = new AVFunChat.AVFunChatMessage();
          ((AVFunChat.AVFunChatMessage)localObject).mergeFrom(paramMessage);
          this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.a(str, (AVFunChat.AVFunChatMessage)localObject);
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
      this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.f(str, i);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("NativeEventHandler", 2, "EM_SDK_EVENT_ID_GROUND_GLASS_SWITCH. nSwitch = " + i + ", fromUin=" + str);
      break;
      i = (int)l1;
      this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.g(str, i);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("NativeEventHandler", 2, "EM_SDK_EVENT_ID_GROUND_GLASS_WAIT_TIME. nTime = " + i + ", fromUin=" + str);
      break;
      i = (int)l1;
      this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.f(i);
      break;
      QLog.d("NativeEventHandler", 1, "EM_SDK_EVENT_ID_CUSTOM_COMMAND: recv SDKCustomCommand from SDK, peerUin = " + str);
      this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.a(str, ((lny)localObject).c, ((lny)localObject).d, ((lny)localObject).jdField_b_of_type_Int);
      break;
      QLog.d("NativeEventHandler", 1, "NETWORK_CHECK: recv send network check request from SDK, peerUin = " + str);
      this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.H();
      break;
      azqs.b(null, "CliOper", "", "", "0X800A7A4", "0X800A7A4", 0, (int)((lny)localObject).c, "", "", "", "");
      break;
      azqs.b(null, "CliOper", "", "", "0X800A7A5", "0X800A7A5", 0, (int)((lny)localObject).c, "", "", "", "");
      break;
      this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.g((int)((lny)localObject).c);
      break;
      break;
      label2730:
      paramMessage = "";
      break label774;
      label2736:
      bool = false;
      break label898;
      break label1140;
      label2745:
      bool = false;
      break label1091;
      i = 0;
      break label1724;
      i = 2;
      break label1724;
      i = 1;
      break label1724;
      label2766:
      paramMessage = "";
      break label1881;
      switch ((int)l1)
      {
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     lnx
 * JD-Core Version:    0.7.0.1
 */