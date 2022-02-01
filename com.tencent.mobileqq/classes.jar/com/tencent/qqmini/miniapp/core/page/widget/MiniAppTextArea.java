package com.tencent.qqmini.miniapp.core.page.widget;

import android.app.Activity;
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
    NativeViewContainer localNativeViewContainer = this.mNativeContainer;
    if (localNativeViewContainer != null) {
      localNativeViewContainer.addConfirmListener(this);
    }
  }
  
  private void addKeyboardListener()
  {
    MiniAppTextArea.KeyboardHiddenObserver localKeyboardHiddenObserver = new MiniAppTextArea.KeyboardHiddenObserver(this);
    this.mInputKeyboardListner.put(Integer.valueOf(this.mCurInputId), localKeyboardHiddenObserver);
    this.mNativeContainer.setSoftKeyboardStateListener(localKeyboardHiddenObserver);
  }
  
  private boolean checkHasNavBar(Activity paramActivity)
  {
    return ((DisplayUtil.hasNavBar(paramActivity)) && (DisplayUtil.isNavigationBarExist(paramActivity))) || (DisplayUtil.isFlymeOS7NavBarShow());
  }
  
  private void evaluateTextAreaHeightChange()
  {
    if (this.mNativeContainer != null) {
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
          return;
        }
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  private Activity getCurrentActivity()
  {
    NativeViewContainer localNativeViewContainer = this.mNativeContainer;
    if ((localNativeViewContainer != null) && (localNativeViewContainer.getPageWebviewContainer() != null)) {
      return this.mNativeContainer.getPageWebviewContainer().getAttachActivity();
    }
    return null;
  }
  
  private int getDefaultHeight(float paramFloat)
  {
    Object localObject = new Paint();
    ((Paint)localObject).setTextSize(paramFloat * DisplayUtil.getDensity(getContext()));
    localObject = ((Paint)localObject).getFontMetrics();
    return (int)(((Paint.FontMetrics)localObject).descent - ((Paint.FontMetrics)localObject).ascent);
  }
  
  private int getSelectionPosition()
  {
    Layout localLayout = getLayout();
    int i = 0;
    if (localLayout == null) {
      return 0;
    }
    int j = Selection.getSelectionStart(getText());
    if (j != -1) {
      i = localLayout.getLineForOffset(j) + 1;
    }
    double d = getLineHeight() * i;
    Double.isNaN(d);
    j = (int)(d + 0.5D);
    i = this.textAreaMaxHeight;
    if (i != 0)
    {
      i = Math.min(j, i);
    }
    else
    {
      int k = this.textAreaHeight;
      i = j;
      if (k != 0) {
        i = Math.min(j, k);
      }
    }
    return i + this.marginBootom + this.confirmHeight;
  }
  
  private void hideCurrentInput(boolean paramBoolean)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("hideCurrentInput : ");
    ((StringBuilder)localObject1).append(isFocused());
    QMLog.d("MiniAppTextArea", ((StringBuilder)localObject1).toString());
    localObject1 = this.mNativeContainer;
    if (localObject1 != null) {
      localObject1 = ((NativeViewContainer)localObject1).getPageWebviewContainer();
    } else {
      localObject1 = null;
    }
    if ((localObject1 != null) && (isFocused()))
    {
      clearFocus();
      Object localObject2 = (InputMethodManager)((PageWebviewContainer)localObject1).getContext().getSystemService("input_method");
      if (localObject2 == null) {
        return;
      }
      ((InputMethodManager)localObject2).hideSoftInputFromWindow(((PageWebviewContainer)localObject1).getWindowToken(), 0);
      if (this.hasConfirm) {
        hideKeyBoardConfirmView();
      }
      try
      {
        localObject2 = new JSONObject();
        ((JSONObject)localObject2).put("inputId", this.mCurInputId);
        ((JSONObject)localObject2).put("value", getText().toString());
        ((JSONObject)localObject2).put("cursor", getText().toString().length());
        if (paramBoolean) {
          ((PageWebviewContainer)localObject1).evaluateSubscribeJS("onKeyboardConfirm", ((JSONObject)localObject2).toString());
        }
      }
      catch (Exception localException)
      {
        QMLog.e("MiniAppTextArea", "hideCurrentInput error", localException);
      }
    }
    this.mHandler.postDelayed(new MiniAppTextArea.2(this), 50L);
  }
  
  private void hideKeyBoardConfirmView()
  {
    NativeViewContainer localNativeViewContainer = this.mNativeContainer;
    if (localNativeViewContainer != null)
    {
      localNativeViewContainer.hideKeyBoardConfirmView();
      removeConfirmListener();
    }
  }
  
  private void hideSoftKeyboard(boolean paramBoolean)
  {
    NativeViewContainer localNativeViewContainer = this.mNativeContainer;
    if (localNativeViewContainer != null) {
      localNativeViewContainer.getPageWebviewContainer();
    }
    this.isKeyboardShow = false;
    hideKeyBoardConfirmView();
    hideCurrentInput(paramBoolean);
  }
  
  private boolean needUpdateLayoutParams(JSONObject paramJSONObject)
  {
    return (paramJSONObject.has("width")) || (paramJSONObject.has("height")) || (paramJSONObject.has("left")) || (paramJSONObject.has("top"));
  }
  
  private void removeConfirmListener()
  {
    NativeViewContainer localNativeViewContainer = this.mNativeContainer;
    if (localNativeViewContainer != null) {
      localNativeViewContainer.removeConfirmListener(this);
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
    NativeViewContainer localNativeViewContainer = this.mNativeContainer;
    if (localNativeViewContainer != null)
    {
      localNativeViewContainer.showKeyBoardConfirmView(paramInt);
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
  
  private void updateCursorPosition(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 > 0)
    {
      if (paramInt2 > 0)
      {
        this.cursorPositation = paramInt1;
        return;
      }
      if (paramInt3 > 0) {
        this.cursorPositation = (paramInt1 + paramInt3);
      }
    }
  }
  
  private void updateFontWeight(JSONObject paramJSONObject)
  {
    if (paramJSONObject.has("fontWeight"))
    {
      if ("bold".equals(paramJSONObject.optString("fontWeight")))
      {
        setTypeface(Typeface.defaultFromStyle(1));
        return;
      }
      setTypeface(Typeface.defaultFromStyle(0));
    }
  }
  
  private void updateLayoutParams(JSONObject paramJSONObject, boolean paramBoolean)
  {
    if (needUpdateLayoutParams(paramJSONObject))
    {
      int k = (int)Math.max(DisplayUtil.getDensity(getContext()) * paramJSONObject.optInt("width") + 0.5F, 0.0F);
      this.textAreaHeight = ((int)Math.max(DisplayUtil.getDensity(getContext()) * paramJSONObject.optInt("height") + 0.5F, 0.0F));
      int j = this.textAreaHeight;
      int i = j;
      if (j == 0)
      {
        i = j;
        if (this.autoSize)
        {
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
          if (paramBoolean)
          {
            i = j;
            if (getLayout() != null)
            {
              i = j;
              if (getLayout().getHeight() > this.textAreaMinHeight) {
                i = getLayout().getHeight();
              }
            }
          }
        }
      }
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
      paramJSONObject = this.placeholderStyle;
      if ((paramJSONObject != null) && (paramJSONObject.has("color")))
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
    int i = this.textAreaMaxHeight;
    if (i != 0) {
      setMaxHeight(i);
    }
    i = this.textAreaMinHeight;
    if (i != 0)
    {
      setMinHeight(i);
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
      i = paramJSONObject.optInt("lineSpace");
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
      if ("left".equals(paramJSONObject))
      {
        setGravity(3);
        return;
      }
      if ("center".equals(paramJSONObject))
      {
        setGravity(1);
        return;
      }
      if ("right".equals(paramJSONObject)) {
        setGravity(5);
      }
    }
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
      if (!TextUtils.isEmpty(paramJSONObject))
      {
        int i = this.cursorPositation;
        if (i == -1) {
          i = paramJSONObject.length();
        }
        paramJSONObject = new StringBuilder();
        paramJSONObject.append("updatevalue set cursor : ");
        paramJSONObject.append(i);
        QMLog.d("miniapp-textarea", paramJSONObject.toString());
        setSelection(i);
      }
      this.cursorPositation = -1;
    }
  }
  
  public void callbackLineChange()
  {
    Object localObject = this.mNativeContainer;
    if (localObject != null) {
      localObject = ((NativeViewContainer)localObject).getPageWebviewContainer();
    } else {
      localObject = null;
    }
    try
    {
      this.lastLines = 1;
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("height", getLineHeight() / DisplayUtil.getDensity(getContext()));
      localJSONObject.put("lineCount", 1);
      localJSONObject.put("inputId", this.mCurInputId);
      if (localObject != null)
      {
        ((PageWebviewContainer)localObject).evaluateSubscribeJS("onTextAreaHeightChange", localJSONObject.toString());
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      QMLog.e("MiniAppTextArea", "callbackLineChange error.", localThrowable);
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
    if (paramJSONObject.has("data")) {
      this.data = paramJSONObject.optString("data");
    }
    boolean bool = paramJSONObject.has("autoSize");
    int i = 0;
    if (bool) {
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