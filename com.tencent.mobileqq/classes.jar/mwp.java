import android.content.Context;
import android.content.res.Resources;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;

class mwp
  extends RelativeLayout
{
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ImageView b;
  
  public mwp(Context paramContext, int paramInt, CharSequence paramCharSequence)
  {
    super(paramContext);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.setMargins(paramContext.getResources().getDimensionPixelSize(2131297766), 0, 0, 0);
    localLayoutParams.addRule(15, -1);
    localLayoutParams.addRule(9, -1);
    this.b = new ImageView(paramContext);
    this.b.setImageResource(paramInt);
    this.b.setLayoutParams(localLayoutParams);
    localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.setMargins(0, 0, paramContext.getResources().getDimensionPixelSize(2131297766), 0);
    localLayoutParams.addRule(15, -1);
    localLayoutParams.addRule(11, -1);
    this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(paramContext);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130841928);
    this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams);
    localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(15, -1);
    localLayoutParams.addRule(14, -1);
    this.jdField_a_of_type_AndroidWidgetTextView = new TextView(paramContext);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramCharSequence);
    this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_AndroidWidgetTextView.setGravity(17);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16777216);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(0, paramContext.getResources().getDimension(2131298867));
    addView(this.b);
    addView(this.jdField_a_of_type_AndroidWidgetTextView);
    addView(this.jdField_a_of_type_AndroidWidgetImageView);
    setBackgroundResource(2130837556);
    setId(2131369158);
    setMinimumHeight(paramContext.getResources().getDimensionPixelSize(2131296614));
  }
  
  public void a(int paramInt)
  {
    this.b.setImageResource(paramInt);
  }
  
  public void a(CharSequence paramCharSequence)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramCharSequence);
  }
  
  public void a(boolean paramBoolean)
  {
    ImageView localImageView = this.jdField_a_of_type_AndroidWidgetImageView;
    if (paramBoolean) {}
    for (int i = 0;; i = 4)
    {
      localImageView.setVisibility(i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     mwp
 * JD-Core Version:    0.7.0.1
 */