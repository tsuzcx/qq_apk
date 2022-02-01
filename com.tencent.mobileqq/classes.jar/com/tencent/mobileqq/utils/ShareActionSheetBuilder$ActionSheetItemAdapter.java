package com.tencent.mobileqq.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.TextPaint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Iterator;
import java.util.List;

public class ShareActionSheetBuilder$ActionSheetItemAdapter
  extends BaseAdapter
{
  private int jdField_a_of_type_Int = 0;
  private Resources jdField_a_of_type_AndroidContentResResources;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private ShareActionSheetBuilder.ActionSheetItemAdapter.IconFactory jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItemAdapter$IconFactory;
  private List<ShareActionSheetBuilder.ActionSheetItem> jdField_a_of_type_JavaUtilList;
  
  public ShareActionSheetBuilder$ActionSheetItemAdapter(Context paramContext, List<ShareActionSheetBuilder.ActionSheetItem> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
  }
  
  protected int a()
  {
    return 2131559010;
  }
  
  public ShareActionSheetBuilder.ActionSheetItem a(int paramInt)
  {
    ShareActionSheetBuilder.ActionSheetItem localActionSheetItem;
    if ((this.jdField_a_of_type_JavaUtilList == null) || (paramInt < 0))
    {
      localActionSheetItem = null;
      return localActionSheetItem;
    }
    int j = -1;
    int i = 0;
    for (;;)
    {
      if (i >= this.jdField_a_of_type_JavaUtilList.size()) {
        break label89;
      }
      localActionSheetItem = (ShareActionSheetBuilder.ActionSheetItem)this.jdField_a_of_type_JavaUtilList.get(i);
      int k = j;
      if (localActionSheetItem != null)
      {
        k = j;
        if (localActionSheetItem.visibility == 0) {
          k = j + 1;
        }
      }
      if (k == paramInt) {
        break;
      }
      i += 1;
      j = k;
    }
    label89:
    return null;
  }
  
  protected ShareActionSheetBuilder.ActionSheetItemAdapter.IconFactory a(Context paramContext)
  {
    return new ShareActionSheetBuilder.ActionSheetItemAdapter.IconFactory(paramContext);
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return 0;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      ShareActionSheetBuilder.ActionSheetItem localActionSheetItem = (ShareActionSheetBuilder.ActionSheetItem)localIterator.next();
      if ((localActionSheetItem == null) || (localActionSheetItem.visibility != 0)) {
        break label60;
      }
      i += 1;
    }
    label60:
    for (;;)
    {
      break;
      return i;
    }
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int j = 0;
    if (this.jdField_a_of_type_AndroidContentResResources == null) {
      this.jdField_a_of_type_AndroidContentResResources = paramViewGroup.getContext().getResources();
    }
    if (this.jdField_a_of_type_Int == 0) {
      this.jdField_a_of_type_Int = ((int)this.jdField_a_of_type_AndroidContentResResources.getDimension(2131296816));
    }
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItemAdapter$IconFactory == null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItemAdapter$IconFactory = a(paramViewGroup.getContext());
    }
    View localView;
    if (paramView == null)
    {
      localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(a(), paramViewGroup, false);
      paramView = new ShareActionSheetBuilder.ActionSheetItemViewHolder();
      paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131377941));
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131377942));
      localView.setTag(paramView);
    }
    for (;;)
    {
      paramView.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItem = a(paramInt);
      if (paramView.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItem != null) {
        break;
      }
      QLog.e("ShareActionSheetBuilder", 2, "ShareActionSheetBuilder.ActionSheetItemAdapter.getView() getItem(" + paramInt + ") == null !!!");
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return localView;
      localObject1 = (ShareActionSheetBuilder.ActionSheetItemViewHolder)paramView.getTag();
      localView = paramView;
      paramView = (View)localObject1;
    }
    localView.setId(paramView.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItem.id);
    float f = this.jdField_a_of_type_AndroidContentResResources.getDimension(2131296816);
    Object localObject1 = paramView.jdField_a_of_type_AndroidWidgetTextView.getPaint();
    ((TextPaint)localObject1).setTextSize(this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131299097));
    Object localObject2 = paramView.jdField_a_of_type_AndroidWidgetTextView;
    String str = paramView.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItem.label;
    int i;
    if (paramView.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItem.firstLineCount > 0)
    {
      i = paramView.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItem.firstLineCount;
      label285:
      ((TextView)localObject2).setText(ShareActionSheetBuilder.a((TextPaint)localObject1, f, str, i));
      i = -8947849;
      localObject1 = paramView.jdField_a_of_type_AndroidWidgetTextView;
      if (!paramView.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItem.enable) {
        break label498;
      }
      label321:
      ((TextView)localObject1).setTextColor(i);
      if (!paramView.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItem.iconNeedBg) {
        break label565;
      }
      if (paramView.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItem.iconDrawable == null) {
        break label506;
      }
      localObject1 = paramView.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItem.iconDrawable;
      label357:
      i = ((Drawable)localObject1).getIntrinsicWidth();
      int k = ((Drawable)localObject1).getIntrinsicHeight();
      if (this.jdField_a_of_type_Int <= i) {
        break label525;
      }
      i = (int)((this.jdField_a_of_type_Int - i) / 2.0F);
      label393:
      if (this.jdField_a_of_type_Int > k) {
        j = (int)((this.jdField_a_of_type_Int - k) / 2.0F);
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItemAdapter$IconFactory.a((Drawable)localObject1, i, j);
      if (!paramView.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItem.enable) {
        break label531;
      }
      localObject2 = ShareActionSheetBuilder.ActionSheetItemAdapter.IconFactory.a(this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItemAdapter$IconFactory, (Drawable)localObject1);
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItemAdapter$IconFactory.a((Drawable)localObject1, (Drawable)localObject2);
      paramView.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
      label473:
      if (Build.VERSION.SDK_INT < 16) {
        break label554;
      }
      paramView.jdField_a_of_type_AndroidWidgetImageView.setBackground(null);
    }
    for (;;)
    {
      break;
      i = 5;
      break label285;
      label498:
      i = 2138535799;
      break label321;
      label506:
      localObject1 = this.jdField_a_of_type_AndroidContentResResources.getDrawable(paramView.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItem.icon);
      break label357;
      label525:
      i = 0;
      break label393;
      label531:
      localObject1 = ShareActionSheetBuilder.ActionSheetItemAdapter.IconFactory.b(this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItemAdapter$IconFactory, (Drawable)localObject1);
      paramView.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
      break label473;
      label554:
      paramView.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(null);
      continue;
      label565:
      paramView.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130837562);
      if (paramView.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItem.iconDrawable != null)
      {
        if (Build.VERSION.SDK_INT >= 16) {
          paramView.jdField_a_of_type_AndroidWidgetImageView.setBackground(paramView.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItem.iconDrawable);
        } else {
          paramView.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(paramView.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItem.iconDrawable);
        }
      }
      else {
        paramView.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(paramView.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItem.icon);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItemAdapter
 * JD-Core Version:    0.7.0.1
 */