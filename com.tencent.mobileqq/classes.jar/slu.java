import android.util.Pair;
import android.widget.Toast;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.util.WeakReferenceHandler;

public class slu
  extends CardObserver
{
  public slu(FriendProfileCardActivity paramFriendProfileCardActivity) {}
  
  public void e(boolean paramBoolean, Object paramObject)
  {
    for (;;)
    {
      try
      {
        if (this.a.isFinishing()) {
          break;
        }
        this.a.jdField_b_of_type_ComTencentUtilWeakReferenceHandler.removeCallbacks(this.a.jdField_b_of_type_JavaLangRunnable);
        this.a.H();
        if ((!paramBoolean) || (paramObject == null)) {
          break;
        }
        if ((paramObject instanceof Card))
        {
          ThreadManager.post(new slv(this, (Card)paramObject), 5, null, true);
          return;
        }
        if (!(paramObject instanceof Pair)) {
          break;
        }
        paramObject = (Pair)paramObject;
        if (((Integer)paramObject.first).intValue() == 101107)
        {
          this.a.f = 1;
          this.a.K();
          return;
        }
      }
      catch (Exception paramObject)
      {
        paramObject.printStackTrace();
        return;
      }
      if (((Integer)paramObject.first).intValue() == 101108)
      {
        this.a.f = 2;
      }
      else
      {
        if ((((Integer)paramObject.first).intValue() >= 400000) && (((Integer)paramObject.first).intValue() <= 499999))
        {
          Toast.makeText(this.a.getApplicationContext(), (CharSequence)paramObject.second, 0).show();
          return;
        }
        Toast.makeText(this.a.getApplicationContext(), 2131436727, 0).show();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     slu
 * JD-Core Version:    0.7.0.1
 */