import android.view.View;
import com.tencent.biz.pubaccount.VideoInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsGuideProxy;", "", "()V", "columnGuideManager", "Lcom/tencent/biz/pubaccount/readinjoy/video/column/VideoColumnGuideManager;", "getColumnGuideManager", "()Lcom/tencent/biz/pubaccount/readinjoy/video/column/VideoColumnGuideManager;", "setColumnGuideManager", "(Lcom/tencent/biz/pubaccount/readinjoy/video/column/VideoColumnGuideManager;)V", "hasShowVideoColumnGuide", "", "userGuideController", "Lcom/tencent/biz/pubaccount/readinjoy/video/VideofeedsUserGuideController;", "getUserGuideController", "()Lcom/tencent/biz/pubaccount/readinjoy/video/VideofeedsUserGuideController;", "setUserGuideController", "(Lcom/tencent/biz/pubaccount/readinjoy/video/VideofeedsUserGuideController;)V", "dismissGuideAnim", "", "getPlayPercent", "", "currentTs", "", "playParam", "Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager$VideoPlayParam;", "hideUserGuide", "needShowVideoColumnGuide", "onVideoProgressChange", "rootView", "Landroid/view/View;", "videoRootView", "setFullScreen", "fullScreen", "setNeedUserGuide", "needGuide", "showUserGuide", "videoInfo", "Lcom/tencent/biz/pubaccount/VideoInfo;", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class ryr
{
  public static final rys a;
  @Nullable
  private sgp jdField_a_of_type_Sgp;
  @Nullable
  private shi jdField_a_of_type_Shi;
  private boolean jdField_a_of_type_Boolean;
  
  static
  {
    jdField_a_of_type_Rys = new rys(null);
  }
  
  private final float a(long paramLong, sar paramsar)
  {
    paramsar = paramsar.jdField_a_of_type_Sfb;
    if (paramsar != null) {}
    for (long l = paramsar.b();; l = 0L) {
      return (float)paramLong * 100.0F / (float)l;
    }
  }
  
  private final boolean a(long paramLong, sar paramsar)
  {
    return (siy.a.a()) && (!this.jdField_a_of_type_Boolean) && (a(paramLong, paramsar) >= 20) && (paramsar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a != null);
  }
  
  public final void a()
  {
    sgp localsgp = this.jdField_a_of_type_Sgp;
    if (localsgp != null) {
      localsgp.a();
    }
  }
  
  public final void a(@NotNull VideoInfo paramVideoInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramVideoInfo, "videoInfo");
    if (paramVideoInfo.a == null)
    {
      sgp localsgp = this.jdField_a_of_type_Sgp;
      if (localsgp != null) {
        localsgp.a(paramVideoInfo);
      }
    }
  }
  
  public final void a(@NotNull sar paramsar, long paramLong, @NotNull View paramView1, @NotNull View paramView2)
  {
    Intrinsics.checkParameterIsNotNull(paramsar, "playParam");
    Intrinsics.checkParameterIsNotNull(paramView1, "rootView");
    Intrinsics.checkParameterIsNotNull(paramView2, "videoRootView");
    if (a(paramLong, paramsar))
    {
      paramsar = this.jdField_a_of_type_Shi;
      if (paramsar == null) {
        break label55;
      }
    }
    label55:
    for (boolean bool = paramsar.a(paramView1, paramView2);; bool = false)
    {
      this.jdField_a_of_type_Boolean = bool;
      return;
    }
  }
  
  public final void a(@Nullable sgp paramsgp)
  {
    this.jdField_a_of_type_Sgp = paramsgp;
  }
  
  public final void a(@Nullable shi paramshi)
  {
    this.jdField_a_of_type_Shi = paramshi;
  }
  
  public final void a(boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_Sgp;
    if (localObject != null) {
      ((sgp)localObject).a(paramBoolean);
    }
    localObject = this.jdField_a_of_type_Shi;
    if (localObject != null) {
      ((shi)localObject).a(paramBoolean);
    }
  }
  
  public final void b()
  {
    Object localObject = this.jdField_a_of_type_Sgp;
    if (localObject != null) {
      ((sgp)localObject).b();
    }
    localObject = this.jdField_a_of_type_Shi;
    if (localObject != null) {
      ((shi)localObject).a();
    }
  }
  
  public final void b(boolean paramBoolean)
  {
    sgp localsgp = this.jdField_a_of_type_Sgp;
    if (localsgp != null) {
      localsgp.b(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ryr
 * JD-Core Version:    0.7.0.1
 */