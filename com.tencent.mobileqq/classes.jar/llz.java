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
public class llz
  extends Handler
{
  private final String jdField_a_of_type_JavaLangString = "VcControllerImpl_NativeEventHandler";
  
  public llz(VcControllerImpl paramVcControllerImpl, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    int i;
    Object localObject;
    long l1;
    String str;
    label759:
    boolean bool;
    for (;;)
    {
      byte[] arrayOfByte;
      try
      {
        i = paramMessage.what;
        localObject = (lma)paramMessage.obj;
        if (localObject == null)
        {
          lcl.e("VcControllerImpl_NativeEventHandler", "p is null");
          return;
        }
        paramMessage = ((lma)localObject).jdField_a_of_type_ArrayOfByte;
        l1 = ((lma)localObject).jdField_a_of_type_Long;
        str = mqx.a(((lma)localObject).jdField_b_of_type_Long);
        arrayOfByte = ((lma)localObject).jdField_b_of_type_ArrayOfByte;
        if ((i != 16) && (i != 100) && (i != 117) && (i != 120) && (i != 124)) {
          lcl.d("VcControllerImpl_NativeEventHandler", "handleMessage eventId: " + i + ", info: " + l1 + ", fromUin:" + str);
        }
        QLog.d("Native-Event", 1, "<-- Native_Event_Handler() eventId = " + i);
        switch (i)
        {
        case 71: 
        case 1: 
        case 2: 
        case 60: 
        case 61: 
          VcControllerImpl.access$300(this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl, i, (lma)localObject);
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
        i = (int)((lma)localObject).c;
        j = (int)((lma)localObject).d;
        if (((lma)localObject).jdField_b_of_type_ArrayOfByte == null) {
          break label2594;
        }
        paramMessage = new String(((lma)localObject).jdField_b_of_type_ArrayOfByte);
        this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.a(str, i, j, paramMessage);
        break;
      }
      long l2 = ((lma)localObject).c;
      long l3 = ((lma)localObject).d;
      if (l1 == 1L) {
        this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.a(str, arrayOfByte, 1L);
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.b(l2, l3, l1);
        break;
        this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.a(str, paramMessage, 0L);
      }
      if (((lma)localObject).c != 1L) {
        break label2600;
      }
      bool = true;
      label881:
      i = (int)((lma)localObject).d;
      try
      {
        paramMessage = new String(((lma)localObject).jdField_a_of_type_ArrayOfByte, "utf-8");
        j = ((lma)localObject).jdField_a_of_type_Int;
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
      i = (int)l1;
      paramMessage = new StringBuilder().append("EV_VOIP_CLOSED, Param0[").append(((lma)localObject).c).append("], Param1[").append(((lma)localObject).d).append("], Param2[").append(((lma)localObject).jdField_a_of_type_JavaLangString).append("], Param3[").append(((lma)localObject).jdField_a_of_type_Int).append("], Param4[").append(((lma)localObject).jdField_b_of_type_Int).append("], extraBuf[");
      if (((lma)localObject).jdField_b_of_type_ArrayOfByte == null) {
        break label2609;
      }
      bool = true;
      label1033:
      QLog.w("VcControllerImpl", 1, bool + "], reason[" + i + "]");
      switch (i)
      {
      case 13: 
        label1080:
        this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.a(str, i, ((lma)localObject).c);
        for (;;)
        {
          lix.a(i, ((lma)localObject).c, ((lma)localObject).d, ((lma)localObject).jdField_a_of_type_JavaLangString);
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
        this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.b(str, (int)l1, ((lma)localObject).c, ((lma)localObject).jdField_a_of_type_ArrayOfByte);
        continue;
        this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.a(str, (int)l1, ((lma)localObject).c, ((lma)localObject).jdField_a_of_type_ArrayOfByte);
        continue;
        this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.b(str, paramMessage, l1);
        continue;
        this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.c(str, paramMessage, l1);
        continue;
        switch ((int)((lma)localObject).c)
        {
        default: 
          label1644:
          QLog.i("VcControllerImpl", 1, "EV_VOIP_OTHER_TER_CHATING_STAUTS, extraParam0=" + ((lma)localObject).c);
          this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.a(str, ((lma)localObject).d, i);
          continue;
          i = (int)((lma)localObject).c;
          j = (int)((lma)localObject).d;
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
          i = (int)((lma)localObject).jdField_a_of_type_Long;
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
          this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.b(str, (int)l1, ((lma)localObject).jdField_a_of_type_ArrayOfByte);
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
      this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.a(str, ((lma)localObject).c, ((lma)localObject).d, ((lma)localObject).jdField_b_of_type_Int);
      break;
      QLog.d("NativeEventHandler", 1, "NETWORK_CHECK: recv send network check request from SDK, peerUin = " + str);
      this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.H();
      break;
      axqw.b(null, "CliOper", "", "", "0X800A7A4", "0X800A7A4", 0, (int)((lma)localObject).c, "", "", "", "");
      break;
      axqw.b(null, "CliOper", "", "", "0X800A7A5", "0X800A7A5", 0, (int)((lma)localObject).c, "", "", "", "");
      break;
      this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.g((int)((lma)localObject).c);
      break;
      break;
      label2594:
      paramMessage = "";
      break label759;
      label2600:
      bool = false;
      break label881;
      break label1080;
      label2609:
      bool = false;
      break label1033;
      i = 0;
      break label1644;
      i = 2;
      break label1644;
      i = 1;
      break label1644;
      switch ((int)l1)
      {
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     llz
 * JD-Core Version:    0.7.0.1
 */