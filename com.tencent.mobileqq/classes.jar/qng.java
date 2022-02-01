import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentBigImageVideo;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentUgcOriginalHeader;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentHeaderNewSocial;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentSocialOperation;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.widget.AbsListView.LayoutParams;

public class qng
  extends qjh
{
  public qng(Context paramContext, aoof paramaoof, sel paramsel)
  {
    super(paramContext, paramaoof, paramsel);
  }
  
  public qjh a()
  {
    this.jdField_a_of_type_Boolean = true;
    return a(this.jdField_a_of_type_Sel, this.jdField_a_of_type_Aoof).r().l().g().n().q().j().h();
  }
  
  public qjh d()
  {
    LinearLayout localLinearLayout1 = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
    localLinearLayout1.setOrientation(1);
    localLinearLayout1.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderNewSocial != null) {
      localLinearLayout1.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderNewSocial);
    }
    LinearLayout localLinearLayout2 = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
    localLinearLayout2.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
    localLinearLayout2.setOrientation(1);
    localLinearLayout2.setPadding(0, 0, 0, agej.a(1.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentUgcOriginalHeader != null) {
      localLinearLayout2.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentUgcOriginalHeader);
    }
    if (this.jdField_a_of_type_Qjg != null)
    {
      LinearLayout localLinearLayout3 = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
      localLinearLayout3.setOrientation(1);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
      localLayoutParams.setMargins(agej.a(12.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), agej.a(11.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), agej.a(12.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), agej.a(12.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      localLinearLayout3.setLayoutParams(localLayoutParams);
      localLinearLayout3.addView((View)this.jdField_a_of_type_Qjg);
      if ((this.jdField_a_of_type_Qjg instanceof ComponentContentBigImageVideo))
      {
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentTitle != null) {
          localLinearLayout3.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentTitle);
        }
        oxr.a(localLinearLayout3, this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130842844));
        localLinearLayout3.setOnClickListener(new qnh(this));
      }
      localLinearLayout2.addView(localLinearLayout3);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentUgcSource != null) {
      localLinearLayout2.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentUgcSource);
    }
    oxr.a(localLinearLayout2, this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130843009));
    localLinearLayout1.addView(localLinearLayout2);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentSocialOperation != null) {
      localLinearLayout1.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentSocialOperation);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentDivider != null) {
      localLinearLayout1.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentDivider);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentLastRead != null) {
      localLinearLayout1.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentLastRead);
    }
    localLinearLayout2.setOnClickListener(new qni(this));
    a(localLinearLayout1);
    return this;
  }
  
  public qjh e()
  {
    return null;
  }
  
  public qjh o()
  {
    super.o();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderNewSocial != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderNewSocial.a(this.jdField_a_of_type_JavaLangObject);
      if ((this.jdField_a_of_type_JavaLangObject instanceof ppu))
      {
        ppu localppu = (ppu)this.jdField_a_of_type_JavaLangObject;
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderNewSocial.setReadedStatus(this.jdField_a_of_type_Sel.a(localppu.e(), localppu.a().mArticleID));
      }
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentUgcOriginalHeader != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentUgcOriginalHeader.a(this.jdField_a_of_type_JavaLangObject);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentSocialOperation != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentSocialOperation.a(this.jdField_a_of_type_JavaLangObject);
    }
    return this;
  }
  
  public qjh p()
  {
    super.p();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderNewSocial != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderNewSocial.a(this.jdField_a_of_type_Qjp);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentSocialOperation != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentSocialOperation.a(this.jdField_a_of_type_Qjp);
    }
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qng
 * JD-Core Version:    0.7.0.1
 */