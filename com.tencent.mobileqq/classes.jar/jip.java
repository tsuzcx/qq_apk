import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.av.VideoController;
import com.tencent.av.gaudio.AVInviteAccount;
import com.tencent.av.gaudio.AVInvitePSTNPhone;
import com.tencent.av.gaudio.AVUserInfo;
import com.tencent.av.gaudio.QQGAudioCtrl;
import com.tencent.av.report.TraeConfigUpdate;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

@SuppressLint({"HandlerLeak"})
public class jip
  extends Handler
{
  public jip(QQGAudioCtrl paramQQGAudioCtrl, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage == null) {}
    int m;
    Object localObject;
    long l3;
    long l1;
    int j;
    int n;
    int k;
    int i;
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
        localObject = (jiq)paramMessage.obj;
        label647:
        if (localObject == null)
        {
          if (QLog.isColorLevel()) {
            QLog.e("QQGAudioCtrl", 2, "handleMessage-->NativeEventParams is null");
          }
        }
        else
        {
          paramMessage = ((jiq)localObject).jdField_a_of_type_ArrayOfByte;
          l3 = ((jiq)localObject).jdField_a_of_type_Long;
          l1 = ((jiq)localObject).jdField_b_of_type_Long;
          j = ((jiq)localObject).jdField_a_of_type_Int;
          n = ((jiq)localObject).jdField_b_of_type_Int;
          k = ((jiq)localObject).c;
          i = ((jiq)localObject).d;
          if ((m == 61) || (m == 43) || (!AudioHelper.e())) {
            break label3276;
          }
          StringBuilder localStringBuilder = new StringBuilder().append("handleMessage, groupId[").append(l1).append("], multiAVType[").append(j).append("], multiSubType[").append(n).append("], relationType[").append(k).append("], info[").append(l3).append("], detail[");
          if (paramMessage == null) {
            break label3963;
          }
          bool = true;
          QLog.w("QQGAudioCtrl", 1, bool + "], eventId[" + m + "], buflen[" + i + "]");
          break label3276;
          label271:
          if (QLog.isColorLevel())
          {
            QLog.e("QQGAudioCtrl", 2, "Wrong type of eventid=" + m);
            continue;
            if (QLog.isColorLevel()) {
              QLog.d("QQGAudioCtrl", 2, "OnMemberJoin Or OnMemberOut");
            }
            if (paramMessage == null)
            {
              if (QLog.isColorLevel()) {
                QLog.e("QQGAudioCtrl", 2, "GroupId= " + l1 + " multiAVType=" + j + " MultiSubType=" + n + " relationType=" + k + " info=" + l3 + " eventId=" + m);
              }
            }
            else
            {
              paramMessage = this.a.getAVInfoFromByte(paramMessage, i);
              if (paramMessage == null)
              {
                if (QLog.isColorLevel()) {
                  QLog.e("QQGAudioCtrl", 2, "Can not get AVUserInfo");
                }
              }
              else if ((paramMessage.jdField_a_of_type_Int == 0) || ((paramMessage.jdField_a_of_type_Int == 1) && (paramMessage.jdField_b_of_type_Int == 3) && (m == 70)) || ((paramMessage.jdField_a_of_type_Int == 1) && (m == 71)))
              {
                this.a.mVideoController.a(paramMessage, l1, m, k, l3, new int[] { j });
              }
              else if (QLog.isColorLevel())
              {
                QLog.e("QQGAudioCtrl", 2, "onMAVMemberInOrOut --> WRONG INFO. Info = " + paramMessage.toString());
                continue;
                if ((paramMessage == null) || (paramMessage.length < 8))
                {
                  if (QLog.isColorLevel())
                  {
                    localObject = new StringBuilder().append("GroupId= ").append(l1).append(" multiAVType=").append(j).append(" MultiSubType=").append(n).append(" relationType=").append(k).append(" info=").append(l3).append(" eventId=").append(m).append(" detail=");
                    if (paramMessage == null) {
                      break label3969;
                    }
                    bool = true;
                    QLog.e("QQGAudioCtrl", 2, bool);
                  }
                }
                else
                {
                  paramMessage = QQGAudioCtrl.access$000(this.a, paramMessage);
                  if (paramMessage == null)
                  {
                    if (QLog.isColorLevel()) {
                      QLog.e("QQGAudioCtrl", 2, "handleMessage--> can not get the uin");
                    }
                  }
                  else
                  {
                    long l2;
                    if (QLog.isColorLevel())
                    {
                      localObject = new StringBuilder();
                      n = paramMessage.length;
                      i = 0;
                      while (i < n)
                      {
                        l2 = paramMessage[i];
                        ((StringBuilder)localObject).append("UserUin = ");
                        ((StringBuilder)localObject).append(l2);
                        ((StringBuilder)localObject).append(", ");
                        i += 1;
                      }
                      ((StringBuilder)localObject).append("eventid = ");
                      ((StringBuilder)localObject).append(m);
                      QLog.d("QQGAudioCtrl", 2, ((StringBuilder)localObject).toString());
                    }
                    this.a.mVideoController.a(l1, paramMessage, m, k, l3, j);
                    continue;
                    this.a.mVideoController.b(l1, k, m);
                    continue;
                    if ((paramMessage == null) || (paramMessage.length < 8))
                    {
                      if (QLog.isColorLevel())
                      {
                        localObject = new StringBuilder().append("GroupId= ").append(l1).append(" multiAVType=").append(j).append(" MultiSubType=").append(n).append(" relationType=").append(k).append(" info=").append(l3).append(" eventId=").append(m).append(" detail==null");
                        if (paramMessage != null) {
                          break label3975;
                        }
                        bool = true;
                        label925:
                        QLog.e("QQGAudioCtrl", 2, bool);
                      }
                    }
                    else if (k != 1)
                    {
                      if (QLog.isColorLevel()) {
                        QLog.e("QQGAudioCtrl", 2, "Why Discussion AVChat can recv VideoSrcType Change???????");
                      }
                    }
                    else
                    {
                      l2 = this.a.getLongFromByte(paramMessage);
                      if (QLog.isColorLevel()) {
                        QLog.d("QQGAudioCtrl", 2, "EM_SDK_EVENT_ID_GROUP_VIDEO_SRC_TYPE_CHANGE-->videoSrcType=" + l3 + "uin =" + l2);
                      }
                      if (j != 10)
                      {
                        this.a.mVideoController.a((int)l3, k, l2, l1);
                        continue;
                        if ((paramMessage == null) || (paramMessage.length < 8))
                        {
                          if (QLog.isColorLevel())
                          {
                            localObject = new StringBuilder().append("GroupId= ").append(l1).append(" multiAVType=").append(j).append(" MultiSubType=").append(n).append(" relationType=").append(k).append(" info=").append(l3).append(" eventId=").append(m).append(" detail==null");
                            if (paramMessage != null) {
                              break label3981;
                            }
                            bool = true;
                            label1144:
                            QLog.e("QQGAudioCtrl", 2, bool);
                          }
                        }
                        else
                        {
                          l2 = this.a.getLongFromByte(paramMessage);
                          if (QLog.isColorLevel()) {
                            QLog.d("QQGAudioCtrl", 2, "EM_SDK_EVENT_ID_PPT_UPLOAD_STATE-->uploadType=" + l3 + "uin =" + l2);
                          }
                          this.a.mVideoController.a(l1, l2, k, (int)l3);
                          continue;
                          if (l3 == 8L)
                          {
                            if (k == 1) {
                              this.a.mVideoController.c(l1, 1, j);
                            }
                          }
                          else if (l3 == 7L)
                          {
                            this.a.mVideoController.c(l1, 2, j);
                          }
                          else if (l3 == 32L)
                          {
                            this.a.mVideoController.c(l1, 7, j);
                          }
                          else if (l3 == 35L)
                          {
                            this.a.mVideoController.c(l1, 35, j);
                          }
                          else if (l3 == 42L)
                          {
                            this.a.mVideoController.c(l1, 42, j);
                          }
                          else if (l3 == 43L)
                          {
                            this.a.mVideoController.c(l1, 43, j);
                          }
                          else
                          {
                            if ((l3 <= 200L) || (l3 >= 300L)) {
                              break label3987;
                            }
                            paramMessage = new String(paramMessage);
                            this.a.mVideoController.a(l1, l3, paramMessage);
                            continue;
                            label1448:
                            this.a.mVideoController.c(l1, 3, j);
                            continue;
                            label1465:
                            this.a.mVideoController.c(l1, (int)l3, j);
                            continue;
                            if ((((jiq)localObject).jdField_a_of_type_ArrayOfByte == null) || (((jiq)localObject).jdField_a_of_type_ArrayOfByte.length != 16))
                            {
                              if (QLog.isColorLevel()) {
                                QLog.e("QQGAudioCtrl", 2, "eventId = " + m + ", p.detail buf length incorrect ");
                              }
                            }
                            else
                            {
                              paramMessage = this.a.getAVInfoFromByte(((jiq)localObject).jdField_a_of_type_ArrayOfByte, ((jiq)localObject).jdField_a_of_type_ArrayOfByte.length);
                              if (m != 140) {
                                break label4008;
                              }
                              bool = true;
                              label1573:
                              if (QLog.isColorLevel()) {
                                QLog.e("QQGAudioCtrl", 2, "MemberAudioChange : uin = " + paramMessage.jdField_a_of_type_Long + ", accountType = " + paramMessage.jdField_a_of_type_Int + ", pstnstatus = " + paramMessage.jdField_b_of_type_Int + ", isMicOff = " + bool);
                              }
                              this.a.mVideoController.a(paramMessage.jdField_a_of_type_Long, paramMessage.jdField_a_of_type_Int, paramMessage.jdField_b_of_type_Int, bool);
                              continue;
                              l2 = 0L;
                              if ((((jiq)localObject).jdField_a_of_type_ArrayOfByte == null) || (((jiq)localObject).jdField_a_of_type_ArrayOfByte.length != 8))
                              {
                                l1 = l2;
                                if (!QLog.isColorLevel()) {
                                  break label4014;
                                }
                                QLog.e("QQGAudioCtrl", 2, "eventId = " + m + ", p.detail buf length incorrect ");
                                l1 = l2;
                                break label4014;
                                label1738:
                                if (QLog.isColorLevel()) {
                                  QLog.e("QQGAudioCtrl", 2, "MeetingControlMode : uin = " + l1 + ", isRoomMicOff = " + bool);
                                }
                                this.a.mVideoController.b(l1, bool);
                              }
                              else
                              {
                                l1 = this.a.getLongFromByte(((jiq)localObject).jdField_a_of_type_ArrayOfByte);
                                break label4014;
                                label1814:
                                if ((((jiq)localObject).jdField_a_of_type_ArrayOfByte == null) || (((jiq)localObject).jdField_a_of_type_ArrayOfByte.length != 8))
                                {
                                  if (!QLog.isColorLevel()) {
                                    break;
                                  }
                                  QLog.e("QQGAudioCtrl", 2, "eventId = " + m + ", p.detail buf length incorrect ");
                                }
                                for (l1 = 0L;; l1 = this.a.getLongFromByte(((jiq)localObject).jdField_a_of_type_ArrayOfByte))
                                {
                                  label1873:
                                  if (QLog.isColorLevel()) {
                                    QLog.e("QQGAudioCtrl", 2, "SetMicByAdmin : uin = " + l1 + ", isMicOff = " + bool);
                                  }
                                  this.a.mVideoController.a(l1, bool);
                                  break;
                                }
                                i = (int)l3;
                                if ((((jiq)localObject).jdField_a_of_type_ArrayOfByte == null) || (((jiq)localObject).jdField_a_of_type_ArrayOfByte.length != i << 4))
                                {
                                  if (QLog.isColorLevel()) {
                                    QLog.e("QQGAudioCtrl", 2, "eventId = " + m + ", p.detail buf length incorrect ");
                                  }
                                }
                                else
                                {
                                  paramMessage = QQGAudioCtrl.access$100(this.a, ((jiq)localObject).jdField_a_of_type_ArrayOfByte, 16);
                                  if ((paramMessage != null) && (paramMessage.size() == i))
                                  {
                                    this.a.mVideoController.a(i, paramMessage);
                                    continue;
                                    if ((((jiq)localObject).jdField_a_of_type_ArrayOfByte == null) || (((jiq)localObject).jdField_a_of_type_ArrayOfByte.length != 16))
                                    {
                                      if (QLog.isColorLevel()) {
                                        QLog.e("QQGAudioCtrl", 2, "eventId = " + m + ", p.detail buf length incorrect ");
                                      }
                                    }
                                    else
                                    {
                                      l1 = this.a.getLongFromByte(((jiq)localObject).jdField_a_of_type_ArrayOfByte);
                                      paramMessage = new byte[4];
                                      System.arraycopy(((jiq)localObject).jdField_a_of_type_ArrayOfByte, 12, paramMessage, 0, 4);
                                      i = QQGAudioCtrl.access$200(this.a, paramMessage);
                                      if (l3 != 1L) {
                                        break label4052;
                                      }
                                      bool = true;
                                      label2164:
                                      if (QLog.isColorLevel()) {
                                        QLog.e("QQGAudioCtrl", 2, "onGAudioUserAudioSuspectNoisy : uin = " + l1 + ", isSuspectNoisy = " + bool + ",validDuration = " + i);
                                      }
                                      this.a.mVideoController.a(l1, bool, i);
                                      continue;
                                      if (QLog.isColorLevel()) {
                                        QLog.d("QQGAudioCtrl", 2, "EV_GA_SDK_Creat_SUC.");
                                      }
                                      this.a.mVideoController.d(k, l1);
                                      this.a.mVideoController.f = 0;
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
    paramMessage = QQGAudioCtrl.access$000(this.a, paramMessage);
    if (k != 2) {
      if (k == 1) {
        break label4058;
      }
    }
    for (;;)
    {
      label2304:
      this.a.onRecvUserList(6, k, l1, paramMessage, l3, j, n, i);
      break;
      label3276:
      label3963:
      do
      {
        i = paramMessage.length;
        break label2304;
        if (k == 3)
        {
          this.a.onRecvDoubleVideoMeeting(m, k, l3);
          break;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.e("QQGAudioCtrl", 2, "OnRecvMultiVideoInvite-->RelationType is null; relationType=" + k);
        break;
        this.a.mVideoController.a(k, l1, new int[] { j });
        break;
        this.a.mVideoController.c(k, l1);
        break;
        this.a.mVideoController.a(k, l1, 17, (int)((jiq)localObject).jdField_a_of_type_Long);
        break;
        this.a.mVideoController.a(k, l1, 16, (int)((jiq)localObject).jdField_a_of_type_Long);
        break;
        this.a.mVideoController.a(k, l1, 15, (int)((jiq)localObject).jdField_a_of_type_Long);
        break;
        paramMessage = QQGAudioCtrl.access$000(this.a, paramMessage);
        if (paramMessage == null) {}
        for (i = 0;; i = paramMessage.length)
        {
          this.a.onRecvUserList(44, k, l1, paramMessage, 0L, j, 0, i);
          break;
        }
        this.a.mVideoController.a(l1, k, j);
        break;
        if (QLog.isColorLevel()) {
          QLog.d("QQGAudioCtrl", 2, "EM_SDK_EVENT_ID_GET_ROOM_INFO");
        }
        paramMessage = QQGAudioCtrl.access$100(this.a, paramMessage, 16);
        if (paramMessage != null)
        {
          i = (int)l3;
          this.a.onRecvUserList(44, k, l1, paramMessage, 0L, 0, j, i);
          break;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("QQGAudioCtrl", 2, "infoList is null");
        break;
        this.a.mVideoController.d(l1, k, j);
        break;
        this.a.mVideoController.b(61, l3, k);
        break;
        this.a.mVideoController.a(m, l3, l1, k);
        break;
        this.a.mVideoController.b(m, l3, l1, k);
        break;
        this.a.mVideoController.c(m, l3, l1, k);
        break;
        this.a.mVideoController.i(3);
        break;
        this.a.mVideoController.i(4);
        break;
        i = (int)((jiq)localObject).jdField_a_of_type_Long;
        if (QLog.isColorLevel()) {
          QLog.i("QQGAudioCtrl", 2, "SharpConfigPayload. multi version = " + i);
        }
        BaseApplicationImpl.getContext().sendBroadcast(new Intent("com.tencent.av.ui.ConfigInfoTips.ACTION_IS_GETTED_SHARP_CONFIG_PAYLOAD").putExtra("version", i));
        TraeConfigUpdate.a().a("load", i);
        break;
        this.a.mVideoController.a(m, l1, null);
        break;
        this.a.mVideoController.a(m, l1, null);
        break;
        this.a.mVideoController.a(m, l1, null);
        break;
        this.a.mVideoController.a(m, l1, null);
        break;
        this.a.mVideoController.a(m, l1, null);
        break;
        this.a.mVideoController.a(m, l1, null);
        break;
        this.a.mVideoController.a(m, l1, null);
        break;
        if ((paramMessage == null) || (paramMessage.length == 0)) {
          break;
        }
        paramMessage = new String(paramMessage);
        paramMessage = QQGAudioCtrl.access$300(this.a, paramMessage);
        this.a.mVideoController.a(m, l1, paramMessage);
        break;
        this.a.mVideoController.D();
        break;
        paramMessage = AVInviteAccount.a(paramMessage, i);
        this.a.mVideoController.d(paramMessage);
        break;
        paramMessage = AVInvitePSTNPhone.a(paramMessage, i);
        this.a.mVideoController.e(paramMessage);
        break;
        this.a.mVideoController.E();
        break;
        this.a.mVideoController.F();
        break;
        paramMessage = AVInviteAccount.a(paramMessage, i);
        this.a.mVideoController.f(paramMessage);
        break;
        this.a.mVideoController.G();
        break;
        this.a.mVideoController.a(m, l1, null);
        break;
        this.a.mVideoController.a(m, l1, null);
        break;
        this.a.mVideoController.I();
        break;
        this.a.mVideoController.J();
        break;
        if (paramMessage == null) {
          break;
        }
        this.a.mVideoController.d(this.a.getLongFromByte(paramMessage));
        break;
        if (l3 == 0L) {
          break;
        }
        i = (int)l3;
        if (QLog.isColorLevel()) {
          QLog.e("QQGAudioCtrl", 2, "EM_SDK_EVENT_ID_CAMERAQOS_FPS_CHANGE, nFps=" + i);
        }
        this.a.mVideoController.j(i);
        break;
        l1 = 0L;
        break label1873;
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
        case 80: 
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
        case 138: 
        case 139: 
        case 140: 
        case 141: 
        case 142: 
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
        case 129: 
        case 130: 
        case 131: 
        case 132: 
        case 133: 
        case 134: 
        case 135: 
        case 136: 
        case 137: 
        case 19: 
        case 20: 
        case 24: 
        case 21: 
        case 22: 
        case 23: 
        case 146: 
        case 147: 
        case 148: 
        case 153: 
        case 158: 
        case 157: 
        case 171: 
        default: 
          break label271;
          bool = false;
          break;
          bool = false;
          break label647;
          bool = false;
          break label925;
          bool = false;
          break label1144;
          if (l3 == 3L) {
            break label1448;
          }
          if (l3 != 15L) {
            break label1465;
          }
          break label1448;
          bool = false;
          break label1573;
          if (l3 == 0L)
          {
            bool = false;
            break label1738;
          }
          bool = true;
          break;
        case 143: 
          if (l3 == 0L)
          {
            bool = false;
            break label1814;
          }
          bool = true;
          break label1814;
          bool = false;
          break label2164;
        }
      } while (paramMessage != null);
      label3969:
      label3975:
      label3981:
      label3987:
      label4008:
      label4014:
      label4052:
      label4058:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jip
 * JD-Core Version:    0.7.0.1
 */