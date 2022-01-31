import android.content.Context;
import android.widget.LinearLayout;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentBig;
import com.tencent.widget.AbsListView.LayoutParams;

public class ptd
  extends pqt
{
  public ptd(Context paramContext, baxk parambaxk, rap paramrap)
  {
    super(paramContext, parambaxk, paramrap);
  }
  
  public pqt a()
  {
    this.jdField_a_of_type_Boolean = true;
    return g().h();
  }
  
  public pqt d()
  {
    if (!this.jdField_a_of_type_Boolean) {
      throw new Exception("buildComponent() must after buildComponent()!");
    }
    LinearLayout localLinearLayout = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
    localLinearLayout.setOrientation(1);
    if ((this.jdField_a_of_type_JavaLangObject != null) && ((this.jdField_a_of_type_JavaLangObject instanceof pbi)) && (onk.s(((pbi)this.jdField_a_of_type_JavaLangObject).a()))) {
      localLinearLayout.setLayoutParams(new AbsListView.LayoutParams(actn.a(250.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), -2));
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_Pqs != null) && ((this.jdField_a_of_type_Pqs instanceof ComponentContentBig))) {
        localLinearLayout.addView((ComponentContentBig)this.jdField_a_of_type_Pqs);
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentTitle != null) {
        localLinearLayout.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentTitle);
      }
      a(localLinearLayout);
      return this;
      localLinearLayout.setLayoutParams(new AbsListView.LayoutParams(actn.a(220.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), -2));
    }
  }
  
  public pqt e()
  {
    return null;
  }
  
  public pqt g()
  {
    this.jdField_a_of_type_Pqs = new ComponentContentBig(this.jdField_a_of_type_AndroidContentContext);
    return this;
  }
  
  public pqt o()
  {
    super.o();
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ptd
 * JD-Core Version:    0.7.0.1
 */