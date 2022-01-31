import com.tencent.mobileqq.activity.InterestSwitchEditActivity;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class svk
  extends CardObserver
{
  public svk(InterestSwitchEditActivity paramInterestSwitchEditActivity) {}
  
  protected void c(boolean paramBoolean, String paramString, Card paramCard)
  {
    if (paramBoolean)
    {
      if ((this.a.app.getCurrentAccountUin().equals(paramString)) && (paramCard != null) && (-1 != paramCard.switch_interest) && (-1 != paramCard.switch_music) && (-1 != paramCard.switch_recent_activity) && (-1 != paramCard.switch_star) && (-1 != paramCard.switch_joined_troop) && (-1 != paramCard.switch_ktv) && (-1 != paramCard.switch_eat) && (-1 != paramCard.switch_reader) && (-1 != paramCard.switch_radio) && (-1 != paramCard.switch_now) && (-1 != paramCard.switch_comic) && (-1 != paramCard.switch_education) && (-1 != paramCard.switch_using_tim) && (-1 != paramCard.switch_weishi))
      {
        InterestSwitchEditActivity.a(this.a, paramCard);
        InterestSwitchEditActivity.a(this.a);
      }
      while (!QLog.isColorLevel()) {
        return;
      }
      QLog.i("InterestSwitchEditActivity", 2, "suc but has invalidate value");
      return;
    }
    QQToast.a(this.a, "拉取开关信息失败", 0).b(this.a.getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     svk
 * JD-Core Version:    0.7.0.1
 */