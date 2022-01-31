import com.tencent.biz.pubaccount.subscript.SubscriptFeedsActivity;
import com.tencent.biz.pubaccount.subscript.SubscriptFeedsAdapter;
import com.tencent.biz.pubaccount.subscript.SubscriptRecommendController;
import com.tencent.widget.SwipListView;
import java.util.List;

class mwd
  implements Runnable
{
  mwd(mwc parammwc, List paramList) {}
  
  public void run()
  {
    int i;
    if (SubscriptFeedsActivity.a(this.jdField_a_of_type_Mwc.a) != null)
    {
      i = SubscriptFeedsActivity.a(this.jdField_a_of_type_Mwc.a).size();
      if (this.jdField_a_of_type_JavaUtilList == null) {
        break label142;
      }
    }
    label142:
    for (int j = this.jdField_a_of_type_JavaUtilList.size();; j = 0)
    {
      SubscriptFeedsActivity.a(this.jdField_a_of_type_Mwc.a, this.jdField_a_of_type_JavaUtilList);
      if ((SubscriptFeedsActivity.a(this.jdField_a_of_type_Mwc.a)) && (i != j))
      {
        if (this.jdField_a_of_type_Mwc.a.a.a == 2) {
          SubscriptFeedsActivity.a(this.jdField_a_of_type_Mwc.a).setSelectionFromBottom(SubscriptFeedsActivity.a(this.jdField_a_of_type_Mwc.a).getCount() - 1, 0);
        }
        SubscriptFeedsActivity.b(this.jdField_a_of_type_Mwc.a, false);
      }
      return;
      i = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mwd
 * JD-Core Version:    0.7.0.1
 */