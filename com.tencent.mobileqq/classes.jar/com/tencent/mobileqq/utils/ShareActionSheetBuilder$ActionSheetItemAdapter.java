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
  private List<ShareActionSheetBuilder.ActionSheetItem> a;
  private LayoutInflater b;
  private int c = 0;
  private ShareActionSheetBuilder.ActionSheetItemAdapter.IconFactory d;
  private Resources e;
  
  public ShareActionSheetBuilder$ActionSheetItemAdapter(Context paramContext, List<ShareActionSheetBuilder.ActionSheetItem> paramList)
  {
    this.a = paramList;
    this.b = LayoutInflater.from(paramContext);
  }
  
  protected int a()
  {
    return 2131624526;
  }
  
  public ShareActionSheetBuilder.ActionSheetItem a(int paramInt)
  {
    if (this.a != null)
    {
      if (paramInt < 0) {
        return null;
      }
      int j = -1;
      int i = 0;
      while (i < this.a.size())
      {
        ShareActionSheetBuilder.ActionSheetItem localActionSheetItem = (ShareActionSheetBuilder.ActionSheetItem)this.a.get(i);
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
    Object localObject = this.a;
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
    if (this.e == null) {
      this.e = paramViewGroup.getContext().getResources();
    }
    if (this.c == 0) {
      this.c = ((int)this.e.getDimension(2131297127));
    }
    if (this.d == null) {
      this.d = a(paramViewGroup.getContext());
    }
    int j = 0;
    Object localObject1;
    if (paramView == null)
    {
      paramView = this.b.inflate(a(), paramViewGroup, false);
      localObject1 = new ShareActionSheetBuilder.ActionSheetItemViewHolder();
      ((ShareActionSheetBuilder.ActionSheetItemViewHolder)localObject1).b = ((ImageView)paramView.findViewById(2131445759));
      ((ShareActionSheetBuilder.ActionSheetItemViewHolder)localObject1).a = ((TextView)paramView.findViewById(2131445760));
      paramView.setTag(localObject1);
    }
    else
    {
      localObject1 = (ShareActionSheetBuilder.ActionSheetItemViewHolder)paramView.getTag();
    }
    ((ShareActionSheetBuilder.ActionSheetItemViewHolder)localObject1).c = a(paramInt);
    if (((ShareActionSheetBuilder.ActionSheetItemViewHolder)localObject1).c == null)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("ShareActionSheetBuilder.ActionSheetItemAdapter.getView() getItem(");
      ((StringBuilder)localObject1).append(paramInt);
      ((StringBuilder)localObject1).append(") == null !!!");
      QLog.e("ShareActionSheetBuilder", 2, ((StringBuilder)localObject1).toString());
    }
    else
    {
      paramView.setId(((ShareActionSheetBuilder.ActionSheetItemViewHolder)localObject1).c.id);
      float f = this.e.getDimension(2131297127);
      Object localObject2 = ((ShareActionSheetBuilder.ActionSheetItemViewHolder)localObject1).a.getPaint();
      ((TextPaint)localObject2).setTextSize(this.e.getDimensionPixelSize(2131299839));
      Object localObject3 = ((ShareActionSheetBuilder.ActionSheetItemViewHolder)localObject1).a;
      String str = ((ShareActionSheetBuilder.ActionSheetItemViewHolder)localObject1).c.label;
      if (((ShareActionSheetBuilder.ActionSheetItemViewHolder)localObject1).c.firstLineCount > 0) {
        i = ((ShareActionSheetBuilder.ActionSheetItemViewHolder)localObject1).c.firstLineCount;
      } else {
        i = 5;
      }
      ((TextView)localObject3).setText(ShareActionSheetBuilder.a((TextPaint)localObject2, f, str, i));
      int i = -8947849;
      localObject2 = ((ShareActionSheetBuilder.ActionSheetItemViewHolder)localObject1).a;
      if (!((ShareActionSheetBuilder.ActionSheetItemViewHolder)localObject1).c.enable) {
        i = 2138535799;
      }
      ((TextView)localObject2).setTextColor(i);
      if (((ShareActionSheetBuilder.ActionSheetItemViewHolder)localObject1).c.iconNeedBg)
      {
        if (((ShareActionSheetBuilder.ActionSheetItemViewHolder)localObject1).c.iconDrawable != null) {
          localObject2 = ((ShareActionSheetBuilder.ActionSheetItemViewHolder)localObject1).c.iconDrawable;
        } else {
          localObject2 = this.e.getDrawable(((ShareActionSheetBuilder.ActionSheetItemViewHolder)localObject1).c.icon);
        }
        i = ((Drawable)localObject2).getIntrinsicWidth();
        int k = ((Drawable)localObject2).getIntrinsicHeight();
        int m = this.c;
        if (m > i) {
          i = (int)((m - i) / 2.0F);
        } else {
          i = 0;
        }
        m = this.c;
        if (m > k) {
          j = (int)((m - k) / 2.0F);
        }
        localObject2 = this.d.a((Drawable)localObject2, i, j);
        if (((ShareActionSheetBuilder.ActionSheetItemViewHolder)localObject1).c.enable)
        {
          localObject3 = ShareActionSheetBuilder.ActionSheetItemAdapter.IconFactory.a(this.d, (Drawable)localObject2);
          localObject2 = this.d.a((Drawable)localObject2, (Drawable)localObject3);
          ((ShareActionSheetBuilder.ActionSheetItemViewHolder)localObject1).b.setImageDrawable((Drawable)localObject2);
        }
        else
        {
          localObject2 = ShareActionSheetBuilder.ActionSheetItemAdapter.IconFactory.b(this.d, (Drawable)localObject2);
          ((ShareActionSheetBuilder.ActionSheetItemViewHolder)localObject1).b.setImageDrawable((Drawable)localObject2);
        }
        if (Build.VERSION.SDK_INT >= 16) {
          ((ShareActionSheetBuilder.ActionSheetItemViewHolder)localObject1).b.setBackground(null);
        } else {
          ((ShareActionSheetBuilder.ActionSheetItemViewHolder)localObject1).b.setBackgroundDrawable(null);
        }
      }
      else
      {
        ((ShareActionSheetBuilder.ActionSheetItemViewHolder)localObject1).b.setImageResource(2130837657);
        if (((ShareActionSheetBuilder.ActionSheetItemViewHolder)localObject1).c.iconDrawable != null)
        {
          if (Build.VERSION.SDK_INT >= 16) {
            ((ShareActionSheetBuilder.ActionSheetItemViewHolder)localObject1).b.setBackground(((ShareActionSheetBuilder.ActionSheetItemViewHolder)localObject1).c.iconDrawable);
          } else {
            ((ShareActionSheetBuilder.ActionSheetItemViewHolder)localObject1).b.setBackgroundDrawable(((ShareActionSheetBuilder.ActionSheetItemViewHolder)localObject1).c.iconDrawable);
          }
        }
        else {
          ((ShareActionSheetBuilder.ActionSheetItemViewHolder)localObject1).b.setBackgroundResource(((ShareActionSheetBuilder.ActionSheetItemViewHolder)localObject1).c.icon);
        }
      }
    }
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItemAdapter
 * JD-Core Version:    0.7.0.1
 */