import android.support.v4.app.FragmentActivity;
import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.biz.pubaccount.readinjoy.ugc.editvideo.EditVideoFragment;

public class ret
  implements TextWatcher
{
  public ret(EditVideoFragment paramEditVideoFragment) {}
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    int j = 1;
    EditVideoFragment.a(this.a);
    int i;
    if ((this.a.getActivity() != null) && (this.a.getActivity().isResume()))
    {
      i = 1;
      if ((paramInt3 != 1) || (paramInt2 != 0)) {
        break label99;
      }
    }
    label99:
    for (paramInt2 = j;; paramInt2 = 0)
    {
      if ((rct.b()) && (i != 0) && (paramInt2 != 0) && (paramCharSequence.toString().substring(paramInt1, paramInt1 + 1).equals("#"))) {
        EditVideoFragment.b(this.a);
      }
      return;
      i = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ret
 * JD-Core Version:    0.7.0.1
 */