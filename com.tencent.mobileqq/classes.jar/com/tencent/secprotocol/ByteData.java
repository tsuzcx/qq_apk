package com.tencent.secprotocol;

import a.a.a.b.a;
import a.a.a.b.d;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.secprotocol.t.ReportLogHelper;
import com.tencent.secprotocol.t.s;
import java.util.ArrayList;
import java.util.List;

public class ByteData
{
  public static final String BMP_ARRIVE_TIME = "bmp_arrive_time_stamp";
  public static final int MSG_DATA_BMP = 164;
  public static final int MSG_DATA_ORDER = 165;
  public static final int MSG_DATA_UPING = 163;
  public static final int MSG_DATA_WRITE_SP = 162;
  public static final int MSG_INTERNAL_DATA_UPING = 161;
  public static final String MY_VERSION = "0.4.2";
  public static final long REQUEST_TIME_BUFF = 43200L;
  public static final int RH_SCV = 1;
  public static final String SP_MARK_TIME = "mark_time_";
  public static final String TIME_STAMP_NAME = "byte_data_time_stamp";
  public static final String VAL_ARRIVE_TIME = "val_arrive_time";
  public static boolean isMsf = false;
  public static final boolean isPrint = false;
  public static Handler mDataHandler;
  public static String processName = "";
  public static String sSessionID = "";
  public a.a.a.b.b cData = null;
  public String filterName = "";
  public boolean filterStatus = false;
  public HandlerThread handlerThread = null;
  public a mBmpMgr = null;
  public Context mContext = null;
  public boolean mPoxyInit = false;
  public boolean mPoxyNativeLoaded = false;
  public final String mThradName = "ByteThread";
  public final String mUin = null;
  public final byte[] status = { 0, 0, 0, 0 };
  
  public ByteData()
  {
    try
    {
      this.handlerThread = new HandlerThread("ByteThread");
      this.handlerThread.start();
      mDataHandler = new ByteData.e(this, this.handlerThread.getLooper());
      return;
    }
    catch (Exception localException)
    {
      this.status[3] = 11;
      localException.printStackTrace();
    }
  }
  
  private boolean checkObject(long paramLong, Object paramObject)
  {
    boolean bool = false;
    if (paramLong == 0L) {
      return false;
    }
    if ((!(paramObject instanceof byte[])) || (paramObject == null) || (((byte[])paramObject).length <= 0)) {
      bool = true;
    }
    return bool;
  }
  
  private boolean checkProgressName()
  {
    if (!processName.isEmpty())
    {
      String[] arrayOfString = processName.split(":");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("temp[temp.length-1]: ");
      localStringBuilder.append(arrayOfString[(arrayOfString.length - 1)]);
      logCat("poxy_java", localStringBuilder.toString());
      if (arrayOfString[(arrayOfString.length - 1)].equalsIgnoreCase("msf"))
      {
        isMsf = true;
        return isMsf;
      }
    }
    return isMsf;
  }
  
  private boolean checkToa()
  {
    if (!isMsf)
    {
      Object localObject = this.mContext;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("bmp_arrive_time_stamp_");
      localStringBuilder.append(processName);
      localObject = ((Context)localObject).getSharedPreferences(localStringBuilder.toString(), 0);
      long l1 = System.currentTimeMillis();
      long l2 = l1 - ((SharedPreferences)localObject).getLong("val_arrive_time", 0L);
      if ((l2 > 43200L) && (l2 > 0L))
      {
        localObject = ((SharedPreferences)localObject).edit();
        ((SharedPreferences.Editor)localObject).putLong("val_arrive_time", l1);
        ((SharedPreferences.Editor)localObject).commit();
        return true;
      }
      return false;
    }
    return true;
  }
  
  private native byte[] getByte(Context paramContext, long paramLong1, long paramLong2, long paramLong3, long paramLong4, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4);
  
  private Context getContext()
  {
    return this.mContext;
  }
  
  public static ByteData getInstance()
  {
    return ByteData.d.a;
  }
  
  private void initLoadlibrary()
  {
    if (this.mPoxyInit) {
      return;
    }
    if (this.mPoxyNativeLoaded) {
      return;
    }
    if (a.a.a.a.b.b(this.mContext, "poxy"))
    {
      this.mPoxyNativeLoaded = true;
      this.mPoxyInit = true;
      return;
    }
    this.status[3] = 10;
  }
  
  public static void logCat(String paramString1, String paramString2) {}
  
  private native int putByte(Context paramContext, long paramLong1, long paramLong2, long paramLong3, long paramLong4, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4);
  
  private void putDwoning(int paramInt1, int paramInt2, int paramInt3, Object paramObject1, Object paramObject2)
  {
    if ((this.mPoxyNativeLoaded) && (this.mPoxyInit))
    {
      if (paramObject1 == null) {
        return;
      }
      long l1 = paramInt1;
      long l2 = paramInt2;
      long l3 = paramInt3;
      try
      {
        putByte(null, l1, l2, l3, 0L, paramObject1, this.cData.b, null, paramObject2);
        return;
      }
      catch (Exception paramObject1)
      {
        paramObject1.printStackTrace();
      }
    }
  }
  
