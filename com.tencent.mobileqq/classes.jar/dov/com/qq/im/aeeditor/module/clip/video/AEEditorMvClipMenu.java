package dov.com.qq.im.aeeditor.module.clip.video;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.qcircle.api.IQCircleRFWApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.player.IPlayer.PlayerStatus;
import com.tencent.tavcut.player.MoviePlayer;
import com.tencent.tavcut.timeline.TimelineBuilder;
import com.tencent.tavcut.timeline.TimelineView;
import com.tencent.tavcut.timeline.TimelineView.SpeedChangeCallback;
import com.tencent.tavkit.composition.TAVSource;
import dov.com.qq.im.ae.util.AEThemeUtil;

public class AEEditorMvClipMenu
  extends FrameLayout
{
  private float jdField_a_of_type_Float = 1.0F;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout = null;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private CMTimeRange jdField_a_of_type_ComTencentTavCoremediaCMTimeRange;
  private IPlayer.PlayerStatus jdField_a_of_type_ComTencentTavPlayerIPlayer$PlayerStatus;
  private TimelineView jdField_a_of_type_ComTencentTavcutTimelineTimelineView;
  TAVSource jdField_a_of_type_ComTencentTavkitCompositionTAVSource;
  private AEEditorMvClipMenu.MvClipMenuListener jdField_a_of_type_DovComQqImAeeditorModuleClipVideoAEEditorMvClipMenu$MvClipMenuListener;
  private boolean jdField_a_of_type_Boolean = false;
  private CMTimeRange jdField_b_of_type_ComTencentTavCoremediaCMTimeRange;
  private IPlayer.PlayerStatus jdField_b_of_type_ComTencentTavPlayerIPlayer$PlayerStatus;
  private boolean jdField_b_of_type_Boolean = false;
  
  public AEEditorMvClipMenu(@NonNull Context paramContext)
  {
    super(paramContext);
    b();
  }
  
  public AEEditorMvClipMenu(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b();
  }
  
  public AEEditorMvClipMenu(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    b();
  }
  
  private void a(CMTime paramCMTime)
  {
    if (this.jdField_a_of_type_DovComQqImAeeditorModuleClipVideoAEEditorMvClipMenu$MvClipMenuListener != null) {
      this.jdField_a_of_type_DovComQqImAeeditorModuleClipVideoAEEditorMvClipMenu$MvClipMenuListener.a(paramCMTime);
    }
  }
  
  private void a(CMTimeRange paramCMTimeRange)
  {
    if (this.jdField_a_of_type_DovComQqImAeeditorModuleClipVideoAEEditorMvClipMenu$MvClipMenuListener != null) {
      this.jdField_a_of_type_DovComQqImAeeditorModuleClipVideoAEEditorMvClipMenu$MvClipMenuListener.a(paramCMTimeRange);
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_DovComQqImAeeditorModuleClipVideoAEEditorMvClipMenu$MvClipMenuListener != null) {
      this.jdField_a_of_type_DovComQqImAeeditorModuleClipVideoAEEditorMvClipMenu$MvClipMenuListener.a(paramBoolean);
    }
  }
  
  private void b()
  {
    c();
  }
  
  private void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  private void c()
  {
    this.jdField_b_of_type_Boolean = AEThemeUtil.a();
    inflate(getContext(), 2131558608, this);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131362322));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131369818));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131380608));
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131372071));
    this.jdField_a_of_type_ComTencentTavcutTimelineTimelineView = new TimelineView(getContext(), null, 2130837974, 2130837731, 2130837731, 2130837921, 2130837922, 2130837923, 2130837924);
    this.jdField_a_of_type_ComTencentTavcutTimelineTimelineView.setSliderFrameColor(Color.parseColor("#3B80FF"));
    this.jdField_a_of_type_ComTencentTavcutTimelineTimelineView.setIndicatorRes(2130838017);
    this.jdField_a_of_type_ComTencentTavcutTimelineTimelineView.setDurationBgRes(2130837966);
    this.jdField_a_of_type_ComTencentTavcutTimelineTimelineView.setTypeface(((IQCircleRFWApi)QRoute.api(IQCircleRFWApi.class)).getTypeface(getContext(), "https://downv6.qq.com/video_story/qcircle/ttf/qircle_number_bold.ttf"));
    this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_ComTencentTavcutTimelineTimelineView);
    d();
    e();
    f();
  }
  
  private void d() {}
  
  private void e()
  {
    this.jdField_a_of_type_ComTencentTavcutTimelineTimelineView.setSliderChangeListener(new AEEditorMvClipMenu.1(this));
  }
  
  private void f()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new AEEditorMvClipMenu.2(this));
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentTavcutTimelineTimelineView != null) {
      this.jdField_a_of_type_ComTencentTavcutTimelineTimelineView.release();
    }
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    Object localObject = this.jdField_a_of_type_ComTencentTavCoremediaCMTimeRange.getDuration();
    Log.e("MvClipMenu", "updateTimeLineView: newTimeRange " + this.jdField_a_of_type_ComTencentTavCoremediaCMTimeRange);
    CMTimeRange localCMTimeRange = this.jdField_a_of_type_ComTencentTavCoremediaCMTimeRange;
    long l = ((CMTime)localObject).getTimeUs() / 1000L;
    if (paramLong1 != -1L) {
      if (paramLong2 == -1L) {
        break label150;
      }
    }
    for (;;)
    {
      localObject = new TimelineBuilder().setMaxSelectDurationMs(60000L).setLockMode(false).setSliderBarMode(true).setShowDuration(true);
      this.jdField_a_of_type_ComTencentTavcutTimelineTimelineView.setTimelineBuilder((TimelineBuilder)localObject);
      this.jdField_a_of_type_ComTencentTavcutTimelineTimelineView.setClipData(this.jdField_a_of_type_ComTencentTavkitCompositionTAVSource, l, paramLong1, paramLong2);
      this.jdField_a_of_type_ComTencentTavcutTimelineTimelineView.setSpeed(1.0F);
      return;
      paramLong1 = localCMTimeRange.getStart().multi(1.0F).getTimeUs() / 1000L;
      break;
      label150:
      paramLong2 = localCMTimeRange.getEnd().multi(1.0F).getTimeUs() / 1000L;
    }
  }
  
  public void a(MoviePlayer paramMoviePlayer)
  {
    if (this.jdField_a_of_type_ComTencentTavcutTimelineTimelineView != null) {
      this.jdField_a_of_type_ComTencentTavcutTimelineTimelineView.bindPlayer(paramMoviePlayer);
    }
  }
  
  public void a(TAVSource paramTAVSource)
  {
    this.jdField_a_of_type_ComTencentTavcutTimelineTimelineView.updateTavSource(paramTAVSource);
  }
  
  public void a(TAVSource paramTAVSource, long paramLong1, long paramLong2)
  {
    if (this.jdField_a_of_type_ComTencentTavcutTimelineTimelineView != null) {
      this.jdField_a_of_type_ComTencentTavcutTimelineTimelineView.updateTimeRangeAndSource(paramTAVSource, paramLong1, paramLong2);
    }
  }
  
  public void a(TAVSource paramTAVSource, long paramLong1, long paramLong2, long paramLong3)
  {
    if (this.jdField_a_of_type_ComTencentTavcutTimelineTimelineView != null) {
      this.jdField_a_of_type_ComTencentTavcutTimelineTimelineView.setClipData(paramTAVSource, paramLong1, paramLong2, paramLong3);
    }
  }
  
  public void setMvClipMenuListener(AEEditorMvClipMenu.MvClipMenuListener paramMvClipMenuListener)
  {
    this.jdField_a_of_type_DovComQqImAeeditorModuleClipVideoAEEditorMvClipMenu$MvClipMenuListener = paramMvClipMenuListener;
  }
  
  public void setPlayPosition(CMTime paramCMTime)
  {
    if (this.jdField_a_of_type_ComTencentTavcutTimelineTimelineView != null) {
      this.jdField_a_of_type_ComTencentTavcutTimelineTimelineView.setPlayPosition(((float)(paramCMTime.getTimeUs() / 1000L) * 1.0F));
    }
  }
  
  public void setPlayStatus(IPlayer.PlayerStatus paramPlayerStatus)
  {
    this.jdField_a_of_type_ComTencentTavPlayerIPlayer$PlayerStatus = paramPlayerStatus;
  }
  
  public void setSpeedEnable(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new AEEditorMvClipMenu.4(this));
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131165357));
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130837913);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new AEEditorMvClipMenu.5(this));
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131166284));
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130837914);
  }
  
  public void setTAVSource(TAVSource paramTAVSource)
  {
    this.jdField_a_of_type_ComTencentTavkitCompositionTAVSource = paramTAVSource;
  }
  
  public void setTime(CMTimeRange paramCMTimeRange)
  {
    this.jdField_b_of_type_ComTencentTavCoremediaCMTimeRange = paramCMTimeRange;
    this.jdField_a_of_type_ComTencentTavCoremediaCMTimeRange = paramCMTimeRange;
    Log.e("MvClipMenu", "setTime: newTimeRange " + this.jdField_a_of_type_ComTencentTavCoremediaCMTimeRange);
  }
  
  public void setTimeLineViewSpeed(float paramFloat, TimelineView.SpeedChangeCallback paramSpeedChangeCallback)
  {
    if (this.jdField_a_of_type_ComTencentTavcutTimelineTimelineView != null) {
      this.jdField_a_of_type_ComTencentTavcutTimelineTimelineView.updateSpeed(paramFloat, new AEEditorMvClipMenu.3(this, paramSpeedChangeCallback));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.clip.video.AEEditorMvClipMenu
 * JD-Core Version:    0.7.0.1
 */