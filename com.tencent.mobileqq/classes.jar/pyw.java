import android.content.Context;
import android.widget.LinearLayout;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentHotQuestion;
import com.tencent.widget.AbsListView.LayoutParams;

public class pyw
  extends pxl
{
  public pyw(Context paramContext, bdbb parambdbb, rqj paramrqj)
  {
    super(paramContext, parambdbb, paramrqj);
  }
  
  public pxl a()
  {
    this.jdField_a_of_type_Boolean = true;
    return g();
  }
  
  public pxl d()
  {
    if (!this.jdField_a_of_type_Boolean) {
      throw new Exception("buildComponent() must after buildComponent()!");
    }
    LinearLayout localLinearLayout = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
    localLinearLayout.setOrientation(1);
    localLinearLayout.setLayoutParams(new AbsListView.LayoutParams(aepi.a(150.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), -2));
    if ((this.jdField_a_of_type_Pxk != null) && ((this.jdField_a_of_type_Pxk instanceof ComponentContentHotQuestion))) {
      localLinearLayout.addView((ComponentContentHotQuestion)this.jdField_a_of_type_Pxk);
    }
    a(localLinearLayout);
    return this;
  }
  
  public pxl e()
  {
    return null;
  }
  
  public pxl g()
  {
    this.jdField_a_of_type_Pxk = new ComponentContentHotQuestion(this.jdField_a_of_type_AndroidContentContext);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     pyw
 * JD-Core Version:    0.7.0.1
 */