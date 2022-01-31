package com.tencent.plato.mqq.module;

import alkb;
import android.os.AsyncTask;
import android.support.annotation.Nullable;
import com.squareup.okhttp.Call;
import com.squareup.okhttp.OkHttpClient;
import com.tencent.plato.ExportedModule;
import com.tencent.plato.core.utils.Ev;
import com.tencent.plato.network.PlatoCookieHandler;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

public final class NetworkingModule
  extends ExportedModule
{
  private final OkHttpClient jdField_a_of_type_ComSquareupOkhttpOkHttpClient = new OkHttpClient();
  private final PlatoCookieHandler jdField_a_of_type_ComTencentPlatoNetworkPlatoCookieHandler = new PlatoCookieHandler(Ev.appContext());
  @Nullable
  private final String jdField_a_of_type_JavaLangString;
  private final Map jdField_a_of_type_JavaUtilMap = new HashMap();
  private boolean jdField_a_of_type_Boolean;
  
  public NetworkingModule()
  {
    super("Networking");
    this.jdField_a_of_type_ComSquareupOkhttpOkHttpClient.setConnectTimeout(30000L, TimeUnit.MILLISECONDS);
    this.jdField_a_of_type_ComSquareupOkhttpOkHttpClient.setWriteTimeout(30000L, TimeUnit.MILLISECONDS);
    this.jdField_a_of_type_ComSquareupOkhttpOkHttpClient.setCookieHandler(this.jdField_a_of_type_ComTencentPlatoNetworkPlatoCookieHandler);
    this.jdField_a_of_type_JavaLangString = null;
  }
  
  private void a()
  {
    try
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
      while (localIterator.hasNext()) {
        a(localIterator.next());
      }
      this.jdField_a_of_type_JavaUtilMap.clear();
    }
    finally {}
  }
  
  private void a(Object paramObject)
  {
    paramObject = (Call)this.jdField_a_of_type_JavaUtilMap.get(paramObject);
    if ((paramObject != null) && (!paramObject.isCanceled())) {
      AsyncTask.THREAD_POOL_EXECUTOR.execute(new alkb(this, paramObject));
    }
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentPlatoNetworkPlatoCookieHandler.destroy();
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.plato.mqq.module.NetworkingModule
 * JD-Core Version:    0.7.0.1
 */