package cooperation.weiyun.sdk.api;

import android.content.Context;
import anhp;
import anhq;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.weiyun.utils.Utils;
import cooperation.weiyun.channel.WySender;
import cooperation.weiyun.channel.pb.WeiyunPB.AioPicAndVideoCopyToWeiyunMsgReq;
import cooperation.weiyun.channel.pb.WeiyunPB.CrossBidProxyCopyFileToOtherBidMsgReq;
import cooperation.weiyun.channel.pb.WeiyunPB.CrossBidProxyOfflineFileGetListMsgReq;
import cooperation.weiyun.channel.pb.WeiyunPB.DiskAlbumStatusReportReq;
import cooperation.weiyun.channel.pb.WeiyunPB.DiskDirFileBatchDeleteExMsgReq;
import cooperation.weiyun.channel.pb.WeiyunPB.DiskFileBatchDownloadMsgReq;
import cooperation.weiyun.channel.pb.WeiyunPB.DiskFileDocDownloadAbsMsgReq;
import cooperation.weiyun.channel.pb.WeiyunPB.DiskPicBackupReq;
import cooperation.weiyun.channel.pb.WeiyunPB.LibInfoListGetMsgReq;
import cooperation.weiyun.channel.pb.WeiyunPB.MsgBody;
import cooperation.weiyun.channel.pb.WeiyunPB.PwdQueryMsgReq;
import cooperation.weiyun.channel.pb.WeiyunPB.PwdQueryMsgRsp;
import cooperation.weiyun.channel.pb.WeiyunPB.PwdVerifyMsgReq;
import cooperation.weiyun.channel.pb.WeiyunPB.QqSdkFileUploadMsgReq;
import cooperation.weiyun.channel.pb.WeiyunPB.ReqMsgBody;
import cooperation.weiyun.channel.pb.WeiyunPB.WeiyunTrialCouponUseMsgReq;
import cooperation.weiyun.utils.PreferenceUtils;
import cooperation.weiyun.utils.StringUtils;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;

public final class WeiyunApi
{
  private static final AtomicBoolean[] a = { new AtomicBoolean(false), new AtomicBoolean(false), new AtomicBoolean(false), new AtomicBoolean(false) };
  
  public static String a(Context paramContext)
  {
    return PreferenceUtils.a(paramContext, String.valueOf(BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin()), "key_signature");
  }
  
  public static void a(Context paramContext)
  {
    ThreadManager.executeOnSubThread(new anhq(paramContext));
  }
  
  public static void a(Context paramContext, long paramLong)
  {
    PreferenceUtils.a(paramContext, String.valueOf(paramLong), "key_pwd_queried");
    PreferenceUtils.a(paramContext, String.valueOf(paramLong), "key_pwd_has");
    PreferenceUtils.a(paramContext, String.valueOf(paramLong), "key_pwd_verified");
    a[0].set(false);
    a[1].set(false);
    a[2].set(false);
    a[3].set(false);
  }
  
  public static void a(Context paramContext, String paramString)
  {
    PreferenceUtils.a(paramContext, String.valueOf(BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin()), "key_signature", paramString);
  }
  
  public static void a(Context paramContext, boolean paramBoolean)
  {
    boolean bool = true;
    a[3].set(true);
    AtomicBoolean localAtomicBoolean = a[0];
    if (!paramBoolean) {}
    for (;;)
    {
      if (localAtomicBoolean.compareAndSet(bool, paramBoolean)) {
        PreferenceUtils.a(paramContext, String.valueOf(BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin()), "key_pwd_queried", Boolean.toString(paramBoolean));
      }
      return;
      bool = false;
    }
  }
  
  public static void a(WeiyunPB.AioPicAndVideoCopyToWeiyunMsgReq paramAioPicAndVideoCopyToWeiyunMsgReq, IWeiyunCallback paramIWeiyunCallback)
  {
    WySender.a().a(Integer.toString(246001), a(246001, paramAioPicAndVideoCopyToWeiyunMsgReq), new anhp(246001, paramIWeiyunCallback));
  }
  
  public static void a(WeiyunPB.CrossBidProxyCopyFileToOtherBidMsgReq paramCrossBidProxyCopyFileToOtherBidMsgReq, IWeiyunCallback paramIWeiyunCallback)
  {
    WySender.a().a(Integer.toString(245700), a(245700, paramCrossBidProxyCopyFileToOtherBidMsgReq), new anhp(245700, paramIWeiyunCallback));
  }
  
