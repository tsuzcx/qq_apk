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
  public PresetWordsListAdapter.OnItemEventListener a;
  protected List<String> a;
  public boolean a;
  private boolean b = false;
  private boolean c = false;
  
  public PresetWordsListAdapter()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Boolean = false;
  }
  
  private void a(int paramInt, PresetWordsListAdapter.ViewHolder paramViewHolder, String paramString, ViewGroup paramViewGroup)
  {
    if (paramInt == 0)
    {
      if (paramString.equals(paramViewGroup.getContext().getString(2131720009)))
      {
        paramViewHolder.b.setVisibility(8);
        paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.setTextColor(ColorUtils.a("#4D94FF"));
        paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.setTag(TroopNickRuleFragment.f);
        paramString = (LinearLayout.LayoutParams)paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
        if (paramString != null)
        {
          paramString.rightMargin = ViewUtils.b(12.0F);
          paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams(paramString);
        }
        paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.setClickable(true);
        paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(paramViewHolder);
        return;
      }
      paramViewHolder.b.setVisibility(0);
      paramViewHolder.b.setOnClickListener(paramViewHolder);
      paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramViewGroup.getContext().getResources().getColorStateList(2131167061));
      paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.setTag(TroopNickRuleFragment.g);
      paramString = (LinearLayout.LayoutParams)paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
      if (paramString != null)
      {
        paramString.rightMargin = ViewUtils.b(7.0F);
        paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams(paramString);
      }
      paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(null);
      paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.setClickable(false);
    }
  }
  
  public String a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return (String)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return "";
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaUtilList.add(paramString);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void b()
  {
    this.b = true;
  }
  
  public void c()
  {
    this.c = true;
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
    String str = a(paramInt);
    if (!TextUtils.isEmpty(str))
    {
      View localView;
      Object localObject;
      if (paramView == null)
      {
        localView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131560690, null, false);
        if (this.b) {
          localView.setBackgroundDrawable(paramViewGroup.getContext().getResources().getDrawable(2130846418));
        }
        localObject = new PresetWordsListAdapter.ViewHolder(this);
        ((PresetWordsListAdapter.ViewHolder)localObject).jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131373018));
        ((PresetWordsListAdapter.ViewHolder)localObject).b = ((TextView)localView.findViewById(2131373019));
        ((PresetWordsListAdapter.ViewHolder)localObject).b.setTag(TroopNickRuleFragment.e);
        localView.setTag(localObject);
        if (this.c)
        {
          ((LinearLayout.LayoutParams)((PresetWordsListAdapter.ViewHolder)localObject).jdField_a_of_type_AndroidWidgetTextView.getLayoutParams()).setMargins(30, 15, 30, 15);
          ((PresetWordsListAdapter.ViewHolder)localObject).jdField_a_of_type_AndroidWidgetTextView.setOnClickListener((View.OnClickListener)localObject);
          ((PresetWordsListAdapter.ViewHolder)localObject).b.setVisibility(8);
        }
        else
        {
          ((PresetWordsListAdapter.ViewHolder)localObject).b.setOnClickListener((View.OnClickListener)localObject);
          a(paramInt, (PresetWordsListAdapter.ViewHolder)localObject, str, paramViewGroup);
        }
      }
      else
      {
        PresetWordsListAdapter.ViewHolder localViewHolder = (PresetWordsListAdapter.ViewHolder)paramView.getTag();
        localObject = localViewHolder;
        localView = paramView;
        if (!this.c)
        {
          a(paramInt, localViewHolder, str, paramViewGroup);
          localView = paramView;
          localObject = localViewHolder;
        }
      }
      ((PresetWordsListAdapter.ViewHolder)localObject).jdField_a_of_type_AndroidWidgetTextView.setText(str);
      ((PresetWordsListAdapter.ViewHolder)localObject).jdField_a_of_type_Int = paramInt;
      paramView = localView;
    }
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.PresetWordsListAdapter
 * JD-Core Version:    0.7.0.1
 */