package com.tencent.mobileqq.kandian.biz.viola.barrage;

import android.os.Bundle;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/viola/barrage/BarrageController$BarrageBusinessObserver;", "Lcom/tencent/mobileqq/kandian/biz/viola/barrage/BarrageHandler$BarrageObserver;", "(Lcom/tencent/mobileqq/kandian/biz/viola/barrage/BarrageController;)V", "onGetBarrageList", "", "isSuccess", "", "data", "Landroid/os/Bundle;", "saveSessionParams", "rowKey", "", "cookie", "commonData", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
final class BarrageController$BarrageBusinessObserver
  extends BarrageHandler.BarrageObserver
{
  private final void a(String paramString1, String paramString2, String paramString3)
  {
    if (TextUtils.isEmpty((CharSequence)paramString1)) {
      return;
    }
    BarrageHandler.SessionParams localSessionParams2 = (BarrageHandler.SessionParams)BarrageController.a(this.a).get(paramString1);
    BarrageHandler.SessionParams localSessionParams1 = localSessionParams2;
    if (localSessionParams2 == null)
    {
      localSessionParams1 = new BarrageHandler.SessionParams();
      ((Map)BarrageController.a(this.a)).put(paramString1, localSessionParams1);
    }
    localSessionParams1.b = paramString3;
    localSessionParams1.a = paramString2;
  }
  
  public void a(boolean paramBoolean, @NotNull Bundle paramBundle)
  {
    Intrinsics.checkParameterIsNotNull(paramBundle, "data");
    Object localObject = paramBundle.getParcelableArrayList("value_barrage_list");
    Intrinsics.checkExpressionValueIsNotNull(localObject, "data.getParcelableArrayL…ndler.VALUE_BARRAGE_LIST)");
    localObject = (List)localObject;
    int i = paramBundle.getInt("value_barrage_time_interval");
    String str = paramBundle.getString("value_row_key");
    a(str, paramBundle.getString("value_cookie"), paramBundle.getString("value_common_data"));
    if (paramBoolean)
    {
      if ((localObject != null) && (i > 0) && (!TextUtils.isEmpty((CharSequence)str)))
      {
        BarrageController.a(this.a).clear();
        BarrageController.a(this.a).addAll((Collection)localObject);
        if (this.a.a()) {
          this.a.a();
        }
      }
    }
    else {
      QLog.e("BarrageController", 2, "onGetBarrageList error...");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.viola.barrage.BarrageController.BarrageBusinessObserver
 * JD-Core Version:    0.7.0.1
 */