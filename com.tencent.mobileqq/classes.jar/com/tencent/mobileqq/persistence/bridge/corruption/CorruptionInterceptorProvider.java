package com.tencent.mobileqq.persistence.bridge.corruption;

import com.tencent.mobileqq.data.entitymanager.Interceptor;
import com.tencent.mobileqq.data.entitymanager.Provider;
import com.tencent.mobileqq.persistence.bridge.corruption.interceptor.DBExistCheckCorruptionInterceptor;
import com.tencent.mobileqq.persistence.bridge.corruption.interceptor.DBFixCorruptionInterceptor;
import com.tencent.mobileqq.persistence.bridge.corruption.interceptor.DBReportCorruptionInterceptor;
import java.util.ArrayList;
import java.util.List;

public class CorruptionInterceptorProvider
  implements Provider<List<Interceptor<Void>>>
{
  private List<Interceptor<Void>> a = new ArrayList();
  
  public CorruptionInterceptorProvider()
  {
    this.a.add(new DBExistCheckCorruptionInterceptor());
    this.a.add(new DBReportCorruptionInterceptor());
    this.a.add(new DBFixCorruptionInterceptor());
  }
  
  public List<Interceptor<Void>> a()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.persistence.bridge.corruption.CorruptionInterceptorProvider
 * JD-Core Version:    0.7.0.1
 */