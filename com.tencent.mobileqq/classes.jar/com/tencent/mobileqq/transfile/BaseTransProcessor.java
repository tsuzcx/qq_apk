package com.tencent.mobileqq.transfile;

import aitt;
import android.os.Environment;
import android.os.Message;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.AppConstants.RichMediaErrorCode;
import com.tencent.mobileqq.app.MessageObserver.StatictisInfo;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.pic.Logger;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp.RespCommon;
import com.tencent.mobileqq.transfile.protohandler.RichProtoProc;
import com.tencent.mobileqq.transfile.protohandler.RichProtoProc.RichProtoCallback;
import com.tencent.mobileqq.utils.httputils.HttpMsg;
import com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.ProxyIpManager.ProxyIp;

public class BaseTransProcessor
  implements AppConstants.RichMediaErrorCode, INetEngine.INetEngineListener, ITransProcessor, ProtoReqManager.IProtoRespBack, RichProtoProc.RichProtoCallback, IHttpCommunicatorListener
{
  protected static INetEngine.IBreakDownFix a;
  protected static RichMediaStrategy.OldEngineDPCProfile a;
  private static Object jdField_a_of_type_JavaLangObject;
  private static ArrayList jdField_a_of_type_JavaUtilArrayList;
  static ConcurrentHashMap jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  public static String k;
  private int jdField_a_of_type_Int;
  protected AppInterface a;
  public BaseTransFileController a;
  BaseTransProcessor.StepInfo jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo = new BaseTransProcessor.StepInfo();
  public FileMsg a;
  public INetEngine a;
  NetReq jdField_a_of_type_ComTencentMobileqqTransfileNetReq;
  public TransferRequest a;
  RichProto.RichProtoReq jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProto$RichProtoReq;
  private String jdField_a_of_type_JavaLangString;
  StringBuilder jdField_a_of_type_JavaLangStringBuilder = new StringBuilder();
  public HashMap a;
  protected List a;
  private boolean jdField_a_of_type_Boolean;
  private int b;
  public BaseTransProcessor.StepInfo b;
  private int c;
  public BaseTransProcessor.StepInfo c;
  int jdField_d_of_type_Int = -9528;
  BaseTransProcessor.StepInfo jdField_d_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo = new BaseTransProcessor.StepInfo();
  int e;
  int f = -9530;
  int g = -9531;
  int jdField_h_of_type_Int = -9532;
  String jdField_h_of_type_JavaLangString = "P";
  int jdField_i_of_type_Int = -9533;
  String jdField_i_of_type_JavaLangString = "Q";
  boolean jdField_i_of_type_Boolean = false;
  public int j;
  public String j;
  boolean j;
  int k;
  public long k;
  public boolean k;
  int jdField_l_of_type_Int = 0;
  long jdField_l_of_type_Long;
  boolean jdField_l_of_type_Boolean = false;
  int jdField_m_of_type_Int = 0;
  public long m;
  boolean jdField_m_of_type_Boolean = false;
  protected int n;
  long jdField_n_of_type_Long = 0L;
  boolean jdField_n_of_type_Boolean = false;
  public long o;
  public boolean o;
  protected long p;
  boolean p;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqTransfileRichMediaStrategy$OldEngineDPCProfile = new RichMediaStrategy.OldEngineDPCProfile();
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    jdField_a_of_type_JavaLangObject = new Object();
    jdField_k_of_type_JavaLangString = "param_reason";
    jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$IBreakDownFix = new aitt();
  }
  
  public BaseTransProcessor(BaseTransFileController paramBaseTransFileController, TransferRequest paramTransferRequest)
  {
    this.jdField_e_of_type_Int = -9529;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_j_of_type_Int = 9001;
    this.jdField_j_of_type_JavaLangString = "";
    this.jdField_k_of_type_Int = -1;
    this.jdField_j_of_type_Boolean = false;
    this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo = new BaseTransProcessor.StepInfo();
    this.jdField_c_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo = new BaseTransProcessor.StepInfo();
    this.jdField_k_of_type_Boolean = false;
    this.jdField_o_of_type_Boolean = false;
    this.jdField_p_of_type_Boolean = true;
    this.jdField_m_of_type_Long = 0L;
    this.jdField_o_of_type_Long = 0L;
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramBaseTransFileController.jdField_a_of_type_ComTencentCommonAppAppInterface;
    this.jdField_k_of_type_Long = System.nanoTime();
    Logger.a("BaseTransProcessor", "TimeCompare", "Processor Start Time = " + this.jdField_k_of_type_Long + "ns,Processor = " + this);
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg = new FileMsg();
    this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransFileController = paramBaseTransFileController;
    this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest = paramTransferRequest;
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_Int;
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_b_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long;
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_h_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int;
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.q = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.c;
    paramBaseTransFileController = this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg;
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Boolean) {
      i1 = 0;
    }
    paramBaseTransFileController.jdField_a_of_type_Int = i1;
    this.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getNetEngine(0);
    k();
  }
  
  public BaseTransProcessor(TransFileController paramTransFileController)
  {
    this.jdField_e_of_type_Int = -9529;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_j_of_type_Int = 9001;
    this.jdField_j_of_type_JavaLangString = "";
    this.jdField_k_of_type_Int = -1;
    this.jdField_j_of_type_Boolean = false;
    this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo = new BaseTransProcessor.StepInfo();
    this.jdField_c_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo = new BaseTransProcessor.StepInfo();
    this.jdField_k_of_type_Boolean = false;
    this.jdField_o_of_type_Boolean = false;
    this.jdField_p_of_type_Boolean = true;
    this.jdField_m_of_type_Long = 0L;
    this.jdField_o_of_type_Long = 0L;
    this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransFileController = paramTransFileController;
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramTransFileController.a;
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg = new FileMsg();
    this.jdField_k_of_type_Long = System.nanoTime();
  }
  
  public BaseTransProcessor(String paramString1, String paramString2, boolean paramBoolean, TransFileController paramTransFileController)
  {
    this.jdField_e_of_type_Int = -9529;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_j_of_type_Int = 9001;
    this.jdField_j_of_type_JavaLangString = "";
    this.jdField_k_of_type_Int = -1;
    this.jdField_j_of_type_Boolean = false;
    this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo = new BaseTransProcessor.StepInfo();
    this.jdField_c_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo = new BaseTransProcessor.StepInfo();
    this.jdField_k_of_type_Boolean = false;
    this.jdField_o_of_type_Boolean = false;
    this.jdField_p_of_type_Boolean = true;
    this.jdField_m_of_type_Long = 0L;
    this.jdField_o_of_type_Long = 0L;
    this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransFileController = paramTransFileController;
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramTransFileController.a;
    this.jdField_k_of_type_Long = System.nanoTime();
    if (paramBoolean) {}
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg = new FileMsg(paramString1, paramString2, i1);
      this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor = this;
      return;
      i1 = 1;
    }
  }
  
  public static String a(int paramInt, long paramLong)
  {
    return "H_" + paramInt + "_" + paramLong;
  }
  
  public static String a(long paramLong)
  {
    return "T_" + paramLong;
  }
  
  public static String a(Exception paramException)
  {
    return AbstractImageDownloader.a(paramException);
  }
  
  public static String a(String paramString, long paramLong)
  {
    return paramString + "_" + paramLong;
  }
  
  public static void a(Message paramMessage, Class paramClass, long paramLong)
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if ((jdField_a_of_type_JavaUtilArrayList != null) && (!jdField_a_of_type_JavaUtilArrayList.isEmpty()))
      {
        Iterator localIterator = jdField_a_of_type_JavaUtilArrayList.iterator();
        TransProcessorHandler localTransProcessorHandler;
        Object localObject2;
        do
        {
          while (!((Iterator)localObject2).hasNext())
          {
            do
            {
              if (!localIterator.hasNext()) {
                break;
              }
              localTransProcessorHandler = (TransProcessorHandler)localIterator.next();
              localObject2 = localTransProcessorHandler.a();
            } while (((ArrayList)localObject2).isEmpty());
            localObject2 = ((ArrayList)localObject2).iterator();
          }
        } while (!paramClass.isAssignableFrom((Class)((Iterator)localObject2).next()));
        Message localMessage = localTransProcessorHandler.obtainMessage();
        localMessage.what = paramMessage.what;
        localMessage.obj = paramMessage.obj;
        localMessage.arg1 = paramMessage.arg1;
        localTransProcessorHandler.sendMessageDelayed(localMessage, paramLong);
      }
    }
  }
  
  public static void a(TransProcessorHandler paramTransProcessorHandler)
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (!jdField_a_of_type_JavaUtilArrayList.contains(paramTransProcessorHandler)) {
        jdField_a_of_type_JavaUtilArrayList.add(paramTransProcessorHandler);
      }
      return;
    }
  }
  
  public static boolean a(int paramInt, HashMap paramHashMap)
  {
    if (paramHashMap == null) {
      return true;
    }
    if ((paramInt == -9530) || (paramInt == -9532) || (paramInt == -9533) || (paramInt == -9531))
    {
      paramHashMap.put(jdField_k_of_type_JavaLangString, a("Q", paramInt));
      paramHashMap.put("param_FailCode", Integer.toString(-9527));
      return true;
    }
    if ((paramInt == -9528) || (paramInt == -9529))
    {
      paramHashMap.put(jdField_k_of_type_JavaLangString, a("P", paramInt));
      paramHashMap.put("param_FailCode", Integer.toString(-9527));
      return true;
    }
    return false;
  }
  
  static boolean a(List paramList1, List paramList2)
  {
    if ((paramList2 == null) || (paramList1 == null) || (paramList1.isEmpty()) || (paramList2.contains(paramList1.get(0)))) {
      return false;
    }
    ArrayList localArrayList = new ArrayList();
    paramList1 = paramList1.iterator();
    while (paramList1.hasNext())
    {
      ProxyIpManager.ProxyIp localProxyIp = (ProxyIpManager.ProxyIp)paramList1.next();
      Object localObject = paramList2.iterator();
      while (((Iterator)localObject).hasNext())
      {
        ServerAddr localServerAddr = (ServerAddr)((Iterator)localObject).next();
        if ((localProxyIp.ip.equals(localServerAddr.jdField_a_of_type_JavaLangString)) && (localProxyIp.port == localServerAddr.jdField_a_of_type_Int)) {
          paramList2.remove(localServerAddr);
        }
      }
      localObject = new ServerAddr();
      ((ServerAddr)localObject).jdField_a_of_type_JavaLangString = localProxyIp.ip;
      ((ServerAddr)localObject).jdField_a_of_type_Int = localProxyIp.port;
      localArrayList.add(localObject);
    }
    paramList2.addAll(0, localArrayList);
    return true;
  }
  
  public static String b(long paramLong)
  {
    return "M_" + paramLong;
  }
  
  private void b(NetResp paramNetResp)
  {
    long l1 = 0L;
    if ((paramNetResp.h != 0L) && (this.jdField_p_of_type_Boolean)) {
      if (paramNetResp.jdField_a_of_type_JavaUtilHashMap.get("X-httime") == null) {
        break label219;
      }
    }
    for (int i1 = Integer.parseInt((String)paramNetResp.jdField_a_of_type_JavaUtilHashMap.get("X-httime"));; i1 = 0)
    {
      if (paramNetResp.jdField_a_of_type_JavaUtilHashMap.get("X-piccachetime") != null) {
        l1 = Integer.parseInt((String)paramNetResp.jdField_a_of_type_JavaUtilHashMap.get("X-piccachetime"));
      }
      long l2 = i1 - l1;
      long l3 = paramNetResp.h - i1;
      this.jdField_n_of_type_Long += l3;
      this.jdField_m_of_type_Long += l2;
      this.jdField_o_of_type_Long += l1;
      this.jdField_a_of_type_JavaLangStringBuilder.append("s").append(this.jdField_n_of_type_Int).append("_").append("tr").append(l3).append("_").append("ht").append(l2).append("_").append("pic").append(l1).append(";");
      this.jdField_n_of_type_Int += 1;
      this.jdField_p_of_type_Long = paramNetResp.i;
      return;
      label219:
      this.jdField_p_of_type_Boolean = false;
    }
  }
  
  public static void b(TransProcessorHandler paramTransProcessorHandler)
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      jdField_a_of_type_JavaUtilArrayList.remove(paramTransProcessorHandler);
      return;
    }
  }
  
  public static String c(String paramString)
  {
    return "C_" + paramString;
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_Int == 0) {
        d(1002);
      }
    }
    else {
      return;
    }
    d(2002);
  }
  
  private void o()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      int i1 = g();
      if (i1 > this.jdField_a_of_type_Int) {
        this.jdField_a_of_type_Int = i1;
      }
    }
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest != null) {
      if (!this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Boolean) {
        break label195;
      }
    }
    label195:
    for (int i1 = 1004;; i1 = 2004)
    {
      d(i1);
      this.jdField_o_of_type_Boolean = true;
      if ((QLog.isColorLevel()) && (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest != null)) {
        b("cancel", "");
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProto$RichProtoReq != null)
      {
        RichProtoProc.b(this.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProto$RichProtoReq);
        this.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProto$RichProtoReq = null;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine.b(this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq);
        this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq = null;
      }
      this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransFileController.a(a());
      try
      {
        if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest != null)
        {
          TransferResult localTransferResult = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqTransfileTransferResult;
          if (localTransferResult != null)
          {
            localTransferResult.jdField_a_of_type_Int = -1;
            localTransferResult.jdField_a_of_type_Long = 9037L;
            localTransferResult.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest;
          }
        }
        if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest != null) {
          b("cancel", "");
        }
        notifyAll();
        if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest != null) {
          b("cancel", "");
        }
        return 0;
      }
      finally {}
    }
  }
  
  public long a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_Long;
  }
  
  @Deprecated
  public FileMsg.StepBaseInfo a(int paramInt)
  {
    Object localObject1 = null;
    if (paramInt == 0) {}
    for (;;)
    {
      try
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg$StepBaseInfo;
        return localObject1;
      }
      finally {}
      if (paramInt == 1) {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_b_of_type_ComTencentMobileqqTransfileFileMsg$StepBaseInfo;
      } else if (paramInt == 2) {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg$StepTransInfo;
      } else if (paramInt == 3) {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.c;
      } else if (paramInt == 3) {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_b_of_type_ComTencentMobileqqTransfileFileMsg$StepTransInfo;
      }
    }
  }
  
  public FileMsg a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg;
  }
  
  TransferRequest a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public String a(String paramString1, String paramString2, int paramInt)
  {
    return MessageForPtt.getLocalFilePath(paramInt, AppConstants.aK + this.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount() + "/" + "ptt" + "/" + paramString1 + "_" + FileMsg.a() + ".amr");
  }
  
  protected String a(String paramString, List paramList)
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.isEmpty()))
    {
      paramList = paramString;
      if (QLog.isColorLevel())
      {
        QLog.d("PROXY_IP", 2, "[HTTP] proxy Ip List is empty use common conn!");
        paramList = paramString;
      }
    }
    ServerAddr localServerAddr;
    do
    {
      return paramList;
      localServerAddr = RichMediaUtil.a(paramString);
      if (localServerAddr != null) {
        break;
      }
      paramList = paramString;
    } while (!QLog.isColorLevel());
    QLog.d("PROXY_IP", 2, "[HTTP] replace proxy ip fail, host is domain");
    return paramString;
    Object localObject1 = this.jdField_a_of_type_JavaUtilList.iterator();
    int i1 = 0;
    label85:
    Object localObject2;
    if (((Iterator)localObject1).hasNext())
    {
      localObject2 = (ProxyIpManager.ProxyIp)((Iterator)localObject1).next();
      if ((!((ProxyIpManager.ProxyIp)localObject2).ip.equals(localServerAddr.jdField_a_of_type_JavaLangString)) || (((ProxyIpManager.ProxyIp)localObject2).port != localServerAddr.jdField_a_of_type_Int)) {
        break label523;
      }
      i1 = 1;
    }
    label523:
    for (;;)
    {
      break label85;
      if (i1 == 0)
      {
        localObject1 = (ProxyIpManager.ProxyIp)this.jdField_a_of_type_JavaUtilList.get(0);
        paramString = RichMediaUtil.a(paramString, "http://" + ((ProxyIpManager.ProxyIp)localObject1).ip + ":" + ((ProxyIpManager.ProxyIp)localObject1).port + "/");
        paramString = paramString + "&bHost=" + localServerAddr.jdField_a_of_type_JavaLangString + "&bPort=" + localServerAddr.jdField_a_of_type_Int;
        paramList = paramString;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("PROXY_IP", 2, "[HTTP] replace proxy ip: " + ((ProxyIpManager.ProxyIp)localObject1).ip + ":" + ((ProxyIpManager.ProxyIp)localObject1).port);
        return paramString;
      }
      localObject2 = paramList.iterator();
      paramList = null;
      label317:
      if (((Iterator)localObject2).hasNext())
      {
        localObject1 = (ServerAddr)((Iterator)localObject2).next();
        Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
        for (;;)
        {
          if (localIterator.hasNext())
          {
            ProxyIpManager.ProxyIp localProxyIp = (ProxyIpManager.ProxyIp)localIterator.next();
            if ((!((ServerAddr)localObject1).jdField_a_of_type_JavaLangString.equals(localProxyIp.ip)) && (((ServerAddr)localObject1).jdField_a_of_type_Int != localProxyIp.port))
            {
              paramList = (List)localObject1;
              if (paramList == null) {
                break;
              }
            }
          }
        }
      }
      for (;;)
      {
        label404:
        localObject1 = paramString;
        if (paramList != null) {
          localObject1 = paramString + "&bHost=" + paramList.jdField_a_of_type_JavaLangString + "&bPort=" + paramList.jdField_a_of_type_Int;
        }
        paramList = (List)localObject1;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("PROXY_IP", 2, "[HTTP] replace proxy ip: " + localServerAddr.jdField_a_of_type_JavaLangString + ":" + localServerAddr.jdField_a_of_type_Int);
        return localObject1;
        break label317;
        break label404;
      }
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
  }
  
  protected void a(int paramInt1, int paramInt2, long paramLong)
  {
    b("updateUiState", "state:" + paramInt1 + " ret:" + paramInt2 + " currentProgress:" + this.jdField_c_of_type_Int + " mProgress:" + this.jdField_a_of_type_Int);
    if (((paramInt1 == 2005) || (paramInt1 == 1005)) && (this.jdField_j_of_type_Int == 9001))
    {
      String str = AbstractImageDownloader.a(new Exception());
      HashMap localHashMap = new HashMap();
      localHashMap.put("stackMsg", str);
      StatisticCollector.a(BaseApplication.getContext()).a(null, "actRichMediaReportError", false, 0L, 0L, localHashMap, "");
    }
    this.jdField_l_of_type_Long = System.currentTimeMillis();
    long l1 = (System.nanoTime() - this.jdField_k_of_type_Long) / 1000000L;
    boolean bool;
    if ((l1 > 60000L) || (paramInt1 == 1005))
    {
      bool = true;
      if (l1 <= 60000L) {
        break label209;
      }
      RichMediaUtil.a(true, "image_sending_too_long");
    }
    for (;;)
    {
      b(paramInt1, paramInt2, paramLong);
      return;
      bool = false;
      break;
      label209:
      RichMediaUtil.a(bool, "image_sending_" + this.jdField_j_of_type_Int + "_" + this.jdField_j_of_type_JavaLangString);
    }
  }
  
  @Deprecated
  public void a(int paramInt1, int paramInt2, long paramLong, String paramString)
  {
    try
    {
      FileMsg.StepTransInfo localStepTransInfo = this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg$StepTransInfo;
      localStepTransInfo.jdField_a_of_type_Int = paramInt1;
      localStepTransInfo.jdField_a_of_type_Boolean = false;
      localStepTransInfo.jdField_a_of_type_JavaLangString = paramString;
      localStepTransInfo.jdField_e_of_type_Int = paramInt2;
      localStepTransInfo.c = paramLong;
      b(localStepTransInfo.jdField_a_of_type_Int, localStepTransInfo.jdField_a_of_type_JavaLangString);
      c(2);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  @Deprecated
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    try
    {
      FileMsg.StepBaseInfo localStepBaseInfo = a(paramInt1);
      if (localStepBaseInfo != null)
      {
        localStepBaseInfo.jdField_a_of_type_Int = paramInt2;
        localStepBaseInfo.jdField_a_of_type_JavaLangString = paramString;
        localStepBaseInfo.jdField_a_of_type_Boolean = false;
        c(paramInt1);
      }
      b(paramInt2, paramString);
      return;
    }
    finally {}
  }
  
  protected void a(int paramInt, long paramLong)
  {
    a(paramInt, 0, paramLong);
  }
  
  public void a(int paramInt, String paramString1, String paramString2, BaseTransProcessor.StepInfo paramStepInfo)
  {
    this.jdField_j_of_type_Int = paramInt;
    this.jdField_j_of_type_JavaLangString = paramString1;
    if ((paramString2 != null) && (!"".equals(paramString2))) {
      this.jdField_a_of_type_JavaUtilHashMap.put("param_reason", paramString2);
    }
    if (paramStepInfo != null)
    {
      paramStepInfo.b();
      paramStepInfo.jdField_a_of_type_Int = 0;
    }
  }
  
  @Deprecated
  public void a(int paramInt, boolean paramBoolean)
  {
    try
    {
      FileMsg.StepBaseInfo localStepBaseInfo = a(paramInt);
      if ((localStepBaseInfo != null) && ((localStepBaseInfo.jdField_a_of_type_Long == 0L) || (paramBoolean))) {
        localStepBaseInfo.jdField_a_of_type_Long = System.currentTimeMillis();
      }
      return;
    }
    finally {}
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.a(paramLong);
  }
  
  public void a(BaseTransProcessor.StepInfo paramStepInfo, NetResp paramNetResp, boolean paramBoolean)
  {
    if ((paramStepInfo == null) || (paramNetResp == null)) {
      return;
    }
    this.jdField_a_of_type_JavaUtilHashMap.put("param_Server", paramNetResp.jdField_a_of_type_JavaUtilHashMap.get("serverip"));
    if (paramBoolean)
    {
      this.jdField_a_of_type_JavaUtilHashMap.put("serverip", paramNetResp.jdField_a_of_type_JavaUtilHashMap.get("serverip"));
      paramStepInfo.jdField_b_of_type_Int += 1;
      paramStepInfo.jdField_c_of_type_Int += paramNetResp.jdField_d_of_type_Int - 1;
      paramStepInfo.b();
      paramStepInfo.jdField_a_of_type_Int = 1;
      this.jdField_a_of_type_JavaUtilHashMap.remove("param_url");
      this.jdField_a_of_type_JavaUtilHashMap.remove("param_rspHeader");
      return;
    }
    this.jdField_a_of_type_JavaUtilHashMap.put("serverip", paramNetResp.jdField_a_of_type_JavaUtilHashMap.get("firstserverip"));
    paramStepInfo.jdField_c_of_type_Int += paramNetResp.jdField_d_of_type_Int;
    if (paramNetResp.jdField_b_of_type_Int == -9527) {}
    for (String str = (String)paramNetResp.jdField_a_of_type_JavaUtilHashMap.get("netresp_param_reason");; str = null)
    {
      a(paramNetResp.jdField_b_of_type_Int, paramNetResp.jdField_a_of_type_JavaLangString, str, paramStepInfo);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_url", paramNetResp.jdField_a_of_type_JavaUtilHashMap.get("param_url"));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_rspHeader", paramNetResp.jdField_a_of_type_JavaUtilHashMap.get("param_rspHeader"));
      if ((paramNetResp.jdField_b_of_type_Int == -9527) && ("H_404_-124".equals(str))) {
        this.jdField_a_of_type_JavaUtilHashMap.put("param_reqHeader", paramNetResp.jdField_a_of_type_JavaUtilHashMap.get("param_reqHeader"));
      }
      paramStepInfo.jdField_a_of_type_Int = 0;
      return;
    }
  }
  
  public void a(BaseTransProcessor.StepInfo paramStepInfo, RichProto.RichProtoResp.RespCommon paramRespCommon)
  {
    if ((paramStepInfo != null) && (paramRespCommon != null))
    {
      paramStepInfo.b();
      paramStepInfo.jdField_b_of_type_Int = paramRespCommon.jdField_e_of_type_Int;
      paramStepInfo.jdField_c_of_type_Int = paramRespCommon.f;
      if (paramRespCommon.jdField_c_of_type_Int == 0) {
        paramStepInfo.jdField_a_of_type_Int = 1;
      }
    }
    else
    {
      return;
    }
    paramStepInfo.jdField_a_of_type_Int = 0;
    a(paramRespCommon.jdField_d_of_type_Int, paramRespCommon.g, paramRespCommon.jdField_h_of_type_JavaLangString, paramStepInfo);
  }
  
  public void a(BaseTransProcessor.StepInfo paramStepInfo, boolean paramBoolean1, boolean paramBoolean2, MessageObserver.StatictisInfo paramStatictisInfo)
  {
    if (paramStatictisInfo == null) {
      return;
    }
    paramStepInfo.b();
    if (paramBoolean2)
    {
      paramStepInfo.jdField_c_of_type_Int = (paramStatictisInfo.jdField_c_of_type_Int - 1);
      paramStepInfo.jdField_b_of_type_Int = 1;
      paramStepInfo.jdField_a_of_type_Int = 1;
      return;
    }
    String str;
    if (paramStatictisInfo.jdField_b_of_type_Int == 2900)
    {
      i1 = -9527;
      if (!paramBoolean1) {}
      for (str = b(paramStatictisInfo.jdField_a_of_type_Long);; str = a(paramStatictisInfo.jdField_a_of_type_Long))
      {
        a(i1, "", str, paramStepInfo);
        paramStepInfo.jdField_c_of_type_Int = paramStatictisInfo.jdField_c_of_type_Int;
        paramStepInfo.jdField_b_of_type_Int = 0;
        paramStepInfo.jdField_a_of_type_Int = 0;
        return;
      }
    }
    if ((paramStatictisInfo.jdField_b_of_type_Int == 1002) || (paramStatictisInfo.jdField_b_of_type_Int == 1013))
    {
      if (!paramBoolean1) {}
      for (i1 = 9350;; i1 = 9311)
      {
        str = paramStatictisInfo.jdField_a_of_type_JavaLangString;
        break;
      }
    }
    if (!paramBoolean1) {}
    for (int i1 = 9351;; i1 = 9044)
    {
      str = paramStatictisInfo.jdField_a_of_type_JavaLangString;
      break;
    }
  }
  
  public void a(NetReq paramNetReq, long paramLong1, long paramLong2) {}
  
  public void a(NetResp paramNetResp)
  {
    b(paramNetResp);
  }
  
  public void a(ProtoReqManager.ProtoResp paramProtoResp, ProtoReqManager.ProtoReq paramProtoReq) {}
  
  public void a(RichProto.RichProtoReq paramRichProtoReq, RichProto.RichProtoResp paramRichProtoResp) {}
  
  public void a(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2) {}
  
  public void a(IOException paramIOException)
  {
    paramIOException = paramIOException.getMessage();
    String str = Environment.getExternalStorageState();
    if (paramIOException.contains("EACCES")) {
      b(9039, paramIOException);
    }
    do
    {
      return;
      if (paramIOException.contains("ENOSPC"))
      {
        b(9040, paramIOException);
        return;
      }
      if (paramIOException.contains("Read-only"))
      {
        b(9039, paramIOException);
        return;
      }
    } while ("mounted".equals(str));
    b(9039, paramIOException);
  }
  
  public void a(String paramString) {}
  
  protected void a(boolean paramBoolean) {}
  
  public boolean a()
  {
    return this.jdField_l_of_type_Boolean;
  }
  
  public boolean a(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2, int paramInt)
  {
    return true;
  }
  
  public void ar_() {}
  
  public int b()
  {
    return 0;
  }
  
  public long b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_e_of_type_Long;
  }
  
  protected String b()
  {
    return null;
  }
  
  public void b() {}
  
  @Deprecated
  public void b(int paramInt)
  {
    a(paramInt, false);
  }
  
  protected void b(int paramInt1, int paramInt2, long paramLong)
  {
    if (this.jdField_o_of_type_Boolean) {
      return;
    }
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      this.jdField_b_of_type_Int = paramInt1;
      if ((jdField_a_of_type_JavaUtilArrayList != null) && (!jdField_a_of_type_JavaUtilArrayList.isEmpty()))
      {
        Iterator localIterator = jdField_a_of_type_JavaUtilArrayList.iterator();
        TransProcessorHandler localTransProcessorHandler;
        do
        {
          Object localObject3;
          while (!((Iterator)localObject3).hasNext())
          {
            do
            {
              if (!localIterator.hasNext()) {
                break;
              }
              localTransProcessorHandler = (TransProcessorHandler)localIterator.next();
              localObject3 = localTransProcessorHandler.a();
            } while (((ArrayList)localObject3).isEmpty());
            localObject3 = ((ArrayList)localObject3).iterator();
          }
          localObject4 = (Class)((Iterator)localObject3).next();
        } while (!getClass().equals(localObject4));
        Object localObject4 = localTransProcessorHandler.obtainMessage();
        this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_e_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_d_of_type_Int;
        this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_d_of_type_Int = paramInt1;
        ((Message)localObject4).what = paramInt1;
        ((Message)localObject4).obj = this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg;
        ((Message)localObject4).arg1 = paramInt2;
        localTransProcessorHandler.sendMessageDelayed((Message)localObject4, paramLong);
      }
    }
  }
  
  public void b(int paramInt, String paramString)
  {
    a(paramInt, paramString, null, null);
  }
  
  public void b(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2) {}
  
  public void b(String paramString1, String paramString2)
  {
    boolean bool = false;
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg == null) {
      Logger.b("BaseTransProcessor", "logRichMediaEvent", "file is null !");
    }
    do
    {
      return;
      if (!(this instanceof ShortVideoForwardProcessor)) {
        break;
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest == null);
    RichMediaUtil.a("T", RichMediaUtil.b(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int), RichMediaUtil.c(this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_b_of_type_Int), String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_b_of_type_Long), paramString1, paramString2, null);
    return;
    int i1 = -1;
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest != null) {
      i1 = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int;
    }
    if ((this instanceof BuddyTransfileProcessor))
    {
      i1 = 0;
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest == null) {
        break label162;
      }
      bool = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Boolean;
    }
    for (;;)
    {
      RichMediaUtil.a(RichMediaUtil.b(i1), bool, RichMediaUtil.c(this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_b_of_type_Int), String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_b_of_type_Long), paramString1, paramString2);
      return;
      if (!(this instanceof C2CPicUploadProcessor)) {
        break;
      }
      i1 = 0;
      break;
      label162:
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_Int == 0) {
        bool = true;
      }
    }
  }
  
  public boolean b()
  {
    return this.jdField_k_of_type_Boolean;
  }
  
  public int c()
  {
    return 0;
  }
  
  public long c()
  {
    return this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_d_of_type_Int;
  }
  
  public void c() {}
  
  @Deprecated
  public void c(int paramInt)
  {
    try
    {
      FileMsg.StepBaseInfo localStepBaseInfo = a(paramInt);
      if (localStepBaseInfo != null) {
        localStepBaseInfo.jdField_b_of_type_Long = System.currentTimeMillis();
      }
      return;
    }
    finally {}
  }
  
  protected void c(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public boolean c()
  {
    return (this.jdField_a_of_type_ComTencentCommonAppAppInterface.isRunning()) && (this.jdField_a_of_type_ComTencentCommonAppAppInterface.isLogin());
  }
  
  public long d()
  {
    return this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_e_of_type_Int;
  }
  
  void d()
  {
    long l1 = (System.nanoTime() - this.jdField_k_of_type_Long) / 1000000L;
    if ((!this.jdField_a_of_type_ComTencentCommonAppAppInterface.isLogin()) || (!this.jdField_a_of_type_ComTencentCommonAppAppInterface.isRunning())) {
      b(9366, "account switch");
    }
    b("onError", "elapsed:" + l1 + " errCode:" + this.jdField_j_of_type_Int + " errDesc:" + this.jdField_j_of_type_JavaLangString + " reason:" + (String)this.jdField_a_of_type_JavaUtilHashMap.get("param_reason"));
    a(false);
    this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransFileController.a(a());
  }
  
  public void d(int paramInt)
  {
    a(paramInt, 0L);
  }
  
  public void d(boolean paramBoolean) {}
  
  protected boolean d()
  {
    return (!this.jdField_o_of_type_Boolean) && (!this.jdField_k_of_type_Boolean);
  }
  
  public int e()
  {
    return this.jdField_c_of_type_Int;
  }
  
  void e()
  {
    long l1 = (System.nanoTime() - this.jdField_k_of_type_Long) / 1000000L;
    b("onSuccess", "elapsed:" + l1 + ",key:" + a());
    a(true);
    this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransFileController.a(a());
  }
  
  public void e(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.a(paramInt);
  }
  
  public void e(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public int f()
  {
    int i2 = 0;
    int i1;
    if (this.jdField_a_of_type_Boolean) {
      i1 = this.jdField_a_of_type_Int;
    }
    do
    {
      do
      {
        return i1;
        i1 = i2;
      } while (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg == null);
      i1 = i2;
    } while (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_Long <= 0L);
    return (int)(this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_e_of_type_Long * 100L / this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_Long);
  }
  
  public int g()
  {
    int i2 = 0;
    int i1 = i2;
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg != null)
    {
      i1 = i2;
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_Long > 0L)
      {
        i2 = (int)(this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_e_of_type_Long * 100L / this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_Long);
        i1 = i2;
        if (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_Int == 0) {
          if (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_b_of_type_Int != 1)
          {
            i1 = i2;
            if (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_b_of_type_Int != 131075) {}
          }
          else
          {
            i1 = i2;
            if (i2 == 100)
            {
              i1 = i2;
              if (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_d_of_type_Int != 1003) {
                i1 = 99;
              }
            }
          }
        }
      }
    }
    return i1;
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg != null)
    {
      o();
      f();
    }
  }
  
  public void h() {}
  
  public void i() {}
  
  public void j() {}
  
  public void k()
  {
    boolean bool = false;
    Integer localInteger = (Integer)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.b());
    if (localInteger == null) {}
    for (int i1 = 0;; i1 = localInteger.intValue())
    {
      this.jdField_m_of_type_Int = i1;
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_d_of_type_Int < 3) {
        bool = true;
      }
      this.jdField_i_of_type_Boolean = bool;
      return;
    }
  }
  
  public void l()
  {
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.b(), Integer.valueOf(this.jdField_m_of_type_Int));
    if (jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size() > 2000) {
      jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    }
  }
  
  void m()
  {
    this.jdField_j_of_type_Int = 0;
    this.jdField_j_of_type_JavaLangString = "";
    this.jdField_a_of_type_JavaUtilHashMap.clear();
  }
  
  protected void n() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\a2.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.BaseTransProcessor
 * JD-Core Version:    0.7.0.1
 */