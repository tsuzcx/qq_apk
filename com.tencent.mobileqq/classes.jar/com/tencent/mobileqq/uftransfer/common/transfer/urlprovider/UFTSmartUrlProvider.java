package com.tencent.mobileqq.uftransfer.common.transfer.urlprovider;

import android.text.TextUtils;
import com.tencent.mobileqq.uftransfer.depend.UFTLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import mqq.app.AppRuntime;

public class UFTSmartUrlProvider
  extends UFTUrlProvider
{
  protected boolean a = false;
  protected Map<String, UFTUrlProvider.UrlRetryContent> b = new HashMap();
  
  public UFTSmartUrlProvider(AppRuntime paramAppRuntime, List<String> paramList, String paramString, long paramLong, boolean paramBoolean, IUFTRetryCallback paramIUFTRetryCallback)
  {
    super(paramAppRuntime, paramList, paramString, paramLong, paramBoolean, paramIUFTRetryCallback);
  }
  
  private void a(String paramString, UFTUrlProvider.UrlRetryContent paramUrlRetryContent, boolean paramBoolean)
  {
    if (paramBoolean) {}
    try
    {
      this.b.clear();
      this.b.put(paramString, paramUrlRetryContent);
      return;
    }
    finally {}
  }
  
  private UFTUrlProvider.UrlRetryContent b(String paramString)
  {
    try
    {
      paramString = (UFTUrlProvider.UrlRetryContent)this.b.get(paramString);
      return paramString;
    }
    finally {}
  }
  
  public String a()
  {
    Object localObject1 = null;
    int i = 0;
    int j;
    do
    {
      String str = this.d.a();
      if (str == null) {
        break;
      }
      localObject2 = localObject1;
      if (!TextUtils.isEmpty(str))
      {
        a(str, new UFTUrlProvider.UrlRetryContent(this), false);
        localObject2 = localObject1;
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          localObject2 = str;
        }
      }
      j = i + 1;
      localObject1 = localObject2;
      i = j;
    } while (j < 16);
    localObject1 = localObject2;
    this.h = ((String)localObject1);
    this.g = false;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("[");
    ((StringBuilder)localObject2).append(this.c);
    ((StringBuilder)localObject2).append("] initProvider init:");
    ((StringBuilder)localObject2).append((String)localObject1);
    UFTLog.b("[UFTTransfer] UFTSmartUrlProvider", 1, ((StringBuilder)localObject2).toString());
    return localObject1;
  }
  
  protected String a(String paramString, int paramInt, boolean paramBoolean)
  {
    Object localObject1 = b(paramString);
    if (localObject1 == null)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("[");
      ((StringBuilder)localObject1).append(this.c);
      ((StringBuilder)localObject1).append("] selectUrl err. not find strErrUrl. strErrUrl:");
      ((StringBuilder)localObject1).append(paramString);
      UFTLog.d("[UFTTransfer] UFTSmartUrlProvider", 1, ((StringBuilder)localObject1).toString());
      return null;
    }
    Object localObject2;
    if (((9056 == paramInt) || (paramBoolean)) && (a((UFTUrlProvider.UrlRetryContent)localObject1)))
    {
      a((UFTUrlProvider.UrlRetryContent)localObject1, paramInt, paramBoolean);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[");
      ((StringBuilder)localObject2).append(this.c);
      ((StringBuilder)localObject2).append("] selectUrl:");
      ((StringBuilder)localObject2).append(paramString);
      ((StringBuilder)localObject2).append(((UFTUrlProvider.UrlRetryContent)localObject1).toString());
      ((StringBuilder)localObject2).append(" eof err or serr, use cur errurl");
      UFTLog.b("[UFTTransfer] UFTSmartUrlProvider", 1, ((StringBuilder)localObject2).toString());
      return paramString;
    }
    paramString = new UFTUrlProvider.UrlRetryContent(this);
    paramString.a = 2147483647;
    paramString.b = 2147483647;
    paramString.c = 2147483647;
    paramString.d = 2147483647;
    try
    {
      Iterator localIterator = this.b.entrySet().iterator();
      localObject1 = null;
      while (localIterator.hasNext())
      {
        Object localObject3 = (Map.Entry)localIterator.next();
        localObject2 = (String)((Map.Entry)localObject3).getKey();
        localObject3 = (UFTUrlProvider.UrlRetryContent)((Map.Entry)localObject3).getValue();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[");
        localStringBuilder.append(this.c);
        localStringBuilder.append("]");
        localStringBuilder.append((String)localObject2);
        localStringBuilder.append(" <->");
        localStringBuilder.append(((UFTUrlProvider.UrlRetryContent)localObject3).toString());
        UFTLog.b("[UFTTransfer] UFTSmartUrlProvider", 1, localStringBuilder.toString());
        if (((UFTUrlProvider.UrlRetryContent)localObject3).a < paramString.a)
        {
          paramString = (String)localObject3;
          localObject1 = localObject2;
        }
      }
      if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (a(paramString)))
      {
        a(paramString, paramInt, paramBoolean);
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("[");
        ((StringBuilder)localObject2).append(this.c);
        ((StringBuilder)localObject2).append("] selectUrl:");
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(paramString.toString());
        UFTLog.b("[UFTTransfer] UFTSmartUrlProvider", 1, ((StringBuilder)localObject2).toString());
        return localObject1;
      }
      this.g = true;
      paramString = new StringBuilder();
      paramString.append("[");
      paramString.append(this.c);
      paramString.append("] all retry over and fail");
      UFTLog.d("[UFTTransfer] UFTSmartUrlProvider", 1, paramString.toString());
      return null;
    }
    finally {}
    for (;;)
    {
      throw paramString;
    }
  }
  
  public void a(String paramString)
  {
    Object localObject = b(paramString);
    if (localObject == null) {
      return;
    }
    ((UFTUrlProvider.UrlRetryContent)localObject).a = 0;
    ((UFTUrlProvider.UrlRetryContent)localObject).b = 0;
    ((UFTUrlProvider.UrlRetryContent)localObject).e = true;
    if (!this.a)
    {
      this.a = true;
      a(paramString, (UFTUrlProvider.UrlRetryContent)localObject, true);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[");
      ((StringBuilder)localObject).append(this.c);
      ((StringBuilder)localObject).append("] data conned. lockedUseThisUrl:");
      ((StringBuilder)localObject).append(paramString);
      UFTLog.b("[UFTTransfer] UFTSmartUrlProvider", 1, ((StringBuilder)localObject).toString());
    }
  }
  
  public int b()
  {
    UFTUrlProvider.UrlRetryContent localUrlRetryContent = b(this.h);
    if (localUrlRetryContent != null) {
      return localUrlRetryContent.a;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.common.transfer.urlprovider.UFTSmartUrlProvider
 * JD-Core Version:    0.7.0.1
 */