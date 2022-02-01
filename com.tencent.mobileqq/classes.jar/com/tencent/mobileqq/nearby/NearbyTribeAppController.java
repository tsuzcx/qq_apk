package com.tencent.mobileqq.nearby;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.activity.TroopBarPublishUtils;
import com.tencent.mobileqq.uniformdownload.api.IUniformDownloadUtil;
import com.tencent.mobileqq.uniformdownload.util.IUniformDownloaderListener;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.PackageUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.Random;

public class NearbyTribeAppController
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler;
  protected QQAppInterface a;
  private IUniformDownloaderListener jdField_a_of_type_ComTencentMobileqqUniformdownloadUtilIUniformDownloaderListener = new NearbyTribeAppController.3(this);
  private String jdField_a_of_type_JavaLangString = "NearbyTribeAppController";
  private boolean jdField_a_of_type_Boolean;
  private String[] jdField_a_of_type_ArrayOfJavaLangString = { HardCodeUtil.a(2131707425), HardCodeUtil.a(2131707424), "好看的人都在用兴趣部落APP", HardCodeUtil.a(2131707423), HardCodeUtil.a(2131707421), "看看好友在兴趣部落APP玩什么？" };
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean = true;
  private String[] jdField_b_of_type_ArrayOfJavaLangString = { HardCodeUtil.a(2131707414), HardCodeUtil.a(2131707417), "好看的人都在用兴趣部落APP", HardCodeUtil.a(2131707420), HardCodeUtil.a(2131707419) };
  
  public NearbyTribeAppController(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public void a()
  {
    Context localContext;
    if (!NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_AndroidContentContext))
    {
      localContext = this.jdField_a_of_type_AndroidContentContext;
      QQToast.a(localContext, 1, localContext.getString(2131694425), 0).a();
      return;
    }
    if (!"0".equals(PackageUtil.a(this.jdField_a_of_type_AndroidContentContext, "com.tencent.tribe")))
    {
      localContext = this.jdField_a_of_type_AndroidContentContext;
      if ((localContext instanceof Activity))
      {
        TroopBarPublishUtils.a((Activity)localContext);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_tribe", "", "user_profile", "Clk_app_call", 0, 0, String.valueOf(this.jdField_a_of_type_Int), "", "", "");
      }
      return;
    }
    if (!this.jdField_b_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "invokeTribeOpenOrDownload,isActivate=false");
      }
      return;
    }
    ThreadManager.post(new NearbyTribeAppController.1(this), 8, null, true);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_tribe", "", "user_profile", "Clk_app_download", 0, 0, String.valueOf(this.jdField_a_of_type_Int), "", "", "");
  }
  
  public void a(TextView paramTextView)
  {
    String str = PackageUtil.a(this.jdField_a_of_type_AndroidContentContext, "com.tencent.tribe");
    Random localRandom = new Random();
    int i;
    if (!"0".equals(str))
    {
      i = localRandom.nextInt(this.jdField_b_of_type_ArrayOfJavaLangString.length);
      this.jdField_a_of_type_Int = (i + 1);
      this.jdField_b_of_type_JavaLangString = this.jdField_b_of_type_ArrayOfJavaLangString[i];
      paramTextView.setText(this.jdField_b_of_type_JavaLangString);
      paramTextView = "exp_app_call";
    }
    else
    {
      i = localRandom.nextInt(this.jdField_a_of_type_ArrayOfJavaLangString.length);
      this.jdField_a_of_type_Int = (i + 1);
      this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ArrayOfJavaLangString[i];
      paramTextView.setText(this.jdField_b_of_type_JavaLangString);
      paramTextView = "exp_app_download";
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_tribe", "", "user_profile", paramTextView, 0, 0, String.valueOf(this.jdField_a_of_type_Int), "", "", "");
  }
  
  protected void a(String paramString)
  {
    try
    {
      this.jdField_b_of_type_Boolean = true;
      QLog.e(this.jdField_a_of_type_JavaLangString, 1, "这里已经下架，如果依然发现该log，异常case");
      ((IUniformDownloadUtil)QRoute.api(IUniformDownloadUtil.class)).getFileInfoOfUrlAsync("https://pub.idqqimg.com/pc/misc/files/20170706/c221bf304be44e5a9e0441768beacff0.apk", new NearbyTribeAppController.2(this));
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      QQToast.a(BaseApplicationImpl.getContext(), HardCodeUtil.a(2131707422), 0).b(50);
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.NearbyTribeAppController
 * JD-Core Version:    0.7.0.1
 */