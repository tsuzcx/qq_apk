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
  private Context a;
  private List<C2CShortcutAppInfo> b = new ArrayList();
  private C2CShortcutBarAdapter.ItemExposeListener c;
  
  public C2CShortcutBarAdapter(Context paramContext, List<C2CShortcutAppInfo> paramList, C2CShortcutBarAdapter.ItemExposeListener paramItemExposeListener)
  {
    this.a = paramContext;
    this.c = paramItemExposeListener;
    if (paramList != null) {
      this.b.addAll(paramList);
    }
  }
  
  private void a(ImageView paramImageView, String paramString)
  {
    Object localObject = this.a.getResources().getDrawable(2130838758);
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject);
    localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject);
    localObject = paramImageView.getLayoutParams();
    localURLDrawableOptions.mRequestHeight = ((ViewGroup.LayoutParams)localObject).height;
    localURLDrawableOptions.mRequestWidth = ((ViewGroup.LayoutParams)localObject).width;
    try
    {
      paramString = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
      paramString.setTag(URLDrawableDecodeHandler.b(((ViewGroup.LayoutParams)localObject).width, ((ViewGroup.LayoutParams)localObject).height, ViewUtils.dip2px(2.0F)));
      paramString.setDecodeHandler(URLDrawableDecodeHandler.j);
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
    return (C2CShortcutAppInfo)this.b.get(paramInt);
  }
  
  public void a(List<C2CShortcutAppInfo> paramList)
  {
    if (paramList == null) {
      return;
    }
    this.b.clear();
    this.b.addAll(paramList);
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    return this.b.size();
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
      paramView = LayoutInflater.from(this.a).inflate(2131627272, paramViewGroup, false);
      ((C2CShortcutBarAdapter.ViewHolder)localObject).a = ((URLImageView)paramView.findViewById(2131445855));
      ((C2CShortcutBarAdapter.ViewHolder)localObject).b = ((TextView)paramView.findViewById(2131445857));
      ((C2CShortcutBarAdapter.ViewHolder)localObject).c = ((TextView)paramView.findViewById(2131445856));
      ((C2CShortcutBarAdapter.ViewHolder)localObject).d = paramView.findViewById(2131450235);
      ((C2CShortcutBarAdapter.ViewHolder)localObject).e = ((TextView)paramView.findViewById(2131445853));
      paramView.setTag(localObject);
    }
    else
    {
      localObject = (C2CShortcutBarAdapter.ViewHolder)paramView.getTag();
    }
    C2CShortcutAppInfo localC2CShortcutAppInfo = a(paramInt);
    boolean bool = ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime());
    if (bool) {
      ((C2CShortcutBarAdapter.ViewHolder)localObject).b.setTextColor(Color.parseColor("#ffffff"));
    } else {
      ((C2CShortcutBarAdapter.ViewHolder)localObject).b.setTextColor(Color.parseColor("#1C1D1E"));
    }
    if (bool) {
      paramView.setBackgroundDrawable(paramView.getResources().getDrawable(2130838710));
    } else {
      paramView.setBackgroundDrawable(paramView.getResources().getDrawable(2130838709));
    }
    if (!TextUtils.isEmpty(localC2CShortcutAppInfo.l))
    {
      ((C2CShortcutBarAdapter.ViewHolder)localObject).d.setVisibility(0);
      ((C2CShortcutBarAdapter.ViewHolder)localObject).e.setVisibility(0);
      ((C2CShortcutBarAdapter.ViewHolder)localObject).e.setText(localC2CShortcutAppInfo.l);
    }
    else
    {
      ((C2CShortcutBarAdapter.ViewHolder)localObject).d.setVisibility(8);
      ((C2CShortcutBarAdapter.ViewHolder)localObject).e.setVisibility(8);
    }
    a(((C2CShortcutBarAdapter.ViewHolder)localObject).a, localC2CShortcutAppInfo.d);
    ((C2CShortcutBarAdapter.ViewHolder)localObject).b.setText(localC2CShortcutAppInfo.c);
    Object localObject = this.c;
    if (localObject != null) {
      ((C2CShortcutBarAdapter.ItemExposeListener)localObject).a(localC2CShortcutAppInfo, paramInt);
    }
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.c2cshortcutbar.C2CShortcutBarAdapter
 * JD-Core Version:    0.7.0.1
 */