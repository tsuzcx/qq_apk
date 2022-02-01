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
      str = URLEncoder.encode(Build.MODEL, "UTF-8");
      Intrinsics.checkExpressionValueIsNotNull(str, "URLEncoder.encode(Build.MODEL, \"UTF-8\")");
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      String str;
      label29:
      break label29;
    }
    str = "";
    DEVICE = str;
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
    if (this != paramObject)
    {
      if ((paramObject instanceof UserMeta))
      {
        paramObject = (UserMeta)paramObject;
        if ((Intrinsics.areEqual(this.uin, paramObject.uin)) && (Intrinsics.areEqual(this.uuid, paramObject.uuid)) && (Intrinsics.areEqual(this.appKey, paramObject.appKey)))
        {
          int i;
          if (this.appId == paramObject.appId) {
            i = 1;
          } else {
            i = 0;
          }
          if ((i != 0) && (Intrinsics.areEqual(this.version, paramObject.version)) && (Intrinsics.areEqual(this.deviceId, paramObject.deviceId)) && (Intrinsics.areEqual(this.sdkVersion, paramObject.sdkVersion)) && (Intrinsics.areEqual(this.os, paramObject.os)) && (Intrinsics.areEqual(this.manufacturer, paramObject.manufacturer)) && (Intrinsics.areEqual(this.device, paramObject.device)) && (Intrinsics.areEqual(this.apiVer, paramObject.apiVer)) && (Intrinsics.areEqual(this.pluginVer, paramObject.pluginVer)) && (Intrinsics.areEqual(this.abFactor, paramObject.abFactor))) {
            return true;
          }
        }
      }
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    String str = this.uin;
    int i7 = 0;
    int i;
    if (str != null) {
      i = str.hashCode();
    } else {
      i = 0;
    }
    str = this.uuid;
    int j;
    if (str != null) {
      j = str.hashCode();
    } else {
      j = 0;
    }
    str = this.appKey;
    int k;
    if (str != null) {
      k = str.hashCode();
    } else {
      k = 0;
    }
    int i8 = this.appId;
    str = this.version;
    int m;
    if (str != null) {
      m = str.hashCode();
    } else {
      m = 0;
    }
    str = this.deviceId;
    int n;
    if (str != null) {
      n = str.hashCode();
    } else {
      n = 0;
    }
    str = this.sdkVersion;
    int i1;
    if (str != null) {
      i1 = str.hashCode();
    } else {
      i1 = 0;
    }
    str = this.os;
    int i2;
    if (str != null) {
      i2 = str.hashCode();
    } else {
      i2 = 0;
    }
    str = this.manufacturer;
    int i3;
    if (str != null) {
      i3 = str.hashCode();
    } else {
      i3 = 0;
    }
    str = this.device;
    int i4;
    if (str != null) {
      i4 = str.hashCode();
    } else {
      i4 = 0;
    }
    str = this.apiVer;
    int i5;
    if (str != null) {
      i5 = str.hashCode();
    } else {
      i5 = 0;
    }
    str = this.pluginVer;
    int i6;
    if (str != null) {
      i6 = str.hashCode();
    } else {
      i6 = 0;
    }
    str = this.abFactor;
    if (str != null) {
      i7 = str.hashCode();
    }
    return (((((((((((i * 31 + j) * 31 + k) * 31 + i8) * 31 + m) * 31 + n) * 31 + i1) * 31 + i2) * 31 + i3) * 31 + i4) * 31 + i5) * 31 + i6) * 31 + i7;
  }
  
  @NotNull
  public String toJSON()
  {
    return JsonTransform.DefaultImpls.toJSON(this);
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("UserMeta(uin=");
    localStringBuilder.append(this.uin);
    localStringBuilder.append(", uuid=");
    localStringBuilder.append(this.uuid);
    localStringBuilder.append(", appKey=");
    localStringBuilder.append(this.appKey);
    localStringBuilder.append(", appId=");
    localStringBuilder.append(this.appId);
    localStringBuilder.append(", version=");
    localStringBuilder.append(this.version);
    localStringBuilder.append(", deviceId=");
    localStringBuilder.append(this.deviceId);
    localStringBuilder.append(", sdkVersion=");
    localStringBuilder.append(this.sdkVersion);
    localStringBuilder.append(", os=");
    localStringBuilder.append(this.os);
    localStringBuilder.append(", manufacturer=");
    localStringBuilder.append(this.manufacturer);
    localStringBuilder.append(", device=");
    localStringBuilder.append(this.device);
    localStringBuilder.append(", apiVer=");
    localStringBuilder.append(this.apiVer);
    localStringBuilder.append(", pluginVer=");
    localStringBuilder.append(this.pluginVer);
    localStringBuilder.append(", abFactor=");
    localStringBuilder.append(this.abFactor);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qapmsdk.base.meta.UserMeta
 * JD-Core Version:    0.7.0.1
 */