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
  protected int a;
  protected long a;
  protected final HttpUrlProcessor a;
  protected final TroopFileTransferRetryController.ITroopFileTransferRetrySink a;
  protected Map<String, TroopFileTransferRetryController.RetryContent> a;
  protected boolean a;
  protected int b;
  protected boolean b;
  protected int c = 0;
  protected int d = 0;
  protected int e = 3;
  protected int f = 3;
  protected int g = 3;
  protected int h = 30;
  
  public TroopFileTransferRetryController(QQAppInterface paramQQAppInterface, List<String> paramList, String paramString, long paramLong, boolean paramBoolean, TroopFileTransferRetryController.ITroopFileTransferRetrySink paramITroopFileTransferRetrySink)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreHttpUrlProcessor = new HttpUrlProcessor(paramQQAppInterface, paramList, paramString);
    if (paramBoolean) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreHttpUrlProcessor.a(true);
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileTransferRetryController$ITroopFileTransferRetrySink = paramITroopFileTransferRetrySink;
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public String a()
  {
    int i = 1;
    Object localObject1 = null;
    int j = 0;
    Object localObject2;
    int k;
    do
    {
      String str = this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreHttpUrlProcessor.a();
      if (!TextUtils.isEmpty(str))
      {
        this.jdField_a_of_type_JavaUtilMap.put(str, new TroopFileTransferRetryController.RetryContent(this));
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = str;
        }
        k = j + 1;
        j = TroopFileTransferUtil.Log.jdField_a_of_type_Int;
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("[");
        ((StringBuilder)localObject1).append(this.jdField_a_of_type_Long);
        ((StringBuilder)localObject1).append("] retryContrller init:");
        ((StringBuilder)localObject1).append(str);
        TroopFileTransferUtil.Log.c("TroopFileTransferRetryController", j, ((StringBuilder)localObject1).toString());
      }
      else
      {
        i = 0;
        k = j;
        localObject2 = localObject1;
      }
      if (i == 0) {
        break;
      }
      localObject1 = localObject2;
      j = k;
    } while (k < 4);
    return localObject2;
  }
  
  protected String a(String paramString, int paramInt, boolean paramBoolean)
  {
    try
    {
      TroopFileTransferRetryController.RetryContent localRetryContent = (TroopFileTransferRetryController.RetryContent)this.jdField_a_of_type_JavaUtilMap.get(paramString);
      if (localRetryContent == null)
      {
        paramInt = TroopFileTransferUtil.Log.jdField_a_of_type_Int;
        paramString = new StringBuilder();
        paramString.append("[");
        paramString.append(this.jdField_a_of_type_Long);
        paramString.append("] selectUrl err. not find strErrUrl. urlCont:");
        paramString.append(this.jdField_a_of_type_JavaUtilMap.size());
        TroopFileTransferUtil.Log.a("TroopFileTransferRetryController", paramInt, paramString.toString());
        return null;
      }
      if (((9056 == paramInt) || (paramBoolean)) && (localRetryContent.jdField_a_of_type_Int < this.e))
      {
        a(localRetryContent, paramInt, paramBoolean);
        paramInt = TroopFileTransferUtil.Log.jdField_a_of_type_Int;
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("[");
        ((StringBuilder)localObject1).append(this.jdField_a_of_type_Long);
        ((StringBuilder)localObject1).append("] selectUrl:");
        ((StringBuilder)localObject1).append(paramString);
        ((StringBuilder)localObject1).append(localRetryContent.toString());
        ((StringBuilder)localObject1).append(" eof err or serr, use cur errurl");
        TroopFileTransferUtil.Log.c("TroopFileTransferRetryController", paramInt, ((StringBuilder)localObject1).toString());
        return paramString;
      }
      localObject1 = new TroopFileTransferRetryController.RetryContent(this);
      ((TroopFileTransferRetryController.RetryContent)localObject1).jdField_a_of_type_Int = 2147483647;
      ((TroopFileTransferRetryController.RetryContent)localObject1).jdField_b_of_type_Int = 2147483647;
      ((TroopFileTransferRetryController.RetryContent)localObject1).c = 2147483647;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
      label246:
      Object localObject3;
      int i;
      for (localObject2 = null; localIterator.hasNext(); localObject2 = localObject3)
      {
        Object localObject4 = (Map.Entry)localIterator.next();
        localObject3 = (String)((Map.Entry)localObject4).getKey();
        localObject4 = (TroopFileTransferRetryController.RetryContent)((Map.Entry)localObject4).getValue();
        i = TroopFileTransferUtil.Log.jdField_a_of_type_Int;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[");
        localStringBuilder.append(this.jdField_a_of_type_Long);
        localStringBuilder.append("]");
        localStringBuilder.append((String)localObject3);
        localStringBuilder.append(" <->");
        localStringBuilder.append(((TroopFileTransferRetryController.RetryContent)localObject4).toString());
        TroopFileTransferUtil.Log.c("TroopFileTransferRetryController", i, localStringBuilder.toString());
        if ((paramString.equalsIgnoreCase((String)localObject3)) || (((TroopFileTransferRetryController.RetryContent)localObject4).jdField_a_of_type_Int >= ((TroopFileTransferRetryController.RetryContent)localObject1).jdField_a_of_type_Int)) {
          break label246;
        }
        localObject1 = localObject4;
      }
      if (localObject2 != null) {
        if (((TroopFileTransferRetryController.RetryContent)localObject1).jdField_a_of_type_Int < this.e) {
          break label723;
        }
      }
      if (localObject2 == null)
      {
        i = TroopFileTransferUtil.Log.jdField_a_of_type_Int;
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("[");
        ((StringBuilder)localObject1).append(this.jdField_a_of_type_Long);
        ((StringBuilder)localObject1).append("] no next url use cur errurl");
        TroopFileTransferUtil.Log.b("TroopFileTransferRetryController", i, ((StringBuilder)localObject1).toString());
        localObject1 = localRetryContent;
      }
      else
      {
        i = TroopFileTransferUtil.Log.jdField_a_of_type_Int;
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("[");
        ((StringBuilder)localObject3).append(this.jdField_a_of_type_Long);
        ((StringBuilder)localObject3).append("] minurl retry over, use cur errurl. minRetryUrl:");
        ((StringBuilder)localObject3).append((String)localObject2);
        ((StringBuilder)localObject3).append(((TroopFileTransferRetryController.RetryContent)localObject1).toString());
        TroopFileTransferUtil.Log.b("TroopFileTransferRetryController", i, ((StringBuilder)localObject3).toString());
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
    if (((TroopFileTransferRetryController.RetryContent)localObject1).jdField_a_of_type_Int < this.e)
    {
      a((TroopFileTransferRetryController.RetryContent)localObject1, paramInt, paramBoolean);
      paramInt = TroopFileTransferUtil.Log.jdField_a_of_type_Int;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[");
      ((StringBuilder)localObject2).append(this.jdField_a_of_type_Long);
      ((StringBuilder)localObject2).append("] selectUrl:");
      ((StringBuilder)localObject2).append(paramString);
      ((StringBuilder)localObject2).append(((TroopFileTransferRetryController.RetryContent)localObject1).toString());
      TroopFileTransferUtil.Log.c("TroopFileTransferRetryController", paramInt, ((StringBuilder)localObject2).toString());
      return paramString;
    }
    this.jdField_a_of_type_Boolean = true;
    paramInt = TroopFileTransferUtil.Log.jdField_a_of_type_Int;
    paramString = new StringBuilder();
    paramString.append("[");
    paramString.append(this.jdField_a_of_type_Long);
    paramString.append("] all retry over and fail");
    TroopFileTransferUtil.Log.a("TroopFileTransferRetryController", paramInt, paramString.toString());
    return null;
  }
  
  public void a()
  {
    this.e = 3;
    this.f = 3;
    this.g = 0;
    this.h = 5;
  }
  
  protected void a(TroopFileTransferRetryController.RetryContent paramRetryContent, int paramInt, boolean paramBoolean)
  {
    if (9056 == paramInt)
    {
      if (paramRetryContent.jdField_b_of_type_Int < this.f)
      {
        paramRetryContent.jdField_b_of_type_Int += 1;
        return;
      }
      paramRetryContent.jdField_b_of_type_Int = 0;
      paramRetryContent.jdField_a_of_type_Int += 1;
      this.jdField_b_of_type_Int += 1;
      return;
    }
    if (paramBoolean)
    {
      if (paramRetryContent.c < this.g)
      {
        paramRetryContent.c += 1;
        return;
      }
      paramRetryContent.c = 0;
      paramRetryContent.jdField_a_of_type_Int += 1;
      this.jdField_b_of_type_Int += 1;
      return;
    }
    paramRetryContent.jdField_a_of_type_Int += 1;
    this.jdField_b_of_type_Int += 1;
  }
  
  public void a(String paramString)
  {
    try
    {
      Object localObject = (TroopFileTransferRetryController.RetryContent)this.jdField_a_of_type_JavaUtilMap.get(paramString);
      if (localObject == null) {
        return;
      }
      if (!this.jdField_b_of_type_Boolean)
      {
        this.jdField_b_of_type_Boolean = true;
        ((TroopFileTransferRetryController.RetryContent)localObject).a();
        this.jdField_a_of_type_JavaUtilMap.clear();
        this.jdField_a_of_type_JavaUtilMap.put(paramString, localObject);
        i = TroopFileTransferUtil.Log.jdField_a_of_type_Int;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_Long);
        ((StringBuilder)localObject).append("] data conned. lockedUseThisUrl:");
        ((StringBuilder)localObject).append(paramString);
        TroopFileTransferUtil.Log.c("TroopFileTransferRetryController", i, ((StringBuilder)localObject).toString());
        return;
      }
      int i = this.d;
      int j = this.h;
      if (i > j) {
        return;
      }
      ((TroopFileTransferRetryController.RetryContent)localObject).a();
      this.d += 1;
      i = TroopFileTransferUtil.Log.jdField_a_of_type_Int;
      paramString = new StringBuilder();
      paramString.append("[");
      paramString.append(this.jdField_a_of_type_Long);
      paramString.append("] data conned. resetRetryInfo. resetcount:");
      paramString.append(this.d);
      TroopFileTransferUtil.Log.c("TroopFileTransferRetryController", i, paramString.toString());
      return;
    }
    finally {}
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean a(String paramString, int paramInt, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileTransferRetryController$ITroopFileTransferRetrySink == null)
    {
      paramInt = TroopFileTransferUtil.Log.jdField_a_of_type_Int;
      paramString = new StringBuilder();
      paramString.append("[");
      paramString.append(this.jdField_a_of_type_Long);
      paramString.append("] reqRetryOnErr fail. sink=null");
      TroopFileTransferUtil.Log.a("TroopFileTransferRetryController", paramInt, paramString.toString());
      return false;
    }
    if (TextUtils.isEmpty(paramString))
    {
      paramInt = TroopFileTransferUtil.Log.jdField_a_of_type_Int;
      paramString = new StringBuilder();
      paramString.append("[");
      paramString.append(this.jdField_a_of_type_Long);
      paramString.append("] reqRetryOnErr fail. strErrUrl=null");
      TroopFileTransferUtil.Log.a("TroopFileTransferRetryController", paramInt, paramString.toString());
      return false;
    }
    Object localObject = a(paramString, paramInt, paramBoolean);
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      i = TroopFileTransferUtil.Log.jdField_a_of_type_Int;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Long);
      ((StringBuilder)localObject).append("] reqRetryOnErr fail. all retry over or has err. errCode:");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(" bSvrErr:");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append(" ReportR:");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
      ((StringBuilder)localObject).append("UrlChgedT:");
      ((StringBuilder)localObject).append(this.c);
      ((StringBuilder)localObject).append(" strErrUrl:");
      ((StringBuilder)localObject).append(paramString);
      TroopFileTransferUtil.Log.a("TroopFileTransferRetryController", i, ((StringBuilder)localObject).toString());
      return false;
    }
    long l = 100L;
    if (9056 != paramInt) {
      l = this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileTransferRetryController$ITroopFileTransferRetrySink.a();
    }
    ThreadManager.getSubThreadHandler().postDelayed(new TroopFileTransferRetryController.1(this, (String)localObject), l);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Int += 1;
    if (!paramString.equalsIgnoreCase((String)localObject)) {
      this.c += 1;
    }
    int i = TroopFileTransferUtil.Log.jdField_a_of_type_Int;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append("] reqRetryOnErr suc, delay:");
    localStringBuilder.append(l);
    localStringBuilder.append(" errCode:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" bSvrErr:");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(" strErrUrl:");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" selectUrl:");
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(" ReportR:");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append("UrlChgedT:");
    localStringBuilder.append(this.c);
    TroopFileTransferUtil.Log.c("TroopFileTransferRetryController", i, localStringBuilder.toString());
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.TroopFileTransferRetryController
 * JD-Core Version:    0.7.0.1
 */