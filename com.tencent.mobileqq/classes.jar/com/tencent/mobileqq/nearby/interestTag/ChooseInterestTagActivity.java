package com.tencent.mobileqq.nearby.interestTag;

import android.annotation.TargetApi;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.AbsListView.OnScrollListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.nearby.business.NearbyCardHandler;
import com.tencent.mobileqq.nearby.business.NearbyCardObserver;
import com.tencent.mobileqq.nearby.profilecard.LabelEditCtrl;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.NearbyImgDownloader;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.widget.MonitorSizeChangeHSV;
import com.tencent.mobileqq.widget.MonitorSizeChangeHSV.IOnSizeChangeCallback;
import com.tencent.mobileqq.widget.QQProgressNotifier;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.InputMethodUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import mqq.os.MqqHandler;

public class ChooseInterestTagActivity
  extends IphoneTitleBarActivity
{
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "#77C6F4", "#FFA366", "#333333", "#5DC2A2" };
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int = 0;
  private Handler jdField_a_of_type_AndroidOsHandler = new ChooseInterestTagActivity.5(this);
  private TextWatcher jdField_a_of_type_AndroidTextTextWatcher = new ChooseInterestTagActivity.13(this);
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new ChooseInterestTagActivity.10(this);
  private View.OnKeyListener jdField_a_of_type_AndroidViewView$OnKeyListener = new ChooseInterestTagActivity.8(this);
  private View jdField_a_of_type_AndroidViewView;
  private AbsListView.OnScrollListener jdField_a_of_type_AndroidWidgetAbsListView$OnScrollListener = new ChooseInterestTagActivity.7(this);
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private ListView jdField_a_of_type_AndroidWidgetListView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private NearbyCardHandler jdField_a_of_type_ComTencentMobileqqNearbyBusinessNearbyCardHandler;
  private NearbyCardObserver jdField_a_of_type_ComTencentMobileqqNearbyBusinessNearbyCardObserver = new ChooseInterestTagActivity.6(this);
  private InterestTagAdapter jdField_a_of_type_ComTencentMobileqqNearbyInterestTagInterestTagAdapter;
  private InterestTagItemView.IInterestTagItemViewCallback jdField_a_of_type_ComTencentMobileqqNearbyInterestTagInterestTagItemView$IInterestTagItemViewCallback = new ChooseInterestTagActivity.14(this);
  private ShowTagNamePopupWindow.IShowTagNamePopupWindowCallback jdField_a_of_type_ComTencentMobileqqNearbyInterestTagShowTagNamePopupWindow$IShowTagNamePopupWindowCallback = new ChooseInterestTagActivity.12(this);
  private MonitorSizeChangeHSV.IOnSizeChangeCallback jdField_a_of_type_ComTencentMobileqqWidgetMonitorSizeChangeHSV$IOnSizeChangeCallback = new ChooseInterestTagActivity.9(this);
  private MonitorSizeChangeHSV jdField_a_of_type_ComTencentMobileqqWidgetMonitorSizeChangeHSV;
  private QQProgressNotifier jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier;
  private String jdField_a_of_type_JavaLangString = "";
  private ArrayList<InterestTagInfo> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private List<InterestTagInfo> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int = 0;
  private View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener = new ChooseInterestTagActivity.11(this);
  private View jdField_b_of_type_AndroidViewView;
  private LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private List<InterestTagInfo> jdField_b_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_b_of_type_Boolean = false;
  private int jdField_c_of_type_Int = -1;
  private View jdField_c_of_type_AndroidViewView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private boolean jdField_c_of_type_Boolean = false;
  private int jdField_d_of_type_Int = 0;
  private View jdField_d_of_type_AndroidViewView;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private boolean jdField_d_of_type_Boolean = false;
  private int jdField_e_of_type_Int;
  private TextView jdField_e_of_type_AndroidWidgetTextView;
  private boolean jdField_e_of_type_Boolean = false;
  private int jdField_f_of_type_Int;
  private boolean jdField_f_of_type_Boolean = false;
  
  private View a(InterestTagInfo paramInterestTagInfo, boolean paramBoolean)
  {
    Object localObject4;
    TextView localTextView;
    Object localObject1;
    Object localObject3;
    int i;
    if ((this.jdField_c_of_type_Boolean) || (this.jdField_c_of_type_Int == 3) || (this.jdField_c_of_type_Int == 2) || (this.jdField_c_of_type_Int == 1) || (this.jdField_c_of_type_Int == 4))
    {
      localObject4 = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561390, null);
      localTextView = (TextView)((View)localObject4).findViewById(2131380726);
      if (localTextView != null)
      {
        if (paramInterestTagInfo.tagName != null) {
          break label301;
        }
        localObject1 = "";
        localObject3 = localObject1;
        if (((String)localObject1).length() > 6) {
          localObject3 = ((String)localObject1).substring(0, 6) + "...";
        }
        localTextView.setSingleLine(true);
        localTextView.setText((CharSequence)localObject3);
        if (!this.jdField_c_of_type_Boolean) {
          break label313;
        }
        i = LabelEditCtrl.a(this.jdField_c_of_type_Int);
        if (i == -1) {
          break label805;
        }
        i = Color.parseColor(LabelEditCtrl.b[i]);
      }
    }
    for (;;)
    {
      label163:
      localTextView.setTextColor(i);
      if (this.jdField_c_of_type_Boolean)
      {
        i = LabelEditCtrl.a(this.jdField_c_of_type_Int);
        if (i == -1) {
          break label800;
        }
        i = Color.parseColor(LabelEditCtrl.jdField_a_of_type_ArrayOfJavaLangString[i]);
      }
      for (;;)
      {
        label198:
        localObject1 = new GradientDrawable();
        ((GradientDrawable)localObject1).setColor(i);
        ((GradientDrawable)localObject1).setCornerRadius(getResources().getDimensionPixelSize(2131298933));
        ((View)localObject4).setBackgroundDrawable((Drawable)localObject1);
        ((View)localObject4).setTag(paramInterestTagInfo);
        paramInterestTagInfo = new LinearLayout.LayoutParams(-2, (int)DisplayUtils.a(this, 17.0F));
        if (paramBoolean) {}
        label301:
        label313:
        int j;
        for (i = 10;; i = 5)
        {
          for (;;)
          {
            for (;;)
            {
              paramInterestTagInfo.leftMargin = ((int)(i * this.jdField_a_of_type_Float + 0.5D));
              ((View)localObject4).setLayoutParams(paramInterestTagInfo);
              ((View)localObject4).setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
              return localObject4;
              localObject1 = paramInterestTagInfo.tagName.trim();
              break;
              try
              {
                i = Color.parseColor(paramInterestTagInfo.tagTextColor);
              }
              catch (Exception localException1)
              {
                if (QLog.isDevelopLevel()) {
                  localException1.printStackTrace();
                }
                i = -1;
              }
            }
            break label163;
            j = Color.parseColor(jdField_a_of_type_ArrayOfJavaLangString[(this.jdField_c_of_type_Int - 1)]);
            try
            {
              i = Color.parseColor(paramInterestTagInfo.tagBgColor);
            }
            catch (Exception localException2)
            {
              i = j;
            }
          }
          if (!QLog.isDevelopLevel()) {
            break label198;
          }
          QLog.d("choose_interest_tag", 4, "parse tagBgClor: " + localException2.getMessage());
          i = j;
          break label198;
        }
        localObject4 = new URLImageView(this);
        Object localObject2 = new LinearLayout.LayoutParams((int)(this.jdField_a_of_type_Float * 40.0F + 0.5D), this.jdField_f_of_type_Int);
        ((LinearLayout.LayoutParams)localObject2).leftMargin = ((int)(this.jdField_a_of_type_Float * 10.0F + 0.5D));
        ((ImageView)localObject4).setLayoutParams((ViewGroup.LayoutParams)localObject2);
        ((ImageView)localObject4).setTag(paramInterestTagInfo);
        ((ImageView)localObject4).setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
        ((ImageView)localObject4).setScaleType(ImageView.ScaleType.CENTER_CROP);
        if (this.jdField_c_of_type_Int == 7)
        {
          localObject2 = new GradientDrawable();
          ((GradientDrawable)localObject2).setColor(getResources().getColor(2131165883));
          ((GradientDrawable)localObject2).setCornerRadius(this.jdField_a_of_type_Float * 10.0F);
          ((GradientDrawable)localObject2).setShape(0);
          i = getResources().getDimensionPixelSize(2131297473);
          ((GradientDrawable)localObject2).setSize(i, i);
          if (TextUtils.isEmpty(paramInterestTagInfo.tagIconUrl)) {
            break label795;
          }
        }
        for (;;)
        {
          try
          {
            localObject3 = URLDrawable.URLDrawableOptions.obtain();
            if (this.jdField_c_of_type_Int == 5)
            {
              i = getResources().getDimensionPixelSize(2131297475);
              ((URLDrawable.URLDrawableOptions)localObject3).mRequestHeight = i;
              j = getResources().getDimensionPixelSize(2131297474);
              ((URLDrawable.URLDrawableOptions)localObject3).mRequestWidth = j;
              ((URLDrawable.URLDrawableOptions)localObject3).mFailedDrawable = ((Drawable)localObject2);
              ((URLDrawable.URLDrawableOptions)localObject3).mLoadingDrawable = ((Drawable)localObject2);
              paramInterestTagInfo = URLDrawable.getDrawable(NearbyImgDownloader.convertURL(paramInterestTagInfo.tagIconUrl), (URLDrawable.URLDrawableOptions)localObject3);
            }
          }
          catch (Exception localException3)
          {
            paramInterestTagInfo = null;
          }
          try
          {
            if (this.jdField_c_of_type_Int == 7)
            {
              paramInterestTagInfo.setTag(URLDrawableDecodeHandler.b(j, i, (int)(this.jdField_a_of_type_Float * 10.0F)));
              paramInterestTagInfo.setDecodeHandler(URLDrawableDecodeHandler.c);
            }
            ((URLDrawable.URLDrawableOptions)localObject3).mFailedDrawable = null;
            ((URLDrawable.URLDrawableOptions)localObject3).mLoadingDrawable = null;
            if (paramInterestTagInfo != null) {
              break label784;
            }
            ((ImageView)localObject4).setImageDrawable((Drawable)localObject2);
            return localObject4;
          }
          catch (Exception localException4)
          {
            break label763;
          }
          localObject2 = getResources().getDrawable(2131165883);
          break;
          i = getResources().getDimensionPixelSize(2131297473);
          ((URLDrawable.URLDrawableOptions)localObject3).mRequestHeight = i;
          continue;
          label763:
          if (QLog.isColorLevel()) {
            QLog.i("choose_interest_tag", 2, localException3.toString());
          }
          continue;
          label784:
          localObject2 = paramInterestTagInfo;
          continue;
          label795:
          paramInterestTagInfo = null;
        }
        label800:
        i = 0;
      }
      label805:
      i = -1;
    }
  }
  
  private void a()
  {
    String str2 = "";
    String str1 = "";
    String str3 = HardCodeUtil.a(2131701852);
    if (this.jdField_c_of_type_Int == 3)
    {
      str2 = HardCodeUtil.a(2131701862);
      str1 = HardCodeUtil.a(2131701890);
      this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_d_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetEditText.setHint(str3);
      if (!this.jdField_b_of_type_Boolean) {
        break label399;
      }
    }
    for (;;)
    {
      setTitle(str1);
      if (!this.jdField_b_of_type_Boolean) {
        break label404;
      }
      setLeftViewName(2131690800);
      this.leftView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.rightViewImg.setVisibility(8);
      this.rightViewText.setVisibility(0);
      this.rightViewText.setText(HardCodeUtil.a(2131701874));
      this.rightViewText.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      return;
      if (this.jdField_c_of_type_Int == 5)
      {
        str2 = HardCodeUtil.a(2131701853);
        str1 = HardCodeUtil.a(2131701861);
        this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_d_of_type_AndroidViewView.setVisibility(0);
        break;
      }
      if (this.jdField_c_of_type_Int == 6)
      {
        str2 = HardCodeUtil.a(2131701885);
        str1 = HardCodeUtil.a(2131701879);
        this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_d_of_type_AndroidViewView.setVisibility(0);
        break;
      }
      if (this.jdField_c_of_type_Int == 2)
      {
        str2 = HardCodeUtil.a(2131701858);
        str1 = HardCodeUtil.a(2131701882);
        this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_d_of_type_AndroidViewView.setVisibility(8);
        break;
      }
      if (this.jdField_c_of_type_Int == 7)
      {
        str2 = HardCodeUtil.a(2131701857);
        str1 = HardCodeUtil.a(2131701883);
        this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_d_of_type_AndroidViewView.setVisibility(0);
        break;
      }
      if (this.jdField_c_of_type_Int == 4)
      {
        str1 = HardCodeUtil.a(2131701891);
        str2 = HardCodeUtil.a(2131701863);
        this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_d_of_type_AndroidViewView.setVisibility(8);
        break;
      }
      if (this.jdField_c_of_type_Int != 1) {
        break;
      }
      str2 = HardCodeUtil.a(2131701860);
      str1 = HardCodeUtil.a(2131701869);
      this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_d_of_type_AndroidViewView.setVisibility(0);
      str3 = HardCodeUtil.a(2131701854);
      break;
      label399:
      str1 = str2;
    }
    label404:
    setLeftViewName(2131690601);
    this.leftView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.rightViewImg.setVisibility(8);
    this.rightViewText.setVisibility(8);
  }
  
  @TargetApi(11)
  private void a(int paramInt)
  {
    Object localObject;
    if ((this.jdField_d_of_type_Int == 1) && (paramInt == 0))
    {
      if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount() > 0)
      {
        localObject = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount() - 1);
        if (Build.VERSION.SDK_INT >= 11) {
          ((View)localObject).setAlpha(1.0F);
        }
      }
      this.jdField_d_of_type_Int = 0;
    }
    do
    {
      return;
      if ((this.jdField_d_of_type_Int == 0) && (paramInt == 1))
      {
        if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount() > 0)
        {
          localObject = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount() - 1);
          if (Build.VERSION.SDK_INT >= 11) {
            ((View)localObject).setAlpha(0.5F);
          }
        }
        this.jdField_d_of_type_Int = 1;
        return;
      }
    } while (paramInt != 2);
    if ((this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount() > 0) && (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty()))
    {
      localObject = (InterestTagInfo)this.jdField_a_of_type_JavaUtilArrayList.remove(this.jdField_a_of_type_JavaUtilArrayList.size() - 1);
      b((InterestTagInfo)localObject);
      c((InterestTagInfo)localObject);
    }
    this.jdField_d_of_type_Int = 0;
  }
  
  private void a(int paramInt1, String paramString, int paramInt2)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier != null) && (!isFinishing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.a(paramInt1, paramString, paramInt2);
    }
  }
  
  private void a(InterestTagInfo paramInterestTagInfo)
  {
    Object localObject;
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetMonitorSizeChangeHSV.getVisibility() != 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetMonitorSizeChangeHSV.setVisibility(0);
      if (this.jdField_a_of_type_Boolean)
      {
        localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqWidgetMonitorSizeChangeHSV.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject).height = this.jdField_f_of_type_Int;
        this.jdField_a_of_type_ComTencentMobileqqWidgetMonitorSizeChangeHSV.setLayoutParams((ViewGroup.LayoutParams)localObject);
        localObject = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject).height = this.jdField_f_of_type_Int;
        int i = (int)(this.jdField_a_of_type_Float * 10.0F + 0.5D);
        ((RelativeLayout.LayoutParams)localObject).bottomMargin = i;
        ((RelativeLayout.LayoutParams)localObject).topMargin = i;
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
    }
    boolean bool;
    if (this.jdField_a_of_type_JavaUtilArrayList.size() == 1)
    {
      bool = true;
      paramInterestTagInfo = a(paramInterestTagInfo, bool);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramInterestTagInfo);
      localObject = new AlphaAnimation(0.1F, 1.0F);
      ScaleAnimation localScaleAnimation = new ScaleAnimation(0.0F, 1.0F, 0.0F, 1.0F, 1, 0.5F, 1, 0.5F);
      AnimationSet localAnimationSet = new AnimationSet(true);
      localAnimationSet.addAnimation((Animation)localObject);
      localAnimationSet.addAnimation(localScaleAnimation);
      localAnimationSet.setFillAfter(true);
      localAnimationSet.setDuration(70L);
      localAnimationSet.setInterpolator(new DecelerateInterpolator());
      localAnimationSet.setAnimationListener(new ChooseInterestTagActivity.3(this));
      paramInterestTagInfo.startAnimation(localAnimationSet);
      if (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty()) {
        break label299;
      }
      this.rightViewText.setEnabled(false);
      if (!this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_AndroidWidgetEditText.setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(2130842513), null, null, null);
      }
    }
    for (;;)
    {
      a(true);
      return;
      bool = false;
      break;
      label299:
      this.rightViewText.setEnabled(true);
      if (!this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_AndroidWidgetEditText.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
      }
    }
  }
  
  private void a(String paramString)
  {
    QQToast.a(this, paramString, 0).b(getTitleBarHeight());
  }
  
  private void a(List<InterestTagInfo> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {}
    do
    {
      do
      {
        return;
        int i = 0;
        if (i < paramList.size())
        {
          Object localObject = (InterestTagInfo)paramList.get(i);
          if (i == 0) {}
          for (boolean bool = true;; bool = false)
          {
            localObject = a((InterestTagInfo)localObject, bool);
            int j = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
            this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject, j);
            i += 1;
            break;
          }
        }
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(new ChooseInterestTagActivity.2(this), 100L);
        if (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty()) {
          break;
        }
        this.rightViewText.setEnabled(false);
      } while (this.jdField_a_of_type_Boolean);
      this.jdField_a_of_type_AndroidWidgetEditText.setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(2130842513), null, null, null);
      return;
      this.rightViewText.setEnabled(true);
    } while (this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_AndroidWidgetEditText.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
  }
  
  private void a(boolean paramBoolean)
  {
    QQAppInterface localQQAppInterface;
    if (this.jdField_c_of_type_Boolean)
    {
      localQQAppInterface = this.app;
      if (!paramBoolean) {
        break label52;
      }
    }
    label52:
    for (String str = "add_tag";; str = "del_tag")
    {
      ReportController.b(localQQAppInterface, "dc00899", "grp_lbs", "", "data_card", str, 0, 0, "", "", "", String.valueOf(this.jdField_c_of_type_Int));
      return;
    }
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.jdField_b_of_type_AndroidWidgetLinearLayout == null) {
      return;
    }
    if ((!paramBoolean2) && (this.jdField_f_of_type_Boolean)) {
      this.jdField_a_of_type_AndroidWidgetListView.removeFooterView(this.jdField_b_of_type_AndroidWidgetLinearLayout);
    }
    TextView localTextView;
    ProgressBar localProgressBar;
    for (this.jdField_f_of_type_Boolean = false;; this.jdField_f_of_type_Boolean = true)
    {
      do
      {
        localTextView = (TextView)this.jdField_b_of_type_AndroidWidgetLinearLayout.findViewById(2131371896);
        localProgressBar = (ProgressBar)this.jdField_b_of_type_AndroidWidgetLinearLayout.findViewById(2131376854);
        ImageView localImageView = (ImageView)this.jdField_b_of_type_AndroidWidgetLinearLayout.findViewById(2131370717);
        if (localImageView.getVisibility() != 8) {
          localImageView.setVisibility(8);
        }
        if (!paramBoolean1) {
          break;
        }
        localTextView.setTextColor(getResources().getColor(2131167113));
        localTextView.setText(HardCodeUtil.a(2131701881));
        localProgressBar.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetLinearLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        return;
      } while ((!paramBoolean2) || (this.jdField_f_of_type_Boolean));
      this.jdField_a_of_type_AndroidWidgetListView.addFooterView(this.jdField_b_of_type_AndroidWidgetLinearLayout);
    }
    if (paramBoolean2)
    {
      localTextView.setTextColor(getResources().getColor(2131167178));
      localTextView.setText(HardCodeUtil.a(2131701867));
      localProgressBar.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      return;
    }
    localTextView.setTextColor(getResources().getColor(2131167113));
    localTextView.setText(HardCodeUtil.a(2131701889));
    localProgressBar.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setOnClickListener(null);
  }
  
  private boolean a(InterestTagInfo paramInterestTagInfo)
  {
    return this.jdField_a_of_type_JavaUtilArrayList.contains(paramInterestTagInfo);
  }
  
  @TargetApi(9)
  private void b()
  {
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(this);
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131366441));
    this.jdField_a_of_type_ComTencentMobileqqWidgetMonitorSizeChangeHSV = ((MonitorSizeChangeHSV)findViewById(2131368580));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131370642));
    this.jdField_a_of_type_AndroidWidgetListView = ((ListView)findViewById(2131370870));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131377236));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131377235);
    this.jdField_b_of_type_AndroidViewView = findViewById(2131377277);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131380809));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131380818));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131377292));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131380829));
    this.jdField_c_of_type_AndroidViewView = findViewById(2131381105);
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131380817));
    this.jdField_d_of_type_AndroidViewView = findViewById(2131381116);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131380819));
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    int i = getResources().getColor(2131166366);
    this.jdField_c_of_type_AndroidViewView.setBackgroundColor(i);
    this.jdField_d_of_type_AndroidViewView.setBackgroundColor(i);
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)LayoutInflater.from(this).inflate(2131559592, null));
    a(false, true);
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
      this.jdField_a_of_type_AndroidWidgetEditText.setOnKeyListener(this.jdField_a_of_type_AndroidViewView$OnKeyListener);
      this.jdField_a_of_type_AndroidWidgetEditText.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      if (AppSetting.jdField_d_of_type_Boolean) {
        this.jdField_a_of_type_AndroidWidgetEditText.setContentDescription(HardCodeUtil.a(2131701884));
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetMonitorSizeChangeHSV.setOnSizeChangeCallback(this.jdField_a_of_type_ComTencentMobileqqWidgetMonitorSizeChangeHSV$IOnSizeChangeCallback);
    this.jdField_a_of_type_AndroidWidgetListView.setOnScrollListener(this.jdField_a_of_type_AndroidWidgetAbsListView$OnScrollListener);
    this.jdField_a_of_type_AndroidWidgetEditText.clearFocus();
    if (Build.VERSION.SDK_INT >= 9) {
      this.jdField_a_of_type_AndroidWidgetListView.setOverScrollMode(2);
    }
    this.jdField_a_of_type_Float = getResources().getDisplayMetrics().density;
  }
  
  private void b(InterestTagInfo paramInterestTagInfo)
  {
    if (paramInterestTagInfo == null) {
      return;
    }
    int j = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
    int i = 0;
    if (i < j)
    {
      View localView = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i);
      if (((InterestTagInfo)localView.getTag()).equals(paramInterestTagInfo))
      {
        paramInterestTagInfo = new AlphaAnimation(1.0F, 0.1F);
        ScaleAnimation localScaleAnimation = new ScaleAnimation(1.0F, 0.0F, 1.0F, 0.0F, 1, 0.5F, 1, 0.5F);
        AnimationSet localAnimationSet = new AnimationSet(true);
        localAnimationSet.addAnimation(paramInterestTagInfo);
        localAnimationSet.addAnimation(localScaleAnimation);
        localAnimationSet.setFillAfter(true);
        localAnimationSet.setDuration(70L);
        localAnimationSet.setInterpolator(new AccelerateInterpolator());
        localAnimationSet.setAnimationListener(new ChooseInterestTagActivity.4(this, localView));
        localView.startAnimation(localAnimationSet);
      }
    }
    else
    {
      if (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty()) {
        break label207;
      }
      this.rightViewText.setEnabled(false);
      if (!this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_AndroidWidgetEditText.setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(2130842513), null, null, null);
      }
    }
    for (;;)
    {
      a(false);
      return;
      i += 1;
      break;
      label207:
      this.rightViewText.setEnabled(true);
      if (!this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_AndroidWidgetEditText.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
      }
    }
  }
  
  private void c()
  {
    int j = 0;
    Intent localIntent = getIntent();
    int i;
    boolean bool;
    label106:
    Object localObject;
    if (getIntent() == null)
    {
      i = -1;
      this.jdField_c_of_type_Int = i;
      if ((this.jdField_c_of_type_Int < 1) || (this.jdField_c_of_type_Int > 7))
      {
        finish();
        if (QLog.isColorLevel()) {
          QLog.i("choose_interest_tag", 2, "tagType is wrong. " + this.jdField_c_of_type_Int);
        }
      }
      if (localIntent != null) {
        this.jdField_c_of_type_Boolean = localIntent.getBooleanExtra("is_from_nearby", false);
      }
      if (getIntent() != null) {
        break label453;
      }
      bool = false;
      this.jdField_b_of_type_Boolean = bool;
      if (this.jdField_b_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        localObject = "";
        if (this.jdField_c_of_type_Int != 3) {
          break label468;
        }
        localObject = HardCodeUtil.a(2131701892);
        label146:
        this.jdField_d_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      }
      if ((this.jdField_c_of_type_Int != 2) && (this.jdField_c_of_type_Int != 4)) {
        break label584;
      }
      bool = true;
      label173:
      this.jdField_a_of_type_Boolean = bool;
      if (!this.jdField_a_of_type_Boolean) {
        break label589;
      }
      i = 10;
      label188:
      this.jdField_e_of_type_Int = i;
      ((RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqWidgetMonitorSizeChangeHSV.getLayoutParams()).rightMargin = ((int)(this.jdField_a_of_type_Float * this.jdField_e_of_type_Int + 0.5D));
      if (this.jdField_c_of_type_Int != 5) {
        break label595;
      }
      this.jdField_f_of_type_Int = ((int)(this.jdField_a_of_type_Float * 50.0F + 0.5D));
      label248:
      if (!this.jdField_a_of_type_Boolean) {
        break label669;
      }
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      localObject = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).height = 1;
      ((RelativeLayout.LayoutParams)localObject).width = 1;
      i = j;
      if (this.jdField_b_of_type_Boolean) {
        i = (int)(this.jdField_a_of_type_Float * 7.0F + 0.5D);
      }
      ((RelativeLayout.LayoutParams)localObject).topMargin = i;
      ((RelativeLayout.LayoutParams)localObject).bottomMargin = i;
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams().height = this.jdField_f_of_type_Int;
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setGravity(16);
      if (localIntent != null)
      {
        localObject = localIntent.getParcelableArrayListExtra("choosed_interest_tags");
        if ((localObject != null) && (((ArrayList)localObject).size() > 0))
        {
          Collections.reverse((List)localObject);
          this.jdField_a_of_type_JavaUtilArrayList.addAll((Collection)localObject);
        }
        d();
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier = new QQProgressNotifier(this);
      this.jdField_a_of_type_ComTencentMobileqqNearbyBusinessNearbyCardHandler = ((NearbyCardHandler)this.app.getBusinessHandler(BusinessHandlerFactory.NEARBY_CARD_HANDLER));
      ThreadManager.getFileThreadHandler().post(new ChooseInterestTagActivity.1(this));
      return;
      i = getIntent().getIntExtra("interest_tag_type", -1);
      break;
      label453:
      bool = getIntent().getBooleanExtra("is_from_judge", false);
      break label106;
      label468:
      if (this.jdField_c_of_type_Int == 5)
      {
        localObject = HardCodeUtil.a(2131701870);
        break label146;
      }
      if (this.jdField_c_of_type_Int == 6)
      {
        localObject = HardCodeUtil.a(2131701856);
        break label146;
      }
      if (this.jdField_c_of_type_Int == 2)
      {
        localObject = HardCodeUtil.a(2131701875);
        break label146;
      }
      if (this.jdField_c_of_type_Int == 7)
      {
        localObject = HardCodeUtil.a(2131701873);
        break label146;
      }
      if (this.jdField_c_of_type_Int == 4)
      {
        localObject = HardCodeUtil.a(2131701851);
        break label146;
      }
      if (this.jdField_c_of_type_Int != 1) {
        break label146;
      }
      localObject = HardCodeUtil.a(2131701855);
      break label146;
      label584:
      bool = false;
      break label173;
      label589:
      i = 100;
      break label188;
      label595:
      if ((this.jdField_c_of_type_Int == 1) || (this.jdField_c_of_type_Int == 2) || (this.jdField_c_of_type_Int == 3) || (this.jdField_c_of_type_Int == 4))
      {
        this.jdField_f_of_type_Int = ((int)(this.jdField_a_of_type_Float * 26.0F + 0.5D));
        break label248;
      }
      this.jdField_f_of_type_Int = ((int)(this.jdField_a_of_type_Float * 40.0F + 0.5D));
      break label248;
      label669:
      localObject = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).height = this.jdField_f_of_type_Int;
      i = (int)(this.jdField_a_of_type_Float * 10.0F + 0.5D);
      ((RelativeLayout.LayoutParams)localObject).bottomMargin = i;
      ((RelativeLayout.LayoutParams)localObject).topMargin = i;
    }
  }
  
  private void c(InterestTagInfo paramInterestTagInfo)
  {
    int j = this.jdField_a_of_type_AndroidWidgetListView.getFirstVisiblePosition();
    int k = this.jdField_a_of_type_AndroidWidgetListView.getLastVisiblePosition();
    int i = j;
    while (i <= k)
    {
      View localView = this.jdField_a_of_type_AndroidWidgetListView.getChildAt(i - j);
      if ((localView != null) && ((localView instanceof InterestTagItemView)) && (paramInterestTagInfo.equals(localView.getTag()))) {
        ((InterestTagItemView)localView).a();
      }
      i += 1;
    }
  }
  
  private void d()
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.isEmpty()))
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetMonitorSizeChangeHSV.getVisibility() != 8) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetMonitorSizeChangeHSV.setVisibility(8);
      }
      this.rightViewText.setEnabled(false);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetMonitorSizeChangeHSV.getVisibility() != 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetMonitorSizeChangeHSV.setVisibility(0);
      if (this.jdField_a_of_type_Boolean)
      {
        RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqWidgetMonitorSizeChangeHSV.getLayoutParams();
        localLayoutParams.height = this.jdField_f_of_type_Int;
        this.jdField_a_of_type_ComTencentMobileqqWidgetMonitorSizeChangeHSV.setLayoutParams(localLayoutParams);
        localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
        localLayoutParams.height = this.jdField_f_of_type_Int;
        int i = (int)(this.jdField_a_of_type_Float * 10.0F + 0.5D);
        localLayoutParams.bottomMargin = i;
        localLayoutParams.topMargin = i;
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setLayoutParams(localLayoutParams);
      }
    }
    a(this.jdField_a_of_type_JavaUtilArrayList);
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.b();
    }
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public void doOnBackPressed()
  {
    if (!this.jdField_b_of_type_Boolean)
    {
      Intent localIntent2 = getIntent();
      Intent localIntent1 = localIntent2;
      if (localIntent2 == null) {
        localIntent1 = new Intent();
      }
      Collections.reverse(this.jdField_a_of_type_JavaUtilArrayList);
      localIntent1.putParcelableArrayListExtra("choosed_interest_tags", this.jdField_a_of_type_JavaUtilArrayList);
      localIntent1.putExtra("interest_tag_type", this.jdField_c_of_type_Int);
      setResult(-1, localIntent1);
    }
    super.doOnBackPressed();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2131561339);
    getWindow().setBackgroundDrawable(getResources().getDrawable(2130845181));
    b();
    addObserver(this.jdField_a_of_type_ComTencentMobileqqNearbyBusinessNearbyCardObserver);
    c();
    a();
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqNearbyBusinessNearbyCardObserver);
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.b();
    }
  }
  
  public void finish()
  {
    InputMethodUtil.b(this.jdField_a_of_type_AndroidWidgetEditText);
    super.finish();
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.interestTag.ChooseInterestTagActivity
 * JD-Core Version:    0.7.0.1
 */