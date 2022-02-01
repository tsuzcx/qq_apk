package com.tencent.nativevue;

import android.util.Log;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

public class NativeVueEngine
  implements NativeVuePreconditionAdapter.LoadSoResult
{
  public static final int DEFAULT_CONVERTER_TYPE = 0;
  public static final int HIPPY_CONVERTER_TYPE = 1;
  private static volatile NativeVueEngine INSTANCE;
  private static final String TAG = "NativeVueEngine";
  private NativeVueEngine.Builder builder;
  private List<NativeVueEngine.VDomHolder> lazyDomList = new CopyOnWriteArrayList();
  private volatile boolean loadSoSuccess;
  private volatile boolean loadingSo;
  
  private native String createDom(String paramString1, String paramString2);
  
  private native String createDom(String paramString1, String paramString2, int paramInt);
  
  public static NativeVueEngine getInstance()
  {
    if (INSTANCE == null) {
      try
      {
        if (INSTANCE == null) {
          INSTANCE = new NativeVueEngine();
        }
      }
      finally {}
    }
    return INSTANCE;
  }
  
  private native boolean initNaive(String paramString1, String paramString2);
  
  private void internalCreateDom(String paramString1, String paramString2, int paramInt, NativeVueEngine.DomResult paramDomResult)
  {
    try
    {
      paramDomResult.onResult(createDom(paramString1, paramString2, paramInt));
      return;
    }
    catch (Throwable paramString1)
    {
      paramDomResult.onResult("");
      paramString2 = new StringBuilder();
      paramString2.append("[internalCreateDom]: ");
      paramString2.append(paramString1.getMessage());
      onLogError(paramString2.toString());
    }
  }
  
  private void internalInit()
  {
    try
    {
      Iterator localIterator = this.builder.envMap.entrySet().iterator();
      Object localObject;
      while (localIterator.hasNext())
      {
        localObject = (Map.Entry)localIterator.next();
        initNaive((String)((Map.Entry)localObject).getKey(), (String)((Map.Entry)localObject).getValue());
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("initNativeVueError: ");
      ((StringBuilder)localObject).append(localThrowable.getMessage());
      onLogError(((StringBuilder)localObject).toString());
    }
  }
  
  private static void logD(String paramString)
  {
    NativeVueLogAdapter localNativeVueLogAdapter = getInstance().builder.logAdapter;
    if (localNativeVueLogAdapter != null)
    {
      localNativeVueLogAdapter.logD(paramString);
      return;
    }
    Log.d("NativeVueEngine", paramString);
  }
  
  private static void logE(String paramString)
  {
    NativeVueLogAdapter localNativeVueLogAdapter = getInstance().builder.logAdapter;
    if (localNativeVueLogAdapter != null)
    {
      localNativeVueLogAdapter.logE(paramString);
      localNativeVueLogAdapter.onNativeVueError(paramString);
      return;
    }
    Log.e("NativeVueEngine", paramString);
  }
  
  private void onLogError(String paramString)
  {
    NativeVueLogAdapter localNativeVueLogAdapter = getInstance().builder.logAdapter;
    if (localNativeVueLogAdapter != null) {
      localNativeVueLogAdapter.logE(paramString);
    }
  }
  
  private void tryRunLazyDomTask()
  {
    Iterator localIterator = this.lazyDomList.iterator();
    while (localIterator.hasNext())
    {
      NativeVueEngine.VDomHolder localVDomHolder = (NativeVueEngine.VDomHolder)localIterator.next();
      NativeVueEngine.DomResult localDomResult = (NativeVueEngine.DomResult)localVDomHolder.domResultRef.get();
      if (localDomResult != null)
      {
        internalCreateDom(localVDomHolder.data, localVDomHolder.vueDom, localVDomHolder.converterType, localDomResult);
        onLogError("[tryRunLazyDomTask]: ");
      }
    }
    this.lazyDomList.clear();
  }
  
  public void createVDom(String paramString1, String paramString2, int paramInt, NativeVueEngine.DomResult paramDomResult)
  {
    if (this.loadingSo)
    {
      this.lazyDomList.add(new NativeVueEngine.VDomHolder(paramString1, paramString2, paramInt, paramDomResult));
      onLogError("loading native vue so");
      return;
    }
    if (this.loadSoSuccess)
    {
      internalCreateDom(paramString1, paramString2, paramInt, paramDomResult);
      return;
    }
    paramDomResult.onResult("");
    onLogError("init native vue error");
  }
  
  public void createVDom(String paramString1, String paramString2, NativeVueEngine.DomResult paramDomResult)
  {
    createVDom(paramString1, paramString2, 0, paramDomResult);
  }
  
  public void init(NativeVueEngine.Builder paramBuilder)
  {
    this.builder = paramBuilder;
    this.loadingSo = true;
    paramBuilder.preconditionAdapter.loadNativeVueSo(this);
  }
  
  public void onLoadError()
  {
    this.loadSoSuccess = false;
    this.loadingSo = false;
    onLogError("loadNativeVueSo error");
  }
  
  public void onLoadSuccess()
  {
    this.loadSoSuccess = true;
    this.loadingSo = false;
    internalInit();
    tryRunLazyDomTask();
    logD("onNativeVueSoLoadSuccess");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.nativevue.NativeVueEngine
 * JD-Core Version:    0.7.0.1
 */