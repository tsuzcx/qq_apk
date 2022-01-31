package com.tencent.mobileqq.mini.widget.input;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextUtils;
import android.text.method.DigitsKeyListener;
import android.view.KeyEvent;
import android.view.ViewParent;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mobileqq.mini.appbrand.jsapi.plugins.BaseJsPluginEngine;
import com.tencent.mobileqq.mini.appbrand.page.AbsAppBrandPage;
import com.tencent.mobileqq.mini.appbrand.page.PageWebview;
import com.tencent.mobileqq.mini.appbrand.utils.AppBrandTask;
import com.tencent.mobileqq.mini.util.ColorUtil;
import com.tencent.mobileqq.mini.util.ColorUtils;
import com.tencent.mobileqq.mini.util.DisplayUtil;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

public class WebEditText
  extends EditText
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  private static final String TAG = "WebEditText";
  private boolean adjustPosition;
  private String backgroundColor = "#FFFFFFFF";
  private boolean confirmHold;
  private String fontWeight = "normal";
  private boolean hasMoveParent;
  private int mInputId;
  private WeakReference<PageWebview> mPageWebviewRef;
  private int mWebInputHeight;
  private int mWebInputLeft;
  private int mWebInputTop;
  private int mWebInputWidth;
  private int marginBottom;
  private String textAlign = "left";
  private String textColor = "#FFFFFFFF";
  
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
  
  @TargetApi(16)
  public void detach()
  {
    ViewParent localViewParent = super.getParent();
    if (localViewParent != null) {
      AppBrandTask.runTaskOnUiThreadDelay(new WebEditText.1(this, localViewParent), 0L);
    }
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
  
  public boolean initWithWebParams(BaseJsPluginEngine paramBaseJsPluginEngine, AbsAppBrandPage paramAbsAppBrandPage, String paramString)
  {
    int j = 2;
    boolean bool1 = true;
    if ((TextUtils.isEmpty(paramString)) || (paramAbsAppBrandPage == null))
    {
      bool1 = false;
      return bool1;
    }
    Object localObject = super.getContext();
    paramBaseJsPluginEngine = new JSONObject(paramString);
    paramAbsAppBrandPage = paramBaseJsPluginEngine.optString("type");
    boolean bool2 = paramBaseJsPluginEngine.optBoolean("password");
    int i;
    if (("number".equals(paramAbsAppBrandPage)) || ("digit".equals(paramAbsAppBrandPage)) || ("idcard".equals(paramAbsAppBrandPage))) {
      i = 2;
    }
    for (;;)
    {
      super.setInputType(i);
      paramString = paramBaseJsPluginEngine.optString("confirmType");
      if ("send".equals(paramString))
      {
        i = 4;
        label108:
        setImeOptions(i);
        i = paramBaseJsPluginEngine.optInt("maxLength", -1);
        if (i != -1) {
          super.setFilters(new InputFilter[] { new InputFilter.LengthFilter(i) });
        }
        paramString = paramBaseJsPluginEngine.optJSONObject("style");
        if (paramString != null)
        {
          float f = DisplayUtil.getDensity((Context)localObject);
          this.mWebInputWidth = ((int)(paramString.optInt("width") * f));
          this.mWebInputHeight = ((int)(paramString.optInt("height") * f));
          this.mWebInputLeft = ((int)(paramString.optInt("left") * f));
          this.mWebInputTop = ((int)(f * paramString.optInt("top")));
          super.setTextSize(paramString.optInt("fontSize", 16));
          this.fontWeight = paramString.optString("fontWeight", "normal");
          this.textColor = paramString.optString("color", "#FFFFFFFF");
          this.backgroundColor = paramString.optString("backgroundColor", "#FFFFFFFF");
          this.marginBottom = ((int)(DisplayUtil.getDensity(getContext()) * paramString.optInt("marginBottom") + 0.5F));
          this.textAlign = paramString.optString("textAlign", "left");
        }
        paramString = paramBaseJsPluginEngine.optString("placeholder");
        localObject = paramBaseJsPluginEngine.optJSONObject("placeholderStyle");
        if (localObject != null) {
          super.setHintTextColor(ColorUtils.parseColor(((JSONObject)localObject).optString("color", "#FFFFFFFF")));
        }
        this.adjustPosition = paramBaseJsPluginEngine.optBoolean("adjustPosition");
        this.confirmHold = paramBaseJsPluginEngine.optBoolean("confirmHold", false);
        localObject = paramBaseJsPluginEngine.optString("defaultValue");
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          break label591;
        }
        super.setText((CharSequence)localObject);
        label391:
        i = paramBaseJsPluginEngine.optInt("selectionStart", -1);
        j = paramBaseJsPluginEngine.optInt("selectionEnd", -1);
        if ((i != -1) && (j != -1) && (j > i)) {
          setSelection(i, j);
        }
        i = paramBaseJsPluginEngine.optInt("cursor", -1);
        if (i > 0) {
          setSelection(i);
        }
        super.setTextColor(ColorUtil.parseColor(this.textColor));
        super.setBackgroundColor(ColorUtil.parseColor(this.backgroundColor));
        super.setHint(paramString);
        if (!"left".equals(this.textAlign)) {
          break label601;
        }
        setGravity(19);
      }
      for (;;)
      {
        if (!"idcard".equals(paramAbsAppBrandPage)) {
          break label645;
        }
        super.setKeyListener(DigitsKeyListener.getInstance("1234567890Xx"));
        return true;
        if (!bool2) {
          break label666;
        }
        i = 129;
        break;
        if ("search".equals(paramString))
        {
          i = 3;
          break label108;
        }
        if ("next".equals(paramString))
        {
          i = 5;
          break label108;
        }
        i = j;
        if ("go".equals(paramString)) {
          break label108;
        }
        i = 6;
        break label108;
        label591:
        super.setText("");
        break label391;
        label601:
        if ("center".equals(this.textAlign)) {
          setGravity(17);
        } else if ("right".equals(this.textAlign)) {
          setGravity(21);
        }
      }
      label645:
      if (!"digit".equals(paramAbsAppBrandPage)) {
        break;
      }
      super.setKeyListener(DigitsKeyListener.getInstance("1234567890."));
      return true;
      label666:
      i = 1;
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
    if (WebInputHandler.getInstance().isFocus(this.mInputId))
    {
      super.requestFocus();
      if (QLog.isColorLevel()) {
        QLog.d("WebEditText", 2, "showSoftInput for inputId=" + this.mInputId);
      }
      InputMethodManager localInputMethodManager = (InputMethodManager)super.getContext().getSystemService("input_method");
      if (localInputMethodManager != null) {
        localInputMethodManager.showSoftInput(this, 0);
      }
    }
  }
  
  public boolean onKeyPreIme(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (paramKeyEvent.getAction() == 1) && (WebInputHandler.getInstance().hasFocusInput()))
    {
      WebInputHandler.getInstance().hideCurrentInput(true);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.widget.input.WebEditText
 * JD-Core Version:    0.7.0.1
 */