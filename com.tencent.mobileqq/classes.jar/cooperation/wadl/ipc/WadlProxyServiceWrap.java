package cooperation.wadl.ipc;

import android.text.TextUtils;
import com.tencent.gamecenter.appointment.GameCenterBroadcastReceiver;
import com.tencent.gamecenter.appointment.GameCenterUtils;
import com.tencent.gamecenter.wadl.api.IQQGameDownloadService;
import com.tencent.gamecenter.wadl.api.IQQGameNetService;
import com.tencent.gamecenter.wadl.api.IQQGameTrpcService;
import com.tencent.gamecenter.wadl.biz.entity.WadlParams;
import com.tencent.gamecenter.wadl.biz.listener.WadlProxyServiceCallBackInterface;
import com.tencent.gamecenter.wadl.biz.listener.WadlResCallBack;
import com.tencent.gamecenter.wadl.util.WLog;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class WadlProxyServiceWrap
{
  protected WadlProxyServiceWrap()
  {
    WLog.c("WadlProxyServiceWrap", "WadlProxyServiceWrap new instance");
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("WadlProxyServiceWrap", 1, "doQueryAllTask");
    }
    ((IQQGameDownloadService)QRoute.api(IQQGameDownloadService.class)).doQueryAllTask();
  }
  
  public void a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WadlProxyServiceWrap", 1, "doPauseAction from=" + paramInt + ",appId=" + paramString);
    }
    ((IQQGameDownloadService)QRoute.api(IQQGameDownloadService.class)).doPauseAction(paramInt, paramString);
  }
  
  public void a(WadlParams paramWadlParams)
  {
    WLog.c("WadlProxyServiceWrap", "dispatchAction wadlParams=" + paramWadlParams);
    switch (paramWadlParams.jdField_b_of_type_Int)
    {
    case 6: 
    case 7: 
    case 8: 
    case 9: 
    case 11: 
    default: 
    case 2: 
    case 12: 
      do
      {
        return;
        if ((paramWadlParams.jdField_a_of_type_Boolean) || (!paramWadlParams.jdField_b_of_type_Boolean)) {
          break;
        }
      } while (TextUtils.isEmpty(paramWadlParams.q));
      GameCenterUtils.b(paramWadlParams.jdField_a_of_type_JavaLangString, "DELAY_LIST");
      GameCenterUtils.a(paramWadlParams.jdField_a_of_type_JavaLangString, paramWadlParams.q, "DELAY_APPID_DETAIL_");
      GameCenterBroadcastReceiver.a();
      return;
      b(paramWadlParams);
      return;
    case 3: 
    case 10: 
      a(paramWadlParams.d, paramWadlParams.jdField_a_of_type_JavaLangString);
      return;
    case 4: 
      b(paramWadlParams.d, paramWadlParams.jdField_a_of_type_JavaLangString);
      return;
    }
    c(paramWadlParams);
  }
  
  public void a(WadlProxyServiceCallBackInterface paramWadlProxyServiceCallBackInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WadlProxyServiceWrap", 1, "registerWadlServiceCallBack callback=" + paramWadlProxyServiceCallBackInterface);
    }
    ((IQQGameDownloadService)QRoute.api(IQQGameDownloadService.class)).registerWadlServiceCallBack(paramWadlProxyServiceCallBackInterface);
  }
  
  public void a(WadlResCallBack paramWadlResCallBack)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WadlProxyServiceWrap", 1, "registerResCallBack callback=" + paramWadlResCallBack);
    }
    ((IQQGameDownloadService)QRoute.api(IQQGameDownloadService.class)).registerResCallBack(paramWadlResCallBack);
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WadlProxyServiceWrap", 1, "doQueryActionByVia via=" + paramString);
    }
    ((IQQGameDownloadService)QRoute.api(IQQGameDownloadService.class)).doQueryActionByVia(paramString);
  }
  
  public void a(ArrayList<String> paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WadlProxyServiceWrap", 1, "doQueryAction apps=" + paramArrayList);
    }
    ((IQQGameDownloadService)QRoute.api(IQQGameDownloadService.class)).doQueryAction(paramArrayList);
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("WadlProxyServiceWrap", 1, "doQueryAllRes");
    }
    ((IQQGameDownloadService)QRoute.api(IQQGameDownloadService.class)).doQueryAllRes();
  }
  
  public void b(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WadlProxyServiceWrap", 1, "doResumeAction from=" + paramInt + ",appId=" + paramString);
    }
    ((IQQGameDownloadService)QRoute.api(IQQGameDownloadService.class)).doResumeAction(paramInt, paramString);
  }
  
  public void b(WadlParams paramWadlParams)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WadlProxyServiceWrap", 1, "doDownloadAction wadlParams=" + paramWadlParams);
    }
    if (paramWadlParams == null) {
      return;
    }
    if (!paramWadlParams.jdField_a_of_type_Boolean)
    {
      if (TextUtils.isEmpty(paramWadlParams.c)) {
        paramWadlParams.c = "10000144";
      }
      if (TextUtils.isEmpty(paramWadlParams.p)) {
        paramWadlParams.p = "biz_src_zf_games";
      }
      if (TextUtils.isEmpty(paramWadlParams.j)) {
        paramWadlParams.j = paramWadlParams.f;
      }
      GameCenterUtils.a(paramWadlParams.jdField_a_of_type_JavaLangString, "DELAY_LIST");
      GameCenterUtils.c(paramWadlParams.jdField_a_of_type_JavaLangString, "DELAY_APPID_DETAIL_");
      if ((paramWadlParams.d == 1) || (paramWadlParams.d == 2))
      {
        paramWadlParams.b(8);
        if (paramWadlParams.d == 1) {
          paramWadlParams.b(4);
        }
      }
    }
    while (TextUtils.isEmpty(paramWadlParams.e))
    {
      GameCenterUtils.a(null, "558", "202982", paramWadlParams.jdField_a_of_type_JavaLangString, "55801", "4", "430");
      WLog.c("WadlProxyServiceWrap", "invalid url:" + paramWadlParams);
      return;
      paramWadlParams.a(1);
    }
    ((IQQGameDownloadService)QRoute.api(IQQGameDownloadService.class)).doDownloadAction(paramWadlParams);
  }
  
  public void b(WadlProxyServiceCallBackInterface paramWadlProxyServiceCallBackInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WadlProxyServiceWrap", 1, "unRegisterWadlServiceCallBack callback=" + paramWadlProxyServiceCallBackInterface);
    }
    ((IQQGameDownloadService)QRoute.api(IQQGameDownloadService.class)).unRegisterWadlServiceCallBack(paramWadlProxyServiceCallBackInterface);
  }
  
  public void b(WadlResCallBack paramWadlResCallBack)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WadlProxyServiceWrap", 1, "registerResCallBack callback=" + paramWadlResCallBack);
    }
    ((IQQGameDownloadService)QRoute.api(IQQGameDownloadService.class)).unRegisterResCallBack(paramWadlResCallBack);
  }
  
  public void b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WadlProxyServiceWrap", 1, "doPauseResAction resId=" + paramString);
    }
    ((IQQGameDownloadService)QRoute.api(IQQGameDownloadService.class)).doPauseResAction(paramString);
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("WadlProxyServiceWrap", 1, "destroy");
    }
    ((IQQGameNetService)QRoute.api(IQQGameNetService.class)).destroy();
    ((IQQGameTrpcService)QRoute.api(IQQGameTrpcService.class)).destroy();
    ((IQQGameDownloadService)QRoute.api(IQQGameDownloadService.class)).release();
  }
  
  public void c(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WadlProxyServiceWrap", 1, "deleteDownload from=" + paramInt + ",appId=" + paramString);
    }
    ((IQQGameDownloadService)QRoute.api(IQQGameDownloadService.class)).deleteDownload(paramInt, paramString);
  }
  
  public void c(WadlParams paramWadlParams)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WadlProxyServiceWrap", 1, "doInstallAction wadlParams=" + paramWadlParams);
    }
    if (paramWadlParams == null) {
      return;
    }
    if (TextUtils.isEmpty(paramWadlParams.p)) {
      paramWadlParams.p = "biz_src_zf_games";
    }
    ((IQQGameDownloadService)QRoute.api(IQQGameDownloadService.class)).doInstallAction(paramWadlParams);
  }
  
  public void c(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WadlProxyServiceWrap", 1, "doResumeResAction resId=" + paramString);
    }
    ((IQQGameDownloadService)QRoute.api(IQQGameDownloadService.class)).doResumeResAction(paramString);
  }
  
  public void d(WadlParams paramWadlParams)
  {
    WLog.c("WadlProxyServiceWrap", "dispatchResAction wadlParams=" + paramWadlParams);
    switch (paramWadlParams.jdField_b_of_type_Int)
    {
    case 5: 
    case 6: 
    case 7: 
    case 8: 
    case 9: 
    default: 
      return;
    case 2: 
      b(paramWadlParams);
      return;
    case 3: 
      b(paramWadlParams.a());
      return;
    case 4: 
      c(paramWadlParams.a());
      return;
    }
    d(paramWadlParams.a());
  }
  
  public void d(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WadlProxyServiceWrap", 1, "deleteResDownload resId=" + paramString);
    }
    ((IQQGameDownloadService)QRoute.api(IQQGameDownloadService.class)).deleteResDownload(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.wadl.ipc.WadlProxyServiceWrap
 * JD-Core Version:    0.7.0.1
 */