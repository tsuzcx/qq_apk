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
    String str = paramMenuItem.b();
    Drawable localDrawable = paramMenuItem.a();
    View localView = ((LayoutInflater)super.getContext().getSystemService("layout_inflater")).inflate(paramInt, null);
    ImageView localImageView1 = (ImageView)localView.findViewById(2131370813);
    ImageView localImageView2 = (ImageView)localView.findViewById(2131370804);
    TextView localTextView = (TextView)localView.findViewById(2131370816);
    if ((localImageView1 != null) && (paramMenuItem.a() > 0)) {
      localImageView1.setVisibility(0);
    } else if (localImageView1 != null) {
      localImageView1.setVisibility(8);
    }
    if (localDrawable != null) {
      localImageView2.setImageDrawable(localDrawable);
    } else {
      localImageView2.setVisibility(8);
    }
    if (str != null)
    {
      if (SubString.a(str) > 10) {
        localTextView.setText(SubString.a(str, 10, "..."));
      } else {
        localTextView.setText(str);
      }
    }
    else {
      localTextView.setVisibility(8);
    }
    localView.setOnClickListener(new PublicMenuBar.1(this, paramMenuItem.c(), paramMenuItem.a()));
    localView.setFocusable(true);
    localView.setClickable(true);
    paramMenuItem = new LinearLayout.LayoutParams(-1, -1, 1.0F);
    paramMenuItem.gravity = 17;
    localView.setLayoutParams(paramMenuItem);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localView);
    return localView;
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