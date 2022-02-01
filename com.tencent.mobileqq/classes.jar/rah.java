import com.tencent.biz.pubaccount.readinjoy.share.watchword.mvp.RIJWriteWatchWordPresenter.fetchTopicWatchWord.1;
import com.tencent.biz.pubaccount.readinjoy.share.watchword.mvp.RIJWriteWatchWordPresenter.fetchVideoWatchWord.1;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/share/watchword/mvp/RIJWriteWatchWordPresenter;", "Lcom/tencent/biz/pubaccount/readinjoy/share/watchword/mvp/IRIJWriteWatchWordShareContract$IPresenter;", "model", "Lcom/tencent/biz/pubaccount/readinjoy/share/watchword/mvp/IRIJWriteWatchWordShareContract$IModel;", "(Lcom/tencent/biz/pubaccount/readinjoy/share/watchword/mvp/IRIJWriteWatchWordShareContract$IModel;)V", "view", "Lcom/tencent/biz/pubaccount/readinjoy/share/watchword/mvp/IRIJWriteWatchWordShareContract$IView;", "attachView", "", "detachView", "fetchTopicWatchWord", "topicId", "", "url", "title", "fetchVideoWatchWord", "rowkey", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class rah
{
  private final qzu jdField_a_of_type_Qzu;
  private qzv jdField_a_of_type_Qzv;
  
  public rah(@NotNull qzu paramqzu)
  {
    this.jdField_a_of_type_Qzu = paramqzu;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Qzv = ((qzv)null);
  }
  
  public void a(@NotNull String paramString1, @NotNull String paramString2, @Nullable String paramString3)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "topicId");
    Intrinsics.checkParameterIsNotNull(paramString2, "url");
    qzu localqzu = this.jdField_a_of_type_Qzu;
    if (paramString3 != null) {}
    for (String str = paramString3;; str = "")
    {
      localqzu.a(paramString1, paramString2, str, (Function3)new RIJWriteWatchWordPresenter.fetchTopicWatchWord.1(this, paramString3, paramString2));
      return;
    }
  }
  
  public void a(@NotNull String paramString1, @NotNull String paramString2, @Nullable String paramString3, @Nullable String paramString4)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "rowkey");
    Intrinsics.checkParameterIsNotNull(paramString2, "url");
    qzu localqzu = this.jdField_a_of_type_Qzu;
    if (paramString4 != null) {}
    for (String str = paramString4;; str = "")
    {
      localqzu.a(paramString1, paramString2, paramString3, str, (Function3)new RIJWriteWatchWordPresenter.fetchVideoWatchWord.1(this, paramString4, paramString2));
      return;
    }
  }
  
  public void a(@NotNull qzv paramqzv)
  {
    Intrinsics.checkParameterIsNotNull(paramqzv, "view");
    this.jdField_a_of_type_Qzv = paramqzv;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rah
 * JD-Core Version:    0.7.0.1
 */