package dov.com.qq.im.aeeditor.module.clip.video;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.FrameLayout;
import android.widget.ImageView;
import bnri;
import bnwp;
import bnwq;
import bnwr;
import bnws;
import bnwt;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.player.IPlayer.PlayerStatus;
import com.tencent.tavcut.player.MoviePlayer;
import com.tencent.tavcut.timeline.TimelineBuilder;
import com.tencent.tavcut.timeline.TimelineView;
import com.tencent.tavcut.timeline.TimelineView.SpeedChangeCallback;
import com.tencent.tavkit.composition.TAVSource;

public class AEEditorMvClipMenu
  extends FrameLayout
{
  private float jdField_a_of_type_Float = 1.0F;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private bnwt jdField_a_of_type_Bnwt;
  private CMTimeRange jdField_a_of_type_ComTencentTavCoremediaCMTimeRange;
  private IPlayer.PlayerStatus jdField_a_of_type_ComTencentTavPlayerIPlayer$PlayerStatus;
  private TimelineView jdField_a_of_type_ComTencentTavcutTimelineTimelineView;
  TAVSource jdField_a_of_type_ComTencentTavkitCompositionTAVSource;
  private boolean jdField_a_of_type_Boolean;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private CMTimeRange jdField_b_of_type_ComTencentTavCoremediaCMTimeRange;
  private IPlayer.PlayerStatus jdField_b_of_type_ComTencentTavPlayerIPlayer$PlayerStatus;
  private boolean jdField_b_of_type_Boolean;
  
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
    if (this.jdField_a_of_type_Bnwt != null) {
      this.jdField_a_of_type_Bnwt.a(paramCMTime);
    }
  }
  
  private void a(CMTimeRange paramCMTimeRange)
  {
    if (this.jdField_a_of_type_Bnwt != null) {
      this.jdField_a_of_type_Bnwt.a(paramCMTimeRange);
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Bnwt != null) {
      this.jdField_a_of_type_Bnwt.a(paramBoolean);
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
    this.jdField_b_of_type_Boolean = bnri.a();
    inflate(getContext(), 2131558584, this);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131371756));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131369350));
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131371757));
    this.jdField_a_of_type_ComTencentTavcutTimelineTimelineView = new TimelineView(getContext(), null, 2130837943, 2130837720, 2130837720, 2130837854, 2130837903, 2130837904, 2130837905);
    this.jdField_a_of_type_ComTencentTavcutTimelineTimelineView.setSliderFrameColor(Color.parseColor("#3B80FF"));
    this.jdField_a_of_type_ComTencentTavcutTimelineTimelineView.setIndicatorRes(2130837963);
    this.jdField_a_of_type_ComTencentTavcutTimelineTimelineView.setDurationBgRes(2130837938);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_ComTencentTavcutTimelineTimelineView);
    d();
    e();
    f();
  }
  
  private void d() {}
  
  private void e()
  {
    this.jdField_a_of_type_ComTencentTavcutTimelineTimelineView.setSliderChangeListener(new bnwp(this));
  }
  
  private void f()
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new bnwq(this));
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(new bnwr(this));
  }
  
  private void g()
  {
    if (!this.jdField_a_of_type_AndroidWidgetImageView.isSelected()) {}
    for (boolean bool = true;; bool = false)
    {
      a(bool);
      return;
    }
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
  
  public void setMvClipMenuListener(bnwt parambnwt)
  {
    this.jdField_a_of_type_Bnwt = parambnwt;
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
    ImageView localImageView;
    if (this.jdField_a_of_type_AndroidWidgetImageView != null)
    {
      localImageView = this.jdField_a_of_type_AndroidWidgetImageView;
      if ((paramPlayerStatus != IPlayer.PlayerStatus.PLAYING) && (paramPlayerStatus != IPlayer.PlayerStatus.REPLAY)) {
        break label39;
      }
    }
    label39:
    for (boolean bool = true;; bool = false)
    {
      localImageView.setSelected(bool);
      return;
    }
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
      this.jdField_a_of_type_ComTencentTavcutTimelineTimelineView.updateSpeed(paramFloat, new bnws(this, paramFloat, paramSpeedChangeCallback));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.clip.video.AEEditorMvClipMenu
 * JD-Core Version:    0.7.0.1
 */