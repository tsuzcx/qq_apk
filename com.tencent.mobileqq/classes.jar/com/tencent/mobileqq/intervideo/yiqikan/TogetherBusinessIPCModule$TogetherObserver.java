package com.tencent.mobileqq.intervideo.yiqikan;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.together.TogetherUtils;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import mqq.observer.BusinessObserver;
import mqq.util.WeakReference;

public class TogetherBusinessIPCModule$TogetherObserver
  implements BusinessObserver
{
  private int jdField_a_of_type_Int;
  private WeakReference<QIPCModule> jdField_a_of_type_MqqUtilWeakReference;
  
  public TogetherBusinessIPCModule$TogetherObserver(QIPCModule paramQIPCModule, int paramInt)
  {
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramQIPCModule);
    this.jdField_a_of_type_Int = paramInt;
  }
  
  private void a(Bundle paramBundle, TogetherBusinessServlet.RspOpenStart paramRspOpenStart)
  {
    if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface))
    {
      if (QLog.isColorLevel()) {
        QLog.d("TogetherObserver", 2, "handleStartPackage TogetherControlManager");
      }
      int i = paramBundle.getInt("session_type", -1);
      long l = paramBundle.getLong("uin", -1L);
      int j = paramBundle.getInt("business_type", 0);
      String str = paramBundle.getString("appid", "");
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if (j == 2)
      {
        if (i == 2) {
          paramBundle = "c2c_AIO";
        } else {
          paramBundle = "Grp_AIO";
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(l);
        localStringBuilder.append("");
        ReportController.b(localQQAppInterface, "dc00899", paramBundle, "", "video_tab", "clk_share_suc", 0, 0, localStringBuilder.toString(), str, "", "");
      }
      TogetherUtils.a(localQQAppInterface, paramRspOpenStart.jumpType, paramRspOpenStart.jumpUrl, null, new Bundle(), i);
    }
  }
  
  private boolean a(TogetherBusinessServlet.RspOpenStart paramRspOpenStart)
  {
    if ((paramRspOpenStart.resultInfo != null) && (paramRspOpenStart.resultInfo.showErrorMsg) && (!TextUtils.isEmpty(paramRspOpenStart.resultInfo.errorMsg))) {
      return false;
    }
    return ((paramRspOpenStart.jumpType == 1) || (paramRspOpenStart.jumpType == 2)) && (!TextUtils.isEmpty(paramRspOpenStart.jumpUrl));
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("type:");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(" isSuccess:");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("TogetherObserver", 2, ((StringBuilder)localObject).toString());
    }
    if (this.jdField_a_of_type_MqqUtilWeakReference.get() == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TogetherObserver", 2, " mRef is empty");
      }
      return;
    }
    Object localObject = (QIPCModule)this.jdField_a_of_type_MqqUtilWeakReference.get();
    if ((12 == paramInt) && (paramBoolean))
    {
      ((QIPCModule)localObject).callbackResult(this.jdField_a_of_type_Int, EIPCResult.createResult(0, paramBundle));
      return;
    }
    if ((13 == paramInt) && (paramBoolean))
    {
      ((QIPCModule)localObject).callbackResult(this.jdField_a_of_type_Int, EIPCResult.createResult(0, paramBundle));
      localObject = (TogetherBusinessServlet.RspOpenStart)paramBundle.getSerializable("QQAIOMediaSvc.open_start");
      paramBundle = paramBundle.getBundle("bundle");
      if ((paramBundle != null) && (localObject != null))
      {
        if (a((TogetherBusinessServlet.RspOpenStart)localObject))
        {
          if (QLog.isColorLevel()) {
            QLog.d("TogetherObserver", 2, "handleStartPackage jumpToTogetherBusiness");
          }
          a(paramBundle, (TogetherBusinessServlet.RspOpenStart)localObject);
        }
      }
      else if (QLog.isColorLevel()) {
        QLog.d("TogetherObserver", 2, "bundleExtra is null or rspOpenStart is null");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.yiqikan.TogetherBusinessIPCModule.TogetherObserver
 * JD-Core Version:    0.7.0.1
 */