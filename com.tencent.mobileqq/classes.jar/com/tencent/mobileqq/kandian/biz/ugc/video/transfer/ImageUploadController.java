package com.tencent.mobileqq.kandian.biz.ugc.video.transfer;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.common.util.NetworkUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
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
import java.util.HashMap;

public class ImageUploadController
  extends FileUploadController
{
  TransferRequest d;
  TransProcessorHandler e;
  private Long f;
  private Long g;
  private long h;
  private long i;
  private long j;
  private long k;
  private String l;
  private String m;
  private String n;
  private String o;
  
  public ImageUploadController(Context paramContext, QQAppInterface paramQQAppInterface, FileUploadController.FileUploadListener paramFileUploadListener)
  {
    super(paramContext, paramQQAppInterface, paramFileUploadListener);
    paramContext = Long.valueOf(0L);
    this.f = paramContext;
    this.g = paramContext;
    this.h = 0L;
    this.i = 0L;
    this.j = 0L;
    this.k = 0L;
    this.l = null;
    this.m = null;
    this.n = null;
    this.o = null;
    this.e = new ImageUploadController.1(this);
  }
  
  private void a(int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_FailCode", String.valueOf(paramInt));
    long l1 = this.i;
    long l2 = this.h;
    StatisticCollector localStatisticCollector = StatisticCollector.getInstance(this.a);
    String str = this.b.getCurrentAccountUin();
    boolean bool;
    if (paramInt == 0) {
      bool = true;
    } else {
      bool = false;
    }
    localStatisticCollector.collectPerformance(str, "actReadInJoyUGCVideo", bool, l1 - l2, 0L, localHashMap, "");
  }
  
  private void a(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    b(paramInt);
    c(paramInt);
    if (this.c != null) {
      this.c.a(paramInt, paramString1, paramString2, paramString3);
    }
  }
  
  private void b(int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_FailCode", String.valueOf(paramInt));
    localHashMap.put("cover_size_before_compression", this.f.toString());
    localHashMap.put("cover_size_after_compression", this.g.toString());
    StatisticCollector localStatisticCollector = StatisticCollector.getInstance(this.a);
    String str = RIJQQAppInterfaceUtil.d();
    boolean bool;
    if (paramInt == 0) {
      bool = true;
    } else {
      bool = false;
    }
    localStatisticCollector.collectPerformance(str, "actReadInJoyDeliverVideoCompressCover", bool, this.i - this.h, 0L, localHashMap, "");
  }
  
  private void c(int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_FailCode", String.valueOf(paramInt));
    StatisticCollector localStatisticCollector = StatisticCollector.getInstance(this.a);
    String str = RIJQQAppInterfaceUtil.d();
    boolean bool;
    if (paramInt == 0) {
      bool = true;
    } else {
      bool = false;
    }
    localStatisticCollector.collectPerformance(str, "actReadInJoyDeliverVideoUploadCover", bool, this.j - this.k, 0L, localHashMap, "");
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    a(paramString, paramBoolean, 0);
  }
  
  public void a(String paramString, boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("startUploadPic path=");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("ImageUploadController", 2, ((StringBuilder)localObject).toString());
    }
    this.o = paramString;
    if (TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ImageUploadController", 2, "startUploadPic empty path!");
      }
      a(1001, null, null, null);
      return;
    }
    Object localObject = new File(paramString);
    if (!((File)localObject).exists())
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("startUploadPic file not exist, path=");
        ((StringBuilder)localObject).append(paramString);
        QLog.d("ImageUploadController", 2, ((StringBuilder)localObject).toString());
      }
      a(1002, null, null, null);
      return;
    }
    this.f = Long.valueOf(((File)localObject).length());
    if (!NetworkUtil.a(this.a))
    {
      a(1003, null, null, null);
      return;
    }
    this.l = "";
    this.m = "";
    this.n = "";
    this.h = System.currentTimeMillis();
    localObject = new CompressInfo(paramString, paramInt);
    ((CompressInfo)localObject).o = 0;
    if (!((ICompressOperator)QRoute.api(ICompressOperator.class)).start((CompressInfo)localObject)) {
      a(1001);
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("startUploadPic compressPath=");
      localStringBuilder.append(((CompressInfo)localObject).l);
      localStringBuilder.append(", originPath=");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", outWidth=");
      localStringBuilder.append(((CompressInfo)localObject).m);
      localStringBuilder.append(", outHeight=");
      localStringBuilder.append(((CompressInfo)localObject).n);
      QLog.d("ImageUploadController", 2, localStringBuilder.toString());
    }
    if (!TextUtils.isEmpty(((CompressInfo)localObject).l)) {
      paramString = ((CompressInfo)localObject).l;
    }
    this.l = paramString;
    this.g = Long.valueOf(new File(this.l).length());
    this.i = System.currentTimeMillis();
    paramString = (ITransFileController)this.b.getRuntimeService(ITransFileController.class);
    this.e.addFilter(new Class[] { BDHCommonUploadProcessor.class });
    paramString.addHandle(this.e);
    this.d = new TransferRequest();
    localObject = this.d;
    ((TransferRequest)localObject).mIsUp = true;
    ((TransferRequest)localObject).mCommandId = 10;
    ((TransferRequest)localObject).mLocalPath = this.l;
    ((TransferRequest)localObject).mUniseq = (System.currentTimeMillis() + (Math.random() * 10000.0D));
    localObject = this.d;
    ((TransferRequest)localObject).mPeerUin = "0";
    ((TransferRequest)localObject).mFileType = 24;
    ((TransferRequest)localObject).mRichTag = "KandianUGCPicUpload";
    paramString.transferAsync((TransferRequest)localObject);
  }
  
  public void b()
  {
    ((ITransFileController)this.b.getRuntimeService(ITransFileController.class)).removeHandle(this.e);
    if ((!TextUtils.isEmpty(this.o)) && (!TextUtils.isEmpty(this.l)) && (!this.o.equals(this.l)))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("clearTempFile(image), origin:");
        ((StringBuilder)localObject).append(this.o);
        ((StringBuilder)localObject).append(", compress:");
        ((StringBuilder)localObject).append(this.l);
        QLog.d("ImageUploadController", 2, ((StringBuilder)localObject).toString());
      }
      Object localObject = new File(this.l);
      if (((File)localObject).exists()) {
        ((File)localObject).delete();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.video.transfer.ImageUploadController
 * JD-Core Version:    0.7.0.1
 */