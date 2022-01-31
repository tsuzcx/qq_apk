import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.biz.pubaccount.readinjoy.ugc.selectmember.ReadInJoySelectMemberFragment;
import com.tencent.biz.pubaccount.readinjoy.ugc.selectmember.search.HybridSearchFragment;

public class qhj
  implements TextWatcher
{
  public qhj(ReadInJoySelectMemberFragment paramReadInJoySelectMemberFragment) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (paramEditable.length() > 0)
    {
      if (!ReadInJoySelectMemberFragment.a(this.a).isVisible()) {
        this.a.getChildFragmentManager().beginTransaction().add(2131366671, ReadInJoySelectMemberFragment.a(this.a)).addToBackStack(null).commit();
      }
      ReadInJoySelectMemberFragment.a(this.a).a(paramEditable.toString());
    }
    while (ReadInJoySelectMemberFragment.a(this.a).isDetached()) {
      return;
    }
    this.a.getChildFragmentManager().popBackStackImmediate();
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qhj
 * JD-Core Version:    0.7.0.1
 */