import android.app.Application;
import android.content.Intent;
import android.os.IBinder.DeathRecipient;
import android.os.RemoteException;
import android.text.TextUtils;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.av.service.QQServiceForAV;
import com.tencent.av.utils.VideoMsgTools;
import com.tencent.mobileqq.app.QQAppInterface;
import java.io.Serializable;

class lxj
  implements IBinder.DeathRecipient
{
  lxj(lxh paramlxh) {}
  
  public void binderDied()
  {
    lba.g("QQServiceForAV", "binderDied, video process died!");
    QQAppInterface localQQAppInterface = (QQAppInterface)this.a.a.a();
    if (localQQAppInterface != null) {
      localQQAppInterface.mQQServiceRef = null;
    }
    try
    {
      this.a.a();
      if ((TextUtils.isEmpty(this.a.a.c)) && (localQQAppInterface != null)) {
        this.a.a.c = localQQAppInterface.getCurrentAccountUin();
      }
      str2 = this.a.a.jdField_b_of_type_JavaLangString;
      str3 = this.a.a.c;
      if ((this.a.a.jdField_a_of_type_Int == 1004) || (this.a.a.jdField_a_of_type_Int == 1000) || (this.a.a.jdField_a_of_type_Int == 1020))
      {
        localObject2 = this.a.a.d;
        Object localObject1 = str2;
        if ((localQQAppInterface != null) && (localQQAppInterface.isVideoChatting()))
        {
          lba.g("QQServiceForAV", "video chatting!");
          lba.g("QQServiceForAV", "linkToVideoProcessDeath-->uinType=" + this.a.a.jdField_a_of_type_Int + " friendUin=" + (String)localObject1 + " senderUin=" + (String)localObject2);
          if ((localObject1 == null) || (((String)localObject1).length() <= 2)) {
            break label1067;
          }
          i = 1;
          if ((this.a.a.jdField_b_of_type_Boolean) && (i != 0)) {
            VideoMsgTools.a(localQQAppInterface, this.a.a.jdField_a_of_type_Int, 45, true, (String)localObject1, (String)localObject2, true, null, true, new Object[0]);
          }
        }
        if (QQServiceForAV.a(this.a.a))
        {
          if (localQQAppInterface != null)
          {
            lcz.a("MobileQQ:BootAction", 5000L);
            localObject1 = new Intent("com.tencent.av.ui.VChatActivity");
            ((Intent)localObject1).putExtra("uin", localQQAppInterface.getCurrentUin());
            ((Intent)localObject1).putExtra("type", 1);
            ((Intent)localObject1).putExtra("processExitTimestamp", System.currentTimeMillis());
            ((Intent)localObject1).putExtra("source", 1);
            ((Intent)localObject1).setPackage(this.a.a.getPackageName());
            ((Intent)localObject1).setFlags(32);
            this.a.a.sendBroadcast((Intent)localObject1);
          }
          QQServiceForAV.a(this.a.a, false);
        }
        localObject2 = new Intent();
        ((Intent)localObject2).setAction("tencent.av.v2q.StopVideoChat");
        ((Intent)localObject2).putExtra("uinType", this.a.a.jdField_a_of_type_Int);
        ((Intent)localObject2).putExtra("bindType", this.a.a.jdField_b_of_type_Int);
        ((Intent)localObject2).putExtra("bindId", this.a.a.jdField_a_of_type_JavaLangString);
        ((Intent)localObject2).putExtra("peerUin", this.a.a.jdField_b_of_type_JavaLangString);
        ((Intent)localObject2).putExtra("extraUin", this.a.a.d);
        ((Intent)localObject2).putExtra("stopReason", 0);
        if (localQQAppInterface != null) {
          break label1072;
        }
        localObject1 = Integer.valueOf(0);
        ((Intent)localObject2).putExtra("selfUin", (Serializable)localObject1);
        ((Intent)localObject2).setPackage(this.a.a.getApplication().getPackageName());
        if ((this.a.a.jdField_b_of_type_JavaLangString != null) && ((this.a.a.jdField_a_of_type_Int != 1006) || (this.a.a.d != null)))
        {
          lba.g("QQServiceForAV", "ACTION_STOP_VIDEO_CHAT, stopReason = VideoConstants.CLOSE_DOUBLE, mUinType = " + this.a.a.jdField_a_of_type_Int + ", peerUin = " + this.a.a.jdField_b_of_type_JavaLangString);
          this.a.a.sendBroadcast((Intent)localObject2);
        }
        if (localQQAppInterface != null)
        {
          long l1 = localQQAppInterface.getAVNotifyCenter().b();
          i = localQQAppInterface.getAVNotifyCenter().a();
          int j = (int)localQQAppInterface.getAVNotifyCenter().a(i, l1);
          if ((l1 > 0L) && (this.a.a.jdField_b_of_type_Boolean))
          {
            long l2 = Long.valueOf(localQQAppInterface.getCurrentAccountUin()).longValue();
            localObject1 = new Intent();
            ((Intent)localObject1).setAction("tencent.av.v2q.MultiVideo");
            ((Intent)localObject1).putExtra("type", 23);
            ((Intent)localObject1).putExtra("friendUin", l2);
            ((Intent)localObject1).putExtra("relationType", i);
            ((Intent)localObject1).putExtra("relationId", l1);
            ((Intent)localObject1).putExtra("from", "QQServiceForAV");
            ((Intent)localObject1).putExtra("MultiAVType", localQQAppInterface.getAVNotifyCenter().b(l1));
            if (j <= 1) {
              break label1082;
            }
            ((Intent)localObject1).putExtra("roomUserNum", j - 1);
            ((Intent)localObject1).setPackage(this.a.a.getApplication().getPackageName());
            lba.g("QQServiceForAV", "linkToVideoProcessDeath MULTI_VIDEO_V2Q -->uinType=" + this.a.a.jdField_a_of_type_Int + " roomNum=" + j);
            this.a.a.sendBroadcast((Intent)localObject1);
          }
          this.a.a.jdField_b_of_type_Boolean = false;
          localQQAppInterface.getAVNotifyCenter().a(0, 0);
        }
        msw.a(this.a.a.getApplicationContext());
        QQServiceForAV.jdField_a_of_type_AndroidOsIBinder = null;
      }
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        String str2;
        String str3;
        int i;
        localRemoteException.printStackTrace();
        lba.h("QQServiceForAV", "linkToDeath stopPumpMessage exception msg = " + localRemoteException.getMessage());
        continue;
        String str1 = str2;
        Object localObject2 = str3;
        if (this.a.a.jdField_a_of_type_Int == 1006)
        {
          str1 = str2;
          localObject2 = str3;
          if (!str2.startsWith("+"))
          {
            str1 = this.a.a.d;
            localObject2 = str3;
            continue;
            label1067:
            i = 0;
            continue;
            label1072:
            str1 = localQQAppInterface.getCurrentUin();
            continue;
            label1082:
            str1.putExtra("roomUserNum", 0);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lxj
 * JD-Core Version:    0.7.0.1
 */