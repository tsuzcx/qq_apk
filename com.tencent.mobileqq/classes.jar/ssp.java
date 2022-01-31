import com.tencent.mobileqq.activity.FriendProfileMoreInfoActivity;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.PickerViewAdapter;

public class ssp
  implements IphonePickerView.PickerViewAdapter
{
  public ssp(FriendProfileMoreInfoActivity paramFriendProfileMoreInfoActivity) {}
  
  public int getColumnCount()
  {
    return 1;
  }
  
  public int getRowCount(int paramInt)
  {
    return 2;
  }
  
  public String getText(int paramInt1, int paramInt2)
  {
    if (paramInt2 == 0) {
      return this.a.getString(2131433941);
    }
    return this.a.getString(2131433942);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ssp
 * JD-Core Version:    0.7.0.1
 */