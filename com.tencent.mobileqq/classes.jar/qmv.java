import android.content.Context;
import android.widget.LinearLayout;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentHeaderTopicRecommend;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentSocialOperation;
import com.tencent.widget.AbsListView.LayoutParams;

public class qmv
  extends qjh
{
  public qmv(Context paramContext, aoof paramaoof, sel paramsel)
  {
    super(paramContext, paramaoof, paramsel);
  }
  
  public qjh a()
  {
    this.jdField_a_of_type_Boolean = true;
    return f(this.jdField_a_of_type_Sel, this.jdField_a_of_type_Aoof).q().l().n();
  }
  
  public qjh d()
  {
    if (!this.jdField_a_of_type_Boolean) {
      throw new Exception("layoutComponent() must after buildComponent()!");
    }
    LinearLayout localLinearLayout = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
    localLinearLayout.setOrientation(1);
    localLinearLayout.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderTopicRecommend != null) {
      localLinearLayout.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderTopicRecommend);
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
  
  public qjh o()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qmv
 * JD-Core Version:    0.7.0.1
 */