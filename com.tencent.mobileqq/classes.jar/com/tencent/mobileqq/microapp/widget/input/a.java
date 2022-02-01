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
    if (QLog.isColorLevel()) {
      QLog.d("WebInputHandler", 2, "[showKeyboard] jsPluginEngine=" + paramf + ", webview=" + paramBaseAppBrandWebview + ", webParams=" + paramString + ", callbackId=" + paramInt);
    }
    synchronized (this.d)
    {
      if (QLog.isColorLevel()) {
        QLog.d("WebInputHandler", 2, "[showKeyboard] mCurrentFocusInput=" + this.e);
      }
      if ((paramBaseAppBrandWebview == null) || (!(paramBaseAppBrandWebview instanceof PageWebview)))
      {
        Log.e("WebInputHandler", "[showKeyboard] invalid webview");
        return;
      }
      if ((paramf == null) || (paramf.a == null) || (paramf.a.g == null))
      {
        if (QLog.isColorLevel()) {
          QLog.e("WebInputHandler", 2, "[showKeyboard] runtime error");
        }
        paramBaseAppBrandWebview.evaluateCallbackJs(paramInt, com.tencent.mobileqq.microapp.a.c.b("showKeyboard", null).toString());
        return;
      }
    }
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
    WebEditText localWebEditText = new WebEditText(paramBaseAppBrandWebview.getContext());
    try
    {
      bool = localWebEditText.a(paramf, this.f, paramString);
      this.h = this.c.incrementAndGet();
      PageWebview localPageWebview = this.f.getCurrentPageWebview();
      localPageWebview.onWebviewScrollListener = new b(this, localPageWebview);
      if (bool) {}
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("WebInputHandler", 2, new Object[] { "[showKeyboard] makeLayoutParams scrollY:", Integer.valueOf(localPageWebview.scrollY) });
        }
        this.e = localWebEditText;
        localWebEditText.a(this.h);
        localWebEditText.a(localPageWebview);
        this.g.put(Integer.valueOf(this.h), localWebEditText);
        localWebEditText.d();
        localWebEditText.addTextChangedListener(new c(this, paramString, paramf, localPageWebview));
        localWebEditText.setOnEditorActionListener(new d(this, localWebEditText, localPageWebview));
        paramf = com.tencent.mobileqq.microapp.a.c.a("showKeyboard", null);
        paramf.put("inputId", this.h);
        paramBaseAppBrandWebview.evaluteJs("WeixinJSBridge.invokeCallbackHandler(" + paramInt + ", " + paramf + ")");
      }
      catch (Exception paramf)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("WebInputHandler", 2, "[showKeyboard] exception:", paramf);
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
        paramf = com.tencent.mobileqq.microapp.a.c.b("showKeyboard", null);
        paramBaseAppBrandWebview.evaluteJs("WeixinJSBridge.invokeCallbackHandler(" + paramInt + ", " + paramf + ")");
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("WebInputHandler", 2, "[hideCurrentInput] hideSoftInput=" + paramBoolean);
    }
    if (this.g.size() > 0)
    {
      Iterator localIterator = this.g.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (WebEditText)((Map.Entry)localIterator.next()).getValue();
        if (QLog.isColorLevel()) {
          QLog.d("WebInputHandler", 2, "[hideCurrentInput] webEditText=" + localObject);
        }
        int i = ((WebEditText)localObject).a();
        String str = ((WebEditText)localObject).getText().toString();
        PageWebview localPageWebview = ((WebEditText)localObject).b();
        if ((this.e != null) && (this.e.a() == ((WebEditText)localObject).a()) && (paramBoolean)) {
          ((InputMethodManager)((WebEditText)localObject).getContext().getSystemService("input_method")).hideSoftInputFromWindow(((WebEditText)localObject).getWindowToken(), 0);
        }
        ((WebEditText)localObject).clearFocus();
        ((WebEditText)localObject).c();
        this.a.add(localObject);
        if (localPageWebview != null) {
          try
          {
            localObject = new JSONObject();
            ((JSONObject)localObject).put("inputId", i);
            ((JSONObject)localObject).put("value", str);
            ((JSONObject)localObject).put("cursor", str.length());
            localPageWebview.evaluateSubcribeJS("onKeyboardComplete", ((JSONObject)localObject).toString(), localPageWebview.pageWebviewId);
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
    return (this.e != null) && (this.e.a() == paramInt);
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
    //   8: ifnonnull +11 -> 19
    //   11: iconst_0
    //   12: istore 9
    //   14: aload_0
    //   15: monitorexit
    //   16: iload 9
    //   18: ireturn
    //   19: new 129	org/json/JSONObject
    //   22: dup
    //   23: aload_2
    //   24: invokespecial 363	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   27: astore_2
    //   28: aload_0
    //   29: getfield 43	com/tencent/mobileqq/microapp/widget/input/a:g	Ljava/util/Map;
    //   32: aload_2
    //   33: ldc 236
    //   35: invokevirtual 367	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   38: invokestatic 198	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   41: invokeinterface 371 2 0
    //   46: checkcast 160	com/tencent/mobileqq/microapp/widget/input/WebEditText
    //   49: astore_1
    //   50: aload_1
    //   51: ifnonnull +9 -> 60
    //   54: iconst_0
    //   55: istore 9
    //   57: goto -43 -> 14
    //   60: aload_2
    //   61: ldc_w 373
    //   64: invokevirtual 377	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   67: astore_2
    //   68: aload_2
    //   69: ifnull +146 -> 215
    //   72: aload_2
    //   73: ldc_w 379
    //   76: invokevirtual 367	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   79: istore 7
    //   81: aload_2
    //   82: ldc_w 381
    //   85: invokevirtual 367	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   88: istore 5
    //   90: aload_2
    //   91: ldc_w 383
    //   94: invokevirtual 367	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   97: istore 4
    //   99: aload_2
    //   100: ldc_w 385
    //   103: invokevirtual 367	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   106: istore 6
    //   108: aload_1
    //   109: invokevirtual 303	com/tencent/mobileqq/microapp/widget/input/WebEditText:getContext	()Landroid/content/Context;
    //   112: invokestatic 391	com/tencent/mobileqq/microapp/util/DisplayUtil:getDensity	(Landroid/content/Context;)F
    //   115: fstore_3
    //   116: iload 4
    //   118: i2f
    //   119: fload_3
    //   120: fmul
    //   121: ldc_w 392
    //   124: fadd
    //   125: f2i
    //   126: istore 4
    //   128: iload 6
    //   130: i2f
    //   131: fload_3
    //   132: fmul
    //   133: ldc_w 392
    //   136: fadd
    //   137: f2i
    //   138: istore 6
    //   140: iload 7
    //   142: i2f
    //   143: fload_3
    //   144: fmul
    //   145: ldc_w 392
    //   148: fadd
    //   149: f2i
    //   150: istore 7
    //   152: iload 5
    //   154: i2f
    //   155: fload_3
    //   156: fmul
    //   157: ldc_w 392
    //   160: fadd
    //   161: f2i
    //   162: istore 5
    //   164: aload_0
    //   165: getfield 54	com/tencent/mobileqq/microapp/widget/input/a:f	Lcom/tencent/mobileqq/microapp/appbrand/page/AbsAppBrandPage;
    //   168: invokevirtual 178	com/tencent/mobileqq/microapp/appbrand/page/AbsAppBrandPage:getCurrentPageWebview	()Lcom/tencent/mobileqq/microapp/appbrand/page/PageWebview;
    //   171: getfield 192	com/tencent/mobileqq/microapp/appbrand/page/PageWebview:scrollY	I
    //   174: istore 8
    //   176: aload_1
    //   177: invokevirtual 396	com/tencent/mobileqq/microapp/widget/input/WebEditText:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   180: checkcast 398	android/widget/FrameLayout$LayoutParams
    //   183: astore_2
    //   184: aload_2
    //   185: iload 4
    //   187: putfield 400	android/widget/FrameLayout$LayoutParams:width	I
    //   190: aload_2
    //   191: iload 6
    //   193: putfield 402	android/widget/FrameLayout$LayoutParams:height	I
    //   196: aload_2
    //   197: iload 7
    //   199: putfield 405	android/widget/FrameLayout$LayoutParams:leftMargin	I
    //   202: aload_2
    //   203: iload 5
    //   205: iload 8
    //   207: isub
    //   208: putfield 408	android/widget/FrameLayout$LayoutParams:topMargin	I
    //   211: aload_1
    //   212: invokevirtual 411	com/tencent/mobileqq/microapp/widget/input/WebEditText:requestLayout	()V
    //   215: iconst_1
    //   216: istore 9
    //   218: goto -204 -> 14
    //   221: astore_1
    //   222: aload_1
    //   223: invokevirtual 414	java/lang/Exception:printStackTrace	()V
    //   226: iconst_0
    //   227: istore 9
    //   229: goto -215 -> 14
    //   232: astore_1
    //   233: aload_0
    //   234: monitorexit
    //   235: aload_1
    //   236: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	237	0	this	a
    //   0	237	1	paramf	f
    //   0	237	2	paramString	String
    //   115	41	3	f1	float
    //   97	89	4	i	int
    //   88	120	5	j	int
    //   106	86	6	k	int
    //   79	119	7	m	int
    //   174	34	8	n	int
    //   12	216	9	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   19	50	221	java/lang/Exception
    //   60	68	221	java/lang/Exception
    //   72	116	221	java/lang/Exception
    //   164	215	221	java/lang/Exception
    //   2	7	232	finally
    //   19	50	232	finally
    //   60	68	232	finally
    //   72	116	232	finally
    //   164	215	232	finally
    //   222	226	232	finally
  }
  
  public void b(f paramf, BaseAppBrandWebview paramBaseAppBrandWebview, String paramString, int paramInt)
  {
    for (;;)
    {
      Object localObject;
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("WebInputHandler", 2, "[hideKeyboard] jsPluginEngine=" + paramf + ", webview=" + paramBaseAppBrandWebview + ", webParams=" + paramString + ", callbackId=" + paramInt);
        }
        localObject = this.d;
        if (paramBaseAppBrandWebview != null) {}
        try
        {
          if (!(paramBaseAppBrandWebview instanceof PageWebview))
          {
            if (QLog.isColorLevel()) {
              QLog.e("WebInputHandler", 2, "[hideKeyboard] invalid webview");
            }
            return;
          }
          if ((paramf == null) || (paramf.a == null) || (paramf.a.g == null))
          {
            if (QLog.isColorLevel()) {
              QLog.e("WebInputHandler", 2, "[hideKeyboard] runtime error");
            }
            paramBaseAppBrandWebview.evaluateCallbackJs(paramInt, com.tencent.mobileqq.microapp.a.c.b("hideKeyboard", null).toString());
            continue;
            paramf = finally;
          }
        }
        finally {}
        if (!TextUtils.isEmpty(paramString)) {
          break label216;
        }
      }
      finally {}
      if (QLog.isColorLevel()) {
        QLog.e("WebInputHandler", 2, "[hideKeyboard] no web input params");
      }
      paramBaseAppBrandWebview.evaluateCallbackJs(paramInt, com.tencent.mobileqq.microapp.a.c.b("hideKeyboard", null).toString());
      continue;
      label216:
      if ((AbsAppBrandPage)paramf.a.g.pageLinkedList.peek() == null) {
        paramBaseAppBrandWebview.evaluateCallbackJs(paramInt, com.tencent.mobileqq.microapp.a.c.b("hideKeyboard", null).toString());
      }
      try
      {
        paramf = paramBaseAppBrandWebview.getContext();
        int i = new JSONObject(paramString).optInt("inputId");
        if (!this.g.containsKey(Integer.valueOf(i)))
        {
          paramBaseAppBrandWebview.evaluateCallbackJs(paramInt, com.tencent.mobileqq.microapp.a.c.a("hideKeyboard", null).toString());
          continue;
        }
        WebEditText localWebEditText = (WebEditText)this.g.remove(Integer.valueOf(i));
        paramBaseAppBrandWebview.evaluateCallbackJs(paramInt, com.tencent.mobileqq.microapp.a.c.a("hideKeyboard", null).toString());
        paramString = new JSONObject();
        paramString.put("inputId", i);
        paramString.put("value", localWebEditText.getText().toString());
        paramString.put("cursor", localWebEditText.getText().toString().length());
        this.a.add(localWebEditText);
        localWebEditText.setFocusable(false);
        localWebEditText.setFocusableInTouchMode(false);
        localWebEditText.clearFocus();
        ((InputMethodManager)paramf.getSystemService("input_method")).hideSoftInputFromWindow(localWebEditText.getWindowToken(), 0);
        localWebEditText.c();
        paramf = (PageWebview)paramBaseAppBrandWebview;
        paramf.evaluateSubcribeJS("onKeyboardComplete", paramString.toString(), paramf.pageWebviewId);
      }
      catch (Exception paramf)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("WebInputHandler", 2, "hideKeyboard, exception", paramf);
          }
        }
      }
    }
  }
  
  public boolean b()
  {
    return this.e != null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.widget.input.a
 * JD-Core Version:    0.7.0.1
 */