package com.tencent.mobileqq.kandian.biz.pts.lite;

import java.util.HashMap;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/pts/lite/PTSLiteSwiperEventDispatcher$ItemExposureData;", "", "identifier", "", "dataSet", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "folderStatus", "(Ljava/lang/String;Ljava/util/HashMap;Ljava/lang/String;)V", "getDataSet", "()Ljava/util/HashMap;", "setDataSet", "(Ljava/util/HashMap;)V", "getFolderStatus", "()Ljava/lang/String;", "setFolderStatus", "(Ljava/lang/String;)V", "getIdentifier", "setIdentifier", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class PTSLiteSwiperEventDispatcher$ItemExposureData
{
  @Nullable
  private String jdField_a_of_type_JavaLangString;
  @NotNull
  private HashMap<String, String> jdField_a_of_type_JavaUtilHashMap;
  @Nullable
  private String b;
  
  public PTSLiteSwiperEventDispatcher$ItemExposureData()
  {
    this(null, null, null, 7, null);
  }
  
  public PTSLiteSwiperEventDispatcher$ItemExposureData(@Nullable String paramString1, @NotNull HashMap<String, String> paramHashMap, @Nullable String paramString2)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_JavaUtilHashMap = paramHashMap;
    this.b = paramString2;
  }
  
  @Nullable
  public final String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  @NotNull
  public final HashMap<String, String> a()
  {
    return this.jdField_a_of_type_JavaUtilHashMap;
  }
  
  @Nullable
  public final String b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.lite.PTSLiteSwiperEventDispatcher.ItemExposureData
 * JD-Core Version:    0.7.0.1
 */