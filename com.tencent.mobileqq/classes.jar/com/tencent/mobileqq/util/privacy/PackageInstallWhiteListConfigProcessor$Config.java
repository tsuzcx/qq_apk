package com.tencent.mobileqq.util.privacy;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/util/privacy/PackageInstallWhiteListConfigProcessor$Config;", "", "()V", "whiteListMap", "Ljava/util/HashMap;", "", "Lorg/json/JSONArray;", "Lkotlin/collections/HashMap;", "getWhiteListMap$QQCommon_release", "()Ljava/util/HashMap;", "setWhiteListMap$QQCommon_release", "(Ljava/util/HashMap;)V", "parse", "", "configText", "QQCommon_release"}, k=1, mv={1, 1, 16})
public final class PackageInstallWhiteListConfigProcessor$Config
{
  @NotNull
  private HashMap<String, JSONArray> a = new HashMap();
  
  @NotNull
  public final HashMap<String, JSONArray> a()
  {
    return this.a;
  }
  
  public final void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "configText");
    QLog.d("PackageInstallWhiteListConfigProcessor", 1, paramString);
    if (!TextUtils.isEmpty((CharSequence)paramString)) {
      try
      {
        paramString = new JSONObject(paramString);
        Iterator localIterator = paramString.keys();
        Intrinsics.checkExpressionValueIsNotNull(localIterator, "json.keys()");
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          Map localMap = (Map)this.a;
          Intrinsics.checkExpressionValueIsNotNull(str, "key");
          JSONArray localJSONArray = paramString.optJSONArray(str);
          Intrinsics.checkExpressionValueIsNotNull(localJSONArray, "json.optJSONArray(key)");
          localMap.put(str, localJSONArray);
        }
        return;
      }
      catch (Throwable paramString)
      {
        QLog.e("PackageInstallWhiteListConfigProcessor", 1, paramString, new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.util.privacy.PackageInstallWhiteListConfigProcessor.Config
 * JD-Core Version:    0.7.0.1
 */