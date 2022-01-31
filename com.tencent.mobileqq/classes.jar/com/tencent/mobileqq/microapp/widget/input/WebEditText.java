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
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.microapp.appbrand.a.a.y;
import com.tencent.mobileqq.microapp.appbrand.page.AbsAppBrandPage;
import com.tencent.mobileqq.microapp.appbrand.page.PageWebview;
import com.tencent.mobileqq.microapp.ui.NavigationBar;
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
  
  public boolean a(y paramy, AbsAppBrandPage paramAbsAppBrandPage, String paramString)
  {
    int j = 2;
    if ((TextUtils.isEmpty(paramString)) || (paramAbsAppBrandPage == null)) {
      return false;
    }
    Object localObject1 = super.getContext();
    paramString = new JSONObject(paramString);
    Object localObject2 = paramString.optString("type");
    boolean bool = paramString.optBoolean("isPassword");
    int i;
    if (("number".equals(localObject2)) || ("digit".equals(localObject2)) || ("idcard".equals(localObject2))) {
      i = 2;
    }
    for (;;)
    {
      super.setInputType(i);
      localObject2 = paramString.optString("confirmType");
      if ("send".equals(localObject2))
      {
        i = 4;
        label107:
        setImeOptions(i);
        i = paramString.optInt("maxLength", -1);
        if (i != -1) {
          super.setFilters(new InputFilter[] { new InputFilter.LengthFilter(i) });
        }
        localObject2 = paramString.optJSONObject("style");
        if (localObject2 != null)
        {
          float f1 = DisplayUtil.getDensity((Context)localObject1);
          this.c = ((int)(((JSONObject)localObject2).optInt("width") * f1));
          this.d = ((int)(((JSONObject)localObject2).optInt("height") * f1));
          this.f = ((int)(((JSONObject)localObject2).optInt("left") * f1));
          this.e = ((int)(f1 * ((JSONObject)localObject2).optInt("top")) + paramAbsAppBrandPage.getNavBar().getHeight());
          super.setTextSize(((JSONObject)localObject2).optInt("fontSize", 16));
          ((JSONObject)localObject2).optString("fontWeight", "normal");
          this.a = ((JSONObject)localObject2).optString("color", "#FFFFFFFF");
          this.b = ((JSONObject)localObject2).optString("backgroundColor", "#FFFFFFFF");
          ((JSONObject)localObject2).optInt("marginBottom");
          ((JSONObject)localObject2).optString("textAlign", "left");
        }
        paramAbsAppBrandPage = paramString.optString("placeholder");
        localObject1 = paramString.optJSONObject("placeholderStyle");
        if (localObject1 != null) {
          super.setHintTextColor(Color.parseColor(((JSONObject)localObject1).optString("color", "#FFFFFFFF")));
        }
        if (paramString.optBoolean("adjustPosition")) {
          paramy.b().getWindow().setSoftInputMode(32);
        }
        paramy = paramString.optString("defaultValue");
        if (TextUtils.isEmpty(paramy)) {
          break label485;
        }
        super.setText(paramy);
      }
      for (;;)
      {
        super.setTextColor(com.tencent.mobileqq.microapp.b.a.h(this.a));
        super.setBackgroundColor(com.tencent.mobileqq.microapp.b.a.h(this.b));
        super.setGravity(19);
        super.setHint(paramAbsAppBrandPage);
        return true;
        if (!bool) {
          break label495;
        }
        i = 129;
        break;
        if ("search".equals(localObject2))
        {
          i = 3;
          break label107;
        }
        if ("next".equals(localObject2))
        {
          i = 5;
          break label107;
        }
        i = j;
        if ("go".equals(localObject2)) {
          break label107;
        }
        i = 6;
        break label107;
        label485:
        super.setText("");
      }
      label495:
      i = 1;
    }
  }
  
  public FrameLayout.LayoutParams b(int paramInt)
  {
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(this.c, this.d);
    localLayoutParams.leftMargin = this.f;
    localLayoutParams.topMargin = (this.e - paramInt);
    return localLayoutParams;
  }
  
  public PageWebview b()
  {
    if (this.h != null) {
      return (PageWebview)this.h.get();
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
      if (QLog.isColorLevel()) {
        QLog.d("WebEditText", 2, "showSoftInput for inputId=" + this.g);
      }
      InputMethodManager localInputMethodManager = (InputMethodManager)super.getContext().getSystemService("input_method");
      if (localInputMethodManager != null) {
        localInputMethodManager.showSoftInput(this, 2);
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
    localStringBuilder.append("mWebInputWidth=").append(this.c);
    localStringBuilder.append(", mWebInputHeight=").append(this.d);
    localStringBuilder.append(", mWebInputTop=").append(this.e);
    localStringBuilder.append(", mWebInputLeft=").append(this.f);
    localStringBuilder.append(", mInputId=").append(this.g);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.widget.input.WebEditText
 * JD-Core Version:    0.7.0.1
 */