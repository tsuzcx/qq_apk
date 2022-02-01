package com.tencent.mobileqq.microapp.widget.input;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.inputmethod.InputMethodManager;
import com.tencent.mobileqq.microapp.appbrand.a.a.f;
import com.tencent.mobileqq.microapp.appbrand.page.AbsAppBrandPage;
import com.tencent.mobileqq.microapp.appbrand.page.AppBrandPageContainer;
import com.tencent.mobileqq.microapp.appbrand.page.PageWebview;
import com.tencent.mobileqq.microapp.webview.BaseAppBrandWebview;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

public final class a
{
  private static a b;
  List a = new ArrayList();
  private AtomicInteger c = new AtomicInteger(0);
  private Object d = new Object();
  private WebEditText e;
  private AbsAppBrandPage f;
  private Map g = new HashMap();
  private int h;
  
  public static a a()
  {
    try
    {
      if (b == null) {
        b = new a();
      }
      a locala = b;
      return locala;
    }
    finally {}
  }
  
  public void a(f paramf, BaseAppBrandWebview paramBaseAppBrandWebview, String paramString, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("[showKeyboard] jsPluginEngine=");
      ((StringBuilder)???).append(paramf);
      ((StringBuilder)???).append(", webview=");
      ((StringBuilder)???).append(paramBaseAppBrandWebview);
      ((StringBuilder)???).append(", webParams=");
      ((StringBuilder)???).append(paramString);
      ((StringBuilder)???).append(", callbackId=");
      ((StringBuilder)???).append(paramInt);
      QLog.d("WebInputHandler", 2, ((StringBuilder)???).toString());
    }
    for (;;)
    {
      synchronized (this.d)
      {
        Object localObject2;
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("[showKeyboard] mCurrentFocusInput=");
          ((StringBuilder)localObject2).append(this.e);
          QLog.d("WebInputHandler", 2, ((StringBuilder)localObject2).toString());
        }
        if ((paramBaseAppBrandWebview != null) && ((paramBaseAppBrandWebview instanceof PageWebview)))
        {
          if ((paramf != null) && (paramf.a != null) && (paramf.a.g != null))
          {
            if (TextUtils.isEmpty(paramString))
            {
              if (QLog.isColorLevel()) {
                QLog.e("WebInputHandler", 2, "[showKeyboard] no web input params");
              }
              paramBaseAppBrandWebview.evaluateCallbackJs(paramInt, com.tencent.mobileqq.microapp.a.c.b("showKeyboard", null).toString());
              return;
            }
            this.f = ((AbsAppBrandPage)paramf.a.g.pageLinkedList.peek());
            if (this.f == null)
            {
              paramBaseAppBrandWebview.evaluateCallbackJs(paramInt, com.tencent.mobileqq.microapp.a.c.b("showKeyboard", null).toString());
              return;
            }
            localObject2 = new WebEditText(paramBaseAppBrandWebview.getContext());
            try
            {
              bool = ((WebEditText)localObject2).a(paramf, this.f, paramString);
            }
            catch (Exception localException)
            {
              if (!QLog.isColorLevel()) {
                break label668;
              }
            }
            QLog.e("WebInputHandler", 2, "[showKeyboard] initWithWebParams exception:", localException);
            break label668;
            this.h = this.c.incrementAndGet();
            PageWebview localPageWebview = this.f.getCurrentPageWebview();
            localPageWebview.onWebviewScrollListener = new b(this, localPageWebview);
            if (bool) {}
            try
            {
              if (QLog.isColorLevel()) {
                QLog.d("WebInputHandler", 2, new Object[] { "[showKeyboard] makeLayoutParams scrollY:", Integer.valueOf(localPageWebview.scrollY) });
              }
              this.e = ((WebEditText)localObject2);
              ((WebEditText)localObject2).a(this.h);
              ((WebEditText)localObject2).a(localPageWebview);
              this.g.put(Integer.valueOf(this.h), localObject2);
              ((WebEditText)localObject2).d();
              ((WebEditText)localObject2).addTextChangedListener(new c(this, paramString, paramf, localPageWebview));
              ((WebEditText)localObject2).setOnEditorActionListener(new d(this, (WebEditText)localObject2, localPageWebview));
              paramf = com.tencent.mobileqq.microapp.a.c.a("showKeyboard", null);
              paramf.put("inputId", this.h);
              paramString = new StringBuilder();
              paramString.append("WeixinJSBridge.invokeCallbackHandler(");
              paramString.append(paramInt);
              paramString.append(", ");
              paramString.append(paramf);
              paramString.append(")");
              paramBaseAppBrandWebview.evaluteJs(paramString.toString());
            }
            catch (Exception paramf)
            {
              if (!QLog.isColorLevel()) {
                continue;
              }
              QLog.e("WebInputHandler", 2, "[showKeyboard] exception:", paramf);
            }
            paramf = com.tencent.mobileqq.microapp.a.c.b("showKeyboard", null);
            paramString = new StringBuilder();
            paramString.append("WeixinJSBridge.invokeCallbackHandler(");
            paramString.append(paramInt);
            paramString.append(", ");
            paramString.append(paramf);
            paramString.append(")");
            paramBaseAppBrandWebview.evaluteJs(paramString.toString());
          }
          else
          {
            if (QLog.isColorLevel()) {
              QLog.e("WebInputHandler", 2, "[showKeyboard] runtime error");
            }
            paramBaseAppBrandWebview.evaluateCallbackJs(paramInt, com.tencent.mobileqq.microapp.a.c.b("showKeyboard", null).toString());
          }
        }
        else
        {
          Log.e("WebInputHandler", "[showKeyboard] invalid webview");
          return;
        }
      }
      label668:
      boolean bool = false;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("[hideCurrentInput] hideSoftInput=");
      ((StringBuilder)localObject1).append(paramBoolean);
      QLog.i("WebInputHandler", 2, ((StringBuilder)localObject1).toString());
    }
    if (this.g.size() > 0)
    {
      localObject1 = this.g.entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (WebEditText)((Map.Entry)((Iterator)localObject1).next()).getValue();
        if (QLog.isColorLevel())
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("[hideCurrentInput] webEditText=");
          ((StringBuilder)localObject3).append(localObject2);
          QLog.d("WebInputHandler", 2, ((StringBuilder)localObject3).toString());
        }
        int i = ((WebEditText)localObject2).a();
        Object localObject3 = ((WebEditText)localObject2).getText().toString();
        PageWebview localPageWebview = ((WebEditText)localObject2).b();
        WebEditText localWebEditText = this.e;
        if ((localWebEditText != null) && (localWebEditText.a() == ((WebEditText)localObject2).a()) && (paramBoolean)) {
          ((InputMethodManager)((WebEditText)localObject2).getContext().getSystemService("input_method")).hideSoftInputFromWindow(((WebEditText)localObject2).getWindowToken(), 0);
        }
        ((WebEditText)localObject2).clearFocus();
        ((WebEditText)localObject2).c();
        this.a.add(localObject2);
        if (localPageWebview != null) {
          try
          {
            localObject2 = new JSONObject();
            ((JSONObject)localObject2).put("inputId", i);
            ((JSONObject)localObject2).put("value", localObject3);
            ((JSONObject)localObject2).put("cursor", ((String)localObject3).length());
            localPageWebview.evaluateSubcribeJS("onKeyboardComplete", ((JSONObject)localObject2).toString(), localPageWebview.pageWebviewId);
          }
          catch (Exception localException)
          {
            Log.e("WebInputHandler", "[hideCurrentInput] exception:", localException);
          }
        }
      }
    }
    this.e = null;
  }
  
  public boolean a(int paramInt)
  {
    WebEditText localWebEditText = this.e;
    return (localWebEditText != null) && (localWebEditText.a() == paramInt);
  }
  
  /* Error */
  public boolean a(f paramf, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 43	com/tencent/mobileqq/microapp/widget/input/a:g	Ljava/util/Map;
    //   6: astore_1
    //   7: aload_1
    //   8: ifnonnull +7 -> 15
    //   11: aload_0
    //   12: monitorexit
    //   13: iconst_0
    //   14: ireturn
    //   15: new 128	org/json/JSONObject
    //   18: dup
    //   19: aload_2
    //   20: invokespecial 363	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   23: astore_2
    //   24: aload_0
    //   25: getfield 43	com/tencent/mobileqq/microapp/widget/input/a:g	Ljava/util/Map;
    //   28: aload_2
    //   29: ldc 232
    //   31: invokevirtual 367	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   34: invokestatic 194	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   37: invokeinterface 371 2 0
    //   42: checkcast 151	com/tencent/mobileqq/microapp/widget/input/WebEditText
    //   45: astore_1
    //   46: aload_1
    //   47: ifnonnull +7 -> 54
    //   50: aload_0
    //   51: monitorexit
    //   52: iconst_0
    //   53: ireturn
    //   54: aload_2
    //   55: ldc_w 373
    //   58: invokevirtual 377	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   61: astore_2
    //   62: aload_2
    //   63: ifnull +146 -> 209
    //   66: aload_2
    //   67: ldc_w 379
    //   70: invokevirtual 367	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   73: istore 7
    //   75: aload_2
    //   76: ldc_w 381
    //   79: invokevirtual 367	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   82: istore 5
    //   84: aload_2
    //   85: ldc_w 383
    //   88: invokevirtual 367	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   91: istore 4
    //   93: aload_2
    //   94: ldc_w 385
    //   97: invokevirtual 367	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   100: istore 6
    //   102: aload_1
    //   103: invokevirtual 303	com/tencent/mobileqq/microapp/widget/input/WebEditText:getContext	()Landroid/content/Context;
    //   106: invokestatic 391	com/tencent/mobileqq/microapp/util/DisplayUtil:getDensity	(Landroid/content/Context;)F
    //   109: fstore_3
    //   110: iload 4
    //   112: i2f
    //   113: fload_3
    //   114: fmul
    //   115: ldc_w 392
    //   118: fadd
    //   119: f2i
    //   120: istore 4
    //   122: iload 6
    //   124: i2f
    //   125: fload_3
    //   126: fmul
    //   127: ldc_w 392
    //   130: fadd
    //   131: f2i
    //   132: istore 6
    //   134: iload 7
    //   136: i2f
    //   137: fload_3
    //   138: fmul
    //   139: ldc_w 392
    //   142: fadd
    //   143: f2i
    //   144: istore 7
    //   146: fload_3
    //   147: iload 5
    //   149: i2f
    //   150: fmul
    //   151: ldc_w 392
    //   154: fadd
    //   155: f2i
    //   156: istore 5
    //   158: aload_0
    //   159: getfield 54	com/tencent/mobileqq/microapp/widget/input/a:f	Lcom/tencent/mobileqq/microapp/appbrand/page/AbsAppBrandPage;
    //   162: invokevirtual 174	com/tencent/mobileqq/microapp/appbrand/page/AbsAppBrandPage:getCurrentPageWebview	()Lcom/tencent/mobileqq/microapp/appbrand/page/PageWebview;
    //   165: getfield 188	com/tencent/mobileqq/microapp/appbrand/page/PageWebview:scrollY	I
    //   168: istore 8
    //   170: aload_1
    //   171: invokevirtual 396	com/tencent/mobileqq/microapp/widget/input/WebEditText:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   174: checkcast 398	android/widget/FrameLayout$LayoutParams
    //   177: astore_2
    //   178: aload_2
    //   179: iload 4
    //   181: putfield 400	android/widget/FrameLayout$LayoutParams:width	I
    //   184: aload_2
    //   185: iload 6
    //   187: putfield 402	android/widget/FrameLayout$LayoutParams:height	I
    //   190: aload_2
    //   191: iload 7
    //   193: putfield 405	android/widget/FrameLayout$LayoutParams:leftMargin	I
    //   196: aload_2
    //   197: iload 5
    //   199: iload 8
    //   201: isub
    //   202: putfield 408	android/widget/FrameLayout$LayoutParams:topMargin	I
    //   205: aload_1
    //   206: invokevirtual 411	com/tencent/mobileqq/microapp/widget/input/WebEditText:requestLayout	()V
    //   209: aload_0
    //   210: monitorexit
    //   211: iconst_1
    //   212: ireturn
    //   213: astore_1
    //   214: aload_1
    //   215: invokevirtual 414	java/lang/Exception:printStackTrace	()V
    //   218: aload_0
    //   219: monitorexit
    //   220: iconst_0
    //   221: ireturn
    //   222: astore_1
    //   223: aload_0
    //   224: monitorexit
    //   225: aload_1
    //   226: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	227	0	this	a
    //   0	227	1	paramf	f
    //   0	227	2	paramString	String
    //   109	38	3	f1	float
    //   91	89	4	i	int
    //   82	120	5	j	int
    //   100	86	6	k	int
    //   73	119	7	m	int
    //   168	34	8	n	int
    // Exception table:
    //   from	to	target	type
    //   15	46	213	java/lang/Exception
    //   54	62	213	java/lang/Exception
    //   66	110	213	java/lang/Exception
    //   158	209	213	java/lang/Exception
    //   2	7	222	finally
    //   15	46	222	finally
    //   54	62	222	finally
    //   66	110	222	finally
    //   158	209	222	finally
    //   214	218	222	finally
  }
  
  /* Error */
  public void b(f paramf, BaseAppBrandWebview paramBaseAppBrandWebview, String paramString, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 63	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +85 -> 90
    //   8: new 65	java/lang/StringBuilder
    //   11: dup
    //   12: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   15: astore 6
    //   17: aload 6
    //   19: ldc_w 416
    //   22: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: pop
    //   26: aload 6
    //   28: aload_1
    //   29: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   32: pop
    //   33: aload 6
    //   35: ldc 77
    //   37: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: pop
    //   41: aload 6
    //   43: aload_2
    //   44: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   47: pop
    //   48: aload 6
    //   50: ldc 79
    //   52: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: pop
    //   56: aload 6
    //   58: aload_3
    //   59: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: pop
    //   63: aload 6
    //   65: ldc 81
    //   67: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: pop
    //   71: aload 6
    //   73: iload 4
    //   75: invokevirtual 84	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   78: pop
    //   79: ldc 86
    //   81: iconst_2
    //   82: aload 6
    //   84: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   87: invokestatic 93	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   90: aload_0
    //   91: getfield 33	com/tencent/mobileqq/microapp/widget/input/a:d	Ljava/lang/Object;
    //   94: astore 6
    //   96: aload 6
    //   98: monitorenter
    //   99: aload_2
    //   100: ifnull +405 -> 505
    //   103: aload_2
    //   104: instanceof 99
    //   107: ifne +6 -> 113
    //   110: goto +395 -> 505
    //   113: aload_1
    //   114: ifnull +354 -> 468
    //   117: aload_1
    //   118: getfield 104	com/tencent/mobileqq/microapp/appbrand/a/a/f:a	Lcom/tencent/mobileqq/microapp/appbrand/a;
    //   121: ifnull +347 -> 468
    //   124: aload_1
    //   125: getfield 104	com/tencent/mobileqq/microapp/appbrand/a/a/f:a	Lcom/tencent/mobileqq/microapp/appbrand/a;
    //   128: getfield 109	com/tencent/mobileqq/microapp/appbrand/a:g	Lcom/tencent/mobileqq/microapp/appbrand/page/AppBrandPageContainer;
    //   131: ifnonnull +6 -> 137
    //   134: goto +334 -> 468
    //   137: aload_3
    //   138: invokestatic 115	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   141: ifeq +40 -> 181
    //   144: invokestatic 63	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   147: ifeq +12 -> 159
    //   150: ldc 86
    //   152: iconst_2
    //   153: ldc_w 418
    //   156: invokestatic 119	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   159: aload_2
    //   160: iload 4
    //   162: ldc_w 420
    //   165: aconst_null
    //   166: invokestatic 126	com/tencent/mobileqq/microapp/a/c:b	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   169: invokevirtual 129	org/json/JSONObject:toString	()Ljava/lang/String;
    //   172: invokevirtual 135	com/tencent/mobileqq/microapp/webview/BaseAppBrandWebview:evaluateCallbackJs	(ILjava/lang/String;)V
    //   175: aload 6
    //   177: monitorexit
    //   178: aload_0
    //   179: monitorexit
    //   180: return
    //   181: aload_1
    //   182: getfield 104	com/tencent/mobileqq/microapp/appbrand/a/a/f:a	Lcom/tencent/mobileqq/microapp/appbrand/a;
    //   185: getfield 109	com/tencent/mobileqq/microapp/appbrand/a:g	Lcom/tencent/mobileqq/microapp/appbrand/page/AppBrandPageContainer;
    //   188: getfield 141	com/tencent/mobileqq/microapp/appbrand/page/AppBrandPageContainer:pageLinkedList	Ljava/util/LinkedList;
    //   191: invokevirtual 147	java/util/LinkedList:peek	()Ljava/lang/Object;
    //   194: checkcast 149	com/tencent/mobileqq/microapp/appbrand/page/AbsAppBrandPage
    //   197: ifnonnull +25 -> 222
    //   200: aload_2
    //   201: iload 4
    //   203: ldc_w 420
    //   206: aconst_null
    //   207: invokestatic 126	com/tencent/mobileqq/microapp/a/c:b	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   210: invokevirtual 129	org/json/JSONObject:toString	()Ljava/lang/String;
    //   213: invokevirtual 135	com/tencent/mobileqq/microapp/webview/BaseAppBrandWebview:evaluateCallbackJs	(ILjava/lang/String;)V
    //   216: aload 6
    //   218: monitorexit
    //   219: aload_0
    //   220: monitorexit
    //   221: return
    //   222: aload_2
    //   223: invokevirtual 155	com/tencent/mobileqq/microapp/webview/BaseAppBrandWebview:getContext	()Landroid/content/Context;
    //   226: astore_1
    //   227: new 128	org/json/JSONObject
    //   230: dup
    //   231: aload_3
    //   232: invokespecial 363	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   235: ldc 232
    //   237: invokevirtual 367	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   240: istore 5
    //   242: aload_0
    //   243: getfield 43	com/tencent/mobileqq/microapp/widget/input/a:g	Ljava/util/Map;
    //   246: iload 5
    //   248: invokestatic 194	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   251: invokeinterface 423 2 0
    //   256: ifne +25 -> 281
    //   259: aload_2
    //   260: iload 4
    //   262: ldc_w 420
    //   265: aconst_null
    //   266: invokestatic 230	com/tencent/mobileqq/microapp/a/c:a	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   269: invokevirtual 129	org/json/JSONObject:toString	()Ljava/lang/String;
    //   272: invokevirtual 135	com/tencent/mobileqq/microapp/webview/BaseAppBrandWebview:evaluateCallbackJs	(ILjava/lang/String;)V
    //   275: aload 6
    //   277: monitorexit
    //   278: aload_0
    //   279: monitorexit
    //   280: return
    //   281: aload_0
    //   282: getfield 43	com/tencent/mobileqq/microapp/widget/input/a:g	Ljava/util/Map;
    //   285: iload 5
    //   287: invokestatic 194	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   290: invokeinterface 426 2 0
    //   295: checkcast 151	com/tencent/mobileqq/microapp/widget/input/WebEditText
    //   298: astore 7
    //   300: aload_2
    //   301: iload 4
    //   303: ldc_w 420
    //   306: aconst_null
    //   307: invokestatic 230	com/tencent/mobileqq/microapp/a/c:a	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   310: invokevirtual 129	org/json/JSONObject:toString	()Ljava/lang/String;
    //   313: invokevirtual 135	com/tencent/mobileqq/microapp/webview/BaseAppBrandWebview:evaluateCallbackJs	(ILjava/lang/String;)V
    //   316: new 128	org/json/JSONObject
    //   319: dup
    //   320: invokespecial 333	org/json/JSONObject:<init>	()V
    //   323: astore_3
    //   324: aload_3
    //   325: ldc 232
    //   327: iload 5
    //   329: invokevirtual 235	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   332: pop
    //   333: aload_3
    //   334: ldc_w 335
    //   337: aload 7
    //   339: invokevirtual 299	com/tencent/mobileqq/microapp/widget/input/WebEditText:getText	()Landroid/text/Editable;
    //   342: invokevirtual 300	java/lang/Object:toString	()Ljava/lang/String;
    //   345: invokevirtual 338	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   348: pop
    //   349: aload_3
    //   350: ldc_w 340
    //   353: aload 7
    //   355: invokevirtual 299	com/tencent/mobileqq/microapp/widget/input/WebEditText:getText	()Landroid/text/Editable;
    //   358: invokevirtual 300	java/lang/Object:toString	()Ljava/lang/String;
    //   361: invokevirtual 345	java/lang/String:length	()I
    //   364: invokevirtual 235	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   367: pop
    //   368: aload_0
    //   369: getfield 38	com/tencent/mobileqq/microapp/widget/input/a:a	Ljava/util/List;
    //   372: aload 7
    //   374: invokeinterface 332 2 0
    //   379: pop
    //   380: aload 7
    //   382: iconst_0
    //   383: invokevirtual 429	com/tencent/mobileqq/microapp/widget/input/WebEditText:setFocusable	(Z)V
    //   386: aload 7
    //   388: iconst_0
    //   389: invokevirtual 432	com/tencent/mobileqq/microapp/widget/input/WebEditText:setFocusableInTouchMode	(Z)V
    //   392: aload 7
    //   394: invokevirtual 324	com/tencent/mobileqq/microapp/widget/input/WebEditText:clearFocus	()V
    //   397: aload_1
    //   398: ldc_w 305
    //   401: invokevirtual 311	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   404: checkcast 313	android/view/inputmethod/InputMethodManager
    //   407: aload 7
    //   409: invokevirtual 317	com/tencent/mobileqq/microapp/widget/input/WebEditText:getWindowToken	()Landroid/os/IBinder;
    //   412: iconst_0
    //   413: invokevirtual 321	android/view/inputmethod/InputMethodManager:hideSoftInputFromWindow	(Landroid/os/IBinder;I)Z
    //   416: pop
    //   417: aload 7
    //   419: invokevirtual 326	com/tencent/mobileqq/microapp/widget/input/WebEditText:c	()V
    //   422: aload_2
    //   423: checkcast 99	com/tencent/mobileqq/microapp/appbrand/page/PageWebview
    //   426: astore_1
    //   427: aload_1
    //   428: ldc_w 347
    //   431: aload_3
    //   432: invokevirtual 129	org/json/JSONObject:toString	()Ljava/lang/String;
    //   435: aload_1
    //   436: getfield 350	com/tencent/mobileqq/microapp/appbrand/page/PageWebview:pageWebviewId	I
    //   439: invokevirtual 354	com/tencent/mobileqq/microapp/appbrand/page/PageWebview:evaluateSubcribeJS	(Ljava/lang/String;Ljava/lang/String;I)V
    //   442: goto +20 -> 462
    //   445: astore_1
    //   446: invokestatic 63	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   449: ifeq +13 -> 462
    //   452: ldc 86
    //   454: iconst_2
    //   455: ldc_w 434
    //   458: aload_1
    //   459: invokestatic 166	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   462: aload 6
    //   464: monitorexit
    //   465: aload_0
    //   466: monitorexit
    //   467: return
    //   468: invokestatic 63	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   471: ifeq +12 -> 483
    //   474: ldc 86
    //   476: iconst_2
    //   477: ldc_w 436
    //   480: invokestatic 119	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   483: aload_2
    //   484: iload 4
    //   486: ldc_w 420
    //   489: aconst_null
    //   490: invokestatic 126	com/tencent/mobileqq/microapp/a/c:b	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   493: invokevirtual 129	org/json/JSONObject:toString	()Ljava/lang/String;
    //   496: invokevirtual 135	com/tencent/mobileqq/microapp/webview/BaseAppBrandWebview:evaluateCallbackJs	(ILjava/lang/String;)V
    //   499: aload 6
    //   501: monitorexit
    //   502: aload_0
    //   503: monitorexit
    //   504: return
    //   505: invokestatic 63	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   508: ifeq +12 -> 520
    //   511: ldc 86
    //   513: iconst_2
    //   514: ldc_w 438
    //   517: invokestatic 119	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   520: aload 6
    //   522: monitorexit
    //   523: aload_0
    //   524: monitorexit
    //   525: return
    //   526: astore_1
    //   527: aload 6
    //   529: monitorexit
    //   530: aload_1
    //   531: athrow
    //   532: astore_1
    //   533: aload_0
    //   534: monitorexit
    //   535: aload_1
    //   536: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	537	0	this	a
    //   0	537	1	paramf	f
    //   0	537	2	paramBaseAppBrandWebview	BaseAppBrandWebview
    //   0	537	3	paramString	String
    //   0	537	4	paramInt	int
    //   240	88	5	i	int
    //   15	513	6	localObject	Object
    //   298	120	7	localWebEditText	WebEditText
    // Exception table:
    //   from	to	target	type
    //   222	275	445	java/lang/Exception
    //   281	442	445	java/lang/Exception
    //   103	110	526	finally
    //   117	134	526	finally
    //   137	159	526	finally
    //   159	178	526	finally
    //   181	219	526	finally
    //   222	275	526	finally
    //   275	278	526	finally
    //   281	442	526	finally
    //   446	462	526	finally
    //   462	465	526	finally
    //   468	483	526	finally
    //   483	502	526	finally
    //   505	520	526	finally
    //   520	523	526	finally
    //   527	530	526	finally
    //   2	90	532	finally
    //   90	99	532	finally
    //   530	532	532	finally
  }
  
  public boolean b()
  {
    return this.e != null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.widget.input.a
 * JD-Core Version:    0.7.0.1
 */