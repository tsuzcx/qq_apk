package com.tencent.mobileqq.ecshop.view.api.impl;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.ecshop.api.IEcshopUtilApi;
import com.tencent.mobileqq.ecshop.conf.EcshopConfBean;
import com.tencent.mobileqq.ecshop.conf.EcshopConfBean.PromotionConfBean;
import com.tencent.mobileqq.ecshop.temp.api.IEcshopMessageApi;
import com.tencent.mobileqq.ecshop.utils.AppUtils;
import com.tencent.mobileqq.ecshop.utils.SharedPreferencesUtil;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.preload.PreloadStaticApi;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class EcshopRainViewApiImpl$addRainView$1
  implements Runnable
{
  EcshopRainViewApiImpl$addRainView$1(EcshopRainViewApiImpl paramEcshopRainViewApiImpl, Context paramContext, RelativeLayout paramRelativeLayout) {}
  
  public final void run()
  {
    int i;
    try
    {
      localMessageRecord = ((IMessageFacade)AppUtils.a().getRuntimeService(IMessageFacade.class, "")).getLastMsgForMsgTab("3046055438", 1008);
      localObject2 = (JSONObject)null;
      if (SharedPreferencesUtil.e("LAST_MSG_SEQ_RAIN") == localMessageRecord.uniseq) {
        return;
      }
      localObject1 = QRoute.api(IEcshopMessageApi.class);
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "QRoute.api(IEcshopMessageApi::class.java)");
      localObject3 = (IEcshopMessageApi)localObject1;
      if (((IEcshopMessageApi)localObject3).isMessageForStructing(localMessageRecord))
      {
        localObject1 = ((IEcshopMessageApi)localObject3).getStuctMsgAdInfo(localMessageRecord);
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          return;
        }
        localObject1 = new JSONObject((String)localObject1);
      }
      else
      {
        localObject1 = localObject2;
        if (((IEcshopMessageApi)localObject3).isMessageForArkApp(localMessageRecord))
        {
          localObject3 = ((IEcshopMessageApi)localObject3).getArkMsgMetaList(localMessageRecord);
          localObject1 = localObject2;
          if (!StringUtil.isEmpty((String)localObject3))
          {
            localObject3 = new JSONObject((String)localObject3).optJSONObject("gdt");
            localObject1 = localObject2;
            if (localObject3 != null) {
              localObject1 = ((JSONObject)localObject3).optJSONObject("adInfo");
            }
          }
        }
      }
    }
    catch (Exception localException)
    {
      MessageRecord localMessageRecord;
      Object localObject2;
      Object localObject1;
      Object localObject3;
      int j;
      int k;
      QLog.e("EcshopRainViewApiImpl", 1, (Throwable)localException, new Object[0]);
    }
    localObject1 = ((JSONObject)localObject1).optJSONObject("ext");
    if (localObject1 != null)
    {
      localObject1 = ((JSONObject)localObject1).optJSONArray("exp_map");
      if (localObject1 != null)
      {
        j = ((JSONArray)localObject1).length();
        i = 0;
        label228:
        if (i < j)
        {
          localObject2 = ((JSONArray)localObject1).optJSONObject(i);
          k = ((JSONObject)localObject2).optInt("key");
          localObject2 = ((JSONObject)localObject2).optString("value");
          if ((k == 102636) && (Intrinsics.areEqual("1", localObject2))) {
            i = 1;
          }
        }
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        localObject1 = ((IEcshopUtilApi)QRoute.api(IEcshopUtilApi.class)).getEcshopConfBean();
        localObject2 = this.this$0;
        localObject3 = ((EcshopConfBean)localObject1).m;
        Intrinsics.checkExpressionValueIsNotNull(localObject3, "ecshopConfBean.promotionConf");
        Intrinsics.checkExpressionValueIsNotNull(localMessageRecord, "lastMsg");
        if (!((EcshopRainViewApiImpl)localObject2).isInPromotionTime((EcshopConfBean.PromotionConfBean)localObject3, localMessageRecord)) {
          return;
        }
        localObject1 = PreloadStaticApi.a(((EcshopConfBean)localObject1).m.d);
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          return;
        }
        localObject2 = new BitmapFactory.Options();
        ((BitmapFactory.Options)localObject2).inPurgeable = true;
        ((BitmapFactory.Options)localObject2).inSampleSize = 2;
        localObject1 = BitmapFactory.decodeFile((String)localObject1, (BitmapFactory.Options)localObject2);
        localObject2 = this.this$0;
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "rainIcon");
        EcshopRainViewApiImpl.access$rainInUIThread((EcshopRainViewApiImpl)localObject2, (Bitmap)localObject1, this.a, this.b);
        SharedPreferencesUtil.a("LAST_MSG_SEQ_RAIN", localMessageRecord.uniseq);
        return;
      }
      return;
      if (localException != null) {
        break;
      }
      return;
      i += 1;
      break label228;
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ecshop.view.api.impl.EcshopRainViewApiImpl.addRainView.1
 * JD-Core Version:    0.7.0.1
 */