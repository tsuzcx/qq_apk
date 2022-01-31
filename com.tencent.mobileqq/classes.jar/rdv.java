import com.tencent.mobileqq.activity.AccountManageActivity;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.subaccount.SubAccountControll;
import com.tencent.mobileqq.subaccount.logic.SubAccountBackProtocData;
import com.tencent.util.Pair;
import java.util.ArrayList;

public class rdv
  extends MessageObserver
{
  public rdv(AccountManageActivity paramAccountManageActivity) {}
  
  public void a(boolean paramBoolean, String paramString, SubAccountBackProtocData paramSubAccountBackProtocData)
  {
    if (this.a.isFinishing()) {}
    SubAccountControll localSubAccountControll;
    do
    {
      for (;;)
      {
        return;
        AccountManageActivity.a(this.a, false);
        localSubAccountControll = (SubAccountControll)this.a.app.getManager(61);
        if (paramSubAccountBackProtocData.a != 1) {
          break;
        }
        if ((this.a.isResume()) && (SubAccountControll.a(this.a.app, "sub.uin.all")))
        {
          paramString = localSubAccountControll.a("sub.uin.all");
          int j = paramString.size();
          int i = 0;
          while (i < j)
          {
            paramSubAccountBackProtocData = (Pair)paramString.get(i);
            localSubAccountControll.a(this.a.app, this.a, paramSubAccountBackProtocData, new rdw(this, localSubAccountControll, paramSubAccountBackProtocData));
            i += 1;
          }
        }
      }
    } while (!this.a.isResume());
    localSubAccountControll.a(paramString, 1, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rdv
 * JD-Core Version:    0.7.0.1
 */