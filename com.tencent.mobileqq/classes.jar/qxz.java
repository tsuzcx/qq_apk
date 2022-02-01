import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.reward.RIJRewardTaskVideoTimer.presenter.2;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/reward/RIJRewardTaskVideoTimer;", "Lcom/tencent/biz/pubaccount/readinjoy/reward/IRIJRewardTaskTimer;", "Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager$VideoStatusListener;", "Lcom/tencent/biz/pubaccount/readinjoy/video/VideoPlayManager$OnPlayStateListener;", "()V", "curRowKey", "", "isResume", "", "presenter", "Lcom/tencent/biz/pubaccount/readinjoy/reward/mvp/RIJRewardTaskTimingPresenter;", "kotlin.jvm.PlatformType", "getPresenter", "()Lcom/tencent/biz/pubaccount/readinjoy/reward/mvp/RIJRewardTaskTimingPresenter;", "presenter$delegate", "Lkotlin/Lazy;", "attach", "", "activity", "Landroid/app/Activity;", "manager", "Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager;", "Lcom/tencent/biz/pubaccount/readinjoy/video/VideoPlayManager;", "attachDebugView", "enabled", "onCompletion", "playParam", "Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager$VideoPlayParam;", "onPause", "onResume", "onStateChange", "Lcom/tencent/biz/pubaccount/readinjoy/video/VideoPlayManager$VideoPlayParam;", "videoPlayerWrapper", "Lcom/tencent/biz/pubaccount/readinjoy/video/VideoPlayerWrapper;", "oldState", "", "newState", "extra", "", "onVideoBufferEnd", "isPlaying", "onVideoBufferStart", "onVideoError", "model", "what", "errorMsg", "onVideoInitiate", "onVideoPause", "onVideoReplayOnLoop", "times", "onVideoRestart", "onVideoStart", "onVideoStop", "isCompleted", "startTiming", "rowKey", "maxTaskTimeInMs", "stopTiming", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class qxz
  implements ryq, sde
{
  private String jdField_a_of_type_JavaLangString;
  private final Lazy jdField_a_of_type_KotlinLazy = LazyKt.lazy((Function0)RIJRewardTaskVideoTimer.presenter.2.INSTANCE);
  private boolean jdField_a_of_type_Boolean;
  
  private final qzk a()
  {
    return (qzk)this.jdField_a_of_type_KotlinLazy.getValue();
  }
  
  private final void g(ryo paramryo)
  {
    Object localObject;
    if (this.jdField_a_of_type_JavaLangString != null)
    {
      if (paramryo == null) {
        break label121;
      }
      localObject = paramryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
      if (localObject == null) {
        break label121;
      }
      localObject = ((VideoInfo)localObject).g;
      if ((Intrinsics.areEqual(localObject, this.jdField_a_of_type_JavaLangString) ^ true)) {
        c();
      }
    }
    if (paramryo != null)
    {
      localObject = paramryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
      if ((localObject != null) && (((VideoInfo)localObject).c == true)) {}
    }
    else if (paramryo != null)
    {
      localObject = paramryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
      if (localObject != null)
      {
        localObject = ((VideoInfo)localObject).g;
        if (localObject != null)
        {
          paramryo = paramryo.jdField_a_of_type_Sdj;
          if (paramryo == null) {
            break label127;
          }
        }
      }
    }
    label121:
    label127:
    for (long l = paramryo.b();; l = 0L)
    {
      a((String)localObject, (int)l);
      return;
      localObject = null;
      break;
    }
  }
  
  private final void h(ryo paramryo)
  {
    if (this.jdField_a_of_type_JavaLangString != null)
    {
      if (paramryo == null) {
        break label41;
      }
      paramryo = paramryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
      if (paramryo == null) {
        break label41;
      }
    }
    label41:
    for (paramryo = paramryo.g;; paramryo = null)
    {
      if (Intrinsics.areEqual(paramryo, this.jdField_a_of_type_JavaLangString)) {
        c();
      }
      return;
    }
  }
  
  public final void a()
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  public final void a(@NotNull Activity paramActivity)
  {
    Intrinsics.checkParameterIsNotNull(paramActivity, "activity");
    if (!bkwm.j(bkwm.a())) {
      return;
    }
    Object localObject = paramActivity.findViewById(16908290);
    if (localObject == null) {
      throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup");
    }
    localObject = (ViewGroup)localObject;
    if (((ViewGroup)localObject).findViewById(2131375972) == null) {
      ((ViewGroup)localObject).addView(LayoutInflater.from((Context)paramActivity).inflate(2131562678, (ViewGroup)localObject, false));
    }
    paramActivity = (qzg)new qya((TextView)((ViewGroup)localObject).findViewById(2131379014), (TextView)((ViewGroup)localObject).findViewById(2131363005), (TextView)((ViewGroup)localObject).findViewById(2131363006), (TextView)((ViewGroup)localObject).findViewById(2131379010), (TextView)((ViewGroup)localObject).findViewById(2131365259));
    a().a(paramActivity);
  }
  
  public final void a(@NotNull Activity paramActivity, @NotNull VideoFeedsPlayManager paramVideoFeedsPlayManager)
  {
    Intrinsics.checkParameterIsNotNull(paramActivity, "activity");
    Intrinsics.checkParameterIsNotNull(paramVideoFeedsPlayManager, "manager");
    a(paramActivity);
    paramVideoFeedsPlayManager.a((ryq)this);
  }
  
  public final void a(@NotNull Activity paramActivity, @NotNull sdc paramsdc)
  {
    Intrinsics.checkParameterIsNotNull(paramActivity, "activity");
    Intrinsics.checkParameterIsNotNull(paramsdc, "manager");
    a(paramActivity);
    paramsdc.a((sde)this);
  }
  
  public void a(@NotNull String paramString, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "rowKey");
    if ((a()) && (this.jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_JavaLangString = paramString;
      a().a(paramString, paramInt, 2);
    }
  }
  
  public void a(@Nullable ryo paramryo)
  {
    g(paramryo);
  }
  
  public void a(@Nullable ryo paramryo, int paramInt) {}
  
  public void a(@Nullable ryo paramryo, int paramInt1, int paramInt2, @Nullable String paramString)
  {
    h(paramryo);
  }
  
  public void a(@Nullable ryo paramryo, boolean paramBoolean)
  {
    h(paramryo);
  }
  
  public void a(@Nullable sdg paramsdg, @Nullable sdj paramsdj, int paramInt1, int paramInt2, @Nullable Object paramObject)
  {
    if ((paramsdg == null) || (paramsdg.b)) {
      c();
    }
    do
    {
      return;
      if (paramInt2 == 3)
      {
        if ((this.jdField_a_of_type_JavaLangString != null) && ((Intrinsics.areEqual(paramsdg.j, this.jdField_a_of_type_JavaLangString) ^ true))) {
          c();
        }
        paramsdg = paramsdg.j;
        Intrinsics.checkExpressionValueIsNotNull(paramsdg, "playParam.videoArticleID");
        if (paramsdj != null) {}
        for (long l = paramsdj.b();; l = 0L)
        {
          a(paramsdg, (int)l);
          return;
        }
      }
    } while ((paramInt1 != 3) || (this.jdField_a_of_type_JavaLangString == null) || (!Intrinsics.areEqual(paramsdg.j, this.jdField_a_of_type_JavaLangString)));
    c();
  }
  
  public boolean a()
  {
    return (qxs.a()) && (ReadinjoyTabFrame.d_());
  }
  
  public final void b()
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void b(@Nullable ryo paramryo)
  {
    h(paramryo);
  }
  
  public void b(@Nullable ryo paramryo, boolean paramBoolean)
  {
    g(paramryo);
  }
  
  public void c()
  {
    this.jdField_a_of_type_JavaLangString = ((String)null);
    a().a();
  }
  
  public void c(@Nullable ryo paramryo)
  {
    h(paramryo);
  }
  
  public void d(@Nullable ryo paramryo)
  {
    g(paramryo);
  }
  
  public void e(@Nullable ryo paramryo) {}
  
  public void f(@Nullable ryo paramryo)
  {
    h(paramryo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qxz
 * JD-Core Version:    0.7.0.1
 */