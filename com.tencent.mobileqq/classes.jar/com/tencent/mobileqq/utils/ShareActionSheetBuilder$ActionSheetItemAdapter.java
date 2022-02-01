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
  private LayoutInflater inflater;
  private List<ShareActionSheetBuilder.ActionSheetItem> items;
  private ShareActionSheetBuilder.ActionSheetItemAdapter.IconFactory mIconFactory;
  private int mIconSize;
  private Resources mRes;
  
  public ShareActionSheetBuilder$ActionSheetItemAdapter(Context paramContext, List<ShareActionSheetBuilder.ActionSheetItem> paramList)
  {
    this.items = paramList;
    this.inflater = LayoutInflater.from(paramContext);
  }
  
  protected ShareActionSheetBuilder.ActionSheetItemAdapter.IconFactory createIconFactory(Context paramContext)
  {
    return new ShareActionSheetBuilder.ActionSheetItemAdapter.IconFactory(paramContext);
  }
  
  public int getCount()
  {
    if (this.items == null) {
      return 0;
    }
    Iterator localIterator = this.items.iterator();
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
  
  public ShareActionSheetBuilder.ActionSheetItem getItem(int paramInt)
  {
    ShareActionSheetBuilder.ActionSheetItem localActionSheetItem;
    if ((this.items == null) || (paramInt < 0))
    {
      localActionSheetItem = null;
      return localActionSheetItem;
    }
    int j = -1;
    int i = 0;
    for (;;)
    {
      if (i >= this.items.size()) {
        break label89;
      }
      localActionSheetItem = (ShareActionSheetBuilder.ActionSheetItem)this.items.get(i);
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
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  protected int getLayoutId()
  {
    return 2131558969;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int j = 0;
    if (this.mRes == null) {
      this.mRes = paramViewGroup.getContext().getResources();
    }
    if (this.mIconSize == 0) {
      this.mIconSize = ((int)this.mRes.getDimension(2131296796));
    }
    if (this.mIconFactory == null) {
      this.mIconFactory = createIconFactory(paramViewGroup.getContext());
    }
    View localView;
    if (paramView == null)
    {
      localView = this.inflater.inflate(getLayoutId(), paramViewGroup, false);
      paramView = new ShareActionSheetBuilder.ActionSheetItemViewHolder();
      paramView.vIcon = ((ImageView)localView.findViewById(2131377530));
      paramView.vLabel = ((TextView)localView.findViewById(2131377531));
      localView.setTag(paramView);
    }
    for (;;)
    {
      paramView.sheetItem = getItem(paramInt);
      if (paramView.sheetItem != null) {
        break;
      }
      QLog.e("ShareActionSheetBuilder", 2, "ShareActionSheetBuilder.ActionSheetItemAdapter.getView() getItem(" + paramInt + ") == null !!!");
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return localView;
      localObject1 = (ShareActionSheetBuilder.ActionSheetItemViewHolder)paramView.getTag();
      localView = paramView;
      paramView = (View)localObject1;
    }
    localView.setId(paramView.sheetItem.id);
    float f = this.mRes.getDimension(2131296796);
    Object localObject1 = paramView.vLabel.getPaint();
    ((TextPaint)localObject1).setTextSize(this.mRes.getDimensionPixelSize(2131299009));
    Object localObject2 = paramView.vLabel;
    String str = paramView.sheetItem.label;
    int i;
    if (paramView.sheetItem.firstLineCount > 0)
    {
      i = paramView.sheetItem.firstLineCount;
      label285:
      ((TextView)localObject2).setText(ShareActionSheetBuilder.breakLabel2((TextPaint)localObject1, f, str, i));
      i = -8947849;
      localObject1 = paramView.vLabel;
      if (!paramView.sheetItem.enable) {
        break label498;
      }
      label321:
      ((TextView)localObject1).setTextColor(i);
      if (!paramView.sheetItem.iconNeedBg) {
        break label565;
      }
      if (paramView.sheetItem.iconDrawable == null) {
        break label506;
      }
      localObject1 = paramView.sheetItem.iconDrawable;
      label357:
      i = ((Drawable)localObject1).getIntrinsicWidth();
      int k = ((Drawable)localObject1).getIntrinsicHeight();
      if (this.mIconSize <= i) {
        break label525;
      }
      i = (int)((this.mIconSize - i) / 2.0F);
      label393:
      if (this.mIconSize > k) {
        j = (int)((this.mIconSize - k) / 2.0F);
      }
      localObject1 = this.mIconFactory.addBackground((Drawable)localObject1, i, j);
      if (!paramView.sheetItem.enable) {
        break label531;
      }
      localObject2 = ShareActionSheetBuilder.ActionSheetItemAdapter.IconFactory.access$000(this.mIconFactory, (Drawable)localObject1);
      localObject1 = this.mIconFactory.makePressedStateListDrawable((Drawable)localObject1, (Drawable)localObject2);
      paramView.vIcon.setImageDrawable((Drawable)localObject1);
      label473:
      if (Build.VERSION.SDK_INT < 16) {
        break label554;
      }
      paramView.vIcon.setBackground(null);
    }
    for (;;)
    {
      break;
      i = 5;
      break label285;
      label498:
      i = 2138535799;
      break label321;
      label506:
      localObject1 = this.mRes.getDrawable(paramView.sheetItem.icon);
      break label357;
      label525:
      i = 0;
      break label393;
      label531:
      localObject1 = ShareActionSheetBuilder.ActionSheetItemAdapter.IconFactory.access$100(this.mIconFactory, (Drawable)localObject1);
      paramView.vIcon.setImageDrawable((Drawable)localObject1);
      break label473;
      label554:
      paramView.vIcon.setBackgroundDrawable(null);
      continue;
      label565:
      paramView.vIcon.setImageResource(2130837562);
      if (paramView.sheetItem.iconDrawable != null)
      {
        if (Build.VERSION.SDK_INT >= 16) {
          paramView.vIcon.setBackground(paramView.sheetItem.iconDrawable);
        } else {
          paramView.vIcon.setBackgroundDrawable(paramView.sheetItem.iconDrawable);
        }
      }
      else {
        paramView.vIcon.setBackgroundResource(paramView.sheetItem.icon);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItemAdapter
 * JD-Core Version:    0.7.0.1
 */