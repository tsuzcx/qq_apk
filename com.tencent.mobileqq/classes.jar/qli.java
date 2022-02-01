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

public class qli
  extends qjh
{
  private qob a;
  
  public qli(Context paramContext, aoof paramaoof, sel paramsel)
  {
    super(paramContext, paramaoof, paramsel);
  }
  
  public qjh a()
  {
    this.jdField_a_of_type_Boolean = true;
    return a(this.jdField_a_of_type_Sel, this.jdField_a_of_type_Aoof).f().g().q().l().n().j();
  }
  
  public qjh d()
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
    oxr.a(localLinearLayout2, this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130841694));
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentAccountSummary != null) {
      localLinearLayout2.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentAccountSummary);
    }
    if ((this.jdField_a_of_type_Qjg != null) && ((this.jdField_a_of_type_Qjg instanceof ComponentContentGridImage)))
    {
      localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
      localLayoutParams.setMargins(agej.a(12.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0, agej.a(12.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), agej.a(12.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      ((ComponentContentGridImage)this.jdField_a_of_type_Qjg).setLayoutParams(localLayoutParams);
      ((ComponentContentGridImage)this.jdField_a_of_type_Qjg).setDuplicateParentStateEnabled(true);
      oxr.a((ComponentContentGridImage)this.jdField_a_of_type_Qjg, this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130841694));
      ((ComponentContentGridImage)this.jdField_a_of_type_Qjg).setOnNoItemClickListener(new qlj(this));
      localLinearLayout2.addView((ComponentContentGridImage)this.jdField_a_of_type_Qjg);
    }
    localLinearLayout2.setOnClickListener(new qlk(this));
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
  
  public qjh e()
  {
    LinearLayout.LayoutParams localLayoutParams;
    if ((this.jdField_a_of_type_Qob != null) && (this.jdField_a_of_type_Qjg != null) && ((this.jdField_a_of_type_Qjg instanceof ComponentContentGridImage)))
    {
      if (!(((ComponentContentGridImage)this.jdField_a_of_type_Qjg).getLayoutParams() instanceof LinearLayout.LayoutParams)) {
        break label122;
      }
      localLayoutParams = (LinearLayout.LayoutParams)((ComponentContentGridImage)this.jdField_a_of_type_Qjg).getLayoutParams();
      if ((this.jdField_a_of_type_Qob.a() != null) && (this.jdField_a_of_type_Qob.a().size() != 0)) {
        break label136;
      }
      localLayoutParams.setMargins(agej.a(12.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0, agej.a(12.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0);
    }
    for (;;)
    {
      ((ComponentContentGridImage)this.jdField_a_of_type_Qjg).setLayoutParams(localLayoutParams);
      return this;
      label122:
      localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
      break;
      label136:
      localLayoutParams.setMargins(agej.a(12.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0, agej.a(12.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), agej.a(12.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    }
  }
  
  public qjh f()
  {
    super.f();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentAccountSummary.jdField_a_of_type_Boolean = true;
    return this;
  }
  
  public qjh g()
  {
    this.jdField_a_of_type_Qjg = new ComponentContentGridImage(this.jdField_a_of_type_AndroidContentContext);
    return this;
  }
  
  public qjh o()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderNewSocial != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderNewSocial.a(this.jdField_a_of_type_JavaLangObject);
      if ((this.jdField_a_of_type_JavaLangObject instanceof ppu))
      {
        ppu localppu = (ppu)this.jdField_a_of_type_JavaLangObject;
        if (localppu.a() != null) {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderNewSocial.setReadedStatus(this.jdField_a_of_type_Sel.a(localppu.e(), localppu.a().mArticleID));
        }
      }
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentAccountSummary != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentAccountSummary.a(this.jdField_a_of_type_JavaLangObject);
    }
    if (this.jdField_a_of_type_Qjg != null)
    {
      if ((this.jdField_a_of_type_Qjg instanceof ComponentContentGridImage)) {
        ((ComponentContentGridImage)this.jdField_a_of_type_Qjg).setMIReadInJoyModel(this.jdField_a_of_type_JavaLangObject);
      }
      this.jdField_a_of_type_Qob = ComponentContentGridImage.a(this.jdField_a_of_type_JavaLangObject, 0);
      this.jdField_a_of_type_Qjg.a(this.jdField_a_of_type_Qob);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qli
 * JD-Core Version:    0.7.0.1
 */