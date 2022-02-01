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
  private Context jdField_a_of_type_AndroidContentContext;
  public Bundle a;
  TransProcessorHandler jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler = new KingsMomentVideoDeliverController.1(this);
  TransferRequest jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest;
  private WeakReference<KandianVideoUploadController.DeliverVideoTaskListener> jdField_a_of_type_JavaLangRefWeakReference;
  private QQAppInterface jdField_b_of_type_ComTencentMobileqqAppQQAppInterface;
  private WeakReference<Context> jdField_b_of_type_JavaLangRefWeakReference;
  private String d;
  private String e;
  private String f;
  private String g;
  private String h;
  
  public KingsMomentVideoDeliverController(Context paramContext, KandianVideoUploadController.DeliverVideoTaskListener paramDeliverVideoTaskListener, Intent paramIntent)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramDeliverVideoTaskListener);
    this.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(paramContext);
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)ReadInJoyUtils.a());
    this.jdField_a_of_type_AndroidOsBundle = paramIntent.getExtras();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    c();
    KanDianVideoUploadUtils.a(this.jdField_a_of_type_AndroidOsBundle);
  }
  
  private void a(float paramFloat)
  {
    this.jdField_a_of_type_Float = paramFloat;
    WeakReference localWeakReference = this.jdField_a_of_type_JavaLangRefWeakReference;
    if ((localWeakReference != null) && (localWeakReference.get() != null)) {
      ((KandianVideoUploadController.DeliverVideoTaskListener)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a(this.jdField_a_of_type_JavaLangString, paramFloat);
    }
  }
  
  private void a(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    paramString1 = VideoMetaInfo.a().a(paramString1).b(paramString2).d(paramString4).c(paramString3).e(paramString5).a();
    if (paramInt == 0) {
      a(true, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidOsBundle, paramString1, (KandianVideoUploadController.DeliverVideoTaskListener)this.jdField_a_of_type_JavaLangRefWeakReference.get());
    }
    paramString2 = this.jdField_a_of_type_JavaLangRefWeakReference;
    if ((paramString2 != null) && (paramString2.get() != null)) {
      ((KandianVideoUploadController.DeliverVideoTaskListener)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a(this.jdField_a_of_type_JavaLangString, paramInt, paramString1);
    }
  }
  
  private void b(int paramInt)
  {
    a(paramInt, null, null, null, null, null);
  }
  
  private void c()
  {
    this.g = this.jdField_a_of_type_AndroidOsBundle.getString("arg_video_path");
    this.h = this.jdField_a_of_type_AndroidOsBundle.getString("arg_video_cover");
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidOsBundle.getString("mTaskID");
  }
  
  private void c(int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_FailCode", String.valueOf(paramInt));
    long l1 = NetConnInfoCenter.getServerTimeMillis();
    long l2 = this.jdField_a_of_type_Long;
    StatisticCollector localStatisticCollector = StatisticCollector.getInstance((Context)this.jdField_b_of_type_JavaLangRefWeakReference.get());
    String str = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
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
    a(this.h);
    this.jdField_a_of_type_Long = NetConnInfoCenter.getServerTimeMillis();
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
    if (!NetworkUtil.a((Context)this.jdField_b_of_type_JavaLangRefWeakReference.get()))
    {
      b(1003);
      return;
    }
    this.d = "";
    this.jdField_e_of_type_JavaLangString = "";
    this.f = "";
    localObject = new CompressInfo(paramString, 0);
    ((CompressInfo)localObject).f = 0;
    if (!((ICompressOperator)QRoute.api(ICompressOperator.class)).start((CompressInfo)localObject)) {
      c(1001);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("startUploadPic compressPath=");
    localStringBuilder.append(((CompressInfo)localObject).jdField_e_of_type_JavaLangString);
    localStringBuilder.append(", originPath=");
    localStringBuilder.append(paramString);
    localStringBuilder.append(", outWidth=");
    localStringBuilder.append(((CompressInfo)localObject).d);
    localStringBuilder.append(", outHeight=");
    localStringBuilder.append(((CompressInfo)localObject).jdField_e_of_type_Int);
    QLog.d("KingsMomentVideoDeliveControllerr", 1, localStringBuilder.toString());
    if (!TextUtils.isEmpty(((CompressInfo)localObject).jdField_e_of_type_JavaLangString)) {
      paramString = ((CompressInfo)localObject).jdField_e_of_type_JavaLangString;
    }
    this.d = paramString;
    paramString = (ITransFileController)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITransFileController.class);
    this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler.addFilter(new Class[] { BDHCommonUploadProcessor.class });
    paramString.addHandle(this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler);
    this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest = new TransferRequest();
    localObject = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest;
    ((TransferRequest)localObject).mIsUp = true;
    ((TransferRequest)localObject).mCommandId = 10;
    ((TransferRequest)localObject).mLocalPath = this.d;
    ((TransferRequest)localObject).mUniseq = (System.currentTimeMillis() + (Math.random() * 10000.0D));
    localObject = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest;
    ((TransferRequest)localObject).mPeerUin = "0";
    ((TransferRequest)localObject).mFileType = 24;
    ((TransferRequest)localObject).mRichTag = "KandianUGCPicUpload";
    paramString.transferAsync((TransferRequest)localObject);
  }
  
  public void b()
  {
    KanDianVideoUploadUtils.a(this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.video.transfer.KingsMomentVideoDeliverController
 * JD-Core Version:    0.7.0.1
 */