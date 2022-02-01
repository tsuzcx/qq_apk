import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/share/watchword/mvp/RIJReadWatchWordPresenter;", "Lcom/tencent/biz/pubaccount/readinjoy/share/watchword/mvp/IRIJReadWatchWordShareContract$IPresenter;", "model", "Lcom/tencent/biz/pubaccount/readinjoy/share/watchword/mvp/IRIJReadWatchWordShareContract$IModel;", "(Lcom/tencent/biz/pubaccount/readinjoy/share/watchword/mvp/IRIJReadWatchWordShareContract$IModel;)V", "view", "Lcom/tencent/biz/pubaccount/readinjoy/share/watchword/mvp/IRIJReadWatchWordShareContract$IView;", "attachView", "", "detachView", "requestWatchWordUrl", "watchWord", "", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class qta
{
  public static final qtb a;
  private final qst jdField_a_of_type_Qst;
  private qsu jdField_a_of_type_Qsu;
  
  static
  {
    jdField_a_of_type_Qtb = new qtb(null);
  }
  
  public qta(@NotNull qst paramqst)
  {
    this.jdField_a_of_type_Qst = paramqst;
  }
  
  public void a(@NotNull qsu paramqsu)
  {
    Intrinsics.checkParameterIsNotNull(paramqsu, "view");
    this.jdField_a_of_type_Qsu = paramqsu;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qta
 * JD-Core Version:    0.7.0.1
 */