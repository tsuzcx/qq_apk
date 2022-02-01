package com.tencent.raft.raftframework;

import android.content.Context;
import com.tencent.raft.raftframework.declare.IRADeclareManager;
import com.tencent.raft.raftframework.declare.RADeclareManager;
import com.tencent.raft.raftframework.log.ILogDelegate;
import com.tencent.raft.raftframework.log.RLog;
import com.tencent.raft.raftframework.service.IRAServiceManager;
import com.tencent.raft.raftframework.service.RAServiceManager;
import com.tencent.raft.raftframework.sla.SLAReporter;

public class RAApplicationContext
{
  public static final String INIT_CLASS = "com.tencent.raft.generate.RaftServiceEntryMap";
  public static final String TAG = "RAApplicationContext";
  private static RAApplicationContext sInstance;
  private Context mContext;
  private IRADeclareManager mDeclareManager;
  private boolean mHasStartUp = false;
  private SLAReporter mSLAReporter;
  private IRAServiceManager mServiceManager;
  
  public static RAApplicationContext getGlobalContext()
  {
    if (sInstance == null) {
      sInstance = new RAApplicationContext();
    }
    return sInstance;
  }
  
  public static RAApplicationContext newInstance()
  {
    return new RAApplicationContext();
  }
  
  public static void setLogDelegate(ILogDelegate paramILogDelegate)
  {
    RLog.setLogDelegate(paramILogDelegate);
  }
  
  public Context getContext()
  {
    return this.mContext;
  }
  
  public String getDeclareConstant(String paramString)
  {
    try
    {
      paramString = this.mDeclareManager.getDeclareConstant(paramString);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public Object getDeclareService(String paramString)
  {
    for (;;)
    {
      try
      {
        long l = System.nanoTime();
        paramString = this.mDeclareManager.getDeclareService(paramString);
        SLAReporter localSLAReporter = this.mSLAReporter;
        if (paramString != null)
        {
          bool = true;
          localSLAReporter.reportGetServiceFinish(l, bool);
          return paramString;
        }
      }
      finally {}
      boolean bool = false;
    }
  }
  
  public <T> T getService(Class<T> paramClass)
  {
    try
    {
      paramClass = getService(paramClass, null);
      return paramClass;
    }
    finally
    {
      paramClass = finally;
      throw paramClass;
    }
  }
  
  public <T> T getService(Class<T> paramClass, IServiceProvider paramIServiceProvider)
  {
    for (;;)
    {
      try
      {
        long l = System.nanoTime();
        paramClass = this.mServiceManager.getService(paramClass, paramIServiceProvider);
        paramIServiceProvider = this.mSLAReporter;
        if (paramClass != null)
        {
          bool = true;
          paramIServiceProvider.reportGetServiceFinish(l, bool);
          return paramClass;
        }
      }
      finally {}
      boolean bool = false;
    }
  }
  
  public boolean hasStartUp()
  {
    return this.mHasStartUp;
  }
  
  public void shutdown()
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("shutdown [");
      localStringBuilder.append(hashCode());
      localStringBuilder.append("]");
      RLog.d("RAApplicationContext", new Object[] { localStringBuilder.toString() });
      this.mHasStartUp = false;
      this.mServiceManager.destroy();
      this.mServiceManager = null;
      this.mDeclareManager.destroy();
      this.mDeclareManager = null;
      if (this.mSLAReporter != null)
      {
        this.mSLAReporter.release();
        this.mSLAReporter = null;
      }
      this.mContext = null;
      return;
    }
    finally {}
  }
  
  public void startup(Context paramContext)
  {
    try
    {
      startup(paramContext, true);
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public void startup(Context paramContext, boolean paramBoolean)
  {
    try
    {
      if (this.mSLAReporter == null) {
        this.mSLAReporter = new SLAReporter(paramContext);
      }
      this.mSLAReporter.open(paramBoolean);
      this.mSLAReporter.reportOnFrameworkStartup();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("startup [");
      localStringBuilder.append(hashCode());
      localStringBuilder.append("], current RAFT version:");
      localStringBuilder.append("com.raft.uas/v1alpha2");
      RLog.d("RAApplicationContext", new Object[] { localStringBuilder.toString() });
      if (!this.mHasStartUp)
      {
        this.mContext = paramContext;
        this.mServiceManager = new RAServiceManager("com.tencent.raft.generate.RaftServiceEntryMap");
        this.mDeclareManager = new RADeclareManager("com.tencent.raft.generate.RaftServiceEntryMap");
        this.mHasStartUp = true;
        this.mSLAReporter.reportOnFrameworkStartupFinish();
        return;
      }
      RLog.e("RAApplicationContext", new Object[] { "cannot startup again" });
      throw new IllegalStateException("cannot startup again");
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.raft.raftframework.RAApplicationContext
 * JD-Core Version:    0.7.0.1
 */