import android.content.Context;
import android.widget.LinearLayout;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentBig;
import com.tencent.widget.AbsListView.LayoutParams;

public class phi
  extends pez
{
  public phi(Context paramContext, azwg paramazwg, qoe paramqoe)
  {
    super(paramContext, paramazwg, paramqoe);
  }
  
  public pez a()
  {
    this.jdField_a_of_type_Boolean = true;
    return g().h();
  }
  
  public pez d()
  {
    if (!this.jdField_a_of_type_Boolean) {
      throw new Exception("buildComponent() must after buildComponent()!");
    }
    LinearLayout localLinearLayout = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
    localLinearLayout.setOrientation(1);
    if ((this.jdField_a_of_type_JavaLangObject != null) && ((this.jdField_a_of_type_JavaLangObject instanceof oqh)) && (obz.s(((oqh)this.jdField_a_of_type_JavaLangObject).a()))) {
      localLinearLayout.setLayoutParams(new AbsListView.LayoutParams(aciy.a(250.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), -2));
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_Pey != null) && ((this.jdField_a_of_type_Pey instanceof ComponentContentBig))) {
        localLinearLayout.addView((ComponentContentBig)this.jdField_a_of_type_Pey);
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentTitle != null) {
        localLinearLayout.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentTitle);
      }
      a(localLinearLayout);
      return this;
      localLinearLayout.setLayoutParams(new AbsListView.LayoutParams(aciy.a(220.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), -2));
    }
  }
  
  public pez e()
  {
    return null;
  }
  
  public pez g()
  {
    this.jdField_a_of_type_Pey = new ComponentContentBig(this.jdField_a_of_type_AndroidContentContext);
    return this;
  }
  
  public pez o()
  {
    super.o();
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     phi
 * JD-Core Version:    0.7.0.1
 */