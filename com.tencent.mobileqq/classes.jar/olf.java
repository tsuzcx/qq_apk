import android.view.View;
import com.tencent.biz.pubaccount.PublicAccountMenuBar;
import java.util.List;

public class olf
  implements bkzq
{
  public olf(PublicAccountMenuBar paramPublicAccountMenuBar, List paramList, bkzi parambkzi) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    try
    {
      if (PublicAccountMenuBar.a(this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountMenuBar)) {
        return;
      }
      PublicAccountMenuBar.a(this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountMenuBar, true);
      if (paramInt == 0)
      {
        PublicAccountMenuBar.a(this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountMenuBar, false);
        return;
      }
    }
    catch (Exception paramView)
    {
      paramView.printStackTrace();
      return;
    }
    paramView = (aako)this.jdField_a_of_type_JavaUtilList.get(paramInt - 1);
    if (paramView == null)
    {
      PublicAccountMenuBar.a(this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountMenuBar, false);
      return;
    }
    PublicAccountMenuBar.a(this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountMenuBar, paramView);
    this.jdField_a_of_type_Bkzi.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     olf
 * JD-Core Version:    0.7.0.1
 */