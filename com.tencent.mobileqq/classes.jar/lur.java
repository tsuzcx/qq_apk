import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.model.IReadInJoyModel;
import com.tencent.biz.pubaccount.readinjoy.rebuild.FeedItemCellTypeUgcPlainSocial;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;

public class lur
  implements View.OnClickListener
{
  public lur(FeedItemCellTypeUgcPlainSocial paramFeedItemCellTypeUgcPlainSocial) {}
  
  public void onClick(View paramView)
  {
    ReadInJoyUtils.a(this.a.jdField_a_of_type_AndroidContentContext, ((IReadInJoyModel)this.a.jdField_a_of_type_JavaLangObject).a(), 2, false, 2, false);
    ReadInJoyBaseAdapter.a(((IReadInJoyModel)this.a.jdField_a_of_type_JavaLangObject).a(), ((IReadInJoyModel)this.a.jdField_a_of_type_JavaLangObject).e());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lur
 * JD-Core Version:    0.7.0.1
 */