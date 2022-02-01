import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.EditText;
import com.tencent.biz.pubaccount.readinjoy.ugc.selectmember.ReadInJoySelectMemberFragment;

public class sba
  implements View.OnKeyListener
{
  public sba(ReadInJoySelectMemberFragment paramReadInJoySelectMemberFragment) {}
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 67) && (paramKeyEvent.getAction() == 0) && (TextUtils.isEmpty(ReadInJoySelectMemberFragment.a(this.a).getText()))) {
      ReadInJoySelectMemberFragment.a(this.a).a();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sba
 * JD-Core Version:    0.7.0.1
 */