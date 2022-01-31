import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.widget.AbsListView.LayoutParams;
import java.lang.reflect.Constructor;

public class ptl<T extends View>
  extends pqt
{
  private Class<T> a;
  
  ptl(Context paramContext, baxk parambaxk, rap paramrap, Class<T> paramClass)
  {
    super(paramContext, parambaxk, paramrap);
    this.jdField_a_of_type_JavaLangClass = paramClass;
  }
  
  public pqt a()
  {
    this.jdField_a_of_type_Boolean = true;
    return g().l().n();
  }
  
  public pqt d()
  {
    LinearLayout localLinearLayout = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
    localLinearLayout.setOrientation(1);
    localLinearLayout.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
    if ((this.jdField_a_of_type_Pqs != null) && (this.jdField_a_of_type_Pqs.getClass().equals(this.jdField_a_of_type_JavaLangClass))) {
      localLinearLayout.addView((View)this.jdField_a_of_type_Pqs);
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
  
  public pqt e()
  {
    return this;
  }
  
  public pqt g()
  {
    try
    {
      this.jdField_a_of_type_Pqs = ((pqs)this.jdField_a_of_type_JavaLangClass.getConstructor(new Class[] { Context.class }).newInstance(new Object[] { this.jdField_a_of_type_AndroidContentContext }));
      return this;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return this;
  }
  
  public pqt o()
  {
    super.o();
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ptl
 * JD-Core Version:    0.7.0.1
 */