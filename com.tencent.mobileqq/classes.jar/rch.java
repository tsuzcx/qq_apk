import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/share/watchword/mvp/RIJReadWatchWordPresenter;", "Lcom/tencent/biz/pubaccount/readinjoy/share/watchword/mvp/IRIJReadWatchWordShareContract$IPresenter;", "model", "Lcom/tencent/biz/pubaccount/readinjoy/share/watchword/mvp/IRIJReadWatchWordShareContract$IModel;", "(Lcom/tencent/biz/pubaccount/readinjoy/share/watchword/mvp/IRIJReadWatchWordShareContract$IModel;)V", "view", "Lcom/tencent/biz/pubaccount/readinjoy/share/watchword/mvp/IRIJReadWatchWordShareContract$IView;", "attachView", "", "detachView", "requestWatchWordUrl", "watchWord", "", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class rch
{
  public static final rci a;
  private final rca jdField_a_of_type_Rca;
  private rcb jdField_a_of_type_Rcb;
  
  static
  {
    jdField_a_of_type_Rci = new rci(null);
  }
  
  public rch(@NotNull rca paramrca)
  {
    this.jdField_a_of_type_Rca = paramrca;
  }
  
  public void a(@NotNull rcb paramrcb)
  {
    Intrinsics.checkParameterIsNotNull(paramrcb, "view");
    this.jdField_a_of_type_Rcb = paramrcb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rch
 * JD-Core Version:    0.7.0.1
 */