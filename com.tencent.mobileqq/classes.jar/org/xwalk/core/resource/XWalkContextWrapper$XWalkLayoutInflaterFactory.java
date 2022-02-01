package org.xwalk.core.resource;

import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.LayoutInflater.Factory;
import android.view.View;
import android.view.ViewStub;
import org.xwalk.core.Log;

final class XWalkContextWrapper$XWalkLayoutInflaterFactory
  implements LayoutInflater.Factory
{
  LayoutInflater layoutInflater;
  
  private View createView(String paramString1, String paramString2, AttributeSet paramAttributeSet)
  {
    try
    {
      paramString1 = this.layoutInflater.createView(paramString1, paramString2, paramAttributeSet);
      return paramString1;
    }
    catch (InflateException|ClassNotFoundException paramString1)
    {
      label13:
      break label13;
    }
    return null;
  }
  
  public View inflateView(String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    int i = paramString.indexOf(".");
    Object localObject = null;
    if (i == -1)
    {
      if (paramString.equals("WebView")) {
        localObject = createView(paramString, "android.webkit.", paramAttributeSet);
      }
      paramContext = (Context)localObject;
      if (localObject == null) {
        paramContext = createView(paramString, "android.widget.", paramAttributeSet);
      }
      localObject = paramContext;
      if (paramContext == null) {
        return createView(paramString, "android.view.", paramAttributeSet);
      }
    }
    else
    {
      localObject = this.layoutInflater.createView(paramString, null, paramAttributeSet);
    }
    return localObject;
  }
  
  public View onCreateView(String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    Context localContext2 = null;
    Context localContext1 = null;
    try
    {
      paramContext = inflateView(paramString, paramContext, paramAttributeSet);
      paramAttributeSet = paramContext;
      localContext1 = paramContext;
      localContext2 = paramContext;
      if (!(paramContext instanceof ViewStub)) {
        break label106;
      }
      paramAttributeSet = paramContext;
      localContext1 = paramContext;
      localContext2 = paramContext;
      if (Build.VERSION.SDK_INT < 21) {
        break label106;
      }
      localContext1 = paramContext;
      localContext2 = paramContext;
      ((ViewStub)paramContext).setLayoutInflater(this.layoutInflater);
      return paramContext;
    }
    catch (ClassNotFoundException paramContext)
    {
      break label85;
    }
    catch (InflateException paramContext)
    {
      label64:
      break label64;
    }
    Log.w("XWalkLib", String.format("[XWalkContextWrapper] Inflate failed. name:%s. Use default Inflate.", new Object[] { paramString }));
    return localContext2;
    label85:
    Log.w("XWalkLib", String.format("[XWalkContextWrapper] class not found. name:%s. Use default Inflate.", new Object[] { paramString }));
    paramAttributeSet = localContext1;
    label106:
    return paramAttributeSet;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.xwalk.core.resource.XWalkContextWrapper.XWalkLayoutInflaterFactory
 * JD-Core Version:    0.7.0.1
 */