package com.tencent.mobileqq.pic;

import agqb;
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
  public int a;
  public long a;
  public String a;
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private String jdField_b_of_type_JavaLangString;
  private ArrayList jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int = 90;
  private long jdField_c_of_type_Long = 209715200L;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int = 70;
  private long jdField_d_of_type_Long = 157286400L;
  private String jdField_d_of_type_JavaLangString;
  private boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int = 50;
  private long jdField_e_of_type_Long = 73400320L;
  private boolean jdField_e_of_type_Boolean;
  private int jdField_f_of_type_Int;
  private long jdField_f_of_type_Long = 52428800L;
  private boolean jdField_f_of_type_Boolean;
  private int jdField_g_of_type_Int;
  private boolean jdField_g_of_type_Boolean;
  private boolean h;
  private boolean i;
  
  public PresendPicMgrService(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2)
  {
    this.jdField_f_of_type_Int = paramInt1;
    this.jdField_b_of_type_JavaLangString = paramString1;
    this.jdField_c_of_type_JavaLangString = paramString2;
    this.jdField_d_of_type_JavaLangString = paramString3;
    this.jdField_g_of_type_Int = paramInt2;
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
    Logger.a("PresendPicMgrService", "[@]buildPicUploadInfo", "curFriendUin = " + this.jdField_b_of_type_JavaLangString);
    ((PicUploadInfo.Builder)localObject).d(this.jdField_b_of_type_JavaLangString);
    ((PicUploadInfo.Builder)localObject).a(paramString);
    ((PicUploadInfo.Builder)localObject).e(this.jdField_f_of_type_Int);
    ((PicUploadInfo.Builder)localObject).e(this.jdField_c_of_type_JavaLangString);
    ((PicUploadInfo.Builder)localObject).d(paramInt1);
    ((PicUploadInfo.Builder)localObject).f(0);
    ((PicUploadInfo.Builder)localObject).k(paramInt2);
    ((PicUploadInfo.Builder)localObject).l(this.jdField_g_of_type_Int);
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
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getAppRuntime(this.jdField_d_of_type_JavaLangString);
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
      localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getAppRuntime(this.jdField_d_of_type_JavaLangString);
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
        localBaseUploadProcessor = (BaseUploadProcessor)((QQAppInterface)BaseApplicationImpl.sApplication.getAppRuntime(this.jdField_d_of_type_JavaLangString)).a().a(((MessageRecord)???).frienduin, ((MessageRecord)???).uniseq);
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
      j = this.jdField_b_of_type_Int;
      continue;
      j = this.jdField_c_of_type_Int;
      continue;
      j = this.jdField_d_of_type_Int;
      continue;
      j = this.jdField_e_of_type_Int;
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
        this.jdField_g_of_type_Boolean = localObject[6].equals("1");
        this.h = localObject[7].equals("1");
      }
    }
    try
    {
      this.jdField_c_of_type_Long = Long.valueOf(localObject[8]).longValue();
      this.jdField_f_of_type_Long = Long.valueOf(localObject[9]).longValue();
      this.jdField_e_of_type_Long = Long.valueOf(localObject[10]).longValue();
      this.jdField_d_of_type_Long = Long.valueOf(localObject[11]).longValue();
      this.jdField_b_of_type_Int = Integer.parseInt(localObject[12]);
      this.jdField_c_of_type_Int = Integer.parseInt(localObject[13]);
      this.jdField_d_of_type_Int = Integer.parseInt(localObject[14]);
      this.jdField_e_of_type_Int = Integer.parseInt(localObject[15]);
      Logger.a("PresendPicMgrService", "getServerConfig", "mEnablePreCompress_WIFI = " + this.jdField_a_of_type_Boolean + "mEnablePreCompress_2G = " + this.jdField_b_of_type_Boolean + "mEnablePreCompress_3G = " + this.jdField_c_of_type_Boolean + "mEnablePreCompress_4G = " + this.jdField_d_of_type_Boolean + "mEnablePreUpload_WIFI = " + this.jdField_e_of_type_Boolean + ",mEnablePreUpload_2G = " + this.jdField_f_of_type_Boolean + ",mEnablePreUpload_3G = " + this.jdField_g_of_type_Boolean + ",mEnablePreUpload_4G = " + this.h + "mPreUpMaxWasteSizeWIFI = " + this.jdField_c_of_type_Long + ", mPreUpMaxWasteSize2G = " + this.jdField_f_of_type_Long + ",mPreUpMaxWasteSize3G = " + this.jdField_e_of_type_Long + ",mPreUpMaxWasteSize4G = " + this.jdField_d_of_type_Long + ",mCancelPercentWIFI = " + this.jdField_b_of_type_Int + ",mCancelPercent2G = " + this.jdField_c_of_type_Int + ",mCancelPercent3G = " + this.jdField_d_of_type_Int + ",mCancelPercent4G = " + this.jdField_e_of_type_Int);
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
    return this.jdField_f_of_type_Int;
  }
  
  /* Error */
  public void a()
  {
    // Byte code:
    //   0: ldc 78
    //   2: ldc_w 614
    //   5: ldc_w 272
    //   8: invokestatic 109	com/tencent/mobileqq/pic/Logger:a	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   11: aconst_null
    //   12: putstatic 129	com/tencent/mobileqq/pic/PresendPicMgrService:jdField_a_of_type_ComTencentMobileqqPicPresendPicMgrService	Lcom/tencent/mobileqq/pic/PresendPicMgrService;
    //   15: getstatic 278	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   18: aload_0
    //   19: getfield 61	com/tencent/mobileqq/pic/PresendPicMgrService:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   22: invokevirtual 282	com/tencent/common/app/BaseApplicationImpl:getAppRuntime	(Ljava/lang/String;)Lmqq/app/AppRuntime;
    //   25: checkcast 284	com/tencent/mobileqq/app/QQAppInterface
    //   28: astore_2
    //   29: iconst_0
    //   30: istore_1
    //   31: iload_1
    //   32: aload_0
    //   33: getfield 29	com/tencent/mobileqq/pic/PresendPicMgrService:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   36: invokevirtual 135	java/util/ArrayList:size	()I
    //   39: if_icmpge +423 -> 462
    //   42: aload_0
    //   43: getfield 29	com/tencent/mobileqq/pic/PresendPicMgrService:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   46: iload_1
    //   47: invokevirtual 618	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   50: checkcast 151	com/tencent/mobileqq/pic/PicReq
    //   53: astore_3
    //   54: aload_3
    //   55: getfield 413	com/tencent/mobileqq/pic/PicReq:jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo	Lcom/tencent/mobileqq/pic/PicUploadInfo;
    //   58: getfield 619	com/tencent/mobileqq/pic/PicUploadInfo:jdField_c_of_type_Int	I
    //   61: iconst_4
    //   62: if_icmpne +37 -> 99
    //   65: ldc 78
    //   67: ldc_w 621
    //   70: new 82	java/lang/StringBuilder
    //   73: dup
    //   74: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   77: ldc_w 623
    //   80: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: aload_3
    //   84: getfield 153	com/tencent/mobileqq/pic/PicReq:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   87: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   93: invokestatic 109	com/tencent/mobileqq/pic/Logger:a	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   96: goto +573 -> 669
    //   99: aload_3
    //   100: getfield 413	com/tencent/mobileqq/pic/PicReq:jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo	Lcom/tencent/mobileqq/pic/PicUploadInfo;
    //   103: astore 4
    //   105: aload 4
    //   107: monitorenter
    //   108: aload_3
    //   109: getfield 413	com/tencent/mobileqq/pic/PicReq:jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo	Lcom/tencent/mobileqq/pic/PicUploadInfo;
    //   112: getfield 418	com/tencent/mobileqq/pic/PicUploadInfo:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   115: astore 5
    //   117: aload 5
    //   119: ifnonnull +80 -> 199
    //   122: ldc 78
    //   124: ldc_w 621
    //   127: new 82	java/lang/StringBuilder
    //   130: dup
    //   131: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   134: ldc_w 625
    //   137: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: aload_3
    //   141: getfield 153	com/tencent/mobileqq/pic/PicReq:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   144: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   150: invokestatic 109	com/tencent/mobileqq/pic/Logger:a	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   153: aload_3
    //   154: getfield 413	com/tencent/mobileqq/pic/PicReq:jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo	Lcom/tencent/mobileqq/pic/PicUploadInfo;
    //   157: iconst_1
    //   158: putfield 626	com/tencent/mobileqq/pic/PicUploadInfo:jdField_e_of_type_Boolean	Z
    //   161: aload_3
    //   162: getfield 413	com/tencent/mobileqq/pic/PicReq:jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo	Lcom/tencent/mobileqq/pic/PicUploadInfo;
    //   165: invokevirtual 631	java/lang/Object:wait	()V
    //   168: ldc 78
    //   170: ldc_w 621
    //   173: new 82	java/lang/StringBuilder
    //   176: dup
    //   177: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   180: ldc_w 633
    //   183: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   186: aload_3
    //   187: getfield 153	com/tencent/mobileqq/pic/PicReq:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   190: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   193: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   196: invokestatic 109	com/tencent/mobileqq/pic/Logger:a	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   199: aload 4
    //   201: monitorexit
    //   202: aload_3
    //   203: getfield 413	com/tencent/mobileqq/pic/PicReq:jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo	Lcom/tencent/mobileqq/pic/PicUploadInfo;
    //   206: getfield 418	com/tencent/mobileqq/pic/PicUploadInfo:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   209: ifnonnull +88 -> 297
    //   212: ldc 78
    //   214: ldc_w 621
    //   217: new 82	java/lang/StringBuilder
    //   220: dup
    //   221: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   224: ldc_w 635
    //   227: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   230: aload_3
    //   231: getfield 413	com/tencent/mobileqq/pic/PicReq:jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo	Lcom/tencent/mobileqq/pic/PicUploadInfo;
    //   234: getfield 450	com/tencent/mobileqq/pic/PicUploadInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   237: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   240: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   243: invokestatic 424	com/tencent/mobileqq/pic/Logger:b	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   246: goto +423 -> 669
    //   249: astore_2
    //   250: invokestatic 214	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   253: ifeq +12 -> 265
    //   256: ldc 78
    //   258: iconst_2
    //   259: ldc_w 373
    //   262: invokestatic 222	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   265: ldc 78
    //   267: ldc_w 637
    //   270: ldc_w 272
    //   273: invokestatic 109	com/tencent/mobileqq/pic/Logger:a	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   276: aload_0
    //   277: invokevirtual 639	com/tencent/mobileqq/pic/PresendPicMgrService:d	()V
    //   280: return
    //   281: astore 5
    //   283: aload 5
    //   285: invokevirtual 640	java/lang/InterruptedException:printStackTrace	()V
    //   288: goto -89 -> 199
    //   291: astore_2
    //   292: aload 4
    //   294: monitorexit
    //   295: aload_2
    //   296: athrow
    //   297: aload_3
    //   298: getfield 413	com/tencent/mobileqq/pic/PicReq:jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo	Lcom/tencent/mobileqq/pic/PicUploadInfo;
    //   301: getfield 418	com/tencent/mobileqq/pic/PicUploadInfo:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   304: checkcast 426	com/tencent/mobileqq/data/MessageRecord
    //   307: astore 4
    //   309: aload_0
    //   310: getfield 642	com/tencent/mobileqq/pic/PresendPicMgrService:jdField_a_of_type_Int	I
    //   313: iconst_1
    //   314: if_icmpne +90 -> 404
    //   317: aload 4
    //   319: ldc_w 644
    //   322: iconst_1
    //   323: invokestatic 647	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   326: invokevirtual 650	com/tencent/mobileqq/data/MessageRecord:saveExtInfoToExtStr	(Ljava/lang/String;Ljava/lang/String;)V
    //   329: aload 4
    //   331: ldc_w 652
    //   334: aload_0
    //   335: getfield 653	com/tencent/mobileqq/pic/PresendPicMgrService:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   338: invokevirtual 650	com/tencent/mobileqq/data/MessageRecord:saveExtInfoToExtStr	(Ljava/lang/String;Ljava/lang/String;)V
    //   341: aload 4
    //   343: ldc_w 655
    //   346: aload_0
    //   347: getfield 656	com/tencent/mobileqq/pic/PresendPicMgrService:jdField_a_of_type_Long	J
    //   350: invokestatic 659	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   353: invokevirtual 650	com/tencent/mobileqq/data/MessageRecord:saveExtInfoToExtStr	(Ljava/lang/String;Ljava/lang/String;)V
    //   356: aload 4
    //   358: ldc_w 661
    //   361: aload_3
    //   362: getfield 413	com/tencent/mobileqq/pic/PicReq:jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo	Lcom/tencent/mobileqq/pic/PicUploadInfo;
    //   365: getfield 230	com/tencent/mobileqq/pic/PicUploadInfo:jdField_g_of_type_Int	I
    //   368: invokestatic 647	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   371: invokevirtual 650	com/tencent/mobileqq/data/MessageRecord:saveExtInfoToExtStr	(Ljava/lang/String;Ljava/lang/String;)V
    //   374: aload 4
    //   376: ldc_w 663
    //   379: aload_0
    //   380: getfield 29	com/tencent/mobileqq/pic/PresendPicMgrService:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   383: invokevirtual 135	java/util/ArrayList:size	()I
    //   386: invokestatic 647	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   389: invokevirtual 650	com/tencent/mobileqq/data/MessageRecord:saveExtInfoToExtStr	(Ljava/lang/String;Ljava/lang/String;)V
    //   392: aload 4
    //   394: ldc_w 665
    //   397: iload_1
    //   398: invokestatic 647	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   401: invokevirtual 650	com/tencent/mobileqq/data/MessageRecord:saveExtInfoToExtStr	(Ljava/lang/String;Ljava/lang/String;)V
    //   404: aload_0
    //   405: aload 4
    //   407: invokespecial 666	com/tencent/mobileqq/pic/PresendPicMgrService:a	(Lcom/tencent/mobileqq/data/MessageRecord;)V
    //   410: aload_3
    //   411: getfield 413	com/tencent/mobileqq/pic/PicReq:jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo	Lcom/tencent/mobileqq/pic/PicUploadInfo;
    //   414: getfield 619	com/tencent/mobileqq/pic/PicUploadInfo:jdField_c_of_type_Int	I
    //   417: iconst_3
    //   418: if_icmpne +251 -> 669
    //   421: ldc 78
    //   423: ldc_w 621
    //   426: new 82	java/lang/StringBuilder
    //   429: dup
    //   430: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   433: ldc_w 668
    //   436: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   439: aload 4
    //   441: invokevirtual 381	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   444: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   447: invokestatic 109	com/tencent/mobileqq/pic/Logger:a	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   450: aload_0
    //   451: aload 4
    //   453: checkcast 289	com/tencent/mobileqq/data/MessageForPic
    //   456: invokespecial 670	com/tencent/mobileqq/pic/PresendPicMgrService:a	(Lcom/tencent/mobileqq/data/MessageForPic;)V
    //   459: goto +210 -> 669
    //   462: aload_0
    //   463: getfield 31	com/tencent/mobileqq/pic/PresendPicMgrService:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   466: astore_3
    //   467: aload_3
    //   468: monitorenter
    //   469: aload_0
    //   470: iconst_1
    //   471: putfield 472	com/tencent/mobileqq/pic/PresendPicMgrService:i	Z
    //   474: aload_0
    //   475: getfield 31	com/tencent/mobileqq/pic/PresendPicMgrService:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   478: invokevirtual 139	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   481: astore 4
    //   483: aload 4
    //   485: invokeinterface 145 1 0
    //   490: ifeq +174 -> 664
    //   493: aload 4
    //   495: invokeinterface 149 1 0
    //   500: checkcast 151	com/tencent/mobileqq/pic/PicReq
    //   503: astore 5
    //   505: aload 5
    //   507: getfield 413	com/tencent/mobileqq/pic/PicReq:jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo	Lcom/tencent/mobileqq/pic/PicUploadInfo;
    //   510: getfield 619	com/tencent/mobileqq/pic/PicUploadInfo:jdField_c_of_type_Int	I
    //   513: istore_1
    //   514: aload 5
    //   516: getfield 413	com/tencent/mobileqq/pic/PicReq:jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo	Lcom/tencent/mobileqq/pic/PicUploadInfo;
    //   519: getfield 418	com/tencent/mobileqq/pic/PicUploadInfo:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   522: checkcast 426	com/tencent/mobileqq/data/MessageRecord
    //   525: astore 6
    //   527: aload_0
    //   528: getfield 29	com/tencent/mobileqq/pic/PresendPicMgrService:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   531: aload 5
    //   533: invokevirtual 673	java/util/ArrayList:contains	(Ljava/lang/Object;)Z
    //   536: ifeq +96 -> 632
    //   539: iload_1
    //   540: iconst_1
    //   541: if_icmpne +50 -> 591
    //   544: ldc 78
    //   546: ldc_w 621
    //   549: new 82	java/lang/StringBuilder
    //   552: dup
    //   553: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   556: ldc_w 675
    //   559: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   562: aload 6
    //   564: invokevirtual 381	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   567: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   570: invokestatic 109	com/tencent/mobileqq/pic/Logger:a	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   573: aload_2
    //   574: invokevirtual 287	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/message/QQMessageFacade;
    //   577: aload 6
    //   579: aconst_null
    //   580: invokevirtual 678	com/tencent/mobileqq/app/message/QQMessageFacade:b	(Lcom/tencent/mobileqq/data/MessageRecord;Lcom/tencent/mobileqq/app/MessageObserver;)V
    //   583: goto -100 -> 483
    //   586: astore_2
    //   587: aload_3
    //   588: monitorexit
    //   589: aload_2
    //   590: athrow
    //   591: ldc 78
    //   593: ldc_w 621
    //   596: new 82	java/lang/StringBuilder
    //   599: dup
    //   600: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   603: ldc_w 680
    //   606: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   609: aload 6
    //   611: invokevirtual 381	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   614: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   617: invokestatic 109	com/tencent/mobileqq/pic/Logger:a	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   620: aload_0
    //   621: aload 6
    //   623: checkcast 289	com/tencent/mobileqq/data/MessageForPic
    //   626: invokespecial 670	com/tencent/mobileqq/pic/PresendPicMgrService:a	(Lcom/tencent/mobileqq/data/MessageForPic;)V
    //   629: goto -146 -> 483
    //   632: ldc 78
    //   634: ldc_w 621
    //   637: new 82	java/lang/StringBuilder
    //   640: dup
    //   641: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   644: ldc_w 682
    //   647: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   650: aload 6
    //   652: invokevirtual 381	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   655: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   658: invokestatic 109	com/tencent/mobileqq/pic/Logger:a	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   661: goto -178 -> 483
    //   664: aload_3
    //   665: monitorexit
    //   666: goto -401 -> 265
    //   669: iload_1
    //   670: iconst_1
    //   671: iadd
    //   672: istore_1
    //   673: goto -642 -> 31
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	676	0	this	PresendPicMgrService
    //   30	643	1	j	int
    //   28	1	2	localQQAppInterface	QQAppInterface
    //   249	1	2	localAccountNotMatchException	AccountNotMatchException
    //   291	283	2	localObject1	Object
    //   586	4	2	localObject2	Object
    //   115	3	5	localObject5	Object
    //   281	3	5	localInterruptedException	java.lang.InterruptedException
    //   503	29	5	localPicReq	PicReq
    //   525	126	6	localMessageRecord	MessageRecord
    // Exception table:
    //   from	to	target	type
    //   15	29	249	mqq/app/AccountNotMatchException
    //   31	96	249	mqq/app/AccountNotMatchException
    //   99	108	249	mqq/app/AccountNotMatchException
    //   202	246	249	mqq/app/AccountNotMatchException
    //   295	297	249	mqq/app/AccountNotMatchException
    //   297	404	249	mqq/app/AccountNotMatchException
    //   404	459	249	mqq/app/AccountNotMatchException
    //   462	469	249	mqq/app/AccountNotMatchException
    //   589	591	249	mqq/app/AccountNotMatchException
    //   122	199	281	java/lang/InterruptedException
    //   108	117	291	finally
    //   122	199	291	finally
    //   199	202	291	finally
    //   283	288	291	finally
    //   292	295	291	finally
    //   469	483	586	finally
    //   483	539	586	finally
    //   544	583	586	finally
    //   587	589	586	finally
    //   591	629	586	finally
    //   632	661	586	finally
    //   664	666	586	finally
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
      localPicReq.a(new agqb(this, localPicReq));
      if ((!a()) || (b()) || (FileUtils.a(localPicReq.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_g_of_type_JavaLangString) > 512000L))
      {
        Logger.a("PresendPicMgrService", "presendPic", "set FLAG_NOT_UPLOAD!");
        localPicReq.a(null);
        localPicReq.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_c_of_type_Int = 3;
      }
      try
      {
        PicBusiManager.a(localPicReq, (QQAppInterface)BaseApplicationImpl.sApplication.getAppRuntime(this.jdField_d_of_type_JavaLangString));
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
      bool = this.h;
    }
  }
  
  public int[] a()
  {
    try
    {
      int[] arrayOfInt = PicBusiManager.a((QQAppInterface)BaseApplicationImpl.sApplication.getAppRuntime(this.jdField_d_of_type_JavaLangString));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.pic.PresendPicMgrService
 * JD-Core Version:    0.7.0.1
 */