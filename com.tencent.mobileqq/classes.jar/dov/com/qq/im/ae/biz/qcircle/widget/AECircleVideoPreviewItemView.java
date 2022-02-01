package dov.com.qq.im.ae.biz.qcircle.widget;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.qqvideoplatform.api.QQVideoViewFactory;
import com.tencent.mobileqq.videoplatform.api.VideoPlayParam;
import com.tencent.mobileqq.videoplatform.view.BaseVideoView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.text.SimpleDateFormat;

public class AECircleVideoPreviewItemView
  extends RelativeLayout
{
  private int jdField_a_of_type_Int = -1;
  private Context jdField_a_of_type_AndroidContentContext;
  private ColorDrawable jdField_a_of_type_AndroidGraphicsDrawableColorDrawable = new ColorDrawable(570425344);
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private SeekBar.OnSeekBarChangeListener jdField_a_of_type_AndroidWidgetSeekBar$OnSeekBarChangeListener;
  private SeekBar jdField_a_of_type_AndroidWidgetSeekBar;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private LocalMediaInfo jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo;
  private BaseVideoView jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView;
  private SimpleDateFormat jdField_a_of_type_JavaTextSimpleDateFormat = null;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  
  public AECircleVideoPreviewItemView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    View.inflate(paramContext, 2131558495, this);
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131381466));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131381467));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131381468));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131381470));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131381472));
    this.jdField_a_of_type_AndroidWidgetSeekBar = ((SeekBar)findViewById(2131381471));
    this.jdField_a_of_type_AndroidWidgetSeekBar.setOnSeekBarChangeListener(a());
    this.jdField_a_of_type_AndroidWidgetSeekBar.setOnTouchListener(a());
    this.jdField_a_of_type_AndroidWidgetSeekBar.setPadding(ImmersiveUtils.dpToPx(6.0F), 0, ImmersiveUtils.dpToPx(6.0F), 0);
    this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView = ((BaseVideoView)QQVideoViewFactory.b(this.jdField_a_of_type_AndroidContentContext, 109L, null, null));
    this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.setOnClickListener(a());
    this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView, -1, -1);
  }
  
  private View.OnClickListener a()
  {
    if (this.jdField_a_of_type_AndroidViewView$OnClickListener == null) {
      this.jdField_a_of_type_AndroidViewView$OnClickListener = new AECircleVideoPreviewItemView.2(this);
    }
    return this.jdField_a_of_type_AndroidViewView$OnClickListener;
  }
  
  private View.OnTouchListener a()
  {
    if (this.jdField_a_of_type_AndroidViewView$OnTouchListener == null) {
      this.jdField_a_of_type_AndroidViewView$OnTouchListener = new AECircleVideoPreviewItemView.4(this);
    }
    return this.jdField_a_of_type_AndroidViewView$OnTouchListener;
  }
  
  private SeekBar.OnSeekBarChangeListener a()
  {
    if (this.jdField_a_of_type_AndroidWidgetSeekBar$OnSeekBarChangeListener == null) {
      this.jdField_a_of_type_AndroidWidgetSeekBar$OnSeekBarChangeListener = new AECircleVideoPreviewItemView.3(this);
    }
    return this.jdField_a_of_type_AndroidWidgetSeekBar$OnSeekBarChangeListener;
  }
  
  private URLDrawable.URLDrawableOptions a(LocalMediaInfo paramLocalMediaInfo)
  {
    int i = ImmersiveUtils.getScreenWidth();
    int j = (int)(i / paramLocalMediaInfo.mediaWidth * paramLocalMediaInfo.mediaHeight);
    paramLocalMediaInfo = URLDrawable.URLDrawableOptions.obtain();
    paramLocalMediaInfo.mRequestWidth = i;
    paramLocalMediaInfo.mRequestHeight = j;
    paramLocalMediaInfo.mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
    paramLocalMediaInfo.mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
    return paramLocalMediaInfo;
  }
  
  private VideoPlayParam a(LocalMediaInfo paramLocalMediaInfo)
  {
    VideoPlayParam localVideoPlayParam = new VideoPlayParam();
    localVideoPlayParam.mVideoFormat = 104;
    localVideoPlayParam.mIsLocal = true;
    localVideoPlayParam.mIsLoop = true;
    localVideoPlayParam.mSceneId = 109;
    localVideoPlayParam.mVideoPath = paramLocalMediaInfo.path;
    localVideoPlayParam.mNeedPlayProgress = true;
    localVideoPlayParam.mCallback = new AECircleVideoPreviewItemView.1(this, paramLocalMediaInfo);
    return localVideoPlayParam;
  }
  
  private String a(long paramLong)
  {
    if (this.jdField_a_of_type_JavaTextSimpleDateFormat == null) {
      this.jdField_a_of_type_JavaTextSimpleDateFormat = new SimpleDateFormat("mm:ss");
    }
    return this.jdField_a_of_type_JavaTextSimpleDateFormat.format(Long.valueOf(paramLong));
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.mIsPlayVideo) {
        this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.resume();
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.play();
  }
  
  public void a()
  {
    b();
    if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    if (this.jdField_a_of_type_AndroidWidgetSeekBar != null) {
      this.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(0);
    }
    if (this.jdField_b_of_type_AndroidWidgetImageView != null) {
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    if (this.jdField_b_of_type_AndroidWidgetTextView != null) {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(a(0L));
    }
  }
  
  public void a(LocalMediaInfo paramLocalMediaInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo = paramLocalMediaInfo;
    this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.setVideoParam(a(paramLocalMediaInfo));
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(URLDrawable.getDrawable(QAlbumUtil.generateAlbumVideoThumbURL(paramLocalMediaInfo.path, null), a(paramLocalMediaInfo)));
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(a(paramLocalMediaInfo.mDuration));
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(0);
    this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.play();
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    a();
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView != null)
    {
      QLog.d("AECircleVideoPreviewItemView", 4, "onDetachedFromWindow: video release");
      this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.pause();
      this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.releasePlayer(false);
    }
  }
  
  public void onVisibilityChanged(@NonNull View paramView, int paramInt)
  {
    super.onVisibilityChanged(paramView, paramInt);
    if (this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView == null) {
      return;
    }
    if (paramInt == 0)
    {
      b();
      return;
    }
    QLog.d("AECircleVideoPreviewItemView", 4, "onVisibilityChanged: video release");
    this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.pause();
    this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.releasePlayer(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.biz.qcircle.widget.AECircleVideoPreviewItemView
 * JD-Core Version:    0.7.0.1
 */