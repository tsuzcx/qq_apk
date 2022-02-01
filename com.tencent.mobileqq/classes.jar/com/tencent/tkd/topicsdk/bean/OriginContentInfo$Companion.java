package com.tencent.tkd.topicsdk.bean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/bean/OriginContentInfo$Companion;", "", "()V", "TYPE_UNKNOWN", "", "TYPE_WITH_IMAGE", "TYPE_WITH_VIDEO", "serialVersionUID", "", "getFormatDurationString", "", "duration", "parseFromJson", "Lcom/tencent/tkd/topicsdk/bean/OriginContentInfo;", "eventInfoJson", "Lorg/json/JSONObject;", "toStringArray", "", "Lorg/json/JSONArray;", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class OriginContentInfo$Companion
{
  private final String a(long paramLong)
  {
    if (paramLong >= 3600)
    {
      localObject = StringCompanionObject.INSTANCE;
      localObject = Locale.getDefault();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "Locale.getDefault()");
      arrayOfObject = new Object[3];
      arrayOfObject[0] = Long.valueOf(paramLong / 3600);
      arrayOfObject[1] = Long.valueOf(paramLong % 3600 / 60);
      arrayOfObject[2] = Long.valueOf(paramLong % 60);
      localObject = String.format((Locale)localObject, "%02d:%02d:%02d", Arrays.copyOf(arrayOfObject, arrayOfObject.length));
      Intrinsics.checkExpressionValueIsNotNull(localObject, "java.lang.String.format(locale, format, *args)");
      return localObject;
    }
    Object localObject = StringCompanionObject.INSTANCE;
    localObject = Locale.getDefault();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "Locale.getDefault()");
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = Long.valueOf(paramLong % 3600 / 60);
    arrayOfObject[1] = Long.valueOf(paramLong % 60);
    localObject = String.format((Locale)localObject, "%02d:%02d", Arrays.copyOf(arrayOfObject, arrayOfObject.length));
    Intrinsics.checkExpressionValueIsNotNull(localObject, "java.lang.String.format(locale, format, *args)");
    return localObject;
  }
  
  private final List<String> a(@NotNull JSONArray paramJSONArray)
  {
    List localList = (List)new ArrayList();
    int i = 0;
    int j = paramJSONArray.length();
    while (i < j)
    {
      String str = paramJSONArray.optString(i);
      Intrinsics.checkExpressionValueIsNotNull(str, "this.optString(i)");
      localList.add(str);
      i += 1;
    }
    return localList;
  }
  
  @Nullable
  public final OriginContentInfo a(@NotNull JSONObject paramJSONObject)
  {
    Intrinsics.checkParameterIsNotNull(paramJSONObject, "eventInfoJson");
    Object localObject = paramJSONObject.optJSONObject("originContentInfo");
    int j;
    long l;
    String str1;
    int k;
    String str2;
    String str3;
    String str4;
    String str5;
    String str6;
    String str7;
    String str8;
    String str9;
    String str10;
    String str11;
    String str12;
    String str13;
    int i;
    if (localObject != null)
    {
      j = ((JSONObject)localObject).optInt("type");
      paramJSONObject = ((JSONObject)localObject).optJSONArray("imageUrlArray");
      if (paramJSONObject == null) {
        break label382;
      }
      paramJSONObject = ((Companion)this).a(paramJSONObject);
      if (paramJSONObject == null) {
        break label382;
      }
      l = ((JSONObject)localObject).optLong("duration");
      str1 = ((JSONObject)localObject).optString("durationString");
      k = ((JSONObject)localObject).optInt("repostLevel");
      str2 = ((JSONObject)localObject).optString("userName");
      str3 = ((JSONObject)localObject).optString("userId");
      str4 = ((JSONObject)localObject).optString("jumpUrl");
      str5 = ((JSONObject)localObject).optString("avatarUrl");
      str6 = ((JSONObject)localObject).optString("defaultImageUrl");
      str7 = ((JSONObject)localObject).optString("title");
      str8 = ((JSONObject)localObject).optString("defaultTitle");
      str9 = ((JSONObject)localObject).optString("summary");
      str10 = ((JSONObject)localObject).optString("defaultSummary");
      str11 = ((JSONObject)localObject).optString("contentInfo");
      str12 = ((JSONObject)localObject).optString("originContentKey");
      str13 = ((JSONObject)localObject).optString("repostContentKey");
      localObject = ((JSONObject)localObject).optString("originJumpUrl");
      if (l == 0L) {
        break label401;
      }
      Intrinsics.checkExpressionValueIsNotNull(str1, "durationString");
      if (((CharSequence)str1).length() != 0) {
        break label396;
      }
      i = 1;
      label225:
      if (i == 0) {
        break label401;
      }
      str1 = ((Companion)this).a(l);
    }
    label396:
    label401:
    for (;;)
    {
      Intrinsics.checkExpressionValueIsNotNull(str1, "durationString");
      Intrinsics.checkExpressionValueIsNotNull(str2, "userName");
      Intrinsics.checkExpressionValueIsNotNull(str3, "userId");
      Intrinsics.checkExpressionValueIsNotNull(str4, "jumpUrl");
      Intrinsics.checkExpressionValueIsNotNull(str5, "avatarUrl");
      Intrinsics.checkExpressionValueIsNotNull(str6, "defaultImageUrl");
      Intrinsics.checkExpressionValueIsNotNull(str7, "title");
      Intrinsics.checkExpressionValueIsNotNull(str8, "defaultTitle");
      Intrinsics.checkExpressionValueIsNotNull(str9, "summary");
      Intrinsics.checkExpressionValueIsNotNull(str10, "defaultSummary");
      Intrinsics.checkExpressionValueIsNotNull(str11, "contentInfo");
      Intrinsics.checkExpressionValueIsNotNull(str12, "originContentKey");
      Intrinsics.checkExpressionValueIsNotNull(str13, "repostContentKey");
      Intrinsics.checkExpressionValueIsNotNull(localObject, "originJumpUrl");
      return new OriginContentInfo(j, paramJSONObject, l, str1, k, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, (String)localObject);
      return null;
      label382:
      paramJSONObject = (List)new ArrayList();
      break;
      i = 0;
      break label225;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.bean.OriginContentInfo.Companion
 * JD-Core Version:    0.7.0.1
 */