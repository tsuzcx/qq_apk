package com.tencent.mobileqq.widget.share;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.armap.INonMainProcAvatarLoader;
import com.tencent.mobileqq.avatar.api.IQQNonMainProcAvatarLoaderApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItemViewHolder;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Iterator;
import java.util.List;

public class ShareActionSheetV2$ActionSheetItemAdapter
  extends BaseAdapter
{
  private int jdField_a_of_type_Int = 0;
  private Resources jdField_a_of_type_AndroidContentResResources;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private ShareActionSheetV2.ActionSheetItemAdapter.IconFactory jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheetV2$ActionSheetItemAdapter$IconFactory;
  private ShareActionSheetV2 jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheetV2;
  private List<ShareActionSheetBuilder.ActionSheetItem> jdField_a_of_type_JavaUtilList;
  
  public ShareActionSheetV2$ActionSheetItemAdapter(Context paramContext, List<ShareActionSheetBuilder.ActionSheetItem> paramList, ShareActionSheetV2 paramShareActionSheetV2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ActionSheetItemAdapter() called with: context = [");
      localStringBuilder.append(paramContext);
      localStringBuilder.append("], objects = [");
      localStringBuilder.append(paramList);
      localStringBuilder.append("] #this = ");
      localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
      QLog.d("ShareActionSheetV2", 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheetV2 = paramShareActionSheetV2;
  }
  
  private static void a(int paramInt, String paramString, ImageView paramImageView, ShareActionSheetBuilder.ActionSheetItemViewHolder paramActionSheetItemViewHolder, ActionSheetItemAdapter paramActionSheetItemAdapter, ShareActionSheetV2 paramShareActionSheetV2)
  {
    if (paramImageView != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      if (paramInt != 0) {
        if (paramInt != 1)
        {
          if ((paramInt != 1000) && (paramInt != 1004)) {
            if (paramInt != 3000)
            {
              if (paramInt != 6000)
              {
                if ((paramInt == 10008) || (paramInt == 10010)) {
                  break label118;
                }
                paramInt = -1;
                break label120;
              }
            }
            else
            {
              paramInt = 101;
              break label120;
            }
          }
        }
        else
        {
          int i = 4;
          paramInt = i;
          if (TextUtils.isEmpty(paramActionSheetItemViewHolder.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItem.argus)) {
            break label120;
          }
          paramInt = i;
          if (!paramActionSheetItemViewHolder.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItem.argus.contains("isNewTroop=1")) {
            break label120;
          }
          paramInt = 113;
          break label120;
        }
      }
      label118:
      paramInt = 1;
      label120:
      if (paramInt == -1) {
        return;
      }
      if (ShareActionSheetV2.a(paramShareActionSheetV2) == null) {
        ShareActionSheetV2.a(paramShareActionSheetV2, new SparseArray());
      }
      INonMainProcAvatarLoader localINonMainProcAvatarLoader = (INonMainProcAvatarLoader)ShareActionSheetV2.a(paramShareActionSheetV2).get(paramInt);
      paramActionSheetItemAdapter = localINonMainProcAvatarLoader;
      if (localINonMainProcAvatarLoader == null)
      {
        paramActionSheetItemAdapter = ((IQQNonMainProcAvatarLoaderApi)QRoute.api(IQQNonMainProcAvatarLoaderApi.class)).getNonMainAppHeadLoader(paramShareActionSheetV2.a, paramInt);
        byte b;
        if (QQTheme.f()) {
          b = 1;
        } else {
          b = 3;
        }
        paramActionSheetItemAdapter.a(b);
        paramActionSheetItemAdapter.a();
        ShareActionSheetV2.a(paramShareActionSheetV2).put(paramInt, paramActionSheetItemAdapter);
      }
      paramImageView.setTag(paramString);
      paramActionSheetItemAdapter.a(ShareActionSheetV2.a(paramShareActionSheetV2));
      paramString = paramActionSheetItemAdapter.a(paramString, true);
      if (paramString == null) {
        return;
      }
      paramActionSheetItemViewHolder.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItem.iconDrawable = new BitmapDrawable(paramString);
      b(paramActionSheetItemViewHolder);
    }
  }
  
  private void a(ShareActionSheetBuilder.ActionSheetItemViewHolder paramActionSheetItemViewHolder)
  {
    if (paramActionSheetItemViewHolder.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItem.action == 72) {
      a(paramActionSheetItemViewHolder.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItem.uinType, paramActionSheetItemViewHolder.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItem.uin, paramActionSheetItemViewHolder.jdField_a_of_type_AndroidWidgetImageView, paramActionSheetItemViewHolder, this, this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheetV2);
    }
  }
  
  private static void b(ShareActionSheetBuilder.ActionSheetItemViewHolder paramActionSheetItemViewHolder)
  {
    if (paramActionSheetItemViewHolder.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItem.iconDrawable != null)
    {
      if (Build.VERSION.SDK_INT >= 16)
      {
        paramActionSheetItemViewHolder.jdField_a_of_type_AndroidWidgetImageView.setBackground(paramActionSheetItemViewHolder.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItem.iconDrawable);
        return;
      }
      paramActionSheetItemViewHolder.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(paramActionSheetItemViewHolder.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItem.iconDrawable);
      return;
    }
    paramActionSheetItemViewHolder.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(paramActionSheetItemViewHolder.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItem.icon);
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
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheetV2$ActionSheetItemAdapter$IconFactory == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheetV2$ActionSheetItemAdapter$IconFactory = new ShareActionSheetV2.ActionSheetItemAdapter.IconFactory(paramViewGroup.getContext());
    }
    int j = 0;
    Object localObject1;
    if (paramView == null)
    {
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131558904, paramViewGroup, false);
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
      QLog.e("ShareActionSheetV2", 2, ((StringBuilder)localObject1).toString());
    }
    else
    {
      paramView.setId(((ShareActionSheetBuilder.ActionSheetItemViewHolder)localObject1).jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItem.id);
      float f = this.jdField_a_of_type_AndroidContentResResources.getDimension(2131296796);
      ((ShareActionSheetBuilder.ActionSheetItemViewHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView.getPaint().setTextSize(this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131299102));
      ((ShareActionSheetBuilder.ActionSheetItemViewHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView.setMaxWidth((int)f);
      ((ShareActionSheetBuilder.ActionSheetItemViewHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText(((ShareActionSheetBuilder.ActionSheetItemViewHolder)localObject1).jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItem.label);
      int i = -8947849;
      Object localObject2 = ((ShareActionSheetBuilder.ActionSheetItemViewHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView;
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
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheetV2$ActionSheetItemAdapter$IconFactory.a((Drawable)localObject2, i, j);
        if (((ShareActionSheetBuilder.ActionSheetItemViewHolder)localObject1).jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItem.enable)
        {
          Drawable localDrawable = ShareActionSheetV2.ActionSheetItemAdapter.IconFactory.a(this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheetV2$ActionSheetItemAdapter$IconFactory, (Drawable)localObject2);
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheetV2$ActionSheetItemAdapter$IconFactory.a((Drawable)localObject2, localDrawable);
          ((ShareActionSheetBuilder.ActionSheetItemViewHolder)localObject1).jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject2);
        }
        else
        {
          localObject2 = ShareActionSheetV2.ActionSheetItemAdapter.IconFactory.b(this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheetV2$ActionSheetItemAdapter$IconFactory, (Drawable)localObject2);
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
        if ((((ShareActionSheetBuilder.ActionSheetItemViewHolder)localObject1).jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItem.action != 72) && (((ShareActionSheetBuilder.ActionSheetItemViewHolder)localObject1).jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItem.action != 73)) {
          ((ShareActionSheetBuilder.ActionSheetItemViewHolder)localObject1).jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130837649);
        } else if (QQTheme.f()) {
          ((ShareActionSheetBuilder.ActionSheetItemViewHolder)localObject1).jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130837651);
        } else {
          ((ShareActionSheetBuilder.ActionSheetItemViewHolder)localObject1).jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130837650);
        }
        b((ShareActionSheetBuilder.ActionSheetItemViewHolder)localObject1);
        a((ShareActionSheetBuilder.ActionSheetItemViewHolder)localObject1);
      }
    }
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.share.ShareActionSheetV2.ActionSheetItemAdapter
 * JD-Core Version:    0.7.0.1
 */