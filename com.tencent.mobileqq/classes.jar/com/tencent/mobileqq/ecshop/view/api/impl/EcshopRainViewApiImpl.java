package com.tencent.mobileqq.ecshop.view.api.impl;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Handler;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.ecshop.api.IEcshopUtilApi;
import com.tencent.mobileqq.ecshop.conf.EcshopConfBean;
import com.tencent.mobileqq.ecshop.conf.EcshopConfBean.PromotionConfBean;
import com.tencent.mobileqq.ecshop.temp.api.IEcshopMessageApi;
import com.tencent.mobileqq.ecshop.view.api.IEcshopRainViewApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.preload.IPreloadServiceAbs;
import com.tencent.mobileqq.qwallet.preload.PreloadStaticApi;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/ecshop/view/api/impl/EcshopRainViewApiImpl;", "Lcom/tencent/mobileqq/ecshop/view/api/IEcshopRainViewApi;", "()V", "addRainView", "", "contentView", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "getMsgPromotion", "", "record", "Lcom/tencent/mobileqq/data/MessageRecord;", "adInfoJson", "", "Lorg/json/JSONObject;", "handlePreload", "isInPromotionTime", "", "confBean", "Lcom/tencent/mobileqq/ecshop/conf/EcshopConfBean$PromotionConfBean;", "message", "rainInUIThread", "rainIcon", "Landroid/graphics/Bitmap;", "Companion", "qqshop-feature-impl_release"}, k=1, mv={1, 1, 16})
public final class EcshopRainViewApiImpl
  implements IEcshopRainViewApi
{
  public static final EcshopRainViewApiImpl.Companion Companion = new EcshopRainViewApiImpl.Companion(null);
  private static final int KEY_IS_RAIN = 102636;
  private static final String KEY_LAST_MSG_SEQ_RAIN = "LAST_MSG_SEQ_RAIN";
  private static final int KEY_PERIOD_TYPE = 102632;
  private static final String TAG = "EcshopRainViewApiImpl";
  
  private final int getMsgPromotion(MessageRecord paramMessageRecord)
  {
    Object localObject = QRoute.api(IEcshopMessageApi.class);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "QRoute.api(IEcshopMessageApi::class.java)");
    localObject = (IEcshopMessageApi)localObject;
    if (((IEcshopMessageApi)localObject).isMessageForStructing(paramMessageRecord)) {
      return getMsgPromotion(((IEcshopMessageApi)localObject).getStuctMsgAdInfo(paramMessageRecord));
    }
    if (((IEcshopMessageApi)localObject).isMessageForArkApp(paramMessageRecord))
    {
      paramMessageRecord = ((IEcshopMessageApi)localObject).getArkMsgMetaList(paramMessageRecord);
      if (!StringUtil.a(paramMessageRecord))
      {
        paramMessageRecord = new JSONObject(paramMessageRecord).optJSONObject("gdt");
        if (paramMessageRecord != null)
        {
          paramMessageRecord = paramMessageRecord.optJSONObject("adInfo");
          Intrinsics.checkExpressionValueIsNotNull(paramMessageRecord, "adInfoObj");
          return getMsgPromotion(paramMessageRecord);
        }
      }
    }
    return -1;
  }
  
  private final int getMsgPromotion(JSONObject paramJSONObject)
  {
    try
    {
      paramJSONObject = paramJSONObject.optJSONObject("ext");
      if (paramJSONObject != null)
      {
        paramJSONObject = paramJSONObject.optJSONArray("exp_map");
        if (paramJSONObject != null)
        {
          int j = paramJSONObject.length();
          int i = 0;
          while (i < j)
          {
            Object localObject = paramJSONObject.optJSONObject(i);
            int k = ((JSONObject)localObject).optInt("key");
            localObject = ((JSONObject)localObject).optString("value");
            if (k == 102632)
            {
              if (Intrinsics.areEqual("1", localObject)) {
                return 1;
              }
              boolean bool = Intrinsics.areEqual("2", localObject);
              if (!bool) {
                break;
              }
              return 2;
            }
            i += 1;
          }
        }
        return -1;
      }
    }
    catch (Exception paramJSONObject)
    {
      QLog.e("EcshopRainViewApiImpl", 1, (Throwable)paramJSONObject, new Object[0]);
    }
    return -1;
  }
  
  private final void rainInUIThread(Bitmap paramBitmap, Context paramContext, RelativeLayout paramRelativeLayout)
  {
    ThreadManagerV2.getUIHandlerV2().post((Runnable)new EcshopRainViewApiImpl.rainInUIThread.1(paramContext, paramRelativeLayout, paramBitmap));
  }
  
  public void addRainView(@NotNull RelativeLayout paramRelativeLayout, @NotNull Context paramContext)
  {
    Intrinsics.checkParameterIsNotNull(paramRelativeLayout, "contentView");
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    if (Build.VERSION.SDK_INT < 23) {
      return;
    }
    ThreadManagerV2.excute((Runnable)new EcshopRainViewApiImpl.addRainView.1(this, paramContext, paramRelativeLayout), 32, null, true);
  }
  
  public int getMsgPromotion(@Nullable String paramString)
  {
    try
    {
      if (TextUtils.isEmpty((CharSequence)paramString)) {
        return -1;
      }
      int i = getMsgPromotion(new JSONObject(paramString));
      return i;
    }
    catch (Exception paramString)
    {
      QLog.e("EcshopRainViewApiImpl", 1, (Throwable)paramString, new Object[0]);
    }
    return -1;
  }
  
  public void handlePreload(@NotNull MessageRecord paramMessageRecord)
  {
    Intrinsics.checkParameterIsNotNull(paramMessageRecord, "record");
    try
    {
      if (Build.VERSION.SDK_INT < 23) {
        return;
      }
      if (getMsgPromotion(paramMessageRecord) != -1)
      {
        paramMessageRecord = ((IEcshopUtilApi)QRoute.api(IEcshopUtilApi.class)).getEcshopConfBean().a;
        PreloadStaticApi.a().getResPath(paramMessageRecord.d, null);
        if (paramMessageRecord.jdField_a_of_type_Int == 1)
        {
          Object localObject = paramMessageRecord.jdField_a_of_type_JavaUtilMap;
          Intrinsics.checkExpressionValueIsNotNull(localObject, "promotionConf.warmUpUrls");
          localObject = ((Map)localObject).entrySet().iterator();
          while (((Iterator)localObject).hasNext())
          {
            String str = (String)((Map.Entry)((Iterator)localObject).next()).getValue();
            PreloadStaticApi.a().getResPath(str, null);
          }
          paramMessageRecord = paramMessageRecord.jdField_b_of_type_JavaUtilMap;
          Intrinsics.checkExpressionValueIsNotNull(paramMessageRecord, "promotionConf.highTideUrls");
          paramMessageRecord = paramMessageRecord.entrySet().iterator();
          while (paramMessageRecord.hasNext())
          {
            localObject = (String)((Map.Entry)paramMessageRecord.next()).getValue();
            PreloadStaticApi.a().getResPath((String)localObject, null);
          }
        }
      }
      return;
    }
    catch (Exception paramMessageRecord)
    {
      QLog.e("EcshopRainViewApiImpl", 1, (Throwable)paramMessageRecord, new Object[0]);
    }
  }
  
  public boolean isInPromotionTime(@NotNull EcshopConfBean.PromotionConfBean paramPromotionConfBean, @NotNull MessageRecord paramMessageRecord)
  {
    Intrinsics.checkParameterIsNotNull(paramPromotionConfBean, "confBean");
    Intrinsics.checkParameterIsNotNull(paramMessageRecord, "message");
    try
    {
      SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
      Date localDate = localSimpleDateFormat.parse(paramPromotionConfBean.jdField_a_of_type_JavaLangString);
      Intrinsics.checkExpressionValueIsNotNull(localDate, "sSdf.parse(confBean.beginTime)");
      long l1 = localDate.getTime();
      paramPromotionConfBean = localSimpleDateFormat.parse(paramPromotionConfBean.jdField_b_of_type_JavaLangString);
      Intrinsics.checkExpressionValueIsNotNull(paramPromotionConfBean, "sSdf.parse(confBean.endTime)");
      long l2 = paramPromotionConfBean.getTime();
      if (QLog.isColorLevel())
      {
        paramPromotionConfBean = new StringBuilder();
        paramPromotionConfBean.append("beginTime = ");
        paramPromotionConfBean.append(l1);
        paramPromotionConfBean.append(" endTime = ");
        paramPromotionConfBean.append(l2);
        paramPromotionConfBean.append(" msgTime = ");
        paramPromotionConfBean.append(paramMessageRecord.time);
        QLog.i("EcshopRainViewApiImpl", 2, paramPromotionConfBean.toString());
      }
      long l3 = paramMessageRecord.time;
      l3 *= 1000;
      if (l1 + 1L > l3) {
        return false;
      }
      if (l2 > l3) {
        return true;
      }
    }
    catch (Exception paramPromotionConfBean)
    {
      QLog.e("EcshopRainViewApiImpl", 1, (Throwable)paramPromotionConfBean, new Object[0]);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.ecshop.view.api.impl.EcshopRainViewApiImpl
 * JD-Core Version:    0.7.0.1
 */