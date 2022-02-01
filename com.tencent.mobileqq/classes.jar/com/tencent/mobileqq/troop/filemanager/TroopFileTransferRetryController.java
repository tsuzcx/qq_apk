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
    int i = 0;
    int j = 1;
    Object localObject1 = null;
    for (;;)
    {
      String str = this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreHttpUrlProcessor.a();
      if (!TextUtils.isEmpty(str))
      {
        this.jdField_a_of_type_JavaUtilMap.put(str, new TroopFileTransferRetryController.RetryContent(this));
        Object localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = str;
        }
        TroopFileTransferUtil.Log.c("TroopFileTransferRetryController", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_Long + "] retryContrller init:" + str);
        localObject1 = localObject2;
        i += 1;
      }
      while ((j == 0) || (i >= 4))
      {
        return localObject1;
        j = 0;
      }
    }
  }
  
  protected String a(String paramString, int paramInt, boolean paramBoolean)
  {
    TroopFileTransferRetryController.RetryContent localRetryContent;
    try
    {
      localRetryContent = (TroopFileTransferRetryController.RetryContent)this.jdField_a_of_type_JavaUtilMap.get(paramString);
      if (localRetryContent == null)
      {
        TroopFileTransferUtil.Log.a("TroopFileTransferRetryController", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_Long + "] selectUrl err. not find strErrUrl. urlCont:" + this.jdField_a_of_type_JavaUtilMap.size());
        paramString = null;
      }
      for (;;)
      {
        return paramString;
        if (((9056 != paramInt) && (!paramBoolean)) || (localRetryContent.jdField_a_of_type_Int >= this.e)) {
          break;
        }
        a(localRetryContent, paramInt, paramBoolean);
        TroopFileTransferUtil.Log.c("TroopFileTransferRetryController", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_Long + "] selectUrl:" + paramString + localRetryContent.toString() + " eof err or serr, use cur errurl");
      }
      localObject1 = new TroopFileTransferRetryController.RetryContent(this);
    }
    finally {}
    Object localObject1;
    ((TroopFileTransferRetryController.RetryContent)localObject1).jdField_a_of_type_Int = 2147483647;
    ((TroopFileTransferRetryController.RetryContent)localObject1).jdField_b_of_type_Int = 2147483647;
    ((TroopFileTransferRetryController.RetryContent)localObject1).c = 2147483647;
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
    Object localObject2 = null;
    label216:
    Object localObject3;
    while (localIterator.hasNext())
    {
      Object localObject4 = (Map.Entry)localIterator.next();
      localObject3 = (String)((Map.Entry)localObject4).getKey();
      localObject4 = (TroopFileTransferRetryController.RetryContent)((Map.Entry)localObject4).getValue();
      TroopFileTransferUtil.Log.c("TroopFileTransferRetryController", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_Long + "]" + (String)localObject3 + " <->" + ((TroopFileTransferRetryController.RetryContent)localObject4).toString());
      if (!paramString.equalsIgnoreCase((String)localObject3))
      {
        if (((TroopFileTransferRetryController.RetryContent)localObject4).jdField_a_of_type_Int >= ((TroopFileTransferRetryController.RetryContent)localObject1).jdField_a_of_type_Int) {
          break label580;
        }
        localObject2 = localObject4;
        localObject1 = localObject3;
        break label592;
      }
    }
    if ((localObject2 == null) || (((TroopFileTransferRetryController.RetryContent)localObject1).jdField_a_of_type_Int >= this.e)) {
      if (localObject2 == null)
      {
        TroopFileTransferUtil.Log.b("TroopFileTransferRetryController", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_Long + "] no next url use cur errurl");
        break label607;
      }
    }
    for (;;)
    {
      if (((TroopFileTransferRetryController.RetryContent)localObject1).jdField_a_of_type_Int < this.e)
      {
        a((TroopFileTransferRetryController.RetryContent)localObject1, paramInt, paramBoolean);
        TroopFileTransferUtil.Log.c("TroopFileTransferRetryController", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_Long + "] selectUrl:" + paramString + ((TroopFileTransferRetryController.RetryContent)localObject1).toString());
        break;
        TroopFileTransferUtil.Log.b("TroopFileTransferRetryController", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_Long + "] minurl retry over, use cur errurl. minRetryUrl:" + localObject2 + ((TroopFileTransferRetryController.RetryContent)localObject1).toString());
        break label607;
      }
      this.jdField_a_of_type_Boolean = true;
      TroopFileTransferUtil.Log.a("TroopFileTransferRetryController", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_Long + "] all retry over and fail");
      paramString = null;
      break;
      paramString = localObject2;
      continue;
      label580:
      localObject3 = localObject1;
      localObject1 = localObject2;
      localObject2 = localObject3;
      label592:
      localObject3 = localObject1;
      localObject1 = localObject2;
      localObject2 = localObject3;
      break label216;
      label607:
      localObject1 = localRetryContent;
    }
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
    for (;;)
    {
      TroopFileTransferRetryController.RetryContent localRetryContent;
      try
      {
        localRetryContent = (TroopFileTransferRetryController.RetryContent)this.jdField_a_of_type_JavaUtilMap.get(paramString);
        if (localRetryContent == null) {
          return;
        }
        if (!this.jdField_b_of_type_Boolean)
        {
          this.jdField_b_of_type_Boolean = true;
          localRetryContent.a();
          this.jdField_a_of_type_JavaUtilMap.clear();
          this.jdField_a_of_type_JavaUtilMap.put(paramString, localRetryContent);
          TroopFileTransferUtil.Log.c("TroopFileTransferRetryController", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_Long + "] data conned. lockedUseThisUrl:" + paramString);
          continue;
        }
        if (this.d > this.h) {
          continue;
        }
      }
      finally {}
      localRetryContent.a();
      this.d += 1;
      TroopFileTransferUtil.Log.c("TroopFileTransferRetryController", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_Long + "] data conned. resetRetryInfo. resetcount:" + this.d);
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean a(String paramString, int paramInt, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileTransferRetryController$ITroopFileTransferRetrySink == null)
    {
      TroopFileTransferUtil.Log.a("TroopFileTransferRetryController", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_Long + "] reqRetryOnErr fail. sink=null");
      return false;
    }
    if (TextUtils.isEmpty(paramString))
    {
      TroopFileTransferUtil.Log.a("TroopFileTransferRetryController", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_Long + "] reqRetryOnErr fail. strErrUrl=null");
      return false;
    }
    String str = a(paramString, paramInt, paramBoolean);
    if (TextUtils.isEmpty(str))
    {
      TroopFileTransferUtil.Log.a("TroopFileTransferRetryController", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_Long + "] reqRetryOnErr fail. all retry over or has err. errCode:" + paramInt + " bSvrErr:" + paramBoolean + " ReportR:" + this.jdField_a_of_type_Int + "UrlChgedT:" + this.c + " strErrUrl:" + paramString);
      return false;
    }
    long l = 100L;
    if (9056 != paramInt) {
      l = this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileTransferRetryController$ITroopFileTransferRetrySink.b();
    }
    ThreadManager.getSubThreadHandler().postDelayed(new TroopFileTransferRetryController.1(this, str), l);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Int += 1;
    if (!paramString.equalsIgnoreCase(str)) {
      this.c += 1;
    }
    TroopFileTransferUtil.Log.c("TroopFileTransferRetryController", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_Long + "] reqRetryOnErr suc, delay:" + l + " errCode:" + paramInt + " bSvrErr:" + paramBoolean + " strErrUrl:" + paramString + " selectUrl:" + str + " ReportR:" + this.jdField_a_of_type_Int + "UrlChgedT:" + this.c);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.TroopFileTransferRetryController
 * JD-Core Version:    0.7.0.1
 */