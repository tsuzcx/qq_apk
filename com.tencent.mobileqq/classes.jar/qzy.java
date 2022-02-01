import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/share/watchword/mvp/RIJReadWatchWordPresenter;", "Lcom/tencent/biz/pubaccount/readinjoy/share/watchword/mvp/IRIJReadWatchWordShareContract$IPresenter;", "model", "Lcom/tencent/biz/pubaccount/readinjoy/share/watchword/mvp/IRIJReadWatchWordShareContract$IModel;", "(Lcom/tencent/biz/pubaccount/readinjoy/share/watchword/mvp/IRIJReadWatchWordShareContract$IModel;)V", "view", "Lcom/tencent/biz/pubaccount/readinjoy/share/watchword/mvp/IRIJReadWatchWordShareContract$IView;", "attachView", "", "detachView", "requestWatchWordUrl", "watchWord", "", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class qzy
{
  public static final qzz a;
  private final qzr jdField_a_of_type_Qzr;
  private qzs jdField_a_of_type_Qzs;
  
  static
  {
    jdField_a_of_type_Qzz = new qzz(null);
  }
  
  public qzy(@NotNull qzr paramqzr)
  {
    this.jdField_a_of_type_Qzr = paramqzr;
  }
  
  public void a(@NotNull qzs paramqzs)
  {
    Intrinsics.checkParameterIsNotNull(paramqzs, "view");
    this.jdField_a_of_type_Qzs = paramqzs;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qzy
 * JD-Core Version:    0.7.0.1
 */