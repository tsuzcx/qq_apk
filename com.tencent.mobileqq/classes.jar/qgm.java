import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/pts/lite/PTSLiteSwiperEventDispatcher$Builder;", "", "()V", "adapter", "Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoyBaseAdapter;", "getAdapter", "()Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoyBaseAdapter;", "setAdapter", "(Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoyBaseAdapter;)V", "articleInfoMap", "Ljava/util/HashMap;", "", "Lcom/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo;", "Lkotlin/collections/HashMap;", "getArticleInfoMap", "()Ljava/util/HashMap;", "setArticleInfoMap", "(Ljava/util/HashMap;)V", "positionMap", "", "getPositionMap", "setPositionMap", "build", "Lcom/tencent/biz/pubaccount/readinjoy/pts/lite/PTSLiteSwiperEventDispatcher;", "withArticleInfoMap", "withPositionMap", "withRIJAdapter", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class qgm
{
  @NotNull
  private HashMap<String, Integer> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  @Nullable
  private sel jdField_a_of_type_Sel;
  @NotNull
  private HashMap<String, ArticleInfo> b = new HashMap();
  
  @NotNull
  public final qgl a()
  {
    qgl localqgl = new qgl(null);
    qgl.a(localqgl, this.jdField_a_of_type_Sel);
    qgl.a(localqgl, this.jdField_a_of_type_JavaUtilHashMap);
    qgl.b(localqgl, this.b);
    return localqgl;
  }
  
  @NotNull
  public final qgm a(@NotNull HashMap<String, Integer> paramHashMap)
  {
    Intrinsics.checkParameterIsNotNull(paramHashMap, "positionMap");
    this.jdField_a_of_type_JavaUtilHashMap = paramHashMap;
    return this;
  }
  
  @NotNull
  public final qgm a(@NotNull sel paramsel)
  {
    Intrinsics.checkParameterIsNotNull(paramsel, "adapter");
    this.jdField_a_of_type_Sel = paramsel;
    return this;
  }
  
  @NotNull
  public final qgm b(@NotNull HashMap<String, ArticleInfo> paramHashMap)
  {
    Intrinsics.checkParameterIsNotNull(paramHashMap, "articleInfoMap");
    this.b = paramHashMap;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qgm
 * JD-Core Version:    0.7.0.1
 */