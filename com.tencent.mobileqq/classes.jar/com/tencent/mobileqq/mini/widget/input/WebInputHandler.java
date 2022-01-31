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
import com.tencent.mobileqq.mini.appbrand.page.WebviewContainer;
import com.tencent.mobileqq.mini.ui.NavigationBar;
import com.tencent.mobileqq.mini.util.ApiUtil;
import com.tencent.mobileqq.mini.util.DisplayUtil;
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
  private boolean isKeyboardShow;
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
    label125:
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
          break label125;
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
        this.mPage.getCurrentWebviewContainer().addView(paramJsRuntime, paramJsRuntime.makeLayoutParams(this.mPage.getCurrentWebviewContainer().getNativeScrollY()));
        this.mCurrentFocusInput = paramJsRuntime;
        paramJsRuntime.setInputId(this.inputId);
        paramJsRuntime.setPageWebview(localPageWebview);
        this.mShowingInput.put(Integer.valueOf(this.inputId), paramJsRuntime);
        paramJsRuntime.showSoftInput();
        paramJsRuntime.addTextChangedListener(new WebInputHandler.2(this, paramString, paramBaseJsPluginEngine, localPageWebview));
        paramJsRuntime.setOnEditorActionListener(new WebInputHandler.3(this, paramJsRuntime, localPageWebview));
        paramJsRuntime.getViewTreeObserver().addOnGlobalLayoutListener(new WebInputHandler.4(this, paramJsRuntime));
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
    //   3: getfield 55	com/tencent/mobileqq/mini/widget/input/WebInputHandler:mShowingInput	Ljava/util/Map;
    //   6: astore 10
    //   8: aload 10
    //   10: ifnonnull +11 -> 21
    //   13: iconst_0
    //   14: istore 9
    //   16: aload_0
    //   17: monitorexit
    //   18: iload 9
    //   20: ireturn
    //   21: new 233	org/json/JSONObject
    //   24: dup
    //   25: aload_1
    //   26: invokespecial 352	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   29: astore 10
    //   31: aload_0
    //   32: getfield 55	com/tencent/mobileqq/mini/widget/input/WebInputHandler:mShowingInput	Ljava/util/Map;
    //   35: aload 10
    //   37: ldc 235
    //   39: invokevirtual 356	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   42: invokestatic 227	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   45: invokeinterface 363 2 0
    //   50: checkcast 108	com/tencent/mobileqq/mini/widget/input/WebEditText
    //   53: astore_1
    //   54: aload_1
    //   55: ifnonnull +9 -> 64
    //   58: iconst_0
    //   59: istore 9
    //   61: goto -45 -> 16
    //   64: aload 10
    //   66: ldc 241
    //   68: invokevirtual 527	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   71: ifeq +27 -> 98
    //   74: aload 10
    //   76: ldc 241
    //   78: invokevirtual 378	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   81: astore 11
    //   83: aload_1
    //   84: aload 11
    //   86: invokevirtual 385	com/tencent/mobileqq/mini/widget/input/WebEditText:setText	(Ljava/lang/CharSequence;)V
    //   89: aload_1
    //   90: aload 11
    //   92: invokevirtual 251	java/lang/String:length	()I
    //   95: invokevirtual 388	com/tencent/mobileqq/mini/widget/input/WebEditText:setSelection	(I)V
    //   98: aload 10
    //   100: ldc_w 529
    //   103: iconst_m1
    //   104: invokevirtual 532	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   107: istore_3
    //   108: aload 10
    //   110: ldc_w 534
    //   113: iconst_m1
    //   114: invokevirtual 532	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   117: istore 4
    //   119: iload_3
    //   120: iconst_m1
    //   121: if_icmpeq +22 -> 143
    //   124: iload 4
    //   126: iconst_m1
    //   127: if_icmpeq +16 -> 143
    //   130: iload 4
    //   132: iload_3
    //   133: if_icmple +10 -> 143
    //   136: aload_1
    //   137: iload_3
    //   138: iload 4
    //   140: invokevirtual 537	com/tencent/mobileqq/mini/widget/input/WebEditText:setSelection	(II)V
    //   143: aload 10
    //   145: ldc 246
    //   147: iconst_m1
    //   148: invokevirtual 532	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   151: istore_3
    //   152: iload_3
    //   153: ifle +8 -> 161
    //   156: aload_1
    //   157: iload_3
    //   158: invokevirtual 388	com/tencent/mobileqq/mini/widget/input/WebEditText:setSelection	(I)V
    //   161: aload 10
    //   163: ldc_w 539
    //   166: invokevirtual 543	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   169: astore 10
    //   171: aload 10
    //   173: ifnull +173 -> 346
    //   176: aload 10
    //   178: ldc_w 545
    //   181: invokevirtual 356	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   184: istore 6
    //   186: aload 10
    //   188: ldc_w 547
    //   191: invokevirtual 356	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   194: istore 5
    //   196: aload 10
    //   198: ldc_w 549
    //   201: invokevirtual 356	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   204: istore_3
    //   205: aload 10
    //   207: ldc_w 551
    //   210: invokevirtual 356	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   213: istore 4
    //   215: aload_1
    //   216: invokevirtual 212	com/tencent/mobileqq/mini/widget/input/WebEditText:getContext	()Landroid/content/Context;
    //   219: invokestatic 555	com/tencent/mobileqq/mini/util/DisplayUtil:getDensity	(Landroid/content/Context;)F
    //   222: fstore_2
    //   223: iload_3
    //   224: i2f
    //   225: fload_2
    //   226: fmul
    //   227: ldc_w 556
    //   230: fadd
    //   231: fconst_0
    //   232: invokestatic 562	java/lang/Math:max	(FF)F
    //   235: f2i
    //   236: istore_3
    //   237: iload 4
    //   239: i2f
    //   240: fload_2
    //   241: fmul
    //   242: ldc_w 556
    //   245: fadd
    //   246: fconst_0
    //   247: invokestatic 562	java/lang/Math:max	(FF)F
    //   250: f2i
    //   251: istore 4
    //   253: iload 6
    //   255: i2f
    //   256: fload_2
    //   257: fmul
    //   258: ldc_w 556
    //   261: fadd
    //   262: f2i
    //   263: istore 6
    //   265: aload_0
    //   266: iconst_0
    //   267: putfield 425	com/tencent/mobileqq/mini/widget/input/WebInputHandler:navbarHeight	I
    //   270: iload 5
    //   272: i2f
    //   273: fload_2
    //   274: fmul
    //   275: ldc_w 556
    //   278: fadd
    //   279: f2i
    //   280: istore 5
    //   282: aload_0
    //   283: getfield 82	com/tencent/mobileqq/mini/widget/input/WebInputHandler:mPage	Lcom/tencent/mobileqq/mini/appbrand/page/AbsAppBrandPage;
    //   286: invokevirtual 441	com/tencent/mobileqq/mini/appbrand/page/AbsAppBrandPage:getCurrentPageWebview	()Lcom/tencent/mobileqq/mini/appbrand/page/PageWebview;
    //   289: getfield 454	com/tencent/mobileqq/mini/appbrand/page/PageWebview:scrollY	I
    //   292: istore 7
    //   294: aload_0
    //   295: getfield 425	com/tencent/mobileqq/mini/widget/input/WebInputHandler:navbarHeight	I
    //   298: istore 8
    //   300: aload_1
    //   301: invokevirtual 566	com/tencent/mobileqq/mini/widget/input/WebEditText:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   304: checkcast 568	android/widget/FrameLayout$LayoutParams
    //   307: astore 10
    //   309: aload 10
    //   311: iload_3
    //   312: putfield 570	android/widget/FrameLayout$LayoutParams:width	I
    //   315: aload 10
    //   317: iload 4
    //   319: putfield 572	android/widget/FrameLayout$LayoutParams:height	I
    //   322: aload 10
    //   324: iload 6
    //   326: putfield 575	android/widget/FrameLayout$LayoutParams:leftMargin	I
    //   329: aload 10
    //   331: iload 8
    //   333: iload 5
    //   335: iload 7
    //   337: isub
    //   338: iadd
    //   339: putfield 578	android/widget/FrameLayout$LayoutParams:topMargin	I
    //   342: aload_1
    //   343: invokevirtual 581	com/tencent/mobileqq/mini/widget/input/WebEditText:requestLayout	()V
    //   346: iconst_1
    //   347: istore 9
    //   349: goto -333 -> 16
    //   352: astore_1
    //   353: aload_1
    //   354: invokevirtual 584	java/lang/Exception:printStackTrace	()V
    //   357: iconst_0
    //   358: istore 9
    //   360: goto -344 -> 16
    //   363: astore_1
    //   364: aload_0
    //   365: monitorexit
    //   366: aload_1
    //   367: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	368	0	this	WebInputHandler
    //   0	368	1	paramString	String
    //   222	52	2	f	float
    //   107	205	3	i	int
    //   117	201	4	j	int
    //   194	144	5	k	int
    //   184	141	6	m	int
    //   292	46	7	n	int
    //   298	41	8	i1	int
    //   14	345	9	bool	boolean
    //   6	324	10	localObject	Object
    //   81	10	11	str	String
    // Exception table:
    //   from	to	target	type
    //   21	54	352	java/lang/Exception
    //   64	98	352	java/lang/Exception
    //   98	119	352	java/lang/Exception
    //   136	143	352	java/lang/Exception
    //   143	152	352	java/lang/Exception
    //   156	161	352	java/lang/Exception
    //   161	171	352	java/lang/Exception
    //   176	253	352	java/lang/Exception
    //   265	270	352	java/lang/Exception
    //   282	346	352	java/lang/Exception
    //   2	8	363	finally
    //   21	54	363	finally
    //   64	98	363	finally
    //   98	119	363	finally
    //   136	143	363	finally
    //   143	152	363	finally
    //   156	161	363	finally
    //   161	171	363	finally
    //   176	253	363	finally
    //   265	270	363	finally
    //   282	346	363	finally
    //   353	357	363	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.widget.input.WebInputHandler
 * JD-Core Version:    0.7.0.1
 */