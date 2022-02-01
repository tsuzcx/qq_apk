package com.tencent.mobileqq.kandian.biz.ugc;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyObserver;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class KandianVideoUploadController$1
  extends ReadInJoyObserver
{
  KandianVideoUploadController$1(KandianVideoUploadController paramKandianVideoUploadController) {}
  
  public void a(String paramString1, int paramInt1, long paramLong, String paramString2, int paramInt2, String paramString3, String paramString4)
  {
    this.a.f = false;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("receive 83e requestUUID:");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(" ,retCode :");
    ((StringBuilder)localObject).append(paramInt1);
    QLog.d("ReadInJoyDeliverVideo", 1, ((StringBuilder)localObject).toString());
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(KandianVideoUploadController.a(this.a))))
    {
      if (!paramString1.equals(KandianVideoUploadController.a(this.a))) {
        return;
      }
      if (paramInt1 == 0)
      {
        KanDianVideoUploadUtils.b(KandianVideoUploadController.b(this.a));
        paramString1 = this.a;
        paramString1.e = true;
        if (KandianVideoUploadController.c(paramString1)) {
          ThreadManager.post(new KandianVideoUploadController.1.1(this), 5, null, false);
        }
      }
    }
    try
    {
      localObject = new JSONObject();
      boolean bool = TextUtils.isEmpty(paramString3);
      if (bool)
      {
        paramString1 = "";
        paramString3 = paramString1;
      }
    }
    catch (Exception paramString1)
    {
      label177:
      break label488;
    }
    try
    {
      ((JSONObject)localObject).put("type", 4);
    }
    catch (Exception paramString1)
    {
      break label177;
    }
    break label488;
    ((JSONObject)localObject).put("type", 5);
    paramString1 = paramString3;
    paramString3 = paramString1;
    KandianVideoUploadController.a(this.a, KandianVideoUploadController.b(this.a).getLong("arg_video_duration", 0L));
    paramString3 = paramString1;
    KandianVideoUploadController.a(this.a, KandianVideoUploadController.b(this.a).getInt("arg_video_width", 0));
    paramString3 = paramString1;
    ((JSONObject)localObject).put("comment", new String(Base64Util.encode(paramString1.getBytes(), 0)));
    paramString3 = paramString1;
    ((JSONObject)localObject).put("feedsId", String.valueOf(paramLong));
    try
    {
      ((JSONObject)localObject).put("status", paramInt2);
      ((JSONObject)localObject).put("ugcVideoCoverUrl", KandianVideoUploadController.d(this.a));
      ((JSONObject)localObject).put("ugcVideoDuration", KandianVideoUploadController.e(this.a));
    }
    catch (Exception paramString3)
    {
      int i;
      label482:
      break label482;
    }
    try
    {
      ((JSONObject)localObject).put("ugcVideoRowkey", paramString2);
      ((JSONObject)localObject).put("ugcVideoWidth", KandianVideoUploadController.f(this.a));
      ((JSONObject)localObject).put("ugcVideoHeight", KandianVideoUploadController.g(this.a));
      i = KandianVideoUploadController.h(this.a);
      if (i == 12) {
        ((JSONObject)localObject).put("feedsType", 4);
      } else if (KandianVideoUploadController.h(this.a) == 13) {
        ((JSONObject)localObject).put("feedsType", 5);
      }
      localObject = ((JSONObject)localObject).toString();
      KandianVideoUploadController.b(this.a).putString("arg_result_json", (String)localObject);
      paramString3 = paramString1;
      if (!QLog.isColorLevel()) {
        break label488;
      }
      paramString3 = new StringBuilder();
      paramString3.append("onDeliverUpMasterResult resultJson=");
      paramString3.append((String)localObject);
      QLog.d("ReadInJoyDeliverVideo", 2, paramString3.toString());
      paramString3 = paramString1;
    }
    catch (Exception paramString3)
    {
      paramString3 = paramString1;
      break label488;
    }
    paramString3 = paramString1;
    label488:
    this.a.a(0);
    ReadInJoyHelper.C(this.a.b, 1);
    break label539;
    if (paramInt1 == 33) {
      this.a.a(1006);
    } else {
      this.a.a(1006);
    }
    label539:
    if (KandianVideoUploadController.i(this.a) != null) {
      KandianVideoUploadController.i(this.a).a(this.a.g, paramInt1, paramLong, paramString2, paramInt2, paramString3, paramString4);
    }
    KandianVideoUploadController.b(this.a, paramInt1);
    KandianVideoUploadController.c(this.a, paramInt1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.KandianVideoUploadController.1
 * JD-Core Version:    0.7.0.1
 */