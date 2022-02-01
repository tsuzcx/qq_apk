package com.tencent.qqmini.miniapp.core.page.widget;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.inputmethod.InputMethodManager;
import com.tencent.qqmini.miniapp.core.page.NativeViewContainer;
import com.tencent.qqmini.miniapp.core.page.PageWebview;
import com.tencent.qqmini.miniapp.core.page.PageWebview.OnWebviewScrollListener;
import com.tencent.qqmini.miniapp.core.page.PageWebviewContainer;
import com.tencent.qqmini.sdk.core.utils.SoftKeyboardStateHelper.SoftKeyboardStateListener;
import com.tencent.qqmini.sdk.launcher.core.action.NativeViewRequestEvent;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.utils.DisplayUtil;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

public class WebInputHandler
{
  private static final int DEFAULT_SPACING = 5;
  private static final String TAG = "WebInputHandler";
  private boolean adjustPosition = false;
  private int inputId;
  private boolean isKeyboardShow = false;
  private WebEditText mCurrentFocusInput;
  private AtomicInteger mInputIdGenerator = new AtomicInteger(0);
  private Map<Integer, SoftKeyboardStateHelper.SoftKeyboardStateListener> mInputKeyboardListner = new ConcurrentHashMap();
  private Object mInputLock = new Object();
  private NativeViewContainer mNativeContainer;
  private Map<Integer, String> mSetValue = new HashMap();
  private Map<Integer, WebEditText> mShowingInput = new ConcurrentHashMap();
  private int navbarHeight;
  private int offset = 0;
  private int screenHeight;
  public PageWebview.OnWebviewScrollListener scrollListener;
  private int showKeyboardHeight = 0;
  
  public WebInputHandler(NativeViewContainer paramNativeViewContainer)
  {
    this.mNativeContainer = paramNativeViewContainer;
  }
  
  private void animatorTranslateY(float... paramVarArgs)
  {
    paramVarArgs = ObjectAnimator.ofFloat(this.mNativeContainer.getPageWebviewContainer(), "translationY", paramVarArgs);
    paramVarArgs.setDuration(200L);
    paramVarArgs.setInterpolator(new AccelerateDecelerateInterpolator());
    paramVarArgs.start();
  }
  
  public Map<Integer, WebEditText> getShowingInput()
  {
    return this.mShowingInput;
  }
  
  public WebEditText getWebEditText()
  {
    return new WebEditText(this.mNativeContainer.getContext(), this);
  }
  
  public boolean hasFocusInput()
  {
    return this.mCurrentFocusInput != null;
  }
  
