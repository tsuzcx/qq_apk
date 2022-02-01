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
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private MultiCardRecommendFragment jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRecommendFragment;
  public Map<Integer, List<RecommendPerson>> a;
  private boolean jdField_a_of_type_Boolean;
  
  public TroopMemRecommendRclAdapter(MultiCardRecommendFragment paramMultiCardRecommendFragment, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRecommendFragment = paramMultiCardRecommendFragment;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaUtilMap = new LinkedHashMap(16, 0.75F, false);
    this.jdField_a_of_type_Boolean = ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null);
  }
  
  private int a()
  {
    return this.jdField_a_of_type_JavaUtilMap.size();
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
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilMap = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRecommendFragment = null;
  }
  
  public int getItemCount()
  {
    return this.jdField_a_of_type_JavaUtilMap.size() + 1;
  }
  
  public int getItemViewType(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_JavaUtilMap;
    int j = 0;
    int i = j;
    if (localObject != null)
    {
      if (((Map)localObject).size() == 0) {
        return 0;
      }
      if (paramInt >= a()) {
        return 1;
      }
      localObject = this.jdField_a_of_type_JavaUtilMap.keySet().toArray();
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
        if (((TroopMemRecommendRclAdapter.ActiveViewHolder)localObject).jdField_a_of_type_JavaUtilList.size() > 0)
        {
          ((TroopMemRecommendRclAdapter.ActiveViewHolder)localObject).jdField_a_of_type_AndroidWidgetTextView.setText(((RecommendPerson)((TroopMemRecommendRclAdapter.ActiveViewHolder)localObject).jdField_a_of_type_JavaUtilList.get(0)).cardMainTitle);
          i = j;
        }
        while (i < ((TroopMemRecommendRclAdapter.ActiveViewHolder)localObject).b.size())
        {
          try
          {
            TroopMemRecommendRclAdapter.ActiveViewHolder.ActiveSubItemView localActiveSubItemView = (TroopMemRecommendRclAdapter.ActiveViewHolder.ActiveSubItemView)((TroopMemRecommendRclAdapter.ActiveViewHolder)localObject).b.get(i);
            str1 = ((RecommendPerson)((TroopMemRecommendRclAdapter.ActiveViewHolder)localObject).jdField_a_of_type_JavaUtilList.get(i)).uin;
            str2 = ((RecommendPerson)((TroopMemRecommendRclAdapter.ActiveViewHolder)localObject).jdField_a_of_type_JavaUtilList.get(i)).troopUin;
            str2 = ContactUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str2, str1);
            str3 = ((RecommendPerson)((TroopMemRecommendRclAdapter.ActiveViewHolder)localObject).jdField_a_of_type_JavaUtilList.get(i)).recommendReason;
            str4 = ((RecommendPerson)((TroopMemRecommendRclAdapter.ActiveViewHolder)localObject).jdField_a_of_type_JavaUtilList.get(i)).recommendKeyword;
            localActiveSubItemView.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRecommendFragment.a(str1));
            localActiveSubItemView.jdField_a_of_type_AndroidWidgetTextView.setText(str2);
            a(localActiveSubItemView.b, str4, str3, localActiveSubItemView.jdField_a_of_type_AndroidWidgetTextView.getCurrentTextColor());
            localActiveSubItemView.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(2131376767, localObject);
            localActiveSubItemView.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(2131364098, ((TroopMemRecommendRclAdapter.ActiveViewHolder)localObject).jdField_a_of_type_JavaUtilList.get(i));
            localActiveSubItemView.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnTouchListener(UITools.a);
            localActiveSubItemView.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener((View.OnClickListener)localObject);
            localActiveSubItemView.jdField_a_of_type_AndroidWidgetButton.setTag(2131376767, localObject);
            localActiveSubItemView.jdField_a_of_type_AndroidWidgetButton.setTag(2131364098, ((TroopMemRecommendRclAdapter.ActiveViewHolder)localObject).jdField_a_of_type_JavaUtilList.get(i));
            localActiveSubItemView.jdField_a_of_type_AndroidWidgetButton.setOnTouchListener(UITools.a);
            localActiveSubItemView.jdField_a_of_type_AndroidWidgetButton.setOnClickListener((View.OnClickListener)localObject);
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
        if (((TroopMemRecommendRclAdapter.CommonViewHolder)localObject).jdField_a_of_type_JavaUtilList.size() > 0)
        {
          ((TroopMemRecommendRclAdapter.CommonViewHolder)localObject).jdField_a_of_type_AndroidWidgetTextView.setText(((RecommendPerson)((TroopMemRecommendRclAdapter.CommonViewHolder)localObject).jdField_a_of_type_JavaUtilList.get(0)).cardMainTitle);
          i = k;
        }
        while (i < ((TroopMemRecommendRclAdapter.CommonViewHolder)localObject).b.size())
        {
          try
          {
            TroopMemRecommendRclAdapter.CommonViewHolder.CommonSubItemView localCommonSubItemView = (TroopMemRecommendRclAdapter.CommonViewHolder.CommonSubItemView)((TroopMemRecommendRclAdapter.CommonViewHolder)localObject).b.get(i);
            str1 = ((RecommendPerson)((TroopMemRecommendRclAdapter.CommonViewHolder)localObject).jdField_a_of_type_JavaUtilList.get(i)).uin;
            str2 = ((RecommendPerson)((TroopMemRecommendRclAdapter.CommonViewHolder)localObject).jdField_a_of_type_JavaUtilList.get(i)).troopUin;
            str2 = ContactUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str2, str1);
            str3 = ((RecommendPerson)((TroopMemRecommendRclAdapter.CommonViewHolder)localObject).jdField_a_of_type_JavaUtilList.get(i)).recommendReason;
            str4 = ((RecommendPerson)((TroopMemRecommendRclAdapter.CommonViewHolder)localObject).jdField_a_of_type_JavaUtilList.get(i)).recommendKeyword;
            localCommonSubItemView.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRecommendFragment.a(str1));
            localCommonSubItemView.jdField_a_of_type_AndroidWidgetTextView.setText(str2);
            a(localCommonSubItemView.b, str4, str3, localCommonSubItemView.jdField_a_of_type_AndroidWidgetTextView.getCurrentTextColor());
            localCommonSubItemView.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(2131376767, localObject);
            localCommonSubItemView.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(2131364098, ((TroopMemRecommendRclAdapter.CommonViewHolder)localObject).jdField_a_of_type_JavaUtilList.get(i));
            localCommonSubItemView.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnTouchListener(UITools.a);
            localCommonSubItemView.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener((View.OnClickListener)localObject);
            localCommonSubItemView.jdField_a_of_type_AndroidWidgetButton.setTag(2131376767, localObject);
            localCommonSubItemView.jdField_a_of_type_AndroidWidgetButton.setTag(2131364098, ((TroopMemRecommendRclAdapter.CommonViewHolder)localObject).jdField_a_of_type_JavaUtilList.get(i));
            localCommonSubItemView.jdField_a_of_type_AndroidWidgetButton.setOnTouchListener(UITools.a);
            localCommonSubItemView.jdField_a_of_type_AndroidWidgetButton.setOnClickListener((View.OnClickListener)localObject);
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
        QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        if ((localQQAppInterface != null) && (this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRecommendFragment != null) && (TroopMemberRecommendManager.a(localQQAppInterface).a != null)) {
          ((TroopMemRecommendRclAdapter.BottomViewHolder)localObject).jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRecommendFragment.getResources().getString(2131719951, new Object[] { Integer.valueOf(TroopMemberRecommendManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a.b) }));
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
      paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131562987, paramViewGroup, false);
      localObject = new TroopMemRecommendRclAdapter.EmptyViewHolder(this, paramViewGroup);
    }
    else if (paramInt == 1)
    {
      paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131562984, paramViewGroup, false);
      localObject = new TroopMemRecommendRclAdapter.BottomViewHolder(this, paramViewGroup);
    }
    else if (paramInt == 101)
    {
      paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131562982, paramViewGroup, false);
      localObject = new TroopMemRecommendRclAdapter.ActiveViewHolder(this, paramViewGroup, paramInt);
    }
    else
    {
      paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131562985, paramViewGroup, false);
      localObject = new TroopMemRecommendRclAdapter.CommonViewHolder(this, paramViewGroup, paramInt);
    }
    if ((paramViewGroup != null) && (paramViewGroup.getBackground() != null))
    {
      if (this.jdField_a_of_type_Boolean)
      {
        paramViewGroup.getBackground().setColorFilter(Color.parseColor("#000000"), PorterDuff.Mode.SRC_ATOP);
        return localObject;
      }
      paramViewGroup.getBackground().clearColorFilter();
    }
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.multicard.TroopMemRecommendRclAdapter
 * JD-Core Version:    0.7.0.1
 */