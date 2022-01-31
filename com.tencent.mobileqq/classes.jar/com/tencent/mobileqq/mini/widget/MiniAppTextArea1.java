package com.tencent.mobileqq.mini.widget;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.Layout;
import android.text.Selection;
import android.text.TextUtils;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout.LayoutParams;
import bbjw;
import com.tencent.mobileqq.mini.app.MiniAppStateManager;
import com.tencent.mobileqq.mini.appbrand.AppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.page.AbsAppBrandPage;
import com.tencent.mobileqq.mini.appbrand.page.PageWebview;
import com.tencent.mobileqq.mini.appbrand.page.WebviewContainer;
import com.tencent.mobileqq.mini.util.ColorUtils;
import com.tencent.mobileqq.mini.util.DisplayUtil;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class MiniAppTextArea1
  extends EditText
{
  private static final String TAG = "MiniAppTextArea1";
  private static volatile boolean isFocused;
  private boolean adjustPosition;
  private boolean autoSize;
  private int confirmHeight = DisplayUtil.dip2px(getContext(), 50.0F);
  private int curInputId = -1;
  private String curValue;
  private WebviewContainer curWebviewContainer;
  private String data;
  private boolean disable;
  private boolean hasConfirm;
  private boolean isFixed;
  private boolean isKeyboardShow;
  private int lastLines = -1;
  private int lastTranslateY;
  private Handler mHandler;
  private int marginBootom;
  private MiniAppTextArea1.KeyboardHiddenObserver observer;
  private int parentId;
  private JSONObject placeholderStyle = new JSONObject();
  private int screenHeight;
  private int showKeyboardHeight;
  private JSONObject style = new JSONObject();
  private int textAreaHeight;
  private int textAreaMaxHeight;
  private int textAreaMinHeight;
  private Runnable translateRunable = new MiniAppTextArea1.4(this);
  
  public MiniAppTextArea1(@NonNull Context paramContext, int paramInt, WebviewContainer paramWebviewContainer)
  {
    super(paramContext);
    this.curWebviewContainer = paramWebviewContainer;
    this.mHandler = new Handler(Looper.getMainLooper());
    this.curInputId = paramInt;
    setPadding(0, 0, 0, 0);
    this.observer = new MiniAppTextArea1.KeyboardHiddenObserver(this);
    this.screenHeight = DisplayUtil.getRealHeight(getContext());
    MiniAppStateManager.getInstance().addObserver(this.observer);
    setBackgroundDrawable(null);
    setHorizontallyScrolling(false);
    setVerticalScrollBarEnabled(false);
    setSingleLine(false);
    setInputType(131073);
    setFocusable(true);
    setOnFocusChangeListener(new MiniAppTextArea1.1(this, paramWebviewContainer));
    addTextChangedListener(new MiniAppTextArea1.2(this, paramInt, paramWebviewContainer));
    getViewTreeObserver().addOnGlobalLayoutListener(new MiniAppTextArea1.3(this));
  }
  
  private void evaluateTextAreaHeightChange()
  {
    if (this.curWebviewContainer != null) {}
    try
    {
      MiniAppTextArea1.EditInfo localEditInfo = getCurEditInfo();
      if (localEditInfo.getCurLine() != this.lastLines)
      {
        this.lastLines = localEditInfo.getCurLine();
        JSONObject localJSONObject = new JSONObject();
        int j = localEditInfo.getHeight();
        int i = j;
        if (this.textAreaMinHeight != 0) {
          i = Math.max(this.textAreaMinHeight, j);
        }
        localJSONObject.put("height", i / DisplayUtil.getDensity(getContext()));
        localJSONObject.put("lineCount", localEditInfo.getCurLine());
        localJSONObject.put("inputId", this.curInputId);
        this.curWebviewContainer.getPageWebview().evaluateSubcribeJS("onTextAreaHeightChange", localJSONObject.toString(), this.curWebviewContainer.getPageWebview().pageWebviewId);
      }
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
  
  private int getSelectionPosition()
  {
    int i = 0;
    Layout localLayout = getLayout();
    if (localLayout == null) {
      return 0;
    }
    int j = Selection.getSelectionStart(getText());
    if (j != -1) {
      i = localLayout.getLineForOffset(j) + 1;
    }
    j = (int)(i * getLineHeight() + 0.5D);
    if (this.textAreaMaxHeight != 0) {
      i = Math.min(j, this.textAreaMaxHeight);
    }
    for (;;)
    {
      return i + this.marginBootom + this.confirmHeight;
      i = j;
      if (this.textAreaHeight != 0) {
        i = Math.min(j, this.textAreaHeight);
      }
    }
  }
  
  private void hideCurrentInput(String paramString)
  {
    Object localObject;
    if ((this.curWebviewContainer != null) && (isFocused()))
    {
      clearFocus();
      localObject = (InputMethodManager)this.curWebviewContainer.getContext().getSystemService("input_method");
      if (localObject != null) {}
    }
    else
    {
      return;
    }
    ((InputMethodManager)localObject).hideSoftInputFromWindow(this.curWebviewContainer.getWindowToken(), 0);
    if (this.curWebviewContainer != null) {
      if (this.hasConfirm) {
        this.curWebviewContainer.appBrandRuntime.getCurPage().hideKeyBoardConfirmView();
      }
    }
    try
    {
      localObject = new JSONObject();
      ((JSONObject)localObject).put("inputId", this.curInputId);
      ((JSONObject)localObject).put("value", getText().toString());
      ((JSONObject)localObject).put("cursor", getText().toString().length());
      if ("confirm".equals(paramString)) {
        this.curWebviewContainer.getPageWebview().evaluateSubcribeJS("onKeyboardConfirm", ((JSONObject)localObject).toString(), this.curWebviewContainer.getPageWebview().pageWebviewId);
      }
      this.curWebviewContainer.getPageWebview().evaluateSubcribeJS("onKeyboardComplete", ((JSONObject)localObject).toString(), this.curWebviewContainer.getPageWebview().pageWebviewId);
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        QLog.e("MiniAppTextArea1", 2, "hideCurrentInput error", paramString);
      }
    }
    this.mHandler.postDelayed(new MiniAppTextArea1.5(this), 50L);
  }
  
  private void updateStyle(JSONObject paramJSONObject, boolean paramBoolean)
  {
    if (paramJSONObject.has("marginBottom")) {
      this.marginBootom = ((int)(DisplayUtil.getDensity(getContext()) * paramJSONObject.optInt("marginBottom") + 0.5F));
    }
    if (paramJSONObject.has("maxHeight")) {
      this.textAreaMaxHeight = ((int)(DisplayUtil.getDensity(getContext()) * paramJSONObject.optInt("maxHeight") + 0.5F));
    }
    if (paramJSONObject.has("minHeight")) {
      this.textAreaMinHeight = ((int)(DisplayUtil.getDensity(getContext()) * paramJSONObject.optInt("minHeight") + 0.5F));
    }
    if (this.textAreaMaxHeight != 0) {
      setMaxHeight(this.textAreaMaxHeight);
    }
    if (this.textAreaMinHeight != 0)
    {
      setMinHeight(this.textAreaMinHeight);
      setMinimumHeight(this.textAreaMinHeight);
      setMinimumWidth(0);
    }
    int k;
    int j;
    int i;
    if ((paramJSONObject.has("width")) || (paramJSONObject.has("height")) || (paramJSONObject.has("left")) || (paramJSONObject.has("top")))
    {
      k = (int)Math.max(DisplayUtil.getDensity(getContext()) * paramJSONObject.optInt("width") + 0.5F, 0.0F);
      this.textAreaHeight = ((int)Math.max(DisplayUtil.getDensity(getContext()) * paramJSONObject.optInt("height") + 0.5F, 0.0F));
      j = this.textAreaHeight;
      i = j;
      if (this.textAreaHeight != 0) {
        break label616;
      }
      i = j;
      if (!this.autoSize) {
        break label616;
      }
      j = this.textAreaMinHeight;
      i = j;
      if (!paramBoolean) {
        break label616;
      }
      i = j;
      if (getLayout().getHeight() <= this.textAreaMinHeight) {
        break label616;
      }
      i = getLayout().getHeight();
    }
    label605:
    label616:
    for (;;)
    {
      j = (int)(DisplayUtil.getDensity(getContext()) * paramJSONObject.optInt("left") + 0.5F);
      int m = (int)(DisplayUtil.getDensity(getContext()) * paramJSONObject.optInt("top") + 0.5F);
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)getLayoutParams();
      Object localObject = localLayoutParams;
      if (localLayoutParams == null) {
        localObject = new FrameLayout.LayoutParams(k, i, 3);
      }
      ((FrameLayout.LayoutParams)localObject).width = k;
      ((FrameLayout.LayoutParams)localObject).height = i;
      ((FrameLayout.LayoutParams)localObject).leftMargin = j;
      ((FrameLayout.LayoutParams)localObject).topMargin = m;
      setLayoutParams((ViewGroup.LayoutParams)localObject);
      if (paramJSONObject.has("textAlign"))
      {
        localObject = paramJSONObject.optString("textAlign");
        if ("left".equals(localObject)) {
          setGravity(3);
        }
      }
      else if (paramJSONObject.has("fontWeight"))
      {
        if (!"bold".equals(paramJSONObject.optString("fontWeight"))) {
          break label605;
        }
        setTypeface(Typeface.defaultFromStyle(1));
      }
      for (;;)
      {
        if (paramJSONObject.has("fontSize")) {
          setTextSize(paramJSONObject.optInt("fontSize"));
        }
        if (paramJSONObject.has("lineSpace"))
        {
          i = paramJSONObject.optInt("lineSpace");
          setLineSpacing(DisplayUtil.dip2px(getContext(), i), 1.0F);
        }
        if (paramJSONObject.has("color")) {
          setTextColor(ColorUtils.parseColor(paramJSONObject.optString("color")));
        }
        return;
        if ("center".equals(localObject))
        {
          setGravity(1);
          break;
        }
        if (!"right".equals(localObject)) {
          break;
        }
        setGravity(5);
        break;
        setTypeface(Typeface.defaultFromStyle(0));
      }
    }
  }
  
  private void updateTextareaAnimator()
  {
    this.mHandler.removeCallbacks(this.translateRunable);
    this.mHandler.postDelayed(this.translateRunable, 50L);
  }
  
  private void updateTextareaHeight()
  {
    if ((this.autoSize) && (getLayout().getHeight() > this.textAreaMinHeight))
    {
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)getLayoutParams();
      localLayoutParams.height = getLayout().getHeight();
      setLayoutParams(localLayoutParams);
    }
  }
  
  public void callbackLineChange()
  {
    try
    {
      this.lastLines = 1;
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("height", getLineHeight() / DisplayUtil.getDensity(getContext()));
      localJSONObject.put("lineCount", 1);
      localJSONObject.put("inputId", this.curInputId);
      this.curWebviewContainer.getPageWebview().evaluateSubcribeJS("onTextAreaHeightChange", localJSONObject.toString(), this.curWebviewContainer.getPageWebview().pageWebviewId);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("MiniAppTextArea1", 1, "callbackLineChange error.", localThrowable);
    }
  }
  
  public MiniAppTextArea1.EditInfo getCurEditInfo()
  {
    MiniAppTextArea1.EditInfo localEditInfo = new MiniAppTextArea1.EditInfo();
    Layout localLayout = getLayout();
    if (localLayout != null)
    {
      localEditInfo.setCurLine(localLayout.getLineCount());
      localEditInfo.setHeight(localLayout.getHeight());
    }
    return localEditInfo;
  }
  
  public int getParentId()
  {
    return this.parentId;
  }
  
  public boolean isFixed()
  {
    return this.isFixed;
  }
  
  public boolean isTextAreaFocused()
  {
    return isFocused;
  }
  
  public void setAttributes(JSONObject paramJSONObject, boolean paramBoolean)
  {
    if (paramJSONObject.has("data")) {
      this.data = paramJSONObject.optString("data");
    }
    if (paramJSONObject.has("autoSize")) {
      this.autoSize = paramJSONObject.optBoolean("autoSize", false);
    }
    if (paramJSONObject.has("adjustPosition")) {
      this.adjustPosition = paramJSONObject.optBoolean("adjustPosition", false);
    }
    if (paramJSONObject.has("confirm")) {
      this.hasConfirm = paramJSONObject.optBoolean("confirm", true);
    }
    if (paramJSONObject.has("disabled"))
    {
      this.disable = paramJSONObject.optBoolean("disabled", false);
      if (this.disable) {
        setInputType(0);
      }
    }
    if ((paramJSONObject.has("hidden")) && (paramJSONObject.optBoolean("hidden"))) {
      setVisibility(8);
    }
    String str;
    if (paramJSONObject.has("value"))
    {
      str = paramJSONObject.optString("value");
      this.curValue = str;
      if (!TextUtils.isEmpty(str)) {
        setText(str);
      }
    }
    int i;
    if (paramJSONObject.has("maxLength"))
    {
      i = paramJSONObject.optInt("maxLength");
      if (i > 0) {
        setFilters(new InputFilter[] { new InputFilter.LengthFilter(i) });
      }
    }
    if (paramJSONObject.has("placeholder"))
    {
      str = paramJSONObject.optString("placeholder");
      if (!bbjw.a(str)) {
        setHint(str);
      }
    }
    if (paramJSONObject.has("placeholderStyle"))
    {
      this.placeholderStyle = paramJSONObject.optJSONObject("placeholderStyle");
      if ((this.placeholderStyle != null) && (this.placeholderStyle.has("color")))
      {
        str = this.placeholderStyle.optString("color");
        if (!TextUtils.isEmpty(str)) {
          setHintTextColor(ColorUtils.parseColor(str));
        }
      }
    }
    if ((paramJSONObject.has("selectionStart")) || (paramJSONObject.has("selectionEnd")))
    {
      i = paramJSONObject.optInt("selectionStart", -1);
      int j = paramJSONObject.optInt("selectionEnd", -1);
      if ((i != -1) && (j != -1) && (j > i)) {
        setSelection(i, j);
      }
    }
    if (paramJSONObject.has("cursor"))
    {
      i = paramJSONObject.optInt("cursor", -1);
      if (i > 0) {
        setSelection(i);
      }
    }
    paramJSONObject = paramJSONObject.optJSONObject("style");
    if (paramJSONObject != null)
    {
      this.style = paramJSONObject;
      updateStyle(paramJSONObject, paramBoolean);
    }
  }
  
  public void setFixed(boolean paramBoolean)
  {
    this.isFixed = paramBoolean;
  }
  
  public void setParentId(int paramInt)
  {
    this.parentId = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.widget.MiniAppTextArea1
 * JD-Core Version:    0.7.0.1
 */