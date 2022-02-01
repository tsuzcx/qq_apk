import android.view.View;
import com.tencent.biz.pubaccount.VideoInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsGuideProxy;", "", "()V", "columnGuideManager", "Lcom/tencent/biz/pubaccount/readinjoy/video/column/VideoColumnGuideManager;", "getColumnGuideManager", "()Lcom/tencent/biz/pubaccount/readinjoy/video/column/VideoColumnGuideManager;", "setColumnGuideManager", "(Lcom/tencent/biz/pubaccount/readinjoy/video/column/VideoColumnGuideManager;)V", "hasShowVideoColumnGuide", "", "userGuideController", "Lcom/tencent/biz/pubaccount/readinjoy/video/VideofeedsUserGuideController;", "getUserGuideController", "()Lcom/tencent/biz/pubaccount/readinjoy/video/VideofeedsUserGuideController;", "setUserGuideController", "(Lcom/tencent/biz/pubaccount/readinjoy/video/VideofeedsUserGuideController;)V", "dismissGuideAnim", "", "getPlayPercent", "", "currentTs", "", "playParam", "Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager$VideoPlayParam;", "hideUserGuide", "needShowVideoColumnGuide", "onVideoProgressChange", "rootView", "Landroid/view/View;", "videoRootView", "setFullScreen", "fullScreen", "setNeedUserGuide", "needGuide", "showUserGuide", "videoInfo", "Lcom/tencent/biz/pubaccount/VideoInfo;", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class rpn
{
  public static final rpo a;
  @Nullable
  private rxt jdField_a_of_type_Rxt;
  @Nullable
  private rym jdField_a_of_type_Rym;
  private boolean jdField_a_of_type_Boolean;
  
  static
  {
    jdField_a_of_type_Rpo = new rpo(null);
  }
  
  private final float a(long paramLong, rrm paramrrm)
  {
    paramrrm = paramrrm.jdField_a_of_type_Rwf;
    if (paramrrm != null) {}
    for (long l = paramrrm.b();; l = 0L) {
      return (float)paramLong * 100.0F / (float)l;
    }
  }
  
  private final boolean a(long paramLong, rrm paramrrm)
  {
    return (sac.a.a()) && (!this.jdField_a_of_type_Boolean) && (a(paramLong, paramrrm) >= 20) && (paramrrm.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a != null);
  }
  
  public final void a()
  {
    rxt localrxt = this.jdField_a_of_type_Rxt;
    if (localrxt != null) {
      localrxt.a();
    }
  }
  
  public final void a(@NotNull VideoInfo paramVideoInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramVideoInfo, "videoInfo");
    if (paramVideoInfo.a == null)
    {
      rxt localrxt = this.jdField_a_of_type_Rxt;
      if (localrxt != null) {
        localrxt.a(paramVideoInfo);
      }
    }
  }
  
  public final void a(@NotNull rrm paramrrm, long paramLong, @NotNull View paramView1, @NotNull View paramView2)
  {
    Intrinsics.checkParameterIsNotNull(paramrrm, "playParam");
    Intrinsics.checkParameterIsNotNull(paramView1, "rootView");
    Intrinsics.checkParameterIsNotNull(paramView2, "videoRootView");
    if (a(paramLong, paramrrm))
    {
      paramrrm = this.jdField_a_of_type_Rym;
      if (paramrrm == null) {
        break label55;
      }
    }
    label55:
    for (boolean bool = paramrrm.a(paramView1, paramView2);; bool = false)
    {
      this.jdField_a_of_type_Boolean = bool;
      return;
    }
  }
  
  public final void a(@Nullable rxt paramrxt)
  {
    this.jdField_a_of_type_Rxt = paramrxt;
  }
  
  public final void a(@Nullable rym paramrym)
  {
    this.jdField_a_of_type_Rym = paramrym;
  }
  
  public final void a(boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_Rxt;
    if (localObject != null) {
      ((rxt)localObject).a(paramBoolean);
    }
    localObject = this.jdField_a_of_type_Rym;
    if (localObject != null) {
      ((rym)localObject).a(paramBoolean);
    }
  }
  
  public final void b()
  {
    Object localObject = this.jdField_a_of_type_Rxt;
    if (localObject != null) {
      ((rxt)localObject).b();
    }
    localObject = this.jdField_a_of_type_Rym;
    if (localObject != null) {
      ((rym)localObject).a();
    }
  }
  
  public final void b(boolean paramBoolean)
  {
    rxt localrxt = this.jdField_a_of_type_Rxt;
    if (localrxt != null) {
      localrxt.b(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rpn
 * JD-Core Version:    0.7.0.1
 */