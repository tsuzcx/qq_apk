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
    if (QLog.isColorLevel()) {
      QLog.d("ShareActionSheetV2", 2, "ActionSheetItemAdapter() called with: context = [" + paramContext + "], objects = [" + paramList + "] #this = " + Integer.toHexString(System.identityHashCode(this)));
    }
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheetV2 = paramShareActionSheetV2;
  }
  
  private static void a(int paramInt, String paramString, ImageView paramImageView, ShareActionSheetBuilder.ActionSheetItemViewHolder paramActionSheetItemViewHolder, ActionSheetItemAdapter paramActionSheetItemAdapter, ShareActionSheetV2 paramShareActionSheetV2)
  {
    if ((paramImageView == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    switch (paramInt)
    {
    case 6000: 
    default: 
      paramInt = -1;
    }
    label90:
    while (paramInt != -1)
    {
      if (ShareActionSheetV2.a(paramShareActionSheetV2) == null) {
        ShareActionSheetV2.a(paramShareActionSheetV2, new SparseArray());
      }
      INonMainProcAvatarLoader localINonMainProcAvatarLoader = (INonMainProcAvatarLoader)ShareActionSheetV2.a(paramShareActionSheetV2).get(paramInt);
      paramActionSheetItemAdapter = localINonMainProcAvatarLoader;
      if (localINonMainProcAvatarLoader == null)
      {
        paramActionSheetItemAdapter = ((IQQNonMainProcAvatarLoaderApi)QRoute.api(IQQNonMainProcAvatarLoaderApi.class)).getNonMainAppHeadLoader(paramShareActionSheetV2.a, paramInt);
        if (!QQTheme.e()) {
          break label292;
        }
      }
      for (byte b = 1;; b = 3)
      {
        paramActionSheetItemAdapter.a(b);
        paramActionSheetItemAdapter.a();
        ShareActionSheetV2.a(paramShareActionSheetV2).put(paramInt, paramActionSheetItemAdapter);
        paramImageView.setTag(paramString);
        paramActionSheetItemAdapter.a(ShareActionSheetV2.a(paramShareActionSheetV2));
        paramString = paramActionSheetItemAdapter.a(paramString, true);
        if (paramString == null) {
          break;
        }
        paramActionSheetItemViewHolder.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItem.iconDrawable = new BitmapDrawable(paramString);
        b(paramActionSheetItemViewHolder);
        return;
        paramInt = 1;
        break label90;
        if ((TextUtils.isEmpty(paramActionSheetItemViewHolder.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItem.argus)) || (!paramActionSheetItemViewHolder.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItem.argus.contains("isNewTroop=1"))) {
          break label298;
        }
        paramInt = 113;
        break label90;
        paramInt = 101;
        break label90;
      }
      paramInt = 4;
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
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheetV2$ActionSheetItemAdapter$IconFactory == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheetV2$ActionSheetItemAdapter$IconFactory = new ShareActionSheetV2.ActionSheetItemAdapter.IconFactory(paramViewGroup.getContext());
    }
    View localView;
    if (paramView == null)
    {
      localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559010, paramViewGroup, false);
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
      QLog.e("ShareActionSheetV2", 2, "ShareActionSheetBuilder.ActionSheetItemAdapter.getView() getItem(" + paramInt + ") == null !!!");
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return localView;
      localObject = (ShareActionSheetBuilder.ActionSheetItemViewHolder)paramView.getTag();
      localView = paramView;
      paramView = (View)localObject;
    }
    localView.setId(paramView.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItem.id);
    float f = this.jdField_a_of_type_AndroidContentResResources.getDimension(2131296816);
    paramView.jdField_a_of_type_AndroidWidgetTextView.getPaint().setTextSize(this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131299097));
    paramView.jdField_a_of_type_AndroidWidgetTextView.setMaxWidth((int)f);
    paramView.jdField_a_of_type_AndroidWidgetTextView.setText(paramView.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItem.label);
    int i = -8947849;
    Object localObject = paramView.jdField_a_of_type_AndroidWidgetTextView;
    if (paramView.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItem.enable)
    {
      label301:
      ((TextView)localObject).setTextColor(i);
      if (!paramView.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItem.iconNeedBg) {
        break label539;
      }
      if (paramView.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItem.iconDrawable == null) {
        break label480;
      }
      localObject = paramView.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItem.iconDrawable;
      label337:
      i = ((Drawable)localObject).getIntrinsicWidth();
      int k = ((Drawable)localObject).getIntrinsicHeight();
      if (this.jdField_a_of_type_Int <= i) {
        break label499;
      }
      i = (int)((this.jdField_a_of_type_Int - i) / 2.0F);
      label373:
      if (this.jdField_a_of_type_Int > k) {
        j = (int)((this.jdField_a_of_type_Int - k) / 2.0F);
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheetV2$ActionSheetItemAdapter$IconFactory.a((Drawable)localObject, i, j);
      if (!paramView.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItem.enable) {
        break label505;
      }
      Drawable localDrawable = ShareActionSheetV2.ActionSheetItemAdapter.IconFactory.a(this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheetV2$ActionSheetItemAdapter$IconFactory, (Drawable)localObject);
      localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheetV2$ActionSheetItemAdapter$IconFactory.a((Drawable)localObject, localDrawable);
      paramView.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      label453:
      if (Build.VERSION.SDK_INT < 16) {
        break label528;
      }
      paramView.jdField_a_of_type_AndroidWidgetImageView.setBackground(null);
    }
    for (;;)
    {
      break;
      i = 2138535799;
      break label301;
      label480:
      localObject = this.jdField_a_of_type_AndroidContentResResources.getDrawable(paramView.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItem.icon);
      break label337;
      label499:
      i = 0;
      break label373;
      label505:
      localObject = ShareActionSheetV2.ActionSheetItemAdapter.IconFactory.b(this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheetV2$ActionSheetItemAdapter$IconFactory, (Drawable)localObject);
      paramView.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      break label453;
      label528:
      paramView.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(null);
    }
    label539:
    if ((paramView.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItem.action == 72) || (paramView.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItem.action == 73)) {
      if (QQTheme.e()) {
        paramView.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130837564);
      }
    }
    for (;;)
    {
      b(paramView);
      a(paramView);
      break;
      paramView.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130837563);
      continue;
      paramView.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130837562);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.widget.share.ShareActionSheetV2.ActionSheetItemAdapter
 * JD-Core Version:    0.7.0.1
 */