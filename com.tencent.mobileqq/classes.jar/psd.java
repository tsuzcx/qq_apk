import android.content.Context;
import android.widget.LinearLayout;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentHotSearch;
import com.tencent.widget.AbsListView.LayoutParams;

public class psd
  extends pqq
{
  public psd(Context paramContext, baxy parambaxy, ram paramram)
  {
    super(paramContext, parambaxy, paramram);
  }
  
  public pqq a()
  {
    this.jdField_a_of_type_Boolean = true;
    return g().l().n();
  }
  
  public pqq d()
  {
    LinearLayout localLinearLayout = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
    localLinearLayout.setOrientation(1);
    localLinearLayout.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
    if ((this.jdField_a_of_type_Pqp != null) && ((this.jdField_a_of_type_Pqp instanceof ComponentContentHotSearch))) {
      localLinearLayout.addView((ComponentContentHotSearch)this.jdField_a_of_type_Pqp);
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
    return this;
  }
  
  public pqq g()
  {
    this.jdField_a_of_type_Pqp = new ComponentContentHotSearch(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Ram);
    return this;
  }
  
  public pqq o()
  {
    super.o();
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     psd
 * JD-Core Version:    0.7.0.1
 */