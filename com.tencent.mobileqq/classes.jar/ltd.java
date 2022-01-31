import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.model.IReadInJoyModel;
import com.tencent.biz.pubaccount.readinjoy.rebuild.FeedItemCellTypeBigSocial;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter.OnSubRegionClickListener;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.ReadInJoyHelper;

public class ltd
  implements View.OnClickListener
{
  public ltd(FeedItemCellTypeBigSocial paramFeedItemCellTypeBigSocial, LinearLayout paramLinearLayout1, LinearLayout paramLinearLayout2, LinearLayout paramLinearLayout3) {}
  
  public void onClick(View paramView)
  {
    ReadInJoyHelper.f(ReadInJoyUtils.a(), this.jdField_a_of_type_AndroidWidgetLinearLayout.getTop() + this.b.getTop() + this.c.getTop());
    paramView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildFeedItemCellTypeBigSocial.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.a();
    if (paramView != null) {
      paramView.a(null, ((IReadInJoyModel)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildFeedItemCellTypeBigSocial.jdField_a_of_type_JavaLangObject).a(), 2);
    }
    if (QLog.isColorLevel())
    {
      QLog.d("Q.readinjoy.videoanimation", 2, new Object[] { "position show", "firstlayout top" + this.jdField_a_of_type_AndroidWidgetLinearLayout.getTop() });
      QLog.d("Q.readinjoy.videoanimation", 2, new Object[] { "position show", "firstlayout width" + this.jdField_a_of_type_AndroidWidgetLinearLayout.getWidth() });
      QLog.d("Q.readinjoy.videoanimation", 2, new Object[] { "position show", "thirdlayout top" + this.b.getTop() });
      QLog.d("Q.readinjoy.videoanimation", 2, new Object[] { "position show", "thirdlayout width" + this.b.getWidth() });
      QLog.d("Q.readinjoy.videoanimation", 2, new Object[] { "position show", "secondlayout top" + this.c.getTop() });
      QLog.d("Q.readinjoy.videoanimation", 2, new Object[] { "position show", "secondlayout width" + this.c.getWidth() });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ltd
 * JD-Core Version:    0.7.0.1
 */