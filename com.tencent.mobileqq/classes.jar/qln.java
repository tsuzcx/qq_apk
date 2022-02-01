import android.content.Context;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentSmall;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentUgcSource;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentHeaderPublish;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentSocialOperation;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentTitle;
import com.tencent.widget.AbsListView.LayoutParams;

public class qln
  extends qjh
{
  public qln(Context paramContext, aoof paramaoof, sel paramsel)
  {
    super(paramContext, paramaoof, paramsel);
  }
  
  public qjh a()
  {
    this.jdField_a_of_type_Boolean = true;
    return c(this.jdField_a_of_type_Sel, this.jdField_a_of_type_Aoof).q().l().n().h().g().j();
  }
  
  public qjh d()
  {
    if (!this.jdField_a_of_type_Boolean) {
      throw new Exception("buildComponent() must after buildComponent()!");
    }
    LinearLayout localLinearLayout = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
    localLinearLayout.setOrientation(1);
    localLinearLayout.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderPublish != null) {
      localLinearLayout.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderPublish);
    }
    if ((this.jdField_a_of_type_Qjg != null) && ((this.jdField_a_of_type_Qjg instanceof ComponentContentSmall)) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentTitle != null))
    {
      RelativeLayout localRelativeLayout1 = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
      localRelativeLayout1.setPadding(agej.a(12.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0, agej.a(12.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0);
      RelativeLayout localRelativeLayout2 = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
      localRelativeLayout2.setBackgroundResource(2130842852);
      localRelativeLayout2.setLayoutParams(new RelativeLayout.LayoutParams(-1, agej.a(79.0F, this.jdField_a_of_type_AndroidContentContext.getResources())));
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(agej.a(104.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), -1);
      localLayoutParams.addRule(11);
      ((ComponentContentSmall)this.jdField_a_of_type_Qjg).setLayoutParams(localLayoutParams);
      ((ComponentContentSmall)this.jdField_a_of_type_Qjg).setId(1);
      localRelativeLayout2.addView((ComponentContentSmall)this.jdField_a_of_type_Qjg);
      localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
      localLayoutParams.addRule(9);
      localLayoutParams.addRule(15);
      localLayoutParams.addRule(0, ((ComponentContentSmall)this.jdField_a_of_type_Qjg).getId());
      localLayoutParams.setMargins(agej.a(12.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0, agej.a(20.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentTitle.setLayoutParams(localLayoutParams);
      localRelativeLayout2.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentTitle);
      localRelativeLayout1.addView(localRelativeLayout2);
      localRelativeLayout2.setOnClickListener(new qlo(this));
      localLinearLayout.addView(localRelativeLayout1);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentUgcSource != null) {
      localLinearLayout.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentUgcSource);
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
  
  public qjh e()
  {
    return null;
  }
  
  public qjh g()
  {
    this.jdField_a_of_type_Qjg = new ComponentContentSmall(this.jdField_a_of_type_AndroidContentContext);
    return this;
  }
  
  public qjh o()
  {
    super.o();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderPublish != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderPublish.a(this.jdField_a_of_type_JavaLangObject);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentUgcSource != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentUgcSource.a(this.jdField_a_of_type_JavaLangObject);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentSocialOperation != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentSocialOperation.a(this.jdField_a_of_type_JavaLangObject);
    }
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qln
 * JD-Core Version:    0.7.0.1
 */