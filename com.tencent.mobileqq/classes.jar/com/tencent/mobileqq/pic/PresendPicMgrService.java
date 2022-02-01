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
  static int t;
  private static PresendPicMgrService u;
  private String A;
  private String B;
  private String C;
  private int D;
  protected ArrayList<PicReq> a = new ArrayList();
  protected ArrayList<PicReq> b = new ArrayList();
  protected long c;
  protected boolean d;
  protected boolean e;
  protected boolean f;
  protected boolean g;
  protected long h = 209715200L;
  protected long i = 157286400L;
  protected long j = 73400320L;
  protected long k = 52428800L;
  protected int l = 0;
  protected int m = 90;
  protected int n = 70;
  protected int o = 50;
  protected boolean p = false;
  public int q = 0;
  public long r;
  public String s;
  private boolean v;
  private boolean w;
  private boolean x;
  private boolean y;
  private int z;
  
  public PresendPicMgrService(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2)
  {
    this.z = paramInt1;
    this.A = paramString1;
    this.B = paramString2;
    this.C = paramString3;
    this.D = paramInt2;
    long l1 = BasePicPreDownloadUtils.b("presend_lastDayTime", 0L);
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
    l();
    if (l2 - l1 > 86400000L)
    {
      Logger.a("PresendPicMgrService", "PresendPicMgrService", "more than one day, clear wastesize");
      StatisticConstants.a(BasePicPreDownloadUtils.b("presend_FlowWaste", 0L));
      BasePicPreDownloadUtils.a("presend_lastDayTime", l2);
      BasePicPreDownloadUtils.a("presend_FlowWaste", 0L);
    }
    this.c = BasePicPreDownloadUtils.b("presend_FlowWaste", 0L);
    u = this;
  }
  
  private PicUploadInfo a(String paramString, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    Object localObject = new PicUploadInfo.Builder();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("curFriendUin = ");
    localStringBuilder.append(this.A);
    Logger.a("PresendPicMgrService", "[@]buildPicUploadInfo", localStringBuilder.toString());
    ((PicUploadInfo.Builder)localObject).d(this.A);
    ((PicUploadInfo.Builder)localObject).a(paramString);
    ((PicUploadInfo.Builder)localObject).e(this.z);
    ((PicUploadInfo.Builder)localObject).e(this.B);
    ((PicUploadInfo.Builder)localObject).d(paramInt1);
    ((PicUploadInfo.Builder)localObject).f(0);
    ((PicUploadInfo.Builder)localObject).k(paramInt2);
    ((PicUploadInfo.Builder)localObject).l(this.D);
    localObject = ((PicUploadInfo.Builder)localObject).k();
    if (paramInt2 == 10)
    {
      if (((PicUploadInfo)localObject).ac == null) {
        ((PicUploadInfo)localObject).ac = new PicUploadExtra();
      }
      ((PicUploadInfo)localObject).ac.h = 9;
    }
    ((PicUploadInfo)localObject).w = true;
    if (((IPicUtil)QRoute.api(IPicUtil.class)).isProgressiveJpeg(paramString)) {
      LogTag.a();
    }
    try
    {
      ((PicUploadInfo)localObject).r = ((IPicUtil)QRoute.api(IPicUtil.class)).getSliceInfos(paramString);
      if ((((PicUploadInfo)localObject).r == null) || (!QLog.isColorLevel())) {
        break label316;
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("PresendPicMgrService.buildPicUploadInfo:");
      localStringBuilder.append(((PicUploadInfo)localObject).r.toString());
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
      ((PicUploadInfo)localObject).s = 1;
      Logger.a(localObject, "fixProtocolType", "sendReq.upInfo.protocolType");
      return localObject;
    }
    ((PicUploadInfo)localObject).s = ((PicUploadInfo)localObject).j();
    return localObject;
  }
  
  private void a(long paramLong, int paramInt)
  {
    this.c += paramLong;
    BasePicPreDownloadUtils.a("presend_FlowWaste", this.c);
    StatisticConstants.a(paramLong, paramInt);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PresendStatus:  wastesize = ");
    localStringBuilder.append(paramLong);
    localStringBuilder.append(",mWastedUploadFlow = ");
    localStringBuilder.append(this.c);
    localStringBuilder.append(",cancelType = ");
    localStringBuilder.append(paramInt);
    Logger.a("PresendPicMgrService", "calcWasteFlow ", localStringBuilder.toString());
  }
  
  private void a(MessageForPic paramMessageForPic)
  {
    Logger.a("PresendPicMgrService", "reuploadPhoto", " ");
    try
    {
      Object localObject = (QQAppInterface)BaseApplicationImpl.sApplication.getAppRuntime(this.C);
      ((QQAppInterface)localObject).getMessageFacade().h(paramMessageForPic.frienduin, paramMessageForPic.istroop, paramMessageForPic.uniseq);
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
      ((PicUploadInfo.Builder)localObject).A = paramMessageForPic.extLong;
      ((PicUploadInfo.Builder)localObject).B = paramMessageForPic.extStr;
      PicUploadInfo.RetryInfo localRetryInfo = new PicUploadInfo.RetryInfo();
      localRetryInfo.a = paramMessageForPic.msgseq;
      localRetryInfo.b = paramMessageForPic.shmsgseq;
      localRetryInfo.a = paramMessageForPic.msgseq;
      ((PicUploadInfo.Builder)localObject).a(localRetryInfo);
      paramMessageForPic = ((IPicBus)QRoute.api(IPicBus.class)).createPicReq(4, 5);
      paramMessageForPic.a(((PicUploadInfo.Builder)localObject).k());
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
  
  public static PresendPicMgrService e()
  {
    return u;
  }
  
  private void l()
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
        this.v = localObject[0].equals("1");
        this.w = localObject[1].equals("1");
        this.x = localObject[2].equals("1");
        this.y = localObject[3].equals("1");
        this.d = localObject[4].equals("1");
        this.e = localObject[5].equals("1");
        this.f = localObject[6].equals("1");
        this.g = localObject[7].equals("1");
        try
        {
          this.h = Long.valueOf(localObject[8]).longValue();
          this.k = Long.valueOf(localObject[9]).longValue();
          this.j = Long.valueOf(localObject[10]).longValue();
          this.i = Long.valueOf(localObject[11]).longValue();
          this.l = Integer.parseInt(localObject[12]);
          this.m = Integer.parseInt(localObject[13]);
          this.n = Integer.parseInt(localObject[14]);
          this.o = Integer.parseInt(localObject[15]);
        }
        catch (NumberFormatException localNumberFormatException)
        {
          localNumberFormatException.printStackTrace();
        }
        StringBuilder localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("mEnablePreCompress_WIFI = ");
        localStringBuilder1.append(this.v);
        localStringBuilder1.append("mEnablePreCompress_2G = ");
        localStringBuilder1.append(this.w);
        localStringBuilder1.append("mEnablePreCompress_3G = ");
        localStringBuilder1.append(this.x);
        localStringBuilder1.append("mEnablePreCompress_4G = ");
        localStringBuilder1.append(this.y);
        localStringBuilder1.append("mEnablePreUpload_WIFI = ");
        localStringBuilder1.append(this.d);
        localStringBuilder1.append(",mEnablePreUpload_2G = ");
        localStringBuilder1.append(this.e);
        localStringBuilder1.append(",mEnablePreUpload_3G = ");
        localStringBuilder1.append(this.f);
        localStringBuilder1.append(",mEnablePreUpload_4G = ");
        localStringBuilder1.append(this.g);
        localStringBuilder1.append("mPreUpMaxWasteSizeWIFI = ");
        localStringBuilder1.append(this.h);
        localStringBuilder1.append(", mPreUpMaxWasteSize2G = ");
        localStringBuilder1.append(this.k);
        localStringBuilder1.append(",mPreUpMaxWasteSize3G = ");
        localStringBuilder1.append(this.j);
        localStringBuilder1.append(",mPreUpMaxWasteSize4G = ");
        localStringBuilder1.append(this.i);
        localStringBuilder1.append(",mCancelPercentWIFI = ");
        localStringBuilder1.append(this.l);
        localStringBuilder1.append(",mCancelPercent2G = ");
        localStringBuilder1.append(this.m);
        localStringBuilder1.append(",mCancelPercent3G = ");
        localStringBuilder1.append(this.n);
        localStringBuilder1.append(",mCancelPercent4G = ");
        localStringBuilder1.append(this.o);
        Logger.a("PresendPicMgrService", "getServerConfig", localStringBuilder1.toString());
      }
    }
  }
  
  protected PicReq a(ArrayList<PicReq> paramArrayList, String paramString)
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
        if (localPicReq.c.equals(paramString)) {
          return localPicReq;
        }
      }
    }
    return null;
  }
  
  public void a()
  {
    Logger.a("PresendPicMgrService", "sendMsg__ start!", " ");
    u = null;
    ArrayList localArrayList = new ArrayList();
    try
    {
      synchronized (this.b)
      {
        this.p = true;
        Object localObject4 = (QQAppInterface)BaseApplicationImpl.sApplication.getAppRuntime(this.C);
        Object localObject5 = new ArrayList(this.a);
        ??? = new ArrayList(this.b);
        long l1 = 0L;
        int i1 = 0;
        Object localObject6;
        while (i1 < ((ArrayList)localObject5).size())
        {
          localObject6 = (PicReq)((ArrayList)localObject5).get(i1);
          long l2;
          if (((PicReq)localObject6).g.h == 4)
          {
            ??? = new StringBuilder();
            ((StringBuilder)???).append("FLAG_UPLOADINFO_ERROR do not send! uuid = ");
            ((StringBuilder)???).append(((PicReq)localObject6).c);
            Logger.a("PresendPicMgrService", "sendMsg", ((StringBuilder)???).toString());
            l2 = l1;
          }
          synchronized (((PicReq)localObject6).g)
          {
            Object localObject8 = ((PicReq)localObject6).g.i;
            if (localObject8 == null) {
              try
              {
                localObject8 = new StringBuilder();
                ((StringBuilder)localObject8).append("start wait! uuid = ");
                ((StringBuilder)localObject8).append(((PicReq)localObject6).c);
                Logger.a("PresendPicMgrService", "sendMsg", ((StringBuilder)localObject8).toString());
                ((PicReq)localObject6).g.y = true;
                ((PicReq)localObject6).g.wait();
                localObject8 = new StringBuilder();
                ((StringBuilder)localObject8).append("finish wait! uuid = ");
                ((StringBuilder)localObject8).append(((PicReq)localObject6).c);
                Logger.a("PresendPicMgrService", "sendMsg", ((StringBuilder)localObject8).toString());
              }
              catch (InterruptedException localInterruptedException)
              {
                localInterruptedException.printStackTrace();
              }
            }
            ((PicReq)localObject6).g.z = true;
            if (((PicReq)localObject6).g.i == null)
            {
              ??? = new StringBuilder();
              ((StringBuilder)???).append("get MR failed! uuid = ");
              ((StringBuilder)???).append(((PicReq)localObject6).g.a);
              Logger.b("PresendPicMgrService", "sendMsg", ((StringBuilder)???).toString());
              l2 = l1;
            }
            else
            {
              ??? = (MessageRecord)((PicReq)localObject6).g.i;
              if (this.q == 1)
              {
                ((MessageRecord)???).saveExtInfoToExtStr("msg_extra_key_is_sync_qzone", String.valueOf(1));
                ((MessageRecord)???).saveExtInfoToExtStr("msg_extra_key_qzone_album_id", this.s);
                ((MessageRecord)???).saveExtInfoToExtStr("msg_extra_key_qzone_batch_id", String.valueOf(this.r));
                ((MessageRecord)???).saveExtInfoToExtStr("msg_extra_key_qzone_is_raw", String.valueOf(((PicReq)localObject6).g.s));
                ((MessageRecord)???).saveExtInfoToExtStr("msg_extra_key_qzone_batch_count", String.valueOf(((ArrayList)localObject5).size()));
                ((MessageRecord)???).saveExtInfoToExtStr("msg_extra_key_qzone_photo_index", String.valueOf(i1));
              }
              a((MessageRecord)???);
              if ((??? instanceof MessageForPic))
              {
                localArrayList.add(((MessageForPic)???).path);
                l1 = ((MessageRecord)???).uniseq;
              }
              l2 = l1;
              if (((PicReq)localObject6).g.h == 3)
              {
                localObject6 = new StringBuilder();
                ((StringBuilder)localObject6).append("Pic not upload,reupload! mr = ");
                ((StringBuilder)localObject6).append(???);
                Logger.a("PresendPicMgrService", "sendMsg", ((StringBuilder)localObject6).toString());
                a((MessageForPic)???);
                l2 = l1;
              }
            }
            i1 += 1;
            l1 = l2;
          }
        }
        try
        {
          localObject6 = ((ArrayList)???).iterator();
          while (((Iterator)localObject6).hasNext())
          {
            Object localObject9 = (PicReq)((Iterator)localObject6).next();
            i1 = ((PicReq)localObject9).g.h;
            ??? = (MessageRecord)((PicReq)localObject9).g.i;
            if (((ArrayList)localObject5).contains(localObject9))
            {
              if (i1 == 1)
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
          if ((localList.size() >= 5) && (this.z == 1))
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
            TroopGrayTipUtils.a((QQAppInterface)BaseApplicationImpl.sApplication.getAppRuntime(this.C), this.A, this.C, localList, l1);
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
    k();
  }
  
  public void a(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("cancelType = ");
    localStringBuilder.append(paramInt);
    Logger.a("PresendPicMgrService", "cancelAll", localStringBuilder.toString());
    h();
  }
  
  public void a(int paramInt, long paramLong, String paramString)
  {
    this.q = paramInt;
    this.r = paramLong;
    this.s = paramString;
  }
  
  protected void a(PicReq paramPicReq, int paramInt)
  {
    synchronized (paramPicReq.g)
    {
      paramPicReq.g.x = true;
      if (paramPicReq.g.i == null)
      {
        Logger.b("PresendPicMgrService", "doCancel", " req.upInfo.picExtraObject == null!");
        return;
      }
      ??? = (MessageRecord)paramPicReq.g.i;
      try
      {
        BaseUploadProcessor localBaseUploadProcessor = (BaseUploadProcessor)((ITransFileController)((QQAppInterface)BaseApplicationImpl.sApplication.getAppRuntime(this.C)).getRuntimeService(ITransFileController.class)).findProcessor(((MessageRecord)???).frienduin, ((MessageRecord)???).uniseq);
        long l1;
        if (localBaseUploadProcessor == null)
        {
          Logger.a("PresendPicMgrService", "doCancel", " processor == null!");
          l1 = ((MessageForPic)???).mPresendTransferedSize;
        }
        else
        {
          int i1 = g();
          StringBuilder localStringBuilder;
          if (localBaseUploadProcessor.getRealProgress() < i1)
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append(" processor upload less than cancelPercent:");
            localStringBuilder.append(i1);
            localStringBuilder.append(", do cancel! ");
            Logger.a("PresendPicMgrService", "doCancel", localStringBuilder.toString());
            localBaseUploadProcessor.cancel();
            l1 = localBaseUploadProcessor.getTransferedSize();
          }
          else
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append(" processor upload more than cancelPercent:");
            localStringBuilder.append(i1);
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
        ((StringBuilder)???).append(paramPicReq.g.n);
        ((StringBuilder)???).append(",uuid:");
        ((StringBuilder)???).append(paramPicReq.g.a);
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
  
  public void a(String paramString, int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(" start,localUUID = ");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(", cancelType = ");
    ((StringBuilder)localObject).append(paramInt);
    Logger.a("PresendPicMgrService", "cancelUploadReq", ((StringBuilder)localObject).toString());
    localObject = a(this.a, paramString);
    if (localObject == null)
    {
      Logger.a("PresendPicMgrService", "cancelUploadReq", " find req failed ");
      return;
    }
    this.a.remove(localObject);
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
    if (!paramString1.b())
    {
      Logger.b("PresendPicMgrService", paramString2, paramString1.H.a, paramString1.H.b);
      paramString1.h = 4;
      this.a.add(localObject);
      return;
    }
    ((PicReq)localObject).a(new PresendPicMgrService.1(this, (PicReq)localObject, paramString1));
    if ((!i()) || (j()) || (FileUtils.getFileSizes(((PicReq)localObject).g.n) > 512000L))
    {
      Logger.a("PresendPicMgrService", "presendPic", "set FLAG_NOT_UPLOAD!");
      ((PicReq)localObject).a(null);
      ((PicReq)localObject).g.h = 3;
    }
    try
    {
      paramString1 = (QQAppInterface)BaseApplicationImpl.sApplication.getAppRuntime(this.C);
      ((IPicBus)QRoute.api(IPicBus.class)).launch((PicReq)localObject);
      this.a.add(localObject);
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
  
  public int b()
  {
    return this.z;
  }
  
  public boolean[] c()
  {
    return new boolean[] { this.v, this.w, this.x, this.y };
  }
  
  public int[] d()
  {
    try
    {
      Object localObject = (QQAppInterface)BaseApplicationImpl.sApplication.getAppRuntime(this.C);
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
  
  public void f()
  {
    int i1 = NetworkUtil.getSystemNetwork(BaseApplication.getContext());
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("netType = ");
    ((StringBuilder)localObject).append(i1);
    Logger.a("PresendPicMgrService", "handletWifi2Mobile", ((StringBuilder)localObject).toString());
    localObject = this.a;
    if ((localObject != null) && (((ArrayList)localObject).size() != 0))
    {
      PicReq localPicReq;
      if (i1 == 2)
      {
        Logger.a("PresendPicMgrService", "handletWifi2Mobile", "switch to G2,cancel upload! ");
        localObject = this.a.iterator();
        while (((Iterator)localObject).hasNext())
        {
          localPicReq = (PicReq)((Iterator)localObject).next();
          a(localPicReq, 1001);
          localPicReq.g.h = 3;
        }
      }
      if (((i1 == 3) || (i1 == 4)) && (j()))
      {
        Logger.a("PresendPicMgrService", "handletWifi2Mobile", "switch to G3/G4,overWastLimit,cancel upload! ");
        localObject = this.a.iterator();
        while (((Iterator)localObject).hasNext())
        {
          localPicReq = (PicReq)((Iterator)localObject).next();
          a(localPicReq, 1002);
          localPicReq.g.h = 3;
        }
      }
      return;
    }
    Logger.a("PresendPicMgrService", "handletWifi2Mobile", "mUploadReqList is Null! ");
  }
  
  protected int g()
  {
    int i2 = NetworkUtil.getSystemNetwork(BaseApplication.getContext());
    int i1;
    if (i2 != 1)
    {
      if (i2 != 2)
      {
        if (i2 != 3)
        {
          if (i2 != 4) {
            i1 = 0;
          } else {
            i1 = this.o;
          }
        }
        else {
          i1 = this.n;
        }
      }
      else {
        i1 = this.m;
      }
    }
    else {
      i1 = this.l;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" NetType = ");
    localStringBuilder.append(i2);
    localStringBuilder.append(", cancelpercent = ");
    localStringBuilder.append(i1);
    Logger.a("PresendPicMgrService", "getCancelPercent", localStringBuilder.toString());
    return i1;
  }
  
  void h()
  {
    Logger.a("PresendPicMgrService", "resetStatus", "");
    this.a.clear();
    this.b.clear();
    this.p = false;
  }
  
  boolean i()
  {
    int i1 = NetworkUtil.getSystemNetwork(BaseApplication.getContext());
    boolean bool;
    if (i1 != 1)
    {
      if (i1 != 2)
      {
        if (i1 != 3)
        {
          if (i1 != 4) {
            bool = false;
          } else {
            bool = this.g;
          }
        }
        else {
          bool = this.f;
        }
      }
      else {
        bool = this.e;
      }
    }
    else {
      bool = this.d;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("nettype = ");
    localStringBuilder.append(i1);
    localStringBuilder.append(" result =  ");
    localStringBuilder.append(bool);
    Logger.a("PresendPicMgrService", "isPreuploadEnable", localStringBuilder.toString());
    return bool;
  }
  
  protected boolean j()
  {
    int i1 = NetworkUtil.getSystemNetwork(BaseApplication.getContext());
    boolean bool = true;
    if (i1 != 1)
    {
      if (i1 != 2)
      {
        if (i1 != 3)
        {
          if ((i1 == 4) && (this.c > this.i)) {
            break label94;
          }
        }
        else if (this.c > this.j) {
          break label94;
        }
      }
      else if (this.c > this.k) {
        break label94;
      }
    }
    else {
      if (this.c > this.h) {
        break label94;
      }
    }
    bool = false;
    label94:
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PresendStatus : nettype = ");
    localStringBuilder.append(i1);
    localStringBuilder.append(" result =  ");
    localStringBuilder.append(bool);
    localStringBuilder.append(",mWastedUploadFlow = ");
    localStringBuilder.append(this.c);
    Logger.a("PresendPicMgrService", "isOverWasteLimit", localStringBuilder.toString());
    return bool;
  }
  
  public void k()
  {
    this.q = 0;
    this.r = 0L;
    this.s = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.pic.PresendPicMgrService
 * JD-Core Version:    0.7.0.1
 */