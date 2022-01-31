import android.content.Context;
import android.widget.LinearLayout;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentBig;
import com.tencent.widget.AbsListView.LayoutParams;

public class pta
  extends pqq
{
  public pta(Context paramContext, baxy parambaxy, ram paramram)
  {
    super(paramContext, parambaxy, paramram);
  }
  
  public pqq a()
  {
    this.jdField_a_of_type_Boolean = true;
    return g().h();
  }
  
  public pqq d()
  {
    if (!this.jdField_a_of_type_Boolean) {
      throw new Exception("buildComponent() must after buildComponent()!");
    }
    LinearLayout localLinearLayout = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
    localLinearLayout.setOrientation(1);
    if ((this.jdField_a_of_type_JavaLangObject != null) && ((this.jdField_a_of_type_JavaLangObject instanceof pbf)) && (onh.s(((pbf)this.jdField_a_of_type_JavaLangObject).a()))) {
      localLinearLayout.setLayoutParams(new AbsListView.LayoutParams(actj.a(250.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), -2));
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_Pqp != null) && ((this.jdField_a_of_type_Pqp instanceof ComponentContentBig))) {
        localLinearLayout.addView((ComponentContentBig)this.jdField_a_of_type_Pqp);
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentTitle != null) {
        localLinearLayout.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentTitle);
      }
      a(localLinearLayout);
      return this;
      localLinearLayout.setLayoutParams(new AbsListView.LayoutParams(actj.a(220.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), -2));
    }
  }
  
  public pqq e()
  {
    return null;
  }
  
  public pqq g()
  {
    this.jdField_a_of_type_Pqp = new ComponentContentBig(this.jdField_a_of_type_AndroidContentContext);
    return this;
  }
  
  public pqq o()
  {
    super.o();
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pta
 * JD-Core Version:    0.7.0.1
 */