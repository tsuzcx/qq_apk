package cooperation.qqreader.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import bhgr;

public class TabItemView
  extends LinearLayout
{
  public View a;
  public ImageView a;
  public TextView a;
  
  public TabItemView(Context paramContext)
  {
    this(paramContext, null, 0);
  }
  
  public TabItemView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public TabItemView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    LinearLayout localLinearLayout = new LinearLayout(paramContext);
    localLinearLayout.setOrientation(1);
    LinearLayout.LayoutParams localLayoutParams1 = new LinearLayout.LayoutParams(-1, bhgr.a(paramContext, 54.0F));
    this.jdField_a_of_type_AndroidViewView = new View(paramContext);
    LinearLayout.LayoutParams localLayoutParams2 = new LinearLayout.LayoutParams(-1, bhgr.a(paramContext, 1.0F));
    localLinearLayout.addView(this.jdField_a_of_type_AndroidViewView, localLayoutParams2);
    this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(paramContext);
    int i = bhgr.a(paramContext, 25.0F);
    localLayoutParams2 = new LinearLayout.LayoutParams(i, i);
    localLayoutParams2.gravity = 17;
    localLayoutParams2.setMargins(0, bhgr.a(paramContext, 5.0F), 0, bhgr.a(paramContext, 2.0F));
    localLinearLayout.addView(this.jdField_a_of_type_AndroidWidgetImageView, localLayoutParams2);
    this.jdField_a_of_type_AndroidWidgetTextView = new TextView(paramContext);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(2, 11.0F);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1728053248);
    this.jdField_a_of_type_AndroidWidgetTextView.setGravity(17);
    paramContext = new LinearLayout.LayoutParams(-1, -2);
    localLinearLayout.addView(this.jdField_a_of_type_AndroidWidgetTextView, paramContext);
    addView(localLinearLayout, localLayoutParams1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqreader.view.TabItemView
 * JD-Core Version:    0.7.0.1
 */