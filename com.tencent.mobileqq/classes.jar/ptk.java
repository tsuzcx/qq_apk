import android.content.Context;
import android.content.res.Resources;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentSmall;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentInfo;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentTitle;
import com.tencent.widget.AbsListView.LayoutParams;

public class ptk
  extends pqq
{
  public ptk(Context paramContext, baxy parambaxy, ram paramram)
  {
    super(paramContext, parambaxy, paramram);
  }
  
  public pqq a()
  {
    this.jdField_a_of_type_Boolean = true;
    return b();
  }
  
  public pqq d()
  {
    if (!this.jdField_a_of_type_Boolean) {
      throw new Exception("buildComponent() must after buildComponent()!");
    }
    LinearLayout localLinearLayout = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
    localLinearLayout.setOrientation(1);
    localLinearLayout.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderSpecialTopic != null) {
      localLinearLayout.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderSpecialTopic);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderFriendRecommend != null) {
      localLinearLayout.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderFriendRecommend);
    }
    if ((this.jdField_a_of_type_Pqp != null) && ((this.jdField_a_of_type_Pqp instanceof ComponentContentSmall)) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentTitle != null))
    {
      RelativeLayout localRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
      localRelativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298552)));
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(11);
      ((ComponentContentSmall)this.jdField_a_of_type_Pqp).setId(1);
      ((ComponentContentSmall)this.jdField_a_of_type_Pqp).setLayoutParams(localLayoutParams);
      localRelativeLayout.addView((ComponentContentSmall)this.jdField_a_of_type_Pqp);
      localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
      localLayoutParams.addRule(9);
      localLayoutParams.addRule(0, ((ComponentContentSmall)this.jdField_a_of_type_Pqp).getId());
      localLayoutParams.topMargin = actj.a(-5.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentTitle.setId(2);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentTitle.setLayoutParams(localLayoutParams);
      localRelativeLayout.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentTitle);
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentInfo != null)
      {
        localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
        localLayoutParams.addRule(12);
        localLayoutParams.addRule(9);
        localLayoutParams.addRule(0, ((ComponentContentSmall)this.jdField_a_of_type_Pqp).getId());
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentInfo.setId(3);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentInfo.setLayoutParams(localLayoutParams);
        localRelativeLayout.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentInfo);
      }
      localLinearLayout.addView(localRelativeLayout);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentJump != null) {
      localLinearLayout.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentJump);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentComment != null) {
      localLinearLayout.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentComment);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentDivider != null) {
      localLinearLayout.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentDivider);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentLastRead != null) {
      localLinearLayout.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentLastRead);
    }
    a(localLinearLayout);
    return this;
  }
  
  public pqq e()
  {
    RelativeLayout.LayoutParams localLayoutParams;
    if (puy.d((pau)this.jdField_a_of_type_JavaLangObject))
    {
      localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentTitle.getLayoutParams();
      localLayoutParams.addRule(15);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentTitle.setLayoutParams(localLayoutParams);
    }
    for (;;)
    {
      return null;
      if (!puy.j((pau)this.jdField_a_of_type_JavaLangObject))
      {
        localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentTitle.getLayoutParams();
        localLayoutParams.addRule(15, 0);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentTitle.setLayoutParams(localLayoutParams);
      }
    }
  }
  
  public pqq g()
  {
    this.jdField_a_of_type_Pqp = new ComponentContentSmall(this.jdField_a_of_type_AndroidContentContext);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ptk
 * JD-Core Version:    0.7.0.1
 */