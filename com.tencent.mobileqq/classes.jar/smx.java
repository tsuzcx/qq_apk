import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyListViewGroup;
import com.tencent.qphone.base.util.QLog;

public class smx
  extends pkt
{
  public smx(ReadInJoyListViewGroup paramReadInJoyListViewGroup) {}
  
  public void c(String paramString)
  {
    boolean bool = bcoo.a();
    if (bool) {
      this.a.a.b(true, 3, false);
    }
    QLog.d("ReadInJoyListViewGroup", 1, "onRefreshArticles! isLearnModelNow=" + bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     smx
 * JD-Core Version:    0.7.0.1
 */