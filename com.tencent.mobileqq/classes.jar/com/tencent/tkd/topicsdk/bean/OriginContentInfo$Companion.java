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
    long l1 = 3600;
    if (paramLong >= l1)
    {
      localObject = StringCompanionObject.INSTANCE;
      localObject = Locale.getDefault();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "Locale.getDefault()");
      arrayOfObject = new Object[3];
      arrayOfObject[0] = Long.valueOf(paramLong / l1);
      l2 = 60;
      arrayOfObject[1] = Long.valueOf(paramLong % l1 / l2);
      arrayOfObject[2] = Long.valueOf(paramLong % l2);
      localObject = String.format((Locale)localObject, "%02d:%02d:%02d", Arrays.copyOf(arrayOfObject, arrayOfObject.length));
      Intrinsics.checkExpressionValueIsNotNull(localObject, "java.lang.String.format(locale, format, *args)");
      return localObject;
    }
    Object localObject = StringCompanionObject.INSTANCE;
    localObject = Locale.getDefault();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "Locale.getDefault()");
    Object[] arrayOfObject = new Object[2];
    long l2 = 60;
    arrayOfObject[0] = Long.valueOf(paramLong % l1 / l2);
    arrayOfObject[1] = Long.valueOf(paramLong % l2);
    localObject = String.format((Locale)localObject, "%02d:%02d", Arrays.copyOf(arrayOfObject, arrayOfObject.length));
    Intrinsics.checkExpressionValueIsNotNull(localObject, "java.lang.String.format(locale, format, *args)");
    return localObject;
  }
  
  private final List<String> a(@NotNull JSONArray paramJSONArray)
  {
    List localList = (List)new ArrayList();
    int j = paramJSONArray.length();
    int i = 0;
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
    if (localObject != null)
    {
      int j = ((JSONObject)localObject).optInt("type");
      paramJSONObject = ((JSONObject)localObject).optJSONArray("imageUrlArray");
      if (paramJSONObject != null)
      {
        paramJSONObject = ((Companion)this).a(paramJSONObject);
        if (paramJSONObject != null) {}
      }
      else
      {
        paramJSONObject = (List)new ArrayList();
      }
      long l = ((JSONObject)localObject).optLong("duration");
      String str1 = ((JSONObject)localObject).optString("durationString");
      int k = ((JSONObject)localObject).optInt("repostLevel");
      String str2 = ((JSONObject)localObject).optString("userName");
      String str3 = ((JSONObject)localObject).optString("userId");
      String str4 = ((JSONObject)localObject).optString("jumpUrl");
      String str5 = ((JSONObject)localObject).optString("avatarUrl");
      String str6 = ((JSONObject)localObject).optString("defaultImageUrl");
      String str7 = ((JSONObject)localObject).optString("title");
      String str8 = ((JSONObject)localObject).optString("defaultTitle");
      String str9 = ((JSONObject)localObject).optString("summary");
      String str10 = ((JSONObject)localObject).optString("defaultSummary");
      String str11 = ((JSONObject)localObject).optString("contentInfo");
      String str12 = ((JSONObject)localObject).optString("originContentKey");
      String str13 = ((JSONObject)localObject).optString("repostContentKey");
      String str14 = ((JSONObject)localObject).optString("originJumpUrl");
      localObject = str1;
      if (l != 0L)
      {
        Intrinsics.checkExpressionValueIsNotNull(str1, "durationString");
        int i;
        if (((CharSequence)str1).length() == 0) {
          i = 1;
        } else {
          i = 0;
        }
        localObject = str1;
        if (i != 0) {
          localObject = ((Companion)this).a(l);
        }
      }
      Intrinsics.checkExpressionValueIsNotNull(localObject, "durationString");
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
      Intrinsics.checkExpressionValueIsNotNull(str14, "originJumpUrl");
      return new OriginContentInfo(j, paramJSONObject, l, (String)localObject, k, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.bean.OriginContentInfo.Companion
 * JD-Core Version:    0.7.0.1
 */