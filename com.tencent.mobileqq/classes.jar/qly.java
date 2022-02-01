import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.widget.AbsListView.LayoutParams;
import java.lang.reflect.Constructor;

public class qly<T extends View>
  extends qjh
{
  private Class<T> a;
  
  public qly(Context paramContext, aoof paramaoof, sel paramsel, Class<T> paramClass)
  {
    super(paramContext, paramaoof, paramsel);
    this.jdField_a_of_type_JavaLangClass = paramClass;
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
    if ((this.jdField_a_of_type_Qjg != null) && (this.jdField_a_of_type_Qjg.getClass().equals(this.jdField_a_of_type_JavaLangClass))) {
      localLinearLayout.addView((View)this.jdField_a_of_type_Qjg);
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
    try
    {
      this.jdField_a_of_type_Qjg = ((qjg)this.jdField_a_of_type_JavaLangClass.getConstructor(new Class[] { Context.class }).newInstance(new Object[] { this.jdField_a_of_type_AndroidContentContext }));
      return this;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return this;
  }
  
  public qjh o()
  {
    super.o();
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qly
 * JD-Core Version:    0.7.0.1
 */