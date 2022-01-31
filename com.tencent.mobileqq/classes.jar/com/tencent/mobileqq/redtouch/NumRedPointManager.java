package com.tencent.mobileqq.redtouch;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.tencent.mobileqq.app.NumRedPointHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RedpointHandler;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.ReportReqBody;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.ReportStaticsData;
import com.tencent.pb.getnumred.NumRedPoint.NumRedBusi;
import com.tencent.pb.getnumred.NumRedPoint.NumRedPath;
import com.tencent.pb.getnumred.NumRedPoint.NumRedRspBody;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.s2c.msgtype0x210.submsgtype0x89.Submsgtype0x89.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x89.Submsgtype0x89.NumRedBusiInfo;

public class NumRedPointManager
  implements Manager
{
  public static String[][] a;
  protected QQAppInterface a;
  private NumRedPoint.NumRedRspBody jdField_a_of_type_ComTencentPbGetnumredNumRedPoint$NumRedRspBody;
  Object jdField_a_of_type_JavaLangObject = new Object();
  private ConcurrentHashMap jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private ConcurrentHashMap b = new ConcurrentHashMap();
  
  static
  {
    jdField_a_of_type_Array2dOfJavaLangString = new String[][] { { "100510", "0" }, { "100007.102000", "1" } };
  }
  
  public NumRedPointManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private int a(String paramString1, String paramString2)
  {
    int k = -1;
    int i;
    if ((paramString1 == null) || (paramString2 == null))
    {
      i = -2;
      return i;
    }
    String[] arrayOfString1 = paramString1.split("\\.");
    String[] arrayOfString2 = paramString2.split("\\.");
    int j = 0;
    for (;;)
    {
      try
      {
        if ((j < arrayOfString1.length) && (j < arrayOfString2.length))
        {
          m = Integer.parseInt(arrayOfString1[j]);
          int n = Integer.parseInt(arrayOfString2[j]);
          i = k;
          if (m < n) {
            break;
          }
          if (m <= n) {
            break label130;
          }
          return 1;
        }
        if (arrayOfString1.length > j) {
          return 1;
        }
        int m = arrayOfString2.length;
        i = k;
        if (m > j) {
          break;
        }
        return 0;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        localNumberFormatException.printStackTrace();
        return paramString1.compareTo(paramString2);
      }
      label130:
      j += 1;
    }
  }
  
  private NumRedPoint.NumRedBusi a(int paramInt)
  {
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        Object localObject1 = b();
        if (localObject1 == null)
        {
          a("getNumRedBusiInfoByAppId : numRedBusiList == null ");
          return null;
        }
        Iterator localIterator = ((List)localObject1).iterator();
        if (localIterator.hasNext())
        {
          localObject1 = (NumRedPoint.NumRedBusi)localIterator.next();
          if (paramInt != ((NumRedPoint.NumRedBusi)localObject1).uint32_appid.get()) {
            continue;
          }
          if (localObject1 == null)
          {
            a("getNumRedBusiInfoByAppId : cannot find the info by appid");
            return null;
          }
          return localObject1;
        }
      }
      Object localObject3 = null;
    }
  }
  
  private NumRedPoint.NumRedBusi a(Submsgtype0x89.NumRedBusiInfo paramNumRedBusiInfo)
  {
    if (paramNumRedBusiInfo == null)
    {
      a("numRedPushInfo2NumRedBusi : busiInfo is null");
      return null;
    }
    NumRedPoint.NumRedBusi localNumRedBusi = new NumRedPoint.NumRedBusi();
    localNumRedBusi.uint32_appid.set(paramNumRedBusiInfo.uint32_android_app_id.get());
    localNumRedBusi.i_new_flag.set(0);
    localNumRedBusi.uint32_modify_ts.set(0);
    localNumRedBusi.int32_appset.set(paramNumRedBusiInfo.int32_appset.get());
    ArrayList localArrayList = new ArrayList();
    NumRedPoint.NumRedPath localNumRedPath = new NumRedPoint.NumRedPath();
    localNumRedPath.str_path.set(paramNumRedBusiInfo.str_android_path.get());
    localNumRedPath.str_missionid.set(paramNumRedBusiInfo.str_missionid.get());
    localNumRedPath.uint64_msgid.set(paramNumRedBusiInfo.uint64_msgid.get());
    localNumRedPath.uint32_msg_status.set(paramNumRedBusiInfo.uint32_status.get());
    localNumRedPath.uint32_expire_time.set(paramNumRedBusiInfo.uint32_expire_time.get());
    localNumRedPath.uint32_push_num_red_ts.set((int)(System.currentTimeMillis() / 1000L));
    localArrayList.add(localNumRedPath);
    localNumRedBusi.rpt_num_red_path.set(localArrayList);
    return localNumRedBusi;
  }
  
  private ToServiceMsg a(String paramString)
  {
    return new ToServiceMsg("mobileqq.service", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramString);
  }
  
  private List a(NumRedPoint.NumRedBusi paramNumRedBusi)
  {
    if (paramNumRedBusi == null)
    {
      a("getNumRedPathList : mNumRed is null");
      return null;
    }
    return paramNumRedBusi.rpt_num_red_path.get();
  }
  
  private void a(int paramInt1, List paramList, int paramInt2, String paramString)
  {
    a("onReport : appid == " + paramInt1 + ",msgIs == " + paramList + ",data == " + paramString);
    BusinessInfoCheckUpdate.ReportReqBody localReportReqBody = new BusinessInfoCheckUpdate.ReportReqBody();
    localReportReqBody.uin.set(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()));
    localReportReqBody.clientver.set("7.6.0.3525");
    localReportReqBody.platid.set(109);
    ArrayList localArrayList = new ArrayList();
    localReportReqBody.missionid.set(localArrayList);
    localReportReqBody.appid.set(paramInt1);
    localReportReqBody.platver.set(Build.VERSION.SDK_INT + "");
    localReportReqBody.msgids.set(paramList);
    localArrayList = new ArrayList();
    try
    {
      paramList = new JSONObject();
      if (paramList != null) {}
      try
      {
        paramList.put("cmd", paramInt2);
        JSONObject localJSONObject = new JSONObject(paramString);
        paramString = paramList;
        if (localJSONObject == null) {
          break label295;
        }
        Iterator localIterator = localJSONObject.keys();
        for (;;)
        {
          paramString = paramList;
          if (!localIterator.hasNext()) {
            break;
          }
          paramString = (String)localIterator.next();
          BusinessInfoCheckUpdate.ReportStaticsData localReportStaticsData = new BusinessInfoCheckUpdate.ReportStaticsData();
          localReportStaticsData.key.set(paramString);
          localReportStaticsData.value.set(localJSONObject.getString(paramString));
          localArrayList.add(localReportStaticsData);
        }
        paramString.printStackTrace();
      }
      catch (JSONException paramString) {}
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        label295:
        paramList = null;
      }
    }
    paramString = paramList;
    if (paramString != null) {
      localReportReqBody.buffer.set(paramString.toString());
    }
    localReportReqBody.reportdata.set(localArrayList);
    paramList = a("RedTouchSvc.ClientReport");
    paramList.putWupBuffer(localReportReqBody.toByteArray());
    a(paramList);
  }
  
  private final void a(ToServiceMsg paramToServiceMsg)
  {
    if (paramToServiceMsg == null) {
      return;
    }
    paramToServiceMsg.extraData.putBoolean("req_pb_protocol_flag", true);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.sendToService(paramToServiceMsg);
  }
  
  private void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NumRedPointManager", 2, paramString);
    }
  }
  
  private boolean a(NumRedPoint.NumRedRspBody paramNumRedRspBody)
  {
    try
    {
      a("saveRsp2File : startime==" + System.currentTimeMillis());
      boolean bool = FileUtils.a(new File(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getFilesDir(), "NumRedShowFileName_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()).getAbsolutePath(), paramNumRedRspBody.toByteArray(), false);
      a("saveRsp2File : endtime==" + System.currentTimeMillis());
      c(paramNumRedRspBody);
      b();
      c();
      a(100, true, paramNumRedRspBody);
      return bool;
    }
    finally
    {
      paramNumRedRspBody = finally;
      throw paramNumRedRspBody;
    }
  }
  
  private boolean a(Submsgtype0x89.NumRedBusiInfo paramNumRedBusiInfo)
  {
    if (paramNumRedBusiInfo == null) {}
    while ((paramNumRedBusiInfo.uint32_plat_id.get() != 109) && (paramNumRedBusiInfo.uint32_plat_id.get() != 109110)) {
      return false;
    }
    return true;
  }
  
  private int b(int paramInt1, int paramInt2)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      Object localObject2 = a(paramInt1);
      if (localObject2 == null)
      {
        a("getNumFromFileByAppid : cannot find the info by appid");
        return 0;
      }
      localObject2 = ((NumRedPoint.NumRedBusi)localObject2).rpt_num_red_path.get();
      if (localObject2 == null)
      {
        a("getNumFromFileByAppid : path list is null");
        return 0;
      }
    }
    Iterator localIterator = localObject3.iterator();
    paramInt1 = 0;
    for (;;)
    {
      NumRedPoint.NumRedPath localNumRedPath;
      int i;
      if (localIterator.hasNext())
      {
        localNumRedPath = (NumRedPoint.NumRedPath)localIterator.next();
        i = paramInt1;
        if (100 == paramInt2)
        {
          if (localNumRedPath.uint32_msg_status.get() == 0) {
            break label166;
          }
          i = paramInt1;
          if (1 == localNumRedPath.uint32_msg_status.get()) {
            break label166;
          }
        }
      }
      for (;;)
      {
        if (localNumRedPath.uint32_msg_status.get() == paramInt2)
        {
          paramInt1 = i + 1;
          break;
          return paramInt1;
        }
        paramInt1 = i;
        break;
        label166:
        i = paramInt1 + 1;
      }
    }
  }
  
  /* Error */
  private int b(String paramString, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 43	com/tencent/mobileqq/redtouch/NumRedPointManager:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   4: astore 6
    //   6: aload 6
    //   8: monitorenter
    //   9: aload_1
    //   10: ifnonnull +8 -> 18
    //   13: aload 6
    //   15: monitorexit
    //   16: iconst_m1
    //   17: ireturn
    //   18: aload_0
    //   19: invokevirtual 70	com/tencent/mobileqq/redtouch/NumRedPointManager:b	()Ljava/util/List;
    //   22: astore 7
    //   24: aload 7
    //   26: ifnonnull +15 -> 41
    //   29: aload_0
    //   30: ldc_w 428
    //   33: invokespecial 75	com/tencent/mobileqq/redtouch/NumRedPointManager:a	(Ljava/lang/String;)V
    //   36: aload 6
    //   38: monitorexit
    //   39: iconst_0
    //   40: ireturn
    //   41: aload 7
    //   43: invokeinterface 81 1 0
    //   48: astore 7
    //   50: iconst_0
    //   51: istore 4
    //   53: aload 7
    //   55: invokeinterface 87 1 0
    //   60: ifeq +134 -> 194
    //   63: aload 7
    //   65: invokeinterface 91 1 0
    //   70: checkcast 93	com/tencent/pb/getnumred/NumRedPoint$NumRedBusi
    //   73: getfield 198	com/tencent/pb/getnumred/NumRedPoint$NumRedBusi:rpt_num_red_path	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   76: invokevirtual 221	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   79: astore 8
    //   81: aload 8
    //   83: ifnull -30 -> 53
    //   86: iconst_0
    //   87: istore 5
    //   89: iload 4
    //   91: istore_3
    //   92: iload_3
    //   93: istore 4
    //   95: iload 5
    //   97: aload 8
    //   99: invokeinterface 431 1 0
    //   104: if_icmpge -51 -> 53
    //   107: aload 8
    //   109: iload 5
    //   111: invokeinterface 434 2 0
    //   116: checkcast 138	com/tencent/pb/getnumred/NumRedPoint$NumRedPath
    //   119: astore 9
    //   121: iload_3
    //   122: istore 4
    //   124: bipush 100
    //   126: iload_2
    //   127: if_icmpne +32 -> 159
    //   130: aload 9
    //   132: getfield 173	com/tencent/pb/getnumred/NumRedPoint$NumRedPath:uint32_msg_status	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   135: invokevirtual 103	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   138: ifeq +74 -> 212
    //   141: iload_3
    //   142: istore 4
    //   144: iconst_1
    //   145: aload 9
    //   147: getfield 173	com/tencent/pb/getnumred/NumRedPoint$NumRedPath:uint32_msg_status	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   150: invokevirtual 103	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   153: if_icmpne +6 -> 159
    //   156: goto +56 -> 212
    //   159: aload 9
    //   161: getfield 143	com/tencent/pb/getnumred/NumRedPoint$NumRedPath:str_path	Lcom/tencent/mobileqq/pb/PBStringField;
    //   164: invokevirtual 151	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   167: aload_1
    //   168: invokevirtual 437	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   171: ifeq +35 -> 206
    //   174: aload 9
    //   176: getfield 173	com/tencent/pb/getnumred/NumRedPoint$NumRedPath:uint32_msg_status	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   179: invokevirtual 103	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   182: iload_2
    //   183: if_icmpne +23 -> 206
    //   186: iload 4
    //   188: iconst_1
    //   189: iadd
    //   190: istore_3
    //   191: goto +29 -> 220
    //   194: aload 6
    //   196: monitorexit
    //   197: iload 4
    //   199: ireturn
    //   200: astore_1
    //   201: aload 6
    //   203: monitorexit
    //   204: aload_1
    //   205: athrow
    //   206: iload 4
    //   208: istore_3
    //   209: goto +11 -> 220
    //   212: iload_3
    //   213: iconst_1
    //   214: iadd
    //   215: istore 4
    //   217: goto -58 -> 159
    //   220: iload 5
    //   222: iconst_1
    //   223: iadd
    //   224: istore 5
    //   226: goto -134 -> 92
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	229	0	this	NumRedPointManager
    //   0	229	1	paramString	String
    //   0	229	2	paramInt	int
    //   91	124	3	i	int
    //   51	165	4	j	int
    //   87	138	5	k	int
    //   4	198	6	localObject1	Object
    //   79	29	8	localList	List
    //   119	56	9	localNumRedPath	NumRedPoint.NumRedPath
    // Exception table:
    //   from	to	target	type
    //   13	16	200	finally
    //   18	24	200	finally
    //   29	39	200	finally
    //   41	50	200	finally
    //   53	81	200	finally
    //   95	121	200	finally
    //   130	141	200	finally
    //   144	156	200	finally
    //   159	186	200	finally
    //   194	197	200	finally
    //   201	204	200	finally
  }
  
  private void b()
  {
    Object localObject1 = this.jdField_a_of_type_JavaLangObject;
    int i = 0;
    try
    {
      if (i < jdField_a_of_type_Array2dOfJavaLangString.length)
      {
        Object localObject2 = jdField_a_of_type_Array2dOfJavaLangString[i][0];
        if ((localObject2 != null) && (((String)localObject2).contains("."))) {}
        for (int j = Integer.valueOf(((String)localObject2).substring(0, ((String)localObject2).indexOf("."))).intValue();; j = Integer.valueOf(jdField_a_of_type_Array2dOfJavaLangString[i][0]).intValue())
        {
          localObject2 = new ConcurrentHashMap();
          int k = b(j, 0);
          int m = b(j, 1);
          int n = b(j, 3);
          int i1 = b(j, 4);
          int i2 = b(j, 100);
          ((ConcurrentHashMap)localObject2).put(Integer.valueOf(0), Integer.valueOf(k));
          ((ConcurrentHashMap)localObject2).put(Integer.valueOf(1), Integer.valueOf(m));
          ((ConcurrentHashMap)localObject2).put(Integer.valueOf(3), Integer.valueOf(n));
          ((ConcurrentHashMap)localObject2).put(Integer.valueOf(4), Integer.valueOf(i1));
          ((ConcurrentHashMap)localObject2).put(Integer.valueOf(100), Integer.valueOf(i2));
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(j), localObject2);
          i += 1;
          break;
        }
      }
      return;
    }
    finally {}
  }
  
  private void b(int paramInt, long paramLong, String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Long.valueOf(paramLong));
    a(paramInt, localArrayList, 1, paramString);
  }
  
  private void b(NumRedPoint.NumRedRspBody paramNumRedRspBody)
  {
    if (paramNumRedRspBody == null) {}
    do
    {
      return;
      localObject2 = paramNumRedRspBody.rpt_num_red.get();
    } while (localObject2 == null);
    NumRedPoint.NumRedRspBody localNumRedRspBody;
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      localNumRedRspBody = a();
      if (localNumRedRspBody == null)
      {
        a(paramNumRedRspBody);
        return;
      }
    }
    List localList = localNumRedRspBody.rpt_num_red.get();
    if (localList == null)
    {
      a(paramNumRedRspBody);
      return;
    }
    Object localObject2 = ((List)localObject2).iterator();
    Object localObject3;
    int i;
    label113:
    int j;
    label168:
    label239:
    NumRedPoint.NumRedPath localNumRedPath;
    for (;;)
    {
      if (((Iterator)localObject2).hasNext())
      {
        localObject3 = (NumRedPoint.NumRedBusi)((Iterator)localObject2).next();
        i = 0;
        if (i >= localList.size()) {
          break label421;
        }
        if (((NumRedPoint.NumRedBusi)localList.get(i)).uint32_appid.get() != ((NumRedPoint.NumRedBusi)localObject3).uint32_appid.get()) {
          break label428;
        }
        j = 1;
        paramNumRedRspBody = (NumRedPoint.NumRedBusi)localList.get(i);
        i = j;
        if (i == 0)
        {
          localList.add(localObject3);
        }
        else
        {
          Object localObject4 = ((NumRedPoint.NumRedBusi)localObject3).rpt_num_red_path.get();
          if ((localObject4 != null) && (paramNumRedRspBody != null))
          {
            localObject3 = paramNumRedRspBody.rpt_num_red_path.get();
            if (localObject3 == null)
            {
              paramNumRedRspBody.rpt_num_red_path.set((List)localObject4);
            }
            else
            {
              localObject4 = ((List)localObject4).iterator();
              if (((Iterator)localObject4).hasNext())
              {
                localNumRedPath = (NumRedPoint.NumRedPath)((Iterator)localObject4).next();
                i = 0;
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      if (i < ((List)localObject3).size())
      {
        if (localNumRedPath.uint64_msgid.get() == ((NumRedPoint.NumRedPath)((List)localObject3).get(i)).uint64_msgid.get())
        {
          j = 1;
          paramNumRedRspBody = (NumRedPoint.NumRedPath)((List)localObject3).get(i);
        }
      }
      else
      {
        for (i = j;; i = 0)
        {
          if (i == 0)
          {
            ((List)localObject3).add(localNumRedPath);
            break label239;
          }
          if (paramNumRedRspBody == null) {
            break label239;
          }
          paramNumRedRspBody.str_path.set(localNumRedPath.str_path.get());
          paramNumRedRspBody.str_missionid.set(localNumRedPath.str_missionid.get());
          paramNumRedRspBody.uint32_msg_status.set(localNumRedPath.uint32_msg_status.get());
          paramNumRedRspBody.uint32_expire_time.set(localNumRedPath.uint32_expire_time.get());
          break label239;
          break;
          a(localNumRedRspBody);
          return;
          paramNumRedRspBody = null;
        }
        label421:
        paramNumRedRspBody = null;
        i = 0;
        break label168;
        label428:
        i += 1;
        break label113;
      }
      i += 1;
    }
  }
  
  private boolean b(Submsgtype0x89.NumRedBusiInfo paramNumRedBusiInfo)
  {
    boolean bool = true;
    String str = paramNumRedBusiInfo.str_client_ver_begin.get();
    paramNumRedBusiInfo = paramNumRedBusiInfo.str_client_ver_end.get();
    if ((str == null) && (paramNumRedBusiInfo == null)) {
      return false;
    }
    int i = a(str, "7.6.0");
    int j = a("7.6.0", paramNumRedBusiInfo);
    if ((i == -1) || (i == 0))
    {
      i = 1;
      if ((j != 1) && (j != 0) && (!paramNumRedBusiInfo.equals("0.0.0"))) {
        break label98;
      }
      j = 1;
      label82:
      if ((i == 0) || (j == 0)) {
        break label103;
      }
    }
    for (;;)
    {
      return bool;
      i = 0;
      break;
      label98:
      j = 0;
      break label82;
      label103:
      bool = false;
    }
  }
  
  private void c()
  {
    Object localObject1 = this.jdField_a_of_type_JavaLangObject;
    int i = 0;
    for (;;)
    {
      try
      {
        if (i < jdField_a_of_type_Array2dOfJavaLangString.length)
        {
          Object localObject2 = jdField_a_of_type_Array2dOfJavaLangString[i][0];
          if ((localObject2 != null) && (((String)localObject2).contains(".")))
          {
            j = Integer.valueOf(((String)localObject2).substring(0, ((String)localObject2).indexOf("."))).intValue();
            localObject2 = a(j);
            if (localObject2 == null) {
              break label299;
            }
          }
          else
          {
            j = Integer.valueOf(jdField_a_of_type_Array2dOfJavaLangString[i][0]).intValue();
            continue;
          }
          localObject2 = a((NumRedPoint.NumRedBusi)localObject2);
          if (localObject2 == null) {
            break label299;
          }
          localObject2 = ((List)localObject2).iterator();
          if (!((Iterator)localObject2).hasNext()) {
            break label299;
          }
          NumRedPoint.NumRedPath localNumRedPath = (NumRedPoint.NumRedPath)((Iterator)localObject2).next();
          int j = b(localNumRedPath.str_path.get(), 0);
          int k = b(localNumRedPath.str_path.get(), 1);
          int m = b(localNumRedPath.str_path.get(), 3);
          int n = b(localNumRedPath.str_path.get(), 4);
          ConcurrentHashMap localConcurrentHashMap = new ConcurrentHashMap();
          localConcurrentHashMap.put(Integer.valueOf(0), Integer.valueOf(j));
          localConcurrentHashMap.put(Integer.valueOf(1), Integer.valueOf(k));
          localConcurrentHashMap.put(Integer.valueOf(3), Integer.valueOf(m));
          localConcurrentHashMap.put(Integer.valueOf(4), Integer.valueOf(n));
          this.b.put(localNumRedPath.str_path.get(), localConcurrentHashMap);
          continue;
        }
      }
      finally {}
      return;
      label299:
      i += 1;
    }
  }
  
  private void c(NumRedPoint.NumRedRspBody paramNumRedRspBody)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_ComTencentPbGetnumredNumRedPoint$NumRedRspBody = paramNumRedRspBody;
      return;
    }
  }
  
  public int a(int paramInt)
  {
    int i = 0;
    label123:
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        Object localObject2 = b();
        if (localObject2 == null)
        {
          a("getNumRedShowNumByAppSet : numRedBusiList is null");
          return 0;
        }
        localObject2 = ((List)localObject2).iterator();
        if (((Iterator)localObject2).hasNext())
        {
          NumRedPoint.NumRedBusi localNumRedBusi = (NumRedPoint.NumRedBusi)((Iterator)localObject2).next();
          if ((paramInt == localNumRedBusi.int32_appset.get()) && (a(localNumRedBusi.uint32_appid.get())))
          {
            i = a(localNumRedBusi.uint32_appid.get(), 100) + i;
            break label123;
          }
        }
        else
        {
          return i;
        }
      }
    }
  }
  
  public int a(int paramInt1, int paramInt2)
  {
    Object localObject = new ConcurrentHashMap();
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Integer.valueOf(paramInt1)))
    {
      ConcurrentHashMap localConcurrentHashMap = (ConcurrentHashMap)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt1));
      localObject = localConcurrentHashMap;
      if (localConcurrentHashMap.contains(Integer.valueOf(paramInt2))) {
        return ((Integer)localConcurrentHashMap.get(Integer.valueOf(paramInt2))).intValue();
      }
    }
    int i = b(paramInt1, paramInt2);
    ((ConcurrentHashMap)localObject).put(Integer.valueOf(paramInt2), Integer.valueOf(i));
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramInt1), localObject);
    return i;
  }
  
  public int a(String paramString, int paramInt)
  {
    Object localObject = new ConcurrentHashMap();
    if (this.b.containsKey(paramString))
    {
      ConcurrentHashMap localConcurrentHashMap = (ConcurrentHashMap)this.b.get(paramString);
      localObject = localConcurrentHashMap;
      if (localConcurrentHashMap.contains(Integer.valueOf(paramInt))) {
        return ((Integer)localConcurrentHashMap.get(Integer.valueOf(paramInt))).intValue();
      }
    }
    int i = b(paramString, paramInt);
    ((ConcurrentHashMap)localObject).put(Integer.valueOf(paramInt), Integer.valueOf(i));
    this.b.put(paramString, localObject);
    return i;
  }
  
  public NumRedPoint.NumRedRspBody a()
  {
    Object localObject2;
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_ComTencentPbGetnumredNumRedPoint$NumRedRspBody != null)
      {
        localObject2 = this.jdField_a_of_type_ComTencentPbGetnumredNumRedPoint$NumRedRspBody;
        return localObject2;
      }
      ??? = new NumRedPoint.NumRedRspBody();
      localObject2 = new File(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getFilesDir(), "NumRedShowFileName_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      if (!((File)localObject2).exists()) {
        a("numredshownum pb file does not exist");
      }
    }
    try
    {
      ((File)localObject2).createNewFile();
      try
      {
        localObject2 = FileUtils.a((File)localObject2);
        if (localObject2 != null) {
          break label136;
        }
        a("Can not translate numredshownum pb file to byte");
        return null;
      }
      finally {}
      arrayOfByte = finally;
      throw arrayOfByte;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        localIOException.printStackTrace();
      }
    }
    try
    {
      label136:
      localNumRedRspBody.mergeFrom(arrayOfByte);
      c(localNumRedRspBody);
      return localNumRedRspBody;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      a("merge numredshownum file to rspbody fail");
    }
    return null;
  }
  
  public List a()
  {
    ArrayList localArrayList1 = new ArrayList();
    int i = 0;
    if (i < jdField_a_of_type_Array2dOfJavaLangString.length)
    {
      Object localObject1 = jdField_a_of_type_Array2dOfJavaLangString[i][0];
      int j;
      label64:
      Object localObject2;
      if ((localObject1 != null) && (((String)localObject1).contains(".")))
      {
        j = Integer.valueOf(((String)localObject1).substring(0, ((String)localObject1).indexOf("."))).intValue();
        localObject2 = a(j);
        localObject1 = new NumRedPoint.NumRedBusi();
        ((NumRedPoint.NumRedBusi)localObject1).uint32_appid.set(j);
        ((NumRedPoint.NumRedBusi)localObject1).uint32_modify_ts.set((int)(System.currentTimeMillis() / 1000L));
        ((NumRedPoint.NumRedBusi)localObject1).i_new_flag.set(0);
        if (localObject2 == null) {
          break label290;
        }
        localObject2 = a((NumRedPoint.NumRedBusi)localObject2);
        if ((localObject2 != null) && (((List)localObject2).size() >= 1)) {
          break label185;
        }
        ((NumRedPoint.NumRedBusi)localObject1).i_new_flag.set(0);
        localArrayList1.add(localObject1);
      }
      for (;;)
      {
        i += 1;
        break;
        j = Integer.valueOf(jdField_a_of_type_Array2dOfJavaLangString[i][0]).intValue();
        break label64;
        label185:
        ArrayList localArrayList2 = new ArrayList();
        j = 0;
        while (j < ((List)localObject2).size())
        {
          NumRedPoint.NumRedPath localNumRedPath = (NumRedPoint.NumRedPath)((List)localObject2).get(j);
          if ((localNumRedPath.uint32_msg_status.get() == 0) || (localNumRedPath.uint32_msg_status.get() == 1)) {
            localArrayList2.add(localNumRedPath);
          }
          if (localNumRedPath.uint32_msg_status.get() == 0) {
            ((NumRedPoint.NumRedBusi)localObject1).i_new_flag.set(1);
          }
          j += 1;
        }
        ((NumRedPoint.NumRedBusi)localObject1).rpt_num_red_path.set(localArrayList2);
        label290:
        localArrayList1.add(localObject1);
      }
    }
    return localArrayList1;
  }
  
  public List a(int paramInt)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      Object localObject2 = a(paramInt);
      if (localObject2 == null) {
        return null;
      }
      localObject2 = ((NumRedPoint.NumRedBusi)localObject2).rpt_num_red_path.get();
      return localObject2;
    }
  }
  
  public void a()
  {
    List localList1;
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      NumRedPoint.NumRedRspBody localNumRedRspBody1 = a();
      if (localNumRedRspBody1 == null) {
        return;
      }
      localList1 = localNumRedRspBody1.rpt_num_red.get();
      if (localList1 == null) {
        return;
      }
    }
    int j = 0;
    int i = 0;
    List localList2;
    int m;
    if (j < localList1.size())
    {
      localList2 = ((NumRedPoint.NumRedBusi)localList1.get(j)).rpt_num_red_path.get();
      if (localList2 != null) {
        break label193;
      }
      m = i;
    }
    for (;;)
    {
      m = i;
      int k;
      if (k < localList2.size())
      {
        NumRedPoint.NumRedPath localNumRedPath = (NumRedPoint.NumRedPath)localList2.get(k);
        if (localNumRedPath.uint32_push_num_red_ts.get() + localNumRedPath.uint32_expire_time.get() < (int)(System.currentTimeMillis() / 1000L))
        {
          localNumRedPath.uint32_msg_status.set(4);
          i = 1;
          break label198;
          if (i != 0) {
            a(localNumRedRspBody2);
          }
        }
      }
      else
      {
        j += 1;
        i = m;
        break;
        label193:
        k = 0;
        continue;
      }
      label198:
      k += 1;
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject2;
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      NumRedPoint.NumRedRspBody localNumRedRspBody1 = a();
      localObject2 = a(paramInt1);
      if (localObject2 == null) {
        return;
      }
      localObject2 = a((NumRedPoint.NumRedBusi)localObject2);
      if (localObject2 == null) {
        return;
      }
    }
    paramInt1 = 0;
    if (paramInt1 < ((List)localObject2).size()) {
      if (((NumRedPoint.NumRedPath)((List)localObject2).get(paramInt1)).uint64_msgid.get() == paramInt2) {
        ((NumRedPoint.NumRedPath)((List)localObject2).get(paramInt1)).uint32_msg_status.set(paramInt3);
      }
    }
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      if (paramInt1 != 0) {
        a(localNumRedRspBody2);
      }
      return;
      paramInt1 += 1;
      break;
    }
  }
  
  public void a(int paramInt, long paramLong, String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Long.valueOf(paramLong));
    a(paramInt, localArrayList, 9, paramString);
  }
  
  public void a(int paramInt, boolean paramBoolean, Object paramObject)
  {
    NumRedPointHandler localNumRedPointHandler = (NumRedPointHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(55);
    if (localNumRedPointHandler != null)
    {
      localNumRedPointHandler.a(paramInt, paramBoolean, paramObject);
      a("notifyObserver");
    }
    RedpointHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  public void a(NumRedPoint.NumRedRspBody paramNumRedRspBody)
  {
    if (paramNumRedRspBody == null) {}
    Object localObject;
    label70:
    do
    {
      return;
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0).edit();
      if (!paramNumRedRspBody.i_inteval.has()) {
        break label160;
      }
      if (paramNumRedRspBody.i_inteval.get() <= 0) {
        break;
      }
      i = paramNumRedRspBody.i_inteval.get();
      ((SharedPreferences.Editor)localObject).putInt("NumRedTimeInterval", i);
      ((SharedPreferences.Editor)localObject).putInt("NumRedLastTime", (int)(System.currentTimeMillis() / 1000L));
      ((SharedPreferences.Editor)localObject).commit();
      localObject = paramNumRedRspBody.rpt_num_red.get();
    } while (localObject == null);
    int i = 0;
    label113:
    if (i < ((List)localObject).size())
    {
      List localList = ((NumRedPoint.NumRedBusi)((List)localObject).get(i)).rpt_num_red_path.get();
      if (localList == null) {}
      for (;;)
      {
        i += 1;
        break label113;
        i = 0;
        break;
        ((SharedPreferences.Editor)localObject).remove("NumRedTimeInterval");
        break label70;
        int j = 0;
        while (j < localList.size())
        {
          ((NumRedPoint.NumRedPath)localList.get(j)).uint32_push_num_red_ts.set((int)(System.currentTimeMillis() / 1000L));
          j += 1;
        }
      }
    }
    label160:
    a("handleNumRedRsp : modify pushtime end");
    b(paramNumRedRspBody);
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null) {}
    for (;;)
    {
      int i;
      try
      {
        localObject = new Submsgtype0x89.MsgBody();
        ((Submsgtype0x89.MsgBody)localObject).mergeFrom(paramArrayOfByte);
        localObject = ((Submsgtype0x89.MsgBody)localObject).rpt_msg_num_red.get();
        if (localObject == null) {
          return;
        }
        paramArrayOfByte = new ArrayList();
        i = 0;
        if (i < ((List)localObject).size())
        {
          Submsgtype0x89.NumRedBusiInfo localNumRedBusiInfo = (Submsgtype0x89.NumRedBusiInfo)((List)localObject).get(i);
          if ((!a(localNumRedBusiInfo)) || (!b(localNumRedBusiInfo))) {
            break label151;
          }
          b(localNumRedBusiInfo.uint32_app_id.get(), localNumRedBusiInfo.uint64_msgid.get(), "");
          paramArrayOfByte.add(a(localNumRedBusiInfo));
        }
      }
      catch (Exception paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
        return;
      }
      Object localObject = new NumRedPoint.NumRedRspBody();
      ((NumRedPoint.NumRedRspBody)localObject).rpt_num_red.set(paramArrayOfByte);
      b((NumRedPoint.NumRedRspBody)localObject);
      return;
      label151:
      i += 1;
    }
  }
  
  public boolean a(int paramInt)
  {
    boolean bool = false;
    if (a(paramInt, 0) > 0) {
      bool = true;
    }
    return bool;
  }
  
  public List b()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      Object localObject2 = a();
      if (localObject2 == null)
      {
        a("getNumRedBusiInfoByAppId : rsp == null ");
        return null;
      }
      localObject2 = ((NumRedPoint.NumRedRspBody)localObject2).rpt_num_red.get();
      return localObject2;
    }
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.redtouch.NumRedPointManager
 * JD-Core Version:    0.7.0.1
 */