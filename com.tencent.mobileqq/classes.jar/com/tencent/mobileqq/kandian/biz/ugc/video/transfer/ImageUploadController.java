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
  private long jdField_a_of_type_Long;
  TransProcessorHandler jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler;
  TransferRequest jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest;
  private Long jdField_a_of_type_JavaLangLong;
  private String jdField_a_of_type_JavaLangString;
  private long jdField_b_of_type_Long;
  private Long jdField_b_of_type_JavaLangLong;
  private String jdField_b_of_type_JavaLangString;
  private long jdField_c_of_type_Long;
  private String jdField_c_of_type_JavaLangString;
  private long jdField_d_of_type_Long;
  private String jdField_d_of_type_JavaLangString;
  
  public ImageUploadController(Context paramContext, QQAppInterface paramQQAppInterface, FileUploadController.FileUploadListener paramFileUploadListener)
  {
    super(paramContext, paramQQAppInterface, paramFileUploadListener);
    paramContext = Long.valueOf(0L);
    this.jdField_a_of_type_JavaLangLong = paramContext;
    this.jdField_b_of_type_JavaLangLong = paramContext;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_c_of_type_Long = 0L;
    this.jdField_d_of_type_Long = 0L;
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_c_of_type_JavaLangString = null;
    this.jdField_d_of_type_JavaLangString = null;
    this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler = new ImageUploadController.1(this);
  }
  
  private void a(int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_FailCode", String.valueOf(paramInt));
    long l1 = this.jdField_b_of_type_Long;
    long l2 = this.jdField_a_of_type_Long;
    StatisticCollector localStatisticCollector = StatisticCollector.getInstance(this.jdField_a_of_type_AndroidContentContext);
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
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
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcVideoTransferFileUploadController$FileUploadListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcVideoTransferFileUploadController$FileUploadListener.a(paramInt, paramString1, paramString2, paramString3);
    }
  }
  
  private void b(int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_FailCode", String.valueOf(paramInt));
    localHashMap.put("cover_size_before_compression", this.jdField_a_of_type_JavaLangLong.toString());
    localHashMap.put("cover_size_after_compression", this.jdField_b_of_type_JavaLangLong.toString());
    StatisticCollector localStatisticCollector = StatisticCollector.getInstance(this.jdField_a_of_type_AndroidContentContext);
    String str = RIJQQAppInterfaceUtil.a();
    boolean bool;
    if (paramInt == 0) {
      bool = true;
    } else {
      bool = false;
    }
    localStatisticCollector.collectPerformance(str, "actReadInJoyDeliverVideoCompressCover", bool, this.jdField_b_of_type_Long - this.jdField_a_of_type_Long, 0L, localHashMap, "");
  }
  
  private void c(int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_FailCode", String.valueOf(paramInt));
    StatisticCollector localStatisticCollector = StatisticCollector.getInstance(this.jdField_a_of_type_AndroidContentContext);
    String str = RIJQQAppInterfaceUtil.a();
    boolean bool;
    if (paramInt == 0) {
      bool = true;
    } else {
      bool = false;
    }
    localStatisticCollector.collectPerformance(str, "actReadInJoyDeliverVideoUploadCover", bool, this.jdField_c_of_type_Long - this.jdField_d_of_type_Long, 0L, localHashMap, "");
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
    this.jdField_d_of_type_JavaLangString = paramString;
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
    this.jdField_a_of_type_JavaLangLong = Long.valueOf(((File)localObject).length());
    if (!NetworkUtil.a(this.jdField_a_of_type_AndroidContentContext))
    {
      a(1003, null, null, null);
      return;
    }
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    localObject = new CompressInfo(paramString, paramInt);
    ((CompressInfo)localObject).f = 0;
    if (!((ICompressOperator)QRoute.api(ICompressOperator.class)).start((CompressInfo)localObject)) {
      a(1001);
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("startUploadPic compressPath=");
      localStringBuilder.append(((CompressInfo)localObject).jdField_e_of_type_JavaLangString);
      localStringBuilder.append(", originPath=");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", outWidth=");
      localStringBuilder.append(((CompressInfo)localObject).d);
      localStringBuilder.append(", outHeight=");
      localStringBuilder.append(((CompressInfo)localObject).jdField_e_of_type_Int);
      QLog.d("ImageUploadController", 2, localStringBuilder.toString());
    }
    if (!TextUtils.isEmpty(((CompressInfo)localObject).jdField_e_of_type_JavaLangString)) {
      paramString = ((CompressInfo)localObject).jdField_e_of_type_JavaLangString;
    }
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_b_of_type_JavaLangLong = Long.valueOf(new File(this.jdField_a_of_type_JavaLangString).length());
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    paramString = (ITransFileController)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITransFileController.class);
    this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler.addFilter(new Class[] { BDHCommonUploadProcessor.class });
    paramString.addHandle(this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler);
    this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest = new TransferRequest();
    localObject = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest;
    ((TransferRequest)localObject).mIsUp = true;
    ((TransferRequest)localObject).mCommandId = 10;
    ((TransferRequest)localObject).mLocalPath = this.jdField_a_of_type_JavaLangString;
    ((TransferRequest)localObject).mUniseq = (System.currentTimeMillis() + (Math.random() * 10000.0D));
    localObject = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest;
    ((TransferRequest)localObject).mPeerUin = "0";
    ((TransferRequest)localObject).mFileType = 24;
    ((TransferRequest)localObject).mRichTag = "KandianUGCPicUpload";
    paramString.transferAsync((TransferRequest)localObject);
  }
  
  public void b()
  {
    ((ITransFileController)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITransFileController.class)).removeHandle(this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler);
    if ((!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (!this.jdField_d_of_type_JavaLangString.equals(this.jdField_a_of_type_JavaLangString)))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("clearTempFile(image), origin:");
        ((StringBuilder)localObject).append(this.jdField_d_of_type_JavaLangString);
        ((StringBuilder)localObject).append(", compress:");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
        QLog.d("ImageUploadController", 2, ((StringBuilder)localObject).toString());
      }
      Object localObject = new File(this.jdField_a_of_type_JavaLangString);
      if (((File)localObject).exists()) {
        ((File)localObject).delete();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.video.transfer.ImageUploadController
 * JD-Core Version:    0.7.0.1
 */