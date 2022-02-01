import android.view.View;
import com.dataline.activities.PrinterActivity;
import com.tencent.widget.ListView;
import com.tencent.widget.XListView;

public class ct
  implements bldp
{
  public ct(PrinterActivity paramPrinterActivity) {}
  
  public void onNotCompleteVisable(int paramInt, View paramView, ListView paramListView) {}
  
  public void onViewCompleteVisable(int paramInt, View paramView, ListView paramListView) {}
  
  public boolean onViewCompleteVisableAndReleased(int paramInt, View paramView, ListView paramListView)
  {
    paramInt = PrinterActivity.a(this.a).a.a();
    if (paramInt > 0)
    {
      PrinterActivity.a(this.a).a.a.b();
      this.a.a.setSelectionFromBottom(paramInt, 0);
      PrinterActivity.a(this.a).a.a.notifyDataSetChanged();
    }
    return false;
  }
  
  public void onViewNotCompleteVisableAndReleased(int paramInt, View paramView, ListView paramListView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ct
 * JD-Core Version:    0.7.0.1
 */