  private void setContext(Context paramContext)
  {
    if ((paramContext instanceof Context)) {
      this.mContext = paramContext;
    }
  }
  
  private void writeSp(long paramLong)
  {
    try
    {
      if (this.mPoxyNativeLoaded)
      {
        if (!this.mPoxyInit) {
          return;
        }
        Object localObject = s.md5sum(this.cData.e);
        Context localContext = this.mContext;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("mark_time_");
        localStringBuilder.append(processName);
        localStringBuilder.append("_");
        localStringBuilder.append((String)localObject);
        localObject = localContext.getSharedPreferences(localStringBuilder.toString(), 4).edit();
        ((SharedPreferences.Editor)localObject).putLong("byte_data_time_stamp", paramLong);
        ((SharedPreferences.Editor)localObject).commit();
        sSessionID = String.valueOf(paramLong);
        this.cData.f = sSessionID;
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public byte[] getCode(long paramLong1, long paramLong2, long paramLong3, long paramLong4, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, Object paramObject5)
  {
    if (checkObject(paramLong1, paramObject4))
    {
      paramObject1 = this.status;
      paramObject1[3] = 12;
      return paramObject1;
    }
    if ((this.status[1] == 0) && (this.mPoxyNativeLoaded) && (this.mPoxyInit))
    {
      this.cData.e = ((String)paramObject3);
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(this.cData.b);
      localArrayList.add(String.valueOf(1));
      localArrayList.add(this.cData.e);
      localArrayList.add((String)paramObject5);
      localArrayList.add(this.cData.d);
      localArrayList.add(this.cData.f);
      localArrayList.add((String)paramObject1);
      localArrayList.add(this.cData.g);
      localArrayList.add(processName);
      ReportLogHelper.report(5, 0);
      return getByte(this.mContext, paramLong1, paramLong2, paramLong3, paramLong4, (String[])localArrayList.toArray(new String[localArrayList.size()]), paramObject2, paramObject3, paramObject4);
    }
    paramObject1 = this.status;
    if (paramObject1[3] == 0) {
      paramObject1[3] = 13;
    }
    return this.status;
  }
  
  public byte[] getSign(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    return getCode(1L, 0L, 0L, 0L, "", "", paramString1, paramArrayOfByte, paramString2);
  }
  
  public void init(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    if ((paramContext != getInstance().getContext()) && (!this.mPoxyInit) && (paramContext != null)) {
      try
      {
        processName = s.getProcessName(paramContext);
        this.mBmpMgr = new a(paramContext, processName);
        this.cData = new a.a.a.b.b(paramContext, paramString1, "", paramString2, paramString3, paramString4, sSessionID, paramString5, "0.4.2");
        setContext(paramContext);
        initLoadlibrary();
        checkProgressName();
        paramContext = new StringBuilder();
        paramContext.append("isMsf: ");
        paramContext.append(isMsf);
        logCat("poxy_java", paramContext.toString());
        ReportLogHelper.report(4, 0);
        return;
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
        return;
      }
    }
    logCat("poxy_java", "init fail!");
  }
  
  public void processFilterSwitch(boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) && (TextUtils.isEmpty(paramString)))
    {
      Log.d("ByteData", "[warning]: Process name is empty !");
      return;
    }
    if (paramBoolean)
    {
      this.filterStatus = paramBoolean;
      this.filterName = paramString;
      return;
    }
    this.filterStatus = paramBoolean;
    this.filterName = "";
  }
  
  public void putUping(int paramInt1, int paramInt2, int paramInt3, Object paramObject)
  {
    try
    {
      Object localObject = new d(paramInt2, paramInt3, paramObject);
      Message localMessage = mDataHandler.obtainMessage(paramInt1);
      localMessage.obj = localObject;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("poxy_java --> putType: ");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(" cmd: ");
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append(" reqTyep: ");
      ((StringBuilder)localObject).append(paramInt3);
      ((StringBuilder)localObject).append(" cabk report log ");
      ((StringBuilder)localObject).append(paramObject);
      logCat("ByteData", ((StringBuilder)localObject).toString());
      mDataHandler.sendMessage(localMessage);
      return;
    }
    catch (Exception paramObject)
    {
      paramObject.printStackTrace();
    }
  }
  
  public void runTime(int paramInt1, String paramString, int paramInt2)
  {
    if (this.mPoxyNativeLoaded)
    {
      if (!this.mPoxyInit) {
        return;
      }
      if ((this.filterStatus) && (!processName.equalsIgnoreCase(this.filterName))) {
        return;
      }
      try
      {
        mDataHandler.post(new ByteData.c(this, paramInt1, paramInt2, paramString));
        return;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  public void setData(String paramString)
  {
    if (this.mPoxyNativeLoaded)
    {
      if (!this.mPoxyInit) {
        return;
      }
      try
      {
        mDataHandler.post(new ByteData.a(this, paramString));
        return;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  public void setDataEx(String paramString1, String paramString2)
  {
    if (this.mPoxyNativeLoaded)
    {
      if (!this.mPoxyInit) {
        return;
      }
      try
      {
        mDataHandler.post(new ByteData.b(this, paramString1, paramString2));
        return;
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.secprotocol.ByteData
 * JD-Core Version:    0.7.0.1
 */