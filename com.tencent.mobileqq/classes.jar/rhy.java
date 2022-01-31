import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.AddFriendActivity;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class rhy
  extends TroopObserver
{
  public rhy(AddFriendActivity paramAddFriendActivity) {}
  
  protected void a(boolean paramBoolean1, byte paramByte, TroopInfo paramTroopInfo, boolean paramBoolean2)
  {
    this.a.removeObserver(this.a.a);
    if ((paramBoolean1) && (paramByte == 0) && (paramTroopInfo != null) && (Utils.a(paramTroopInfo.troopuin, this.a.b)))
    {
      if (SearchUtils.a(paramTroopInfo.troopowneruin))
      {
        Message localMessage = Message.obtain();
        localMessage.what = 3;
        if (paramBoolean2) {}
        for (paramByte = 1;; paramByte = 0)
        {
          localMessage.arg1 = paramByte;
          localMessage.obj = paramTroopInfo;
          AddFriendActivity.a(this.a).sendMessageDelayed(localMessage, 300L);
          return;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("AddFriendActivity", 2, "TroopObserver.onTroopSearch: troopUin=" + this.a.b + " 是异常号，群主uin = " + paramTroopInfo.troopowneruin);
      }
      AddFriendActivity.a(this.a);
      this.a.a(2131434954);
      return;
    }
    AddFriendActivity.a(this.a);
    if (!paramBoolean1)
    {
      if (!NetworkUtil.d(BaseApplication.getContext()))
      {
        this.a.a(2131434445);
        return;
      }
      this.a.a(2131434449);
      return;
    }
    if (paramByte == 2)
    {
      this.a.a(2131434954);
      return;
    }
    if (paramByte == 3)
    {
      this.a.a(2131434955);
      return;
    }
    if (paramByte == 4)
    {
      this.a.a(2131434956);
      return;
    }
    this.a.a(2131434954);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rhy
 * JD-Core Version:    0.7.0.1
 */