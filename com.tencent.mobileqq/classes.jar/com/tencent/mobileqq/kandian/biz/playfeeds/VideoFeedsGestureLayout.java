package com.tencent.mobileqq.kandian.biz.playfeeds;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.SeekBar;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.video.feeds.api.IVideoPlayManager;
import com.tencent.mobileqq.kandian.biz.video.feeds.entity.VideoPlayParam;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.api.CustomClickListener;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.api.IVideoFeedsPlayManager;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.AbsVideoFeedsGestureLayout;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoBrightnessController;
import com.tencent.mobileqq.kandian.glue.video.VideoVolumeControl;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class VideoFeedsGestureLayout
  extends AbsVideoFeedsGestureLayout
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private AudioManager jdField_a_of_type_AndroidMediaAudioManager;
  private GestureDetector jdField_a_of_type_AndroidViewGestureDetector;
  private SeekBar jdField_a_of_type_AndroidWidgetSeekBar;
  private TopGestureLayout jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout;
  private VideoFeedsGestureUIManager jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsGestureUIManager;
  private IVideoPlayManager jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsApiIVideoPlayManager;
  private CustomClickListener jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiCustomClickListener;
  private IVideoFeedsPlayManager jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsPlayManager;
  private VideoBrightnessController jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoBrightnessController;
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long = 0L;
  private boolean jdField_b_of_type_Boolean = false;
  private int jdField_c_of_type_Int = 0;
  private long jdField_c_of_type_Long = 0L;
  private boolean jdField_c_of_type_Boolean = false;
  private int jdField_d_of_type_Int;
  private boolean jdField_d_of_type_Boolean = false;
  private int e;
  private int f = -1;
  private int g;
  private int h;
  
  public VideoFeedsGestureLayout(Context paramContext)
  {
    super(paramContext, null, 0);
  }
  
  public VideoFeedsGestureLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet, 0);
  }
  
  public VideoFeedsGestureLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void a(float paramFloat)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsApiIVideoPlayManager;
    if ((localObject != null) && (((IVideoPlayManager)localObject).a() != null))
    {
      l2 = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsApiIVideoPlayManager.a().jdField_b_of_type_Int * 1000;
      l1 = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsApiIVideoPlayManager.b();
    }
    else
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsPlayManager;
      if (localObject == null) {
        break label88;
      }
      l2 = ((IVideoFeedsPlayManager)localObject).d();
      l1 = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsPlayManager.a();
    }
    break label95;
    label88:
    long l1 = 0L;
    long l2 = l1;
    label95:
    if ((this.jdField_c_of_type_Int == 0) && (l2 != 0L)) {
      this.jdField_a_of_type_Float = ((float)l1 / (float)l2);
    }
    float f2 = this.jdField_a_of_type_Float + paramFloat;
    float f1;
    if (f2 > 1.0F)
    {
      f1 = 1.0F;
    }
    else
    {
      f1 = f2;
      if (f2 < 0.0F) {
        f1 = 0.0F;
      }
    }
    this.h = ((int)((float)l2 * f1));
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsGestureUIManager.a(3, paramFloat, this.h, l2);
  }
  
  private void a(boolean paramBoolean)
  {
    Object localObject1 = this.jdField_a_of_type_AndroidAppActivity;
    if (localObject1 == null) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout == null)
    {
      localObject1 = (ViewGroup)((Activity)localObject1).getWindow().getDecorView();
      int i = 0;
      while (i < ((ViewGroup)localObject1).getChildCount())
      {
        View localView = ((ViewGroup)localObject1).getChildAt(i);
        Object localObject2 = localObject1;
        if (localView != null)
        {
          localObject2 = localObject1;
          if ((localView instanceof ViewGroup)) {
            localObject2 = (ViewGroup)localView;
          }
        }
        if ((localObject2 instanceof TopGestureLayout))
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout = ((TopGestureLayout)localObject2);
          break;
        }
        i += 1;
        localObject1 = localObject2;
      }
    }
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout;
    if (localObject1 != null) {
      ((TopGestureLayout)localObject1).setInterceptTouchFlag(paramBoolean);
    }
  }
  
  private void b()
  {
    if (this.jdField_c_of_type_Int == 3)
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsApiIVideoPlayManager;
      if (localObject != null)
      {
        ((IVideoPlayManager)localObject).b(this.h);
        localObject = this.jdField_a_of_type_AndroidWidgetSeekBar;
        if (localObject != null) {
          ((SeekBar)localObject).setProgress(this.h / 1000);
        }
      }
      else
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsPlayManager;
        if (localObject != null) {
          ((IVideoFeedsPlayManager)localObject).a(this.h, true);
        }
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsGestureUIManager.a(0, 0.0F, 0L, 0L);
  }
  
  private void b(float paramFloat)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoBrightnessController;
    if (localObject == null) {
      return;
    }
    if (this.jdField_c_of_type_Int == 0)
    {
      if (((VideoBrightnessController)localObject).a()) {
        this.jdField_b_of_type_Boolean = true;
      }
      i = this.f;
      if (i == -1)
      {
        if (this.jdField_b_of_type_Boolean) {
          this.e = 127;
        } else {
          this.e = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoBrightnessController.a();
        }
      }
      else {
        this.e = i;
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("mBeginBrightness = ");
        ((StringBuilder)localObject).append(this.e);
        QLog.i("VideoFeedsItemFrameLayout", 2, ((StringBuilder)localObject).toString());
      }
    }
    int i = (int)(paramFloat * 255.0F);
    int j = this.e + i;
    if (j > 255)
    {
      i = 255;
    }
    else
    {
      i = j;
      if (j < 0) {
        i = 0;
      }
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoBrightnessController;
    paramFloat = i / 255.0F;
    ((VideoBrightnessController)localObject).a(paramFloat);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsGestureUIManager.a(2, paramFloat, 0L, 0L);
    this.f = i;
  }
  
  private void c(float paramFloat)
  {
    if (this.jdField_c_of_type_Int == 0) {
      this.jdField_d_of_type_Int = this.jdField_a_of_type_AndroidMediaAudioManager.getStreamVolume(3);
    }
    int i = this.g;
    int j = (int)(i * paramFloat) + this.jdField_d_of_type_Int;
    if (j <= i)
    {
      i = j;
      if (j < 0) {
        i = 0;
      }
    }
    int k = this.jdField_a_of_type_Int;
    j = 2;
    if (k != 2) {
      j = 1;
    }
    if (i == 0) {
      VideoVolumeControl.getInstance().setMute(true, "user_gesture", j);
    } else {
      VideoVolumeControl.getInstance().setMute(false, "user_gesture", j);
    }
    this.jdField_a_of_type_AndroidMediaAudioManager.setStreamVolume(3, i, 0);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsGestureUIManager.a(1, i / this.g, 0L, 0L);
  }
  
  public void a()
  {
    VideoFeedsGestureUIManager localVideoFeedsGestureUIManager = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsGestureUIManager;
    if (localVideoFeedsGestureUIManager != null) {
      localVideoFeedsGestureUIManager.a();
    }
    this.jdField_c_of_type_Int = 0;
  }
  
  public void a(int paramInt, float paramFloat)
  {
    if (!this.jdField_c_of_type_Boolean) {
      return;
    }
    CustomClickListener localCustomClickListener;
    if (paramInt == 0)
    {
      this.jdField_d_of_type_Boolean = false;
      localCustomClickListener = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiCustomClickListener;
      if (localCustomClickListener != null) {
        localCustomClickListener.a(this, 1);
      }
    }
    else if (!this.jdField_d_of_type_Boolean)
    {
      this.jdField_d_of_type_Boolean = true;
      localCustomClickListener = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiCustomClickListener;
      if (localCustomClickListener != null) {
        localCustomClickListener.a(this, 2);
      }
    }
    if (this.jdField_a_of_type_AndroidMediaAudioManager == null)
    {
      this.jdField_a_of_type_AndroidMediaAudioManager = ((AudioManager)BaseApplicationImpl.getApplication().getBaseContext().getSystemService("audio"));
      this.g = this.jdField_a_of_type_AndroidMediaAudioManager.getStreamMaxVolume(3);
    }
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt == 3) {
            a(paramFloat);
          }
        }
        else {
          b(paramFloat);
        }
      }
      else {
        c(paramFloat);
      }
    }
    else {
      b();
    }
    this.jdField_c_of_type_Int = paramInt;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    this.jdField_c_of_type_Long = System.currentTimeMillis();
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (this.jdField_a_of_type_AndroidViewGestureDetector == null) {
      this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(getContext(), new VideoFeedsGestureLayout.MyGestureListener(this));
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    boolean bool = false;
    if ((i == 1) && (this.jdField_b_of_type_Int != 0))
    {
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("channel_id", this.jdField_a_of_type_Long);
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
      i = this.jdField_b_of_type_Int;
      if (i != 1)
      {
        if (i != 2)
        {
          if (i == 3) {
            ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).videoDataReportWithFansInfoInR5(null, null, "0X8008A41", "0X8008A41", 0, 0, "", "", "", VideoReporter.a(localJSONObject), false);
          }
        }
        else {
          ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).videoDataReportWithFansInfoInR5(null, null, "0X8008A42", "0X8008A42", 0, 0, "", "", "", VideoReporter.a(localJSONObject), false);
        }
      }
      else {
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).videoDataReportWithFansInfoInR5(null, null, "0X8008A43", "0X8008A43", 0, 0, "", "", "", VideoReporter.a(localJSONObject), false);
      }
      this.jdField_b_of_type_Int = 0;
      a(0, 0.0F);
    }
    this.jdField_a_of_type_AndroidViewGestureDetector.onTouchEvent(paramMotionEvent);
    if ((this.jdField_c_of_type_Boolean) || (this.jdField_a_of_type_Int != 1)) {
      bool = true;
    }
    return bool;
  }
  
  public void setChannelID(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void setContext(Activity paramActivity)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
  }
  
  public void setIsInFullScreen(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
    if ((this.jdField_c_of_type_Boolean) && (!this.jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsGestureUIManager = new VideoFeedsGestureUIManager();
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsGestureUIManager.a(this.jdField_a_of_type_AndroidAppActivity, this);
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("wgs error =");
          localStringBuilder.append(localException.getMessage());
          QLog.d("VideoFeedsItemFrameLayout", 2, localStringBuilder.toString());
        }
      }
      this.jdField_a_of_type_Boolean = true;
    }
    if (this.jdField_c_of_type_Boolean)
    {
      a(false);
      return;
    }
    a(true);
    VideoBrightnessController localVideoBrightnessController = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoBrightnessController;
    if (localVideoBrightnessController != null)
    {
      localVideoBrightnessController.a();
      this.f = -1;
    }
  }
  
  @Deprecated
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    super.setOnClickListener(paramOnClickListener);
  }
  
  public void setOnCustomClickListener(CustomClickListener paramCustomClickListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiCustomClickListener = paramCustomClickListener;
  }
  
  public void setSeekBar(SeekBar paramSeekBar)
  {
    this.jdField_a_of_type_AndroidWidgetSeekBar = paramSeekBar;
  }
  
  public void setVideoBrightnessController(VideoBrightnessController paramVideoBrightnessController)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoBrightnessController = paramVideoBrightnessController;
  }
  
  public void setVideoPlayManager(IVideoPlayManager paramIVideoPlayManager)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsApiIVideoPlayManager = paramIVideoPlayManager;
    this.jdField_a_of_type_Int = 1;
  }
  
  public void setVideoPlayManager(IVideoFeedsPlayManager paramIVideoFeedsPlayManager)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsPlayManager = paramIVideoFeedsPlayManager;
    this.jdField_a_of_type_Int = 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsGestureLayout
 * JD-Core Version:    0.7.0.1
 */