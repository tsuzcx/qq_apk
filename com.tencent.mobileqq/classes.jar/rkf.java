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
public final class rkf
  implements sks, spi
{
  private String jdField_a_of_type_JavaLangString;
  private final Lazy jdField_a_of_type_KotlinLazy = LazyKt.lazy((Function0)RIJRewardTaskVideoTimer.presenter.2.INSTANCE);
  private boolean jdField_a_of_type_Boolean;
  
  private final rlq a()
  {
    return (rlq)this.jdField_a_of_type_KotlinLazy.getValue();
  }
  
  private final void g(skq paramskq)
  {
    Object localObject;
    if (this.jdField_a_of_type_JavaLangString != null)
    {
      if (paramskq == null) {
        break label121;
      }
      localObject = paramskq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
      if (localObject == null) {
        break label121;
      }
      localObject = ((VideoInfo)localObject).g;
      if ((Intrinsics.areEqual(localObject, this.jdField_a_of_type_JavaLangString) ^ true)) {
        c();
      }
    }
    if (paramskq != null)
    {
      localObject = paramskq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
      if ((localObject != null) && (((VideoInfo)localObject).c == true)) {}
    }
    else if (paramskq != null)
    {
      localObject = paramskq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
      if (localObject != null)
      {
        localObject = ((VideoInfo)localObject).g;
        if (localObject != null)
        {
          paramskq = paramskq.jdField_a_of_type_Spn;
          if (paramskq == null) {
            break label127;
          }
        }
      }
    }
    label121:
    label127:
    for (long l = paramskq.b();; l = 0L)
    {
      a((String)localObject, (int)l);
      return;
      localObject = null;
      break;
    }
  }
  
  private final void h(skq paramskq)
  {
    if (this.jdField_a_of_type_JavaLangString != null)
    {
      if (paramskq == null) {
        break label41;
      }
      paramskq = paramskq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
      if (paramskq == null) {
        break label41;
      }
    }
    label41:
    for (paramskq = paramskq.g;; paramskq = null)
    {
      if (Intrinsics.areEqual(paramskq, this.jdField_a_of_type_JavaLangString)) {
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
    if (!bmhv.j(bmhv.a())) {
      return;
    }
    Object localObject = paramActivity.findViewById(16908290);
    if (localObject == null) {
      throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup");
    }
    localObject = (ViewGroup)localObject;
    if (((ViewGroup)localObject).findViewById(2131376219) == null) {
      ((ViewGroup)localObject).addView(LayoutInflater.from((Context)paramActivity).inflate(2131562749, (ViewGroup)localObject, false));
    }
    paramActivity = (rlm)new rkg((TextView)((ViewGroup)localObject).findViewById(2131379310), (TextView)((ViewGroup)localObject).findViewById(2131363022), (TextView)((ViewGroup)localObject).findViewById(2131363023), (TextView)((ViewGroup)localObject).findViewById(2131379304), (TextView)((ViewGroup)localObject).findViewById(2131365353));
    a().a(paramActivity);
  }
  
  public final void a(@NotNull Activity paramActivity, @NotNull VideoFeedsPlayManager paramVideoFeedsPlayManager)
  {
    Intrinsics.checkParameterIsNotNull(paramActivity, "activity");
    Intrinsics.checkParameterIsNotNull(paramVideoFeedsPlayManager, "manager");
    a(paramActivity);
    paramVideoFeedsPlayManager.a((sks)this);
  }
  
  public final void a(@NotNull Activity paramActivity, @NotNull spg paramspg)
  {
    Intrinsics.checkParameterIsNotNull(paramActivity, "activity");
    Intrinsics.checkParameterIsNotNull(paramspg, "manager");
    a(paramActivity);
    paramspg.a((spi)this);
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
  
  public void a(@Nullable skq paramskq)
  {
    g(paramskq);
  }
  
  public void a(@Nullable skq paramskq, int paramInt) {}
  
  public void a(@Nullable skq paramskq, int paramInt1, int paramInt2, @Nullable String paramString)
  {
    h(paramskq);
  }
  
  public void a(@Nullable skq paramskq, boolean paramBoolean)
  {
    h(paramskq);
  }
  
  public void a(@Nullable spk paramspk, @Nullable spn paramspn, int paramInt1, int paramInt2, @Nullable Object paramObject)
  {
    if ((paramspk == null) || (paramspk.b)) {
      c();
    }
    do
    {
      return;
      if (paramInt2 == 3)
      {
        if ((this.jdField_a_of_type_JavaLangString != null) && ((Intrinsics.areEqual(paramspk.j, this.jdField_a_of_type_JavaLangString) ^ true))) {
          c();
        }
        paramspk = paramspk.j;
        Intrinsics.checkExpressionValueIsNotNull(paramspk, "playParam.videoArticleID");
        if (paramspn != null) {}
        for (long l = paramspn.b();; l = 0L)
        {
          a(paramspk, (int)l);
          return;
        }
      }
    } while ((paramInt1 != 3) || (this.jdField_a_of_type_JavaLangString == null) || (!Intrinsics.areEqual(paramspk.j, this.jdField_a_of_type_JavaLangString)));
    c();
  }
  
  public boolean a()
  {
    return ((rjy.a()) || (prj.a())) && (ReadinjoyTabFrame.d_());
  }
  
  public final void b()
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void b(@Nullable skq paramskq)
  {
    h(paramskq);
  }
  
  public void b(@Nullable skq paramskq, boolean paramBoolean)
  {
    g(paramskq);
  }
  
  public void c()
  {
    this.jdField_a_of_type_JavaLangString = ((String)null);
    a().a();
  }
  
  public void c(@Nullable skq paramskq)
  {
    h(paramskq);
  }
  
  public void d(@Nullable skq paramskq)
  {
    g(paramskq);
  }
  
  public void e(@Nullable skq paramskq) {}
  
  public void f(@Nullable skq paramskq)
  {
    h(paramskq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rkf
 * JD-Core Version:    0.7.0.1
 */