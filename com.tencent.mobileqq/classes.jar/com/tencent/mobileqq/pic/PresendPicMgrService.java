package com.tencent.mobileqq.pic;

import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.photo.StatisticConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCAccountNames;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.pic.api.ICompressOperator;
import com.tencent.mobileqq.pic.api.IPicBus;
import com.tencent.mobileqq.pic.api.IPicUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmedia.ordersend.IOrderMediaMsgService;
import com.tencent.mobileqq.transfile.BaseTransFileController;
import com.tencent.mobileqq.transfile.BaseUploadProcessor;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.troop.utils.TroopGrayTipUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.LogTag;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AccountNotMatchException;

public class PresendPicMgrService
  extends IPresendPicMgr.Stub
{
  private static PresendPicMgrService jdField_a_of_type_ComTencentMobileqqPicPresendPicMgrService;
  static int jdField_b_of_type_Int;
  public int a;
  public long a;
  public String a;
  private ArrayList<PicReq> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  private long jdField_b_of_type_Long;
  private String jdField_b_of_type_JavaLangString;
  private ArrayList<PicReq> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int = 0;
  private long jdField_c_of_type_Long = 209715200L;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int = 90;
  private long jdField_d_of_type_Long = 157286400L;
  private String jdField_d_of_type_JavaLangString;
  private boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int = 70;
  private long jdField_e_of_type_Long = 73400320L;
  private boolean jdField_e_of_type_Boolean;
  private int jdField_f_of_type_Int = 50;
  private long jdField_f_of_type_Long = 52428800L;
  private boolean jdField_f_of_type_Boolean;
  private int jdField_g_of_type_Int;
  private boolean jdField_g_of_type_Boolean;
  private int jdField_h_of_type_Int;
  private boolean jdField_h_of_type_Boolean;
  private boolean i = false;
  
  public PresendPicMgrService(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_g_of_type_Int = paramInt1;
    this.jdField_b_of_type_JavaLangString = paramString1;
    this.jdField_c_of_type_JavaLangString = paramString2;
    this.jdField_d_of_type_JavaLangString = paramString3;
    this.jdField_h_of_type_Int = paramInt2;
    long l1 = BasePicPreDownloadUtils.a("presend_lastDayTime", 0L);
    long l2 = System.currentTimeMillis();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("currentTime = ");
    localStringBuilder.append(l2);
    localStringBuilder.append(", lastDayTime = ");
    localStringBuilder.append(l1);
    localStringBuilder.append(", curFriendUin = ");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(",troopUin = ");
    localStringBuilder.append(paramString2);
    localStringBuilder.append(",myUin = ");
    localStringBuilder.append(paramString3);
    Logger.a("PresendPicMgrService", "[@]PresendPicMgrService", localStringBuilder.toString());
    e();
    if (l2 - l1 > 86400000L)
    {
      Logger.a("PresendPicMgrService", "PresendPicMgrService", "more than one day, clear wastesize");
      StatisticConstants.a(BasePicPreDownloadUtils.a("presend_FlowWaste", 0L));
      BasePicPreDownloadUtils.a("presend_lastDayTime", l2);
      BasePicPreDownloadUtils.a("presend_FlowWaste", 0L);
    }
    this.jdField_b_of_type_Long = BasePicPreDownloadUtils.a("presend_FlowWaste", 0L);
    jdField_a_of_type_ComTencentMobileqqPicPresendPicMgrService = this;
  }
  
  private PicReq a(ArrayList<PicReq> paramArrayList, String paramString)
  {
    if (paramArrayList != null)
    {
      if (paramArrayList.size() == 0) {
        return null;
      }
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        PicReq localPicReq = (PicReq)paramArrayList.next();
        if (localPicReq.jdField_a_of_type_JavaLangString.equals(paramString)) {
          return localPicReq;
        }
      }
    }
    return null;
  }
  
  private PicUploadInfo a(String paramString, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    Object localObject = new PicUploadInfo.Builder();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("curFriendUin = ");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    Logger.a("PresendPicMgrService", "[@]buildPicUploadInfo", localStringBuilder.toString());
    ((PicUploadInfo.Builder)localObject).d(this.jdField_b_of_type_JavaLangString);
    ((PicUploadInfo.Builder)localObject).a(paramString);
    ((PicUploadInfo.Builder)localObject).e(this.jdField_g_of_type_Int);
    ((PicUploadInfo.Builder)localObject).e(this.jdField_c_of_type_JavaLangString);
    ((PicUploadInfo.Builder)localObject).d(paramInt1);
    ((PicUploadInfo.Builder)localObject).f(0);
    ((PicUploadInfo.Builder)localObject).k(paramInt2);
    ((PicUploadInfo.Builder)localObject).l(this.jdField_h_of_type_Int);
    localObject = ((PicUploadInfo.Builder)localObject).a();
    if (paramInt2 == 10)
    {
      if (((PicUploadInfo)localObject).jdField_a_of_type_ComTencentMobileqqPicPicUploadExtra == null) {
        ((PicUploadInfo)localObject).jdField_a_of_type_ComTencentMobileqqPicPicUploadExtra = new PicUploadExtra();
      }
      ((PicUploadInfo)localObject).jdField_a_of_type_ComTencentMobileqqPicPicUploadExtra.jdField_a_of_type_Int = 9;
    }
    ((PicUploadInfo)localObject).jdField_c_of_type_Boolean = true;
    if (((IPicUtil)QRoute.api(IPicUtil.class)).isProgressiveJpeg(paramString)) {
      LogTag.a();
    }
    try
    {
      ((PicUploadInfo)localObject).jdField_a_of_type_JavaUtilArrayList = ((IPicUtil)QRoute.api(IPicUtil.class)).getSliceInfos(paramString);
      if ((((PicUploadInfo)localObject).jdField_a_of_type_JavaUtilArrayList == null) || (!QLog.isColorLevel())) {
        break label316;
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("PresendPicMgrService.buildPicUploadInfo:");
      localStringBuilder.append(((PicUploadInfo)localObject).jdField_a_of_type_JavaUtilArrayList.toString());
      QLog.d("peak_pgjpeg", 2, localStringBuilder.toString());
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      label257:
      break label257;
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("OutOfMemoryError occurred in PeakUtils.getSliceInfos， ");
      localStringBuilder.append(paramString);
      localStringBuilder.append("'s size is ");
      localStringBuilder.append(FileUtils.getFileSizes(paramString));
      QLog.w("peak_pgjpeg", 2, localStringBuilder.toString());
    }
    label316:
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("PeakUtils.getSliceInfos(");
    localStringBuilder.append(paramString);
    localStringBuilder.append(")");
    LogTag.a("peak_pgjpeg", localStringBuilder.toString());
    if (paramBoolean)
    {
      ((PicUploadInfo)localObject).jdField_g_of_type_Int = 1;
      Logger.a(localObject, "fixProtocolType", "sendReq.upInfo.protocolType");
      return localObject;
    }
    ((PicUploadInfo)localObject).jdField_g_of_type_Int = ((PicUploadInfo)localObject).a();
    return localObject;
  }
  
  public static PresendPicMgrService a()
  {
    return jdField_a_of_type_ComTencentMobileqqPicPresendPicMgrService;
  }
  
  private void a(long paramLong, int paramInt)
  {
    this.jdField_b_of_type_Long += paramLong;
    BasePicPreDownloadUtils.a("presend_FlowWaste", this.jdField_b_of_type_Long);
    StatisticConstants.a(paramLong, paramInt);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PresendStatus:  wastesize = ");
    localStringBuilder.append(paramLong);
    localStringBuilder.append(",mWastedUploadFlow = ");
    localStringBuilder.append(this.jdField_b_of_type_Long);
    localStringBuilder.append(",cancelType = ");
    localStringBuilder.append(paramInt);
    Logger.a("PresendPicMgrService", "calcWasteFlow ", localStringBuilder.toString());
  }
  
  private void a(MessageForPic paramMessageForPic)
  {
    Logger.a("PresendPicMgrService", "reuploadPhoto", " ");
    try
    {
      Object localObject = (QQAppInterface)BaseApplicationImpl.sApplication.getAppRuntime(this.jdField_d_of_type_JavaLangString);
      ((QQAppInterface)localObject).getMessageFacade().b(paramMessageForPic.frienduin, paramMessageForPic.istroop, paramMessageForPic.uniseq);
      if (paramMessageForPic.isSendFromLocal()) {
        ((ITransFileController)((QQAppInterface)localObject).getRuntimeService(ITransFileController.class)).removeProcessor(BaseTransFileController.makeKey(paramMessageForPic.frienduin, paramMessageForPic.uniseq));
      }
      localObject = new PicUploadInfo.Builder();
      ((PicUploadInfo.Builder)localObject).a(paramMessageForPic.path);
      ((PicUploadInfo.Builder)localObject).d(5);
      ((PicUploadInfo.Builder)localObject).d(paramMessageForPic.frienduin);
      ((PicUploadInfo.Builder)localObject).b(paramMessageForPic.uniseq);
      if (paramMessageForPic.fileSizeFlag == 1) {
        ((PicUploadInfo.Builder)localObject).c(1);
      } else {
        ((PicUploadInfo.Builder)localObject).c(0);
      }
      ((PicUploadInfo.Builder)localObject).e(paramMessageForPic.senderuin);
      ((PicUploadInfo.Builder)localObject).c(paramMessageForPic.selfuin);
      ((PicUploadInfo.Builder)localObject).e(paramMessageForPic.istroop);
      ((PicUploadInfo.Builder)localObject).jdField_i_of_type_Int = paramMessageForPic.extLong;
      ((PicUploadInfo.Builder)localObject).jdField_i_of_type_JavaLangString = paramMessageForPic.extStr;
      PicUploadInfo.RetryInfo localRetryInfo = new PicUploadInfo.RetryInfo();
      localRetryInfo.jdField_a_of_type_Long = paramMessageForPic.msgseq;
      localRetryInfo.jdField_b_of_type_Long = paramMessageForPic.shmsgseq;
      localRetryInfo.jdField_a_of_type_Long = paramMessageForPic.msgseq;
      ((PicUploadInfo.Builder)localObject).a(localRetryInfo);
      paramMessageForPic = ((IPicBus)QRoute.api(IPicBus.class)).createPicReq(4, 5);
      paramMessageForPic.a(((PicUploadInfo.Builder)localObject).a());
      ((IPicBus)QRoute.api(IPicBus.class)).launch(paramMessageForPic);
      return;
    }
    catch (AccountNotMatchException paramMessageForPic)
    {
      label255:
      break label255;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PresendPicMgrService", 2, "no appRuntime");
    }
  }
  
  private void a(MessageRecord paramMessageRecord)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    ((IOrderMediaMsgService)localQQAppInterface.getRuntimeService(IOrderMediaMsgService.class)).enqueueMediaMsgByUniseq(paramMessageRecord.frienduin, paramMessageRecord.uniseq);
    ((IOrderMediaMsgService)localQQAppInterface.getRuntimeService(IOrderMediaMsgService.class)).addOrderMsg(paramMessageRecord, ((MessageForPic)paramMessageRecord).path);
  }
  
  private void a(PicReq paramPicReq, int paramInt)
  {
    synchronized (paramPicReq.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo)
    {
      paramPicReq.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_d_of_type_Boolean = true;
      if (paramPicReq.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_a_of_type_JavaLangObject == null)
      {
        Logger.b("PresendPicMgrService", "doCancel", " req.upInfo.picExtraObject == null!");
        return;
      }
      ??? = (MessageRecord)paramPicReq.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_a_of_type_JavaLangObject;
      try
      {
        BaseUploadProcessor localBaseUploadProcessor = (BaseUploadProcessor)((ITransFileController)((QQAppInterface)BaseApplicationImpl.sApplication.getAppRuntime(this.jdField_d_of_type_JavaLangString)).getRuntimeService(ITransFileController.class)).findProcessor(((MessageRecord)???).frienduin, ((MessageRecord)???).uniseq);
        long l1;
        if (localBaseUploadProcessor == null)
        {
          Logger.a("PresendPicMgrService", "doCancel", " processor == null!");
          l1 = ((MessageForPic)???).mPresendTransferedSize;
        }
        else
        {
          int j = b();
          StringBuilder localStringBuilder;
          if (localBaseUploadProcessor.getRealProgress() < j)
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append(" processor upload less than cancelPercent:");
            localStringBuilder.append(j);
            localStringBuilder.append(", do cancel! ");
            Logger.a("PresendPicMgrService", "doCancel", localStringBuilder.toString());
            localBaseUploadProcessor.cancel();
            l1 = localBaseUploadProcessor.getTransferedSize();
          }
          else
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append(" processor upload more than cancelPercent:");
            localStringBuilder.append(j);
            localStringBuilder.append(", do not cancel!");
            Logger.a("PresendPicMgrService", "doCancel", localStringBuilder.toString());
            l1 = localBaseUploadProcessor.getFileSize();
          }
        }
        long l2 = FileUtils.getFileSizes(((MessageForPic)???).path);
        ??? = new StringBuilder();
        ((StringBuilder)???).append("picSize = ");
        ((StringBuilder)???).append(l2);
        Logger.a("PresendPicMgrService", "doCancel", ((StringBuilder)???).toString());
        a(l1, paramInt);
        ??? = new StringBuilder();
        ((StringBuilder)???).append("PresendStatus: Path:");
        ((StringBuilder)???).append(paramPicReq.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_g_of_type_JavaLangString);
        ((StringBuilder)???).append(",uuid:");
        ((StringBuilder)???).append(paramPicReq.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_a_of_type_JavaLangString);
        ((StringBuilder)???).append(",canceled:true, peakCompress:true, peakUpload:true, saveMR:true, transferAsync:true");
        Logger.a("PresendPicMgrService", "doCancel ", ((StringBuilder)???).toString());
        return;
      }
      catch (AccountNotMatchException paramPicReq)
      {
        label391:
        break label391;
      }
      if (QLog.isColorLevel()) {
        QLog.d("PresendPicMgrService", 2, "no appRuntime");
      }
      return;
    }
  }
  
  private int b()
  {
    int k = NetworkUtil.getSystemNetwork(BaseApplication.getContext());
    int j;
    if (k != 1)
    {
      if (k != 2)
      {
        if (k != 3)
        {
          if (k != 4) {
            j = 0;
          } else {
            j = this.jdField_f_of_type_Int;
          }
        }
        else {
          j = this.jdField_e_of_type_Int;
        }
      }
      else {
        j = this.jdField_d_of_type_Int;
      }
    }
    else {
      j = this.jdField_c_of_type_Int;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" NetType = ");
    localStringBuilder.append(k);
    localStringBuilder.append(", cancelpercent = ");
    localStringBuilder.append(j);
    Logger.a("PresendPicMgrService", "getCancelPercent", localStringBuilder.toString());
    return j;
  }
  
  private boolean b()
  {
    int j = NetworkUtil.getSystemNetwork(BaseApplication.getContext());
    boolean bool = true;
    if (j != 1)
    {
      if (j != 2)
      {
        if (j != 3)
        {
          if ((j == 4) && (this.jdField_b_of_type_Long > this.jdField_d_of_type_Long)) {
            break label94;
          }
        }
        else if (this.jdField_b_of_type_Long > this.jdField_e_of_type_Long) {
          break label94;
        }
      }
      else if (this.jdField_b_of_type_Long > this.jdField_f_of_type_Long) {
        break label94;
      }
    }
    else {
      if (this.jdField_b_of_type_Long > this.jdField_c_of_type_Long) {
        break label94;
      }
    }
    bool = false;
    label94:
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PresendStatus : nettype = ");
    localStringBuilder.append(j);
    localStringBuilder.append(" result =  ");
    localStringBuilder.append(bool);
    localStringBuilder.append(",mWastedUploadFlow = ");
    localStringBuilder.append(this.jdField_b_of_type_Long);
    Logger.a("PresendPicMgrService", "isOverWasteLimit", localStringBuilder.toString());
    return bool;
  }
  
  private void e()
  {
    Object localObject = ((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.pic_presend.name());
    if (((IDPCApi)QRoute.api(IDPCApi.class)).isFeatureSupported(DPCAccountNames.picpredownload_whitelist.name()))
    {
      localObject = "1|1|1|1|1|1|1|1|104857600|104857600|104857600|104857600|0|90|70|50";
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("In VIP list, presendConfigString ");
      localStringBuilder2.append("1|1|1|1|1|1|1|1|104857600|104857600|104857600|104857600|0|90|70|50");
      Logger.a("PresendPicMgrService", "getServerConfig", localStringBuilder2.toString());
    }
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("presendConfigString = ");
    localStringBuilder2.append((String)localObject);
    Logger.a("PresendPicMgrService", "getServerConfig", localStringBuilder2.toString());
    if ((localObject != null) && (((String)localObject).length() > 0))
    {
      localObject = ((String)localObject).split("\\|");
      if (localObject.length >= 16)
      {
        this.jdField_a_of_type_Boolean = localObject[0].equals("1");
        this.jdField_b_of_type_Boolean = localObject[1].equals("1");
        this.jdField_c_of_type_Boolean = localObject[2].equals("1");
        this.jdField_d_of_type_Boolean = localObject[3].equals("1");
        this.jdField_e_of_type_Boolean = localObject[4].equals("1");
        this.jdField_f_of_type_Boolean = localObject[5].equals("1");
        this.jdField_g_of_type_Boolean = localObject[6].equals("1");
        this.jdField_h_of_type_Boolean = localObject[7].equals("1");
        try
        {
          this.jdField_c_of_type_Long = Long.valueOf(localObject[8]).longValue();
          this.jdField_f_of_type_Long = Long.valueOf(localObject[9]).longValue();
          this.jdField_e_of_type_Long = Long.valueOf(localObject[10]).longValue();
          this.jdField_d_of_type_Long = Long.valueOf(localObject[11]).longValue();
          this.jdField_c_of_type_Int = Integer.parseInt(localObject[12]);
          this.jdField_d_of_type_Int = Integer.parseInt(localObject[13]);
          this.jdField_e_of_type_Int = Integer.parseInt(localObject[14]);
          this.jdField_f_of_type_Int = Integer.parseInt(localObject[15]);
        }
        catch (NumberFormatException localNumberFormatException)
        {
          localNumberFormatException.printStackTrace();
        }
        StringBuilder localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("mEnablePreCompress_WIFI = ");
        localStringBuilder1.append(this.jdField_a_of_type_Boolean);
        localStringBuilder1.append("mEnablePreCompress_2G = ");
        localStringBuilder1.append(this.jdField_b_of_type_Boolean);
        localStringBuilder1.append("mEnablePreCompress_3G = ");
        localStringBuilder1.append(this.jdField_c_of_type_Boolean);
        localStringBuilder1.append("mEnablePreCompress_4G = ");
        localStringBuilder1.append(this.jdField_d_of_type_Boolean);
        localStringBuilder1.append("mEnablePreUpload_WIFI = ");
        localStringBuilder1.append(this.jdField_e_of_type_Boolean);
        localStringBuilder1.append(",mEnablePreUpload_2G = ");
        localStringBuilder1.append(this.jdField_f_of_type_Boolean);
        localStringBuilder1.append(",mEnablePreUpload_3G = ");
        localStringBuilder1.append(this.jdField_g_of_type_Boolean);
        localStringBuilder1.append(",mEnablePreUpload_4G = ");
        localStringBuilder1.append(this.jdField_h_of_type_Boolean);
        localStringBuilder1.append("mPreUpMaxWasteSizeWIFI = ");
        localStringBuilder1.append(this.jdField_c_of_type_Long);
        localStringBuilder1.append(", mPreUpMaxWasteSize2G = ");
        localStringBuilder1.append(this.jdField_f_of_type_Long);
        localStringBuilder1.append(",mPreUpMaxWasteSize3G = ");
        localStringBuilder1.append(this.jdField_e_of_type_Long);
        localStringBuilder1.append(",mPreUpMaxWasteSize4G = ");
        localStringBuilder1.append(this.jdField_d_of_type_Long);
        localStringBuilder1.append(",mCancelPercentWIFI = ");
        localStringBuilder1.append(this.jdField_c_of_type_Int);
        localStringBuilder1.append(",mCancelPercent2G = ");
        localStringBuilder1.append(this.jdField_d_of_type_Int);
        localStringBuilder1.append(",mCancelPercent3G = ");
        localStringBuilder1.append(this.jdField_e_of_type_Int);
        localStringBuilder1.append(",mCancelPercent4G = ");
        localStringBuilder1.append(this.jdField_f_of_type_Int);
        Logger.a("PresendPicMgrService", "getServerConfig", localStringBuilder1.toString());
      }
    }
  }
  
  public int a()
  {
    return this.jdField_g_of_type_Int;
  }
  
  public void a()
  {
    Logger.a("PresendPicMgrService", "sendMsg__ start!", " ");
    jdField_a_of_type_ComTencentMobileqqPicPresendPicMgrService = null;
    ArrayList localArrayList = new ArrayList();
    try
    {
      synchronized (this.jdField_b_of_type_JavaUtilArrayList)
      {
        this.i = true;
        Object localObject4 = (QQAppInterface)BaseApplicationImpl.sApplication.getAppRuntime(this.jdField_d_of_type_JavaLangString);
        Object localObject5 = new ArrayList(this.jdField_a_of_type_JavaUtilArrayList);
        ??? = new ArrayList(this.jdField_b_of_type_JavaUtilArrayList);
        long l1 = 0L;
        int j = 0;
        Object localObject6;
        while (j < ((ArrayList)localObject5).size())
        {
          localObject6 = (PicReq)((ArrayList)localObject5).get(j);
          long l2;
          if (((PicReq)localObject6).jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_c_of_type_Int == 4)
          {
            ??? = new StringBuilder();
            ((StringBuilder)???).append("FLAG_UPLOADINFO_ERROR do not send! uuid = ");
            ((StringBuilder)???).append(((PicReq)localObject6).jdField_a_of_type_JavaLangString);
            Logger.a("PresendPicMgrService", "sendMsg", ((StringBuilder)???).toString());
            l2 = l1;
          }
          synchronized (((PicReq)localObject6).jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo)
          {
            Object localObject8 = ((PicReq)localObject6).jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_a_of_type_JavaLangObject;
            if (localObject8 == null) {
              try
              {
                localObject8 = new StringBuilder();
                ((StringBuilder)localObject8).append("start wait! uuid = ");
                ((StringBuilder)localObject8).append(((PicReq)localObject6).jdField_a_of_type_JavaLangString);
                Logger.a("PresendPicMgrService", "sendMsg", ((StringBuilder)localObject8).toString());
                ((PicReq)localObject6).jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_e_of_type_Boolean = true;
                ((PicReq)localObject6).jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.wait();
                localObject8 = new StringBuilder();
                ((StringBuilder)localObject8).append("finish wait! uuid = ");
                ((StringBuilder)localObject8).append(((PicReq)localObject6).jdField_a_of_type_JavaLangString);
                Logger.a("PresendPicMgrService", "sendMsg", ((StringBuilder)localObject8).toString());
              }
              catch (InterruptedException localInterruptedException)
              {
                localInterruptedException.printStackTrace();
              }
            }
            ((PicReq)localObject6).jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_f_of_type_Boolean = true;
            if (((PicReq)localObject6).jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_a_of_type_JavaLangObject == null)
            {
              ??? = new StringBuilder();
              ((StringBuilder)???).append("get MR failed! uuid = ");
              ((StringBuilder)???).append(((PicReq)localObject6).jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_a_of_type_JavaLangString);
              Logger.b("PresendPicMgrService", "sendMsg", ((StringBuilder)???).toString());
              l2 = l1;
            }
            else
            {
              ??? = (MessageRecord)((PicReq)localObject6).jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_a_of_type_JavaLangObject;
              if (this.jdField_a_of_type_Int == 1)
              {
                ((MessageRecord)???).saveExtInfoToExtStr("msg_extra_key_is_sync_qzone", String.valueOf(1));
                ((MessageRecord)???).saveExtInfoToExtStr("msg_extra_key_qzone_album_id", this.jdField_a_of_type_JavaLangString);
                ((MessageRecord)???).saveExtInfoToExtStr("msg_extra_key_qzone_batch_id", String.valueOf(this.jdField_a_of_type_Long));
                ((MessageRecord)???).saveExtInfoToExtStr("msg_extra_key_qzone_is_raw", String.valueOf(((PicReq)localObject6).jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_g_of_type_Int));
                ((MessageRecord)???).saveExtInfoToExtStr("msg_extra_key_qzone_batch_count", String.valueOf(((ArrayList)localObject5).size()));
                ((MessageRecord)???).saveExtInfoToExtStr("msg_extra_key_qzone_photo_index", String.valueOf(j));
              }
              a((MessageRecord)???);
              if ((??? instanceof MessageForPic))
              {
                localArrayList.add(((MessageForPic)???).path);
                l1 = ((MessageRecord)???).uniseq;
              }
              l2 = l1;
              if (((PicReq)localObject6).jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_c_of_type_Int == 3)
              {
                localObject6 = new StringBuilder();
                ((StringBuilder)localObject6).append("Pic not upload,reupload! mr = ");
                ((StringBuilder)localObject6).append(???);
                Logger.a("PresendPicMgrService", "sendMsg", ((StringBuilder)localObject6).toString());
                a((MessageForPic)???);
                l2 = l1;
              }
            }
            j += 1;
            l1 = l2;
          }
        }
        try
        {
          localObject6 = ((ArrayList)???).iterator();
          while (((Iterator)localObject6).hasNext())
          {
            Object localObject9 = (PicReq)((Iterator)localObject6).next();
            j = ((PicReq)localObject9).jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_c_of_type_Int;
            ??? = (MessageRecord)((PicReq)localObject9).jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_a_of_type_JavaLangObject;
            if (((ArrayList)localObject5).contains(localObject9))
            {
              if (j == 1)
              {
                localObject9 = new StringBuilder();
                ((StringBuilder)localObject9).append("preupload success,dosend! mr =  ");
                ((StringBuilder)localObject9).append(???);
                Logger.a("PresendPicMgrService", "sendMsg", ((StringBuilder)localObject9).toString());
                ((IOrderMediaMsgService)((QQAppInterface)localObject4).getRuntimeService(IOrderMediaMsgService.class)).sendOrderMsg((MessageRecord)???, null);
              }
              else
              {
                localObject9 = new StringBuilder();
                ((StringBuilder)localObject9).append("preupload failed,reupload! mr =  ");
                ((StringBuilder)localObject9).append(???);
                Logger.a("PresendPicMgrService", "sendMsg", ((StringBuilder)localObject9).toString());
                a((MessageForPic)???);
              }
            }
            else
            {
              localObject9 = new StringBuilder();
              ((StringBuilder)localObject9).append("unselect,do not send mr =  ");
              ((StringBuilder)localObject9).append(???);
              Logger.a("PresendPicMgrService", "sendMsg", ((StringBuilder)localObject9).toString());
            }
          }
          if ((localList.size() >= 5) && (this.jdField_g_of_type_Int == 1))
          {
            if (QLog.isColorLevel())
            {
              ??? = localList.iterator();
              while (((Iterator)???).hasNext())
              {
                localObject4 = (String)((Iterator)???).next();
                localObject5 = new StringBuilder();
                ((StringBuilder)localObject5).append("sendPhotoTask,  mSendPaths path=");
                ((StringBuilder)localObject5).append((String)localObject4);
                QLog.d("PresendPicMgrService", 2, ((StringBuilder)localObject5).toString());
              }
              ??? = new StringBuilder();
              ((StringBuilder)???).append("sendPhotoTask,  lastMessageUniseq=");
              ((StringBuilder)???).append(l1);
              QLog.d("PresendPicMgrService", 2, ((StringBuilder)???).toString());
            }
            TroopGrayTipUtils.a((QQAppInterface)BaseApplicationImpl.sApplication.getAppRuntime(this.jdField_d_of_type_JavaLangString), this.jdField_b_of_type_JavaLangString, this.jdField_d_of_type_JavaLangString, localList, l1);
          }
          else if (QLog.isColorLevel())
          {
            ??? = new StringBuilder();
            ((StringBuilder)???).append("sendPhotoTask,  mSendPaths size=");
            ((StringBuilder)???).append(localList.size());
            QLog.d("PresendPicMgrService", 2, ((StringBuilder)???).toString());
          }
        }
        finally {}
      }
    }
    catch (AccountNotMatchException localAccountNotMatchException)
    {
      label1050:
      break label1050;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PresendPicMgrService", 2, "no appRuntime");
    }
    Logger.a("PresendPicMgrService", "sendMsg__ end!", " ");
    d();
  }
  
  public void a(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("cancelType = ");
    localStringBuilder.append(paramInt);
    Logger.a("PresendPicMgrService", "cancelAll", localStringBuilder.toString());
    c();
  }
  
  public void a(int paramInt, long paramLong, String paramString)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(String paramString, int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(" start,localUUID = ");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(", cancelType = ");
    ((StringBuilder)localObject).append(paramInt);
    Logger.a("PresendPicMgrService", "cancelUploadReq", ((StringBuilder)localObject).toString());
    localObject = a(this.jdField_a_of_type_JavaUtilArrayList, paramString);
    if (localObject == null)
    {
      Logger.a("PresendPicMgrService", "cancelUploadReq", " find req failed ");
      return;
    }
    this.jdField_a_of_type_JavaUtilArrayList.remove(localObject);
    a((PicReq)localObject, paramInt);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(" end,localUUID = ");
    ((StringBuilder)localObject).append(paramString);
    Logger.a("PresendPicMgrService", "cancelUploadReq", ((StringBuilder)localObject).toString());
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("presendPic in main process ");
      ((StringBuilder)localObject).append(paramInt2);
      QLog.d("MsgVia", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("PresendStatus : path = ");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(", localUUID = ");
    ((StringBuilder)localObject).append(paramString2);
    ((StringBuilder)localObject).append(",fileSize = ");
    ((StringBuilder)localObject).append(FileUtils.getFileSizes(paramString1));
    ((StringBuilder)localObject).append(",entrance = ");
    ((StringBuilder)localObject).append(paramInt2);
    Logger.a("PresendPicMgrService", "presendPic", ((StringBuilder)localObject).toString());
    localObject = ((IPicBus)QRoute.api(IPicBus.class)).createPicReq(2, 1052);
    paramString1 = a(paramString1, paramBoolean, paramInt1, paramInt2);
    ((PicReq)localObject).a(paramString1);
    ((PicReq)localObject).a(paramString2);
    if (!paramString1.a())
    {
      Logger.b("PresendPicMgrService", paramString2, paramString1.jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo.jdField_a_of_type_JavaLangString, paramString1.jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo.jdField_b_of_type_JavaLangString);
      paramString1.jdField_c_of_type_Int = 4;
      this.jdField_a_of_type_JavaUtilArrayList.add(localObject);
      return;
    }
    ((PicReq)localObject).a(new PresendPicMgrService.1(this, (PicReq)localObject, paramString1));
    if ((!a()) || (b()) || (FileUtils.getFileSizes(((PicReq)localObject).jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_g_of_type_JavaLangString) > 512000L))
    {
      Logger.a("PresendPicMgrService", "presendPic", "set FLAG_NOT_UPLOAD!");
      ((PicReq)localObject).a(null);
      ((PicReq)localObject).jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_c_of_type_Int = 3;
    }
    try
    {
      paramString1 = (QQAppInterface)BaseApplicationImpl.sApplication.getAppRuntime(this.jdField_d_of_type_JavaLangString);
      ((IPicBus)QRoute.api(IPicBus.class)).launch((PicReq)localObject);
      this.jdField_a_of_type_JavaUtilArrayList.add(localObject);
      return;
    }
    catch (AccountNotMatchException paramString1)
    {
      label336:
      break label336;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PresendPicMgrService", 2, "no appRuntime");
    }
  }
  
  boolean a()
  {
    int j = NetworkUtil.getSystemNetwork(BaseApplication.getContext());
    boolean bool;
    if (j != 1)
    {
      if (j != 2)
      {
        if (j != 3)
        {
          if (j != 4) {
            bool = false;
          } else {
            bool = this.jdField_h_of_type_Boolean;
          }
        }
        else {
          bool = this.jdField_g_of_type_Boolean;
        }
      }
      else {
        bool = this.jdField_f_of_type_Boolean;
      }
    }
    else {
      bool = this.jdField_e_of_type_Boolean;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("nettype = ");
    localStringBuilder.append(j);
    localStringBuilder.append(" result =  ");
    localStringBuilder.append(bool);
    Logger.a("PresendPicMgrService", "isPreuploadEnable", localStringBuilder.toString());
    return bool;
  }
  
  public int[] a()
  {
    try
    {
      Object localObject = (QQAppInterface)BaseApplicationImpl.sApplication.getAppRuntime(this.jdField_d_of_type_JavaLangString);
      localObject = ((ICompressOperator)QRoute.api(ICompressOperator.class)).getCompressConfigFromServer((AppInterface)localObject);
      return localObject;
    }
    catch (AccountNotMatchException localAccountNotMatchException)
    {
      label32:
      break label32;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PresendPicMgrService", 2, "getPicCompressArgConfig no appRuntime");
    }
    return null;
  }
  
  public boolean[] a()
  {
    return new boolean[] { this.jdField_a_of_type_Boolean, this.jdField_b_of_type_Boolean, this.jdField_c_of_type_Boolean, this.jdField_d_of_type_Boolean };
  }
  
  public void b()
  {
    int j = NetworkUtil.getSystemNetwork(BaseApplication.getContext());
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("netType = ");
    ((StringBuilder)localObject).append(j);
    Logger.a("PresendPicMgrService", "handletWifi2Mobile", ((StringBuilder)localObject).toString());
    localObject = this.jdField_a_of_type_JavaUtilArrayList;
    if ((localObject != null) && (((ArrayList)localObject).size() != 0))
    {
      PicReq localPicReq;
      if (j == 2)
      {
        Logger.a("PresendPicMgrService", "handletWifi2Mobile", "switch to G2,cancel upload! ");
        localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (((Iterator)localObject).hasNext())
        {
          localPicReq = (PicReq)((Iterator)localObject).next();
          a(localPicReq, 1001);
          localPicReq.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_c_of_type_Int = 3;
        }
      }
      if (((j == 3) || (j == 4)) && (b()))
      {
        Logger.a("PresendPicMgrService", "handletWifi2Mobile", "switch to G3/G4,overWastLimit,cancel upload! ");
        localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (((Iterator)localObject).hasNext())
        {
          localPicReq = (PicReq)((Iterator)localObject).next();
          a(localPicReq, 1002);
          localPicReq.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_c_of_type_Int = 3;
        }
      }
      return;
    }
    Logger.a("PresendPicMgrService", "handletWifi2Mobile", "mUploadReqList is Null! ");
  }
  
  void c()
  {
    Logger.a("PresendPicMgrService", "resetStatus", "");
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_b_of_type_JavaUtilArrayList.clear();
    this.i = false;
  }
  
  public void d()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_JavaLangString = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.pic.PresendPicMgrService
 * JD-Core Version:    0.7.0.1
 */