import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentAccountSummary;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentGridImage;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentUgcSource;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentDivider;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentHeaderNewSocial;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentLastRead;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentSocialOperation;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.widget.AbsListView.LayoutParams;
import java.util.List;

public class pss
  extends pqq
{
  private pvl a;
  
  public pss(Context paramContext, baxy parambaxy, ram paramram)
  {
    super(paramContext, parambaxy, paramram);
  }
  
  public pqq a()
  {
    this.jdField_a_of_type_Boolean = true;
    return a(this.jdField_a_of_type_Ram, this.jdField_a_of_type_Baxy).f().g().q().l().n().j();
  }
  
  public pqq d()
  {
    if (!this.jdField_a_of_type_Boolean) {
      throw new Exception("buildComponent() must after buildComponent()!");
    }
    LinearLayout localLinearLayout1 = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
    localLinearLayout1.setOrientation(1);
    localLinearLayout1.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderNewSocial != null) {
      localLinearLayout1.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderNewSocial);
    }
    LinearLayout localLinearLayout2 = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
    localLinearLayout2.setOrientation(1);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
    localLinearLayout2.setBackgroundColor(Color.parseColor("#F8F8F8"));
    localLinearLayout2.setLayoutParams(localLayoutParams);
    oky.a(localLinearLayout2, this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130841263));
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentAccountSummary != null) {
      localLinearLayout2.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentAccountSummary);
    }
    if ((this.jdField_a_of_type_Pqp != null) && ((this.jdField_a_of_type_Pqp instanceof ComponentContentGridImage)))
    {
      localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
      localLayoutParams.setMargins(actj.a(12.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0, actj.a(12.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), actj.a(12.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      ((ComponentContentGridImage)this.jdField_a_of_type_Pqp).setLayoutParams(localLayoutParams);
      ((ComponentContentGridImage)this.jdField_a_of_type_Pqp).setDuplicateParentStateEnabled(true);
      oky.a((ComponentContentGridImage)this.jdField_a_of_type_Pqp, this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130841263));
      ((ComponentContentGridImage)this.jdField_a_of_type_Pqp).setOnNoItemClickListener(new pst(this));
      localLinearLayout2.addView((ComponentContentGridImage)this.jdField_a_of_type_Pqp);
    }
    localLinearLayout2.setOnClickListener(new psu(this));
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentUgcSource != null) {
      localLinearLayout2.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentUgcSource);
    }
    if (localLinearLayout2.getChildCount() > 0) {
      localLinearLayout1.addView(localLinearLayout2);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentSocialOperation != null) {
      localLinearLayout1.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentSocialOperation);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentDivider != null) {
      localLinearLayout1.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentDivider);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentLastRead != null) {
      localLinearLayout1.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentLastRead);
    }
    a(localLinearLayout1);
    return this;
  }
  
  public pqq e()
  {
    LinearLayout.LayoutParams localLayoutParams;
    if ((this.jdField_a_of_type_Pvl != null) && (this.jdField_a_of_type_Pqp != null) && ((this.jdField_a_of_type_Pqp instanceof ComponentContentGridImage)))
    {
      if (!(((ComponentContentGridImage)this.jdField_a_of_type_Pqp).getLayoutParams() instanceof LinearLayout.LayoutParams)) {
        break label122;
      }
      localLayoutParams = (LinearLayout.LayoutParams)((ComponentContentGridImage)this.jdField_a_of_type_Pqp).getLayoutParams();
      if ((this.jdField_a_of_type_Pvl.a() != null) && (this.jdField_a_of_type_Pvl.a().size() != 0)) {
        break label136;
      }
      localLayoutParams.setMargins(actj.a(12.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0, actj.a(12.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0);
    }
    for (;;)
    {
      ((ComponentContentGridImage)this.jdField_a_of_type_Pqp).setLayoutParams(localLayoutParams);
      return this;
      label122:
      localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
      break;
      label136:
      localLayoutParams.setMargins(actj.a(12.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0, actj.a(12.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), actj.a(12.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    }
  }
  
  public pqq f()
  {
    super.f();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentAccountSummary.jdField_a_of_type_Boolean = true;
    return this;
  }
  
  public pqq g()
  {
    this.jdField_a_of_type_Pqp = new ComponentContentGridImage(this.jdField_a_of_type_AndroidContentContext);
    return this;
  }
  
  public pqq o()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderNewSocial != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderNewSocial.a(this.jdField_a_of_type_JavaLangObject);
      if ((this.jdField_a_of_type_JavaLangObject instanceof pau))
      {
        pau localpau = (pau)this.jdField_a_of_type_JavaLangObject;
        if (localpau.a() != null) {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderNewSocial.setReadedStatus(this.jdField_a_of_type_Ram.a(localpau.e(), localpau.a().mArticleID));
        }
      }
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentAccountSummary != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentAccountSummary.a(this.jdField_a_of_type_JavaLangObject);
    }
    if (this.jdField_a_of_type_Pqp != null)
    {
      if ((this.jdField_a_of_type_Pqp instanceof ComponentContentGridImage)) {
        ((ComponentContentGridImage)this.jdField_a_of_type_Pqp).setMIReadInJoyModel(this.jdField_a_of_type_JavaLangObject);
      }
      this.jdField_a_of_type_Pvl = ComponentContentGridImage.a(this.jdField_a_of_type_JavaLangObject, 0);
      this.jdField_a_of_type_Pqp.a(this.jdField_a_of_type_Pvl);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentSocialOperation != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentSocialOperation.a(this.jdField_a_of_type_JavaLangObject);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentDivider != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentDivider.a(this.jdField_a_of_type_JavaLangObject);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentLastRead != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentLastRead.a(this.jdField_a_of_type_JavaLangObject);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentUgcSource != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentUgcSource.a(this.jdField_a_of_type_JavaLangObject);
    }
    try
    {
      e();
      return this;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pss
 * JD-Core Version:    0.7.0.1
 */