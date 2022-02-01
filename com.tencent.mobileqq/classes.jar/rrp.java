import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.common.util.NetworkUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.BDHCommonUploadProcessor;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.HashMap;

public class rrp
  extends rgt
{
  private Context jdField_a_of_type_AndroidContentContext;
  public Bundle a;
  TransProcessorHandler jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler = new rrq(this);
  TransferRequest jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest;
  private WeakReference<rgv> jdField_a_of_type_JavaLangRefWeakReference;
  private QQAppInterface jdField_b_of_type_ComTencentMobileqqAppQQAppInterface;
  private WeakReference<Context> jdField_b_of_type_JavaLangRefWeakReference;
  private String d;
  private String e;
  private String f;
  private String g;
  private String h;
  
  public rrp(Context paramContext, rgv paramrgv, Intent paramIntent)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramrgv);
    this.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(paramContext);
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)pay.a());
    this.jdField_a_of_type_AndroidOsBundle = paramIntent.getExtras();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    c();
    rgs.a(this.jdField_a_of_type_AndroidOsBundle);
  }
  
  private void a(float paramFloat)
  {
    this.jdField_a_of_type_Float = paramFloat;
    if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)) {
      ((rgv)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a(this.jdField_a_of_type_JavaLangString, paramFloat);
    }
  }
  
  private void a(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    paramString1 = rri.a().a(paramString1).b(paramString2).d(paramString4).c(paramString3).e(paramString5).a();
    if (paramInt == 0) {
      a(true, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidOsBundle, paramString1, (rgv)this.jdField_a_of_type_JavaLangRefWeakReference.get());
    }
    if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)) {
      ((rgv)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a(this.jdField_a_of_type_JavaLangString, paramInt, paramString1);
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
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      localStatisticCollector.collectPerformance(str, "actReadInJoyUGCVideo", bool, l1 - l2, 0L, localHashMap, "");
      return;
    }
  }
  
  public void a()
  {
    a(this.h);
    this.jdField_a_of_type_Long = NetConnInfoCenter.getServerTimeMillis();
  }
  
  public void a(String paramString)
  {
    QLog.d("KingsMomentVideoDeliveControllerr", 1, "startUploadPic path=" + paramString);
    if (TextUtils.isEmpty(paramString))
    {
      QLog.d("KingsMomentVideoDeliveControllerr", 1, "startUploadPic empty path!");
      b(10);
      return;
    }
    if (!new File(paramString).exists())
    {
      QLog.d("KingsMomentVideoDeliveControllerr", 1, "startUploadPic file not exist, path=" + paramString);
      b(5);
      return;
    }
    if (!NetworkUtil.isNetworkAvailable((Context)this.jdField_b_of_type_JavaLangRefWeakReference.get()))
    {
      b(1003);
      return;
    }
    this.d = "";
    this.jdField_e_of_type_JavaLangString = "";
    this.f = "";
    CompressInfo localCompressInfo = new CompressInfo(paramString, 0);
    localCompressInfo.f = 0;
    if (!ayeu.a(localCompressInfo)) {
      c(1001);
    }
    QLog.d("KingsMomentVideoDeliveControllerr", 1, "startUploadPic compressPath=" + localCompressInfo.jdField_e_of_type_JavaLangString + ", originPath=" + paramString + ", outWidth=" + localCompressInfo.d + ", outHeight=" + localCompressInfo.jdField_e_of_type_Int);
    if (TextUtils.isEmpty(localCompressInfo.jdField_e_of_type_JavaLangString)) {}
    for (;;)
    {
      this.d = paramString;
      paramString = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getTransFileController();
      this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler.addFilter(new Class[] { BDHCommonUploadProcessor.class });
      paramString.addHandle(this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler);
      this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest = new TransferRequest();
      this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.mIsUp = true;
      this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.mCommandId = 10;
      this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.mLocalPath = this.d;
      this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.mUniseq = (System.currentTimeMillis() + (Math.random() * 10000.0D));
      this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.mPeerUin = "0";
      this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.mFileType = 24;
      this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.mRichTag = "KandianUGCPicUpload";
      paramString.transferAsync(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest);
      return;
      paramString = localCompressInfo.jdField_e_of_type_JavaLangString;
    }
  }
  
  public void b()
  {
    rgs.a(this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rrp
 * JD-Core Version:    0.7.0.1
 */