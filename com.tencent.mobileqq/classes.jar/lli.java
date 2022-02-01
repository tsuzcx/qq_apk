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
public class lli
  extends Handler
{
  private final String jdField_a_of_type_JavaLangString = "VcControllerImpl_NativeEventHandler";
  
  public lli(VcControllerImpl paramVcControllerImpl, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    int i;
    Object localObject;
    long l1;
    String str;
    for (;;)
    {
      byte[] arrayOfByte;
      try
      {
        i = paramMessage.what;
        localObject = (llj)paramMessage.obj;
        if (localObject == null)
        {
          lbj.e("VcControllerImpl_NativeEventHandler", "p is null");
          return;
        }
        paramMessage = ((llj)localObject).jdField_a_of_type_ArrayOfByte;
        l1 = ((llj)localObject).jdField_a_of_type_Long;
        str = mrs.a(((llj)localObject).jdField_b_of_type_Long);
        arrayOfByte = ((llj)localObject).jdField_b_of_type_ArrayOfByte;
        if ((i != 16) && (i != 100) && (i != 117) && (i != 120) && (i != 124)) {
          lbj.d("VcControllerImpl_NativeEventHandler", "handleMessage eventId: " + i + ", info: " + l1 + ", fromUin:" + str);
        }
        QLog.d("Native-Event", 1, "<-- Native_Event_Handler() eventId = " + i);
        switch (i)
        {
        case 71: 
        case 1: 
        case 2: 
        case 60: 
        case 61: 
          VcControllerImpl.access$300(this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl, i, (llj)localObject);
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
        i = (int)((llj)localObject).c;
        j = (int)((llj)localObject).d;
        l1 = ((llj)localObject).e;
        if (((llj)localObject).jdField_b_of_type_ArrayOfByte == null) {
          break label2750;
        }
        paramMessage = new String(((llj)localObject).jdField_b_of_type_ArrayOfByte);
        label778:
        this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.a(str, i, j, paramMessage, l1);
        if (!mrn.a()) {
          break;
        }
        mrn.a().a(this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl, null);
        break;
      }
      long l2 = ((llj)localObject).c;
      long l3 = ((llj)localObject).d;
      if (l1 == 1L) {
        this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.a(str, arrayOfByte, 1L);
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.b(l2, l3, l1);
        break;
        this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.a(str, paramMessage, 0L);
      }
      if (((llj)localObject).c != 1L) {
        break label2756;
      }
      label917:
      i = (int)((llj)localObject).d;
      try
      {
        paramMessage = new String(((llj)localObject).jdField_a_of_type_ArrayOfByte, "utf-8");
        j = ((llj)localObject).jdField_a_of_type_Int;
        this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.a(bool1, i, paramMessage, j);
      }
      catch (UnsupportedEncodingException paramMessage)
      {
        for (;;)
        {
          paramMessage.printStackTrace();
          paramMessage = "";
        }
      }
      l1 = ((llj)localObject).c;
      this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.c(l1, 0L, 100L);
      continue;
      i = (int)l1;
      paramMessage = new StringBuilder().append("EV_VOIP_CLOSED, Param0[").append(((llj)localObject).c).append("], Param1[").append(((llj)localObject).d).append("], Param2[").append(((llj)localObject).jdField_a_of_type_JavaLangString).append("], Param3[").append(((llj)localObject).jdField_a_of_type_Int).append("], Param4[").append(((llj)localObject).jdField_b_of_type_Int).append("], Param5[").append(((llj)localObject).e).append("], extraBuf[");
      if (((llj)localObject).jdField_b_of_type_ArrayOfByte == null) {
        break label2765;
      }
      bool1 = bool2;
      label1111:
      QLog.w("VcControllerImpl", 1, bool1 + "], reason[" + i + "]");
      switch (i)
      {
      case 13: 
        label1160:
        this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.a(str, i, ((llj)localObject).c);
        for (;;)
        {
          lia.a(i, ((llj)localObject).c, ((llj)localObject).d, ((llj)localObject).jdField_a_of_type_JavaLangString);
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
        this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.b(true);
        continue;
        this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.b(false);
        continue;
        if (AVReport.a().a) {
          AVReport.a().k = SystemClock.elapsedRealtime();
        }
        for (;;)
        {
          this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.c(true);
          break;
          AVReport.a().z = SystemClock.elapsedRealtime();
        }
        this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.b(paramMessage, l1);
        continue;
        this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.t(str);
        continue;
        this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.b(str, (int)l1, ((llj)localObject).c, ((llj)localObject).jdField_a_of_type_ArrayOfByte);
        continue;
        this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.a(str, (int)l1, ((llj)localObject).c, ((llj)localObject).jdField_a_of_type_ArrayOfByte);
        continue;
        this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.b(str, paramMessage, l1);
        continue;
        this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.d(str, paramMessage, l1);
        continue;
        this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.c(str, paramMessage, l1);
        continue;
        switch ((int)((llj)localObject).c)
        {
        default: 
          label1744:
          QLog.i("VcControllerImpl", 1, "EV_VOIP_OTHER_TER_CHATING_STAUTS, extraParam0=" + ((llj)localObject).c);
          this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.a(str, ((llj)localObject).d, i);
          continue;
          i = (int)((llj)localObject).c;
          j = (int)((llj)localObject).d;
          l1 = ((llj)localObject).e;
          this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.a(str, i, j, l1);
          continue;
          this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.d(str, (int)l1);
          continue;
          i = (int)((llj)localObject).c;
          j = (int)((llj)localObject).d;
          l2 = ((llj)localObject).e;
          if (((llj)localObject).jdField_b_of_type_ArrayOfByte == null) {
            break label2786;
          }
          paramMessage = new String(((llj)localObject).jdField_b_of_type_ArrayOfByte);
          label1901:
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
          i = (int)((llj)localObject).jdField_a_of_type_Long;
          if (QLog.isColorLevel()) {
            QLog.d("NativeEventHandler", 2, "SharpConfigPayload. version = " + i);
          }
          BaseApplicationImpl.getContext().sendBroadcast(new Intent("com.tencent.av.ui.ConfigInfoTips.ACTION_IS_GETTED_SHARP_CONFIG_PAYLOAD").putExtra("version", i));
          lwd.a().a("load", i);
          continue;
          this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.b(str, l1, paramMessage);
          continue;
          this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.onAudioData(paramMessage);
          continue;
          this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.b(str, (int)l1, ((llj)localObject).jdField_a_of_type_ArrayOfByte);
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
        this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.d(paramMessage);
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
      this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.a(str, ((llj)localObject).c, ((llj)localObject).d, ((llj)localObject).jdField_b_of_type_Int);
      break;
      QLog.d("NativeEventHandler", 1, "NETWORK_CHECK: recv send network check request from SDK, peerUin = " + str);
      this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.H();
      break;
      bdll.b(null, "CliOper", "", "", "0X800A7A4", "0X800A7A4", 0, (int)((llj)localObject).c, "", "", "", "");
      break;
      bdll.b(null, "CliOper", "", "", "0X800A7A5", "0X800A7A5", 0, (int)((llj)localObject).c, "", "", "", "");
      break;
      this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.g((int)((llj)localObject).c);
      break;
      break;
      label2750:
      paramMessage = "";
      break label778;
      label2756:
      bool1 = false;
      break label917;
      break label1160;
      label2765:
      bool1 = false;
      break label1111;
      i = 0;
      break label1744;
      i = 2;
      break label1744;
      i = 1;
      break label1744;
      label2786:
      paramMessage = "";
      break label1901;
      switch ((int)l1)
      {
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lli
 * JD-Core Version:    0.7.0.1
 */