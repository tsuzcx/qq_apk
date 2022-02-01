import android.text.TextPaint;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAccessibilityHelper;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/video/videofeeds/CommonVideoItemDelegate;", "Lcom/tencent/biz/pubaccount/readinjoy/video/videofeeds/BaseVideoItemDelegate;", "videoHolder", "Lcom/tencent/biz/pubaccount/readinjoy/video/videofeeds/VideoItemHolder;", "presenter", "Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendPresenter;", "adapter", "Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsAdapter;", "(Lcom/tencent/biz/pubaccount/readinjoy/video/videofeeds/VideoItemHolder;Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendPresenter;Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsAdapter;)V", "getDianZanDrawable", "", "isDianZan", "", "innerConfigMenuBtns", "", "videoInfo", "Lcom/tencent/biz/pubaccount/VideoInfo;", "onDianZanClick", "onMenuDataChanged", "info", "onScreenOrientationChanged", "isFullScreen", "onVideoDoubleClick", "actionX", "actionY", "isZanStatusChanged", "refreshContentUI", "isNeedReloadTitle", "refreshMenuUI", "setContentUIVisibility", "visible", "setFooterDiversionVisibility", "setFooterVisibility", "setHeaderDiversionVisibility", "setHeaderVisibility", "updateCommentUI", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public abstract class swn
  extends swk
{
  private final swu a;
  
  public swn(@NotNull swu paramswu, @NotNull slr paramslr, @NotNull shl paramshl)
  {
    super((swm)paramswu, paramslr, paramshl);
    this.jdField_a_of_type_Swu = paramswu;
  }
  
  public int a(boolean paramBoolean)
  {
    if (paramBoolean) {
      return 2130843164;
    }
    return 2130843062;
  }
  
  public void a(int paramInt1, int paramInt2, boolean paramBoolean) {}
  
  public void a(@NotNull VideoInfo paramVideoInfo, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramVideoInfo, "videoInfo");
    super.a(paramVideoInfo, paramBoolean);
    Object localObject = this.jdField_a_of_type_Swu.v;
    if (localObject != null) {
      ((TextView)localObject).setVisibility(0);
    }
    if (((this.jdField_a_of_type_Swu.c == 0) && (this.jdField_a_of_type_Swu.b == 0) && ((this.jdField_a_of_type_Slr.a() instanceof VideoFeedsPlayActivity)) && (paramBoolean)) || (paramVideoInfo.c))
    {
      localObject = this.jdField_a_of_type_Swu.v;
      if (localObject != null) {
        ((TextView)localObject).setText((CharSequence)"");
      }
      this.jdField_a_of_type_Swu.u.setText((CharSequence)"");
    }
    for (;;)
    {
      localObject = this.jdField_a_of_type_Swu.v;
      if (localObject != null)
      {
        localObject = ((TextView)localObject).getPaint();
        if (localObject != null) {
          ((TextPaint)localObject).setFakeBoldText(true);
        }
      }
      localObject = this.jdField_a_of_type_Swu.u.getPaint();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "videoHolder.fullTitleTextView.paint");
      ((TextPaint)localObject).setFakeBoldText(true);
      this.jdField_a_of_type_Shl.a(this.jdField_a_of_type_Swu, paramVideoInfo);
      k(true);
      if (this.jdField_a_of_type_Swu.o != null)
      {
        paramVideoInfo = this.jdField_a_of_type_Swu.o;
        if (paramVideoInfo != null) {
          paramVideoInfo.setVisibility(8);
        }
      }
      return;
      six.a(paramVideoInfo, this.jdField_a_of_type_Swu.v);
      six.a(paramVideoInfo, this.jdField_a_of_type_Swu.u);
    }
  }
  
  protected final void a(@NotNull swu paramswu, @NotNull VideoInfo paramVideoInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramswu, "videoHolder");
    Intrinsics.checkParameterIsNotNull(paramVideoInfo, "videoInfo");
    if (paramswu.jdField_p_of_type_AndroidViewView != null)
    {
      localObject = paramswu.jdField_p_of_type_AndroidViewView;
      if (localObject != null) {
        ((View)localObject).setOnClickListener((View.OnClickListener)this.jdField_a_of_type_Shl);
      }
      localObject = paramswu.jdField_p_of_type_AndroidViewView;
      if (localObject != null) {
        ((View)localObject).setTag(paramswu);
      }
    }
    Object localObject = paramswu.jdField_l_of_type_AndroidViewViewGroup;
    if (localObject != null) {
      ((ViewGroup)localObject).setTag(paramswu);
    }
    localObject = paramswu.jdField_l_of_type_AndroidViewViewGroup;
    if (localObject != null) {
      ((ViewGroup)localObject).setOnClickListener((View.OnClickListener)this.jdField_a_of_type_Shl);
    }
    localObject = paramswu.jdField_l_of_type_AndroidViewViewGroup;
    if (localObject != null) {
      ((ViewGroup)localObject).setVisibility(0);
    }
    localObject = paramswu.jdField_l_of_type_AndroidWidgetImageView;
    if (localObject != null) {
      ((ImageView)localObject).setTag(paramswu);
    }
    localObject = paramswu.jdField_l_of_type_AndroidWidgetImageView;
    if (localObject != null) {
      ((ImageView)localObject).setOnClickListener((View.OnClickListener)this.jdField_a_of_type_Shl);
    }
    localObject = paramswu.jdField_l_of_type_AndroidWidgetImageView;
    if (localObject != null) {
      ((ImageView)localObject).setOnLongClickListener((View.OnLongClickListener)this.jdField_a_of_type_Shl);
    }
    if (paramswu.jdField_m_of_type_AndroidViewViewGroup != null)
    {
      localObject = paramswu.jdField_m_of_type_AndroidViewViewGroup;
      if (localObject != null) {
        ((ViewGroup)localObject).setOnClickListener((View.OnClickListener)this.jdField_a_of_type_Shl);
      }
      localObject = paramswu.jdField_m_of_type_AndroidViewViewGroup;
      if (localObject != null) {
        ((ViewGroup)localObject).setOnLongClickListener((View.OnLongClickListener)this.jdField_a_of_type_Shl);
      }
      localObject = paramswu.jdField_m_of_type_AndroidViewViewGroup;
      if (localObject != null) {
        ((ViewGroup)localObject).setTag(paramswu);
      }
    }
    localObject = paramswu.jdField_l_of_type_AndroidWidgetImageView;
    if (localObject != null) {
      ((ImageView)localObject).setVisibility(0);
    }
    localObject = paramswu.jdField_m_of_type_AndroidWidgetImageView;
    if (localObject != null) {
      ((ImageView)localObject).setTag(paramswu);
    }
    localObject = paramswu.jdField_m_of_type_AndroidWidgetImageView;
    if (localObject != null) {
      ((ImageView)localObject).setOnClickListener((View.OnClickListener)this.jdField_a_of_type_Shl);
    }
    paramswu = paramswu.jdField_m_of_type_AndroidWidgetImageView;
    if (paramswu != null) {
      paramswu.setVisibility(0);
    }
    b(paramVideoInfo);
  }
  
  public void a(boolean paramBoolean)
  {
    Object localObject;
    if (this.jdField_a_of_type_Swu.i != null)
    {
      localObject = this.jdField_a_of_type_Swu.a;
      if (localObject != null)
      {
        localObject = ((skq)localObject).a;
        if ((localObject != null) && (((VideoInfo)localObject).a == 0)) {}
      }
      else
      {
        localObject = this.jdField_a_of_type_Swu.a;
        if (localObject != null)
        {
          localObject = ((skq)localObject).a;
          if ((localObject != null) && (((VideoInfo)localObject).a() == true)) {
            break label86;
          }
        }
      }
      localObject = this.jdField_a_of_type_Swu.i;
      if (localObject != null) {
        ((ViewGroup)localObject).setVisibility(8);
      }
    }
    label86:
    do
    {
      do
      {
        return;
        if (!paramBoolean) {
          break;
        }
        localObject = this.jdField_a_of_type_Swu.i;
      } while (localObject == null);
      ((ViewGroup)localObject).setVisibility(0);
      return;
      localObject = this.jdField_a_of_type_Swu.i;
    } while (localObject == null);
    ((ViewGroup)localObject).setVisibility(8);
  }
  
  public void a_(@NotNull VideoInfo paramVideoInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramVideoInfo, "videoInfo");
  }
  
  public void b(@NotNull VideoInfo paramVideoInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramVideoInfo, "info");
    c(paramVideoInfo);
    VideoFeedsAccessibilityHelper.a((View)this.jdField_a_of_type_Swu.w, paramVideoInfo.e);
    ImageView localImageView = this.jdField_a_of_type_Swu.jdField_m_of_type_AndroidWidgetImageView;
    if (localImageView != null) {
      localImageView.setImageDrawable(this.jdField_a_of_type_Shl.a(a(paramVideoInfo.r)));
    }
    six.b(this.jdField_a_of_type_Swu.x, paramVideoInfo.t, "赞");
    six.b(this.jdField_a_of_type_Swu.y, paramVideoInfo.f, "Biu");
  }
  
  public void b(boolean paramBoolean)
  {
    ViewGroup localViewGroup;
    if (this.jdField_a_of_type_Swu.jdField_p_of_type_AndroidViewViewGroup != null)
    {
      localViewGroup = this.jdField_a_of_type_Swu.jdField_p_of_type_AndroidViewViewGroup;
      if (localViewGroup != null) {
        if (!paramBoolean) {
          break label34;
        }
      }
    }
    label34:
    for (int i = 0;; i = 8)
    {
      localViewGroup.setVisibility(i);
      return;
    }
  }
  
  public void c(@NotNull VideoInfo paramVideoInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramVideoInfo, "info");
    if (paramVideoInfo.e > 0)
    {
      TextView localTextView = this.jdField_a_of_type_Swu.w;
      if (localTextView != null) {
        localTextView.setVisibility(0);
      }
      six.b(this.jdField_a_of_type_Swu.w, paramVideoInfo.e, "评论");
      paramVideoInfo = this.jdField_a_of_type_Swu.jdField_k_of_type_AndroidWidgetImageView;
      if (paramVideoInfo != null) {
        paramVideoInfo.setImageResource(2130843162);
      }
    }
    do
    {
      return;
      paramVideoInfo = this.jdField_a_of_type_Swu.w;
      if (paramVideoInfo != null) {
        paramVideoInfo.setVisibility(8);
      }
      paramVideoInfo = this.jdField_a_of_type_Swu.jdField_k_of_type_AndroidWidgetImageView;
    } while (paramVideoInfo == null);
    paramVideoInfo.setImageResource(2130843163);
  }
  
  public void c(boolean paramBoolean)
  {
    ViewGroup localViewGroup;
    if (this.jdField_a_of_type_Swu.q != null)
    {
      localViewGroup = this.jdField_a_of_type_Swu.q;
      if (localViewGroup != null) {
        if (!paramBoolean) {
          break label34;
        }
      }
    }
    label34:
    for (int i = 0;; i = 8)
    {
      localViewGroup.setVisibility(i);
      return;
    }
  }
  
  public void d()
  {
    Object localObject1 = this.jdField_a_of_type_Swu.x;
    Object localObject2 = this.jdField_a_of_type_Swu.a;
    if (localObject2 != null)
    {
      localObject2 = ((skq)localObject2).a;
      if (localObject2 == null) {}
    }
    for (int i = ((VideoInfo)localObject2).t;; i = 0)
    {
      six.b((TextView)localObject1, i, "赞");
      if (this.jdField_a_of_type_Shl.a == null)
      {
        localObject1 = new ScaleAnimation(1.0F, 0.0F, 1.0F, 0.0F, 1, 0.5F, 1, 0.5F);
        ((ScaleAnimation)localObject1).setDuration(200L);
        ((ScaleAnimation)localObject1).setRepeatCount(1);
        ((ScaleAnimation)localObject1).setRepeatMode(2);
        ((ScaleAnimation)localObject1).setInterpolator((Interpolator)new DecelerateInterpolator());
        this.jdField_a_of_type_Shl.a = ((Animation)localObject1);
      }
      this.jdField_a_of_type_Shl.a.setAnimationListener((Animation.AnimationListener)new swo(this));
      localObject1 = this.jdField_a_of_type_Swu.jdField_m_of_type_AndroidWidgetImageView;
      if (localObject1 != null) {
        ((ImageView)localObject1).startAnimation(this.jdField_a_of_type_Shl.a);
      }
      return;
    }
  }
  
  public void f(boolean paramBoolean)
  {
    super.f(paramBoolean);
    if (paramBoolean)
    {
      localTextView = this.jdField_a_of_type_Swu.v;
      if (localTextView != null) {
        localTextView.setVisibility(8);
      }
      k(false);
      a(false);
      l(false);
      return;
    }
    TextView localTextView = this.jdField_a_of_type_Swu.v;
    if (localTextView != null) {
      localTextView.setVisibility(0);
    }
    k(true);
    a(true);
    l(true);
  }
  
  public void k(boolean paramBoolean)
  {
    ViewGroup localViewGroup;
    if (this.jdField_a_of_type_Swu.n != null)
    {
      if (!paramBoolean) {
        break label32;
      }
      localViewGroup = this.jdField_a_of_type_Swu.n;
      if (localViewGroup != null) {
        localViewGroup.setVisibility(0);
      }
    }
    label32:
    do
    {
      return;
      localViewGroup = this.jdField_a_of_type_Swu.n;
    } while (localViewGroup == null);
    localViewGroup.setVisibility(8);
  }
  
  public void l(boolean paramBoolean)
  {
    Object localObject;
    if (this.jdField_a_of_type_Swu.jdField_k_of_type_AndroidViewViewGroup != null)
    {
      localObject = this.jdField_a_of_type_Swu.a;
      if (localObject != null)
      {
        localObject = ((skq)localObject).a;
        if ((localObject != null) && (((VideoInfo)localObject).a() == true)) {
          break label58;
        }
      }
      localObject = this.jdField_a_of_type_Swu.jdField_k_of_type_AndroidViewViewGroup;
      if (localObject != null) {
        ((ViewGroup)localObject).setVisibility(8);
      }
    }
    label58:
    do
    {
      do
      {
        return;
        if (!paramBoolean) {
          break;
        }
        localObject = this.jdField_a_of_type_Swu.jdField_k_of_type_AndroidViewViewGroup;
      } while (localObject == null);
      ((ViewGroup)localObject).setVisibility(0);
      return;
      localObject = this.jdField_a_of_type_Swu.jdField_k_of_type_AndroidViewViewGroup;
    } while (localObject == null);
    ((ViewGroup)localObject).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     swn
 * JD-Core Version:    0.7.0.1
 */