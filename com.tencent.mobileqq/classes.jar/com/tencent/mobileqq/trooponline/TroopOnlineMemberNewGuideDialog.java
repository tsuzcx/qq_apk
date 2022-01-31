package com.tencent.mobileqq.trooponline;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.util.BitmapUtil;

public class TroopOnlineMemberNewGuideDialog
  extends Dialog
  implements View.OnClickListener
{
  protected View a;
  protected Button a;
  protected ImageView a;
  protected ImageView b;
  protected ImageView c;
  
  public TroopOnlineMemberNewGuideDialog(Context paramContext, Bitmap paramBitmap, View paramView)
  {
    super(paramContext, 2131624575);
    setContentView(2130971714);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131375412));
    this.b = ((ImageView)findViewById(2131375413));
    this.c = ((ImageView)findViewById(2131375414));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131375415));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_AndroidWidgetButton.getText().toString().equals("知道了")) {
      dismiss();
    }
    do
    {
      return;
      this.jdField_a_of_type_AndroidWidgetButton.setText("知道了");
      this.b.setImageResource(2130846399);
      ((LinearLayout.LayoutParams)this.b.getLayoutParams()).leftMargin = (-DisplayUtil.a(getContext(), 120.0F));
      ((LinearLayout.LayoutParams)this.b.getLayoutParams()).topMargin = (-DisplayUtil.a(getContext(), 40.0F));
      this.c.setImageResource(2130846402);
      ((LinearLayout.LayoutParams)this.c.getLayoutParams()).topMargin = (-DisplayUtil.a(getContext(), 15.0F));
      paramView = BitmapUtil.a(this.jdField_a_of_type_AndroidViewView);
      this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(0);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramView);
    } while (paramView == null);
    ((LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams()).gravity = 3;
    ((LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams()).leftMargin = paramView.getWidth();
    ((LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams()).topMargin = DisplayUtil.a(getContext(), 50.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\a2.jar
 * Qualified Name:     com.tencent.mobileqq.trooponline.TroopOnlineMemberNewGuideDialog
 * JD-Core Version:    0.7.0.1
 */