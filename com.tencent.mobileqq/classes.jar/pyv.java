import android.content.Context;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentGalleryBiu;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentUgcSource;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentHeaderPublish;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentSocialOperation;
import com.tencent.widget.AbsListView.LayoutParams;

public class pyv
  extends pxl
{
  public pyv(Context paramContext, bcws parambcws, rqj paramrqj)
  {
    super(paramContext, parambcws, paramrqj);
  }
  
  public pxl a()
  {
    this.jdField_a_of_type_Boolean = true;
    return c(this.jdField_a_of_type_Rqj, this.jdField_a_of_type_Bcws).l().g().n().q().j().h();
  }
  
  public pxl c(rqj paramrqj, bcws parambcws)
  {
    super.c(paramrqj, parambcws);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderPublish.b = true;
    return this;
  }
  
  public pxl d()
  {
    if (!this.jdField_a_of_type_Boolean) {
      throw new Exception("buildComponent() must after buildComponent()!");
    }
    LinearLayout localLinearLayout1 = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
    localLinearLayout1.setOrientation(1);
    localLinearLayout1.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderPublish != null) {
      localLinearLayout1.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderPublish);
    }
    if ((this.jdField_a_of_type_Pxk != null) && ((this.jdField_a_of_type_Pxk instanceof ComponentContentGalleryBiu)))
    {
      ((ComponentContentGalleryBiu)this.jdField_a_of_type_Pxk).setIsNeedAddTitle(true);
      LinearLayout localLinearLayout2 = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
      localLinearLayout2.setOrientation(1);
      new LinearLayout.LayoutParams(-2, -2);
      localLinearLayout2.addView((ComponentContentGalleryBiu)this.jdField_a_of_type_Pxk);
      localLinearLayout2.setPadding(aekt.a(12.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0, aekt.a(12.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0);
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
    return null;
  }
  
  public pxl g()
  {
    this.jdField_a_of_type_Pxk = new ComponentContentGalleryBiu(this.jdField_a_of_type_AndroidContentContext);
    return this;
  }
  
  public pxl o()
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
    if ((this.jdField_a_of_type_Pxk != null) && ((this.jdField_a_of_type_Pxk instanceof ComponentContentGalleryBiu)))
    {
      ((ComponentContentGalleryBiu)this.jdField_a_of_type_Pxk).setAdapter(this.jdField_a_of_type_Rqj);
      ((ComponentContentGalleryBiu)this.jdField_a_of_type_Pxk).setPosition(this.jdField_a_of_type_Int);
    }
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     pyv
 * JD-Core Version:    0.7.0.1
 */