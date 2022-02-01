package com.tencent.mobileqq.scribble;

import android.text.TextUtils;
import com.tencent.biz.common.util.ZipUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.transfile.predownload.IPreDownloadController;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;

class ScribbleResMgr$4$1
  implements INetEngineListener
{
  ScribbleResMgr$4$1(ScribbleResMgr.4 param4) {}
  
  public void onResp(NetResp paramNetResp)
  {
    boolean bool = QLog.isColorLevel();
    int i = 2;
    Object localObject1;
    if (bool)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onResp  mResult: ");
      ((StringBuilder)localObject1).append(paramNetResp.mResult);
      ((StringBuilder)localObject1).append(" url:");
      ((StringBuilder)localObject1).append(this.a.a.c);
      QLog.i("ScribbleResMgr", 2, ((StringBuilder)localObject1).toString());
    }
    int j = i;
    if (paramNetResp.mResult == 0)
    {
      j = this.a.a.a;
      Object localObject2 = "";
      if (j == 1) {
        localObject1 = ScribbleResMgr.b(this.a.a.a, this.a.a.b);
      } else {
        localObject1 = "";
      }
      if (this.a.a.a == 2) {
        localObject1 = ScribbleResMgr.a(this.a.a.b);
      }
      Object localObject3 = this.a.a.d;
      String str = FileUtils.calcMd5((String)localObject1);
      if ((!TextUtils.isEmpty(str)) && (str.equalsIgnoreCase((String)localObject3)))
      {
        if (this.a.a.a == 2)
        {
          localObject2 = ScribbleResMgr.b(this.a.a.b);
          j = ZipUtils.unZipFolder((String)localObject1, (String)localObject2);
          if (j != 0)
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("unzip failed, filepath=");
            ((StringBuilder)localObject3).append((String)localObject1);
            ((StringBuilder)localObject3).append(" destDir= ");
            ((StringBuilder)localObject3).append((String)localObject2);
            ((StringBuilder)localObject3).append(" result: ");
            ((StringBuilder)localObject3).append(j);
            QLog.e("ScribbleResMgr", 2, ((StringBuilder)localObject3).toString());
            j = 0;
            break label316;
          }
        }
        j = 1;
        label316:
        if (j != 0) {
          i = 1;
        }
      }
      else
      {
        localObject1 = str;
        if (str == null) {
          localObject1 = "";
        }
        if (localObject3 != null) {
          localObject2 = localObject3;
        }
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("onResp url: ");
        ((StringBuilder)localObject3).append(this.a.a.c);
        ((StringBuilder)localObject3).append("check wrong md5 =");
        ((StringBuilder)localObject3).append((String)localObject1);
        ((StringBuilder)localObject3).append(" desMd5 = ");
        ((StringBuilder)localObject3).append((String)localObject2);
        QLog.e("ScribbleResMgr", 2, ((StringBuilder)localObject3).toString());
      }
      localObject1 = (IPreDownloadController)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getRuntimeService(IPreDownloadController.class);
      j = i;
      if (((IPreDownloadController)localObject1).isEnable())
      {
        ((IPreDownloadController)localObject1).preDownloadSuccess(this.a.a.c, paramNetResp.mTotalFileLen);
        j = i;
      }
    }
    if (paramNetResp.mResult == 3) {
      j = 4;
    }
    ScribbleResMgr.a(this.a.this$0, this.a.a, j);
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.scribble.ScribbleResMgr.4.1
 * JD-Core Version:    0.7.0.1
 */