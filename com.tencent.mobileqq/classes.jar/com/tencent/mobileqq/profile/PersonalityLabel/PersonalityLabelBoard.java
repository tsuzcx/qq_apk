package com.tencent.mobileqq.profile.PersonalityLabel;

import agsa;
import agsb;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.profile.PersonalityLabel.tagCloud.TagCloudView;
import com.tencent.mobileqq.profile.PersonalityLabel.tagCloud.TagUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.util.WeakReference;

public class PersonalityLabelBoard
  extends LinearLayout
  implements Handler.Callback, View.OnClickListener, OnGetPersonalityLabelsListener
{
  float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int = 0;
  ColorStateList jdField_a_of_type_AndroidContentResColorStateList = ColorStateList.valueOf(-16777216);
  Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
  protected LayoutInflater a;
  public View a;
  LinearLayout.LayoutParams jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public PersonalityLabel a;
  public TagCloudView a;
  Runnable jdField_a_of_type_JavaLangRunnable = new agsb(this);
  private String jdField_a_of_type_JavaLangString;
  public WeakReference a;
  private boolean jdField_a_of_type_Boolean;
  View jdField_b_of_type_AndroidViewView;
  public TextView b;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean = true;
  public View c;
  public TextView c;
  private TextView d;
  
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
  
  public PersonalityLabelBoard(Context paramContext, QQAppInterface paramQQAppInterface, String paramString, View paramView)
  {
    super(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidViewView = paramView;
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
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2131493236);
    }
    String str = paramPersonalityLabel.getLatestThumbUrl();
    if (!TextUtils.isEmpty(str)) {
      localURLDrawable = URLDrawable.getDrawable(str, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    }
    TagUtil.a(localArrayList, paramPersonalityLabel, this.jdField_a_of_type_Float);
    this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelTagCloudTagCloudView.setTags(localArrayList);
    this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelTagCloudTagCloudView.setTagIcon(localURLDrawable);
    if (AppSetting.jdField_b_of_type_Boolean)
    {
      paramPersonalityLabel = new StringBuilder();
      paramPersonalityLabel.append("个性标签").append("，").append("图片").append("，").append("点按两次查看");
      this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelTagCloudTagCloudView.setContentDescription(paramPersonalityLabel.toString());
    }
  }
  
  private void a(PersonalityLabel paramPersonalityLabel, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Int == 1) {}
    for (int i = paramPersonalityLabel.praiseCount + paramPersonalityLabel.unreadCount; (i <= 0) && (paramPersonalityLabel.unreadCount <= 0); i = paramPersonalityLabel.praiseCount)
    {
      if (this.jdField_c_of_type_AndroidViewView.getVisibility() != 8) {
        this.jdField_c_of_type_AndroidViewView.setVisibility(8);
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
    if (this.jdField_c_of_type_AndroidViewView.getVisibility() != 0) {
      this.jdField_c_of_type_AndroidViewView.setVisibility(0);
    }
    if (this.jdField_a_of_type_Int == 0) {
      if (paramPersonalityLabel.unreadCount <= 0) {
        if (this.jdField_c_of_type_AndroidWidgetTextView.getVisibility() != 8) {
          this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
        }
      }
    }
    for (;;)
    {
      if (AppSetting.jdField_b_of_type_Boolean)
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
        this.jdField_c_of_type_AndroidViewView.setContentDescription(localStringBuilder.toString());
      }
      if ((!paramBoolean) || (this.jdField_a_of_type_Int != 0) || (paramPersonalityLabel.unreadCount <= 0)) {
        break;
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007FCD", "0X8007FCD", 0, 0, "0", "0", "", "");
      return;
      if (this.jdField_c_of_type_AndroidWidgetTextView.getVisibility() != 0) {
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      }
      localStringBuilder.delete(0, localStringBuilder.length());
      localStringBuilder.append("+");
      localStringBuilder.append(paramPersonalityLabel.unreadCount);
      if (!TextUtils.equals(this.jdField_c_of_type_AndroidWidgetTextView.getText(), localStringBuilder))
      {
        this.jdField_c_of_type_AndroidWidgetTextView.setText(localStringBuilder);
        continue;
        if (this.jdField_c_of_type_AndroidWidgetTextView.getVisibility() != 8) {
          this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
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
    if (this.jdField_a_of_type_Boolean) {}
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
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007FCB", "0X8007FCB", 0, 0, "0", "0", "", "");
    } while ((this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabel == null) || (this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabel.unreadCount <= 0));
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007FCE", "0X8007FCE", 0, 0, "0", "0", "", "");
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
    if ((paramPersonalityLabel.getSize() > 0) && (this.jdField_b_of_type_AndroidViewView == null))
    {
      this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130970568, this, false);
      this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelTagCloudTagCloudView = ((TagCloudView)this.jdField_b_of_type_AndroidViewView.findViewById(2131371129));
      this.jdField_c_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131366690);
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131371130));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131371131));
      this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelTagCloudTagCloudView.setOnClickListener(this);
      this.jdField_c_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelTagCloudTagCloudView.setMinHeight((int)(this.jdField_a_of_type_Float * 150.0F));
      this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelTagCloudTagCloudView.setThreshold((int)(this.jdField_a_of_type_Float * 7.5F));
      if (getChildCount() <= 0) {
        break label410;
      }
    }
    label410:
    for (View localView = getChildAt(0);; localView = null)
    {
      if (paramPersonalityLabel.getSize() != 0) {
        break label416;
      }
      if ((localView == this.jdField_b_of_type_AndroidViewView) || (localView == null))
      {
        removeAllViews();
        addView(this.jdField_a_of_type_AndroidWidgetLinearLayout);
      }
      this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabel = paramPersonalityLabel;
      if ((paramBoolean2) && (this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabel.isCloseByUser == 0))
      {
        this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 100L);
      }
      return;
      if ((paramPersonalityLabel.getSize() != 0) || (this.jdField_a_of_type_AndroidWidgetLinearLayout != null)) {
        break;
      }
      if (this.jdField_b_of_type_Boolean) {}
      for (this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130970569, this, false));; this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130970570, this, false)))
      {
        this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131371124));
        this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
        this.d = ((TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131371122));
        this.d.setTextColor(this.jdField_a_of_type_AndroidContentResColorStateList);
        break;
      }
    }
    label416:
    if ((localView == this.jdField_a_of_type_AndroidWidgetLinearLayout) || (localView == null))
    {
      removeAllViews();
      addView(this.jdField_b_of_type_AndroidViewView);
      a(paramPersonalityLabel);
    }
    for (;;)
    {
      a(paramPersonalityLabel, paramBoolean1);
      break;
      if (localView == this.jdField_b_of_type_AndroidViewView) {
        if (!paramPersonalityLabel.equals(this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabel)) {
          a(paramPersonalityLabel);
        } else if (QLog.isColorLevel()) {
          QLog.i("PersonalityLabelBoard", 2, "onGetPersonalityLabels same data");
        }
      }
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    return false;
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.jdField_c_of_type_AndroidViewView)
    {
      if (this.jdField_a_of_type_Int != 0) {
        break label193;
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80081D7", "0X80081D7", 0, 0, "", "", "", "");
      Intent localIntent = new Intent(getContext(), QQBrowserActivity.class);
      localIntent.putExtra("url", "https://ti.qq.com/cgi-node/specialtag/zanlist?_wv=1027&asyncMode=3");
      getContext().startActivity(localIntent);
      if (this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabel.unreadCount > 0) {}
    }
    label193:
    do
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabel.unreadCount = 0;
      postDelayed(new agsa(this), 500L);
      if ((getContext() instanceof FriendProfileCardActivity)) {
        ((FriendProfileCardActivity)getContext()).d();
      }
      while (paramView == this.jdField_a_of_type_AndroidWidgetTextView)
      {
        ProfileCardUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)getContext(), true);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007FCC", "0X8007FCC", 0, 0, "0", "0", "", "");
        return;
        c();
      }
    } while (paramView != this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelTagCloudTagCloudView);
    c();
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
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
    for (this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130970569, this, false));; this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130970570, this, false)))
    {
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131371124));
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.d = ((TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131371122));
      this.d.setTextColor(this.jdField_a_of_type_AndroidContentResColorStateList);
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
  
  public void setScrollListener(PersonalityLabelBoard.IScroll paramIScroll)
  {
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramIScroll);
  }
  
  public void setTextColors(ColorStateList paramColorStateList)
  {
    this.jdField_a_of_type_AndroidContentResColorStateList = paramColorStateList;
    if (this.d != null) {
      this.d.setTextColor(this.jdField_a_of_type_AndroidContentResColorStateList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelBoard
 * JD-Core Version:    0.7.0.1
 */