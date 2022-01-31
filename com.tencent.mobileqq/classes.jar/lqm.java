import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.av.gaudio.QQGAudioCtrl;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

@SuppressLint({"HandlerLeak"})
public class lqm
  extends Handler
{
  public lqm(QQGAudioCtrl paramQQGAudioCtrl, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage == null) {}
    int n;
    Object localObject1;
    long l3;
    long l1;
    int k;
    int m;
    int i2;
    int j;
    int i;
    label274:
    label576:
    label750:
    boolean bool;
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.e("QQGAudioCtrl", 2, "handleMessage-->Message is empty!");
        }
        return;
      }
      finally {}
      if (this.a.mVideoController == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("QQGAudioCtrl", 2, "handleMessage-->mVideoControl = null");
        }
      }
      else
      {
        n = paramMessage.what;
        paramMessage = (lqn)paramMessage.obj;
        if (paramMessage == null)
        {
          if (QLog.isColorLevel()) {
            QLog.e("QQGAudioCtrl", 2, "handleMessage-->NativeEventParams is null");
          }
        }
        else
        {
          localObject1 = paramMessage.jdField_a_of_type_ArrayOfByte;
          l3 = paramMessage.jdField_a_of_type_Long;
          l1 = paramMessage.jdField_b_of_type_Long;
          k = paramMessage.jdField_a_of_type_Int;
          int i1 = paramMessage.jdField_b_of_type_Int;
          m = paramMessage.c;
          i2 = paramMessage.d;
          j = paramMessage.e;
          if (n == 61)
          {
            QQGAudioCtrl.mEventCountLog_EM_SDK_EVENT_ID_VIDEO_DEC_FRAME_DATA.a();
            break label2660;
            if (QLog.isColorLevel()) {
              QLog.e("QQGAudioCtrl", 2, "Wrong type of eventid=" + n);
            }
          }
          else
          {
            if ((n == 43) || (!AudioHelper.e())) {
              break label2660;
            }
            Object localObject2 = new StringBuilder().append("handleMessage, groupId[").append(l1).append("], multiAVType[").append(k).append("], multiSubType[").append(i1).append("], relationType[").append(m).append("], info[").append(l3).append("], detail[");
            if (localObject1 == null) {
              break label3371;
            }
            i = localObject1.length;
            QLog.w("QQGAudioCtrl", 1, i + "], eventId[" + n + "], buflen[" + i2 + "], flag[" + j + "]");
            break label2660;
            if (localObject1 != null)
            {
              paramMessage = this.a.getAVInfoFromByte((byte[])localObject1, i2);
              if (paramMessage == null)
              {
                if (QLog.isColorLevel()) {
                  QLog.e("QQGAudioCtrl", 2, "handleMessage, fail, empty userInfo");
                }
              }
              else if ((paramMessage.jdField_a_of_type_Int == 0) || ((paramMessage.jdField_a_of_type_Int == 1) && (paramMessage.jdField_b_of_type_Int == 3) && (n == 70)) || ((paramMessage.jdField_a_of_type_Int == 1) && (n == 71)))
              {
                this.a.mVideoController.a(paramMessage, l1, n, m, l3, new int[] { k });
                continue;
                if ((localObject1 != null) && (localObject1.length >= 8))
                {
                  paramMessage = QQGAudioCtrl.access$000(this.a, (byte[])localObject1);
                  if (paramMessage == null)
                  {
                    if (QLog.isColorLevel()) {
                      QLog.e("QQGAudioCtrl", 2, "handleMessage, fail, empty uinList");
                    }
                  }
                  else
                  {
                    if (!QLog.isColorLevel()) {
                      break label3376;
                    }
                    localObject1 = new StringBuilder();
                    j = paramMessage.length;
                    i = 0;
                    long l2;
                    while (i < j)
                    {
                      l2 = paramMessage[i];
                      ((StringBuilder)localObject1).append("UserUin = ");
                      ((StringBuilder)localObject1).append(l2);
                      ((StringBuilder)localObject1).append(", ");
                      i += 1;
                    }
                    ((StringBuilder)localObject1).append("eventid = ");
                    ((StringBuilder)localObject1).append(n);
                    QLog.d("QQGAudioCtrl", 2, ((StringBuilder)localObject1).toString());
                    break label3376;
                    this.a.mVideoController.a(l1, paramMessage, n, m, l3, k, i);
                    continue;
                    this.a.mVideoController.c(l1, m, n);
                    continue;
                    if ((localObject1 != null) && (localObject1.length >= 8) && (m == 1))
                    {
                      l2 = this.a.getLongFromByte((byte[])localObject1);
                      if (k != 10)
                      {
                        this.a.mVideoController.a((int)l3, m, l2, l1);
                        continue;
                        if ((localObject1 != null) && (localObject1.length >= 8))
                        {
                          l2 = this.a.getLongFromByte((byte[])localObject1);
                          this.a.mVideoController.a(l1, l2, m, (int)l3);
                          continue;
                          for (;;)
                          {
                            this.a.mVideoController.a(l1, l3, paramMessage);
                            if (i == 0) {
                              break;
                            }
                            this.a.mVideoController.b(m, l1, i, k);
                            break;
                            label776:
                            paramMessage = new String((byte[])localObject1);
                          }
                          label959:
                          if ((paramMessage.jdField_a_of_type_ArrayOfByte != null) && (paramMessage.jdField_a_of_type_ArrayOfByte.length >= 16))
                          {
                            paramMessage = this.a.getAVInfoFromByte(paramMessage.jdField_a_of_type_ArrayOfByte, paramMessage.jdField_a_of_type_ArrayOfByte.length);
                            if (n != 140) {
                              break label3574;
                            }
                            bool = true;
                            label834:
                            if (paramMessage != null)
                            {
                              if (QLog.isColorLevel()) {
                                QLog.w("QQGAudioCtrl", 1, "MemberAudioChange, uin[" + paramMessage.jdField_a_of_type_Long + "], accountType[" + paramMessage.jdField_a_of_type_Int + "], isMicOff[" + bool + "]");
                              }
                              this.a.mVideoController.a(paramMessage.jdField_a_of_type_Long, paramMessage.jdField_a_of_type_Int, paramMessage.jdField_b_of_type_Int, bool);
                              continue;
                              l2 = 0L;
                              l1 = l2;
                              if (paramMessage.jdField_a_of_type_ArrayOfByte == null) {
                                break label3580;
                              }
                              if (paramMessage.jdField_a_of_type_ArrayOfByte.length != 8)
                              {
                                l1 = l2;
                                break label3580;
                                this.a.mVideoController.a(l1, bool, false);
                              }
                              else
                              {
                                l1 = this.a.getLongFromByte(paramMessage.jdField_a_of_type_ArrayOfByte);
                                break label3580;
                                i = (int)l3;
                                if (paramMessage.jdField_a_of_type_ArrayOfByte == null) {
                                  break;
                                }
                                if (paramMessage.jdField_a_of_type_ArrayOfByte.length != 8) {}
                                for (l1 = 0L;; l1 = this.a.getLongFromByte(paramMessage.jdField_a_of_type_ArrayOfByte))
                                {
                                  label1019:
                                  if (QLog.isColorLevel()) {
                                    QLog.e("QQGAudioCtrl", 2, "SetMicByAdmin : uin = " + l1 + ", micAuthByAdmin = " + i);
                                  }
                                  this.a.mVideoController.a(l1, i);
                                  break;
                                }
                                j = (int)l3;
                                if ((paramMessage.jdField_a_of_type_ArrayOfByte != null) && (j != 0))
                                {
                                  localObject2 = this.a;
                                  byte[] arrayOfByte = paramMessage.jdField_a_of_type_ArrayOfByte;
                                  if (paramMessage.jdField_a_of_type_ArrayOfByte == null) {
                                    break label3599;
                                  }
                                  i = localObject1.length / j;
                                  label1134:
                                  paramMessage = QQGAudioCtrl.access$100((QQGAudioCtrl)localObject2, arrayOfByte, i);
                                  if ((paramMessage != null) && (paramMessage.size() == j))
                                  {
                                    this.a.mVideoController.a(j, paramMessage);
                                    continue;
                                    if ((paramMessage.jdField_a_of_type_ArrayOfByte != null) && (paramMessage.jdField_a_of_type_ArrayOfByte.length == 16))
                                    {
                                      l1 = this.a.getLongFromByte(paramMessage.jdField_a_of_type_ArrayOfByte);
                                      localObject1 = new byte[4];
                                      System.arraycopy(paramMessage.jdField_a_of_type_ArrayOfByte, 12, localObject1, 0, 4);
                                      i = QQGAudioCtrl.access$200(this.a, (byte[])localObject1);
                                      if (l3 != 1L) {
                                        break label3604;
                                      }
                                      bool = true;
                                      label1240:
                                      if (QLog.isColorLevel()) {
                                        QLog.e("QQGAudioCtrl", 2, "onGAudioUserAudioSuspectNoisy : uin = " + l1 + ", isSuspectNoisy = " + bool + ",validDuration = " + i);
                                      }
                                      this.a.mVideoController.a(l1, bool, i);
                                      continue;
                                      this.a.mVideoController.e(m, l1, k);
                                      this.a.processMicAuthAfterEnterRoom(paramMessage.jdField_a_of_type_ArrayOfByte);
                                      continue;
                                      paramMessage = QQGAudioCtrl.access$000(this.a, (byte[])localObject1);
                                      if (m == 2) {
                                        break label3610;
                                      }
                                      if (m == 1)
                                      {
                                        break label3610;
                                        for (;;)
                                        {
                                          label1369:
                                          this.a.onRecvUserList(6, m, l1, paramMessage, l3, k, i1, i, j);
                                          break;
                                          label1394:
                                          i = paramMessage.length;
                                        }
                                      }
                                      if (m == 3)
                                      {
                                        this.a.onRecvDoubleVideoMeeting(n, m, l3, k, i1);
                                        continue;
                                        this.a.mVideoController.a(m, l1, new int[] { k });
                                        continue;
                                        this.a.mVideoController.b(m, l1);
                                        continue;
                                        this.a.mVideoController.a(m, l1, 17, (int)paramMessage.jdField_a_of_type_Long);
                                        continue;
                                        this.a.mVideoController.a(m, l1, 16, (int)paramMessage.jdField_a_of_type_Long);
                                        continue;
                                        this.a.mVideoController.a(m, l1, 15, (int)paramMessage.jdField_a_of_type_Long);
                                        continue;
                                        paramMessage = QQGAudioCtrl.access$000(this.a, (byte[])localObject1);
                                        if (paramMessage == null) {}
                                        for (i = 0;; i = paramMessage.length)
                                        {
                                          this.a.onRecvUserList(44, m, l1, paramMessage, 0L, k, 0, i, j);
                                          break;
                                        }
                                        this.a.mVideoController.b(l1, m, k);
                                        continue;
                                        j = (int)l3;
                                        if (j >= 0)
                                        {
                                          paramMessage = null;
                                          if (j > 0)
                                          {
                                            paramMessage = this.a;
                                            if (localObject1 == null) {
                                              break label3619;
                                            }
                                            i = localObject1.length / j;
                                            label1646:
                                            paramMessage = QQGAudioCtrl.access$100(paramMessage, (byte[])localObject1, i);
                                          }
                                          if (paramMessage != null) {
                                            this.a.onRecvUserList(44, m, l1, paramMessage, 0L, 0, k, j);
                                          } else {
                                            this.a.onRecvUserListFail(m, l1, -99L);
                                          }
                                        }
                                        else
                                        {
                                          this.a.onRecvUserListFail(m, l1, j);
                                          continue;
                                          this.a.mVideoController.d(l1, m, k);
                                          this.a.processMicAuthAfterEnterRoom(paramMessage.jdField_a_of_type_ArrayOfByte);
                                          continue;
                                          if (QLog.isColorLevel()) {
                                            QLog.d("QQGAudioCtrl", 2, "EM_SDK_EVENT_ID_VIDEO_DEC_FRAME_DATA-->Uin=" + l3 + " ,VideoSrcType=" + m);
                                          }
                                          this.a.mVideoController.b(61, l3, m);
                                          continue;
                                          this.a.mVideoController.a(n, l3, l1, m);
                                          continue;
                                          this.a.mVideoController.b(n, l3, l1, m);
                                          continue;
                                          this.a.mVideoController.a(84, (int)l3, m, l1, k, i1);
                                          continue;
                                          this.a.mVideoController.a(85, (int)l3, m, l1, k, i1);
                                          continue;
                                          this.a.mVideoController.a(86, (int)l3, m, l1, k, i1);
                                          continue;
                                          this.a.mVideoController.a(87, (int)l3, m, l1, k, i1);
                                          continue;
                                          this.a.mVideoController.a(88, (int)l3, m, l1, k, i1);
                                          continue;
                                          this.a.mVideoController.a(89, (int)l3, m, l1, k, i1);
                                          continue;
                                          this.a.mVideoController.c(n, l3, l1, m);
                                          continue;
                                          this.a.mVideoController.h(3);
                                          continue;
                                          this.a.mVideoController.h(4);
                                          continue;
                                          i = (int)paramMessage.jdField_a_of_type_Long;
                                          BaseApplicationImpl.getContext().sendBroadcast(new Intent("com.tencent.av.ui.ConfigInfoTips.ACTION_IS_GETTED_SHARP_CONFIG_PAYLOAD").putExtra("version", i));
                                          lyf.a().a("load", i);
                                          continue;
                                          if (l3 != 0L) {
                                            break label3624;
                                          }
                                          localObject1 = lph.a((byte[])localObject1, i2);
                                          this.a.mVideoController.c((ArrayList)localObject1);
                                          if (((k == 10) || (k == 1)) && (localObject1 != null))
                                          {
                                            l2 = this.a.mVideoController.a(m, k, l1);
                                            paramMessage = new ArrayList(((ArrayList)localObject1).size());
                                            l3 = AudioHelper.a() / 1000L;
                                            localObject1 = ((ArrayList)localObject1).iterator();
                                            while (((Iterator)localObject1).hasNext()) {
                                              paramMessage.add(new lqk(((lph)((Iterator)localObject1).next()).jdField_a_of_type_Long, l3));
                                            }
                                            this.a.mVideoController.a(l1, l2, paramMessage);
                                            if (QLog.isColorLevel()) {
                                              QLog.i("QQGAudioCtrl", 2, "EM_SDK_EVENT_ID_PBInvite_Rsp = MULTIAV_GROUP_AUDIO saveInviteMembers");
                                            }
                                          }
                                        }
                                      }
                                    }
                                  }
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      this.a.mVideoController.b(l1, l3, paramMessage);
      break;
      label2313:
      paramMessage = new String((byte[])localObject1);
    }
    for (;;)
    {
      label2326:
      this.a.mVideoController.a(l1, m, k, (int)l3, paramMessage);
      break;
      label2351:
      paramMessage = new String((byte[])localObject1);
    }
    label3599:
    label3604:
    label3610:
    label3619:
    label3624:
    for (;;)
    {
      label2364:
      this.a.mVideoController.b(l1, m, k, (int)l3, paramMessage);
      break;
      label2660:
      label3574:
      label3580:
      do
      {
        paramMessage = new String((byte[])localObject1);
        break label2364;
        this.a.mVideoController.y();
        break;
        this.a.mVideoController.z();
        break;
        if (localObject1 == null) {
          break;
        }
        this.a.mVideoController.e(this.a.getLongFromByte((byte[])localObject1));
        break;
        if (l3 == 0L) {
          break;
        }
        i = (int)l3;
        this.a.mVideoController.f(i);
        break;
        if (localObject1 == null) {
          break;
        }
        this.a.mVideoController.g((byte[])localObject1);
        break;
        paramMessage = QQGAudioCtrl.access$300(this.a, (byte[])localObject1, i2);
        if (paramMessage == null) {
          break;
        }
        this.a.mVideoController.b(l1, paramMessage);
        break;
        azqs.b(null, "CliOper", "", "", "0X800A7A6", "0X800A7A6", 0, (int)l3, "", "", "", "");
        break;
        azqs.b(null, "CliOper", "", "", "0X800A7A7", "0X800A7A7", 0, (int)l3, "", "", "", "");
        break;
        this.a.mVideoController.f(l3);
        break;
        QQGAudioCtrl.access$400(this.a, m, l1, l3, j);
        break;
        l1 = 0L;
        break label1019;
        switch (n)
        {
        case 7: 
        case 13: 
        case 36: 
        case 37: 
        case 38: 
        case 9: 
        case 10: 
        case 14: 
        case 15: 
        case 16: 
        case 17: 
        case 18: 
        case 19: 
        case 23: 
        case 24: 
        case 25: 
        case 26: 
        case 27: 
        case 28: 
        case 29: 
        case 40: 
        case 41: 
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
        case 60: 
        case 62: 
        case 63: 
        case 64: 
        case 65: 
        case 66: 
        case 67: 
        case 68: 
        case 69: 
        case 81: 
        case 82: 
        case 83: 
        case 99: 
        case 100: 
        case 105: 
        case 106: 
        case 111: 
        case 112: 
        case 113: 
        case 114: 
        case 115: 
        case 116: 
        case 117: 
        case 118: 
        case 119: 
        case 120: 
        case 124: 
        case 125: 
        case 126: 
        case 127: 
        case 128: 
        case 129: 
        case 130: 
        case 131: 
        case 132: 
        case 133: 
        case 134: 
        case 135: 
        case 136: 
        case 137: 
        case 146: 
        case 147: 
        case 148: 
        case 149: 
        case 150: 
        case 151: 
        case 152: 
        case 154: 
        case 155: 
        case 156: 
        case 159: 
        case 160: 
        case 161: 
        case 162: 
        case 163: 
        case 164: 
        case 165: 
        case 166: 
        case 167: 
        case 168: 
        case 169: 
        case 170: 
        case 173: 
        case 70: 
        case 71: 
        case 42: 
        case 43: 
        case 72: 
        case 73: 
        case 74: 
        case 75: 
        case 76: 
        case 77: 
        case 78: 
        case 79: 
        case 101: 
        case 102: 
        case 103: 
        case 104: 
        case 107: 
        case 108: 
        case 109: 
        case 110: 
        case 140: 
        case 141: 
        case 142: 
        case 143: 
        case 144: 
        case 145: 
        case 30: 
        case 5: 
        case 6: 
        case 12: 
        case 11: 
        case 31: 
        case 32: 
        case 34: 
        case 35: 
        case 39: 
        case 44: 
        case 45: 
        case 8: 
        case 33: 
        case 61: 
        case 90: 
        case 91: 
        case 92: 
        case 93: 
        case 94: 
        case 95: 
        case 84: 
        case 85: 
        case 86: 
        case 87: 
        case 88: 
        case 89: 
        case 96: 
        case 97: 
        case 98: 
        case 121: 
        case 122: 
        case 123: 
        case 20: 
        case 153: 
        case 158: 
        case 157: 
        case 171: 
        case 172: 
        case 80: 
        case 174: 
        case 175: 
        case 176: 
        case 177: 
        default: 
          break;
          i = -1;
          break label274;
          i = 0;
          if (n != 42) {
            break label576;
          }
          j = (int)l3;
          if (j > 100)
          {
            i = 100;
            break label576;
          }
          i = j;
          if (j >= 0) {
            break label576;
          }
          i = 0;
          break;
        case 138: 
        case 139: 
          i = 0;
          switch ((int)l3)
          {
          default: 
            if ((l3 > 200L) && (l3 < 300L))
            {
              if (localObject1 != null) {
                break label776;
              }
              paramMessage = "";
            }
            break;
          case 8: 
            if (m != 1) {
              break label750;
            }
            i = 1;
            break;
          case 7: 
            i = 2;
            break;
          case 32: 
            i = 7;
            break;
          case 35: 
            i = 35;
            break;
          case 42: 
            i = 42;
            break;
          case 43: 
            i = 43;
            break;
          case 3: 
          case 15: 
            i = 3;
            break label750;
            i = (int)l3;
            break label750;
            bool = false;
            break label834;
            if (l3 == 0L)
            {
              bool = false;
              break label959;
            }
            bool = true;
            break label959;
            i = 0;
            break label1134;
            bool = false;
            break label1240;
            if (paramMessage != null) {
              break label1394;
            }
            i = 0;
            break label1369;
            i = 0;
            break label1646;
            if (localObject1 != null) {
              break label2313;
            }
            paramMessage = "";
          }
          break;
        case 21: 
          if (localObject1 != null) {
            break label2351;
          }
          paramMessage = "";
          break label2326;
        }
      } while (localObject1 != null);
      label3371:
      label3376:
      paramMessage = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     lqm
 * JD-Core Version:    0.7.0.1
 */