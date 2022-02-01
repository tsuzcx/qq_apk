package com.tencent.mobileqq.pic;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.photo.StatisticConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCAccountNames;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.pic.operator.CompressPicOperator;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmedia.ordersend.OrderMediaMsgManager;
import com.tencent.mobileqq.transfile.BaseTransFileController;
import com.tencent.mobileqq.transfile.BaseUploadProcessor;
import com.tencent.mobileqq.transfile.TranDbRecord.PicDbRecord;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.troop.utils.TroopGrayTipUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.LogTag;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.peak.PeakUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AccountNotMatchException;

public class PresendPicMgrService
  extends IPresendPicMgr.Stub
{
  private static PresendPicMgrService jdField_a_of_type_ComTencentMobileqqPicPresendPicMgrService;
  static int jdField_b_of_type_Int = 0;
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
    long l1 = PicPreDownloadUtils.a("presend_lastDayTime", 0L);
    long l2 = System.currentTimeMillis();
    Logger.a("PresendPicMgrService", "[@]PresendPicMgrService", "currentTime = " + l2 + ", lastDayTime = " + l1 + ", curFriendUin = " + paramString1 + ",troopUin = " + paramString2 + ",myUin = " + paramString3);
    e();
    if (l2 - l1 > 86400000L)
    {
      Logger.a("PresendPicMgrService", "PresendPicMgrService", "more than one day, clear wastesize");
      StatisticConstants.a(PicPreDownloadUtils.a("presend_FlowWaste", 0L));
      PicPreDownloadUtils.a("presend_lastDayTime", l2);
      PicPreDownloadUtils.a("presend_FlowWaste", 0L);
    }
    this.jdField_b_of_type_Long = PicPreDownloadUtils.a("presend_FlowWaste", 0L);
    jdField_a_of_type_ComTencentMobileqqPicPresendPicMgrService = this;
  }
  
  private PicReq a(ArrayList<PicReq> paramArrayList, String paramString)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
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
    return null;
  }
  
  private PicUploadInfo a(String paramString, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    Object localObject = new PicUploadInfo.Builder();
    Logger.a("PresendPicMgrService", "[@]buildPicUploadInfo", "curFriendUin = " + this.jdField_b_of_type_JavaLangString);
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
    if (PeakUtils.a(paramString)) {
      LogTag.a();
    }
    try
    {
      ((PicUploadInfo)localObject).jdField_a_of_type_JavaUtilArrayList = PeakUtils.a(paramString);
      if ((((PicUploadInfo)localObject).jdField_a_of_type_JavaUtilArrayList != null) && (QLog.isColorLevel())) {
        QLog.d("peak_pgjpeg", 2, "PresendPicMgrService.buildPicUploadInfo:" + ((PicUploadInfo)localObject).jdField_a_of_type_JavaUtilArrayList.toString());
      }
      LogTag.a("peak_pgjpeg", "PeakUtils.getSliceInfos(" + paramString + ")");
      if (paramBoolean)
      {
        ((PicUploadInfo)localObject).jdField_g_of_type_Int = 1;
        Logger.a(localObject, "fixProtocolType", "sendReq.upInfo.protocolType");
        return localObject;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.w("peak_pgjpeg", 2, "OutOfMemoryError occurred in PeakUtils.getSliceInfos， " + paramString + "'s size is " + FileUtils.a(paramString));
        }
      }
      ((PicUploadInfo)localObject).jdField_g_of_type_Int = ((PicUploadInfo)localObject).a();
    }
    return localObject;
  }
  
  public static PresendPicMgrService a()
  {
    return jdField_a_of_type_ComTencentMobileqqPicPresendPicMgrService;
  }
  
  private void a(long paramLong, int paramInt)
  {
    this.jdField_b_of_type_Long += paramLong;
    PicPreDownloadUtils.a("presend_FlowWaste", this.jdField_b_of_type_Long);
    StatisticConstants.a(paramLong, paramInt);
    Logger.a("PresendPicMgrService", "calcWasteFlow ", "PresendStatus:  wastesize = " + paramLong + ",mWastedUploadFlow = " + this.jdField_b_of_type_Long + ",cancelType = " + paramInt);
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
        ((PicUploadInfo.Builder)localObject).c(TranDbRecord.PicDbRecord.EXTRA_FLAG_SEND_RAW_PHOTO);
      }
      for (;;)
      {
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
        paramMessageForPic = PicBusiManager.a(4, 5);
        paramMessageForPic.a(((PicUploadInfo.Builder)localObject).a());
        PicBusiManager.a(paramMessageForPic);
        return;
        ((PicUploadInfo.Builder)localObject).c(TranDbRecord.PicDbRecord.EXTRA_FLAG_SEND_PHOTO);
      }
      return;
    }
    catch (AccountNotMatchException paramMessageForPic)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PresendPicMgrService", 2, "no appRuntime");
      }
    }
  }
  
  private void a(MessageRecord paramMessageRecord)
  {
    OrderMediaMsgManager localOrderMediaMsgManager = (OrderMediaMsgManager)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(QQManagerFactory.MEDIA_MSG_ORDER_SEND_MANAGER);
    localOrderMediaMsgManager.a(paramMessageRecord.frienduin, paramMessageRecord.uniseq);
    localOrderMediaMsgManager.a(paramMessageRecord, ((MessageForPic)paramMessageRecord).path);
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
    }
    ??? = (MessageRecord)paramPicReq.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_a_of_type_JavaLangObject;
    for (;;)
    {
      BaseUploadProcessor localBaseUploadProcessor;
      long l1;
      try
      {
        localBaseUploadProcessor = (BaseUploadProcessor)((ITransFileController)((QQAppInterface)BaseApplicationImpl.sApplication.getAppRuntime(this.jdField_d_of_type_JavaLangString)).getRuntimeService(ITransFileController.class)).findProcessor(((MessageRecord)???).frienduin, ((MessageRecord)???).uniseq);
        if (localBaseUploadProcessor != null) {
          break label251;
        }
        Logger.a("PresendPicMgrService", "doCancel", " processor == null!");
        l1 = ((MessageForPic)???).mPresendTransferedSize;
        long l2 = FileUtils.a(((MessageForPic)???).path);
        Logger.a("PresendPicMgrService", "doCancel", "picSize = " + l2);
        a(l1, paramInt);
        Logger.a("PresendPicMgrService", "doCancel ", "PresendStatus: Path:" + paramPicReq.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_g_of_type_JavaLangString + ",uuid:" + paramPicReq.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_a_of_type_JavaLangString + ",canceled:true, peakCompress:true, peakUpload:true, saveMR:true, transferAsync:true");
        return;
      }
      catch (AccountNotMatchException paramPicReq) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("PresendPicMgrService", 2, "no appRuntime");
      return;
      label251:
      int j = b();
      if (localBaseUploadProcessor.getRealProgress() < j)
      {
        Logger.a("PresendPicMgrService", "doCancel", " processor upload less than cancelPercent:" + j + ", do cancel! ");
        localBaseUploadProcessor.cancel();
        l1 = localBaseUploadProcessor.getTransferedSize();
      }
      else
      {
        Logger.a("PresendPicMgrService", "doCancel", " processor upload more than cancelPercent:" + j + ", do not cancel!");
        l1 = localBaseUploadProcessor.getFileSize();
      }
    }
  }
  
  private int b()
  {
    int j = 0;
    int k = NetworkUtil.a(BaseApplication.getContext());
    switch (k)
    {
    }
    for (;;)
    {
      Logger.a("PresendPicMgrService", "getCancelPercent", " NetType = " + k + ", cancelpercent = " + j);
      return j;
      j = this.jdField_c_of_type_Int;
      continue;
      j = this.jdField_d_of_type_Int;
      continue;
      j = this.jdField_e_of_type_Int;
      continue;
      j = this.jdField_f_of_type_Int;
    }
  }
  
  private boolean b()
  {
    boolean bool = true;
    int j = NetworkUtil.a(BaseApplication.getContext());
    switch (j)
    {
    default: 
      bool = false;
    }
    for (;;)
    {
      Logger.a("PresendPicMgrService", "isOverWasteLimit", "PresendStatus : nettype = " + j + " result =  " + bool + ",mWastedUploadFlow = " + this.jdField_b_of_type_Long);
      return bool;
      if (this.jdField_b_of_type_Long <= this.jdField_c_of_type_Long) {
        break;
      }
      continue;
      if (this.jdField_b_of_type_Long <= this.jdField_f_of_type_Long) {
        break;
      }
      continue;
      if (this.jdField_b_of_type_Long <= this.jdField_e_of_type_Long) {
        break;
      }
      continue;
      if (this.jdField_b_of_type_Long <= this.jdField_d_of_type_Long) {
        break;
      }
    }
  }
  
  private void e()
  {
    Object localObject = ((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.pic_presend.name());
    if (((IDPCApi)QRoute.api(IDPCApi.class)).isFeatureSupported(DPCAccountNames.picpredownload_whitelist.name()))
    {
      localObject = "1|1|1|1|1|1|1|1|104857600|104857600|104857600|104857600|0|90|70|50";
      Logger.a("PresendPicMgrService", "getServerConfig", "In VIP list, presendConfigString " + "1|1|1|1|1|1|1|1|104857600|104857600|104857600|104857600|0|90|70|50");
    }
    for (;;)
    {
      Logger.a("PresendPicMgrService", "getServerConfig", "presendConfigString = " + (String)localObject);
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
        }
      }
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
        Logger.a("PresendPicMgrService", "getServerConfig", "mEnablePreCompress_WIFI = " + this.jdField_a_of_type_Boolean + "mEnablePreCompress_2G = " + this.jdField_b_of_type_Boolean + "mEnablePreCompress_3G = " + this.jdField_c_of_type_Boolean + "mEnablePreCompress_4G = " + this.jdField_d_of_type_Boolean + "mEnablePreUpload_WIFI = " + this.jdField_e_of_type_Boolean + ",mEnablePreUpload_2G = " + this.jdField_f_of_type_Boolean + ",mEnablePreUpload_3G = " + this.jdField_g_of_type_Boolean + ",mEnablePreUpload_4G = " + this.jdField_h_of_type_Boolean + "mPreUpMaxWasteSizeWIFI = " + this.jdField_c_of_type_Long + ", mPreUpMaxWasteSize2G = " + this.jdField_f_of_type_Long + ",mPreUpMaxWasteSize3G = " + this.jdField_e_of_type_Long + ",mPreUpMaxWasteSize4G = " + this.jdField_d_of_type_Long + ",mCancelPercentWIFI = " + this.jdField_c_of_type_Int + ",mCancelPercent2G = " + this.jdField_d_of_type_Int + ",mCancelPercent3G = " + this.jdField_e_of_type_Int + ",mCancelPercent4G = " + this.jdField_f_of_type_Int);
        return;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        for (;;)
        {
          localNumberFormatException.printStackTrace();
        }
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
    ArrayList localArrayList1 = new ArrayList();
    long l1 = 0L;
    Object localObject4;
    ArrayList localArrayList2;
    int j;
    Object localObject5;
    long l2;
    try
    {
      synchronized (this.jdField_b_of_type_JavaUtilArrayList)
      {
        this.i = true;
        localObject4 = (QQAppInterface)BaseApplicationImpl.sApplication.getAppRuntime(this.jdField_d_of_type_JavaLangString);
        localArrayList2 = new ArrayList(this.jdField_a_of_type_JavaUtilArrayList);
        ??? = new ArrayList(this.jdField_b_of_type_JavaUtilArrayList);
        j = 0;
        if (j >= localArrayList2.size()) {
          break label592;
        }
        localObject5 = (PicReq)localArrayList2.get(j);
        if (((PicReq)localObject5).jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_c_of_type_Int != 4) {
          break label204;
        }
        Logger.a("PresendPicMgrService", "sendMsg", "FLAG_UPLOADINFO_ERROR do not send! uuid = " + ((PicReq)localObject5).jdField_a_of_type_JavaLangString);
        l2 = l1;
        j += 1;
        l1 = l2;
      }
      Logger.a("PresendPicMgrService", "sendMsg__ end!", " ");
    }
    catch (AccountNotMatchException localAccountNotMatchException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PresendPicMgrService", 2, "no appRuntime");
      }
    }
    for (;;)
    {
      for (;;)
      {
        d();
        return;
        label204:
        synchronized (((PicReq)localObject5).jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo)
        {
          for (;;)
          {
            Object localObject7 = ((PicReq)localObject5).jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_a_of_type_JavaLangObject;
            if (localObject7 == null) {}
            try
            {
              Logger.a("PresendPicMgrService", "sendMsg", "start wait! uuid = " + ((PicReq)localObject5).jdField_a_of_type_JavaLangString);
              ((PicReq)localObject5).jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_e_of_type_Boolean = true;
              ((PicReq)localObject5).jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.wait();
              Logger.a("PresendPicMgrService", "sendMsg", "finish wait! uuid = " + ((PicReq)localObject5).jdField_a_of_type_JavaLangString);
              ((PicReq)localObject5).jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_f_of_type_Boolean = true;
              if (((PicReq)localObject5).jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_a_of_type_JavaLangObject == null)
              {
                Logger.b("PresendPicMgrService", "sendMsg", "get MR failed! uuid = " + ((PicReq)localObject5).jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_a_of_type_JavaLangString);
                l2 = l1;
              }
            }
            catch (InterruptedException localInterruptedException)
            {
              for (;;)
              {
                localInterruptedException.printStackTrace();
              }
            }
          }
        }
      }
      ??? = (MessageRecord)((PicReq)localObject5).jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_a_of_type_JavaLangObject;
      if (this.jdField_a_of_type_Int == 1)
      {
        ((MessageRecord)???).saveExtInfoToExtStr("msg_extra_key_is_sync_qzone", String.valueOf(1));
        ((MessageRecord)???).saveExtInfoToExtStr("msg_extra_key_qzone_album_id", this.jdField_a_of_type_JavaLangString);
        ((MessageRecord)???).saveExtInfoToExtStr("msg_extra_key_qzone_batch_id", String.valueOf(this.jdField_a_of_type_Long));
        ((MessageRecord)???).saveExtInfoToExtStr("msg_extra_key_qzone_is_raw", String.valueOf(((PicReq)localObject5).jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_g_of_type_Int));
        ((MessageRecord)???).saveExtInfoToExtStr("msg_extra_key_qzone_batch_count", String.valueOf(localArrayList2.size()));
        ((MessageRecord)???).saveExtInfoToExtStr("msg_extra_key_qzone_photo_index", String.valueOf(j));
      }
      a((MessageRecord)???);
      if ((??? instanceof MessageForPic))
      {
        localObject2.add(((MessageForPic)???).path);
        l1 = ((MessageRecord)???).uniseq;
      }
      l2 = l1;
      if (((PicReq)localObject5).jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_c_of_type_Int != 3) {
        break;
      }
      Logger.a("PresendPicMgrService", "sendMsg", "Pic not upload,reupload! mr = " + ???);
      a((MessageForPic)???);
      l2 = l1;
      break;
      for (;;)
      {
        label592:
        MessageRecord localMessageRecord;
        try
        {
          localObject5 = ((ArrayList)???).iterator();
          if (!((Iterator)localObject5).hasNext()) {
            break;
          }
          ??? = (PicReq)((Iterator)localObject5).next();
          j = ((PicReq)???).jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_c_of_type_Int;
          localMessageRecord = (MessageRecord)((PicReq)???).jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_a_of_type_JavaLangObject;
          if (!localArrayList2.contains(???)) {
            break label759;
          }
          if (j == 1)
          {
            Logger.a("PresendPicMgrService", "sendMsg", "preupload success,dosend! mr =  " + localMessageRecord);
            ((OrderMediaMsgManager)((QQAppInterface)localObject4).getManager(QQManagerFactory.MEDIA_MSG_ORDER_SEND_MANAGER)).a(localMessageRecord, null);
            continue;
          }
          Logger.a("PresendPicMgrService", "sendMsg", "preupload failed,reupload! mr =  " + localMessageRecord);
        }
        finally {}
        a((MessageForPic)localMessageRecord);
        continue;
        label759:
        Logger.a("PresendPicMgrService", "sendMsg", "unselect,do not send mr =  " + localMessageRecord);
      }
      if ((localList.size() >= 5) && (this.jdField_g_of_type_Int == 1))
      {
        if (QLog.isColorLevel())
        {
          ??? = localList.iterator();
          while (((Iterator)???).hasNext())
          {
            localObject4 = (String)((Iterator)???).next();
            QLog.d("PresendPicMgrService", 2, "sendPhotoTask,  mSendPaths path=" + (String)localObject4);
          }
          QLog.d("PresendPicMgrService", 2, "sendPhotoTask,  lastMessageUniseq=" + l1);
        }
        TroopGrayTipUtils.a((QQAppInterface)BaseApplicationImpl.sApplication.getAppRuntime(this.jdField_d_of_type_JavaLangString), this.jdField_b_of_type_JavaLangString, this.jdField_d_of_type_JavaLangString, localList, l1);
      }
      else if (QLog.isColorLevel())
      {
        QLog.d("PresendPicMgrService", 2, "sendPhotoTask,  mSendPaths size=" + localList.size());
      }
    }
  }
  
  public void a(int paramInt)
  {
    Logger.a("PresendPicMgrService", "cancelAll", "cancelType = " + paramInt);
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
    Logger.a("PresendPicMgrService", "cancelUploadReq", " start,localUUID = " + paramString + ", cancelType = " + paramInt);
    PicReq localPicReq = a(this.jdField_a_of_type_JavaUtilArrayList, paramString);
    if (localPicReq == null)
    {
      Logger.a("PresendPicMgrService", "cancelUploadReq", " find req failed ");
      return;
    }
    this.jdField_a_of_type_JavaUtilArrayList.remove(localPicReq);
    a(localPicReq, paramInt);
    Logger.a("PresendPicMgrService", "cancelUploadReq", " end,localUUID = " + paramString);
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MsgVia", 2, "presendPic in main process " + paramInt2);
    }
    Logger.a("PresendPicMgrService", "presendPic", "PresendStatus : path = " + paramString1 + ", localUUID = " + paramString2 + ",fileSize = " + FileUtils.a(paramString1) + ",entrance = " + paramInt2);
    PicReq localPicReq = PicBusiManager.a(2, 1052);
    paramString1 = a(paramString1, paramBoolean, paramInt1, paramInt2);
    localPicReq.a(paramString1);
    localPicReq.a(paramString2);
    if (!paramString1.a())
    {
      Logger.b("PresendPicMgrService", paramString2, paramString1.jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo.jdField_a_of_type_JavaLangString, paramString1.jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo.jdField_b_of_type_JavaLangString);
      paramString1.jdField_c_of_type_Int = 4;
      this.jdField_a_of_type_JavaUtilArrayList.add(localPicReq);
    }
    do
    {
      return;
      localPicReq.a(new PresendPicMgrService.1(this, localPicReq, paramString1));
      if ((!a()) || (b()) || (FileUtils.a(localPicReq.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_g_of_type_JavaLangString) > 512000L))
      {
        Logger.a("PresendPicMgrService", "presendPic", "set FLAG_NOT_UPLOAD!");
        localPicReq.a(null);
        localPicReq.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_c_of_type_Int = 3;
      }
      try
      {
        paramString1 = (QQAppInterface)BaseApplicationImpl.sApplication.getAppRuntime(this.jdField_d_of_type_JavaLangString);
        PicBusiManager.a(localPicReq);
        this.jdField_a_of_type_JavaUtilArrayList.add(localPicReq);
        return;
      }
      catch (AccountNotMatchException paramString1) {}
    } while (!QLog.isColorLevel());
    QLog.d("PresendPicMgrService", 2, "no appRuntime");
  }
  
  boolean a()
  {
    int j = NetworkUtil.a(BaseApplication.getContext());
    boolean bool = false;
    switch (j)
    {
    }
    for (;;)
    {
      Logger.a("PresendPicMgrService", "isPreuploadEnable", "nettype = " + j + " result =  " + bool);
      return bool;
      bool = this.jdField_e_of_type_Boolean;
      continue;
      bool = this.jdField_f_of_type_Boolean;
      continue;
      bool = this.jdField_g_of_type_Boolean;
      continue;
      bool = this.jdField_h_of_type_Boolean;
    }
  }
  
  public int[] a()
  {
    try
    {
      int[] arrayOfInt = CompressPicOperator.a((QQAppInterface)BaseApplicationImpl.sApplication.getAppRuntime(this.jdField_d_of_type_JavaLangString));
      return arrayOfInt;
    }
    catch (AccountNotMatchException localAccountNotMatchException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PresendPicMgrService", 2, "getPicCompressArgConfig no appRuntime");
      }
    }
    return null;
  }
  
  public boolean[] a()
  {
    return new boolean[] { this.jdField_a_of_type_Boolean, this.jdField_b_of_type_Boolean, this.jdField_c_of_type_Boolean, this.jdField_d_of_type_Boolean };
  }
  
  public void b()
  {
    int j = NetworkUtil.a(BaseApplication.getContext());
    Logger.a("PresendPicMgrService", "handletWifi2Mobile", "netType = " + j);
    if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.size() == 0)) {
      Logger.a("PresendPicMgrService", "handletWifi2Mobile", "mUploadReqList is Null! ");
    }
    for (;;)
    {
      return;
      Iterator localIterator;
      PicReq localPicReq;
      if (j == 2)
      {
        Logger.a("PresendPicMgrService", "handletWifi2Mobile", "switch to G2,cancel upload! ");
        localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (localIterator.hasNext())
        {
          localPicReq = (PicReq)localIterator.next();
          a(localPicReq, 1001);
          localPicReq.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_c_of_type_Int = 3;
        }
      }
      if (((j == 3) || (j == 4)) && (b()))
      {
        Logger.a("PresendPicMgrService", "handletWifi2Mobile", "switch to G3/G4,overWastLimit,cancel upload! ");
        localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (localIterator.hasNext())
        {
          localPicReq = (PicReq)localIterator.next();
          a(localPicReq, 1002);
          localPicReq.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_c_of_type_Int = 3;
        }
      }
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.pic.PresendPicMgrService
 * JD-Core Version:    0.7.0.1
 */