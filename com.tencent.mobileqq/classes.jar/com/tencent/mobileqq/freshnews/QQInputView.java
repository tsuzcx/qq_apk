package com.tencent.mobileqq.freshnews;

import ajjy;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import anhs;
import anht;
import apql;
import axku;
import beex;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.dating.widget.InputBar;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonPanel;
import com.tencent.mobileqq.troop.activity.TroopBarPublishUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XEditTextEx;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import yes;

public class QQInputView
  extends RelativeLayout
  implements TextWatcher, View.OnClickListener, anhs
{
  private int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler();
  private Button jdField_a_of_type_AndroidWidgetButton;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private apql jdField_a_of_type_Apql;
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private InputBar jdField_a_of_type_ComTencentMobileqqDatingWidgetInputBar;
  private SystemAndEmojiEmoticonPanel jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel;
  private XEditTextEx jdField_a_of_type_ComTencentWidgetXEditTextEx;
  private boolean jdField_a_of_type_Boolean;
  private int b = 50;
  private int c;
  private int d;
  private int e;
  private int f = 2147483647;
  
  public QQInputView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public QQInputView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  private void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.requestFocus();
    if (this.jdField_a_of_type_Int == 0)
    {
      this.jdField_a_of_type_AndroidOsHandler.post(new QQInputView.2(this));
      return;
    }
    beex.b(this.jdField_a_of_type_ComTencentWidgetXEditTextEx);
    if (this.c == this.d)
    {
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new QQInputView.3(this), 50L);
      return;
    }
    this.jdField_a_of_type_Boolean = true;
  }
  
  private void a(Context paramContext)
  {
    ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(2131495204, this, true);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = ((BaseActivity)paramContext);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131299981));
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx = ((XEditTextEx)super.findViewById(2131302566));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131310076));
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)super.findViewById(2131303278));
    this.jdField_a_of_type_ComTencentMobileqqDatingWidgetInputBar = ((InputBar)super.findViewById(2131302567));
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel = TroopBarPublishUtils.a(getContext(), this.jdField_a_of_type_AndroidWidgetFrameLayout, this.jdField_a_of_type_ComTencentWidgetXEditTextEx, this);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.addTextChangedListener(this);
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setOnClickListener(this);
    if (AppSetting.c)
    {
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setContentDescription(ajjy.a(2131644610));
      this.jdField_a_of_type_AndroidWidgetButton.setContentDescription(ajjy.a(2131644606));
    }
    yes.a(getContext(), this.jdField_a_of_type_ComTencentWidgetXEditTextEx);
  }
  
  private void e()
  {
    String str = this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString();
    str = Pattern.compile("\n").matcher(str).replaceAll("");
    str = Pattern.compile("^ +").matcher(str).replaceAll("");
    str = Pattern.compile(" +$").matcher(str).replaceAll("");
    if (!a(str.length())) {}
    while (this.jdField_a_of_type_Apql == null) {
      return;
    }
    this.jdField_a_of_type_Apql.b(str);
  }
  
  private void f()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130846792);
    if (AppSetting.c) {
      this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(ajjy.a(2131644607));
    }
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel.setVisibility(8);
  }
  
  public String a()
  {
    return "";
  }
  
  public void a()
  {
    a(this.jdField_a_of_type_Int);
  }
  
  public void a(anht paramanht)
  {
    if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText() == null) {}
    for (Object localObject = null;; localObject = this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString())
    {
      if ((TextUtils.isEmpty((CharSequence)localObject)) || ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).length() < 49))) {
        paramanht.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentWidgetXEditTextEx, null);
      }
      return;
    }
  }
  
  public void a(anht paramanht1, anht paramanht2, Drawable paramDrawable) {}
  
  public boolean a(int paramInt)
  {
    return true;
  }
  
  public boolean a(anht paramanht)
  {
    return false;
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    paramEditable = this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString();
    paramEditable = Pattern.compile("\n").matcher(paramEditable).replaceAll("");
    paramEditable = Pattern.compile("^ +").matcher(paramEditable).replaceAll("");
    if (Pattern.compile(" +$").matcher(paramEditable).replaceAll("").length() > 0)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
      this.jdField_a_of_type_AndroidWidgetButton.setSelected(true);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
    this.jdField_a_of_type_AndroidWidgetButton.setSelected(false);
  }
  
  public void b()
  {
    axku.a(this.jdField_a_of_type_ComTencentWidgetXEditTextEx);
  }
  
  public void b(anht paramanht) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void c() {}
  
  public void d() {}
  
  public void onClick(View paramView)
  {
    if (paramView == null) {}
    do
    {
      do
      {
        return;
        if (paramView != this.jdField_a_of_type_AndroidWidgetImageView) {
          break;
        }
      } while (System.currentTimeMillis() - this.jdField_a_of_type_Long < 500L);
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel.getVisibility() == 8) {}
      for (this.jdField_a_of_type_Int = 1;; this.jdField_a_of_type_Int = 0)
      {
        if (this.jdField_a_of_type_Apql != null) {
          this.jdField_a_of_type_Apql.b();
        }
        a();
        return;
      }
      if (paramView == this.jdField_a_of_type_AndroidWidgetButton)
      {
        e();
        return;
      }
    } while (paramView != this.jdField_a_of_type_ComTencentWidgetXEditTextEx);
    a(0);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    paramInt1 = this.jdField_a_of_type_ComTencentMobileqqDatingWidgetInputBar.getBottom();
    paramInt2 = this.jdField_a_of_type_ComTencentMobileqqDatingWidgetInputBar.getTop();
    if (paramInt2 <= 0) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("input", 2, "onLayout.bottom=" + paramInt1 + ",top=" + paramInt2 + ",mFistBottom" + this.d + " mLastBottom=" + this.c + ",mFirstTop=" + this.e + ",mLastTop=" + this.f);
    }
    if (this.d == 0) {
      this.d = paramInt1;
    }
    if (this.e == 0) {
      this.e = paramInt2;
    }
    if ((paramBoolean) && (paramInt4 == this.d) && (this.c < paramInt4)) {
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Boolean = false;
        post(new QQInputView.4(this));
      }
    }
    for (;;)
    {
      this.c = paramInt1;
      this.f = paramInt2;
      return;
      String str;
      if ((paramInt2 == this.e) && (paramInt2 > this.f))
      {
        if (QLog.isColorLevel()) {
          QLog.d("input", 2, "inputview hide");
        }
        if (this.jdField_a_of_type_Apql != null)
        {
          str = this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString();
          str = Pattern.compile("\n").matcher(str).replaceAll("");
          str = Pattern.compile("^ +").matcher(str).replaceAll("");
          str = Pattern.compile(" +$").matcher(str).replaceAll("");
          paramInt3 = str.length();
          if ((paramInt3 == 0) || (paramInt3 < 0) || (paramInt3 > this.b)) {
            str = "";
          }
          this.jdField_a_of_type_Apql.a(str);
        }
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setHint(a());
        f();
      }
      else if ((this.f == this.e) && (paramInt2 != this.f))
      {
        if (QLog.isColorLevel()) {
          QLog.d("input", 2, "inputview show");
        }
        if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString()))
        {
          str = null;
          if (this.jdField_a_of_type_Apql != null) {
            str = this.jdField_a_of_type_Apql.b();
          }
          if (!TextUtils.isEmpty(str))
          {
            this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setHint(str);
            this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
            this.jdField_a_of_type_AndroidWidgetButton.setSelected(false);
          }
        }
        if (this.jdField_a_of_type_Apql != null) {
          this.jdField_a_of_type_Apql.aV_();
        }
      }
      else if ((paramInt2 != this.f) && (this.jdField_a_of_type_Apql != null))
      {
        this.jdField_a_of_type_Apql.a(paramInt2);
      }
    }
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void setCallback(apql paramapql)
  {
    this.jdField_a_of_type_Apql = paramapql;
    this.jdField_a_of_type_AndroidOsHandler.post(new QQInputView.1(this));
  }
  
  public void setContentMaxLength(int paramInt)
  {
    this.b = paramInt;
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setFilters(new InputFilter[] { new InputFilter.LengthFilter(paramInt) });
  }
  
  public void setHintTextColor(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx != null) {
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setHintTextColor(paramInt);
    }
  }
  
  public void setting() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.freshnews.QQInputView
 * JD-Core Version:    0.7.0.1
 */