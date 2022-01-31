import com.tencent.mobileqq.activity.FriendProfileMoreInfoActivity;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.PickerViewAdapter;

public class spq
  implements IphonePickerView.PickerViewAdapter
{
  public spq(FriendProfileMoreInfoActivity paramFriendProfileMoreInfoActivity) {}
  
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
      return this.a.getString(2131433924);
    }
    return this.a.getString(2131433925);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     spq
 * JD-Core Version:    0.7.0.1
 */