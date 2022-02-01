package com.tencent.mobileqq.troop.activity;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.util.ColorUtils;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class PresetWordsListAdapter
  extends BaseAdapter
{
  protected List<String> a = new ArrayList();
  public boolean b = false;
  public PresetWordsListAdapter.OnItemEventListener c;
  private boolean d = false;
  private boolean e = false;
  
  private void a(int paramInt, PresetWordsListAdapter.ViewHolder paramViewHolder, String paramString, ViewGroup paramViewGroup)
  {
    if (paramInt == 0)
    {
      if (paramString.equals(paramViewGroup.getContext().getString(2131917614)))
      {
        paramViewHolder.c.setVisibility(8);
        paramViewHolder.b.setTextColor(ColorUtils.a("#4D94FF"));
        paramViewHolder.b.setTag(TroopNickRuleFragment.f);
        paramString = (LinearLayout.LayoutParams)paramViewHolder.b.getLayoutParams();
        if (paramString != null)
        {
          paramString.rightMargin = ViewUtils.dpToPx(12.0F);
          paramViewHolder.b.setLayoutParams(paramString);
        }
        paramViewHolder.b.setClickable(true);
        paramViewHolder.b.setOnClickListener(paramViewHolder);
        return;
      }
      paramViewHolder.c.setVisibility(0);
      paramViewHolder.c.setOnClickListener(paramViewHolder);
      paramViewHolder.b.setTextColor(paramViewGroup.getContext().getResources().getColorStateList(2131167999));
      paramViewHolder.b.setTag(TroopNickRuleFragment.g);
      paramString = (LinearLayout.LayoutParams)paramViewHolder.b.getLayoutParams();
      if (paramString != null)
      {
        paramString.rightMargin = ViewUtils.dpToPx(7.0F);
        paramViewHolder.b.setLayoutParams(paramString);
      }
      paramViewHolder.b.setOnClickListener(null);
      paramViewHolder.b.setClickable(false);
    }
  }
  
  public String a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.a.size())) {
      return (String)this.a.get(paramInt);
    }
    return "";
  }
  
  public void a()
  {
    this.a.clear();
  }
  
  public void a(String paramString)
  {
    this.a.add(paramString);
  }
  
  public boolean b()
  {
    return this.b;
  }
  
  public void c()
  {
    this.d = true;
  }
  
  public void d()
  {
    this.e = true;
  }
  
  public int getCount()
  {
    return this.a.size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    String str = a(paramInt);
    if (!TextUtils.isEmpty(str))
    {
      View localView;
      Object localObject;
      if (paramView == null)
      {
        localView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131626735, null, false);
        if (this.d) {
          localView.setBackgroundDrawable(paramViewGroup.getContext().getResources().getDrawable(2130847891));
        }
        localObject = new PresetWordsListAdapter.ViewHolder(this);
        ((PresetWordsListAdapter.ViewHolder)localObject).b = ((TextView)localView.findViewById(2131440597));
        ((PresetWordsListAdapter.ViewHolder)localObject).c = ((TextView)localView.findViewById(2131440598));
        ((PresetWordsListAdapter.ViewHolder)localObject).c.setTag(TroopNickRuleFragment.e);
        localView.setTag(localObject);
        if (this.e)
        {
          ((LinearLayout.LayoutParams)((PresetWordsListAdapter.ViewHolder)localObject).b.getLayoutParams()).setMargins(30, 15, 30, 15);
          ((PresetWordsListAdapter.ViewHolder)localObject).b.setOnClickListener((View.OnClickListener)localObject);
          ((PresetWordsListAdapter.ViewHolder)localObject).c.setVisibility(8);
        }
        else
        {
          ((PresetWordsListAdapter.ViewHolder)localObject).c.setOnClickListener((View.OnClickListener)localObject);
          a(paramInt, (PresetWordsListAdapter.ViewHolder)localObject, str, paramViewGroup);
        }
      }
      else
      {
        PresetWordsListAdapter.ViewHolder localViewHolder = (PresetWordsListAdapter.ViewHolder)paramView.getTag();
        localObject = localViewHolder;
        localView = paramView;
        if (!this.e)
        {
          a(paramInt, localViewHolder, str, paramViewGroup);
          localView = paramView;
          localObject = localViewHolder;
        }
      }
      ((PresetWordsListAdapter.ViewHolder)localObject).b.setText(str);
      ((PresetWordsListAdapter.ViewHolder)localObject).a = paramInt;
      paramView = localView;
    }
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.PresetWordsListAdapter
 * JD-Core Version:    0.7.0.1
 */