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
  private List<ShareActionSheetBuilder.ActionSheetItem> a;
  private LayoutInflater b;
  private int c = 0;
  private NativeShareView.ActionSheetItemAdapter.IconFactory d;
  private Resources e;
  
  public NativeShareView$ActionSheetItemAdapter(Context paramContext, List<ShareActionSheetBuilder.ActionSheetItem> paramList)
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
      this.d = new NativeShareView.ActionSheetItemAdapter.IconFactory(paramViewGroup.getContext());
    }
    int i = 0;
    if (paramView == null)
    {
      paramView = this.b.inflate(2131626021, paramViewGroup, false);
      paramViewGroup = new ScreenShotFragment.ActionSheetItemViewHolder();
      paramViewGroup.b = ((ImageView)paramView.findViewById(2131445759));
      paramViewGroup.a = ((TextView)paramView.findViewById(2131445760));
      paramView.setTag(paramViewGroup);
      paramView.setFocusable(true);
    }
    else
    {
      paramViewGroup = (ScreenShotFragment.ActionSheetItemViewHolder)paramView.getTag();
    }
    paramViewGroup.c = a(paramInt);
    if (paramViewGroup.c == null)
    {
      paramViewGroup = new StringBuilder();
      paramViewGroup.append("ShareActionSheetBuilder.ActionSheetItemAdapter.getView() getItem(");
      paramViewGroup.append(paramInt);
      paramViewGroup.append(") == null !!!");
      QLog.e("NativeShareView", 2, paramViewGroup.toString());
      return paramView;
    }
    paramView.setId(paramViewGroup.c.id);
    Object localObject1 = paramViewGroup.a;
    Object localObject2 = paramViewGroup.c.label;
    if (paramViewGroup.c.firstLineCount > 0) {
      paramInt = paramViewGroup.c.firstLineCount;
    } else {
      paramInt = 6;
    }
    ((TextView)localObject1).setText(NativeShareView.a((String)localObject2, paramInt));
    paramInt = -16578534;
    localObject1 = paramViewGroup.a;
    if (!paramViewGroup.c.enable) {
      paramInt = 2130905114;
    }
    ((TextView)localObject1).setTextColor(paramInt);
    if (paramViewGroup.c.iconNeedBg)
    {
      if (paramViewGroup.c.iconDrawable != null) {
        localObject1 = paramViewGroup.c.iconDrawable;
      } else {
        localObject1 = this.e.getDrawable(paramViewGroup.c.icon);
      }
      paramInt = ((Drawable)localObject1).getIntrinsicWidth();
      int j = ((Drawable)localObject1).getIntrinsicHeight();
      int k = this.c;
      if (k > paramInt) {
        paramInt = (int)((k - paramInt) / 2.0F);
      } else {
        paramInt = 0;
      }
      k = this.c;
      if (k > j) {
        i = (int)((k - j) / 2.0F);
      }
      localObject1 = this.d.a((Drawable)localObject1, paramInt, i);
      if (paramViewGroup.c.enable)
      {
        localObject2 = NativeShareView.ActionSheetItemAdapter.IconFactory.a(this.d, (Drawable)localObject1);
        localObject1 = this.d.a((Drawable)localObject1, (Drawable)localObject2);
        paramViewGroup.b.setImageDrawable((Drawable)localObject1);
      }
      else
      {
        localObject1 = NativeShareView.ActionSheetItemAdapter.IconFactory.b(this.d, (Drawable)localObject1);
        paramViewGroup.b.setImageDrawable((Drawable)localObject1);
      }
      if (Build.VERSION.SDK_INT >= 16) {
        paramViewGroup.b.setBackground(null);
      } else {
        paramViewGroup.b.setBackgroundDrawable(null);
      }
    }
    else
    {
      paramViewGroup.b.setImageResource(2130837657);
      if (paramViewGroup.c.iconDrawable != null)
      {
        if (Build.VERSION.SDK_INT >= 16) {
          paramViewGroup.b.setBackground(paramViewGroup.c.iconDrawable);
        } else {
          paramViewGroup.b.setBackgroundDrawable(paramViewGroup.c.iconDrawable);
        }
      }
      else {
        paramViewGroup.b.setBackgroundResource(paramViewGroup.c.icon);
      }
    }
    if (AppSetting.e)
    {
      if (paramViewGroup.c.label != null) {
        paramViewGroup = paramViewGroup.c.label;
      } else {
        paramViewGroup = "";
      }
      paramView.setContentDescription(paramViewGroup);
    }
    return paramView;
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.view.impl.NativeShareView.ActionSheetItemAdapter
 * JD-Core Version:    0.7.0.1
 */