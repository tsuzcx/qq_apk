package com.tencent.mobileqq.kandian.glue.viola.videonew;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.SeekBar;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsGestureLayout;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsHelper;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.api.CustomClickListener;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoBrightnessController;
import com.tencent.mobileqq.kandian.biz.viola.video.VideoInfo;
import com.tencent.mobileqq.kandian.biz.viola.view.ViolaLazyFragment;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.viola.core.ViolaInstance;
import java.util.HashMap;

public class ViolaVideoView
  extends FrameLayout
  implements View.OnClickListener, CustomClickListener, IVideoView, VideoPlayManager.VideoStatusListener
{
  private static HashMap<Integer, Drawable> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long;
  private ColorDrawable jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
  private Handler jdField_a_of_type_AndroidOsHandler = new ViolaVideoView.UIHandler(this, null);
  private View jdField_a_of_type_AndroidViewView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private SeekBar jdField_a_of_type_AndroidWidgetSeekBar;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private VideoFeedsGestureLayout jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsGestureLayout;
  private VideoBrightnessController jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoBrightnessController;
  private IVideoView.VideoViewEventListener jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewIVideoView$VideoViewEventListener;
  private VideoPlayManager jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewVideoPlayManager;
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int;
  private View jdField_b_of_type_AndroidViewView;
  private ViewGroup jdField_b_of_type_AndroidViewViewGroup;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private HashMap<Integer, Drawable> jdField_b_of_type_JavaUtilHashMap = new HashMap();
  private boolean jdField_b_of_type_Boolean = true;
  private ViewGroup jdField_c_of_type_AndroidViewViewGroup;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private boolean jdField_c_of_type_Boolean = false;
  private ViewGroup jdField_d_of_type_AndroidViewViewGroup;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private boolean jdField_d_of_type_Boolean = false;
  private ViewGroup jdField_e_of_type_AndroidViewViewGroup;
  private TextView jdField_e_of_type_AndroidWidgetTextView;
  private ViewGroup jdField_f_of_type_AndroidViewViewGroup;
  private TextView jdField_f_of_type_AndroidWidgetTextView;
  
  public ViolaVideoView(@NonNull Activity paramActivity)
  {
    super(paramActivity);
    setTag("ViolaVideoView");
    this.jdField_a_of_type_AndroidViewViewGroup = new FrameLayout(paramActivity);
    addView(this.jdField_a_of_type_AndroidViewViewGroup, -1, -1);
    this.jdField_a_of_type_ComTencentImageURLImageView = new URLImageView(paramActivity);
    this.jdField_a_of_type_ComTencentImageURLImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    addView(this.jdField_a_of_type_ComTencentImageURLImageView, -1, -1);
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(paramActivity).inflate(2131560372, this, false);
    addView(this.jdField_a_of_type_AndroidViewView);
    a(this.jdField_a_of_type_AndroidViewView, paramActivity);
    this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable = new ColorDrawable(paramActivity.getResources().getColor(2131165327));
    this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable);
    paramActivity.getWindow().setFlags(16777216, 16777216);
  }
  
  private Drawable a(int paramInt)
  {
    if (this.jdField_b_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(paramInt))) {
      return (Drawable)this.jdField_b_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
    }
    try
    {
      Drawable localDrawable = getContext().getResources().getDrawable(paramInt);
      this.jdField_b_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt), localDrawable);
      return localDrawable;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("innerGetDrawableFromCache() OutOfMemoryError e=");
        localStringBuilder.append(localOutOfMemoryError.getMessage());
        QLog.d("ViolaVideoView", 2, localStringBuilder.toString());
      }
    }
    return null;
  }
  
  private static Drawable a(Context paramContext, int paramInt)
  {
    Object localObject = jdField_a_of_type_JavaUtilHashMap;
    if (localObject == null) {
      return null;
    }
    if (((HashMap)localObject).containsKey(Integer.valueOf(paramInt))) {
      return (Drawable)jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
    }
    try
    {
      paramContext = paramContext.getResources().getDrawable(paramInt);
      jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt), paramContext);
      return paramContext;
    }
    catch (OutOfMemoryError paramContext)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("innerGetDrawableFromCache() OutOfMemoryError e=");
        ((StringBuilder)localObject).append(paramContext.getMessage());
        QLog.d("ViolaVideoView", 2, ((StringBuilder)localObject).toString());
      }
    }
    return null;
  }
  
  private void a(int paramInt, String paramString)
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewVideoPlayManager.b()) {
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("innerChangePlayButton() what = ");
      localStringBuilder.append(paramInt);
      QLog.d("ViolaVideoView", 2, localStringBuilder.toString());
    }
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler.obtainMessage(paramInt, paramString).sendToTarget();
  }
  
  private void a(View paramView, Activity paramActivity)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsGestureLayout = ((VideoFeedsGestureLayout)paramView.findViewById(2131367624));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131372826));
    this.jdField_c_of_type_AndroidViewViewGroup = ((ViewGroup)paramView.findViewById(2131380559));
    this.jdField_a_of_type_AndroidWidgetSeekBar = ((SeekBar)paramView.findViewById(2131377131));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131365348));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379072));
    this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)paramView.findViewById(2131372827));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366298));
    this.jdField_d_of_type_AndroidViewViewGroup = ((ViewGroup)paramView.findViewById(2131363736));
    this.jdField_e_of_type_AndroidViewViewGroup = ((ViewGroup)paramView.findViewById(2131367407));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367408));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131372166));
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366815));
    this.jdField_f_of_type_AndroidViewViewGroup = ((ViewGroup)paramView.findViewById(2131367406));
    this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131364715);
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131367409));
    this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(null);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_e_of_type_AndroidWidgetTextView.setOnClickListener(this);
    h();
    this.jdField_e_of_type_AndroidViewViewGroup.setOnClickListener(this);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_d_of_type_AndroidWidgetTextView.getPaint().setFakeBoldText(true);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoBrightnessController = new VideoBrightnessController(paramActivity);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsGestureLayout.setOnCustomClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsGestureLayout.setContext(paramActivity);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsGestureLayout.setVideoBrightnessController(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoBrightnessController);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsGestureLayout.setVideoPlayManager(this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewVideoPlayManager);
  }
  
  private void a(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      this.jdField_a_of_type_AndroidWidgetSeekBar.setClickable(true);
      this.jdField_a_of_type_AndroidWidgetSeekBar.setEnabled(true);
      this.jdField_a_of_type_AndroidWidgetSeekBar.setSelected(true);
      this.jdField_a_of_type_AndroidWidgetSeekBar.setFocusable(true);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetSeekBar.setClickable(false);
    this.jdField_a_of_type_AndroidWidgetSeekBar.setEnabled(false);
    this.jdField_a_of_type_AndroidWidgetSeekBar.setSelected(false);
    this.jdField_a_of_type_AndroidWidgetSeekBar.setFocusable(false);
  }
  
  private boolean a(View paramView)
  {
    return (this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewVideoPlayManager.a() != null) && (paramView.getTag() == this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewVideoPlayManager.a());
  }
  
  private boolean a(VideoPlayManager.VideoPlayParam paramVideoPlayParam)
  {
    boolean bool1 = NetworkUtil.isMobileNetWork(getContext());
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    bool1 = bool2;
    if (paramVideoPlayParam != null)
    {
      bool1 = bool2;
      if (paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizViolaVideoVideoInfo != null) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private void b(int paramInt)
  {
    ((ViewGroup.MarginLayoutParams)this.jdField_d_of_type_AndroidViewViewGroup.getLayoutParams()).bottomMargin = paramInt;
    this.jdField_d_of_type_AndroidViewViewGroup.requestLayout();
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewVideoPlayManager.b()) {
      return;
    }
    VideoFeedsHelper.a(this.jdField_a_of_type_ComTencentImageURLImageView, paramInt1, paramInt2);
  }
  
  private void b(int paramInt, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewVideoPlayManager.a() == null) {
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("innerChangePlayButtonFromOpen() what = ");
      localStringBuilder.append(paramInt);
      QLog.d("ViolaVideoView", 2, localStringBuilder.toString());
    }
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler.obtainMessage(paramInt, paramString).sendToTarget();
  }
  
  private void b(boolean paramBoolean)
  {
    IVideoView.VideoViewEventListener localVideoViewEventListener;
    if (paramBoolean)
    {
      if (this.jdField_c_of_type_AndroidViewViewGroup.getVisibility() == 8)
      {
        localVideoViewEventListener = this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewIVideoView$VideoViewEventListener;
        if (localVideoViewEventListener != null) {
          localVideoViewEventListener.a(paramBoolean);
        }
        VideoFeedsHelper.a(this.jdField_c_of_type_AndroidViewViewGroup, 0);
      }
      if (this.jdField_b_of_type_AndroidViewViewGroup.getVisibility() == 8) {
        VideoFeedsHelper.a(this.jdField_b_of_type_AndroidViewViewGroup, 0);
      }
    }
    else
    {
      if (this.jdField_c_of_type_AndroidViewViewGroup.getVisibility() == 0)
      {
        localVideoViewEventListener = this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewIVideoView$VideoViewEventListener;
        if (localVideoViewEventListener != null) {
          localVideoViewEventListener.a(paramBoolean);
        }
        VideoFeedsHelper.a(this.jdField_c_of_type_AndroidViewViewGroup, 8);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewVideoPlayManager.a()) && (this.jdField_b_of_type_AndroidViewViewGroup.getVisibility() == 0)) {
        VideoFeedsHelper.a(this.jdField_b_of_type_AndroidViewViewGroup, 8);
      }
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    }
  }
  
  private boolean b(VideoPlayManager.VideoPlayParam paramVideoPlayParam)
  {
    return (paramVideoPlayParam != null) && (paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizViolaVideoVideoInfo != null) && (!paramVideoPlayParam.jdField_b_of_type_Boolean) && (NetworkUtil.isMobileNetWork(getContext())) && (paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizViolaVideoVideoInfo.jdField_a_of_type_Long >= 0L);
  }
  
  private void c(VideoInfo paramVideoInfo)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(HardCodeUtil.a(2131716202));
    ((StringBuilder)localObject).append(VideoFeedsHelper.b(paramVideoInfo.jdField_a_of_type_Long));
    localObject = ((StringBuilder)localObject).toString();
    if (paramVideoInfo.jdField_a_of_type_Long <= 0L) {
      localObject = HardCodeUtil.a(2131716203);
    }
    paramVideoInfo = this.jdField_f_of_type_AndroidWidgetTextView;
    paramVideoInfo.setText((CharSequence)localObject);
    VideoFeedsHelper.a(paramVideoInfo, 0);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new ViolaVideoView.10(this, paramVideoInfo), 1000L);
  }
  
  private void f()
  {
    if (!this.jdField_c_of_type_Boolean) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewVideoPlayManager.a() == null) {
      return;
    }
    this.jdField_c_of_type_Boolean = false;
    if (getParent() != null)
    {
      VVideoView localVVideoView = (VVideoView)getParent();
      a();
      localVVideoView.b(1);
      b();
      a(1);
    }
  }
  
  private void g()
  {
    if (this.jdField_c_of_type_Boolean) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewVideoPlayManager.a() == null) {
      return;
    }
    this.jdField_c_of_type_Boolean = true;
    if (getParent() != null)
    {
      VVideoView localVVideoView = (VVideoView)getParent();
      a();
      localVVideoView.a(0);
      b();
      a(0, false);
    }
  }
  
  private void h()
  {
    this.jdField_a_of_type_AndroidWidgetSeekBar.setOnSeekBarChangeListener(new ViolaVideoView.9(this));
  }
  
  public ViewGroup a()
  {
    return this.jdField_a_of_type_AndroidViewViewGroup;
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewVideoPlayManager.a() != null) && (this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewVideoPlayManager.a().jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIVideoView != null)) {
      this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewVideoPlayManager.a().jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIVideoView.a();
    }
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ViolaVideoView", 2, "deal exitFullScreen: ");
    }
    this.jdField_c_of_type_Boolean = false;
    setControlType(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsGestureLayout.setIsInFullScreen(false);
    if (paramInt == 1) {
      ((Activity)getContext()).setRequestedOrientation(1);
    } else {
      ((Activity)getContext()).setRequestedOrientation(9);
    }
    ((Activity)getContext()).setRequestedOrientation(1);
    if (getParent() != null)
    {
      localObject = (VVideoView)getParent();
      ((Activity)getContext()).getWindow().getDecorView().setSystemUiVisibility(this.jdField_b_of_type_Int);
      if ((((VVideoView)localObject).a() != null) && (((VVideoView)localObject).a().getInstance() != null) && (((VVideoView)localObject).a().getInstance().getFragment() != null))
      {
        localObject = (ViolaLazyFragment)((VVideoView)localObject).a().getInstance().getFragment();
        if (localObject != null)
        {
          ((ViolaLazyFragment)localObject).showTitleBar();
          ((ViolaLazyFragment)localObject).recoverStatusBar();
        }
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewVideoPlayManager.a();
      ViewGroup.LayoutParams localLayoutParams = getLayoutParams();
      localLayoutParams.height = ((VideoPlayManager.VideoPlayParam)localObject).c;
      localLayoutParams.width = ((VideoPlayManager.VideoPlayParam)localObject).jdField_b_of_type_Int;
    }
    this.jdField_f_of_type_AndroidViewViewGroup.setPadding(0, 0, 0, 0);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewIVideoView$VideoViewEventListener;
    if (localObject != null) {
      ((IVideoView.VideoViewEventListener)localObject).b(false);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    Object localObject = getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).width = paramInt1;
    ((ViewGroup.LayoutParams)localObject).height = paramInt2;
    setLayoutParams((ViewGroup.LayoutParams)localObject);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onSizeChanged: width=");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(",height=");
      ((StringBuilder)localObject).append(paramInt2);
      QLog.d("ViolaVideoView", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ViolaVideoView", 2, "deal enterFullScreen: ");
    }
    this.jdField_c_of_type_Boolean = true;
    setControlType(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsGestureLayout.setIsInFullScreen(true);
    if (!paramBoolean) {
      if (paramInt == 0) {
        ((Activity)getContext()).setRequestedOrientation(0);
      } else {
        ((Activity)getContext()).setRequestedOrientation(8);
      }
    }
    if (getParent() != null)
    {
      localObject = (VVideoView)getParent();
      Activity localActivity = (Activity)getContext();
      this.jdField_b_of_type_Int = localActivity.getWindow().getDecorView().getSystemUiVisibility();
      VideoFeedsHelper.b(localActivity);
      if ((((VVideoView)localObject).a() != null) && (((VVideoView)localObject).a().getInstance() != null) && (((VVideoView)localObject).a().getInstance().getFragment() != null))
      {
        localObject = (ViolaLazyFragment)((VVideoView)localObject).a().getInstance().getFragment();
        if (localObject != null)
        {
          ((ViolaLazyFragment)localObject).hideTitleBar();
          ((ViolaLazyFragment)localObject).hideStatusBar();
        }
      }
      localObject = getLayoutParams();
      ((ViewGroup.LayoutParams)localObject).height = -1;
      ((ViewGroup.LayoutParams)localObject).width = -1;
    }
    if (paramBoolean) {
      this.jdField_f_of_type_AndroidViewViewGroup.setPadding(0, 40, 0, 0);
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewIVideoView$VideoViewEventListener;
    if (localObject != null) {
      ((IVideoView.VideoViewEventListener)localObject).b(true);
    }
  }
  
  public void a(View paramView)
  {
    if (!a(paramView)) {
      return;
    }
    boolean bool;
    if (this.jdField_c_of_type_AndroidViewViewGroup.getVisibility() == 8) {
      bool = true;
    } else {
      bool = false;
    }
    b(bool);
  }
  
  public void a(View paramView, int paramInt)
  {
    if (!a(paramView)) {
      return;
    }
    if (paramInt != 1)
    {
      if (paramInt != 2) {
        return;
      }
      b(false);
      return;
    }
    b(true);
  }
  
  public void a(View paramView, int paramInt1, int paramInt2) {}
  
  public void a(VideoInfo paramVideoInfo)
  {
    if (!TextUtils.isEmpty(paramVideoInfo.b))
    {
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      Object localObject = getLayoutParams();
      int i = ((ViewGroup.LayoutParams)localObject).width;
      int j = 0;
      if (i > 0) {
        i = ((ViewGroup.LayoutParams)localObject).width;
      } else {
        i = 0;
      }
      localURLDrawableOptions.mRequestWidth = i;
      i = j;
      if (((ViewGroup.LayoutParams)localObject).height > 0) {
        i = ((ViewGroup.LayoutParams)localObject).height;
      }
      localURLDrawableOptions.mRequestHeight = i;
      localURLDrawableOptions.mPlayGifImage = true;
      localObject = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject);
      localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject);
      paramVideoInfo = URLDrawable.getDrawable(paramVideoInfo.b, localURLDrawableOptions);
      this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(paramVideoInfo);
      return;
    }
    this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(null);
  }
  
  public void a(VideoPlayManager.VideoPlayParam paramVideoPlayParam)
  {
    a(paramVideoPlayParam.jdField_b_of_type_Int, paramVideoPlayParam.c);
    a(paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizViolaVideoVideoInfo);
    if (b(paramVideoPlayParam)) {
      b(paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizViolaVideoVideoInfo);
    }
    b(false);
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewVideoPlayManager.f(paramVideoPlayParam.jdField_d_of_type_Int);
    if (paramVideoPlayParam.jdField_e_of_type_Int != -1) {
      b(paramVideoPlayParam.jdField_e_of_type_Int);
    }
    setFullScreenDisable(paramVideoPlayParam.jdField_d_of_type_Boolean);
    a(paramVideoPlayParam.jdField_e_of_type_Boolean);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(0);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(0, 3000L);
    this.jdField_a_of_type_AndroidWidgetImageView.setTag(paramVideoPlayParam);
    this.jdField_e_of_type_AndroidViewViewGroup.setTag(paramVideoPlayParam);
    this.jdField_b_of_type_AndroidViewView.setTag(paramVideoPlayParam);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsGestureLayout.setTag(paramVideoPlayParam);
    this.jdField_e_of_type_AndroidWidgetTextView.setTag(paramVideoPlayParam);
    setFullScreenTitle(paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizViolaVideoVideoInfo.c);
  }
  
  public void a(VideoPlayManager.VideoPlayParam paramVideoPlayParam, int paramInt)
  {
    a(2, null);
  }
  
  public void a(VideoPlayManager.VideoPlayParam paramVideoPlayParam, int paramInt1, int paramInt2, String paramString)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new ViolaVideoView.8(this, paramString));
  }
  
  public void a(VideoPlayManager.VideoPlayParam paramVideoPlayParam, long paramLong)
  {
    long l = this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewVideoPlayManager.c();
    if (!this.jdField_a_of_type_Boolean)
    {
      if (l == 0L)
      {
        this.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(0);
      }
      else if (paramLong != 0L)
      {
        int i = (int)(100L * paramLong / l);
        float f1 = Math.round(100000.0F / (float)l);
        float f2 = i + f1;
        f1 = f2;
        if (f2 > 100.0F) {
          f1 = 100.0F;
        }
        this.jdField_a_of_type_AndroidWidgetSeekBar.setProgress((int)f1);
        VideoFeedsHelper.a(this.jdField_a_of_type_AndroidWidgetTextView, paramLong);
      }
      if (l > 0L) {
        VideoFeedsHelper.a(this.jdField_b_of_type_AndroidWidgetTextView, l);
      }
    }
  }
  
  public void a(VideoPlayManager.VideoPlayParam paramVideoPlayParam, boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    if (paramBoolean)
    {
      this.jdField_b_of_type_Boolean = true;
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 1200L);
      return;
    }
    b(2, null);
  }
  
  public void a(VideoPlayManager paramVideoPlayManager)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewVideoPlayManager = paramVideoPlayManager;
  }
  
  public boolean a()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewVideoPlayManager.a() != null) && (this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewVideoPlayManager.a().jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIVideoView != null)) {
      this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewVideoPlayManager.a().jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIVideoView.b();
    }
  }
  
  public void b(View paramView) {}
  
  protected void b(VideoInfo paramVideoInfo)
  {
    paramVideoInfo = VideoFeedsHelper.c(paramVideoInfo.jdField_a_of_type_Long);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    Drawable localDrawable = getContext().getResources().getDrawable(2130843291);
    this.jdField_e_of_type_AndroidWidgetTextView.setText(paramVideoInfo);
    this.jdField_e_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(localDrawable, null, null, null);
    this.jdField_e_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(DisplayUtil.a(getContext(), 6.0F));
    this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
  }
  
  public void b(VideoPlayManager.VideoPlayParam paramVideoPlayParam) {}
  
  public void b(VideoPlayManager.VideoPlayParam paramVideoPlayParam, int paramInt)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new ViolaVideoView.3(this));
  }
  
  public void c()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoBrightnessController;
    if (localObject != null)
    {
      ((VideoBrightnessController)localObject).b();
      this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoBrightnessController = null;
    }
    localObject = this.jdField_a_of_type_AndroidOsHandler;
    if (localObject != null)
    {
      ((Handler)localObject).removeMessages(0);
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
  }
  
  public void c(VideoPlayManager.VideoPlayParam paramVideoPlayParam)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new ViolaVideoView.1(this, paramVideoPlayParam));
  }
  
  public void d()
  {
    int i;
    if (this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewVideoPlayManager.b()) {
      i = this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewVideoPlayManager.a();
    } else {
      i = 0;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handlePlayButtonClick() status()=");
      ((StringBuilder)localObject).append(i);
      QLog.d("ViolaVideoView", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewVideoPlayManager.a();
    switch (i)
    {
    default: 
      return;
    case 6: 
      this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewVideoPlayManager.c((VideoPlayManager.VideoPlayParam)localObject);
      this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewVideoPlayManager.b((VideoPlayManager.VideoPlayParam)localObject);
      return;
    case 5: 
      this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewVideoPlayManager.d(1);
      return;
    case 3: 
    case 4: 
      this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewVideoPlayManager.c(1);
      return;
    case 2: 
      this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewVideoPlayManager.b();
      return;
    case 1: 
      this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewVideoPlayManager.c(1);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewVideoPlayManager.b((VideoPlayManager.VideoPlayParam)localObject);
  }
  
  public void d(VideoPlayManager.VideoPlayParam paramVideoPlayParam)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new ViolaVideoView.2(this));
  }
  
  public void e()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("changeFullScreenStatus: mIsShowingFull=");
      localStringBuilder.append(this.jdField_c_of_type_Boolean);
      QLog.d("ViolaVideoView", 2, localStringBuilder.toString());
    }
    if (this.jdField_c_of_type_Boolean)
    {
      f();
      return;
    }
    g();
  }
  
  public void e(VideoPlayManager.VideoPlayParam paramVideoPlayParam)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new ViolaVideoView.4(this));
  }
  
  public void f(VideoPlayManager.VideoPlayParam paramVideoPlayParam)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new ViolaVideoView.5(this));
  }
  
  public void g(VideoPlayManager.VideoPlayParam paramVideoPlayParam)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new ViolaVideoView.6(this));
  }
  
  public void h(VideoPlayManager.VideoPlayParam paramVideoPlayParam)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new ViolaVideoView.7(this));
  }
  
  public void onClick(View paramView)
  {
    if (!a(paramView)) {
      return;
    }
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131372826: 
      d();
      return;
    case 2131372166: 
      if (this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewVideoPlayManager.d()) {
        VideoFeedsHelper.a(this.jdField_c_of_type_AndroidViewViewGroup, 8, 200);
      }
      d();
      return;
    case 2131367407: 
      e();
      return;
    }
    e();
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    c();
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public void setControlType(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    int i = this.jdField_a_of_type_Int;
    paramInt = 8;
    if (i != 0)
    {
      if (i != 1)
      {
        localObject = this.jdField_f_of_type_AndroidViewViewGroup;
        if (this.jdField_c_of_type_Boolean) {
          paramInt = 0;
        }
        ((ViewGroup)localObject).setVisibility(paramInt);
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
        localImageView = this.jdField_b_of_type_AndroidWidgetImageView;
        if (this.jdField_c_of_type_Boolean) {
          localObject = a(getContext(), 2130841851);
        } else {
          localObject = a(getContext(), 2130841852);
        }
        localImageView.setBackgroundDrawable((Drawable)localObject);
        return;
      }
      Object localObject = this.jdField_a_of_type_AndroidViewView;
      if (this.jdField_c_of_type_Boolean) {
        i = 0;
      } else {
        i = 8;
      }
      ((View)localObject).setVisibility(i);
      localObject = this.jdField_f_of_type_AndroidViewViewGroup;
      if (this.jdField_c_of_type_Boolean) {
        paramInt = 0;
      }
      ((ViewGroup)localObject).setVisibility(paramInt);
      ImageView localImageView = this.jdField_b_of_type_AndroidWidgetImageView;
      if (this.jdField_c_of_type_Boolean) {
        localObject = a(getContext(), 2130841851);
      } else {
        localObject = a(getContext(), 2130841852);
      }
      localImageView.setBackgroundDrawable((Drawable)localObject);
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
  
  public void setEndWithLastFrame(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
  }
  
  public void setEventListener(IVideoView.VideoViewEventListener paramVideoViewEventListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewIVideoView$VideoViewEventListener = paramVideoViewEventListener;
  }
  
  public void setFullScreenDisable(boolean paramBoolean)
  {
    ViewGroup localViewGroup = this.jdField_e_of_type_AndroidViewViewGroup;
    int i;
    if (paramBoolean) {
      i = 8;
    } else {
      i = 0;
    }
    localViewGroup.setVisibility(i);
  }
  
  public void setFullScreenTitle(String paramString)
  {
    this.jdField_d_of_type_AndroidWidgetTextView.setText(paramString);
  }
  
  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.videonew.ViolaVideoView
 * JD-Core Version:    0.7.0.1
 */