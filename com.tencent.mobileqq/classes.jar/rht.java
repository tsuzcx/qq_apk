import com.tencent.mobileqq.activity.AgeSelectionActivity;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.PickerViewAdapter;
import java.util.Calendar;

public class rht
  implements IphonePickerView.PickerViewAdapter
{
  private rht(AgeSelectionActivity paramAgeSelectionActivity) {}
  
  public int getColumnCount()
  {
    return 3;
  }
  
  public int getRowCount(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 0;
    case 0: 
      return AgeSelectionActivity.a(this.a) - 1897 + 1;
    case 1: 
      return 12;
    }
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.set(1, AgeSelectionActivity.b(this.a) + 1897);
    localCalendar.set(2, AgeSelectionActivity.c(this.a));
    localCalendar.set(5, 1);
    return localCalendar.getActualMaximum(5);
  }
  
  public String getText(int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    default: 
      return "";
    case 0: 
      return paramInt2 + 1897 + "年";
    case 1: 
      return paramInt2 + 1 + "月";
    }
    return paramInt2 + 1 + "日";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rht
 * JD-Core Version:    0.7.0.1
 */