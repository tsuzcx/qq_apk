package com.tencent.mobileqq.c2cshortcutbar;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class C2CShortcutBarAdapter
  extends BaseAdapter
{
  private Context jdField_a_of_type_AndroidContentContext;
  private C2CShortcutBarAdapter.ItemExposeListener jdField_a_of_type_ComTencentMobileqqC2cshortcutbarC2CShortcutBarAdapter$ItemExposeListener;
  private List<C2CShortcutAppInfo> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public C2CShortcutBarAdapter(Context paramContext, List<C2CShortcutAppInfo> paramList, C2CShortcutBarAdapter.ItemExposeListener paramItemExposeListener)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqC2cshortcutbarC2CShortcutBarAdapter$ItemExposeListener = paramItemExposeListener;
    if (paramList != null) {
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    }
  }
  
  private void a(ImageView paramImageView, String paramString)
  {
    Object localObject = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838632);
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject);
    localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject);
    localObject = paramImageView.getLayoutParams();
    localURLDrawableOptions.mRequestHeight = ((ViewGroup.LayoutParams)localObject).height;
    localURLDrawableOptions.mRequestWidth = ((ViewGroup.LayoutParams)localObject).width;
    try
    {
      paramString = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
      paramString.setTag(URLDrawableDecodeHandler.b(((ViewGroup.LayoutParams)localObject).width, ((ViewGroup.LayoutParams)localObject).height, ViewUtils.a(2.0F)));
      paramString.setDecodeHandler(URLDrawableDecodeHandler.i);
      paramImageView.setImageDrawable(paramString);
      return;
    }
    catch (Exception paramImageView)
    {
      if (QLog.isColorLevel()) {
        QLog.d("C2CShortcutBarAdapter", 2, "updateIconView exception ", paramImageView);
      }
    }
  }
  
  public C2CShortcutAppInfo a(int paramInt)
  {
    return (C2CShortcutAppInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public void a(List<C2CShortcutAppInfo> paramList)
  {
    if (paramList == null) {
      return;
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      localObject = new C2CShortcutBarAdapter.ViewHolder();
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560931, paramViewGroup, false);
      ((C2CShortcutBarAdapter.ViewHolder)localObject).jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131377456));
      ((C2CShortcutBarAdapter.ViewHolder)localObject).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131377458));
      ((C2CShortcutBarAdapter.ViewHolder)localObject).b = ((TextView)paramView.findViewById(2131377457));
      ((C2CShortcutBarAdapter.ViewHolder)localObject).jdField_a_of_type_AndroidViewView = paramView.findViewById(2131381186);
      ((C2CShortcutBarAdapter.ViewHolder)localObject).c = ((TextView)paramView.findViewById(2131377454));
      paramView.setTag(localObject);
    }
    else
    {
      localObject = (C2CShortcutBarAdapter.ViewHolder)paramView.getTag();
    }
    C2CShortcutAppInfo localC2CShortcutAppInfo = a(paramInt);
    boolean bool = ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime());
    if (bool) {
      ((C2CShortcutBarAdapter.ViewHolder)localObject).jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#ffffff"));
    } else {
      ((C2CShortcutBarAdapter.ViewHolder)localObject).jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#1C1D1E"));
    }
    if (bool) {
      paramView.setBackgroundDrawable(paramView.getResources().getDrawable(2130838593));
    } else {
      paramView.setBackgroundDrawable(paramView.getResources().getDrawable(2130838592));
    }
    if (!TextUtils.isEmpty(localC2CShortcutAppInfo.g))
    {
      ((C2CShortcutBarAdapter.ViewHolder)localObject).jdField_a_of_type_AndroidViewView.setVisibility(0);
      ((C2CShortcutBarAdapter.ViewHolder)localObject).c.setVisibility(0);
      ((C2CShortcutBarAdapter.ViewHolder)localObject).c.setText(localC2CShortcutAppInfo.g);
    }
    else
    {
      ((C2CShortcutBarAdapter.ViewHolder)localObject).jdField_a_of_type_AndroidViewView.setVisibility(8);
      ((C2CShortcutBarAdapter.ViewHolder)localObject).c.setVisibility(8);
    }
    a(((C2CShortcutBarAdapter.ViewHolder)localObject).jdField_a_of_type_ComTencentImageURLImageView, localC2CShortcutAppInfo.c);
    ((C2CShortcutBarAdapter.ViewHolder)localObject).jdField_a_of_type_AndroidWidgetTextView.setText(localC2CShortcutAppInfo.b);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqC2cshortcutbarC2CShortcutBarAdapter$ItemExposeListener;
    if (localObject != null) {
      ((C2CShortcutBarAdapter.ItemExposeListener)localObject).a(localC2CShortcutAppInfo, paramInt);
    }
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.c2cshortcutbar.C2CShortcutBarAdapter
 * JD-Core Version:    0.7.0.1
 */