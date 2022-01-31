import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.widget.AbsListView.LayoutParams;
import java.lang.reflect.Constructor;

public class qac<T extends View>
  extends pxl
{
  private Class<T> a;
  
  qac(Context paramContext, bcws parambcws, rqj paramrqj, Class<T> paramClass)
  {
    super(paramContext, parambcws, paramrqj);
    this.jdField_a_of_type_JavaLangClass = paramClass;
  }
  
  public pxl a()
  {
    this.jdField_a_of_type_Boolean = true;
    return g().l().n();
  }
  
  public pxl d()
  {
    LinearLayout localLinearLayout = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
    localLinearLayout.setOrientation(1);
    localLinearLayout.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
    if ((this.jdField_a_of_type_Pxk != null) && (this.jdField_a_of_type_Pxk.getClass().equals(this.jdField_a_of_type_JavaLangClass))) {
      localLinearLayout.addView((View)this.jdField_a_of_type_Pxk);
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
  
  public pxl e()
  {
    return this;
  }
  
  public pxl g()
  {
    try
    {
      this.jdField_a_of_type_Pxk = ((pxk)this.jdField_a_of_type_JavaLangClass.getConstructor(new Class[] { Context.class }).newInstance(new Object[] { this.jdField_a_of_type_AndroidContentContext }));
      return this;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return this;
  }
  
  public pxl o()
  {
    super.o();
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     qac
 * JD-Core Version:    0.7.0.1
 */