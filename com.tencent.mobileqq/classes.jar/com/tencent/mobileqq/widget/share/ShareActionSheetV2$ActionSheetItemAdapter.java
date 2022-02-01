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
import aozt;
import bbyp;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItemViewHolder;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Iterator;
import java.util.List;

public class ShareActionSheetV2$ActionSheetItemAdapter
  extends BaseAdapter
{
  private LayoutInflater inflater;
  private List<ShareActionSheetBuilder.ActionSheetItem> items;
  private ShareActionSheetV2.ActionSheetItemAdapter.IconFactory mIconFactory;
  private int mIconSize;
  private Resources mRes;
  private ShareActionSheetV2 mShareActionSheetV2;
  
  public ShareActionSheetV2$ActionSheetItemAdapter(Context paramContext, List<ShareActionSheetBuilder.ActionSheetItem> paramList, ShareActionSheetV2 paramShareActionSheetV2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShareActionSheetV2", 2, "ActionSheetItemAdapter() called with: context = [" + paramContext + "], objects = [" + paramList + "] #this = " + Integer.toHexString(System.identityHashCode(this)));
    }
    this.items = paramList;
    this.inflater = LayoutInflater.from(paramContext);
    this.mShareActionSheetV2 = paramShareActionSheetV2;
  }
  
  private static void bindIconBackground(ShareActionSheetBuilder.ActionSheetItemViewHolder paramActionSheetItemViewHolder)
  {
    if (paramActionSheetItemViewHolder.sheetItem.iconDrawable != null)
    {
      if (Build.VERSION.SDK_INT >= 16)
      {
        paramActionSheetItemViewHolder.vIcon.setBackground(paramActionSheetItemViewHolder.sheetItem.iconDrawable);
        return;
      }
      paramActionSheetItemViewHolder.vIcon.setBackgroundDrawable(paramActionSheetItemViewHolder.sheetItem.iconDrawable);
      return;
    }
    paramActionSheetItemViewHolder.vIcon.setBackgroundResource(paramActionSheetItemViewHolder.sheetItem.icon);
  }
  
  private void bindIconFace(ShareActionSheetBuilder.ActionSheetItemViewHolder paramActionSheetItemViewHolder)
  {
    if (paramActionSheetItemViewHolder.sheetItem.action == 72) {
      loadAvatar(paramActionSheetItemViewHolder.sheetItem.uinType, paramActionSheetItemViewHolder.sheetItem.uin, paramActionSheetItemViewHolder.vIcon, paramActionSheetItemViewHolder, this, this.mShareActionSheetV2);
    }
  }
  
  private static void loadAvatar(int paramInt, String paramString, ImageView paramImageView, ShareActionSheetBuilder.ActionSheetItemViewHolder paramActionSheetItemViewHolder, ActionSheetItemAdapter paramActionSheetItemAdapter, ShareActionSheetV2 paramShareActionSheetV2)
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
      if (ShareActionSheetV2.access$1400(paramShareActionSheetV2) == null) {
        ShareActionSheetV2.access$1402(paramShareActionSheetV2, new SparseArray());
      }
      aozt localaozt = (aozt)ShareActionSheetV2.access$1400(paramShareActionSheetV2).get(paramInt);
      paramActionSheetItemAdapter = localaozt;
      if (localaozt == null)
      {
        paramActionSheetItemAdapter = new aozt(paramShareActionSheetV2.mOutAct, paramInt);
        if (!bbyp.a()) {
          break label278;
        }
      }
      for (byte b = 1;; b = 3)
      {
        paramActionSheetItemAdapter.a(b);
        paramActionSheetItemAdapter.a();
        ShareActionSheetV2.access$1400(paramShareActionSheetV2).put(paramInt, paramActionSheetItemAdapter);
        paramImageView.setTag(paramString);
        paramActionSheetItemAdapter.a(ShareActionSheetV2.access$1500(paramShareActionSheetV2));
        paramString = paramActionSheetItemAdapter.a(paramString, true);
        if (paramString == null) {
          break;
        }
        paramActionSheetItemViewHolder.sheetItem.iconDrawable = new BitmapDrawable(paramString);
        bindIconBackground(paramActionSheetItemViewHolder);
        return;
        paramInt = 1;
        break label90;
        if ((TextUtils.isEmpty(paramActionSheetItemViewHolder.sheetItem.argus)) || (!paramActionSheetItemViewHolder.sheetItem.argus.contains("isNewTroop=1"))) {
          break label284;
        }
        paramInt = 113;
        break label90;
        paramInt = 101;
        break label90;
      }
      paramInt = 4;
    }
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
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int j = 0;
    if (this.mRes == null) {
      this.mRes = paramViewGroup.getContext().getResources();
    }
    if (this.mIconSize == 0) {
      this.mIconSize = ((int)this.mRes.getDimension(2131296795));
    }
    if (this.mIconFactory == null) {
      this.mIconFactory = new ShareActionSheetV2.ActionSheetItemAdapter.IconFactory(paramViewGroup.getContext());
    }
    View localView;
    if (paramView == null)
    {
      localView = this.inflater.inflate(2131558942, paramViewGroup, false);
      paramView = new ShareActionSheetBuilder.ActionSheetItemViewHolder();
      paramView.vIcon = ((ImageView)localView.findViewById(2131377257));
      paramView.vLabel = ((TextView)localView.findViewById(2131377258));
      localView.setTag(paramView);
    }
    for (;;)
    {
      paramView.sheetItem = getItem(paramInt);
      if (paramView.sheetItem != null) {
        break;
      }
      QLog.e("ShareActionSheetV2", 2, "ShareActionSheetBuilder.ActionSheetItemAdapter.getView() getItem(" + paramInt + ") == null !!!");
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return localView;
      localObject = (ShareActionSheetBuilder.ActionSheetItemViewHolder)paramView.getTag();
      localView = paramView;
      paramView = (View)localObject;
    }
    localView.setId(paramView.sheetItem.id);
    float f = this.mRes.getDimension(2131296795);
    paramView.vLabel.getPaint().setTextSize(this.mRes.getDimensionPixelSize(2131299005));
    paramView.vLabel.setMaxWidth((int)f);
    paramView.vLabel.setText(paramView.sheetItem.label);
    int i = -8947849;
    Object localObject = paramView.vLabel;
    if (paramView.sheetItem.enable)
    {
      label301:
      ((TextView)localObject).setTextColor(i);
      if (!paramView.sheetItem.iconNeedBg) {
        break label539;
      }
      if (paramView.sheetItem.iconDrawable == null) {
        break label480;
      }
      localObject = paramView.sheetItem.iconDrawable;
      label337:
      i = ((Drawable)localObject).getIntrinsicWidth();
      int k = ((Drawable)localObject).getIntrinsicHeight();
      if (this.mIconSize <= i) {
        break label499;
      }
      i = (int)((this.mIconSize - i) / 2.0F);
      label373:
      if (this.mIconSize > k) {
        j = (int)((this.mIconSize - k) / 2.0F);
      }
      localObject = this.mIconFactory.addBackground((Drawable)localObject, i, j);
      if (!paramView.sheetItem.enable) {
        break label505;
      }
      Drawable localDrawable = ShareActionSheetV2.ActionSheetItemAdapter.IconFactory.access$1200(this.mIconFactory, (Drawable)localObject);
      localObject = this.mIconFactory.makePressedStateListDrawable((Drawable)localObject, localDrawable);
      paramView.vIcon.setImageDrawable((Drawable)localObject);
      label453:
      if (Build.VERSION.SDK_INT < 16) {
        break label528;
      }
      paramView.vIcon.setBackground(null);
    }
    for (;;)
    {
      break;
      i = 2138535799;
      break label301;
      label480:
      localObject = this.mRes.getDrawable(paramView.sheetItem.icon);
      break label337;
      label499:
      i = 0;
      break label373;
      label505:
      localObject = ShareActionSheetV2.ActionSheetItemAdapter.IconFactory.access$1300(this.mIconFactory, (Drawable)localObject);
      paramView.vIcon.setImageDrawable((Drawable)localObject);
      break label453;
      label528:
      paramView.vIcon.setBackgroundDrawable(null);
    }
    label539:
    if ((paramView.sheetItem.action == 72) || (paramView.sheetItem.action == 73)) {
      if (bbyp.a()) {
        paramView.vIcon.setImageResource(2130837564);
      }
    }
    for (;;)
    {
      bindIconBackground(paramView);
      bindIconFace(paramView);
      break;
      paramView.vIcon.setImageResource(2130837563);
      continue;
      paramView.vIcon.setImageResource(2130837562);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.share.ShareActionSheetV2.ActionSheetItemAdapter
 * JD-Core Version:    0.7.0.1
 */