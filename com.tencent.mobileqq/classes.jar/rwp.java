import android.view.View;
import com.tencent.biz.pubaccount.VideoInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsGuideProxy;", "", "()V", "columnGuideManager", "Lcom/tencent/biz/pubaccount/readinjoy/video/column/VideoColumnGuideManager;", "getColumnGuideManager", "()Lcom/tencent/biz/pubaccount/readinjoy/video/column/VideoColumnGuideManager;", "setColumnGuideManager", "(Lcom/tencent/biz/pubaccount/readinjoy/video/column/VideoColumnGuideManager;)V", "hasShowVideoColumnGuide", "", "userGuideController", "Lcom/tencent/biz/pubaccount/readinjoy/video/VideofeedsUserGuideController;", "getUserGuideController", "()Lcom/tencent/biz/pubaccount/readinjoy/video/VideofeedsUserGuideController;", "setUserGuideController", "(Lcom/tencent/biz/pubaccount/readinjoy/video/VideofeedsUserGuideController;)V", "dismissGuideAnim", "", "getPlayPercent", "", "currentTs", "", "playParam", "Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager$VideoPlayParam;", "hideUserGuide", "needShowVideoColumnGuide", "onVideoProgressChange", "rootView", "Landroid/view/View;", "videoRootView", "setFullScreen", "fullScreen", "setNeedUserGuide", "needGuide", "showUserGuide", "videoInfo", "Lcom/tencent/biz/pubaccount/VideoInfo;", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class rwp
{
  public static final rwq a;
  @Nullable
  private sex jdField_a_of_type_Sex;
  @Nullable
  private sfq jdField_a_of_type_Sfq;
  private boolean jdField_a_of_type_Boolean;
  
  static
  {
    jdField_a_of_type_Rwq = new rwq(null);
  }
  
  private final float a(long paramLong, ryo paramryo)
  {
    paramryo = paramryo.jdField_a_of_type_Sdj;
    if (paramryo != null) {}
    for (long l = paramryo.b();; l = 0L) {
      return (float)paramLong * 100.0F / (float)l;
    }
  }
  
  private final boolean a(long paramLong, ryo paramryo)
  {
    return (shg.a.a()) && (!this.jdField_a_of_type_Boolean) && (a(paramLong, paramryo) >= 20) && (paramryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a != null);
  }
  
  public final void a()
  {
    sex localsex = this.jdField_a_of_type_Sex;
    if (localsex != null) {
      localsex.a();
    }
  }
  
  public final void a(@NotNull VideoInfo paramVideoInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramVideoInfo, "videoInfo");
    if (paramVideoInfo.a == null)
    {
      sex localsex = this.jdField_a_of_type_Sex;
      if (localsex != null) {
        localsex.a(paramVideoInfo);
      }
    }
  }
  
  public final void a(@NotNull ryo paramryo, long paramLong, @NotNull View paramView1, @NotNull View paramView2)
  {
    Intrinsics.checkParameterIsNotNull(paramryo, "playParam");
    Intrinsics.checkParameterIsNotNull(paramView1, "rootView");
    Intrinsics.checkParameterIsNotNull(paramView2, "videoRootView");
    if (a(paramLong, paramryo))
    {
      paramryo = this.jdField_a_of_type_Sfq;
      if (paramryo == null) {
        break label55;
      }
    }
    label55:
    for (boolean bool = paramryo.a(paramView1, paramView2);; bool = false)
    {
      this.jdField_a_of_type_Boolean = bool;
      return;
    }
  }
  
  public final void a(@Nullable sex paramsex)
  {
    this.jdField_a_of_type_Sex = paramsex;
  }
  
  public final void a(@Nullable sfq paramsfq)
  {
    this.jdField_a_of_type_Sfq = paramsfq;
  }
  
  public final void a(boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_Sex;
    if (localObject != null) {
      ((sex)localObject).a(paramBoolean);
    }
    localObject = this.jdField_a_of_type_Sfq;
    if (localObject != null) {
      ((sfq)localObject).a(paramBoolean);
    }
  }
  
  public final void b()
  {
    Object localObject = this.jdField_a_of_type_Sex;
    if (localObject != null) {
      ((sex)localObject).b();
    }
    localObject = this.jdField_a_of_type_Sfq;
    if (localObject != null) {
      ((sfq)localObject).a();
    }
  }
  
  public final void b(boolean paramBoolean)
  {
    sex localsex = this.jdField_a_of_type_Sex;
    if (localsex != null) {
      localsex.b(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rwp
 * JD-Core Version:    0.7.0.1
 */