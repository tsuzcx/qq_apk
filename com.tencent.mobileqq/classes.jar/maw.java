import android.content.res.Resources;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

class maw
  extends mav
{
  View jdField_a_of_type_AndroidViewView;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  
  maw(LinearLayout paramLinearLayout)
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = paramLinearLayout;
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramLinearLayout.findViewById(2131373625));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramLinearLayout.findViewById(2131373622));
    this.jdField_a_of_type_AndroidViewView = paramLinearLayout.findViewById(2131373626);
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramLinearLayout.findViewById(2131373628));
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
  
  boolean a(may parammay)
  {
    a();
    if ((parammay.b) && (parammay.jdField_a_of_type_AndroidGraphicsBitmap != null) && (this.jdField_a_of_type_AndroidWidgetImageView != null))
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(parammay.jdField_a_of_type_AndroidGraphicsBitmap);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    if ((parammay.c) && (this.jdField_a_of_type_AndroidWidgetProgressBar != null)) {
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    }
    if ((parammay.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_AndroidViewView != null)) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
    if ((parammay.jdField_a_of_type_AndroidTextSpannableString != null) && (this.jdField_a_of_type_AndroidWidgetTextView != null)) {
      mat.a(this.jdField_a_of_type_AndroidWidgetTextView, parammay);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     maw
 * JD-Core Version:    0.7.0.1
 */