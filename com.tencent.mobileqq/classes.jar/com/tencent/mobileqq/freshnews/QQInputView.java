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
  private InputBar a;
  private ImageView b;
  private XEditTextEx c;
  private Button d;
  private FrameLayout e;
  private long f = 0L;
  private Handler g = new Handler();
  private BaseActivity h;
  private SystemAndEmojiEmoticonPanel i;
  private QQInputView.IQQInputCallback j;
  private int k = 0;
  private boolean l = false;
  private int m = 50;
  private int n = 0;
  private int o = 0;
  private int p = 0;
  private int q = 2147483647;
  
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
  
  private void a()
  {
    String str = this.c.getText().toString();
    str = Pattern.compile("\n").matcher(str).replaceAll("");
    str = Pattern.compile("^ +").matcher(str).replaceAll("");
    str = Pattern.compile(" +$").matcher(str).replaceAll("");
    if (!a(str.length())) {
      return;
    }
    QQInputView.IQQInputCallback localIQQInputCallback = this.j;
    if (localIQQInputCallback != null) {
      localIQQInputCallback.b(str);
    }
  }
  
  private void a(Context paramContext)
  {
    ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(2131627454, this, true);
    this.h = ((BaseActivity)paramContext);
    this.b = ((ImageView)super.findViewById(2131432400));
    this.c = ((XEditTextEx)super.findViewById(2131435808));
    this.d = ((Button)super.findViewById(2131445580));
    this.e = ((FrameLayout)super.findViewById(2131436914));
    this.a = ((InputBar)super.findViewById(2131435809));
    this.i = TroopBarPublishUtils.a(getContext(), this.e, this.c, this);
    this.b.setOnClickListener(this);
    this.d.setOnClickListener(this);
    this.c.addTextChangedListener(this);
    this.c.setOnClickListener(this);
    if (AppSetting.e)
    {
      this.c.setContentDescription(HardCodeUtil.a(2131908040));
      this.d.setContentDescription(HardCodeUtil.a(2131908036));
    }
    DeviceLib.a(getContext(), this.c);
  }
  
  private void b()
  {
    this.k = 0;
    this.b.setImageResource(2130849798);
    if (AppSetting.e) {
      this.b.setContentDescription(HardCodeUtil.a(2131908037));
    }
    this.i.setVisibility(8);
  }
  
  private void b(int paramInt)
  {
    this.k = paramInt;
    this.c.requestFocus();
    if (this.k == 0)
    {
      this.g.post(new QQInputView.2(this));
      return;
    }
    InputMethodUtil.b(this.c);
    if (this.n == this.o)
    {
      this.g.postDelayed(new QQInputView.3(this), 50L);
      return;
    }
    this.l = true;
  }
  
  public boolean a(int paramInt)
  {
    return true;
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    paramEditable = this.c.getText().toString();
    paramEditable = Pattern.compile("\n").matcher(paramEditable).replaceAll("");
    paramEditable = Pattern.compile("^ +").matcher(paramEditable).replaceAll("");
    if (Pattern.compile(" +$").matcher(paramEditable).replaceAll("").length() > 0)
    {
      this.d.setEnabled(true);
      this.d.setSelected(true);
      return;
    }
    this.d.setEnabled(false);
    this.d.setSelected(false);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void delete()
  {
    com.tencent.mobileqq.text.TextUtils.backspace(this.c);
  }
  
  public void emoticonMall() {}
  
  public String getContent()
  {
    return this.c.getText().toString();
  }
  
  public void getFocus()
  {
    b(this.k);
  }
  
  public String getHint()
  {
    return "";
  }
  
  public void onClick(View paramView)
  {
    if (paramView != null) {
      if (paramView == this.b)
      {
        if (System.currentTimeMillis() - this.f >= 500L)
        {
          this.f = System.currentTimeMillis();
          if (this.i.getVisibility() == 8) {
            this.k = 1;
          } else {
            this.k = 0;
          }
          QQInputView.IQQInputCallback localIQQInputCallback = this.j;
          if (localIQQInputCallback != null) {
            localIQQInputCallback.d();
          }
          getFocus();
        }
      }
      else if (paramView == this.d) {
        a();
      } else if (paramView == this.c) {
        b(0);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onHidePopup(EmoticonInfo paramEmoticonInfo) {}
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    paramInt1 = this.a.getBottom();
    paramInt2 = this.a.getTop();
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
      ((StringBuilder)localObject).append(this.o);
      ((StringBuilder)localObject).append(" mLastBottom=");
      ((StringBuilder)localObject).append(this.n);
      ((StringBuilder)localObject).append(",mFirstTop=");
      ((StringBuilder)localObject).append(this.p);
      ((StringBuilder)localObject).append(",mLastTop=");
      ((StringBuilder)localObject).append(this.q);
      QLog.d("input", 2, ((StringBuilder)localObject).toString());
    }
    if (this.o == 0) {
      this.o = paramInt1;
    }
    if (this.p == 0) {
      this.p = paramInt2;
    }
    if ((paramBoolean) && (paramInt4 == this.o) && (this.n < paramInt4))
    {
      if (this.l)
      {
        this.l = false;
        post(new QQInputView.4(this));
      }
    }
    else if ((paramInt2 == this.p) && (paramInt2 > this.q))
    {
      if (QLog.isColorLevel()) {
        QLog.d("input", 2, "inputview hide");
      }
      if (this.j != null)
      {
        localObject = this.c.getText().toString();
        localObject = Pattern.compile("\n").matcher((CharSequence)localObject).replaceAll("");
        localObject = Pattern.compile("^ +").matcher((CharSequence)localObject).replaceAll("");
        localObject = Pattern.compile(" +$").matcher((CharSequence)localObject).replaceAll("");
        paramInt3 = ((String)localObject).length();
        if ((paramInt3 == 0) || (paramInt3 < 0) || (paramInt3 > this.m)) {
          localObject = "";
        }
        this.j.a((String)localObject);
      }
      this.c.setHint(getHint());
      b();
    }
    else
    {
      paramInt3 = this.q;
      if ((paramInt3 == this.p) && (paramInt2 != paramInt3))
      {
        if (QLog.isColorLevel()) {
          QLog.d("input", 2, "inputview show");
        }
        if (android.text.TextUtils.isEmpty(this.c.getText().toString()))
        {
          localObject = null;
          QQInputView.IQQInputCallback localIQQInputCallback = this.j;
          if (localIQQInputCallback != null) {
            localObject = localIQQInputCallback.c();
          }
          if (!android.text.TextUtils.isEmpty((CharSequence)localObject))
          {
            this.c.setHint((CharSequence)localObject);
            this.d.setEnabled(false);
            this.d.setSelected(false);
          }
        }
        localObject = this.j;
        if (localObject != null) {
          ((QQInputView.IQQInputCallback)localObject).a();
        }
      }
      else if (paramInt2 != this.q)
      {
        localObject = this.j;
        if (localObject != null) {
          ((QQInputView.IQQInputCallback)localObject).a(paramInt2);
        }
      }
    }
    this.n = paramInt1;
    this.q = paramInt2;
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
    if (this.c.getText() == null) {
      str = null;
    } else {
      str = this.c.getText().toString();
    }
    if ((android.text.TextUtils.isEmpty(str)) || ((!android.text.TextUtils.isEmpty(str)) && (str.length() < 49))) {
      paramEmoticonInfo.send(this.h.app, this.h, this.c, null);
    }
  }
  
  public void setCallback(QQInputView.IQQInputCallback paramIQQInputCallback)
  {
    this.j = paramIQQInputCallback;
    this.g.post(new QQInputView.1(this));
  }
  
  public void setContentMaxLength(int paramInt)
  {
    this.m = paramInt;
    this.c.setFilters(new InputFilter[] { new InputFilter.LengthFilter(paramInt) });
  }
  
  public void setHintTextColor(int paramInt)
  {
    XEditTextEx localXEditTextEx = this.c;
    if (localXEditTextEx != null) {
      localXEditTextEx.setHintTextColor(paramInt);
    }
  }
  
  public void setting() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.freshnews.QQInputView
 * JD-Core Version:    0.7.0.1
 */