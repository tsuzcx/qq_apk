import com.tencent.biz.pubaccount.readinjoy.view.headers.ReadInJoyDiandianHeaderController;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.widget.HorizontalListView.OnScrollStateChangedListener;

public class sxj
  implements HorizontalListView.OnScrollStateChangedListener
{
  public sxj(ReadInJoyDiandianHeaderController paramReadInJoyDiandianHeaderController) {}
  
  public void onScrollStateChanged(int paramInt)
  {
    if ((ReadInJoyDiandianHeaderController.b(this.a)) && (paramInt == 4097)) {
      odq.a(null, "", "0X8009BA4", "0X8009BA4", 0, 0, ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getCurrentAccountUin(), "", "", "", false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sxj
 * JD-Core Version:    0.7.0.1
 */