package dov.com.qq.im.aeeditor.view.videotrack;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import com.tencent.mobileqq.qcircle.api.IQCircleRFWApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.tavcut.util.SpeedUtil;
import com.tencent.tavcut.util.TimeFormatUtil;
import com.tencent.tavsticker.utils.ViewUtils;
import com.tencent.weishi.module.edit.widget.playtrack.provider.IPlayTrackViewBitmapProvider;
import com.tencent.weseevideo.camera.mvauto.redo.CutModelKt;
import com.tencent.weseevideo.camera.mvauto.redo.VideoResourceModelKt;
import com.tencent.weseevideo.camera.mvauto.redo.VideoResourceModelKt.Companion;
import com.tencent.weseevideo.model.resource.VideoResourceModel;
import dov.com.qq.im.ae.util.AEQLog;
import dov.com.qq.im.aeeditor.module.edit.multi.data.SpeedFloatUtil;
import dov.com.qq.im.aeeditor.view.dragdrop.IValueChangeListener;
import dov.com.qq.im.aeeditor.view.playtrack.view.PlayTrackExpandWidthView;
import dov.com.qq.im.aeeditor.view.timebar.scale.ScaleAdapter;
import dov.com.qq.im.aeeditor.view.timeline.EffectTimelineView;
import dov.com.qq.im.aeeditor.view.timeline.SliderView;
import dov.com.qq.im.aeeditor.view.timeline.TimeLineViewListener;

