package dov.com.qq.im.aeeditor.module.clip.video;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import blht;
import blhu;
import blhv;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.player.IPlayer.PlayerStatus;
import com.tencent.tavcut.player.MoviePlayer;
import com.tencent.tavcut.timeline.TimelineBuilder;
import com.tencent.tavcut.timeline.TimelineView;
import com.tencent.tavkit.composition.TAVSource;

public class AEEditorMvClipMenu
  extends FrameLayout
{
  private float jdField_a_of_type_Float = 1.0F;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private blhv jdField_a_of_type_Blhv;
  private CMTimeRange jdField_a_of_type_ComTencentTavCoremediaCMTimeRange;
  private IPlayer.PlayerStatus jdField_a_of_type_ComTencentTavPlayerIPlayer$PlayerStatus;
  private TimelineView jdField_a_of_type_ComTencentTavcutTimelineTimelineView;
  TAVSource jdField_a_of_type_ComTencentTavkitCompositionTAVSource;
  private boolean jdField_a_of_type_Boolean;
  private CMTimeRange jdField_b_of_type_ComTencentTavCoremediaCMTimeRange;
  private IPlayer.PlayerStatus jdField_b_of_type_ComTencentTavPlayerIPlayer$PlayerStatus;
  
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
    if (this.jdField_a_of_type_Blhv != null) {
      this.jdField_a_of_type_Blhv.a(paramCMTime);
    }
  }
  
  private void a(CMTimeRange paramCMTimeRange)
  {
    if (this.jdField_a_of_type_Blhv != null) {
      this.jdField_a_of_type_Blhv.a(paramCMTimeRange);
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Blhv != null) {
      this.jdField_a_of_type_Blhv.a(paramBoolean);
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
    inflate(getContext(), 2131558541, this);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131370910));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131370911));
    this.jdField_a_of_type_ComTencentTavcutTimelineTimelineView = new TimelineView(getContext(), null, 2130837673, 2130837648, 2130837647, 2130837660, 2130837661, 2130837689, 2130837690);
    this.jdField_a_of_type_ComTencentTavcutTimelineTimelineView.setSliderFrameColor(getResources().getColor(2131165231));
    this.jdField_a_of_type_ComTencentTavcutTimelineTimelineView.setIndicatorRes(2130837688);
    this.jdField_a_of_type_ComTencentTavcutTimelineTimelineView.setDurationBgRes(2130837691);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
    this.jdField_a_of_type_ComTencentTavcutTimelineTimelineView.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentTavcutTimelineTimelineView);
    d();
    e();
    f();
  }
  
  private void d() {}
  
  private void e()
  {
    this.jdField_a_of_type_ComTencentTavcutTimelineTimelineView.setSliderChangeListener(new blht(this));
  }
  
  private void f()
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new blhu(this));
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
    long l2 = ((CMTime)localObject).getTimeUs() / 1000L;
    if (paramLong1 != -1L)
    {
      if (paramLong2 == -1L) {
        break label167;
      }
      label70:
      localObject = new TimelineBuilder();
      if (l2 <= 60000L) {
        break label187;
      }
    }
    label167:
    label187:
    for (long l1 = 60000L;; l1 = l2)
    {
      localObject = ((TimelineBuilder)localObject).setMaxSelectDurationMs(l1).setLockMode(false).setSliderBarMode(true).setShowDuration(true);
      this.jdField_a_of_type_ComTencentTavcutTimelineTimelineView.setTimelineBuilder((TimelineBuilder)localObject);
      this.jdField_a_of_type_ComTencentTavcutTimelineTimelineView.setClipData(this.jdField_a_of_type_ComTencentTavkitCompositionTAVSource, l2, paramLong1, paramLong2);
      this.jdField_a_of_type_ComTencentTavcutTimelineTimelineView.setSpeed(1.0F);
      return;
      paramLong1 = localCMTimeRange.getStart().multi(1.0F).getTimeUs() / 1000L;
      break;
      paramLong2 = localCMTimeRange.getEnd().multi(1.0F).getTimeUs() / 1000L;
      break label70;
    }
  }
  
  public void a(MoviePlayer paramMoviePlayer)
  {
    if (this.jdField_a_of_type_ComTencentTavcutTimelineTimelineView != null) {
      this.jdField_a_of_type_ComTencentTavcutTimelineTimelineView.bindPlayer(paramMoviePlayer);
    }
  }
  
  public void a(TAVSource paramTAVSource, long paramLong1, long paramLong2, long paramLong3)
  {
    if (this.jdField_a_of_type_ComTencentTavcutTimelineTimelineView != null) {
      this.jdField_a_of_type_ComTencentTavcutTimelineTimelineView.setClipData(paramTAVSource, paramLong1, paramLong2, paramLong3);
    }
  }
  
  public void setMvClipMenuListener(blhv paramblhv)
  {
    this.jdField_a_of_type_Blhv = paramblhv;
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
      if (paramPlayerStatus != IPlayer.PlayerStatus.PLAYING) {
        break label32;
      }
    }
    label32:
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
  
  public void setTimeLineViewSpeed(float paramFloat)
  {
    if (this.jdField_a_of_type_ComTencentTavcutTimelineTimelineView != null) {
      this.jdField_a_of_type_ComTencentTavcutTimelineTimelineView.updateSpeed(paramFloat);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.clip.video.AEEditorMvClipMenu
 * JD-Core Version:    0.7.0.1
 */