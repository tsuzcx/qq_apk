package com.tencent.qqmini.sdk.runtime.core.page.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextUtils;
import android.text.method.DigitsKeyListener;
import android.view.KeyEvent;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout.LayoutParams;
import bdnw;
import bdwa;
import bdyk;
import bdyn;
import com.tencent.qqmini.sdk.runtime.core.page.NativeViewContainer;
import com.tencent.qqmini.sdk.runtime.core.page.PageWebview;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

public class WebEditText
  extends EditText
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  private int jdField_a_of_type_Int;
  private bdwa jdField_a_of_type_Bdwa;
  private String jdField_a_of_type_JavaLangString = "normal";
  private WeakReference<PageWebview> jdField_a_of_type_JavaLangRefWeakReference;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString = "#FFFFFFFF";
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private String jdField_c_of_type_JavaLangString = "#FFFFFFFF";
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int;
  private String jdField_d_of_type_JavaLangString = "left";
  private int e;
  private int f;
  
  public WebEditText(Context paramContext, bdwa parambdwa)
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
    this.jdField_a_of_type_Bdwa = parambdwa;
  }
  
  public int a()
  {
    return this.e;
  }
  
  public FrameLayout.LayoutParams a(int paramInt)
  {
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
    localLayoutParams.leftMargin = this.jdField_d_of_type_Int;
    localLayoutParams.topMargin = (this.jdField_c_of_type_Int - paramInt);
    return localLayoutParams;
  }
  
  public PageWebview a()
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {
      return (PageWebview)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    }
    return null;
  }
  
  @TargetApi(16)
  public void a()
  {
    if (super.getParent() != null) {
      ((ViewGroup)super.getParent()).removeView(this);
    }
    super.getViewTreeObserver().removeOnGlobalLayoutListener(this);
    this.jdField_a_of_type_JavaLangRefWeakReference.clear();
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean a(NativeViewContainer paramNativeViewContainer, String paramString)
  {
    int j = 2;
    boolean bool1 = true;
    if ((TextUtils.isEmpty(paramString)) || (paramNativeViewContainer == null))
    {
      bool1 = false;
      return bool1;
    }
    Object localObject1 = super.getContext();
    paramString = new JSONObject(paramString);
    String str = paramString.optString("type");
    boolean bool2 = paramString.optBoolean("password");
    int i;
    if (("number".equals(str)) || ("digit".equals(str)) || ("idcard".equals(str))) {
      i = 2;
    }
    for (;;)
    {
      super.setInputType(i);
      Object localObject2 = paramString.optString("confirmType");
      label114:
      float f1;
      if ("send".equals(localObject2))
      {
        i = 4;
        setImeOptions(i);
        i = paramString.optInt("maxLength", -1);
        if (i != -1) {
          super.setFilters(new InputFilter[] { new InputFilter.LengthFilter(i) });
        }
        localObject2 = paramString.optJSONObject("style");
        if (localObject2 != null)
        {
          f1 = bdyn.a((Context)localObject1);
          this.jdField_a_of_type_Int = ((int)(((JSONObject)localObject2).optInt("width") * f1));
          this.jdField_b_of_type_Int = ((int)(((JSONObject)localObject2).optInt("height") * f1));
          this.jdField_d_of_type_Int = ((int)(((JSONObject)localObject2).optInt("left") * f1));
          if ((paramNativeViewContainer == null) || (!paramNativeViewContainer.a())) {
            break label621;
          }
          this.jdField_c_of_type_Int = ((int)(f1 * ((JSONObject)localObject2).optInt("top")));
          label245:
          super.setTextSize(((JSONObject)localObject2).optInt("fontSize", 16));
          this.jdField_a_of_type_JavaLangString = ((JSONObject)localObject2).optString("fontWeight", "normal");
          this.jdField_b_of_type_JavaLangString = ((JSONObject)localObject2).optString("color", "#FFFFFFFF");
          this.jdField_c_of_type_JavaLangString = ((JSONObject)localObject2).optString("backgroundColor", "#FFFFFFFF");
          this.f = ((int)(bdyn.a(getContext()) * ((JSONObject)localObject2).optInt("marginBottom") + 0.5F));
          this.jdField_d_of_type_JavaLangString = ((JSONObject)localObject2).optString("textAlign", "left");
        }
        paramNativeViewContainer = paramString.optString("placeholder");
        localObject1 = paramString.optJSONObject("placeholderStyle");
        if (localObject1 != null) {
          super.setHintTextColor(bdyk.a(((JSONObject)localObject1).optString("color", "#FFFFFFFF")));
        }
        this.jdField_a_of_type_Boolean = paramString.optBoolean("adjustPosition");
        this.jdField_c_of_type_Boolean = paramString.optBoolean("confirmHold", false);
        localObject1 = paramString.optString("defaultValue");
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          break label644;
        }
        super.setText((CharSequence)localObject1);
        label417:
        i = paramString.optInt("selectionStart", -1);
        j = paramString.optInt("selectionEnd", -1);
        if ((i != -1) && (j != -1) && (j > i)) {
          setSelection(i, j);
        }
        i = paramString.optInt("cursor", -1);
        if (i > 0) {
          setSelection(i);
        }
        super.setTextColor(bdyk.a(this.jdField_b_of_type_JavaLangString));
        super.setBackgroundColor(bdyk.a(this.jdField_c_of_type_JavaLangString));
        super.setHint(paramNativeViewContainer);
        if (!"left".equals(this.jdField_d_of_type_JavaLangString)) {
          break label654;
        }
        setGravity(19);
      }
      for (;;)
      {
        if (!"idcard".equals(str)) {
          break label698;
        }
        super.setKeyListener(DigitsKeyListener.getInstance("1234567890Xx"));
        return true;
        if (!bool2) {
          break label720;
        }
        i = 129;
        break;
        if ("search".equals(localObject2))
        {
          i = 3;
          break label114;
        }
        if ("next".equals(localObject2))
        {
          i = 5;
          break label114;
        }
        i = j;
        if ("go".equals(localObject2)) {
          break label114;
        }
        i = 6;
        break label114;
        label621:
        this.jdField_c_of_type_Int = ((int)(f1 * ((JSONObject)localObject2).optInt("top")) + paramNativeViewContainer.a());
        break label245;
        label644:
        super.setText("");
        break label417;
        label654:
        if ("center".equals(this.jdField_d_of_type_JavaLangString)) {
          setGravity(17);
        } else if ("right".equals(this.jdField_d_of_type_JavaLangString)) {
          setGravity(21);
        }
      }
      label698:
      if (!"digit".equals(str)) {
        break;
      }
      super.setKeyListener(DigitsKeyListener.getInstance("1234567890."));
      return true;
      label720:
      i = 1;
    }
  }
  
  public int b()
  {
    return this.f;
  }
  
  @TargetApi(16)
  public void b()
  {
    setFocusable(true);
    setFocusableInTouchMode(true);
    requestFocus();
    InputMethodManager localInputMethodManager = (InputMethodManager)super.getContext().getSystemService("input_method");
    if (localInputMethodManager != null) {
      localInputMethodManager.showSoftInput(this, 0);
    }
  }
  
  public boolean b()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public boolean c()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  public void onGlobalLayout()
  {
    if ((this.jdField_a_of_type_Bdwa != null) && (this.jdField_a_of_type_Bdwa.a(this.e)))
    {
      super.requestFocus();
      bdnw.a("WebEditText", "showSoftInput for inputId=" + this.e);
      InputMethodManager localInputMethodManager = (InputMethodManager)super.getContext().getSystemService("input_method");
      if (localInputMethodManager != null) {
        localInputMethodManager.showSoftInput(this, 0);
      }
    }
  }
  
  public boolean onKeyPreIme(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (paramKeyEvent.getAction() == 1) && (this.jdField_a_of_type_Bdwa != null) && (this.jdField_a_of_type_Bdwa.a()))
    {
      this.jdField_a_of_type_Bdwa.a(true);
      return true;
    }
    return super.onKeyPreIme(paramInt, paramKeyEvent);
  }
  
  public void setHasMoveParent(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public void setInputHeight(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void setInputId(int paramInt)
  {
    this.e = paramInt;
  }
  
  public void setPageWebview(PageWebview paramPageWebview)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramPageWebview);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("WebEditText{");
    localStringBuilder.append("mWebInputWidth=").append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", mWebInputHeight=").append(this.jdField_b_of_type_Int);
    localStringBuilder.append(", mWebInputTop=").append(this.jdField_c_of_type_Int);
    localStringBuilder.append(", mWebInputLeft=").append(this.jdField_d_of_type_Int);
    localStringBuilder.append(", mInputId=").append(this.e);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.core.page.widget.WebEditText
 * JD-Core Version:    0.7.0.1
 */