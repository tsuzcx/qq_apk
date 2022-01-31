import android.content.Context;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentGridImage;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentUgcSource;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentDivider;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentHeaderPublish;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentLastRead;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentSocialOperation;
import com.tencent.widget.AbsListView.LayoutParams;

public class psq
  extends pqq
{
  private pvl a;
  
  public psq(Context paramContext, baxy parambaxy, ram paramram)
  {
    super(paramContext, parambaxy, paramram);
  }
  
  public pqq a()
  {
    this.jdField_a_of_type_Boolean = true;
    return c(this.jdField_a_of_type_Ram, this.jdField_a_of_type_Baxy).g().q().l().n().j();
  }
  
  public pqq c(ram paramram, baxy parambaxy)
  {
    super.c(paramram, parambaxy);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderPublish.jdField_a_of_type_Boolean = true;
    return this;
  }
  
  public pqq d()
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
    if ((this.jdField_a_of_type_Pqp != null) && ((this.jdField_a_of_type_Pqp instanceof ComponentContentGridImage)))
    {
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
      localLayoutParams.setMargins(actj.a(12.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0, actj.a(12.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0);
      ((ComponentContentGridImage)this.jdField_a_of_type_Pqp).setLayoutParams(localLayoutParams);
      ((ComponentContentGridImage)this.jdField_a_of_type_Pqp).setOnNoItemClickListener(new psr(this));
      localLinearLayout.addView((ComponentContentGridImage)this.jdField_a_of_type_Pqp);
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
  
  public pqq e()
  {
    return null;
  }
  
  public pqq g()
  {
    this.jdField_a_of_type_Pqp = new ComponentContentGridImage(this.jdField_a_of_type_AndroidContentContext);
    return this;
  }
  
  public pqq o()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderPublish != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderPublish.a(this.jdField_a_of_type_JavaLangObject);
    }
    if (this.jdField_a_of_type_Pqp != null)
    {
      if ((this.jdField_a_of_type_Pqp instanceof ComponentContentGridImage)) {
        ((ComponentContentGridImage)this.jdField_a_of_type_Pqp).setMIReadInJoyModel(this.jdField_a_of_type_JavaLangObject);
      }
      this.jdField_a_of_type_Pvl = ComponentContentGridImage.a(this.jdField_a_of_type_JavaLangObject, 0);
      this.jdField_a_of_type_Pqp.a(this.jdField_a_of_type_Pvl);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentUgcSource != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentUgcSource.a(this.jdField_a_of_type_JavaLangObject);
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
 * Qualified Name:     psq
 * JD-Core Version:    0.7.0.1
 */