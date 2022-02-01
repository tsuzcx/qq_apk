package com.tencent.mobileqq.freshnews;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.common.config.AppSetting;
import com.tencent.devicelib.DeviceLib;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.dating.widget.InputBar;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonPanel;
import com.tencent.mobileqq.troop.activity.TroopBarPublishUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.InputMethodUtil;
import com.tencent.widget.XEditTextEx;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QQInputView
  extends RelativeLayout
  implements TextWatcher, View.OnClickListener, EmoticonCallback
{
  private int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long = 0L;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler();
  private Button jdField_a_of_type_AndroidWidgetButton;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private InputBar jdField_a_of_type_ComTencentMobileqqDatingWidgetInputBar;
  private SystemAndEmojiEmoticonPanel jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel;
  private QQInputView.IQQInputCallback jdField_a_of_type_ComTencentMobileqqFreshnewsQQInputView$IQQInputCallback;
  private XEditTextEx jdField_a_of_type_ComTencentWidgetXEditTextEx;
  private boolean jdField_a_of_type_Boolean = false;
  private int b = 50;
  private int c = 0;
  private int d = 0;
  private int e = 0;
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
    InputMethodUtil.b(this.jdField_a_of_type_ComTencentWidgetXEditTextEx);
    if (this.c == this.d)
    {
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new QQInputView.3(this), 50L);
      return;
    }
    this.jdField_a_of_type_Boolean = true;
  }
  
  private void a(Context paramContext)
  {
    ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(2131561104, this, true);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = ((BaseActivity)paramContext);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131366114));
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx = ((XEditTextEx)super.findViewById(2131368874));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131377197));
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)super.findViewById(2131369784));
    this.jdField_a_of_type_ComTencentMobileqqDatingWidgetInputBar = ((InputBar)super.findViewById(2131368875));
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel = TroopBarPublishUtils.a(getContext(), this.jdField_a_of_type_AndroidWidgetFrameLayout, this.jdField_a_of_type_ComTencentWidgetXEditTextEx, this);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.addTextChangedListener(this);
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setOnClickListener(this);
    if (AppSetting.d)
    {
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setContentDescription(HardCodeUtil.a(2131710349));
      this.jdField_a_of_type_AndroidWidgetButton.setContentDescription(HardCodeUtil.a(2131710345));
    }
    DeviceLib.a(getContext(), this.jdField_a_of_type_ComTencentWidgetXEditTextEx);
  }
  
  private void b()
  {
    String str = this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString();
    str = Pattern.compile("\n").matcher(str).replaceAll("");
    str = Pattern.compile("^ +").matcher(str).replaceAll("");
    str = Pattern.compile(" +$").matcher(str).replaceAll("");
    if (!a(str.length())) {
      return;
    }
    QQInputView.IQQInputCallback localIQQInputCallback = this.jdField_a_of_type_ComTencentMobileqqFreshnewsQQInputView$IQQInputCallback;
    if (localIQQInputCallback != null) {
      localIQQInputCallback.b(str);
    }
  }
  
  private void c()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130848134);
    if (AppSetting.d) {
      this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(HardCodeUtil.a(2131710346));
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
  
  public boolean a(int paramInt)
  {
    return true;
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
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void delete()
  {
    com.tencent.mobileqq.text.TextUtils.backspace(this.jdField_a_of_type_ComTencentWidgetXEditTextEx);
  }
  
  public void emoticonMall() {}
  
  public void onClick(View paramView)
  {
    if (paramView != null) {
      if (paramView == this.jdField_a_of_type_AndroidWidgetImageView)
      {
        if (System.currentTimeMillis() - this.jdField_a_of_type_Long >= 500L)
        {
          this.jdField_a_of_type_Long = System.currentTimeMillis();
          if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel.getVisibility() == 8) {
            this.jdField_a_of_type_Int = 1;
          } else {
            this.jdField_a_of_type_Int = 0;
          }
          QQInputView.IQQInputCallback localIQQInputCallback = this.jdField_a_of_type_ComTencentMobileqqFreshnewsQQInputView$IQQInputCallback;
          if (localIQQInputCallback != null) {
            localIQQInputCallback.b();
          }
          a();
        }
      }
      else if (paramView == this.jdField_a_of_type_AndroidWidgetButton) {
        b();
      } else if (paramView == this.jdField_a_of_type_ComTencentWidgetXEditTextEx) {
        a(0);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onHidePopup(EmoticonInfo paramEmoticonInfo) {}
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    paramInt1 = this.jdField_a_of_type_ComTencentMobileqqDatingWidgetInputBar.getBottom();
    paramInt2 = this.jdField_a_of_type_ComTencentMobileqqDatingWidgetInputBar.getTop();
    if (paramInt2 <= 0) {
      return;
    }
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onLayout.bottom=");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(",top=");
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append(",mFistBottom");
      ((StringBuilder)localObject).append(this.d);
      ((StringBuilder)localObject).append(" mLastBottom=");
      ((StringBuilder)localObject).append(this.c);
      ((StringBuilder)localObject).append(",mFirstTop=");
      ((StringBuilder)localObject).append(this.e);
      ((StringBuilder)localObject).append(",mLastTop=");
      ((StringBuilder)localObject).append(this.f);
      QLog.d("input", 2, ((StringBuilder)localObject).toString());
    }
    if (this.d == 0) {
      this.d = paramInt1;
    }
    if (this.e == 0) {
      this.e = paramInt2;
    }
    if ((paramBoolean) && (paramInt4 == this.d) && (this.c < paramInt4))
    {
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Boolean = false;
        post(new QQInputView.4(this));
      }
    }
    else if ((paramInt2 == this.e) && (paramInt2 > this.f))
    {
      if (QLog.isColorLevel()) {
        QLog.d("input", 2, "inputview hide");
      }
      if (this.jdField_a_of_type_ComTencentMobileqqFreshnewsQQInputView$IQQInputCallback != null)
      {
        localObject = this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString();
        localObject = Pattern.compile("\n").matcher((CharSequence)localObject).replaceAll("");
        localObject = Pattern.compile("^ +").matcher((CharSequence)localObject).replaceAll("");
        localObject = Pattern.compile(" +$").matcher((CharSequence)localObject).replaceAll("");
        paramInt3 = ((String)localObject).length();
        if ((paramInt3 == 0) || (paramInt3 < 0) || (paramInt3 > this.b)) {
          localObject = "";
        }
        this.jdField_a_of_type_ComTencentMobileqqFreshnewsQQInputView$IQQInputCallback.a((String)localObject);
      }
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setHint(a());
      c();
    }
    else
    {
      paramInt3 = this.f;
      if ((paramInt3 == this.e) && (paramInt2 != paramInt3))
      {
        if (QLog.isColorLevel()) {
          QLog.d("input", 2, "inputview show");
        }
        if (android.text.TextUtils.isEmpty(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString()))
        {
          localObject = null;
          QQInputView.IQQInputCallback localIQQInputCallback = this.jdField_a_of_type_ComTencentMobileqqFreshnewsQQInputView$IQQInputCallback;
          if (localIQQInputCallback != null) {
            localObject = localIQQInputCallback.b();
          }
          if (!android.text.TextUtils.isEmpty((CharSequence)localObject))
          {
            this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setHint((CharSequence)localObject);
            this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
            this.jdField_a_of_type_AndroidWidgetButton.setSelected(false);
          }
        }
        localObject = this.jdField_a_of_type_ComTencentMobileqqFreshnewsQQInputView$IQQInputCallback;
        if (localObject != null) {
          ((QQInputView.IQQInputCallback)localObject).a();
        }
      }
      else if (paramInt2 != this.f)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqFreshnewsQQInputView$IQQInputCallback;
        if (localObject != null) {
          ((QQInputView.IQQInputCallback)localObject).a(paramInt2);
        }
      }
    }
    this.c = paramInt1;
    this.f = paramInt2;
  }
  
  public boolean onLongClick(EmoticonInfo paramEmoticonInfo)
  {
    return false;
  }
  
  public void onShowPopup(EmoticonInfo paramEmoticonInfo1, EmoticonInfo paramEmoticonInfo2, Drawable paramDrawable) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void send() {}
  
  public void send(EmoticonInfo paramEmoticonInfo)
  {
    String str;
    if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText() == null) {
      str = null;
    } else {
      str = this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString();
    }
    if ((android.text.TextUtils.isEmpty(str)) || ((!android.text.TextUtils.isEmpty(str)) && (str.length() < 49))) {
      paramEmoticonInfo.send(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentWidgetXEditTextEx, null);
    }
  }
  
  public void setCallback(QQInputView.IQQInputCallback paramIQQInputCallback)
  {
    this.jdField_a_of_type_ComTencentMobileqqFreshnewsQQInputView$IQQInputCallback = paramIQQInputCallback;
    this.jdField_a_of_type_AndroidOsHandler.post(new QQInputView.1(this));
  }
  
  public void setContentMaxLength(int paramInt)
  {
    this.b = paramInt;
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setFilters(new InputFilter[] { new InputFilter.LengthFilter(paramInt) });
  }
  
  public void setHintTextColor(int paramInt)
  {
    XEditTextEx localXEditTextEx = this.jdField_a_of_type_ComTencentWidgetXEditTextEx;
    if (localXEditTextEx != null) {
      localXEditTextEx.setHintTextColor(paramInt);
    }
  }
  
  public void setting() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.freshnews.QQInputView
 * JD-Core Version:    0.7.0.1
 */