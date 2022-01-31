import android.content.res.Resources;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

class maj
  extends mai
{
  View jdField_a_of_type_AndroidViewView;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  
  maj(LinearLayout paramLinearLayout)
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = paramLinearLayout;
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramLinearLayout.findViewById(2131372504));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramLinearLayout.findViewById(2131372501));
    this.jdField_a_of_type_AndroidViewView = paramLinearLayout.findViewById(2131372505);
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramLinearLayout.findViewById(2131372507));
  }
  
  Resources a()
  {
    return this.jdField_a_of_type_AndroidWidgetTextView.getResources();
  }
  
  void a()
  {
    if (!a()) {}
    do
    {
      return;
      if (this.jdField_a_of_type_AndroidWidgetImageView != null)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(null);
      }
      if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
      }
      if (this.jdField_a_of_type_AndroidViewView != null) {
        this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      }
    } while (this.jdField_a_of_type_AndroidWidgetProgressBar == null);
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
  }
  
  boolean a()
  {
    return (this.jdField_a_of_type_AndroidWidgetTextView != null) && (this.jdField_a_of_type_AndroidWidgetProgressBar != null);
  }
  
  boolean a(mal parammal)
  {
    a();
    if ((parammal.b) && (parammal.jdField_a_of_type_AndroidGraphicsBitmap != null) && (this.jdField_a_of_type_AndroidWidgetImageView != null))
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(parammal.jdField_a_of_type_AndroidGraphicsBitmap);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    if ((parammal.c) && (this.jdField_a_of_type_AndroidWidgetProgressBar != null)) {
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    }
    if ((parammal.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_AndroidViewView != null)) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
    if ((parammal.jdField_a_of_type_AndroidTextSpannableString != null) && (this.jdField_a_of_type_AndroidWidgetTextView != null)) {
      mag.a(this.jdField_a_of_type_AndroidWidgetTextView, parammal);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     maj
 * JD-Core Version:    0.7.0.1
 */