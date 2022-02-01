package com.tencent.mobileqq.flashshow.widgets.fault;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.qcircleshadow.lib.variation.HostNetworkUtils;
import com.tencent.biz.richframework.download.RFWDownloader;
import com.tencent.biz.richframework.download.RFWDownloader.RFWDownloadListener;
import com.tencent.biz.richframework.download.RFWDownloaderFactory;
import com.tencent.biz.richframework.download.RFWMultiDownloadHelper;
import com.tencent.biz.richframework.download.RFWMultiDownloadHelper.DownloadTask;
import com.tencent.mobileqq.flashshow.config.FSConfig;
import com.tencent.mobileqq.flashshow.utils.download.FSDownloadConfig;
import com.tencent.mobileqq.flashshow.widgets.FSBaseWidgetView;
import java.io.File;

public abstract class FSFaultHintView<T>
  extends FSBaseWidgetView<T>
{
  private static RFWMultiDownloadHelper e = new RFWMultiDownloadHelper();
  protected View a;
  protected View b;
  protected ImageView c;
  protected TextView d;
  private RFWDownloader.RFWDownloadListener f;
  
  static
  {
    e.addTask(new RFWMultiDownloadHelper.DownloadTask("https://downv6.qq.com/video_story/flashshow/empty_state_error_hint.png", FSDownloadConfig.a()));
    e.addTask(new RFWMultiDownloadHelper.DownloadTask("https://downv6.qq.com/video_story/flashshow/empty_state_empty_hint.png", FSDownloadConfig.a()));
    e.start();
  }
  
  public FSFaultHintView(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  public FSFaultHintView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void setVisible(boolean paramBoolean)
  {
    if ((!paramBoolean) && (getVisibility() == 0)) {
      setVisibility(8);
    }
    if ((paramBoolean) && (getVisibility() == 8)) {
      setVisibility(0);
    }
  }
  
  protected void a() {}
  
  protected void a(ImageView paramImageView, String paramString)
  {
    String str = c(paramString);
    if (RFWDownloaderFactory.getDownloader(FSDownloadConfig.a()).isFileDownLoading(paramString)) {
      return;
    }
    if (new File(str).exists())
    {
      b(paramImageView, str);
      return;
    }
    this.f = new FSFaultHintView.1(this, paramImageView);
    RFWDownloaderFactory.getDownloader(FSDownloadConfig.a()).download(paramString, this.f);
  }
  
  public void a(String paramString)
  {
    setVisible(true);
    a(this.c, "https://downv6.qq.com/video_story/flashshow/empty_state_empty_hint.png");
    if (!TextUtils.isEmpty(paramString)) {
      this.d.setText(paramString);
    }
  }
  
  protected void b()
  {
    String str = c("https://downv6.qq.com/video_story/flashshow/empty_state_error_hint.png");
    if (new File(str).exists()) {
      b(this.c, str);
    }
  }
  
  protected void b(ImageView paramImageView, String paramString)
  {
    if (paramImageView != null)
    {
      paramImageView.setVisibility(0);
      getMainHandler().post(new FSFaultHintView.2(this, paramImageView, paramString));
    }
  }
  
  public void b(String paramString)
  {
    if ((HostNetworkUtils.isNetworkAvailable() ^ true))
    {
      b();
    }
    else
    {
      a(this.c, "https://downv6.qq.com/video_story/flashshow/empty_state_error_hint.png");
      if (!TextUtils.isEmpty(paramString)) {
        this.d.setText(paramString);
      } else {
        this.d.setText(FSConfig.n());
      }
    }
    setVisible(true);
  }
  
  protected void bindData(T paramT, int paramInt) {}
  
  protected String c(String paramString)
  {
    return RFWDownloaderFactory.getDownloader(FSDownloadConfig.a()).getDefaultSavePath(paramString);
  }
  
  public void c()
  {
    setVisible(false);
  }
  
  public int getLayoutId()
  {
    return 2131624793;
  }
  
  protected void onInitView(Context paramContext, View paramView)
  {
    this.a = paramView.findViewById(2131433287);
    this.b = paramView.findViewById(2131437473);
    this.c = ((ImageView)paramView.findViewById(2131436413));
    this.d = ((TextView)paramView.findViewById(2131448526));
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.widgets.fault.FSFaultHintView
 * JD-Core Version:    0.7.0.1
 */