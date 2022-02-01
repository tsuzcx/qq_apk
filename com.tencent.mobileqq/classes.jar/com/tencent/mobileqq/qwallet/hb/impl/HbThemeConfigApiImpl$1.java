package com.tencent.mobileqq.qwallet.hb.impl;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.preload.IPreloadImgApi;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONObject;

class HbThemeConfigApiImpl$1
  implements Runnable
{
  HbThemeConfigApiImpl$1(HbThemeConfigApiImpl paramHbThemeConfigApiImpl, Context paramContext, JSONObject paramJSONObject, AppInterface paramAppInterface) {}
  
  public void run()
  {
    Object localObject = this.a.getSharedPreferences("qb_tenpay_share_face", 0).edit();
    ((SharedPreferences.Editor)localObject).putString("hb_face", HbThemeConfigApiImpl.access$002(this.this$0, this.b).toString());
    ((SharedPreferences.Editor)localObject).commit();
    localObject = HbThemeConfigApiImpl.access$000(this.this$0).optString("hb_face_imgurl");
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("HbThemeConfigApi", 2, "start downloading img...");
    }
    HashSet localHashSet = new HashSet(2);
    localHashSet.add(localObject);
    ((IPreloadImgApi)QRoute.api(IPreloadImgApi.class)).startDownload(this.c, localHashSet);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.impl.HbThemeConfigApiImpl.1
 * JD-Core Version:    0.7.0.1
 */