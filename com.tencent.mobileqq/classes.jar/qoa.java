import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/pts/lite/PTSLiteSwiperEventDispatcher$Builder;", "", "()V", "adapter", "Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoyBaseAdapter;", "getAdapter", "()Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoyBaseAdapter;", "setAdapter", "(Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoyBaseAdapter;)V", "articleInfoMap", "Ljava/util/HashMap;", "", "Lcom/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo;", "Lkotlin/collections/HashMap;", "getArticleInfoMap", "()Ljava/util/HashMap;", "setArticleInfoMap", "(Ljava/util/HashMap;)V", "positionMap", "", "getPositionMap", "setPositionMap", "build", "Lcom/tencent/biz/pubaccount/readinjoy/pts/lite/PTSLiteSwiperEventDispatcher;", "withArticleInfoMap", "withPositionMap", "withRIJAdapter", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class qoa
{
  @NotNull
  private HashMap<String, Integer> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  @Nullable
  private snh jdField_a_of_type_Snh;
  @NotNull
  private HashMap<String, ArticleInfo> b = new HashMap();
  
  @NotNull
  public final qnz a()
  {
    qnz localqnz = new qnz(null);
    qnz.a(localqnz, this.jdField_a_of_type_Snh);
    qnz.a(localqnz, this.jdField_a_of_type_JavaUtilHashMap);
    qnz.b(localqnz, this.b);
    return localqnz;
  }
  
  @NotNull
  public final qoa a(@NotNull HashMap<String, Integer> paramHashMap)
  {
    Intrinsics.checkParameterIsNotNull(paramHashMap, "positionMap");
    this.jdField_a_of_type_JavaUtilHashMap = paramHashMap;
    return this;
  }
  
  @NotNull
  public final qoa a(@NotNull snh paramsnh)
  {
    Intrinsics.checkParameterIsNotNull(paramsnh, "adapter");
    this.jdField_a_of_type_Snh = paramsnh;
    return this;
  }
  
  @NotNull
  public final qoa b(@NotNull HashMap<String, ArticleInfo> paramHashMap)
  {
    Intrinsics.checkParameterIsNotNull(paramHashMap, "articleInfoMap");
    this.b = paramHashMap;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qoa
 * JD-Core Version:    0.7.0.1
 */