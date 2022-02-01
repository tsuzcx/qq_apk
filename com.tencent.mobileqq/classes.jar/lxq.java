import android.content.Intent;
import com.tencent.av.service.QQServiceForAV;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class lxq
  extends anvi
{
  public lxq(QQServiceForAV paramQQServiceForAV) {}
  
  protected void onUpdateCustomHead(boolean paramBoolean, String paramString)
  {
    Intent localIntent = new Intent("com.tencent.qqhead.getheadresp2");
    localIntent.putExtra("uin", paramString);
    QQAppInterface localQQAppInterface = (QQAppInterface)this.a.a();
    if (this.a.b.contains(paramString)) {
      localQQAppInterface.getApp().sendBroadcast(localIntent);
    }
    this.a.b.remove(paramString);
    if (this.a.b()) {
      localQQAppInterface.removeObserver(this.a.jdField_a_of_type_Anvi);
    }
  }
  
  protected void onUpdateFriendInfo(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("QQServiceForAV", 2, "onUpdateFriendInfo uin = " + paramString);
      QLog.d("QQServiceForAV", 2, "onUpdateFriendInfo isSuccess = " + paramBoolean);
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)this.a.a();
    Intent localIntent;
    if ((paramBoolean) && (paramString != null))
    {
      localIntent = new Intent();
      localIntent.setAction("tencent.video.q2v.ACTION_ON_UPDATE_FRIEND_INFO");
      localIntent.putExtra("uin", paramString);
      localObject = (anvk)QQServiceForAV.m(this.a).getManager(QQManagerFactory.FRIENDS_MANAGER);
      if (localObject == null) {
        break label206;
      }
      localObject = ((anvk)localObject).e(paramString);
      if (localObject == null) {
        break label206;
      }
    }
    label206:
    for (Object localObject = ContactUtils.getFriendName((Friends)localObject);; localObject = paramString)
    {
      localIntent.putExtra("nick", (String)localObject);
      localIntent.setPackage(localQQAppInterface.getApplication().getPackageName());
      localQQAppInterface.getApp().sendBroadcast(localIntent);
      this.a.jdField_a_of_type_JavaUtilArrayList.remove(paramString);
      if (this.a.b()) {
        localQQAppInterface.removeObserver(this.a.jdField_a_of_type_Anvi);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     lxq
 * JD-Core Version:    0.7.0.1
 */