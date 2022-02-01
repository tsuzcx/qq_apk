package com.tencent.tkd.topicsdk.mediaselector;

import android.content.Context;
import com.tencent.tkd.topicsdk.bean.Media;
import com.tencent.tkd.topicsdk.framework.ThreadManagerKt;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/mediaselector/MediaDataManager;", "", "()V", "currentPhotoMap", "Ljava/util/HashMap;", "", "Ljava/util/ArrayList;", "Lcom/tencent/tkd/topicsdk/bean/Media;", "Lkotlin/collections/ArrayList;", "Lkotlin/collections/HashMap;", "getPhotoMediaList", "", "dir", "loadPhotos", "", "context", "Landroid/content/Context;", "callback", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "mediaList", "mediaMap", "loadVideos", "updatePhotoMap", "photoMap", "allMediaList", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class MediaDataManager
{
  public static final MediaDataManager a;
  private static final HashMap<String, ArrayList<Media>> a;
  
  static
  {
    jdField_a_of_type_ComTencentTkdTopicsdkMediaselectorMediaDataManager = new MediaDataManager();
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  private final void a(HashMap<String, ArrayList<Media>> paramHashMap, ArrayList<Media> paramArrayList)
  {
    try
    {
      jdField_a_of_type_JavaUtilHashMap.clear();
      ((Map)jdField_a_of_type_JavaUtilHashMap).put("", paramArrayList);
      jdField_a_of_type_JavaUtilHashMap.putAll((Map)paramHashMap);
      return;
    }
    finally
    {
      paramHashMap = finally;
      throw paramHashMap;
    }
  }
  
  @NotNull
  public final List<Media> a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "dir");
    paramString = (ArrayList)jdField_a_of_type_JavaUtilHashMap.get(paramString);
    if (paramString != null) {
      return (List)paramString;
    }
    return CollectionsKt.emptyList();
  }
  
  public final void a(@NotNull Context paramContext, @NotNull Function2<? super ArrayList<Media>, ? super HashMap<String, ArrayList<Media>>, Unit> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "callback");
    ThreadManagerKt.c((Function0)new MediaDataManager.loadPhotos.1(paramContext, paramFunction2));
  }
  
  public final void b(@NotNull Context paramContext, @NotNull Function2<? super ArrayList<Media>, ? super HashMap<String, ArrayList<Media>>, Unit> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "callback");
    ThreadManagerKt.c((Function0)new MediaDataManager.loadVideos.1(paramContext, paramFunction2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.mediaselector.MediaDataManager
 * JD-Core Version:    0.7.0.1
 */