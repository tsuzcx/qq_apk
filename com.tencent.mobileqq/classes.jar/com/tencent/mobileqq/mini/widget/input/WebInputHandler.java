package com.tencent.mobileqq.mini.widget.input;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.ViewTreeObserver;
import android.view.inputmethod.InputMethodManager;
import com.tencent.mobileqq.mini.appbrand.BaseAppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.jsapi.plugins.BaseJsPluginEngine;
import com.tencent.mobileqq.mini.appbrand.page.AbsAppBrandPage;
import com.tencent.mobileqq.mini.appbrand.page.AppBrandPageContainer;
import com.tencent.mobileqq.mini.appbrand.page.PageWebview;
import com.tencent.mobileqq.mini.appbrand.page.PageWebview.OnWebviewScrollListener;
import com.tencent.mobileqq.mini.appbrand.page.ServiceOriginalWebview;
import com.tencent.mobileqq.mini.appbrand.page.ServiceWebview;
import com.tencent.mobileqq.mini.ui.NavigationBar;
import com.tencent.mobileqq.mini.util.ApiUtil;
import com.tencent.mobileqq.mini.util.DisplayUtil;
import com.tencent.mobileqq.mini.utils.EditAreaAnimatorUtil;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

public final class WebInputHandler
{
  private static final int DEFAULT_SPACING = 5;
  private static final String TAG = "WebInputHandler";
  private static WebInputHandler sMe;
  private boolean adjustPosition;
  private int inputId;
  private int lastOffset;
  private WebEditText mCurrentFocusInput;
  private AtomicInteger mInputIdGenerator = new AtomicInteger(0);
  private Object mInputLock = new Object();
  private AbsAppBrandPage mPage;
  private Map<Integer, String> mSetValue = new HashMap();
  private Map<Integer, WebEditText> mShowingInput = new ConcurrentHashMap();
  private int navbarHeight;
  private int offset;
  private int screenHeight;
  public PageWebview.OnWebviewScrollListener scrollListener;
  private int showKeyboardHeight;
  
  public static WebInputHandler getInstance()
  {
    try
    {
      if (sMe == null) {
        sMe = new WebInputHandler();
      }
      WebInputHandler localWebInputHandler = sMe;
      return localWebInputHandler;
    }
    finally {}
  }
  
  private void hideInput(WebEditText paramWebEditText, Context paramContext)
  {
    ((InputMethodManager)paramContext.getSystemService("input_method")).hideSoftInputFromWindow(paramWebEditText.getWindowToken(), 0);
  }
  
  private void updateViewOffset()
  {
    WebEditText localWebEditText = (WebEditText)this.mShowingInput.get(Integer.valueOf(this.inputId));
    if ((localWebEditText == null) || (!localWebEditText.isFocused()) || (localWebEditText.hasMoveParent())) {
      return;
    }
    this.adjustPosition = localWebEditText.isAdjustPosition();
    int i = localWebEditText.getBottom();
    int j = localWebEditText.getMarginBottom();
    i = this.screenHeight - (i + j);
    if ((this.adjustPosition) && (i < this.showKeyboardHeight))
    {
      this.offset = (-(this.showKeyboardHeight - i));
      if (this.offset != this.lastOffset)
      {
        EditAreaAnimatorUtil.editAreaAnimator(this.mPage, this.lastOffset, this.offset, 1.0F, 1.0F);
        this.lastOffset = this.offset;
      }
    }
    localWebEditText.setHasMoveParent(true);
  }
  
  public Map<Integer, WebEditText> getShowingInput()
  {
    return this.mShowingInput;
  }
  
  public boolean hasFocusInput()
  {
    return this.mCurrentFocusInput != null;
  }
  
