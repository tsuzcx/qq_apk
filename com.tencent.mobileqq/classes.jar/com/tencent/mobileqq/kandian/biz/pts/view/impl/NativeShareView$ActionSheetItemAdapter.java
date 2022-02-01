package com.tencent.mobileqq.kandian.biz.pts.view.impl;

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
import com.tencent.mobileqq.screendetect.ScreenShotFragment.ActionSheetItemViewHolder;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import java.util.Iterator;
import java.util.List;

public class NativeShareView$ActionSheetItemAdapter
  extends BaseAdapter
  implements AdapterView.OnItemClickListener
{
  private int jdField_a_of_type_Int = 0;
  private Resources jdField_a_of_type_AndroidContentResResources;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private NativeShareView.ActionSheetItemAdapter.IconFactory jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewImplNativeShareView$ActionSheetItemAdapter$IconFactory;
  private List<ShareActionSheetBuilder.ActionSheetItem> jdField_a_of_type_JavaUtilList;
  
  public NativeShareView$ActionSheetItemAdapter(Context paramContext, List<ShareActionSheetBuilder.ActionSheetItem> paramList)
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
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewImplNativeShareView$ActionSheetItemAdapter$IconFactory == null) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewImplNativeShareView$ActionSheetItemAdapter$IconFactory = new NativeShareView.ActionSheetItemAdapter.IconFactory(paramViewGroup.getContext());
    }
    int i = 0;
    if (paramView == null)
    {
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559978, paramViewGroup, false);
      paramViewGroup = new ScreenShotFragment.ActionSheetItemViewHolder();
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131377364));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131377365));
      paramView.setTag(paramViewGroup);
      paramView.setFocusable(true);
    }
    else
    {
      paramViewGroup = (ScreenShotFragment.ActionSheetItemViewHolder)paramView.getTag();
    }
    paramViewGroup.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItem = a(paramInt);
    if (paramViewGroup.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItem == null)
    {
      paramViewGroup = new StringBuilder();
      paramViewGroup.append("ShareActionSheetBuilder.ActionSheetItemAdapter.getView() getItem(");
      paramViewGroup.append(paramInt);
      paramViewGroup.append(") == null !!!");
      QLog.e("NativeShareView", 2, paramViewGroup.toString());
      return paramView;
    }
    paramView.setId(paramViewGroup.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItem.id);
    Object localObject1 = paramViewGroup.jdField_a_of_type_AndroidWidgetTextView;
    Object localObject2 = paramViewGroup.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItem.label;
    if (paramViewGroup.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItem.firstLineCount > 0) {
      paramInt = paramViewGroup.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItem.firstLineCount;
    } else {
      paramInt = 6;
    }
    ((TextView)localObject1).setText(NativeShareView.a((String)localObject2, paramInt));
    paramInt = -16578534;
    localObject1 = paramViewGroup.jdField_a_of_type_AndroidWidgetTextView;
    if (!paramViewGroup.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItem.enable) {
      paramInt = 2130905114;
    }
    ((TextView)localObject1).setTextColor(paramInt);
    if (paramViewGroup.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItem.iconNeedBg)
    {
      if (paramViewGroup.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItem.iconDrawable != null) {
        localObject1 = paramViewGroup.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItem.iconDrawable;
      } else {
        localObject1 = this.jdField_a_of_type_AndroidContentResResources.getDrawable(paramViewGroup.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItem.icon);
      }
      paramInt = ((Drawable)localObject1).getIntrinsicWidth();
      int j = ((Drawable)localObject1).getIntrinsicHeight();
      int k = this.jdField_a_of_type_Int;
      if (k > paramInt) {
        paramInt = (int)((k - paramInt) / 2.0F);
      } else {
        paramInt = 0;
      }
      k = this.jdField_a_of_type_Int;
      if (k > j) {
        i = (int)((k - j) / 2.0F);
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewImplNativeShareView$ActionSheetItemAdapter$IconFactory.a((Drawable)localObject1, paramInt, i);
      if (paramViewGroup.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItem.enable)
      {
        localObject2 = NativeShareView.ActionSheetItemAdapter.IconFactory.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewImplNativeShareView$ActionSheetItemAdapter$IconFactory, (Drawable)localObject1);
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewImplNativeShareView$ActionSheetItemAdapter$IconFactory.a((Drawable)localObject1, (Drawable)localObject2);
        paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
      }
      else
      {
        localObject1 = NativeShareView.ActionSheetItemAdapter.IconFactory.b(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewImplNativeShareView$ActionSheetItemAdapter$IconFactory, (Drawable)localObject1);
        paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
      }
      if (Build.VERSION.SDK_INT >= 16) {
        paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setBackground(null);
      } else {
        paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(null);
      }
    }
    else
    {
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130837649);
      if (paramViewGroup.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItem.iconDrawable != null)
      {
        if (Build.VERSION.SDK_INT >= 16) {
          paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setBackground(paramViewGroup.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItem.iconDrawable);
        } else {
          paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(paramViewGroup.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItem.iconDrawable);
        }
      }
      else {
        paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(paramViewGroup.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItem.icon);
      }
    }
    if (AppSetting.d)
    {
      if (paramViewGroup.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItem.label != null) {
        paramViewGroup = paramViewGroup.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItem.label;
      } else {
        paramViewGroup = "";
      }
      paramView.setContentDescription(paramViewGroup);
    }
    return paramView;
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.view.impl.NativeShareView.ActionSheetItemAdapter
 * JD-Core Version:    0.7.0.1
 */