package com.tencent.mobileqq.transfile;

import android.os.Environment;
import android.os.Message;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.AppConstants.RichMediaErrorCode;
import com.tencent.mobileqq.app.StatictisInfo;
import com.tencent.mobileqq.highway.ipv6.Ipv6Config;
import com.tencent.mobileqq.highway.ipv6.Ipv6Flags;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.MsfServiceSdk;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.transfile.api.IProtoReqManager;
import com.tencent.mobileqq.transfile.api.impl.ProtoReqManagerImpl.IProtoRespBack;
import com.tencent.mobileqq.transfile.api.impl.ProtoReqManagerImpl.ProtoReq;
import com.tencent.mobileqq.transfile.api.impl.ProtoReqManagerImpl.ProtoResp;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp.RespCommon;
import com.tencent.mobileqq.transfile.protohandler.RichProtoProc;
import com.tencent.mobileqq.transfile.protohandler.RichProtoProc.RichProtoCallback;
import com.tencent.mobileqq.transfile.report.RMServMonitorReport;
import com.tencent.mobileqq.utils.httputils.HttpMsg;
import com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.List<Lcom.tencent.mobileqq.transfile.ServerAddr;>;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.ProxyIpManager.ProxyIp;

public class BaseTransProcessor
  implements AppConstants.RichMediaErrorCode, INetEngineListener, ITransProcessor, ProtoReqManagerImpl.IProtoRespBack, RichProtoProc.RichProtoCallback, IHttpCommunicatorListener
{
  protected static final String COSTREPORT_HT = "ht";
  protected static final String COSTREPORT_PIC = "pic";
  protected static final String COSTREPORT_PREFIX = "s";
  protected static final String COSTREPORT_SN = "sn";
  protected static final String COSTREPORT_TRANS = "tr";
  public static final String FILE_AST_DIR = "ast";
  public static final String FILE_PTT_DIR = "ptt";
  public static final String KEYIS_PRESEND = "param_isPresend";
  public static final String KEYIS_SECOND_TRANS = "param_isSecondTrans";
  public static final String KEY_AIODURATION = "param_AIODuration";
  public static final String KEY_AIOPERCENT = "param_AIOPercent";
  public static final String KEY_BDHEXIST_BEFORE_VIDEO_UPLOAD = "param_BDHExistBeforeVideoUpload";
  public static final String KEY_BDHGENERATE_COMBINE_FILE_TIME = "param_BDHGenerateCombineFileTime";
  public static final String KEY_BDHSRV_IP = "param_bdhSrv";
  public static final String KEY_BDHSRV_PORT = "param_bdhPort";
  public static final String KEY_BDHTRANS_INFO = "param_BdhTrans";
  public static final String KEY_BUSI_TYPE = "param_busiType";
  public static final String KEY_COST_EACH = "param_CostEach";
  public static final String KEY_DOWN_MODE = "param_DownMode";
  public static final String KEY_ENCRYPT = "param_encrypt";
  public static final String KEY_ENC_RETRY = "param_encRetry";
  public static final String KEY_ERR_DESC = "param_errorDesc";
  public static final String KEY_FAIL_CODE = "param_FailCode";
  public static final String KEY_FILE_MD5 = "param_fileMd5";
  public static final String KEY_FROM_BUSI_TYPE = "param_fromBusiType";
  public static final String KEY_FROM_CHAT_TYPE = "param_fromChatType";
  public static final String KEY_FROM_UIN = "param_fromUin";
  public static final String KEY_GROUP_FILE_ID = "param_fileid";
  public static final String KEY_GROUP_ID = "param_grpUin";
  public static final String KEY_IMAGETYPE = "param_imgType";
  public static final String KEY_IN_QUEUE_COST = "param_inQueueCost";
  public static final String KEY_IPV6POLICY = "param_Ipv6Policy";
  public static final String KEY_IS_ENCRYPT_ROLLBACK = "param_encryptRollback";
  public static final String KEY_IS_HTTPS = "param_isHttps";
  public static final String KEY_IS_OPEN_UP = "param_openUp";
  public static final String KEY_IS_RAW_PIC = "param_IsRawPic";
  public static final String KEY_LONG_MSG_ANDROID_ERR_CODE = "param_android_error_code";
  public static final String KEY_LONG_MSG_CHANNEL = "param_channel";
  public static final String KEY_LONG_MSG_ERROR_CODE = "param_errcode";
  public static final String KEY_LONG_MSG_HTTP_ERROR_CODE = "param_http_error_code";
  public static final String KEY_LONG_MSG_IP_SOURCE = "param_ip_source";
  public static final String KEY_LONG_MSG_PUIN = "param_puin";
  public static final String KEY_LONG_MSG_RESID = "param_resid";
  public static final String KEY_LONG_MSG_UIN = "param_uin";
  public static final String KEY_LONG_MSG_URL = "param_url";
  public static final String KEY_MD5CHECK = "param_md5check";
  public static final String KEY_MSFCONN_IP_TPYE = "msfConnIPType";
  public static final String KEY_NET_IP_TYPE = "ipStackType";
  public static final String KEY_NET_TYPE = "param_NetType";
  public static final String KEY_OLD_SERVER_IP = "param_Server";
  public static final String KEY_OPEN_UP_STEP_INFO = "param_openUpStep";
  public static final String KEY_PHONE_TYPE = "param_PhoneType";
  public static final String KEY_PIC_DECRYPT_TIME = "param_picDecryptTime";
  public static final String KEY_PIC_ENCRYPT = "param_picEncrypt";
  public static final String KEY_PIC_MD5 = "param_picmd5";
  public static final String KEY_PIC_RES_LENGTH = "param_picResLength";
  public static final String KEY_PIC_RES_WIDTH = "param_picResWidth";
  public static final String KEY_PIC_SIZE = "param_picSize";
  public static final String KEY_PIC_TYPE = "param_picType";
  public static final String KEY_PTT_NET_DOWN = "param_pttNetDown";
  public static final String KEY_PTT_OPT = "param_pttOpt";
  public static final String KEY_PTT_WRITTEN_SIZE = "param_writtenSize";
  public static final String KEY_REASON = "param_reason";
  public static final String KEY_RECV_DATA_LEN = "param_recvDataLen";
  public static final String KEY_REQ_HEADER = "param_reqHeader";
  public static final String KEY_REQ_IP = "param_reqIp";
  public static final String KEY_RESP_HEADER = "param_rspHeader";
  public static final String KEY_RETRY = "param_Retry";
  public static final String KEY_SEG_PER_CNT = "param_segspercnt";
  public static final String KEY_SENDBY_QUICK_HTTP = "param_quickHttp";
  public static final String KEY_SERVER_IP = "serverip";
  public static final String KEY_SERVER_VIDEO_IPS = "param_iplist";
  public static final String KEY_SESSION_KEY = "param_sessionKey";
  public static final String KEY_SLICE_NUM = "param_sliceNum";
  public static final String KEY_SOURCE_TYPE = "param_source_type";
  public static final String KEY_STEP_INFO = "param_step";
  public static final String KEY_SWITCH_CHNL = "param_switchChannel";
  public static final String KEY_TIME_COST = "param_time_cost";
  public static final String KEY_TO_BUSI_TYPE = "param_toBusiType";
  public static final String KEY_TO_CHAT_TYPE = "param_toChatType";
  public static final String KEY_TO_UIN = "param_toUin";
  public static final String KEY_TRANS_CONSUME = "param_trans_consume";
  public static final String KEY_URL = "param_url";
  public static final String KEY_URL_ENCRYPT = "param_urlEncrypt";
  public static final String KEY_UUID = "param_uuid";
  public static final String KEY_VIDEO_AIOTIME = "param_cost_c_aio";
  public static final String KEY_VIDEO_CLIENT_COMP_TIME = "param_cost_c_comp";
  public static final String KEY_VIDEO_DURATION = "param_videoDuration";
  public static final String KEY_VIDEO_FILE_FORMAT = "param_fileFormat";
  public static final String KEY_VIDEO_FILE_MD5_S = "param_fileMD5";
  public static final String KEY_VIDEO_IS_PRE_UPLOAD = "param_isPreUpload";
  public static final String KEY_VIDEO_RECORD_TIME = "param_cost_c_record";
  public static final String KEY_VIDEO_RECORD_TIMES = "param_recordTimes";
  public static final String KEY_VIDEO_ROLLBACK = "param_rollback";
  public static final String KEY_VIDEO_SEGS_TIME = "param_cost_s_segs";
  public static final String KEY_VIDEO_SERVER_COMP_TIME = "param_cost_s_comp";
  public static final String KEY_VIDEO_SERVER_ERR_CODE = "param_SvrErroCode";
  public static final String KEY_VIDEO_SERVER_STORE_TIME = "param_cost_s_store";
  public static final String KEY_VIDEO_SESSION_ID = "param_sessionID";
  public static final String KEY_VIDEO_THUMB_MD5 = "param_thumbMd5";
  public static final String KEY_VIDEO_THUMB_SIZE = "param_thumbSize";
  public static final String KEY_VIDEO_TIME_BEFORE_SEND = "param_timeBeforeSend";
  public static final String KEY_VIDEO_TRANS_TIME = "param_cost_c_trans";
  public static final String KEY_VIDEO_WAIT_TIME = "param_cost_c_wait";
  public static final String KEY_XPICCACHETIME = "X-piccachetime";
  public static final String KEY_XRT_FLAG = "param_xRtFlag";
  private static final String PROXY_TAG = "PROXY_IP";
  public static final String REPORT_TAG_SUCC = "param_succ_flag";
  public static final int STEP_MSG_URL_DOWN = 4;
  public static final int STEP_NOTIFY = 3;
  public static final int STEP_SIG = 0;
  public static final int STEP_TRANS = 2;
  public static final int STEP_URL = 1;
  public static final String STORAGE_FTN = "ftn";
  public static final String STORAGE_PIC_PLATFORM = "picplatform";
  public static final String STORAGE_PTT_CENTER = "pttcenter";
  public static final String TAG = "BaseTransProcessor";
  private static ArrayList<TransProcessorHandler> handlerList = new ArrayList();
  private static Object lock = new Object();
  public static String param_Reason = "param_reason";
  static ConcurrentHashMap<String, Integer> sReportMap = new ConcurrentHashMap();
  public AppInterface app;
  StringBuilder costReport = new StringBuilder();
  private int currentProgress;
  public int errCode = 9001;
  public String errDesc = "";
  int errorHttpBadResp = -9531;
  int errorHttpDataNotComplete = -9533;
  int errorHttpDataRender = -9532;
  int errorHttpRollback = -9530;
  int errorUrlDecodeFailed = -9529;
  int errorUrlKeyFieldMiss = -9528;
  public FileMsg file;
  String httpOkFailPre = "Q";
  protected long inQueueCost = 0L;
  protected boolean isDomainTest = false;
  boolean isReportValid = true;
  private String key;
  public BaseTransFileController mController;
  long mEndTime;
  boolean mIsCancel = false;
  boolean mIsOldDbRec = false;
  public boolean mIsPause = false;
  public boolean mIsRawPic = false;
  public boolean mIsShortVideoReceive = false;
  public boolean mIsShortVideoSend = false;
  public IHttpEngineService mNetEngine;
  NetReq mNetReq;
  int mNetworkChgRetryCount = 0;
  protected int mProgress;
  protected List<ProxyIpManager.ProxyIp> mProxyIpList;
  protected RMServMonitorReport mRSMReporter = new RMServMonitorReport();
  protected HashMap<String, String> mReportInfo = new HashMap();
  int mReportedFlag = 0;
  int mRequestUrlNetType = -1;
  RichProto.RichProtoReq mRichProtoReq;
  boolean mSendByQuickHttp = false;
  protected long mStartTime;
  private int mState;
  BaseTransProcessor.StepInfo mStepDirectDown = new BaseTransProcessor.StepInfo();
  BaseTransProcessor.StepInfo mStepMsg = new BaseTransProcessor.StepInfo();
  BaseTransProcessor.StepInfo mStepTrans = new BaseTransProcessor.StepInfo();
  BaseTransProcessor.StepInfo mStepUrl = new BaseTransProcessor.StepInfo();
  private boolean mSupportFakeProgress = false;
  public TransferRequest mUiRequest;
  public String reason = "";
  long reportTimeHt = 0L;
  long reportTimePicCache = 0L;
  long reportTimeTrans = 0L;
  String requestOkFailPre = "P";
  protected int segmentNum = 0;
  
  public BaseTransProcessor() {}
  
  public BaseTransProcessor(BaseTransFileController paramBaseTransFileController)
  {
    this.mController = paramBaseTransFileController;
    this.app = paramBaseTransFileController.app;
    this.file = new FileMsg();
    this.mStartTime = System.nanoTime();
  }
  
  public BaseTransProcessor(BaseTransFileController paramBaseTransFileController, TransferRequest paramTransferRequest)
  {
    this.app = paramBaseTransFileController.app;
    this.mStartTime = System.nanoTime();
    TransFileUtil.printRichMediaDebug("BaseTransProcessor", "TimeCompare", "Processor Start Time = " + this.mStartTime + "ns,Processor = " + this);
    this.file = new FileMsg();
    this.mController = paramBaseTransFileController;
    this.mUiRequest = paramTransferRequest;
    this.file.fileType = this.mUiRequest.mFileType;
    this.file.uniseq = this.mUiRequest.mUniseq;
    this.file.uinType = this.mUiRequest.mUinType;
    this.file.friendUin = this.mUiRequest.mPeerUin;
    paramBaseTransFileController = this.file;
    if (this.mUiRequest.mIsUp) {}
    for (;;)
    {
      paramBaseTransFileController.actionType = i;
      this.mNetEngine = ((IHttpEngineService)this.app.getRuntimeService(IHttpEngineService.class, "all"));
      fetchReportFlag();
      return;
      i = 1;
    }
  }
  
  public BaseTransProcessor(String paramString1, String paramString2, boolean paramBoolean, BaseTransFileController paramBaseTransFileController)
  {
    this.mController = paramBaseTransFileController;
    this.app = paramBaseTransFileController.app;
    this.mStartTime = System.nanoTime();
    if (paramBoolean) {}
    for (;;)
    {
      this.file = new FileMsg(paramString1, paramString2, i);
      this.file.processor = this;
      return;
      i = 1;
    }
  }
  
  public BaseTransProcessor(String paramString, boolean paramBoolean, BaseTransFileController paramBaseTransFileController)
  {
    this.mController = paramBaseTransFileController;
    this.app = paramBaseTransFileController.app;
    this.mStartTime = System.nanoTime();
    if (paramBoolean) {}
    for (;;)
    {
      this.file = new FileMsg(paramString, null, i);
      this.file.processor = this;
      return;
      i = 1;
    }
  }
  
  public static void addHandler(TransProcessorHandler paramTransProcessorHandler)
  {
    synchronized (lock)
    {
      if (!handlerList.contains(paramTransProcessorHandler)) {
        handlerList.add(paramTransProcessorHandler);
      }
      return;
    }
  }
  
  static boolean addProxyIpToList(List<ProxyIpManager.ProxyIp> paramList, List<ServerAddr> paramList1)
  {
    if ((paramList1 == null) || (paramList == null) || (paramList.isEmpty()) || (paramList1.contains(paramList.get(0)))) {
      return false;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      ProxyIpManager.ProxyIp localProxyIp = (ProxyIpManager.ProxyIp)paramList.next();
      Object localObject = paramList1.iterator();
      while (((Iterator)localObject).hasNext())
      {
        ServerAddr localServerAddr = (ServerAddr)((Iterator)localObject).next();
        if ((localProxyIp.ip.equals(localServerAddr.mIp)) && (localProxyIp.port == localServerAddr.port)) {
          paramList1.remove(localServerAddr);
        }
      }
      localObject = new ServerAddr();
      ((ServerAddr)localObject).mIp = localProxyIp.ip;
      ((ServerAddr)localObject).port = localProxyIp.port;
      localArrayList.add(localObject);
    }
    paramList1.addAll(0, localArrayList);
    return true;
  }
  
  public static boolean adjustErrorCode(int paramInt, HashMap<String, String> paramHashMap)
  {
    if (paramHashMap == null) {
      return true;
    }
    if ((paramInt == -9530) || (paramInt == -9532) || (paramInt == -9533) || (paramInt == -9531))
    {
      paramHashMap.put(param_Reason, getServerReason("Q", paramInt));
      paramHashMap.put("param_FailCode", Integer.toString(-9527));
      return true;
    }
    if ((paramInt == -9528) || (paramInt == -9529))
    {
      paramHashMap.put(param_Reason, getServerReason("P", paramInt));
      paramHashMap.put("param_FailCode", Integer.toString(-9527));
      return true;
    }
    return false;
  }
  
  private void collectTransStatistics(NetResp paramNetResp)
  {
    long l1 = 0L;
    if ((paramNetResp.reqCost != 0L) && (this.isReportValid)) {
      if (paramNetResp.mRespProperties.get("X-httime") == null) {
        break label215;
      }
    }
    for (int i = Integer.parseInt((String)paramNetResp.mRespProperties.get("X-httime"));; i = 0)
    {
      if (paramNetResp.mRespProperties.get("X-piccachetime") != null) {
        l1 = Integer.parseInt((String)paramNetResp.mRespProperties.get("X-piccachetime"));
      }
      long l2 = i - l1;
      long l3 = paramNetResp.reqCost - i;
      this.reportTimeTrans += l3;
      this.reportTimeHt += l2;
      this.reportTimePicCache += l1;
      this.costReport.append("s").append(this.segmentNum).append("_").append("tr").append(l3).append("_").append("ht").append(l2).append("_").append("pic").append(l1).append(";");
      this.segmentNum += 1;
      this.inQueueCost = paramNetResp.inQueueCost;
      return;
      label215:
      this.isReportValid = false;
    }
  }
  
  private void doSendProgressMessage()
  {
    if (this.file != null)
    {
      if (this.file.actionType == 0) {
        sendMessageToUpdate(1002);
      }
    }
    else {
      return;
    }
    sendMessageToUpdate(2002);
  }
  
  public static String getClientReason(String paramString)
  {
    return "C_" + paramString;
  }
  
  public static String getExceptionMessage(Exception paramException)
  {
    int i = 8;
    if (paramException == null) {
      return "Exception e is null";
    }
    Object localObject = paramException.getMessage();
    StackTraceElement[] arrayOfStackTraceElement = paramException.getStackTrace();
    if (arrayOfStackTraceElement != null)
    {
      localObject = new StringBuilder(":");
      int j = arrayOfStackTraceElement.length;
      if (j > 8) {}
      for (;;)
      {
        ((StringBuilder)localObject).append("\n");
        j = 0;
        while (j < i)
        {
          ((StringBuilder)localObject).append(arrayOfStackTraceElement[j].toString()).append("\n");
          j += 1;
        }
        i = j;
      }
      return paramException.toString() + ((StringBuilder)localObject).toString();
    }
    return localObject;
  }
  
  public static String getExpStackString(Exception paramException)
  {
    return getExceptionMessage(paramException);
  }
  
  public static String getHttpCmdReason(int paramInt, long paramLong)
  {
    return "S_" + paramInt + "_" + paramLong;
  }
  
  public static String getHttpDataReason(int paramInt, long paramLong)
  {
    return "H_" + paramInt + "_" + paramLong;
  }
  
  public static String getMsgReason(long paramLong)
  {
    return "M_" + paramLong;
  }
  
  public static String getServerReason(String paramString, long paramLong)
  {
    return paramString + "_" + paramLong;
  }
  
  public static String getUrlReason(long paramLong)
  {
    return "T_" + paramLong;
  }
  
  public static void removeHandler(TransProcessorHandler paramTransProcessorHandler)
  {
    synchronized (lock)
    {
      handlerList.remove(paramTransProcessorHandler);
      return;
    }
  }
  
  public static void sendCustomMessageToUpdateDelay(Message paramMessage, Class paramClass, long paramLong)
  {
    synchronized (lock)
    {
      if ((handlerList != null) && (!handlerList.isEmpty()))
      {
        Iterator localIterator = handlerList.iterator();
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
              localObject2 = localTransProcessorHandler.getFilter();
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
  
  private void updateProgress()
  {
    if (this.mSupportFakeProgress)
    {
      int i = getRealProgress();
      if (i > this.mProgress) {
        this.mProgress = i;
      }
    }
  }
  
  public void accountChanged() {}
  
  public void addDomainToList(ArrayList<ServerAddr> paramArrayList, String paramString)
  {
    if ((paramArrayList != null) && (paramString != null))
    {
      ServerAddr localServerAddr = new ServerAddr();
      localServerAddr.mIp = paramString;
      localServerAddr.isDomain = true;
      paramArrayList.add(localServerAddr);
    }
  }
  
  void analysisIOProblem(IOException paramIOException)
  {
    paramIOException = paramIOException.getMessage();
    String str = Environment.getExternalStorageState();
    if (paramIOException.contains("EACCES")) {
      setError(9039, paramIOException);
    }
    do
    {
      return;
      if (paramIOException.contains("ENOSPC"))
      {
        setError(9040, paramIOException);
        return;
      }
      if (paramIOException.contains("Read-only"))
      {
        setError(9039, paramIOException);
        return;
      }
    } while ("mounted".equals(str));
    setError(9039, paramIOException);
  }
  
  protected boolean canDoNextStep()
  {
    return (!this.mIsCancel) && (!this.mIsPause);
  }
  
  public int cancel()
  {
    if (this.mUiRequest != null) {
      if (!this.mUiRequest.mIsUp) {
        break label198;
      }
    }
    label198:
    for (int i = 1004;; i = 2004)
    {
      sendMessageToUpdate(i);
      this.mIsCancel = true;
      if ((QLog.isColorLevel()) && (this.mUiRequest != null)) {
        logRichMediaEvent("cancel", "");
      }
      if (this.mRichProtoReq != null)
      {
        RichProtoProc.cancelRichProtoReq(this.mRichProtoReq);
        this.mRichProtoReq = null;
      }
      if (this.mNetReq != null)
      {
        this.mNetEngine.cancelReq(this.mNetReq);
        this.mNetReq = null;
      }
      this.mController.removeProcessor(getKey());
      try
      {
        if (this.mUiRequest != null)
        {
          TransferResult localTransferResult = this.mUiRequest.mResult;
          if (localTransferResult != null)
          {
            localTransferResult.mResult = -1;
            localTransferResult.mErrCode = 9037L;
            localTransferResult.mOrigReq = this.mUiRequest;
          }
        }
        if (this.mUiRequest != null) {
          logRichMediaEvent("cancel", "");
        }
        notifyAll();
        if (this.mUiRequest != null) {
          logRichMediaEvent("cancel", "");
        }
        return 0;
      }
      finally {}
    }
  }
  
  public void cancelTransTimer() {}
  
  public int checkParam()
  {
    return 0;
  }
  
  void clearReprotInfo()
  {
    this.errCode = 0;
    this.errDesc = "";
    this.mReportInfo.clear();
  }
  
  public void copyRespCommon(BaseTransProcessor.StepInfo paramStepInfo, RichProto.RichProtoResp.RespCommon paramRespCommon)
  {
    if ((paramStepInfo != null) && (paramRespCommon != null))
    {
      paramStepInfo.logFinishTime();
      paramStepInfo.successTryCount = paramRespCommon.successCount;
      paramStepInfo.failTryCount = paramRespCommon.failCount;
      if (paramRespCommon.result == 0) {
        paramStepInfo.result = 1;
      }
    }
    else
    {
      return;
    }
    paramStepInfo.result = 0;
    setError(paramRespCommon.errCode, paramRespCommon.errStr, paramRespCommon.reason, paramStepInfo);
  }
  
  public void copyStatisInfo(BaseTransProcessor.StepInfo paramStepInfo, boolean paramBoolean1, boolean paramBoolean2, StatictisInfo paramStatictisInfo)
  {
    if (paramStatictisInfo == null) {
      return;
    }
    paramStepInfo.logFinishTime();
    if (paramBoolean2)
    {
      paramStepInfo.failTryCount = (paramStatictisInfo.c - 1);
      paramStepInfo.successTryCount = 1;
      paramStepInfo.result = 1;
      return;
    }
    String str;
    if (paramStatictisInfo.b == 2900)
    {
      i = -9527;
      if (!paramBoolean1) {}
      for (str = getMsgReason(paramStatictisInfo.jdField_a_of_type_Long);; str = getUrlReason(paramStatictisInfo.jdField_a_of_type_Long))
      {
        setError(i, "", str, paramStepInfo);
        paramStepInfo.failTryCount = paramStatictisInfo.c;
        paramStepInfo.successTryCount = 0;
        paramStepInfo.result = 0;
        return;
      }
    }
    if ((paramStatictisInfo.b == 1002) || (paramStatictisInfo.b == 1013))
    {
      if (!paramBoolean1) {}
      for (i = 9350;; i = 9311)
      {
        str = paramStatictisInfo.jdField_a_of_type_JavaLangString;
        break;
      }
    }
    if (!paramBoolean1) {}
    for (int i = 9351;; i = 9044)
    {
      str = paramStatictisInfo.jdField_a_of_type_JavaLangString;
      break;
    }
  }
  
  public void copyStatisInfoFromNetResp(BaseTransProcessor.StepInfo paramStepInfo, NetResp paramNetResp, boolean paramBoolean)
  {
    if ((paramStepInfo == null) || (paramNetResp == null)) {
      return;
    }
    this.mReportInfo.put("param_Server", paramNetResp.mRespProperties.get("serverip"));
    if (paramBoolean)
    {
      this.mReportInfo.put("serverip", paramNetResp.mRespProperties.get("serverip"));
      paramStepInfo.successTryCount += 1;
      paramStepInfo.failTryCount += paramNetResp.mTryTime - 1;
      paramStepInfo.logFinishTime();
      paramStepInfo.result = 1;
      this.mReportInfo.remove("param_url");
      this.mReportInfo.remove("param_rspHeader");
      return;
    }
    this.mReportInfo.put("serverip", paramNetResp.mRespProperties.get("firstserverip"));
    paramStepInfo.failTryCount += paramNetResp.mTryTime;
    if (paramNetResp.mErrCode == -9527) {}
    for (String str = (String)paramNetResp.mRespProperties.get("netresp_param_reason");; str = null)
    {
      setError(paramNetResp.mErrCode, paramNetResp.mErrDesc, str, paramStepInfo);
      this.mReportInfo.put("param_url", paramNetResp.mRespProperties.get("param_url"));
      this.mReportInfo.put("param_rspHeader", paramNetResp.mRespProperties.get("param_rspHeader"));
      if ((paramNetResp.mErrCode == -9527) && ("H_404_-124".equals(str))) {
        this.mReportInfo.put("param_reqHeader", paramNetResp.mRespProperties.get("param_reqHeader"));
      }
      paramStepInfo.result = 0;
      return;
    }
  }
  
  public void decode(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2) {}
  
  protected void doReport(boolean paramBoolean) {}
  
  public void doReportForServerMonitor(String paramString, boolean paramBoolean)
  {
    if (this.mRSMReporter.mReason == null) {
      this.mRSMReporter.mReason = this.reason;
    }
    if (this.mRSMReporter.mErrDesc == null) {
      this.mRSMReporter.mErrDesc = this.errDesc;
    }
    this.mRSMReporter.mChatType = (this.mUiRequest.mUinType + "");
    this.mRSMReporter.mChatUin = (this.mUiRequest.mPeerUin + "");
    if (isUploadProcessor()) {}
    for (this.mRSMReporter.mIPPolicy = Ipv6Config.getFlags().mBdhStrategy;; this.mRSMReporter.mIPPolicy = Ipv6Config.getFlags().mRMDownStrategy)
    {
      if ((this.mStepTrans != null) && (this.mStepTrans.startTime > 0L)) {
        this.mRSMReporter.mTimeCost = ((System.nanoTime() - this.mStepTrans.startTime) / 1000000L);
      }
      this.mRSMReporter.doReport(paramString, paramBoolean);
      return;
    }
  }
  
  public boolean errerOccered()
  {
    return this.errCode != 9001;
  }
  
  public void fetchReportFlag()
  {
    boolean bool = false;
    Integer localInteger = (Integer)sReportMap.get(this.mUiRequest.getKey());
    if (localInteger == null) {}
    for (int i = 0;; i = localInteger.intValue())
    {
      this.mReportedFlag = i;
      if (this.mUiRequest.mDbRecVersion < 3) {
        bool = true;
      }
      this.mIsOldDbRec = bool;
      return;
    }
  }
  
  public int getCurrentProgress()
  {
    return this.currentProgress;
  }
  
  public FileMsg getFileMsg()
  {
    return this.file;
  }
  
  public long getFileSize()
  {
    return this.file.fileSize;
  }
  
  public long getFileStatus()
  {
    return this.file.status;
  }
  
  public String getKey()
  {
    return this.key;
  }
  
  public long getLastFileStatus()
  {
    return this.file.lastStatus;
  }
  
  public int getProgress()
  {
    int j = 0;
    int i;
    if (this.mSupportFakeProgress) {
      i = this.mProgress;
    }
    do
    {
      do
      {
        return i;
        i = j;
      } while (this.file == null);
      i = j;
    } while (this.file.fileSize <= 0L);
    return (int)(this.file.transferedSize * 100L / this.file.fileSize);
  }
  
  protected IProtoReqManager getProtoReqManager()
  {
    return (IProtoReqManager)this.app.getRuntimeService(IProtoReqManager.class, "");
  }
  
  public int getRealProgress()
  {
    int j = 0;
    int i = j;
    if (this.file != null)
    {
      i = j;
      if (this.file.fileSize > 0L)
      {
        j = (int)(this.file.transferedSize * 100L / this.file.fileSize);
        i = j;
        if (this.file.actionType == 0) {
          if (this.file.fileType != 1)
          {
            i = j;
            if (this.file.fileType != 131075) {}
          }
          else
          {
            i = j;
            if (j == 100)
            {
              i = j;
              if (this.file.status != 1003) {
                i = 99;
              }
            }
          }
        }
      }
    }
    return i;
  }
  
  protected String getReportTAG()
  {
    return null;
  }
  
  protected int getState()
  {
    return this.mState;
  }
  
  @Deprecated
  public FileMsg.StepBaseInfo getStepInfo(int paramInt)
  {
    Object localObject1 = null;
    if (paramInt == 0) {}
    for (;;)
    {
      try
      {
        localObject1 = this.file.stepSig;
        return localObject1;
      }
      finally {}
      if (paramInt == 1) {
        localObject1 = this.file.stepUrl;
      } else if (paramInt == 2) {
        localObject1 = this.file.stepTrans;
      } else if (paramInt == 3) {
        localObject1 = this.file.stepNotify;
      } else if (paramInt == 3) {
        localObject1 = this.file.stepMsgDirecDown;
      }
    }
  }
  
  public TransferRequest getTransferRequest()
  {
    return this.mUiRequest;
  }
  
  public long getTransferedSize()
  {
    return this.file.transferedSize;
  }
  
  public void handleError(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2) {}
  
  public void handleRedirect(String paramString) {}
  
  /* Error */
  @Deprecated
  public void incStepCount(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: iload_1
    //   4: invokevirtual 1131	com/tencent/mobileqq/transfile/BaseTransProcessor:getStepInfo	(I)Lcom/tencent/mobileqq/transfile/FileMsg$StepBaseInfo;
    //   7: astore 4
    //   9: aload 4
    //   11: ifnull +19 -> 30
    //   14: iload_2
    //   15: ifeq +18 -> 33
    //   18: aload 4
    //   20: aload 4
    //   22: getfield 1134	com/tencent/mobileqq/transfile/FileMsg$StepBaseInfo:successTryCount	I
    //   25: iload_3
    //   26: iadd
    //   27: putfield 1134	com/tencent/mobileqq/transfile/FileMsg$StepBaseInfo:successTryCount	I
    //   30: aload_0
    //   31: monitorexit
    //   32: return
    //   33: aload 4
    //   35: aload 4
    //   37: getfield 1135	com/tencent/mobileqq/transfile/FileMsg$StepBaseInfo:failTryCount	I
    //   40: iload_3
    //   41: iadd
    //   42: putfield 1135	com/tencent/mobileqq/transfile/FileMsg$StepBaseInfo:failTryCount	I
    //   45: goto -15 -> 30
    //   48: astore 4
    //   50: aload_0
    //   51: monitorexit
    //   52: aload 4
    //   54: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	55	0	this	BaseTransProcessor
    //   0	55	1	paramInt1	int
    //   0	55	2	paramBoolean	boolean
    //   0	55	3	paramInt2	int
    //   7	29	4	localStepBaseInfo	FileMsg.StepBaseInfo
    //   48	5	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	9	48	finally
    //   18	30	48	finally
    //   33	45	48	finally
  }
  
  boolean isAppValid()
  {
    return (this.app.isRunning()) && (this.app.isLogin());
  }
  
  public boolean isPause()
  {
    return this.mIsPause;
  }
  
  public boolean isRawPic()
  {
    return this.mIsRawPic;
  }
  
  protected boolean isRetry(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2)
  {
    if (paramHttpMsg2 == null) {}
    do
    {
      return false;
      paramHttpMsg1 = paramHttpMsg2.getErrorString();
    } while ((paramHttpMsg1 != null) && (paramHttpMsg1.contains("HttpCommunicator closed or msg caceled!")));
    return true;
  }
  
  protected boolean isUploadProcessor()
  {
    return true;
  }
  
  public void logRichMediaEvent(String paramString1, String paramString2)
  {
    if (this.file == null)
    {
      TransFileUtil.printRichMediaError("BaseTransProcessor", "logRichMediaEvent", "file is null !");
      return;
    }
    int i = -1;
    if (this.mUiRequest != null) {
      i = this.mUiRequest.mUinType;
    }
    boolean bool;
    if (this.mUiRequest != null) {
      bool = this.mUiRequest.mIsUp;
    }
    for (;;)
    {
      TransFileUtil.log(TransFileUtil.getUinDesc(i), bool, RichMediaUtil.getFileTypeDesc(this.file.fileType), String.valueOf(this.file.uniseq), paramString1, paramString2);
      return;
      if (this.file.actionType == 0) {
        bool = true;
      } else {
        bool = false;
      }
    }
  }
  
  public void onBusiProtoResp(RichProto.RichProtoReq paramRichProtoReq, RichProto.RichProtoResp paramRichProtoResp) {}
  
  void onError()
  {
    long l = (System.nanoTime() - this.mStartTime) / 1000000L;
    if ((this.app != null) && ((!this.app.isLogin()) || (!this.app.isRunning()))) {
      setError(9366, "account switch");
    }
    logRichMediaEvent("onError", "elapsed:" + l + " errCode:" + this.errCode + " errDesc:" + this.errDesc + " reason:" + (String)this.mReportInfo.get("param_reason"));
    doReport(false);
    this.mController.removeProcessor(getKey());
  }
  
  public void onProtoResp(ProtoReqManagerImpl.ProtoResp paramProtoResp, ProtoReqManagerImpl.ProtoReq paramProtoReq) {}
  
  public void onResp(NetResp paramNetResp)
  {
    collectTransStatistics(paramNetResp);
  }
  
  void onSuccess()
  {
    long l = (System.nanoTime() - this.mStartTime) / 1000000L;
    logRichMediaEvent("onSuccess", "elapsed:" + l + ",key:" + getKey());
    doReport(true);
    this.mController.removeProcessor(getKey());
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2) {}
  
  public void pause() {}
  
  protected String replaceUrlWithProxyIp(String paramString, List<ServerAddr> paramList)
  {
    Object localObject1 = null;
    if ((this.mProxyIpList == null) || (this.mProxyIpList.isEmpty()))
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
      localServerAddr = TransFileUtil.getIpAndPortFromUrl(paramString);
      if (localServerAddr != null) {
        break;
      }
      paramList = paramString;
    } while (!QLog.isColorLevel());
    QLog.d("PROXY_IP", 2, "[HTTP] replace proxy ip fail, host is domain");
    return paramString;
    Object localObject2 = this.mProxyIpList.iterator();
    int i = 0;
    label88:
    Object localObject3;
    if (((Iterator)localObject2).hasNext())
    {
      localObject3 = (ProxyIpManager.ProxyIp)((Iterator)localObject2).next();
      if ((!((ProxyIpManager.ProxyIp)localObject3).ip.equals(localServerAddr.mIp)) || (((ProxyIpManager.ProxyIp)localObject3).port != localServerAddr.port)) {
        break label617;
      }
      i = 1;
    }
    label617:
    for (;;)
    {
      break label88;
      if (i == 0)
      {
        localObject1 = (ProxyIpManager.ProxyIp)this.mProxyIpList.get(0);
        paramList = paramString;
        if (paramString == null) {
          break;
        }
        if (paramString.startsWith("http://")) {
          paramList = "http://" + ((ProxyIpManager.ProxyIp)localObject1).ip + ":" + ((ProxyIpManager.ProxyIp)localObject1).port + "/";
        }
      }
      for (;;)
      {
        paramString = TransFileUtil.replaceIp(paramString, paramList);
        paramString = paramString + "&bHost=" + localServerAddr.mIp + "&bPort=" + localServerAddr.port;
        paramList = paramString;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("PROXY_IP", 2, "[HTTP] replace proxy ip: " + ((ProxyIpManager.ProxyIp)localObject1).ip + ":" + ((ProxyIpManager.ProxyIp)localObject1).port);
        return paramString;
        if (paramString.startsWith("https://"))
        {
          paramList = "https://" + ((ProxyIpManager.ProxyIp)localObject1).ip + ":" + ((ProxyIpManager.ProxyIp)localObject1).port + "/";
          continue;
          localObject3 = paramList.iterator();
          paramList = (List<ServerAddr>)localObject1;
          do
          {
            localObject2 = paramList;
            if (!((Iterator)localObject3).hasNext()) {
              break;
            }
            localObject2 = (ServerAddr)((Iterator)localObject3).next();
            Iterator localIterator = this.mProxyIpList.iterator();
            do
            {
              localObject1 = paramList;
              if (!localIterator.hasNext()) {
                break;
              }
              localObject1 = (ProxyIpManager.ProxyIp)localIterator.next();
            } while ((((ServerAddr)localObject2).mIp.equals(((ProxyIpManager.ProxyIp)localObject1).ip)) || (((ServerAddr)localObject2).port == ((ProxyIpManager.ProxyIp)localObject1).port));
            localObject1 = localObject2;
            paramList = (List<ServerAddr>)localObject1;
          } while (localObject1 == null);
          localObject2 = localObject1;
          localObject1 = paramString;
          if (localObject2 != null) {
            localObject1 = paramString + "&bHost=" + ((ServerAddr)localObject2).mIp + "&bPort=" + ((ServerAddr)localObject2).port;
          }
          paramList = (List<ServerAddr>)localObject1;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("PROXY_IP", 2, "[HTTP] replace proxy ip: " + localServerAddr.mIp + ":" + localServerAddr.port);
          return localObject1;
        }
        paramList = null;
      }
    }
  }
  
  public void reportForIpv6(boolean paramBoolean, long paramLong)
  {
    this.mReportInfo.put("ipStackType", String.valueOf(NetConnInfoCenter.getActiveNetIpFamily(false)));
    this.mReportInfo.put("msfConnIPType", String.valueOf(MsfServiceSdk.get().getConnectedIPFamily()));
    if (isUploadProcessor()) {
      this.mReportInfo.put("param_Ipv6Policy", String.valueOf(Ipv6Config.getFlags().mBdhStrategy));
    }
    for (;;)
    {
      if ((this.mReportInfo.get("param_is_ipv6") != null) && (((String)this.mReportInfo.get("param_is_ipv6")).equals(String.valueOf(1)))) {
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, getReportTAG() + "_ipv6", paramBoolean, paramLong, 0L, this.mReportInfo, "");
      }
      return;
      this.mReportInfo.put("param_Ipv6Policy", String.valueOf(Ipv6Config.getFlags().mRMDownStrategy));
    }
  }
  
  public void resetTransTimer() {}
  
  public int resume()
  {
    return 0;
  }
  
  public void retry() {}
  
  protected void sendMessageToUpdate(int paramInt)
  {
    sendMessageToUpdateDelay(paramInt, 0L);
  }
  
  protected void sendMessageToUpdateDelay(int paramInt1, int paramInt2, long paramLong)
  {
    logRichMediaEvent("updateUiState", "state:" + paramInt1 + " ret:" + paramInt2 + " currentProgress:" + this.currentProgress + " mProgress:" + this.mProgress);
    if (((paramInt1 == 2005) || (paramInt1 == 1005)) && (this.errCode == 9001))
    {
      String str = getExceptionMessage(new Exception());
      HashMap localHashMap = new HashMap();
      localHashMap.put("stackMsg", str);
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actRichMediaReportError", false, 0L, 0L, localHashMap, "");
    }
    this.mEndTime = System.currentTimeMillis();
    long l = (System.nanoTime() - this.mStartTime) / 1000000L;
    boolean bool;
    if ((l > 60000L) || (paramInt1 == 1005))
    {
      bool = true;
      if (l <= 60000L) {
        break label210;
      }
      RichMediaUtil.stopImageSendReport(true, "image_sending_too_long");
    }
    for (;;)
    {
      sendMsgToUpdateUIDelay(paramInt1, paramInt2, paramLong);
      return;
      bool = false;
      break;
      label210:
      RichMediaUtil.stopImageSendReport(bool, "image_sending_" + this.errCode + "_" + this.errDesc);
    }
  }
  
  protected void sendMessageToUpdateDelay(int paramInt, long paramLong)
  {
    sendMessageToUpdateDelay(paramInt, 0, paramLong);
  }
  
  protected void sendMsgToUpdateUIDelay(int paramInt1, int paramInt2, long paramLong)
  {
    if (this.mIsCancel) {
      return;
    }
    synchronized (lock)
    {
      this.mState = paramInt1;
      if ((handlerList != null) && (!handlerList.isEmpty()))
      {
        Iterator localIterator = handlerList.iterator();
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
              localObject3 = localTransProcessorHandler.getFilter();
            } while (((ArrayList)localObject3).isEmpty());
            localObject3 = ((ArrayList)localObject3).iterator();
          }
          localObject4 = (Class)((Iterator)localObject3).next();
        } while (!getClass().equals(localObject4));
        Object localObject4 = localTransProcessorHandler.obtainMessage();
        this.file.lastStatus = this.file.status;
        this.file.status = paramInt1;
        ((Message)localObject4).what = paramInt1;
        ((Message)localObject4).obj = this.file;
        ((Message)localObject4).arg1 = paramInt2;
        localTransProcessorHandler.sendMessageDelayed((Message)localObject4, paramLong);
      }
    }
  }
  
  protected void sendProgressMessage()
  {
    if (this.file != null)
    {
      updateProgress();
      doSendProgressMessage();
    }
  }
  
  public void setCurrentProgress(int paramInt)
  {
    this.currentProgress = paramInt;
  }
  
  public void setError(int paramInt, String paramString)
  {
    setError(paramInt, paramString, null, null);
  }
  
  public void setError(int paramInt, String paramString1, String paramString2, BaseTransProcessor.StepInfo paramStepInfo)
  {
    this.errCode = paramInt;
    this.reason = paramString2;
    this.errDesc = paramString1;
    if ((paramString2 != null) && (!"".equals(paramString2))) {
      this.mReportInfo.put("param_reason", paramString2);
    }
    if (paramStepInfo != null)
    {
      paramStepInfo.logFinishTime();
      paramStepInfo.result = 0;
    }
  }
  
  public void setFakeProgressCapable(boolean paramBoolean)
  {
    this.mSupportFakeProgress = paramBoolean;
  }
  
  public void setFileSize(long paramLong)
  {
    this.file.fileSize = paramLong;
  }
  
  @Deprecated
  public void setHttpError(int paramInt1, int paramInt2, long paramLong, String paramString)
  {
    try
    {
      FileMsg.StepTransInfo localStepTransInfo = this.file.stepTrans;
      localStepTransInfo.errCode = paramInt1;
      localStepTransInfo.result = false;
      localStepTransInfo.errDesc = paramString;
      localStepTransInfo.httpRespCode = paramInt2;
      localStepTransInfo.detailErrCode = paramLong;
      setError(localStepTransInfo.errCode, localStepTransInfo.errDesc);
      setStepFinishTime(2);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void setId(long paramLong)
  {
    this.file.setFileId(paramLong);
  }
  
  public void setKey(String paramString)
  {
    this.key = paramString;
  }
  
  @Deprecated
  public void setMsgError(int paramInt, StatictisInfo paramStatictisInfo, String paramString)
  {
    try
    {
      setMsgResult(paramInt, false, paramStatictisInfo, paramString);
      return;
    }
    finally
    {
      paramStatictisInfo = finally;
      throw paramStatictisInfo;
    }
  }
  
  @Deprecated
  public void setMsgResult(int paramInt, boolean paramBoolean, StatictisInfo paramStatictisInfo, String paramString)
  {
    int i = 9351;
    FileMsg.StepBaseInfo localStepBaseInfo;
    for (;;)
    {
      try
      {
        localStepBaseInfo = getStepInfo(paramInt);
        if (localStepBaseInfo == null)
        {
          if (!paramBoolean)
          {
            if (paramInt == 3) {
              setStepError(paramInt, i, paramString + "info null");
            }
          }
          else {
            return;
          }
          i = 9044;
          continue;
        }
        if (!paramBoolean) {
          break label115;
        }
        if (paramStatictisInfo == null)
        {
          localStepBaseInfo.failTryCount = 0;
          localStepBaseInfo.successTryCount = 1;
          continue;
        }
        localStepBaseInfo.failTryCount = (paramStatictisInfo.c - 1);
      }
      finally {}
      localStepBaseInfo.successTryCount = 1;
      continue;
      label115:
      if (paramStatictisInfo != null) {
        break;
      }
      localStepBaseInfo.failTryCount = 1;
      localStepBaseInfo.successTryCount = 0;
    }
    if (paramStatictisInfo.b == 2900)
    {
      paramStatictisInfo.b = -9527;
      if (paramInt == 3) {
        paramString = getMsgReason(paramStatictisInfo.jdField_a_of_type_Long);
      }
    }
    for (;;)
    {
      setStepError(paramInt, paramStatictisInfo.b, paramString);
      localStepBaseInfo.detailErrCode = paramStatictisInfo.jdField_a_of_type_Long;
      localStepBaseInfo.retryCount = paramStatictisInfo.c;
      localStepBaseInfo.failTryCount = paramStatictisInfo.c;
      localStepBaseInfo.successTryCount = 0;
      break;
      paramString = getUrlReason(paramStatictisInfo.jdField_a_of_type_Long);
      continue;
      if (paramStatictisInfo.b == 1002) {
        break label285;
      }
      if (paramStatictisInfo.b != 1013) {
        break label306;
      }
      break label285;
      paramStatictisInfo.b = i;
      paramString = paramStatictisInfo.jdField_a_of_type_JavaLangString;
    }
    for (;;)
    {
      label262:
      paramStatictisInfo.b = i;
      paramString = paramStatictisInfo.jdField_a_of_type_JavaLangString;
      break;
      label285:
      label306:
      do
      {
        i = 9044;
        break label262;
        if (paramInt == 3)
        {
          i = 9350;
          break;
        }
        i = 9311;
        break;
      } while (paramInt != 3);
    }
  }
  
  protected void setMtype() {}
  
  public void setPicTrumbSize(long paramLong)
  {
    this.file.picThumbSize = paramLong;
  }
  
  public void setReportFlag()
  {
    sReportMap.put(this.mUiRequest.getKey(), Integer.valueOf(this.mReportedFlag));
    if (sReportMap.size() > 2000) {
      sReportMap.clear();
    }
  }
  
  @Deprecated
  public void setStepError(int paramInt1, int paramInt2, long paramLong, String paramString)
  {
    try
    {
      FileMsg.StepBaseInfo localStepBaseInfo = getStepInfo(paramInt1);
      if (localStepBaseInfo != null)
      {
        localStepBaseInfo.errCode = paramInt2;
        localStepBaseInfo.errDesc = paramString;
        localStepBaseInfo.detailErrCode = paramLong;
        localStepBaseInfo.result = false;
        setStepFinishTime(paramInt1);
      }
      setError(paramInt2, paramString);
      return;
    }
    finally {}
  }
  
  @Deprecated
  public void setStepError(int paramInt1, int paramInt2, String paramString)
  {
    try
    {
      FileMsg.StepBaseInfo localStepBaseInfo = getStepInfo(paramInt1);
      if (localStepBaseInfo != null)
      {
        localStepBaseInfo.errCode = paramInt2;
        localStepBaseInfo.errDesc = paramString;
        localStepBaseInfo.result = false;
        setStepFinishTime(paramInt1);
      }
      setError(paramInt2, paramString);
      return;
    }
    finally {}
  }
  
  @Deprecated
  public void setStepFinishTime(int paramInt)
  {
    try
    {
      FileMsg.StepBaseInfo localStepBaseInfo = getStepInfo(paramInt);
      if (localStepBaseInfo != null) {
        localStepBaseInfo.finishTime = System.currentTimeMillis();
      }
      return;
    }
    finally {}
  }
  
  @Deprecated
  public void setStepRetryCount(int paramInt1, int paramInt2)
  {
    try
    {
      FileMsg.StepBaseInfo localStepBaseInfo = getStepInfo(paramInt1);
      if (localStepBaseInfo != null) {
        localStepBaseInfo.retryCount = paramInt2;
      }
      return;
    }
    finally {}
  }
  
  @Deprecated
  public void setStepStartTime(int paramInt)
  {
    setStepStartTime(paramInt, false);
  }
  
  @Deprecated
  public void setStepStartTime(int paramInt, boolean paramBoolean)
  {
    try
    {
      FileMsg.StepBaseInfo localStepBaseInfo = getStepInfo(paramInt);
      if ((localStepBaseInfo != null) && ((localStepBaseInfo.startTime == 0L) || (paramBoolean))) {
        localStepBaseInfo.startTime = System.currentTimeMillis();
      }
      return;
    }
    finally {}
  }
  
  public void setTransType(int paramInt)
  {
    this.file.setFileType(paramInt);
  }
  
  @Deprecated
  public void setTryCountInfoFromMsgHandler(int paramInt, boolean paramBoolean, StatictisInfo paramStatictisInfo)
  {
    int j = 0;
    int k = 0;
    int m = 0;
    int i = 0;
    FileMsg.StepBaseInfo localStepBaseInfo;
    for (;;)
    {
      try
      {
        localStepBaseInfo = getStepInfo(paramInt);
        if (localStepBaseInfo == null) {
          return;
        }
        if (!paramBoolean) {
          break;
        }
        if (paramInt != 1) {
          break label148;
        }
        if (paramStatictisInfo == null)
        {
          paramInt = i;
          localStepBaseInfo.failTryCount = paramInt;
          localStepBaseInfo.successTryCount = 1;
          continue;
        }
        paramInt = paramStatictisInfo.c - 1;
      }
      finally {}
      continue;
      for (;;)
      {
        localStepBaseInfo.failTryCount = paramInt;
        break;
        label84:
        paramInt = paramStatictisInfo.c;
      }
    }
    localStepBaseInfo.successTryCount = 0;
    if (paramInt == 1)
    {
      if (paramStatictisInfo == null) {}
      for (paramInt = k;; paramInt = paramStatictisInfo.c)
      {
        localStepBaseInfo.failTryCount = paramInt;
        break;
      }
    }
    for (;;)
    {
      label127:
      localStepBaseInfo.failTryCount = paramInt;
      break;
      label148:
      do
      {
        paramInt = paramStatictisInfo.c;
        paramInt += 1;
        break label127;
        if (paramStatictisInfo != null) {
          break label84;
        }
        paramInt = j;
        break;
      } while (paramStatictisInfo != null);
      paramInt = m;
    }
  }
  
  public void start() {}
  
  public boolean statusChanged(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2, int paramInt)
  {
    return true;
  }
  
  public void stop() {}
  
  protected void timeout() {}
  
  public void updateMessageDataBaseContent(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.BaseTransProcessor
 * JD-Core Version:    0.7.0.1
 */