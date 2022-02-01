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
  private List<ShareActionSheetBuilder.ActionSheetItem> a;
  private LayoutInflater b;
  private int c = 0;
  private ScreenShotFragment.ActionSheetItemAdapter.IconFactory d;
  private Resources e;
  
  public ScreenShotFragment$ActionSheetItemAdapter(Context paramContext, List<ShareActionSheetBuilder.ActionSheetItem> paramList)
  {
    this.a = paramList;
    this.b = LayoutInflater.from(paramContext);
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
      this.d = new ScreenShotFragment.ActionSheetItemAdapter.IconFactory(paramViewGroup.getContext());
    }
    int j = 0;
    Object localObject1;
    if (paramView == null)
    {
      paramView = this.b.inflate(2131624526, paramViewGroup, false);
      localObject1 = new ScreenShotFragment.ActionSheetItemViewHolder();
      ((ScreenShotFragment.ActionSheetItemViewHolder)localObject1).b = ((ImageView)paramView.findViewById(2131445759));
      ((ScreenShotFragment.ActionSheetItemViewHolder)localObject1).a = ((TextView)paramView.findViewById(2131445760));
      paramView.setTag(localObject1);
      paramView.setFocusable(true);
    }
    else
    {
      localObject1 = (ScreenShotFragment.ActionSheetItemViewHolder)paramView.getTag();
    }
    ((ScreenShotFragment.ActionSheetItemViewHolder)localObject1).c = a(paramInt);
    if (((ScreenShotFragment.ActionSheetItemViewHolder)localObject1).c == null)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("ShareActionSheetBuilder.ActionSheetItemAdapter.getView() getItem(");
      ((StringBuilder)localObject1).append(paramInt);
      ((StringBuilder)localObject1).append(") == null !!!");
      QLog.e("ScreenShotFragment", 2, ((StringBuilder)localObject1).toString());
    }
    else
    {
      paramView.setId(((ScreenShotFragment.ActionSheetItemViewHolder)localObject1).c.id);
      Object localObject2 = ((ScreenShotFragment.ActionSheetItemViewHolder)localObject1).a;
      Object localObject3 = ((ScreenShotFragment.ActionSheetItemViewHolder)localObject1).c.label;
      if (((ScreenShotFragment.ActionSheetItemViewHolder)localObject1).c.firstLineCount > 0) {
        i = ((ScreenShotFragment.ActionSheetItemViewHolder)localObject1).c.firstLineCount;
      } else {
        i = 6;
      }
      ((TextView)localObject2).setText(ScreenShotFragment.a((String)localObject3, i));
      int i = -8947849;
      localObject2 = ((ScreenShotFragment.ActionSheetItemViewHolder)localObject1).a;
      if (!((ScreenShotFragment.ActionSheetItemViewHolder)localObject1).c.enable) {
        i = 2138535799;
      }
      ((TextView)localObject2).setTextColor(i);
      if (((ScreenShotFragment.ActionSheetItemViewHolder)localObject1).c.iconNeedBg)
      {
        if (((ScreenShotFragment.ActionSheetItemViewHolder)localObject1).c.iconDrawable != null) {
          localObject2 = ((ScreenShotFragment.ActionSheetItemViewHolder)localObject1).c.iconDrawable;
        } else {
          localObject2 = this.e.getDrawable(((ScreenShotFragment.ActionSheetItemViewHolder)localObject1).c.icon);
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
        if (((ScreenShotFragment.ActionSheetItemViewHolder)localObject1).c.enable)
        {
          localObject3 = ScreenShotFragment.ActionSheetItemAdapter.IconFactory.a(this.d, (Drawable)localObject2);
          localObject2 = this.d.a((Drawable)localObject2, (Drawable)localObject3);
          ((ScreenShotFragment.ActionSheetItemViewHolder)localObject1).b.setImageDrawable((Drawable)localObject2);
        }
        else
        {
          localObject2 = ScreenShotFragment.ActionSheetItemAdapter.IconFactory.b(this.d, (Drawable)localObject2);
          ((ScreenShotFragment.ActionSheetItemViewHolder)localObject1).b.setImageDrawable((Drawable)localObject2);
        }
        if (Build.VERSION.SDK_INT >= 16) {
          ((ScreenShotFragment.ActionSheetItemViewHolder)localObject1).b.setBackground(null);
        } else {
          ((ScreenShotFragment.ActionSheetItemViewHolder)localObject1).b.setBackgroundDrawable(null);
        }
      }
      else
      {
        ((ScreenShotFragment.ActionSheetItemViewHolder)localObject1).b.setImageResource(2130837657);
        if (((ScreenShotFragment.ActionSheetItemViewHolder)localObject1).c.iconDrawable != null)
        {
          if (Build.VERSION.SDK_INT >= 16) {
            ((ScreenShotFragment.ActionSheetItemViewHolder)localObject1).b.setBackground(((ScreenShotFragment.ActionSheetItemViewHolder)localObject1).c.iconDrawable);
          } else {
            ((ScreenShotFragment.ActionSheetItemViewHolder)localObject1).b.setBackgroundDrawable(((ScreenShotFragment.ActionSheetItemViewHolder)localObject1).c.iconDrawable);
          }
        }
        else {
          ((ScreenShotFragment.ActionSheetItemViewHolder)localObject1).b.setBackgroundResource(((ScreenShotFragment.ActionSheetItemViewHolder)localObject1).c.icon);
        }
      }
      if (AppSetting.e)
      {
        if (((ScreenShotFragment.ActionSheetItemViewHolder)localObject1).c.label != null) {
          localObject1 = ((ScreenShotFragment.ActionSheetItemViewHolder)localObject1).c.label;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.screendetect.ScreenShotFragment.ActionSheetItemAdapter
 * JD-Core Version:    0.7.0.1
 */