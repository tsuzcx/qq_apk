package com.tencent.mobileqq.uftransfer.common.transfer.urlprovider;

import android.text.TextUtils;
import com.tencent.mobileqq.uftransfer.UFTLogicThread;
import com.tencent.mobileqq.uftransfer.depend.UFTLog;
import java.util.List;
import mqq.app.AppRuntime;

public class UFTUrlProvider
{
  protected long c;
  protected final UFTHttpUrlProcessor d;
  protected int e = 0;
  protected int f = 0;
  protected boolean g = false;
  protected String h;
  protected UFTUrlProvider.UrlRetryContent i = new UFTUrlProvider.UrlRetryContent(this);
  protected final IUFTRetryCallback j;
  protected int k = 6;
  protected int l = 3;
  protected int m = 3;
  
  public UFTUrlProvider(AppRuntime paramAppRuntime, List<String> paramList, String paramString, long paramLong, boolean paramBoolean, IUFTRetryCallback paramIUFTRetryCallback)
  {
    this.d = new UFTHttpUrlProcessor(paramAppRuntime, paramList, paramString, paramBoolean);
    this.j = paramIUFTRetryCallback;
    this.c = paramLong;
  }
  
  private String e()
  {
    String str = this.d.a();
    if (str != null)
    {
      this.f += 1;
      this.i.a();
    }
    return str;
  }
  
  public String a()
  {
    int n = 0;
    int i1;
    do
    {
      str = this.d.a();
      if (str == null) {
        break;
      }
      if (!TextUtils.isEmpty(str)) {
        break label41;
      }
      i1 = n + 1;
      n = i1;
    } while (i1 < 8);
    String str = null;
    label41:
    this.h = str;
    this.g = false;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    localStringBuilder.append(this.c);
    localStringBuilder.append("] initProvider init:");
    localStringBuilder.append(str);
    UFTLog.b("[UFTTransfer] UFTUrlProvider", 1, localStringBuilder.toString());
    return str;
  }
  
  protected String a(String paramString, int paramInt, boolean paramBoolean)
  {
    Object localObject;
    if (a(paramInt))
    {
      localObject = e();
      if ((TextUtils.isEmpty((CharSequence)localObject)) && (a(this.i)))
      {
        a(this.i, paramInt, paramBoolean);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[");
        ((StringBuilder)localObject).append(this.c);
        ((StringBuilder)localObject).append("] selectUrl:");
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append(this.i.toString());
        ((StringBuilder)localObject).append(" no more url, use cur errurl retry");
        UFTLog.b("[UFTTransfer] UFTUrlProvider", 1, ((StringBuilder)localObject).toString());
        return paramString;
      }
      return localObject;
    }
    if (a(this.i))
    {
      a(this.i, paramInt, paramBoolean);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[");
      ((StringBuilder)localObject).append(this.c);
      ((StringBuilder)localObject).append("] selectUrl:");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(this.i.toString());
      ((StringBuilder)localObject).append(" use cur errurl retry");
      UFTLog.b("[UFTTransfer] UFTUrlProvider", 1, ((StringBuilder)localObject).toString());
      return paramString;
    }
    return e();
  }
  
  protected void a(UFTUrlProvider.UrlRetryContent paramUrlRetryContent, int paramInt, boolean paramBoolean)
  {
    if (9056 == paramInt)
    {
      if (paramUrlRetryContent.b < this.l)
      {
        paramUrlRetryContent.b += 1;
      }
      else
      {
        paramUrlRetryContent.b = 0;
        paramUrlRetryContent.a += 1;
      }
    }
    else if (paramBoolean)
    {
      if (paramUrlRetryContent.c < this.m)
      {
        paramUrlRetryContent.c += 1;
      }
      else
      {
        paramUrlRetryContent.c = 0;
        paramUrlRetryContent.a += 1;
      }
    }
    else {
      paramUrlRetryContent.a += 1;
    }
    paramUrlRetryContent.d += 1;
  }
  
  public void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (!paramString.equals(this.h)) {
        return;
      }
      paramString = this.i;
      paramString.a = 0;
      paramString.b = 0;
      paramString.e = true;
    }
  }
  
  protected boolean a(int paramInt)
  {
    if (this.i.e) {
      return false;
    }
    return (paramInt == 9052) || (paramInt == 9050) || (paramInt == 9055) || (paramInt == 9053) || (paramInt == 9054);
  }
  
  protected boolean a(UFTUrlProvider.UrlRetryContent paramUrlRetryContent)
  {
    if (paramUrlRetryContent == null) {
      return false;
    }
    return paramUrlRetryContent.a < this.k;
  }
  
  public int b()
  {
    return this.i.a;
  }
  
  public boolean b(String paramString, int paramInt, boolean paramBoolean)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramString.equals(this.h)))
    {
      String str = a(paramString, paramInt, paramBoolean);
      if (TextUtils.isEmpty(str))
      {
        this.g = true;
        paramString = new StringBuilder();
        paramString.append("[");
        paramString.append(this.c);
        paramString.append("] reqUrlRetryOnErr fail. all retry over or has err. errCode:");
        paramString.append(paramInt);
        paramString.append(" svrRetryErr:");
        paramString.append(paramBoolean);
        paramString.append(d());
        UFTLog.d("[UFTTransfer] UFTUrlProvider", 1, paramString.toString());
        return false;
      }
      long l1 = 100L;
      if (9056 != paramInt) {
        l1 = this.j.h();
      }
      UFTLogicThread.a().a(new UFTUrlProvider.1(this, str), l1);
      this.h = str;
      this.g = false;
      this.e += 1;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[");
      localStringBuilder.append(this.c);
      localStringBuilder.append("] reqUrlRetryOnErr suc, delay:");
      localStringBuilder.append(l1);
      localStringBuilder.append(" errCode:");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" svrRetryErr:");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(" strErrUrl:");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" selectUrl:");
      localStringBuilder.append(str);
      localStringBuilder.append(d());
      UFTLog.b("[UFTTransfer] UFTUrlProvider", 1, localStringBuilder.toString());
      return true;
    }
    this.g = true;
    paramString = new StringBuilder();
    paramString.append("[");
    paramString.append(this.c);
    paramString.append("] reqUrlRetryOnErr fail. strErrUrl is no match");
    UFTLog.d("[UFTTransfer] UFTUrlProvider", 1, paramString.toString());
    return false;
  }
  
  public boolean c()
  {
    return this.g;
  }
  
  protected String d()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("totalRetries:");
    localStringBuilder.append(this.e);
    localStringBuilder.append(" UrlChgedT:");
    localStringBuilder.append(this.f);
    localStringBuilder.append(this.i.toString());
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.common.transfer.urlprovider.UFTUrlProvider
 * JD-Core Version:    0.7.0.1
 */