  public void hideCurrentInput()
  {
    if (this.mCurrentFocusInput != null)
    {
      Object localObject1 = this.mNativeContainer;
      if ((localObject1 != null) && (((NativeViewContainer)localObject1).getPageWebviewContainer() != null))
      {
        if (this.mShowingInput.size() > 0) {
          try
          {
            localObject1 = this.mShowingInput.entrySet().iterator();
            while (((Iterator)localObject1).hasNext())
            {
              Object localObject3 = (WebEditText)((Map.Entry)((Iterator)localObject1).next()).getValue();
              Object localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("[hideCurrentInput] webEditText=");
              ((StringBuilder)localObject2).append(localObject3);
              QMLog.d("WebInputHandler", ((StringBuilder)localObject2).toString());
              int i = ((WebEditText)localObject3).getInputId();
              localObject2 = ((WebEditText)localObject3).getPageWebview();
              if ((this.mCurrentFocusInput != null) && (this.mCurrentFocusInput.getInputId() == ((WebEditText)localObject3).getInputId()))
              {
                ((InputMethodManager)((WebEditText)localObject3).getContext().getSystemService("input_method")).hideSoftInputFromWindow(((WebEditText)localObject3).getWindowToken(), 0);
                this.isKeyboardShow = false;
              }
              ((WebEditText)localObject3).clearFocus();
              ((WebEditText)localObject3).detach();
              ((WebEditText)localObject3).setHasMoveParent(false);
              this.mShowingInput.remove(Integer.valueOf(i));
              Object localObject4;
              if (this.mNativeContainer != null)
              {
                localObject4 = (SoftKeyboardStateHelper.SoftKeyboardStateListener)this.mInputKeyboardListner.remove(Integer.valueOf(i));
                this.mNativeContainer.removeSoftKeyboardStateListener((SoftKeyboardStateHelper.SoftKeyboardStateListener)localObject4);
              }
              if (localObject2 != null)
              {
                localObject3 = ((WebEditText)localObject3).getText().toString();
                localObject4 = new JSONObject();
                ((JSONObject)localObject4).put("inputId", i);
                ((JSONObject)localObject4).put("value", localObject3);
                ((JSONObject)localObject4).put("cursor", ((String)localObject3).length());
                this.mNativeContainer.getPageWebviewContainer().evaluateSubscribeJS("onKeyboardComplete", ((JSONObject)localObject4).toString());
                if (this.scrollListener != null) {
                  ((PageWebview)localObject2).removeWebviewScrollListener(this.scrollListener);
                }
              }
            }
            this.mCurrentFocusInput = null;
          }
          catch (Throwable localThrowable)
          {
            QMLog.e("WebInputHandler", "hideCurrentInput error, ", localThrowable);
          }
        }
        NativeViewContainer localNativeViewContainer = this.mNativeContainer;
        if ((localNativeViewContainer != null) && (localNativeViewContainer.getPageWebviewContainer() != null)) {
          animatorTranslateY(new float[] { this.mNativeContainer.getPageWebviewContainer().getTranslationY(), 0.0F });
        }
        return;
      }
    }
    QMLog.e("WebInputHandler", "mCurrentFocusInput is null, return.");
  }
  
