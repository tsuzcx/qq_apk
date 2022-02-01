package com.tencent.mqpsdk;

import android.content.Context;
import android.text.TextUtils;
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
    boolean bool = TextUtils.isEmpty(paramString);
    Object localObject = null;
    if (bool) {
      return null;
    }
    if (this.jdField_a_of_type_JavaUtilMap == null) {
      this.jdField_a_of_type_JavaUtilMap = new LinkedHashMap();
    }
    if (this.jdField_a_of_type_JavaUtilMap.containsKey(paramString)) {
      return this.jdField_a_of_type_JavaUtilMap.get(paramString);
    }
    if (TextUtils.equals(paramString, "intchk")) {
      localObject = new MQPIntChkService(this);
    } else if (TextUtils.equals(paramString, "sig_check")) {
      localObject = new MQPSigCheckService(this);
    }
    if (localObject != null) {
      this.jdField_a_of_type_JavaUtilMap.put(paramString, localObject);
    }
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mqpsdk.MQPSecServiceManager
 * JD-Core Version:    0.7.0.1
 */