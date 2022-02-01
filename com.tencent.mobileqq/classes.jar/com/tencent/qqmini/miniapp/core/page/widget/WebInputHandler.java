package com.tencent.qqmini.miniapp.core.page.widget;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.inputmethod.InputMethodManager;
import com.tencent.qqmini.miniapp.core.page.NativeViewContainer;
import com.tencent.qqmini.miniapp.core.page.PageWebview;
import com.tencent.qqmini.miniapp.core.page.PageWebview.OnWebviewScrollListener;
import com.tencent.qqmini.miniapp.core.page.PageWebviewContainer;
import com.tencent.qqmini.sdk.core.utils.SoftKeyboardStateHelper.SoftKeyboardStateListener;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
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

public final class WebInputHandler
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
  
  private void AnimatorTranslateY(float... paramVarArgs)
  {
    paramVarArgs = ObjectAnimator.ofFloat(this.mNativeContainer.getPageWebviewContainer(), "translationY", paramVarArgs);
    paramVarArgs.setDuration(200L);
    paramVarArgs.setInterpolator(new AccelerateDecelerateInterpolator());
    paramVarArgs.start();
  }
  
  private boolean parseParams(NativeViewRequestEvent paramNativeViewRequestEvent, WebEditText paramWebEditText)
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
    if ((this.mCurrentFocusInput == null) || (this.mNativeContainer == null) || (this.mNativeContainer.getPageWebviewContainer() == null)) {
      QMLog.e("WebInputHandler", "mCurrentFocusInput is null, return.");
    }
    do
    {
      return;
      if (this.mShowingInput.size() > 0)
      {
        Iterator localIterator = this.mShowingInput.entrySet().iterator();
        for (;;)
        {
          if (localIterator.hasNext())
          {
            Object localObject = (WebEditText)((Map.Entry)localIterator.next()).getValue();
            QMLog.d("WebInputHandler", "[hideCurrentInput] webEditText=" + localObject);
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
            if (this.mNativeContainer != null)
            {
              localObject = (SoftKeyboardStateHelper.SoftKeyboardStateListener)this.mInputKeyboardListner.remove(Integer.valueOf(i));
              this.mNativeContainer.removeSoftKeyboardStateListener((SoftKeyboardStateHelper.SoftKeyboardStateListener)localObject);
            }
            if (localPageWebview == null) {
              continue;
            }
            try
            {
              localObject = new JSONObject();
              ((JSONObject)localObject).put("inputId", i);
              ((JSONObject)localObject).put("value", str);
              ((JSONObject)localObject).put("cursor", str.length());
              this.mNativeContainer.getPageWebviewContainer().evaluateSubscribeJS("onKeyboardComplete", ((JSONObject)localObject).toString());
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
    } while ((this.mNativeContainer == null) || (this.mNativeContainer.getPageWebviewContainer() == null));
    AnimatorTranslateY(new float[] { this.mNativeContainer.getPageWebviewContainer().getTranslationY(), 0.0F });
  }
  
  public void hideKeyboard(NativeViewRequestEvent paramNativeViewRequestEvent)
  {
    for (;;)
    {
      try
      {
        QMLog.d("WebInputHandler", ", webParams=" + paramNativeViewRequestEvent.jsonParams + ", callbackId=" + paramNativeViewRequestEvent.callbackId);
        synchronized (this.mInputLock)
        {
          if (!(paramNativeViewRequestEvent.jsService instanceof PageWebview))
          {
            hideCurrentInput(true);
            paramNativeViewRequestEvent.ok();
            return;
          }
          if (TextUtils.isEmpty(paramNativeViewRequestEvent.jsonParams))
          {
            QMLog.e("WebInputHandler", "[hideKeyboard] no web input params");
            paramNativeViewRequestEvent.fail();
          }
        }
        try
        {
          int i = new JSONObject(paramNativeViewRequestEvent.jsonParams).optInt("inputId");
          if (!this.mShowingInput.containsKey(Integer.valueOf(i)))
          {
            paramNativeViewRequestEvent.ok();
            continue;
          }
          WebEditText localWebEditText = (WebEditText)this.mShowingInput.get(Integer.valueOf(i));
          this.mSetValue.remove(Integer.valueOf(i));
          paramNativeViewRequestEvent.ok();
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("inputId", i);
          localJSONObject.put("value", localWebEditText.getText().toString());
          localJSONObject.put("cursor", localWebEditText.getText().toString().length());
          hideCurrentInput(true);
          paramNativeViewRequestEvent.jsService.evaluateSubscribeJS("onKeyboardComplete", localJSONObject.toString(), 0);
        }
        catch (Exception paramNativeViewRequestEvent)
        {
          for (;;)
          {
            QMLog.e("WebInputHandler", "hideKeyboard, exception", paramNativeViewRequestEvent);
          }
        }
      }
      finally {}
    }
  }
  
  public boolean isFocus(int paramInt)
  {
    return (this.mCurrentFocusInput != null) && (this.mCurrentFocusInput.getInputId() == paramInt);
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
    Object localObject2 = new WebEditText(this.mNativeContainer.getContext(), this);
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
    //   6: astore 10
    //   8: aload 10
    //   10: ifnonnull +11 -> 21
    //   13: iconst_0
    //   14: istore 9
    //   16: aload_0
    //   17: monitorexit
    //   18: iload 9
    //   20: ireturn
    //   21: new 272	org/json/JSONObject
    //   24: dup
    //   25: aload_1
    //   26: invokespecial 352	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   29: astore 10
    //   31: aload_0
    //   32: getfield 55	com/tencent/qqmini/miniapp/core/page/widget/WebInputHandler:mShowingInput	Ljava/util/Map;
    //   35: aload 10
    //   37: ldc_w 274
    //   40: invokevirtual 356	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   43: invokestatic 260	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   46: invokeinterface 363 2 0
    //   51: checkcast 135	com/tencent/qqmini/miniapp/core/page/widget/WebEditText
    //   54: astore_1
    //   55: aload_1
    //   56: ifnonnull +9 -> 65
    //   59: iconst_0
    //   60: istore 9
    //   62: goto -46 -> 16
    //   65: aload 10
    //   67: ldc_w 280
    //   70: invokevirtual 503	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   73: ifeq +28 -> 101
    //   76: aload 10
    //   78: ldc_w 280
    //   81: invokevirtual 377	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   84: astore 11
    //   86: aload_1
    //   87: aload 11
    //   89: invokevirtual 384	com/tencent/qqmini/miniapp/core/page/widget/WebEditText:setText	(Ljava/lang/CharSequence;)V
    //   92: aload_1
    //   93: aload 11
    //   95: invokevirtual 290	java/lang/String:length	()I
    //   98: invokevirtual 387	com/tencent/qqmini/miniapp/core/page/widget/WebEditText:setSelection	(I)V
    //   101: aload 10
    //   103: ldc_w 505
    //   106: iconst_m1
    //   107: invokevirtual 508	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   110: istore_3
    //   111: aload 10
    //   113: ldc_w 510
    //   116: iconst_m1
    //   117: invokevirtual 508	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
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
    //   143: invokevirtual 513	com/tencent/qqmini/miniapp/core/page/widget/WebEditText:setSelection	(II)V
    //   146: aload 10
    //   148: ldc_w 285
    //   151: iconst_m1
    //   152: invokevirtual 508	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   155: istore_3
    //   156: iload_3
    //   157: ifle +8 -> 165
    //   160: aload_1
    //   161: iload_3
    //   162: invokevirtual 387	com/tencent/qqmini/miniapp/core/page/widget/WebEditText:setSelection	(I)V
    //   165: aload 10
    //   167: ldc_w 515
    //   170: invokevirtual 519	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   173: astore 10
    //   175: aload 10
    //   177: ifnull +173 -> 350
    //   180: aload 10
    //   182: ldc_w 521
    //   185: invokevirtual 356	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   188: istore 6
    //   190: aload 10
    //   192: ldc_w 523
    //   195: invokevirtual 356	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   198: istore 5
    //   200: aload 10
    //   202: ldc_w 525
    //   205: invokevirtual 356	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   208: istore_3
    //   209: aload 10
    //   211: ldc_w 527
    //   214: invokevirtual 356	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   217: istore 4
    //   219: aload_1
    //   220: invokevirtual 227	com/tencent/qqmini/miniapp/core/page/widget/WebEditText:getContext	()Landroid/content/Context;
    //   223: invokestatic 531	com/tencent/qqmini/sdk/launcher/utils/DisplayUtil:getDensity	(Landroid/content/Context;)F
    //   226: fstore_2
    //   227: iload_3
    //   228: i2f
    //   229: fload_2
    //   230: fmul
    //   231: ldc_w 532
    //   234: fadd
    //   235: fconst_0
    //   236: invokestatic 538	java/lang/Math:max	(FF)F
    //   239: f2i
    //   240: istore_3
    //   241: iload 4
    //   243: i2f
    //   244: fload_2
    //   245: fmul
    //   246: ldc_w 532
    //   249: fadd
    //   250: fconst_0
    //   251: invokestatic 538	java/lang/Math:max	(FF)F
    //   254: f2i
    //   255: istore 4
    //   257: iload 6
    //   259: i2f
    //   260: fload_2
    //   261: fmul
    //   262: ldc_w 532
    //   265: fadd
    //   266: f2i
    //   267: istore 6
    //   269: aload_0
    //   270: iconst_0
    //   271: putfield 413	com/tencent/qqmini/miniapp/core/page/widget/WebInputHandler:navbarHeight	I
    //   274: iload 5
    //   276: i2f
    //   277: fload_2
    //   278: fmul
    //   279: ldc_w 532
    //   282: fadd
    //   283: f2i
    //   284: istore 5
    //   286: aload_0
    //   287: getfield 72	com/tencent/qqmini/miniapp/core/page/widget/WebInputHandler:mNativeContainer	Lcom/tencent/qqmini/miniapp/core/page/NativeViewContainer;
    //   290: invokevirtual 425	com/tencent/qqmini/miniapp/core/page/NativeViewContainer:getCurrentPageWebview	()Lcom/tencent/qqmini/miniapp/core/page/PageWebview;
    //   293: getfield 446	com/tencent/qqmini/miniapp/core/page/PageWebview:scrollY	I
    //   296: istore 7
    //   298: aload_0
    //   299: getfield 413	com/tencent/qqmini/miniapp/core/page/widget/WebInputHandler:navbarHeight	I
    //   302: istore 8
    //   304: aload_1
    //   305: invokevirtual 542	com/tencent/qqmini/miniapp/core/page/widget/WebEditText:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   308: checkcast 544	android/widget/FrameLayout$LayoutParams
    //   311: astore 10
    //   313: aload 10
    //   315: iload_3
    //   316: putfield 546	android/widget/FrameLayout$LayoutParams:width	I
    //   319: aload 10
    //   321: iload 4
    //   323: putfield 548	android/widget/FrameLayout$LayoutParams:height	I
    //   326: aload 10
    //   328: iload 6
    //   330: putfield 551	android/widget/FrameLayout$LayoutParams:leftMargin	I
    //   333: aload 10
    //   335: iload 8
    //   337: iload 5
    //   339: iload 7
    //   341: isub
    //   342: iadd
    //   343: putfield 554	android/widget/FrameLayout$LayoutParams:topMargin	I
    //   346: aload_1
    //   347: invokevirtual 557	com/tencent/qqmini/miniapp/core/page/widget/WebEditText:requestLayout	()V
    //   350: iconst_1
    //   351: istore 9
    //   353: goto -337 -> 16
    //   356: astore_1
    //   357: aload_1
    //   358: invokevirtual 560	java/lang/Exception:printStackTrace	()V
    //   361: iconst_0
    //   362: istore 9
    //   364: goto -348 -> 16
    //   367: astore_1
    //   368: aload_0
    //   369: monitorexit
    //   370: aload_1
    //   371: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	372	0	this	WebInputHandler
    //   0	372	1	paramString	String
    //   226	52	2	f	float
    //   110	206	3	i	int
    //   120	202	4	j	int
    //   198	144	5	k	int
    //   188	141	6	m	int
    //   296	46	7	n	int
    //   302	41	8	i1	int
    //   14	349	9	bool	boolean
    //   6	328	10	localObject	Object
    //   84	10	11	str	String
    // Exception table:
    //   from	to	target	type
    //   21	55	356	java/lang/Exception
    //   65	101	356	java/lang/Exception
    //   101	122	356	java/lang/Exception
    //   139	146	356	java/lang/Exception
    //   146	156	356	java/lang/Exception
    //   160	165	356	java/lang/Exception
    //   165	175	356	java/lang/Exception
    //   180	257	356	java/lang/Exception
    //   269	274	356	java/lang/Exception
    //   286	350	356	java/lang/Exception
    //   2	8	367	finally
    //   21	55	367	finally
    //   65	101	367	finally
    //   101	122	367	finally
    //   139	146	367	finally
    //   146	156	367	finally
    //   160	165	367	finally
    //   165	175	367	finally
    //   180	257	367	finally
    //   269	274	367	finally
    //   286	350	367	finally
    //   357	361	367	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.page.widget.WebInputHandler
 * JD-Core Version:    0.7.0.1
 */