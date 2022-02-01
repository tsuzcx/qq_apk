package com.tencent.mobileqq.multicard;

import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.av.utils.UITools;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.business.TroopMemRecommendConfBean;
import com.tencent.mobileqq.multicard.manager.TroopMemberRecommendManager;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TroopMemRecommendRclAdapter
  extends RecyclerView.Adapter
{
  public Map<Integer, List<RecommendPerson>> a;
  private QQAppInterface b;
  private MultiCardRecommendFragment c;
  private boolean d;
  
  public TroopMemRecommendRclAdapter(MultiCardRecommendFragment paramMultiCardRecommendFragment, QQAppInterface paramQQAppInterface)
  {
    this.c = paramMultiCardRecommendFragment;
    this.b = paramQQAppInterface;
    this.a = new LinkedHashMap(16, 0.75F, false);
    this.d = ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null);
  }
  
  private void a(TextView paramTextView, String paramString1, String paramString2, int paramInt)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setTextColorAndSize, needStyleText =");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(" totalText =");
      ((StringBuilder)localObject).append(paramString2);
      QLog.d("TroopMemberRecommend.Adapter", 2, ((StringBuilder)localObject).toString());
    }
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2))) {
      try
      {
        int i = paramString2.indexOf(paramString1);
        localObject = new SpannableStringBuilder();
        ((SpannableStringBuilder)localObject).append(paramString2);
        ((SpannableStringBuilder)localObject).setSpan(new ForegroundColorSpan(paramInt), i, paramString1.length() + i, 33);
        paramTextView.setText((CharSequence)localObject);
        return;
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
        paramTextView.setText(paramString2);
        return;
      }
    }
    paramTextView.setText(paramString2);
  }
  
  private int b()
  {
    return this.a.size();
  }
  
  public void a()
  {
    this.a = null;
    this.b = null;
    this.c = null;
  }
  
  public int getItemCount()
  {
    return this.a.size() + 1;
  }
  
  public int getItemViewType(int paramInt)
  {
    Object localObject = this.a;
    int j = 0;
    int i = j;
    if (localObject != null)
    {
      if (((Map)localObject).size() == 0) {
        return 0;
      }
      if (paramInt >= b()) {
        return 1;
      }
      localObject = this.a.keySet().toArray();
      i = j;
      if (localObject[paramInt] != null)
      {
        i = j;
        if ((localObject[paramInt] instanceof Integer)) {
          i = ((Integer)localObject[paramInt]).intValue();
        }
      }
    }
    return i;
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if (!(paramViewHolder instanceof TroopMemRecommendRclAdapter.EmptyViewHolder))
    {
      boolean bool = paramViewHolder instanceof TroopMemRecommendRclAdapter.ActiveViewHolder;
      int k = 0;
      int j = 0;
      Object localObject;
      int i;
      String str1;
      String str2;
      String str3;
      String str4;
      if (bool)
      {
        localObject = (TroopMemRecommendRclAdapter.ActiveViewHolder)paramViewHolder;
        i = j;
        if (((TroopMemRecommendRclAdapter.ActiveViewHolder)localObject).a.size() > 0)
        {
          ((TroopMemRecommendRclAdapter.ActiveViewHolder)localObject).c.setText(((RecommendPerson)((TroopMemRecommendRclAdapter.ActiveViewHolder)localObject).a.get(0)).cardMainTitle);
          i = j;
        }
        while (i < ((TroopMemRecommendRclAdapter.ActiveViewHolder)localObject).b.size())
        {
          try
          {
            TroopMemRecommendRclAdapter.ActiveViewHolder.ActiveSubItemView localActiveSubItemView = (TroopMemRecommendRclAdapter.ActiveViewHolder.ActiveSubItemView)((TroopMemRecommendRclAdapter.ActiveViewHolder)localObject).b.get(i);
            str1 = ((RecommendPerson)((TroopMemRecommendRclAdapter.ActiveViewHolder)localObject).a.get(i)).uin;
            str2 = ((RecommendPerson)((TroopMemRecommendRclAdapter.ActiveViewHolder)localObject).a.get(i)).troopUin;
            str2 = ContactUtils.b(this.b, str2, str1);
            str3 = ((RecommendPerson)((TroopMemRecommendRclAdapter.ActiveViewHolder)localObject).a.get(i)).recommendReason;
            str4 = ((RecommendPerson)((TroopMemRecommendRclAdapter.ActiveViewHolder)localObject).a.get(i)).recommendKeyword;
            localActiveSubItemView.b.setImageBitmap(this.c.a(str1));
            localActiveSubItemView.c.setText(str2);
            a(localActiveSubItemView.d, str4, str3, localActiveSubItemView.c.getCurrentTextColor());
            localActiveSubItemView.a.setTag(2131445060, localObject);
            localActiveSubItemView.a.setTag(2131430064, ((TroopMemRecommendRclAdapter.ActiveViewHolder)localObject).a.get(i));
            localActiveSubItemView.a.setOnTouchListener(UITools.a);
            localActiveSubItemView.a.setOnClickListener((View.OnClickListener)localObject);
            localActiveSubItemView.e.setTag(2131445060, localObject);
            localActiveSubItemView.e.setTag(2131430064, ((TroopMemRecommendRclAdapter.ActiveViewHolder)localObject).a.get(i));
            localActiveSubItemView.e.setOnTouchListener(UITools.a);
            localActiveSubItemView.e.setOnClickListener((View.OnClickListener)localObject);
          }
          catch (NumberFormatException localNumberFormatException1)
          {
            localNumberFormatException1.printStackTrace();
          }
          i += 1;
        }
      }
      if ((paramViewHolder instanceof TroopMemRecommendRclAdapter.CommonViewHolder))
      {
        localObject = (TroopMemRecommendRclAdapter.CommonViewHolder)paramViewHolder;
        i = k;
        if (((TroopMemRecommendRclAdapter.CommonViewHolder)localObject).a.size() > 0)
        {
          ((TroopMemRecommendRclAdapter.CommonViewHolder)localObject).c.setText(((RecommendPerson)((TroopMemRecommendRclAdapter.CommonViewHolder)localObject).a.get(0)).cardMainTitle);
          i = k;
        }
        while (i < ((TroopMemRecommendRclAdapter.CommonViewHolder)localObject).b.size())
        {
          try
          {
            TroopMemRecommendRclAdapter.CommonViewHolder.CommonSubItemView localCommonSubItemView = (TroopMemRecommendRclAdapter.CommonViewHolder.CommonSubItemView)((TroopMemRecommendRclAdapter.CommonViewHolder)localObject).b.get(i);
            str1 = ((RecommendPerson)((TroopMemRecommendRclAdapter.CommonViewHolder)localObject).a.get(i)).uin;
            str2 = ((RecommendPerson)((TroopMemRecommendRclAdapter.CommonViewHolder)localObject).a.get(i)).troopUin;
            str2 = ContactUtils.b(this.b, str2, str1);
            str3 = ((RecommendPerson)((TroopMemRecommendRclAdapter.CommonViewHolder)localObject).a.get(i)).recommendReason;
            str4 = ((RecommendPerson)((TroopMemRecommendRclAdapter.CommonViewHolder)localObject).a.get(i)).recommendKeyword;
            localCommonSubItemView.b.setImageBitmap(this.c.a(str1));
            localCommonSubItemView.c.setText(str2);
            a(localCommonSubItemView.d, str4, str3, localCommonSubItemView.c.getCurrentTextColor());
            localCommonSubItemView.a.setTag(2131445060, localObject);
            localCommonSubItemView.a.setTag(2131430064, ((TroopMemRecommendRclAdapter.CommonViewHolder)localObject).a.get(i));
            localCommonSubItemView.a.setOnTouchListener(UITools.a);
            localCommonSubItemView.a.setOnClickListener((View.OnClickListener)localObject);
            localCommonSubItemView.e.setTag(2131445060, localObject);
            localCommonSubItemView.e.setTag(2131430064, ((TroopMemRecommendRclAdapter.CommonViewHolder)localObject).a.get(i));
            localCommonSubItemView.e.setOnTouchListener(UITools.a);
            localCommonSubItemView.e.setOnClickListener((View.OnClickListener)localObject);
          }
          catch (NumberFormatException localNumberFormatException2)
          {
            localNumberFormatException2.printStackTrace();
          }
          i += 1;
        }
      }
      if ((paramViewHolder instanceof TroopMemRecommendRclAdapter.BottomViewHolder))
      {
        localObject = (TroopMemRecommendRclAdapter.BottomViewHolder)paramViewHolder;
        QQAppInterface localQQAppInterface = this.b;
        if ((localQQAppInterface != null) && (this.c != null) && (TroopMemberRecommendManager.a(localQQAppInterface).a != null)) {
          ((TroopMemRecommendRclAdapter.BottomViewHolder)localObject).a.setText(this.c.getResources().getString(2131917556, new Object[] { Integer.valueOf(TroopMemberRecommendManager.a(this.b).a.b) }));
        }
      }
    }
    EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
  }
  
  @RequiresApi(api=23)
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    Object localObject;
    if (paramInt == 0)
    {
      paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131629595, paramViewGroup, false);
      localObject = new TroopMemRecommendRclAdapter.EmptyViewHolder(this, paramViewGroup);
    }
    else if (paramInt == 1)
    {
      paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131629592, paramViewGroup, false);
      localObject = new TroopMemRecommendRclAdapter.BottomViewHolder(this, paramViewGroup);
    }
    else if (paramInt == 101)
    {
      paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131629590, paramViewGroup, false);
      localObject = new TroopMemRecommendRclAdapter.ActiveViewHolder(this, paramViewGroup, paramInt);
    }
    else
    {
      paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131629593, paramViewGroup, false);
      localObject = new TroopMemRecommendRclAdapter.CommonViewHolder(this, paramViewGroup, paramInt);
    }
    if ((paramViewGroup != null) && (paramViewGroup.getBackground() != null))
    {
      if (this.d)
      {
        paramViewGroup.getBackground().setColorFilter(Color.parseColor("#000000"), PorterDuff.Mode.SRC_ATOP);
        return localObject;
      }
      paramViewGroup.getBackground().clearColorFilter();
    }
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.multicard.TroopMemRecommendRclAdapter
 * JD-Core Version:    0.7.0.1
 */