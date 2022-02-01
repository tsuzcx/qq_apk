import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter.29.1;
import com.tencent.mobileqq.app.ThreadManager;

public class sfh
  implements sga
{
  sfh(sel paramsel) {}
  
  public void onClick(View paramView)
  {
    pmz localpmz = (pmz)paramView.getTag();
    BaseArticleInfo localBaseArticleInfo = this.a.b(localpmz.jdField_a_of_type_Int);
    if (localBaseArticleInfo == null) {
      return;
    }
    this.a.a(localpmz.jdField_a_of_type_Rwc, localBaseArticleInfo, true);
    ThreadManager.executeOnSubThread(new ReadInJoyBaseAdapter.29.1(this, localBaseArticleInfo));
    pms.a(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sfh
 * JD-Core Version:    0.7.0.1
 */