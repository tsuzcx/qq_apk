package com.tencent.mobileqq.flashshow.widgets.comment;

import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.richframework.animation.drawable.AnimationDrawableCreateOption.Builder;
import com.tencent.biz.richframework.animation.drawable.AnimationDrawableFactory;
import com.tencent.biz.richframework.animation.drawable.AnimationDrawableFactory.CreateResultListener;
import com.tencent.biz.richframework.animation.drawable.QQAnimationDrawable;
import com.tencent.biz.richframework.download.RFWDownloader;
import com.tencent.biz.richframework.download.RFWDownloaderFactory;
import com.tencent.biz.richframework.download.RFWMultiDownloadHelper;
import com.tencent.biz.richframework.download.RFWMultiDownloadHelper.DownloadTask;
import com.tencent.mobileqq.flashshow.utils.download.FSDownloadConfig;
import com.tencent.mobileqq.flashshow.widgets.FSBaseWidgetView;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;

public class FSPanelLoadingView
  extends FSBaseWidgetView
{
  private static RFWMultiDownloadHelper f = new RFWMultiDownloadHelper();
  private ImageView a;
  private QQAnimationDrawable b;
  private TextView c;
  private int d = 2130840383;
  private boolean e = false;
  private final AnimationDrawableFactory.CreateResultListener g = new FSPanelLoadingView.1(this);
  
  static
  {
    f.addTask(new RFWMultiDownloadHelper.DownloadTask("https://downv6.qq.com/video_story/wezone_url/defaultmode/qq_video/Qvideo_loading_seq.zip", FSDownloadConfig.a()));
    f.start();
  }
  
  public FSPanelLoadingView(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  public FSPanelLoadingView(@NonNull Context paramContext, int paramInt)
  {
    super(paramContext, Integer.valueOf(paramInt));
  }
  
  public FSPanelLoadingView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public FSPanelLoadingView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void c()
  {
    this.e = true;
    if (this.b == null)
    {
      QLog.d("FSPanelLoadingView", 1, "showDynamicLogoView Async fetchAnimDrawable first!");
      if (RFWDownloaderFactory.getDownloader(FSDownloadConfig.a()).isFileDownLoaded("https://downv6.qq.com/video_story/wezone_url/defaultmode/qq_video/Qvideo_loading_seq.zip"))
      {
        QLog.d("FSPanelLoadingView", 1, "showDynamicLogoView AnimDrawable already downloaded!");
        AnimationDrawableCreateOption.Builder localBuilder = new AnimationDrawableCreateOption.Builder("https://downv6.qq.com/video_story/wezone_url/defaultmode/qq_video/Qvideo_loading_seq.zip");
        localBuilder.b(67);
        localBuilder.a(2147483647L);
        localBuilder.a(false);
        localBuilder.b(true);
        AnimationDrawableFactory.a().a(hashCode(), localBuilder.a(), this.g);
        return;
      }
      f();
      QLog.d("FSPanelLoadingView", 1, "showDynamicLogoView AnimDrawable need download,show static logo first!");
      return;
    }
    QLog.d("FSPanelLoadingView", 1, "showUpdateAnim sync!");
    d();
  }
  
  private void d()
  {
    if (!this.e) {
      return;
    }
    if ((this.b != null) && (this.a != null))
    {
      setVisibility(0);
      this.a.setImageDrawable(this.b);
      this.b.start();
    }
  }
  
  private void e()
  {
    QQAnimationDrawable localQQAnimationDrawable = this.b;
    if (localQQAnimationDrawable == null) {
      return;
    }
    if (localQQAnimationDrawable.isRunning()) {
      this.b.stop();
    }
  }
  
  private void f()
  {
    if (!this.e) {
      return;
    }
    e();
    ImageView localImageView = this.a;
    if (localImageView != null)
    {
      localImageView.setImageResource(this.d);
      setVisibility(0);
    }
  }
  
  public void a()
  {
    this.e = true;
    c();
  }
  
  public void a(int paramInt)
  {
    paramInt /= 2;
    int i = ViewUtils.dip2px(37.0F);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    localLayoutParams.topMargin = (paramInt - i);
    localLayoutParams.gravity = 1;
    setLayoutParams(localLayoutParams);
    this.e = true;
    c();
  }
  
  public void b()
  {
    setVisibility(8);
    this.e = false;
    e();
  }
  
  protected void bindData(Object paramObject, int paramInt) {}
  
  public int getLayoutId()
  {
    return 2131624832;
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    b();
  }
  
  protected void onInitView(Context paramContext, View paramView)
  {
    this.a = ((ImageView)paramView.findViewById(2131433330));
    this.c = ((TextView)paramView.findViewById(2131433377));
    if (Build.VERSION.SDK_INT >= 21) {
      this.c.setLetterSpacing(0.1F);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.widgets.comment.FSPanelLoadingView
 * JD-Core Version:    0.7.0.1
 */