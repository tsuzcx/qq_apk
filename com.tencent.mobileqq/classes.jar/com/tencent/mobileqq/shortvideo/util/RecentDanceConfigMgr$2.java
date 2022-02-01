package com.tencent.mobileqq.shortvideo.util;

import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

final class RecentDanceConfigMgr$2
  implements INetEngineListener
{
  RecentDanceConfigMgr$2(RecentDanceConfigMgr.DItemInfo paramDItemInfo, String paramString) {}
  
  public void onResp(NetResp paramNetResp)
  {
    Object localObject;
    if (paramNetResp.mResult == 0)
    {
      paramNetResp = paramNetResp.mReq;
      if (new File(paramNetResp.mOutPath).exists())
      {
        localObject = RecentDanceConfigMgr.a(paramNetResp.mOutPath);
        if ((localObject != null) && (!"".equals(localObject)) && (((String)localObject).equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilRecentDanceConfigMgr$DItemInfo.icon_md5)))
        {
          if (QLog.isColorLevel()) {
            QLog.i("RecentDanceConfigMgr", 2, "processNetWork onResp: check success");
          }
          FileUtils.rename(paramNetResp.mOutPath, this.jdField_a_of_type_JavaLangString);
          RecentDanceConfigMgr.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilRecentDanceConfigMgr$DItemInfo, this.jdField_a_of_type_JavaLangString);
          return;
        }
        FileUtils.deleteFile(paramNetResp.mOutPath);
        FileUtils.deleteFile(this.jdField_a_of_type_JavaLangString);
        if (QLog.isColorLevel())
        {
          paramNetResp = new StringBuilder();
          paramNetResp.append("processNetWork onResp: item.icon_md5");
          paramNetResp.append(this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilRecentDanceConfigMgr$DItemInfo.icon_md5);
          paramNetResp.append(" md5=");
          paramNetResp.append((String)localObject);
          QLog.i("RecentDanceConfigMgr", 2, paramNetResp.toString());
        }
      }
      else if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("processNetWork onResp[not exists]: mOutPath");
        ((StringBuilder)localObject).append(paramNetResp.mOutPath);
        QLog.i("RecentDanceConfigMgr", 2, ((StringBuilder)localObject).toString());
      }
    }
    else
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("processNetWork onResp: resp.mResult=");
        ((StringBuilder)localObject).append(paramNetResp.mResult);
        QLog.i("RecentDanceConfigMgr", 2, ((StringBuilder)localObject).toString());
      }
      FileUtils.deleteFile(paramNetResp.mReq.mOutPath);
    }
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel())
    {
      paramNetReq = new StringBuilder();
      paramNetReq.append("processNetWork onUpdateProgeress: totalLen=");
      paramNetReq.append(paramLong2);
      paramNetReq.append(" curOffset=");
      paramNetReq.append(paramLong1);
      QLog.i("RecentDanceConfigMgr", 2, paramNetReq.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.util.RecentDanceConfigMgr.2
 * JD-Core Version:    0.7.0.1
 */