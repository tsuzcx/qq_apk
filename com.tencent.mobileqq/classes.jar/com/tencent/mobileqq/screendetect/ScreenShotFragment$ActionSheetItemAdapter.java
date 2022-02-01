package com.tencent.mobileqq.screendetect;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import java.util.Iterator;
import java.util.List;

public class ScreenShotFragment$ActionSheetItemAdapter
  extends BaseAdapter
  implements AdapterView.OnItemClickListener
{
  private int jdField_a_of_type_Int = 0;
  private Resources jdField_a_of_type_AndroidContentResResources;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private ScreenShotFragment.ActionSheetItemAdapter.IconFactory jdField_a_of_type_ComTencentMobileqqScreendetectScreenShotFragment$ActionSheetItemAdapter$IconFactory;
  private List<ShareActionSheetBuilder.ActionSheetItem> jdField_a_of_type_JavaUtilList;
  
  public ScreenShotFragment$ActionSheetItemAdapter(Context paramContext, List<ShareActionSheetBuilder.ActionSheetItem> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
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
    if (this.jdField_a_of_type_ComTencentMobileqqScreendetectScreenShotFragment$ActionSheetItemAdapter$IconFactory == null) {
      this.jdField_a_of_type_ComTencentMobileqqScreendetectScreenShotFragment$ActionSheetItemAdapter$IconFactory = new ScreenShotFragment.ActionSheetItemAdapter.IconFactory(paramViewGroup.getContext());
    }
    int j = 0;
    Object localObject1;
    if (paramView == null)
    {
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131558904, paramViewGroup, false);
      localObject1 = new ScreenShotFragment.ActionSheetItemViewHolder();
      ((ScreenShotFragment.ActionSheetItemViewHolder)localObject1).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131377364));
      ((ScreenShotFragment.ActionSheetItemViewHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131377365));
      paramView.setTag(localObject1);
      paramView.setFocusable(true);
    }
    else
    {
      localObject1 = (ScreenShotFragment.ActionSheetItemViewHolder)paramView.getTag();
    }
    ((ScreenShotFragment.ActionSheetItemViewHolder)localObject1).jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItem = a(paramInt);
    if (((ScreenShotFragment.ActionSheetItemViewHolder)localObject1).jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItem == null)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("ShareActionSheetBuilder.ActionSheetItemAdapter.getView() getItem(");
      ((StringBuilder)localObject1).append(paramInt);
      ((StringBuilder)localObject1).append(") == null !!!");
      QLog.e("ScreenShotFragment", 2, ((StringBuilder)localObject1).toString());
    }
    else
    {
      paramView.setId(((ScreenShotFragment.ActionSheetItemViewHolder)localObject1).jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItem.id);
      Object localObject2 = ((ScreenShotFragment.ActionSheetItemViewHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView;
      Object localObject3 = ((ScreenShotFragment.ActionSheetItemViewHolder)localObject1).jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItem.label;
      if (((ScreenShotFragment.ActionSheetItemViewHolder)localObject1).jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItem.firstLineCount > 0) {
        i = ((ScreenShotFragment.ActionSheetItemViewHolder)localObject1).jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItem.firstLineCount;
      } else {
        i = 6;
      }
      ((TextView)localObject2).setText(ScreenShotFragment.a((String)localObject3, i));
      int i = -8947849;
      localObject2 = ((ScreenShotFragment.ActionSheetItemViewHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView;
      if (!((ScreenShotFragment.ActionSheetItemViewHolder)localObject1).jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItem.enable) {
        i = 2138535799;
      }
      ((TextView)localObject2).setTextColor(i);
      if (((ScreenShotFragment.ActionSheetItemViewHolder)localObject1).jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItem.iconNeedBg)
      {
        if (((ScreenShotFragment.ActionSheetItemViewHolder)localObject1).jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItem.iconDrawable != null) {
          localObject2 = ((ScreenShotFragment.ActionSheetItemViewHolder)localObject1).jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItem.iconDrawable;
        } else {
          localObject2 = this.jdField_a_of_type_AndroidContentResResources.getDrawable(((ScreenShotFragment.ActionSheetItemViewHolder)localObject1).jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItem.icon);
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
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqScreendetectScreenShotFragment$ActionSheetItemAdapter$IconFactory.a((Drawable)localObject2, i, j);
        if (((ScreenShotFragment.ActionSheetItemViewHolder)localObject1).jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItem.enable)
        {
          localObject3 = ScreenShotFragment.ActionSheetItemAdapter.IconFactory.a(this.jdField_a_of_type_ComTencentMobileqqScreendetectScreenShotFragment$ActionSheetItemAdapter$IconFactory, (Drawable)localObject2);
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqScreendetectScreenShotFragment$ActionSheetItemAdapter$IconFactory.a((Drawable)localObject2, (Drawable)localObject3);
          ((ScreenShotFragment.ActionSheetItemViewHolder)localObject1).jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject2);
        }
        else
        {
          localObject2 = ScreenShotFragment.ActionSheetItemAdapter.IconFactory.b(this.jdField_a_of_type_ComTencentMobileqqScreendetectScreenShotFragment$ActionSheetItemAdapter$IconFactory, (Drawable)localObject2);
          ((ScreenShotFragment.ActionSheetItemViewHolder)localObject1).jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject2);
        }
        if (Build.VERSION.SDK_INT >= 16) {
          ((ScreenShotFragment.ActionSheetItemViewHolder)localObject1).jdField_a_of_type_AndroidWidgetImageView.setBackground(null);
        } else {
          ((ScreenShotFragment.ActionSheetItemViewHolder)localObject1).jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(null);
        }
      }
      else
      {
        ((ScreenShotFragment.ActionSheetItemViewHolder)localObject1).jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130837649);
        if (((ScreenShotFragment.ActionSheetItemViewHolder)localObject1).jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItem.iconDrawable != null)
        {
          if (Build.VERSION.SDK_INT >= 16) {
            ((ScreenShotFragment.ActionSheetItemViewHolder)localObject1).jdField_a_of_type_AndroidWidgetImageView.setBackground(((ScreenShotFragment.ActionSheetItemViewHolder)localObject1).jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItem.iconDrawable);
          } else {
            ((ScreenShotFragment.ActionSheetItemViewHolder)localObject1).jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(((ScreenShotFragment.ActionSheetItemViewHolder)localObject1).jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItem.iconDrawable);
          }
        }
        else {
          ((ScreenShotFragment.ActionSheetItemViewHolder)localObject1).jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(((ScreenShotFragment.ActionSheetItemViewHolder)localObject1).jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItem.icon);
        }
      }
      if (AppSetting.d)
      {
        if (((ScreenShotFragment.ActionSheetItemViewHolder)localObject1).jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItem.label != null) {
          localObject1 = ((ScreenShotFragment.ActionSheetItemViewHolder)localObject1).jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItem.label;
        } else {
          localObject1 = "";
        }
        paramView.setContentDescription((CharSequence)localObject1);
      }
    }
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return paramView;
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.screendetect.ScreenShotFragment.ActionSheetItemAdapter
 * JD-Core Version:    0.7.0.1
 */