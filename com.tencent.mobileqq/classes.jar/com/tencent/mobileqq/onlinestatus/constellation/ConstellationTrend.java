package com.tencent.mobileqq.onlinestatus.constellation;

import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/onlinestatus/constellation/ConstellationTrend;", "", "constellationName", "", "trends", "", "trendsMap", "", "", "(Ljava/lang/String;Ljava/util/List;Ljava/util/Map;)V", "getConstellationName", "()Ljava/lang/String;", "setConstellationName", "(Ljava/lang/String;)V", "getTrends", "()Ljava/util/List;", "setTrends", "(Ljava/util/List;)V", "getTrendsMap", "()Ljava/util/Map;", "setTrendsMap", "(Ljava/util/Map;)V", "chosenTrend", "getTrend", "key", "parse", "text", "Companion", "qqonlinestatus-impl_release"}, k=1, mv={1, 1, 16})
public class ConstellationTrend
{
  private static final int jdField_a_of_type_Int = 1;
  public static final ConstellationTrend.Companion a;
  private static final int b = 2;
  @NotNull
  private String jdField_a_of_type_JavaLangString;
  @NotNull
  private List<String> jdField_a_of_type_JavaUtilList;
  @NotNull
  private Map<Integer, String> jdField_a_of_type_JavaUtilMap;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqOnlinestatusConstellationConstellationTrend$Companion = new ConstellationTrend.Companion(null);
  }
  
  public ConstellationTrend()
  {
    this(null, null, null, 7, null);
  }
  
  public ConstellationTrend(@NotNull String paramString, @NotNull List<String> paramList, @NotNull Map<Integer, String> paramMap)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_JavaUtilMap = paramMap;
  }
  
  @NotNull
  public final ConstellationTrend a(@Nullable String paramString)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("text: ");
      ((StringBuilder)localObject1).append(paramString);
      QLog.d("ConstellationTrend", 2, new Object[] { "parse: called. ", ((StringBuilder)localObject1).toString() });
    }
    for (;;)
    {
      try
      {
        localObject1 = new JSONObject(paramString);
        paramString = ((JSONObject)localObject1).optString("title");
        Intrinsics.checkExpressionValueIsNotNull(paramString, "optString(\"title\")");
        this.jdField_a_of_type_JavaLangString = paramString;
        paramString = this.jdField_a_of_type_JavaUtilList;
        Object localObject2 = ((JSONObject)localObject1).optString("lucky_color");
        Intrinsics.checkExpressionValueIsNotNull(localObject2, "luckyColor");
        if (((CharSequence)localObject2).length() > 0)
        {
          i = 1;
          if (i != 0)
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("今日幸运颜色为");
            ((StringBuilder)localObject3).append((String)localObject2);
            paramString.add(((StringBuilder)localObject3).toString());
            this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(jdField_a_of_type_Int), localObject2);
          }
          localObject2 = ((JSONObject)localObject1).optString("lucky_number");
          Intrinsics.checkExpressionValueIsNotNull(localObject2, "luckyNumber");
          if (((CharSequence)localObject2).length() <= 0) {
            break label599;
          }
          i = 1;
          if (i != 0)
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("今日幸运数字为");
            ((StringBuilder)localObject3).append((String)localObject2);
            paramString.add(((StringBuilder)localObject3).toString());
            this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(b), localObject2);
          }
          localObject2 = ((JSONObject)localObject1).optString("great_thing");
          Intrinsics.checkExpressionValueIsNotNull(localObject2, "greatThing");
          Object localObject3 = (CharSequence)localObject2;
          localObject3 = new Regex("[,，]").split((CharSequence)localObject3, 0);
          if (((StringsKt.isBlank((CharSequence)localObject2) ^ true)) && ((((Collection)localObject3).isEmpty() ^ true)))
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("今日宜");
            ((StringBuilder)localObject2).append((String)((List)localObject3).get(0));
            paramString.add(((StringBuilder)localObject2).toString());
          }
          localObject1 = ((JSONObject)localObject1).optString("speed_sign_name");
          Intrinsics.checkExpressionValueIsNotNull(localObject1, "speedSign");
          if (((CharSequence)localObject1).length() <= 0) {
            break label604;
          }
          i = 1;
          if (i != 0)
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("速配星座：");
            ((StringBuilder)localObject2).append((String)localObject1);
            paramString.add(((StringBuilder)localObject2).toString());
          }
          localObject1 = (Iterable)this.jdField_a_of_type_JavaUtilList;
          paramString = (Collection)new ArrayList();
          localObject1 = ((Iterable)localObject1).iterator();
          if (((Iterator)localObject1).hasNext())
          {
            localObject2 = ((Iterator)localObject1).next();
            if (((CharSequence)localObject2).length() <= 0) {
              break label609;
            }
            i = 1;
            if (i == 0) {
              continue;
            }
            paramString.add(localObject2);
            continue;
          }
          paramString = (List)paramString;
          return this;
        }
      }
      catch (Exception paramString)
      {
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("constellationName: ");
          ((StringBuilder)localObject1).append(this.jdField_a_of_type_JavaLangString);
          QLog.d("ConstellationTrend", 2, new Object[] { "parse: called. ", ((StringBuilder)localObject1).toString(), paramString });
        }
        return this;
      }
      int i = 0;
      continue;
      label599:
      i = 0;
      continue;
      label604:
      i = 0;
      continue;
      label609:
      i = 0;
    }
  }
  
  @NotNull
  public final String a()
  {
    if ((((Collection)this.jdField_a_of_type_JavaUtilList).isEmpty() ^ true)) {
      return (String)CollectionsKt.random((Collection)this.jdField_a_of_type_JavaUtilList, (Random)Random.Default);
    }
    return "";
  }
  
  @Nullable
  public final String a(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilMap.containsKey(Integer.valueOf(paramInt))) && (this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt)) != null)) {
      return (String)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt));
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.constellation.ConstellationTrend
 * JD-Core Version:    0.7.0.1
 */