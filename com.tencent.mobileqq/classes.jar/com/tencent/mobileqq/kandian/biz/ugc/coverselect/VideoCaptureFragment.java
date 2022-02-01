package com.tencent.mobileqq.kandian.biz.ugc.coverselect;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.kandian.base.view.widget.CaptureOperateTouchLayout;
import com.tencent.mobileqq.kandian.base.view.widget.VideoMeasureScaleView;
import com.tencent.mobileqq.kandian.biz.ugc.coverselect.capture.CaptureTask;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.List;

public class VideoCaptureFragment
  extends PublicBaseFragment
  implements IVideoCaptureView
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private CaptureOperateTouchLayout jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetCaptureOperateTouchLayout;
  private VideoMeasureScaleView jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetVideoMeasureScaleView;
  private ImageUpdateListener jdField_a_of_type_ComTencentMobileqqKandianBizUgcCoverselectImageUpdateListener;
  private PreviewImageAdapter jdField_a_of_type_ComTencentMobileqqKandianBizUgcCoverselectPreviewImageAdapter;
  private VideoCapturePresenter jdField_a_of_type_ComTencentMobileqqKandianBizUgcCoverselectVideoCapturePresenter;
  private TextView b;
  
  public static VideoCaptureFragment a(String paramString, float paramFloat)
  {
    VideoCaptureFragment localVideoCaptureFragment = new VideoCaptureFragment();
    Bundle localBundle = new Bundle();
    localBundle.putString("ARG_VIDEO_URL", paramString);
    localBundle.putFloat("ARG_INITIAL_PROGRESS", paramFloat);
    localVideoCaptureFragment.setArguments(localBundle);
    return localVideoCaptureFragment;
  }
  
  private void a()
  {
    int i = b() + this.jdField_a_of_type_AndroidWidgetImageView.getPaddingTop() + this.jdField_a_of_type_AndroidWidgetImageView.getPaddingBottom();
    ViewGroup.LayoutParams localLayoutParams = this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
    localLayoutParams.height = i;
    localLayoutParams.width = i;
    this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams);
  }
  
  private void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetCaptureOperateTouchLayout.setup(this.jdField_a_of_type_AndroidWidgetImageView, this.jdField_a_of_type_AndroidWidgetTextView, this.b, this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetVideoMeasureScaleView, a());
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetCaptureOperateTouchLayout.setEnabled(false);
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetCaptureOperateTouchLayout.setOnCaptureOperateCallback(new VideoCaptureFragment.1(this));
  }
  
  public float a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetCaptureOperateTouchLayout.a();
  }
  
  public int a()
  {
    return 5;
  }
  
  public ViewGroup a()
  {
    return this.jdField_a_of_type_AndroidViewViewGroup;
  }
  
  public void a(float paramFloat, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetCaptureOperateTouchLayout.a(paramFloat, paramBoolean);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcCoverselectPreviewImageAdapter.notifyItemChanged(paramInt);
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetCaptureOperateTouchLayout.setDuration(paramLong);
  }
  
  public void a(Bitmap paramBitmap)
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
    ImageUpdateListener localImageUpdateListener = this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcCoverselectImageUpdateListener;
    if (localImageUpdateListener != null) {
      localImageUpdateListener.a(paramBitmap);
    }
  }
  
  public void a(ImageUpdateListener paramImageUpdateListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcCoverselectImageUpdateListener = paramImageUpdateListener;
  }
  
  public void a(OutputPicListener paramOutputPicListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcCoverselectVideoCapturePresenter.a(paramOutputPicListener);
  }
  
  public void a(List<CaptureTask> paramList)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcCoverselectPreviewImageAdapter = new PreviewImageAdapter(this.jdField_a_of_type_AndroidAppActivity, paramList);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcCoverselectPreviewImageAdapter);
  }
  
  public int b()
  {
    return (int)((UIUtils.a(BaseApplication.getContext()) - UIUtils.a(this.jdField_a_of_type_AndroidAppActivity, 5.0F)) / a());
  }
  
  public void b(long paramLong)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetCaptureOperateTouchLayout.setDuration(paramLong);
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetCaptureOperateTouchLayout.setEnabled(true);
  }
  
  public void b(List<CaptureTask> paramList)
  {
    PreviewImageAdapter localPreviewImageAdapter = this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcCoverselectPreviewImageAdapter;
    if (localPreviewImageAdapter != null)
    {
      localPreviewImageAdapter.clearList();
      this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcCoverselectPreviewImageAdapter.appendList(paramList);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcCoverselectPreviewImageAdapter.notifyDataSetChanged();
    }
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return View.inflate(this.jdField_a_of_type_AndroidAppActivity, 2131559981, null);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcCoverselectVideoCapturePresenter.c();
  }
  
  public void onPause()
  {
    super.onPause();
    this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcCoverselectVideoCapturePresenter.e();
  }
  
  public void onResume()
  {
    super.onResume();
    this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcCoverselectVideoCapturePresenter.d();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)paramView.findViewById(2131380541));
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramView.findViewById(2131380535));
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetCaptureOperateTouchLayout = ((CaptureOperateTouchLayout)paramView.findViewById(2131380539));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131380536));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131380540));
    this.b = ((TextView)paramView.findViewById(2131380542));
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetVideoMeasureScaleView = ((VideoMeasureScaleView)paramView.findViewById(2131380538));
    this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcCoverselectVideoCapturePresenter = new VideoCapturePresenter(this.jdField_a_of_type_AndroidAppActivity, getArguments(), this);
    paramView = new LinearLayoutManager(this.jdField_a_of_type_AndroidAppActivity, 0, false);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(paramView);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getLayoutParams().height = b();
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(paramView);
    a();
    b();
    this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcCoverselectVideoCapturePresenter.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.coverselect.VideoCaptureFragment
 * JD-Core Version:    0.7.0.1
 */