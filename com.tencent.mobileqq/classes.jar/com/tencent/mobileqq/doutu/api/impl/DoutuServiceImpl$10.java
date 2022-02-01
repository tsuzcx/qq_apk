package com.tencent.mobileqq.doutu.api.impl;

import com.tencent.mobileqq.doutu.DuiButtonImageView;
import com.tencent.mobileqq.doutu.api.IDoutuSPUtil;
import com.tencent.mobileqq.doutu.api.IDoutuUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class DoutuServiceImpl$10
  implements INetEngineListener
{
  DoutuServiceImpl$10(DoutuServiceImpl paramDoutuServiceImpl, String paramString1, String paramString2, String paramString3) {}
  
  public void onResp(NetResp paramNetResp)
  {
    StringBuilder localStringBuilder;
    boolean bool;
    int i;
    if (paramNetResp.mResult == 0)
    {
      if (QLog.isColorLevel())
      {
        paramNetResp = new StringBuilder();
        paramNetResp.append("checkAndDownloadRes : [onDone] download finished ");
        paramNetResp.append(this.jdField_a_of_type_JavaLangString);
        QLog.d("DoutuServiceImpl", 2, paramNetResp.toString());
      }
      paramNetResp = DoutuServiceImpl.access$500(this.jdField_a_of_type_ComTencentMobileqqDoutuApiImplDoutuServiceImpl, this.b);
      if (this.c.equalsIgnoreCase(paramNetResp))
      {
        DoutuServiceImpl.access$600(this.jdField_a_of_type_ComTencentMobileqqDoutuApiImplDoutuServiceImpl, this.b);
        paramNetResp = this.jdField_a_of_type_ComTencentMobileqqDoutuApiImplDoutuServiceImpl;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(IDoutuUtils.DOUTU_ANIMA_RES_PATH);
        localStringBuilder.append("doutuResInfo");
        DoutuServiceImpl.access$700(paramNetResp, localStringBuilder.toString(), this.c);
        ((IDoutuSPUtil)QRoute.api(IDoutuSPUtil.class)).updateDoutuResDamaged(BaseApplication.getContext(), false);
        DuiButtonImageView.a();
        bool = true;
        i = 0;
      }
      else
      {
        if (QLog.isColorLevel())
        {
          paramNetResp = new StringBuilder();
          paramNetResp.append("[onDone] checkMd5 failed: ");
          paramNetResp.append(this.b);
          QLog.d("DoutuServiceImpl", 2, paramNetResp.toString());
        }
        FileUtils.deleteFile(this.b);
        bool = false;
        i = 80704;
      }
    }
    else
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("checkAndDownloadRes : [onDone] downloadFile failed: ");
        localStringBuilder.append(paramNetResp.mErrCode);
        localStringBuilder.append(", errDesc=");
        localStringBuilder.append(paramNetResp.mErrDesc);
        QLog.d("DoutuServiceImpl", 2, localStringBuilder.toString());
      }
      i = paramNetResp.mErrCode;
      bool = false;
    }
    paramNetResp = new HashMap();
    paramNetResp.put("param_FailCode", String.valueOf(i));
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "doutuResDownload", bool, 0L, 0L, paramNetResp, "");
    DoutuServiceImpl.isLoadingRes = false;
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.doutu.api.impl.DoutuServiceImpl.10
 * JD-Core Version:    0.7.0.1
 */