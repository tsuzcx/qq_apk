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
import com.tencent.mobileqq.mini.appbrand.page.WebviewContainer;
import com.tencent.mobileqq.mini.appbrand.utils.AppBrandTask;
import com.tencent.mobileqq.mini.ui.NavigationBar;
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
    Object localObject1 = super.getContext();
    paramBaseJsPluginEngine = new JSONObject(paramString);
    paramString = paramBaseJsPluginEngine.optString("type");
    boolean bool2 = paramBaseJsPluginEngine.optBoolean("password");
    int i;
    if (("number".equals(paramString)) || ("digit".equals(paramString)) || ("idcard".equals(paramString))) {
      i = 2;
    }
    for (;;)
    {
      super.setInputType(i);
      Object localObject2 = paramBaseJsPluginEngine.optString("confirmType");
      label110:
      float f;
      if ("send".equals(localObject2))
      {
        i = 4;
        setImeOptions(i);
        i = paramBaseJsPluginEngine.optInt("maxLength", -1);
        if (i != -1) {
          super.setFilters(new InputFilter[] { new InputFilter.LengthFilter(i) });
        }
        localObject2 = paramBaseJsPluginEngine.optJSONObject("style");
        if (localObject2 != null)
        {
          f = DisplayUtil.getDensity((Context)localObject1);
          this.mWebInputWidth = ((int)(((JSONObject)localObject2).optInt("width") * f));
          this.mWebInputHeight = ((int)(((JSONObject)localObject2).optInt("height") * f));
          this.mWebInputLeft = ((int)(((JSONObject)localObject2).optInt("left") * f));
          if ((paramAbsAppBrandPage.getCurrentWebviewContainer() == null) || (!paramAbsAppBrandPage.getCurrentWebviewContainer().isCustomNavibar())) {
            break label627;
          }
          this.mWebInputTop = ((int)(f * ((JSONObject)localObject2).optInt("top")));
          label252:
          super.setTextSize(((JSONObject)localObject2).optInt("fontSize", 16));
          this.fontWeight = ((JSONObject)localObject2).optString("fontWeight", "normal");
          this.textColor = ((JSONObject)localObject2).optString("color", "#FFFFFFFF");
          this.backgroundColor = ((JSONObject)localObject2).optString("backgroundColor", "#FFFFFFFF");
          this.marginBottom = ((int)(DisplayUtil.getDensity(getContext()) * ((JSONObject)localObject2).optInt("marginBottom") + 0.5F));
          this.textAlign = ((JSONObject)localObject2).optString("textAlign", "left");
        }
        paramAbsAppBrandPage = paramBaseJsPluginEngine.optString("placeholder");
        localObject1 = paramBaseJsPluginEngine.optJSONObject("placeholderStyle");
        if (localObject1 != null) {
          super.setHintTextColor(ColorUtils.parseColor(((JSONObject)localObject1).optString("color", "#FFFFFFFF")));
        }
        this.adjustPosition = paramBaseJsPluginEngine.optBoolean("adjustPosition");
        this.confirmHold = paramBaseJsPluginEngine.optBoolean("confirmHold", false);
        localObject1 = paramBaseJsPluginEngine.optString("defaultValue");
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          break label654;
        }
        super.setText((CharSequence)localObject1);
        label424:
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
        super.setHint(paramAbsAppBrandPage);
        if (!"left".equals(this.textAlign)) {
          break label664;
        }
        setGravity(19);
      }
      for (;;)
      {
        if (!"idcard".equals(paramString)) {
          break label708;
        }
        super.setKeyListener(DigitsKeyListener.getInstance("1234567890Xx"));
        return true;
        if (!bool2) {
          break label729;
        }
        i = 129;
        break;
        if ("search".equals(localObject2))
        {
          i = 3;
          break label110;
        }
        if ("next".equals(localObject2))
        {
          i = 5;
          break label110;
        }
        i = j;
        if ("go".equals(localObject2)) {
          break label110;
        }
        i = 6;
        break label110;
        label627:
        this.mWebInputTop = ((int)(f * ((JSONObject)localObject2).optInt("top")) + paramAbsAppBrandPage.getNavBar().getHeight());
        break label252;
        label654:
        super.setText("");
        break label424;
        label664:
        if ("center".equals(this.textAlign)) {
          setGravity(17);
        } else if ("right".equals(this.textAlign)) {
          setGravity(21);
        }
      }
      label708:
      if (!"digit".equals(paramString)) {
        break;
      }
      super.setKeyListener(DigitsKeyListener.getInstance("1234567890."));
      return true;
      label729:
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.widget.input.WebEditText
 * JD-Core Version:    0.7.0.1
 */