  public void hideCurrentInput(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("WebInputHandler", 2, "[hideCurrentInput] hideSoftInput=" + paramBoolean);
    }
    if (this.mCurrentFocusInput == null)
    {
      QLog.e("WebInputHandler", 2, "mCurrentFocusInput is null, return.");
      return;
    }
    if (this.mShowingInput.size() > 0)
    {
      Iterator localIterator = this.mShowingInput.entrySet().iterator();
      for (;;)
      {
        if (localIterator.hasNext())
        {
          Object localObject = (WebEditText)((Map.Entry)localIterator.next()).getValue();
          if (QLog.isColorLevel()) {
            QLog.d("WebInputHandler", 2, "[hideCurrentInput] webEditText=" + localObject);
          }
          int i = ((WebEditText)localObject).getInputId();
          String str = ((WebEditText)localObject).getText().toString();
          PageWebview localPageWebview = ((WebEditText)localObject).getPageWebview();
          if ((this.mCurrentFocusInput != null) && (this.mCurrentFocusInput.getInputId() == ((WebEditText)localObject).getInputId()) && (paramBoolean)) {
            ((InputMethodManager)((WebEditText)localObject).getContext().getSystemService("input_method")).hideSoftInputFromWindow(((WebEditText)localObject).getWindowToken(), 0);
          }
          ((WebEditText)localObject).clearFocus();
          ((WebEditText)localObject).detach();
          ((WebEditText)localObject).setHasMoveParent(false);
          this.mShowingInput.remove(Integer.valueOf(i));
          if (localPageWebview == null) {
            continue;
          }
          try
          {
            localObject = new JSONObject();
            ((JSONObject)localObject).put("inputId", i);
            ((JSONObject)localObject).put("value", str);
            ((JSONObject)localObject).put("cursor", str.length());
            localPageWebview.evaluateSubcribeJS("onKeyboardComplete", ((JSONObject)localObject).toString(), localPageWebview.pageWebviewId);
            if (this.scrollListener != null) {
              localPageWebview.removeWebviewScrollListener(this.scrollListener);
            }
          }
          catch (Exception localException)
          {
            for (;;)
            {
              Log.e("WebInputHandler", "[hideCurrentInput] exception:", localException);
            }
          }
        }
      }
    }
    this.mCurrentFocusInput = null;
  }
  
  public void hideKeyboard(BaseJsPluginEngine paramBaseJsPluginEngine, JsRuntime paramJsRuntime, String paramString, int paramInt)
  {
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("WebInputHandler", 2, "[hideKeyboard] jsPluginEngine=" + paramBaseJsPluginEngine + ", webview=" + paramJsRuntime + ", webParams=" + paramString + ", callbackId=" + paramInt);
        }
        synchronized (this.mInputLock)
        {
          if (((paramJsRuntime instanceof ServiceWebview)) || ((paramJsRuntime instanceof ServiceOriginalWebview)))
          {
            if (this.mCurrentFocusInput != null)
            {
              hideCurrentInput(true);
              paramJsRuntime.evaluateCallbackJs(paramInt, ApiUtil.wrapCallbackOk("hideKeyboard", null).toString());
            }
            return;
          }
          if ((paramBaseJsPluginEngine == null) || (paramBaseJsPluginEngine.appBrandRuntime == null) || (paramBaseJsPluginEngine.appBrandRuntime.getContainer() == null))
          {
            if (QLog.isColorLevel()) {
              QLog.e("WebInputHandler", 2, "[hideKeyboard] runtime error");
            }
            paramJsRuntime.evaluateCallbackJs(paramInt, ApiUtil.wrapCallbackFail("hideKeyboard", null).toString());
          }
        }
        if (!TextUtils.isEmpty(paramString)) {
          break label241;
        }
      }
      finally {}
      if (QLog.isColorLevel()) {
        QLog.e("WebInputHandler", 2, "[hideKeyboard] no web input params");
      }
      paramJsRuntime.evaluateCallbackJs(paramInt, ApiUtil.wrapCallbackFail("hideKeyboard", null).toString());
      continue;
      label241:
      if ((AbsAppBrandPage)((AppBrandPageContainer)paramBaseJsPluginEngine.appBrandRuntime.getContainer()).pageLinkedList.peek() == null)
      {
        paramJsRuntime.evaluateCallbackJs(paramInt, ApiUtil.wrapCallbackFail("hideKeyboard", null).toString());
      }
      else
      {
        try
        {
          paramJsRuntime.getContextEx();
          int i = new JSONObject(paramString).optInt("inputId");
          if (!this.mShowingInput.containsKey(Integer.valueOf(i)))
          {
            paramJsRuntime.evaluateCallbackJs(paramInt, ApiUtil.wrapCallbackOk("hideKeyboard", null).toString());
            continue;
          }
          paramString = (WebEditText)this.mShowingInput.get(Integer.valueOf(i));
          this.mSetValue.remove(Integer.valueOf(i));
          paramJsRuntime.evaluateCallbackJs(paramInt, ApiUtil.wrapCallbackOk("hideKeyboard", null).toString());
          paramBaseJsPluginEngine = new JSONObject();
          paramBaseJsPluginEngine.put("inputId", i);
          paramBaseJsPluginEngine.put("value", paramString.getText().toString());
          paramBaseJsPluginEngine.put("cursor", paramString.getText().toString().length());
          hideCurrentInput(true);
          paramJsRuntime = (PageWebview)paramJsRuntime;
          paramJsRuntime.evaluateSubcribeJS("onKeyboardComplete", paramBaseJsPluginEngine.toString(), paramJsRuntime.pageWebviewId);
        }
        catch (Exception paramBaseJsPluginEngine) {}
        if (QLog.isColorLevel()) {
          QLog.e("WebInputHandler", 2, "hideKeyboard, exception", paramBaseJsPluginEngine);
        }
      }
    }
  }
  
  public boolean isFocus(int paramInt)
  {
    return (this.mCurrentFocusInput != null) && (this.mCurrentFocusInput.getInputId() == paramInt);
  }
  
  public void setKeyboardValue(BaseJsPluginEngine paramBaseJsPluginEngine, JsRuntime paramJsRuntime, String paramString, int paramInt)
  {
    label126:
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("WebInputHandler", 2, "[setKeyboardValue] jsPluginEngine=" + paramBaseJsPluginEngine + ", webview=" + paramJsRuntime + ", webParams=" + paramString + ", callbackId=" + paramInt);
      }
      try
      {
        paramString = new JSONObject(paramString);
        j = paramString.optInt("inputId");
        paramBaseJsPluginEngine = (WebEditText)this.mShowingInput.get(Integer.valueOf(j));
        if (paramBaseJsPluginEngine != null) {
          break label126;
        }
        paramJsRuntime.evaluateCallbackJs(paramInt, ApiUtil.wrapCallbackFail("setKeyboardValue", null).toString());
      }
      catch (Exception paramBaseJsPluginEngine)
      {
        for (;;)
        {
          int j;
          QLog.e("WebInputHandler", 1, "setKeyboardValue error.", paramBaseJsPluginEngine);
        }
      }
      return;
    }
    finally {}
    paramString = paramString.optString("value");
    this.mSetValue.put(Integer.valueOf(j), paramString);
    paramBaseJsPluginEngine.setText(paramString);
    if (paramString != null) {}
    for (int i = paramString.length();; i = 0)
    {
      paramBaseJsPluginEngine.setSelection(i);
      paramBaseJsPluginEngine = ApiUtil.wrapCallbackOk("setKeyboardValue", null);
      paramBaseJsPluginEngine.put("inputId", j);
      paramJsRuntime.evaluateCallbackJs(paramInt, paramBaseJsPluginEngine.toString());
      break;
    }
  }
  
  public void showKeyboard(BaseJsPluginEngine paramBaseJsPluginEngine, JsRuntime paramJsRuntime, String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebInputHandler", 2, "[showKeyboard] jsPluginEngine=" + paramBaseJsPluginEngine + ", webview=" + paramJsRuntime + ", webParams=" + paramString + ", callbackId=" + paramInt);
    }
    synchronized (this.mInputLock)
    {
      if (QLog.isColorLevel()) {
        QLog.d("WebInputHandler", 2, "[showKeyboard] mCurrentFocusInput=" + this.mCurrentFocusInput);
      }
      if ((paramJsRuntime == null) || (!(paramJsRuntime instanceof PageWebview)))
      {
        Log.e("WebInputHandler", "[showKeyboard] invalid webview");
        return;
      }
      if ((paramBaseJsPluginEngine == null) || (paramBaseJsPluginEngine.appBrandRuntime == null) || (paramBaseJsPluginEngine.appBrandRuntime.getContainer() == null))
      {
        if (QLog.isColorLevel()) {
          QLog.e("WebInputHandler", 2, "[showKeyboard] runtime error");
        }
        paramJsRuntime.evaluateCallbackJs(paramInt, ApiUtil.wrapCallbackFail("showKeyboard", null).toString());
        return;
      }
    }
    if (TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.e("WebInputHandler", 2, "[showKeyboard] no web input params");
      }
      paramJsRuntime.evaluateCallbackJs(paramInt, ApiUtil.wrapCallbackFail("showKeyboard", null).toString());
      return;
    }
    this.mPage = ((AbsAppBrandPage)((AppBrandPageContainer)paramBaseJsPluginEngine.appBrandRuntime.getContainer()).pageLinkedList.peek());
    if (this.mPage == null)
    {
      paramJsRuntime.evaluateCallbackJs(paramInt, ApiUtil.wrapCallbackFail("showKeyboard", null).toString());
      return;
    }
    this.screenHeight = DisplayUtil.getRealHeight(this.mPage.getContext());
    this.navbarHeight = this.mPage.getNavBar().getHeight();
    hideCurrentInput(false);
    paramJsRuntime = new WebEditText(paramJsRuntime.getContextEx());
    try
    {
      bool = paramJsRuntime.initWithWebParams(paramBaseJsPluginEngine, this.mPage, paramString);
      this.inputId = this.mInputIdGenerator.incrementAndGet();
      paramBaseJsPluginEngine.setCurInputId(this.inputId);
      PageWebview localPageWebview = this.mPage.getCurrentPageWebview();
      this.scrollListener = new WebInputHandler.1(this, localPageWebview);
      localPageWebview.setOnWebviewScrollListener(this.scrollListener);
      if (bool) {}
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("WebInputHandler", 2, new Object[] { "[showKeyboard] makeLayoutParams scrollY:", Integer.valueOf(localPageWebview.scrollY) });
        }
        this.mPage.addView(paramJsRuntime, paramJsRuntime.makeLayoutParams(this.mPage.getCurrentPageWebview().scrollY));
        this.mCurrentFocusInput = paramJsRuntime;
        paramJsRuntime.setInputId(this.inputId);
        paramJsRuntime.setPageWebview(localPageWebview);
        this.mShowingInput.put(Integer.valueOf(this.inputId), paramJsRuntime);
        paramJsRuntime.showSoftInput();
        paramJsRuntime.addTextChangedListener(new WebInputHandler.2(this, paramString, paramBaseJsPluginEngine, localPageWebview));
        paramJsRuntime.setOnEditorActionListener(new WebInputHandler.3(this, paramJsRuntime, localPageWebview));
        paramJsRuntime.getViewTreeObserver().addOnGlobalLayoutListener(new WebInputHandler.4(this));
        paramBaseJsPluginEngine = ApiUtil.wrapCallbackOk("showKeyboard", null);
        paramBaseJsPluginEngine.put("inputId", this.inputId);
        localPageWebview.evaluateCallbackJs(paramInt, paramBaseJsPluginEngine.toString());
      }
      catch (Exception paramBaseJsPluginEngine)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("WebInputHandler", 2, "[showKeyboard] exception:", paramBaseJsPluginEngine);
          }
        }
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("WebInputHandler", 2, "[showKeyboard] initWithWebParams exception:", localException);
        }
        boolean bool = false;
        continue;
        localException.evaluateCallbackJs(paramInt, ApiUtil.wrapCallbackFail("showKeyboard", null).toString());
      }
    }
  }
  
  /* Error */
  public boolean updateInput(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 54	com/tencent/mobileqq/mini/widget/input/WebInputHandler:mShowingInput	Ljava/util/Map;
    //   6: astore 10
    //   8: aload 10
    //   10: ifnonnull +11 -> 21
    //   13: iconst_0
    //   14: istore 9
    //   16: aload_0
    //   17: monitorexit
    //   18: iload 9
    //   20: ireturn
    //   21: new 259	org/json/JSONObject
    //   24: dup
    //   25: aload_1
    //   26: invokespecial 378	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   29: astore 10
    //   31: aload_0
    //   32: getfield 54	com/tencent/mobileqq/mini/widget/input/WebInputHandler:mShowingInput	Ljava/util/Map;
    //   35: aload 10
    //   37: ldc_w 261
    //   40: invokevirtual 382	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   43: invokestatic 120	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   46: invokeinterface 126 2 0
    //   51: checkcast 106	com/tencent/mobileqq/mini/widget/input/WebEditText
    //   54: astore_1
    //   55: aload_1
    //   56: ifnonnull +9 -> 65
    //   59: iconst_0
    //   60: istore 9
    //   62: goto -46 -> 16
    //   65: aload 10
    //   67: ldc_w 267
    //   70: invokevirtual 538	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   73: ifeq +28 -> 101
    //   76: aload 10
    //   78: ldc_w 267
    //   81: invokevirtual 401	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   84: astore 11
    //   86: aload_1
    //   87: aload 11
    //   89: invokevirtual 408	com/tencent/mobileqq/mini/widget/input/WebEditText:setText	(Ljava/lang/CharSequence;)V
    //   92: aload_1
    //   93: aload 11
    //   95: invokevirtual 277	java/lang/String:length	()I
    //   98: invokevirtual 411	com/tencent/mobileqq/mini/widget/input/WebEditText:setSelection	(I)V
    //   101: aload 10
    //   103: ldc_w 540
    //   106: iconst_m1
    //   107: invokevirtual 543	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   110: istore_3
    //   111: aload 10
    //   113: ldc_w 545
    //   116: iconst_m1
    //   117: invokevirtual 543	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   120: istore 4
    //   122: iload_3
    //   123: iconst_m1
    //   124: if_icmpeq +22 -> 146
    //   127: iload 4
    //   129: iconst_m1
    //   130: if_icmpeq +16 -> 146
    //   133: iload 4
    //   135: iload_3
    //   136: if_icmple +10 -> 146
    //   139: aload_1
    //   140: iload_3
    //   141: iload 4
    //   143: invokevirtual 548	com/tencent/mobileqq/mini/widget/input/WebEditText:setSelection	(II)V
    //   146: aload 10
    //   148: ldc_w 272
    //   151: iconst_m1
    //   152: invokevirtual 543	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   155: istore_3
    //   156: iload_3
    //   157: ifle +8 -> 165
    //   160: aload_1
    //   161: iload_3
    //   162: invokevirtual 411	com/tencent/mobileqq/mini/widget/input/WebEditText:setSelection	(I)V
    //   165: aload 10
    //   167: ldc_w 550
    //   170: invokevirtual 554	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   173: astore 10
    //   175: aload 10
    //   177: ifnull +206 -> 383
    //   180: aload 10
    //   182: ldc_w 556
    //   185: invokevirtual 382	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   188: istore 6
    //   190: aload 10
    //   192: ldc_w 558
    //   195: invokevirtual 382	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   198: istore 5
    //   200: aload 10
    //   202: ldc_w 560
    //   205: invokevirtual 382	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   208: istore_3
    //   209: aload 10
    //   211: ldc_w 562
    //   214: invokevirtual 382	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   217: istore 4
    //   219: aload_1
    //   220: invokevirtual 248	com/tencent/mobileqq/mini/widget/input/WebEditText:getContext	()Landroid/content/Context;
    //   223: invokestatic 566	com/tencent/mobileqq/mini/util/DisplayUtil:getDensity	(Landroid/content/Context;)F
    //   226: fstore_2
    //   227: iload_3
    //   228: i2f
    //   229: fload_2
    //   230: fmul
    //   231: ldc_w 567
    //   234: fadd
    //   235: fconst_0
    //   236: invokestatic 573	java/lang/Math:max	(FF)F
    //   239: f2i
    //   240: istore_3
    //   241: iload 4
    //   243: i2f
    //   244: fload_2
    //   245: fmul
    //   246: ldc_w 567
    //   249: fadd
    //   250: fconst_0
    //   251: invokestatic 573	java/lang/Math:max	(FF)F
    //   254: f2i
    //   255: istore 4
    //   257: iload 6
    //   259: i2f
    //   260: fload_2
    //   261: fmul
    //   262: ldc_w 567
    //   265: fadd
    //   266: f2i
    //   267: istore 6
    //   269: aload_0
    //   270: aload_0
    //   271: getfield 75	com/tencent/mobileqq/mini/widget/input/WebInputHandler:mPage	Lcom/tencent/mobileqq/mini/appbrand/page/AbsAppBrandPage;
    //   274: invokevirtual 439	com/tencent/mobileqq/mini/appbrand/page/AbsAppBrandPage:getNavBar	()Lcom/tencent/mobileqq/mini/ui/NavigationBar;
    //   277: invokevirtual 444	com/tencent/mobileqq/mini/ui/NavigationBar:getHeight	()I
    //   280: putfield 446	com/tencent/mobileqq/mini/widget/input/WebInputHandler:navbarHeight	I
    //   283: ldc_w 575
    //   286: aload_0
    //   287: getfield 75	com/tencent/mobileqq/mini/widget/input/WebInputHandler:mPage	Lcom/tencent/mobileqq/mini/appbrand/page/AbsAppBrandPage;
    //   290: invokevirtual 439	com/tencent/mobileqq/mini/appbrand/page/AbsAppBrandPage:getNavBar	()Lcom/tencent/mobileqq/mini/ui/NavigationBar;
    //   293: invokevirtual 578	com/tencent/mobileqq/mini/ui/NavigationBar:getNavbarStyle	()Ljava/lang/String;
    //   296: invokevirtual 581	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   299: ifeq +8 -> 307
    //   302: aload_0
    //   303: iconst_0
    //   304: putfield 446	com/tencent/mobileqq/mini/widget/input/WebInputHandler:navbarHeight	I
    //   307: iload 5
    //   309: i2f
    //   310: fload_2
    //   311: fmul
    //   312: ldc_w 567
    //   315: fadd
    //   316: f2i
    //   317: istore 5
    //   319: aload_0
    //   320: getfield 75	com/tencent/mobileqq/mini/widget/input/WebInputHandler:mPage	Lcom/tencent/mobileqq/mini/appbrand/page/AbsAppBrandPage;
    //   323: invokevirtual 462	com/tencent/mobileqq/mini/appbrand/page/AbsAppBrandPage:getCurrentPageWebview	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   326: getfield 475	com/tencent/mobileqq/mini/appbrand/page/PageWebview:scrollY	I
    //   329: istore 7
    //   331: aload_0
    //   332: getfield 446	com/tencent/mobileqq/mini/widget/input/WebInputHandler:navbarHeight	I
    //   335: istore 8
    //   337: aload_1
    //   338: invokevirtual 585	com/tencent/mobileqq/mini/widget/input/WebEditText:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   341: checkcast 587	android/widget/FrameLayout$LayoutParams
    //   344: astore 10
    //   346: aload 10
    //   348: iload_3
    //   349: putfield 589	android/widget/FrameLayout$LayoutParams:width	I
    //   352: aload 10
    //   354: iload 4
    //   356: putfield 591	android/widget/FrameLayout$LayoutParams:height	I
    //   359: aload 10
    //   361: iload 6
    //   363: putfield 594	android/widget/FrameLayout$LayoutParams:leftMargin	I
    //   366: aload 10
    //   368: iload 8
    //   370: iload 5
    //   372: iload 7
    //   374: isub
    //   375: iadd
    //   376: putfield 597	android/widget/FrameLayout$LayoutParams:topMargin	I
    //   379: aload_1
    //   380: invokevirtual 600	com/tencent/mobileqq/mini/widget/input/WebEditText:requestLayout	()V
    //   383: iconst_1
    //   384: istore 9
    //   386: goto -370 -> 16
    //   389: astore_1
    //   390: aload_1
    //   391: invokevirtual 603	java/lang/Exception:printStackTrace	()V
    //   394: iconst_0
    //   395: istore 9
    //   397: goto -381 -> 16
    //   400: astore_1
    //   401: aload_0
    //   402: monitorexit
    //   403: aload_1
    //   404: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	405	0	this	WebInputHandler
    //   0	405	1	paramString	String
    //   226	85	2	f	float
    //   110	239	3	i	int
    //   120	235	4	j	int
    //   198	177	5	k	int
    //   188	174	6	m	int
    //   329	46	7	n	int
    //   335	41	8	i1	int
    //   14	382	9	bool	boolean
    //   6	361	10	localObject	Object
    //   84	10	11	str	String
    // Exception table:
    //   from	to	target	type
    //   21	55	389	java/lang/Exception
    //   65	101	389	java/lang/Exception
    //   101	122	389	java/lang/Exception
    //   139	146	389	java/lang/Exception
    //   146	156	389	java/lang/Exception
    //   160	165	389	java/lang/Exception
    //   165	175	389	java/lang/Exception
    //   180	257	389	java/lang/Exception
    //   269	307	389	java/lang/Exception
    //   319	383	389	java/lang/Exception
    //   2	8	400	finally
    //   21	55	400	finally
    //   65	101	400	finally
    //   101	122	400	finally
    //   139	146	400	finally
    //   146	156	400	finally
    //   160	165	400	finally
    //   165	175	400	finally
    //   180	257	400	finally
    //   269	307	400	finally
    //   319	383	400	finally
    //   390	394	400	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.widget.input.WebInputHandler
 * JD-Core Version:    0.7.0.1
 */