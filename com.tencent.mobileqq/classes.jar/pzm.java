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

public class pzm
  extends pxl
{
  private qcf a;
  
  public pzm(Context paramContext, bdbb parambdbb, rqj paramrqj)
  {
    super(paramContext, parambdbb, paramrqj);
  }
  
  public pxl a()
  {
    this.jdField_a_of_type_Boolean = true;
    return a(this.jdField_a_of_type_Rqj, this.jdField_a_of_type_Bdbb).f().g().q().l().n().j();
  }
  
  public pxl d()
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
    opi.a(localLinearLayout2, this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130841382));
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentAccountSummary != null) {
      localLinearLayout2.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentAccountSummary);
    }
    if ((this.jdField_a_of_type_Pxk != null) && ((this.jdField_a_of_type_Pxk instanceof ComponentContentGridImage)))
    {
      localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
      localLayoutParams.setMargins(aepi.a(12.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0, aepi.a(12.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), aepi.a(12.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      ((ComponentContentGridImage)this.jdField_a_of_type_Pxk).setLayoutParams(localLayoutParams);
      ((ComponentContentGridImage)this.jdField_a_of_type_Pxk).setDuplicateParentStateEnabled(true);
      opi.a((ComponentContentGridImage)this.jdField_a_of_type_Pxk, this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130841382));
      ((ComponentContentGridImage)this.jdField_a_of_type_Pxk).setOnNoItemClickListener(new pzn(this));
      localLinearLayout2.addView((ComponentContentGridImage)this.jdField_a_of_type_Pxk);
    }
    localLinearLayout2.setOnClickListener(new pzo(this));
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
  
  public pxl e()
  {
    LinearLayout.LayoutParams localLayoutParams;
    if ((this.jdField_a_of_type_Qcf != null) && (this.jdField_a_of_type_Pxk != null) && ((this.jdField_a_of_type_Pxk instanceof ComponentContentGridImage)))
    {
      if (!(((ComponentContentGridImage)this.jdField_a_of_type_Pxk).getLayoutParams() instanceof LinearLayout.LayoutParams)) {
        break label122;
      }
      localLayoutParams = (LinearLayout.LayoutParams)((ComponentContentGridImage)this.jdField_a_of_type_Pxk).getLayoutParams();
      if ((this.jdField_a_of_type_Qcf.a() != null) && (this.jdField_a_of_type_Qcf.a().size() != 0)) {
        break label136;
      }
      localLayoutParams.setMargins(aepi.a(12.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0, aepi.a(12.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0);
    }
    for (;;)
    {
      ((ComponentContentGridImage)this.jdField_a_of_type_Pxk).setLayoutParams(localLayoutParams);
      return this;
      label122:
      localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
      break;
      label136:
      localLayoutParams.setMargins(aepi.a(12.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0, aepi.a(12.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), aepi.a(12.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    }
  }
  
  public pxl f()
  {
    super.f();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentAccountSummary.jdField_a_of_type_Boolean = true;
    return this;
  }
  
  public pxl g()
  {
    this.jdField_a_of_type_Pxk = new ComponentContentGridImage(this.jdField_a_of_type_AndroidContentContext);
    return this;
  }
  
  public pxl o()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderNewSocial != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderNewSocial.a(this.jdField_a_of_type_JavaLangObject);
      if ((this.jdField_a_of_type_JavaLangObject instanceof pgd))
      {
        pgd localpgd = (pgd)this.jdField_a_of_type_JavaLangObject;
        if (localpgd.a() != null) {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderNewSocial.setReadedStatus(this.jdField_a_of_type_Rqj.a(localpgd.e(), localpgd.a().mArticleID));
        }
      }
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentAccountSummary != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentAccountSummary.a(this.jdField_a_of_type_JavaLangObject);
    }
    if (this.jdField_a_of_type_Pxk != null)
    {
      if ((this.jdField_a_of_type_Pxk instanceof ComponentContentGridImage)) {
        ((ComponentContentGridImage)this.jdField_a_of_type_Pxk).setMIReadInJoyModel(this.jdField_a_of_type_JavaLangObject);
      }
      this.jdField_a_of_type_Qcf = ComponentContentGridImage.a(this.jdField_a_of_type_JavaLangObject, 0);
      this.jdField_a_of_type_Pxk.a(this.jdField_a_of_type_Qcf);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     pzm
 * JD-Core Version:    0.7.0.1
 */