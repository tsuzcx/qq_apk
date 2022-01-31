import android.content.Context;
import android.widget.LinearLayout;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentHotQuestion;
import com.tencent.widget.AbsListView.LayoutParams;

public class psc
  extends pqq
{
  public psc(Context paramContext, baxy parambaxy, ram paramram)
  {
    super(paramContext, parambaxy, paramram);
  }
  
  public pqq a()
  {
    this.jdField_a_of_type_Boolean = true;
    return g();
  }
  
  public pqq d()
  {
    if (!this.jdField_a_of_type_Boolean) {
      throw new Exception("buildComponent() must after buildComponent()!");
    }
    LinearLayout localLinearLayout = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
    localLinearLayout.setOrientation(1);
    localLinearLayout.setLayoutParams(new AbsListView.LayoutParams(actj.a(150.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), -2));
    if ((this.jdField_a_of_type_Pqp != null) && ((this.jdField_a_of_type_Pqp instanceof ComponentContentHotQuestion))) {
      localLinearLayout.addView((ComponentContentHotQuestion)this.jdField_a_of_type_Pqp);
    }
    a(localLinearLayout);
    return this;
  }
  
  public pqq e()
  {
    return null;
  }
  
  public pqq g()
  {
    this.jdField_a_of_type_Pqp = new ComponentContentHotQuestion(this.jdField_a_of_type_AndroidContentContext);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     psc
 * JD-Core Version:    0.7.0.1
 */