  /* Error */
  public void hideKeyboard(NativeViewRequestEvent paramNativeViewRequestEvent)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 178	java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial 179	java/lang/StringBuilder:<init>	()V
    //   9: astore_2
    //   10: aload_2
    //   11: ldc_w 309
    //   14: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: pop
    //   18: aload_2
    //   19: aload_1
    //   20: getfield 314	com/tencent/qqmini/sdk/launcher/core/action/NativeViewRequestEvent:jsonParams	Ljava/lang/String;
    //   23: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: pop
    //   27: aload_2
    //   28: ldc_w 316
    //   31: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: pop
    //   35: aload_2
    //   36: aload_1
    //   37: getfield 319	com/tencent/qqmini/sdk/launcher/core/action/NativeViewRequestEvent:callbackId	I
    //   40: invokevirtual 322	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   43: pop
    //   44: ldc 11
    //   46: aload_2
    //   47: invokevirtual 192	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   50: invokestatic 198	com/tencent/qqmini/sdk/launcher/log/QMLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   53: aload_0
    //   54: getfield 50	com/tencent/qqmini/miniapp/core/page/widget/WebInputHandler:mInputLock	Ljava/lang/Object;
    //   57: astore_2
    //   58: aload_2
    //   59: monitorenter
    //   60: aload_1
    //   61: getfield 326	com/tencent/qqmini/sdk/launcher/core/action/NativeViewRequestEvent:jsService	Lcom/tencent/qqmini/sdk/launcher/core/IJsService;
    //   64: instanceof 287
    //   67: ifne +17 -> 84
    //   70: aload_0
    //   71: invokevirtual 328	com/tencent/qqmini/miniapp/core/page/widget/WebInputHandler:hideCurrentInput	()V
    //   74: aload_1
    //   75: invokevirtual 331	com/tencent/qqmini/sdk/launcher/core/action/NativeViewRequestEvent:ok	()Ljava/lang/String;
    //   78: pop
    //   79: aload_2
    //   80: monitorexit
    //   81: aload_0
    //   82: monitorexit
    //   83: return
    //   84: aload_2
    //   85: monitorexit
    //   86: aload_0
    //   87: monitorexit
    //   88: return
    //   89: astore_1
    //   90: aload_2
    //   91: monitorexit
    //   92: aload_1
    //   93: athrow
    //   94: astore_1
    //   95: aload_0
    //   96: monitorexit
    //   97: aload_1
    //   98: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	99	0	this	WebInputHandler
    //   0	99	1	paramNativeViewRequestEvent	NativeViewRequestEvent
    // Exception table:
    //   from	to	target	type
    //   60	81	89	finally
    //   84	86	89	finally
    //   90	92	89	finally
    //   2	60	94	finally
    //   92	94	94	finally
  }
  
  public boolean isFocus(int paramInt)
  {
    WebEditText localWebEditText = this.mCurrentFocusInput;
    return (localWebEditText != null) && (localWebEditText.getInputId() == paramInt);
  }
  
  public boolean parseParams(NativeViewRequestEvent paramNativeViewRequestEvent, WebEditText paramWebEditText)
  {
    try
    {
      boolean bool = paramWebEditText.initWithWebParams(this.mNativeContainer, paramNativeViewRequestEvent.jsonParams);
      return bool;
    }
    catch (Exception paramNativeViewRequestEvent)
    {
      QMLog.e("WebInputHandler", "[showKeyboard] initWithWebParams exception:", paramNativeViewRequestEvent);
    }
    return false;
  }
  
  public void setKeyboardValue(NativeViewRequestEvent paramNativeViewRequestEvent)
  {
    for (;;)
    {
      try
      {
        Object localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(", webParams=");
        ((StringBuilder)localObject1).append(paramNativeViewRequestEvent.jsonParams);
        ((StringBuilder)localObject1).append(", callbackId=");
        ((StringBuilder)localObject1).append(paramNativeViewRequestEvent.callbackId);
        QMLog.d("WebInputHandler", ((StringBuilder)localObject1).toString());
        try
        {
          Object localObject2 = new JSONObject(paramNativeViewRequestEvent.jsonParams);
          int j = ((JSONObject)localObject2).optInt("inputId");
          localObject1 = (WebEditText)this.mShowingInput.get(Integer.valueOf(j));
          if (localObject1 == null)
          {
            paramNativeViewRequestEvent.fail();
            return;
          }
          localObject2 = ((JSONObject)localObject2).optString("value");
          this.mSetValue.put(Integer.valueOf(j), localObject2);
          ((WebEditText)localObject1).setText((CharSequence)localObject2);
          if (localObject2 == null) {
            break label212;
          }
          i = ((String)localObject2).length();
          ((WebEditText)localObject1).setSelection(i);
          localObject1 = new JSONObject();
          ((JSONObject)localObject1).put("inputId", j);
          paramNativeViewRequestEvent.ok((JSONObject)localObject1);
        }
        catch (Exception paramNativeViewRequestEvent)
        {
          QMLog.e("WebInputHandler", "setKeyboardValue error.", paramNativeViewRequestEvent);
        }
        return;
      }
      finally {}
      label212:
      int i = 0;
    }
  }
  
  public void showKeyboard(NativeViewRequestEvent paramNativeViewRequestEvent)
  {
    ??? = new StringBuilder();
    ((StringBuilder)???).append("showKeyboard , webParams=");
    ((StringBuilder)???).append(paramNativeViewRequestEvent.jsonParams);
    ((StringBuilder)???).append(", callbackId=");
    ((StringBuilder)???).append(paramNativeViewRequestEvent.callbackId);
    QMLog.d("WebInputHandler", ((StringBuilder)???).toString());
    synchronized (this.mInputLock)
    {
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[showKeyboard] mCurrentFocusInput=");
      ((StringBuilder)localObject2).append(this.mCurrentFocusInput);
      QMLog.d("WebInputHandler", ((StringBuilder)localObject2).toString());
      if (TextUtils.isEmpty(paramNativeViewRequestEvent.jsonParams))
      {
        QMLog.e("WebInputHandler", "[showKeyboard] no web input params");
        paramNativeViewRequestEvent.fail();
        return;
      }
      if (this.mNativeContainer == null)
      {
        paramNativeViewRequestEvent.fail();
        return;
      }
      this.screenHeight = DisplayUtil.getRealHeight(this.mNativeContainer.getContext());
      this.navbarHeight = this.mNativeContainer.getNaviBarHeight();
      localObject2 = getWebEditText();
      this.inputId = this.mInputIdGenerator.incrementAndGet();
      this.mNativeContainer.setCurInputId(this.inputId);
      PageWebview localPageWebview = this.mNativeContainer.getCurrentPageWebview();
      this.scrollListener = new WebInputHandler.MyOnWebviewScrollListener(localPageWebview);
      if (this.mNativeContainer != null)
      {
        WebInputHandler.KeyboardHiddenObserver localKeyboardHiddenObserver = new WebInputHandler.KeyboardHiddenObserver(this);
        this.mNativeContainer.setSoftKeyboardStateListener(localKeyboardHiddenObserver);
        this.mInputKeyboardListner.put(Integer.valueOf(this.inputId), localKeyboardHiddenObserver);
      }
      if (localPageWebview != null) {
        localPageWebview.setOnWebviewScrollListener(this.scrollListener);
      }
      try
      {
        if (parseParams(paramNativeViewRequestEvent, (WebEditText)localObject2))
        {
          if ((this.mNativeContainer != null) && (this.mNativeContainer.getPageWebviewContainer() != null)) {
            this.mNativeContainer.getPageWebviewContainer().addView((View)localObject2, ((WebEditText)localObject2).makeLayoutParams(this.mNativeContainer.getCurrentPageWebview().scrollY));
          }
          this.mCurrentFocusInput = ((WebEditText)localObject2);
          ((WebEditText)localObject2).setInputId(this.inputId);
          ((WebEditText)localObject2).setPageWebview(localPageWebview);
          this.mShowingInput.put(Integer.valueOf(this.inputId), localObject2);
          ((WebEditText)localObject2).showSoftInput();
          ((WebEditText)localObject2).addTextChangedListener(new WebInputHandler.MyTextWatcher(this, paramNativeViewRequestEvent));
          ((WebEditText)localObject2).setOnEditorActionListener(new WebInputHandler.MyOnEditorActionListener(this, (WebEditText)localObject2, paramNativeViewRequestEvent));
          ((WebEditText)localObject2).getViewTreeObserver().addOnGlobalLayoutListener(new WebInputHandler.MyOnGlobalLayoutListener(this, (WebEditText)localObject2));
          localObject2 = new JSONObject();
          ((JSONObject)localObject2).put("inputId", this.inputId);
          paramNativeViewRequestEvent.ok((JSONObject)localObject2);
        }
        else
        {
          paramNativeViewRequestEvent.fail();
        }
      }
      catch (Exception paramNativeViewRequestEvent)
      {
        QMLog.e("WebInputHandler", "[showKeyboard] exception:", paramNativeViewRequestEvent);
      }
      return;
    }
  }
  
  /* Error */
  public boolean updateInput(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 55	com/tencent/qqmini/miniapp/core/page/widget/WebInputHandler:mShowingInput	Ljava/util/Map;
    //   6: astore 7
    //   8: aload 7
    //   10: ifnonnull +7 -> 17
    //   13: aload_0
    //   14: monitorexit
    //   15: iconst_0
    //   16: ireturn
    //   17: new 257	org/json/JSONObject
    //   20: dup
    //   21: aload_1
    //   22: invokespecial 347	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   25: astore 7
    //   27: aload_0
    //   28: getfield 55	com/tencent/qqmini/miniapp/core/page/widget/WebInputHandler:mShowingInput	Ljava/util/Map;
    //   31: aload 7
    //   33: ldc_w 259
    //   36: invokevirtual 351	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   39: invokestatic 240	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   42: invokeinterface 354 2 0
    //   47: checkcast 132	com/tencent/qqmini/miniapp/core/page/widget/WebEditText
    //   50: astore_1
    //   51: aload_1
    //   52: ifnonnull +7 -> 59
    //   55: aload_0
    //   56: monitorexit
    //   57: iconst_0
    //   58: ireturn
    //   59: aload 7
    //   61: ldc_w 265
    //   64: invokevirtual 491	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   67: ifeq +28 -> 95
    //   70: aload 7
    //   72: ldc_w 265
    //   75: invokevirtual 361	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   78: astore 8
    //   80: aload_1
    //   81: aload 8
    //   83: invokevirtual 368	com/tencent/qqmini/miniapp/core/page/widget/WebEditText:setText	(Ljava/lang/CharSequence;)V
    //   86: aload_1
    //   87: aload 8
    //   89: invokevirtual 275	java/lang/String:length	()I
    //   92: invokevirtual 371	com/tencent/qqmini/miniapp/core/page/widget/WebEditText:setSelection	(I)V
    //   95: aload 7
    //   97: ldc_w 493
    //   100: iconst_m1
    //   101: invokevirtual 496	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   104: istore_3
    //   105: aload 7
    //   107: ldc_w 498
    //   110: iconst_m1
    //   111: invokevirtual 496	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   114: istore 4
    //   116: iload_3
    //   117: iconst_m1
    //   118: if_icmpeq +22 -> 140
    //   121: iload 4
    //   123: iconst_m1
    //   124: if_icmpeq +16 -> 140
    //   127: iload 4
    //   129: iload_3
    //   130: if_icmple +10 -> 140
    //   133: aload_1
    //   134: iload_3
    //   135: iload 4
    //   137: invokevirtual 501	com/tencent/qqmini/miniapp/core/page/widget/WebEditText:setSelection	(II)V
    //   140: aload 7
    //   142: ldc_w 270
    //   145: iconst_m1
    //   146: invokevirtual 496	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   149: istore_3
    //   150: iload_3
    //   151: ifle +8 -> 159
    //   154: aload_1
    //   155: iload_3
    //   156: invokevirtual 371	com/tencent/qqmini/miniapp/core/page/widget/WebEditText:setSelection	(I)V
    //   159: aload 7
    //   161: ldc_w 503
    //   164: invokevirtual 507	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   167: astore 7
    //   169: aload 7
    //   171: ifnull +169 -> 340
    //   174: aload 7
    //   176: ldc_w 509
    //   179: invokevirtual 351	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   182: istore 4
    //   184: aload 7
    //   186: ldc_w 511
    //   189: invokevirtual 351	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   192: istore_3
    //   193: aload_1
    //   194: invokevirtual 206	com/tencent/qqmini/miniapp/core/page/widget/WebEditText:getContext	()Landroid/content/Context;
    //   197: invokestatic 515	com/tencent/qqmini/sdk/launcher/utils/DisplayUtil:getDensity	(Landroid/content/Context;)F
    //   200: fstore_2
    //   201: iload 4
    //   203: i2f
    //   204: fload_2
    //   205: fmul
    //   206: ldc_w 516
    //   209: fadd
    //   210: fconst_0
    //   211: invokestatic 522	java/lang/Math:max	(FF)F
    //   214: f2i
    //   215: istore 4
    //   217: iload_3
    //   218: i2f
    //   219: fload_2
    //   220: fmul
    //   221: ldc_w 516
    //   224: fadd
    //   225: fconst_0
    //   226: invokestatic 522	java/lang/Math:max	(FF)F
    //   229: f2i
    //   230: istore_3
    //   231: aload_0
    //   232: iconst_0
    //   233: putfield 402	com/tencent/qqmini/miniapp/core/page/widget/WebInputHandler:navbarHeight	I
    //   236: aload_1
    //   237: invokevirtual 526	com/tencent/qqmini/miniapp/core/page/widget/WebEditText:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   240: checkcast 528	android/widget/FrameLayout$LayoutParams
    //   243: astore 8
    //   245: aload 8
    //   247: iload 4
    //   249: putfield 530	android/widget/FrameLayout$LayoutParams:width	I
    //   252: aload 8
    //   254: iload_3
    //   255: putfield 532	android/widget/FrameLayout$LayoutParams:height	I
    //   258: aload 7
    //   260: ldc_w 534
    //   263: invokevirtual 351	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   266: istore_3
    //   267: aload 7
    //   269: ldc_w 536
    //   272: invokevirtual 351	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   275: istore 4
    //   277: iload_3
    //   278: i2f
    //   279: fload_2
    //   280: fmul
    //   281: ldc_w 516
    //   284: fadd
    //   285: f2i
    //   286: istore_3
    //   287: fload_2
    //   288: iload 4
    //   290: i2f
    //   291: fmul
    //   292: ldc_w 516
    //   295: fadd
    //   296: f2i
    //   297: istore 4
    //   299: aload_0
    //   300: getfield 72	com/tencent/qqmini/miniapp/core/page/widget/WebInputHandler:mNativeContainer	Lcom/tencent/qqmini/miniapp/core/page/NativeViewContainer;
    //   303: invokevirtual 413	com/tencent/qqmini/miniapp/core/page/NativeViewContainer:getCurrentPageWebview	()Lcom/tencent/qqmini/miniapp/core/page/PageWebview;
    //   306: getfield 434	com/tencent/qqmini/miniapp/core/page/PageWebview:scrollY	I
    //   309: istore 5
    //   311: aload_0
    //   312: getfield 402	com/tencent/qqmini/miniapp/core/page/widget/WebInputHandler:navbarHeight	I
    //   315: istore 6
    //   317: aload 8
    //   319: iload_3
    //   320: putfield 539	android/widget/FrameLayout$LayoutParams:leftMargin	I
    //   323: aload 8
    //   325: iload 4
    //   327: iload 5
    //   329: isub
    //   330: iload 6
    //   332: iadd
    //   333: putfield 542	android/widget/FrameLayout$LayoutParams:topMargin	I
    //   336: aload_1
    //   337: invokevirtual 545	com/tencent/qqmini/miniapp/core/page/widget/WebEditText:requestLayout	()V
    //   340: aload_0
    //   341: monitorexit
    //   342: iconst_1
    //   343: ireturn
    //   344: astore_1
    //   345: aload_1
    //   346: invokevirtual 548	java/lang/Exception:printStackTrace	()V
    //   349: aload_0
    //   350: monitorexit
    //   351: iconst_0
    //   352: ireturn
    //   353: astore_1
    //   354: aload_0
    //   355: monitorexit
    //   356: aload_1
    //   357: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	358	0	this	WebInputHandler
    //   0	358	1	paramString	String
    //   200	88	2	f	float
    //   104	216	3	i	int
    //   114	216	4	j	int
    //   309	21	5	k	int
    //   315	18	6	m	int
    //   6	262	7	localObject1	Object
    //   78	246	8	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   17	51	344	java/lang/Exception
    //   59	95	344	java/lang/Exception
    //   95	116	344	java/lang/Exception
    //   133	140	344	java/lang/Exception
    //   140	150	344	java/lang/Exception
    //   154	159	344	java/lang/Exception
    //   159	169	344	java/lang/Exception
    //   174	277	344	java/lang/Exception
    //   299	340	344	java/lang/Exception
    //   2	8	353	finally
    //   17	51	353	finally
    //   59	95	353	finally
    //   95	116	353	finally
    //   133	140	353	finally
    //   140	150	353	finally
    //   154	159	353	finally
    //   159	169	353	finally
    //   174	277	353	finally
    //   299	340	353	finally
    //   345	349	353	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.page.widget.WebInputHandler
 * JD-Core Version:    0.7.0.1
 */