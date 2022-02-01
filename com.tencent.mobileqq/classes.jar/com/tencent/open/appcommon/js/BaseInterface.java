package com.tencent.open.appcommon.js;

import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.jsbridge.JsBridge.JsBridgeListener;
import com.tencent.mobileqq.jsbridge.JsBridge.JsHandler;
import com.tencent.open.base.LogUtility;
import com.tencent.open.base.StringAddition;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class BaseInterface
  extends JsBridge.JsHandler
{
  protected static final Pattern HTTPS_PATTERN = Pattern.compile("^https://(\\w+\\.)+qq\\.com/.*");
  protected static final int NO_AUTH_CODE = -1;
  protected static final String NO_AUTH_MSG = "baby,you don't have permission";
  private static final String TAG = "BaseInterface";
  protected static final Pattern qqPattern = Pattern.compile("^http://(\\w+\\.)+qq\\.com/.*");
  public List<String> batchCallbackQueue = new ArrayList();
  protected String currentUrl = "";
  protected boolean firstIn = true;
  protected boolean jsRight = true;
  public TimerTask mTask = null;
  public int optLef = 0;
  
  public void addResult(WebView paramWebView, long paramLong1, String paramString, long paramLong2, int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("callBatch addResult result : ");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(", timeout : ");
    ((StringBuilder)localObject).append(paramLong2);
    ((StringBuilder)localObject).append(", queueLimit : ");
    ((StringBuilder)localObject).append(paramInt);
    LogUtility.c("BaseInterface", ((StringBuilder)localObject).toString());
    if (this.firstIn)
    {
      localObject = ThreadManager.getTimer();
      BaseInterface.1 local1 = new BaseInterface.1(this, paramWebView, paramLong1);
      this.mTask = local1;
      ((Timer)localObject).schedule(local1, paramLong2, paramLong2);
      this.firstIn = false;
    }
    try
    {
      this.batchCallbackQueue.add(paramString);
      if ((this.batchCallbackQueue.size() >= this.optLef) || (this.batchCallbackQueue.size() >= paramInt))
      {
        LogUtility.c("BaseInterface", "callBatch one batch complete , call batchCallback once !!!");
        this.mTask.cancel();
        this.firstIn = true;
        batchCallback(paramWebView, paramLong1);
      }
      return;
    }
    finally {}
  }
  
  protected void batchCallback(WebView paramWebView, long paramLong)
  {
    ArrayList localArrayList = new ArrayList();
    try
    {
      this.optLef -= this.batchCallbackQueue.size();
      Iterator localIterator = this.batchCallbackQueue.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (!str.equals("void")) {
          localArrayList.add(str);
        }
      }
      this.batchCallbackQueue.clear();
      if (localArrayList.size() > 0)
      {
        new Handler(Looper.getMainLooper()).post(new BaseInterface.2(this, paramLong, localArrayList, paramWebView));
        return;
      }
      LogUtility.c("BaseInterface", "Response<callBatch> AsyncInterface no need response");
      return;
    }
    finally {}
    for (;;)
    {
      throw paramWebView;
    }
  }
  
  protected void batchCallbackError(WebView paramWebView, long paramLong, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("batchCallbackError guid : ");
    localStringBuilder.append(paramLong);
    localStringBuilder.append(", msg : ");
    localStringBuilder.append(paramString);
    LogUtility.c("BaseInterface", localStringBuilder.toString());
    new Handler(Looper.getMainLooper()).post(new BaseInterface.3(this, paramLong, paramString, paramWebView));
  }
  
  public void call(String paramString, List<String> paramList, JsBridge.JsBridgeListener paramJsBridgeListener)
  {
    long l2 = System.currentTimeMillis();
    Object localObject2 = getClass().getMethods();
    int j = localObject2.length;
    int i = 0;
    while (i < j)
    {
      localObject1 = localObject2[i];
      if ((((Method)localObject1).getName().equals(paramString)) && (((Method)localObject1).getParameterTypes().length == paramList.size())) {
        break label78;
      }
      i += 1;
    }
    Object localObject1 = null;
    label78:
    localObject2 = localObject1;
    Object localObject3;
    if (localObject1 == null)
    {
      try
      {
        localObject4 = Class.forName("com.tencent.open.appcommon.js.BaseJsCallBack");
      }
      catch (Exception localException2)
      {
        localException2.printStackTrace();
        localObject4 = null;
      }
      localObject3 = localObject1;
      if (localObject4 != null)
      {
        localObject4 = ((Class)localObject4).getMethods();
        localObject3 = localObject1;
        if (localObject4 != null)
        {
          localObject3 = localObject1;
          if (localObject4.length > 0)
          {
            j = localObject4.length;
            i = 0;
            for (;;)
            {
              localObject3 = localObject1;
              if (i >= j) {
                break;
              }
              localObject3 = localObject4[i];
              if ((((Method)localObject3).getName().equals(paramString)) && (((Method)localObject3).getParameterTypes().length == paramList.size())) {
                break;
              }
              i += 1;
            }
          }
        }
      }
    }
    long l1 = System.currentTimeMillis();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AsyncInterface:[");
    Object localObject4 = "";
    if (localObject3 == null) {
      localObject1 = "";
    } else {
      localObject1 = ((Method)localObject3).getName();
    }
    localStringBuilder.append((String)localObject1);
    localStringBuilder.append("]:Reflct find method cost::time6-time5=");
    localStringBuilder.append(l1 - l2);
    LogUtility.b("TIME", localStringBuilder.toString());
    if (localObject3 != null) {}
    try
    {
      if (paramList.size() == 0) {
        localObject1 = ((Method)localObject3).invoke(this, new Object[0]);
      } else {
        localObject1 = ((Method)localObject3).invoke(this, paramList.toArray());
      }
      l2 = System.currentTimeMillis();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("AsyncInterface:[");
      if (localObject3 != null) {
        localObject4 = ((Method)localObject3).getName();
      }
      localStringBuilder.append((String)localObject4);
      localStringBuilder.append("]:Invoke find method cost:time7-time6=");
      localStringBuilder.append(l2 - l1);
      LogUtility.b("TIME", localStringBuilder.toString());
      localObject3 = ((Method)localObject3).getReturnType();
      if ((localObject3 != Void.TYPE) && (localObject3 != Void.class))
      {
        if (paramJsBridgeListener != null)
        {
          if (customCallback())
          {
            if ((paramJsBridgeListener instanceof OpenJsBridge.OpenJsBridgeListener)) {
              return;
            }
            paramJsBridgeListener.a(localObject1.toString());
            return;
          }
          if ((paramJsBridgeListener instanceof OpenJsBridge.OpenJsBridgeListener))
          {
            ((OpenJsBridge.OpenJsBridgeListener)paramJsBridgeListener).a(paramString, localObject1);
            return;
          }
          paramJsBridgeListener.a(localObject1);
        }
      }
      else
      {
        if ((paramJsBridgeListener instanceof OpenJsBridge.OpenJsBridgeListener))
        {
          ((OpenJsBridge.OpenJsBridgeListener)paramJsBridgeListener).a(paramString, null);
          return;
        }
        paramJsBridgeListener.a(null);
      }
      return;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      break label596;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      break label567;
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      label538:
      label567:
      label596:
      break label538;
    }
    catch (Exception localException1)
    {
      label509:
      break label509;
    }
    if (paramJsBridgeListener != null) {
      if ((paramJsBridgeListener instanceof OpenJsBridge.OpenJsBridgeListener))
      {
        ((OpenJsBridge.OpenJsBridgeListener)paramJsBridgeListener).b(paramString);
      }
      else
      {
        paramJsBridgeListener.a();
        break label622;
        if (paramJsBridgeListener != null) {
          if ((paramJsBridgeListener instanceof OpenJsBridge.OpenJsBridgeListener))
          {
            ((OpenJsBridge.OpenJsBridgeListener)paramJsBridgeListener).b(paramString);
          }
          else
          {
            paramJsBridgeListener.a();
            break label622;
            if (paramJsBridgeListener != null) {
              if ((paramJsBridgeListener instanceof OpenJsBridge.OpenJsBridgeListener))
              {
                ((OpenJsBridge.OpenJsBridgeListener)paramJsBridgeListener).b(paramString);
              }
              else
              {
                paramJsBridgeListener.a();
                break label622;
                if (paramJsBridgeListener != null) {
                  if ((paramJsBridgeListener instanceof OpenJsBridge.OpenJsBridgeListener)) {
                    ((OpenJsBridge.OpenJsBridgeListener)paramJsBridgeListener).b(paramString);
                  } else {
                    paramJsBridgeListener.a();
                  }
                }
              }
            }
          }
        }
      }
    }
    label622:
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("cannot found match method,maybe your method using args type is NO String? request method:class:");
    ((StringBuilder)localObject1).append(getClass().getSimpleName());
    ((StringBuilder)localObject1).append(paramString);
    ((StringBuilder)localObject1).append(" args:");
    ((StringBuilder)localObject1).append(paramList);
    QLog.d("BaseInterface", 4, ((StringBuilder)localObject1).toString());
    if (paramJsBridgeListener != null)
    {
      if ((paramJsBridgeListener instanceof OpenJsBridge.OpenJsBridgeListener))
      {
        ((OpenJsBridge.OpenJsBridgeListener)paramJsBridgeListener).b(paramString);
        return;
      }
      paramJsBridgeListener.a();
    }
  }
  
  public void callBatch(WebView paramWebView, HashMap<String, JsBridge.JsHandler> paramHashMap, long paramLong1, String paramString, long paramLong2, int paramInt)
  {
    try
    {
      JSONArray localJSONArray = new JSONArray(URLDecoder.decode(paramString, "UTF-8"));
      this.optLef = localJSONArray.length();
      int i = 0;
      while (i < localJSONArray.length())
      {
        paramString = localJSONArray.optJSONObject(i);
        if (paramString != null) {
          for (;;)
          {
            Object localObject2 = paramString.optString("ns");
            String str1 = paramString.optString("method");
            String str2 = paramString.optString("guid");
            paramString = paramString.optString("args");
            ArrayList localArrayList = new ArrayList();
            try
            {
              paramString = new JSONArray(paramString);
              int j = 0;
              while (j < paramString.length())
              {
                localArrayList.add(paramString.getString(j));
                j += 1;
              }
              if (AsyncMethodMap.a.contains(str1)) {
                localArrayList.add(str2);
              }
              paramString = (Class)AsyncMethodMap.b.get(localObject2);
              if (paramString != null)
              {
                paramString = paramString.getMethods();
                int k = paramString.length;
                j = 0;
                while (j < k)
                {
                  localObject1 = paramString[j];
                  if ((((Method)localObject1).getName().equals(str1)) && (((Method)localObject1).getParameterTypes().length == localArrayList.size()))
                  {
                    paramString = (String)localObject1;
                    break label272;
                  }
                  j += 1;
                }
                paramString = null;
                label272:
                if (paramString != null)
                {
                  localObject1 = paramHashMap.get(localObject2);
                  try
                  {
                    localObject2 = new StringBuilder();
                    ((StringBuilder)localObject2).append("callBatch <call> class : ");
                    ((StringBuilder)localObject2).append(localObject1.getClass().getName());
                    ((StringBuilder)localObject2).append(" , method : ");
                    ((StringBuilder)localObject2).append(str1);
                    ((StringBuilder)localObject2).append("\n , args : ");
                    ((StringBuilder)localObject2).append(localArrayList.toString());
                    LogUtility.b("BaseInterface", ((StringBuilder)localObject2).toString());
                    if (localArrayList.size() == 0) {
                      localObject1 = paramString.invoke(localObject1, new Object[0]);
                    } else {
                      localObject1 = paramString.invoke(localObject1, localArrayList.toArray());
                    }
                    paramString = paramString.getReturnType();
                    if ((paramString != Void.TYPE) && (paramString != Void.class))
                    {
                      paramString = "'undefined'";
                      if ((localObject1 instanceof String))
                      {
                        paramString = ((String)localObject1).replace("\\", "\\\\").replace("'", "\\'");
                        localObject1 = new StringBuilder();
                        ((StringBuilder)localObject1).append("'");
                        ((StringBuilder)localObject1).append(paramString);
                        ((StringBuilder)localObject1).append("'");
                        paramString = ((StringBuilder)localObject1).toString();
                      }
                      else if ((!(localObject1 instanceof Number)) && (!(localObject1 instanceof Long)) && (!(localObject1 instanceof Integer)) && (!(localObject1 instanceof Double)) && (!(localObject1 instanceof Float)))
                      {
                        if ((localObject1 instanceof Boolean)) {
                          paramString = localObject1.toString();
                        }
                      }
                      else
                      {
                        paramString = localObject1.toString();
                      }
                      localObject1 = new StringBuilder();
                      ((StringBuilder)localObject1).append("['interface.");
                      ((StringBuilder)localObject1).append(str1);
                      ((StringBuilder)localObject1).append("',{'guid':");
                      ((StringBuilder)localObject1).append(str2);
                      ((StringBuilder)localObject1).append(",'r':0,'data':");
                      ((StringBuilder)localObject1).append(paramString);
                      ((StringBuilder)localObject1).append("}]");
                      paramString = ((StringBuilder)localObject1).toString();
                    }
                    try
                    {
                      addResult(paramWebView, paramLong1, paramString, paramLong2, paramInt);
                    }
                    catch (Exception paramString)
                    {
                      break label696;
                    }
                    addResult(paramWebView, paramLong1, "void", paramLong2, paramInt);
                  }
                  catch (Exception paramString) {}
                  label696:
                  LogUtility.c("BaseInterface", "callBatch error", paramString);
                }
              }
            }
            catch (Exception paramString)
            {
              Object localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("callBatch args error : ");
              ((StringBuilder)localObject1).append(paramString.toString());
              LogUtility.e("BaseInterface", ((StringBuilder)localObject1).toString());
              this.optLef -= 1;
            }
          }
        }
        i += 1;
      }
      return;
    }
    catch (UnsupportedEncodingException paramHashMap)
    {
      LogUtility.b("BaseInterface", "callBatch decode params format err", paramHashMap);
      batchCallbackError(paramWebView, paramLong1, "callBatch callBatch decode params format err");
      return;
    }
    catch (JSONException paramHashMap)
    {
      LogUtility.b("BaseInterface", "callBatch request params format err", paramHashMap);
      batchCallbackError(paramWebView, paramLong1, "callBatch request params format err");
    }
  }
  
  public void destroy()
  {
    TimerTask localTimerTask = this.mTask;
    if (localTimerTask != null)
    {
      localTimerTask.cancel();
      this.mTask = null;
    }
  }
  
  public void doOnCreate() {}
  
  public void doOnDestroy() {}
  
  public void doOnPause() {}
  
  public void doOnResume() {}
  
  public abstract String getInterfaceName();
  
  public boolean hasRight()
  {
    if (!this.jsRight)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(" js interface has no permission, ");
      localStringBuilder.append(this.currentUrl);
      LogUtility.e("AppStore", localStringBuilder.toString());
    }
    return this.jsRight;
  }
  
  void setCurrentUrl(String paramString)
  {
    this.currentUrl = paramString.toLowerCase();
    try
    {
      if ((!StringAddition.d(this.currentUrl)) && (!this.currentUrl.startsWith("file://")))
      {
        if (qqPattern.matcher(this.currentUrl).find())
        {
          this.jsRight = true;
          return;
        }
        if (HTTPS_PATTERN.matcher(this.currentUrl).find())
        {
          this.jsRight = true;
          return;
        }
        this.jsRight = false;
        return;
      }
      this.jsRight = true;
      return;
    }
    catch (Exception paramString)
    {
      label90:
      break label90;
    }
    this.jsRight = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.appcommon.js.BaseInterface
 * JD-Core Version:    0.7.0.1
 */