public class VideoTrackTimeLineView
  extends EffectTimelineView
{
  private float jdField_a_of_type_Float;
  private ObjectAnimator jdField_a_of_type_AndroidAnimationObjectAnimator;
  private Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private IPlayTrackViewBitmapProvider jdField_a_of_type_ComTencentWeishiModuleEditWidgetPlaytrackProviderIPlayTrackViewBitmapProvider = new VideoTrackTimeLineView.1(this);
  private CutModelKt jdField_a_of_type_ComTencentWeseevideoCameraMvautoRedoCutModelKt;
  private VideoResourceModel jdField_a_of_type_ComTencentWeseevideoModelResourceVideoResourceModel;
  private PlayTrackExpandWidthView jdField_a_of_type_DovComQqImAeeditorViewPlaytrackViewPlayTrackExpandWidthView;
  private RoundFrameLayout jdField_a_of_type_DovComQqImAeeditorViewVideotrackRoundFrameLayout;
  private VideoTrackTimeLineView.OnSlideChangedListener jdField_a_of_type_DovComQqImAeeditorViewVideotrackVideoTrackTimeLineView$OnSlideChangedListener;
  private boolean jdField_a_of_type_Boolean = true;
  private float jdField_b_of_type_Float = 0.0F;
  private View jdField_b_of_type_AndroidViewView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private boolean jdField_b_of_type_Boolean = true;
  private float jdField_c_of_type_Float = 0.0F;
  private int jdField_c_of_type_Int = 0;
  private boolean jdField_c_of_type_Boolean = true;
  private int d;
  protected long h = 0L;
  protected long i = 0L;
  protected long j = 0L;
  private long k = 0L;
  private long l = 0L;
  
  @RequiresApi(api=16)
  public VideoTrackTimeLineView(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  @RequiresApi(api=16)
  public VideoTrackTimeLineView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  @RequiresApi(api=16)
  public VideoTrackTimeLineView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.f = -1L;
    this.g = -1L;
    g();
  }
  
  private long a(long paramLong)
  {
    long l1 = ((float)(b() - this.jdField_a_of_type_DovComQqImAeeditorViewTimebarScaleScaleAdapter.c()) - (float)paramLong / this.jdField_a_of_type_Float);
    if ((this.jdField_b_of_type_Boolean) && (Math.abs(l1) < this.jdField_a_of_type_DovComQqImAeeditorViewTimebarScaleScaleAdapter.a(l())) && (this.jdField_a_of_type_ComTencentWeseevideoModelResourceVideoResourceModel.getScaleDuration() > c()))
    {
      AEQLog.b("miles", "第一次满足左侧吸附条件");
      performHapticFeedback(0, 2);
      this.jdField_b_of_type_Boolean = false;
      return ((float)Math.max(b() - this.jdField_a_of_type_DovComQqImAeeditorViewTimebarScaleScaleAdapter.c(), c()) * this.jdField_a_of_type_Float);
    }
    if (Math.abs(l1) >= this.jdField_a_of_type_DovComQqImAeeditorViewTimebarScaleScaleAdapter.a(l()))
    {
      this.jdField_b_of_type_Boolean = true;
      return paramLong;
    }
    return this.jdField_a_of_type_ComTencentWeseevideoModelResourceVideoResourceModel.getSelectTimeDuration();
  }
  
  private void a(long paramLong)
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView != null)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(TimeFormatUtil.getDurationSecondsEnglish(paramLong));
    }
  }
  
  private long b(long paramLong)
  {
    long l1 = ((float)(this.jdField_a_of_type_DovComQqImAeeditorViewTimebarScaleScaleAdapter.c() - a()) - (float)paramLong / this.jdField_a_of_type_Float);
    if ((this.jdField_c_of_type_Boolean) && (Math.abs(l1) < this.jdField_a_of_type_DovComQqImAeeditorViewTimebarScaleScaleAdapter.a(l())) && (this.jdField_a_of_type_ComTencentWeseevideoModelResourceVideoResourceModel.getScaleDuration() > c()))
    {
      Log.i("miles", "第一次满足左侧吸附条件");
      performHapticFeedback(0, 2);
      this.jdField_c_of_type_Boolean = false;
      return ((float)Math.max(this.jdField_a_of_type_DovComQqImAeeditorViewTimebarScaleScaleAdapter.c() - a(), c()) * this.jdField_a_of_type_Float);
    }
    if (Math.abs(l1) >= this.jdField_a_of_type_DovComQqImAeeditorViewTimebarScaleScaleAdapter.a(l()))
    {
      this.jdField_c_of_type_Boolean = true;
      return paramLong;
    }
    return this.jdField_a_of_type_ComTencentWeseevideoModelResourceVideoResourceModel.getSelectTimeDuration();
  }
  
  private boolean b()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_ComTencentWeseevideoCameraMvautoRedoCutModelKt != null)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_ComTencentWeseevideoCameraMvautoRedoCutModelKt.getResource() != null)
      {
        bool1 = bool2;
        if (this.jdField_a_of_type_ComTencentWeseevideoCameraMvautoRedoCutModelKt.getResource().getScaleDuration() != this.jdField_a_of_type_ComTencentWeseevideoCameraMvautoRedoCutModelKt.getResource().getSelectTimeDuration()) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  @RequiresApi(api=16)
  private void g()
  {
    this.jdField_a_of_type_DovComQqImAeeditorViewPlaytrackViewPlayTrackExpandWidthView = new PlayTrackExpandWidthView(getContext());
    ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(-1, -1);
    this.jdField_a_of_type_DovComQqImAeeditorViewVideotrackRoundFrameLayout.addView(this.jdField_a_of_type_DovComQqImAeeditorViewPlaytrackViewPlayTrackExpandWidthView, localLayoutParams);
    if (this.d == 0) {
      this.d = ViewUtils.dip2px(40.0F);
    }
    this.jdField_c_of_type_Int = ((int)getResources().getDimension(2131296308));
    this.jdField_a_of_type_DovComQqImAeeditorViewPlaytrackViewPlayTrackExpandWidthView.setPixelPerBitmap(this.d);
    this.jdField_a_of_type_DovComQqImAeeditorViewPlaytrackViewPlayTrackExpandWidthView.setVideoThumbProvider(this.jdField_a_of_type_ComTencentWeishiModuleEditWidgetPlaytrackProviderIPlayTrackViewBitmapProvider);
    h();
    i();
    j();
  }
  
  private void h()
  {
    this.jdField_a_of_type_AndroidViewView = new View(getContext());
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
    this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2131167388);
    this.jdField_a_of_type_AndroidViewView.setVisibility(4);
    this.jdField_a_of_type_DovComQqImAeeditorViewVideotrackRoundFrameLayout.addView(this.jdField_a_of_type_AndroidViewView, localLayoutParams);
  }
  
  private void i()
  {
    this.jdField_a_of_type_AndroidWidgetTextView = new TextView(getContext());
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, (int)getResources().getDimension(2131296330));
    localLayoutParams.leftMargin = ((int)getResources().getDimension(2131296304));
    localLayoutParams.bottomMargin = ((int)getResources().getDimension(2131296308));
    localLayoutParams.gravity = 83;
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(0, getResources().getDimension(2131296326));
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
    this.jdField_a_of_type_AndroidWidgetTextView.setShadowLayer(4.0F, 1.0F, 3.0F, 2131165368);
    this.jdField_a_of_type_AndroidWidgetTextView.setIncludeFontPadding(false);
    this.jdField_a_of_type_AndroidWidgetTextView.setSingleLine();
    this.jdField_a_of_type_AndroidWidgetTextView.setGravity(80);
    this.jdField_a_of_type_AndroidWidgetTextView.setPadding((int)getResources().getDimension(2131296307), 0, (int)getResources().getDimension(2131296307), 0);
    this.jdField_a_of_type_AndroidWidgetTextView.setTypeface(((IQCircleRFWApi)QRoute.api(IQCircleRFWApi.class)).getTypeface(getContext(), "https://downv6.qq.com/video_story/qcircle/ttf/qircle_number_bold.ttf"));
    this.jdField_a_of_type_DovComQqImAeeditorViewVideotrackRoundFrameLayout.addView(this.jdField_a_of_type_AndroidWidgetTextView, localLayoutParams);
  }
  
  @RequiresApi(api=16)
  private void j()
  {
    this.jdField_b_of_type_AndroidWidgetTextView = new TextView(getContext());
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams((int)getResources().getDimension(2131296342), (int)getResources().getDimension(2131296328));
    localLayoutParams.leftMargin = ((int)getResources().getDimension(2131296312));
    localLayoutParams.topMargin = ((int)getResources().getDimension(2131296307));
    localLayoutParams.gravity = 51;
    this.jdField_b_of_type_AndroidWidgetTextView.setTextSize(0, getResources().getDimension(2131296319));
    this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-1);
    this.jdField_b_of_type_AndroidWidgetTextView.setSingleLine();
    this.jdField_a_of_type_AndroidWidgetTextView.setIncludeFontPadding(false);
    this.jdField_b_of_type_AndroidWidgetTextView.setGravity(17);
    this.jdField_b_of_type_AndroidWidgetTextView.setBackground(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130837992));
    this.jdField_b_of_type_AndroidWidgetTextView.setTypeface(((IQCircleRFWApi)QRoute.api(IQCircleRFWApi.class)).getTypeface(getContext(), "https://downv6.qq.com/video_story/qcircle/ttf/qircle_number_bold.ttf"));
    this.jdField_a_of_type_DovComQqImAeeditorViewVideotrackRoundFrameLayout.addView(this.jdField_b_of_type_AndroidWidgetTextView, localLayoutParams);
  }
  
  private void k()
  {
    if (this.jdField_b_of_type_AndroidWidgetTextView == null) {
      return;
    }
    if (b())
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      float f = this.jdField_a_of_type_ComTencentWeseevideoModelResourceVideoResourceModel.getSpeed();
      if (SpeedFloatUtil.a(f, 0.75F))
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(SpeedUtil.getPreciseValue(f, 2) + "x");
        return;
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setText(SpeedUtil.getPreciseValue(f, 1) + "x");
      return;
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  private int l()
  {
    if (this.jdField_a_of_type_DovComQqImAeeditorViewTimebarScaleScaleAdapter != null) {
      return (int)(this.jdField_a_of_type_DovComQqImAeeditorViewTimebarScaleScaleAdapter.a() / 4.0F);
    }
    return (int)getResources().getDimension(2131296319);
  }
  
  private void l()
  {
    float f = this.jdField_a_of_type_DovComQqImAeeditorViewTimebarScaleScaleAdapter.a(((float)this.jdField_a_of_type_ComTencentWeseevideoModelResourceVideoResourceModel.getSelectTimeDuration() / this.jdField_a_of_type_Float));
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)getLayoutParams();
    localMarginLayoutParams.width = ((int)(f + h() * 2));
    setLayoutParams(localMarginLayoutParams);
  }
  
  private void m()
  {
    this.h = this.jdField_a_of_type_ComTencentWeseevideoModelResourceVideoResourceModel.getSelectTimeStart();
    this.i = this.jdField_a_of_type_ComTencentWeseevideoModelResourceVideoResourceModel.getSelectTimeDuration();
    this.j = this.jdField_a_of_type_ComTencentWeseevideoModelResourceVideoResourceModel.getSourceTimeDuration();
  }
  
  public ViewGroup a()
  {
    ViewGroup localViewGroup = (ViewGroup)LayoutInflater.from(getContext()).inflate(2131558607, null);
    this.jdField_b_of_type_AndroidViewView = localViewGroup.findViewById(2131363573);
    this.jdField_a_of_type_DovComQqImAeeditorViewVideotrackRoundFrameLayout = ((RoundFrameLayout)localViewGroup.findViewById(2131365294));
    return localViewGroup;
  }
  
  public CutModelKt a()
  {
    return this.jdField_a_of_type_ComTencentWeseevideoCameraMvautoRedoCutModelKt.copy(this.jdField_a_of_type_ComTencentWeseevideoCameraMvautoRedoCutModelKt.getUuid(), VideoResourceModelKt.Companion.from(this.jdField_a_of_type_ComTencentWeseevideoModelResourceVideoResourceModel), this.jdField_a_of_type_ComTencentWeseevideoCameraMvautoRedoCutModelKt.getVideoConfiguration(), this.jdField_a_of_type_ComTencentWeseevideoCameraMvautoRedoCutModelKt.getAudioConfiguration());
  }
  
  public PlayTrackExpandWidthView a()
  {
    return this.jdField_a_of_type_DovComQqImAeeditorViewPlaytrackViewPlayTrackExpandWidthView;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_ComTencentWeseevideoModelResourceVideoResourceModel.getPath();
  }
  
  public void a()
  {
    super.a();
    m();
    this.jdField_c_of_type_Float = this.jdField_b_of_type_Float;
  }
  
  public void a(float paramFloat)
  {
    AEQLog.a("VideoTrackTimeLineView", "[handleLeftSliderMove]");
    if (this.jdField_a_of_type_DovComQqImAeeditorViewVideotrackVideoTrackTimeLineView$OnSlideChangedListener != null) {
      this.jdField_a_of_type_DovComQqImAeeditorViewVideotrackVideoTrackTimeLineView$OnSlideChangedListener.a(true);
    }
    long l2;
    long l1;
    if ((paramFloat < this.jdField_b_of_type_Float) && (this.jdField_a_of_type_DovComQqImAeeditorViewDragdropIValueChangeListener.a()))
    {
      this.jdField_a_of_type_DovComQqImAeeditorViewDragdropIValueChangeListener.a();
      this.jdField_c_of_type_Float = this.jdField_b_of_type_Float;
      m();
      paramFloat -= this.jdField_c_of_type_Float;
      if (((paramFloat < 0.0F) && (this.jdField_a_of_type_ComTencentWeseevideoModelResourceVideoResourceModel.getSelectTimeStart() > 0L)) || ((paramFloat > 0.0F) && ((float)this.jdField_a_of_type_ComTencentWeseevideoModelResourceVideoResourceModel.getSelectTimeDuration() / this.jdField_a_of_type_Float > (float)c())) || ((paramFloat > 0.0F) && (paramFloat < this.jdField_b_of_type_Float)))
      {
        l2 = ((float)this.jdField_a_of_type_DovComQqImAeeditorViewTimebarScaleScaleAdapter.a(paramFloat) * this.jdField_a_of_type_Float);
        if (l2 > -this.h) {
          break label404;
        }
        l1 = -this.h;
      }
    }
    for (;;)
    {
      l1 = a(this.i - l1);
      l1 = this.i - l1;
      this.jdField_a_of_type_ComTencentWeseevideoModelResourceVideoResourceModel.setSelectTimeStartUs((this.h + l1) * 1000L);
      this.jdField_a_of_type_ComTencentWeseevideoModelResourceVideoResourceModel.setSelectTimeDurationUs((this.i - l1) * 1000L);
      this.jdField_a_of_type_ComTencentWeseevideoModelResourceVideoResourceModel.setScaleDuration(((float)this.jdField_a_of_type_ComTencentWeseevideoModelResourceVideoResourceModel.getSelectTimeDuration() / this.jdField_a_of_type_Float));
      l();
      if (this.jdField_a_of_type_DovComQqImAeeditorViewTimelineTimeLineViewListener != null) {
        this.jdField_a_of_type_DovComQqImAeeditorViewTimelineTimeLineViewListener.a(this, this.jdField_b_of_type_Long, ((float)l1 / this.jdField_a_of_type_Float));
      }
      a(((float)this.jdField_a_of_type_ComTencentWeseevideoModelResourceVideoResourceModel.getSelectTimeDuration() / this.jdField_a_of_type_Float));
      this.jdField_b_of_type_Float = (this.jdField_c_of_type_Float + paramFloat);
      if (this.jdField_a_of_type_DovComQqImAeeditorViewVideotrackVideoTrackTimeLineView$OnSlideChangedListener != null) {
        this.jdField_a_of_type_DovComQqImAeeditorViewVideotrackVideoTrackTimeLineView$OnSlideChangedListener.e();
      }
      return;
      if ((paramFloat > this.jdField_b_of_type_Float) && (this.jdField_a_of_type_DovComQqImAeeditorViewDragdropIValueChangeListener.b()))
      {
        this.jdField_a_of_type_DovComQqImAeeditorViewDragdropIValueChangeListener.a();
        this.jdField_c_of_type_Float = this.jdField_b_of_type_Float;
        m();
        break;
      }
      if ((!this.jdField_a_of_type_DovComQqImAeeditorViewDragdropIValueChangeListener.a()) && (!this.jdField_a_of_type_DovComQqImAeeditorViewDragdropIValueChangeListener.b())) {
        break;
      }
      AEQLog.b("miles", "滚动中，直接return");
      this.jdField_b_of_type_Float = paramFloat;
      return;
      label404:
      l1 = l2;
      if ((float)l2 > (float)this.i - (float)c() * this.jdField_a_of_type_Float) {
        l1 = ((float)this.i - (float)c() * this.jdField_a_of_type_Float);
      }
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_ComTencentWeseevideoModelResourceVideoResourceModel.setSelectTimeStartUs((paramInt * this.jdField_a_of_type_Float) * 1000L);
    this.jdField_a_of_type_ComTencentWeseevideoModelResourceVideoResourceModel.setSelectTimeDurationUs(((float)(this.h + this.i) - paramInt * this.jdField_a_of_type_Float) * 1000L);
    this.jdField_a_of_type_ComTencentWeseevideoModelResourceVideoResourceModel.setScaleDuration(((float)this.jdField_a_of_type_ComTencentWeseevideoModelResourceVideoResourceModel.getSelectTimeDuration() / this.jdField_a_of_type_Float));
    l();
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.a(paramView, paramInt1, paramInt2, paramInt3, paramInt4);
    this.jdField_a_of_type_DovComQqImAeeditorViewPlaytrackViewPlayTrackExpandWidthView.invalidate();
  }
  
  public void a(boolean paramBoolean)
  {
    AEQLog.a("VideoTrackTimeLineView", "[onSliderMoveEnd]");
    if (this.jdField_a_of_type_DovComQqImAeeditorViewVideotrackVideoTrackTimeLineView$OnSlideChangedListener != null) {
      this.jdField_a_of_type_DovComQqImAeeditorViewVideotrackVideoTrackTimeLineView$OnSlideChangedListener.a(false);
    }
    super.a(paramBoolean);
    this.jdField_b_of_type_Float = 0.0F;
    this.jdField_c_of_type_Float = 0.0F;
    m();
    this.jdField_b_of_type_Boolean = true;
    this.jdField_c_of_type_Boolean = true;
  }
  
  public void b()
  {
    super.b();
    m();
  }
  
  public void b(float paramFloat)
  {
    AEQLog.a("VideoTrackTimeLineView", "[handleRightSliderMove]");
    if (this.jdField_a_of_type_DovComQqImAeeditorViewVideotrackVideoTrackTimeLineView$OnSlideChangedListener != null) {
      this.jdField_a_of_type_DovComQqImAeeditorViewVideotrackVideoTrackTimeLineView$OnSlideChangedListener.a(true);
    }
    long l2;
    long l1;
    if ((paramFloat < this.jdField_b_of_type_Float) && (this.jdField_a_of_type_DovComQqImAeeditorViewDragdropIValueChangeListener.a()))
    {
      this.jdField_a_of_type_DovComQqImAeeditorViewDragdropIValueChangeListener.a();
      this.jdField_c_of_type_Float = this.jdField_b_of_type_Float;
      m();
      paramFloat -= this.jdField_c_of_type_Float;
      if (((paramFloat < 0.0F) && ((float)this.jdField_a_of_type_ComTencentWeseevideoModelResourceVideoResourceModel.getSelectTimeDuration() / this.jdField_a_of_type_Float > (float)c())) || ((paramFloat > 0.0F) && (this.jdField_a_of_type_ComTencentWeseevideoModelResourceVideoResourceModel.getSelectTimeStart() + this.jdField_a_of_type_ComTencentWeseevideoModelResourceVideoResourceModel.getSelectTimeDuration() < this.j)))
      {
        l2 = ((float)this.jdField_a_of_type_DovComQqImAeeditorViewTimebarScaleScaleAdapter.a(paramFloat) * this.jdField_a_of_type_Float);
        if (l2 < this.j - this.h - this.i) {
          break label392;
        }
        l1 = this.j - this.h - this.i;
      }
    }
    for (;;)
    {
      l1 = b(l1 + this.i);
      l2 = this.i;
      this.jdField_a_of_type_ComTencentWeseevideoModelResourceVideoResourceModel.setSelectTimeDurationUs(1000L * l1);
      this.jdField_a_of_type_ComTencentWeseevideoModelResourceVideoResourceModel.setScaleDuration(((float)l1 / this.jdField_a_of_type_Float));
      l();
      if (this.jdField_a_of_type_DovComQqImAeeditorViewTimelineTimeLineViewListener != null) {
        this.jdField_a_of_type_DovComQqImAeeditorViewTimelineTimeLineViewListener.b(this, this.jdField_c_of_type_Long, ((float)(l1 - l2) / this.jdField_a_of_type_Float));
      }
      a(((float)this.jdField_a_of_type_ComTencentWeseevideoModelResourceVideoResourceModel.getSelectTimeDuration() / this.jdField_a_of_type_Float));
      this.jdField_b_of_type_Float = (this.jdField_c_of_type_Float + paramFloat);
      if (this.jdField_a_of_type_DovComQqImAeeditorViewVideotrackVideoTrackTimeLineView$OnSlideChangedListener != null) {
        this.jdField_a_of_type_DovComQqImAeeditorViewVideotrackVideoTrackTimeLineView$OnSlideChangedListener.e();
      }
      return;
      if ((paramFloat > this.jdField_b_of_type_Float) && (this.jdField_a_of_type_DovComQqImAeeditorViewDragdropIValueChangeListener.b()))
      {
        this.jdField_a_of_type_DovComQqImAeeditorViewDragdropIValueChangeListener.a();
        this.jdField_c_of_type_Float = this.jdField_b_of_type_Float;
        m();
        break;
      }
      if ((!this.jdField_a_of_type_DovComQqImAeeditorViewDragdropIValueChangeListener.a()) && (!this.jdField_a_of_type_DovComQqImAeeditorViewDragdropIValueChangeListener.b())) {
        break;
      }
      AEQLog.b("miles", "滚动中，直接return");
      this.jdField_b_of_type_Float = paramFloat;
      return;
      label392:
      l1 = l2;
      if ((float)l2 <= -((float)this.i - (float)c() * this.jdField_a_of_type_Float)) {
        l1 = -((float)this.i - (float)c() * this.jdField_a_of_type_Float);
      }
    }
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_ComTencentWeseevideoModelResourceVideoResourceModel.setSelectTimeStartUs(((float)(this.h + this.i) - paramInt * this.jdField_a_of_type_Float - (float)c()) * 1000L);
    this.jdField_a_of_type_ComTencentWeseevideoModelResourceVideoResourceModel.setSelectTimeDurationUs((paramInt * this.jdField_a_of_type_Float + (float)c()) * 1000L);
    this.jdField_a_of_type_ComTencentWeseevideoModelResourceVideoResourceModel.setScaleDuration(((float)this.jdField_a_of_type_ComTencentWeseevideoModelResourceVideoResourceModel.getSelectTimeDuration() / this.jdField_a_of_type_Float));
    l();
  }
  
  public void c(int paramInt)
  {
    this.jdField_a_of_type_ComTencentWeseevideoModelResourceVideoResourceModel.setSelectTimeStartUs(this.h * 1000L);
    this.jdField_a_of_type_ComTencentWeseevideoModelResourceVideoResourceModel.setSelectTimeDurationUs(((float)(paramInt + c()) * this.jdField_a_of_type_Float) * 1000L);
    this.jdField_a_of_type_ComTencentWeseevideoModelResourceVideoResourceModel.setScaleDuration(paramInt + c());
    l();
  }
  
  public int d()
  {
    return getResources().getDimensionPixelOffset(2131296336);
  }
  
  public long d()
  {
    return ((float)this.jdField_a_of_type_ComTencentWeseevideoModelResourceVideoResourceModel.getSelectTimeDuration() / this.jdField_a_of_type_Float);
  }
  
  public void d()
  {
    if (this.l > 0L) {
      setRedMaskViewShowTimeRange(this.k, this.l);
    }
  }
  
  public void d(int paramInt)
  {
    this.jdField_a_of_type_ComTencentWeseevideoModelResourceVideoResourceModel.setSelectTimeStartUs(this.h * 1000L);
    this.jdField_a_of_type_ComTencentWeseevideoModelResourceVideoResourceModel.setSelectTimeDurationUs(((float)(this.j - this.h) - paramInt * this.jdField_a_of_type_Float) * 1000L);
    this.jdField_a_of_type_ComTencentWeseevideoModelResourceVideoResourceModel.setScaleDuration(((float)this.jdField_a_of_type_ComTencentWeseevideoModelResourceVideoResourceModel.getSelectTimeDuration() / this.jdField_a_of_type_Float));
    l();
  }
  
  public int e()
  {
    return 0;
  }
  
  public long e()
  {
    return ((float)this.jdField_a_of_type_ComTencentWeseevideoModelResourceVideoResourceModel.getSelectTimeStart() / this.jdField_a_of_type_Float);
  }
  
  public void e()
  {
    this.jdField_a_of_type_DovComQqImAeeditorViewPlaytrackViewPlayTrackExpandWidthView.postInvalidate();
  }
  
  public long f()
  {
    return ((float)this.jdField_a_of_type_ComTencentWeseevideoModelResourceVideoResourceModel.getSelectTimeDuration() / this.jdField_a_of_type_Float - (float)c());
  }
  
  @RequiresApi(api=17)
  public void f()
  {
    if (this.jdField_a_of_type_AndroidAnimationObjectAnimator != null)
    {
      localView = (View)this.jdField_a_of_type_AndroidAnimationObjectAnimator.getTarget();
      if (localView != null) {
        this.jdField_a_of_type_DovComQqImAeeditorViewVideotrackRoundFrameLayout.removeView(localView);
      }
      this.jdField_a_of_type_AndroidAnimationObjectAnimator.removeAllListeners();
      this.jdField_a_of_type_AndroidAnimationObjectAnimator.cancel();
    }
    View localView = new View(getContext());
    localView.setAlpha(0.0F);
    if (Build.VERSION.SDK_INT >= 17) {
      localView.setId(View.generateViewId());
    }
    localView.setBackgroundColor(getContext().getResources().getColor(2131165219));
    this.jdField_a_of_type_AndroidAnimationObjectAnimator = ObjectAnimator.ofFloat(localView, "alpha", new float[] { 0.0F, 0.3F }).setDuration(200L);
    this.jdField_a_of_type_AndroidAnimationObjectAnimator.setStartDelay(500L);
    this.jdField_a_of_type_AndroidAnimationObjectAnimator.setRepeatCount(4);
    this.jdField_a_of_type_AndroidAnimationObjectAnimator.setRepeatMode(2);
    this.jdField_a_of_type_AndroidAnimationObjectAnimator.addListener(new VideoTrackTimeLineView.2(this, localView));
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
    this.jdField_a_of_type_DovComQqImAeeditorViewVideotrackRoundFrameLayout.addView(localView, localLayoutParams);
    this.jdField_a_of_type_AndroidAnimationObjectAnimator.start();
  }
  
  public long g()
  {
    return ((float)this.jdField_a_of_type_ComTencentWeseevideoModelResourceVideoResourceModel.getSelectTimeDuration() / this.jdField_a_of_type_Float - (float)c());
  }
  
  public long h()
  {
    return ((float)(this.j - this.jdField_a_of_type_ComTencentWeseevideoModelResourceVideoResourceModel.getSelectTimeDuration() - this.jdField_a_of_type_ComTencentWeseevideoModelResourceVideoResourceModel.getSelectTimeStart()) / this.jdField_a_of_type_Float);
  }
  
  public void setBitmapWidth(int paramInt)
  {
    this.d = paramInt;
    this.jdField_a_of_type_DovComQqImAeeditorViewPlaytrackViewPlayTrackExpandWidthView.setPixelPerBitmap(this.d);
  }
  
  public void setCornerRadius(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
    RoundFrameLayout localRoundFrameLayout;
    if (this.jdField_a_of_type_DovComQqImAeeditorViewVideotrackRoundFrameLayout != null)
    {
      localRoundFrameLayout = this.jdField_a_of_type_DovComQqImAeeditorViewVideotrackRoundFrameLayout;
      if (!isSelected()) {
        break label32;
      }
    }
    label32:
    for (paramInt = 0;; paramInt = this.jdField_c_of_type_Int)
    {
      localRoundFrameLayout.setRadius(paramInt);
      return;
    }
  }
  
  public void setEndValue(long paramLong)
  {
    super.setEndValue(paramLong);
    if (this.g == -1L) {
      this.g = paramLong;
    }
  }
  
  public void setMediaClipModel(CutModelKt paramCutModelKt)
  {
    this.jdField_a_of_type_ComTencentWeseevideoCameraMvautoRedoCutModelKt = paramCutModelKt;
    this.jdField_a_of_type_ComTencentWeseevideoModelResourceVideoResourceModel = paramCutModelKt.getResource().convert();
    this.jdField_a_of_type_Float = this.jdField_a_of_type_ComTencentWeseevideoCameraMvautoRedoCutModelKt.getResource().getScaleSpeed();
  }
  
  public void setOnSlideChangedListener(VideoTrackTimeLineView.OnSlideChangedListener paramOnSlideChangedListener)
  {
    this.jdField_a_of_type_DovComQqImAeeditorViewVideotrackVideoTrackTimeLineView$OnSlideChangedListener = paramOnSlideChangedListener;
  }
  
  public void setRedMaskViewShowTimeRange(long paramLong1, long paramLong2)
  {
    if ((paramLong1 < 0L) || (paramLong2 <= 0L)) {
      return;
    }
    this.k = paramLong1;
    this.l = paramLong2;
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
    localLayoutParams.leftMargin = this.jdField_a_of_type_DovComQqImAeeditorViewTimebarScaleScaleAdapter.a(paramLong1);
    localLayoutParams.width = this.jdField_a_of_type_DovComQqImAeeditorViewTimebarScaleScaleAdapter.a(paramLong2);
    this.jdField_a_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
  }
  
  public void setScaleModel(ScaleAdapter paramScaleAdapter)
  {
    super.setScaleModel(paramScaleAdapter);
    this.jdField_a_of_type_DovComQqImAeeditorViewPlaytrackViewPlayTrackExpandWidthView.setScaleAdapter(this.jdField_a_of_type_DovComQqImAeeditorViewTimebarScaleScaleAdapter);
  }
  
  public void setSelected(boolean paramBoolean)
  {
    super.setSelected(paramBoolean);
    a(((float)this.jdField_a_of_type_ComTencentWeseevideoModelResourceVideoResourceModel.getSelectTimeDuration() / this.jdField_a_of_type_Float));
    k();
    if (this.jdField_b_of_type_Int == 1) {
      this.jdField_b_of_type_AndroidViewView.setSelected(paramBoolean);
    }
    while (this.jdField_b_of_type_Int != 0) {
      return;
    }
    RoundFrameLayout localRoundFrameLayout = this.jdField_a_of_type_DovComQqImAeeditorViewVideotrackRoundFrameLayout;
    if (paramBoolean) {}
    for (int m = 0;; m = this.jdField_c_of_type_Int)
    {
      localRoundFrameLayout.setRadius(m);
      return;
    }
  }
  
  public void setSelectedStyle(int paramInt)
  {
    super.setSelectedStyle(paramInt);
    if (this.jdField_b_of_type_Int == 1) {
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
    }
    while (this.jdField_b_of_type_Int != 0) {
      return;
    }
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
  }
  
  public void setShowSliderView(boolean paramBoolean)
  {
    int n = 0;
    SliderView localSliderView;
    if (this.jdField_a_of_type_DovComQqImAeeditorViewTimelineSliderView != null)
    {
      localSliderView = this.jdField_a_of_type_DovComQqImAeeditorViewTimelineSliderView;
      if (paramBoolean)
      {
        m = 0;
        localSliderView.setVisibility(m);
      }
    }
    else if (this.jdField_b_of_type_DovComQqImAeeditorViewTimelineSliderView != null)
    {
      localSliderView = this.jdField_b_of_type_DovComQqImAeeditorViewTimelineSliderView;
      if (!paramBoolean) {
        break label58;
      }
    }
    label58:
    for (int m = n;; m = 4)
    {
      localSliderView.setVisibility(m);
      return;
      m = 4;
      break;
    }
  }
  
  public void setStartValue(long paramLong)
  {
    super.setStartValue(paramLong);
    if (this.f == -1L) {
      this.f = paramLong;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.view.videotrack.VideoTrackTimeLineView
 * JD-Core Version:    0.7.0.1
 */