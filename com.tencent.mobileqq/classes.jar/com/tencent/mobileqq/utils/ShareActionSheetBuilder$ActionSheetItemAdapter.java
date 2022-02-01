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
    return 2131558904;
  }
  
  public ShareActionSheetBuilder.ActionSheetItem a(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      if (paramInt < 0) {
        return null;
      }
      int j = -1;
      int i = 0;
      while (i < this.jdField_a_of_type_JavaUtilList.size())
      {
        ShareActionSheetBuilder.ActionSheetItem localActionSheetItem = (ShareActionSheetBuilder.ActionSheetItem)this.jdField_a_of_type_JavaUtilList.get(i);
        int k = j;
        if (localActionSheetItem != null)
        {
          k = j;
          if (localActionSheetItem.visibility == 0) {
            k = j + 1;
          }
        }
        if (k == paramInt) {
          return localActionSheetItem;
        }
        i += 1;
        j = k;
      }
    }
    return null;
  }
  
  protected ShareActionSheetBuilder.ActionSheetItemAdapter.IconFactory a(Context paramContext)
  {
    return new ShareActionSheetBuilder.ActionSheetItemAdapter.IconFactory(paramContext);
  }
  
  public int getCount()
  {
    Object localObject = this.jdField_a_of_type_JavaUtilList;
    int i = 0;
    if (localObject == null) {
      return 0;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      ShareActionSheetBuilder.ActionSheetItem localActionSheetItem = (ShareActionSheetBuilder.ActionSheetItem)((Iterator)localObject).next();
      if ((localActionSheetItem != null) && (localActionSheetItem.visibility == 0)) {
        i += 1;
      }
    }
    return i;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (this.jdField_a_of_type_AndroidContentResResources == null) {
      this.jdField_a_of_type_AndroidContentResResources = paramViewGroup.getContext().getResources();
    }
    if (this.jdField_a_of_type_Int == 0) {
      this.jdField_a_of_type_Int = ((int)this.jdField_a_of_type_AndroidContentResResources.getDimension(2131296796));
    }
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItemAdapter$IconFactory == null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItemAdapter$IconFactory = a(paramViewGroup.getContext());
    }
    int j = 0;
    Object localObject1;
    if (paramView == null)
    {
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(a(), paramViewGroup, false);
      localObject1 = new ShareActionSheetBuilder.ActionSheetItemViewHolder();
      ((ShareActionSheetBuilder.ActionSheetItemViewHolder)localObject1).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131377364));
      ((ShareActionSheetBuilder.ActionSheetItemViewHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131377365));
      paramView.setTag(localObject1);
    }
    else
    {
      localObject1 = (ShareActionSheetBuilder.ActionSheetItemViewHolder)paramView.getTag();
    }
    ((ShareActionSheetBuilder.ActionSheetItemViewHolder)localObject1).jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItem = a(paramInt);
    if (((ShareActionSheetBuilder.ActionSheetItemViewHolder)localObject1).jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItem == null)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("ShareActionSheetBuilder.ActionSheetItemAdapter.getView() getItem(");
      ((StringBuilder)localObject1).append(paramInt);
      ((StringBuilder)localObject1).append(") == null !!!");
      QLog.e("ShareActionSheetBuilder", 2, ((StringBuilder)localObject1).toString());
    }
    else
    {
      paramView.setId(((ShareActionSheetBuilder.ActionSheetItemViewHolder)localObject1).jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItem.id);
      float f = this.jdField_a_of_type_AndroidContentResResources.getDimension(2131296796);
      Object localObject2 = ((ShareActionSheetBuilder.ActionSheetItemViewHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView.getPaint();
      ((TextPaint)localObject2).setTextSize(this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131299102));
      Object localObject3 = ((ShareActionSheetBuilder.ActionSheetItemViewHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView;
      String str = ((ShareActionSheetBuilder.ActionSheetItemViewHolder)localObject1).jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItem.label;
      if (((ShareActionSheetBuilder.ActionSheetItemViewHolder)localObject1).jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItem.firstLineCount > 0) {
        i = ((ShareActionSheetBuilder.ActionSheetItemViewHolder)localObject1).jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItem.firstLineCount;
      } else {
        i = 5;
      }
      ((TextView)localObject3).setText(ShareActionSheetBuilder.a((TextPaint)localObject2, f, str, i));
      int i = -8947849;
      localObject2 = ((ShareActionSheetBuilder.ActionSheetItemViewHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView;
      if (!((ShareActionSheetBuilder.ActionSheetItemViewHolder)localObject1).jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItem.enable) {
        i = 2138535799;
      }
      ((TextView)localObject2).setTextColor(i);
      if (((ShareActionSheetBuilder.ActionSheetItemViewHolder)localObject1).jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItem.iconNeedBg)
      {
        if (((ShareActionSheetBuilder.ActionSheetItemViewHolder)localObject1).jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItem.iconDrawable != null) {
          localObject2 = ((ShareActionSheetBuilder.ActionSheetItemViewHolder)localObject1).jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItem.iconDrawable;
        } else {
          localObject2 = this.jdField_a_of_type_AndroidContentResResources.getDrawable(((ShareActionSheetBuilder.ActionSheetItemViewHolder)localObject1).jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItem.icon);
        }
        i = ((Drawable)localObject2).getIntrinsicWidth();
        int k = ((Drawable)localObject2).getIntrinsicHeight();
        int m = this.jdField_a_of_type_Int;
        if (m > i) {
          i = (int)((m - i) / 2.0F);
        } else {
          i = 0;
        }
        m = this.jdField_a_of_type_Int;
        if (m > k) {
          j = (int)((m - k) / 2.0F);
        }
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItemAdapter$IconFactory.a((Drawable)localObject2, i, j);
        if (((ShareActionSheetBuilder.ActionSheetItemViewHolder)localObject1).jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItem.enable)
        {
          localObject3 = ShareActionSheetBuilder.ActionSheetItemAdapter.IconFactory.a(this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItemAdapter$IconFactory, (Drawable)localObject2);
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItemAdapter$IconFactory.a((Drawable)localObject2, (Drawable)localObject3);
          ((ShareActionSheetBuilder.ActionSheetItemViewHolder)localObject1).jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject2);
        }
        else
        {
          localObject2 = ShareActionSheetBuilder.ActionSheetItemAdapter.IconFactory.b(this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItemAdapter$IconFactory, (Drawable)localObject2);
          ((ShareActionSheetBuilder.ActionSheetItemViewHolder)localObject1).jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject2);
        }
        if (Build.VERSION.SDK_INT >= 16) {
          ((ShareActionSheetBuilder.ActionSheetItemViewHolder)localObject1).jdField_a_of_type_AndroidWidgetImageView.setBackground(null);
        } else {
          ((ShareActionSheetBuilder.ActionSheetItemViewHolder)localObject1).jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(null);
        }
      }
      else
      {
        ((ShareActionSheetBuilder.ActionSheetItemViewHolder)localObject1).jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130837649);
        if (((ShareActionSheetBuilder.ActionSheetItemViewHolder)localObject1).jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItem.iconDrawable != null)
        {
          if (Build.VERSION.SDK_INT >= 16) {
            ((ShareActionSheetBuilder.ActionSheetItemViewHolder)localObject1).jdField_a_of_type_AndroidWidgetImageView.setBackground(((ShareActionSheetBuilder.ActionSheetItemViewHolder)localObject1).jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItem.iconDrawable);
          } else {
            ((ShareActionSheetBuilder.ActionSheetItemViewHolder)localObject1).jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(((ShareActionSheetBuilder.ActionSheetItemViewHolder)localObject1).jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItem.iconDrawable);
          }
        }
        else {
          ((ShareActionSheetBuilder.ActionSheetItemViewHolder)localObject1).jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(((ShareActionSheetBuilder.ActionSheetItemViewHolder)localObject1).jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItem.icon);
        }
      }
    }
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItemAdapter
 * JD-Core Version:    0.7.0.1
 */