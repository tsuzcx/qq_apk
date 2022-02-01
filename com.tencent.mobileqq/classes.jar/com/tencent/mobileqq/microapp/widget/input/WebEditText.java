package com.tencent.mobileqq.microapp.widget.input;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.microapp.a.c;
import com.tencent.mobileqq.microapp.appbrand.a.a.f;
import com.tencent.mobileqq.microapp.appbrand.page.AbsAppBrandPage;
import com.tencent.mobileqq.microapp.appbrand.page.PageWebview;
import com.tencent.mobileqq.microapp.util.DisplayUtil;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

public class WebEditText
  extends EditText
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  String a = "#FFFFFFFF";
  String b = "#FFFFFFFF";
  private int c;
  private int d;
  private int e;
  private int f;
  private int g;
  private WeakReference h;
  
  public WebEditText(Context paramContext)
  {
    super(paramContext);
    super.setBackgroundDrawable(null);
    super.setIncludeFontPadding(false);
    super.setSingleLine(true);
    super.setTextIsSelectable(true);
    if (Build.VERSION.SDK_INT >= 16) {
      super.setLineSpacing(0.0F, 1.0F);
    }
    super.setPadding(0, 0, 0, 0);
  }
  
  public int a()
  {
    return this.g;
  }
  
  public void a(int paramInt)
  {
    this.g = paramInt;
  }
  
  public void a(PageWebview paramPageWebview)
  {
    this.h = new WeakReference(paramPageWebview);
  }
  
  public boolean a(f paramf, AbsAppBrandPage paramAbsAppBrandPage, String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramAbsAppBrandPage == null) {
        return false;
      }
      Object localObject = super.getContext();
      paramAbsAppBrandPage = new JSONObject(paramString);
      paramString = paramAbsAppBrandPage.optString("type");
      boolean bool1 = paramAbsAppBrandPage.optBoolean("isPassword");
      boolean bool2 = "number".equals(paramString);
      int j = 2;
      if ((!bool2) && (!"digit".equals(paramString)) && (!"idcard".equals(paramString)))
      {
        if (bool1) {
          i = 129;
        } else {
          i = 1;
        }
      }
      else {
        i = 2;
      }
      super.setInputType(i);
      paramString = paramAbsAppBrandPage.optString("confirmType");
      if ("send".equals(paramString)) {
        i = 4;
      } else if ("search".equals(paramString)) {
        i = 3;
      } else if ("next".equals(paramString)) {
        i = 5;
      } else if ("go".equals(paramString)) {
        i = j;
      } else {
        i = 6;
      }
      setImeOptions(i);
      int i = paramAbsAppBrandPage.optInt("maxLength", -1);
      if (i != -1) {
        super.setFilters(new InputFilter[] { new InputFilter.LengthFilter(i) });
      }
      paramString = paramAbsAppBrandPage.optJSONObject("style");
      if (paramString != null)
      {
        float f1 = DisplayUtil.getDensity((Context)localObject);
        this.c = ((int)(paramString.optInt("width") * f1));
        this.d = ((int)(paramString.optInt("height") * f1));
        this.f = ((int)(paramString.optInt("left") * f1));
        super.setTextSize(paramString.optInt("fontSize", 16));
        paramString.optString("fontWeight", "normal");
        this.a = paramString.optString("color", "#FFFFFFFF");
        this.b = paramString.optString("backgroundColor", "#FFFFFFFF");
        paramString.optInt("marginBottom");
        paramString.optString("textAlign", "left");
      }
      paramString = paramAbsAppBrandPage.optString("placeholder");
      localObject = paramAbsAppBrandPage.optJSONObject("placeholderStyle");
      if (localObject != null) {
        super.setHintTextColor(Color.parseColor(((JSONObject)localObject).optString("color", "#FFFFFFFF")));
      }
      if (paramAbsAppBrandPage.optBoolean("adjustPosition")) {
        paramf.b().getWindow().setSoftInputMode(32);
      }
      paramf = paramAbsAppBrandPage.optString("defaultValue");
      if (!TextUtils.isEmpty(paramf)) {
        super.setText(paramf);
      } else {
        super.setText("");
      }
      super.setTextColor(c.p(this.a));
      super.setBackgroundColor(c.p(this.b));
      super.setGravity(19);
      super.setHint(paramString);
      return true;
    }
    return false;
  }
  
  public PageWebview b()
  {
    WeakReference localWeakReference = this.h;
    if (localWeakReference != null) {
      return (PageWebview)localWeakReference.get();
    }
    return null;
  }
  
  @TargetApi(16)
  public void c()
  {
    if (super.getParent() != null) {
      ((ViewGroup)super.getParent()).removeView(this);
    }
    super.getViewTreeObserver().removeOnGlobalLayoutListener(this);
    this.h.clear();
  }
  
  @TargetApi(16)
  public void d()
  {
    setFocusable(true);
    setFocusableInTouchMode(true);
    requestFocus();
    Object localObject = super.getViewTreeObserver();
    ((ViewTreeObserver)localObject).removeOnGlobalLayoutListener(this);
    ((ViewTreeObserver)localObject).addOnGlobalLayoutListener(this);
    localObject = (InputMethodManager)super.getContext().getSystemService("input_method");
    if (localObject != null) {
      ((InputMethodManager)localObject).showSoftInput(this, 2);
    }
  }
  
  public void onGlobalLayout()
  {
    if (a.a().a(this.g))
    {
      super.requestFocus();
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("showSoftInput for inputId=");
        ((StringBuilder)localObject).append(this.g);
        QLog.d("WebEditText", 2, ((StringBuilder)localObject).toString());
      }
      Object localObject = (InputMethodManager)super.getContext().getSystemService("input_method");
      if (localObject != null) {
        ((InputMethodManager)localObject).showSoftInput(this, 2);
      }
    }
  }
  
  public boolean onKeyPreIme(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (paramKeyEvent.getAction() == 1) && (a.a().b()))
    {
      a.a().a(true);
      return true;
    }
    return super.onKeyPreIme(paramInt, paramKeyEvent);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("WebEditText{");
    localStringBuilder.append("mWebInputWidth=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", mWebInputHeight=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", mWebInputTop=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", mWebInputLeft=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", mInputId=");
    localStringBuilder.append(this.g);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.widget.input.WebEditText
 * JD-Core Version:    0.7.0.1
 */