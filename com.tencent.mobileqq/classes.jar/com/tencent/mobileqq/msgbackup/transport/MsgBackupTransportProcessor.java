package com.tencent.mobileqq.msgbackup.transport;

import android.content.Context;
import android.net.Uri;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msgbackup.authentication.MsgBackupAuthProcessor;
import com.tencent.mobileqq.msgbackup.authentication.MsgBackupPushHandler;
import com.tencent.mobileqq.msgbackup.controller.IMsgBackupUICallback;
import com.tencent.mobileqq.msgbackup.controller.MsgBackupManager;
import com.tencent.mobileqq.msgbackup.controller.MsgBackupRequest;
import com.tencent.mobileqq.msgbackup.data.MsgBackupSessionInfo;
import com.tencent.mobileqq.msgbackup.data.MsgBackupSessionTask;
import com.tencent.mobileqq.msgbackup.util.MsgBackupReportData;
import com.tencent.mobileqq.msgbackup.util.MsgBackupReportData.FileError;
import com.tencent.mobileqq.msgbackup.util.MsgBackupReportData.ServerFileDetail;
import com.tencent.mobileqq.msgbackup.util.MsgBackupReporter;
import com.tencent.mobileqq.msgbackup.util.MsgBackupTimeStats;
import com.tencent.mobileqq.msgbackup.util.MsgBackupUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MsgBackupTransportProcessor
{
  private static MsgBackupTransportProcessor t;
  protected MsgBackupJniProxy a;
  protected MsgBackupNotifier b;
  protected int c;
  protected String[] d = new String[10];
  protected Integer e = new Integer(0);
  protected Integer f = new Integer(0);
  protected String[] g = new String[10];
  protected Integer h = new Integer(0);
  protected Integer i = new Integer(0);
  protected String j;
  protected long k = 0L;
  protected boolean l = false;
  private boolean m = false;
  private long n = 0L;
  private long o = 0L;
  private boolean p = false;
  private boolean q = false;
  private boolean r = false;
  private final Object s = new Object();
  private IMsgBackupUICallback u;
  
  private MsgBackupJniProxy a(Context paramContext)
  {
    if (this.a == null) {
      this.a = new MsgBackupJniProxy(paramContext);
    }
    return this.a;
  }
  
  public static MsgBackupTransportProcessor a()
  {
    if (t == null) {
      try
      {
        if (t == null) {
          t = new MsgBackupTransportProcessor();
        }
      }
      finally {}
    }
    return t;
  }
  
  private String a(long paramLong, int paramInt)
  {
    int i1 = MsgBackupManager.i;
    Object localObject4 = MsgBackupManager.a().j;
    ((ConcurrentHashMap)localObject4).size();
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("getSessionJsonRsp, fid = ");
      ((StringBuilder)localObject1).append(paramLong);
      ((StringBuilder)localObject1).append(", mServerReadyMList.size = ");
      ((StringBuilder)localObject1).append(((ConcurrentHashMap)localObject4).size());
      ((StringBuilder)localObject1).append(", mDataCache = ");
      ((StringBuilder)localObject1).append(i1);
      ((StringBuilder)localObject1).append(", from = ");
      ((StringBuilder)localObject1).append(paramInt);
      QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = new JSONArray();
    ??? = new JSONObject();
    try
    {
      if (((ConcurrentHashMap)localObject4).size() > 0)
      {
        ((JSONObject)???).put("cmd", "chat_list_count");
        ((JSONObject)???).put("listCount", i1);
        ((JSONArray)localObject1).put(???);
        int i2 = 0;
        synchronized (this.s)
        {
          localObject4 = ((ConcurrentHashMap)localObject4).values().iterator();
          while (((Iterator)localObject4).hasNext())
          {
            MsgBackupSessionInfo localMsgBackupSessionInfo = (MsgBackupSessionInfo)((Iterator)localObject4).next();
            i1 = i2;
            if (localMsgBackupSessionInfo.g) {
              i1 = i2 + 1;
            }
            i2 = i1;
            if (!localMsgBackupSessionInfo.e)
            {
              JSONObject localJSONObject = new JSONObject();
              String str2 = localMsgBackupSessionInfo.a;
              i2 = localMsgBackupSessionInfo.b;
              localJSONObject.put("cmd", "chat_ready");
              localJSONObject.put("chatUin", str2);
              localJSONObject.put("chatType", MsgBackupUtil.b(i2));
              localJSONObject.put("dbSize", localMsgBackupSessionInfo.d);
              ((JSONArray)localObject1).put(localJSONObject);
              localMsgBackupSessionInfo.e = true;
              i2 = i1;
            }
          }
          if ((3 == paramInt) && (this.u != null)) {
            this.u.a(i2, MsgBackupManager.i);
          }
        }
      }
      String str1 = localObject2.toString();
      return str1;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return "[]";
  }
  
  private String a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null) {}
    try
    {
      paramArrayOfByte = new String(paramArrayOfByte, "utf-8");
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      label17:
      break label17;
    }
    MsgBackupUtil.b("MsgBackup", "receivedCompleted String byte transport string error!!!", new Object[0]);
    return "";
  }
  
  private void a(long paramLong, int paramInt, MsgBackupSessionTask paramMsgBackupSessionTask, ConcurrentHashMap<String, MsgBackupSessionInfo> paramConcurrentHashMap, MsgBackupSessionInfo paramMsgBackupSessionInfo, ConcurrentHashMap<Long, MsgBackupSessionTask> paramConcurrentHashMap1)
  {
    if (paramMsgBackupSessionTask.c)
    {
      MsgBackupReporter.a();
      Object localObject = MsgBackupReporter.a;
      ((MsgBackupReportData)localObject).s += 1L;
      localObject = MsgBackupReporter.a;
      ((MsgBackupReportData)localObject).y += 1L;
      localObject = new MsgBackupReportData.FileError();
      ((MsgBackupReportData.FileError)localObject).b = 1;
      ((MsgBackupReportData.FileError)localObject).c = 0;
      ((MsgBackupReportData.FileError)localObject).a = paramInt;
      MsgBackupReporter.a.z.add(localObject);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("dbMList receivedCompleted  called not success, so again task = ");
        ((StringBuilder)localObject).append(paramMsgBackupSessionTask);
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, ((StringBuilder)localObject).toString());
      }
      if ((!TextUtils.isEmpty(paramMsgBackupSessionTask.e)) && (!TextUtils.isEmpty(paramMsgBackupSessionTask.f))) {
        a(paramLong, paramMsgBackupSessionTask, paramConcurrentHashMap, paramMsgBackupSessionInfo, paramConcurrentHashMap1);
      }
    }
  }
  
  private void a(long paramLong, int paramInt, String paramString, MsgBackupSessionTask paramMsgBackupSessionTask, ConcurrentHashMap<String, MsgBackupSessionInfo> paramConcurrentHashMap, MsgBackupSessionInfo paramMsgBackupSessionInfo, ConcurrentHashMap<Long, MsgBackupSessionTask> paramConcurrentHashMap1, ConcurrentHashMap<Long, MsgBackupSessionTask> paramConcurrentHashMap2)
  {
    if (paramInt == 0)
    {
      a(paramLong, paramString, paramConcurrentHashMap1, paramConcurrentHashMap2);
      return;
    }
    a(paramLong, paramInt, paramMsgBackupSessionTask, paramConcurrentHashMap, paramMsgBackupSessionInfo, paramConcurrentHashMap1);
  }
  
  private void a(long paramLong, int paramInt, ConcurrentHashMap<String, MsgBackupSessionInfo> paramConcurrentHashMap, MsgBackupSessionInfo paramMsgBackupSessionInfo, ConcurrentHashMap<Long, MsgBackupSessionTask> paramConcurrentHashMap1, ConcurrentHashMap<Long, MsgBackupSessionTask> paramConcurrentHashMap2)
  {
    MsgBackupSessionTask localMsgBackupSessionTask = (MsgBackupSessionTask)paramConcurrentHashMap2.get(Long.valueOf(paramLong));
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ResReq receivedCompleted  called  task = ");
      localStringBuilder.append(localMsgBackupSessionTask);
      localStringBuilder.append(", resMList.size = ");
      localStringBuilder.append(paramConcurrentHashMap2.size());
      localStringBuilder.append(", errCode = ");
      localStringBuilder.append(paramInt);
      QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, localStringBuilder.toString());
    }
    if (localMsgBackupSessionTask != null) {
      a(paramLong, paramInt, paramConcurrentHashMap, paramMsgBackupSessionInfo, paramConcurrentHashMap1, paramConcurrentHashMap2, localMsgBackupSessionTask);
    }
  }
  
  private void a(long paramLong, int paramInt, ConcurrentHashMap<String, MsgBackupSessionInfo> paramConcurrentHashMap, MsgBackupSessionInfo paramMsgBackupSessionInfo, ConcurrentHashMap<Long, MsgBackupSessionTask> paramConcurrentHashMap1, ConcurrentHashMap<Long, MsgBackupSessionTask> paramConcurrentHashMap2, MsgBackupSessionTask paramMsgBackupSessionTask)
  {
    if (paramInt == 0)
    {
      b(paramLong, paramConcurrentHashMap, paramMsgBackupSessionInfo, paramConcurrentHashMap1, paramConcurrentHashMap2, paramMsgBackupSessionTask);
      return;
    }
    b(paramLong, paramInt, paramConcurrentHashMap, paramMsgBackupSessionInfo, paramConcurrentHashMap1, paramConcurrentHashMap2, paramMsgBackupSessionTask);
  }
  
  private void a(long paramLong, MsgBackupSessionTask paramMsgBackupSessionTask, ConcurrentHashMap<String, MsgBackupSessionInfo> paramConcurrentHashMap, MsgBackupSessionInfo paramMsgBackupSessionInfo, ConcurrentHashMap<Long, MsgBackupSessionTask> paramConcurrentHashMap1)
  {
    if ((paramMsgBackupSessionTask.g > 3) && (this.q))
    {
      b(paramLong, paramMsgBackupSessionTask, paramConcurrentHashMap, paramMsgBackupSessionInfo, paramConcurrentHashMap1);
      return;
    }
    if (j())
    {
      MsgBackupUtil.b("recvFile panic error! dbMList receivedCompleted", new Object[0]);
      return;
    }
    paramMsgBackupSessionTask.g = ((short)(paramMsgBackupSessionTask.g + 1));
    this.a.a(this.k, paramLong, paramMsgBackupSessionTask.f, paramMsgBackupSessionTask.e, paramMsgBackupSessionTask.h, paramMsgBackupSessionTask.i, false);
  }
  
  private void a(long paramLong, String paramString)
  {
    if (j())
    {
      MsgBackupUtil.b("http get reached! but can not understand this request! session is valid........", new Object[0]);
      return;
    }
    paramString = (String)MsgBackupUtil.c(paramString).get("fid");
    if (!TextUtils.isEmpty(paramString))
    {
      long l1 = Long.parseLong(paramString);
      MsgBackupUtil.b("http get reached! but can not understand this request! session is valid........", new Object[0]);
      this.a.refuseFileRequest(this.k, paramLong, l1, "404");
    }
  }
  
  private void a(long paramLong1, String paramString1, int paramInt, long paramLong2, ConcurrentHashMap<String, MsgBackupSessionInfo> paramConcurrentHashMap, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString2))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("receivedCompleted, fid = ");
        localStringBuilder.append(paramLong1);
        localStringBuilder.append(", url = ");
        localStringBuilder.append(paramString1);
        localStringBuilder.append(", errCode = ");
        localStringBuilder.append(paramInt);
        localStringBuilder.append(", context = ");
        localStringBuilder.append(paramLong2);
        localStringBuilder.append(", recvBuf = ");
        localStringBuilder.append(paramString2);
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, localStringBuilder.toString());
      }
      try
      {
        paramString1 = new JSONArray(paramString2);
        if (paramString1.length() > 0)
        {
          paramString2 = (JSONObject)paramString1.get(0);
          if ("chat_list_count".equals(paramString2.optString("cmd")))
          {
            a(paramConcurrentHashMap, paramString1, paramString2);
            return;
          }
          a(paramConcurrentHashMap, paramString1);
          return;
        }
        if ((paramConcurrentHashMap.size() < MsgBackupManager.i) || (MsgBackupManager.i <= 0))
        {
          MsgBackupUtil.b("client cache is deal completedly! so get next session!", new Object[0]);
          j(3);
          return;
        }
      }
      catch (JSONException paramString1)
      {
        QLog.e("MsgBackup_MsgBackupTransportProcessor", 2, "receivedCompleted parse json error!", paramString1);
      }
    }
  }
  
  private void a(long paramLong1, String paramString1, int paramInt, String paramString2, byte[] paramArrayOfByte, long paramLong2, ConcurrentHashMap<Long, MsgBackupSessionTask> paramConcurrentHashMap, ConcurrentHashMap<String, MsgBackupSessionInfo> paramConcurrentHashMap1)
  {
    paramConcurrentHashMap.remove(Long.valueOf(paramLong1));
    if ((this.a != null) && (TextUtils.isEmpty(paramString2)))
    {
      if (j())
      {
        MsgBackupUtil.b("getRecvBuffer called operator is closed! please clear handler msg!........", new Object[0]);
        return;
      }
      a(paramLong1, paramString1, paramInt, paramLong2, paramConcurrentHashMap1, a(paramArrayOfByte));
    }
  }
  
  private void a(long paramLong, String paramString, int paramInt, boolean paramBoolean)
  {
    if (j())
    {
      MsgBackupUtil.b("requestFromFile called------> operator is closed! please clear handler msg!........", new Object[0]);
      return;
    }
    if (this.a != null)
    {
      long l1 = MsgBackupUtil.a();
      String str = MsgBackupUtil.a(this.g[0], this.i.intValue());
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("getmsg?fid=");
      ((StringBuilder)localObject1).append(l1);
      ((StringBuilder)localObject1).append("&chatUin=");
      ((StringBuilder)localObject1).append(paramString);
      ((StringBuilder)localObject1).append("&chatType=");
      ((StringBuilder)localObject1).append(MsgBackupUtil.b(paramInt));
      localObject1 = ((StringBuilder)localObject1).toString();
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(str);
      ((StringBuilder)localObject2).append(MsgBackupUtil.b((String)localObject1, this.j));
      str = ((StringBuilder)localObject2).toString();
      localObject1 = MsgBackupUtil.a(paramString, MsgBackupUtil.b(paramInt), null);
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("requestFromFile fid = ");
        ((StringBuilder)localObject2).append(l1);
        ((StringBuilder)localObject2).append(", url = ");
        ((StringBuilder)localObject2).append(str);
        ((StringBuilder)localObject2).append(", path = ");
        ((StringBuilder)localObject2).append((String)localObject1);
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, ((StringBuilder)localObject2).toString());
      }
      localObject2 = new MsgBackupSessionTask();
      ((MsgBackupSessionTask)localObject2).c = true;
      ((MsgBackupSessionTask)localObject2).g = 0;
      ((MsgBackupSessionTask)localObject2).e = ((String)localObject1);
      ((MsgBackupSessionTask)localObject2).f = str;
      paramString = MsgBackupUtil.b(paramString, MsgBackupUtil.b(paramInt));
      ConcurrentHashMap localConcurrentHashMap = MsgBackupManager.a().k;
      MsgBackupReporter.a();
      Object localObject3 = MsgBackupReporter.a;
      ((MsgBackupReportData)localObject3).r += 1L;
      localObject3 = (MsgBackupSessionInfo)localConcurrentHashMap.get(paramString);
      if (localObject3 != null)
      {
        ((MsgBackupSessionInfo)localObject3).k.put(Long.valueOf(l1), localObject2);
        ((MsgBackupSessionTask)localObject2).i = ((MsgBackupSessionInfo)localObject3).d;
        ((MsgBackupSessionTask)localObject2).h = MsgBackupUtil.b(((MsgBackupSessionInfo)localObject3).d);
        Object localObject4 = MsgBackupReporter.a;
        ((MsgBackupReportData)localObject4).k += ((MsgBackupSessionTask)localObject2).i;
        if (QLog.isColorLevel())
        {
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append("requestFromFile , sessionInfo.dbMList = ");
          ((StringBuilder)localObject4).append(((MsgBackupSessionInfo)localObject3).k);
          ((StringBuilder)localObject4).append(". sessionInfo.hashcode = ");
          ((StringBuilder)localObject4).append(localObject3.hashCode());
          ((StringBuilder)localObject4).append(", task.isSmallerFile = ");
          ((StringBuilder)localObject4).append(((MsgBackupSessionTask)localObject2).h);
          QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, ((StringBuilder)localObject4).toString());
        }
      }
      if (QLog.isColorLevel())
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("requestFromFile fid = ");
        ((StringBuilder)localObject3).append(l1);
        ((StringBuilder)localObject3).append(", mClientCanRecvMList = ");
        ((StringBuilder)localObject3).append(localConcurrentHashMap);
        ((StringBuilder)localObject3).append(", keyFromUin = ");
        ((StringBuilder)localObject3).append(paramString);
        ((StringBuilder)localObject3).append(", task.isSmallerFile = ");
        ((StringBuilder)localObject3).append(((MsgBackupSessionTask)localObject2).h);
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, ((StringBuilder)localObject3).toString());
      }
      this.a.a(paramLong, l1, str, (String)localObject1, ((MsgBackupSessionTask)localObject2).h, ((MsgBackupSessionTask)localObject2).i, false);
      boolean bool = this.l;
      paramBoolean = false;
      if (this.u != null) {
        paramBoolean = true;
      }
      MsgBackupUtil.b("MsgBackup_MsgBackupTransportProcessor", "requestFromFile isTransportStart = %b, mCallBack is not null = %b", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(paramBoolean) });
      paramString = this.u;
      if ((paramString != null) && (!this.l))
      {
        this.l = true;
        paramString.c(true);
      }
    }
  }
  
  private void a(long paramLong, String paramString, ConcurrentHashMap<Long, MsgBackupSessionTask> paramConcurrentHashMap)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("httpGetReached success, url = ");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, ((StringBuilder)localObject).toString());
    }
    if (j())
    {
      MsgBackupUtil.b("getres onSendComplete operator is closed! please clear handler msg!........", new Object[0]);
      return;
    }
    Object localObject = MsgBackupReporter.a;
    ((MsgBackupReportData)localObject).i += 1L;
    localObject = MsgBackupReporter.a;
    ((MsgBackupReportData)localObject).l += 1L;
    paramString = MsgBackupUtil.c(paramString);
    long l1 = Long.parseLong((String)paramString.get("fid"));
    localObject = (String)paramString.get("filepath");
    MsgBackupUtil.b("res url parse fid = %d,filepath = %s", new Object[] { Long.valueOf(l1), localObject });
    paramString = (String)localObject;
    if (MsgBackupUtil.c) {
      paramString = Uri.decode((String)localObject);
    }
    MsgBackupUtil.b("res url parse fid = %d,filepath = %s", new Object[] { Long.valueOf(l1), paramString });
    localObject = new MsgBackupReportData.ServerFileDetail();
    ((MsgBackupReportData.ServerFileDetail)localObject).a = false;
    ((MsgBackupReportData.ServerFileDetail)localObject).b = 0L;
    MsgBackupManager.a().n.put(Long.valueOf(l1), localObject);
    localObject = new MsgBackupSessionTask();
    ((MsgBackupSessionTask)localObject).g = 0;
    ((MsgBackupSessionTask)localObject).c = true;
    ((MsgBackupSessionTask)localObject).e = MsgBackupUtil.b(paramString);
    ((MsgBackupSessionTask)localObject).d = paramLong;
    paramConcurrentHashMap.put(Long.valueOf(l1), localObject);
    this.a.a(this.k, paramLong, l1, ((MsgBackupSessionTask)localObject).e);
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("onHttpRequest, send res file, fileRes path = ");
      paramString.append(((MsgBackupSessionTask)localObject).e);
      paramString.append(", mFidMList.size = ");
      paramString.append(paramConcurrentHashMap.size());
      QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, paramString.toString());
    }
  }
  
  private void a(long paramLong, String paramString, ConcurrentHashMap<Long, MsgBackupSessionTask> paramConcurrentHashMap1, ConcurrentHashMap<Long, MsgBackupSessionTask> paramConcurrentHashMap2)
  {
    paramConcurrentHashMap1.remove(Long.valueOf(paramLong));
    if (paramString.endsWith(".db"))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("receivedCompleted db success, path = ");
        localStringBuilder.append(paramString);
        localStringBuilder.append(", dbMList.size = ");
        localStringBuilder.append(paramConcurrentHashMap1.size());
        localStringBuilder.append(", resMList.size = ");
        localStringBuilder.append(paramConcurrentHashMap2.size());
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, localStringBuilder.toString());
      }
      paramConcurrentHashMap1 = paramString.substring(paramString.lastIndexOf("/") + 1);
      if (QLog.isColorLevel())
      {
        paramConcurrentHashMap2 = new StringBuilder();
        paramConcurrentHashMap2.append("receivedCompleted db success, dbName = ");
        paramConcurrentHashMap2.append(paramConcurrentHashMap1);
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, paramConcurrentHashMap2.toString());
      }
      paramConcurrentHashMap1 = new MsgBackupRequest();
      paramConcurrentHashMap1.b = 1;
      paramConcurrentHashMap1.i = paramString;
      MsgBackupManager.a().b(paramConcurrentHashMap1);
    }
  }
  
  private void a(long paramLong1, ConcurrentHashMap<Long, MsgBackupSessionTask> paramConcurrentHashMap, long paramLong2, String paramString)
  {
    MsgBackupSessionTask localMsgBackupSessionTask = new MsgBackupSessionTask();
    localMsgBackupSessionTask.g = 0;
    localMsgBackupSessionTask.c = false;
    localMsgBackupSessionTask.a = paramString;
    localMsgBackupSessionTask.d = paramLong1;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("sendPreparedSession  postinfo httpGetReached, client request server's already session, fid = ");
      localStringBuilder.append(paramLong2);
      localStringBuilder.append(", msg = ");
      localStringBuilder.append(paramString);
      QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, localStringBuilder.toString());
    }
    paramConcurrentHashMap.put(Long.valueOf(paramLong2), localMsgBackupSessionTask);
    this.a.b(this.k, paramLong1, paramLong2, paramString);
  }
  
  private void a(long paramLong, ConcurrentHashMap<String, MsgBackupSessionInfo> paramConcurrentHashMap, MsgBackupSessionInfo arg4, ConcurrentHashMap<Long, MsgBackupSessionTask> paramConcurrentHashMap1, ConcurrentHashMap<Long, MsgBackupSessionTask> paramConcurrentHashMap2, MsgBackupSessionTask paramMsgBackupSessionTask)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("isTcpDetected = ");
    localStringBuilder.append(this.q);
    localStringBuilder.append(", isResRequestAllFinished");
    localStringBuilder.append(???.h.get());
    localStringBuilder.append(", resReq fileTask receivedCompleted retry over time task = ");
    localStringBuilder.append(paramMsgBackupSessionTask);
    QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, localStringBuilder.toString());
    paramConcurrentHashMap2.remove(Long.valueOf(paramLong));
    int i1 = paramConcurrentHashMap2.size();
    int i2 = paramConcurrentHashMap1.size();
    if ((i1 == 0) && (i2 == 0) && (???.h.get()))
    {
      ???.g = true;
      a(???);
      if (QLog.isColorLevel())
      {
        ??? = new StringBuilder();
        ???.append("last session transport completed!, uin = ");
        ???.append(MsgBackupManager.o);
        ???.append(", uintype = ");
        ???.append(MsgBackupManager.p);
        ???.append(", task = ");
        ???.append(paramMsgBackupSessionTask);
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, ???.toString());
      }
      if (QLog.isColorLevel())
      {
        ??? = new StringBuilder();
        ???.append("mclient will get db mClientCanRecvMList.size = ");
        ???.append(paramConcurrentHashMap.size());
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, ???.toString());
      }
      synchronized (this.s)
      {
        paramConcurrentHashMap = paramConcurrentHashMap.values().iterator();
        i1 = 0;
        while (paramConcurrentHashMap.hasNext()) {
          if (((MsgBackupSessionInfo)paramConcurrentHashMap.next()).g) {
            i1 += 1;
          }
        }
        paramConcurrentHashMap = this.u;
        if (paramConcurrentHashMap != null) {
          paramConcurrentHashMap.a(i1, MsgBackupManager.i);
        }
        if (i1 == MsgBackupManager.i) {
          return;
        }
        if (!k(2))
        {
          MsgBackupUtil.b("this session res has received! over time  so get next session!", new Object[0]);
          j(3);
          return;
        }
      }
    }
  }
  
  private void a(long paramLong, ConcurrentHashMap<Long, MsgBackupSessionTask> paramConcurrentHashMap, MsgBackupSessionTask paramMsgBackupSessionTask)
  {
    StringBuilder localStringBuilder;
    if (paramMsgBackupSessionTask.c)
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("mfidMlist fileTask receivedCompleted  called not success, so again task = ");
        localStringBuilder.append(paramMsgBackupSessionTask);
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, localStringBuilder.toString());
      }
      if ((!TextUtils.isEmpty(paramMsgBackupSessionTask.e)) && (!TextUtils.isEmpty(paramMsgBackupSessionTask.f)))
      {
        if (paramMsgBackupSessionTask.g > 3)
        {
          paramConcurrentHashMap.remove(Long.valueOf(paramLong));
          paramConcurrentHashMap = new StringBuilder();
          paramConcurrentHashMap.append(" mfidMlist fileTask receivedCompleted retry over time task = ");
          paramConcurrentHashMap.append(paramMsgBackupSessionTask);
          QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, paramConcurrentHashMap.toString());
          return;
        }
        if (j())
        {
          MsgBackupUtil.b("recvFile panic error! mfidMlist fileTask receivedCompleted", new Object[0]);
          return;
        }
        paramMsgBackupSessionTask.g = ((short)(paramMsgBackupSessionTask.g + 1));
        this.a.a(this.k, paramLong, paramMsgBackupSessionTask.f, paramMsgBackupSessionTask.e, paramMsgBackupSessionTask.h, paramMsgBackupSessionTask.i, true);
      }
    }
    else
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("receivedCompleted mfidMlist called not success, so again task = ");
        localStringBuilder.append(paramMsgBackupSessionTask);
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, localStringBuilder.toString());
      }
      if (!TextUtils.isEmpty(paramMsgBackupSessionTask.f))
      {
        if (paramMsgBackupSessionTask.g > 3)
        {
          paramConcurrentHashMap.remove(Long.valueOf(paramLong));
          paramConcurrentHashMap = new StringBuilder();
          paramConcurrentHashMap.append("receivedCompleted mfidMlist retry over time task = ");
          paramConcurrentHashMap.append(paramMsgBackupSessionTask);
          QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, paramConcurrentHashMap.toString());
          return;
        }
        if (j())
        {
          MsgBackupUtil.b("receivedCompleted mfidMlist  operator is closed! please clear handler msg!........", new Object[0]);
          return;
        }
        paramMsgBackupSessionTask.g = ((short)(paramMsgBackupSessionTask.g + 1));
        this.a.a(this.k, paramLong, paramMsgBackupSessionTask.f);
      }
    }
  }
  
  private void a(long paramLong, ConcurrentHashMap<Long, MsgBackupSessionTask> paramConcurrentHashMap, Map<String, String> paramMap)
  {
    if (j())
    {
      MsgBackupUtil.b("httpGetReached postinfo operator is closed! please clear handler msg!........", new Object[0]);
      return;
    }
    long l1 = Long.parseLong((String)paramMap.get("fid"));
    a(paramLong, paramConcurrentHashMap, l1, a(l1, 1));
  }
  
  private void a(long paramLong, ConcurrentHashMap<Long, MsgBackupSessionTask> paramConcurrentHashMap, ConcurrentHashMap<String, MsgBackupSessionInfo> paramConcurrentHashMap1, Map<String, String> arg5)
  {
    if (???.size() >= 3)
    {
      boolean bool = j();
      int i1 = 0;
      if (bool)
      {
        MsgBackupUtil.b("httpGetReached postinfo operator is closed! please clear handler msg!........", new Object[0]);
        return;
      }
      long l1 = Long.parseLong((String)???.get("fid"));
      String str = (String)???.get("chatUin");
      int i2 = Integer.parseInt((String)???.get("chatType"));
      if (QLog.isColorLevel())
      {
        ??? = new StringBuilder();
        ???.append("httpGetReached: client report 会话 uin =");
        ???.append(str);
        ???.append(" 接收完成, chatType = ");
        ???.append(i2);
        ???.append("：mServerReadyMList.size = ");
        ???.append(paramConcurrentHashMap1.size());
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, ???.toString());
      }
      ??? = (MsgBackupSessionInfo)paramConcurrentHashMap1.get(MsgBackupUtil.b(str, i2));
      if (??? != null)
      {
        ???.g = true;
        if (this.u != null) {
          synchronized (this.s)
          {
            paramConcurrentHashMap1 = paramConcurrentHashMap1.values().iterator();
            while (paramConcurrentHashMap1.hasNext()) {
              if (((MsgBackupSessionInfo)paramConcurrentHashMap1.next()).g) {
                i1 += 1;
              }
            }
            if (QLog.isColorLevel())
            {
              paramConcurrentHashMap1 = new StringBuilder();
              paramConcurrentHashMap1.append("httpGetReached: client report session completed! hasCompletedCount = ");
              paramConcurrentHashMap1.append(i1);
              QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, paramConcurrentHashMap1.toString());
            }
            paramConcurrentHashMap1 = this.u;
            if (paramConcurrentHashMap1 != null) {
              paramConcurrentHashMap1.a(i1, MsgBackupManager.i);
            }
            i1 = MsgBackupManager.i;
          }
        }
      }
      if (QLog.isColorLevel())
      {
        paramConcurrentHashMap1 = new StringBuilder();
        paramConcurrentHashMap1.append("httpGetReached, client report session transport completed! fid = ");
        paramConcurrentHashMap1.append(l1);
        paramConcurrentHashMap1.append(", msg = []");
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, paramConcurrentHashMap1.toString());
      }
      a(paramLong, paramConcurrentHashMap, l1, a(l1, 3));
    }
  }
  
  private void a(MsgBackupSessionInfo paramMsgBackupSessionInfo)
  {
    if (this.p)
    {
      i(258);
      return;
    }
    a(this.k, false, paramMsgBackupSessionInfo.a, paramMsgBackupSessionInfo.b);
  }
  
  private void a(ConcurrentHashMap<String, MsgBackupSessionInfo> paramConcurrentHashMap, JSONArray paramJSONArray)
  {
    int i1 = 0;
    while (i1 < paramJSONArray.length())
    {
      Object localObject = (JSONObject)paramJSONArray.get(i1);
      if ("chat_ready".equals(((JSONObject)localObject).optString("cmd")))
      {
        String str = ((JSONObject)localObject).optString("chatUin");
        int i2 = ((JSONObject)localObject).optInt("chatType");
        long l1 = ((JSONObject)localObject).optLong("dbSize");
        localObject = new MsgBackupSessionInfo();
        ((MsgBackupSessionInfo)localObject).f = false;
        ((MsgBackupSessionInfo)localObject).a = str;
        ((MsgBackupSessionInfo)localObject).d = l1;
        ((MsgBackupSessionInfo)localObject).b = MsgBackupUtil.c(i2);
        paramConcurrentHashMap.put(MsgBackupUtil.b(((MsgBackupSessionInfo)localObject).a, i2), localObject);
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("receivedCompleted  会话 uin =");
          localStringBuilder.append(str);
          localStringBuilder.append(", uintype = ");
          localStringBuilder.append(((MsgBackupSessionInfo)localObject).b);
          localStringBuilder.append("：mClientCanRecvMList.size = ");
          localStringBuilder.append(paramConcurrentHashMap.size());
          QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, localStringBuilder.toString());
        }
      }
      i1 += 1;
    }
    k(4);
  }
  
  private void a(ConcurrentHashMap<String, MsgBackupSessionInfo> paramConcurrentHashMap, JSONArray paramJSONArray, JSONObject paramJSONObject)
  {
    MsgBackupManager.i = paramJSONObject.optInt("listCount");
    MsgBackupReporter.a();
    MsgBackupReporter.a.g = MsgBackupManager.i;
    if (QLog.isColorLevel())
    {
      paramJSONObject = new StringBuilder();
      paramJSONObject.append("receivedCompleted, 会话总个数：MsgBackupManager.sessionCount = ");
      paramJSONObject.append(MsgBackupManager.i);
      QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, paramJSONObject.toString());
    }
    int i1 = 1;
    while (i1 < paramJSONArray.length())
    {
      Object localObject1 = (JSONObject)paramJSONArray.get(i1);
      if ("chat_ready".equals(((JSONObject)localObject1).optString("cmd")))
      {
        paramJSONObject = ((JSONObject)localObject1).optString("chatUin");
        int i2 = ((JSONObject)localObject1).optInt("chatType");
        long l1 = ((JSONObject)localObject1).optLong("dbSize");
        localObject1 = new MsgBackupSessionInfo();
        ((MsgBackupSessionInfo)localObject1).f = false;
        ((MsgBackupSessionInfo)localObject1).a = paramJSONObject;
        ((MsgBackupSessionInfo)localObject1).b = MsgBackupUtil.c(i2);
        ((MsgBackupSessionInfo)localObject1).d = l1;
        Object localObject2 = MsgBackupUtil.b(((MsgBackupSessionInfo)localObject1).a, i2);
        if (paramConcurrentHashMap.get(localObject2) == null) {
          paramConcurrentHashMap.put(localObject2, localObject1);
        }
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("receivedCompleted  会话 uin =");
          ((StringBuilder)localObject2).append(paramJSONObject);
          ((StringBuilder)localObject2).append(", uintype = ");
          ((StringBuilder)localObject2).append(((MsgBackupSessionInfo)localObject1).b);
          ((StringBuilder)localObject2).append("：mClientCanRecvMList= ");
          ((StringBuilder)localObject2).append(paramConcurrentHashMap);
          QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, ((StringBuilder)localObject2).toString());
        }
      }
      i1 += 1;
    }
    k(4);
  }
  
  private boolean a(ConcurrentHashMap<String, MsgBackupSessionInfo> paramConcurrentHashMap, boolean paramBoolean)
  {
    Iterator localIterator = paramConcurrentHashMap.values().iterator();
    int i1 = 0;
    boolean bool1;
    int i2;
    Object localObject;
    do
    {
      do
      {
        do
        {
          boolean bool2 = localIterator.hasNext();
          bool1 = true;
          i2 = i1;
          if (!bool2) {
            break;
          }
          localObject = (MsgBackupSessionInfo)localIterator.next();
        } while (((MsgBackupSessionInfo)localObject).f);
        if (((MsgBackupSessionInfo)localObject).d > 0L) {
          break;
        }
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(" requestNextSessionDb !, curDealUin is not null! dbsize 等于 0 ！客户端不会去请求了，只是通知server端，该会话已经接受完成了！uin = ");
          localStringBuilder.append(((MsgBackupSessionInfo)localObject).a);
          localStringBuilder.append(", uintype = ");
          localStringBuilder.append(((MsgBackupSessionInfo)localObject).b);
          localStringBuilder.append(", dbsize = ");
          localStringBuilder.append(((MsgBackupSessionInfo)localObject).d);
          QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, localStringBuilder.toString());
        }
        ((MsgBackupSessionInfo)localObject).g = true;
        ((MsgBackupSessionInfo)localObject).f = true;
        a((MsgBackupSessionInfo)localObject);
      } while (this.u == null);
      i2 = d(paramConcurrentHashMap);
      localObject = this.u;
      if (localObject != null) {
        ((IMsgBackupUICallback)localObject).a(i2, MsgBackupManager.i);
      }
      i1 = i2;
    } while (i2 != MsgBackupManager.i);
    MsgBackupUtil.b("MsgBackup_MsgBackupTransportProcessor", "curDealUin is not null! session transport completed! dbSize is 0!------------->", new Object[0]);
    break label398;
    i1 = d(paramConcurrentHashMap);
    paramConcurrentHashMap = this.u;
    if (paramConcurrentHashMap != null) {
      paramConcurrentHashMap.a(i1, MsgBackupManager.i);
    }
    if (i1 == MsgBackupManager.i) {
      MsgBackupUtil.b("MsgBackup_MsgBackupTransportProcessor", "curDealUin is not null! session transport completed!------------->", new Object[0]);
    }
    for (;;)
    {
      break;
      ((MsgBackupSessionInfo)localObject).f = true;
      MsgBackupManager.o = ((MsgBackupSessionInfo)localObject).a;
      MsgBackupManager.p = ((MsgBackupSessionInfo)localObject).b;
      if (QLog.isColorLevel())
      {
        paramConcurrentHashMap = new StringBuilder();
        paramConcurrentHashMap.append(" requestNextSessionDb !, current uin = ");
        paramConcurrentHashMap.append(MsgBackupManager.o);
        paramConcurrentHashMap.append(", uintype = ");
        paramConcurrentHashMap.append(MsgBackupManager.p);
        paramConcurrentHashMap.append(", dbsize = ");
        paramConcurrentHashMap.append(((MsgBackupSessionInfo)localObject).d);
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, paramConcurrentHashMap.toString());
      }
      a(this.k, ((MsgBackupSessionInfo)localObject).a, ((MsgBackupSessionInfo)localObject).b, false);
      paramBoolean = bool1;
    }
    label398:
    i1 = i2;
    if ((!paramBoolean) && (i1 != MsgBackupManager.i))
    {
      j(5);
      if (QLog.isColorLevel())
      {
        paramConcurrentHashMap = new StringBuilder();
        paramConcurrentHashMap.append("requestNextSessionDb called with warning step2 , , hasFinishedC = ");
        paramConcurrentHashMap.append(i1);
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, paramConcurrentHashMap.toString());
      }
    }
    return paramBoolean;
  }
  
  private void b(long paramLong, int paramInt, ConcurrentHashMap<String, MsgBackupSessionInfo> paramConcurrentHashMap, MsgBackupSessionInfo paramMsgBackupSessionInfo, ConcurrentHashMap<Long, MsgBackupSessionTask> paramConcurrentHashMap1, ConcurrentHashMap<Long, MsgBackupSessionTask> paramConcurrentHashMap2, MsgBackupSessionTask paramMsgBackupSessionTask)
  {
    if (paramMsgBackupSessionTask.c)
    {
      MsgBackupReporter.a();
      Object localObject = MsgBackupReporter.a;
      ((MsgBackupReportData)localObject).m += 1L;
      localObject = MsgBackupReporter.a;
      ((MsgBackupReportData)localObject).y += 1L;
      localObject = new MsgBackupReportData.FileError();
      if (MsgBackupManager.a().l.contains(Long.valueOf(paramLong)))
      {
        MsgBackupReportData localMsgBackupReportData = MsgBackupReporter.a;
        localMsgBackupReportData.p += 1L;
        MsgBackupManager.a().l.remove(Long.valueOf(paramLong));
        ((MsgBackupReportData.FileError)localObject).c = 2;
      }
      else
      {
        ((MsgBackupReportData.FileError)localObject).c = 1;
      }
      ((MsgBackupReportData.FileError)localObject).b = 2;
      ((MsgBackupReportData.FileError)localObject).a = paramInt;
      MsgBackupReporter.a.z.add(localObject);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("resReq fileTask receivedCompleted  called not success, so again task = ");
        ((StringBuilder)localObject).append(paramMsgBackupSessionTask);
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, ((StringBuilder)localObject).toString());
      }
      if ((!TextUtils.isEmpty(paramMsgBackupSessionTask.e)) && (!TextUtils.isEmpty(paramMsgBackupSessionTask.f)))
      {
        if ((paramMsgBackupSessionTask.g > 3) && (this.q))
        {
          a(paramLong, paramConcurrentHashMap, paramMsgBackupSessionInfo, paramConcurrentHashMap1, paramConcurrentHashMap2, paramMsgBackupSessionTask);
          return;
        }
        if (j())
        {
          MsgBackupUtil.b("recvFile panic error! resReq fileTask receivedCompleted", new Object[0]);
          return;
        }
        paramMsgBackupSessionTask.g = ((short)(paramMsgBackupSessionTask.g + 1));
        this.a.a(this.k, paramLong, paramMsgBackupSessionTask.f, paramMsgBackupSessionTask.e, paramMsgBackupSessionTask.h, paramMsgBackupSessionTask.i, true);
      }
    }
  }
  
  private void b(long paramLong, MsgBackupSessionTask arg3, ConcurrentHashMap<String, MsgBackupSessionInfo> paramConcurrentHashMap, MsgBackupSessionInfo paramMsgBackupSessionInfo, ConcurrentHashMap<Long, MsgBackupSessionTask> paramConcurrentHashMap1)
  {
    MsgBackupManager.g += 1;
    MsgBackupUtil.b("MsgBackup_MsgBackupTransportProcessor", "MsgBackup_Manager skipSessionCount = %d", new Object[] { Integer.valueOf(MsgBackupManager.g) });
    paramConcurrentHashMap1.remove(Long.valueOf(paramLong));
    paramConcurrentHashMap1 = new StringBuilder();
    paramConcurrentHashMap1.append("isTcpDetected = ");
    paramConcurrentHashMap1.append(this.q);
    paramConcurrentHashMap1.append(", 此会话db一直失败，扔掉，通知对端dbMList receivedCompleted retry over time task = ");
    paramConcurrentHashMap1.append(???);
    QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, paramConcurrentHashMap1.toString());
    paramMsgBackupSessionInfo.g = true;
    a(paramMsgBackupSessionInfo);
    if (QLog.isColorLevel())
    {
      ??? = new StringBuilder();
      ???.append("getdb failed !  mclient will get db mClientCanRecvMList.size = ");
      ???.append(paramConcurrentHashMap.size());
      QLog.d("MsgBackup", 2, ???.toString());
    }
    synchronized (this.s)
    {
      paramConcurrentHashMap = paramConcurrentHashMap.values().iterator();
      int i1 = 0;
      while (paramConcurrentHashMap.hasNext()) {
        if (((MsgBackupSessionInfo)paramConcurrentHashMap.next()).g) {
          i1 += 1;
        }
      }
      ??? = this.u;
      if (??? != null) {
        ???.a(i1, MsgBackupManager.i);
      }
      if (i1 == MsgBackupManager.i) {
        return;
      }
      if (!k(2))
      {
        MsgBackupUtil.b("this session db has received error! so get next session!", new Object[0]);
        j(3);
      }
      return;
    }
    for (;;)
    {
      throw paramConcurrentHashMap;
    }
  }
  
  private void b(long paramLong, String paramString1, int paramInt, String paramString2)
  {
    paramString1 = paramString2;
    if (MsgBackupUtil.b) {
      paramString1 = MsgBackupUtil.a(paramString2, this.j);
    }
    MsgBackupReporter.a();
    paramString2 = MsgBackupManager.a().r;
    ConcurrentHashMap localConcurrentHashMap = MsgBackupManager.a().j;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("httpGetReached, MsgBackupManager.curDealType = ");
      localStringBuilder.append(MsgBackupManager.o);
      localStringBuilder.append(", MsgBackupManager.curDealType = ");
      localStringBuilder.append(MsgBackupManager.p);
      QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, localStringBuilder.toString());
    }
    if ((this.a != null) && (paramString1 != null))
    {
      if (paramString1.contains("/postinfo?"))
      {
        c(paramLong, paramString1, paramString2, localConcurrentHashMap);
        return;
      }
      if (paramString1.contains("/getmsg?"))
      {
        b(paramLong, paramString1, paramString2, localConcurrentHashMap);
        return;
      }
      if (paramString1.contains("/getres?"))
      {
        a(paramLong, paramString1, paramString2);
        return;
      }
      a(paramLong, paramString1);
    }
  }
  
  private void b(long paramLong1, String paramString1, int paramInt1, String paramString2, byte[] paramArrayOfByte, int paramInt2, int paramInt3, long paramLong2)
  {
    if (MsgBackupUtil.b) {
      paramString1 = MsgBackupUtil.b(paramString1, this.g[0], this.i.intValue(), this.j);
    }
    Object localObject = MsgBackupManager.a().r;
    MsgBackupSessionTask localMsgBackupSessionTask = (MsgBackupSessionTask)((ConcurrentHashMap)localObject).get(Long.valueOf(paramLong1));
    ConcurrentHashMap localConcurrentHashMap = MsgBackupManager.a().k;
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("receivedCompleted called! mfidMlist.size = ");
      localStringBuilder.append(((ConcurrentHashMap)localObject).size());
      localStringBuilder.append(", mClientCanRecvMList.size = ");
      localStringBuilder.append(localConcurrentHashMap.size());
      localStringBuilder.append(", path = ");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(",url = ");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(", fid = ");
      localStringBuilder.append(paramLong1);
      localStringBuilder.append(",errorCode = ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(", task = ");
      localStringBuilder.append(localMsgBackupSessionTask);
      localStringBuilder.append("，mFidMList ");
      localStringBuilder.append(((ConcurrentHashMap)localObject).toString());
      localStringBuilder.append(", MsgBackupManager.sessionCount = ");
      localStringBuilder.append(MsgBackupManager.i);
      QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, localStringBuilder.toString());
    }
    if (localMsgBackupSessionTask != null)
    {
      if (paramInt1 == 0)
      {
        a(paramLong1, paramString1, paramInt1, paramString2, paramArrayOfByte, paramLong2, (ConcurrentHashMap)localObject, localConcurrentHashMap);
        return;
      }
      a(paramLong1, (ConcurrentHashMap)localObject, localMsgBackupSessionTask);
      return;
    }
    paramArrayOfByte = MsgBackupUtil.b(MsgBackupManager.o, MsgBackupUtil.b(MsgBackupManager.p));
    paramString1 = (MsgBackupSessionInfo)localConcurrentHashMap.get(paramArrayOfByte);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("receivedCompleted key = ");
      ((StringBuilder)localObject).append(paramArrayOfByte);
      ((StringBuilder)localObject).append(", mClientCanRecvMList = ");
      ((StringBuilder)localObject).append(localConcurrentHashMap);
      ((StringBuilder)localObject).append(", sessionInfo = ");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(", errCode = ");
      ((StringBuilder)localObject).append(paramInt1);
      QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, ((StringBuilder)localObject).toString());
    }
    if (paramString1 != null)
    {
      paramArrayOfByte = paramString1.k;
      localObject = paramString1.j;
      localMsgBackupSessionTask = (MsgBackupSessionTask)paramArrayOfByte.get(Long.valueOf(paramLong1));
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("receivedCompleted  dbMList task = ");
        localStringBuilder.append(localMsgBackupSessionTask);
        localStringBuilder.append(", dbMList = ");
        localStringBuilder.append(paramArrayOfByte.toString());
        localStringBuilder.append(". sessionInfo.hashcode = ");
        localStringBuilder.append(paramString1.hashCode());
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, localStringBuilder.toString());
      }
      if (localMsgBackupSessionTask != null)
      {
        a(paramLong1, paramInt1, paramString2, localMsgBackupSessionTask, localConcurrentHashMap, paramString1, paramArrayOfByte, (ConcurrentHashMap)localObject);
        return;
      }
      a(paramLong1, paramInt1, localConcurrentHashMap, paramString1, paramArrayOfByte, (ConcurrentHashMap)localObject);
    }
  }
  
  private void b(long paramLong, String paramString, ConcurrentHashMap<Long, MsgBackupSessionTask> paramConcurrentHashMap, ConcurrentHashMap<String, MsgBackupSessionInfo> paramConcurrentHashMap1)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("httpGetReached success, url = ");
      ((StringBuilder)localObject1).append(paramString);
      QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, ((StringBuilder)localObject1).toString());
    }
    boolean bool1 = j();
    int i1 = 0;
    if (bool1)
    {
      MsgBackupUtil.b("getmsg onSendComplete operator is closed! please clear handler msg!........", new Object[0]);
      return;
    }
    boolean bool2 = this.l;
    if (this.u != null) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    MsgBackupUtil.b("MsgBackup_MsgBackupTransportProcessor", "getmsg isTransportStart = %b, mCallBack is not null = %b", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
    Object localObject1 = this.u;
    if ((localObject1 != null) && (!this.l))
    {
      this.l = true;
      ((IMsgBackupUICallback)localObject1).c(true);
    }
    localObject1 = MsgBackupUtil.c(paramString);
    long l1 = Long.parseLong((String)((Map)localObject1).get("fid"));
    if (!MsgBackupManager.v)
    {
      paramString = new MsgBackupSessionTask();
      paramString.g = 0;
      paramString.c = false;
      paramString.a = "[]";
      paramString.d = paramLong;
      if (QLog.isColorLevel())
      {
        paramConcurrentHashMap1 = new StringBuilder();
        paramConcurrentHashMap1.append("httpGetReached, getmsg ui is not ready!");
        paramConcurrentHashMap1.append(l1);
        paramConcurrentHashMap1.append(", msg = ");
        paramConcurrentHashMap1.append("[]");
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, paramConcurrentHashMap1.toString());
      }
      paramConcurrentHashMap.put(Long.valueOf(l1), paramString);
      this.a.b(this.k, paramLong, l1, "[]");
      return;
    }
    paramString = new MsgBackupReportData.ServerFileDetail();
    paramString.a = false;
    paramString.b = 0L;
    MsgBackupManager.a().m.put(Long.valueOf(l1), paramString);
    paramString = (String)((Map)localObject1).get("chatUin");
    int i2 = Integer.parseInt((String)((Map)localObject1).get("chatType"));
    localObject1 = MsgBackupUtil.a(paramString, i2, null);
    ??? = new MsgBackupSessionTask();
    ((MsgBackupSessionTask)???).g = 0;
    ((MsgBackupSessionTask)???).c = true;
    ((MsgBackupSessionTask)???).d = paramLong;
    ((MsgBackupSessionTask)???).e = ((String)localObject1);
    paramConcurrentHashMap.put(Long.valueOf(l1), ???);
    synchronized (this.s)
    {
      paramConcurrentHashMap1 = paramConcurrentHashMap1.values().iterator();
      while (paramConcurrentHashMap1.hasNext()) {
        if (((MsgBackupSessionInfo)paramConcurrentHashMap1.next()).g) {
          i1 += 1;
        }
      }
      paramConcurrentHashMap1 = this.u;
      if (paramConcurrentHashMap1 != null) {
        paramConcurrentHashMap1.a(i1, MsgBackupManager.i);
      }
      this.a.a(this.k, paramLong, l1, (String)localObject1);
      if (QLog.isColorLevel())
      {
        paramConcurrentHashMap1 = new StringBuilder();
        paramConcurrentHashMap1.append("onHttpRequest, send db uin = ");
        paramConcurrentHashMap1.append(paramString);
        paramConcurrentHashMap1.append(", uinType = ");
        paramConcurrentHashMap1.append(MsgBackupUtil.c(i2));
        paramConcurrentHashMap1.append(", dbpath = ");
        paramConcurrentHashMap1.append((String)localObject1);
        paramConcurrentHashMap1.append(", fid = ");
        paramConcurrentHashMap1.append(l1);
        paramConcurrentHashMap1.append(", mFidMList.size = ");
        paramConcurrentHashMap1.append(paramConcurrentHashMap.size());
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, paramConcurrentHashMap1.toString());
      }
      return;
    }
    for (;;)
    {
      throw paramString;
    }
  }
  
  private void b(long paramLong, ConcurrentHashMap<String, MsgBackupSessionInfo> paramConcurrentHashMap, MsgBackupSessionInfo arg4, ConcurrentHashMap<Long, MsgBackupSessionTask> paramConcurrentHashMap1, ConcurrentHashMap<Long, MsgBackupSessionTask> paramConcurrentHashMap2, MsgBackupSessionTask paramMsgBackupSessionTask)
  {
    paramConcurrentHashMap2.remove(Long.valueOf(paramLong));
    int i1 = paramConcurrentHashMap2.size();
    int i2 = paramConcurrentHashMap1.size();
    if (QLog.isColorLevel())
    {
      paramConcurrentHashMap1 = new StringBuilder();
      paramConcurrentHashMap1.append("ResReq receivedCompleted  called success, isResRequestAllFinished ");
      paramConcurrentHashMap1.append(???.h.get());
      paramConcurrentHashMap1.append(", task = ");
      paramConcurrentHashMap1.append(paramMsgBackupSessionTask);
      paramConcurrentHashMap1.append(", resMList.size = ");
      paramConcurrentHashMap1.append(i1);
      QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, paramConcurrentHashMap1.toString());
    }
    if ((i1 == 0) && (i2 == 0) && (???.h.get()))
    {
      ???.g = true;
      a(???);
      if (QLog.isColorLevel())
      {
        ??? = new StringBuilder();
        ???.append("last session transport completed!, uin = ");
        ???.append(MsgBackupManager.o);
        ???.append(", uintype = ");
        ???.append(MsgBackupManager.p);
        ???.append(", task = ");
        ???.append(paramMsgBackupSessionTask);
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, ???.toString());
      }
      if (QLog.isColorLevel())
      {
        ??? = new StringBuilder();
        ???.append("mclient will get db mClientCanRecvMList.size = ");
        ???.append(paramConcurrentHashMap.size());
        QLog.d("MsgBackup", 2, ???.toString());
      }
      synchronized (this.s)
      {
        paramConcurrentHashMap = paramConcurrentHashMap.values().iterator();
        i1 = 0;
        while (paramConcurrentHashMap.hasNext()) {
          if (((MsgBackupSessionInfo)paramConcurrentHashMap.next()).g) {
            i1 += 1;
          }
        }
        paramConcurrentHashMap = this.u;
        if (paramConcurrentHashMap != null) {
          paramConcurrentHashMap.a(i1, MsgBackupManager.i);
        }
        if (i1 == MsgBackupManager.i) {
          return;
        }
        if (!k(2))
        {
          MsgBackupUtil.b("this session res has received! so get next session!", new Object[0]);
          j(3);
          return;
        }
      }
    }
  }
  
  private void b(String paramString1, int paramInt1, int paramInt2, String paramString2, long paramLong)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("recvMessageUdp udpdetected = ");
      localStringBuilder.append(this.p);
      localStringBuilder.append(", ip = ");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(", port = ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(", cmd = ");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(", cookie = ");
      localStringBuilder.append(paramLong);
      localStringBuilder.append(", data = ");
      localStringBuilder.append(paramString2);
      QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, localStringBuilder.toString());
    }
    if (paramInt2 == 256) {
      return;
    }
    if (paramInt2 == 257)
    {
      h(paramString2);
      return;
    }
    if (paramInt2 == 258)
    {
      g(paramString2);
      return;
    }
    if (paramInt2 == 259) {
      f(paramString2);
    }
  }
  
  private boolean b(long paramLong, ConcurrentHashMap<Long, MsgBackupSessionTask> paramConcurrentHashMap, Map<String, String> paramMap)
  {
    if (!MsgBackupManager.v)
    {
      long l1 = Long.parseLong((String)paramMap.get("fid"));
      paramMap = new MsgBackupSessionTask();
      paramMap.g = 0;
      paramMap.c = false;
      paramMap.a = "[]";
      paramMap.d = paramLong;
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("httpGetReached, postinfo ui is not ready!");
        localStringBuilder.append(l1);
        localStringBuilder.append(", msg = ");
        localStringBuilder.append("[]");
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, localStringBuilder.toString());
      }
      paramConcurrentHashMap.put(Long.valueOf(l1), paramMap);
      this.a.b(this.k, paramLong, l1, "[]");
      return true;
    }
    return false;
  }
  
  private void c(long paramLong, String paramString, ConcurrentHashMap<Long, MsgBackupSessionTask> paramConcurrentHashMap, ConcurrentHashMap<String, MsgBackupSessionInfo> paramConcurrentHashMap1)
  {
    if (j())
    {
      MsgBackupUtil.b("httpGetReached postinfo operator is closed! please clear handler msg!........", new Object[0]);
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("httpGetReached success, url = ");
      localStringBuilder.append(paramString);
      QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, localStringBuilder.toString());
    }
    paramString = MsgBackupUtil.c(paramString);
    if (b(paramLong, paramConcurrentHashMap, paramString)) {
      return;
    }
    if (paramString.size() == 1)
    {
      a(paramLong, paramConcurrentHashMap, paramString);
      return;
    }
    if (!TextUtils.isEmpty((CharSequence)paramString.get("exit")))
    {
      d(paramLong, paramConcurrentHashMap, paramString);
      return;
    }
    if (paramString.size() == 4)
    {
      c(paramLong, paramConcurrentHashMap, paramString);
      return;
    }
    a(paramLong, paramConcurrentHashMap, paramConcurrentHashMap1, paramString);
  }
  
  private void c(long paramLong, ConcurrentHashMap<Long, MsgBackupSessionTask> paramConcurrentHashMap, Map<String, String> paramMap)
  {
    if (j())
    {
      MsgBackupUtil.b("httpGetReached postinfo operator is closed! please clear handler msg!........", new Object[0]);
      return;
    }
    long l1 = Long.parseLong((String)paramMap.get("fid"));
    if (this.e.intValue() != 0)
    {
      this.d[0] = ((String)paramMap.get("ip"));
      this.e = Integer.valueOf(Integer.parseInt((String)paramMap.get("udpport")));
    }
    if (this.f.intValue() != 0)
    {
      this.d[0] = ((String)paramMap.get("ip"));
      this.f = Integer.valueOf(Integer.parseInt((String)paramMap.get("tcpport")));
    }
    if (QLog.isColorLevel())
    {
      paramMap = new StringBuilder();
      paramMap.append("httpGetReached, client report its port and ipv4, fid = ");
      paramMap.append(l1);
      paramMap.append(", msg = []");
      QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, paramMap.toString());
    }
    a(paramLong, paramConcurrentHashMap, l1, a(l1, 2));
  }
  
  private int d(ConcurrentHashMap<String, MsgBackupSessionInfo> paramConcurrentHashMap)
  {
    paramConcurrentHashMap = paramConcurrentHashMap.values().iterator();
    int i1 = 0;
    while (paramConcurrentHashMap.hasNext()) {
      if (((MsgBackupSessionInfo)paramConcurrentHashMap.next()).g) {
        i1 += 1;
      }
    }
    return i1;
  }
  
  private void d(long paramLong, ConcurrentHashMap<Long, MsgBackupSessionTask> paramConcurrentHashMap, Map<String, String> paramMap)
  {
    if (j())
    {
      MsgBackupUtil.b("httpGetReached postinfo operator is closed! please clear handler msg!........", new Object[0]);
      return;
    }
    long l1 = Long.parseLong((String)paramMap.get("fid"));
    if (!TextUtils.isEmpty((String)paramMap.get("exit")))
    {
      paramMap = this.u;
      if (paramMap != null) {
        paramMap.m_(true);
      }
    }
    paramMap = new MsgBackupSessionTask();
    paramMap.g = 0;
    paramMap.c = false;
    paramMap.a = "[]";
    paramMap.d = paramLong;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("httpGetReached, notify has exit!, fid = ");
      localStringBuilder.append(l1);
      localStringBuilder.append(", msg = ");
      localStringBuilder.append("[]");
      QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, localStringBuilder.toString());
    }
    paramConcurrentHashMap.put(Long.valueOf(l1), paramMap);
    this.a.b(this.k, paramLong, l1, "[]");
  }
  
  private void f(String paramString)
  {
    try
    {
      paramString = new JSONArray(paramString);
      if (paramString.length() == 1)
      {
        paramString = (JSONObject)paramString.get(0);
        if ("exit".equals(paramString.optString("cmd")))
        {
          paramString = paramString.optString("sig");
          if (QLog.isColorLevel()) {
            QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "-------------------exit-------------------");
          }
          if ((TextUtils.equals(paramString, MsgBackupAuthProcessor.a().d())) && (this.u != null))
          {
            this.u.m_(true);
            return;
          }
        }
      }
    }
    catch (JSONException paramString)
    {
      QLog.e("MsgBackup_MsgBackupTransportProcessor", 2, "MBR_UDP_CMD_EXIT parse json error!", paramString);
    }
  }
  
  private void g(String arg1)
  {
    for (;;)
    {
      int i1;
      try
      {
        Object localObject1 = MsgBackupManager.a().j;
        ??? = new JSONArray(???);
        i1 = ???.length();
        int i2 = 0;
        if (i1 >= 1)
        {
          i1 = 0;
          if (i1 < ???.length())
          {
            Object localObject3 = (JSONObject)???.get(i1);
            ((JSONObject)localObject3).optString("cmd");
            String str = ((JSONObject)localObject3).optString("chatUin");
            int i3 = ((JSONObject)localObject3).optInt("chatType");
            Object localObject4 = MsgBackupUtil.b(str, i3);
            localObject3 = (MsgBackupSessionInfo)((ConcurrentHashMap)localObject1).get(localObject4);
            if (QLog.isColorLevel())
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("client notify this session has received success! keyFromUin = ");
              localStringBuilder.append((String)localObject4);
              localStringBuilder.append(", mMList = ");
              localStringBuilder.append(localObject1);
              QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, localStringBuilder.toString());
            }
            if (localObject3 != null)
            {
              if (QLog.isColorLevel())
              {
                localObject4 = new StringBuilder();
                ((StringBuilder)localObject4).append("udp 通知 此会话接受完成 chatUin = ");
                ((StringBuilder)localObject4).append(str);
                ((StringBuilder)localObject4).append(", uinType = ");
                ((StringBuilder)localObject4).append(MsgBackupUtil.c(i3));
                QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, ((StringBuilder)localObject4).toString());
              }
              ((MsgBackupSessionInfo)localObject3).g = true;
              break label392;
            }
            if (!QLog.isColorLevel()) {
              break label392;
            }
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("client notify this session has received success! chatUin = ");
            ((StringBuilder)localObject3).append(str);
            ((StringBuilder)localObject3).append(", chatType = ");
            ((StringBuilder)localObject3).append(i3);
            QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, ((StringBuilder)localObject3).toString());
            break label392;
          }
        }
        synchronized (this.s)
        {
          localObject1 = ((ConcurrentHashMap)localObject1).values().iterator();
          i1 = i2;
          if (((Iterator)localObject1).hasNext())
          {
            if (!((MsgBackupSessionInfo)((Iterator)localObject1).next()).g) {
              continue;
            }
            i1 += 1;
            continue;
          }
          if (this.u != null)
          {
            this.u.a(i1, MsgBackupManager.i);
            return;
          }
        }
        return;
      }
      catch (JSONException ???)
      {
        QLog.e("MsgBackup_MsgBackupTransportProcessor", 2, "MBR_UDP_CMD_SYNC_RECV_DONE parse json error!", ???);
      }
      label392:
      i1 += 1;
    }
  }
  
  private void h(String paramString)
  {
    for (;;)
    {
      int i1;
      try
      {
        ConcurrentHashMap localConcurrentHashMap = MsgBackupManager.a().k;
        paramString = new JSONArray(paramString);
        if (paramString.length() >= 1)
        {
          i1 = 0;
          if (i1 < paramString.length())
          {
            Object localObject = (JSONObject)paramString.get(i1);
            String str = ((JSONObject)localObject).optString("cmd");
            if ("chat_list_count".equals(str))
            {
              MsgBackupManager.i = ((JSONObject)localObject).optInt("listCount");
              MsgBackupReporter.a();
              MsgBackupReporter.a.g = MsgBackupManager.i;
            }
            if (!"chat_ready".equals(str)) {
              break label220;
            }
            str = ((JSONObject)localObject).optString("chatUin");
            int i2 = ((JSONObject)localObject).optInt("chatType");
            long l1 = ((JSONObject)localObject).optLong("dbSize");
            localObject = new MsgBackupSessionInfo();
            ((MsgBackupSessionInfo)localObject).g = false;
            ((MsgBackupSessionInfo)localObject).f = false;
            ((MsgBackupSessionInfo)localObject).a = str;
            ((MsgBackupSessionInfo)localObject).b = MsgBackupUtil.c(i2);
            ((MsgBackupSessionInfo)localObject).d = l1;
            str = MsgBackupUtil.b(((MsgBackupSessionInfo)localObject).a, i2);
            if (localConcurrentHashMap.get(str) != null) {
              break label220;
            }
            localConcurrentHashMap.put(str, localObject);
            break label220;
          }
          k(3);
          return;
        }
      }
      catch (JSONException paramString)
      {
        QLog.e("MsgBackup_MsgBackupTransportProcessor", 2, "MBR_UDP_CMD_SYNC_RECV_DONE parse json error!", paramString);
      }
      return;
      label220:
      i1 += 1;
    }
  }
  
  private void p()
  {
    this.a.stop(this.k);
    this.a.destroySession(this.k);
    this.k = 0L;
    MsgBackupTransportExecutor.a().b();
  }
  
  private String q()
  {
    JSONArray localJSONArray = new JSONArray();
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("cmd", "exit");
      localJSONObject.put("sig", MsgBackupAuthProcessor.a().d());
      localJSONArray.put(localJSONObject);
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return localJSONArray.toString();
  }
  
  public String a(int paramInt, long paramLong)
  {
    Object localObject1 = new JSONArray();
    if ((paramInt == 256) || (paramInt == 257)) {}
    for (;;)
    {
      try
      {
        if (!MsgBackupManager.v)
        {
          localObject1 = ((JSONArray)localObject1).toString();
          ??? = MsgBackupManager.a().q;
          localObject4 = new MsgBackupSessionTask();
          ((MsgBackupSessionTask)localObject4).a = ((String)localObject1);
          ((MsgBackupSessionTask)localObject4).b = paramInt;
          ((MsgBackupSessionTask)localObject4).g = 0;
          ((ConcurrentHashMap)???).put(Long.valueOf(paramLong), localObject4);
          if (!QLog.isColorLevel()) {
            continue;
          }
          ??? = new StringBuilder();
          ((StringBuilder)???).append("MsgBackupManager.sUIReady = ");
          ((StringBuilder)???).append(MsgBackupManager.v);
          ((StringBuilder)???).append(", getSessionJson is called! cookie = ");
          ((StringBuilder)???).append(paramLong);
          ((StringBuilder)???).append(", msg = ");
          ((StringBuilder)???).append((String)localObject1);
          QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, ((StringBuilder)???).toString());
          return localObject1;
        }
        ??? = MsgBackupManager.a().h;
        Object localObject4 = MsgBackupManager.a().j;
        i1 = MsgBackupManager.i;
        if (((ConcurrentHashMap)localObject4).size() > 0)
        {
          ??? = new JSONObject();
          ((JSONObject)???).put("cmd", "chat_list_count");
          ((JSONObject)???).put("listCount", i1);
          ((JSONArray)localObject1).put(???);
          Object localObject5;
          Object localObject6;
          synchronized (this.s)
          {
            localObject4 = ((ConcurrentHashMap)localObject4).values().iterator();
            i2 = 0;
            if (((Iterator)localObject4).hasNext())
            {
              localObject5 = (MsgBackupSessionInfo)((Iterator)localObject4).next();
              i1 = i2;
              if (((MsgBackupSessionInfo)localObject5).g) {
                i1 = i2 + 1;
              }
              if (((MsgBackupSessionInfo)localObject5).e) {
                continue;
              }
              localObject6 = ((MsgBackupSessionInfo)localObject5).a;
              i2 = ((MsgBackupSessionInfo)localObject5).b;
              JSONObject localJSONObject = new JSONObject();
              localJSONObject.put("cmd", "chat_ready");
              localJSONObject.put("chatUin", localObject6);
              localJSONObject.put("chatType", MsgBackupUtil.b(i2));
              localJSONObject.put("dbSize", ((MsgBackupSessionInfo)localObject5).d);
              ((JSONArray)localObject1).put(localJSONObject);
              ((MsgBackupSessionInfo)localObject5).e = true;
              continue;
            }
            if (this.u == null) {
              continue;
            }
            this.u.a(i2, MsgBackupManager.i);
          }
          if (paramInt == 258)
          {
            ??? = MsgBackupManager.a().k.values().iterator();
            if (((Iterator)???).hasNext())
            {
              localObject4 = (MsgBackupSessionInfo)((Iterator)???).next();
              if ((((MsgBackupSessionInfo)localObject4).i) || (!((MsgBackupSessionInfo)localObject4).g)) {
                continue;
              }
              localObject5 = ((MsgBackupSessionInfo)localObject4).a;
              i1 = ((MsgBackupSessionInfo)localObject4).b;
              localObject6 = new JSONObject();
              ((JSONObject)localObject6).put("cmd", "chat_transfer_complete");
              ((JSONObject)localObject6).put("chatUin", localObject5);
              ((JSONObject)localObject6).put("chatType", MsgBackupUtil.b(i1));
              localObject2.put(localObject6);
              ((MsgBackupSessionInfo)localObject4).i = true;
              continue;
            }
          }
          else if (paramInt == 259)
          {
            ??? = new JSONObject();
            ((JSONObject)???).put("cmd", "exit");
            ((JSONObject)???).put("sig", MsgBackupAuthProcessor.a().d());
            localObject2.put(???);
          }
        }
        str = localObject2.toString();
        ??? = MsgBackupManager.a().q;
        localObject4 = new MsgBackupSessionTask();
        ((MsgBackupSessionTask)localObject4).a = str;
        ((MsgBackupSessionTask)localObject4).b = paramInt;
        ((MsgBackupSessionTask)localObject4).g = 0;
        ((ConcurrentHashMap)???).put(Long.valueOf(paramLong), localObject4);
        if (QLog.isColorLevel())
        {
          ??? = new StringBuilder();
          ((StringBuilder)???).append("getSessionJson, cookie = ");
          ((StringBuilder)???).append(paramLong);
          ((StringBuilder)???).append(", msg = ");
          ((StringBuilder)???).append(str);
          QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, ((StringBuilder)???).toString());
        }
        return str;
      }
      catch (JSONException localJSONException)
      {
        int i1;
        int i2;
        String str;
        continue;
      }
      str.printStackTrace();
      return "[]";
      return str;
      i2 = i1;
    }
  }
  
  public void a(int paramInt)
  {
    this.e = Integer.valueOf(paramInt);
  }
  
  public void a(long paramLong1, long paramLong2, long paramLong3)
  {
    MsgBackupTimeStats.a(paramLong1, paramLong2);
    if (this.n > 0L)
    {
      paramLong2 = SystemClock.elapsedRealtime() - this.n;
      if (paramLong2 > 1500L)
      {
        long l1 = this.o;
        IMsgBackupUICallback localIMsgBackupUICallback = this.u;
        if (localIMsgBackupUICallback != null)
        {
          paramLong2 = (paramLong3 + l1) * 1000L / paramLong2;
          localIMsgBackupUICallback.a(paramLong2);
          MsgBackupTimeStats.b(paramLong1, paramLong2);
        }
        this.o = 0L;
        this.n = SystemClock.elapsedRealtime();
        return;
      }
      this.o += paramLong3;
      return;
    }
    this.n = SystemClock.elapsedRealtime();
    this.o += paramLong3;
  }
  
  public void a(long paramLong, String paramString1, int paramInt, String paramString2)
  {
    if (this.c == 2) {
      b(paramLong, paramString1, paramInt, paramString2);
    }
  }
  
  public void a(long paramLong1, String paramString1, int paramInt1, String paramString2, byte[] paramArrayOfByte, int paramInt2, int paramInt3, long paramLong2)
  {
    MsgBackupUtil.b("MsgBackup_MsgBackupTransportProcessor", "onRecvComplete from jni fid = %d,url = %s,errcode = %d,path = %s ", new Object[] { Long.valueOf(paramLong1), paramString1, Integer.valueOf(paramInt1), paramString2 });
    MsgBackupTimeStats.a(paramLong1);
    b(paramLong1, paramString1, paramInt1, paramString2, paramArrayOfByte, paramInt2, paramInt3, paramLong2);
  }
  
  public void a(long paramLong1, String paramString, long paramLong2, long paramLong3, int paramInt1, long paramLong4, int paramInt2, int paramInt3, long paramLong5)
  {
    MsgBackupTimeStats.a(paramLong1, paramLong3);
    MsgBackupReporter.a();
    if (MsgBackupManager.a().n.containsKey(Long.valueOf(paramLong1)))
    {
      paramString = (MsgBackupReportData.ServerFileDetail)MsgBackupManager.a().n.get(Long.valueOf(paramLong1));
      if ((paramString != null) && (!paramString.a))
      {
        paramString.a = true;
        paramString.b = paramLong3;
        paramString = MsgBackupReporter.a;
        paramString.j += paramLong3;
      }
    }
    else if (MsgBackupManager.a().m.containsKey(Long.valueOf(paramLong1)))
    {
      paramString = (MsgBackupReportData.ServerFileDetail)MsgBackupManager.a().m.get(Long.valueOf(paramLong1));
      if ((paramString != null) && (!paramString.a))
      {
        paramString.a = true;
        paramString.b = paramLong3;
        paramString = MsgBackupReporter.a;
        paramString.k += paramLong3;
      }
    }
    if (this.n > 0L)
    {
      paramLong2 = SystemClock.elapsedRealtime() - this.n;
      if (paramLong2 > 1500L)
      {
        paramLong3 = this.o;
        paramString = this.u;
        if (paramString != null)
        {
          paramLong2 = (paramLong4 + paramLong3) * 1000L / paramLong2;
          paramString.a(paramLong2);
          MsgBackupTimeStats.b(paramLong1, paramLong2);
        }
        this.o = 0L;
        this.n = SystemClock.elapsedRealtime();
        return;
      }
      this.o += paramLong4;
      return;
    }
    this.n = SystemClock.elapsedRealtime();
    this.o += paramLong4;
  }
  
  public void a(long paramLong1, String paramString, long paramLong2, long paramLong3, long paramLong4) {}
  
  public void a(long paramLong1, boolean paramBoolean, int paramInt1, String paramString, int paramInt2, int paramInt3, long paramLong2)
  {
    MsgBackupTimeStats.a(paramLong1);
    MsgBackupReporter.a();
    if (MsgBackupManager.a().n.containsKey(Long.valueOf(paramLong1)))
    {
      localObject = (MsgBackupReportData.ServerFileDetail)MsgBackupManager.a().n.get(Long.valueOf(paramLong1));
      if (localObject != null)
      {
        boolean bool = MsgBackupUtil.b(((MsgBackupReportData.ServerFileDetail)localObject).b);
        if (bool)
        {
          localObject = MsgBackupReporter.a;
          ((MsgBackupReportData)localObject).o += 1L;
        }
        if (!paramBoolean)
        {
          localObject = MsgBackupReporter.a;
          ((MsgBackupReportData)localObject).y += 1L;
          localObject = new MsgBackupReportData.FileError();
          ((MsgBackupReportData.FileError)localObject).b = 2;
          if (bool) {
            paramInt2 = 2;
          } else {
            paramInt2 = 1;
          }
          ((MsgBackupReportData.FileError)localObject).c = paramInt2;
          ((MsgBackupReportData.FileError)localObject).a = paramInt1;
          MsgBackupReporter.a.z.add(localObject);
          if (bool)
          {
            localObject = MsgBackupReporter.a;
            ((MsgBackupReportData)localObject).p += 1L;
          }
        }
      }
      MsgBackupManager.a().n.remove(Long.valueOf(paramLong1));
    }
    else if (MsgBackupManager.a().m.containsKey(Long.valueOf(paramLong1)))
    {
      if ((MsgBackupReportData.ServerFileDetail)MsgBackupManager.a().m.get(Long.valueOf(paramLong1)) != null)
      {
        localObject = MsgBackupReporter.a;
        ((MsgBackupReportData)localObject).r += 1L;
        if (!paramBoolean)
        {
          localObject = MsgBackupReporter.a;
          ((MsgBackupReportData)localObject).s += 1L;
          localObject = MsgBackupReporter.a;
          ((MsgBackupReportData)localObject).y += 1L;
          localObject = new MsgBackupReportData.FileError();
          ((MsgBackupReportData.FileError)localObject).b = 1;
          ((MsgBackupReportData.FileError)localObject).c = 0;
          ((MsgBackupReportData.FileError)localObject).a = paramInt1;
          MsgBackupReporter.a.z.add(localObject);
        }
      }
      MsgBackupManager.a().m.remove(Long.valueOf(paramLong1));
    }
    Object localObject = MsgBackupManager.a().r;
    MsgBackupSessionTask localMsgBackupSessionTask = (MsgBackupSessionTask)((ConcurrentHashMap)localObject).get(Long.valueOf(paramLong1));
    if (localMsgBackupSessionTask != null)
    {
      if (paramBoolean)
      {
        ((ConcurrentHashMap)localObject).remove(Long.valueOf(paramLong1));
        if (QLog.isColorLevel())
        {
          paramString = new StringBuilder();
          paramString.append("onSendComplete  task = ");
          paramString.append(localMsgBackupSessionTask);
          paramString.append(", mFidMList.size = ");
          paramString.append(((ConcurrentHashMap)localObject).size());
          QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, paramString.toString());
        }
      }
      else if (localMsgBackupSessionTask.c)
      {
        if (QLog.isColorLevel())
        {
          paramString = new StringBuilder();
          paramString.append("fileTask onSendComplete  called not success, so again  task = ");
          paramString.append(localMsgBackupSessionTask);
          QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, paramString.toString());
        }
        if (!TextUtils.isEmpty(localMsgBackupSessionTask.e))
        {
          if (localMsgBackupSessionTask.g > 3)
          {
            paramString = new StringBuilder();
            paramString.append("onSendComplete fileTask  retry over time task = ");
            paramString.append(localMsgBackupSessionTask);
            QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, paramString.toString());
            ((ConcurrentHashMap)localObject).remove(Long.valueOf(paramLong1));
            return;
          }
          if (j())
          {
            MsgBackupUtil.b("fileTask onSendComplete operator is closed! please clear handler msg!........", new Object[0]);
            return;
          }
          localMsgBackupSessionTask.g = ((short)(localMsgBackupSessionTask.g + 1));
          this.a.a(this.k, localMsgBackupSessionTask.d, paramLong1, localMsgBackupSessionTask.e);
        }
      }
      else
      {
        if (QLog.isColorLevel())
        {
          paramString = new StringBuilder();
          paramString.append("onSendComplete  called not success, so again task = ");
          paramString.append(localMsgBackupSessionTask);
          QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, paramString.toString());
        }
        if (!TextUtils.isEmpty(localMsgBackupSessionTask.a))
        {
          if (localMsgBackupSessionTask.g > 3)
          {
            paramString = new StringBuilder();
            paramString.append("onSendComplete retry over time task = ");
            paramString.append(localMsgBackupSessionTask);
            QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, paramString.toString());
            ((ConcurrentHashMap)localObject).remove(Long.valueOf(paramLong1));
            return;
          }
          if (j())
          {
            MsgBackupUtil.b("onSendComplete operator is closed! please clear handler msg!........", new Object[0]);
            return;
          }
          localMsgBackupSessionTask.g = ((short)(localMsgBackupSessionTask.g + 1));
          this.a.b(this.k, localMsgBackupSessionTask.d, paramLong1, localMsgBackupSessionTask.a);
        }
      }
    }
    else if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onSendComplete  called, please check your mFidMList whether contains this task, before execute, should add in mFidMList!, path = ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(", fid = ");
      ((StringBuilder)localObject).append(paramLong1);
      QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void a(long paramLong, boolean paramBoolean, String paramString, int paramInt)
  {
    if ((this.i.intValue() != 0) && (this.h.intValue() != 0))
    {
      if ((this.c == 1) && (this.q))
      {
        if (j())
        {
          MsgBackupUtil.b("requestNotifyServer called------>MBRROLE_CLIENT  operator is closed! please clear handler msg!........", new Object[0]);
          return;
        }
        Object localObject;
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("requestNotifyServer, isTcpDetected = ");
          ((StringBuilder)localObject).append(this.q);
          QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, ((StringBuilder)localObject).toString());
        }
        long l1 = MsgBackupUtil.a();
        if (!TextUtils.isEmpty(paramString))
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("postinfo?fid=");
          ((StringBuilder)localObject).append(l1);
          ((StringBuilder)localObject).append("&chatUin=");
          ((StringBuilder)localObject).append(paramString);
          ((StringBuilder)localObject).append("&chatType=");
          ((StringBuilder)localObject).append(MsgBackupUtil.b(paramInt));
          paramString = ((StringBuilder)localObject).toString();
          MsgBackupUtil.b("MsgBackup_MsgBackupTransportProcessor", paramString, new Object[0]);
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(MsgBackupUtil.a(this.g[0], this.i.intValue()));
          ((StringBuilder)localObject).append(MsgBackupUtil.b(paramString, this.j));
          paramString = ((StringBuilder)localObject).toString();
        }
        for (;;)
        {
          break;
          if (paramBoolean)
          {
            paramString = new StringBuilder();
            paramString.append("postinfo?fid=");
            paramString.append(l1);
            paramString.append("&ip=");
            paramString.append(this.d[0]);
            paramString.append("&tcpport=");
            paramString.append(this.f);
            paramString.append("&udpport=");
            paramString.append(this.e);
            paramString = paramString.toString();
            MsgBackupUtil.b("MsgBackup_MsgBackupTransportProcessor", paramString, new Object[0]);
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(MsgBackupUtil.a(this.g[0], this.i.intValue()));
            ((StringBuilder)localObject).append(MsgBackupUtil.b(paramString, this.j));
            paramString = ((StringBuilder)localObject).toString();
          }
          else
          {
            paramString = new StringBuilder();
            paramString.append("postinfo?fid=");
            paramString.append(l1);
            paramString = paramString.toString();
            MsgBackupUtil.b("MsgBackup_MsgBackupTransportProcessor", paramString, new Object[0]);
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(MsgBackupUtil.a(this.g[0], this.i.intValue()));
            ((StringBuilder)localObject).append(MsgBackupUtil.b(paramString, this.j));
            paramString = ((StringBuilder)localObject).toString();
          }
        }
        if ((!TextUtils.isEmpty(paramString)) && (this.a != null))
        {
          localObject = new MsgBackupSessionTask();
          ((MsgBackupSessionTask)localObject).g = 0;
          ((MsgBackupSessionTask)localObject).c = false;
          ((MsgBackupSessionTask)localObject).f = paramString;
          MsgBackupManager.a().r.put(Long.valueOf(l1), localObject);
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("requestNotifyServer fid = ");
            ((StringBuilder)localObject).append(l1);
            ((StringBuilder)localObject).append(", url = ");
            ((StringBuilder)localObject).append(paramString);
            QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, ((StringBuilder)localObject).toString());
          }
          this.a.a(paramLong, l1, paramString);
        }
      }
      else
      {
        MsgBackupUtil.b("MsgBackup_MsgBackupTransportProcessor", "requestNotifyServer is called error!", new Object[0]);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "requestNotifyServer server ip and port is not set! this method will be called in processConfirmRsp!");
    }
  }
  
  public void a(IMsgBackupUICallback paramIMsgBackupUICallback)
  {
    this.u = paramIMsgBackupUICallback;
  }
  
  public void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      MsgBackupManager.a().b();
      MsgBackupUtil.b();
      if (this.b == null) {
        this.b = new MsgBackupNotifier();
      }
      MsgBackupManager.a().k.clear();
      e(1);
      MsgBackupManager.a().k.clear();
      ThreadManager.getSubThreadHandler().post(new MsgBackupTransportProcessor.1(this, paramString));
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    int i1 = this.c;
    if (i1 == 1)
    {
      if (this.e.intValue() != 0) {
        this.e = Integer.valueOf(paramInt);
      }
    }
    else if ((i1 == 2) && (this.h.intValue() != 0)) {
      this.h = Integer.valueOf(paramInt);
    }
  }
  
  public void a(String paramString1, int paramInt1, int paramInt2, String paramString2, long paramLong)
  {
    b(paramString1, paramInt1, paramInt2, paramString2, paramLong);
  }
  
  public void a(String paramString1, int paramInt, String paramString2)
  {
    MsgBackupManager.a().b();
    MsgBackupUtil.b();
    MsgBackupManager.a().e().a(paramInt);
    MsgBackupManager.a().e().a(paramString2);
    MsgBackupManager.a().k.clear();
    e(1);
    if (paramInt == 1)
    {
      if (this.b == null) {
        this.b = new MsgBackupNotifier();
      }
      ThreadManager.getSubThreadHandler().post(new MsgBackupTransportProcessor.3(this, paramString1));
    }
    if (paramInt == 2)
    {
      if (this.b == null) {
        this.b = new MsgBackupNotifier();
      }
      ThreadManager.getSubThreadHandler().post(new MsgBackupTransportProcessor.4(this, paramString1));
    }
  }
  
  public void a(String paramString1, String paramString2, long paramLong)
  {
    if (j())
    {
      MsgBackupUtil.b("clientGetResFile called---> operator is closed! please clear handler msg!........", new Object[0]);
      return;
    }
    MsgBackupReporter.a();
    Object localObject1 = MsgBackupReporter.a;
    ((MsgBackupReportData)localObject1).l += 1L;
    localObject1 = MsgBackupManager.a().k;
    if ((paramString1 == null) && (paramString2 == null))
    {
      MsgBackupUtil.b("MsgBackup_MsgBackupTransportProcessor", "clientGetResFile MsgBackupManager.curDealUin = %s, MsgBackupManager.curDealType = %d", new Object[] { MsgBackupManager.o, Integer.valueOf(MsgBackupManager.p) });
      paramString1 = (MsgBackupSessionInfo)((ConcurrentHashMap)localObject1).get(MsgBackupUtil.b(MsgBackupManager.o, MsgBackupUtil.b(MsgBackupManager.p)));
      if (paramString1 != null)
      {
        MsgBackupUtil.b("MsgBackup_MsgBackupTransportProcessor", "clientGetResFile sessionInfo is not null reslist size = %d, dbsize = %d", new Object[] { Integer.valueOf(paramString1.j.size()), Integer.valueOf(paramString1.k.size()) });
        if ((paramString1.j.size() == 0) && (paramString1.k.size() == 0)) {
          k(6);
        }
        paramString1.h.set(true);
      }
      return;
    }
    new File(paramString2).getParentFile().mkdirs();
    long l1 = MsgBackupUtil.a();
    paramString1 = MsgBackupUtil.b(String.format("getres?fid=%d&filepath=%s", new Object[] { Long.valueOf(l1), paramString1 }), this.j);
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(MsgBackupUtil.a(this.g[0], this.i.intValue()));
    ((StringBuilder)localObject2).append(paramString1);
    paramString1 = ((StringBuilder)localObject2).toString();
    localObject2 = new MsgBackupSessionTask();
    ((MsgBackupSessionTask)localObject2).g = 0;
    ((MsgBackupSessionTask)localObject2).c = true;
    ((MsgBackupSessionTask)localObject2).e = paramString2;
    ((MsgBackupSessionTask)localObject2).f = paramString1;
    ((MsgBackupSessionTask)localObject2).h = MsgBackupUtil.b(paramLong);
    ((MsgBackupSessionTask)localObject2).i = paramLong;
    MsgBackupReportData localMsgBackupReportData = MsgBackupReporter.a;
    localMsgBackupReportData.j += paramLong;
    localObject1 = (MsgBackupSessionInfo)((ConcurrentHashMap)localObject1).get(MsgBackupUtil.b(MsgBackupManager.o, MsgBackupUtil.b(MsgBackupManager.p)));
    if (localObject1 != null) {
      ((MsgBackupSessionInfo)localObject1).j.put(Long.valueOf(l1), localObject2);
    }
    this.a.a(this.k, l1, paramString1, paramString2, ((MsgBackupSessionTask)localObject2).h, ((MsgBackupSessionTask)localObject2).i, true);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    MsgBackupManager.a().b();
    MsgBackupUtil.b();
    if (this.b == null) {
      this.b = new MsgBackupNotifier();
    }
    e(1);
    ThreadManager.getSubThreadHandler().post(new MsgBackupTransportProcessor.2(this, paramString, paramBoolean));
  }
  
  public void a(boolean paramBoolean)
  {
    this.p = paramBoolean;
    MsgBackupReporter.a();
    MsgBackupReporter.a.u = this.p;
  }
  
  public void a(boolean paramBoolean, long paramLong1, long paramLong2)
  {
    int i1 = this.c;
    Object localObject;
    MsgBackupSessionTask localMsgBackupSessionTask;
    StringBuilder localStringBuilder;
    if (2 == i1)
    {
      localObject = MsgBackupManager.a().q;
      localMsgBackupSessionTask = (MsgBackupSessionTask)((ConcurrentHashMap)localObject).get(Long.valueOf(paramLong1));
      if (localMsgBackupSessionTask != null)
      {
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("onSendMessage, success = ");
          localStringBuilder.append(paramBoolean);
          localStringBuilder.append(", cookie = ");
          localStringBuilder.append(paramLong1);
          localStringBuilder.append(", role = MBRROLE_SERVER");
          QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, localStringBuilder.toString());
        }
        if (paramBoolean)
        {
          ((ConcurrentHashMap)localObject).remove(Long.valueOf(paramLong1));
          return;
        }
        if (j())
        {
          if (QLog.isColorLevel()) {
            QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "onSendMessage role = MBRROLE_CLIENT: panic error!");
          }
          return;
        }
        if (localMsgBackupSessionTask.g > 3)
        {
          ((ConcurrentHashMap)localObject).remove(Long.valueOf(paramLong1));
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(" mfidMlist fileTask receivedCompleted retry over time task = ");
          ((StringBuilder)localObject).append(localMsgBackupSessionTask);
          QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, ((StringBuilder)localObject).toString());
          return;
        }
        localMsgBackupSessionTask.g = ((short)(localMsgBackupSessionTask.g + 1));
        localObject = localMsgBackupSessionTask.a;
        i1 = localMsgBackupSessionTask.b;
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("onSendMessage role = MBRROLE_CLIENT: ");
          localStringBuilder.append(localMsgBackupSessionTask);
          QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, localStringBuilder.toString());
        }
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          this.a.a(this.k, i1, (String)localObject, paramLong1);
        }
      }
    }
    else if (1 == i1)
    {
      localObject = MsgBackupManager.a().q;
      localMsgBackupSessionTask = (MsgBackupSessionTask)((ConcurrentHashMap)localObject).get(Long.valueOf(paramLong1));
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("onSendMessage, success = ");
        localStringBuilder.append(paramBoolean);
        localStringBuilder.append(", cookie = ");
        localStringBuilder.append(paramLong1);
        localStringBuilder.append(", role = MBRROLE_CLIENT");
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, localStringBuilder.toString());
      }
      if (localMsgBackupSessionTask != null)
      {
        if (paramBoolean)
        {
          ((ConcurrentHashMap)localObject).remove(Long.valueOf(paramLong1));
          return;
        }
        if (j())
        {
          if (QLog.isColorLevel()) {
            QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "onSendMessage role = MBRROLE_CLIENT: panic error!");
          }
          return;
        }
        if (localMsgBackupSessionTask.g > 3)
        {
          ((ConcurrentHashMap)localObject).remove(Long.valueOf(paramLong1));
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(" mfidMlist fileTask receivedCompleted retry over time task = ");
          ((StringBuilder)localObject).append(localMsgBackupSessionTask);
          QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, ((StringBuilder)localObject).toString());
          return;
        }
        localObject = localMsgBackupSessionTask.a;
        i1 = localMsgBackupSessionTask.b;
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("onSendMessage  role = MBRROLE_CLIENT: ");
          localStringBuilder.append(localMsgBackupSessionTask);
          QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, localStringBuilder.toString());
        }
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          this.a.a(this.k, i1, (String)localObject, paramLong1);
        }
      }
    }
  }
  
  protected boolean a(ConcurrentHashMap<String, MsgBackupSessionInfo> paramConcurrentHashMap)
  {
    Object localObject = (MsgBackupSessionInfo)paramConcurrentHashMap.get(MsgBackupUtil.b(MsgBackupManager.o, MsgBackupUtil.b(MsgBackupManager.p)));
    if (localObject != null)
    {
      if (((MsgBackupSessionInfo)localObject).g)
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(" requestNextSessionDb !, last uin = ");
          ((StringBuilder)localObject).append(MsgBackupManager.o);
          ((StringBuilder)localObject).append(", uintype = ");
          ((StringBuilder)localObject).append(MsgBackupManager.p);
          QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, ((StringBuilder)localObject).toString());
        }
        return a(paramConcurrentHashMap, false);
      }
      if (QLog.isColorLevel())
      {
        paramConcurrentHashMap = new StringBuilder();
        paramConcurrentHashMap.append("current session not completed! requestNextSessionDb !, current uin = ");
        paramConcurrentHashMap.append(MsgBackupManager.o);
        paramConcurrentHashMap.append(", uintype = ");
        paramConcurrentHashMap.append(MsgBackupManager.p);
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, paramConcurrentHashMap.toString());
      }
    }
    return false;
  }
  
  public void b()
  {
    this.p = false;
    this.q = false;
    this.n = 0L;
    this.o = 0L;
    this.l = false;
  }
  
  public void b(int paramInt)
  {
    this.f = Integer.valueOf(paramInt);
  }
  
  public void b(String paramString)
  {
    this.d[0] = paramString;
  }
  
  public void b(String paramString, int paramInt) {}
  
  public void b(boolean paramBoolean)
  {
    IMsgBackupUICallback localIMsgBackupUICallback = this.u;
    if (localIMsgBackupUICallback != null) {
      localIMsgBackupUICallback.m_(paramBoolean);
    }
  }
  
  protected boolean b(ConcurrentHashMap<String, MsgBackupSessionInfo> paramConcurrentHashMap)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(" requestNextSessionDb !, last uin = ");
      ((StringBuilder)localObject1).append(MsgBackupManager.o);
      ((StringBuilder)localObject1).append(", uintype = ");
      ((StringBuilder)localObject1).append(MsgBackupManager.p);
      QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject2 = paramConcurrentHashMap.values().iterator();
    do
    {
      do
      {
        do
        {
          boolean bool2 = ((Iterator)localObject2).hasNext();
          bool1 = false;
          if (!bool2) {
            break;
          }
          localObject1 = (MsgBackupSessionInfo)((Iterator)localObject2).next();
        } while (((MsgBackupSessionInfo)localObject1).f);
        if (((MsgBackupSessionInfo)localObject1).d > 0L) {
          break;
        }
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(" requestNextSessionDb !,  curDealUin  null! dbsize 等于 0 ！客户端不会去请求了，只是通知server端，该会话已经接受完成了！uin = ");
          localStringBuilder.append(((MsgBackupSessionInfo)localObject1).a);
          localStringBuilder.append(", uintype = ");
          localStringBuilder.append(((MsgBackupSessionInfo)localObject1).b);
          localStringBuilder.append(", dbSize = ");
          localStringBuilder.append(((MsgBackupSessionInfo)localObject1).d);
          QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, localStringBuilder.toString());
        }
        ((MsgBackupSessionInfo)localObject1).g = true;
        ((MsgBackupSessionInfo)localObject1).f = true;
        a((MsgBackupSessionInfo)localObject1);
      } while (this.u == null);
      i1 = d(paramConcurrentHashMap);
      localObject1 = this.u;
      if ((localObject1 != null) && (!this.l))
      {
        this.l = true;
        ((IMsgBackupUICallback)localObject1).c(true);
      }
      localObject1 = this.u;
      if (localObject1 != null) {
        ((IMsgBackupUICallback)localObject1).a(i1, MsgBackupManager.i);
      }
    } while ((i1 != MsgBackupManager.i) || (this.u == null));
    MsgBackupUtil.b("MsgBackup_MsgBackupTransportProcessor", "session transport completed! dbSize is 0------------->", new Object[0]);
    return false;
    ((MsgBackupSessionInfo)localObject1).f = true;
    MsgBackupManager.o = ((MsgBackupSessionInfo)localObject1).a;
    MsgBackupManager.p = ((MsgBackupSessionInfo)localObject1).b;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(" requestNextSessionDb !, uin = ");
      ((StringBuilder)localObject2).append(MsgBackupManager.o);
      ((StringBuilder)localObject2).append(", uintype = ");
      ((StringBuilder)localObject2).append(MsgBackupManager.p);
      ((StringBuilder)localObject2).append(", dbsize = ");
      ((StringBuilder)localObject2).append(((MsgBackupSessionInfo)localObject1).d);
      QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, ((StringBuilder)localObject2).toString());
    }
    int i1 = d(paramConcurrentHashMap);
    paramConcurrentHashMap = this.u;
    if ((paramConcurrentHashMap != null) && (!this.l))
    {
      this.l = true;
      paramConcurrentHashMap.c(true);
    }
    paramConcurrentHashMap = this.u;
    if (paramConcurrentHashMap != null) {
      paramConcurrentHashMap.a(i1, MsgBackupManager.i);
    }
    if (i1 == MsgBackupManager.i)
    {
      MsgBackupUtil.b("MsgBackup_MsgBackupTransportProcessor", "session transport completed!------------->", new Object[0]);
      return false;
    }
    a(this.k, ((MsgBackupSessionInfo)localObject1).a, ((MsgBackupSessionInfo)localObject1).b, false);
    boolean bool1 = true;
    return bool1;
  }
  
  public String c()
  {
    return this.d[0];
  }
  
  public void c(int paramInt)
  {
    this.h = Integer.valueOf(paramInt);
  }
  
  public void c(String paramString)
  {
    this.g[0] = paramString;
  }
  
  public void c(String paramString, int paramInt) {}
  
  protected void c(ConcurrentHashMap<String, MsgBackupSessionInfo> paramConcurrentHashMap)
  {
    if (!TextUtils.isEmpty(MsgBackupManager.o))
    {
      MsgBackupSessionInfo localMsgBackupSessionInfo = (MsgBackupSessionInfo)paramConcurrentHashMap.get(MsgBackupUtil.b(MsgBackupManager.o, MsgBackupUtil.b(MsgBackupManager.p)));
      if (localMsgBackupSessionInfo != null)
      {
        localMsgBackupSessionInfo.g = true;
        MsgBackupUtil.b("MsgBackup_MsgBackupTransportProcessor", "requestNextSessionDb MsgBackupController MsgBackupManager.curDealUin = %s, MsgBackupManager.curDealType = %d", new Object[] { MsgBackupManager.o, Integer.valueOf(MsgBackupManager.p) });
        a(localMsgBackupSessionInfo);
        if (this.u != null)
        {
          int i1 = d(paramConcurrentHashMap);
          paramConcurrentHashMap = this.u;
          if (paramConcurrentHashMap != null) {
            paramConcurrentHashMap.a(i1, MsgBackupManager.i);
          }
          if (i1 == MsgBackupManager.i) {
            paramConcurrentHashMap = this.u;
          }
        }
      }
    }
  }
  
  public int d()
  {
    return this.e.intValue();
  }
  
  public void d(int paramInt)
  {
    this.i = Integer.valueOf(paramInt);
  }
  
  public void d(String paramString)
  {
    this.j = paramString;
  }
  
  public void d(String paramString, int paramInt) {}
  
  public int e()
  {
    return this.f.intValue();
  }
  
  public String e(String paramString)
  {
    return MsgBackupUtil.a(paramString, this.g[0], this.i.intValue(), this.j);
  }
  
  public void e(int paramInt)
  {
    if ((this.a != null) && (!j()))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("stop called! operator = ");
        localStringBuilder.append(this.k);
        localStringBuilder.append(". from = ");
        localStringBuilder.append(paramInt);
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, localStringBuilder.toString());
      }
      MsgBackupManager.a().c();
      if (Looper.getMainLooper() == Looper.myLooper())
      {
        ThreadManager.getSubThreadHandler().post(new MsgBackupTransportProcessor.5(this));
        return;
      }
      p();
    }
  }
  
  public String f()
  {
    return this.g[0];
  }
  
  public void f(int paramInt)
  {
    if (j())
    {
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "setPeekPoint start panic error!");
      }
      return;
    }
    if (this.a != null)
    {
      StringBuilder localStringBuilder;
      if (paramInt == 2)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "setPeekPoint start for MBRROLE_SERVER");
        }
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("setPeekPoint clientIP = ");
        localStringBuilder.append(c());
        localStringBuilder.append(", clientUdpPort = ");
        localStringBuilder.append(this.e);
        localStringBuilder.append(", clientTcpPort = ");
        localStringBuilder.append(this.f);
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, localStringBuilder.toString());
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("setPeekPoint serverIP = ");
        localStringBuilder.append(f());
        localStringBuilder.append(", serverUdpPort = ");
        localStringBuilder.append(this.h);
        localStringBuilder.append(", serverTcpPort = ");
        localStringBuilder.append(this.i);
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, localStringBuilder.toString());
        this.a.setPeerEndpoint(this.k, this.d, this.e.intValue(), this.f.intValue());
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "setPeekPoint start for MBRROLE_CLIENT");
        }
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("setPeekPoint clientIP = ");
        localStringBuilder.append(c());
        localStringBuilder.append(", clientUdpPort = ");
        localStringBuilder.append(this.e);
        localStringBuilder.append(", clientTcpPort = ");
        localStringBuilder.append(this.f);
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, localStringBuilder.toString());
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("setPeekPoint serverIP = ");
        localStringBuilder.append(f());
        localStringBuilder.append(", serverUdpPort = ");
        localStringBuilder.append(this.h);
        localStringBuilder.append(", serverTcpPort = ");
        localStringBuilder.append(this.i);
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, localStringBuilder.toString());
        this.a.setPeerEndpoint(this.k, this.g, this.h.intValue(), this.i.intValue());
      }
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("setPeekPoint end， operator = ");
        localStringBuilder.append(this.k);
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, localStringBuilder.toString());
      }
    }
  }
  
  public int g()
  {
    return this.h.intValue();
  }
  
  public void g(int paramInt)
  {
    if (j())
    {
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "setEncryptKey panic error!");
      }
      return;
    }
    if (this.a != null)
    {
      if (paramInt == 2)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "setEncryptKey start for MBRROLE_SERVER");
        }
      }
      else if (QLog.isColorLevel()) {
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "setEncryptKey start for MBRROLE_CLIENT");
      }
      this.a.a(this.k, this.j);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("setEncryptKey end， session = ");
        localStringBuilder.append(this.k);
        localStringBuilder.append(", encryptkey = ");
        localStringBuilder.append(this.j);
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, localStringBuilder.toString());
      }
    }
  }
  
  public int h()
  {
    return this.i.intValue();
  }
  
  public void h(int paramInt)
  {
    if (paramInt != 0) {
      this.q = true;
    } else {
      this.q = false;
    }
    if (this.q) {
      MsgBackupTimeStats.a("cost_connect_total", null);
    }
    MsgBackupReporter.a();
    MsgBackupReporter.a.v = paramInt;
    IMsgBackupUICallback localIMsgBackupUICallback = this.u;
    if (localIMsgBackupUICallback != null) {
      localIMsgBackupUICallback.a(this.q);
    }
    if ((this.q) && (this.r))
    {
      this.r = false;
      MsgBackupUtil.b("MsgBackup_MsgBackupTransportProcessor", "tcp is disconnect!, before has cached this request msg, so request again!", new Object[0]);
      k(3);
    }
    j(2);
  }
  
  public int i()
  {
    return this.c;
  }
  
  public void i(int paramInt)
  {
    if (this.a != null)
    {
      Object localObject;
      if (this.p)
      {
        if (j())
        {
          if (QLog.isColorLevel()) {
            QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "sendMessageUdp panic error!");
          }
          return;
        }
        long l1 = MsgBackupUtil.a();
        localObject = a(paramInt, l1);
        this.a.a(this.k, paramInt, (String)localObject, l1);
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("sendMessageUdp udpdetected = ");
          ((StringBuilder)localObject).append(this.p);
          ((StringBuilder)localObject).append(", cmd = ");
          ((StringBuilder)localObject).append(paramInt);
          ((StringBuilder)localObject).append(", cookieIndex = ");
          ((StringBuilder)localObject).append(l1);
          QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, ((StringBuilder)localObject).toString());
        }
      }
      else if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("sendMessageUdp is error! please use tcp get! udpdetected = ");
        ((StringBuilder)localObject).append(this.p);
        ((StringBuilder)localObject).append(", cmd = ");
        ((StringBuilder)localObject).append(paramInt);
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  public void j(int paramInt)
  {
    if ((this.i.intValue() != 0) && (this.h.intValue() != 0))
    {
      if ((this.c == 1) && (this.q))
      {
        if (j())
        {
          MsgBackupUtil.b("requestSessionList called------>MBRROLE_CLIENT  operator is closed! please clear handler msg!........", new Object[0]);
          return;
        }
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("requestSessionList is called! isTcpDetected = ");
          ((StringBuilder)localObject1).append(this.q);
          ((StringBuilder)localObject1).append(", from = ");
          ((StringBuilder)localObject1).append(paramInt);
          QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, ((StringBuilder)localObject1).toString());
        }
        if (!this.m)
        {
          this.m = true;
          a(this.k, true, "", 0);
        }
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("requestSessionList, isTcpDetected = ");
          ((StringBuilder)localObject1).append(this.q);
          ((StringBuilder)localObject1).append(", client will get ready session list from server------>");
          QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, ((StringBuilder)localObject1).toString());
        }
        long l1 = MsgBackupUtil.a();
        Object localObject1 = MsgBackupUtil.a(this.g[0], this.i.intValue());
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("postinfo?fid=");
        ((StringBuilder)localObject2).append(l1);
        localObject2 = ((StringBuilder)localObject2).toString();
        MsgBackupUtil.b("MsgBackup_MsgBackupTransportProcessor", (String)localObject2, new Object[0]);
        localObject2 = MsgBackupUtil.b((String)localObject2, this.j);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append((String)localObject1);
        localStringBuilder.append((String)localObject2);
        localObject1 = localStringBuilder.toString();
        if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (this.a != null))
        {
          localObject2 = new MsgBackupSessionTask();
          ((MsgBackupSessionTask)localObject2).c = false;
          ((MsgBackupSessionTask)localObject2).g = 0;
          ((MsgBackupSessionTask)localObject2).f = ((String)localObject1);
          MsgBackupManager.a().r.put(Long.valueOf(l1), localObject2);
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("requestSessionList fid = ");
            ((StringBuilder)localObject2).append(l1);
            ((StringBuilder)localObject2).append(", url = ");
            ((StringBuilder)localObject2).append((String)localObject1);
            QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, ((StringBuilder)localObject2).toString());
          }
          this.a.a(this.k, l1, (String)localObject1);
        }
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "requestNotifyServer server ip and port is not set! this method will be called in processConfirmRsp!");
    }
  }
  
  protected boolean j()
  {
    return this.k == 0L;
  }
  
  public void k()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onDestroy called! operator = ");
      localStringBuilder.append(this.k);
      QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, localStringBuilder.toString());
    }
    b();
    e(2);
  }
  
  public boolean k(int paramInt)
  {
    try
    {
      if ((!this.q) && (paramInt == 3))
      {
        this.r = true;
        MsgBackupUtil.b("MsgBackup_MsgBackupTransportProcessor", "requestNextSessionDb tcp is disconnect!", new Object[0]);
        return false;
      }
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(" requestNextSessionDb !, from = ");
        ((StringBuilder)localObject1).append(paramInt);
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, ((StringBuilder)localObject1).toString());
      }
      Object localObject1 = MsgBackupManager.a().k;
      if ((paramInt == 1) || (paramInt == 6)) {
        c((ConcurrentHashMap)localObject1);
      }
      boolean bool;
      if (!TextUtils.isEmpty(MsgBackupManager.o)) {
        bool = a((ConcurrentHashMap)localObject1);
      } else {
        bool = b((ConcurrentHashMap)localObject1);
      }
      if ((((ConcurrentHashMap)localObject1).size() == 0) || (TextUtils.isEmpty(MsgBackupManager.o)))
      {
        j(5);
        if (QLog.isColorLevel()) {
          QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "requestNextSessionDb called with warning step1");
        }
      }
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("requestNextSessionDb called with from = ");
        ((StringBuilder)localObject1).append(paramInt);
        ((StringBuilder)localObject1).append(", ret = ");
        ((StringBuilder)localObject1).append(bool);
        ((StringBuilder)localObject1).append(", sessionCount = ");
        ((StringBuilder)localObject1).append(MsgBackupManager.i);
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, ((StringBuilder)localObject1).toString());
      }
      return bool;
    }
    finally {}
  }
  
  public boolean l()
  {
    return this.q;
  }
  
  public void m()
  {
    int i1 = MsgBackupAuthProcessor.a().c();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("exit ---------> bizType = ");
      localStringBuilder.append(i1);
      QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, localStringBuilder.toString());
    }
    if (i1 == 3)
    {
      n();
      return;
    }
    if (i1 == 1)
    {
      o();
      return;
    }
    o();
  }
  
  public void n()
  {
    Object localObject1 = q();
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("exitUdpNotify create exit : ");
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(", isUdpDetected = ");
      ((StringBuilder)localObject2).append(this.p);
      QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, ((StringBuilder)localObject2).toString());
    }
    if (this.p)
    {
      i(259);
      return;
    }
    if (this.c == 1) {
      if ((this.i.intValue() != 0) && (this.h.intValue() != 0))
      {
        if (this.q)
        {
          if (j())
          {
            MsgBackupUtil.b("exiNotifyForTransfer called------> operator is closed! please clear handler msg!........", new Object[0]);
            return;
          }
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("exitForTcp, isTcpDetected = ");
            ((StringBuilder)localObject1).append(this.q);
            QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, ((StringBuilder)localObject1).toString());
          }
          long l1 = MsgBackupUtil.a();
          localObject1 = MsgBackupUtil.a(this.g[0], this.i.intValue());
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("postinfo?fid=");
          ((StringBuilder)localObject2).append(l1);
          ((StringBuilder)localObject2).append("&exit=1");
          localObject2 = ((StringBuilder)localObject2).toString();
          MsgBackupUtil.b("MsgBackup_MsgBackupTransportProcessor", (String)localObject2, new Object[0]);
          localObject2 = MsgBackupUtil.b((String)localObject2, this.j);
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append((String)localObject1);
          localStringBuilder.append((String)localObject2);
          localObject1 = localStringBuilder.toString();
          if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (this.a != null))
          {
            localObject2 = new MsgBackupSessionTask();
            ((MsgBackupSessionTask)localObject2).g = 0;
            ((MsgBackupSessionTask)localObject2).c = false;
            ((MsgBackupSessionTask)localObject2).f = ((String)localObject1);
            MsgBackupManager.a().r.put(Long.valueOf(l1), localObject2);
            if (QLog.isColorLevel())
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("exitForTcp fid = ");
              ((StringBuilder)localObject2).append(l1);
              ((StringBuilder)localObject2).append(", url = ");
              ((StringBuilder)localObject2).append((String)localObject1);
              QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, ((StringBuilder)localObject2).toString());
            }
            this.a.a(this.k, l1, (String)localObject1);
          }
        }
      }
      else if (QLog.isColorLevel()) {
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "exitForTcp called- for client-------------->>>");
      }
    }
  }
  
  public void o()
  {
    Object localObject1 = q();
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("exitUdpNotify create exit : ");
      ((StringBuilder)localObject2).append((String)localObject1);
      QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, ((StringBuilder)localObject2).toString());
    }
    if (this.p)
    {
      i(259);
      return;
    }
    localObject1 = new JSONArray();
    Object localObject2 = new JSONObject();
    try
    {
      ((JSONObject)localObject2).put("cmd", "exit");
      ((JSONObject)localObject2).put("sig", MsgBackupAuthProcessor.a().d());
      ((JSONArray)localObject1).put(localObject2);
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    MsgBackupPushHandler.a().a(((JSONArray)localObject1).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.transport.MsgBackupTransportProcessor
 * JD-Core Version:    0.7.0.1
 */