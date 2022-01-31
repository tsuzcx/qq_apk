import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.Leba;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.model.HotWordSearchEntryDataModel.HotSearchItem;

public class tbo
  implements View.OnFocusChangeListener
{
  public tbo(Leba paramLeba) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      paramView.clearFocus();
      UniteSearchActivity.a(this.a.a(), null, 21, 0L, (HotWordSearchEntryDataModel.HotSearchItem)Leba.a(this.a).getTag(), 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tbo
 * JD-Core Version:    0.7.0.1
 */