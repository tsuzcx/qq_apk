package com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import androidx.annotation.RequiresApi;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.config.CommonConfig;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.config.LayoutConfig;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.config.VideoTrackConfig;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop.DragModel;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop.DragViewModel;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop.EffectTimelineView;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.scale.ScaleCalculator;
import com.tencent.videocut.utils.DensityUtils;
import com.tencent.videocut.utils.TimeUtils;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/VideoTrackTimelineView;", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/EffectTimelineView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "dragModel", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/DragModel;", "(Landroid/content/Context;Landroid/util/AttributeSet;ILcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/DragModel;)V", "RATIO_FORMAT", "", "bevelView", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/PlayTrackExpandWidthView;", "bitmapWidth", "config", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/config/CommonConfig;", "container", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/RoundFrameLayout;", "contentPadding", "getContentPadding", "()I", "cornerRadius", "endClipPosition", "", "getEndClipPosition", "()F", "initialTrackModel", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/VideoTrackModel;", "isLast", "", "lastDownPoint", "Lkotlin/Pair;", "redMaskView", "Landroid/view/View;", "selectListener", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/VideoTrackTimelineView$ContentSelectListener;", "simpleDateFormat", "Ljava/text/SimpleDateFormat;", "startClipPosition", "getStartClipPosition", "tagContainer", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/TopTagViewContainerView;", "thumbnailProvider", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/IThumbnailProvider;", "videoThumbProvider", "com/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/VideoTrackTimelineView$videoThumbProvider$1", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/VideoTrackTimelineView$videoThumbProvider$1;", "changeSelectStatus", "", "selected", "createContentView", "Landroid/view/ViewGroup;", "id", "getMaxEndPosition", "getMinDistance", "getMinStartPosition", "getSelectedStatus", "getUuid", "leftSpace", "onClick", "fromUser", "onClick$qq_wink_impl_release", "refreshContent", "refreshView", "videoTrackModel", "commonConfig", "rightSpace", "setCornerRadius", "radius", "setSelectListener", "setSelected", "setSingleBitmapWidth", "singleBitmapWidthPx", "setThumbnailProvider", "provider", "updateLayout", "updateRedMaskViewShowTimeRange", "updateSelectStatus", "updateSelectStatusWithoutCheck", "updateTag", "updateTransitionClipPosition", "Companion", "ContentSelectListener", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
@SuppressLint({"ViewConstructor", "ClickableViewAccessibility"})
@RequiresApi(17)
public final class VideoTrackTimelineView
  extends EffectTimelineView
{
  public static final VideoTrackTimelineView.Companion c = new VideoTrackTimelineView.Companion(null);
  private final PlayTrackExpandWidthView d;
  private final RoundFrameLayout e;
  private final TopTagViewContainerView f;
  private final View g;
  private int h;
  private VideoTrackModel i;
  private int j;
  private VideoTrackTimelineView.ContentSelectListener k;
  private CommonConfig l;
  private boolean m;
  private final SimpleDateFormat n = new SimpleDateFormat("mm:ss", Locale.US);
  private final String o = "%.1f";
  private Pair<Float, Float> p;
  private IThumbnailProvider q;
  private final VideoTrackTimelineView.videoThumbProvider.1 r;
  
  @JvmOverloads
  public VideoTrackTimelineView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt, @NotNull DragModel paramDragModel)
  {
    super(paramContext, paramAttributeSet, paramInt, paramDragModel);
    paramAttributeSet = Float.valueOf(0.0F);
    this.p = TuplesKt.to(paramAttributeSet, paramAttributeSet);
    this.q = ((IThumbnailProvider)new EmptyThumbnailProvider());
    this.r = new VideoTrackTimelineView.videoThumbProvider.1(this);
    paramAttributeSet = getContentView();
    if (paramAttributeSet == null) {
      paramAttributeSet = a(View.generateViewId());
    }
    paramDragModel = (RoundFrameLayout)paramAttributeSet.findViewById(2131431322);
    PlayTrackExpandWidthView localPlayTrackExpandWidthView = new PlayTrackExpandWidthView(paramContext, null, 0, 6, null);
    localPlayTrackExpandWidthView.setId(View.generateViewId());
    localPlayTrackExpandWidthView.setSingleBitmapWidth(this.h);
    localPlayTrackExpandWidthView.setThumbProvider((IVideoTrackBitmapProvider)this.r);
    paramDragModel.addView((View)localPlayTrackExpandWidthView, new ViewGroup.LayoutParams(-1, -1));
    paramContext = new TopTagViewContainerView(paramContext, null, 0, 6, null);
    paramAttributeSet.addView((View)paramContext);
    View localView = new View(getContext());
    localView.setBackgroundResource(2131165774);
    localView.setVisibility(4);
    paramDragModel.addView(localView, new ViewGroup.LayoutParams(-1, -1));
    this.d = localPlayTrackExpandWidthView;
    Intrinsics.checkExpressionValueIsNotNull(paramDragModel, "container");
    this.e = paramDragModel;
    this.f = paramContext;
    this.g = localView;
    paramAttributeSet.setOnClickListener((View.OnClickListener)new VideoTrackTimelineView.1(this));
    paramAttributeSet.setOnTouchListener((View.OnTouchListener)new VideoTrackTimelineView.2(this));
  }
  
  private final void a(VideoTrackModel paramVideoTrackModel)
  {
    List localList = CollectionsKt.toMutableList((Collection)paramVideoTrackModel.o().c());
    if (paramVideoTrackModel.o().b())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      Object localObject = StringCompanionObject.INSTANCE;
      localObject = this.o;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Float.valueOf((float)TimeUtils.a.c(paramVideoTrackModel.l()) / 1000);
      paramVideoTrackModel = String.format((String)localObject, Arrays.copyOf(arrayOfObject, arrayOfObject.length));
      Intrinsics.checkExpressionValueIsNotNull(paramVideoTrackModel, "java.lang.String.format(format, *args)");
      localStringBuilder.append(paramVideoTrackModel);
      localStringBuilder.append("s");
      localList.add(0, new TagData(localStringBuilder.toString(), 0, 2, null));
    }
    this.f.a(localList);
  }
  
  private final void b(VideoTrackModel paramVideoTrackModel)
  {
    int i1 = paramVideoTrackModel.o().a();
    Object localObject = this.i;
    if (localObject != null)
    {
      localObject = ((VideoTrackModel)localObject).o();
      if ((localObject != null) && (i1 == ((DrawData)localObject).a())) {
        return;
      }
    }
    c(paramVideoTrackModel);
  }
  
  private final void b(VideoTrackModel paramVideoTrackModel, boolean paramBoolean, CommonConfig paramCommonConfig)
  {
    if ((Intrinsics.areEqual(this.i, paramVideoTrackModel)) && (this.m == paramBoolean) && (Intrinsics.areEqual(this.l, paramCommonConfig))) {
      return;
    }
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -1);
    int i2 = 0;
    int i1;
    if (paramBoolean) {
      i1 = 0;
    } else {
      i1 = DensityUtils.a.a(paramCommonConfig.c().b());
    }
    localLayoutParams.width = (paramVideoTrackModel.h() + getSliderWidth() + getSliderWidth() - i1);
    localLayoutParams.leftMargin = (paramVideoTrackModel.e() + paramCommonConfig.b().a() - getSliderWidth());
    setLayoutParams((ViewGroup.LayoutParams)localLayoutParams);
    this.d.setMaxLeftBorderWidth(paramVideoTrackModel.f());
    paramVideoTrackModel = this.f;
    if (paramCommonConfig.c().c()) {
      i1 = i2;
    } else {
      i1 = 8;
    }
    paramVideoTrackModel.setVisibility(i1);
    h();
  }
  
  private final void c(VideoTrackModel paramVideoTrackModel)
  {
    int i1 = paramVideoTrackModel.o().a();
    if (i1 != -1)
    {
      if (i1 != 1) {
        return;
      }
      d(true);
      return;
    }
    d(false);
  }
  
  private final void d(VideoTrackModel paramVideoTrackModel)
  {
    float f1 = paramVideoTrackModel.j();
    float f2 = paramVideoTrackModel.k();
    if ((f1 == getStartClipPosition()) && (f2 == getEndClipPosition())) {
      return;
    }
    this.d.setEndClipWidth(f2);
    this.d.setStartClipWidth(f1);
    this.d.invalidate();
  }
  
  private final void d(boolean paramBoolean)
  {
    setSelected(paramBoolean);
    this.d.setSelected(paramBoolean);
    h();
  }
  
  private final void e(VideoTrackModel paramVideoTrackModel)
  {
    if (paramVideoTrackModel.n().d().c() + paramVideoTrackModel.n().d().d() <= 180000000L) {
      return;
    }
    long l1 = Math.max(0L, 180000000L - paramVideoTrackModel.n().d().c());
    long l2 = paramVideoTrackModel.n().d().d();
    paramVideoTrackModel = new FrameLayout.LayoutParams(-1, -1);
    ScaleCalculator localScaleCalculator = getInnerScaleCalculator();
    int i1;
    if (localScaleCalculator != null) {
      i1 = localScaleCalculator.b(l1);
    } else {
      i1 = 0;
    }
    paramVideoTrackModel.leftMargin = i1;
    localScaleCalculator = getInnerScaleCalculator();
    if (localScaleCalculator != null) {
      i1 = localScaleCalculator.b(l2 - l1);
    } else {
      i1 = 0;
    }
    paramVideoTrackModel.width = i1;
    this.g.setLayoutParams((ViewGroup.LayoutParams)paramVideoTrackModel);
    this.g.setVisibility(0);
  }
  
  private final float getEndClipPosition()
  {
    VideoTrackModel localVideoTrackModel = this.i;
    if (localVideoTrackModel != null) {
      return localVideoTrackModel.k();
    }
    return 0.0F;
  }
  
  private final int getSelectedStatus()
  {
    Object localObject = this.i;
    if (localObject != null)
    {
      localObject = ((VideoTrackModel)localObject).o();
      if (localObject != null) {
        return ((DrawData)localObject).a();
      }
    }
    return -1;
  }
  
  private final float getStartClipPosition()
  {
    VideoTrackModel localVideoTrackModel = this.i;
    if (localVideoTrackModel != null) {
      return localVideoTrackModel.j();
    }
    return 0.0F;
  }
  
  public int a()
  {
    return super.getSliderWidth();
  }
  
  @NotNull
  protected ViewGroup a(int paramInt)
  {
    Object localObject = LayoutInflater.from(getContext()).inflate(2131628258, null);
    if (localObject != null)
    {
      localObject = (ViewGroup)localObject;
      ((ViewGroup)localObject).setId(paramInt);
      return localObject;
    }
    throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup");
  }
  
  public final void a(@NotNull VideoTrackModel paramVideoTrackModel, boolean paramBoolean, @Nullable CommonConfig paramCommonConfig)
  {
    Intrinsics.checkParameterIsNotNull(paramVideoTrackModel, "videoTrackModel");
    if (paramCommonConfig != null) {
      localObject = paramCommonConfig;
    } else {
      localObject = new CommonConfig(null, null, null, null, 15, null);
    }
    b(paramVideoTrackModel, paramBoolean, (CommonConfig)localObject);
    a(paramVideoTrackModel);
    d(paramVideoTrackModel);
    b(paramVideoTrackModel);
    e(paramVideoTrackModel);
    Object localObject = getDragViewModel();
    String str = paramVideoTrackModel.b();
    setDragViewModel(DragViewModel.a((DragViewModel)localObject, null, paramVideoTrackModel.e(), paramVideoTrackModel.a(), 0L, 0, str, null, 73, null));
    this.i = VideoTrackModel.a(paramVideoTrackModel, null, 0, null, 0, 0, 0, 0, 0, 0, 0, 0L, 0, null, null, 16383, null);
    this.m = paramBoolean;
    this.l = paramCommonConfig;
  }
  
  public int b()
  {
    return super.getSliderWidth();
  }
  
  public final void c(boolean paramBoolean)
  {
    VideoTrackTimelineView.ContentSelectListener localContentSelectListener;
    if (paramBoolean)
    {
      localContentSelectListener = this.k;
      if (localContentSelectListener != null) {
        localContentSelectListener.a(getUuid(), getSelectedStatus(), this.d.a(((Number)this.p.getFirst()).floatValue(), ((Number)this.p.getSecond()).floatValue()), this.d.b(((Number)this.p.getFirst()).floatValue(), ((Number)this.p.getSecond()).floatValue()), this);
      }
    }
    else
    {
      localContentSelectListener = this.k;
      if (localContentSelectListener != null) {
        localContentSelectListener.a(getUuid(), getSelectedStatus(), false, false, this);
      }
    }
  }
  
  protected int getContentPadding()
  {
    return 0;
  }
  
  public int getMaxEndPosition()
  {
    VideoTrackModel localVideoTrackModel = this.i;
    if (localVideoTrackModel != null) {
      return localVideoTrackModel.i() + localVideoTrackModel.e();
    }
    return 0;
  }
  
  public int getMinDistance()
  {
    VideoTrackModel localVideoTrackModel = this.i;
    if (localVideoTrackModel != null) {
      return localVideoTrackModel.m();
    }
    return 0;
  }
  
  public int getMinStartPosition()
  {
    VideoTrackModel localVideoTrackModel = this.i;
    if (localVideoTrackModel != null) {
      return localVideoTrackModel.g();
    }
    return 0;
  }
  
  @NotNull
  public final String getUuid()
  {
    Object localObject = this.i;
    if (localObject != null)
    {
      localObject = ((VideoTrackModel)localObject).b();
      if (localObject != null) {
        return localObject;
      }
    }
    return "";
  }
  
  public final void h()
  {
    this.d.postInvalidate();
  }
  
  public final void setCornerRadius(int paramInt)
  {
    this.j = paramInt;
  }
  
  public final void setSelectListener(@NotNull VideoTrackTimelineView.ContentSelectListener paramContentSelectListener)
  {
    Intrinsics.checkParameterIsNotNull(paramContentSelectListener, "selectListener");
    this.k = paramContentSelectListener;
  }
  
  public void setSelected(boolean paramBoolean)
  {
    super.setSelected(paramBoolean);
    this.e.setRadius(DensityUtils.a.a(4.0F));
  }
  
  public final void setSingleBitmapWidth(int paramInt)
  {
    this.h = paramInt;
    this.d.setSingleBitmapWidth(paramInt);
  }
  
  public final void setThumbnailProvider(@NotNull IThumbnailProvider paramIThumbnailProvider)
  {
    Intrinsics.checkParameterIsNotNull(paramIThumbnailProvider, "provider");
    this.q = paramIThumbnailProvider;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.VideoTrackTimelineView
 * JD-Core Version:    0.7.0.1
 */