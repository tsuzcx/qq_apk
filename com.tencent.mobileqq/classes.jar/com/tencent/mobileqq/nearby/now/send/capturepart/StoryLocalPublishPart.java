package com.tencent.mobileqq.nearby.now.send.capturepart;

import aehv;
import aehw;
import aehy;
import aehz;
import aeia;
import aeib;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.nearby.now.send.SmallVideoCameraCaptureFragment;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.PhotoCaptureResult;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.VideoCaptureResult;
import com.tencent.mobileqq.richmedia.capture.view.ProviderContainerView;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;

public class StoryLocalPublishPart
  extends StoryCapturePart
{
  public final int a;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new aeib(this);
  private View jdField_a_of_type_AndroidViewView;
  private ImageButton jdField_a_of_type_AndroidWidgetImageButton;
  private StoryLocalPublishPart.ICapturePartVisiableChangeListener jdField_a_of_type_ComTencentMobileqqNearbyNowSendCapturepartStoryLocalPublishPart$ICapturePartVisiableChangeListener;
  private StoryLocalPublishPart.LocalButtonListenerInterceptor jdField_a_of_type_ComTencentMobileqqNearbyNowSendCapturepartStoryLocalPublishPart$LocalButtonListenerInterceptor;
  private View b;
  private View c;
  
  public StoryLocalPublishPart(@NonNull SmallVideoCameraCaptureFragment paramSmallVideoCameraCaptureFragment)
  {
    super(paramSmallVideoCameraCaptureFragment);
    this.jdField_a_of_type_Int = a();
  }
  
  public void a()
  {
    super.a();
    a(new aehz(this));
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    a(new aeia(this));
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == this.jdField_a_of_type_Int) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendSmallVideoCameraCaptureFragment.a(paramInt1, paramInt2, paramIntent);
    }
    if (paramInt2 == 0) {
      c();
    }
  }
  
  public void a(View paramView, Bundle paramBundle)
  {
    super.a(paramView, paramBundle);
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)paramView.findViewById(2131370473));
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131370474);
    this.b = paramView.findViewById(2131370475);
    this.c = paramView.findViewById(2131370476);
    this.jdField_a_of_type_AndroidWidgetImageButton.setImageDrawable(new ColorDrawable(0));
    this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendSmallVideoCameraCaptureFragment.a().setContainerViewListener(new aehv(this));
    Bosses.get().postJob(new aehw(this, paramView));
  }
  
  public void a(StoryLocalPublishPart.ICapturePartVisiableChangeListener paramICapturePartVisiableChangeListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendCapturepartStoryLocalPublishPart$ICapturePartVisiableChangeListener = paramICapturePartVisiableChangeListener;
  }
  
  public void a(StoryLocalPublishPart.LocalButtonListenerInterceptor paramLocalButtonListenerInterceptor)
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendCapturepartStoryLocalPublishPart$LocalButtonListenerInterceptor = paramLocalButtonListenerInterceptor;
  }
  
  public void a(CameraCaptureView.PhotoCaptureResult paramPhotoCaptureResult)
  {
    super.a(paramPhotoCaptureResult);
  }
  
  public void a(CameraCaptureView.VideoCaptureResult paramVideoCaptureResult, LocalMediaInfo paramLocalMediaInfo)
  {
    super.a(paramVideoCaptureResult, paramLocalMediaInfo);
  }
  
  public void a(Runnable paramRunnable)
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      paramRunnable.run();
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.post(paramRunnable);
  }
  
  public void b()
  {
    super.b();
    a(new aehy(this));
  }
  
  public void c()
  {
    this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(0);
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.b.setVisibility(0);
    this.c.setVisibility(0);
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendCapturepartStoryLocalPublishPart$ICapturePartVisiableChangeListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendCapturepartStoryLocalPublishPart$ICapturePartVisiableChangeListener.a(true);
    }
  }
  
  public void d()
  {
    this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(8);
    this.b.setVisibility(8);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.c.setVisibility(8);
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendCapturepartStoryLocalPublishPart$ICapturePartVisiableChangeListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendCapturepartStoryLocalPublishPart$ICapturePartVisiableChangeListener.a(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.send.capturepart.StoryLocalPublishPart
 * JD-Core Version:    0.7.0.1
 */