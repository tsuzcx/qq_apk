package com.tencent.qqmini.sdk.core.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Handler.Callback;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import bena;
import bfgl;
import com.tencent.qqmini.sdk.core.proxy.KingCardProxy;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import java.util.HashMap;

public class CapsuleButton
  extends RelativeLayout
  implements Handler.Callback, View.OnClickListener
{
  public int a;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private bena jdField_a_of_type_Bena;
  public HashMap<String, Integer> a;
  private Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private Drawable c;
  private Drawable d;
  
  public CapsuleButton(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Int = -1;
    a();
  }
  
  private View a()
  {
    Object localObject = new ImageView(getContext());
    ((ImageView)localObject).setId(2131370277);
    ((ImageView)localObject).setContentDescription("更多");
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(bfgl.a(getContext(), 40.0F), -1);
    localLayoutParams.addRule(9, -1);
    ((ImageView)localObject).setScaleType(ImageView.ScaleType.CENTER_INSIDE);
    addView((View)localObject, localLayoutParams);
    localObject = new ImageView(getContext());
    ((ImageView)localObject).setId(2131370275);
    ((ImageView)localObject).setContentDescription("关闭");
    localLayoutParams = new RelativeLayout.LayoutParams(bfgl.a(getContext(), 40.0F), -1);
    localLayoutParams.addRule(11, -1);
    localLayoutParams.addRule(1, 2131370277);
    ((ImageView)localObject).setScaleType(ImageView.ScaleType.CENTER_INSIDE);
    addView((View)localObject, localLayoutParams);
    localObject = new View(getContext());
    ((View)localObject).setId(2131370276);
    localLayoutParams = new RelativeLayout.LayoutParams(bfgl.a(getContext(), 0.5F), bfgl.a(getContext(), 18.0F));
    localLayoutParams.addRule(13, -1);
    ((View)localObject).setBackgroundColor(436207616);
    addView((View)localObject, localLayoutParams);
    return this;
  }
  
  private void a()
  {
    setClipChildren(false);
    a();
    this.jdField_a_of_type_AndroidWidgetImageView = b();
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131370275));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131370276);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130840846);
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130840840);
    this.c = getResources().getDrawable(2130840843);
    this.d = getResources().getDrawable(2130840837);
  }
  
  private ImageView b()
  {
    ImageView localImageView = ((KingCardProxy)ProxyManager.get(KingCardProxy.class)).getCapsuleButtonMoreView(getContext());
    if (localImageView == null) {
      return (ImageView)findViewById(2131370277);
    }
    addView(localImageView);
    return localImageView;
  }
  
  public ImageView a()
  {
    return this.jdField_a_of_type_AndroidWidgetImageView;
  }
  
  public CapsuleButton a(bena parambena)
  {
    this.jdField_a_of_type_Bena = parambena;
    return this;
  }
  
  public void a(int paramInt)
  {
    if (paramInt == -1)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_b_of_type_AndroidGraphicsDrawableDrawable);
      this.jdField_a_of_type_AndroidViewView.setBackgroundColor(Color.parseColor("#4DFFFFFF"));
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.c);
    this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(this.d);
    this.jdField_a_of_type_AndroidViewView.setBackgroundColor(Color.parseColor("#1A000000"));
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage == null) {
      return false;
    }
    int i = paramMessage.what;
    return false;
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.jdField_a_of_type_AndroidWidgetImageView) {
      if (this.jdField_a_of_type_Bena != null) {
        this.jdField_a_of_type_Bena.b();
      }
    }
    while ((paramView != this.jdField_b_of_type_AndroidWidgetImageView) || (this.jdField_a_of_type_Bena == null)) {
      return;
    }
    this.jdField_a_of_type_Bena.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.widget.CapsuleButton
 * JD-Core Version:    0.7.0.1
 */