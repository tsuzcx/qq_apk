package com.tencent.mobileqq.onlinestatus;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.text.TextPaint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.Animation;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.AutoReplyText;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.text.TextUtils;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class AutoReplyAdapter
  extends BaseAdapter
{
  private AppInterface a;
  private Context b;
  private ArrayList<AutoReplyText> c;
  private Drawable d;
  private boolean e;
  private AutoReplyAdapter.OnAutoReplyItemListener f;
  private boolean g;
  
  public AutoReplyAdapter(AppInterface paramAppInterface, Context paramContext, Drawable paramDrawable)
  {
    this.a = paramAppInterface;
    this.b = paramContext;
    this.d = paramDrawable;
    this.c = new ArrayList();
    this.e = false;
    this.g = false;
  }
  
  private View a(LayoutInflater paramLayoutInflater, int paramInt, ViewGroup paramViewGroup)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131623989, paramViewGroup, false);
    paramViewGroup = (TextView)paramLayoutInflater.findViewById(2131431322);
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)paramViewGroup.getLayoutParams();
    if (getItemViewType(paramInt) == 0)
    {
      localMarginLayoutParams.topMargin = this.b.getResources().getDimensionPixelSize(2131299241);
      localMarginLayoutParams.bottomMargin = this.b.getResources().getDimensionPixelSize(2131299236);
      paramViewGroup.setText(2131887149);
      paramViewGroup.setContentDescription(this.b.getString(2131887149));
    }
    else
    {
      localMarginLayoutParams.bottomMargin = this.b.getResources().getDimensionPixelSize(2131299241);
      localMarginLayoutParams.topMargin = this.b.getResources().getDimensionPixelSize(2131299236);
      paramViewGroup.setText(2131887151);
      paramViewGroup.setContentDescription(this.b.getString(2131887151));
    }
    paramViewGroup.setLayoutParams(localMarginLayoutParams);
    return paramLayoutInflater;
  }
  
  private AutoReplyAdapter.ViewHolder a(LayoutInflater paramLayoutInflater, int paramInt, View paramView, ViewGroup paramViewGroup, AutoReplyText paramAutoReplyText)
  {
    Object localObject = null;
    if ((paramView != null) && (paramView.getTag() != null) && (paramView.getVisibility() != 8))
    {
      paramLayoutInflater = (AutoReplyAdapter.ViewHolder)paramView.getTag();
      paramLayoutInflater.a = paramView;
    }
    else
    {
      paramView = paramLayoutInflater.inflate(2131623985, paramViewGroup, false);
      paramLayoutInflater = paramView.findViewById(2131431997);
      if (QQTheme.isDefaultTheme()) {
        paramInt = 0;
      } else {
        paramInt = 8;
      }
      paramLayoutInflater.setVisibility(paramInt);
      if ((!QQTheme.isDefaultTheme()) && (!QQTheme.isNowThemeIsNight())) {
        paramView.findViewById(2131444642).setBackgroundResource(2130839632);
      }
      paramView.findViewById(2131437100).setPadding(0, 0, 0, 0);
      paramView.findViewById(2131444855).setVisibility(8);
      paramViewGroup = (TextView)paramView.findViewById(2131437131);
      paramViewGroup.setEditableFactory(new AutoReplyAdapter.2(this, paramViewGroup));
      paramLayoutInflater = new AutoReplyAdapter.ViewHolder(null);
      paramLayoutInflater.a = paramView;
      paramLayoutInflater.b = paramViewGroup;
      paramLayoutInflater.c = ((ImageView)paramView.findViewById(2131444823));
      paramLayoutInflater.d = paramView.findViewById(2131432154);
      paramLayoutInflater.e = paramView.findViewById(2131432155);
      paramLayoutInflater.f = paramView.findViewById(2131447106);
      paramLayoutInflater.a.setTag(paramLayoutInflater);
    }
    paramLayoutInflater.c.setOnClickListener(new AutoReplyAdapter.3(this, paramAutoReplyText));
    paramLayoutInflater.d.setOnClickListener(new AutoReplyAdapter.4(this, paramAutoReplyText));
    boolean bool = paramAutoReplyText.getExtra().getBoolean("AutoReplyAdapter:in_use", false);
    if (paramAutoReplyText.getTextId() == 2147483647) {
      paramInt = 1;
    } else {
      paramInt = 0;
    }
    paramView = AutoReplyText.trimRawString(paramAutoReplyText.getRawText(), true);
    int i = (int)(paramLayoutInflater.b.getTextSize() / paramLayoutInflater.b.getPaint().density);
    paramView = TextUtils.subQQTextString(paramView, paramLayoutInflater.b.getPaint(), 3, i, ScreenUtil.SCREEN_WIDTH - ScreenUtil.dip2px(67.0F), true);
    if (QLog.isColorLevel())
    {
      paramViewGroup = new StringBuilder();
      paramViewGroup.append("Truncate subText: ");
      paramViewGroup.append(paramView);
      QLog.d("AutoReplyAdapter", 2, paramViewGroup.toString());
    }
    paramViewGroup = new QQText(paramView, 3, i);
    paramLayoutInflater.b.setText(paramViewGroup);
    paramLayoutInflater.b.setContentDescription(paramViewGroup);
    paramViewGroup = paramLayoutInflater.c;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(HardCodeUtil.a(2131899100));
    localStringBuilder.append(paramView);
    paramViewGroup.setContentDescription(new QQText(localStringBuilder.toString(), 3, i));
    paramLayoutInflater.e.setOnClickListener(new AutoReplyAdapter.5(this, paramAutoReplyText, bool));
    paramLayoutInflater.a.findViewById(2131444642).setOnClickListener(new AutoReplyAdapter.6(this, paramAutoReplyText));
    paramViewGroup = paramLayoutInflater.c;
    paramView = localObject;
    if (bool) {
      paramView = this.d;
    }
    paramViewGroup.setImageDrawable(paramView);
    paramView = paramLayoutInflater.a;
    if (paramInt != 0) {
      paramInt = 0;
    } else {
      paramInt = ScreenUtil.dip2px(200.0F);
    }
    paramView.setTag(-3, Integer.valueOf(paramInt));
    paramView = (RelativeLayout.LayoutParams)paramLayoutInflater.f.getLayoutParams();
    if (paramView.leftMargin > 0)
    {
      paramView.leftMargin = 0;
      paramLayoutInflater.f.setLayoutParams(paramView);
    }
    return paramLayoutInflater;
  }
  
  private void a(View paramView, int paramInt)
  {
    if (paramInt == 2147483647) {
      return;
    }
    if (paramView == null) {
      return;
    }
    if (a())
    {
      AutoReplyAdapter.7 local7 = new AutoReplyAdapter.7(this, paramView, paramView.getMeasuredHeight());
      local7.setAnimationListener(new AutoReplyAdapter.8(this, paramInt));
      local7.setDuration(150L);
      paramView.startAnimation(local7);
    }
  }
  
  private View b(LayoutInflater paramLayoutInflater, int paramInt, ViewGroup paramViewGroup)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131623983, paramViewGroup, false);
    paramLayoutInflater.setOnClickListener(new AutoReplyAdapter.1(this));
    return paramLayoutInflater;
  }
  
  private void b(int paramInt)
  {
    if (paramInt == 2147483647) {
      return;
    }
    if (a())
    {
      Object localObject = this.c.iterator();
      int k = 0;
      int i = 0;
      int j = 0;
      while (((Iterator)localObject).hasNext())
      {
        AutoReplyText localAutoReplyText = (AutoReplyText)((Iterator)localObject).next();
        if (localAutoReplyText.getTextId() == paramInt)
        {
          if (localAutoReplyText.getExtra().getBoolean("AutoReplyAdapter:in_use", false)) {
            k = 1;
          }
          ((Iterator)localObject).remove();
          AutoReplyAdapter.OnAutoReplyItemListener localOnAutoReplyItemListener = this.f;
          if (localOnAutoReplyItemListener != null)
          {
            boolean bool;
            if (localAutoReplyText.getTextId() == 2147483647) {
              bool = true;
            } else {
              bool = false;
            }
            localOnAutoReplyItemListener.a(localAutoReplyText, bool);
          }
          j = 1;
        }
        else if (localAutoReplyText.mTextId != 2147483647)
        {
          localAutoReplyText.mTextId = i;
          i += 1;
        }
      }
      if ((k != 0) && (!this.c.isEmpty()))
      {
        localObject = (AutoReplyText)this.c.get(0);
        if (localObject != null) {
          a(((AutoReplyText)localObject).getTextId());
        }
      }
      if (j != 0)
      {
        this.g = true;
        notifyDataSetChanged();
      }
    }
  }
  
  private void d()
  {
    HashSet localHashSet = new HashSet(this.c);
    this.c.clear();
    this.c.addAll(localHashSet);
    Collections.sort(this.c);
  }
  
  public void a(int paramInt)
  {
    if (a())
    {
      Iterator localIterator = this.c.iterator();
      Object localObject1 = null;
      Object localObject2 = null;
      boolean bool1;
      Object localObject3;
      for (;;)
      {
        boolean bool2 = localIterator.hasNext();
        bool1 = true;
        if (!bool2) {
          break;
        }
        localObject3 = (AutoReplyText)localIterator.next();
        if (localObject3 != null)
        {
          Bundle localBundle = ((AutoReplyText)localObject3).getExtra();
          bool1 = localBundle.getBoolean("AutoReplyAdapter:in_use", false);
          Object localObject4 = localObject2;
          if (bool1) {
            localObject4 = localObject3;
          }
          if (((AutoReplyText)localObject3).getTextId() == paramInt)
          {
            localObject2 = localObject4;
            if (!bool1)
            {
              localBundle.putBoolean("AutoReplyAdapter:in_use", true);
              localObject1 = localObject3;
              localObject2 = localObject4;
            }
          }
          else
          {
            localBundle.putBoolean("AutoReplyAdapter:in_use", false);
            localObject2 = localObject4;
          }
        }
      }
      if (localObject1 != null)
      {
        if (localObject2 == null) {
          bool1 = false;
        }
        this.g = bool1;
        localObject3 = this.f;
        if (localObject3 != null) {
          ((AutoReplyAdapter.OnAutoReplyItemListener)localObject3).a(localObject1, localObject2);
        }
        notifyDataSetChanged();
      }
    }
  }
  
  public void a(@Nullable AutoReplyText paramAutoReplyText)
  {
    if ((a()) && (paramAutoReplyText != null))
    {
      if (paramAutoReplyText.getTextId() == 2147483647) {
        return;
      }
      Iterator localIterator = this.c.iterator();
      label32:
      AutoReplyText localAutoReplyText;
      for (Object localObject = null; localIterator.hasNext(); localObject = localAutoReplyText)
      {
        localAutoReplyText = (AutoReplyText)localIterator.next();
        if ((localAutoReplyText == null) || (localAutoReplyText.getTextId() != paramAutoReplyText.getTextId())) {
          break label32;
        }
        localIterator.remove();
      }
      paramAutoReplyText.getExtra().putBoolean("AutoReplyAdapter:in_use", false);
      if ((localObject != null) && (((AutoReplyText)localObject).getExtra().getBoolean("AutoReplyAdapter:in_use", false))) {
        paramAutoReplyText.getExtra().putBoolean("AutoReplyAdapter:in_use", true);
      }
      this.c.add(paramAutoReplyText);
      localObject = this.f;
      if (localObject != null) {
        ((AutoReplyAdapter.OnAutoReplyItemListener)localObject).a(paramAutoReplyText);
      }
      d();
      this.g = true;
      notifyDataSetChanged();
    }
  }
  
  public void a(@Nullable AutoReplyAdapter.OnAutoReplyItemListener paramOnAutoReplyItemListener)
  {
    this.f = paramOnAutoReplyItemListener;
  }
  
  public void a(List<AutoReplyText> paramList)
  {
    if (a())
    {
      this.c.clear();
      int i;
      if ((paramList != null) && (!paramList.isEmpty()))
      {
        this.c.addAll(paramList);
        paramList = paramList.iterator();
        i = 0;
        while (paramList.hasNext())
        {
          AutoReplyText localAutoReplyText = (AutoReplyText)paramList.next();
          if (localAutoReplyText.isChecked()) {
            i = localAutoReplyText.mTextId;
          }
          localAutoReplyText.getExtra().putBoolean("AutoReplyAdapter:in_use", false);
        }
        d();
      }
      else
      {
        i = 0;
      }
      notifyDataSetChanged();
      a(i);
      this.g = false;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (a())
    {
      this.e = paramBoolean;
      notifyDataSetChanged();
    }
  }
  
  public boolean a()
  {
    return Looper.getMainLooper() == Looper.myLooper();
  }
  
  public boolean areAllItemsEnabled()
  {
    return false;
  }
  
  public boolean b()
  {
    return this.g;
  }
  
  public ArrayList<AutoReplyText> c()
  {
    return this.c;
  }
  
  public int getCount()
  {
    if (this.e) {
      return this.c.size() + 1 + 1 + 1;
    }
    return 0;
  }
  
  @Nullable
  public Object getItem(int paramInt)
  {
    if ((paramInt >= 1) && (paramInt <= this.c.size())) {
      return this.c.get(paramInt - 1);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < 1)) {
      return 0;
    }
    if (paramInt == this.c.size() + 1) {
      return 3;
    }
    if ((paramInt >= 1) && (paramInt <= this.c.size())) {
      return 1;
    }
    if (paramInt == this.c.size() + 1 + 1) {
      return 4;
    }
    return 1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    LayoutInflater localLayoutInflater = LayoutInflater.from(this.b);
    View localView;
    if ((getItemViewType(paramInt) != 0) && (getItemViewType(paramInt) != 4))
    {
      if (getItemViewType(paramInt) == 3)
      {
        localView = b(localLayoutInflater, paramInt, paramViewGroup);
      }
      else
      {
        AutoReplyText localAutoReplyText = (AutoReplyText)getItem(paramInt);
        localView = paramView;
        if (localAutoReplyText != null) {
          localView = a(localLayoutInflater, paramInt, paramView, paramViewGroup, localAutoReplyText).a;
        }
      }
    }
    else {
      localView = a(localLayoutInflater, paramInt, paramViewGroup);
    }
    EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
  
  public boolean isEnabled(int paramInt)
  {
    return (paramInt != 0) && (paramInt != getCount() - 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.AutoReplyAdapter
 * JD-Core Version:    0.7.0.1
 */