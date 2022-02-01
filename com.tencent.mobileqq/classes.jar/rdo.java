import android.content.Context;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentGridImage;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentUgcSource;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentDivider;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentHeaderPublish;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentLastRead;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentSocialOperation;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.face.FaceDecoder;
import com.tencent.widget.AbsListView.LayoutParams;

public class rdo
  extends rbp
{
  private rgj a;
  
  public rdo(Context paramContext, FaceDecoder paramFaceDecoder, szd paramszd)
  {
    super(paramContext, paramFaceDecoder, paramszd);
  }
  
  public rbp a()
  {
    this.jdField_a_of_type_Boolean = true;
    return c(this.jdField_a_of_type_Szd, this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder).g().q().l().n().j();
  }
  
  public rbp c(szd paramszd, FaceDecoder paramFaceDecoder)
  {
    super.c(paramszd, paramFaceDecoder);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderPublish.jdField_a_of_type_Boolean = true;
    return this;
  }
  
  public rbp d()
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
    if ((this.jdField_a_of_type_Rbo != null) && ((this.jdField_a_of_type_Rbo instanceof ComponentContentGridImage)))
    {
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
      localLayoutParams.setMargins(AIOUtils.dp2px(12.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0, AIOUtils.dp2px(12.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0);
      ((ComponentContentGridImage)this.jdField_a_of_type_Rbo).setLayoutParams(localLayoutParams);
      ((ComponentContentGridImage)this.jdField_a_of_type_Rbo).setOnNoItemClickListener(new rdp(this));
      localLinearLayout.addView((ComponentContentGridImage)this.jdField_a_of_type_Rbo);
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
  
  public rbp e()
  {
    return null;
  }
  
  public rbp g()
  {
    this.jdField_a_of_type_Rbo = new ComponentContentGridImage(this.jdField_a_of_type_AndroidContentContext);
    return this;
  }
  
  public rbp o()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderPublish != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderPublish.a(this.jdField_a_of_type_JavaLangObject);
    }
    if (this.jdField_a_of_type_Rbo != null)
    {
      if ((this.jdField_a_of_type_Rbo instanceof ComponentContentGridImage)) {
        ((ComponentContentGridImage)this.jdField_a_of_type_Rbo).setMIReadInJoyModel(this.jdField_a_of_type_JavaLangObject);
      }
      this.jdField_a_of_type_Rgj = ComponentContentGridImage.a(this.jdField_a_of_type_JavaLangObject, 0);
      this.jdField_a_of_type_Rbo.a(this.jdField_a_of_type_Rgj);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rdo
 * JD-Core Version:    0.7.0.1
 */