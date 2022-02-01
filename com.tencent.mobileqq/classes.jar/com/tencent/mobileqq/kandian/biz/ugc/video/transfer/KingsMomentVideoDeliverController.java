package com.tencent.mobileqq.kandian.biz.ugc.video.transfer;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.common.util.NetworkUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.ugc.KanDianVideoUploadUtils;
import com.tencent.mobileqq.kandian.biz.ugc.KandianVideoUploadController;
import com.tencent.mobileqq.kandian.biz.ugc.KandianVideoUploadController.DeliverVideoTaskListener;
import com.tencent.mobileqq.kandian.biz.ugc.video.VideoMetaInfo;
import com.tencent.mobileqq.kandian.biz.ugc.video.VideoMetaInfo.Builder;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.pic.api.ICompressOperator;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.BDHCommonUploadProcessor;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.HashMap;

public class KingsMomentVideoDeliverController
  extends KandianVideoUploadController
{
  public Bundle o;
  TransferRequest p;
  TransProcessorHandler q = new KingsMomentVideoDeliverController.1(this);
  private WeakReference<KandianVideoUploadController.DeliverVideoTaskListener> r;
  private WeakReference<Context> s;
  private QQAppInterface t;
  private String u;
  private String v;
  private String w;
  private String x;
  private String y;
  private Context z;
  
  public KingsMomentVideoDeliverController(Context paramContext, KandianVideoUploadController.DeliverVideoTaskListener paramDeliverVideoTaskListener, Intent paramIntent)
  {
    this.r = new WeakReference(paramDeliverVideoTaskListener);
    this.s = new WeakReference(paramContext);
    this.t = ((QQAppInterface)ReadInJoyUtils.b());
    this.o = paramIntent.getExtras();
    this.z = paramContext;
    c();
    KanDianVideoUploadUtils.a(this.o);
  }
  
  private void a(float paramFloat)
  {
    this.h = paramFloat;
    WeakReference localWeakReference = this.r;
    if ((localWeakReference != null) && (localWeakReference.get() != null)) {
      ((KandianVideoUploadController.DeliverVideoTaskListener)this.r.get()).a(this.g, paramFloat);
    }
  }
  
  private void a(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    paramString1 = VideoMetaInfo.a().a(paramString1).b(paramString2).d(paramString4).c(paramString3).e(paramString5).a();
    if (paramInt == 0) {
      a(true, this.z, this.o, paramString1, (KandianVideoUploadController.DeliverVideoTaskListener)this.r.get());
    }
    paramString2 = this.r;
    if ((paramString2 != null) && (paramString2.get() != null)) {
      ((KandianVideoUploadController.DeliverVideoTaskListener)this.r.get()).a(this.g, paramInt, paramString1);
    }
  }
  
  private void b(int paramInt)
  {
    a(paramInt, null, null, null, null, null);
  }
  
  private void c()
  {
    this.x = this.o.getString("arg_video_path");
    this.y = this.o.getString("arg_video_cover");
    this.g = this.o.getString("mTaskID");
  }
  
  private void c(int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_FailCode", String.valueOf(paramInt));
    long l1 = NetConnInfoCenter.getServerTimeMillis();
    long l2 = this.m;
    StatisticCollector localStatisticCollector = StatisticCollector.getInstance((Context)this.s.get());
    String str = this.t.getCurrentAccountUin();
    boolean bool;
    if (paramInt == 0) {
      bool = true;
    } else {
      bool = false;
    }
    localStatisticCollector.collectPerformance(str, "actReadInJoyUGCVideo", bool, l1 - l2, 0L, localHashMap, "");
  }
  
  public void a()
  {
    a(this.y);
    this.m = NetConnInfoCenter.getServerTimeMillis();
  }
  
  public void a(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("startUploadPic path=");
    ((StringBuilder)localObject).append(paramString);
    QLog.d("KingsMomentVideoDeliveControllerr", 1, ((StringBuilder)localObject).toString());
    if (TextUtils.isEmpty(paramString))
    {
      QLog.d("KingsMomentVideoDeliveControllerr", 1, "startUploadPic empty path!");
      b(10);
      return;
    }
    if (!new File(paramString).exists())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("startUploadPic file not exist, path=");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("KingsMomentVideoDeliveControllerr", 1, ((StringBuilder)localObject).toString());
      b(5);
      return;
    }
    if (!NetworkUtil.a((Context)this.s.get()))
    {
      b(1003);
      return;
    }
    this.u = "";
    this.v = "";
    this.w = "";
    localObject = new CompressInfo(paramString, 0);
    ((CompressInfo)localObject).o = 0;
    if (!((ICompressOperator)QRoute.api(ICompressOperator.class)).start((CompressInfo)localObject)) {
      c(1001);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("startUploadPic compressPath=");
    localStringBuilder.append(((CompressInfo)localObject).l);
    localStringBuilder.append(", originPath=");
    localStringBuilder.append(paramString);
    localStringBuilder.append(", outWidth=");
    localStringBuilder.append(((CompressInfo)localObject).m);
    localStringBuilder.append(", outHeight=");
    localStringBuilder.append(((CompressInfo)localObject).n);
    QLog.d("KingsMomentVideoDeliveControllerr", 1, localStringBuilder.toString());
    if (!TextUtils.isEmpty(((CompressInfo)localObject).l)) {
      paramString = ((CompressInfo)localObject).l;
    }
    this.u = paramString;
    paramString = (ITransFileController)this.t.getRuntimeService(ITransFileController.class);
    this.q.addFilter(new Class[] { BDHCommonUploadProcessor.class });
    paramString.addHandle(this.q);
    this.p = new TransferRequest();
    localObject = this.p;
    ((TransferRequest)localObject).mIsUp = true;
    ((TransferRequest)localObject).mCommandId = 10;
    ((TransferRequest)localObject).mLocalPath = this.u;
    ((TransferRequest)localObject).mUniseq = (System.currentTimeMillis() + (Math.random() * 10000.0D));
    localObject = this.p;
    ((TransferRequest)localObject).mPeerUin = "0";
    ((TransferRequest)localObject).mFileType = 24;
    ((TransferRequest)localObject).mRichTag = "KandianUGCPicUpload";
    paramString.transferAsync((TransferRequest)localObject);
  }
  
  public void b()
  {
    KanDianVideoUploadUtils.a(this.u);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.video.transfer.KingsMomentVideoDeliverController
 * JD-Core Version:    0.7.0.1
 */