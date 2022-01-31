import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentBig;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentHeaderNewSocial;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentSocialOperation;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentTitle;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.widget.AbsListView.LayoutParams;

public class prc
  extends pra
{
  public prc(Context paramContext, baxy parambaxy, ram paramram)
  {
    super(paramContext, parambaxy, paramram);
  }
  
  public pqq a()
  {
    this.jdField_a_of_type_Boolean = true;
    return a(this.jdField_a_of_type_Ram, this.jdField_a_of_type_Baxy).f().g().h().q().l().n().j();
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
    localLinearLayout2.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
    localLinearLayout2.setBackgroundColor(Color.parseColor("#F8F8F8"));
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentAccountSummary != null) {
      localLinearLayout2.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentAccountSummary);
    }
    if ((this.jdField_a_of_type_Pqp != null) && ((this.jdField_a_of_type_Pqp instanceof ComponentContentBig)) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentTitle != null))
    {
      LinearLayout localLinearLayout3 = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
      localLinearLayout3.setOrientation(1);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
      localLayoutParams.leftMargin = actj.a(12.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      localLayoutParams.rightMargin = actj.a(12.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      localLayoutParams.bottomMargin = actj.a(13.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      localLayoutParams.gravity = 1;
      localLinearLayout3.setLayoutParams(localLayoutParams);
      localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
      ((ComponentContentBig)this.jdField_a_of_type_Pqp).setId(1);
      ((ComponentContentBig)this.jdField_a_of_type_Pqp).setLayoutParams(localLayoutParams);
      localLinearLayout3.addView((ComponentContentBig)this.jdField_a_of_type_Pqp);
      localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentTitle.setId(2);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentTitle.setLayoutParams(localLayoutParams);
      localLinearLayout3.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentTitle);
      localLinearLayout3.setOnClickListener(new prd(this, localLinearLayout1, localLinearLayout3, localLinearLayout2));
      localLinearLayout3.setDuplicateParentStateEnabled(true);
      localLinearLayout3.setOnTouchListener(new pre(this, localLinearLayout3));
      localLinearLayout2.setOnTouchListener(new prf(this, localLinearLayout3));
      oky.a(localLinearLayout3, this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130842322));
      localLinearLayout2.addView(localLinearLayout3);
      localLinearLayout2.setDuplicateParentStateEnabled(true);
      localLinearLayout2.setOnTouchListener(new prg(this, localLinearLayout2));
      localLinearLayout1.setOnTouchListener(new prh(this, localLinearLayout2, localLinearLayout3));
    }
    localLinearLayout2.setOnClickListener(new pri(this));
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
  
  public pqq o()
  {
    super.o();
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
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentSocialOperation != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentSocialOperation.a(this.jdField_a_of_type_JavaLangObject);
    }
    return this;
  }
  
  public pqq p()
  {
    super.p();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderNewSocial != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderNewSocial.a(this.jdField_a_of_type_Pqy);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentSocialOperation != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentSocialOperation.a(this.jdField_a_of_type_Pqy);
    }
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     prc
 * JD-Core Version:    0.7.0.1
 */