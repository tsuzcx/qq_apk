import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.model.CommunityConfigInfo;
import com.tencent.biz.pubaccount.readinjoy.view.headers.ReadInJoyDiandianHeaderController;
import com.tencent.biz.pubaccount.readinjoy.view.headers.ReadInJoyDiandianHeaderController.OnCommunityItemListener.1;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.List;

public class sef
  implements View.OnClickListener
{
  public int a;
  
  private sef(ReadInJoyDiandianHeaderController paramReadInJoyDiandianHeaderController) {}
  
  public void onClick(View paramView)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    String str;
    if (this.jdField_a_of_type_Int != this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewHeadersReadInJoyDiandianHeaderController.a.size())
    {
      CommunityConfigInfo localCommunityConfigInfo = (CommunityConfigInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewHeadersReadInJoyDiandianHeaderController.a.get(this.jdField_a_of_type_Int);
      str = localCommunityConfigInfo.jumpUrl;
      paramView.postDelayed(new ReadInJoyDiandianHeaderController.OnCommunityItemListener.1(this, paramView), 300L);
      nrt.a(null, "", "0X8009B9F", "0X8009B9F", 0, 0, localQQAppInterface.getCurrentAccountUin(), localCommunityConfigInfo.bid + "", this.jdField_a_of_type_Int + 1 + "", "", false);
    }
    for (;;)
    {
      ors.a(paramView.getContext(), str);
      return;
      str = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewHeadersReadInJoyDiandianHeaderController.d;
      nrt.a(null, "", "0X8009BA3", "0X8009BA3", 0, 0, localQQAppInterface.getCurrentAccountUin(), "", "", "", false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     sef
 * JD-Core Version:    0.7.0.1
 */