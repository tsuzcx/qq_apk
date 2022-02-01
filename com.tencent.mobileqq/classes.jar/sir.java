import android.view.View;
import com.tencent.biz.pubaccount.VideoInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsGuideProxy;", "", "()V", "columnGuideManager", "Lcom/tencent/biz/pubaccount/readinjoy/video/column/VideoColumnGuideManager;", "getColumnGuideManager", "()Lcom/tencent/biz/pubaccount/readinjoy/video/column/VideoColumnGuideManager;", "setColumnGuideManager", "(Lcom/tencent/biz/pubaccount/readinjoy/video/column/VideoColumnGuideManager;)V", "hasShowVideoColumnGuide", "", "userGuideController", "Lcom/tencent/biz/pubaccount/readinjoy/video/VideofeedsUserGuideController;", "getUserGuideController", "()Lcom/tencent/biz/pubaccount/readinjoy/video/VideofeedsUserGuideController;", "setUserGuideController", "(Lcom/tencent/biz/pubaccount/readinjoy/video/VideofeedsUserGuideController;)V", "dismissGuideAnim", "", "getPlayPercent", "", "currentTs", "", "playParam", "Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager$VideoPlayParam;", "hideUserGuide", "needShowVideoColumnGuide", "onVideoProgressChange", "rootView", "Landroid/view/View;", "videoRootView", "setFullScreen", "fullScreen", "setNeedUserGuide", "needGuide", "showUserGuide", "videoInfo", "Lcom/tencent/biz/pubaccount/VideoInfo;", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class sir
{
  public static final sis a;
  @Nullable
  private src jdField_a_of_type_Src;
  @Nullable
  private srv jdField_a_of_type_Srv;
  private boolean jdField_a_of_type_Boolean;
  
  static
  {
    jdField_a_of_type_Sis = new sis(null);
  }
  
  private final float a(long paramLong, skq paramskq)
  {
    paramskq = paramskq.jdField_a_of_type_Spn;
    if (paramskq != null) {}
    for (long l = paramskq.b();; l = 0L) {
      return (float)paramLong * 100.0F / (float)l;
    }
  }
  
  private final boolean a(long paramLong, skq paramskq)
  {
    return (stw.a.a()) && (!this.jdField_a_of_type_Boolean) && (a(paramLong, paramskq) >= 20) && (paramskq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a != null);
  }
  
  public final void a()
  {
    src localsrc = this.jdField_a_of_type_Src;
    if (localsrc != null) {
      localsrc.a();
    }
  }
  
  public final void a(@NotNull VideoInfo paramVideoInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramVideoInfo, "videoInfo");
    if (paramVideoInfo.a == null)
    {
      src localsrc = this.jdField_a_of_type_Src;
      if (localsrc != null) {
        localsrc.a(paramVideoInfo);
      }
    }
  }
  
  public final void a(@NotNull skq paramskq, long paramLong, @NotNull View paramView1, @NotNull View paramView2)
  {
    Intrinsics.checkParameterIsNotNull(paramskq, "playParam");
    Intrinsics.checkParameterIsNotNull(paramView1, "rootView");
    Intrinsics.checkParameterIsNotNull(paramView2, "videoRootView");
    if (a(paramLong, paramskq))
    {
      paramskq = this.jdField_a_of_type_Srv;
      if (paramskq == null) {
        break label55;
      }
    }
    label55:
    for (boolean bool = paramskq.a(paramView1, paramView2);; bool = false)
    {
      this.jdField_a_of_type_Boolean = bool;
      return;
    }
  }
  
  public final void a(@Nullable src paramsrc)
  {
    this.jdField_a_of_type_Src = paramsrc;
  }
  
  public final void a(@Nullable srv paramsrv)
  {
    this.jdField_a_of_type_Srv = paramsrv;
  }
  
  public final void a(boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_Src;
    if (localObject != null) {
      ((src)localObject).a(paramBoolean);
    }
    localObject = this.jdField_a_of_type_Srv;
    if (localObject != null) {
      ((srv)localObject).a(paramBoolean);
    }
  }
  
  public final void b()
  {
    Object localObject = this.jdField_a_of_type_Src;
    if (localObject != null) {
      ((src)localObject).b();
    }
    localObject = this.jdField_a_of_type_Srv;
    if (localObject != null) {
      ((srv)localObject).a();
    }
  }
  
  public final void b(boolean paramBoolean)
  {
    src localsrc = this.jdField_a_of_type_Src;
    if (localsrc != null) {
      localsrc.b(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sir
 * JD-Core Version:    0.7.0.1
 */