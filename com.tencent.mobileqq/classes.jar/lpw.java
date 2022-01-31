import android.content.res.Resources;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

class lpw
  extends lpv
{
  View jdField_a_of_type_AndroidViewView;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  
  lpw(LinearLayout paramLinearLayout)
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = paramLinearLayout;
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramLinearLayout.findViewById(2131306793));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramLinearLayout.findViewById(2131306790));
    this.jdField_a_of_type_AndroidViewView = paramLinearLayout.findViewById(2131306794);
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramLinearLayout.findViewById(2131306796));
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
  
  boolean a(lpy paramlpy)
  {
    a();
    if ((paramlpy.b) && (paramlpy.jdField_a_of_type_AndroidGraphicsBitmap != null) && (this.jdField_a_of_type_AndroidWidgetImageView != null))
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramlpy.jdField_a_of_type_AndroidGraphicsBitmap);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    if ((paramlpy.c) && (this.jdField_a_of_type_AndroidWidgetProgressBar != null)) {
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    }
    if ((paramlpy.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_AndroidViewView != null)) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
    if ((paramlpy.jdField_a_of_type_AndroidTextSpannableString != null) && (this.jdField_a_of_type_AndroidWidgetTextView != null)) {
      lpt.a(this.jdField_a_of_type_AndroidWidgetTextView, paramlpy);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lpw
 * JD-Core Version:    0.7.0.1
 */