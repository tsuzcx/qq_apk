package com.tencent.mobileqq.flashshow.widgets.comment;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.richframework.download.RFWMultiDownloadHelper;
import com.tencent.biz.richframework.download.RFWMultiDownloadHelper.DownloadTask;
import com.tencent.mobileqq.flashshow.utils.download.FSDownloadConfig;
import com.tencent.mobileqq.flashshow.widgets.FSBaseWidgetView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class FSStatusView
  extends FSBaseWidgetView
  implements View.OnClickListener
{
  private static RFWMultiDownloadHelper f = new RFWMultiDownloadHelper();
  protected LinearLayout a;
  protected ImageView b;
  protected TextView c;
  protected LinearLayout d;
  protected LinearLayout e;
  private View.OnClickListener g;
  
  static
  {
    f.addTask(new RFWMultiDownloadHelper.DownloadTask("https://qzonestyle.gtimg.cn/qzone/qzact/act/external/qzone-platform/wezone/2020-wezone-img/2020-empty-state/6-preload/img_preload_fullscreen_disconnect.png", FSDownloadConfig.a()));
    f.start();
  }
  
  public FSStatusView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public FSStatusView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b();
  }
  
  private void b()
  {
    setClickable(true);
    a();
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
  
  public void a()
  {
    setVisible(false);
  }
  
  protected void a(View paramView)
  {
    View.OnClickListener localOnClickListener = this.g;
    if (localOnClickListener == null) {
      return;
    }
    localOnClickListener.onClick(paramView);
  }
  
  protected void a(ImageView paramImageView, String paramString)
  {
    if (paramImageView != null)
    {
      paramImageView.setVisibility(0);
      getMainHandler().post(new FSStatusView.2(this, paramString, paramImageView));
    }
  }
  
  protected void bindData(Object paramObject, int paramInt) {}
  
  public int getLayoutId()
  {
    return 2131624798;
  }
  
  protected String getLogTag()
  {
    return "FSStatusView";
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131437401) {
      a(paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  protected void onInitView(Context paramContext, View paramView)
  {
    this.a = ((LinearLayout)paramView.findViewById(2131445015));
    this.b = ((ImageView)paramView.findViewById(2131436489));
    this.c = ((TextView)paramView.findViewById(2131436491));
    this.d = ((LinearLayout)paramView.findViewById(2131437401));
    this.e = ((LinearLayout)paramView.findViewById(2131437490));
    this.d.setOnClickListener(this);
  }
  
  public void setOnRetryClickListener(View.OnClickListener paramOnClickListener)
  {
    this.g = paramOnClickListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.widgets.comment.FSStatusView
 * JD-Core Version:    0.7.0.1
 */