import com.tencent.mobileqq.activity.AddRequestActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.QLog;
import java.util.Locale;

public class rhc
  extends CardObserver
{
  public rhc(AddRequestActivity paramAddRequestActivity) {}
  
  protected void a(boolean paramBoolean, String paramString)
  {
    if (!this.a.a.equals(paramString)) {
      return;
    }
    if (paramBoolean)
    {
      this.a.a(2130838746, this.a.getString(2131433453));
      return;
    }
    this.a.a(2130838735, this.a.getString(2131433452));
  }
  
  protected void b(boolean paramBoolean, Object paramObject)
  {
    if ((ProfileActivity.e(AddRequestActivity.a(this.a))) && (paramBoolean) && ((paramObject instanceof Card)))
    {
      paramObject = (Card)paramObject;
      if (Utils.a(paramObject.uin, this.a.a)) {
        this.a.a(paramObject.strCampusName);
      }
      if (QLog.isDevelopLevel()) {
        QLog.i("Q.systemmsg.AddRequestActivity", 4, String.format(Locale.getDefault(), "onGetCampusInfo [%s, %s]", new Object[] { Utils.b(paramObject.uin), Utils.b(paramObject.strCampusName) }));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rhc
 * JD-Core Version:    0.7.0.1
 */