package com.tencent.qapmsdk.base.meta;

import android.app.Application;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.qapmsdk.base.dbpersist.DBHelper;
import com.tencent.qapmsdk.common.util.AsyncSPEditor;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/base/meta/BaseInfo;", "", "()V", "Info", "qapmbase_release"}, k=1, mv={1, 1, 15})
public final class BaseInfo
{
  public static final BaseInfo.Info Info;
  @JvmField
  @Nullable
  public static Application app;
  @JvmField
  @Nullable
  public static DBHelper dbHelper;
  @JvmField
  @NotNull
  public static AsyncSPEditor editor;
  @JvmField
  @NotNull
  public static JSONObject pubJson;
  @JvmField
  @Nullable
  public static SharedPreferences sharePreference;
  @JvmField
  @NotNull
  public static String token;
  @JvmField
  @NotNull
  public static final UrlMeta urlMeta;
  @JvmField
  @NotNull
  public static final UserMeta userMeta;
  
  static
  {
    Object localObject2 = null;
    Info = new BaseInfo.Info(null);
    userMeta = new UserMeta(null, null, null, 0, null, null, null, null, null, null, null, null, null, 8191, null);
    urlMeta = new UrlMeta(null, null, null, null, null, null, null, null, 255, null);
    Object localObject1 = app;
    if (localObject1 != null) {}
    for (localObject1 = ((Application)localObject1).getSharedPreferences("QAPM_SP", 0);; localObject1 = null)
    {
      sharePreference = (SharedPreferences)localObject1;
      SharedPreferences localSharedPreferences = sharePreference;
      localObject1 = localObject2;
      if (localSharedPreferences != null) {
        localObject1 = localSharedPreferences.edit();
      }
      editor = new AsyncSPEditor((SharedPreferences.Editor)localObject1);
      token = "";
      pubJson = new JSONObject();
      return;
    }
  }
  
  @JvmStatic
  public static final void initInfo()
  {
    Info.initInfo();
  }
  
  @JvmStatic
  public static final void initUrl()
  {
    Info.initUrl();
  }
  
  @JvmStatic
  public static final void reset()
  {
    Info.reset();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qapmsdk.base.meta.BaseInfo
 * JD-Core Version:    0.7.0.1
 */