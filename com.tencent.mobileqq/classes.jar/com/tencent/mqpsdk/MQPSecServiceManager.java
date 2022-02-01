package com.tencent.mqpsdk;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mqpsdk.secsrv.MQPAPPScanService;
import com.tencent.mqpsdk.secsrv.MQPIntChkService;
import com.tencent.mqpsdk.secsrv.MQPSigCheckService;
import java.util.LinkedHashMap;
import java.util.Map;

public class MQPSecServiceManager
{
  public Context a;
  public INetTransportProvider a;
  private Map<String, Object> a;
  
  public MQPSecServiceManager(Context paramContext, INetTransportProvider paramINetTransportProvider)
  {
    this.jdField_a_of_type_AndroidContentContext = null;
    this.jdField_a_of_type_ComTencentMqpsdkINetTransportProvider = null;
    this.jdField_a_of_type_JavaUtilMap = null;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMqpsdkINetTransportProvider = paramINetTransportProvider;
  }
  
  public Object a(String paramString)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    if (TextUtils.isEmpty(paramString)) {
      return localObject2;
    }
    if (this.jdField_a_of_type_JavaUtilMap == null) {
      this.jdField_a_of_type_JavaUtilMap = new LinkedHashMap();
    }
    if (this.jdField_a_of_type_JavaUtilMap.containsKey(paramString)) {
      return this.jdField_a_of_type_JavaUtilMap.get(paramString);
    }
    if (TextUtils.equals(paramString, "intchk")) {
      localObject1 = new MQPIntChkService(this);
    }
    for (;;)
    {
      localObject2 = localObject1;
      if (localObject1 == null) {
        break;
      }
      this.jdField_a_of_type_JavaUtilMap.put(paramString, localObject1);
      return localObject1;
      if (TextUtils.equals(paramString, "app_scan")) {
        localObject1 = new MQPAPPScanService(this);
      } else if (TextUtils.equals(paramString, "sig_check")) {
        localObject1 = new MQPSigCheckService(this);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mqpsdk.MQPSecServiceManager
 * JD-Core Version:    0.7.0.1
 */