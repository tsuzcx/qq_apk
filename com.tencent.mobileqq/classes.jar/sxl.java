import com.tencent.mobileqq.activity.FriendProfileMoreInfoActivity;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.IphonePickListener;
import com.tencent.widget.ActionSheet;

public class sxl
  implements IphonePickerView.IphonePickListener
{
  public sxl(FriendProfileMoreInfoActivity paramFriendProfileMoreInfoActivity) {}
  
  public void onConfirmBtClicked()
  {
    if ((this.a.a != null) && (this.a.a.isShowing())) {
      this.a.a.dismiss();
    }
  }
  
  public void onItemSelected(int paramInt1, int paramInt2)
  {
    if (paramInt2 == 0) {}
    for (paramInt1 = 0;; paramInt1 = 1)
    {
      this.a.c = true;
      this.a.a(paramInt1, true);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     sxl
 * JD-Core Version:    0.7.0.1
 */