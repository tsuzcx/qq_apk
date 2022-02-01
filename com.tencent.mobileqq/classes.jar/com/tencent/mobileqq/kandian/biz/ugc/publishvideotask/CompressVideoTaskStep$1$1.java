package com.tencent.mobileqq.kandian.biz.ugc.publishvideotask;

import android.os.Handler;
import com.tencent.biz.pubaccount.util.MD5Utils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.kandian.base.video.compress.VideoMediaInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class CompressVideoTaskStep$1$1
  implements Runnable
{
  CompressVideoTaskStep$1$1(CompressVideoTaskStep.1 param1, int paramInt, String paramString, VideoMediaInfo paramVideoMediaInfo) {}
  
  public void run()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onCompressFinished, retCode =");
    ((StringBuilder)localObject).append(this.a);
    ((StringBuilder)localObject).append(",outPath = ");
    ((StringBuilder)localObject).append(this.b);
    QLog.i("RIJUGC.CompressVideoTaskStep", 1, ((StringBuilder)localObject).toString());
    localObject = this.b;
    if ((localObject != null) && (!((String)localObject).isEmpty())) {
      localObject = MD5Utils.a(new File(this.b));
    } else {
      localObject = "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("get Md5, md5=");
    localStringBuilder.append((String)localObject);
    QLog.i("RIJUGC.CompressVideoTaskStep", 1, localStringBuilder.toString());
    ThreadManagerV2.getUIHandlerV2().post(new CompressVideoTaskStep.1.1.1(this, (String)localObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.publishvideotask.CompressVideoTaskStep.1.1
 * JD-Core Version:    0.7.0.1
 */