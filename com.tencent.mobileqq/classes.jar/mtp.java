import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyObserver;
import com.tencent.biz.pubaccount.readinjoy.view.headers.ReadInJoyDiandianHeaderController;
import com.tencent.biz.pubaccount.readinjoy.view.headers.ReadInJoyDiandianHeaderController.HeaderListAdapter;
import com.tencent.widget.ListView;
import java.util.List;

public class mtp
  extends ReadInJoyObserver
{
  public mtp(ReadInJoyDiandianHeaderController paramReadInJoyDiandianHeaderController) {}
  
  public void c(boolean paramBoolean, List paramList)
  {
    if ((!paramBoolean) || (paramList == null) || (paramList.size() == 0))
    {
      ReadInJoyDiandianHeaderController.a(this.a).removeHeaderView(ReadInJoyDiandianHeaderController.a(this.a));
      return;
    }
    if (ReadInJoyDiandianHeaderController.a(this.a).findHeaderViewPosition(ReadInJoyDiandianHeaderController.a(this.a)) < 0) {
      ReadInJoyDiandianHeaderController.a(this.a).addHeaderView(ReadInJoyDiandianHeaderController.a(this.a));
    }
    ReadInJoyDiandianHeaderController.a(this.a, false);
    ReadInJoyDiandianHeaderController.a(this.a).clear();
    ReadInJoyDiandianHeaderController.a(this.a).addAll(paramList);
    ReadInJoyDiandianHeaderController.a(this.a).notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mtp
 * JD-Core Version:    0.7.0.1
 */