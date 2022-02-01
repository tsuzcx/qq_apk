import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter.29.1;
import com.tencent.mobileqq.app.ThreadManager;

public class sod
  implements sow
{
  sod(snh paramsnh) {}
  
  public void onClick(View paramView)
  {
    pum localpum = (pum)paramView.getTag();
    BaseArticleInfo localBaseArticleInfo = this.a.b(localpum.jdField_a_of_type_Int);
    if (localBaseArticleInfo == null) {
      return;
    }
    this.a.a(localpum.jdField_a_of_type_Sey, localBaseArticleInfo, true);
    ThreadManager.executeOnSubThread(new ReadInJoyBaseAdapter.29.1(this, localBaseArticleInfo));
    puf.a(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sod
 * JD-Core Version:    0.7.0.1
 */