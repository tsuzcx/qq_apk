package com.tencent.mobileqq.troop.filemanager;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.core.HttpUrlProcessor;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import mqq.os.MqqHandler;

public class TroopFileTransferRetryController
{
  protected long a;
  protected final HttpUrlProcessor b;
  protected int c = 0;
  protected int d = 0;
  protected int e = 0;
  protected final TroopFileTransferRetryController.ITroopFileTransferRetrySink f;
  protected boolean g = false;
  protected boolean h = false;
  protected int i = 0;
  protected Map<String, TroopFileTransferRetryController.RetryContent> j = new HashMap();
  protected int k = 3;
  protected int l = 3;
  protected int m = 3;
  protected int n = 30;
  
  public TroopFileTransferRetryController(QQAppInterface paramQQAppInterface, List<String> paramList, String paramString, long paramLong, boolean paramBoolean, TroopFileTransferRetryController.ITroopFileTransferRetrySink paramITroopFileTransferRetrySink)
  {
    this.b = new HttpUrlProcessor(paramQQAppInterface, paramList, paramString);
    if (paramBoolean) {
      this.b.a(true);
    }
    this.f = paramITroopFileTransferRetrySink;
    this.a = paramLong;
  }
  
  public String a()
  {
    int i1 = 1;
    Object localObject1 = null;
    int i2 = 0;
    Object localObject2;
    int i3;
    do
    {
      String str = this.b.b();
      if (!TextUtils.isEmpty(str))
      {
        this.j.put(str, new TroopFileTransferRetryController.RetryContent(this));
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = str;
        }
        i3 = i2 + 1;
        i2 = TroopFileTransferUtil.Log.b;
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("[");
        ((StringBuilder)localObject1).append(this.a);
        ((StringBuilder)localObject1).append("] retryContrller init:");
        ((StringBuilder)localObject1).append(str);
        TroopFileTransferUtil.Log.c("TroopFileTransferRetryController", i2, ((StringBuilder)localObject1).toString());
      }
      else
      {
        i1 = 0;
        i3 = i2;
        localObject2 = localObject1;
      }
      if (i1 == 0) {
        break;
      }
      localObject1 = localObject2;
      i2 = i3;
    } while (i3 < 4);
    return localObject2;
  }
  
  protected void a(TroopFileTransferRetryController.RetryContent paramRetryContent, int paramInt, boolean paramBoolean)
  {
    if (9056 == paramInt)
    {
      if (paramRetryContent.b < this.l)
      {
        paramRetryContent.b += 1;
        return;
      }
      paramRetryContent.b = 0;
      paramRetryContent.a += 1;
      this.d += 1;
      return;
    }
    if (paramBoolean)
    {
      if (paramRetryContent.c < this.m)
      {
        paramRetryContent.c += 1;
        return;
      }
      paramRetryContent.c = 0;
      paramRetryContent.a += 1;
      this.d += 1;
      return;
    }
    paramRetryContent.a += 1;
    this.d += 1;
  }
  
  public void a(String paramString)
  {
    try
    {
      Object localObject = (TroopFileTransferRetryController.RetryContent)this.j.get(paramString);
      if (localObject == null) {
        return;
      }
      if (!this.h)
      {
        this.h = true;
        ((TroopFileTransferRetryController.RetryContent)localObject).a();
        this.j.clear();
        this.j.put(paramString, localObject);
        i1 = TroopFileTransferUtil.Log.b;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[");
        ((StringBuilder)localObject).append(this.a);
        ((StringBuilder)localObject).append("] data conned. lockedUseThisUrl:");
        ((StringBuilder)localObject).append(paramString);
        TroopFileTransferUtil.Log.c("TroopFileTransferRetryController", i1, ((StringBuilder)localObject).toString());
        return;
      }
      int i1 = this.i;
      int i2 = this.n;
      if (i1 > i2) {
        return;
      }
      ((TroopFileTransferRetryController.RetryContent)localObject).a();
      this.i += 1;
      i1 = TroopFileTransferUtil.Log.b;
      paramString = new StringBuilder();
      paramString.append("[");
      paramString.append(this.a);
      paramString.append("] data conned. resetRetryInfo. resetcount:");
      paramString.append(this.i);
      TroopFileTransferUtil.Log.c("TroopFileTransferRetryController", i1, paramString.toString());
      return;
    }
    finally {}
  }
  
  public boolean a(String paramString, int paramInt, boolean paramBoolean)
  {
    if (this.f == null)
    {
      paramInt = TroopFileTransferUtil.Log.b;
      paramString = new StringBuilder();
      paramString.append("[");
      paramString.append(this.a);
      paramString.append("] reqRetryOnErr fail. sink=null");
      TroopFileTransferUtil.Log.a("TroopFileTransferRetryController", paramInt, paramString.toString());
      return false;
    }
    if (TextUtils.isEmpty(paramString))
    {
      paramInt = TroopFileTransferUtil.Log.b;
      paramString = new StringBuilder();
      paramString.append("[");
      paramString.append(this.a);
      paramString.append("] reqRetryOnErr fail. strErrUrl=null");
      TroopFileTransferUtil.Log.a("TroopFileTransferRetryController", paramInt, paramString.toString());
      return false;
    }
    Object localObject = b(paramString, paramInt, paramBoolean);
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      i1 = TroopFileTransferUtil.Log.b;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[");
      ((StringBuilder)localObject).append(this.a);
      ((StringBuilder)localObject).append("] reqRetryOnErr fail. all retry over or has err. errCode:");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(" bSvrErr:");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append(" ReportR:");
      ((StringBuilder)localObject).append(this.c);
      ((StringBuilder)localObject).append("UrlChgedT:");
      ((StringBuilder)localObject).append(this.e);
      ((StringBuilder)localObject).append(" strErrUrl:");
      ((StringBuilder)localObject).append(paramString);
      TroopFileTransferUtil.Log.a("TroopFileTransferRetryController", i1, ((StringBuilder)localObject).toString());
      return false;
    }
    long l1 = 100L;
    if (9056 != paramInt) {
      l1 = this.f.a();
    }
    ThreadManager.getSubThreadHandler().postDelayed(new TroopFileTransferRetryController.1(this, (String)localObject), l1);
    this.g = false;
    this.c += 1;
    if (!paramString.equalsIgnoreCase((String)localObject)) {
      this.e += 1;
    }
    int i1 = TroopFileTransferUtil.Log.b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    localStringBuilder.append(this.a);
    localStringBuilder.append("] reqRetryOnErr suc, delay:");
    localStringBuilder.append(l1);
    localStringBuilder.append(" errCode:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" bSvrErr:");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(" strErrUrl:");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" selectUrl:");
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(" ReportR:");
    localStringBuilder.append(this.c);
    localStringBuilder.append("UrlChgedT:");
    localStringBuilder.append(this.e);
    TroopFileTransferUtil.Log.c("TroopFileTransferRetryController", i1, localStringBuilder.toString());
    return true;
  }
  
  protected String b(String paramString, int paramInt, boolean paramBoolean)
  {
    try
    {
      TroopFileTransferRetryController.RetryContent localRetryContent = (TroopFileTransferRetryController.RetryContent)this.j.get(paramString);
      if (localRetryContent == null)
      {
        paramInt = TroopFileTransferUtil.Log.b;
        paramString = new StringBuilder();
        paramString.append("[");
        paramString.append(this.a);
        paramString.append("] selectUrl err. not find strErrUrl. urlCont:");
        paramString.append(this.j.size());
        TroopFileTransferUtil.Log.a("TroopFileTransferRetryController", paramInt, paramString.toString());
        return null;
      }
      if (((9056 == paramInt) || (paramBoolean)) && (localRetryContent.a < this.k))
      {
        a(localRetryContent, paramInt, paramBoolean);
        paramInt = TroopFileTransferUtil.Log.b;
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("[");
        ((StringBuilder)localObject1).append(this.a);
        ((StringBuilder)localObject1).append("] selectUrl:");
        ((StringBuilder)localObject1).append(paramString);
        ((StringBuilder)localObject1).append(localRetryContent.toString());
        ((StringBuilder)localObject1).append(" eof err or serr, use cur errurl");
        TroopFileTransferUtil.Log.c("TroopFileTransferRetryController", paramInt, ((StringBuilder)localObject1).toString());
        return paramString;
      }
      localObject1 = new TroopFileTransferRetryController.RetryContent(this);
      ((TroopFileTransferRetryController.RetryContent)localObject1).a = 2147483647;
      ((TroopFileTransferRetryController.RetryContent)localObject1).b = 2147483647;
      ((TroopFileTransferRetryController.RetryContent)localObject1).c = 2147483647;
      Iterator localIterator = this.j.entrySet().iterator();
      label246:
      Object localObject3;
      int i1;
      for (localObject2 = null; localIterator.hasNext(); localObject2 = localObject3)
      {
        Object localObject4 = (Map.Entry)localIterator.next();
        localObject3 = (String)((Map.Entry)localObject4).getKey();
        localObject4 = (TroopFileTransferRetryController.RetryContent)((Map.Entry)localObject4).getValue();
        i1 = TroopFileTransferUtil.Log.b;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[");
        localStringBuilder.append(this.a);
        localStringBuilder.append("]");
        localStringBuilder.append((String)localObject3);
        localStringBuilder.append(" <->");
        localStringBuilder.append(((TroopFileTransferRetryController.RetryContent)localObject4).toString());
        TroopFileTransferUtil.Log.c("TroopFileTransferRetryController", i1, localStringBuilder.toString());
        if ((paramString.equalsIgnoreCase((String)localObject3)) || (((TroopFileTransferRetryController.RetryContent)localObject4).a >= ((TroopFileTransferRetryController.RetryContent)localObject1).a)) {
          break label246;
        }
        localObject1 = localObject4;
      }
      if (localObject2 != null) {
        if (((TroopFileTransferRetryController.RetryContent)localObject1).a < this.k) {
          break label723;
        }
      }
      if (localObject2 == null)
      {
        i1 = TroopFileTransferUtil.Log.b;
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("[");
        ((StringBuilder)localObject1).append(this.a);
        ((StringBuilder)localObject1).append("] no next url use cur errurl");
        TroopFileTransferUtil.Log.b("TroopFileTransferRetryController", i1, ((StringBuilder)localObject1).toString());
        localObject1 = localRetryContent;
      }
      else
      {
        i1 = TroopFileTransferUtil.Log.b;
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("[");
        ((StringBuilder)localObject3).append(this.a);
        ((StringBuilder)localObject3).append("] minurl retry over, use cur errurl. minRetryUrl:");
        ((StringBuilder)localObject3).append((String)localObject2);
        ((StringBuilder)localObject3).append(((TroopFileTransferRetryController.RetryContent)localObject1).toString());
        TroopFileTransferUtil.Log.b("TroopFileTransferRetryController", i1, ((StringBuilder)localObject3).toString());
        localObject1 = localRetryContent;
      }
    }
    finally
    {
      for (;;)
      {
        Object localObject1;
        Object localObject2;
        for (;;)
        {
          throw paramString;
        }
        label723:
        paramString = (String)localObject2;
      }
    }
    if (((TroopFileTransferRetryController.RetryContent)localObject1).a < this.k)
    {
      a((TroopFileTransferRetryController.RetryContent)localObject1, paramInt, paramBoolean);
      paramInt = TroopFileTransferUtil.Log.b;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[");
      ((StringBuilder)localObject2).append(this.a);
      ((StringBuilder)localObject2).append("] selectUrl:");
      ((StringBuilder)localObject2).append(paramString);
      ((StringBuilder)localObject2).append(((TroopFileTransferRetryController.RetryContent)localObject1).toString());
      TroopFileTransferUtil.Log.c("TroopFileTransferRetryController", paramInt, ((StringBuilder)localObject2).toString());
      return paramString;
    }
    this.g = true;
    paramInt = TroopFileTransferUtil.Log.b;
    paramString = new StringBuilder();
    paramString.append("[");
    paramString.append(this.a);
    paramString.append("] all retry over and fail");
    TroopFileTransferUtil.Log.a("TroopFileTransferRetryController", paramInt, paramString.toString());
    return null;
  }
  
  public void b()
  {
    this.k = 3;
    this.l = 3;
    this.m = 0;
    this.n = 5;
  }
  
  public int c()
  {
    return this.c;
  }
  
  public boolean d()
  {
    return this.g;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.TroopFileTransferRetryController
 * JD-Core Version:    0.7.0.1
 */