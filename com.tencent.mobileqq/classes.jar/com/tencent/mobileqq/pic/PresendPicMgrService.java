package com.tencent.mobileqq.pic;

import afxl;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.item.PicItemBuilder;
import com.tencent.mobileqq.activity.photo.StatisticConstants;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.AccountDpcManager.DpcAccountNames;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SVIPHandler;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.transfile.BaseUploadProcessor;
import com.tencent.mobileqq.transfile.TranDbRecord.PicDbRecord;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.LogTag;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.peak.PeakUtils;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.AccountNotMatchException;

public class PresendPicMgrService
  extends IPresendPicMgr.Stub
{
  private static PresendPicMgrService jdField_a_of_type_ComTencentMobileqqPicPresendPicMgrService;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private String jdField_a_of_type_JavaLangString;
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = 90;
  private long jdField_b_of_type_Long = 209715200L;
  private String jdField_b_of_type_JavaLangString;
  private ArrayList jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int = 70;
  private long jdField_c_of_type_Long = 157286400L;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int = 50;
  private long jdField_d_of_type_Long = 73400320L;
  private boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int;
  private long jdField_e_of_type_Long = 52428800L;
  private boolean jdField_e_of_type_Boolean;
  private int jdField_f_of_type_Int;
  private boolean jdField_f_of_type_Boolean;
  private boolean g;
  private boolean h;
  private boolean i;
  
  public PresendPicMgrService(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2)
  {
    this.jdField_e_of_type_Int = paramInt1;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_c_of_type_JavaLangString = paramString3;
    this.jdField_f_of_type_Int = paramInt2;
    long l1 = PicPreDownloadUtils.a("presend_lastDayTime", 0L);
    long l2 = System.currentTimeMillis();
    Logger.a("PresendPicMgrService", "[@]PresendPicMgrService", "currentTime = " + l2 + ", lastDayTime = " + l1 + ", curFriendUin = " + paramString1 + ",troopUin = " + paramString2 + ",myUin = " + paramString3);
    d();
    if (l2 - l1 > 86400000L)
    {
      Logger.a("PresendPicMgrService", "PresendPicMgrService", "more than one day, clear wastesize");
      StatisticConstants.a(PicPreDownloadUtils.a("presend_FlowWaste", 0L));
      PicPreDownloadUtils.a("presend_lastDayTime", l2);
      PicPreDownloadUtils.a("presend_FlowWaste", 0L);
    }
    this.jdField_a_of_type_Long = PicPreDownloadUtils.a("presend_FlowWaste", 0L);
    jdField_a_of_type_ComTencentMobileqqPicPresendPicMgrService = this;
  }
  
  private PicReq a(ArrayList paramArrayList, String paramString)
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
    Logger.a("PresendPicMgrService", "[@]buildPicUploadInfo", "curFriendUin = " + this.jdField_a_of_type_JavaLangString);
    ((PicUploadInfo.Builder)localObject).d(this.jdField_a_of_type_JavaLangString);
    ((PicUploadInfo.Builder)localObject).a(paramString);
    ((PicUploadInfo.Builder)localObject).e(this.jdField_e_of_type_Int);
    ((PicUploadInfo.Builder)localObject).e(this.jdField_b_of_type_JavaLangString);
    ((PicUploadInfo.Builder)localObject).d(paramInt1);
    ((PicUploadInfo.Builder)localObject).f(0);
    ((PicUploadInfo.Builder)localObject).k(paramInt2);
    ((PicUploadInfo.Builder)localObject).l(this.jdField_f_of_type_Int);
    localObject = ((PicUploadInfo.Builder)localObject).a();
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
    this.jdField_a_of_type_Long += paramLong;
    PicPreDownloadUtils.a("presend_FlowWaste", this.jdField_a_of_type_Long);
    StatisticConstants.a(paramLong, paramInt);
    Logger.a("PresendPicMgrService", "calcWasteFlow ", "PresendStatus:  wastesize = " + paramLong + ",mWastedUploadFlow = " + this.jdField_a_of_type_Long + ",cancelType = " + paramInt);
  }
  
  private void a(MessageForPic paramMessageForPic)
  {
    Logger.a("PresendPicMgrService", "reuploadPhoto", " ");
    try
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getAppRuntime(this.jdField_c_of_type_JavaLangString);
      localQQAppInterface.a().b(paramMessageForPic.frienduin, paramMessageForPic.istroop, paramMessageForPic.uniseq);
      if (paramMessageForPic.isSendFromLocal()) {
        localQQAppInterface.a().a(localQQAppInterface.a().a(paramMessageForPic.frienduin, paramMessageForPic.uniseq));
      }
      PicUploadInfo.Builder localBuilder = new PicUploadInfo.Builder();
      localBuilder.a(paramMessageForPic.path);
      localBuilder.d(5);
      localBuilder.d(paramMessageForPic.frienduin);
      if (paramMessageForPic.fileSizeFlag == 1) {
        localBuilder.c(TranDbRecord.PicDbRecord.jdField_e_of_type_Int);
      }
      for (;;)
      {
        localBuilder.e(paramMessageForPic.senderuin);
        localBuilder.c(paramMessageForPic.selfuin);
        localBuilder.e(paramMessageForPic.istroop);
        localBuilder.jdField_i_of_type_Int = paramMessageForPic.extLong;
        localBuilder.jdField_i_of_type_JavaLangString = paramMessageForPic.extStr;
        PicUploadInfo.RetryInfo localRetryInfo = new PicUploadInfo.RetryInfo();
        localRetryInfo.jdField_a_of_type_Long = paramMessageForPic.msgseq;
        localRetryInfo.jdField_b_of_type_Long = paramMessageForPic.shmsgseq;
        localRetryInfo.jdField_a_of_type_Long = paramMessageForPic.msgseq;
        localBuilder.a(localRetryInfo);
        paramMessageForPic = PicBusiManager.a(4, 5);
        paramMessageForPic.a(localBuilder.a());
        PicBusiManager.a(paramMessageForPic, localQQAppInterface);
        return;
        localBuilder.c(TranDbRecord.PicDbRecord.jdField_d_of_type_Int);
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
    Logger.a("PresendPicMgrService", "addMsg", "MessageRecord = " + paramMessageRecord);
    try
    {
      localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getAppRuntime(this.jdField_c_of_type_JavaLangString);
      ((SVIPHandler)localQQAppInterface.a(13)).a(paramMessageRecord);
      str = localQQAppInterface.getCurrentAccountUin();
      if (TextUtils.isEmpty(str))
      {
        if (QLog.isColorLevel()) {
          QLog.e("PresendPicMgrService", 2, "[addMsg] empty current uin");
        }
      }
      else if ((PicItemBuilder.jdField_c_of_type_Int == 1) || (PicItemBuilder.jdField_c_of_type_Int == 2))
      {
        localQQAppInterface.a().b(paramMessageRecord, str);
        return;
      }
    }
    catch (AccountNotMatchException paramMessageRecord)
    {
      QQAppInterface localQQAppInterface;
      String str;
      if (QLog.isColorLevel())
      {
        QLog.d("PresendPicMgrService", 2, "no appRuntime");
        return;
        localQQAppInterface.a().a(paramMessageRecord, str);
      }
    }
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
        localBaseUploadProcessor = (BaseUploadProcessor)((QQAppInterface)BaseApplicationImpl.sApplication.getAppRuntime(this.jdField_c_of_type_JavaLangString)).a().a(((MessageRecord)???).frienduin, ((MessageRecord)???).uniseq);
        if (localBaseUploadProcessor != null) {
          break label243;
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
      label243:
      int j = b();
      if (localBaseUploadProcessor.g() < j)
      {
        Logger.a("PresendPicMgrService", "doCancel", " processor upload less than cancelPercent:" + j + ", do cancel! ");
        localBaseUploadProcessor.a();
        l1 = localBaseUploadProcessor.b();
      }
      else
      {
        Logger.a("PresendPicMgrService", "doCancel", " processor upload more than cancelPercent:" + j + ", do not cancel!");
        l1 = localBaseUploadProcessor.a();
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
      j = this.jdField_a_of_type_Int;
      continue;
      j = this.jdField_b_of_type_Int;
      continue;
      j = this.jdField_c_of_type_Int;
      continue;
      j = this.jdField_d_of_type_Int;
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
      Logger.a("PresendPicMgrService", "isOverWasteLimit", "PresendStatus : nettype = " + j + " result =  " + bool + ",mWastedUploadFlow = " + this.jdField_a_of_type_Long);
      return bool;
      if (this.jdField_a_of_type_Long <= this.jdField_b_of_type_Long) {
        break;
      }
      continue;
      if (this.jdField_a_of_type_Long <= this.jdField_e_of_type_Long) {
        break;
      }
      continue;
      if (this.jdField_a_of_type_Long <= this.jdField_d_of_type_Long) {
        break;
      }
      continue;
      if (this.jdField_a_of_type_Long <= this.jdField_c_of_type_Long) {
        break;
      }
    }
  }
  
  private void d()
  {
    Object localObject = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.pic_presend.name());
    if (DeviceProfileManager.a().a(DeviceProfileManager.AccountDpcManager.DpcAccountNames.picpredownload_whitelist.name()))
    {
      localObject = "1|1|1|1|1|1|1|1|104857600|104857600|104857600|104857600|0|90|70|50";
      Logger.a("PresendPicMgrService", "getServerConfig", "In VIP list, presendConfigString " + "1|1|1|1|1|1|1|1|104857600|104857600|104857600|104857600|0|90|70|50");
    }
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
        this.g = localObject[6].equals("1");
        this.h = localObject[7].equals("1");
      }
    }
    try
    {
      this.jdField_b_of_type_Long = Long.valueOf(localObject[8]).longValue();
      this.jdField_e_of_type_Long = Long.valueOf(localObject[9]).longValue();
      this.jdField_d_of_type_Long = Long.valueOf(localObject[10]).longValue();
      this.jdField_c_of_type_Long = Long.valueOf(localObject[11]).longValue();
      this.jdField_a_of_type_Int = Integer.parseInt(localObject[12]);
      this.jdField_b_of_type_Int = Integer.parseInt(localObject[13]);
      this.jdField_c_of_type_Int = Integer.parseInt(localObject[14]);
      this.jdField_d_of_type_Int = Integer.parseInt(localObject[15]);
      Logger.a("PresendPicMgrService", "getServerConfig", "mEnablePreCompress_WIFI = " + this.jdField_a_of_type_Boolean + "mEnablePreCompress_2G = " + this.jdField_b_of_type_Boolean + "mEnablePreCompress_3G = " + this.jdField_c_of_type_Boolean + "mEnablePreCompress_4G = " + this.jdField_d_of_type_Boolean + "mEnablePreUpload_WIFI = " + this.jdField_e_of_type_Boolean + ",mEnablePreUpload_2G = " + this.jdField_f_of_type_Boolean + ",mEnablePreUpload_3G = " + this.g + ",mEnablePreUpload_4G = " + this.h + "mPreUpMaxWasteSizeWIFI = " + this.jdField_b_of_type_Long + ", mPreUpMaxWasteSize2G = " + this.jdField_e_of_type_Long + ",mPreUpMaxWasteSize3G = " + this.jdField_d_of_type_Long + ",mPreUpMaxWasteSize4G = " + this.jdField_c_of_type_Long + ",mCancelPercentWIFI = " + this.jdField_a_of_type_Int + ",mCancelPercent2G = " + this.jdField_b_of_type_Int + ",mCancelPercent3G = " + this.jdField_c_of_type_Int + ",mCancelPercent4G = " + this.jdField_d_of_type_Int);
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
  
  public int a()
  {
    return this.jdField_e_of_type_Int;
  }
  
  public void a()
  {
    Logger.a("PresendPicMgrService", "sendMsg__ start!", " ");
    jdField_a_of_type_ComTencentMobileqqPicPresendPicMgrService = null;
    Object localObject4;
    try
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getAppRuntime(this.jdField_c_of_type_JavaLangString);
      ??? = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      for (;;)
      {
        if (((Iterator)???).hasNext())
        {
          localObject4 = (PicReq)((Iterator)???).next();
          if (((PicReq)localObject4).jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_c_of_type_Int == 4)
          {
            Logger.a("PresendPicMgrService", "sendMsg", "FLAG_UPLOADINFO_ERROR do not send! uuid = " + ((PicReq)localObject4).jdField_a_of_type_JavaLangString);
            continue;
            Logger.a("PresendPicMgrService", "sendMsg__ end!", " ");
          }
        }
      }
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
        return;
        synchronized (((PicReq)localObject4).jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo)
        {
          for (;;)
          {
            Object localObject6 = ((PicReq)localObject4).jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_a_of_type_JavaLangObject;
            if (localObject6 == null) {}
            try
            {
              Logger.a("PresendPicMgrService", "sendMsg", "start wait! uuid = " + ((PicReq)localObject4).jdField_a_of_type_JavaLangString);
              ((PicReq)localObject4).jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_e_of_type_Boolean = true;
              ((PicReq)localObject4).jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.wait();
              Logger.a("PresendPicMgrService", "sendMsg", "finish wait! uuid = " + ((PicReq)localObject4).jdField_a_of_type_JavaLangString);
              if (((PicReq)localObject4).jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_a_of_type_JavaLangObject == null) {
                Logger.b("PresendPicMgrService", "sendMsg", "get MR failed! uuid = " + ((PicReq)localObject4).jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_a_of_type_JavaLangString);
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
      ??? = (MessageRecord)((PicReq)localObject4).jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_a_of_type_JavaLangObject;
      a((MessageRecord)???);
      if (((PicReq)localObject4).jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_c_of_type_Int != 3) {
        break;
      }
      Logger.a("PresendPicMgrService", "sendMsg", "Pic not upload,reupload! mr = " + ???);
      a((MessageForPic)???);
      break;
      for (;;)
      {
        MessageRecord localMessageRecord;
        synchronized (this.jdField_b_of_type_JavaUtilArrayList)
        {
          this.i = true;
          localObject4 = this.jdField_b_of_type_JavaUtilArrayList.iterator();
          if (!((Iterator)localObject4).hasNext()) {
            break;
          }
          ??? = (PicReq)((Iterator)localObject4).next();
          int j = ((PicReq)???).jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_c_of_type_Int;
          localMessageRecord = (MessageRecord)((PicReq)???).jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_a_of_type_JavaLangObject;
          if (!this.jdField_a_of_type_JavaUtilArrayList.contains(???)) {
            break label548;
          }
          if (j == 1)
          {
            Logger.a("PresendPicMgrService", "sendMsg", "preupload success,dosend! mr =  " + localMessageRecord);
            localObject1.a().b(localMessageRecord, null);
          }
        }
        Logger.a("PresendPicMgrService", "sendMsg", "preupload failed,reupload! mr =  " + localMessageRecord);
        a((MessageForPic)localMessageRecord);
        continue;
        label548:
        Logger.a("PresendPicMgrService", "sendMsg", "unselect,do not send mr =  " + localMessageRecord);
      }
    }
  }
  
  public void a(int paramInt)
  {
    Logger.a("PresendPicMgrService", "cancelAll", "cancelType = " + paramInt);
    c();
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
    PicReq localPicReq = PicBusiManager.a(2, 1007);
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
      localPicReq.a(new afxl(this, localPicReq));
      if ((!a()) || (b()) || (FileUtils.a(localPicReq.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_g_of_type_JavaLangString) > 512000L))
      {
        Logger.a("PresendPicMgrService", "presendPic", "set FLAG_NOT_UPLOAD!");
        localPicReq.a(null);
        localPicReq.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_c_of_type_Int = 3;
      }
      try
      {
        PicBusiManager.a(localPicReq, (QQAppInterface)BaseApplicationImpl.sApplication.getAppRuntime(this.jdField_c_of_type_JavaLangString));
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
      bool = this.g;
      continue;
      bool = this.h;
    }
  }
  
  public int[] a()
  {
    try
    {
      int[] arrayOfInt = PicBusiManager.a((QQAppInterface)BaseApplicationImpl.sApplication.getAppRuntime(this.jdField_c_of_type_JavaLangString));
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.pic.PresendPicMgrService
 * JD-Core Version:    0.7.0.1
 */