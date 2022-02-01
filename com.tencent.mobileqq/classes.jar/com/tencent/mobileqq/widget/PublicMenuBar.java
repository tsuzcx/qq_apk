package com.tencent.mobileqq.widget;

import aayp;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import bjbk;
import com.tencent.biz.ui.CustomMenuBar;
import nod;

public class PublicMenuBar
  extends CustomMenuBar
{
  public PublicMenuBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public View a(aayp paramaayp, int paramInt)
  {
    String str = paramaayp.b();
    Drawable localDrawable = paramaayp.a();
    View localView = ((LayoutInflater)super.getContext().getSystemService("layout_inflater")).inflate(paramInt, null);
    ImageView localImageView1 = (ImageView)localView.findViewById(2131370757);
    ImageView localImageView2 = (ImageView)localView.findViewById(2131370748);
    TextView localTextView = (TextView)localView.findViewById(2131370760);
    if ((localImageView1 != null) && (paramaayp.a() > 0))
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
      if (nod.a(str) <= 10) {
        break label209;
      }
      localTextView.setText(nod.a(str, 10, "..."));
    }
    for (;;)
    {
      localView.setOnClickListener(new bjbk(this, paramaayp.c(), paramaayp.a()));
      localView.setFocusable(true);
      localView.setClickable(true);
      paramaayp = new LinearLayout.LayoutParams(-1, -1, 1.0F);
      paramaayp.gravity = 17;
      localView.setLayoutParams(paramaayp);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.PublicMenuBar
 * JD-Core Version:    0.7.0.1
 */