import com.tencent.mobileqq.activity.AgeSelectionActivity;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.IphonePickListener;
import com.tencent.widget.ActionSheet;

public class rkp
  implements IphonePickerView.IphonePickListener
{
  public rkp(AgeSelectionActivity paramAgeSelectionActivity) {}
  
  public void onConfirmBtClicked()
  {
    if ((AgeSelectionActivity.a(this.a) != null) && (AgeSelectionActivity.a(this.a).isShowing())) {
      AgeSelectionActivity.a(this.a).dismiss();
    }
  }
  
  public void onItemSelected(int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AgeSelectionActivity.a(this.a);
      if ((AgeSelectionActivity.a(this.a) != null) && ((paramInt1 == 0) || (paramInt1 == 1))) {
        AgeSelectionActivity.a(this.a).a(2);
      }
      return;
      AgeSelectionActivity.a(this.a, paramInt2);
      continue;
      AgeSelectionActivity.b(this.a, paramInt2);
      continue;
      AgeSelectionActivity.c(this.a, paramInt2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rkp
 * JD-Core Version:    0.7.0.1
 */