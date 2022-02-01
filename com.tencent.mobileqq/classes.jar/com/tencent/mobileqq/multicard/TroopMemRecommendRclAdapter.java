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
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.ContactUtils;
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
    if (QLog.isColorLevel()) {
      QLog.d("TroopMemberRecommend.Adapter", 2, "setTextColorAndSize, needStyleText =" + paramString1 + " totalText =" + paramString2);
    }
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      paramTextView.setText(paramString2);
      return;
    }
    try
    {
      int i = paramString2.indexOf(paramString1);
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
      localSpannableStringBuilder.append(paramString2);
      localSpannableStringBuilder.setSpan(new ForegroundColorSpan(paramInt), i, paramString1.length() + i, 33);
      paramTextView.setText(localSpannableStringBuilder);
      return;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
      paramTextView.setText(paramString2);
    }
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
    if ((this.jdField_a_of_type_JavaUtilMap == null) || (this.jdField_a_of_type_JavaUtilMap.size() == 0)) {}
    Object[] arrayOfObject;
    do
    {
      return 0;
      if (paramInt >= a()) {
        return 1;
      }
      arrayOfObject = this.jdField_a_of_type_JavaUtilMap.keySet().toArray();
    } while ((arrayOfObject[paramInt] == null) || (!(arrayOfObject[paramInt] instanceof Integer)));
    return ((Integer)arrayOfObject[paramInt]).intValue();
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if ((paramViewHolder instanceof TroopMemRecommendRclAdapter.EmptyViewHolder)) {}
    for (;;)
    {
      EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
      return;
      Object localObject;
      int i;
      String str1;
      String str2;
      String str3;
      String str4;
      if ((paramViewHolder instanceof TroopMemRecommendRclAdapter.ActiveViewHolder))
      {
        localObject = (TroopMemRecommendRclAdapter.ActiveViewHolder)paramViewHolder;
        if (((TroopMemRecommendRclAdapter.ActiveViewHolder)localObject).jdField_a_of_type_JavaUtilList.size() > 0) {
          ((TroopMemRecommendRclAdapter.ActiveViewHolder)localObject).jdField_a_of_type_AndroidWidgetTextView.setText(((RecommendPerson)((TroopMemRecommendRclAdapter.ActiveViewHolder)localObject).jdField_a_of_type_JavaUtilList.get(0)).cardMainTitle);
        }
        i = 0;
        while (i < ((TroopMemRecommendRclAdapter.ActiveViewHolder)localObject).b.size()) {
          try
          {
            TroopMemRecommendRclAdapter.ActiveViewHolder.ActiveSubItemView localActiveSubItemView = (TroopMemRecommendRclAdapter.ActiveViewHolder.ActiveSubItemView)((TroopMemRecommendRclAdapter.ActiveViewHolder)localObject).b.get(i);
            str1 = ((RecommendPerson)((TroopMemRecommendRclAdapter.ActiveViewHolder)localObject).jdField_a_of_type_JavaUtilList.get(i)).uin;
            str2 = ((RecommendPerson)((TroopMemRecommendRclAdapter.ActiveViewHolder)localObject).jdField_a_of_type_JavaUtilList.get(i)).troopUin;
            str2 = ContactUtils.g(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str2, str1);
            str3 = ((RecommendPerson)((TroopMemRecommendRclAdapter.ActiveViewHolder)localObject).jdField_a_of_type_JavaUtilList.get(i)).recommendReason;
            str4 = ((RecommendPerson)((TroopMemRecommendRclAdapter.ActiveViewHolder)localObject).jdField_a_of_type_JavaUtilList.get(i)).recommendKeyword;
            localActiveSubItemView.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRecommendFragment.a(str1));
            localActiveSubItemView.jdField_a_of_type_AndroidWidgetTextView.setText(str2);
            a(localActiveSubItemView.b, str4, str3, localActiveSubItemView.jdField_a_of_type_AndroidWidgetTextView.getCurrentTextColor());
            localActiveSubItemView.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(2131377313, localObject);
            localActiveSubItemView.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(2131364179, ((TroopMemRecommendRclAdapter.ActiveViewHolder)localObject).jdField_a_of_type_JavaUtilList.get(i));
            localActiveSubItemView.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnTouchListener(UITools.a);
            localActiveSubItemView.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener((View.OnClickListener)localObject);
            localActiveSubItemView.jdField_a_of_type_AndroidWidgetButton.setTag(2131377313, localObject);
            localActiveSubItemView.jdField_a_of_type_AndroidWidgetButton.setTag(2131364179, ((TroopMemRecommendRclAdapter.ActiveViewHolder)localObject).jdField_a_of_type_JavaUtilList.get(i));
            localActiveSubItemView.jdField_a_of_type_AndroidWidgetButton.setOnTouchListener(UITools.a);
            localActiveSubItemView.jdField_a_of_type_AndroidWidgetButton.setOnClickListener((View.OnClickListener)localObject);
            i += 1;
          }
          catch (NumberFormatException localNumberFormatException1)
          {
            for (;;)
            {
              localNumberFormatException1.printStackTrace();
            }
          }
        }
      }
      if ((paramViewHolder instanceof TroopMemRecommendRclAdapter.CommonViewHolder))
      {
        localObject = (TroopMemRecommendRclAdapter.CommonViewHolder)paramViewHolder;
        if (((TroopMemRecommendRclAdapter.CommonViewHolder)localObject).jdField_a_of_type_JavaUtilList.size() > 0) {
          ((TroopMemRecommendRclAdapter.CommonViewHolder)localObject).jdField_a_of_type_AndroidWidgetTextView.setText(((RecommendPerson)((TroopMemRecommendRclAdapter.CommonViewHolder)localObject).jdField_a_of_type_JavaUtilList.get(0)).cardMainTitle);
        }
        i = 0;
        while (i < ((TroopMemRecommendRclAdapter.CommonViewHolder)localObject).b.size()) {
          try
          {
            TroopMemRecommendRclAdapter.CommonViewHolder.CommonSubItemView localCommonSubItemView = (TroopMemRecommendRclAdapter.CommonViewHolder.CommonSubItemView)((TroopMemRecommendRclAdapter.CommonViewHolder)localObject).b.get(i);
            str1 = ((RecommendPerson)((TroopMemRecommendRclAdapter.CommonViewHolder)localObject).jdField_a_of_type_JavaUtilList.get(i)).uin;
            str2 = ((RecommendPerson)((TroopMemRecommendRclAdapter.CommonViewHolder)localObject).jdField_a_of_type_JavaUtilList.get(i)).troopUin;
            str2 = ContactUtils.g(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str2, str1);
            str3 = ((RecommendPerson)((TroopMemRecommendRclAdapter.CommonViewHolder)localObject).jdField_a_of_type_JavaUtilList.get(i)).recommendReason;
            str4 = ((RecommendPerson)((TroopMemRecommendRclAdapter.CommonViewHolder)localObject).jdField_a_of_type_JavaUtilList.get(i)).recommendKeyword;
            localCommonSubItemView.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRecommendFragment.a(str1));
            localCommonSubItemView.jdField_a_of_type_AndroidWidgetTextView.setText(str2);
            a(localCommonSubItemView.b, str4, str3, localCommonSubItemView.jdField_a_of_type_AndroidWidgetTextView.getCurrentTextColor());
            localCommonSubItemView.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(2131377313, localObject);
            localCommonSubItemView.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(2131364179, ((TroopMemRecommendRclAdapter.CommonViewHolder)localObject).jdField_a_of_type_JavaUtilList.get(i));
            localCommonSubItemView.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnTouchListener(UITools.a);
            localCommonSubItemView.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener((View.OnClickListener)localObject);
            localCommonSubItemView.jdField_a_of_type_AndroidWidgetButton.setTag(2131377313, localObject);
            localCommonSubItemView.jdField_a_of_type_AndroidWidgetButton.setTag(2131364179, ((TroopMemRecommendRclAdapter.CommonViewHolder)localObject).jdField_a_of_type_JavaUtilList.get(i));
            localCommonSubItemView.jdField_a_of_type_AndroidWidgetButton.setOnTouchListener(UITools.a);
            localCommonSubItemView.jdField_a_of_type_AndroidWidgetButton.setOnClickListener((View.OnClickListener)localObject);
            i += 1;
          }
          catch (NumberFormatException localNumberFormatException2)
          {
            for (;;)
            {
              localNumberFormatException2.printStackTrace();
            }
          }
        }
      }
      if ((paramViewHolder instanceof TroopMemRecommendRclAdapter.BottomViewHolder))
      {
        localObject = (TroopMemRecommendRclAdapter.BottomViewHolder)paramViewHolder;
        if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRecommendFragment != null) && (TroopMemberRecommendManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a != null)) {
          ((TroopMemRecommendRclAdapter.BottomViewHolder)localObject).jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRecommendFragment.getResources().getString(2131720218, new Object[] { Integer.valueOf(TroopMemberRecommendManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a.b) }));
        }
      }
    }
  }
  
  @RequiresApi(api=23)
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    View localView;
    if (paramInt == 0)
    {
      localView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131563164, paramViewGroup, false);
      paramViewGroup = new TroopMemRecommendRclAdapter.EmptyViewHolder(this, localView);
    }
    for (;;)
    {
      if ((localView != null) && (localView.getBackground() != null))
      {
        if (!this.jdField_a_of_type_Boolean) {
          break;
        }
        localView.getBackground().setColorFilter(Color.parseColor("#000000"), PorterDuff.Mode.SRC_ATOP);
      }
      return paramViewGroup;
      if (paramInt == 1)
      {
        localView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131563161, paramViewGroup, false);
        paramViewGroup = new TroopMemRecommendRclAdapter.BottomViewHolder(this, localView);
      }
      else if (paramInt == 101)
      {
        localView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131563159, paramViewGroup, false);
        paramViewGroup = new TroopMemRecommendRclAdapter.ActiveViewHolder(this, localView, paramInt);
      }
      else
      {
        localView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131563162, paramViewGroup, false);
        paramViewGroup = new TroopMemRecommendRclAdapter.CommonViewHolder(this, localView, paramInt);
      }
    }
    localView.getBackground().clearColorFilter();
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.multicard.TroopMemRecommendRclAdapter
 * JD-Core Version:    0.7.0.1
 */