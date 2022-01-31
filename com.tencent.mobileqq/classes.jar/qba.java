import android.content.Context;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentBigImageVideo;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentUgcVideo;
import com.tencent.widget.AbsListView.LayoutParams;

public class qba
  extends qay
{
  public qba(Context paramContext, bcws parambcws, rqj paramrqj)
  {
    super(paramContext, parambcws, paramrqj);
  }
  
  public pxl a()
  {
    this.jdField_a_of_type_Boolean = true;
    return f(this.jdField_a_of_type_Rqj, this.jdField_a_of_type_Bcws).g().q().l().n();
  }
  
  public pxl d()
  {
    if (!this.jdField_a_of_type_Boolean) {
      throw new Exception("layoutComponent() must after buildComponent()!");
    }
    LinearLayout localLinearLayout1 = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
    localLinearLayout1.setOrientation(1);
    localLinearLayout1.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderTopicRecommend != null) {
      localLinearLayout1.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderTopicRecommend);
    }
    if ((this.jdField_a_of_type_Pxk != null) && ((this.jdField_a_of_type_Pxk instanceof ComponentContentBigImageVideo)))
    {
      LinearLayout localLinearLayout2 = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
      localLinearLayout2.setOrientation(1);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
      localLayoutParams.setMargins(aekt.a(12.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0, aekt.a(12.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), aekt.a(12.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      localLinearLayout2.setLayoutParams(localLayoutParams);
      localLinearLayout2.addView((ComponentContentBigImageVideo)this.jdField_a_of_type_Pxk);
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentTitle != null) {
        localLinearLayout2.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentTitle);
      }
      localLinearLayout2.setOnClickListener(new qbb(this));
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
  
  public pxl g()
  {
    this.jdField_a_of_type_Pxk = new ComponentContentUgcVideo(this.jdField_a_of_type_AndroidContentContext);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     qba
 * JD-Core Version:    0.7.0.1
 */