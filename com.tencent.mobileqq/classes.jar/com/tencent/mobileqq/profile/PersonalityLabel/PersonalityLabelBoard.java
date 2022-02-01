package com.tencent.mobileqq.profile.PersonalityLabel;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.profile.PersonalityLabel.tagCloud.TagCloudView;
import com.tencent.mobileqq.profile.PersonalityLabel.tagCloud.TagUtil;
import com.tencent.mobileqq.profilecard.bussiness.personalitylabel.ProfilePersonalityLabelComponent;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

public class PersonalityLabelBoard
  extends LinearLayout
  implements Handler.Callback, View.OnClickListener, OnGetPersonalityLabelsListener
{
  float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int = 0;
  ColorStateList jdField_a_of_type_AndroidContentResColorStateList = ColorStateList.valueOf(-16777216);
  Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  protected LayoutInflater a;
  View jdField_a_of_type_AndroidViewView;
  public Button a;
  LinearLayout.LayoutParams jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  public TextView a;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  ProfilePersonalityLabelInfo jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelProfilePersonalityLabelInfo;
  public TagCloudView a;
  private ProfilePersonalityLabelComponent jdField_a_of_type_ComTencentMobileqqProfilecardBussinessPersonalitylabelProfilePersonalityLabelComponent;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean = false;
  public View b;
  public TextView b;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean = true;
  public TextView c;
  
  public PersonalityLabelBoard(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b();
  }
  
  @TargetApi(11)
  public PersonalityLabelBoard(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    b();
  }
  
  public PersonalityLabelBoard(Context paramContext, QQAppInterface paramQQAppInterface, String paramString)
  {
    super(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    b();
    if (!TextUtils.equals(paramString, paramQQAppInterface.getCurrentAccountUin())) {
      this.jdField_a_of_type_Int = 1;
    }
    this.jdField_b_of_type_JavaLangString = paramString;
  }
  
  private void a(ProfilePersonalityLabelInfo paramProfilePersonalityLabelInfo)
  {
    ArrayList localArrayList = new ArrayList(paramProfilePersonalityLabelInfo.getSize());
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2131165426);
    }
    Object localObject = paramProfilePersonalityLabelInfo.getLatestThumbUrl();
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      Drawable localDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      localObject = URLDrawable.getDrawable((String)localObject, localDrawable, localDrawable);
    }
    else
    {
      localObject = null;
    }
    TagUtil.a(localArrayList, paramProfilePersonalityLabelInfo, this.jdField_a_of_type_Float);
    this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelTagCloudTagCloudView.setTags(localArrayList);
    this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelTagCloudTagCloudView.setTagIcon((Drawable)localObject);
    if (AppSetting.d)
    {
      paramProfilePersonalityLabelInfo = new StringBuilder();
      paramProfilePersonalityLabelInfo.append("个性标签");
      this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelTagCloudTagCloudView.setContentDescription(paramProfilePersonalityLabelInfo.toString());
    }
  }
  
  private void a(ProfilePersonalityLabelInfo paramProfilePersonalityLabelInfo, boolean paramBoolean)
  {
    int i;
    if (this.jdField_a_of_type_Int == 1) {
      i = paramProfilePersonalityLabelInfo.praiseCount + paramProfilePersonalityLabelInfo.unreadCount;
    } else {
      i = paramProfilePersonalityLabelInfo.praiseCount;
    }
    if ((i <= 0) && (paramProfilePersonalityLabelInfo.unreadCount <= 0))
    {
      if (this.jdField_b_of_type_AndroidViewView.getVisibility() != 8) {
        this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      }
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("获得");
    localStringBuilder.append(i);
    localStringBuilder.append("个赞");
    if (!TextUtils.equals(this.jdField_b_of_type_AndroidWidgetTextView.getText(), localStringBuilder)) {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(localStringBuilder);
    }
    if (this.jdField_b_of_type_AndroidViewView.getVisibility() != 0) {
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
    }
    if (this.jdField_a_of_type_Int == 0)
    {
      if (paramProfilePersonalityLabelInfo.unreadCount <= 0)
      {
        if (this.c.getVisibility() != 8) {
          this.c.setVisibility(8);
        }
      }
      else
      {
        if (this.c.getVisibility() != 0) {
          this.c.setVisibility(0);
        }
        localStringBuilder.delete(0, localStringBuilder.length());
        localStringBuilder.append("+");
        localStringBuilder.append(paramProfilePersonalityLabelInfo.unreadCount);
        if (!TextUtils.equals(this.c.getText(), localStringBuilder)) {
          this.c.setText(localStringBuilder);
        }
      }
    }
    else if (this.c.getVisibility() != 8) {
      this.c.setVisibility(8);
    }
    if (AppSetting.d)
    {
      localStringBuilder.delete(0, localStringBuilder.length());
      localStringBuilder.append("个性标签");
      localStringBuilder.append("，");
      localStringBuilder.append(this.jdField_b_of_type_AndroidWidgetTextView.getText());
      if (this.jdField_a_of_type_Int == 0)
      {
        if (paramProfilePersonalityLabelInfo.unreadCount > 0)
        {
          localStringBuilder.append("，");
          localStringBuilder.append("新增");
          localStringBuilder.append(paramProfilePersonalityLabelInfo.unreadCount);
          localStringBuilder.append("个赞");
        }
        localStringBuilder.append("，");
        localStringBuilder.append("点按两次查看");
      }
      this.jdField_b_of_type_AndroidViewView.setContentDescription(localStringBuilder.toString());
    }
    if ((paramBoolean) && (this.jdField_a_of_type_Int == 0) && (paramProfilePersonalityLabelInfo.unreadCount > 0)) {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007FCD", "0X8007FCD", 0, 0, "0", "0", "", "");
    }
  }
  
  private void b()
  {
    this.jdField_a_of_type_Float = getResources().getDisplayMetrics().density;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(getContext());
    this.jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams = new LinearLayout.LayoutParams(-1, -2);
    setOrientation(1);
    setLayoutParams(this.jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams);
  }
  
  private void c()
  {
    a(true);
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void a(ProfilePersonalityLabelInfo paramProfilePersonalityLabelInfo, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onGetPersonalityLabels isServer:");
      ((StringBuilder)localObject).append(paramBoolean1);
      ((StringBuilder)localObject).append(", scroll:");
      ((StringBuilder)localObject).append(paramBoolean2);
      ((StringBuilder)localObject).append(",");
      ((StringBuilder)localObject).append(paramProfilePersonalityLabelInfo.toString());
      QLog.i("PersonalityLabelBoard", 2, ((StringBuilder)localObject).toString());
    }
    if ((paramProfilePersonalityLabelInfo.getSize() > 0) && (this.jdField_a_of_type_AndroidViewView == null))
    {
      this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561354, this, false);
      this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelTagCloudTagCloudView = ((TagCloudView)this.jdField_a_of_type_AndroidViewView.findViewById(2131378266));
      this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131381333);
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131379974));
      this.c = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131379976));
      this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelTagCloudTagCloudView.setOnClickListener(this);
      this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelTagCloudTagCloudView.setMinHeight((int)(this.jdField_a_of_type_Float * 150.0F));
      this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelTagCloudTagCloudView.setThreshold((int)(this.jdField_a_of_type_Float * 7.5F));
    }
    else if ((paramProfilePersonalityLabelInfo.getSize() == 0) && (this.jdField_a_of_type_AndroidWidgetLinearLayout == null))
    {
      if (this.jdField_b_of_type_Boolean) {
        this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561355, this, false));
      } else {
        this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561356, this, false));
      }
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131379477));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131379478));
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentResColorStateList);
    }
    if (getChildCount() > 0) {
      localObject = getChildAt(0);
    } else {
      localObject = null;
    }
    if (paramProfilePersonalityLabelInfo.getSize() == 0)
    {
      if ((localObject == this.jdField_a_of_type_AndroidViewView) || (localObject == null))
      {
        removeAllViews();
        addView(this.jdField_a_of_type_AndroidWidgetLinearLayout);
      }
    }
    else
    {
      if ((localObject != this.jdField_a_of_type_AndroidWidgetLinearLayout) && (localObject != null))
      {
        if (localObject == this.jdField_a_of_type_AndroidViewView) {
          if (!paramProfilePersonalityLabelInfo.equals(this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelProfilePersonalityLabelInfo)) {
            a(paramProfilePersonalityLabelInfo);
          } else if (QLog.isColorLevel()) {
            QLog.i("PersonalityLabelBoard", 2, "onGetPersonalityLabels same data");
          }
        }
      }
      else
      {
        removeAllViews();
        addView(this.jdField_a_of_type_AndroidViewView);
        a(paramProfilePersonalityLabelInfo);
      }
      a(paramProfilePersonalityLabelInfo, paramBoolean1);
    }
    this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelProfilePersonalityLabelInfo = paramProfilePersonalityLabelInfo;
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    Object localObject = new Intent(getContext(), PersonalityLabelGalleryActivity.class);
    ((Intent)localObject).putExtra("fromType", 0);
    ((Intent)localObject).putExtra("uin", this.jdField_b_of_type_JavaLangString);
    if ((this.jdField_a_of_type_Int == 1) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))) {
      ((Intent)localObject).putExtra("nickname", this.jdField_a_of_type_JavaLangString);
    }
    ((Activity)getContext()).startActivityForResult((Intent)localObject, 1029);
    if (paramBoolean)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007FCB", "0X8007FCB", 0, 0, "0", "0", "", "");
      localObject = this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelProfilePersonalityLabelInfo;
      if ((localObject != null) && (((ProfilePersonalityLabelInfo)localObject).unreadCount > 0)) {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007FCE", "0X8007FCE", 0, 0, "0", "0", "", "");
      }
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    return false;
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.jdField_b_of_type_AndroidViewView) {
      if (this.jdField_a_of_type_Int == 0)
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80081D7", "0X80081D7", 0, 0, "", "", "", "");
        Object localObject = new Intent(getContext(), QQBrowserActivity.class);
        ((Intent)localObject).putExtra("url", "https://ti.qq.com/cgi-node/specialtag/zanlist?_wv=1027&asyncMode=3");
        getContext().startActivity((Intent)localObject);
        localObject = this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelProfilePersonalityLabelInfo;
        ((ProfilePersonalityLabelInfo)localObject).praiseCount += this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelProfilePersonalityLabelInfo.unreadCount;
        localObject = this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelProfilePersonalityLabelInfo;
        ((ProfilePersonalityLabelInfo)localObject).unreadCount = 0;
        if (((ProfilePersonalityLabelInfo)localObject).praiseCount <= 0) {
          break label216;
        }
        postDelayed(new PersonalityLabelBoard.1(this), 500L);
      }
      else
      {
        c();
      }
    }
    if (paramView == this.jdField_a_of_type_AndroidWidgetButton)
    {
      ProfileCardUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)getContext(), true);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007FCC", "0X8007FCC", 0, 0, "0", "0", "", "");
    }
    else if (paramView == this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelTagCloudTagCloudView)
    {
      c();
    }
    label216:
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void setIsNormalTheme(boolean paramBoolean)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setIsNormalTheme:");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append(" old:");
      ((StringBuilder)localObject).append(this.jdField_b_of_type_Boolean);
      QLog.i("PersonalityLabelBoard", 2, ((StringBuilder)localObject).toString());
    }
    if (this.jdField_b_of_type_Boolean != paramBoolean)
    {
      this.jdField_b_of_type_Boolean = paramBoolean;
      if (getChildCount() > 0) {
        localObject = getChildAt(0);
      } else {
        localObject = null;
      }
      LinearLayout localLinearLayout = this.jdField_a_of_type_AndroidWidgetLinearLayout;
      if (localLinearLayout != null)
      {
        if (this.jdField_b_of_type_Boolean) {
          this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561355, this, false));
        } else {
          this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561356, this, false));
        }
        this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131379477));
        this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
        this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131379478));
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentResColorStateList);
      }
      if ((localObject != null) && (localObject == localLinearLayout))
      {
        removeAllViews();
        addView(this.jdField_a_of_type_AndroidWidgetLinearLayout);
      }
    }
  }
  
  public void setNick(String paramString)
  {
    if (!TextUtils.equals(paramString, this.jdField_a_of_type_JavaLangString)) {
      this.jdField_a_of_type_JavaLangString = paramString;
    }
  }
  
  public void setPersonalityLabelComponent(ProfilePersonalityLabelComponent paramProfilePersonalityLabelComponent)
  {
    this.jdField_a_of_type_ComTencentMobileqqProfilecardBussinessPersonalitylabelProfilePersonalityLabelComponent = paramProfilePersonalityLabelComponent;
  }
  
  public void setTextColors(ColorStateList paramColorStateList)
  {
    this.jdField_a_of_type_AndroidContentResColorStateList = paramColorStateList;
    paramColorStateList = this.jdField_a_of_type_AndroidWidgetTextView;
    if (paramColorStateList != null) {
      paramColorStateList.setTextColor(this.jdField_a_of_type_AndroidContentResColorStateList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelBoard
 * JD-Core Version:    0.7.0.1
 */