package dov.com.tencent.biz.qqstory.takevideo;

import android.os.Message;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.richmedia.view.RotationSeekBar;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LiuHaiUtils;
import dov.com.qq.im.capture.QIMManager;
import dov.com.qq.im.capture.music.QimMusicPlayer;
import dov.com.tencent.mobileqq.activity.richmedia.QzEditVideoPartManager;

public class EditVideoProgressBar
  extends EditVideoPart
{
  private double jdField_a_of_type_Double = 1.0D;
  private int jdField_a_of_type_Int = -1;
  private long jdField_a_of_type_Long = -1L;
  private ImageButton jdField_a_of_type_AndroidWidgetImageButton;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private RotationSeekBar jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewRotationSeekBar;
  private QimMusicPlayer jdField_a_of_type_DovComQqImCaptureMusicQimMusicPlayer;
  private HWEditLocalVideoPlayer jdField_a_of_type_DovComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer;
  private QzEditVideoPartManager jdField_a_of_type_DovComTencentMobileqqActivityRichmediaQzEditVideoPartManager;
  private int jdField_b_of_type_Int = 0;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  
  public EditVideoProgressBar(@NonNull QzEditVideoPartManager paramQzEditVideoPartManager)
  {
    super(paramQzEditVideoPartManager);
    this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaQzEditVideoPartManager = paramQzEditVideoPartManager;
  }
  
  private static String a(long paramLong)
  {
    paramLong /= 1000L;
    return String.format("%02d:%02d", new Object[] { Long.valueOf(paramLong / 60L), Long.valueOf(paramLong % 60L) });
  }
  
  private void c()
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)a(2131366183);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)LayoutInflater.from(a()).inflate(2131562414, localRelativeLayout, false));
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, AIOUtils.a(40.0F, a()));
    LinearLayout localLinearLayout = this.jdField_a_of_type_AndroidWidgetLinearLayout;
    if (this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaQzEditVideoPartManager.k)
    {
      i = 0;
      localLinearLayout.setVisibility(i);
      localLayoutParams.addRule(12);
      if (LiuHaiUtils.e <= 0) {
        break label120;
      }
    }
    label120:
    for (int i = LiuHaiUtils.e + AIOUtils.a(40.0F, a());; i = AIOUtils.a(100.0F, a()))
    {
      localLayoutParams.bottomMargin = i;
      localRelativeLayout.addView(this.jdField_a_of_type_AndroidWidgetLinearLayout, localLayoutParams);
      return;
      i = 8;
      break;
    }
  }
  
  private void d()
  {
    if ((this.jdField_a_of_type_Long < 0L) && (this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaQzEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer != null) && (this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaQzEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer.a() != null))
    {
      this.jdField_a_of_type_Long = this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaQzEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer.a().mDuration;
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer = this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaQzEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer;
      this.jdField_a_of_type_DovComQqImCaptureMusicQimMusicPlayer = ((QimMusicPlayer)QIMManager.a().c(8));
      if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer.a() != 1) || (this.jdField_b_of_type_Int == 1)) {
        break label109;
      }
      this.jdField_a_of_type_AndroidWidgetImageButton.setImageResource(2130848053);
      this.jdField_b_of_type_Int = 1;
    }
    label109:
    while ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer.a() != 2) || (this.jdField_b_of_type_Int == 2)) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageButton.setImageResource(2130848052);
    this.jdField_b_of_type_Int = 2;
  }
  
  private void i()
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer != null) {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer.aK_();
    }
    if (this.jdField_a_of_type_DovComQqImCaptureMusicQimMusicPlayer != null) {
      this.jdField_a_of_type_DovComQqImCaptureMusicQimMusicPlayer.b();
    }
  }
  
  private void k()
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer != null) {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer.m();
    }
    if (this.jdField_a_of_type_DovComQqImCaptureMusicQimMusicPlayer != null) {
      this.jdField_a_of_type_DovComQqImCaptureMusicQimMusicPlayer.a();
    }
  }
  
  public void a()
  {
    super.a();
    c();
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewRotationSeekBar = ((RotationSeekBar)a(2131366091));
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)a(2131366092));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131366093));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)a(2131366090));
    this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(new EditVideoProgressBar.1(this));
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewRotationSeekBar.setEnabled(true);
  }
  
  public void a(int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      return;
    }
    if (this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaQzEditVideoPartManager.k)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
  }
  
  protected boolean a(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return super.a(paramMessage);
      long l;
      int i;
      if (this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaQzEditVideoPartManager.k)
      {
        d();
        if (this.jdField_a_of_type_Long > 0L)
        {
          l = ((Long[])(Long[])paramMessage.obj)[0].longValue();
          if (this.jdField_a_of_type_Double <= 0.0D) {
            break label257;
          }
          i = (int)(l * 100L / this.jdField_a_of_type_Long);
          if ((i >= this.jdField_a_of_type_Int) || (this.jdField_a_of_type_Int >= 95) || (i <= 5)) {
            break label249;
          }
          i = this.jdField_a_of_type_Int;
          QLog.d("EditVideo - progressBar", 2, "progress = " + i + "；lastProgress = " + this.jdField_a_of_type_Int + "; need to reset");
          this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewRotationSeekBar.setProgress(i);
          this.jdField_a_of_type_AndroidWidgetTextView.setText(a((l * this.jdField_a_of_type_Double)));
          this.jdField_b_of_type_AndroidWidgetTextView.setText(a((this.jdField_a_of_type_Long * this.jdField_a_of_type_Double)));
        }
        label214:
        if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer.a() != 1) || (this.jdField_b_of_type_Int == 1)) {
          break label315;
        }
        this.jdField_a_of_type_AndroidWidgetImageButton.setImageResource(2130848053);
      }
      for (this.jdField_b_of_type_Int = 1;; this.jdField_b_of_type_Int = 2)
      {
        label249:
        do
        {
          return true;
          this.jdField_a_of_type_Int = i;
          break;
          i = (int)((this.jdField_a_of_type_Long - l) * 100L / this.jdField_a_of_type_Long);
          this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewRotationSeekBar.setProgress(i);
          this.jdField_a_of_type_AndroidWidgetTextView.setText(a(this.jdField_a_of_type_Long - l));
          this.jdField_b_of_type_AndroidWidgetTextView.setText(a(this.jdField_a_of_type_Long));
          break label214;
        } while ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer.a() != 2) || (this.jdField_b_of_type_Int == 2));
        label257:
        label315:
        this.jdField_a_of_type_AndroidWidgetImageButton.setImageResource(2130848052);
      }
      if (paramMessage.arg1 == 12) {
        switch (paramMessage.arg2)
        {
        default: 
          break;
        case 0: 
          this.jdField_a_of_type_Double = 0.25D;
          break;
        case 4: 
          this.jdField_a_of_type_Double = 4.0D;
          break;
        case 3: 
          this.jdField_a_of_type_Double = 2.0D;
          break;
        case 2: 
          this.jdField_a_of_type_Double = 1.0D;
          break;
        case 1: 
          this.jdField_a_of_type_Double = 0.5D;
          break;
        case 5: 
          this.jdField_a_of_type_Double = -1.0D;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditVideoProgressBar
 * JD-Core Version:    0.7.0.1
 */