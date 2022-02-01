import android.content.Intent;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.text.TextUtils;
import com.tencent.av.service.QQServiceForAV;
import com.tencent.av.service.RecvGVideoLevelInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import tencent.im.oidb.cmd0x899.oidb_0x899.memberlist;

public class lxp
  extends aofu
{
  public lxp(QQServiceForAV paramQQServiceForAV) {}
  
  protected void onGetFollowStatus(boolean paramBoolean1, String paramString, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("nearby.video.follow", 2, "QQServiceForAV, onGetFollowStatus:" + paramBoolean1 + "," + paramString + "," + paramBoolean2);
    }
    synchronized (this.a.jdField_a_of_type_AndroidOsRemoteCallbackList)
    {
      int j = this.a.jdField_a_of_type_AndroidOsRemoteCallbackList.beginBroadcast();
      int i = 0;
      if (i < j)
      {
        if (paramBoolean2) {}
        for (String str = "1";; str = "2") {
          try
          {
            ((lwv)this.a.jdField_a_of_type_AndroidOsRemoteCallbackList.getBroadcastItem(i)).a(paramBoolean1, paramString, str, "getFollowStatus");
            i += 1;
          }
          catch (RemoteException paramString)
          {
            if (!QLog.isColorLevel()) {
              break label168;
            }
            QLog.e("nearby.video.follow", 2, "QQServiceForAV, onGetFollowStatus:" + paramString.toString());
          }
        }
      }
      label168:
      this.a.jdField_a_of_type_AndroidOsRemoteCallbackList.finishBroadcast();
      return;
    }
  }
  
  protected void onGetTroopHideWebConfig(boolean paramBoolean, String paramString1, int paramInt1, String paramString2, int paramInt2, int paramInt3, String paramString3, String paramString4, int paramInt4, int paramInt5, long paramLong)
  {
    paramString3 = (QQAppInterface)this.a.a();
    if (paramBoolean)
    {
      paramString4 = new Intent();
      paramString4.setAction("tencent.video.v2q.hide.webConfig");
      paramString4.putExtra("troopUin", paramString1);
      paramString4.putExtra("color", paramInt1);
      paramString4.putExtra("url", paramString2);
      paramString4.putExtra("grayFlag", paramInt2);
      paramString3.getApp().sendBroadcast(paramString4);
    }
    paramString3.removeObserver(this.a.jdField_a_of_type_Aofu);
  }
  
  protected void onJoinOrExitOpenTroop(boolean paramBoolean1, String paramString, int paramInt1, boolean paramBoolean2, boolean paramBoolean3, int paramInt2, int paramInt3)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)this.a.a();
    String str = localQQAppInterface.getApp().getString(paramInt1);
    if (QLog.isColorLevel()) {
      QLog.d("QQServiceForAV", 2, String.format("onJoinOrExitOpenTroop --> success: %b, troopUin: %s, errorTips: %s isJoin: %b , visitorSpeakEnabled: %b, speakInterval: %d, startSpeakInterval: %d", new Object[] { Boolean.valueOf(paramBoolean1), paramString, str, Boolean.valueOf(paramBoolean2), Boolean.valueOf(paramBoolean3), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) }));
    }
    if (paramBoolean2)
    {
      Intent localIntent = new Intent();
      localIntent.setAction("tencent.video.q2v.JoinOpenGroup");
      localIntent.putExtra("troopUin", paramString);
      localIntent.putExtra("success", paramBoolean1);
      localIntent.putExtra("errorTips", str);
      localIntent.putExtra("visitorSpeakEnabled", paramBoolean3);
      localIntent.putExtra("speakInterval", paramInt2);
      localIntent.putExtra("startSpeakInterval", paramInt3);
      localQQAppInterface.getApp().sendBroadcast(localIntent);
    }
    localQQAppInterface.removeObserver(this.a.jdField_a_of_type_Aofu);
  }
  
  protected void onOIDB0X899_0_Ret(boolean paramBoolean, long paramLong1, int paramInt1, List<oidb_0x899.memberlist> paramList, long paramLong2, int paramInt2, String paramString)
  {
    QLog.w("QQServiceForAV", 1, "onOIDB0X899_0_Ret, isSuccess[" + paramBoolean + "], troopuin[" + paramLong1 + "], nFlag[" + paramInt1 + "], lStartUin[" + paramLong2 + "], result[" + paramInt2 + "], strErrorMsg[" + paramString + "]");
    paramString = (QQAppInterface)this.a.a();
    if ((paramBoolean) && (paramInt1 == 2))
    {
      if (TextUtils.isEmpty(this.a.c)) {
        this.a.c = paramString.getCurrentAccountUin();
      }
      paramLong2 = Long.valueOf(this.a.c).longValue();
      label152:
      oidb_0x899.memberlist localmemberlist;
      if (paramList == null)
      {
        paramInt1 = 0;
        paramInt2 = 0;
        if (paramInt2 >= paramInt1) {
          break label237;
        }
        localmemberlist = (oidb_0x899.memberlist)paramList.get(paramInt2);
        if ((localmemberlist != null) && (localmemberlist.uint64_member_uin.has())) {
          break label210;
        }
      }
      for (;;)
      {
        paramInt2 += 1;
        break label152;
        paramInt1 = paramList.size();
        break;
        label210:
        if (localmemberlist.uint64_member_uin.get() == paramLong2) {
          this.a.a(paramLong1, paramLong2);
        }
      }
      label237:
      paramList = paramString;
      if (paramString == null) {
        paramList = (QQAppInterface)this.a.a();
      }
      paramList.removeObserver(this.a.jdField_a_of_type_Aofu);
    }
  }
  
  protected void onReceiveGVideoLevelInfo(RecvGVideoLevelInfo[] paramArrayOfRecvGVideoLevelInfo)
  {
    synchronized (this.a.jdField_a_of_type_AndroidOsRemoteCallbackList)
    {
      int j = this.a.jdField_a_of_type_AndroidOsRemoteCallbackList.beginBroadcast();
      int i = 0;
      for (;;)
      {
        if (i < j) {
          try
          {
            ((lwv)this.a.jdField_a_of_type_AndroidOsRemoteCallbackList.getBroadcastItem(i)).a(paramArrayOfRecvGVideoLevelInfo);
            i += 1;
          }
          catch (RemoteException paramArrayOfRecvGVideoLevelInfo)
          {
            if (QLog.isColorLevel()) {
              QLog.d("QQServiceForAV", 2, "callBack RemoteException", paramArrayOfRecvGVideoLevelInfo);
            }
          }
        }
      }
      this.a.jdField_a_of_type_AndroidOsRemoteCallbackList.finishBroadcast();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     lxp
 * JD-Core Version:    0.7.0.1
 */