package com.tencent.mobileqq.gamecenter.view;

import ajya;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import aqsv;
import aqtl;
import aqtm;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;

public class QQGameStatusView
  extends LinearLayout
{
  private int jdField_a_of_type_Int = 2;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private aqtm jdField_a_of_type_Aqtm;
  private ScrollTextView jdField_a_of_type_ComTencentMobileqqGamecenterViewScrollTextView;
  private String jdField_a_of_type_JavaLangString = "";
  private boolean jdField_a_of_type_Boolean;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private String jdField_b_of_type_JavaLangString = "";
  
  public QQGameStatusView(Context paramContext)
  {
    super(paramContext);
    c();
  }
  
  public QQGameStatusView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    c();
  }
  
  private void c()
  {
    LayoutInflater.from(getContext()).inflate(2131559080, this);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131367964));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378192));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131368909));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378046));
    this.jdField_b_of_type_AndroidWidgetTextView.setText(ajya.a(2131710333));
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(new aqtl(this));
  }
  
  private void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqGamecenterViewScrollTextView = new ScrollTextView(getContext());
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    this.jdField_a_of_type_ComTencentMobileqqGamecenterViewScrollTextView.setId(2131378009);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeAllViews();
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentMobileqqGamecenterViewScrollTextView, localLayoutParams);
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_AndroidWidgetTextView.setText("等待中");
  }
  
  public void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.jdField_b_of_type_JavaLangString = paramString;
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    if (!paramString.equals(this.jdField_a_of_type_JavaLangString)) {
      return;
    }
    paramString = "";
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(paramString);
      this.jdField_a_of_type_Int = paramInt;
      return;
      paramString = ajya.a(2131710335);
      a(true);
      continue;
      paramString = ajya.a(2131710337);
      a(true);
      continue;
      paramString = ajya.a(2131710339);
      a(true);
      continue;
      paramString = ajya.a(2131710341);
      a(true);
      continue;
      paramString = ajya.a(2131710334);
      a(true);
      continue;
      paramString = ajya.a(2131710340);
      a(false);
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    if ((this.jdField_a_of_type_Int == 5) && (this.jdField_a_of_type_JavaLangString.equals(paramString1))) {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(paramString2 + "%");
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String[] paramArrayOfString, int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130846170);
    this.jdField_a_of_type_AndroidWidgetTextView.setText("");
    d();
    this.jdField_b_of_type_AndroidWidgetTextView.setText(ajya.a(2131710338));
    this.jdField_a_of_type_Int = 2;
    a(true);
    this.jdField_a_of_type_Boolean = false;
    if (!TextUtils.isEmpty(paramString2))
    {
      paramString1 = URLDrawable.URLDrawableOptions.obtain();
      paramString1.mLoadingDrawable = getResources().getDrawable(2130846170);
      paramString1.mFailedDrawable = getResources().getDrawable(2130846170);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(URLDrawable.getDrawable(paramString2, paramString1));
    }
    if (!TextUtils.isEmpty(paramString2)) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString3 + "");
    }
    this.jdField_a_of_type_ComTencentMobileqqGamecenterViewScrollTextView.setShowPriority(paramBoolean);
    this.jdField_a_of_type_ComTencentMobileqqGamecenterViewScrollTextView.removeAllViews();
    this.jdField_a_of_type_ComTencentMobileqqGamecenterViewScrollTextView.setFactory(this.jdField_a_of_type_ComTencentMobileqqGamecenterViewScrollTextView);
    this.jdField_a_of_type_ComTencentMobileqqGamecenterViewScrollTextView.setInterSwitcTime(2000L);
    this.jdField_a_of_type_ComTencentMobileqqGamecenterViewScrollTextView.setText("");
    if ((paramArrayOfString != null) && (paramArrayOfString.length > 0)) {
      this.jdField_a_of_type_ComTencentMobileqqGamecenterViewScrollTextView.setTextArray(paramArrayOfString);
    }
    while (paramInt <= 0) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqGamecenterViewScrollTextView.setText(paramInt + ajya.a(2131710342));
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setBackgroundDrawable(aqsv.a(new ColorDrawable(-16776961), new ColorDrawable(-16776961), "https://cmshow.gtimg.cn/client/gameCenter/gameCenter_headerImage_button_big@2x.png", "https://cmshow.gtimg.cn/client/gameCenter/gameCenter_headerImage_button_big_click@2x.png"));
      return;
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setBackgroundDrawable(aqsv.a(new ColorDrawable(Color.parseColor("#fdb106")), new ColorDrawable(Color.parseColor("#fdb106")), "https://i.gtimg.cn/channel/imglib/201908/upload_054783d98dd3b4888304e66fa1f8e7fa.png", "https://i.gtimg.cn/channel/imglib/201908/upload_054783d98dd3b4888304e66fa1f8e7fa.png"));
  }
  
  public void b()
  {
    this.jdField_a_of_type_Boolean = false;
    a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
  }
  
  public void setListener(aqtm paramaqtm)
  {
    this.jdField_a_of_type_Aqtm = paramaqtm;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.view.QQGameStatusView
 * JD-Core Version:    0.7.0.1
 */