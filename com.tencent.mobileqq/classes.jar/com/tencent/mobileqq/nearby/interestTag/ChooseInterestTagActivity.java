package com.tencent.mobileqq.nearby.interestTag;

import ajya;
import android.annotation.TargetApi;
import android.content.Intent;
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
import atbz;
import atcd;
import atfa;
import atfb;
import atfc;
import atfd;
import atfe;
import atff;
import atfg;
import atfh;
import atfi;
import atfj;
import atfk;
import atfl;
import atfn;
import atfq;
import atft;
import atol;
import axqy;
import ayst;
import bavw;
import bbdv;
import bcno;
import bcqi;
import bcql;
import bfni;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.MonitorSizeChangeHSV;
import com.tencent.qphone.base.util.QLog;
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
  private int jdField_a_of_type_Int;
  private Handler jdField_a_of_type_AndroidOsHandler = new atfh(this);
  private TextWatcher jdField_a_of_type_AndroidTextTextWatcher = new atfd(this);
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new atfa(this);
  private View.OnKeyListener jdField_a_of_type_AndroidViewView$OnKeyListener = new atfk(this);
  private View jdField_a_of_type_AndroidViewView;
  private AbsListView.OnScrollListener jdField_a_of_type_AndroidWidgetAbsListView$OnScrollListener = new atfj(this);
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private ListView jdField_a_of_type_AndroidWidgetListView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private atbz jdField_a_of_type_Atbz;
  private atcd jdField_a_of_type_Atcd = new atfi(this);
  private atfn jdField_a_of_type_Atfn;
  private atfq jdField_a_of_type_Atfq = new atfe(this);
  private atft jdField_a_of_type_Atft = new atfc(this);
  private bcno jdField_a_of_type_Bcno = new atfl(this);
  private bcqi jdField_a_of_type_Bcqi;
  private MonitorSizeChangeHSV jdField_a_of_type_ComTencentMobileqqWidgetMonitorSizeChangeHSV;
  private String jdField_a_of_type_JavaLangString = "";
  private ArrayList<InterestTagInfo> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private List<InterestTagInfo> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener = new atfb(this);
  private View jdField_b_of_type_AndroidViewView;
  private LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private List<InterestTagInfo> jdField_b_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int = -1;
  private View jdField_c_of_type_AndroidViewView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int;
  private View jdField_d_of_type_AndroidViewView;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int;
  private TextView jdField_e_of_type_AndroidWidgetTextView;
  private boolean jdField_e_of_type_Boolean;
  private int jdField_f_of_type_Int;
  private boolean jdField_f_of_type_Boolean;
  
  private View a(InterestTagInfo paramInterestTagInfo, boolean paramBoolean)
  {
    Object localObject4;
    TextView localTextView;
    Object localObject1;
    Object localObject3;
    int i;
    if ((this.jdField_c_of_type_Boolean) || (this.jdField_c_of_type_Int == 3) || (this.jdField_c_of_type_Int == 2) || (this.jdField_c_of_type_Int == 1) || (this.jdField_c_of_type_Int == 4))
    {
      localObject4 = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131560899, null);
      localTextView = (TextView)((View)localObject4).findViewById(2131378436);
      if (localTextView != null)
      {
        if (paramInterestTagInfo.tagName != null) {
          break label300;
        }
        localObject1 = "";
        localObject3 = localObject1;
        if (((String)localObject1).length() > 6) {
          localObject3 = ((String)localObject1).substring(0, 6) + "...";
        }
        localTextView.setSingleLine(true);
        localTextView.setText((CharSequence)localObject3);
        if (!this.jdField_c_of_type_Boolean) {
          break label312;
        }
        i = atol.a(this.jdField_c_of_type_Int);
        if (i == -1) {
          break label804;
        }
        i = Color.parseColor(atol.b[i]);
      }
    }
    for (;;)
    {
      label163:
      localTextView.setTextColor(i);
      if (this.jdField_c_of_type_Boolean)
      {
        i = atol.a(this.jdField_c_of_type_Int);
        if (i == -1) {
          break label799;
        }
        i = Color.parseColor(atol.jdField_a_of_type_ArrayOfJavaLangString[i]);
      }
      for (;;)
      {
        label198:
        localObject1 = new GradientDrawable();
        ((GradientDrawable)localObject1).setColor(i);
        ((GradientDrawable)localObject1).setCornerRadius(getResources().getDimensionPixelSize(2131298653));
        ((View)localObject4).setBackgroundDrawable((Drawable)localObject1);
        ((View)localObject4).setTag(paramInterestTagInfo);
        paramInterestTagInfo = new LinearLayout.LayoutParams(-2, (int)bbdv.a(this, 17.0F));
        if (paramBoolean) {}
        label300:
        label312:
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
          ((GradientDrawable)localObject2).setColor(getResources().getColor(2131165766));
          ((GradientDrawable)localObject2).setCornerRadius(this.jdField_a_of_type_Float * 10.0F);
          ((GradientDrawable)localObject2).setShape(0);
          i = getResources().getDimensionPixelSize(2131297255);
          ((GradientDrawable)localObject2).setSize(i, i);
          if (TextUtils.isEmpty(paramInterestTagInfo.tagIconUrl)) {
            break label794;
          }
        }
        for (;;)
        {
          try
          {
            localObject3 = URLDrawable.URLDrawableOptions.obtain();
            if (this.jdField_c_of_type_Int == 5)
            {
              i = getResources().getDimensionPixelSize(2131297257);
              ((URLDrawable.URLDrawableOptions)localObject3).mRequestHeight = i;
              j = getResources().getDimensionPixelSize(2131297256);
              ((URLDrawable.URLDrawableOptions)localObject3).mRequestWidth = j;
              ((URLDrawable.URLDrawableOptions)localObject3).mFailedDrawable = ((Drawable)localObject2);
              ((URLDrawable.URLDrawableOptions)localObject3).mLoadingDrawable = ((Drawable)localObject2);
              paramInterestTagInfo = URLDrawable.getDrawable(ayst.a(paramInterestTagInfo.tagIconUrl), (URLDrawable.URLDrawableOptions)localObject3);
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
              paramInterestTagInfo.setTag(bavw.b(j, i, (int)(this.jdField_a_of_type_Float * 10.0F)));
              paramInterestTagInfo.setDecodeHandler(bavw.c);
            }
            ((URLDrawable.URLDrawableOptions)localObject3).mFailedDrawable = null;
            ((URLDrawable.URLDrawableOptions)localObject3).mLoadingDrawable = null;
            if (paramInterestTagInfo != null) {
              break label783;
            }
            ((ImageView)localObject4).setImageDrawable((Drawable)localObject2);
            return localObject4;
          }
          catch (Exception localException4)
          {
            break label762;
          }
          localObject2 = getResources().getDrawable(2131165766);
          break;
          i = getResources().getDimensionPixelSize(2131297255);
          ((URLDrawable.URLDrawableOptions)localObject3).mRequestHeight = i;
          continue;
          label762:
          if (QLog.isColorLevel()) {
            QLog.i("choose_interest_tag", 2, localException3.toString());
          }
          continue;
          label783:
          localObject2 = paramInterestTagInfo;
          continue;
          label794:
          paramInterestTagInfo = null;
        }
        label799:
        i = 0;
      }
      label804:
      i = -1;
    }
  }
  
  private void a()
  {
    String str2 = "";
    String str1 = "";
    String str3 = ajya.a(2131701780);
    if (this.jdField_c_of_type_Int == 3)
    {
      str2 = ajya.a(2131701790);
      str1 = ajya.a(2131701818);
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
      setLeftViewName(2131690596);
      this.leftView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.rightViewImg.setVisibility(8);
      this.rightViewText.setVisibility(0);
      this.rightViewText.setText(ajya.a(2131701802));
      this.rightViewText.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      return;
      if (this.jdField_c_of_type_Int == 5)
      {
        str2 = ajya.a(2131701781);
        str1 = ajya.a(2131701789);
        this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_d_of_type_AndroidViewView.setVisibility(0);
        break;
      }
      if (this.jdField_c_of_type_Int == 6)
      {
        str2 = ajya.a(2131701813);
        str1 = ajya.a(2131701807);
        this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_d_of_type_AndroidViewView.setVisibility(0);
        break;
      }
      if (this.jdField_c_of_type_Int == 2)
      {
        str2 = ajya.a(2131701786);
        str1 = ajya.a(2131701810);
        this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_d_of_type_AndroidViewView.setVisibility(8);
        break;
      }
      if (this.jdField_c_of_type_Int == 7)
      {
        str2 = ajya.a(2131701785);
        str1 = ajya.a(2131701811);
        this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_d_of_type_AndroidViewView.setVisibility(0);
        break;
      }
      if (this.jdField_c_of_type_Int == 4)
      {
        str1 = ajya.a(2131701819);
        str2 = ajya.a(2131701791);
        this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_d_of_type_AndroidViewView.setVisibility(8);
        break;
      }
      if (this.jdField_c_of_type_Int != 1) {
        break;
      }
      str2 = ajya.a(2131701788);
      str1 = ajya.a(2131701797);
      this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_d_of_type_AndroidViewView.setVisibility(0);
      str3 = ajya.a(2131701782);
      break;
      label399:
      str1 = str2;
    }
    label404:
    setLeftViewName(2131690331);
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
    if ((this.jdField_a_of_type_Bcqi != null) && (!isFinishing())) {
      this.jdField_a_of_type_Bcqi.a(paramInt1, paramString, paramInt2);
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
      localAnimationSet.setAnimationListener(new atff(this));
      paramInterestTagInfo.startAnimation(localAnimationSet);
      if (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty()) {
        break label299;
      }
      this.rightViewText.setEnabled(false);
      if (!this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_AndroidWidgetEditText.setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(2130841811), null, null, null);
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
    bcql.a(this, paramString, 0).b(getTitleBarHeight());
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
      this.jdField_a_of_type_AndroidWidgetEditText.setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(2130841811), null, null, null);
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
      axqy.b(localQQAppInterface, "dc00899", "grp_lbs", "", "data_card", str, 0, 0, "", "", "", String.valueOf(this.jdField_c_of_type_Int));
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
        localTextView = (TextView)this.jdField_b_of_type_AndroidWidgetLinearLayout.findViewById(2131370442);
        localProgressBar = (ProgressBar)this.jdField_b_of_type_AndroidWidgetLinearLayout.findViewById(2131375056);
        ImageView localImageView = (ImageView)this.jdField_b_of_type_AndroidWidgetLinearLayout.findViewById(2131369480);
        if (localImageView.getVisibility() != 8) {
          localImageView.setVisibility(8);
        }
        if (!paramBoolean1) {
          break;
        }
        localTextView.setTextColor(getResources().getColor(2131166928));
        localTextView.setText(ajya.a(2131701809));
        localProgressBar.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetLinearLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        return;
      } while ((!paramBoolean2) || (this.jdField_f_of_type_Boolean));
      this.jdField_a_of_type_AndroidWidgetListView.addFooterView(this.jdField_b_of_type_AndroidWidgetLinearLayout);
    }
    if (paramBoolean2)
    {
      localTextView.setTextColor(getResources().getColor(2131166987));
      localTextView.setText(ajya.a(2131701795));
      localProgressBar.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      return;
    }
    localTextView.setTextColor(getResources().getColor(2131166928));
    localTextView.setText(ajya.a(2131701817));
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
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131365753));
    this.jdField_a_of_type_ComTencentMobileqqWidgetMonitorSizeChangeHSV = ((MonitorSizeChangeHSV)findViewById(2131367664));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131369423));
    this.jdField_a_of_type_AndroidWidgetListView = ((ListView)findViewById(2131369606));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131375390));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131375389);
    this.jdField_b_of_type_AndroidViewView = findViewById(2131375428);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378525));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378534));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131375442));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378545));
    this.jdField_c_of_type_AndroidViewView = findViewById(2131378806);
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378533));
    this.jdField_d_of_type_AndroidViewView = findViewById(2131378815);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378535));
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    int i = getResources().getColor(2131166211);
    this.jdField_c_of_type_AndroidViewView.setBackgroundColor(i);
    this.jdField_d_of_type_AndroidViewView.setBackgroundColor(i);
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)LayoutInflater.from(this).inflate(2131559314, null));
    a(false, true);
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
      this.jdField_a_of_type_AndroidWidgetEditText.setOnKeyListener(this.jdField_a_of_type_AndroidViewView$OnKeyListener);
      this.jdField_a_of_type_AndroidWidgetEditText.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      if (AppSetting.jdField_d_of_type_Boolean) {
        this.jdField_a_of_type_AndroidWidgetEditText.setContentDescription(ajya.a(2131701812));
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetMonitorSizeChangeHSV.setOnSizeChangeCallback(this.jdField_a_of_type_Bcno);
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
        localAnimationSet.setAnimationListener(new atfg(this, localView));
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
        this.jdField_a_of_type_AndroidWidgetEditText.setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(2130841811), null, null, null);
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
        break label452;
      }
      bool = false;
      this.jdField_b_of_type_Boolean = bool;
      if (this.jdField_b_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        localObject = "";
        if (this.jdField_c_of_type_Int != 3) {
          break label467;
        }
        localObject = ajya.a(2131701820);
        label146:
        this.jdField_d_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      }
      if ((this.jdField_c_of_type_Int != 2) && (this.jdField_c_of_type_Int != 4)) {
        break label583;
      }
      bool = true;
      label173:
      this.jdField_a_of_type_Boolean = bool;
      if (!this.jdField_a_of_type_Boolean) {
        break label588;
      }
      i = 10;
      label188:
      this.jdField_e_of_type_Int = i;
      ((RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqWidgetMonitorSizeChangeHSV.getLayoutParams()).rightMargin = ((int)(this.jdField_a_of_type_Float * this.jdField_e_of_type_Int + 0.5D));
      if (this.jdField_c_of_type_Int != 5) {
        break label594;
      }
      this.jdField_f_of_type_Int = ((int)(this.jdField_a_of_type_Float * 50.0F + 0.5D));
      label248:
      if (!this.jdField_a_of_type_Boolean) {
        break label668;
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
      this.jdField_a_of_type_Bcqi = new bcqi(this);
      this.jdField_a_of_type_Atbz = ((atbz)this.app.a(60));
      ThreadManager.getFileThreadHandler().post(new ChooseInterestTagActivity.1(this));
      return;
      i = getIntent().getIntExtra("interest_tag_type", -1);
      break;
      label452:
      bool = getIntent().getBooleanExtra("is_from_judge", false);
      break label106;
      label467:
      if (this.jdField_c_of_type_Int == 5)
      {
        localObject = ajya.a(2131701798);
        break label146;
      }
      if (this.jdField_c_of_type_Int == 6)
      {
        localObject = ajya.a(2131701784);
        break label146;
      }
      if (this.jdField_c_of_type_Int == 2)
      {
        localObject = ajya.a(2131701803);
        break label146;
      }
      if (this.jdField_c_of_type_Int == 7)
      {
        localObject = ajya.a(2131701801);
        break label146;
      }
      if (this.jdField_c_of_type_Int == 4)
      {
        localObject = ajya.a(2131701779);
        break label146;
      }
      if (this.jdField_c_of_type_Int != 1) {
        break label146;
      }
      localObject = ajya.a(2131701783);
      break label146;
      label583:
      bool = false;
      break label173;
      label588:
      i = 100;
      break label188;
      label594:
      if ((this.jdField_c_of_type_Int == 1) || (this.jdField_c_of_type_Int == 2) || (this.jdField_c_of_type_Int == 3) || (this.jdField_c_of_type_Int == 4))
      {
        this.jdField_f_of_type_Int = ((int)(this.jdField_a_of_type_Float * 26.0F + 0.5D));
        break label248;
      }
      this.jdField_f_of_type_Int = ((int)(this.jdField_a_of_type_Float * 40.0F + 0.5D));
      break label248;
      label668:
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
    if (this.jdField_a_of_type_Bcqi != null) {
      this.jdField_a_of_type_Bcqi.b();
    }
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
    setContentView(2131560846);
    getWindow().setBackgroundDrawable(getResources().getDrawable(2130844242));
    b();
    addObserver(this.jdField_a_of_type_Atcd);
    c();
    a();
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    removeObserver(this.jdField_a_of_type_Atcd);
    if (this.jdField_a_of_type_Bcqi != null) {
      this.jdField_a_of_type_Bcqi.b();
    }
  }
  
  public void finish()
  {
    bfni.b(this.jdField_a_of_type_AndroidWidgetEditText);
    super.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.interestTag.ChooseInterestTagActivity
 * JD-Core Version:    0.7.0.1
 */