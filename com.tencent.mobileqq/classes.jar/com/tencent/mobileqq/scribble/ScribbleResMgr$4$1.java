package com.tencent.mobileqq.scribble;

import android.text.TextUtils;
import com.tencent.biz.common.util.ZipUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.transfile.predownload.PreDownloadController;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;

class ScribbleResMgr$4$1
  implements INetEngineListener
{
  ScribbleResMgr$4$1(ScribbleResMgr.4 param4) {}
  
  public void onResp(NetResp paramNetResp)
  {
    int j = 2;
    if (QLog.isColorLevel()) {
      QLog.i("ScribbleResMgr", 2, "onResp  mResult: " + paramNetResp.mResult + " url:" + this.a.a.sourceUrl);
    }
    int i = j;
    Object localObject;
    String str1;
    String str2;
    if (paramNetResp.mResult == 0)
    {
      localObject = "";
      if (this.a.a.resType == 1) {
        localObject = ScribbleResMgr.b(this.a.a.resType, this.a.a.sourceId);
      }
      if (this.a.a.resType == 2) {
        localObject = ScribbleResMgr.a(this.a.a.sourceId);
      }
      str1 = this.a.a.sourceMd5;
      str2 = FileUtils.c((String)localObject);
      if ((TextUtils.isEmpty(str2)) || (!str2.equalsIgnoreCase(str1))) {
        break label348;
      }
      if (this.a.a.resType != 2) {
        break label438;
      }
      str1 = ScribbleResMgr.b(this.a.a.sourceId);
      i = ZipUtils.unZipFolder((String)localObject, str1);
      if (i == 0) {
        break label438;
      }
      QLog.e("ScribbleResMgr", 2, "unzip failed, filepath=" + (String)localObject + " destDir= " + str1 + " result: " + i);
    }
    label438:
    for (i = 0;; i = 1)
    {
      if (i != 0) {}
      for (i = 1;; i = 2)
      {
        j = i;
        localObject = (PreDownloadController)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(QQManagerFactory.PRE_DOWNLOAD_CONTROLLER_2);
        i = j;
        if (((PreDownloadController)localObject).isEnable())
        {
          ((PreDownloadController)localObject).preDownloadSuccess(this.a.a.sourceUrl, paramNetResp.mTotalFileLen);
          i = j;
        }
        if (paramNetResp.mResult == 3) {
          i = 4;
        }
        ScribbleResMgr.a(this.a.this$0, this.a.a, i);
        return;
        label348:
        if (str2 == null) {}
        for (localObject = "";; localObject = str2)
        {
          if (str1 == null) {
            str1 = "";
          }
          for (;;)
          {
            QLog.e("ScribbleResMgr", 2, "onResp url: " + this.a.a.sourceUrl + "check wrong md5 =" + (String)localObject + " desMd5 = " + str1);
            break;
          }
        }
      }
    }
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.scribble.ScribbleResMgr.4.1
 * JD-Core Version:    0.7.0.1
 */