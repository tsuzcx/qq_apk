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
public class llu
  extends Handler
{
  private final String jdField_a_of_type_JavaLangString = "VcControllerImpl_NativeEventHandler";
  
  public llu(VcControllerImpl paramVcControllerImpl, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    int i;
    Object localObject;
    long l1;
    String str;
    label763:
    boolean bool;
    for (;;)
    {
      byte[] arrayOfByte;
      try
      {
        i = paramMessage.what;
        localObject = (llv)paramMessage.obj;
        if (localObject == null)
        {
          lcg.e("VcControllerImpl_NativeEventHandler", "p is null");
          return;
        }
        paramMessage = ((llv)localObject).jdField_a_of_type_ArrayOfByte;
        l1 = ((llv)localObject).jdField_a_of_type_Long;
        str = mqu.a(((llv)localObject).jdField_b_of_type_Long);
        arrayOfByte = ((llv)localObject).jdField_b_of_type_ArrayOfByte;
        if ((i != 16) && (i != 100) && (i != 117) && (i != 120) && (i != 124)) {
          lcg.d("VcControllerImpl_NativeEventHandler", "handleMessage eventId: " + i + ", info: " + l1 + ", fromUin:" + str);
        }
        QLog.d("Native-Event", 1, "<-- Native_Event_Handler() eventId = " + i);
        switch (i)
        {
        case 71: 
        case 1: 
        case 2: 
        case 60: 
        case 61: 
          VcControllerImpl.access$300(this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl, i, (llv)localObject);
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
        i = (int)((llv)localObject).c;
        j = (int)((llv)localObject).d;
        if (((llv)localObject).jdField_b_of_type_ArrayOfByte == null) {
          break label2626;
        }
        paramMessage = new String(((llv)localObject).jdField_b_of_type_ArrayOfByte);
        this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.a(str, i, j, paramMessage);
        break;
      }
      long l2 = ((llv)localObject).c;
      long l3 = ((llv)localObject).d;
      if (l1 == 1L) {
        this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.a(str, arrayOfByte, 1L);
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.b(l2, l3, l1);
        break;
        this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.a(str, paramMessage, 0L);
      }
      if (((llv)localObject).c != 1L) {
        break label2632;
      }
      bool = true;
      label885:
      i = (int)((llv)localObject).d;
      try
      {
        paramMessage = new String(((llv)localObject).jdField_a_of_type_ArrayOfByte, "utf-8");
        j = ((llv)localObject).jdField_a_of_type_Int;
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
      l1 = ((llv)localObject).c;
      this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.c(l1, 0L, 100L);
      continue;
      i = (int)l1;
      paramMessage = new StringBuilder().append("EV_VOIP_CLOSED, Param0[").append(((llv)localObject).c).append("], Param1[").append(((llv)localObject).d).append("], Param2[").append(((llv)localObject).jdField_a_of_type_JavaLangString).append("], Param3[").append(((llv)localObject).jdField_a_of_type_Int).append("], Param4[").append(((llv)localObject).jdField_b_of_type_Int).append("], extraBuf[");
      if (((llv)localObject).jdField_b_of_type_ArrayOfByte == null) {
        break label2641;
      }
      bool = true;
      label1065:
      QLog.w("VcControllerImpl", 1, bool + "], reason[" + i + "]");
      switch (i)
      {
      case 13: 
        label1112:
        this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.a(str, i, ((llv)localObject).c);
        for (;;)
        {
          lis.a(i, ((llv)localObject).c, ((llv)localObject).d, ((llv)localObject).jdField_a_of_type_JavaLangString);
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
        this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.b(str, (int)l1, ((llv)localObject).c, ((llv)localObject).jdField_a_of_type_ArrayOfByte);
        continue;
        this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.a(str, (int)l1, ((llv)localObject).c, ((llv)localObject).jdField_a_of_type_ArrayOfByte);
        continue;
        this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.b(str, paramMessage, l1);
        continue;
        this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.c(str, paramMessage, l1);
        continue;
        switch ((int)((llv)localObject).c)
        {
        default: 
          label1676:
          QLog.i("VcControllerImpl", 1, "EV_VOIP_OTHER_TER_CHATING_STAUTS, extraParam0=" + ((llv)localObject).c);
          this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.a(str, ((llv)localObject).d, i);
          continue;
          i = (int)((llv)localObject).c;
          j = (int)((llv)localObject).d;
          this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.a(str, i, j);
          continue;
          this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.e(str, (int)l1);
          continue;
          this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.c(str, (int)l1);
          continue;
          this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.d(str, (int)l1);
          continue;
          this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.u(str);
          this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.h(2048);
          continue;
          this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.h(3);
          continue;
          this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.h(4);
          continue;
          i = (int)((llv)localObject).jdField_a_of_type_Long;
          if (QLog.isColorLevel()) {
            QLog.d("NativeEventHandler", 2, "SharpConfigPayload. version = " + i);
          }
          BaseApplicationImpl.getContext().sendBroadcast(new Intent("com.tencent.av.ui.ConfigInfoTips.ACTION_IS_GETTED_SHARP_CONFIG_PAYLOAD").putExtra("version", i));
          lvy.a().a("load", i);
          continue;
          this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.b(str, l1, paramMessage);
          continue;
          this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.onAudioData(paramMessage);
          continue;
          this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.b(str, (int)l1, ((llv)localObject).jdField_a_of_type_ArrayOfByte);
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
      this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.g(str, i);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("NativeEventHandler", 2, "EM_SDK_EVENT_ID_GROUND_GLASS_SWITCH. nSwitch = " + i + ", fromUin=" + str);
      break;
      i = (int)l1;
      this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.h(str, i);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("NativeEventHandler", 2, "EM_SDK_EVENT_ID_GROUND_GLASS_WAIT_TIME. nTime = " + i + ", fromUin=" + str);
      break;
      i = (int)l1;
      this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.f(i);
      break;
      QLog.d("NativeEventHandler", 1, "EM_SDK_EVENT_ID_CUSTOM_COMMAND: recv SDKCustomCommand from SDK, peerUin = " + str);
      this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.a(str, ((llv)localObject).c, ((llv)localObject).d, ((llv)localObject).jdField_b_of_type_Int);
      break;
      QLog.d("NativeEventHandler", 1, "NETWORK_CHECK: recv send network check request from SDK, peerUin = " + str);
      this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.H();
      break;
      axqy.b(null, "CliOper", "", "", "0X800A7A4", "0X800A7A4", 0, (int)((llv)localObject).c, "", "", "", "");
      break;
      axqy.b(null, "CliOper", "", "", "0X800A7A5", "0X800A7A5", 0, (int)((llv)localObject).c, "", "", "", "");
      break;
      this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.g((int)((llv)localObject).c);
      break;
      break;
      label2626:
      paramMessage = "";
      break label763;
      label2632:
      bool = false;
      break label885;
      break label1112;
      label2641:
      bool = false;
      break label1065;
      i = 0;
      break label1676;
      i = 2;
      break label1676;
      i = 1;
      break label1676;
      switch ((int)l1)
      {
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     llu
 * JD-Core Version:    0.7.0.1
 */