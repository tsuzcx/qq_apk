package com.tencent.qqmini.sdk.runtime.core.page.widget;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.Layout;
import android.text.Selection;
import android.text.TextUtils;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout.LayoutParams;
import bgmk;
import bgox;
import bgpu;
import bgpv;
import bhfx;
import bhgt;
import bhgu;
import bhgv;
import bhgw;
import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.qqmini.sdk.runtime.core.page.NativeViewContainer;
import com.tencent.qqmini.sdk.runtime.core.page.PageWebviewContainer;
import com.tencent.qqmini.sdk.utils.ColorUtils;
import com.tencent.qqmini.sdk.utils.DisplayUtil;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class MiniAppTextArea
  extends EditText
  implements bhfx
{
  private static int jdField_e_of_type_Int = 45;
  private int jdField_a_of_type_Int = -1;
  private ViewTreeObserver.OnGlobalLayoutListener jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener;
  private bhgw jdField_a_of_type_Bhgw;
  private NativeViewContainer jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageNativeViewContainer;
  private String jdField_a_of_type_JavaLangString;
  private Map<Integer, bgpu> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = -1;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int;
  private boolean jdField_d_of_type_Boolean;
  private boolean jdField_e_of_type_Boolean;
  private int jdField_f_of_type_Int;
  private boolean jdField_f_of_type_Boolean;
  private int g;
  private int h;
  private int i;
  private int j;
  private int k = DisplayUtil.dip2px(getContext(), 50.0F);
  private int l;
  private int m;
  private int n;
  
  public MiniAppTextArea(Context paramContext, NativeViewContainer paramNativeViewContainer)
  {
    super(paramContext);
    setPadding(0, 0, 0, 0);
    this.jdField_a_of_type_Bhgw = new bhgw(this);
    this.jdField_c_of_type_Int = DisplayUtil.getRealHeight(getContext());
    this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageNativeViewContainer = paramNativeViewContainer;
    e();
    f();
  }
  
  private float a(float paramFloat)
  {
    return paramFloat;
  }
  
  private void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageNativeViewContainer != null)
    {
      this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageNativeViewContainer.c(paramInt);
      f();
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageNativeViewContainer != null) {}
    Object localObject;
    for (PageWebviewContainer localPageWebviewContainer = this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageNativeViewContainer.a();; localPageWebviewContainer = null)
    {
      if ((localPageWebviewContainer != null) && (isFocused()))
      {
        clearFocus();
        localObject = (InputMethodManager)localPageWebviewContainer.getContext().getSystemService("input_method");
        if (localObject != null) {
          break;
        }
      }
      return;
    }
    ((InputMethodManager)localObject).hideSoftInputFromWindow(localPageWebviewContainer.getWindowToken(), 0);
    try
    {
      localObject = new JSONObject();
      ((JSONObject)localObject).put("inputId", this.jdField_a_of_type_Int);
      ((JSONObject)localObject).put("value", getText().toString());
      ((JSONObject)localObject).put("cursor", getText().toString().length());
      if (paramBoolean) {
        localPageWebviewContainer.b("onKeyboardConfirm", ((JSONObject)localObject).toString());
      }
      localPageWebviewContainer.b("onKeyboardComplete", ((JSONObject)localObject).toString());
      return;
    }
    catch (Exception localException)
    {
      QMLog.e("MiniAppTextArea", "hideCurrentInput error", localException);
    }
  }
  
  private int b()
  {
    int i1 = 0;
    Layout localLayout = getLayout();
    if (localLayout == null) {
      return 0;
    }
    int i2 = Selection.getSelectionStart(getText());
    if (i2 != -1) {
      i1 = localLayout.getLineForOffset(i2) + 1;
    }
    i2 = (int)(i1 * getLineHeight() + 0.5D);
    if (this.m != 0) {
      i1 = Math.min(i2, this.m);
    }
    for (;;)
    {
      return i1 + 5 + this.j;
      i1 = i2;
      if (this.l != 0) {
        i1 = Math.min(i2, this.l);
      }
    }
  }
  
  private void b(JSONObject paramJSONObject)
  {
    this.j = ((int)(DisplayUtil.getDensity(getContext()) * paramJSONObject.optInt("marginBottom") + 0.5F));
    int i3 = (int)Math.max(DisplayUtil.getDensity(getContext()) * paramJSONObject.optInt("width") + 0.5F, 0.0F);
    this.l = ((int)Math.max(DisplayUtil.getDensity(getContext()) * paramJSONObject.optInt("height") + 0.5F, 0.0F));
    int i2 = this.l;
    int i1 = i2;
    if (this.l == 0)
    {
      i1 = i2;
      if (this.jdField_a_of_type_Boolean) {
        i1 = -2;
      }
    }
    i2 = (int)(DisplayUtil.getDensity(getContext()) * paramJSONObject.optInt("left") + 0.5F);
    int i4 = (int)(DisplayUtil.getDensity(getContext()) * paramJSONObject.optInt("top") + 0.5F);
    this.m = ((int)(DisplayUtil.getDensity(getContext()) * paramJSONObject.optInt("maxHeight") + 0.5F));
    this.n = ((int)(DisplayUtil.getDensity(getContext()) * paramJSONObject.optInt("minHeight") + 0.5F));
    Object localObject = new FrameLayout.LayoutParams(i3, i1);
    ((FrameLayout.LayoutParams)localObject).leftMargin = i2;
    ((FrameLayout.LayoutParams)localObject).topMargin = i4;
    setLayoutParams((ViewGroup.LayoutParams)localObject);
    if (this.m != 0) {
      setMaxHeight(this.m);
    }
    if (this.n != 0) {
      setMinHeight(this.n);
    }
    localObject = paramJSONObject.optString("textAlign");
    String str = paramJSONObject.optString("fontWeight");
    i1 = paramJSONObject.optInt("fontSize");
    i2 = paramJSONObject.optInt("lineSpace");
    paramJSONObject = paramJSONObject.optString("color");
    setLineSpacing(DisplayUtil.dip2px(getContext(), i2), 1.0F);
    if ("left".equals(localObject)) {
      setGravity(3);
    }
    for (;;)
    {
      setTextSize(i1);
      setTextColor(ColorUtils.parseColor(paramJSONObject));
      if ("bold".equals(str)) {
        setTypeface(Typeface.defaultFromStyle(1));
      }
      return;
      if ("center".equals(localObject)) {
        setGravity(1);
      } else if ("right".equals(localObject)) {
        setGravity(5);
      }
    }
  }
  
  private void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageNativeViewContainer != null) {}
    for (PageWebviewContainer localPageWebviewContainer = this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageNativeViewContainer.a();; localPageWebviewContainer = null)
    {
      this.jdField_f_of_type_Boolean = false;
      h();
      if (this.g != 0) {
        bgox.a(localPageWebviewContainer, this.g, 0.0F, 1.0F, 1.0F);
      }
      a(paramBoolean);
      this.g = 0;
      this.h = 0;
      return;
    }
  }
  
  private void d()
  {
    i();
    if (this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageNativeViewContainer != null) {}
    try
    {
      bhgv localbhgv = a();
      if (localbhgv.a() != this.jdField_b_of_type_Int)
      {
        this.jdField_b_of_type_Int = localbhgv.a();
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("height", a(localbhgv.b() / DisplayUtil.getDensity(getContext())));
        localJSONObject.put("lineCount", localbhgv.a());
        localJSONObject.put("inputId", this.jdField_a_of_type_Int);
        this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageNativeViewContainer.a().b("onTextAreaHeightChange", localJSONObject.toString());
      }
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
  
  private void e()
  {
    bhgw localbhgw = new bhgw(this);
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(this.jdField_a_of_type_Int), localbhgw);
    this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageNativeViewContainer.setSoftKeyboardStateListener(localbhgw);
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageNativeViewContainer != null) {
      this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageNativeViewContainer.a(this);
    }
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageNativeViewContainer != null) {
      this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageNativeViewContainer.b(this);
    }
  }
  
  private void h()
  {
    if (this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageNativeViewContainer != null)
    {
      this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageNativeViewContainer.a();
      g();
    }
  }
  
  private void i()
  {
    if (!isFocused()) {
      return;
    }
    int i2 = b();
    int i1 = i2;
    if (i2 < getHeight()) {
      i1 = getHeight();
    }
    int i3 = getTop();
    int i4 = this.jdField_c_of_type_Int;
    int i5 = this.jdField_d_of_type_Int;
    if (this.jdField_d_of_type_Boolean)
    {
      i2 = this.k;
      label57:
      i1 = i4 - i5 - i3 - i1 - i2;
      i2 = this.jdField_c_of_type_Int;
      i3 = this.i;
      i4 = this.k;
      if ((this.jdField_c_of_type_Boolean) && (i1 < this.i))
      {
        this.g = (-(this.i - i1));
        if (this.g != this.h) {
          if (this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageNativeViewContainer == null) {
            break label203;
          }
        }
      }
    }
    label203:
    for (PageWebviewContainer localPageWebviewContainer = this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageNativeViewContainer.a();; localPageWebviewContainer = null)
    {
      if (localPageWebviewContainer != null) {
        bgox.a(localPageWebviewContainer, this.h, this.g, 1.0F, 1.0F);
      }
      this.h = this.g;
      if ((!this.jdField_d_of_type_Boolean) || (this.jdField_f_of_type_Boolean)) {
        break;
      }
      this.jdField_f_of_type_Boolean = true;
      a(i2 - i3 - i4);
      return;
      i2 = 0;
      break label57;
    }
  }
  
  public int a()
  {
    return this.jdField_f_of_type_Int;
  }
  
  public bhgv a()
  {
    bhgv localbhgv = new bhgv();
    Layout localLayout = getLayout();
    if (localLayout != null)
    {
      localbhgv.a(localLayout.getLineCount());
      localbhgv.b(localLayout.getHeight());
    }
    return localbhgv;
  }
  
  public void a()
  {
    b(true);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    Object localObject = paramJSONObject.optJSONObject("style");
    if (localObject != null) {
      b((JSONObject)localObject);
    }
    if (paramJSONObject.has("value"))
    {
      localObject = paramJSONObject.optString("value");
      this.jdField_a_of_type_JavaLangString = ((String)localObject);
      setText((CharSequence)localObject);
      setSelection(((String)localObject).length());
    }
    int i1 = paramJSONObject.optInt("maxLength");
    if (i1 > 0) {
      setFilters(new InputFilter[] { new InputFilter.LengthFilter(i1) });
    }
    localObject = paramJSONObject.optString("placeholder");
    JSONObject localJSONObject = paramJSONObject.optJSONObject("placeholderStyle");
    if (!bgpv.a((String)localObject)) {
      setHint((CharSequence)localObject);
    }
    if (localJSONObject != null)
    {
      localObject = localJSONObject.optString("color");
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        setHintTextColor(ColorUtils.parseColor((String)localObject));
      }
    }
    i1 = paramJSONObject.optInt("selectionStart", -1);
    int i2 = paramJSONObject.optInt("selectionEnd", -1);
    if ((i1 != -1) && (i2 != -1) && (i2 > i1)) {
      setSelection(i1, i2);
    }
    i1 = paramJSONObject.optInt("cursor", -1);
    if (i1 > 0) {
      setSelection(i1);
    }
  }
  
  public boolean a()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener != null) && (Build.VERSION.SDK_INT >= 16)) {
      getViewTreeObserver().removeOnGlobalLayoutListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
    }
    this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener = null;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageNativeViewContainer != null) {}
    for (PageWebviewContainer localPageWebviewContainer = this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageNativeViewContainer.a();; localPageWebviewContainer = null) {
      try
      {
        this.jdField_b_of_type_Int = 1;
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("height", a(getLineHeight() / DisplayUtil.getDensity(getContext())));
        localJSONObject.put("lineCount", 1);
        localJSONObject.put("inputId", this.jdField_a_of_type_Int);
        if (localPageWebviewContainer != null) {
          localPageWebviewContainer.b("onTextAreaHeightChange", localJSONObject.toString());
        }
        return;
      }
      catch (Throwable localThrowable)
      {
        QMLog.e("MiniAppTextArea", "callbackLineChange error.", localThrowable);
      }
    }
  }
  
  public void setAttributes(int paramInt, JSONObject paramJSONObject, bgmk parambgmk)
  {
    this.jdField_a_of_type_Int = paramInt;
    if (this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageNativeViewContainer.a()) {}
    for (int i1 = 0;; i1 = this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageNativeViewContainer.a())
    {
      this.jdField_d_of_type_Int = i1;
      setBackgroundDrawable(null);
      setHorizontallyScrolling(false);
      setVerticalScrollBarEnabled(false);
      setSingleLine(false);
      setInputType(131073);
      setFocusable(true);
      this.jdField_a_of_type_Boolean = paramJSONObject.optBoolean("autoSize", false);
      this.jdField_c_of_type_Boolean = paramJSONObject.optBoolean("adjustPosition", false);
      this.jdField_d_of_type_Boolean = paramJSONObject.optBoolean("confirm", false);
      this.jdField_e_of_type_Boolean = paramJSONObject.optBoolean("disabled", false);
      if (this.jdField_e_of_type_Boolean) {
        setInputType(0);
      }
      if (paramJSONObject.optBoolean("hidden")) {
        setVisibility(8);
      }
      JSONObject localJSONObject = paramJSONObject.optJSONObject("style");
      if (localJSONObject != null) {
        b(localJSONObject);
      }
      Object localObject = paramJSONObject.optString("value");
      this.jdField_a_of_type_JavaLangString = ((String)localObject);
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        setText((CharSequence)localObject);
      }
      i1 = paramJSONObject.optInt("maxLength");
      if (i1 > 0) {
        setFilters(new InputFilter[] { new InputFilter.LengthFilter(i1) });
      }
      String str = paramJSONObject.optString("placeholder");
      localObject = paramJSONObject.optJSONObject("placeholderStyle");
      if (!bgpv.a(str)) {
        setHint(str);
      }
      if (localObject != null)
      {
        str = ((JSONObject)localObject).optString("color");
        if (!TextUtils.isEmpty(str)) {
          setHintTextColor(ColorUtils.parseColor(str));
        }
      }
      i1 = paramJSONObject.optInt("selectionStart", -1);
      int i2 = paramJSONObject.optInt("selectionEnd", -1);
      if ((i1 != -1) && (i2 != -1) && (i2 > i1)) {
        setSelection(i1, i2);
      }
      i1 = paramJSONObject.optInt("cursor", -1);
      if (i1 > 0) {
        setSelection(i1);
      }
      setOnFocusChangeListener(new bhgt(this));
      addTextChangedListener(new bhgu(this, (JSONObject)localObject, localJSONObject, paramInt, paramJSONObject, parambgmk));
      return;
    }
  }
  
  public void setFixed(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public void setParentId(int paramInt)
  {
    this.jdField_f_of_type_Int = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.core.page.widget.MiniAppTextArea
 * JD-Core Version:    0.7.0.1
 */