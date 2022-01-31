package com.tencent.qqmini.sdk.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import bhmj;
import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.qqmini.sdk.utils.DisplayUtil;
import java.util.Iterator;
import java.util.List;

public class MoreFragment
  extends MiniBaseFragment
  implements Handler.Callback, View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private View jdField_a_of_type_AndroidViewView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private String jdField_a_of_type_JavaLangString;
  private List<MoreItem> jdField_a_of_type_JavaUtilList;
  private int b;
  
  private Intent a()
  {
    if (getActivity() != null) {
      return getActivity().getIntent();
    }
    return null;
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout == null) {
      return;
    }
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 1.0F, 1, 0.0F);
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    AnimationSet localAnimationSet = new AnimationSet(true);
    localAnimationSet.addAnimation(localTranslateAnimation);
    localAnimationSet.addAnimation(localAlphaAnimation);
    localAnimationSet.setInterpolator(new DecelerateInterpolator());
    localAnimationSet.setDuration(200L);
    localAnimationSet.setFillAfter(true);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.startAnimation(localAnimationSet);
  }
  
  private void a(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout == null) {
      return;
    }
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 0.0F, 1, 1.0F);
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    AnimationSet localAnimationSet = new AnimationSet(true);
    localAnimationSet.addAnimation(localTranslateAnimation);
    localAnimationSet.addAnimation(localAlphaAnimation);
    localAnimationSet.setInterpolator(new DecelerateInterpolator());
    localAnimationSet.setDuration(200L);
    localAnimationSet.setFillAfter(true);
    localAnimationSet.setAnimationListener(new bhmj(this, paramInt, paramBoolean, paramBundle));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.startAnimation(localAnimationSet);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    return false;
  }
  
  public void onClick(View paramView)
  {
    boolean bool2 = false;
    int j = -1;
    int i;
    boolean bool1;
    if (paramView == this.jdField_a_of_type_AndroidViewView)
    {
      i = 0;
      bool1 = bool2;
    }
    for (;;)
    {
      a(i, bool1, null);
      return;
      bool1 = bool2;
      i = j;
      if (paramView != this.jdField_a_of_type_AndroidWidgetTextView)
      {
        bool1 = bool2;
        i = j;
        if ((paramView instanceof MoreItemView))
        {
          paramView = ((MoreItemView)paramView).a();
          i = paramView.jdField_a_of_type_Int;
          bool1 = paramView.b;
        }
      }
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.jdField_a_of_type_Int = getActivity().getResources().getDisplayMetrics().heightPixels;
    this.b = DisplayUtil.getStatusBarHeight(getActivity());
    paramLayoutInflater = paramLayoutInflater.inflate(2131559353, paramViewGroup, false);
    if (paramLayoutInflater == null)
    {
      getActivity().finish();
      return null;
    }
    this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.findViewById(2131362208);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131370618));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    paramLayoutInflater.setOnClickListener(this);
    paramViewGroup = a();
    if (paramViewGroup == null)
    {
      QMLog.w("MoreFragment", "Failed to create MoreFragment, intent is null");
      if (getActivity() != null) {
        getActivity().finish();
      }
      return null;
    }
    if (paramViewGroup.getBooleanExtra("key_orientation_landscape", false)) {
      getActivity().findViewById(16908290).setBackgroundResource(2130840923);
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramLayoutInflater.findViewById(2131370744));
    this.jdField_a_of_type_JavaUtilList = paramViewGroup.getParcelableArrayListExtra("key_more_item_list");
    if (this.jdField_a_of_type_JavaUtilList == null)
    {
      QMLog.e("MoreFragment", "Failed to create MoreFragmentView. no items");
      getActivity().finish();
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramLayoutInflater);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      a();
      return paramLayoutInflater;
      paramViewGroup = this.jdField_a_of_type_JavaUtilList.iterator();
      while (paramViewGroup.hasNext())
      {
        paramBundle = (MoreItem)paramViewGroup.next();
        MoreItemView localMoreItemView = new MoreItemView(getActivity());
        localMoreItemView.a(paramBundle);
        localMoreItemView.setOnClickListener(this);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localMoreItemView);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.ui.MoreFragment
 * JD-Core Version:    0.7.0.1
 */