package com.tencent.mobileqq.widget.navbar;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.qwallet.goldmsg.GoldMsgChatHelper;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;

public class NavBarAIO
  extends RelativeLayout
  implements View.OnClickListener
{
  private float jdField_a_of_type_Float;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private OnItemSelectListener jdField_a_of_type_ComTencentMobileqqWidgetNavbarOnItemSelectListener;
  private boolean jdField_a_of_type_Boolean;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private ImageView jdField_d_of_type_AndroidWidgetImageView;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private ImageView jdField_e_of_type_AndroidWidgetImageView;
  private TextView jdField_e_of_type_AndroidWidgetTextView;
  private ImageView jdField_f_of_type_AndroidWidgetImageView;
  private TextView jdField_f_of_type_AndroidWidgetTextView;
  private TextView g;
  
  public NavBarAIO(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public NavBarAIO(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public NavBarAIO(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    View.inflate(paramContext, 2130968837, this);
    setBackgroundResource(2130845951);
    this.jdField_a_of_type_Float = paramContext.getResources().getDisplayMetrics().density;
    this.jdField_a_of_type_Boolean = ThemeUtil.isDefaultOrDIYTheme(false);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131363262));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131364025));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131364019));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131364020));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131363399));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131363987));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131364022));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131363397));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131364024));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131363263));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131363791));
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131364027));
    this.g = ((TextView)findViewById(2131364030));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131364028));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131363493));
    this.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131364029));
    this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131364031));
  }
  
  public void a()
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetLinearLayout.getLayoutParams();
    int i;
    int k;
    int m;
    int j;
    if (!this.jdField_a_of_type_Boolean)
    {
      i = this.jdField_a_of_type_AndroidWidgetTextView.getMeasuredWidth();
      k = this.jdField_a_of_type_AndroidWidgetRelativeLayout.getMeasuredWidth();
      m = (int)(10.0F * this.jdField_a_of_type_Float + 0.5F);
      j = (int)(12.0F * this.jdField_a_of_type_Float + 0.5F);
      m = i + m;
      if ((m <= 0) || (k <= 0)) {
        break label208;
      }
      if ((k <= m) || (localLayoutParams.leftMargin == k)) {
        break label198;
      }
      i = k + j;
      j = i;
    }
    for (;;)
    {
      if (j != localLayoutParams.leftMargin)
      {
        localLayoutParams.setMargins(j, 0, i, 0);
        this.jdField_b_of_type_AndroidWidgetLinearLayout.setLayoutParams(localLayoutParams);
      }
      if (QLog.isDevelopLevel()) {
        QLog.d("NavBarAIO", 4, "fight_Text is ellipsized and lw =  " + m + " rw = " + k);
      }
      return;
      j = this.jdField_a_of_type_AndroidWidgetImageView.getMeasuredWidth();
      i = j;
      if (this.jdField_b_of_type_AndroidWidgetTextView.getVisibility() != 0) {
        break;
      }
      i = j + this.jdField_b_of_type_AndroidWidgetTextView.getMeasuredWidth();
      break;
      label198:
      i = m + j;
      j = i;
      continue;
      label208:
      j = (int)(110.0F * this.jdField_a_of_type_Float + 0.5F);
      i = (int)(97.0F * this.jdField_a_of_type_Float + 0.5F);
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(paramInt);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Boolean) {}
    for (;;)
    {
      a(paramInt2);
      return;
      paramInt2 = paramInt1;
    }
  }
  
  public void a(SessionInfo paramSessionInfo)
  {
    String str = paramSessionInfo.a;
    if (!this.jdField_a_of_type_Boolean)
    {
      if ((!AnonymousChatHelper.a().a(str)) && (!GoldMsgChatHelper.a(paramSessionInfo)))
      {
        paramSessionInfo = getResources().getColorStateList(2131494218);
        this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(paramSessionInfo);
        this.jdField_d_of_type_AndroidWidgetTextView.setTextColor(paramSessionInfo);
        this.jdField_e_of_type_AndroidWidgetTextView.setTextColor(paramSessionInfo);
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      paramSessionInfo = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
      paramSessionInfo.width = AIOUtils.a(41.0F, getResources());
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setLayoutParams(paramSessionInfo);
      paramSessionInfo = (RelativeLayout.LayoutParams)this.jdField_d_of_type_AndroidWidgetImageView.getLayoutParams();
      paramSessionInfo.rightMargin = 0;
      this.jdField_d_of_type_AndroidWidgetImageView.setLayoutParams(paramSessionInfo);
      return;
    }
    if ((!AnonymousChatHelper.a().a(str)) && (!GoldMsgChatHelper.a(paramSessionInfo)))
    {
      paramSessionInfo = getResources().getColorStateList(2131494219);
      this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(paramSessionInfo);
      this.jdField_d_of_type_AndroidWidgetTextView.setTextColor(paramSessionInfo);
      this.jdField_e_of_type_AndroidWidgetTextView.setTextColor(paramSessionInfo);
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    if (!TextUtils.isEmpty(this.jdField_b_of_type_AndroidWidgetTextView.getText())) {
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    for (;;)
    {
      paramSessionInfo = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
      paramSessionInfo.width = AIOUtils.a(38.0F, getResources());
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setLayoutParams(paramSessionInfo);
      paramSessionInfo = (RelativeLayout.LayoutParams)this.jdField_d_of_type_AndroidWidgetImageView.getLayoutParams();
      paramSessionInfo.rightMargin = AIOUtils.a(8.0F, getResources());
      this.jdField_d_of_type_AndroidWidgetImageView.setLayoutParams(paramSessionInfo);
      return;
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    ImageView localImageView = this.jdField_f_of_type_AndroidWidgetImageView;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localImageView.setVisibility(i);
      return;
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_Boolean = ThemeUtil.isDefaultOrDIYTheme(false);
    if (!this.jdField_a_of_type_Boolean)
    {
      setBackgroundResource(2130845951);
      return;
    }
    setBackgroundResource(2130845952);
  }
  
  public void onClick(View paramView)
  {
    int i = 0;
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      if ((i != 0) && (this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarOnItemSelectListener != null)) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarOnItemSelectListener.a(paramView, i);
      }
      return;
      i = 1;
      continue;
      i = 3;
      continue;
      i = 2;
      continue;
      i = 5;
      continue;
      i = 4;
    }
  }
  
  public void setIsDefaultTheme(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setLeftContentDescription(String paramString)
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setContentDescription(paramString);
    this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(paramString);
  }
  
  public void setOnSelectListener(OnItemSelectListener paramOnItemSelectListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarOnItemSelectListener = paramOnItemSelectListener;
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
    this.jdField_f_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.g.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(this);
  }
  
  public void setRight1(String paramString)
  {
    this.g.setText(paramString);
    this.g.setContentDescription(paramString);
    this.g.setVisibility(0);
    this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
    AIOUtils.a(this.g, AIOUtils.a(7.0F, getResources()), AIOUtils.a(7.0F, getResources()), AIOUtils.a(4.0F, getResources()), AIOUtils.a(8.0F, getResources()));
  }
  
  public void setRight1Icon(int paramInt)
  {
    this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_d_of_type_AndroidWidgetImageView.setImageResource(paramInt);
    this.g.setVisibility(8);
    AIOUtils.a(this.jdField_d_of_type_AndroidWidgetImageView, AIOUtils.a(7.0F, getResources()), AIOUtils.a(7.0F, getResources()), AIOUtils.a(4.0F, getResources()), AIOUtils.a(8.0F, getResources()));
  }
  
  public void setRight1Icon(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Boolean) {}
    for (;;)
    {
      setRight1Icon(paramInt2);
      return;
      paramInt2 = paramInt1;
    }
  }
  
  public void setRight2(String paramString)
  {
    this.jdField_f_of_type_AndroidWidgetTextView.setText(paramString);
    this.jdField_f_of_type_AndroidWidgetTextView.setContentDescription(paramString);
    this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
    AIOUtils.a(this.jdField_f_of_type_AndroidWidgetTextView, AIOUtils.a(7.0F, getResources()), AIOUtils.a(7.0F, getResources()), AIOUtils.a(8.0F, getResources()), AIOUtils.a(4.0F, getResources()));
  }
  
  public void setRight2Icon(int paramInt)
  {
    this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(paramInt);
    this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(8);
    AIOUtils.a(this.jdField_c_of_type_AndroidWidgetImageView, AIOUtils.a(7.0F, getResources()), AIOUtils.a(7.0F, getResources()), AIOUtils.a(8.0F, getResources()), AIOUtils.a(4.0F, getResources()));
  }
  
  public void setRight2Icon(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Boolean) {}
    for (;;)
    {
      setRight2Icon(paramInt2);
      return;
      paramInt2 = paramInt1;
    }
  }
  
  public void setRightIcon1Desc(String paramString)
  {
    this.jdField_d_of_type_AndroidWidgetImageView.setContentDescription(paramString);
  }
  
  public void setRightIcon2Desc(String paramString)
  {
    this.jdField_c_of_type_AndroidWidgetImageView.setContentDescription(paramString);
  }
  
  public void setTitleIcon(int paramInt)
  {
    this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\a2.jar
 * Qualified Name:     com.tencent.mobileqq.widget.navbar.NavBarAIO
 * JD-Core Version:    0.7.0.1
 */