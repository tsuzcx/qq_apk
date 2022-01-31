import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.widget.AbsListView.LayoutParams;
import java.lang.reflect.Constructor;

public class pti<T extends View>
  extends pqq
{
  private Class<T> a;
  
  pti(Context paramContext, baxy parambaxy, ram paramram, Class<T> paramClass)
  {
    super(paramContext, parambaxy, paramram);
    this.jdField_a_of_type_JavaLangClass = paramClass;
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
    if ((this.jdField_a_of_type_Pqp != null) && (this.jdField_a_of_type_Pqp.getClass().equals(this.jdField_a_of_type_JavaLangClass))) {
      localLinearLayout.addView((View)this.jdField_a_of_type_Pqp);
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
    try
    {
      this.jdField_a_of_type_Pqp = ((pqp)this.jdField_a_of_type_JavaLangClass.getConstructor(new Class[] { Context.class }).newInstance(new Object[] { this.jdField_a_of_type_AndroidContentContext }));
      return this;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return this;
  }
  
  public pqq o()
  {
    super.o();
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pti
 * JD-Core Version:    0.7.0.1
 */