import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyListViewGroup;
import com.tencent.qphone.base.util.QLog;

public class srn
  extends pmn
{
  public srn(ReadInJoyListViewGroup paramReadInJoyListViewGroup) {}
  
  public void b(String paramString)
  {
    boolean bool = bdch.a();
    if (bool) {
      ReadInJoyListViewGroup.b(this.a, true, 3, false);
    }
    QLog.d("ReadInJoyListViewGroup", 1, "onRefreshArticles! isLearnModelNow=" + bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     srn
 * JD-Core Version:    0.7.0.1
 */