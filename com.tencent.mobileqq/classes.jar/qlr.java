import android.content.Context;
import android.widget.LinearLayout;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentBig;
import com.tencent.widget.AbsListView.LayoutParams;

public class qlr
  extends qjh
{
  public qlr(Context paramContext, aoof paramaoof, sel paramsel)
  {
    super(paramContext, paramaoof, paramsel);
  }
  
  public qjh a()
  {
    this.jdField_a_of_type_Boolean = true;
    return g().h();
  }
  
  public qjh d()
  {
    if (!this.jdField_a_of_type_Boolean) {
      throw new Exception("buildComponent() must after buildComponent()!");
    }
    LinearLayout localLinearLayout = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
    localLinearLayout.setOrientation(1);
    localLinearLayout.setLayoutParams(new AbsListView.LayoutParams(agej.a(220.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), -2));
    if ((this.jdField_a_of_type_Qjg != null) && ((this.jdField_a_of_type_Qjg instanceof ComponentContentBig))) {
      localLinearLayout.addView((ComponentContentBig)this.jdField_a_of_type_Qjg);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentTitle != null) {
      localLinearLayout.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentTitle);
    }
    a(localLinearLayout);
    return this;
  }
  
  public qjh e()
  {
    return null;
  }
  
  public qjh g()
  {
    this.jdField_a_of_type_Qjg = new ComponentContentBig(this.jdField_a_of_type_AndroidContentContext);
    return this;
  }
  
  public qjh o()
  {
    super.o();
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qlr
 * JD-Core Version:    0.7.0.1
 */