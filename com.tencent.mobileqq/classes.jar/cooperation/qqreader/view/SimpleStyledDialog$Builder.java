package cooperation.qqreader.view;

import android.content.Context;
import android.view.View.OnClickListener;

public class SimpleStyledDialog$Builder
{
  private final Context jdField_a_of_type_AndroidContentContext;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean = true;
  private View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean = true;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean = true;
  private String d;
  
  public SimpleStyledDialog$Builder(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public Builder a(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
    return this;
  }
  
  public Builder a(String paramString, View.OnClickListener paramOnClickListener)
  {
    this.d = paramString;
    this.jdField_b_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
    return this;
  }
  
  public SimpleStyledDialog a()
  {
    return new SimpleStyledDialog(this, null);
  }
  
  public Builder b(String paramString, View.OnClickListener paramOnClickListener)
  {
    this.jdField_c_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qqreader.view.SimpleStyledDialog.Builder
 * JD-Core Version:    0.7.0.1
 */