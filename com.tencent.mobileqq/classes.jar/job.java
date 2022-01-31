import android.app.Application;
import android.content.Intent;
import android.os.IBinder.DeathRecipient;
import android.os.RemoteException;
import android.text.TextUtils;
import com.tencent.av.AVLog;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.av.service.QQServiceForAV;
import com.tencent.av.utils.QAVNotification;
import com.tencent.av.utils.VideoMsgTools;
import com.tencent.mobileqq.app.QQAppInterface;

class job
  implements IBinder.DeathRecipient
{
  job(jnz paramjnz) {}
  
  public void binderDied()
  {
    AVLog.d("QQServiceForAV", "binderDied, video process died!");
    QQAppInterface localQQAppInterface = (QQAppInterface)this.a.a.a();
    if (localQQAppInterface != null) {
      localQQAppInterface.a = null;
    }
    try
    {
      this.a.a();
      if ((TextUtils.isEmpty(this.a.a.c)) && (localQQAppInterface != null)) {
        this.a.a.c = localQQAppInterface.getCurrentAccountUin();
      }
      str3 = this.a.a.jdField_b_of_type_JavaLangString;
      str4 = this.a.a.c;
      if ((this.a.a.jdField_a_of_type_Int == 1004) || (this.a.a.jdField_a_of_type_Int == 1000) || (this.a.a.jdField_a_of_type_Int == 1020))
      {
        str2 = this.a.a.d;
        Object localObject = str3;
        if ((localQQAppInterface != null) && (localQQAppInterface.c()))
        {
          AVLog.d("QQServiceForAV", "video chatting!");
          AVLog.d("QQServiceForAV", "linkToVideoProcessDeath-->uinType=" + this.a.a.jdField_a_of_type_Int + " friendUin=" + (String)localObject + " senderUin=" + str2);
          if ((localObject == null) || (((String)localObject).length() <= 2)) {
            break label915;
          }
          i = 1;
          if ((this.a.a.jdField_b_of_type_Boolean) && (i != 0)) {
            VideoMsgTools.a(localQQAppInterface, this.a.a.jdField_a_of_type_Int, 45, true, (String)localObject, str2, true, null, true, new Object[0]);
          }
        }
        localObject = new Intent();
        ((Intent)localObject).setAction("tencent.av.v2q.StopVideoChat");
        ((Intent)localObject).putExtra("uinType", this.a.a.jdField_a_of_type_Int);
        ((Intent)localObject).putExtra("bindType", this.a.a.jdField_b_of_type_Int);
        ((Intent)localObject).putExtra("bindId", this.a.a.jdField_a_of_type_JavaLangString);
        ((Intent)localObject).putExtra("peerUin", this.a.a.jdField_b_of_type_JavaLangString);
        ((Intent)localObject).putExtra("extraUin", this.a.a.d);
        ((Intent)localObject).putExtra("stopReason", 0);
        ((Intent)localObject).setPackage(this.a.a.getApplication().getPackageName());
        if ((this.a.a.jdField_b_of_type_JavaLangString != null) && ((this.a.a.jdField_a_of_type_Int != 1006) || (this.a.a.d != null)))
        {
          AVLog.d("QQServiceForAV", "ACTION_STOP_VIDEO_CHAT, stopReason = VideoConstants.CLOSE_DOUBLE, mUinType = " + this.a.a.jdField_a_of_type_Int + ", peerUin = " + this.a.a.jdField_b_of_type_JavaLangString);
          this.a.a.sendBroadcast((Intent)localObject);
        }
        if (localQQAppInterface != null)
        {
          long l1 = localQQAppInterface.a().b();
          i = localQQAppInterface.a().a();
          int j = (int)localQQAppInterface.a().a(i, l1);
          if ((l1 > 0L) && (this.a.a.jdField_b_of_type_Boolean))
          {
            long l2 = Long.valueOf(localQQAppInterface.getCurrentAccountUin()).longValue();
            localObject = new Intent();
            ((Intent)localObject).setAction("tencent.av.v2q.MultiVideo");
            ((Intent)localObject).putExtra("type", 23);
            ((Intent)localObject).putExtra("friendUin", l2);
            ((Intent)localObject).putExtra("relationType", i);
            ((Intent)localObject).putExtra("relationId", l1);
            ((Intent)localObject).putExtra("from", "QQServiceForAV");
            ((Intent)localObject).putExtra("MultiAVType", localQQAppInterface.a().b(l1));
            if (j <= 1) {
              break label920;
            }
            ((Intent)localObject).putExtra("roomUserNum", j - 1);
            ((Intent)localObject).setPackage(this.a.a.getApplication().getPackageName());
            AVLog.d("QQServiceForAV", "linkToVideoProcessDeath MULTI_VIDEO_V2Q -->uinType=" + this.a.a.jdField_a_of_type_Int + " roomNum=" + j);
            this.a.a.sendBroadcast((Intent)localObject);
          }
          this.a.a.jdField_b_of_type_Boolean = false;
          localQQAppInterface.a().a(0, 0);
        }
        QAVNotification.a(this.a.a.getApplicationContext());
        QQServiceForAV.jdField_a_of_type_AndroidOsIBinder = null;
      }
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        String str3;
        String str4;
        int i;
        localRemoteException.printStackTrace();
        AVLog.e("QQServiceForAV", "linkToDeath stopPumpMessage exception msg = " + localRemoteException.getMessage());
        continue;
        String str1 = str3;
        String str2 = str4;
        if (this.a.a.jdField_a_of_type_Int == 1006)
        {
          str1 = str3;
          str2 = str4;
          if (!str3.startsWith("+"))
          {
            str1 = this.a.a.d;
            str2 = str4;
            continue;
            label915:
            i = 0;
            continue;
            label920:
            str1.putExtra("roomUserNum", 0);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     job
 * JD-Core Version:    0.7.0.1
 */