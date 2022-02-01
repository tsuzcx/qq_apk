package com.tencent.mobileqq.trooppiceffects;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class TroopPicEffectsEditActivity$ItemListAdapter
  extends BaseAdapter
{
  protected TroopPicEffectsEditActivity$ItemListAdapter(TroopPicEffectsEditActivity paramTroopPicEffectsEditActivity) {}
  
  public int getCount()
  {
    return this.a.a.length;
  }
  
  public Object getItem(int paramInt)
  {
    return this.a.a[paramInt];
  }
  
  public long getItemId(int paramInt)
  {
    return this.a.a[paramInt].jdField_a_of_type_Int;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = 0;
    if (paramView == null)
    {
      localObject1 = new TroopPicEffectsEditActivity.ViewHolder();
      paramView = LayoutInflater.from(this.a).inflate(2131562993, paramViewGroup, false);
      ((TroopPicEffectsEditActivity.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131379336));
      ((TroopPicEffectsEditActivity.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379338));
      ((TroopPicEffectsEditActivity.ViewHolder)localObject1).jdField_a_of_type_AndroidViewView = paramView.findViewById(2131379337);
      paramView.setTag(localObject1);
    }
    else
    {
      localObject1 = (TroopPicEffectsEditActivity.ViewHolder)paramView.getTag();
    }
    Object localObject2 = URLDrawable.URLDrawableOptions.obtain();
    ColorDrawable localColorDrawable = new ColorDrawable(0);
    ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = localColorDrawable;
    ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = localColorDrawable;
    localObject2 = URLDrawable.getDrawable(this.a.a[paramInt].jdField_b_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject2);
    ((URLDrawable)localObject2).setTag(URLDrawableDecodeHandler.b(190, 270, DisplayUtil.a(this.a, 3.0F)));
    ((URLDrawable)localObject2).setDecodeHandler(URLDrawableDecodeHandler.i);
    ((TroopPicEffectsEditActivity.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject2);
    ((TroopPicEffectsEditActivity.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText(this.a.a[paramInt].jdField_a_of_type_JavaLangString);
    localObject2 = new GradientDrawable();
    ((GradientDrawable)localObject2).setShape(0);
    ((GradientDrawable)localObject2).setCornerRadii(new float[] { 0.0F, 0.0F, 0.0F, 0.0F, DisplayUtil.a(this.a, 5.0F), DisplayUtil.a(this.a, 5.0F), DisplayUtil.a(this.a, 5.0F), DisplayUtil.a(this.a, 5.0F) });
    ((GradientDrawable)localObject2).setColor(this.a.a[paramInt].jdField_b_of_type_Int);
    ((TroopPicEffectsEditActivity.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView.setBackgroundDrawable((Drawable)localObject2);
    Object localObject1 = ((TroopPicEffectsEditActivity.ViewHolder)localObject1).jdField_a_of_type_AndroidViewView;
    if (!this.a.a[paramInt].jdField_a_of_type_Boolean) {
      i = 8;
    }
    ((View)localObject1).setVisibility(i);
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.trooppiceffects.TroopPicEffectsEditActivity.ItemListAdapter
 * JD-Core Version:    0.7.0.1
 */