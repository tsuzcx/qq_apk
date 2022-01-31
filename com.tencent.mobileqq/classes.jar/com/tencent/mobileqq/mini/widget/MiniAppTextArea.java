package com.tencent.mobileqq.mini.widget;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
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
import bdnn;
import com.tencent.mobileqq.mini.app.MiniAppStateManager;
import com.tencent.mobileqq.mini.appbrand.AppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.page.AbsAppBrandPage;
import com.tencent.mobileqq.mini.appbrand.page.PageWebview;
import com.tencent.mobileqq.mini.appbrand.page.WebviewContainer;
import com.tencent.mobileqq.mini.ui.NavigationBar;
import com.tencent.mobileqq.mini.util.ColorUtils;
import com.tencent.mobileqq.mini.util.DisplayUtil;
import com.tencent.mobileqq.mini.utils.EditAreaAnimatorUtil;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class MiniAppTextArea
  extends EditText
{
  private static int DEFAULT_MINI_HEIGHT = 45;
  private static final int DEFAULT_SPACING = 5;
  private static final String TAG = "MiniAppTextArea";
  private boolean adjustPosition;
  private boolean autoSize;
  private int confirmHeight = DisplayUtil.dip2px(getContext(), 50.0F);
  private int curInputId = -1;
  private String curValue;
  private WebviewContainer curWebviewContainer;
  private boolean disable;
  private boolean hasConfirm;
  private boolean isFixed;
  private boolean isKeyboardShow;
  private int lastLines = -1;
  private int lastOffset;
  private ViewTreeObserver.OnGlobalLayoutListener layoutListener;
  private int marginBootom;
  private int navbarHeight;
  private MiniAppTextArea.KeyboardHiddenObserver observer;
  private int offset;
  private int parentId;
  private int screenHeight;
  private int showKeyboardHeight;
  private int textAreaHeight;
  private int textAreaMaxHeight;
  private int textAreaMinHeight;
  
  public MiniAppTextArea(@NonNull Context paramContext)
  {
    super(paramContext);
    setPadding(0, 0, 0, 0);
    this.observer = new MiniAppTextArea.KeyboardHiddenObserver(this);
    this.screenHeight = DisplayUtil.getRealHeight(getContext());
    MiniAppStateManager.getInstance().addObserver(this.observer);
  }
  
  private void evaluateTextAreaHeightChange()
  {
    updateViewOffset();
    if (this.curWebviewContainer != null) {}
    try
    {
      MiniAppTextArea.EditInfo localEditInfo = getCurEditInfo();
      if (localEditInfo.getCurLine() != this.lastLines)
      {
        this.lastLines = localEditInfo.getCurLine();
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("height", getHeight(localEditInfo.getHeight() / DisplayUtil.getDensity(getContext())));
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
  
  private String getActualColor(String paramString)
  {
    if (bdnn.a(paramString)) {
      return "";
    }
    String str = paramString.substring(paramString.length() - 2);
    paramString = paramString.substring(1, paramString.length() - 2);
    return "#" + str + paramString;
  }
  
  private float getHeight(float paramFloat)
  {
    return paramFloat;
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
      return i + 5 + this.marginBootom;
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
      if (localObject != null) {
        break label40;
      }
    }
    label40:
    do
    {
      return;
      ((InputMethodManager)localObject).hideSoftInputFromWindow(this.curWebviewContainer.getWindowToken(), 0);
    } while (this.curWebviewContainer == null);
    if (this.hasConfirm) {
      this.curWebviewContainer.appBrandRuntime.getCurPage().hideKeyBoardConfirmView();
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
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("MiniAppTextArea", 2, "hideCurrentInput error", paramString);
    }
  }
  
  private void updateStyle(JSONObject paramJSONObject)
  {
    this.marginBootom = ((int)(DisplayUtil.getDensity(getContext()) * paramJSONObject.optInt("marginBottom") + 0.5F));
    int k = (int)Math.max(DisplayUtil.getDensity(getContext()) * paramJSONObject.optInt("width") + 0.5F, 0.0F);
    this.textAreaHeight = ((int)Math.max(DisplayUtil.getDensity(getContext()) * paramJSONObject.optInt("height") + 0.5F, 0.0F));
    int j = this.textAreaHeight;
    int i = j;
    if (this.textAreaHeight == 0)
    {
      i = j;
      if (this.autoSize) {
        i = -2;
      }
    }
    j = (int)(DisplayUtil.getDensity(getContext()) * paramJSONObject.optInt("left") + 0.5F);
    int m = (int)(DisplayUtil.getDensity(getContext()) * paramJSONObject.optInt("top") + 0.5F);
    this.textAreaMaxHeight = ((int)(DisplayUtil.getDensity(getContext()) * paramJSONObject.optInt("maxHeight") + 0.5F));
    this.textAreaMinHeight = ((int)(DisplayUtil.getDensity(getContext()) * paramJSONObject.optInt("minHeight") + 0.5F));
    Object localObject = new FrameLayout.LayoutParams(k, i);
    ((FrameLayout.LayoutParams)localObject).leftMargin = j;
    ((FrameLayout.LayoutParams)localObject).topMargin = m;
    setLayoutParams((ViewGroup.LayoutParams)localObject);
    if (this.textAreaMaxHeight != 0) {
      setMaxHeight(this.textAreaMaxHeight);
    }
    if (this.textAreaMinHeight != 0) {
      setMinHeight(this.textAreaMinHeight);
    }
    localObject = paramJSONObject.optString("textAlign");
    String str = paramJSONObject.optString("fontWeight");
    i = paramJSONObject.optInt("fontSize");
    j = paramJSONObject.optInt("lineSpace");
    paramJSONObject = paramJSONObject.optString("color");
    setLineSpacing(DisplayUtil.dip2px(getContext(), j), 1.0F);
    if ("left".equals(localObject)) {
      setGravity(3);
    }
    for (;;)
    {
      setTextSize(i);
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
  
  private void updateViewOffset()
  {
    int k = 0;
    if (!isFocused()) {
      return;
    }
    int j = getSelectionPosition();
    int i = j;
    if (j < getHeight()) {
      i = getHeight();
    }
    int m = getTop();
    int n = this.screenHeight;
    int i1 = this.navbarHeight;
    if (this.hasConfirm) {}
    for (j = this.confirmHeight;; j = 0)
    {
      j = n - i1 - m - i - j;
      m = this.screenHeight;
      n = this.showKeyboardHeight;
      i = k;
      if (this.hasConfirm) {
        i = this.confirmHeight;
      }
      if ((this.adjustPosition) && (j < this.showKeyboardHeight))
      {
        this.offset = (-(this.showKeyboardHeight - j));
        if (this.offset != this.lastOffset)
        {
          EditAreaAnimatorUtil.editAreaAnimator(this.curWebviewContainer, this.lastOffset, this.offset, 1.0F, 1.0F);
          this.lastOffset = this.offset;
        }
      }
      if ((!this.hasConfirm) || (this.isKeyboardShow)) {
        break;
      }
      this.isKeyboardShow = true;
      this.curWebviewContainer.appBrandRuntime.getCurPage().showKeyBoardConfirmView(m - n - i);
      return;
    }
  }
  
  public void callbackLineChange()
  {
    try
    {
      this.lastLines = 1;
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("height", getHeight(getLineHeight() / DisplayUtil.getDensity(getContext())));
      localJSONObject.put("lineCount", 1);
      localJSONObject.put("inputId", this.curInputId);
      this.curWebviewContainer.getPageWebview().evaluateSubcribeJS("onTextAreaHeightChange", localJSONObject.toString(), this.curWebviewContainer.getPageWebview().pageWebviewId);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("MiniAppTextArea", 1, "callbackLineChange error.", localThrowable);
    }
  }
  
  public MiniAppTextArea.EditInfo getCurEditInfo()
  {
    MiniAppTextArea.EditInfo localEditInfo = new MiniAppTextArea.EditInfo();
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
  
  public boolean isAutoSize()
  {
    return this.autoSize;
  }
  
  public boolean isFixed()
  {
    return this.isFixed;
  }
  
  public void removeLayoutListener()
  {
    if ((this.layoutListener != null) && (Build.VERSION.SDK_INT >= 16)) {
      getViewTreeObserver().removeOnGlobalLayoutListener(this.layoutListener);
    }
    this.layoutListener = null;
  }
  
  public void setAttributes(int paramInt, JSONObject paramJSONObject, WebviewContainer paramWebviewContainer)
  {
    this.curWebviewContainer = paramWebviewContainer;
    this.curInputId = paramInt;
    if (this.curWebviewContainer.appBrandRuntime.getCurPage().getNavBar().getNavbarStyle().equals("custom")) {}
    for (int i = 0;; i = this.curWebviewContainer.appBrandRuntime.getCurPage().getNavBar().getHeight())
    {
      this.navbarHeight = i;
      setBackgroundDrawable(null);
      setHorizontallyScrolling(false);
      setVerticalScrollBarEnabled(false);
      setSingleLine(false);
      setInputType(131073);
      setFocusable(true);
      this.autoSize = paramJSONObject.optBoolean("autoSize", false);
      this.adjustPosition = paramJSONObject.optBoolean("adjustPosition", false);
      this.hasConfirm = paramJSONObject.optBoolean("confirm", true);
      this.disable = paramJSONObject.optBoolean("disabled", false);
      if (this.disable) {
        setInputType(0);
      }
      if (paramJSONObject.optBoolean("hidden")) {
        setVisibility(8);
      }
      JSONObject localJSONObject = paramJSONObject.optJSONObject("style");
      if (localJSONObject != null) {
        updateStyle(localJSONObject);
      }
      Object localObject = paramJSONObject.optString("value");
      this.curValue = ((String)localObject);
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        setText((CharSequence)localObject);
      }
      i = paramJSONObject.optInt("maxLength");
      if (i > 0) {
        setFilters(new InputFilter[] { new InputFilter.LengthFilter(i) });
      }
      String str = paramJSONObject.optString("placeholder");
      localObject = paramJSONObject.optJSONObject("placeholderStyle");
      if (!bdnn.a(str)) {
        setHint(str);
      }
      if (localObject != null)
      {
        str = ((JSONObject)localObject).optString("color");
        if (!TextUtils.isEmpty(str)) {
          setHintTextColor(ColorUtils.parseColor(str));
        }
      }
      i = paramJSONObject.optInt("selectionStart", -1);
      int j = paramJSONObject.optInt("selectionEnd", -1);
      if ((i != -1) && (j != -1) && (j > i)) {
        setSelection(i, j);
      }
      i = paramJSONObject.optInt("cursor", -1);
      if (i > 0) {
        setSelection(i);
      }
      setOnFocusChangeListener(new MiniAppTextArea.1(this, paramWebviewContainer));
      addTextChangedListener(new MiniAppTextArea.2(this, (JSONObject)localObject, localJSONObject, paramInt, paramJSONObject, paramWebviewContainer));
      return;
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
  
  public void updateAttributes(JSONObject paramJSONObject)
  {
    Object localObject = paramJSONObject.optJSONObject("style");
    if (localObject != null) {
      updateStyle((JSONObject)localObject);
    }
    if (paramJSONObject.has("value"))
    {
      localObject = paramJSONObject.optString("value");
      this.curValue = ((String)localObject);
      setText((CharSequence)localObject);
      setSelection(((String)localObject).length());
    }
    int i = paramJSONObject.optInt("maxLength");
    if (i > 0) {
      setFilters(new InputFilter[] { new InputFilter.LengthFilter(i) });
    }
    localObject = paramJSONObject.optString("placeholder");
    JSONObject localJSONObject = paramJSONObject.optJSONObject("placeholderStyle");
    if (!bdnn.a((String)localObject)) {
      setHint((CharSequence)localObject);
    }
    if (localJSONObject != null)
    {
      localObject = localJSONObject.optString("color");
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        setHintTextColor(ColorUtils.parseColor((String)localObject));
      }
    }
    i = paramJSONObject.optInt("selectionStart", -1);
    int j = paramJSONObject.optInt("selectionEnd", -1);
    if ((i != -1) && (j != -1) && (j > i)) {
      setSelection(i, j);
    }
    i = paramJSONObject.optInt("cursor", -1);
    if (i > 0) {
      setSelection(i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.widget.MiniAppTextArea
 * JD-Core Version:    0.7.0.1
 */