package com.tencent.qqmini.miniapp.core.page.widget;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.Layout;
import android.text.Selection;
import android.text.TextUtils;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.qqmini.miniapp.core.page.NativeViewContainer;
import com.tencent.qqmini.miniapp.core.page.NativeViewContainer.IConfirmListerner;
import com.tencent.qqmini.miniapp.core.page.PageWebviewContainer;
import com.tencent.qqmini.sdk.core.utils.SoftKeyboardStateHelper.SoftKeyboardStateListener;
import com.tencent.qqmini.sdk.core.utils.StringUtil;
import com.tencent.qqmini.sdk.launcher.core.action.NativeViewRequestEvent;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.utils.ColorUtils;
import com.tencent.qqmini.sdk.launcher.utils.DisplayUtil;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class MiniAppTextArea
  extends EditText
  implements NativeViewContainer.IConfirmListerner
{
  private static final String TAG = "MiniAppTextArea";
  private boolean adjustPosition = false;
  private boolean autoSize = false;
  private int confirmHeight = DisplayUtil.dip2px(getContext(), 50.0F);
  private String curValue;
  private int cursorPositation = -1;
  private String data = null;
  private boolean disable = false;
  private ViewTreeObserver.OnGlobalLayoutListener globalLayoutListener;
  private boolean hasConfirm = false;
  private boolean hasSendKeyboardShowToJs = false;
  private boolean isFixed = false;
  private volatile boolean isFocused = false;
  private boolean isKeyboardShow = false;
  private int lastLines = -1;
  private int lastTranslateY = 0;
  private int mCurInputId = -1;
  private Handler mHandler;
  private Map<Integer, SoftKeyboardStateHelper.SoftKeyboardStateListener> mInputKeyboardListner = new ConcurrentHashMap();
  private NativeViewContainer mNativeContainer = null;
  private int marginBootom = 0;
  private int parentId = 0;
  private JSONObject placeholderStyle = new JSONObject();
  private int screenHeight;
  private int showKeyboardHeight = 0;
  private JSONObject style = new JSONObject();
  private int textAreaHeight = 0;
  private int textAreaMaxHeight = 0;
  private int textAreaMinHeight = 0;
  private Runnable translateRunable = new MiniAppTextArea.1(this);
  
  public MiniAppTextArea(@NonNull Context paramContext, int paramInt, NativeViewContainer paramNativeViewContainer)
  {
    super(paramContext);
    this.mNativeContainer = paramNativeViewContainer;
    this.mHandler = new Handler(Looper.getMainLooper());
    this.mCurInputId = paramInt;
    setPadding(0, 0, 0, 0);
    this.screenHeight = DisplayUtil.getRealHeight(getContext());
    addKeyboardListener();
    addConfirmListener();
    setBackgroundDrawable(null);
    setHorizontallyScrolling(false);
    setVerticalScrollBarEnabled(false);
    setSingleLine(false);
    setInputType(131073);
    setFocusable(true);
    setOnFocusChangeListener(new MiniAppTextArea.MyOnFocusChangeListener(this, null));
    setGlobalLayoutListener();
  }
  
  private void addConfirmListener()
  {
    if (this.mNativeContainer != null) {
      this.mNativeContainer.addConfirmListener(this);
    }
  }
  
  private void addKeyboardListener()
  {
    MiniAppTextArea.KeyboardHiddenObserver localKeyboardHiddenObserver = new MiniAppTextArea.KeyboardHiddenObserver(this);
    this.mInputKeyboardListner.put(Integer.valueOf(this.mCurInputId), localKeyboardHiddenObserver);
    this.mNativeContainer.setSoftKeyboardStateListener(localKeyboardHiddenObserver);
  }
  
  private void evaluateTextAreaHeightChange()
  {
    if (this.mNativeContainer != null) {}
    try
    {
      MiniAppTextArea.EditInfo localEditInfo = getCurEditInfo();
      if (localEditInfo.getCurLine() != this.lastLines)
      {
        this.lastLines = localEditInfo.getCurLine();
        JSONObject localJSONObject = new JSONObject();
        int j = localEditInfo.getHeight();
        int i = j;
        if (this.textAreaMinHeight != 0) {
          i = Math.max(this.textAreaMinHeight, j);
        }
        j = i;
        if (this.textAreaMaxHeight != 0) {
          j = Math.min(this.textAreaMaxHeight, i);
        }
        localJSONObject.put("height", j / DisplayUtil.getDensity(getContext()));
        localJSONObject.put("lineCount", localEditInfo.getCurLine());
        localJSONObject.put("inputId", this.mCurInputId);
        this.mNativeContainer.getPageWebviewContainer().evaluateSubscribeJS("onTextAreaHeightChange", localJSONObject.toString());
      }
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
  
  private int getDefaultHeight(float paramFloat)
  {
    Object localObject = new Paint();
    ((Paint)localObject).setTextSize(DisplayUtil.getDensity(getContext()) * paramFloat);
    localObject = ((Paint)localObject).getFontMetrics();
    return (int)(((Paint.FontMetrics)localObject).descent - ((Paint.FontMetrics)localObject).ascent);
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
  
  private void hideCurrentInput(boolean paramBoolean)
  {
    QMLog.d("MiniAppTextArea", "hideCurrentInput : " + isFocused());
    PageWebviewContainer localPageWebviewContainer;
    if (this.mNativeContainer != null) {
      localPageWebviewContainer = this.mNativeContainer.getPageWebviewContainer();
    }
    Object localObject;
    for (;;)
    {
      if ((localPageWebviewContainer != null) && (isFocused()))
      {
        clearFocus();
        localObject = (InputMethodManager)localPageWebviewContainer.getContext().getSystemService("input_method");
        if (localObject == null)
        {
          return;
          localPageWebviewContainer = null;
        }
        else
        {
          ((InputMethodManager)localObject).hideSoftInputFromWindow(localPageWebviewContainer.getWindowToken(), 0);
          if (this.hasConfirm) {
            hideKeyBoardConfirmView();
          }
        }
      }
    }
    try
    {
      localObject = new JSONObject();
      ((JSONObject)localObject).put("inputId", this.mCurInputId);
      ((JSONObject)localObject).put("value", getText().toString());
      ((JSONObject)localObject).put("cursor", getText().toString().length());
      if (paramBoolean) {
        localPageWebviewContainer.evaluateSubscribeJS("onKeyboardConfirm", ((JSONObject)localObject).toString());
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QMLog.e("MiniAppTextArea", "hideCurrentInput error", localException);
      }
    }
    this.mHandler.postDelayed(new MiniAppTextArea.2(this), 50L);
  }
  
  private void hideKeyBoardConfirmView()
  {
    if (this.mNativeContainer != null)
    {
      this.mNativeContainer.hideKeyBoardConfirmView();
      removeConfirmListener();
    }
  }
  
  private void hideSoftKeyboard(boolean paramBoolean)
  {
    if (this.mNativeContainer != null) {
      this.mNativeContainer.getPageWebviewContainer();
    }
    this.isKeyboardShow = false;
    hideKeyBoardConfirmView();
    hideCurrentInput(paramBoolean);
  }
  
  private void removeConfirmListener()
  {
    if (this.mNativeContainer != null) {
      this.mNativeContainer.removeConfirmListener(this);
    }
  }
  
  private void setGlobalLayoutListener()
  {
    this.globalLayoutListener = new MiniAppTextArea.MyOnGlobalLayoutListener(this, null);
    if (getViewTreeObserver() != null) {
      getViewTreeObserver().addOnGlobalLayoutListener(this.globalLayoutListener);
    }
  }
  
  private void showKeyBoardConfirmView(int paramInt)
  {
    if (this.mNativeContainer != null)
    {
      this.mNativeContainer.showKeyBoardConfirmView(paramInt);
      addConfirmListener();
    }
  }
  
  private void updateCursor(JSONObject paramJSONObject)
  {
    if (paramJSONObject.has("cursor"))
    {
      int i = paramJSONObject.optInt("cursor", -1);
      if (i > 0) {
        setSelection(i);
      }
    }
  }
  
  private void updateFontWeight(JSONObject paramJSONObject)
  {
    if (paramJSONObject.has("fontWeight"))
    {
      if ("bold".equals(paramJSONObject.optString("fontWeight"))) {
        setTypeface(Typeface.defaultFromStyle(1));
      }
    }
    else {
      return;
    }
    setTypeface(Typeface.defaultFromStyle(0));
  }
  
  private void updateLayoutParams(JSONObject paramJSONObject, boolean paramBoolean)
  {
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
        break label312;
      }
      i = j;
      if (!this.autoSize) {
        break label312;
      }
      if (this.textAreaMinHeight == 0)
      {
        i = 16;
        if (paramJSONObject.has("fontSize")) {
          i = paramJSONObject.optInt("fontSize");
        }
        this.textAreaMinHeight = getDefaultHeight(i);
      }
      j = this.textAreaMinHeight;
      i = j;
      if (!paramBoolean) {
        break label312;
      }
      i = j;
      if (getLayout() == null) {
        break label312;
      }
      i = j;
      if (getLayout().getHeight() <= this.textAreaMinHeight) {
        break label312;
      }
      i = getLayout().getHeight();
    }
    label312:
    for (;;)
    {
      j = (int)(DisplayUtil.getDensity(getContext()) * paramJSONObject.optInt("left") + 0.5F);
      int m = (int)(DisplayUtil.getDensity(getContext()) * paramJSONObject.optInt("top") + 0.5F);
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)getLayoutParams();
      paramJSONObject = localLayoutParams;
      if (localLayoutParams == null) {
        paramJSONObject = new FrameLayout.LayoutParams(k, i, 3);
      }
      paramJSONObject.width = k;
      paramJSONObject.height = i;
      paramJSONObject.leftMargin = j;
      paramJSONObject.topMargin = m;
      setLayoutParams(paramJSONObject);
      return;
    }
  }
  
  private void updateLength(JSONObject paramJSONObject)
  {
    if (paramJSONObject.has("maxLength"))
    {
      int i = paramJSONObject.optInt("maxLength");
      if (i > 0) {
        setFilters(new InputFilter[] { new InputFilter.LengthFilter(i) });
      }
    }
  }
  
  private void updatePlaceHolder(JSONObject paramJSONObject)
  {
    if (paramJSONObject.has("placeholder"))
    {
      String str = paramJSONObject.optString("placeholder");
      if (!StringUtil.isEmpty(str)) {
        setHint(str);
      }
    }
    if (paramJSONObject.has("placeholderStyle"))
    {
      this.placeholderStyle = paramJSONObject.optJSONObject("placeholderStyle");
      if ((this.placeholderStyle != null) && (this.placeholderStyle.has("color")))
      {
        paramJSONObject = this.placeholderStyle.optString("color");
        if (!TextUtils.isEmpty(paramJSONObject)) {
          setHintTextColor(ColorUtils.parseColor(paramJSONObject));
        }
      }
    }
  }
  
  private void updateSelection(JSONObject paramJSONObject)
  {
    if ((paramJSONObject.has("selectionStart")) || (paramJSONObject.has("selectionEnd")))
    {
      int i = paramJSONObject.optInt("selectionStart", -1);
      int j = paramJSONObject.optInt("selectionEnd", -1);
      if ((i != -1) && (j != -1) && (j > i)) {
        setSelection(i, j);
      }
    }
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
    updateLayoutParams(paramJSONObject, paramBoolean);
    updateTextAlign(paramJSONObject);
    updateFontWeight(paramJSONObject);
    if (paramJSONObject.has("fontSize")) {
      setTextSize(paramJSONObject.optInt("fontSize"));
    }
    if (paramJSONObject.has("lineSpace"))
    {
      int i = paramJSONObject.optInt("lineSpace");
      setLineSpacing(DisplayUtil.dip2px(getContext(), i), 1.0F);
    }
    if (paramJSONObject.has("color")) {
      setTextColor(ColorUtils.parseColor(paramJSONObject.optString("color")));
    }
  }
  
  private void updateTextAlign(JSONObject paramJSONObject)
  {
    if (paramJSONObject.has("textAlign"))
    {
      paramJSONObject = paramJSONObject.optString("textAlign");
      if (!"left".equals(paramJSONObject)) {
        break label34;
      }
      setGravity(3);
    }
    label34:
    do
    {
      return;
      if ("center".equals(paramJSONObject))
      {
        setGravity(1);
        return;
      }
    } while (!"right".equals(paramJSONObject));
    setGravity(5);
  }
  
  private void updateTextareaAnimator()
  {
    this.mHandler.removeCallbacks(this.translateRunable);
    this.mHandler.postDelayed(this.translateRunable, 100L);
  }
  
  private void updateTextareaHeight()
  {
    if ((this.autoSize) && (getLayout() != null) && (getLayout().getHeight() > this.textAreaMinHeight))
    {
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)getLayoutParams();
      if ((this.textAreaMaxHeight == 0) || (getLayout().getHeight() <= this.textAreaMaxHeight)) {
        localLayoutParams.height = getLayout().getHeight();
      }
      setLayoutParams(localLayoutParams);
    }
  }
  
  private void updateValue(JSONObject paramJSONObject)
  {
    if (paramJSONObject.has("value"))
    {
      paramJSONObject = paramJSONObject.optString("value");
      this.curValue = paramJSONObject;
      setText(paramJSONObject);
      if (!TextUtils.isEmpty(paramJSONObject)) {
        if (this.cursorPositation == -1) {
          break label85;
        }
      }
    }
    label85:
    for (int i = this.cursorPositation;; i = paramJSONObject.length())
    {
      QMLog.d("miniapp-textarea", "updatevalue set cursor : " + i);
      setSelection(i);
      this.cursorPositation = -1;
      return;
    }
  }
  
  public void callbackLineChange()
  {
    if (this.mNativeContainer != null) {}
    for (PageWebviewContainer localPageWebviewContainer = this.mNativeContainer.getPageWebviewContainer();; localPageWebviewContainer = null) {
      try
      {
        this.lastLines = 1;
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("height", getLineHeight() / DisplayUtil.getDensity(getContext()));
        localJSONObject.put("lineCount", 1);
        localJSONObject.put("inputId", this.mCurInputId);
        if (localPageWebviewContainer != null) {
          localPageWebviewContainer.evaluateSubscribeJS("onTextAreaHeightChange", localJSONObject.toString());
        }
        return;
      }
      catch (Throwable localThrowable)
      {
        QMLog.e("MiniAppTextArea", "callbackLineChange error.", localThrowable);
      }
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
  
  public boolean isFixed()
  {
    return this.isFixed;
  }
  
  public boolean isTextAreaFocused()
  {
    return this.isFocused;
  }
  
  public void onConfirm()
  {
    hideSoftKeyboard(true);
  }
  
  public void removeGlobalLayoutListener()
  {
    if ((getViewTreeObserver() != null) && (this.globalLayoutListener != null) && (Build.VERSION.SDK_INT >= 16)) {
      getViewTreeObserver().removeOnGlobalLayoutListener(this.globalLayoutListener);
    }
  }
  
  public void removeKeyboardListener()
  {
    SoftKeyboardStateHelper.SoftKeyboardStateListener localSoftKeyboardStateListener = (SoftKeyboardStateHelper.SoftKeyboardStateListener)this.mInputKeyboardListner.get(Integer.valueOf(this.mCurInputId));
    if (localSoftKeyboardStateListener != null) {
      this.mNativeContainer.removeSoftKeyboardStateListener(localSoftKeyboardStateListener);
    }
  }
  
  public void setAttributes(JSONObject paramJSONObject, boolean paramBoolean, NativeViewRequestEvent paramNativeViewRequestEvent)
  {
    int i = 0;
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
    if (paramJSONObject.has("hidden"))
    {
      if (paramJSONObject.optBoolean("hidden")) {
        i = 8;
      }
      setVisibility(i);
    }
    updateValue(paramJSONObject);
    updateLength(paramJSONObject);
    updatePlaceHolder(paramJSONObject);
    updateSelection(paramJSONObject);
    updateCursor(paramJSONObject);
    paramJSONObject = paramJSONObject.optJSONObject("style");
    if (paramJSONObject != null)
    {
      this.style = paramJSONObject;
      updateStyle(paramJSONObject, paramBoolean);
    }
    addTextChangedListener(new MiniAppTextArea.MyTextWatcher(this, paramJSONObject, paramNativeViewRequestEvent));
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
 * Qualified Name:     com.tencent.qqmini.miniapp.core.page.widget.MiniAppTextArea
 * JD-Core Version:    0.7.0.1
 */