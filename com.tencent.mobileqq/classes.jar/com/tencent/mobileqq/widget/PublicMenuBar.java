package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import bcpi;
import com.tencent.biz.ui.CustomMenuBar;
import naw;
import xee;

public class PublicMenuBar
  extends CustomMenuBar
{
  public PublicMenuBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public View a(xee paramxee, int paramInt)
  {
    String str = paramxee.a();
    Drawable localDrawable = paramxee.a();
    View localView = ((LayoutInflater)super.getContext().getSystemService("layout_inflater")).inflate(paramInt, null);
    ImageView localImageView1 = (ImageView)localView.findViewById(2131369930);
    ImageView localImageView2 = (ImageView)localView.findViewById(2131369920);
    TextView localTextView = (TextView)localView.findViewById(2131369933);
    if ((localImageView1 != null) && (paramxee.a() > 0))
    {
      localImageView1.setVisibility(0);
      if (localDrawable == null) {
        break label199;
      }
      localImageView2.setImageDrawable(localDrawable);
      label93:
      if (str == null) {
        break label219;
      }
      if (naw.a(str) <= 10) {
        break label209;
      }
      localTextView.setText(naw.a(str, 10, "..."));
    }
    for (;;)
    {
      localView.setOnClickListener(new bcpi(this, paramxee.b(), paramxee.a()));
      localView.setFocusable(true);
      localView.setClickable(true);
      paramxee = new LinearLayout.LayoutParams(-1, -1, 1.0F);
      paramxee.gravity = 17;
      localView.setLayoutParams(paramxee);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localView);
      return localView;
      if (localImageView1 == null) {
        break;
      }
      localImageView1.setVisibility(8);
      break;
      label199:
      localImageView2.setVisibility(8);
      break label93;
      label209:
      localTextView.setText(str);
      continue;
      label219:
      localTextView.setVisibility(8);
    }
  }
  
  public void setSwitchButtonVisibility(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.PublicMenuBar
 * JD-Core Version:    0.7.0.1
 */