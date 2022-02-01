package com.tencent.qapmsdk.base.meta;

import android.os.Build;
import com.google.gson.annotations.SerializedName;
import com.tencent.qapmsdk.common.json.JsonTransform;
import com.tencent.qapmsdk.common.json.JsonTransform.DefaultImpls;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/base/meta/UserMeta;", "Lcom/tencent/qapmsdk/common/json/JsonTransform;", "uin", "", "uuid", "appKey", "appId", "", "version", "deviceId", "sdkVersion", "os", "manufacturer", "device", "apiVer", "pluginVer", "abFactor", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "component1", "component10", "component11", "component12", "component13", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "", "hashCode", "toString", "Companion", "qapmbase_release"}, k=1, mv={1, 1, 15})
public final class UserMeta
  implements JsonTransform
{
  public static final UserMeta.Companion Companion = new UserMeta.Companion(null);
  private static final String DEVICE;
  @SerializedName("abfactor")
  @JvmField
  @NotNull
  public String abFactor;
  @SerializedName("api_ver")
  @JvmField
  @NotNull
  public String apiVer;
  @SerializedName("p_id")
  @JvmField
  public int appId;
  @SerializedName("app_key")
  @JvmField
  @NotNull
  public String appKey;
  @SerializedName("device")
  @JvmField
  @NotNull
  public String device;
  @SerializedName("deviceid")
  @JvmField
  @NotNull
  public String deviceId;
  @SerializedName("manu")
  @JvmField
  @NotNull
  public String manufacturer;
  @SerializedName("os")
  @JvmField
  @NotNull
  public String os;
  @SerializedName("plugin_ver")
  @JvmField
  @NotNull
  public String pluginVer;
  @SerializedName("sdk_ver")
  @JvmField
  @NotNull
  public String sdkVersion;
  @SerializedName("uin")
  @JvmField
  @NotNull
  public String uin;
  @SerializedName("rdmuuid")
  @JvmField
  @NotNull
  public String uuid;
  @SerializedName("version")
  @JvmField
  @NotNull
  public String version;
  
  static
  {
    try
    {
      String str1 = URLEncoder.encode(Build.MODEL, "UTF-8");
      Intrinsics.checkExpressionValueIsNotNull(str1, "URLEncoder.encode(Build.MODEL, \"UTF-8\")");
      DEVICE = str1;
      return;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        String str2 = "";
      }
    }
  }
  
  public UserMeta()
  {
    this(null, null, null, 0, null, null, null, null, null, null, null, null, null, 8191, null);
  }
  
  public UserMeta(@NotNull String paramString1, @NotNull String paramString2, @NotNull String paramString3, int paramInt, @NotNull String paramString4, @NotNull String paramString5, @NotNull String paramString6, @NotNull String paramString7, @NotNull String paramString8, @NotNull String paramString9, @NotNull String paramString10, @NotNull String paramString11, @NotNull String paramString12)
  {
    this.uin = paramString1;
    this.uuid = paramString2;
    this.appKey = paramString3;
    this.appId = paramInt;
    this.version = paramString4;
    this.deviceId = paramString5;
    this.sdkVersion = paramString6;
    this.os = paramString7;
    this.manufacturer = paramString8;
    this.device = paramString9;
    this.apiVer = paramString10;
    this.pluginVer = paramString11;
    this.abFactor = paramString12;
  }
  
  @NotNull
  public final String component1()
  {
    return this.uin;
  }
  
  @NotNull
  public final String component10()
  {
    return this.device;
  }
  
  @NotNull
  public final String component11()
  {
    return this.apiVer;
  }
  
  @NotNull
  public final String component12()
  {
    return this.pluginVer;
  }
  
  @NotNull
  public final String component13()
  {
    return this.abFactor;
  }
  
  @NotNull
  public final String component2()
  {
    return this.uuid;
  }
  
  @NotNull
  public final String component3()
  {
    return this.appKey;
  }
  
  public final int component4()
  {
    return this.appId;
  }
  
  @NotNull
  public final String component5()
  {
    return this.version;
  }
  
  @NotNull
  public final String component6()
  {
    return this.deviceId;
  }
  
  @NotNull
  public final String component7()
  {
    return this.sdkVersion;
  }
  
  @NotNull
  public final String component8()
  {
    return this.os;
  }
  
  @NotNull
  public final String component9()
  {
    return this.manufacturer;
  }
  
  @NotNull
  public final UserMeta copy(@NotNull String paramString1, @NotNull String paramString2, @NotNull String paramString3, int paramInt, @NotNull String paramString4, @NotNull String paramString5, @NotNull String paramString6, @NotNull String paramString7, @NotNull String paramString8, @NotNull String paramString9, @NotNull String paramString10, @NotNull String paramString11, @NotNull String paramString12)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "uin");
    Intrinsics.checkParameterIsNotNull(paramString2, "uuid");
    Intrinsics.checkParameterIsNotNull(paramString3, "appKey");
    Intrinsics.checkParameterIsNotNull(paramString4, "version");
    Intrinsics.checkParameterIsNotNull(paramString5, "deviceId");
    Intrinsics.checkParameterIsNotNull(paramString6, "sdkVersion");
    Intrinsics.checkParameterIsNotNull(paramString7, "os");
    Intrinsics.checkParameterIsNotNull(paramString8, "manufacturer");
    Intrinsics.checkParameterIsNotNull(paramString9, "device");
    Intrinsics.checkParameterIsNotNull(paramString10, "apiVer");
    Intrinsics.checkParameterIsNotNull(paramString11, "pluginVer");
    Intrinsics.checkParameterIsNotNull(paramString12, "abFactor");
    return new UserMeta(paramString1, paramString2, paramString3, paramInt, paramString4, paramString5, paramString6, paramString7, paramString8, paramString9, paramString10, paramString11, paramString12);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1;
    if (this != paramObject)
    {
      bool1 = bool2;
      if (!(paramObject instanceof UserMeta)) {
        break label249;
      }
      paramObject = (UserMeta)paramObject;
      bool1 = bool2;
      if (!Intrinsics.areEqual(this.uin, paramObject.uin)) {
        break label249;
      }
      bool1 = bool2;
      if (!Intrinsics.areEqual(this.uuid, paramObject.uuid)) {
        break label249;
      }
      bool1 = bool2;
      if (!Intrinsics.areEqual(this.appKey, paramObject.appKey)) {
        break label249;
      }
      if (this.appId != paramObject.appId) {
        break label251;
      }
    }
    label249:
    label251:
    for (int i = 1;; i = 0)
    {
      bool1 = bool2;
      if (i != 0)
      {
        bool1 = bool2;
        if (Intrinsics.areEqual(this.version, paramObject.version))
        {
          bool1 = bool2;
          if (Intrinsics.areEqual(this.deviceId, paramObject.deviceId))
          {
            bool1 = bool2;
            if (Intrinsics.areEqual(this.sdkVersion, paramObject.sdkVersion))
            {
              bool1 = bool2;
              if (Intrinsics.areEqual(this.os, paramObject.os))
              {
                bool1 = bool2;
                if (Intrinsics.areEqual(this.manufacturer, paramObject.manufacturer))
                {
                  bool1 = bool2;
                  if (Intrinsics.areEqual(this.device, paramObject.device))
                  {
                    bool1 = bool2;
                    if (Intrinsics.areEqual(this.apiVer, paramObject.apiVer))
                    {
                      bool1 = bool2;
                      if (Intrinsics.areEqual(this.pluginVer, paramObject.pluginVer))
                      {
                        bool1 = bool2;
                        if (Intrinsics.areEqual(this.abFactor, paramObject.abFactor)) {
                          bool1 = true;
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
      return bool1;
    }
  }
  
  public int hashCode()
  {
    int i7 = 0;
    String str = this.uin;
    int i;
    int j;
    label37:
    int k;
    label54:
    int i8;
    int m;
    label78:
    int n;
    label96:
    int i1;
    label114:
    int i2;
    label132:
    int i3;
    label150:
    int i4;
    label168:
    int i5;
    if (str != null)
    {
      i = str.hashCode();
      str = this.uuid;
      if (str == null) {
        break label299;
      }
      j = str.hashCode();
      str = this.appKey;
      if (str == null) {
        break label304;
      }
      k = str.hashCode();
      i8 = this.appId;
      str = this.version;
      if (str == null) {
        break label309;
      }
      m = str.hashCode();
      str = this.deviceId;
      if (str == null) {
        break label315;
      }
      n = str.hashCode();
      str = this.sdkVersion;
      if (str == null) {
        break label321;
      }
      i1 = str.hashCode();
      str = this.os;
      if (str == null) {
        break label327;
      }
      i2 = str.hashCode();
      str = this.manufacturer;
      if (str == null) {
        break label333;
      }
      i3 = str.hashCode();
      str = this.device;
      if (str == null) {
        break label339;
      }
      i4 = str.hashCode();
      str = this.apiVer;
      if (str == null) {
        break label345;
      }
      i5 = str.hashCode();
      label186:
      str = this.pluginVer;
      if (str == null) {
        break label351;
      }
    }
    label299:
    label304:
    label309:
    label315:
    label321:
    label327:
    label333:
    label339:
    label345:
    label351:
    for (int i6 = str.hashCode();; i6 = 0)
    {
      str = this.abFactor;
      if (str != null) {
        i7 = str.hashCode();
      }
      return (i6 + (i5 + (i4 + (i3 + (i2 + (i1 + (n + (m + ((k + (j + i * 31) * 31) * 31 + i8) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31 + i7;
      i = 0;
      break;
      j = 0;
      break label37;
      k = 0;
      break label54;
      m = 0;
      break label78;
      n = 0;
      break label96;
      i1 = 0;
      break label114;
      i2 = 0;
      break label132;
      i3 = 0;
      break label150;
      i4 = 0;
      break label168;
      i5 = 0;
      break label186;
    }
  }
  
  @NotNull
  public String toJSON()
  {
    return JsonTransform.DefaultImpls.toJSON(this);
  }
  
  @NotNull
  public String toString()
  {
    return "UserMeta(uin=" + this.uin + ", uuid=" + this.uuid + ", appKey=" + this.appKey + ", appId=" + this.appId + ", version=" + this.version + ", deviceId=" + this.deviceId + ", sdkVersion=" + this.sdkVersion + ", os=" + this.os + ", manufacturer=" + this.manufacturer + ", device=" + this.device + ", apiVer=" + this.apiVer + ", pluginVer=" + this.pluginVer + ", abFactor=" + this.abFactor + ")";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qapmsdk.base.meta.UserMeta
 * JD-Core Version:    0.7.0.1
 */