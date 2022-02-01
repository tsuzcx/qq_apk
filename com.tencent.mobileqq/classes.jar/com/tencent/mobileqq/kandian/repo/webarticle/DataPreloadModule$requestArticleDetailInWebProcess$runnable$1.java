package com.tencent.mobileqq.kandian.repo.webarticle;

import com.tencent.mobileqq.kandian.base.msf.ReadInJoyOidbHelper;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tencent.im.oidb.cmd0xf24.oidb_cmd0xf24.ReqBody;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class DataPreloadModule$requestArticleDetailInWebProcess$runnable$1
  implements Runnable
{
  DataPreloadModule$requestArticleDetailInWebProcess$runnable$1(String paramString) {}
  
  public final void run()
  {
    int i;
    if (((CharSequence)this.a).length() == 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      QLog.i("DataPreloadModule", 1, "[requestArticleDetail] rowKey is empty, do not request.");
      return;
    }
    if (!DataPreloadModule.access$isAbleToPreload(DataPreloadModule.INSTANCE, this.a))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[requestArticleDetail] is in request or cache list, do not request, rowKey = ");
      ((StringBuilder)localObject).append(this.a);
      QLog.i("DataPreloadModule", 1, ((StringBuilder)localObject).toString());
      return;
    }
    Object localObject = new oidb_cmd0xf24.ReqBody();
    ((oidb_cmd0xf24.ReqBody)localObject).rowkey.set(this.a);
    localObject = ReadInJoyOidbHelper.a("OidbSvc.0xf24", 3876, 0, ((oidb_cmd0xf24.ReqBody)localObject).toByteArray());
    Intrinsics.checkExpressionValueIsNotNull(localObject, "request");
    ((ToServiceMsg)localObject).setTimeout(5000L);
    HashMap localHashMap = ((ToServiceMsg)localObject).getAttributes();
    Intrinsics.checkExpressionValueIsNotNull(localHashMap, "request.attributes");
    ((Map)localHashMap).put("attribute_key_rowKey", this.a);
    DataPreloadModule.INSTANCE.sendPbReq((ToServiceMsg)localObject);
    DataPreloadModule.access$getRequestList$p(DataPreloadModule.INSTANCE).add(this.a);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[requestArticleDetail], rowKey = ");
    ((StringBuilder)localObject).append(this.a);
    QLog.i("DataPreloadModule", 1, ((StringBuilder)localObject).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.webarticle.DataPreloadModule.requestArticleDetailInWebProcess.runnable.1
 * JD-Core Version:    0.7.0.1
 */