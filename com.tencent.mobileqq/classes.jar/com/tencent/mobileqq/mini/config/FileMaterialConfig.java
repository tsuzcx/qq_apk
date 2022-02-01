package com.tencent.mobileqq.mini.config;

import com.tencent.mobileqq.mini.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/mini/config/FileMaterialConfig;", "", "()V", "mTypeList", "", "Lcom/tencent/mobileqq/mini/config/FileMaterialConfig$Item;", "getFileMimeType", "", "filePath", "isMimeTypeSupported", "", "mimeType", "parse", "", "content", "toString", "Companion", "Item", "qqmini_impl_release"}, k=1, mv={1, 1, 16})
public final class FileMaterialConfig
{
  public static final FileMaterialConfig.Companion Companion = new FileMaterialConfig.Companion(null);
  private static final String TAG = "FileMaterialConfig";
  private List<FileMaterialConfig.Item> mTypeList = CollectionsKt.emptyList();
  
  @Nullable
  public final String getFileMimeType(@Nullable String paramString)
  {
    Object localObject1 = (CharSequence)paramString;
    int j = 0;
    int i;
    if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
      i = 0;
    } else {
      i = 1;
    }
    if (i != 0) {
      return null;
    }
    localObject1 = FileUtils.getFileExtensionWithDot(paramString);
    Object localObject2 = (CharSequence)localObject1;
    if ((localObject2 != null) && (((CharSequence)localObject2).length() != 0)) {
      i = 0;
    } else {
      i = 1;
    }
    if (i != 0) {
      return null;
    }
    localObject2 = ((Iterable)this.mTypeList).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      FileMaterialConfig.Item localItem = (FileMaterialConfig.Item)((Iterator)localObject2).next();
      if (Intrinsics.areEqual(localItem.getExt(), localObject1)) {
        return localItem.getMimeType();
      }
    }
    localObject1 = FileUtils.getFileExtension(paramString);
    paramString = com.tencent.smtt.sdk.MimeTypeMap.getSingleton().getMimeTypeFromExtension((String)localObject1);
    localObject2 = (CharSequence)paramString;
    if (localObject2 != null)
    {
      i = j;
      if (((CharSequence)localObject2).length() != 0) {}
    }
    else
    {
      i = 1;
    }
    if (i != 0) {
      paramString = android.webkit.MimeTypeMap.getSingleton().getMimeTypeFromExtension((String)localObject1);
    }
    return paramString;
  }
  
  public final boolean isMimeTypeSupported(@Nullable String paramString)
  {
    Object localObject = (CharSequence)paramString;
    int i;
    if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
      i = 0;
    } else {
      i = 1;
    }
    if (i != 0) {
      return false;
    }
    localObject = this.mTypeList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = ((FileMaterialConfig.Item)((Iterator)localObject).next()).getMimeType();
      if (Intrinsics.areEqual(paramString, str)) {
        return true;
      }
      if ((StringsKt.endsWith$default(str, "/*", false, 2, null)) && (Intrinsics.areEqual(StringsKt.substringBeforeLast$default(str, "/", null, 2, null), StringsKt.substringBeforeLast$default(paramString, "/", null, 2, null)))) {
        return true;
      }
    }
    return false;
  }
  
  public final void parse(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "content");
    try
    {
      paramString = new JSONObject(paramString).optJSONArray("typeList");
      List localList = (List)new ArrayList();
      int i = 0;
      int j = paramString.length();
      while (i < j)
      {
        Object localObject = paramString.optJSONObject(i);
        String str = ((JSONObject)localObject).getString("mt");
        Intrinsics.checkExpressionValueIsNotNull(str, "itemJson.getString(\"mt\")");
        localObject = ((JSONObject)localObject).getString("ext");
        Intrinsics.checkExpressionValueIsNotNull(localObject, "itemJson.getString(\"ext\")");
        localList.add(new FileMaterialConfig.Item(str, (String)localObject));
        i += 1;
      }
      this.mTypeList = localList;
      paramString = new StringBuilder();
      paramString.append("Config.parse: size=");
      paramString.append(this.mTypeList.size());
      QLog.i("FileMaterialConfig", 1, paramString.toString());
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("FileMaterialConfig", 1, "Config.parse:", (Throwable)paramString);
    }
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("FileMaterialConfig: ");
    localStringBuilder.append(this.mTypeList);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.config.FileMaterialConfig
 * JD-Core Version:    0.7.0.1
 */