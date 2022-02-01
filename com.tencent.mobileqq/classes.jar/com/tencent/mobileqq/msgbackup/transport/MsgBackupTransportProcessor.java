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
  private static MsgBackupTransportProcessor jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupTransportProcessor;
  protected int a;
  protected long a;
  private IMsgBackupUICallback jdField_a_of_type_ComTencentMobileqqMsgbackupControllerIMsgBackupUICallback;
  protected MsgBackupJniProxy a;
  protected MsgBackupNotifier a;
  protected Integer a;
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  protected String a;
  protected boolean a;
  protected String[] a;
  private long jdField_b_of_type_Long = 0L;
  protected Integer b;
  private boolean jdField_b_of_type_Boolean = false;
  protected String[] b;
  private long jdField_c_of_type_Long = 0L;
  protected Integer c;
  private boolean jdField_c_of_type_Boolean = false;
  protected Integer d;
  private boolean d;
  private boolean e = false;
  
  public MsgBackupTransportProcessor()
  {
    this.jdField_a_of_type_ArrayOfJavaLangString = new String[10];
    this.jdField_a_of_type_JavaLangInteger = new Integer(0);
    this.jdField_b_of_type_JavaLangInteger = new Integer(0);
    this.jdField_b_of_type_ArrayOfJavaLangString = new String[10];
    this.jdField_c_of_type_JavaLangInteger = new Integer(0);
    this.jdField_d_of_type_JavaLangInteger = new Integer(0);
    this.jdField_a_of_type_Long = 0L;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_Boolean = false;
  }
  
  private int a(ConcurrentHashMap<String, MsgBackupSessionInfo> paramConcurrentHashMap)
  {
    paramConcurrentHashMap = paramConcurrentHashMap.values().iterator();
    int i = 0;
    while (paramConcurrentHashMap.hasNext()) {
      if (((MsgBackupSessionInfo)paramConcurrentHashMap.next()).jdField_c_of_type_Boolean) {
        i += 1;
      }
    }
    return i;
  }
  
  private MsgBackupJniProxy a(Context paramContext)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy == null) {
      this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy = new MsgBackupJniProxy(paramContext);
    }
    return this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy;
  }
  
  public static MsgBackupTransportProcessor a()
  {
    if (jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupTransportProcessor == null) {
      try
      {
        if (jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupTransportProcessor == null) {
          jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupTransportProcessor = new MsgBackupTransportProcessor();
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupTransportProcessor;
  }
  
  private String a(long paramLong, int paramInt)
  {
    int i = MsgBackupManager.jdField_b_of_type_Int;
    Object localObject4 = MsgBackupManager.a().jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap;
    ((ConcurrentHashMap)localObject4).size();
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("getSessionJsonRsp, fid = ");
      ((StringBuilder)localObject1).append(paramLong);
      ((StringBuilder)localObject1).append(", mServerReadyMList.size = ");
      ((StringBuilder)localObject1).append(((ConcurrentHashMap)localObject4).size());
      ((StringBuilder)localObject1).append(", mDataCache = ");
      ((StringBuilder)localObject1).append(i);
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
        ((JSONObject)???).put("listCount", i);
        ((JSONArray)localObject1).put(???);
        int j = 0;
        synchronized (this.jdField_a_of_type_JavaLangObject)
        {
          localObject4 = ((ConcurrentHashMap)localObject4).values().iterator();
          while (((Iterator)localObject4).hasNext())
          {
            MsgBackupSessionInfo localMsgBackupSessionInfo = (MsgBackupSessionInfo)((Iterator)localObject4).next();
            i = j;
            if (localMsgBackupSessionInfo.jdField_c_of_type_Boolean) {
              i = j + 1;
            }
            j = i;
            if (!localMsgBackupSessionInfo.jdField_a_of_type_Boolean)
            {
              JSONObject localJSONObject = new JSONObject();
              String str2 = localMsgBackupSessionInfo.jdField_a_of_type_JavaLangString;
              j = localMsgBackupSessionInfo.jdField_a_of_type_Int;
              localJSONObject.put("cmd", "chat_ready");
              localJSONObject.put("chatUin", str2);
              localJSONObject.put("chatType", MsgBackupUtil.b(j));
              localJSONObject.put("dbSize", localMsgBackupSessionInfo.jdField_a_of_type_Long);
              ((JSONArray)localObject1).put(localJSONObject);
              localMsgBackupSessionInfo.jdField_a_of_type_Boolean = true;
              j = i;
            }
          }
          if ((3 == paramInt) && (this.jdField_a_of_type_ComTencentMobileqqMsgbackupControllerIMsgBackupUICallback != null)) {
            this.jdField_a_of_type_ComTencentMobileqqMsgbackupControllerIMsgBackupUICallback.a(j, MsgBackupManager.jdField_b_of_type_Int);
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
    if (paramMsgBackupSessionTask.jdField_a_of_type_Boolean)
    {
      MsgBackupReporter.a();
      Object localObject = MsgBackupReporter.a;
      ((MsgBackupReportData)localObject).n += 1L;
      localObject = MsgBackupReporter.a;
      ((MsgBackupReportData)localObject).r += 1L;
      localObject = new MsgBackupReportData.FileError();
      ((MsgBackupReportData.FileError)localObject).jdField_b_of_type_Int = 1;
      ((MsgBackupReportData.FileError)localObject).jdField_c_of_type_Int = 0;
      ((MsgBackupReportData.FileError)localObject).jdField_a_of_type_Int = paramInt;
      MsgBackupReporter.a.a.add(localObject);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("dbMList receivedCompleted  called not success, so again task = ");
        ((StringBuilder)localObject).append(paramMsgBackupSessionTask);
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, ((StringBuilder)localObject).toString());
      }
      if ((!TextUtils.isEmpty(paramMsgBackupSessionTask.jdField_b_of_type_JavaLangString)) && (!TextUtils.isEmpty(paramMsgBackupSessionTask.c))) {
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
    if ((paramMsgBackupSessionTask.jdField_a_of_type_Short > 3) && (this.jdField_d_of_type_Boolean))
    {
      b(paramLong, paramMsgBackupSessionTask, paramConcurrentHashMap, paramMsgBackupSessionInfo, paramConcurrentHashMap1);
      return;
    }
    if (a())
    {
      MsgBackupUtil.b("recvFile panic error! dbMList receivedCompleted", new Object[0]);
      return;
    }
    paramMsgBackupSessionTask.jdField_a_of_type_Short = ((short)(paramMsgBackupSessionTask.jdField_a_of_type_Short + 1));
    this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy.a(this.jdField_a_of_type_Long, paramLong, paramMsgBackupSessionTask.c, paramMsgBackupSessionTask.jdField_b_of_type_JavaLangString, paramMsgBackupSessionTask.jdField_b_of_type_Boolean, paramMsgBackupSessionTask.jdField_b_of_type_Long, false);
  }
  
  private void a(long paramLong, String paramString)
  {
    if (a())
    {
      MsgBackupUtil.b("http get reached! but can not understand this request! session is valid........", new Object[0]);
      return;
    }
    paramString = (String)MsgBackupUtil.a(paramString).get("fid");
    if (!TextUtils.isEmpty(paramString))
    {
      long l = Long.parseLong(paramString);
      MsgBackupUtil.b("http get reached! but can not understand this request! session is valid........", new Object[0]);
      this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy.refuseFileRequest(this.jdField_a_of_type_Long, paramLong, l, "404");
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
        if ((paramConcurrentHashMap.size() < MsgBackupManager.jdField_b_of_type_Int) || (MsgBackupManager.jdField_b_of_type_Int <= 0))
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
    if ((this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy != null) && (TextUtils.isEmpty(paramString2)))
    {
      if (a())
      {
        MsgBackupUtil.b("getRecvBuffer called operator is closed! please clear handler msg!........", new Object[0]);
        return;
      }
      a(paramLong1, paramString1, paramInt, paramLong2, paramConcurrentHashMap1, a(paramArrayOfByte));
    }
  }
  
  private void a(long paramLong, String paramString, int paramInt, boolean paramBoolean)
  {
    if (a())
    {
      MsgBackupUtil.b("requestFromFile called------> operator is closed! please clear handler msg!........", new Object[0]);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy != null)
    {
      long l = MsgBackupUtil.a();
      String str = MsgBackupUtil.a(this.jdField_b_of_type_ArrayOfJavaLangString[0], this.jdField_d_of_type_JavaLangInteger.intValue());
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("getmsg?fid=");
      ((StringBuilder)localObject1).append(l);
      ((StringBuilder)localObject1).append("&chatUin=");
      ((StringBuilder)localObject1).append(paramString);
      ((StringBuilder)localObject1).append("&chatType=");
      ((StringBuilder)localObject1).append(MsgBackupUtil.b(paramInt));
      localObject1 = ((StringBuilder)localObject1).toString();
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(str);
      ((StringBuilder)localObject2).append(MsgBackupUtil.b((String)localObject1, this.jdField_a_of_type_JavaLangString));
      str = ((StringBuilder)localObject2).toString();
      localObject1 = MsgBackupUtil.a(paramString, MsgBackupUtil.b(paramInt), null);
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("requestFromFile fid = ");
        ((StringBuilder)localObject2).append(l);
        ((StringBuilder)localObject2).append(", url = ");
        ((StringBuilder)localObject2).append(str);
        ((StringBuilder)localObject2).append(", path = ");
        ((StringBuilder)localObject2).append((String)localObject1);
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, ((StringBuilder)localObject2).toString());
      }
      localObject2 = new MsgBackupSessionTask();
      ((MsgBackupSessionTask)localObject2).jdField_a_of_type_Boolean = true;
      ((MsgBackupSessionTask)localObject2).jdField_a_of_type_Short = 0;
      ((MsgBackupSessionTask)localObject2).jdField_b_of_type_JavaLangString = ((String)localObject1);
      ((MsgBackupSessionTask)localObject2).c = str;
      paramString = MsgBackupUtil.b(paramString, MsgBackupUtil.b(paramInt));
      ConcurrentHashMap localConcurrentHashMap = MsgBackupManager.a().jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap;
      MsgBackupReporter.a();
      Object localObject3 = MsgBackupReporter.a;
      ((MsgBackupReportData)localObject3).m += 1L;
      localObject3 = (MsgBackupSessionInfo)localConcurrentHashMap.get(paramString);
      if (localObject3 != null)
      {
        ((MsgBackupSessionInfo)localObject3).jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(Long.valueOf(l), localObject2);
        ((MsgBackupSessionTask)localObject2).jdField_b_of_type_Long = ((MsgBackupSessionInfo)localObject3).jdField_a_of_type_Long;
        ((MsgBackupSessionTask)localObject2).jdField_b_of_type_Boolean = MsgBackupUtil.a(((MsgBackupSessionInfo)localObject3).jdField_a_of_type_Long);
        Object localObject4 = MsgBackupReporter.a;
        ((MsgBackupReportData)localObject4).f += ((MsgBackupSessionTask)localObject2).jdField_b_of_type_Long;
        if (QLog.isColorLevel())
        {
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append("requestFromFile , sessionInfo.dbMList = ");
          ((StringBuilder)localObject4).append(((MsgBackupSessionInfo)localObject3).jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap);
          ((StringBuilder)localObject4).append(". sessionInfo.hashcode = ");
          ((StringBuilder)localObject4).append(localObject3.hashCode());
          ((StringBuilder)localObject4).append(", task.isSmallerFile = ");
          ((StringBuilder)localObject4).append(((MsgBackupSessionTask)localObject2).jdField_b_of_type_Boolean);
          QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, ((StringBuilder)localObject4).toString());
        }
      }
      if (QLog.isColorLevel())
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("requestFromFile fid = ");
        ((StringBuilder)localObject3).append(l);
        ((StringBuilder)localObject3).append(", mClientCanRecvMList = ");
        ((StringBuilder)localObject3).append(localConcurrentHashMap);
        ((StringBuilder)localObject3).append(", keyFromUin = ");
        ((StringBuilder)localObject3).append(paramString);
        ((StringBuilder)localObject3).append(", task.isSmallerFile = ");
        ((StringBuilder)localObject3).append(((MsgBackupSessionTask)localObject2).jdField_b_of_type_Boolean);
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, ((StringBuilder)localObject3).toString());
      }
      this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy.a(paramLong, l, str, (String)localObject1, ((MsgBackupSessionTask)localObject2).jdField_b_of_type_Boolean, ((MsgBackupSessionTask)localObject2).jdField_b_of_type_Long, false);
      boolean bool = this.jdField_a_of_type_Boolean;
      paramBoolean = false;
      if (this.jdField_a_of_type_ComTencentMobileqqMsgbackupControllerIMsgBackupUICallback != null) {
        paramBoolean = true;
      }
      MsgBackupUtil.b("MsgBackup_MsgBackupTransportProcessor", "requestFromFile isTransportStart = %b, mCallBack is not null = %b", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(paramBoolean) });
      paramString = this.jdField_a_of_type_ComTencentMobileqqMsgbackupControllerIMsgBackupUICallback;
      if ((paramString != null) && (!this.jdField_a_of_type_Boolean))
      {
        this.jdField_a_of_type_Boolean = true;
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
    if (a())
    {
      MsgBackupUtil.b("getres onSendComplete operator is closed! please clear handler msg!........", new Object[0]);
      return;
    }
    Object localObject = MsgBackupReporter.a;
    ((MsgBackupReportData)localObject).jdField_d_of_type_Long += 1L;
    localObject = MsgBackupReporter.a;
    ((MsgBackupReportData)localObject).g += 1L;
    paramString = MsgBackupUtil.a(paramString);
    long l = Long.parseLong((String)paramString.get("fid"));
    localObject = (String)paramString.get("filepath");
    MsgBackupUtil.b("res url parse fid = %d,filepath = %s", new Object[] { Long.valueOf(l), localObject });
    paramString = (String)localObject;
    if (MsgBackupUtil.jdField_c_of_type_Boolean) {
      paramString = Uri.decode((String)localObject);
    }
    MsgBackupUtil.b("res url parse fid = %d,filepath = %s", new Object[] { Long.valueOf(l), paramString });
    localObject = new MsgBackupReportData.ServerFileDetail();
    ((MsgBackupReportData.ServerFileDetail)localObject).jdField_a_of_type_Boolean = false;
    ((MsgBackupReportData.ServerFileDetail)localObject).jdField_a_of_type_Long = 0L;
    MsgBackupManager.a().e.put(Long.valueOf(l), localObject);
    localObject = new MsgBackupSessionTask();
    ((MsgBackupSessionTask)localObject).jdField_a_of_type_Short = 0;
    ((MsgBackupSessionTask)localObject).jdField_a_of_type_Boolean = true;
    ((MsgBackupSessionTask)localObject).jdField_b_of_type_JavaLangString = MsgBackupUtil.a(paramString);
    ((MsgBackupSessionTask)localObject).jdField_a_of_type_Long = paramLong;
    paramConcurrentHashMap.put(Long.valueOf(l), localObject);
    this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy.a(this.jdField_a_of_type_Long, paramLong, l, ((MsgBackupSessionTask)localObject).jdField_b_of_type_JavaLangString);
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("onHttpRequest, send res file, fileRes path = ");
      paramString.append(((MsgBackupSessionTask)localObject).jdField_b_of_type_JavaLangString);
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
      paramConcurrentHashMap1.jdField_a_of_type_Int = 1;
      paramConcurrentHashMap1.jdField_a_of_type_JavaLangString = paramString;
      MsgBackupManager.a().b(paramConcurrentHashMap1);
    }
  }
  
  private void a(long paramLong1, ConcurrentHashMap<Long, MsgBackupSessionTask> paramConcurrentHashMap, long paramLong2, String paramString)
  {
    MsgBackupSessionTask localMsgBackupSessionTask = new MsgBackupSessionTask();
    localMsgBackupSessionTask.jdField_a_of_type_Short = 0;
    localMsgBackupSessionTask.jdField_a_of_type_Boolean = false;
    localMsgBackupSessionTask.jdField_a_of_type_JavaLangString = paramString;
    localMsgBackupSessionTask.jdField_a_of_type_Long = paramLong1;
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
    this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy.b(this.jdField_a_of_type_Long, paramLong1, paramLong2, paramString);
  }
  
  private void a(long paramLong, ConcurrentHashMap<String, MsgBackupSessionInfo> paramConcurrentHashMap, MsgBackupSessionInfo arg4, ConcurrentHashMap<Long, MsgBackupSessionTask> paramConcurrentHashMap1, ConcurrentHashMap<Long, MsgBackupSessionTask> paramConcurrentHashMap2, MsgBackupSessionTask paramMsgBackupSessionTask)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("isTcpDetected = ");
    localStringBuilder.append(this.jdField_d_of_type_Boolean);
    localStringBuilder.append(", isResRequestAllFinished");
    localStringBuilder.append(???.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
    localStringBuilder.append(", resReq fileTask receivedCompleted retry over time task = ");
    localStringBuilder.append(paramMsgBackupSessionTask);
    QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, localStringBuilder.toString());
    paramConcurrentHashMap2.remove(Long.valueOf(paramLong));
    int i = paramConcurrentHashMap2.size();
    int j = paramConcurrentHashMap1.size();
    if ((i == 0) && (j == 0) && (???.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()))
    {
      ???.jdField_c_of_type_Boolean = true;
      a(???);
      if (QLog.isColorLevel())
      {
        ??? = new StringBuilder();
        ???.append("last session transport completed!, uin = ");
        ???.append(MsgBackupManager.jdField_d_of_type_JavaLangString);
        ???.append(", uintype = ");
        ???.append(MsgBackupManager.jdField_c_of_type_Int);
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
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        paramConcurrentHashMap = paramConcurrentHashMap.values().iterator();
        i = 0;
        while (paramConcurrentHashMap.hasNext()) {
          if (((MsgBackupSessionInfo)paramConcurrentHashMap.next()).jdField_c_of_type_Boolean) {
            i += 1;
          }
        }
        paramConcurrentHashMap = this.jdField_a_of_type_ComTencentMobileqqMsgbackupControllerIMsgBackupUICallback;
        if (paramConcurrentHashMap != null) {
          paramConcurrentHashMap.a(i, MsgBackupManager.jdField_b_of_type_Int);
        }
        if (i == MsgBackupManager.jdField_b_of_type_Int) {
          return;
        }
        if (!a(2))
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
    if (paramMsgBackupSessionTask.jdField_a_of_type_Boolean)
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("mfidMlist fileTask receivedCompleted  called not success, so again task = ");
        localStringBuilder.append(paramMsgBackupSessionTask);
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, localStringBuilder.toString());
      }
      if ((!TextUtils.isEmpty(paramMsgBackupSessionTask.jdField_b_of_type_JavaLangString)) && (!TextUtils.isEmpty(paramMsgBackupSessionTask.c)))
      {
        if (paramMsgBackupSessionTask.jdField_a_of_type_Short > 3)
        {
          paramConcurrentHashMap.remove(Long.valueOf(paramLong));
          paramConcurrentHashMap = new StringBuilder();
          paramConcurrentHashMap.append(" mfidMlist fileTask receivedCompleted retry over time task = ");
          paramConcurrentHashMap.append(paramMsgBackupSessionTask);
          QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, paramConcurrentHashMap.toString());
          return;
        }
        if (a())
        {
          MsgBackupUtil.b("recvFile panic error! mfidMlist fileTask receivedCompleted", new Object[0]);
          return;
        }
        paramMsgBackupSessionTask.jdField_a_of_type_Short = ((short)(paramMsgBackupSessionTask.jdField_a_of_type_Short + 1));
        this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy.a(this.jdField_a_of_type_Long, paramLong, paramMsgBackupSessionTask.c, paramMsgBackupSessionTask.jdField_b_of_type_JavaLangString, paramMsgBackupSessionTask.jdField_b_of_type_Boolean, paramMsgBackupSessionTask.jdField_b_of_type_Long, true);
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
      if (!TextUtils.isEmpty(paramMsgBackupSessionTask.c))
      {
        if (paramMsgBackupSessionTask.jdField_a_of_type_Short > 3)
        {
          paramConcurrentHashMap.remove(Long.valueOf(paramLong));
          paramConcurrentHashMap = new StringBuilder();
          paramConcurrentHashMap.append("receivedCompleted mfidMlist retry over time task = ");
          paramConcurrentHashMap.append(paramMsgBackupSessionTask);
          QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, paramConcurrentHashMap.toString());
          return;
        }
        if (a())
        {
          MsgBackupUtil.b("receivedCompleted mfidMlist  operator is closed! please clear handler msg!........", new Object[0]);
          return;
        }
        paramMsgBackupSessionTask.jdField_a_of_type_Short = ((short)(paramMsgBackupSessionTask.jdField_a_of_type_Short + 1));
        this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy.a(this.jdField_a_of_type_Long, paramLong, paramMsgBackupSessionTask.c);
      }
    }
  }
  
  private void a(long paramLong, ConcurrentHashMap<Long, MsgBackupSessionTask> paramConcurrentHashMap, Map<String, String> paramMap)
  {
    if (a())
    {
      MsgBackupUtil.b("httpGetReached postinfo operator is closed! please clear handler msg!........", new Object[0]);
      return;
    }
    long l = Long.parseLong((String)paramMap.get("fid"));
    a(paramLong, paramConcurrentHashMap, l, a(l, 1));
  }
  
  private void a(long paramLong, ConcurrentHashMap<Long, MsgBackupSessionTask> paramConcurrentHashMap, ConcurrentHashMap<String, MsgBackupSessionInfo> paramConcurrentHashMap1, Map<String, String> arg5)
  {
    if (???.size() >= 3)
    {
      boolean bool = a();
      int i = 0;
      if (bool)
      {
        MsgBackupUtil.b("httpGetReached postinfo operator is closed! please clear handler msg!........", new Object[0]);
        return;
      }
      long l = Long.parseLong((String)???.get("fid"));
      String str = (String)???.get("chatUin");
      int j = Integer.parseInt((String)???.get("chatType"));
      if (QLog.isColorLevel())
      {
        ??? = new StringBuilder();
        ???.append("httpGetReached: client report 会话 uin =");
        ???.append(str);
        ???.append(" 接收完成, chatType = ");
        ???.append(j);
        ???.append("：mServerReadyMList.size = ");
        ???.append(paramConcurrentHashMap1.size());
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, ???.toString());
      }
      ??? = (MsgBackupSessionInfo)paramConcurrentHashMap1.get(MsgBackupUtil.b(str, j));
      if (??? != null)
      {
        ???.jdField_c_of_type_Boolean = true;
        if (this.jdField_a_of_type_ComTencentMobileqqMsgbackupControllerIMsgBackupUICallback != null) {
          synchronized (this.jdField_a_of_type_JavaLangObject)
          {
            paramConcurrentHashMap1 = paramConcurrentHashMap1.values().iterator();
            while (paramConcurrentHashMap1.hasNext()) {
              if (((MsgBackupSessionInfo)paramConcurrentHashMap1.next()).jdField_c_of_type_Boolean) {
                i += 1;
              }
            }
            if (QLog.isColorLevel())
            {
              paramConcurrentHashMap1 = new StringBuilder();
              paramConcurrentHashMap1.append("httpGetReached: client report session completed! hasCompletedCount = ");
              paramConcurrentHashMap1.append(i);
              QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, paramConcurrentHashMap1.toString());
            }
            paramConcurrentHashMap1 = this.jdField_a_of_type_ComTencentMobileqqMsgbackupControllerIMsgBackupUICallback;
            if (paramConcurrentHashMap1 != null) {
              paramConcurrentHashMap1.a(i, MsgBackupManager.jdField_b_of_type_Int);
            }
            i = MsgBackupManager.jdField_b_of_type_Int;
          }
        }
      }
      if (QLog.isColorLevel())
      {
        paramConcurrentHashMap1 = new StringBuilder();
        paramConcurrentHashMap1.append("httpGetReached, client report session transport completed! fid = ");
        paramConcurrentHashMap1.append(l);
        paramConcurrentHashMap1.append(", msg = []");
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, paramConcurrentHashMap1.toString());
      }
      a(paramLong, paramConcurrentHashMap, l, a(l, 3));
    }
  }
  
  private void a(MsgBackupSessionInfo paramMsgBackupSessionInfo)
  {
    if (this.jdField_c_of_type_Boolean)
    {
      i(258);
      return;
    }
    a(this.jdField_a_of_type_Long, false, paramMsgBackupSessionInfo.jdField_a_of_type_JavaLangString, paramMsgBackupSessionInfo.jdField_a_of_type_Int);
  }
  
  private void a(ConcurrentHashMap<String, MsgBackupSessionInfo> paramConcurrentHashMap, JSONArray paramJSONArray)
  {
    int i = 0;
    while (i < paramJSONArray.length())
    {
      Object localObject = (JSONObject)paramJSONArray.get(i);
      if ("chat_ready".equals(((JSONObject)localObject).optString("cmd")))
      {
        String str = ((JSONObject)localObject).optString("chatUin");
        int j = ((JSONObject)localObject).optInt("chatType");
        long l = ((JSONObject)localObject).optLong("dbSize");
        localObject = new MsgBackupSessionInfo();
        ((MsgBackupSessionInfo)localObject).jdField_b_of_type_Boolean = false;
        ((MsgBackupSessionInfo)localObject).jdField_a_of_type_JavaLangString = str;
        ((MsgBackupSessionInfo)localObject).jdField_a_of_type_Long = l;
        ((MsgBackupSessionInfo)localObject).jdField_a_of_type_Int = MsgBackupUtil.c(j);
        paramConcurrentHashMap.put(MsgBackupUtil.b(((MsgBackupSessionInfo)localObject).jdField_a_of_type_JavaLangString, j), localObject);
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("receivedCompleted  会话 uin =");
          localStringBuilder.append(str);
          localStringBuilder.append(", uintype = ");
          localStringBuilder.append(((MsgBackupSessionInfo)localObject).jdField_a_of_type_Int);
          localStringBuilder.append("：mClientCanRecvMList.size = ");
          localStringBuilder.append(paramConcurrentHashMap.size());
          QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, localStringBuilder.toString());
        }
      }
      i += 1;
    }
    a(4);
  }
  
  private void a(ConcurrentHashMap<String, MsgBackupSessionInfo> paramConcurrentHashMap, JSONArray paramJSONArray, JSONObject paramJSONObject)
  {
    MsgBackupManager.jdField_b_of_type_Int = paramJSONObject.optInt("listCount");
    MsgBackupReporter.a();
    MsgBackupReporter.a.jdField_b_of_type_Long = MsgBackupManager.jdField_b_of_type_Int;
    if (QLog.isColorLevel())
    {
      paramJSONObject = new StringBuilder();
      paramJSONObject.append("receivedCompleted, 会话总个数：MsgBackupManager.sessionCount = ");
      paramJSONObject.append(MsgBackupManager.jdField_b_of_type_Int);
      QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, paramJSONObject.toString());
    }
    int i = 1;
    while (i < paramJSONArray.length())
    {
      Object localObject1 = (JSONObject)paramJSONArray.get(i);
      if ("chat_ready".equals(((JSONObject)localObject1).optString("cmd")))
      {
        paramJSONObject = ((JSONObject)localObject1).optString("chatUin");
        int j = ((JSONObject)localObject1).optInt("chatType");
        long l = ((JSONObject)localObject1).optLong("dbSize");
        localObject1 = new MsgBackupSessionInfo();
        ((MsgBackupSessionInfo)localObject1).jdField_b_of_type_Boolean = false;
        ((MsgBackupSessionInfo)localObject1).jdField_a_of_type_JavaLangString = paramJSONObject;
        ((MsgBackupSessionInfo)localObject1).jdField_a_of_type_Int = MsgBackupUtil.c(j);
        ((MsgBackupSessionInfo)localObject1).jdField_a_of_type_Long = l;
        Object localObject2 = MsgBackupUtil.b(((MsgBackupSessionInfo)localObject1).jdField_a_of_type_JavaLangString, j);
        if (paramConcurrentHashMap.get(localObject2) == null) {
          paramConcurrentHashMap.put(localObject2, localObject1);
        }
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("receivedCompleted  会话 uin =");
          ((StringBuilder)localObject2).append(paramJSONObject);
          ((StringBuilder)localObject2).append(", uintype = ");
          ((StringBuilder)localObject2).append(((MsgBackupSessionInfo)localObject1).jdField_a_of_type_Int);
          ((StringBuilder)localObject2).append("：mClientCanRecvMList= ");
          ((StringBuilder)localObject2).append(paramConcurrentHashMap);
          QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, ((StringBuilder)localObject2).toString());
        }
      }
      i += 1;
    }
    a(4);
  }
  
  private boolean a(long paramLong, ConcurrentHashMap<Long, MsgBackupSessionTask> paramConcurrentHashMap, Map<String, String> paramMap)
  {
    if (!MsgBackupManager.jdField_f_of_type_Boolean)
    {
      long l = Long.parseLong((String)paramMap.get("fid"));
      paramMap = new MsgBackupSessionTask();
      paramMap.jdField_a_of_type_Short = 0;
      paramMap.jdField_a_of_type_Boolean = false;
      paramMap.jdField_a_of_type_JavaLangString = "[]";
      paramMap.jdField_a_of_type_Long = paramLong;
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("httpGetReached, postinfo ui is not ready!");
        localStringBuilder.append(l);
        localStringBuilder.append(", msg = ");
        localStringBuilder.append("[]");
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, localStringBuilder.toString());
      }
      paramConcurrentHashMap.put(Long.valueOf(l), paramMap);
      this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy.b(this.jdField_a_of_type_Long, paramLong, l, "[]");
      return true;
    }
    return false;
  }
  
  private boolean a(ConcurrentHashMap<String, MsgBackupSessionInfo> paramConcurrentHashMap, boolean paramBoolean)
  {
    Iterator localIterator = paramConcurrentHashMap.values().iterator();
    int i = 0;
    boolean bool1;
    int j;
    Object localObject;
    do
    {
      do
      {
        do
        {
          boolean bool2 = localIterator.hasNext();
          bool1 = true;
          j = i;
          if (!bool2) {
            break;
          }
          localObject = (MsgBackupSessionInfo)localIterator.next();
        } while (((MsgBackupSessionInfo)localObject).jdField_b_of_type_Boolean);
        if (((MsgBackupSessionInfo)localObject).jdField_a_of_type_Long > 0L) {
          break;
        }
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(" requestNextSessionDb !, curDealUin is not null! dbsize 等于 0 ！客户端不会去请求了，只是通知server端，该会话已经接受完成了！uin = ");
          localStringBuilder.append(((MsgBackupSessionInfo)localObject).jdField_a_of_type_JavaLangString);
          localStringBuilder.append(", uintype = ");
          localStringBuilder.append(((MsgBackupSessionInfo)localObject).jdField_a_of_type_Int);
          localStringBuilder.append(", dbsize = ");
          localStringBuilder.append(((MsgBackupSessionInfo)localObject).jdField_a_of_type_Long);
          QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, localStringBuilder.toString());
        }
        ((MsgBackupSessionInfo)localObject).jdField_c_of_type_Boolean = true;
        ((MsgBackupSessionInfo)localObject).jdField_b_of_type_Boolean = true;
        a((MsgBackupSessionInfo)localObject);
      } while (this.jdField_a_of_type_ComTencentMobileqqMsgbackupControllerIMsgBackupUICallback == null);
      j = a(paramConcurrentHashMap);
      localObject = this.jdField_a_of_type_ComTencentMobileqqMsgbackupControllerIMsgBackupUICallback;
      if (localObject != null) {
        ((IMsgBackupUICallback)localObject).a(j, MsgBackupManager.jdField_b_of_type_Int);
      }
      i = j;
    } while (j != MsgBackupManager.jdField_b_of_type_Int);
    MsgBackupUtil.b("MsgBackup_MsgBackupTransportProcessor", "curDealUin is not null! session transport completed! dbSize is 0!------------->", new Object[0]);
    break label398;
    i = a(paramConcurrentHashMap);
    paramConcurrentHashMap = this.jdField_a_of_type_ComTencentMobileqqMsgbackupControllerIMsgBackupUICallback;
    if (paramConcurrentHashMap != null) {
      paramConcurrentHashMap.a(i, MsgBackupManager.jdField_b_of_type_Int);
    }
    if (i == MsgBackupManager.jdField_b_of_type_Int) {
      MsgBackupUtil.b("MsgBackup_MsgBackupTransportProcessor", "curDealUin is not null! session transport completed!------------->", new Object[0]);
    }
    for (;;)
    {
      break;
      ((MsgBackupSessionInfo)localObject).jdField_b_of_type_Boolean = true;
      MsgBackupManager.jdField_d_of_type_JavaLangString = ((MsgBackupSessionInfo)localObject).jdField_a_of_type_JavaLangString;
      MsgBackupManager.jdField_c_of_type_Int = ((MsgBackupSessionInfo)localObject).jdField_a_of_type_Int;
      if (QLog.isColorLevel())
      {
        paramConcurrentHashMap = new StringBuilder();
        paramConcurrentHashMap.append(" requestNextSessionDb !, current uin = ");
        paramConcurrentHashMap.append(MsgBackupManager.jdField_d_of_type_JavaLangString);
        paramConcurrentHashMap.append(", uintype = ");
        paramConcurrentHashMap.append(MsgBackupManager.jdField_c_of_type_Int);
        paramConcurrentHashMap.append(", dbsize = ");
        paramConcurrentHashMap.append(((MsgBackupSessionInfo)localObject).jdField_a_of_type_Long);
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, paramConcurrentHashMap.toString());
      }
      a(this.jdField_a_of_type_Long, ((MsgBackupSessionInfo)localObject).jdField_a_of_type_JavaLangString, ((MsgBackupSessionInfo)localObject).jdField_a_of_type_Int, false);
      paramBoolean = bool1;
    }
    label398:
    i = j;
    if ((!paramBoolean) && (i != MsgBackupManager.jdField_b_of_type_Int))
    {
      j(5);
      if (QLog.isColorLevel())
      {
        paramConcurrentHashMap = new StringBuilder();
        paramConcurrentHashMap.append("requestNextSessionDb called with warning step2 , , hasFinishedC = ");
        paramConcurrentHashMap.append(i);
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, paramConcurrentHashMap.toString());
      }
    }
    return paramBoolean;
  }
  
  private void b(long paramLong, int paramInt, ConcurrentHashMap<String, MsgBackupSessionInfo> paramConcurrentHashMap, MsgBackupSessionInfo paramMsgBackupSessionInfo, ConcurrentHashMap<Long, MsgBackupSessionTask> paramConcurrentHashMap1, ConcurrentHashMap<Long, MsgBackupSessionTask> paramConcurrentHashMap2, MsgBackupSessionTask paramMsgBackupSessionTask)
  {
    if (paramMsgBackupSessionTask.jdField_a_of_type_Boolean)
    {
      MsgBackupReporter.a();
      Object localObject = MsgBackupReporter.a;
      ((MsgBackupReportData)localObject).h += 1L;
      localObject = MsgBackupReporter.a;
      ((MsgBackupReportData)localObject).r += 1L;
      localObject = new MsgBackupReportData.FileError();
      if (MsgBackupManager.a().jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.contains(Long.valueOf(paramLong)))
      {
        MsgBackupReportData localMsgBackupReportData = MsgBackupReporter.a;
        localMsgBackupReportData.k += 1L;
        MsgBackupManager.a().jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.remove(Long.valueOf(paramLong));
        ((MsgBackupReportData.FileError)localObject).jdField_c_of_type_Int = 2;
      }
      else
      {
        ((MsgBackupReportData.FileError)localObject).jdField_c_of_type_Int = 1;
      }
      ((MsgBackupReportData.FileError)localObject).jdField_b_of_type_Int = 2;
      ((MsgBackupReportData.FileError)localObject).jdField_a_of_type_Int = paramInt;
      MsgBackupReporter.a.a.add(localObject);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("resReq fileTask receivedCompleted  called not success, so again task = ");
        ((StringBuilder)localObject).append(paramMsgBackupSessionTask);
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, ((StringBuilder)localObject).toString());
      }
      if ((!TextUtils.isEmpty(paramMsgBackupSessionTask.jdField_b_of_type_JavaLangString)) && (!TextUtils.isEmpty(paramMsgBackupSessionTask.c)))
      {
        if ((paramMsgBackupSessionTask.jdField_a_of_type_Short > 3) && (this.jdField_d_of_type_Boolean))
        {
          a(paramLong, paramConcurrentHashMap, paramMsgBackupSessionInfo, paramConcurrentHashMap1, paramConcurrentHashMap2, paramMsgBackupSessionTask);
          return;
        }
        if (a())
        {
          MsgBackupUtil.b("recvFile panic error! resReq fileTask receivedCompleted", new Object[0]);
          return;
        }
        paramMsgBackupSessionTask.jdField_a_of_type_Short = ((short)(paramMsgBackupSessionTask.jdField_a_of_type_Short + 1));
        this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy.a(this.jdField_a_of_type_Long, paramLong, paramMsgBackupSessionTask.c, paramMsgBackupSessionTask.jdField_b_of_type_JavaLangString, paramMsgBackupSessionTask.jdField_b_of_type_Boolean, paramMsgBackupSessionTask.jdField_b_of_type_Long, true);
      }
    }
  }
  
  private void b(long paramLong, MsgBackupSessionTask arg3, ConcurrentHashMap<String, MsgBackupSessionInfo> paramConcurrentHashMap, MsgBackupSessionInfo paramMsgBackupSessionInfo, ConcurrentHashMap<Long, MsgBackupSessionTask> paramConcurrentHashMap1)
  {
    MsgBackupManager.jdField_a_of_type_Int += 1;
    MsgBackupUtil.b("MsgBackup_MsgBackupTransportProcessor", "MsgBackup_Manager skipSessionCount = %d", new Object[] { Integer.valueOf(MsgBackupManager.jdField_a_of_type_Int) });
    paramConcurrentHashMap1.remove(Long.valueOf(paramLong));
    paramConcurrentHashMap1 = new StringBuilder();
    paramConcurrentHashMap1.append("isTcpDetected = ");
    paramConcurrentHashMap1.append(this.jdField_d_of_type_Boolean);
    paramConcurrentHashMap1.append(", 此会话db一直失败，扔掉，通知对端dbMList receivedCompleted retry over time task = ");
    paramConcurrentHashMap1.append(???);
    QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, paramConcurrentHashMap1.toString());
    paramMsgBackupSessionInfo.jdField_c_of_type_Boolean = true;
    a(paramMsgBackupSessionInfo);
    if (QLog.isColorLevel())
    {
      ??? = new StringBuilder();
      ???.append("getdb failed !  mclient will get db mClientCanRecvMList.size = ");
      ???.append(paramConcurrentHashMap.size());
      QLog.d("MsgBackup", 2, ???.toString());
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      paramConcurrentHashMap = paramConcurrentHashMap.values().iterator();
      int i = 0;
      while (paramConcurrentHashMap.hasNext()) {
        if (((MsgBackupSessionInfo)paramConcurrentHashMap.next()).jdField_c_of_type_Boolean) {
          i += 1;
        }
      }
      ??? = this.jdField_a_of_type_ComTencentMobileqqMsgbackupControllerIMsgBackupUICallback;
      if (??? != null) {
        ???.a(i, MsgBackupManager.jdField_b_of_type_Int);
      }
      if (i == MsgBackupManager.jdField_b_of_type_Int) {
        return;
      }
      if (!a(2))
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
    if (MsgBackupUtil.jdField_b_of_type_Boolean) {
      paramString1 = MsgBackupUtil.a(paramString2, this.jdField_a_of_type_JavaLangString);
    }
    MsgBackupReporter.a();
    paramString2 = MsgBackupManager.a().g;
    ConcurrentHashMap localConcurrentHashMap = MsgBackupManager.a().jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("httpGetReached, MsgBackupManager.curDealType = ");
      localStringBuilder.append(MsgBackupManager.jdField_d_of_type_JavaLangString);
      localStringBuilder.append(", MsgBackupManager.curDealType = ");
      localStringBuilder.append(MsgBackupManager.jdField_c_of_type_Int);
      QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, localStringBuilder.toString());
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy != null) && (paramString1 != null))
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
    if (MsgBackupUtil.jdField_b_of_type_Boolean) {
      paramString1 = MsgBackupUtil.b(paramString1, this.jdField_b_of_type_ArrayOfJavaLangString[0], this.jdField_d_of_type_JavaLangInteger.intValue(), this.jdField_a_of_type_JavaLangString);
    }
    Object localObject = MsgBackupManager.a().g;
    MsgBackupSessionTask localMsgBackupSessionTask = (MsgBackupSessionTask)((ConcurrentHashMap)localObject).get(Long.valueOf(paramLong1));
    ConcurrentHashMap localConcurrentHashMap = MsgBackupManager.a().jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap;
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
      localStringBuilder.append(MsgBackupManager.jdField_b_of_type_Int);
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
    paramArrayOfByte = MsgBackupUtil.b(MsgBackupManager.jdField_d_of_type_JavaLangString, MsgBackupUtil.b(MsgBackupManager.jdField_c_of_type_Int));
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
      paramArrayOfByte = paramString1.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap;
      localObject = paramString1.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
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
    boolean bool1 = a();
    int i = 0;
    if (bool1)
    {
      MsgBackupUtil.b("getmsg onSendComplete operator is closed! please clear handler msg!........", new Object[0]);
      return;
    }
    boolean bool2 = this.jdField_a_of_type_Boolean;
    if (this.jdField_a_of_type_ComTencentMobileqqMsgbackupControllerIMsgBackupUICallback != null) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    MsgBackupUtil.b("MsgBackup_MsgBackupTransportProcessor", "getmsg isTransportStart = %b, mCallBack is not null = %b", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqMsgbackupControllerIMsgBackupUICallback;
    if ((localObject1 != null) && (!this.jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_Boolean = true;
      ((IMsgBackupUICallback)localObject1).c(true);
    }
    localObject1 = MsgBackupUtil.a(paramString);
    long l = Long.parseLong((String)((Map)localObject1).get("fid"));
    if (!MsgBackupManager.jdField_f_of_type_Boolean)
    {
      paramString = new MsgBackupSessionTask();
      paramString.jdField_a_of_type_Short = 0;
      paramString.jdField_a_of_type_Boolean = false;
      paramString.jdField_a_of_type_JavaLangString = "[]";
      paramString.jdField_a_of_type_Long = paramLong;
      if (QLog.isColorLevel())
      {
        paramConcurrentHashMap1 = new StringBuilder();
        paramConcurrentHashMap1.append("httpGetReached, getmsg ui is not ready!");
        paramConcurrentHashMap1.append(l);
        paramConcurrentHashMap1.append(", msg = ");
        paramConcurrentHashMap1.append("[]");
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, paramConcurrentHashMap1.toString());
      }
      paramConcurrentHashMap.put(Long.valueOf(l), paramString);
      this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy.b(this.jdField_a_of_type_Long, paramLong, l, "[]");
      return;
    }
    paramString = new MsgBackupReportData.ServerFileDetail();
    paramString.jdField_a_of_type_Boolean = false;
    paramString.jdField_a_of_type_Long = 0L;
    MsgBackupManager.a().jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap.put(Long.valueOf(l), paramString);
    paramString = (String)((Map)localObject1).get("chatUin");
    int j = Integer.parseInt((String)((Map)localObject1).get("chatType"));
    localObject1 = MsgBackupUtil.a(paramString, j, null);
    ??? = new MsgBackupSessionTask();
    ((MsgBackupSessionTask)???).jdField_a_of_type_Short = 0;
    ((MsgBackupSessionTask)???).jdField_a_of_type_Boolean = true;
    ((MsgBackupSessionTask)???).jdField_a_of_type_Long = paramLong;
    ((MsgBackupSessionTask)???).jdField_b_of_type_JavaLangString = ((String)localObject1);
    paramConcurrentHashMap.put(Long.valueOf(l), ???);
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      paramConcurrentHashMap1 = paramConcurrentHashMap1.values().iterator();
      while (paramConcurrentHashMap1.hasNext()) {
        if (((MsgBackupSessionInfo)paramConcurrentHashMap1.next()).jdField_c_of_type_Boolean) {
          i += 1;
        }
      }
      paramConcurrentHashMap1 = this.jdField_a_of_type_ComTencentMobileqqMsgbackupControllerIMsgBackupUICallback;
      if (paramConcurrentHashMap1 != null) {
        paramConcurrentHashMap1.a(i, MsgBackupManager.jdField_b_of_type_Int);
      }
      this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy.a(this.jdField_a_of_type_Long, paramLong, l, (String)localObject1);
      if (QLog.isColorLevel())
      {
        paramConcurrentHashMap1 = new StringBuilder();
        paramConcurrentHashMap1.append("onHttpRequest, send db uin = ");
        paramConcurrentHashMap1.append(paramString);
        paramConcurrentHashMap1.append(", uinType = ");
        paramConcurrentHashMap1.append(MsgBackupUtil.c(j));
        paramConcurrentHashMap1.append(", dbpath = ");
        paramConcurrentHashMap1.append((String)localObject1);
        paramConcurrentHashMap1.append(", fid = ");
        paramConcurrentHashMap1.append(l);
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
    int i = paramConcurrentHashMap2.size();
    int j = paramConcurrentHashMap1.size();
    if (QLog.isColorLevel())
    {
      paramConcurrentHashMap1 = new StringBuilder();
      paramConcurrentHashMap1.append("ResReq receivedCompleted  called success, isResRequestAllFinished ");
      paramConcurrentHashMap1.append(???.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
      paramConcurrentHashMap1.append(", task = ");
      paramConcurrentHashMap1.append(paramMsgBackupSessionTask);
      paramConcurrentHashMap1.append(", resMList.size = ");
      paramConcurrentHashMap1.append(i);
      QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, paramConcurrentHashMap1.toString());
    }
    if ((i == 0) && (j == 0) && (???.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()))
    {
      ???.jdField_c_of_type_Boolean = true;
      a(???);
      if (QLog.isColorLevel())
      {
        ??? = new StringBuilder();
        ???.append("last session transport completed!, uin = ");
        ???.append(MsgBackupManager.jdField_d_of_type_JavaLangString);
        ???.append(", uintype = ");
        ???.append(MsgBackupManager.jdField_c_of_type_Int);
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
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        paramConcurrentHashMap = paramConcurrentHashMap.values().iterator();
        i = 0;
        while (paramConcurrentHashMap.hasNext()) {
          if (((MsgBackupSessionInfo)paramConcurrentHashMap.next()).jdField_c_of_type_Boolean) {
            i += 1;
          }
        }
        paramConcurrentHashMap = this.jdField_a_of_type_ComTencentMobileqqMsgbackupControllerIMsgBackupUICallback;
        if (paramConcurrentHashMap != null) {
          paramConcurrentHashMap.a(i, MsgBackupManager.jdField_b_of_type_Int);
        }
        if (i == MsgBackupManager.jdField_b_of_type_Int) {
          return;
        }
        if (!a(2))
        {
          MsgBackupUtil.b("this session res has received! so get next session!", new Object[0]);
          j(3);
          return;
        }
      }
    }
  }
  
  private void b(long paramLong, ConcurrentHashMap<Long, MsgBackupSessionTask> paramConcurrentHashMap, Map<String, String> paramMap)
  {
    if (a())
    {
      MsgBackupUtil.b("httpGetReached postinfo operator is closed! please clear handler msg!........", new Object[0]);
      return;
    }
    long l = Long.parseLong((String)paramMap.get("fid"));
    if (this.jdField_a_of_type_JavaLangInteger.intValue() != 0)
    {
      this.jdField_a_of_type_ArrayOfJavaLangString[0] = ((String)paramMap.get("ip"));
      this.jdField_a_of_type_JavaLangInteger = Integer.valueOf(Integer.parseInt((String)paramMap.get("udpport")));
    }
    if (this.jdField_b_of_type_JavaLangInteger.intValue() != 0)
    {
      this.jdField_a_of_type_ArrayOfJavaLangString[0] = ((String)paramMap.get("ip"));
      this.jdField_b_of_type_JavaLangInteger = Integer.valueOf(Integer.parseInt((String)paramMap.get("tcpport")));
    }
    if (QLog.isColorLevel())
    {
      paramMap = new StringBuilder();
      paramMap.append("httpGetReached, client report its port and ipv4, fid = ");
      paramMap.append(l);
      paramMap.append(", msg = []");
      QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, paramMap.toString());
    }
    a(paramLong, paramConcurrentHashMap, l, a(l, 2));
  }
  
  private void b(String paramString1, int paramInt1, int paramInt2, String paramString2, long paramLong)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("recvMessageUdp udpdetected = ");
      localStringBuilder.append(this.jdField_c_of_type_Boolean);
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
      g(paramString2);
      return;
    }
    if (paramInt2 == 258)
    {
      f(paramString2);
      return;
    }
    if (paramInt2 == 259) {
      e(paramString2);
    }
  }
  
  private String c()
  {
    JSONArray localJSONArray = new JSONArray();
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("cmd", "exit");
      localJSONObject.put("sig", MsgBackupAuthProcessor.a().a());
      localJSONArray.put(localJSONObject);
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return localJSONArray.toString();
  }
  
  private void c(long paramLong, String paramString, ConcurrentHashMap<Long, MsgBackupSessionTask> paramConcurrentHashMap, ConcurrentHashMap<String, MsgBackupSessionInfo> paramConcurrentHashMap1)
  {
    if (a())
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
    paramString = MsgBackupUtil.a(paramString);
    if (a(paramLong, paramConcurrentHashMap, paramString)) {
      return;
    }
    if (paramString.size() == 1)
    {
      a(paramLong, paramConcurrentHashMap, paramString);
      return;
    }
    if (!TextUtils.isEmpty((CharSequence)paramString.get("exit")))
    {
      c(paramLong, paramConcurrentHashMap, paramString);
      return;
    }
    if (paramString.size() == 4)
    {
      b(paramLong, paramConcurrentHashMap, paramString);
      return;
    }
    a(paramLong, paramConcurrentHashMap, paramConcurrentHashMap1, paramString);
  }
  
  private void c(long paramLong, ConcurrentHashMap<Long, MsgBackupSessionTask> paramConcurrentHashMap, Map<String, String> paramMap)
  {
    if (a())
    {
      MsgBackupUtil.b("httpGetReached postinfo operator is closed! please clear handler msg!........", new Object[0]);
      return;
    }
    long l = Long.parseLong((String)paramMap.get("fid"));
    if (!TextUtils.isEmpty((String)paramMap.get("exit")))
    {
      paramMap = this.jdField_a_of_type_ComTencentMobileqqMsgbackupControllerIMsgBackupUICallback;
      if (paramMap != null) {
        paramMap.h_(true);
      }
    }
    paramMap = new MsgBackupSessionTask();
    paramMap.jdField_a_of_type_Short = 0;
    paramMap.jdField_a_of_type_Boolean = false;
    paramMap.jdField_a_of_type_JavaLangString = "[]";
    paramMap.jdField_a_of_type_Long = paramLong;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("httpGetReached, notify has exit!, fid = ");
      localStringBuilder.append(l);
      localStringBuilder.append(", msg = ");
      localStringBuilder.append("[]");
      QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, localStringBuilder.toString());
    }
    paramConcurrentHashMap.put(Long.valueOf(l), paramMap);
    this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy.b(this.jdField_a_of_type_Long, paramLong, l, "[]");
  }
  
  private void e(String paramString)
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
          if ((TextUtils.equals(paramString, MsgBackupAuthProcessor.a().a())) && (this.jdField_a_of_type_ComTencentMobileqqMsgbackupControllerIMsgBackupUICallback != null))
          {
            this.jdField_a_of_type_ComTencentMobileqqMsgbackupControllerIMsgBackupUICallback.h_(true);
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
  
  private void f()
  {
    this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy.stop(this.jdField_a_of_type_Long);
    this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy.destroySession(this.jdField_a_of_type_Long);
    this.jdField_a_of_type_Long = 0L;
    MsgBackupTransportExecutor.a().a();
  }
  
  private void f(String arg1)
  {
    for (;;)
    {
      int i;
      try
      {
        Object localObject1 = MsgBackupManager.a().jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap;
        ??? = new JSONArray(???);
        i = ???.length();
        int j = 0;
        if (i >= 1)
        {
          i = 0;
          if (i < ???.length())
          {
            Object localObject3 = (JSONObject)???.get(i);
            ((JSONObject)localObject3).optString("cmd");
            String str = ((JSONObject)localObject3).optString("chatUin");
            int k = ((JSONObject)localObject3).optInt("chatType");
            Object localObject4 = MsgBackupUtil.b(str, k);
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
                ((StringBuilder)localObject4).append(MsgBackupUtil.c(k));
                QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, ((StringBuilder)localObject4).toString());
              }
              ((MsgBackupSessionInfo)localObject3).jdField_c_of_type_Boolean = true;
              break label392;
            }
            if (!QLog.isColorLevel()) {
              break label392;
            }
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("client notify this session has received success! chatUin = ");
            ((StringBuilder)localObject3).append(str);
            ((StringBuilder)localObject3).append(", chatType = ");
            ((StringBuilder)localObject3).append(k);
            QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, ((StringBuilder)localObject3).toString());
            break label392;
          }
        }
        synchronized (this.jdField_a_of_type_JavaLangObject)
        {
          localObject1 = ((ConcurrentHashMap)localObject1).values().iterator();
          i = j;
          if (((Iterator)localObject1).hasNext())
          {
            if (!((MsgBackupSessionInfo)((Iterator)localObject1).next()).jdField_c_of_type_Boolean) {
              continue;
            }
            i += 1;
            continue;
          }
          if (this.jdField_a_of_type_ComTencentMobileqqMsgbackupControllerIMsgBackupUICallback != null)
          {
            this.jdField_a_of_type_ComTencentMobileqqMsgbackupControllerIMsgBackupUICallback.a(i, MsgBackupManager.jdField_b_of_type_Int);
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
      i += 1;
    }
  }
  
  private void g(String paramString)
  {
    for (;;)
    {
      int i;
      try
      {
        ConcurrentHashMap localConcurrentHashMap = MsgBackupManager.a().jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap;
        paramString = new JSONArray(paramString);
        if (paramString.length() >= 1)
        {
          i = 0;
          if (i < paramString.length())
          {
            Object localObject = (JSONObject)paramString.get(i);
            String str = ((JSONObject)localObject).optString("cmd");
            if ("chat_list_count".equals(str))
            {
              MsgBackupManager.jdField_b_of_type_Int = ((JSONObject)localObject).optInt("listCount");
              MsgBackupReporter.a();
              MsgBackupReporter.a.jdField_b_of_type_Long = MsgBackupManager.jdField_b_of_type_Int;
            }
            if (!"chat_ready".equals(str)) {
              break label220;
            }
            str = ((JSONObject)localObject).optString("chatUin");
            int j = ((JSONObject)localObject).optInt("chatType");
            long l = ((JSONObject)localObject).optLong("dbSize");
            localObject = new MsgBackupSessionInfo();
            ((MsgBackupSessionInfo)localObject).jdField_c_of_type_Boolean = false;
            ((MsgBackupSessionInfo)localObject).jdField_b_of_type_Boolean = false;
            ((MsgBackupSessionInfo)localObject).jdField_a_of_type_JavaLangString = str;
            ((MsgBackupSessionInfo)localObject).jdField_a_of_type_Int = MsgBackupUtil.c(j);
            ((MsgBackupSessionInfo)localObject).jdField_a_of_type_Long = l;
            str = MsgBackupUtil.b(((MsgBackupSessionInfo)localObject).jdField_a_of_type_JavaLangString, j);
            if (localConcurrentHashMap.get(str) != null) {
              break label220;
            }
            localConcurrentHashMap.put(str, localObject);
            break label220;
          }
          a(3);
          return;
        }
      }
      catch (JSONException paramString)
      {
        QLog.e("MsgBackup_MsgBackupTransportProcessor", 2, "MBR_UDP_CMD_SYNC_RECV_DONE parse json error!", paramString);
      }
      return;
      label220:
      i += 1;
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_JavaLangInteger.intValue();
  }
  
  public String a()
  {
    return this.jdField_a_of_type_ArrayOfJavaLangString[0];
  }
  
  public String a(int paramInt, long paramLong)
  {
    Object localObject1 = new JSONArray();
    if ((paramInt == 256) || (paramInt == 257)) {}
    for (;;)
    {
      try
      {
        if (!MsgBackupManager.jdField_f_of_type_Boolean)
        {
          localObject1 = ((JSONArray)localObject1).toString();
          ??? = MsgBackupManager.a().jdField_f_of_type_JavaUtilConcurrentConcurrentHashMap;
          localObject4 = new MsgBackupSessionTask();
          ((MsgBackupSessionTask)localObject4).jdField_a_of_type_JavaLangString = ((String)localObject1);
          ((MsgBackupSessionTask)localObject4).jdField_a_of_type_Int = paramInt;
          ((MsgBackupSessionTask)localObject4).jdField_a_of_type_Short = 0;
          ((ConcurrentHashMap)???).put(Long.valueOf(paramLong), localObject4);
          if (!QLog.isColorLevel()) {
            continue;
          }
          ??? = new StringBuilder();
          ((StringBuilder)???).append("MsgBackupManager.sUIReady = ");
          ((StringBuilder)???).append(MsgBackupManager.jdField_f_of_type_Boolean);
          ((StringBuilder)???).append(", getSessionJson is called! cookie = ");
          ((StringBuilder)???).append(paramLong);
          ((StringBuilder)???).append(", msg = ");
          ((StringBuilder)???).append((String)localObject1);
          QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, ((StringBuilder)???).toString());
          return localObject1;
        }
        ??? = MsgBackupManager.a().jdField_a_of_type_JavaUtilHashSet;
        Object localObject4 = MsgBackupManager.a().jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap;
        i = MsgBackupManager.jdField_b_of_type_Int;
        if (((ConcurrentHashMap)localObject4).size() > 0)
        {
          ??? = new JSONObject();
          ((JSONObject)???).put("cmd", "chat_list_count");
          ((JSONObject)???).put("listCount", i);
          ((JSONArray)localObject1).put(???);
          Object localObject5;
          Object localObject6;
          synchronized (this.jdField_a_of_type_JavaLangObject)
          {
            localObject4 = ((ConcurrentHashMap)localObject4).values().iterator();
            j = 0;
            if (((Iterator)localObject4).hasNext())
            {
              localObject5 = (MsgBackupSessionInfo)((Iterator)localObject4).next();
              i = j;
              if (((MsgBackupSessionInfo)localObject5).jdField_c_of_type_Boolean) {
                i = j + 1;
              }
              if (((MsgBackupSessionInfo)localObject5).jdField_a_of_type_Boolean) {
                continue;
              }
              localObject6 = ((MsgBackupSessionInfo)localObject5).jdField_a_of_type_JavaLangString;
              j = ((MsgBackupSessionInfo)localObject5).jdField_a_of_type_Int;
              JSONObject localJSONObject = new JSONObject();
              localJSONObject.put("cmd", "chat_ready");
              localJSONObject.put("chatUin", localObject6);
              localJSONObject.put("chatType", MsgBackupUtil.b(j));
              localJSONObject.put("dbSize", ((MsgBackupSessionInfo)localObject5).jdField_a_of_type_Long);
              ((JSONArray)localObject1).put(localJSONObject);
              ((MsgBackupSessionInfo)localObject5).jdField_a_of_type_Boolean = true;
              continue;
            }
            if (this.jdField_a_of_type_ComTencentMobileqqMsgbackupControllerIMsgBackupUICallback == null) {
              continue;
            }
            this.jdField_a_of_type_ComTencentMobileqqMsgbackupControllerIMsgBackupUICallback.a(j, MsgBackupManager.jdField_b_of_type_Int);
          }
          if (paramInt == 258)
          {
            ??? = MsgBackupManager.a().jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
            if (((Iterator)???).hasNext())
            {
              localObject4 = (MsgBackupSessionInfo)((Iterator)???).next();
              if ((((MsgBackupSessionInfo)localObject4).jdField_d_of_type_Boolean) || (!((MsgBackupSessionInfo)localObject4).jdField_c_of_type_Boolean)) {
                continue;
              }
              localObject5 = ((MsgBackupSessionInfo)localObject4).jdField_a_of_type_JavaLangString;
              i = ((MsgBackupSessionInfo)localObject4).jdField_a_of_type_Int;
              localObject6 = new JSONObject();
              ((JSONObject)localObject6).put("cmd", "chat_transfer_complete");
              ((JSONObject)localObject6).put("chatUin", localObject5);
              ((JSONObject)localObject6).put("chatType", MsgBackupUtil.b(i));
              localObject2.put(localObject6);
              ((MsgBackupSessionInfo)localObject4).jdField_d_of_type_Boolean = true;
              continue;
            }
          }
          else if (paramInt == 259)
          {
            ??? = new JSONObject();
            ((JSONObject)???).put("cmd", "exit");
            ((JSONObject)???).put("sig", MsgBackupAuthProcessor.a().a());
            localObject2.put(???);
          }
        }
        str = localObject2.toString();
        ??? = MsgBackupManager.a().jdField_f_of_type_JavaUtilConcurrentConcurrentHashMap;
        localObject4 = new MsgBackupSessionTask();
        ((MsgBackupSessionTask)localObject4).jdField_a_of_type_JavaLangString = str;
        ((MsgBackupSessionTask)localObject4).jdField_a_of_type_Int = paramInt;
        ((MsgBackupSessionTask)localObject4).jdField_a_of_type_Short = 0;
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
        int i;
        int j;
        String str;
        continue;
      }
      str.printStackTrace();
      return "[]";
      return str;
      j = i;
    }
  }
  
  public String a(String paramString)
  {
    return MsgBackupUtil.a(paramString, this.jdField_b_of_type_ArrayOfJavaLangString[0], this.jdField_d_of_type_JavaLangInteger.intValue(), this.jdField_a_of_type_JavaLangString);
  }
  
  public void a()
  {
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_c_of_type_Long = 0L;
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_JavaLangInteger = Integer.valueOf(paramInt);
  }
  
  public void a(long paramLong1, long paramLong2, long paramLong3)
  {
    MsgBackupTimeStats.a(paramLong1, paramLong2);
    if (this.jdField_b_of_type_Long > 0L)
    {
      paramLong2 = SystemClock.elapsedRealtime() - this.jdField_b_of_type_Long;
      if (paramLong2 > 1500L)
      {
        long l = this.jdField_c_of_type_Long;
        IMsgBackupUICallback localIMsgBackupUICallback = this.jdField_a_of_type_ComTencentMobileqqMsgbackupControllerIMsgBackupUICallback;
        if (localIMsgBackupUICallback != null)
        {
          paramLong2 = (paramLong3 + l) * 1000L / paramLong2;
          localIMsgBackupUICallback.a(paramLong2);
          MsgBackupTimeStats.b(paramLong1, paramLong2);
        }
        this.jdField_c_of_type_Long = 0L;
        this.jdField_b_of_type_Long = SystemClock.elapsedRealtime();
        return;
      }
      this.jdField_c_of_type_Long += paramLong3;
      return;
    }
    this.jdField_b_of_type_Long = SystemClock.elapsedRealtime();
    this.jdField_c_of_type_Long += paramLong3;
  }
  
  public void a(long paramLong, String paramString1, int paramInt, String paramString2)
  {
    if (this.jdField_a_of_type_Int == 2) {
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
    if (MsgBackupManager.a().e.containsKey(Long.valueOf(paramLong1)))
    {
      paramString = (MsgBackupReportData.ServerFileDetail)MsgBackupManager.a().e.get(Long.valueOf(paramLong1));
      if ((paramString != null) && (!paramString.jdField_a_of_type_Boolean))
      {
        paramString.jdField_a_of_type_Boolean = true;
        paramString.jdField_a_of_type_Long = paramLong3;
        paramString = MsgBackupReporter.a;
        paramString.e += paramLong3;
      }
    }
    else if (MsgBackupManager.a().jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Long.valueOf(paramLong1)))
    {
      paramString = (MsgBackupReportData.ServerFileDetail)MsgBackupManager.a().jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramLong1));
      if ((paramString != null) && (!paramString.jdField_a_of_type_Boolean))
      {
        paramString.jdField_a_of_type_Boolean = true;
        paramString.jdField_a_of_type_Long = paramLong3;
        paramString = MsgBackupReporter.a;
        paramString.f += paramLong3;
      }
    }
    if (this.jdField_b_of_type_Long > 0L)
    {
      paramLong2 = SystemClock.elapsedRealtime() - this.jdField_b_of_type_Long;
      if (paramLong2 > 1500L)
      {
        paramLong3 = this.jdField_c_of_type_Long;
        paramString = this.jdField_a_of_type_ComTencentMobileqqMsgbackupControllerIMsgBackupUICallback;
        if (paramString != null)
        {
          paramLong2 = (paramLong4 + paramLong3) * 1000L / paramLong2;
          paramString.a(paramLong2);
          MsgBackupTimeStats.b(paramLong1, paramLong2);
        }
        this.jdField_c_of_type_Long = 0L;
        this.jdField_b_of_type_Long = SystemClock.elapsedRealtime();
        return;
      }
      this.jdField_c_of_type_Long += paramLong4;
      return;
    }
    this.jdField_b_of_type_Long = SystemClock.elapsedRealtime();
    this.jdField_c_of_type_Long += paramLong4;
  }
  
  public void a(long paramLong1, String paramString, long paramLong2, long paramLong3, long paramLong4) {}
  
  public void a(long paramLong1, boolean paramBoolean, int paramInt1, String paramString, int paramInt2, int paramInt3, long paramLong2)
  {
    MsgBackupTimeStats.a(paramLong1);
    MsgBackupReporter.a();
    if (MsgBackupManager.a().e.containsKey(Long.valueOf(paramLong1)))
    {
      localObject = (MsgBackupReportData.ServerFileDetail)MsgBackupManager.a().e.get(Long.valueOf(paramLong1));
      if (localObject != null)
      {
        boolean bool = MsgBackupUtil.a(((MsgBackupReportData.ServerFileDetail)localObject).jdField_a_of_type_Long);
        if (bool)
        {
          localObject = MsgBackupReporter.a;
          ((MsgBackupReportData)localObject).j += 1L;
        }
        if (!paramBoolean)
        {
          localObject = MsgBackupReporter.a;
          ((MsgBackupReportData)localObject).r += 1L;
          localObject = new MsgBackupReportData.FileError();
          ((MsgBackupReportData.FileError)localObject).jdField_b_of_type_Int = 2;
          if (bool) {
            paramInt2 = 2;
          } else {
            paramInt2 = 1;
          }
          ((MsgBackupReportData.FileError)localObject).jdField_c_of_type_Int = paramInt2;
          ((MsgBackupReportData.FileError)localObject).jdField_a_of_type_Int = paramInt1;
          MsgBackupReporter.a.a.add(localObject);
          if (bool)
          {
            localObject = MsgBackupReporter.a;
            ((MsgBackupReportData)localObject).k += 1L;
          }
        }
      }
      MsgBackupManager.a().e.remove(Long.valueOf(paramLong1));
    }
    else if (MsgBackupManager.a().jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Long.valueOf(paramLong1)))
    {
      if ((MsgBackupReportData.ServerFileDetail)MsgBackupManager.a().jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramLong1)) != null)
      {
        localObject = MsgBackupReporter.a;
        ((MsgBackupReportData)localObject).m += 1L;
        if (!paramBoolean)
        {
          localObject = MsgBackupReporter.a;
          ((MsgBackupReportData)localObject).n += 1L;
          localObject = MsgBackupReporter.a;
          ((MsgBackupReportData)localObject).r += 1L;
          localObject = new MsgBackupReportData.FileError();
          ((MsgBackupReportData.FileError)localObject).jdField_b_of_type_Int = 1;
          ((MsgBackupReportData.FileError)localObject).jdField_c_of_type_Int = 0;
          ((MsgBackupReportData.FileError)localObject).jdField_a_of_type_Int = paramInt1;
          MsgBackupReporter.a.a.add(localObject);
        }
      }
      MsgBackupManager.a().jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Long.valueOf(paramLong1));
    }
    Object localObject = MsgBackupManager.a().g;
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
      else if (localMsgBackupSessionTask.jdField_a_of_type_Boolean)
      {
        if (QLog.isColorLevel())
        {
          paramString = new StringBuilder();
          paramString.append("fileTask onSendComplete  called not success, so again  task = ");
          paramString.append(localMsgBackupSessionTask);
          QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, paramString.toString());
        }
        if (!TextUtils.isEmpty(localMsgBackupSessionTask.jdField_b_of_type_JavaLangString))
        {
          if (localMsgBackupSessionTask.jdField_a_of_type_Short > 3)
          {
            paramString = new StringBuilder();
            paramString.append("onSendComplete fileTask  retry over time task = ");
            paramString.append(localMsgBackupSessionTask);
            QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, paramString.toString());
            ((ConcurrentHashMap)localObject).remove(Long.valueOf(paramLong1));
            return;
          }
          if (a())
          {
            MsgBackupUtil.b("fileTask onSendComplete operator is closed! please clear handler msg!........", new Object[0]);
            return;
          }
          localMsgBackupSessionTask.jdField_a_of_type_Short = ((short)(localMsgBackupSessionTask.jdField_a_of_type_Short + 1));
          this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy.a(this.jdField_a_of_type_Long, localMsgBackupSessionTask.jdField_a_of_type_Long, paramLong1, localMsgBackupSessionTask.jdField_b_of_type_JavaLangString);
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
        if (!TextUtils.isEmpty(localMsgBackupSessionTask.jdField_a_of_type_JavaLangString))
        {
          if (localMsgBackupSessionTask.jdField_a_of_type_Short > 3)
          {
            paramString = new StringBuilder();
            paramString.append("onSendComplete retry over time task = ");
            paramString.append(localMsgBackupSessionTask);
            QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, paramString.toString());
            ((ConcurrentHashMap)localObject).remove(Long.valueOf(paramLong1));
            return;
          }
          if (a())
          {
            MsgBackupUtil.b("onSendComplete operator is closed! please clear handler msg!........", new Object[0]);
            return;
          }
          localMsgBackupSessionTask.jdField_a_of_type_Short = ((short)(localMsgBackupSessionTask.jdField_a_of_type_Short + 1));
          this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy.b(this.jdField_a_of_type_Long, localMsgBackupSessionTask.jdField_a_of_type_Long, paramLong1, localMsgBackupSessionTask.jdField_a_of_type_JavaLangString);
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
    if ((this.jdField_d_of_type_JavaLangInteger.intValue() != 0) && (this.jdField_c_of_type_JavaLangInteger.intValue() != 0))
    {
      if ((this.jdField_a_of_type_Int == 1) && (this.jdField_d_of_type_Boolean))
      {
        if (a())
        {
          MsgBackupUtil.b("requestNotifyServer called------>MBRROLE_CLIENT  operator is closed! please clear handler msg!........", new Object[0]);
          return;
        }
        Object localObject;
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("requestNotifyServer, isTcpDetected = ");
          ((StringBuilder)localObject).append(this.jdField_d_of_type_Boolean);
          QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, ((StringBuilder)localObject).toString());
        }
        long l = MsgBackupUtil.a();
        if (!TextUtils.isEmpty(paramString))
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("postinfo?fid=");
          ((StringBuilder)localObject).append(l);
          ((StringBuilder)localObject).append("&chatUin=");
          ((StringBuilder)localObject).append(paramString);
          ((StringBuilder)localObject).append("&chatType=");
          ((StringBuilder)localObject).append(MsgBackupUtil.b(paramInt));
          paramString = ((StringBuilder)localObject).toString();
          MsgBackupUtil.b("MsgBackup_MsgBackupTransportProcessor", paramString, new Object[0]);
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(MsgBackupUtil.a(this.jdField_b_of_type_ArrayOfJavaLangString[0], this.jdField_d_of_type_JavaLangInteger.intValue()));
          ((StringBuilder)localObject).append(MsgBackupUtil.b(paramString, this.jdField_a_of_type_JavaLangString));
          paramString = ((StringBuilder)localObject).toString();
        }
        for (;;)
        {
          break;
          if (paramBoolean)
          {
            paramString = new StringBuilder();
            paramString.append("postinfo?fid=");
            paramString.append(l);
            paramString.append("&ip=");
            paramString.append(this.jdField_a_of_type_ArrayOfJavaLangString[0]);
            paramString.append("&tcpport=");
            paramString.append(this.jdField_b_of_type_JavaLangInteger);
            paramString.append("&udpport=");
            paramString.append(this.jdField_a_of_type_JavaLangInteger);
            paramString = paramString.toString();
            MsgBackupUtil.b("MsgBackup_MsgBackupTransportProcessor", paramString, new Object[0]);
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(MsgBackupUtil.a(this.jdField_b_of_type_ArrayOfJavaLangString[0], this.jdField_d_of_type_JavaLangInteger.intValue()));
            ((StringBuilder)localObject).append(MsgBackupUtil.b(paramString, this.jdField_a_of_type_JavaLangString));
            paramString = ((StringBuilder)localObject).toString();
          }
          else
          {
            paramString = new StringBuilder();
            paramString.append("postinfo?fid=");
            paramString.append(l);
            paramString = paramString.toString();
            MsgBackupUtil.b("MsgBackup_MsgBackupTransportProcessor", paramString, new Object[0]);
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(MsgBackupUtil.a(this.jdField_b_of_type_ArrayOfJavaLangString[0], this.jdField_d_of_type_JavaLangInteger.intValue()));
            ((StringBuilder)localObject).append(MsgBackupUtil.b(paramString, this.jdField_a_of_type_JavaLangString));
            paramString = ((StringBuilder)localObject).toString();
          }
        }
        if ((!TextUtils.isEmpty(paramString)) && (this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy != null))
        {
          localObject = new MsgBackupSessionTask();
          ((MsgBackupSessionTask)localObject).jdField_a_of_type_Short = 0;
          ((MsgBackupSessionTask)localObject).jdField_a_of_type_Boolean = false;
          ((MsgBackupSessionTask)localObject).c = paramString;
          MsgBackupManager.a().g.put(Long.valueOf(l), localObject);
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("requestNotifyServer fid = ");
            ((StringBuilder)localObject).append(l);
            ((StringBuilder)localObject).append(", url = ");
            ((StringBuilder)localObject).append(paramString);
            QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, ((StringBuilder)localObject).toString());
          }
          this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy.a(paramLong, l, paramString);
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
    this.jdField_a_of_type_ComTencentMobileqqMsgbackupControllerIMsgBackupUICallback = paramIMsgBackupUICallback;
  }
  
  public void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      MsgBackupManager.a().a();
      MsgBackupUtil.a();
      if (this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupNotifier == null) {
        this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupNotifier = new MsgBackupNotifier();
      }
      MsgBackupManager.a().jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
      e(1);
      MsgBackupManager.a().jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
      ThreadManager.getSubThreadHandler().post(new MsgBackupTransportProcessor.1(this, paramString));
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    int i = this.jdField_a_of_type_Int;
    if (i == 1)
    {
      if (this.jdField_a_of_type_JavaLangInteger.intValue() != 0) {
        this.jdField_a_of_type_JavaLangInteger = Integer.valueOf(paramInt);
      }
    }
    else if ((i == 2) && (this.jdField_c_of_type_JavaLangInteger.intValue() != 0)) {
      this.jdField_c_of_type_JavaLangInteger = Integer.valueOf(paramInt);
    }
  }
  
  public void a(String paramString1, int paramInt1, int paramInt2, String paramString2, long paramLong)
  {
    b(paramString1, paramInt1, paramInt2, paramString2, paramLong);
  }
  
  public void a(String paramString1, int paramInt, String paramString2)
  {
    MsgBackupManager.a().a();
    MsgBackupUtil.a();
    MsgBackupManager.a().a().a(paramInt);
    MsgBackupManager.a().a().a(paramString2);
    MsgBackupManager.a().jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    e(1);
    if (paramInt == 1)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupNotifier == null) {
        this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupNotifier = new MsgBackupNotifier();
      }
      ThreadManager.getSubThreadHandler().post(new MsgBackupTransportProcessor.3(this, paramString1));
    }
    if (paramInt == 2)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupNotifier == null) {
        this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupNotifier = new MsgBackupNotifier();
      }
      ThreadManager.getSubThreadHandler().post(new MsgBackupTransportProcessor.4(this, paramString1));
    }
  }
  
  public void a(String paramString1, String paramString2, long paramLong)
  {
    if (a())
    {
      MsgBackupUtil.b("clientGetResFile called---> operator is closed! please clear handler msg!........", new Object[0]);
      return;
    }
    MsgBackupReporter.a();
    Object localObject1 = MsgBackupReporter.a;
    ((MsgBackupReportData)localObject1).g += 1L;
    localObject1 = MsgBackupManager.a().jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap;
    if ((paramString1 == null) && (paramString2 == null))
    {
      MsgBackupUtil.b("MsgBackup_MsgBackupTransportProcessor", "clientGetResFile MsgBackupManager.curDealUin = %s, MsgBackupManager.curDealType = %d", new Object[] { MsgBackupManager.jdField_d_of_type_JavaLangString, Integer.valueOf(MsgBackupManager.jdField_c_of_type_Int) });
      paramString1 = (MsgBackupSessionInfo)((ConcurrentHashMap)localObject1).get(MsgBackupUtil.b(MsgBackupManager.jdField_d_of_type_JavaLangString, MsgBackupUtil.b(MsgBackupManager.jdField_c_of_type_Int)));
      if (paramString1 != null)
      {
        MsgBackupUtil.b("MsgBackup_MsgBackupTransportProcessor", "clientGetResFile sessionInfo is not null reslist size = %d, dbsize = %d", new Object[] { Integer.valueOf(paramString1.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size()), Integer.valueOf(paramString1.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.size()) });
        if ((paramString1.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size() == 0) && (paramString1.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.size() == 0)) {
          a(6);
        }
        paramString1.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
      }
      return;
    }
    new File(paramString2).getParentFile().mkdirs();
    long l = MsgBackupUtil.a();
    paramString1 = MsgBackupUtil.b(String.format("getres?fid=%d&filepath=%s", new Object[] { Long.valueOf(l), paramString1 }), this.jdField_a_of_type_JavaLangString);
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(MsgBackupUtil.a(this.jdField_b_of_type_ArrayOfJavaLangString[0], this.jdField_d_of_type_JavaLangInteger.intValue()));
    ((StringBuilder)localObject2).append(paramString1);
    paramString1 = ((StringBuilder)localObject2).toString();
    localObject2 = new MsgBackupSessionTask();
    ((MsgBackupSessionTask)localObject2).jdField_a_of_type_Short = 0;
    ((MsgBackupSessionTask)localObject2).jdField_a_of_type_Boolean = true;
    ((MsgBackupSessionTask)localObject2).jdField_b_of_type_JavaLangString = paramString2;
    ((MsgBackupSessionTask)localObject2).c = paramString1;
    ((MsgBackupSessionTask)localObject2).jdField_b_of_type_Boolean = MsgBackupUtil.a(paramLong);
    ((MsgBackupSessionTask)localObject2).jdField_b_of_type_Long = paramLong;
    MsgBackupReportData localMsgBackupReportData = MsgBackupReporter.a;
    localMsgBackupReportData.e += paramLong;
    localObject1 = (MsgBackupSessionInfo)((ConcurrentHashMap)localObject1).get(MsgBackupUtil.b(MsgBackupManager.jdField_d_of_type_JavaLangString, MsgBackupUtil.b(MsgBackupManager.jdField_c_of_type_Int)));
    if (localObject1 != null) {
      ((MsgBackupSessionInfo)localObject1).jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Long.valueOf(l), localObject2);
    }
    this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy.a(this.jdField_a_of_type_Long, l, paramString1, paramString2, ((MsgBackupSessionTask)localObject2).jdField_b_of_type_Boolean, ((MsgBackupSessionTask)localObject2).jdField_b_of_type_Long, true);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    MsgBackupManager.a().a();
    MsgBackupUtil.a();
    if (this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupNotifier == null) {
      this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupNotifier = new MsgBackupNotifier();
    }
    e(1);
    ThreadManager.getSubThreadHandler().post(new MsgBackupTransportProcessor.2(this, paramString, paramBoolean));
  }
  
  protected void a(ConcurrentHashMap<String, MsgBackupSessionInfo> paramConcurrentHashMap)
  {
    if (!TextUtils.isEmpty(MsgBackupManager.jdField_d_of_type_JavaLangString))
    {
      MsgBackupSessionInfo localMsgBackupSessionInfo = (MsgBackupSessionInfo)paramConcurrentHashMap.get(MsgBackupUtil.b(MsgBackupManager.jdField_d_of_type_JavaLangString, MsgBackupUtil.b(MsgBackupManager.jdField_c_of_type_Int)));
      if (localMsgBackupSessionInfo != null)
      {
        localMsgBackupSessionInfo.jdField_c_of_type_Boolean = true;
        MsgBackupUtil.b("MsgBackup_MsgBackupTransportProcessor", "requestNextSessionDb MsgBackupController MsgBackupManager.curDealUin = %s, MsgBackupManager.curDealType = %d", new Object[] { MsgBackupManager.jdField_d_of_type_JavaLangString, Integer.valueOf(MsgBackupManager.jdField_c_of_type_Int) });
        a(localMsgBackupSessionInfo);
        if (this.jdField_a_of_type_ComTencentMobileqqMsgbackupControllerIMsgBackupUICallback != null)
        {
          int i = a(paramConcurrentHashMap);
          paramConcurrentHashMap = this.jdField_a_of_type_ComTencentMobileqqMsgbackupControllerIMsgBackupUICallback;
          if (paramConcurrentHashMap != null) {
            paramConcurrentHashMap.a(i, MsgBackupManager.jdField_b_of_type_Int);
          }
          if (i == MsgBackupManager.jdField_b_of_type_Int) {
            paramConcurrentHashMap = this.jdField_a_of_type_ComTencentMobileqqMsgbackupControllerIMsgBackupUICallback;
          }
        }
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
    MsgBackupReporter.a();
    MsgBackupReporter.a.jdField_b_of_type_Boolean = this.jdField_c_of_type_Boolean;
  }
  
  public void a(boolean paramBoolean, long paramLong1, long paramLong2)
  {
    int i = this.jdField_a_of_type_Int;
    Object localObject;
    MsgBackupSessionTask localMsgBackupSessionTask;
    StringBuilder localStringBuilder;
    if (2 == i)
    {
      localObject = MsgBackupManager.a().jdField_f_of_type_JavaUtilConcurrentConcurrentHashMap;
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
        if (a())
        {
          if (QLog.isColorLevel()) {
            QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "onSendMessage role = MBRROLE_CLIENT: panic error!");
          }
          return;
        }
        if (localMsgBackupSessionTask.jdField_a_of_type_Short > 3)
        {
          ((ConcurrentHashMap)localObject).remove(Long.valueOf(paramLong1));
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(" mfidMlist fileTask receivedCompleted retry over time task = ");
          ((StringBuilder)localObject).append(localMsgBackupSessionTask);
          QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, ((StringBuilder)localObject).toString());
          return;
        }
        localMsgBackupSessionTask.jdField_a_of_type_Short = ((short)(localMsgBackupSessionTask.jdField_a_of_type_Short + 1));
        localObject = localMsgBackupSessionTask.jdField_a_of_type_JavaLangString;
        i = localMsgBackupSessionTask.jdField_a_of_type_Int;
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("onSendMessage role = MBRROLE_CLIENT: ");
          localStringBuilder.append(localMsgBackupSessionTask);
          QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, localStringBuilder.toString());
        }
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy.a(this.jdField_a_of_type_Long, i, (String)localObject, paramLong1);
        }
      }
    }
    else if (1 == i)
    {
      localObject = MsgBackupManager.a().jdField_f_of_type_JavaUtilConcurrentConcurrentHashMap;
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
        if (a())
        {
          if (QLog.isColorLevel()) {
            QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "onSendMessage role = MBRROLE_CLIENT: panic error!");
          }
          return;
        }
        if (localMsgBackupSessionTask.jdField_a_of_type_Short > 3)
        {
          ((ConcurrentHashMap)localObject).remove(Long.valueOf(paramLong1));
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(" mfidMlist fileTask receivedCompleted retry over time task = ");
          ((StringBuilder)localObject).append(localMsgBackupSessionTask);
          QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, ((StringBuilder)localObject).toString());
          return;
        }
        localObject = localMsgBackupSessionTask.jdField_a_of_type_JavaLangString;
        i = localMsgBackupSessionTask.jdField_a_of_type_Int;
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("onSendMessage  role = MBRROLE_CLIENT: ");
          localStringBuilder.append(localMsgBackupSessionTask);
          QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, localStringBuilder.toString());
        }
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy.a(this.jdField_a_of_type_Long, i, (String)localObject, paramLong1);
        }
      }
    }
  }
  
  protected boolean a()
  {
    return this.jdField_a_of_type_Long == 0L;
  }
  
  public boolean a(int paramInt)
  {
    try
    {
      if ((!this.jdField_d_of_type_Boolean) && (paramInt == 3))
      {
        this.e = true;
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
      Object localObject1 = MsgBackupManager.a().jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap;
      if ((paramInt == 1) || (paramInt == 6)) {
        a((ConcurrentHashMap)localObject1);
      }
      boolean bool;
      if (!TextUtils.isEmpty(MsgBackupManager.jdField_d_of_type_JavaLangString)) {
        bool = a((ConcurrentHashMap)localObject1);
      } else {
        bool = b((ConcurrentHashMap)localObject1);
      }
      if ((((ConcurrentHashMap)localObject1).size() == 0) || (TextUtils.isEmpty(MsgBackupManager.jdField_d_of_type_JavaLangString)))
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
        ((StringBuilder)localObject1).append(MsgBackupManager.jdField_b_of_type_Int);
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, ((StringBuilder)localObject1).toString());
      }
      return bool;
    }
    finally {}
  }
  
  protected boolean a(ConcurrentHashMap<String, MsgBackupSessionInfo> paramConcurrentHashMap)
  {
    Object localObject = (MsgBackupSessionInfo)paramConcurrentHashMap.get(MsgBackupUtil.b(MsgBackupManager.jdField_d_of_type_JavaLangString, MsgBackupUtil.b(MsgBackupManager.jdField_c_of_type_Int)));
    if (localObject != null)
    {
      if (((MsgBackupSessionInfo)localObject).jdField_c_of_type_Boolean)
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(" requestNextSessionDb !, last uin = ");
          ((StringBuilder)localObject).append(MsgBackupManager.jdField_d_of_type_JavaLangString);
          ((StringBuilder)localObject).append(", uintype = ");
          ((StringBuilder)localObject).append(MsgBackupManager.jdField_c_of_type_Int);
          QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, ((StringBuilder)localObject).toString());
        }
        return a(paramConcurrentHashMap, false);
      }
      if (QLog.isColorLevel())
      {
        paramConcurrentHashMap = new StringBuilder();
        paramConcurrentHashMap.append("current session not completed! requestNextSessionDb !, current uin = ");
        paramConcurrentHashMap.append(MsgBackupManager.jdField_d_of_type_JavaLangString);
        paramConcurrentHashMap.append(", uintype = ");
        paramConcurrentHashMap.append(MsgBackupManager.jdField_c_of_type_Int);
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, paramConcurrentHashMap.toString());
      }
    }
    return false;
  }
  
  public int b()
  {
    return this.jdField_b_of_type_JavaLangInteger.intValue();
  }
  
  public String b()
  {
    return this.jdField_b_of_type_ArrayOfJavaLangString[0];
  }
  
  public void b()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onDestroy called! operator = ");
      localStringBuilder.append(this.jdField_a_of_type_Long);
      QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, localStringBuilder.toString());
    }
    a();
    e(2);
  }
  
  public void b(int paramInt)
  {
    this.jdField_b_of_type_JavaLangInteger = Integer.valueOf(paramInt);
  }
  
  public void b(String paramString)
  {
    this.jdField_a_of_type_ArrayOfJavaLangString[0] = paramString;
  }
  
  public void b(String paramString, int paramInt) {}
  
  public void b(boolean paramBoolean)
  {
    IMsgBackupUICallback localIMsgBackupUICallback = this.jdField_a_of_type_ComTencentMobileqqMsgbackupControllerIMsgBackupUICallback;
    if (localIMsgBackupUICallback != null) {
      localIMsgBackupUICallback.h_(paramBoolean);
    }
  }
  
  public boolean b()
  {
    return this.jdField_d_of_type_Boolean;
  }
  
  protected boolean b(ConcurrentHashMap<String, MsgBackupSessionInfo> paramConcurrentHashMap)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(" requestNextSessionDb !, last uin = ");
      ((StringBuilder)localObject1).append(MsgBackupManager.jdField_d_of_type_JavaLangString);
      ((StringBuilder)localObject1).append(", uintype = ");
      ((StringBuilder)localObject1).append(MsgBackupManager.jdField_c_of_type_Int);
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
        } while (((MsgBackupSessionInfo)localObject1).jdField_b_of_type_Boolean);
        if (((MsgBackupSessionInfo)localObject1).jdField_a_of_type_Long > 0L) {
          break;
        }
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(" requestNextSessionDb !,  curDealUin  null! dbsize 等于 0 ！客户端不会去请求了，只是通知server端，该会话已经接受完成了！uin = ");
          localStringBuilder.append(((MsgBackupSessionInfo)localObject1).jdField_a_of_type_JavaLangString);
          localStringBuilder.append(", uintype = ");
          localStringBuilder.append(((MsgBackupSessionInfo)localObject1).jdField_a_of_type_Int);
          localStringBuilder.append(", dbSize = ");
          localStringBuilder.append(((MsgBackupSessionInfo)localObject1).jdField_a_of_type_Long);
          QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, localStringBuilder.toString());
        }
        ((MsgBackupSessionInfo)localObject1).jdField_c_of_type_Boolean = true;
        ((MsgBackupSessionInfo)localObject1).jdField_b_of_type_Boolean = true;
        a((MsgBackupSessionInfo)localObject1);
      } while (this.jdField_a_of_type_ComTencentMobileqqMsgbackupControllerIMsgBackupUICallback == null);
      i = a(paramConcurrentHashMap);
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqMsgbackupControllerIMsgBackupUICallback;
      if ((localObject1 != null) && (!this.jdField_a_of_type_Boolean))
      {
        this.jdField_a_of_type_Boolean = true;
        ((IMsgBackupUICallback)localObject1).c(true);
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqMsgbackupControllerIMsgBackupUICallback;
      if (localObject1 != null) {
        ((IMsgBackupUICallback)localObject1).a(i, MsgBackupManager.jdField_b_of_type_Int);
      }
    } while ((i != MsgBackupManager.jdField_b_of_type_Int) || (this.jdField_a_of_type_ComTencentMobileqqMsgbackupControllerIMsgBackupUICallback == null));
    MsgBackupUtil.b("MsgBackup_MsgBackupTransportProcessor", "session transport completed! dbSize is 0------------->", new Object[0]);
    return false;
    ((MsgBackupSessionInfo)localObject1).jdField_b_of_type_Boolean = true;
    MsgBackupManager.jdField_d_of_type_JavaLangString = ((MsgBackupSessionInfo)localObject1).jdField_a_of_type_JavaLangString;
    MsgBackupManager.jdField_c_of_type_Int = ((MsgBackupSessionInfo)localObject1).jdField_a_of_type_Int;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(" requestNextSessionDb !, uin = ");
      ((StringBuilder)localObject2).append(MsgBackupManager.jdField_d_of_type_JavaLangString);
      ((StringBuilder)localObject2).append(", uintype = ");
      ((StringBuilder)localObject2).append(MsgBackupManager.jdField_c_of_type_Int);
      ((StringBuilder)localObject2).append(", dbsize = ");
      ((StringBuilder)localObject2).append(((MsgBackupSessionInfo)localObject1).jdField_a_of_type_Long);
      QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, ((StringBuilder)localObject2).toString());
    }
    int i = a(paramConcurrentHashMap);
    paramConcurrentHashMap = this.jdField_a_of_type_ComTencentMobileqqMsgbackupControllerIMsgBackupUICallback;
    if ((paramConcurrentHashMap != null) && (!this.jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_Boolean = true;
      paramConcurrentHashMap.c(true);
    }
    paramConcurrentHashMap = this.jdField_a_of_type_ComTencentMobileqqMsgbackupControllerIMsgBackupUICallback;
    if (paramConcurrentHashMap != null) {
      paramConcurrentHashMap.a(i, MsgBackupManager.jdField_b_of_type_Int);
    }
    if (i == MsgBackupManager.jdField_b_of_type_Int)
    {
      MsgBackupUtil.b("MsgBackup_MsgBackupTransportProcessor", "session transport completed!------------->", new Object[0]);
      return false;
    }
    a(this.jdField_a_of_type_Long, ((MsgBackupSessionInfo)localObject1).jdField_a_of_type_JavaLangString, ((MsgBackupSessionInfo)localObject1).jdField_a_of_type_Int, false);
    boolean bool1 = true;
    return bool1;
  }
  
  public int c()
  {
    return this.jdField_c_of_type_JavaLangInteger.intValue();
  }
  
  public void c()
  {
    int i = MsgBackupAuthProcessor.a().a();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("exit ---------> bizType = ");
      localStringBuilder.append(i);
      QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, localStringBuilder.toString());
    }
    if (i == 3)
    {
      d();
      return;
    }
    if (i == 1)
    {
      e();
      return;
    }
    e();
  }
  
  public void c(int paramInt)
  {
    this.jdField_c_of_type_JavaLangInteger = Integer.valueOf(paramInt);
  }
  
  public void c(String paramString)
  {
    this.jdField_b_of_type_ArrayOfJavaLangString[0] = paramString;
  }
  
  public void c(String paramString, int paramInt) {}
  
  public int d()
  {
    return this.jdField_d_of_type_JavaLangInteger.intValue();
  }
  
  public void d()
  {
    Object localObject1 = c();
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("exitUdpNotify create exit : ");
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(", isUdpDetected = ");
      ((StringBuilder)localObject2).append(this.jdField_c_of_type_Boolean);
      QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, ((StringBuilder)localObject2).toString());
    }
    if (this.jdField_c_of_type_Boolean)
    {
      i(259);
      return;
    }
    if (this.jdField_a_of_type_Int == 1) {
      if ((this.jdField_d_of_type_JavaLangInteger.intValue() != 0) && (this.jdField_c_of_type_JavaLangInteger.intValue() != 0))
      {
        if (this.jdField_d_of_type_Boolean)
        {
          if (a())
          {
            MsgBackupUtil.b("exiNotifyForTransfer called------> operator is closed! please clear handler msg!........", new Object[0]);
            return;
          }
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("exitForTcp, isTcpDetected = ");
            ((StringBuilder)localObject1).append(this.jdField_d_of_type_Boolean);
            QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, ((StringBuilder)localObject1).toString());
          }
          long l = MsgBackupUtil.a();
          localObject1 = MsgBackupUtil.a(this.jdField_b_of_type_ArrayOfJavaLangString[0], this.jdField_d_of_type_JavaLangInteger.intValue());
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("postinfo?fid=");
          ((StringBuilder)localObject2).append(l);
          ((StringBuilder)localObject2).append("&exit=1");
          localObject2 = ((StringBuilder)localObject2).toString();
          MsgBackupUtil.b("MsgBackup_MsgBackupTransportProcessor", (String)localObject2, new Object[0]);
          localObject2 = MsgBackupUtil.b((String)localObject2, this.jdField_a_of_type_JavaLangString);
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append((String)localObject1);
          localStringBuilder.append((String)localObject2);
          localObject1 = localStringBuilder.toString();
          if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy != null))
          {
            localObject2 = new MsgBackupSessionTask();
            ((MsgBackupSessionTask)localObject2).jdField_a_of_type_Short = 0;
            ((MsgBackupSessionTask)localObject2).jdField_a_of_type_Boolean = false;
            ((MsgBackupSessionTask)localObject2).c = ((String)localObject1);
            MsgBackupManager.a().g.put(Long.valueOf(l), localObject2);
            if (QLog.isColorLevel())
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("exitForTcp fid = ");
              ((StringBuilder)localObject2).append(l);
              ((StringBuilder)localObject2).append(", url = ");
              ((StringBuilder)localObject2).append((String)localObject1);
              QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, ((StringBuilder)localObject2).toString());
            }
            this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy.a(this.jdField_a_of_type_Long, l, (String)localObject1);
          }
        }
      }
      else if (QLog.isColorLevel()) {
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "exitForTcp called- for client-------------->>>");
      }
    }
  }
  
  public void d(int paramInt)
  {
    this.jdField_d_of_type_JavaLangInteger = Integer.valueOf(paramInt);
  }
  
  public void d(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void d(String paramString, int paramInt) {}
  
  public int e()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void e()
  {
    Object localObject1 = c();
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("exitUdpNotify create exit : ");
      ((StringBuilder)localObject2).append((String)localObject1);
      QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, ((StringBuilder)localObject2).toString());
    }
    if (this.jdField_c_of_type_Boolean)
    {
      i(259);
      return;
    }
    localObject1 = new JSONArray();
    Object localObject2 = new JSONObject();
    try
    {
      ((JSONObject)localObject2).put("cmd", "exit");
      ((JSONObject)localObject2).put("sig", MsgBackupAuthProcessor.a().a());
      ((JSONArray)localObject1).put(localObject2);
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    MsgBackupPushHandler.a().a(((JSONArray)localObject1).toString());
  }
  
  public void e(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy != null) && (!a()))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("stop called! operator = ");
        localStringBuilder.append(this.jdField_a_of_type_Long);
        localStringBuilder.append(". from = ");
        localStringBuilder.append(paramInt);
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, localStringBuilder.toString());
      }
      MsgBackupManager.a().b();
      if (Looper.getMainLooper() == Looper.myLooper())
      {
        ThreadManager.getSubThreadHandler().post(new MsgBackupTransportProcessor.5(this));
        return;
      }
      f();
    }
  }
  
  public void f(int paramInt)
  {
    if (a())
    {
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "setPeekPoint start panic error!");
      }
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy != null)
    {
      StringBuilder localStringBuilder;
      if (paramInt == 2)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "setPeekPoint start for MBRROLE_SERVER");
        }
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("setPeekPoint clientIP = ");
        localStringBuilder.append(a());
        localStringBuilder.append(", clientUdpPort = ");
        localStringBuilder.append(this.jdField_a_of_type_JavaLangInteger);
        localStringBuilder.append(", clientTcpPort = ");
        localStringBuilder.append(this.jdField_b_of_type_JavaLangInteger);
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, localStringBuilder.toString());
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("setPeekPoint serverIP = ");
        localStringBuilder.append(b());
        localStringBuilder.append(", serverUdpPort = ");
        localStringBuilder.append(this.jdField_c_of_type_JavaLangInteger);
        localStringBuilder.append(", serverTcpPort = ");
        localStringBuilder.append(this.jdField_d_of_type_JavaLangInteger);
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, localStringBuilder.toString());
        this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy.setPeerEndpoint(this.jdField_a_of_type_Long, this.jdField_a_of_type_ArrayOfJavaLangString, this.jdField_a_of_type_JavaLangInteger.intValue(), this.jdField_b_of_type_JavaLangInteger.intValue());
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "setPeekPoint start for MBRROLE_CLIENT");
        }
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("setPeekPoint clientIP = ");
        localStringBuilder.append(a());
        localStringBuilder.append(", clientUdpPort = ");
        localStringBuilder.append(this.jdField_a_of_type_JavaLangInteger);
        localStringBuilder.append(", clientTcpPort = ");
        localStringBuilder.append(this.jdField_b_of_type_JavaLangInteger);
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, localStringBuilder.toString());
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("setPeekPoint serverIP = ");
        localStringBuilder.append(b());
        localStringBuilder.append(", serverUdpPort = ");
        localStringBuilder.append(this.jdField_c_of_type_JavaLangInteger);
        localStringBuilder.append(", serverTcpPort = ");
        localStringBuilder.append(this.jdField_d_of_type_JavaLangInteger);
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, localStringBuilder.toString());
        this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy.setPeerEndpoint(this.jdField_a_of_type_Long, this.jdField_b_of_type_ArrayOfJavaLangString, this.jdField_c_of_type_JavaLangInteger.intValue(), this.jdField_d_of_type_JavaLangInteger.intValue());
      }
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("setPeekPoint end， operator = ");
        localStringBuilder.append(this.jdField_a_of_type_Long);
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, localStringBuilder.toString());
      }
    }
  }
  
  public void g(int paramInt)
  {
    if (a())
    {
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "setEncryptKey panic error!");
      }
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy != null)
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
      this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_JavaLangString);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("setEncryptKey end， session = ");
        localStringBuilder.append(this.jdField_a_of_type_Long);
        localStringBuilder.append(", encryptkey = ");
        localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, localStringBuilder.toString());
      }
    }
  }
  
  public void h(int paramInt)
  {
    if (paramInt != 0) {
      this.jdField_d_of_type_Boolean = true;
    } else {
      this.jdField_d_of_type_Boolean = false;
    }
    if (this.jdField_d_of_type_Boolean) {
      MsgBackupTimeStats.a("cost_connect_total", null);
    }
    MsgBackupReporter.a();
    MsgBackupReporter.a.jdField_d_of_type_Int = paramInt;
    IMsgBackupUICallback localIMsgBackupUICallback = this.jdField_a_of_type_ComTencentMobileqqMsgbackupControllerIMsgBackupUICallback;
    if (localIMsgBackupUICallback != null) {
      localIMsgBackupUICallback.a(this.jdField_d_of_type_Boolean);
    }
    if ((this.jdField_d_of_type_Boolean) && (this.e))
    {
      this.e = false;
      MsgBackupUtil.b("MsgBackup_MsgBackupTransportProcessor", "tcp is disconnect!, before has cached this request msg, so request again!", new Object[0]);
      a(3);
    }
    j(2);
  }
  
  public void i(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy != null)
    {
      Object localObject;
      if (this.jdField_c_of_type_Boolean)
      {
        if (a())
        {
          if (QLog.isColorLevel()) {
            QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "sendMessageUdp panic error!");
          }
          return;
        }
        long l = MsgBackupUtil.a();
        localObject = a(paramInt, l);
        this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy.a(this.jdField_a_of_type_Long, paramInt, (String)localObject, l);
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("sendMessageUdp udpdetected = ");
          ((StringBuilder)localObject).append(this.jdField_c_of_type_Boolean);
          ((StringBuilder)localObject).append(", cmd = ");
          ((StringBuilder)localObject).append(paramInt);
          ((StringBuilder)localObject).append(", cookieIndex = ");
          ((StringBuilder)localObject).append(l);
          QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, ((StringBuilder)localObject).toString());
        }
      }
      else if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("sendMessageUdp is error! please use tcp get! udpdetected = ");
        ((StringBuilder)localObject).append(this.jdField_c_of_type_Boolean);
        ((StringBuilder)localObject).append(", cmd = ");
        ((StringBuilder)localObject).append(paramInt);
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  public void j(int paramInt)
  {
    if ((this.jdField_d_of_type_JavaLangInteger.intValue() != 0) && (this.jdField_c_of_type_JavaLangInteger.intValue() != 0))
    {
      if ((this.jdField_a_of_type_Int == 1) && (this.jdField_d_of_type_Boolean))
      {
        if (a())
        {
          MsgBackupUtil.b("requestSessionList called------>MBRROLE_CLIENT  operator is closed! please clear handler msg!........", new Object[0]);
          return;
        }
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("requestSessionList is called! isTcpDetected = ");
          ((StringBuilder)localObject1).append(this.jdField_d_of_type_Boolean);
          ((StringBuilder)localObject1).append(", from = ");
          ((StringBuilder)localObject1).append(paramInt);
          QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, ((StringBuilder)localObject1).toString());
        }
        if (!this.jdField_b_of_type_Boolean)
        {
          this.jdField_b_of_type_Boolean = true;
          a(this.jdField_a_of_type_Long, true, "", 0);
        }
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("requestSessionList, isTcpDetected = ");
          ((StringBuilder)localObject1).append(this.jdField_d_of_type_Boolean);
          ((StringBuilder)localObject1).append(", client will get ready session list from server------>");
          QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, ((StringBuilder)localObject1).toString());
        }
        long l = MsgBackupUtil.a();
        Object localObject1 = MsgBackupUtil.a(this.jdField_b_of_type_ArrayOfJavaLangString[0], this.jdField_d_of_type_JavaLangInteger.intValue());
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("postinfo?fid=");
        ((StringBuilder)localObject2).append(l);
        localObject2 = ((StringBuilder)localObject2).toString();
        MsgBackupUtil.b("MsgBackup_MsgBackupTransportProcessor", (String)localObject2, new Object[0]);
        localObject2 = MsgBackupUtil.b((String)localObject2, this.jdField_a_of_type_JavaLangString);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append((String)localObject1);
        localStringBuilder.append((String)localObject2);
        localObject1 = localStringBuilder.toString();
        if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy != null))
        {
          localObject2 = new MsgBackupSessionTask();
          ((MsgBackupSessionTask)localObject2).jdField_a_of_type_Boolean = false;
          ((MsgBackupSessionTask)localObject2).jdField_a_of_type_Short = 0;
          ((MsgBackupSessionTask)localObject2).c = ((String)localObject1);
          MsgBackupManager.a().g.put(Long.valueOf(l), localObject2);
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("requestSessionList fid = ");
            ((StringBuilder)localObject2).append(l);
            ((StringBuilder)localObject2).append(", url = ");
            ((StringBuilder)localObject2).append((String)localObject1);
            QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, ((StringBuilder)localObject2).toString());
          }
          this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy.a(this.jdField_a_of_type_Long, l, (String)localObject1);
        }
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "requestNotifyServer server ip and port is not set! this method will be called in processConfirmRsp!");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.transport.MsgBackupTransportProcessor
 * JD-Core Version:    0.7.0.1
 */