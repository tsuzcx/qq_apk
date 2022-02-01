package com.tencent.mobileqq.troop.troopcard.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.troop.association.data.AssociatedTroopItem;
import com.tencent.mobileqq.troop.widget.TroopActiveLayout;
import com.tencent.mobileqq.troop.widget.TroopLabelLayout;
import com.tencent.mobileqq.widget.FolderTextView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.SingleLineTextView;
import com.tencent.widget.ThemeImageView;
import java.util.ArrayList;
import java.util.List;

public class TroopAssociationsAdapter
  extends BaseAdapter
{
  private AppInterface a;
  private Context b;
  private String c;
  private long d;
  private List<AssociatedTroopItem> e = new ArrayList();
  private View.OnClickListener f = new TroopAssociationsAdapter.1(this);
  private View.OnClickListener g = new TroopAssociationsAdapter.2(this);
  
  public TroopAssociationsAdapter(Context paramContext, AppInterface paramAppInterface, String paramString, long paramLong)
  {
    this.a = paramAppInterface;
    this.b = paramContext;
    this.c = paramString;
    this.d = paramLong;
  }
  
  private View a(Context paramContext, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2, View.OnClickListener paramOnClickListener3)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(2131627883, null);
    paramOnClickListener3 = new TroopAssociationsAdapter.ViewHolder();
    paramOnClickListener3.a = paramContext;
    paramOnClickListener3.b = ((ImageView)paramContext.findViewById(2131436633));
    if ((paramOnClickListener3.b instanceof ThemeImageView)) {
      ((ThemeImageView)paramOnClickListener3.b).setSupportMaskView(false);
    }
    paramOnClickListener3.c = ((SingleLineTextView)paramContext.findViewById(2131448843));
    paramOnClickListener3.d = ((Button)paramContext.findViewById(2131429917));
    paramOnClickListener3.e = ((TroopActiveLayout)paramContext.findViewById(2131429299));
    paramOnClickListener3.f = ((TroopLabelLayout)paramContext.findViewById(2131429306));
    paramOnClickListener3.g = ((FolderTextView)paramContext.findViewById(2131448375));
    paramOnClickListener3.d.setOnClickListener(paramOnClickListener2);
    paramContext.setOnClickListener(paramOnClickListener1);
    paramContext.setTag(paramOnClickListener3);
    return paramContext;
  }
  
  private void a(TroopAssociationsAdapter.ViewHolder paramViewHolder, AssociatedTroopItem paramAssociatedTroopItem, Drawable paramDrawable)
  {
    if ((paramViewHolder != null) && (paramAssociatedTroopItem != null))
    {
      paramViewHolder.b.setImageDrawable(paramDrawable);
      paramViewHolder.c.setText(paramAssociatedTroopItem.name);
      paramViewHolder.c.setContentDescription(paramAssociatedTroopItem.name);
      paramDrawable = paramAssociatedTroopItem.labelList;
      if ((paramDrawable != null) && (paramDrawable.size() > 0))
      {
        paramViewHolder.f.setVisibility(0);
        paramViewHolder.f.setLabelType(1);
        paramViewHolder.f.setAutoCreateDistanceTextView(true);
        paramViewHolder.f.a(paramDrawable);
      }
      else
      {
        paramViewHolder.f.setVisibility(8);
      }
      if (paramAssociatedTroopItem.privilege != 3)
      {
        paramViewHolder.d.setEnabled(false);
        paramViewHolder.d.setText(2131897486);
        paramViewHolder.d.setBackgroundResource(0);
        paramViewHolder.d.setPadding(this.b.getResources().getDimensionPixelSize(2131297073), 0, 0, 0);
      }
      else if (paramAssociatedTroopItem.memberNum < paramAssociatedTroopItem.maxMemberNum)
      {
        paramViewHolder.d.setEnabled(true);
        paramViewHolder.d.setText(2131897485);
        paramViewHolder.d.setBackgroundResource(2130839494);
        paramViewHolder.d.setPadding(this.b.getResources().getDimensionPixelSize(2131297073), 0, this.b.getResources().getDimensionPixelSize(2131297073), 0);
      }
      else
      {
        paramViewHolder.d.setEnabled(false);
        paramViewHolder.d.setText(2131897483);
        paramViewHolder.d.setBackgroundResource(0);
        paramViewHolder.d.setPadding(this.b.getResources().getDimensionPixelSize(2131297073), 0, 0, 0);
      }
      if (TextUtils.isEmpty(paramAssociatedTroopItem.intro)) {
        paramViewHolder.g.setText(this.b.getString(2131893911));
      } else {
        paramViewHolder.g.setText(new QQText(paramAssociatedTroopItem.intro, 11, 16));
      }
      paramViewHolder.d.setTag(paramAssociatedTroopItem);
      paramViewHolder.a.setTag(paramAssociatedTroopItem);
      return;
    }
    QLog.d("TroopAssociationsAdapter", 1, "viewHolder == null || troopItem == null");
  }
  
  public AssociatedTroopItem a(int paramInt)
  {
    return (AssociatedTroopItem)this.e.get(paramInt);
  }
  
  public void a(List<AssociatedTroopItem> paramList)
  {
    if (paramList != null)
    {
      this.e.clear();
      this.e.addAll(paramList);
      notifyDataSetChanged();
    }
  }
  
  public int getCount()
  {
    return this.e.size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    if (paramView != null)
    {
      localView = paramView;
      if ((paramView.getTag() instanceof TroopAssociationsAdapter.ViewHolder)) {}
    }
    else
    {
      localView = a(this.b, this.g, this.f, null);
    }
    paramView = (TroopAssociationsAdapter.ViewHolder)localView.getTag();
    AssociatedTroopItem localAssociatedTroopItem = a(paramInt);
    a(paramView, localAssociatedTroopItem, FaceDrawable.getFaceDrawable(this.a, 4, localAssociatedTroopItem.uin));
    EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcard.ui.TroopAssociationsAdapter
 * JD-Core Version:    0.7.0.1
 */