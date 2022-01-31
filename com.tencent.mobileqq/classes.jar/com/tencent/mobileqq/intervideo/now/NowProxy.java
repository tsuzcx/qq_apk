package com.tencent.mobileqq.intervideo.now;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.intervideo.IVPluginEvtListener;
import mqq.manager.Manager;

public class NowProxy
  implements Manager
{
  private QQAppInterface a;
  public NowPlugin a;
  
  public NowProxy()
  {
    this.jdField_a_of_type_ComTencentMobileqqIntervideoNowNowPlugin = new NowPlugin();
  }
  
  public NowProxy(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqIntervideoNowNowPlugin = new NowPlugin(paramQQAppInterface);
  }
  
  public static int a(String paramString)
  {
    int i = 2;
    if ((paramString.equals("1")) || (paramString.equals("2"))) {
      i = 1;
    }
    return i;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqIntervideoNowNowPlugin.f();
  }
  
  public void a(Bundle paramBundle)
  {
    this.jdField_a_of_type_ComTencentMobileqqIntervideoNowNowPlugin.a(paramBundle);
  }
  
  public void a(IVPluginEvtListener paramIVPluginEvtListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqIntervideoNowNowPlugin.a(paramIVPluginEvtListener);
  }
  
  public void a(NowProxy.ListNameData paramListNameData, long paramLong, Bundle paramBundle)
  {
    this.jdField_a_of_type_ComTencentMobileqqIntervideoNowNowPlugin.a(paramListNameData, paramLong, paramBundle);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqIntervideoNowNowPlugin.a();
  }
  
  public boolean a(Context paramContext)
  {
    return this.jdField_a_of_type_ComTencentMobileqqIntervideoNowNowPlugin.a(paramContext);
  }
  
  public boolean a(Bundle paramBundle)
  {
    return this.jdField_a_of_type_ComTencentMobileqqIntervideoNowNowPlugin.a(paramBundle);
  }
  
  public boolean a(NowProxy.ListNameData paramListNameData, long paramLong, NowFromData paramNowFromData, int paramInt, Bundle paramBundle)
  {
    return this.jdField_a_of_type_ComTencentMobileqqIntervideoNowNowPlugin.a(paramListNameData, paramLong, paramNowFromData, paramInt, paramBundle);
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqIntervideoNowNowPlugin.d();
  }
  
  public void b(IVPluginEvtListener paramIVPluginEvtListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqIntervideoNowNowPlugin.b(paramIVPluginEvtListener);
  }
  
  public boolean b(Context paramContext)
  {
    return this.jdField_a_of_type_ComTencentMobileqqIntervideoNowNowPlugin.b(paramContext);
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqIntervideoNowNowPlugin.e();
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_ComTencentMobileqqIntervideoNowNowPlugin.a();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.now.NowProxy
 * JD-Core Version:    0.7.0.1
 */