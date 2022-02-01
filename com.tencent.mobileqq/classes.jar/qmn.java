import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/pts/lite/PTSLiteSwiperEventDispatcher$Builder;", "", "()V", "adapter", "Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoyBaseAdapter;", "getAdapter", "()Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoyBaseAdapter;", "setAdapter", "(Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoyBaseAdapter;)V", "articleInfoMap", "Ljava/util/HashMap;", "", "Lcom/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo;", "Lkotlin/collections/HashMap;", "getArticleInfoMap", "()Ljava/util/HashMap;", "setArticleInfoMap", "(Ljava/util/HashMap;)V", "positionMap", "", "getPositionMap", "setPositionMap", "build", "Lcom/tencent/biz/pubaccount/readinjoy/pts/lite/PTSLiteSwiperEventDispatcher;", "withArticleInfoMap", "withPositionMap", "withRIJAdapter", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class qmn
{
  @NotNull
  private HashMap<String, Integer> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  @Nullable
  private slt jdField_a_of_type_Slt;
  @NotNull
  private HashMap<String, ArticleInfo> b = new HashMap();
  
  @NotNull
  public final qmm a()
  {
    qmm localqmm = new qmm(null);
    qmm.a(localqmm, this.jdField_a_of_type_Slt);
    qmm.a(localqmm, this.jdField_a_of_type_JavaUtilHashMap);
    qmm.b(localqmm, this.b);
    return localqmm;
  }
  
  @NotNull
  public final qmn a(@NotNull HashMap<String, Integer> paramHashMap)
  {
    Intrinsics.checkParameterIsNotNull(paramHashMap, "positionMap");
    this.jdField_a_of_type_JavaUtilHashMap = paramHashMap;
    return this;
  }
  
  @NotNull
  public final qmn a(@NotNull slt paramslt)
  {
    Intrinsics.checkParameterIsNotNull(paramslt, "adapter");
    this.jdField_a_of_type_Slt = paramslt;
    return this;
  }
  
  @NotNull
  public final qmn b(@NotNull HashMap<String, ArticleInfo> paramHashMap)
  {
    Intrinsics.checkParameterIsNotNull(paramHashMap, "articleInfoMap");
    this.b = paramHashMap;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qmn
 * JD-Core Version:    0.7.0.1
 */