import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.av.AVLog;
import com.tencent.av.core.IVideoEventListener;
import com.tencent.av.core.VcControllerImpl;
import com.tencent.av.report.AVReport;
import com.tencent.av.report.TraeConfigUpdate;
import com.tencent.av.utils.CharacterUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

@SuppressLint({"HandlerLeak"})
public class jib
  extends Handler
{
  private final String jdField_a_of_type_JavaLangString = "VcControllerImpl_NativeEventHandler";
  
  public jib(VcControllerImpl paramVcControllerImpl, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    int i;
    byte[] arrayOfByte1;
    long l;
    String str;
    for (;;)
    {
      byte[] arrayOfByte2;
      try
      {
        i = paramMessage.what;
        paramMessage = (jic)paramMessage.obj;
        if (paramMessage == null)
        {
          AVLog.e("VcControllerImpl_NativeEventHandler", "p is null");
          return;
        }
        arrayOfByte1 = paramMessage.jdField_a_of_type_ArrayOfByte;
        l = paramMessage.jdField_a_of_type_Long;
        str = CharacterUtil.a(paramMessage.jdField_b_of_type_Long);
        arrayOfByte2 = paramMessage.jdField_b_of_type_ArrayOfByte;
        if ((i == 16) || (i == 100) || (i == 117)) {
          break;
        }
        AVLog.d("VcControllerImpl_NativeEventHandler", "handleMessage eventId: " + i + ", info: " + l + ", fromUin:" + str);
      }
      finally {}
      VcControllerImpl.access$000(this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl, i, paramMessage);
      continue;
      this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.d(str);
      continue;
      if (l > 1000L) {}
      for (this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mfAudio2VideoFlag = true;; this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mfAudio2VideoFlag = false)
      {
        this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.k(str);
        break;
      }
      if (l == 1L)
      {
        this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.a(str, arrayOfByte2, 1L);
      }
      else
      {
        this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.a(str, arrayOfByte1, 0L);
        continue;
        i = (int)l;
        AVLog.d("VcControllerImpl_NativeEventHandler", "EV_VOIP_CLOSED reason = " + i);
        switch (i)
        {
        case 13: 
          label288:
          this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.a(str, i, paramMessage.c);
          continue;
          this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.p(str);
          continue;
          this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.a(str, 12, 0L);
          continue;
          this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.l(str);
          continue;
          this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.m(str);
          continue;
          this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.n(str);
          continue;
          this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.o(str);
          continue;
          this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.q(str);
          continue;
          this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.s(str);
          continue;
          this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.t(str);
          continue;
          this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.a(i - 19, str);
          continue;
          this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.a(str, true);
          continue;
          this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.a(str, false);
          continue;
          this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.e(str);
          continue;
          this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.f(str);
          continue;
          this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.g(str);
          continue;
          this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.h(str);
          continue;
          this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.d(true);
          continue;
          this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.d(false);
          continue;
          if (AVReport.a().a) {
            AVReport.a().k = SystemClock.elapsedRealtime();
          }
          for (;;)
          {
            this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.e(true);
            break;
            AVReport.a().z = SystemClock.elapsedRealtime();
          }
          this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.b(arrayOfByte1, l);
          continue;
          this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.u(str);
          continue;
          this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.b(str, (int)l, paramMessage.c, paramMessage.jdField_a_of_type_ArrayOfByte);
          continue;
          this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.a(str, (int)l, paramMessage.c, paramMessage.jdField_a_of_type_ArrayOfByte);
          continue;
          this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.b(str, arrayOfByte1, l);
          continue;
          this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.c(str, arrayOfByte1, l);
          continue;
          switch ((int)paramMessage.c)
          {
          default: 
            label824:
            QLog.i("VcControllerImpl", 1, "EV_VOIP_OTHER_TER_CHATING_STAUTS, extraParam0=" + paramMessage.c);
            this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.a(str, paramMessage.d, i);
            continue;
            this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.r(str);
            continue;
            this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.f(str, (int)l);
            continue;
            this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.d(str, (int)l);
            continue;
            this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.e(str, (int)l);
            continue;
            this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.w(str);
            this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.i(2048);
            continue;
            this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.i(3);
            continue;
            this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.i(4);
            continue;
            i = (int)paramMessage.jdField_a_of_type_Long;
            if (QLog.isColorLevel()) {
              QLog.d("NativeEventHandler", 2, "SharpConfigPayload. version = " + i);
            }
            BaseApplicationImpl.getContext().sendBroadcast(new Intent("com.tencent.av.ui.ConfigInfoTips.ACTION_IS_GETTED_SHARP_CONFIG_PAYLOAD").putExtra("version", i));
            TraeConfigUpdate.a().a("load", i);
            continue;
            this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.b(str, l, arrayOfByte1);
            continue;
            this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.onAudioData(arrayOfByte1);
            continue;
            this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.b(str, (int)l, paramMessage.jdField_a_of_type_ArrayOfByte);
          }
          break;
        }
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.a(str, (int)l, arrayOfByte1);
      break;
      this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.c((int)l, new String(arrayOfByte1));
      break;
      this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.d((int)l, new String(arrayOfByte1));
      break;
      this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.e(arrayOfByte1);
      break;
      this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.v(new String(arrayOfByte1));
      break;
      this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.j(new String(arrayOfByte1));
      break;
      this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.i(new String(arrayOfByte1));
      break;
      this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.a(str, new String(arrayOfByte1));
      break;
      i = (int)l;
      this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.h(str, i);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("NativeEventHandler", 2, "EM_SDK_EVENT_ID_GROUND_GLASS_SWITCH. nSwitch = " + i + ", fromUin=" + str);
      break;
      i = (int)l;
      this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.i(str, i);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("NativeEventHandler", 2, "EM_SDK_EVENT_ID_GROUND_GLASS_WAIT_TIME. nTime = " + i + ", fromUin=" + str);
      break;
      i = (int)l;
      this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.mEventListener.j(i);
      break;
      switch (i)
      {
      case 71: 
      case 1: 
      case 2: 
      case 60: 
      case 61: 
      case 3: 
      case 6: 
      case 16: 
      case 4: 
      case 24: 
      case 8: 
      case 10: 
      case 7: 
      case 9: 
      case 13: 
      case 14: 
      case 18: 
      case 19: 
      case 20: 
      case 21: 
      case 22: 
      case 25: 
      case 26: 
      case 105: 
      case 106: 
      case 107: 
      case 108: 
      case 62: 
      case 63: 
      case 64: 
      case 65: 
      case 66: 
      case 95: 
      case 68: 
      case 67: 
      case 69: 
      case 72: 
      case 73: 
      case 75: 
      case 74: 
      case 76: 
      case 83: 
      case 91: 
      case 92: 
      case 93: 
      case 100: 
      case 96: 
      case 110: 
      case 113: 
      case 114: 
      case 116: 
      case 5: 
      case 11: 
      case 12: 
      case 15: 
      case 17: 
      case 23: 
      case 27: 
      case 28: 
      case 29: 
      case 30: 
      case 31: 
      case 32: 
      case 33: 
      case 34: 
      case 35: 
      case 36: 
      case 37: 
      case 38: 
      case 39: 
      case 40: 
      case 41: 
      case 42: 
      case 43: 
      case 44: 
      case 45: 
      case 46: 
      case 47: 
      case 48: 
      case 49: 
      case 50: 
      case 51: 
      case 52: 
      case 53: 
      case 54: 
      case 55: 
      case 56: 
      case 57: 
      case 58: 
      case 59: 
      case 70: 
      case 77: 
      case 78: 
      case 79: 
      case 80: 
      case 81: 
      case 82: 
      case 84: 
      case 85: 
      case 86: 
      case 87: 
      case 88: 
      case 89: 
      case 90: 
      case 94: 
      case 97: 
      case 98: 
      case 99: 
      case 101: 
      case 102: 
      case 103: 
      case 104: 
      case 109: 
      case 112: 
      case 115: 
      default: 
        break;
        break label288;
        i = 0;
        break label824;
        i = 2;
        break label824;
        i = 1;
        break;
      case 111: 
        switch ((int)l)
        {
        }
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jib
 * JD-Core Version:    0.7.0.1
 */