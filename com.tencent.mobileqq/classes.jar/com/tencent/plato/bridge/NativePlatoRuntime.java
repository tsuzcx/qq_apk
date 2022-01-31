package com.tencent.plato.bridge;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.plato.IPlatoExceptionHandler;
import com.tencent.plato.core.IWritableArray;
import com.tencent.plato.core.IWritableMap;
import com.tencent.plato.core.utils.Ev;
import com.tencent.plato.core.utils.IReporter;
import com.tencent.plato.core.utils.Tracker;
import com.tencent.plato.impl.AbstractPlatoRuntime;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class NativePlatoRuntime
  extends AbstractPlatoRuntime
{
  private final String mBundlePath;
  private final Context mContext;
  private IPlatoExceptionHandler mExceptionHandler;
  private final HandlerThread mHandlerThread;
  private boolean mHasInit;
  private String mNativesBlobPath;
  private String mSnapshotBlobPath;
  private final Handler mThreadHandler;
  
  public NativePlatoRuntime(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    super(paramContext, paramString1);
    this.mContext = paramContext;
    this.mBundlePath = paramString1;
    this.mNativesBlobPath = paramString2;
    this.mSnapshotBlobPath = paramString3;
    this.mHandlerThread = new HandlerThread("plato-bridge");
    this.mHandlerThread.start();
    this.mThreadHandler = new Handler(this.mHandlerThread.getLooper());
    setNativePointer(jniInit());
  }
  
  private PlatoNativeArray coverToPlatoArray(Object[] paramArrayOfObject)
  {
    PlatoNativeArray localPlatoNativeArray = new PlatoNativeArray();
    if ((paramArrayOfObject == null) || (paramArrayOfObject.length == 0)) {
      return localPlatoNativeArray;
    }
    int j = paramArrayOfObject.length;
    int i = 0;
    label26:
    Object localObject;
    if (i < j)
    {
      localObject = paramArrayOfObject[i];
      if (!(localObject instanceof IWritableMap)) {
        break label67;
      }
      localPlatoNativeArray.put(((IWritableMap)localObject).toJSONObject());
    }
    for (;;)
    {
      i += 1;
      break label26;
      break;
      label67:
      if ((localObject instanceof IWritableArray)) {
        localPlatoNativeArray.put(((IWritableArray)localObject).toJSONArray());
      } else {
        localPlatoNativeArray.put(localObject);
      }
    }
  }
  
  private native void jniCallScriptFunction(String paramString1, String paramString2, PlatoNativeArray paramPlatoNativeArray);
  
  private native void jniDestroy();
  
  private native long jniInit();
  
  private native int jniInitFramework(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, PlatoNativeMap paramPlatoNativeMap);
  
  private native void jniInvokeCallback(int paramInt1, int paramInt2, int paramInt3, PlatoNativeArray paramPlatoNativeArray);
  
  private native void jniThrowException(String paramString);
  
  public void callFunction(final String paramString1, final String paramString2, final Object[] paramArrayOfObject)
  {
    paramArrayOfObject = coverToPlatoArray(paramArrayOfObject);
    if (this.mThreadHandler.getLooper() == Looper.myLooper())
    {
      jniCallScriptFunction(paramString1, paramString2, paramArrayOfObject);
      return;
    }
    this.mThreadHandler.post(new Runnable()
    {
      public void run()
      {
        NativePlatoRuntime.this.jniCallScriptFunction(paramString1, paramString2, paramArrayOfObject);
      }
    });
  }
  
  public void destroyInstance()
  {
    if (this.mThreadHandler.getLooper() == Looper.myLooper())
    {
      if (Build.VERSION.SDK_INT >= 18) {
        this.mHandlerThread.quitSafely();
      }
      for (;;)
      {
        jniDestroy();
        return;
        this.mHandlerThread.quit();
      }
    }
    this.mThreadHandler.post(new Runnable()
    {
      public void run()
      {
        if (Build.VERSION.SDK_INT >= 18) {
          NativePlatoRuntime.this.mHandlerThread.quitSafely();
        }
        for (;;)
        {
          NativePlatoRuntime.this.jniDestroy();
          return;
          NativePlatoRuntime.this.mHandlerThread.quit();
        }
      }
    });
  }
  
  public Handler getThreadHandler()
  {
    return this.mThreadHandler;
  }
  
  public void init()
  {
    this.mThreadHandler.post(new Runnable()
    {
      public void run()
      {
        if (NativePlatoRuntime.this.mHasInit) {
          return;
        }
        NativePlatoRuntime.access$002(NativePlatoRuntime.this, true);
        Object localObject = new PlatoNativeMap();
        ((PlatoNativeMap)localObject).put("path", new File(NativePlatoRuntime.this.mBundlePath).getParent());
        ((PlatoNativeMap)localObject).put("platform", "android");
        Tracker.trace("KeyTime", "====-----------------------------Init_FrameWork start");
        long l1 = System.currentTimeMillis();
        NativePlatoRuntime.this.jniInitFramework(NativePlatoRuntime.this.mContext, NativePlatoRuntime.this.mBundlePath, NativePlatoRuntime.this.mNativesBlobPath, NativePlatoRuntime.this.mSnapshotBlobPath, NativePlatoRuntime.this.getAllModuleDesc(), (PlatoNativeMap)localObject);
        if (Ev.getReporter() != null)
        {
          long l2 = System.currentTimeMillis();
          localObject = new HashMap();
          ((Map)localObject).put("timecost_init", Long.valueOf(l2 - l1));
          Ev.getReporter().report(new Object[] { Integer.valueOf(1), "initFramework", localObject });
        }
        Tracker.trace("KeyTime", "====-----------------------------Init_FrameWork End");
      }
    });
  }
  
  public void invokeCallback(final int paramInt1, final int paramInt2, final int paramInt3, final Object[] paramArrayOfObject)
  {
    paramArrayOfObject = coverToPlatoArray(paramArrayOfObject);
    if (this.mThreadHandler.getLooper() == Looper.myLooper())
    {
      jniInvokeCallback(paramInt1, paramInt2, paramInt3, paramArrayOfObject);
      return;
    }
    this.mThreadHandler.post(new Runnable()
    {
      public void run()
      {
        NativePlatoRuntime.this.jniInvokeCallback(paramInt1, paramInt2, paramInt3, paramArrayOfObject);
      }
    });
  }
  
  public void onPlatoException(String paramString)
  {
    if (this.mExceptionHandler != null) {
      this.mExceptionHandler.onPlatoException(paramString);
    }
  }
  
  public Object onScriptCall(int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte)
  {
    return dispatchScriptRequest(paramInt2, paramInt3, new PlatoReadableArray(this, paramInt1, new String(paramArrayOfByte)));
  }
  
  public void setExceptionHandler(IPlatoExceptionHandler paramIPlatoExceptionHandler)
  {
    this.mExceptionHandler = paramIPlatoExceptionHandler;
  }
  
  public void throwException(Throwable paramThrowable)
  {
    throw new IllegalStateException(paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.plato.bridge.NativePlatoRuntime
 * JD-Core Version:    0.7.0.1
 */