package com.tencent.qqmini.miniapp.core.page.widget;

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
import com.tencent.qqmini.miniapp.core.page.NativeViewContainer;
import com.tencent.qqmini.miniapp.core.page.PageWebview;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.utils.ColorUtils;
import com.tencent.qqmini.sdk.launcher.utils.DisplayUtil;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

public class WebEditText
  extends EditText
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  private static final String TAG = "WebEditText";
  private boolean adjustPosition = false;
  private String backgroundColor = "#FFFFFFFF";
  private boolean confirmHold = false;
  private String fontWeight = "normal";
  private boolean hasMoveParent = false;
  private WebInputHandler mInputHandler;
  private int mInputId;
  private WeakReference<PageWebview> mPageWebviewRef;
  private int mWebInputHeight;
  private int mWebInputLeft;
  private int mWebInputTop;
  private int mWebInputWidth;
  private int marginBottom = 0;
  private String textAlign = "left";
  private String textColor = "#FFFFFFFF";
  
  public WebEditText(Context paramContext)
  {
    super(paramContext);
  }
  
  public WebEditText(Context paramContext, WebInputHandler paramWebInputHandler)
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
    this.mInputHandler = paramWebInputHandler;
  }
  
  private int getImeAction(String paramString)
  {
    int i = 6;
    if ("send".equals(paramString)) {
      i = 4;
    }
    do
    {
      return i;
      if ("search".equals(paramString)) {
        return 3;
      }
      if ("next".equals(paramString)) {
        return 5;
      }
    } while (!"go".equals(paramString));
    return 2;
  }
  
  private int getInputType(String paramString, boolean paramBoolean)
  {
    int i = 1;
    if (("number".equals(paramString)) || ("digit".equals(paramString)) || ("idcard".equals(paramString))) {
      i = 2;
    }
    while (!paramBoolean) {
      return i;
    }
    return 129;
  }
  
  private void parseEditStyle(Context paramContext, JSONObject paramJSONObject)
  {
    paramJSONObject = paramJSONObject.optJSONObject("style");
    if (paramJSONObject != null)
    {
      float f = DisplayUtil.getDensity(paramContext);
      this.mWebInputWidth = ((int)(paramJSONObject.optInt("width") * f));
      this.mWebInputHeight = ((int)(paramJSONObject.optInt("height") * f));
      this.mWebInputLeft = ((int)(paramJSONObject.optInt("left") * f));
      this.mWebInputTop = ((int)(f * paramJSONObject.optInt("top")));
      super.setTextSize(paramJSONObject.optInt("fontSize", 16));
      this.fontWeight = paramJSONObject.optString("fontWeight", "normal");
      this.textColor = paramJSONObject.optString("color", "#FFFFFFFF");
      this.backgroundColor = paramJSONObject.optString("backgroundColor", "#FFFFFFFF");
      this.marginBottom = ((int)(DisplayUtil.getDensity(getContext()) * paramJSONObject.optInt("marginBottom") + 0.5F));
      this.textAlign = paramJSONObject.optString("textAlign", "left");
    }
  }
  
  private void setGravity()
  {
    if ("left".equals(this.textAlign)) {
      setGravity(19);
    }
    do
    {
      return;
      if ("center".equals(this.textAlign))
      {
        setGravity(17);
        return;
      }
    } while (!"right".equals(this.textAlign));
    setGravity(21);
  }
  
  private void setKeyListener(String paramString)
  {
    if ("idcard".equals(paramString)) {
      super.setKeyListener(DigitsKeyListener.getInstance("1234567890Xx"));
    }
    while (!"digit".equals(paramString)) {
      return;
    }
    super.setKeyListener(DigitsKeyListener.getInstance("1234567890."));
  }
  
  @TargetApi(16)
  public void detach()
  {
    if (super.getParent() != null) {
      ((ViewGroup)super.getParent()).removeView(this);
    }
    super.getViewTreeObserver().removeOnGlobalLayoutListener(this);
    this.mPageWebviewRef.clear();
  }
  
  public int getInputHeight()
  {
    return this.mWebInputHeight;
  }
  
  public int getInputId()
  {
    return this.mInputId;
  }
  
  public int getMarginBottom()
  {
    return this.marginBottom;
  }
  
  public PageWebview getPageWebview()
  {
    if (this.mPageWebviewRef != null) {
      return (PageWebview)this.mPageWebviewRef.get();
    }
    return null;
  }
  
  public boolean hasMoveParent()
  {
    return this.hasMoveParent;
  }
  
  public boolean initWithWebParams(NativeViewContainer paramNativeViewContainer, String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramNativeViewContainer == null)) {
      return false;
    }
    Object localObject1 = super.getContext();
    paramNativeViewContainer = new JSONObject(paramString);
    paramString = paramNativeViewContainer.optString("type");
    super.setInputType(getInputType(paramString, paramNativeViewContainer.optBoolean("password")));
    setImeOptions(getImeAction(paramNativeViewContainer.optString("confirmType")));
    int i = paramNativeViewContainer.optInt("maxLength", -1);
    if (i != -1) {
      super.setFilters(new InputFilter[] { new InputFilter.LengthFilter(i) });
    }
    parseEditStyle((Context)localObject1, paramNativeViewContainer);
    localObject1 = paramNativeViewContainer.optString("placeholder");
    Object localObject2 = paramNativeViewContainer.optJSONObject("placeholderStyle");
    if (localObject2 != null) {
      super.setHintTextColor(ColorUtils.parseColor(((JSONObject)localObject2).optString("color", "#FFFFFFFF")));
    }
    this.adjustPosition = paramNativeViewContainer.optBoolean("adjustPosition");
    this.confirmHold = paramNativeViewContainer.optBoolean("confirmHold", false);
    localObject2 = paramNativeViewContainer.optString("defaultValue");
    if (!TextUtils.isEmpty((CharSequence)localObject2)) {
      super.setText((CharSequence)localObject2);
    }
    for (;;)
    {
      i = paramNativeViewContainer.optInt("selectionStart", -1);
      int j = paramNativeViewContainer.optInt("selectionEnd", -1);
      if ((i != -1) && (j != -1) && (j > i)) {
        setSelection(i, j);
      }
      i = paramNativeViewContainer.optInt("cursor", -1);
      if (i > 0) {
        setSelection(i);
      }
      super.setTextColor(ColorUtils.parseColor(this.textColor));
      super.setBackgroundColor(ColorUtils.parseColor(this.backgroundColor));
      super.setHint((CharSequence)localObject1);
      setGravity();
      setKeyListener(paramString);
      return true;
      super.setText("");
    }
  }
  
  public boolean isAdjustPosition()
  {
    return this.adjustPosition;
  }
  
  public boolean isConfirmHold()
  {
    return this.confirmHold;
  }
  
  public FrameLayout.LayoutParams makeLayoutParams(int paramInt)
  {
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(this.mWebInputWidth, this.mWebInputHeight);
    localLayoutParams.leftMargin = this.mWebInputLeft;
    localLayoutParams.topMargin = (this.mWebInputTop - paramInt);
    return localLayoutParams;
  }
  
  public void onGlobalLayout()
  {
    if ((this.mInputHandler != null) && (this.mInputHandler.isFocus(this.mInputId)))
    {
      super.requestFocus();
      QMLog.d("WebEditText", "showSoftInput for inputId=" + this.mInputId);
      InputMethodManager localInputMethodManager = (InputMethodManager)super.getContext().getSystemService("input_method");
      if (localInputMethodManager != null) {
        localInputMethodManager.showSoftInput(this, 0);
      }
    }
  }
  
  public boolean onKeyPreIme(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (paramKeyEvent.getAction() == 1) && (this.mInputHandler != null) && (this.mInputHandler.hasFocusInput()))
    {
      this.mInputHandler.hideCurrentInput();
      return true;
    }
    return super.onKeyPreIme(paramInt, paramKeyEvent);
  }
  
  public void setHasMoveParent(boolean paramBoolean)
  {
    this.hasMoveParent = paramBoolean;
  }
  
  public void setInputHeight(int paramInt)
  {
    this.mWebInputHeight = paramInt;
  }
  
  public void setInputId(int paramInt)
  {
    this.mInputId = paramInt;
  }
  
  public void setPageWebview(PageWebview paramPageWebview)
  {
    this.mPageWebviewRef = new WeakReference(paramPageWebview);
  }
  
  @TargetApi(16)
  public void showSoftInput()
  {
    setFocusable(true);
    setFocusableInTouchMode(true);
    requestFocus();
    InputMethodManager localInputMethodManager = (InputMethodManager)super.getContext().getSystemService("input_method");
    if (localInputMethodManager != null) {
      localInputMethodManager.showSoftInput(this, 0);
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("WebEditText{");
    localStringBuilder.append("mWebInputWidth=").append(this.mWebInputWidth);
    localStringBuilder.append(", mWebInputHeight=").append(this.mWebInputHeight);
    localStringBuilder.append(", mWebInputTop=").append(this.mWebInputTop);
    localStringBuilder.append(", mWebInputLeft=").append(this.mWebInputLeft);
    localStringBuilder.append(", mInputId=").append(this.mInputId);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.page.widget.WebEditText
 * JD-Core Version:    0.7.0.1
 */