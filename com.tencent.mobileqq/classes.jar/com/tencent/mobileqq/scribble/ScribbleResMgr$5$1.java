package com.tencent.mobileqq.scribble;

import android.text.TextUtils;
import com.tencent.biz.common.util.ZipUtils;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;

class ScribbleResMgr$5$1
  implements INetEngineListener
{
  ScribbleResMgr$5$1(ScribbleResMgr.5 param5) {}
  
  public void onResp(NetResp paramNetResp)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("DownloadResIcon onResp resp.mResult:  ");
    ((StringBuilder)localObject1).append(paramNetResp.mResult);
    localObject1 = ((StringBuilder)localObject1).toString();
    int k = 2;
    QLog.i("ScribbleResMgr", 2, (String)localObject1);
    int i = k;
    if (paramNetResp.mResult == 0)
    {
      i = this.a.a;
      Object localObject3 = "";
      Object localObject2;
      if (i == 3)
      {
        localObject2 = ScribbleResMgr.a(this.a.this$0);
        localObject1 = ScribbleResMgr.b(this.a.this$0);
      }
      else
      {
        localObject2 = "";
        localObject1 = localObject2;
      }
      if (this.a.a == 4)
      {
        localObject2 = ScribbleResMgr.c(this.a.this$0);
        localObject1 = ScribbleResMgr.d(this.a.this$0);
      }
      String str = FileUtils.calcMd5((String)localObject2);
      if ((!TextUtils.isEmpty(str)) && (str.equalsIgnoreCase((String)localObject1)))
      {
        localObject1 = BaseScribbleResMgr.a;
        i = ZipUtils.unZipFolder((String)localObject2, (String)localObject1);
        int j;
        if (i != 0)
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("unZipFolder  failed, filepath=");
          ((StringBuilder)localObject3).append((String)localObject2);
          ((StringBuilder)localObject3).append(" destDir= ");
          ((StringBuilder)localObject3).append((String)localObject1);
          ((StringBuilder)localObject3).append(" result: ");
          ((StringBuilder)localObject3).append(i);
          QLog.e("ScribbleResMgr", 2, ((StringBuilder)localObject3).toString());
          j = 0;
        }
        else
        {
          j = 1;
        }
        i = k;
        if (j != 0) {
          i = 1;
        }
      }
      else
      {
        localObject2 = str;
        if (str == null) {
          localObject2 = "";
        }
        if (localObject1 == null) {
          localObject1 = localObject3;
        }
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("check wrong md5 =");
        ((StringBuilder)localObject3).append((String)localObject2);
        ((StringBuilder)localObject3).append(" desMd5 = ");
        ((StringBuilder)localObject3).append((String)localObject1);
        QLog.e("ScribbleResMgr", 2, ((StringBuilder)localObject3).toString());
        i = k;
      }
    }
    if (paramNetResp.mResult == 3) {
      i = 4;
    }
    paramNetResp = new ResInfo();
    paramNetResp.a = this.a.a;
    paramNetResp.b = 0;
    ScribbleResMgr.a(this.a.this$0, paramNetResp, i);
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.scribble.ScribbleResMgr.5.1
 * JD-Core Version:    0.7.0.1
 */