  public static void a(WeiyunPB.CrossBidProxyOfflineFileGetListMsgReq paramCrossBidProxyOfflineFileGetListMsgReq, IWeiyunCallback paramIWeiyunCallback)
  {
    WySender.a().a(Integer.toString(245706), a(245706, paramCrossBidProxyOfflineFileGetListMsgReq), new anhp(245706, paramIWeiyunCallback));
  }
  
  public static void a(WeiyunPB.DiskDirFileBatchDeleteExMsgReq paramDiskDirFileBatchDeleteExMsgReq, IWeiyunCallback paramIWeiyunCallback)
  {
    WySender.a().a(Integer.toString(2509), a(2509, paramDiskDirFileBatchDeleteExMsgReq), new anhp(2509, paramIWeiyunCallback));
  }
  
  public static void a(WeiyunPB.DiskFileBatchDownloadMsgReq paramDiskFileBatchDownloadMsgReq, IWeiyunCallback paramIWeiyunCallback)
  {
    WySender.a().a(Integer.toString(2402), a(2402, paramDiskFileBatchDownloadMsgReq), new anhp(2402, paramIWeiyunCallback));
  }
  
  public static void a(WeiyunPB.DiskFileDocDownloadAbsMsgReq paramDiskFileDocDownloadAbsMsgReq, IWeiyunCallback paramIWeiyunCallback)
  {
    WySender.a().a(Integer.toString(2414), a(2414, paramDiskFileDocDownloadAbsMsgReq), new anhp(2414, paramIWeiyunCallback));
  }
  
  public static void a(WeiyunPB.DiskPicBackupReq paramDiskPicBackupReq, IWeiyunCallback paramIWeiyunCallback)
  {
    WySender.a().a(Integer.toString(2803), a(2803, paramDiskPicBackupReq), new anhp(2803, paramIWeiyunCallback));
  }
  
  public static void a(WeiyunPB.LibInfoListGetMsgReq paramLibInfoListGetMsgReq, IWeiyunCallback paramIWeiyunCallback)
  {
    WySender.a().a(Integer.toString(26113), a(26113, paramLibInfoListGetMsgReq), new anhp(26113, paramIWeiyunCallback));
  }
  
  public static void a(WeiyunPB.PwdVerifyMsgReq paramPwdVerifyMsgReq, IWeiyunCallback paramIWeiyunCallback)
  {
    WySender.a().a(Integer.toString(11005), a(11005, paramPwdVerifyMsgReq), new anhp(11005, paramIWeiyunCallback));
  }
  
  public static void a(WeiyunPB.QqSdkFileUploadMsgReq paramQqSdkFileUploadMsgReq, IWeiyunCallback paramIWeiyunCallback)
  {
    WySender.a().a(Integer.toString(246000), a(246000, paramQqSdkFileUploadMsgReq), new anhp(246000, paramIWeiyunCallback));
  }
  
  public static void a(WeiyunPB.WeiyunTrialCouponUseMsgReq paramWeiyunTrialCouponUseMsgReq, IWeiyunCallback paramIWeiyunCallback)
  {
    WySender.a().a(Integer.toString(245520), a(245520, paramWeiyunTrialCouponUseMsgReq), new anhp(245520, paramIWeiyunCallback));
  }
  
  public static void a(IWeiyunCallback paramIWeiyunCallback)
  {
    if (paramIWeiyunCallback == null) {
      return;
    }
    if (a[0].get())
    {
      WeiyunPB.PwdQueryMsgRsp localPwdQueryMsgRsp = new WeiyunPB.PwdQueryMsgRsp();
      if ((a[1].get()) && (!a[2].get()))
      {
        localPwdQueryMsgRsp.pwd_open.set(true);
        paramIWeiyunCallback.a(localPwdQueryMsgRsp);
        return;
      }
      localPwdQueryMsgRsp.pwd_open.set(false);
      paramIWeiyunCallback.a(localPwdQueryMsgRsp);
      return;
    }
    WySender.a().a(Integer.toString(11001), a(11001, new WeiyunPB.PwdQueryMsgReq()), new anhp(11001, paramIWeiyunCallback));
  }
  
  public static void a(String paramString, IWeiyunCallback paramIWeiyunCallback)
  {
    WeiyunPB.PwdVerifyMsgReq localPwdVerifyMsgReq = new WeiyunPB.PwdVerifyMsgReq();
    paramString = Utils.bytes2HexStr(Utils.str2Md5(paramString));
    localPwdVerifyMsgReq.pwd_md5.set(StringUtils.a(paramString));
    a(localPwdVerifyMsgReq, paramIWeiyunCallback);
  }
  
