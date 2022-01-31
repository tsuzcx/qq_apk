package com.tencent.mobileqq.widget;

import akwd;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.common.util.SubString;
import com.tencent.biz.ui.CustomMenuBar;
import com.tencent.biz.ui.MenuItem;

public class PublicMenuBar
  extends CustomMenuBar
{
  public PublicMenuBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public View a(MenuItem paramMenuItem, int paramInt)
  {
    String str = paramMenuItem.a();
    Drawable localDrawable = paramMenuItem.a();
    View localView = ((LayoutInflater)super.getContext().getSystemService("layout_inflater")).inflate(paramInt, null);
    ImageView localImageView1 = (ImageView)localView.findViewById(2131366828);
    ImageView localImageView2 = (ImageView)localView.findViewById(2131364574);
    TextView localTextView = (TextView)localView.findViewById(2131364575);
    if ((localImageView1 != null) && (paramMenuItem.a() > 0))
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
      if (SubString.a(str) <= 10) {
        break label209;
      }
      localTextView.setText(SubString.a(str, 10, "..."));
    }
    for (;;)
    {
      localView.setOnClickListener(new akwd(this, paramMenuItem.b(), paramMenuItem.a()));
      localView.setFocusable(true);
      localView.setClickable(true);
      paramMenuItem = new LinearLayout.LayoutParams(-1, -1, 1.0F);
      paramMenuItem.gravity = 17;
      localView.setLayoutParams(paramMenuItem);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\aaa.jar
 * Qualified Name:     com.tencent.mobileqq.widget.PublicMenuBar
 * JD-Core Version:    0.7.0.1
 */