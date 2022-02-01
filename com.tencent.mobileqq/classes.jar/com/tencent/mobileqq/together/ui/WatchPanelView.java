package com.tencent.mobileqq.together.ui;

import agej;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import bhez;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.PatchedButton;
import com.tencent.widget.ThemeImageView;

public class WatchPanelView
  extends RelativeLayout
  implements View.OnClickListener
{
  int jdField_a_of_type_Int;
  Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  public View.OnClickListener a;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  URLDrawable jdField_a_of_type_ComTencentImageURLDrawable;
  PatchedButton jdField_a_of_type_ComTencentWidgetPatchedButton;
  TextView b;
  
  public WatchPanelView(Context paramContext)
  {
    super(paramContext);
    b();
  }
  
  private void b()
  {
    LayoutInflater.from(getContext()).inflate(2131561071, this, true);
    setBackgroundResource(2130837962);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131379130));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379133));
    this.jdField_a_of_type_ComTencentWidgetPatchedButton = ((PatchedButton)findViewById(2131379131));
    this.b = ((TextView)findViewById(2131379132));
    this.jdField_a_of_type_ComTencentWidgetPatchedButton.setOnClickListener(this);
    this.jdField_a_of_type_Int = agej.a(39.0F, getResources());
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentImageURLDrawable != null)
    {
      this.jdField_a_of_type_ComTencentImageURLDrawable.setDecodeHandler(null);
      this.jdField_a_of_type_ComTencentImageURLDrawable = null;
    }
  }
  
  public void a(int paramInt)
  {
    if ((this.jdField_a_of_type_AndroidWidgetImageView instanceof ThemeImageView)) {
      ((ThemeImageView)this.jdField_a_of_type_AndroidWidgetImageView).setMaskShape(paramInt);
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    this.b.setVisibility(paramInt);
    this.b.setText(paramString);
    this.b.setContentDescription(paramString);
  }
  
  public void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (!paramString.equals((String)this.jdField_a_of_type_AndroidWidgetImageView.getTag()))
      {
        Object localObject = URLDrawable.URLDrawableOptions.obtain();
        int i = this.jdField_a_of_type_Int;
        ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = i;
        ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = i;
        ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
        ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
        localObject = URLDrawable.getDrawable(paramString, (URLDrawable.URLDrawableOptions)localObject);
        ((URLDrawable)localObject).setTag(bhez.b(this.jdField_a_of_type_Int, this.jdField_a_of_type_Int, 6));
        ((URLDrawable)localObject).setDecodeHandler(bhez.e);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
        this.jdField_a_of_type_AndroidWidgetImageView.setTag(paramString);
        if (this.jdField_a_of_type_ComTencentImageURLDrawable != null) {
          this.jdField_a_of_type_ComTencentImageURLDrawable.setDecodeHandler(null);
        }
        this.jdField_a_of_type_ComTencentImageURLDrawable = ((URLDrawable)localObject);
      }
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    this.jdField_a_of_type_AndroidWidgetImageView.setTag("");
  }
  
  public void a(String paramString, int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
    this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(paramString);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(paramInt));
    setContentDescription(paramString);
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(paramInt);
  }
  
  public void b(String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "加入";
    }
    this.jdField_a_of_type_ComTencentWidgetPatchedButton.setText(str);
    this.jdField_a_of_type_ComTencentWidgetPatchedButton.setContentDescription(str);
  }
  
  public void c(int paramInt)
  {
    this.jdField_a_of_type_ComTencentWidgetPatchedButton.setVisibility(paramInt);
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_AndroidViewView$OnClickListener != null) {
      this.jdField_a_of_type_AndroidViewView$OnClickListener.onClick(paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.together.ui.WatchPanelView
 * JD-Core Version:    0.7.0.1
 */