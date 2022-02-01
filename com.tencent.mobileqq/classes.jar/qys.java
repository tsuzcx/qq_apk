import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/pts/lite/PTSLiteSwiperEventDispatcher$Builder;", "", "()V", "adapter", "Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoyBaseAdapter;", "getAdapter", "()Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoyBaseAdapter;", "setAdapter", "(Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoyBaseAdapter;)V", "articleInfoMap", "Ljava/util/HashMap;", "", "Lcom/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo;", "Lkotlin/collections/HashMap;", "getArticleInfoMap", "()Ljava/util/HashMap;", "setArticleInfoMap", "(Ljava/util/HashMap;)V", "positionMap", "", "getPositionMap", "setPositionMap", "build", "Lcom/tencent/biz/pubaccount/readinjoy/pts/lite/PTSLiteSwiperEventDispatcher;", "withArticleInfoMap", "withPositionMap", "withRIJAdapter", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class qys
{
  @NotNull
  private HashMap<String, Integer> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  @Nullable
  private szd jdField_a_of_type_Szd;
  @NotNull
  private HashMap<String, ArticleInfo> b = new HashMap();
  
  @NotNull
  public final qyr a()
  {
    qyr localqyr = new qyr(null);
    qyr.a(localqyr, this.jdField_a_of_type_Szd);
    qyr.a(localqyr, this.jdField_a_of_type_JavaUtilHashMap);
    qyr.b(localqyr, this.b);
    return localqyr;
  }
  
  @NotNull
  public final qys a(@NotNull HashMap<String, Integer> paramHashMap)
  {
    Intrinsics.checkParameterIsNotNull(paramHashMap, "positionMap");
    this.jdField_a_of_type_JavaUtilHashMap = paramHashMap;
    return this;
  }
  
  @NotNull
  public final qys a(@NotNull szd paramszd)
  {
    Intrinsics.checkParameterIsNotNull(paramszd, "adapter");
    this.jdField_a_of_type_Szd = paramszd;
    return this;
  }
  
  @NotNull
  public final qys b(@NotNull HashMap<String, ArticleInfo> paramHashMap)
  {
    Intrinsics.checkParameterIsNotNull(paramHashMap, "articleInfoMap");
    this.b = paramHashMap;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qys
 * JD-Core Version:    0.7.0.1
 */