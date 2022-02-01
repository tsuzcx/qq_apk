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
  private Activity a;
  private RecyclerView b;
  private CaptureOperateTouchLayout c;
  private ViewGroup d;
  private TextView e;
  private TextView f;
  private VideoMeasureScaleView g;
  private ImageView h;
  private ImageUpdateListener i;
  private PreviewImageAdapter j;
  private VideoCapturePresenter k;
  
  public static VideoCaptureFragment a(String paramString, float paramFloat)
  {
    VideoCaptureFragment localVideoCaptureFragment = new VideoCaptureFragment();
    Bundle localBundle = new Bundle();
    localBundle.putString("ARG_VIDEO_URL", paramString);
    localBundle.putFloat("ARG_INITIAL_PROGRESS", paramFloat);
    localVideoCaptureFragment.setArguments(localBundle);
    return localVideoCaptureFragment;
  }
  
  private void e()
  {
    int m = b() + this.h.getPaddingTop() + this.h.getPaddingBottom();
    ViewGroup.LayoutParams localLayoutParams = this.h.getLayoutParams();
    localLayoutParams.height = m;
    localLayoutParams.width = m;
    this.h.setLayoutParams(localLayoutParams);
  }
  
  private void f()
  {
    this.c.setup(this.h, this.e, this.f, this.g, a());
    this.c.setEnabled(false);
    this.c.setOnCaptureOperateCallback(new VideoCaptureFragment.1(this));
  }
  
  public int a()
  {
    return 5;
  }
  
  public void a(float paramFloat, boolean paramBoolean)
  {
    this.c.a(paramFloat, paramBoolean);
  }
  
  public void a(int paramInt)
  {
    this.j.notifyItemChanged(paramInt);
  }
  
  public void a(long paramLong)
  {
    this.c.setDuration(paramLong);
  }
  
  public void a(Bitmap paramBitmap)
  {
    this.h.setImageBitmap(paramBitmap);
    ImageUpdateListener localImageUpdateListener = this.i;
    if (localImageUpdateListener != null) {
      localImageUpdateListener.a(paramBitmap);
    }
  }
  
  public void a(ImageUpdateListener paramImageUpdateListener)
  {
    this.i = paramImageUpdateListener;
  }
  
  public void a(OutputPicListener paramOutputPicListener)
  {
    this.k.a(paramOutputPicListener);
  }
  
  public void a(List<CaptureTask> paramList)
  {
    this.j = new PreviewImageAdapter(this.a, paramList);
    this.b.setAdapter(this.j);
  }
  
  public int b()
  {
    return (int)((UIUtils.b(BaseApplication.getContext()) - UIUtils.a(this.a, 5.0F)) / a());
  }
  
  public void b(long paramLong)
  {
    this.c.setDuration(paramLong);
    this.c.setEnabled(true);
  }
  
  public void b(List<CaptureTask> paramList)
  {
    PreviewImageAdapter localPreviewImageAdapter = this.j;
    if (localPreviewImageAdapter != null)
    {
      localPreviewImageAdapter.clearList();
      this.j.appendList(paramList);
      this.j.notifyDataSetChanged();
    }
  }
  
  public ViewGroup c()
  {
    return this.d;
  }
  
  public float d()
  {
    return this.c.getCurrentProgress();
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    this.a = paramActivity;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return View.inflate(this.a, 2131626024, null);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.k.c();
  }
  
  public void onPause()
  {
    super.onPause();
    this.k.e();
  }
  
  public void onResume()
  {
    super.onResume();
    this.k.d();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.b = ((RecyclerView)paramView.findViewById(2131449498));
    this.d = ((ViewGroup)paramView.findViewById(2131449492));
    this.c = ((CaptureOperateTouchLayout)paramView.findViewById(2131449496));
    this.h = ((ImageView)paramView.findViewById(2131449493));
    this.e = ((TextView)paramView.findViewById(2131449497));
    this.f = ((TextView)paramView.findViewById(2131449499));
    this.g = ((VideoMeasureScaleView)paramView.findViewById(2131449495));
    this.k = new VideoCapturePresenter(this.a, getArguments(), this);
    paramView = new LinearLayoutManager(this.a, 0, false);
    this.b.setLayoutManager(paramView);
    this.b.getLayoutParams().height = b();
    this.b.setLayoutManager(paramView);
    e();
    f();
    this.k.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.coverselect.VideoCaptureFragment
 * JD-Core Version:    0.7.0.1
 */