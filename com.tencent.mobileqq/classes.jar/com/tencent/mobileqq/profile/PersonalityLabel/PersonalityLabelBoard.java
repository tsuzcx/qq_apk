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
import azez;
import azoi;
import bcst;
import bghy;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.profile.PersonalityLabel.tagCloud.TagCloudView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

public class PersonalityLabelBoard
  extends LinearLayout
  implements Handler.Callback, View.OnClickListener
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
  private azoi jdField_a_of_type_Azoi;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  PersonalityLabel jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabel;
  public TagCloudView a;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
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
  
  private void a(PersonalityLabel paramPersonalityLabel)
  {
    ArrayList localArrayList = new ArrayList(paramPersonalityLabel.getSize());
    URLDrawable localURLDrawable = null;
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2131165438);
    }
    String str = paramPersonalityLabel.getLatestThumbUrl();
    if (!TextUtils.isEmpty(str)) {
      localURLDrawable = URLDrawable.getDrawable(str, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    }
    azez.a(localArrayList, paramPersonalityLabel, this.jdField_a_of_type_Float);
    this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelTagCloudTagCloudView.setTags(localArrayList);
    this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelTagCloudTagCloudView.setTagIcon(localURLDrawable);
    if (AppSetting.c)
    {
      paramPersonalityLabel = new StringBuilder();
      paramPersonalityLabel.append("个性标签");
      this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelTagCloudTagCloudView.setContentDescription(paramPersonalityLabel.toString());
    }
  }
  
  private void a(PersonalityLabel paramPersonalityLabel, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Int == 1) {}
    for (int i = paramPersonalityLabel.praiseCount + paramPersonalityLabel.unreadCount; (i <= 0) && (paramPersonalityLabel.unreadCount <= 0); i = paramPersonalityLabel.praiseCount)
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
    if (this.jdField_a_of_type_Int == 0) {
      if (paramPersonalityLabel.unreadCount <= 0) {
        if (this.c.getVisibility() != 8) {
          this.c.setVisibility(8);
        }
      }
    }
    for (;;)
    {
      if (AppSetting.c)
      {
        localStringBuilder.delete(0, localStringBuilder.length());
        localStringBuilder.append("个性标签").append("，").append(this.jdField_b_of_type_AndroidWidgetTextView.getText());
        if (this.jdField_a_of_type_Int == 0)
        {
          if (paramPersonalityLabel.unreadCount > 0) {
            localStringBuilder.append("，").append("新增").append(paramPersonalityLabel.unreadCount).append("个赞");
          }
          localStringBuilder.append("，").append("点按两次查看");
        }
        this.jdField_b_of_type_AndroidViewView.setContentDescription(localStringBuilder.toString());
      }
      if ((!paramBoolean) || (this.jdField_a_of_type_Int != 0) || (paramPersonalityLabel.unreadCount <= 0)) {
        break;
      }
      bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007FCD", "0X8007FCD", 0, 0, "0", "0", "", "");
      return;
      if (this.c.getVisibility() != 0) {
        this.c.setVisibility(0);
      }
      localStringBuilder.delete(0, localStringBuilder.length());
      localStringBuilder.append("+");
      localStringBuilder.append(paramPersonalityLabel.unreadCount);
      if (!TextUtils.equals(this.c.getText(), localStringBuilder))
      {
        this.c.setText(localStringBuilder);
        continue;
        if (this.c.getVisibility() != 8) {
          this.c.setVisibility(8);
        }
      }
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
  
  public void a(PersonalityLabel paramPersonalityLabel, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PersonalityLabelBoard", 2, "onGetPersonalityLabels isServer:" + paramBoolean1 + ", scroll:" + paramBoolean2 + "," + paramPersonalityLabel.toString());
    }
    if ((paramPersonalityLabel.getSize() > 0) && (this.jdField_a_of_type_AndroidViewView == null))
    {
      this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561419, this, false);
      this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelTagCloudTagCloudView = ((TagCloudView)this.jdField_a_of_type_AndroidViewView.findViewById(2131378234));
      this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131381395);
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131380005));
      this.c = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131380007));
      this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelTagCloudTagCloudView.setOnClickListener(this);
      this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelTagCloudTagCloudView.setMinHeight((int)(this.jdField_a_of_type_Float * 150.0F));
      this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelTagCloudTagCloudView.setThreshold((int)(this.jdField_a_of_type_Float * 7.5F));
      if (getChildCount() <= 0) {
        break label370;
      }
    }
    label370:
    for (View localView = getChildAt(0);; localView = null)
    {
      if (paramPersonalityLabel.getSize() != 0) {
        break label376;
      }
      if ((localView == this.jdField_a_of_type_AndroidViewView) || (localView == null))
      {
        removeAllViews();
        addView(this.jdField_a_of_type_AndroidWidgetLinearLayout);
      }
      this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabel = paramPersonalityLabel;
      return;
      if ((paramPersonalityLabel.getSize() != 0) || (this.jdField_a_of_type_AndroidWidgetLinearLayout != null)) {
        break;
      }
      if (this.jdField_b_of_type_Boolean) {}
      for (this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561420, this, false));; this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561421, this, false)))
      {
        this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131379470));
        this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
        this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131379471));
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentResColorStateList);
        break;
      }
    }
    label376:
    if ((localView == this.jdField_a_of_type_AndroidWidgetLinearLayout) || (localView == null))
    {
      removeAllViews();
      addView(this.jdField_a_of_type_AndroidViewView);
      a(paramPersonalityLabel);
    }
    for (;;)
    {
      a(paramPersonalityLabel, paramBoolean1);
      break;
      if (localView == this.jdField_a_of_type_AndroidViewView) {
        if (!paramPersonalityLabel.equals(this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabel)) {
          a(paramPersonalityLabel);
        } else if (QLog.isColorLevel()) {
          QLog.i("PersonalityLabelBoard", 2, "onGetPersonalityLabels same data");
        }
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Boolean) {}
    do
    {
      do
      {
        return;
        this.jdField_a_of_type_Boolean = true;
        Intent localIntent = new Intent(getContext(), PersonalityLabelGalleryActivity.class);
        localIntent.putExtra("fromType", 0);
        localIntent.putExtra("uin", this.jdField_b_of_type_JavaLangString);
        if ((this.jdField_a_of_type_Int == 1) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))) {
          localIntent.putExtra("nickname", this.jdField_a_of_type_JavaLangString);
        }
        ((Activity)getContext()).startActivityForResult(localIntent, 1029);
      } while (!paramBoolean);
      bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007FCB", "0X8007FCB", 0, 0, "0", "0", "", "");
    } while ((this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabel == null) || (this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabel.unreadCount <= 0));
    bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007FCE", "0X8007FCE", 0, 0, "0", "0", "", "");
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    return false;
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.jdField_b_of_type_AndroidViewView)
    {
      if (this.jdField_a_of_type_Int != 0) {
        break label217;
      }
      bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80081D7", "0X80081D7", 0, 0, "", "", "", "");
      Object localObject = new Intent(getContext(), QQBrowserActivity.class);
      ((Intent)localObject).putExtra("url", "https://ti.qq.com/cgi-node/specialtag/zanlist?_wv=1027&asyncMode=3");
      getContext().startActivity((Intent)localObject);
      localObject = this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabel;
      ((PersonalityLabel)localObject).praiseCount += this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabel.unreadCount;
      this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabel.unreadCount = 0;
      if (this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabel.praiseCount > 0) {}
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      postDelayed(new PersonalityLabelBoard.1(this), 500L);
      if (this.jdField_a_of_type_Azoi != null) {
        this.jdField_a_of_type_Azoi.a();
      }
      for (;;)
      {
        if (paramView != this.jdField_a_of_type_AndroidWidgetButton) {
          break label224;
        }
        bghy.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)getContext(), true);
        bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007FCC", "0X8007FCC", 0, 0, "0", "0", "", "");
        break;
        label217:
        c();
      }
      label224:
      if (paramView == this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelTagCloudTagCloudView) {
        c();
      }
    }
  }
  
  public void setIsNormalTheme(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PersonalityLabelBoard", 2, "setIsNormalTheme:" + paramBoolean + " old:" + this.jdField_b_of_type_Boolean);
    }
    View localView;
    LinearLayout localLinearLayout;
    if (this.jdField_b_of_type_Boolean != paramBoolean)
    {
      this.jdField_b_of_type_Boolean = paramBoolean;
      if (getChildCount() <= 0) {
        break label182;
      }
      localView = getChildAt(0);
      localLinearLayout = this.jdField_a_of_type_AndroidWidgetLinearLayout;
      if (localLinearLayout != null) {
        if (!this.jdField_b_of_type_Boolean) {
          break label187;
        }
      }
    }
    label182:
    label187:
    for (this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561420, this, false));; this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561421, this, false)))
    {
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131379470));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131379471));
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentResColorStateList);
      if ((localView != null) && (localView == localLinearLayout))
      {
        removeAllViews();
        addView(this.jdField_a_of_type_AndroidWidgetLinearLayout);
      }
      return;
      localView = null;
      break;
    }
  }
  
  public void setNick(String paramString)
  {
    if (!TextUtils.equals(paramString, this.jdField_a_of_type_JavaLangString)) {
      this.jdField_a_of_type_JavaLangString = paramString;
    }
  }
  
  public void setPersonalityLabelComponent(azoi paramazoi)
  {
    this.jdField_a_of_type_Azoi = paramazoi;
  }
  
  public void setTextColors(ColorStateList paramColorStateList)
  {
    this.jdField_a_of_type_AndroidContentResColorStateList = paramColorStateList;
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentResColorStateList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelBoard
 * JD-Core Version:    0.7.0.1
 */