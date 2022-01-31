import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.widget.AbsListView.LayoutParams;
import java.lang.reflect.Constructor;

public class phq<T extends View>
  extends pez
{
  private Class<T> a;
  
  phq(Context paramContext, azwg paramazwg, qoe paramqoe, Class<T> paramClass)
  {
    super(paramContext, paramazwg, paramqoe);
    this.jdField_a_of_type_JavaLangClass = paramClass;
  }
  
  public pez a()
  {
    this.jdField_a_of_type_Boolean = true;
    return g().l().n();
  }
  
  public pez d()
  {
    LinearLayout localLinearLayout = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
    localLinearLayout.setOrientation(1);
    localLinearLayout.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
    if ((this.jdField_a_of_type_Pey != null) && (this.jdField_a_of_type_Pey.getClass().equals(this.jdField_a_of_type_JavaLangClass))) {
      localLinearLayout.addView((View)this.jdField_a_of_type_Pey);
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
  
  public pez e()
  {
    return this;
  }
  
  public pez g()
  {
    try
    {
      this.jdField_a_of_type_Pey = ((pey)this.jdField_a_of_type_JavaLangClass.getConstructor(new Class[] { Context.class }).newInstance(new Object[] { this.jdField_a_of_type_AndroidContentContext }));
      return this;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return this;
  }
  
  public pez o()
  {
    super.o();
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     phq
 * JD-Core Version:    0.7.0.1
 */