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
public class loo
  extends Handler
{
  public loo(QQGAudioCtrl paramQQGAudioCtrl, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage == null) {}
    int m;
    Object localObject1;
    long l3;
    long l1;
    int j;
    int k;
    int i1;
    int i;
    label729:
    label754:
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
        m = paramMessage.what;
        paramMessage = (lop)paramMessage.obj;
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
          j = paramMessage.jdField_a_of_type_Int;
          int n = paramMessage.jdField_b_of_type_Int;
          k = paramMessage.c;
          i1 = paramMessage.d;
          if (m == 61)
          {
            QQGAudioCtrl.mEventCountLog_EM_SDK_EVENT_ID_VIDEO_DEC_FRAME_DATA.a();
            break label2380;
            if (QLog.isColorLevel()) {
              QLog.e("QQGAudioCtrl", 2, "Wrong type of eventid=" + m);
            }
          }
          else
          {
            if ((m == 43) || (!AudioHelper.e())) {
              break label2380;
            }
            Object localObject2 = new StringBuilder().append("handleMessage, groupId[").append(l1).append("], multiAVType[").append(j).append("], multiSubType[").append(n).append("], relationType[").append(k).append("], info[").append(l3).append("], detail[");
            if (localObject1 == null) {
              break label3083;
            }
            i = localObject1.length;
            QLog.w("QQGAudioCtrl", 1, i + "], eventId[" + m + "], buflen[" + i1 + "]");
            break label2380;
            if (localObject1 != null)
            {
              paramMessage = this.a.getAVInfoFromByte((byte[])localObject1, i1);
              if (paramMessage == null)
              {
                if (QLog.isColorLevel()) {
                  QLog.e("QQGAudioCtrl", 2, "handleMessage, fail, empty userInfo");
                }
              }
              else if ((paramMessage.jdField_a_of_type_Int == 0) || ((paramMessage.jdField_a_of_type_Int == 1) && (paramMessage.jdField_b_of_type_Int == 3) && (m == 70)) || ((paramMessage.jdField_a_of_type_Int == 1) && (m == 71)))
              {
                this.a.mVideoController.a(paramMessage, l1, m, k, l3, new int[] { j });
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
                    long l2;
                    if (QLog.isColorLevel())
                    {
                      localObject1 = new StringBuilder();
                      n = paramMessage.length;
                      i = 0;
                      while (i < n)
                      {
                        l2 = paramMessage[i];
                        ((StringBuilder)localObject1).append("UserUin = ");
                        ((StringBuilder)localObject1).append(l2);
                        ((StringBuilder)localObject1).append(", ");
                        i += 1;
                      }
                      ((StringBuilder)localObject1).append("eventid = ");
                      ((StringBuilder)localObject1).append(m);
                      QLog.d("QQGAudioCtrl", 2, ((StringBuilder)localObject1).toString());
                    }
                    this.a.mVideoController.a(l1, paramMessage, m, k, l3, j);
                    continue;
                    this.a.mVideoController.b(l1, k, m);
                    continue;
                    if ((localObject1 != null) && (localObject1.length >= 8) && (k == 1))
                    {
                      l2 = this.a.getLongFromByte((byte[])localObject1);
                      if (j != 10)
                      {
                        this.a.mVideoController.a((int)l3, k, l2, l1);
                        continue;
                        if ((localObject1 != null) && (localObject1.length >= 8))
                        {
                          l2 = this.a.getLongFromByte((byte[])localObject1);
                          this.a.mVideoController.a(l1, l2, k, (int)l3);
                          continue;
                          for (;;)
                          {
                            this.a.mVideoController.a(l1, l3, paramMessage);
                            if (i == 0) {
                              break;
                            }
                            this.a.mVideoController.b(k, l1, i, j);
                            break;
                            paramMessage = new String((byte[])localObject1);
                          }
                          label937:
                          if ((paramMessage.jdField_a_of_type_ArrayOfByte != null) && (paramMessage.jdField_a_of_type_ArrayOfByte.length >= 16))
                          {
                            paramMessage = this.a.getAVInfoFromByte(paramMessage.jdField_a_of_type_ArrayOfByte, paramMessage.jdField_a_of_type_ArrayOfByte.length);
                            if (m != 140) {
                              break label3250;
                            }
                            bool = true;
                            label812:
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
                                break label3256;
                              }
                              if (paramMessage.jdField_a_of_type_ArrayOfByte.length != 8)
                              {
                                l1 = l2;
                                break label3256;
                                this.a.mVideoController.a(l1, bool, false);
                              }
                              else
                              {
                                l1 = this.a.getLongFromByte(paramMessage.jdField_a_of_type_ArrayOfByte);
                                break label3256;
                                i = (int)l3;
                                if (paramMessage.jdField_a_of_type_ArrayOfByte == null) {
                                  break;
                                }
                                if (paramMessage.jdField_a_of_type_ArrayOfByte.length != 8) {}
                                for (l1 = 0L;; l1 = this.a.getLongFromByte(paramMessage.jdField_a_of_type_ArrayOfByte))
                                {
                                  label997:
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
                                    break label3275;
                                  }
                                  i = localObject1.length / j;
                                  label1112:
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
                                        break label3280;
                                      }
                                      bool = true;
                                      label1218:
                                      if (QLog.isColorLevel()) {
                                        QLog.e("QQGAudioCtrl", 2, "onGAudioUserAudioSuspectNoisy : uin = " + l1 + ", isSuspectNoisy = " + bool + ",validDuration = " + i);
                                      }
                                      this.a.mVideoController.a(l1, bool, i);
                                      continue;
                                      this.a.mVideoController.e(k, l1, j);
                                      this.a.processMicAuthAfterEnterRoom(paramMessage.jdField_a_of_type_ArrayOfByte);
                                      continue;
                                      paramMessage = QQGAudioCtrl.access$000(this.a, (byte[])localObject1);
                                      if (k == 2) {
                                        break label3286;
                                      }
                                      if (k == 1)
                                      {
                                        break label3286;
                                        for (;;)
                                        {
                                          label1346:
                                          this.a.onRecvUserList(6, k, l1, paramMessage, l3, j, n, i);
                                          break;
                                          label1369:
                                          i = paramMessage.length;
                                        }
                                      }
                                      if (k == 3)
                                      {
                                        this.a.onRecvDoubleVideoMeeting(m, k, l3);
                                        continue;
                                        this.a.mVideoController.a(k, l1, new int[] { j });
                                        continue;
                                        this.a.mVideoController.b(k, l1);
                                        continue;
                                        this.a.mVideoController.a(k, l1, 17, (int)paramMessage.jdField_a_of_type_Long);
                                        continue;
                                        this.a.mVideoController.a(k, l1, 16, (int)paramMessage.jdField_a_of_type_Long);
                                        continue;
                                        this.a.mVideoController.a(k, l1, 15, (int)paramMessage.jdField_a_of_type_Long);
                                        continue;
                                        paramMessage = QQGAudioCtrl.access$000(this.a, (byte[])localObject1);
                                        if (paramMessage == null) {}
                                        for (i = 0;; i = paramMessage.length)
                                        {
                                          this.a.onRecvUserList(44, k, l1, paramMessage, 0L, j, 0, i);
                                          break;
                                        }
                                        this.a.mVideoController.a(l1, k, j);
                                        continue;
                                        m = (int)l3;
                                        if (m >= 0)
                                        {
                                          paramMessage = null;
                                          if (m > 0)
                                          {
                                            paramMessage = this.a;
                                            if (localObject1 == null) {
                                              break label3295;
                                            }
                                            i = localObject1.length / m;
                                            label1617:
                                            paramMessage = QQGAudioCtrl.access$100(paramMessage, (byte[])localObject1, i);
                                          }
                                          if (paramMessage != null) {
                                            this.a.onRecvUserList(44, k, l1, paramMessage, 0L, 0, j, m);
                                          } else {
                                            this.a.onRecvUserListFail(k, l1, -99L);
                                          }
                                        }
                                        else
                                        {
                                          this.a.onRecvUserListFail(k, l1, m);
                                          continue;
                                          this.a.mVideoController.c(l1, k, j);
                                          this.a.processMicAuthAfterEnterRoom(paramMessage.jdField_a_of_type_ArrayOfByte);
                                          continue;
                                          this.a.mVideoController.b(61, l3, k);
                                          continue;
                                          this.a.mVideoController.a(m, l3, l1, k);
                                          continue;
                                          this.a.mVideoController.b(m, l3, l1, k);
                                          continue;
                                          this.a.mVideoController.c(m, l3, l1, k);
                                          continue;
                                          this.a.mVideoController.h(3);
                                          continue;
                                          this.a.mVideoController.h(4);
                                          continue;
                                          i = (int)paramMessage.jdField_a_of_type_Long;
                                          BaseApplicationImpl.getContext().sendBroadcast(new Intent("com.tencent.av.ui.ConfigInfoTips.ACTION_IS_GETTED_SHARP_CONFIG_PAYLOAD").putExtra("version", i));
                                          lwd.a().a("load", i);
                                          continue;
                                          if (l3 != 0L) {
                                            break label3300;
                                          }
                                          localObject1 = lnj.a((byte[])localObject1, i1);
                                          this.a.mVideoController.c((ArrayList)localObject1);
                                          if (((j == 10) || (j == 1)) && (localObject1 != null))
                                          {
                                            l2 = this.a.mVideoController.a(k, j, l1);
                                            paramMessage = new ArrayList(((ArrayList)localObject1).size());
                                            l3 = AudioHelper.a() / 1000L;
                                            localObject1 = ((ArrayList)localObject1).iterator();
                                            while (((Iterator)localObject1).hasNext()) {
                                              paramMessage.add(new lom(((lnj)((Iterator)localObject1).next()).jdField_a_of_type_Long, l3));
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
      label2069:
      paramMessage = new String((byte[])localObject1);
    }
    for (;;)
    {
      label2082:
      this.a.mVideoController.a(l1, k, j, (int)l3, paramMessage);
      break;
      label2106:
      paramMessage = new String((byte[])localObject1);
    }
    for (;;)
    {
      label2119:
      this.a.mVideoController.b(l1, k, j, (int)l3, paramMessage);
      break;
      label2380:
      label3280:
      label3286:
      label3295:
      label3300:
      do
      {
        paramMessage = new String((byte[])localObject1);
        break label2119;
        this.a.mVideoController.y();
        break;
        this.a.mVideoController.z();
        break;
        if (localObject1 == null) {
          break;
        }
        this.a.mVideoController.f(this.a.getLongFromByte((byte[])localObject1));
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
        paramMessage = QQGAudioCtrl.access$300(this.a, (byte[])localObject1, i1);
        if (paramMessage == null) {
          break;
        }
        this.a.mVideoController.b(l1, paramMessage);
        break;
        axqw.b(null, "CliOper", "", "", "0X800A7A6", "0X800A7A6", 0, (int)l3, "", "", "", "");
        break;
        axqw.b(null, "CliOper", "", "", "0X800A7A7", "0X800A7A7", 0, (int)l3, "", "", "", "");
        break;
        l1 = 0L;
        break label997;
        switch (m)
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
        case 84: 
        case 85: 
        case 86: 
        case 87: 
        case 88: 
        case 89: 
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
        default: 
          break;
          i = -1;
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
                break label754;
              }
              paramMessage = "";
            }
            break;
          case 8: 
            if (k != 1) {
              break label729;
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
            break label729;
            i = (int)l3;
            break label729;
            bool = false;
            break label812;
            if (l3 == 0L)
            {
              bool = false;
              break label937;
            }
            bool = true;
            break label937;
            i = 0;
            break label1112;
            bool = false;
            break label1218;
            if (paramMessage != null) {
              break label1369;
            }
            i = 0;
            break label1346;
            i = 0;
            break label1617;
            if (localObject1 != null) {
              break label2069;
            }
            paramMessage = "";
          }
          break;
        case 21: 
          if (localObject1 != null) {
            break label2106;
          }
          paramMessage = "";
          break label2082;
        }
      } while (localObject1 != null);
      label3083:
      label3250:
      label3256:
      label3275:
      paramMessage = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     loo
 * JD-Core Version:    0.7.0.1
 */