package com.tencent.mobileqq.troop.widget;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mobileqq.utils.DisplayUtils;

public class PublishItemBar
  extends LinearLayout
  implements View.OnClickListener
{
  private Handler jdField_a_of_type_AndroidOsHandler;
  private boolean jdField_a_of_type_Boolean;
  private Handler jdField_b_of_type_AndroidOsHandler;
  private boolean jdField_b_of_type_Boolean;
  private Handler jdField_c_of_type_AndroidOsHandler;
  private boolean jdField_c_of_type_Boolean;
  private Handler d;
  
  public PublishItemBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void a(int paramInt)
  {
    boolean bool2 = false;
    if ((paramInt & 0x1) == 1)
    {
      bool1 = true;
      this.jdField_a_of_type_Boolean = bool1;
      if ((paramInt & 0x2) != 2) {
        break label304;
      }
    }
    label304:
    for (boolean bool1 = true;; bool1 = false)
    {
      this.jdField_b_of_type_Boolean = bool1;
      bool1 = bool2;
      if ((paramInt & 0x4) == 4) {
        bool1 = true;
      }
      this.jdField_c_of_type_Boolean = bool1;
      if (getChildCount() > 0) {
        removeAllViews();
      }
      ImageButton localImageButton;
      if (this.jdField_a_of_type_Boolean)
      {
        localImageButton = new ImageButton(getContext());
        localImageButton.setOnClickListener(this);
        localImageButton.setTag(Integer.valueOf(1));
        localImageButton.setImageResource(2130840580);
        localImageButton.setContentDescription(getResources().getString(2131430474));
        a(localImageButton);
        localImageButton = new ImageButton(getContext());
        localImageButton.setOnClickListener(this);
        localImageButton.setTag(Integer.valueOf(5));
        localImageButton.setImageResource(2130840577);
        localImageButton.setContentDescription(getResources().getString(2131430475));
        a(localImageButton);
      }
      if (this.jdField_b_of_type_Boolean)
      {
        localImageButton = new ImageButton(getContext());
        localImageButton.setOnClickListener(this);
        localImageButton.setTag(Integer.valueOf(2));
        localImageButton.setImageResource(2130840572);
        localImageButton.setContentDescription(getResources().getString(2131430477));
        a(localImageButton);
      }
      if (this.jdField_c_of_type_Boolean)
      {
        localImageButton = new ImageButton(getContext());
        localImageButton.setOnClickListener(this);
        localImageButton.setTag(Integer.valueOf(4));
        localImageButton.setImageResource(2130840579);
        localImageButton.setContentDescription(getResources().getString(2131430478));
        a(localImageButton);
      }
      return;
      bool1 = false;
      break;
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if ((paramInt2 != 0) && (paramInt2 != 1)) {}
    int j;
    int i;
    do
    {
      return;
      j = getChildCount();
      i = 0;
    } while (i >= j);
    Object localObject2 = getChildAt(i);
    Object localObject1 = ((View)localObject2).getTag();
    if (((localObject1 instanceof Integer)) && ((localObject2 instanceof ImageButton)))
    {
      localObject2 = (ImageButton)localObject2;
      if (((Integer)localObject1).intValue() != paramInt1) {
        break label121;
      }
      switch (paramInt2)
      {
      }
    }
    for (;;)
    {
      i += 1;
      break;
      ((ImageButton)localObject2).setSelected(false);
      continue;
      ((ImageButton)localObject2).setSelected(true);
      continue;
      label121:
      ((ImageButton)localObject2).setSelected(false);
    }
  }
  
  public void a(ImageButton paramImageButton)
  {
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    paramImageButton.setPadding(0, 0, (int)DisplayUtils.a(getContext(), 24.0F), 0);
    paramImageButton.setBackgroundResource(2130846489);
    paramImageButton.setLayoutParams(localLayoutParams);
    addView(paramImageButton);
  }
  
  public void onClick(View paramView)
  {
    paramView = paramView.getTag();
    if ((paramView != null) && (this.jdField_a_of_type_AndroidOsHandler != null)) {
      switch (((Integer)paramView).intValue())
      {
      }
    }
    do
    {
      do
      {
        do
        {
          return;
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
        } while (this.d == null);
        this.d.sendEmptyMessage(2);
        return;
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(4);
      } while (this.jdField_c_of_type_AndroidOsHandler == null);
      this.jdField_c_of_type_AndroidOsHandler.sendEmptyMessage(4);
      return;
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
      return;
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(5);
      return;
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(3);
    } while (this.jdField_b_of_type_AndroidOsHandler == null);
    this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessage(3);
  }
  
  public void setAudioCallback(Handler paramHandler)
  {
    this.d = paramHandler;
  }
  
  public void setAudioEnable(boolean paramBoolean)
  {
    int j = getChildCount();
    int i = 0;
    if (i < j)
    {
      View localView = getChildAt(i);
      localView.setEnabled(paramBoolean);
      if ((localView instanceof ImageButton))
      {
        if (!paramBoolean) {
          break label54;
        }
        ((ImageButton)localView).setImageResource(2130841397);
      }
      for (;;)
      {
        i += 1;
        break;
        label54:
        ((ImageButton)localView).setImageResource(2130841396);
      }
    }
  }
  
  public void setCallback(Handler paramHandler)
  {
    this.jdField_a_of_type_AndroidOsHandler = paramHandler;
  }
  
  public void setMusicCallback(Handler paramHandler)
  {
    this.jdField_c_of_type_AndroidOsHandler = paramHandler;
  }
  
  public void setVideoCallback(Handler paramHandler)
  {
    this.jdField_b_of_type_AndroidOsHandler = paramHandler;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\a2.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.PublishItemBar
 * JD-Core Version:    0.7.0.1
 */