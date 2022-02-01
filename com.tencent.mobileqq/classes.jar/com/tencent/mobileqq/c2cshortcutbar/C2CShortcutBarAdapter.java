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
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.utils.ViewUtils;
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
    Object localObject = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838812);
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
      paramString.setDecodeHandler(URLDrawableDecodeHandler.j);
      paramImageView.setImageDrawable(paramString);
      return;
    }
    catch (Exception paramImageView)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("C2CShortcutBarAdapter", 2, "updateIconView exception ", paramImageView);
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
    View localView;
    Object localObject;
    if (paramView == null)
    {
      paramView = new C2CShortcutBarAdapter.ViewHolder();
      localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561067, paramViewGroup, false);
      paramView.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)localView.findViewById(2131378031));
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131378033));
      paramView.b = ((TextView)localView.findViewById(2131378032));
      paramView.jdField_a_of_type_AndroidViewView = localView.findViewById(2131381982);
      paramView.c = ((TextView)localView.findViewById(2131378029));
      localView.setTag(paramView);
      localObject = a(paramInt);
      boolean bool = ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime());
      if (!bool) {
        break label275;
      }
      paramView.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#ffffff"));
      label136:
      if (!bool) {
        break label291;
      }
      localView.setBackgroundDrawable(localView.getResources().getDrawable(2130838748));
      label156:
      if (TextUtils.isEmpty(((C2CShortcutAppInfo)localObject).g)) {
        break label310;
      }
      paramView.jdField_a_of_type_AndroidViewView.setVisibility(0);
      paramView.c.setVisibility(0);
      paramView.c.setText(((C2CShortcutAppInfo)localObject).g);
    }
    for (;;)
    {
      a(paramView.jdField_a_of_type_ComTencentImageURLImageView, ((C2CShortcutAppInfo)localObject).c);
      paramView.jdField_a_of_type_AndroidWidgetTextView.setText(((C2CShortcutAppInfo)localObject).b);
      if (this.jdField_a_of_type_ComTencentMobileqqC2cshortcutbarC2CShortcutBarAdapter$ItemExposeListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqC2cshortcutbarC2CShortcutBarAdapter$ItemExposeListener.a((C2CShortcutAppInfo)localObject, paramInt);
      }
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return localView;
      localObject = (C2CShortcutBarAdapter.ViewHolder)paramView.getTag();
      localView = paramView;
      paramView = (View)localObject;
      break;
      label275:
      paramView.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#1C1D1E"));
      break label136;
      label291:
      localView.setBackgroundDrawable(localView.getResources().getDrawable(2130838747));
      break label156;
      label310:
      paramView.jdField_a_of_type_AndroidViewView.setVisibility(8);
      paramView.c.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.c2cshortcutbar.C2CShortcutBarAdapter
 * JD-Core Version:    0.7.0.1
 */