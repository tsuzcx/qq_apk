import android.content.Context;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentSmall;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentHeaderTopicRecommend;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentSocialOperation;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentTitle;
import com.tencent.widget.AbsListView.LayoutParams;

public class puc
  extends pqq
{
  public puc(Context paramContext, baxy parambaxy, ram paramram)
  {
    super(paramContext, parambaxy, paramram);
  }
  
  public pqq a()
  {
    this.jdField_a_of_type_Boolean = true;
    return f(this.jdField_a_of_type_Ram, this.jdField_a_of_type_Baxy).q().l().n().h().g();
  }
  
  public pqq d()
  {
    if (!this.jdField_a_of_type_Boolean) {
      throw new Exception("buildComponent() must after buildComponent()!");
    }
    LinearLayout localLinearLayout = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
    localLinearLayout.setOrientation(1);
    localLinearLayout.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderTopicRecommend != null) {
      localLinearLayout.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderTopicRecommend);
    }
    if ((this.jdField_a_of_type_Pqp != null) && ((this.jdField_a_of_type_Pqp instanceof ComponentContentSmall)) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentTitle != null))
    {
      RelativeLayout localRelativeLayout1 = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
      localRelativeLayout1.setPadding(actj.a(12.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0, actj.a(12.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0);
      RelativeLayout localRelativeLayout2 = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
      localRelativeLayout2.setBackgroundResource(2130842330);
      localRelativeLayout2.setLayoutParams(new RelativeLayout.LayoutParams(-1, actj.a(79.0F, this.jdField_a_of_type_AndroidContentContext.getResources())));
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(actj.a(104.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), -1);
      localLayoutParams.addRule(11);
      ((ComponentContentSmall)this.jdField_a_of_type_Pqp).setLayoutParams(localLayoutParams);
      ((ComponentContentSmall)this.jdField_a_of_type_Pqp).setId(1);
      localRelativeLayout2.addView((ComponentContentSmall)this.jdField_a_of_type_Pqp);
      localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
      localLayoutParams.addRule(9);
      localLayoutParams.addRule(15);
      localLayoutParams.addRule(0, ((ComponentContentSmall)this.jdField_a_of_type_Pqp).getId());
      localLayoutParams.setMargins(actj.a(12.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0, actj.a(20.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentTitle.setLayoutParams(localLayoutParams);
      localRelativeLayout2.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentTitle);
      localRelativeLayout1.addView(localRelativeLayout2);
      localRelativeLayout2.setOnClickListener(new pud(this));
      localLinearLayout.addView(localRelativeLayout1);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentSocialOperation != null) {
      localLinearLayout.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentSocialOperation);
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
    return null;
  }
  
  public pqq g()
  {
    this.jdField_a_of_type_Pqp = new ComponentContentSmall(this.jdField_a_of_type_AndroidContentContext);
    return this;
  }
  
  public pqq o()
  {
    super.o();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderTopicRecommend != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderTopicRecommend.a(this.jdField_a_of_type_JavaLangObject);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentSocialOperation != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentSocialOperation.a(this.jdField_a_of_type_JavaLangObject);
    }
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     puc
 * JD-Core Version:    0.7.0.1
 */