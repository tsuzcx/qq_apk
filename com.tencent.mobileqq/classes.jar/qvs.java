import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.GroupManagerActivity;

class qvs
  implements View.OnClickListener
{
  qvs(qvp paramqvp) {}
  
  public void onClick(View paramView)
  {
    GroupManagerActivity.a((Activity)this.a.a);
    azqs.b(qvp.a(this.a), "CliOper", "", "", "category", "Edit_category", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     qvs
 * JD-Core Version:    0.7.0.1
 */