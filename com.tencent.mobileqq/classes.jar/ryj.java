import android.support.v4.app.FragmentActivity;
import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.biz.pubaccount.readinjoy.ugc.editvideo.EditVideoFragment;

public class ryj
  implements TextWatcher
{
  public ryj(EditVideoFragment paramEditVideoFragment) {}
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = 1;
    EditVideoFragment.a(this.a);
    if ((this.a.getActivity() != null) && (this.a.getActivity().isResume()))
    {
      paramInt2 = 1;
      if (paramInt3 != 1) {
        break label118;
      }
    }
    label118:
    for (paramInt3 = i;; paramInt3 = 0)
    {
      if ((paramInt2 != 0) && (paramInt3 != 0))
      {
        paramCharSequence = paramCharSequence.toString().substring(paramInt1, paramInt1 + 1);
        if ((rwg.b()) && (paramCharSequence.equals("#"))) {
          EditVideoFragment.b(this.a);
        }
        if ((rwg.c()) && (paramCharSequence.equals("@"))) {
          this.a.d();
        }
      }
      return;
      paramInt2 = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ryj
 * JD-Core Version:    0.7.0.1
 */