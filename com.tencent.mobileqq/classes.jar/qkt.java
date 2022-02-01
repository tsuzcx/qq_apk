import android.content.Context;
import android.widget.LinearLayout;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentHotSearch;
import com.tencent.widget.AbsListView.LayoutParams;

public class qkt
  extends qjh
{
  public qkt(Context paramContext, aoof paramaoof, sel paramsel)
  {
    super(paramContext, paramaoof, paramsel);
  }
  
  public qjh a()
  {
    this.jdField_a_of_type_Boolean = true;
    return g().l().n();
  }
  
  public qjh d()
  {
    LinearLayout localLinearLayout = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
    localLinearLayout.setOrientation(1);
    localLinearLayout.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
    if ((this.jdField_a_of_type_Qjg != null) && ((this.jdField_a_of_type_Qjg instanceof ComponentContentHotSearch))) {
      localLinearLayout.addView((ComponentContentHotSearch)this.jdField_a_of_type_Qjg);
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
    return this;
  }
  
  public qjh g()
  {
    this.jdField_a_of_type_Qjg = new ComponentContentHotSearch(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Sel);
    return this;
  }
  
  public qjh o()
  {
    super.o();
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qkt
 * JD-Core Version:    0.7.0.1
 */