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
    if ((this.mCurrentFocusInput == null) || (this.mNativeContainer == null) || (this.mNativeContainer.getPageWebviewContainer() == null)) {
      QMLog.e("WebInputHandler", "mCurrentFocusInput is null, return.");
    }
    do
    {
      return;
      if (this.mShowingInput.size() > 0) {
        try
        {
          Iterator localIterator = this.mShowingInput.entrySet().iterator();
          while (localIterator.hasNext())
          {
            Object localObject1 = (WebEditText)((Map.Entry)localIterator.next()).getValue();
            QMLog.d("WebInputHandler", "[hideCurrentInput] webEditText=" + localObject1);
            int i = ((WebEditText)localObject1).getInputId();
            PageWebview localPageWebview = ((WebEditText)localObject1).getPageWebview();
            if ((this.mCurrentFocusInput != null) && (this.mCurrentFocusInput.getInputId() == ((WebEditText)localObject1).getInputId()))
            {
              ((InputMethodManager)((WebEditText)localObject1).getContext().getSystemService("input_method")).hideSoftInputFromWindow(((WebEditText)localObject1).getWindowToken(), 0);
              this.isKeyboardShow = false;
            }
            ((WebEditText)localObject1).clearFocus();
            ((WebEditText)localObject1).detach();
            ((WebEditText)localObject1).setHasMoveParent(false);
            this.mShowingInput.remove(Integer.valueOf(i));
            Object localObject2;
            if (this.mNativeContainer != null)
            {
              localObject2 = (SoftKeyboardStateHelper.SoftKeyboardStateListener)this.mInputKeyboardListner.remove(Integer.valueOf(i));
              this.mNativeContainer.removeSoftKeyboardStateListener((SoftKeyboardStateHelper.SoftKeyboardStateListener)localObject2);
            }
            if (localPageWebview != null)
            {
              localObject1 = ((WebEditText)localObject1).getText().toString();
              localObject2 = new JSONObject();
              ((JSONObject)localObject2).put("inputId", i);
              ((JSONObject)localObject2).put("value", localObject1);
              ((JSONObject)localObject2).put("cursor", ((String)localObject1).length());
              this.mNativeContainer.getPageWebviewContainer().evaluateSubscribeJS("onKeyboardComplete", ((JSONObject)localObject2).toString());
              if (this.scrollListener != null) {
                localPageWebview.removeWebviewScrollListener(this.scrollListener);
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
    } while ((this.mNativeContainer == null) || (this.mNativeContainer.getPageWebviewContainer() == null));
    animatorTranslateY(new float[] { this.mNativeContainer.getPageWebviewContainer().getTranslationY(), 0.0F });
  }
  
  /* Error */
  public void hideKeyboard(NativeViewRequestEvent paramNativeViewRequestEvent)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 11
    //   4: new 186	java/lang/StringBuilder
    //   7: dup
    //   8: invokespecial 187	java/lang/StringBuilder:<init>	()V
    //   11: ldc_w 309
    //   14: invokevirtual 193	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: aload_1
    //   18: getfield 314	com/tencent/qqmini/sdk/launcher/core/action/NativeViewRequestEvent:jsonParams	Ljava/lang/String;
    //   21: invokevirtual 193	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: ldc_w 316
    //   27: invokevirtual 193	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: aload_1
    //   31: getfield 319	com/tencent/qqmini/sdk/launcher/core/action/NativeViewRequestEvent:callbackId	I
    //   34: invokevirtual 322	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   37: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   40: invokestatic 203	com/tencent/qqmini/sdk/launcher/log/QMLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   43: aload_0
    //   44: getfield 50	com/tencent/qqmini/miniapp/core/page/widget/WebInputHandler:mInputLock	Ljava/lang/Object;
    //   47: astore_2
    //   48: aload_2
    //   49: monitorenter
    //   50: aload_1
    //   51: getfield 326	com/tencent/qqmini/sdk/launcher/core/action/NativeViewRequestEvent:jsService	Lcom/tencent/qqmini/sdk/launcher/core/IJsService;
    //   54: instanceof 292
    //   57: ifne +17 -> 74
    //   60: aload_0
    //   61: invokevirtual 328	com/tencent/qqmini/miniapp/core/page/widget/WebInputHandler:hideCurrentInput	()V
    //   64: aload_1
    //   65: invokevirtual 331	com/tencent/qqmini/sdk/launcher/core/action/NativeViewRequestEvent:ok	()Ljava/lang/String;
    //   68: pop
    //   69: aload_2
    //   70: monitorexit
    //   71: aload_0
    //   72: monitorexit
    //   73: return
    //   74: aload_2
    //   75: monitorexit
    //   76: goto -5 -> 71
    //   79: astore_1
    //   80: aload_2
    //   81: monitorexit
    //   82: aload_1
    //   83: athrow
    //   84: astore_1
    //   85: aload_0
    //   86: monitorexit
    //   87: aload_1
    //   88: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	89	0	this	WebInputHandler
    //   0	89	1	paramNativeViewRequestEvent	NativeViewRequestEvent
    // Exception table:
    //   from	to	target	type
    //   50	71	79	finally
    //   74	76	79	finally
    //   80	82	79	finally
    //   2	50	84	finally
    //   82	84	84	finally
  }
  
  public boolean isFocus(int paramInt)
  {
    return (this.mCurrentFocusInput != null) && (this.mCurrentFocusInput.getInputId() == paramInt);
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
    label96:
    try
    {
      QMLog.d("WebInputHandler", ", webParams=" + paramNativeViewRequestEvent.jsonParams + ", callbackId=" + paramNativeViewRequestEvent.callbackId);
      try
      {
        localObject2 = new JSONObject(paramNativeViewRequestEvent.jsonParams);
        j = ((JSONObject)localObject2).optInt("inputId");
        localObject1 = (WebEditText)this.mShowingInput.get(Integer.valueOf(j));
        if (localObject1 != null) {
          break label96;
        }
        paramNativeViewRequestEvent.fail();
      }
      catch (Exception paramNativeViewRequestEvent)
      {
        for (;;)
        {
          Object localObject2;
          int j;
          Object localObject1;
          QMLog.e("WebInputHandler", "setKeyboardValue error.", paramNativeViewRequestEvent);
        }
      }
      return;
    }
    finally {}
    localObject2 = ((JSONObject)localObject2).optString("value");
    this.mSetValue.put(Integer.valueOf(j), localObject2);
    ((WebEditText)localObject1).setText((CharSequence)localObject2);
    if (localObject2 != null) {}
    for (int i = ((String)localObject2).length();; i = 0)
    {
      ((WebEditText)localObject1).setSelection(i);
      localObject1 = new JSONObject();
      ((JSONObject)localObject1).put("inputId", j);
      paramNativeViewRequestEvent.ok((JSONObject)localObject1);
      break;
    }
  }
  
  public void showKeyboard(NativeViewRequestEvent paramNativeViewRequestEvent)
  {
    QMLog.d("WebInputHandler", "showKeyboard , webParams=" + paramNativeViewRequestEvent.jsonParams + ", callbackId=" + paramNativeViewRequestEvent.callbackId);
    synchronized (this.mInputLock)
    {
      QMLog.d("WebInputHandler", "[showKeyboard] mCurrentFocusInput=" + this.mCurrentFocusInput);
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
    }
    this.screenHeight = DisplayUtil.getRealHeight(this.mNativeContainer.getContext());
    this.navbarHeight = this.mNativeContainer.getNaviBarHeight();
    Object localObject2 = getWebEditText();
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
    for (;;)
    {
      try
      {
        if (!parseParams(paramNativeViewRequestEvent, (WebEditText)localObject2)) {
          continue;
        }
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
      catch (Exception paramNativeViewRequestEvent)
      {
        QMLog.e("WebInputHandler", "[showKeyboard] exception:", paramNativeViewRequestEvent);
        continue;
      }
      return;
      paramNativeViewRequestEvent.fail();
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
    //   6: astore 8
    //   8: aload 8
    //   10: ifnonnull +11 -> 21
    //   13: iconst_0
    //   14: istore 7
    //   16: aload_0
    //   17: monitorexit
    //   18: iload 7
    //   20: ireturn
    //   21: new 262	org/json/JSONObject
    //   24: dup
    //   25: aload_1
    //   26: invokespecial 347	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   29: astore 8
    //   31: aload_0
    //   32: getfield 55	com/tencent/qqmini/miniapp/core/page/widget/WebInputHandler:mShowingInput	Ljava/util/Map;
    //   35: aload 8
    //   37: ldc_w 264
    //   40: invokevirtual 351	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   43: invokestatic 245	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   46: invokeinterface 354 2 0
    //   51: checkcast 132	com/tencent/qqmini/miniapp/core/page/widget/WebEditText
    //   54: astore_1
    //   55: aload_1
    //   56: ifnonnull +9 -> 65
    //   59: iconst_0
    //   60: istore 7
    //   62: goto -46 -> 16
    //   65: aload 8
    //   67: ldc_w 270
    //   70: invokevirtual 491	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   73: ifeq +28 -> 101
    //   76: aload 8
    //   78: ldc_w 270
    //   81: invokevirtual 361	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   84: astore 9
    //   86: aload_1
    //   87: aload 9
    //   89: invokevirtual 368	com/tencent/qqmini/miniapp/core/page/widget/WebEditText:setText	(Ljava/lang/CharSequence;)V
    //   92: aload_1
    //   93: aload 9
    //   95: invokevirtual 280	java/lang/String:length	()I
    //   98: invokevirtual 371	com/tencent/qqmini/miniapp/core/page/widget/WebEditText:setSelection	(I)V
    //   101: aload 8
    //   103: ldc_w 493
    //   106: iconst_m1
    //   107: invokevirtual 496	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   110: istore_3
    //   111: aload 8
    //   113: ldc_w 498
    //   116: iconst_m1
    //   117: invokevirtual 496	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
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
    //   143: invokevirtual 501	com/tencent/qqmini/miniapp/core/page/widget/WebEditText:setSelection	(II)V
    //   146: aload 8
    //   148: ldc_w 275
    //   151: iconst_m1
    //   152: invokevirtual 496	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   155: istore_3
    //   156: iload_3
    //   157: ifle +8 -> 165
    //   160: aload_1
    //   161: iload_3
    //   162: invokevirtual 371	com/tencent/qqmini/miniapp/core/page/widget/WebEditText:setSelection	(I)V
    //   165: aload 8
    //   167: ldc_w 503
    //   170: invokevirtual 507	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   173: astore 8
    //   175: aload 8
    //   177: ifnull +169 -> 346
    //   180: aload 8
    //   182: ldc_w 509
    //   185: invokevirtual 351	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   188: istore 4
    //   190: aload 8
    //   192: ldc_w 511
    //   195: invokevirtual 351	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   198: istore_3
    //   199: aload_1
    //   200: invokevirtual 211	com/tencent/qqmini/miniapp/core/page/widget/WebEditText:getContext	()Landroid/content/Context;
    //   203: invokestatic 515	com/tencent/qqmini/sdk/launcher/utils/DisplayUtil:getDensity	(Landroid/content/Context;)F
    //   206: fstore_2
    //   207: iload 4
    //   209: i2f
    //   210: fload_2
    //   211: fmul
    //   212: ldc_w 516
    //   215: fadd
    //   216: fconst_0
    //   217: invokestatic 522	java/lang/Math:max	(FF)F
    //   220: f2i
    //   221: istore 4
    //   223: iload_3
    //   224: i2f
    //   225: fload_2
    //   226: fmul
    //   227: ldc_w 516
    //   230: fadd
    //   231: fconst_0
    //   232: invokestatic 522	java/lang/Math:max	(FF)F
    //   235: f2i
    //   236: istore_3
    //   237: aload_0
    //   238: iconst_0
    //   239: putfield 402	com/tencent/qqmini/miniapp/core/page/widget/WebInputHandler:navbarHeight	I
    //   242: aload_1
    //   243: invokevirtual 526	com/tencent/qqmini/miniapp/core/page/widget/WebEditText:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   246: checkcast 528	android/widget/FrameLayout$LayoutParams
    //   249: astore 9
    //   251: aload 9
    //   253: iload 4
    //   255: putfield 530	android/widget/FrameLayout$LayoutParams:width	I
    //   258: aload 9
    //   260: iload_3
    //   261: putfield 532	android/widget/FrameLayout$LayoutParams:height	I
    //   264: aload 8
    //   266: ldc_w 534
    //   269: invokevirtual 351	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   272: istore_3
    //   273: aload 8
    //   275: ldc_w 536
    //   278: invokevirtual 351	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   281: istore 4
    //   283: iload_3
    //   284: i2f
    //   285: fload_2
    //   286: fmul
    //   287: ldc_w 516
    //   290: fadd
    //   291: f2i
    //   292: istore_3
    //   293: iload 4
    //   295: i2f
    //   296: fload_2
    //   297: fmul
    //   298: ldc_w 516
    //   301: fadd
    //   302: f2i
    //   303: istore 4
    //   305: aload_0
    //   306: getfield 72	com/tencent/qqmini/miniapp/core/page/widget/WebInputHandler:mNativeContainer	Lcom/tencent/qqmini/miniapp/core/page/NativeViewContainer;
    //   309: invokevirtual 413	com/tencent/qqmini/miniapp/core/page/NativeViewContainer:getCurrentPageWebview	()Lcom/tencent/qqmini/miniapp/core/page/PageWebview;
    //   312: getfield 434	com/tencent/qqmini/miniapp/core/page/PageWebview:scrollY	I
    //   315: istore 5
    //   317: aload_0
    //   318: getfield 402	com/tencent/qqmini/miniapp/core/page/widget/WebInputHandler:navbarHeight	I
    //   321: istore 6
    //   323: aload 9
    //   325: iload_3
    //   326: putfield 539	android/widget/FrameLayout$LayoutParams:leftMargin	I
    //   329: aload 9
    //   331: iload 4
    //   333: iload 5
    //   335: isub
    //   336: iload 6
    //   338: iadd
    //   339: putfield 542	android/widget/FrameLayout$LayoutParams:topMargin	I
    //   342: aload_1
    //   343: invokevirtual 545	com/tencent/qqmini/miniapp/core/page/widget/WebEditText:requestLayout	()V
    //   346: iconst_1
    //   347: istore 7
    //   349: goto -333 -> 16
    //   352: astore_1
    //   353: aload_1
    //   354: invokevirtual 548	java/lang/Exception:printStackTrace	()V
    //   357: iconst_0
    //   358: istore 7
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
    //   206	91	2	f	float
    //   110	216	3	i	int
    //   120	216	4	j	int
    //   315	21	5	k	int
    //   321	18	6	m	int
    //   14	345	7	bool	boolean
    //   6	268	8	localObject1	Object
    //   84	246	9	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   21	55	352	java/lang/Exception
    //   65	101	352	java/lang/Exception
    //   101	122	352	java/lang/Exception
    //   139	146	352	java/lang/Exception
    //   146	156	352	java/lang/Exception
    //   160	165	352	java/lang/Exception
    //   165	175	352	java/lang/Exception
    //   180	283	352	java/lang/Exception
    //   305	346	352	java/lang/Exception
    //   2	8	363	finally
    //   21	55	363	finally
    //   65	101	363	finally
    //   101	122	363	finally
    //   139	146	363	finally
    //   146	156	363	finally
    //   160	165	363	finally
    //   165	175	363	finally
    //   180	283	363	finally
    //   305	346	363	finally
    //   353	357	363	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.page.widget.WebInputHandler
 * JD-Core Version:    0.7.0.1
 */