  public static boolean a()
  {
    return a[0].get();
  }
  
  static byte[] a(int paramInt, Object paramObject)
  {
    if (paramObject == null) {
      return null;
    }
    WeiyunPB.MsgBody localMsgBody = new WeiyunPB.MsgBody();
    WeiyunPB.ReqMsgBody localReqMsgBody = new WeiyunPB.ReqMsgBody();
    switch (paramInt)
    {
    }
    for (;;)
    {
      localMsgBody.ReqMsg_body = localReqMsgBody;
      localMsgBody.ReqMsg_body.setHasFlag(true);
      localMsgBody.setHasFlag(true);
      return localMsgBody.toByteArray();
      localReqMsgBody.LibInfoListGetMsgReq_body.set((WeiyunPB.LibInfoListGetMsgReq)paramObject);
      continue;
      localReqMsgBody.DiskFileBatchDownloadMsgReq_body.set((WeiyunPB.DiskFileBatchDownloadMsgReq)paramObject);
      continue;
      localReqMsgBody.DiskFileDocDownloadAbsMsgReq_body.set((WeiyunPB.DiskFileDocDownloadAbsMsgReq)paramObject);
      continue;
      localReqMsgBody.DiskDirFileBatchDeleteExMsgReq_body.set((WeiyunPB.DiskDirFileBatchDeleteExMsgReq)paramObject);
      continue;
      localReqMsgBody.DiskPicBackupReq_body.set((WeiyunPB.DiskPicBackupReq)paramObject);
      continue;
      localReqMsgBody.DiskAlbumStatusReportReq_body.set((WeiyunPB.DiskAlbumStatusReportReq)paramObject);
      continue;
      localReqMsgBody.PwdQueryMsgReq_body.set((WeiyunPB.PwdQueryMsgReq)paramObject);
      continue;
      localReqMsgBody.PwdVerifyMsgReq_body.set((WeiyunPB.PwdVerifyMsgReq)paramObject);
      continue;
      localReqMsgBody.CrossBidProxyCopyFileToOtherBidMsgReq_body.set((WeiyunPB.CrossBidProxyCopyFileToOtherBidMsgReq)paramObject);
      continue;
      localReqMsgBody.CrossBidProxyOfflineFileGetListMsgReq_body.set((WeiyunPB.CrossBidProxyOfflineFileGetListMsgReq)paramObject);
      continue;
      localReqMsgBody.QqSdkFileUploadMsgReq_body.set((WeiyunPB.QqSdkFileUploadMsgReq)paramObject);
      continue;
      localReqMsgBody.AioPicAndVideoCopyToWeiyunMsgReq_body.set((WeiyunPB.AioPicAndVideoCopyToWeiyunMsgReq)paramObject);
      continue;
      localReqMsgBody.WeiyunTrialCouponUseMsgReq_body.set((WeiyunPB.WeiyunTrialCouponUseMsgReq)paramObject);
    }
  }
  
  public static void b(Context paramContext, boolean paramBoolean)
  {
    boolean bool = true;
    a[3].set(true);
    AtomicBoolean localAtomicBoolean = a[1];
    if (!paramBoolean) {}
    for (;;)
    {
      if (localAtomicBoolean.compareAndSet(bool, paramBoolean)) {
        PreferenceUtils.a(paramContext, String.valueOf(BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin()), "key_pwd_has", Boolean.toString(paramBoolean));
      }
      return;
      bool = false;
    }
  }
  
  public static void b(String paramString, IWeiyunCallback paramIWeiyunCallback)
  {
    WeiyunPB.PwdVerifyMsgReq localPwdVerifyMsgReq = new WeiyunPB.PwdVerifyMsgReq();
    localPwdVerifyMsgReq.cs_sig.set(StringUtils.a(paramString));
    a(localPwdVerifyMsgReq, paramIWeiyunCallback);
  }
  
  public static void c(Context paramContext, boolean paramBoolean)
  {
    boolean bool = true;
    a[3].set(true);
    AtomicBoolean localAtomicBoolean = a[2];
    if (!paramBoolean) {}
    for (;;)
    {
      if (localAtomicBoolean.compareAndSet(bool, paramBoolean)) {
        PreferenceUtils.a(paramContext, String.valueOf(BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin()), "key_pwd_verified", Boolean.toString(paramBoolean));
      }
      return;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.weiyun.sdk.api.WeiyunApi
 * JD-Core Version:    0.7.0.1
 */