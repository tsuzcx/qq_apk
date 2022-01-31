import android.content.Context;
import android.widget.LinearLayout;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentHotQuestion;
import com.tencent.widget.AbsListView.LayoutParams;

public class pgk
  extends pez
{
  public pgk(Context paramContext, azwg paramazwg, qoe paramqoe)
  {
    super(paramContext, paramazwg, paramqoe);
  }
  
  public pez a()
  {
    this.jdField_a_of_type_Boolean = true;
    return g();
  }
  
  public pez d()
  {
    if (!this.jdField_a_of_type_Boolean) {
      throw new Exception("buildComponent() must after buildComponent()!");
    }
    LinearLayout localLinearLayout = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
    localLinearLayout.setOrientation(1);
    localLinearLayout.setLayoutParams(new AbsListView.LayoutParams(aciy.a(150.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), -2));
    if ((this.jdField_a_of_type_Pey != null) && ((this.jdField_a_of_type_Pey instanceof ComponentContentHotQuestion))) {
      localLinearLayout.addView((ComponentContentHotQuestion)this.jdField_a_of_type_Pey);
    }
    a(localLinearLayout);
    return this;
  }
  
  public pez e()
  {
    return null;
  }
  
  public pez g()
  {
    this.jdField_a_of_type_Pey = new ComponentContentHotQuestion(this.jdField_a_of_type_AndroidContentContext);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pgk
 * JD-Core Version:    0.7.0.1
 */