package com.tencent.mobileqq.kandian.biz.playfeeds;

import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import android.graphics.Region.Op;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.text.format.DateUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.base.utils.KandianUGStatisticUtils;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.UGDownloadInfo;
import com.tencent.mobileqq.utils.PackageUtil;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.open.appstore.dl.DownloadManagerV2;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadListener;
import java.util.List;
import javax.annotation.Nullable;
import mqq.os.MqqHandler;

public class VideoFeedsUGView
  extends AbsVideoFeedsUGView
  implements DownloadListener
{
  public static VideoFeedsUGDownloadListener k = new VideoFeedsUGDownloadListener();
  UGDownloadInfo a;
  String b;
  int c = 0;
  ImageView d;
  ImageView e;
  ImageView f;
  TextView g;
  RectF h = new RectF();
  Paint i = new Paint();
  Path j;
  private String l = "";
  
  public VideoFeedsUGView(@NonNull Context paramContext)
  {
    super(paramContext, null, 0);
    a(paramContext);
    setOnClickListener(this);
  }
  
  public VideoFeedsUGView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet, 0);
    a(paramContext);
    setOnClickListener(this);
  }
  
  private void a(Context paramContext)
  {
    this.d = new ImageView(paramContext);
    this.d.setId(1);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(AIOUtils.b(24.0F, getResources()), AIOUtils.b(24.0F, getResources()));
    localLayoutParams.addRule(15);
    localLayoutParams.addRule(9);
    localLayoutParams.leftMargin = AIOUtils.b(8.0F, getResources());
    this.d.setLayoutParams(localLayoutParams);
    addView(this.d, localLayoutParams);
    this.e = new ImageView(paramContext);
    this.e.setId(2);
    localLayoutParams = new RelativeLayout.LayoutParams(AIOUtils.b(95.0F, getResources()), AIOUtils.b(14.0F, getResources()));
    localLayoutParams.addRule(1, 1);
    localLayoutParams.addRule(15);
    localLayoutParams.leftMargin = AIOUtils.b(4.0F, getResources());
    this.e.setLayoutParams(localLayoutParams);
    addView(this.e, localLayoutParams);
    this.g = new TextView(paramContext);
    this.g.setId(3);
    this.g.setTextSize(11.0F);
    localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(1, 1);
    localLayoutParams.addRule(10);
    localLayoutParams.topMargin = AIOUtils.b(6.0F, getResources());
    localLayoutParams.leftMargin = AIOUtils.b(4.0F, getResources());
    localLayoutParams.bottomMargin = 1;
    this.g.setLayoutParams(localLayoutParams);
    addView(this.g, localLayoutParams);
    this.f = new ImageView(paramContext);
    this.f.setPadding(AIOUtils.b(4.0F, getResources()), AIOUtils.b(4.0F, getResources()), AIOUtils.b(4.0F, getResources()), AIOUtils.b(4.0F, getResources()));
    this.f.setOnClickListener(new VideoFeedsUGView.1(this));
    paramContext = new RelativeLayout.LayoutParams(AIOUtils.b(16.0F, getResources()), AIOUtils.b(16.0F, getResources()));
    paramContext.addRule(11);
    paramContext.addRule(15);
    paramContext.rightMargin = AIOUtils.b(4.0F, getResources());
    this.f.setLayoutParams(paramContext);
    addView(this.f, paramContext);
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.a == null)
    {
      setVisibility(8);
      return;
    }
    if (!DateUtils.isToday(SharedPreUtils.k("ug_prefix_ug_1get3_ug_show_time")))
    {
      SharedPreUtils.a("ug_prefix_ug_1get3_ug_show_time", System.currentTimeMillis());
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("ug_prefix_ug_1get3_ug_click_count");
      ((StringBuilder)localObject1).append(this.a.p);
      SharedPreUtils.c(((StringBuilder)localObject1).toString(), 0);
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("ug_prefix_ug_1get3_ug_exp_count");
      ((StringBuilder)localObject1).append(this.a.p);
      SharedPreUtils.c(((StringBuilder)localObject1).toString(), 0);
    }
    if (DateUtils.isToday(SharedPreUtils.k("ug_prefix_ug_1get3_ug_close_time")))
    {
      setVisibility(8);
      return;
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("ug_prefix_ug_1get3_ug_click_count");
    ((StringBuilder)localObject1).append(this.a.p);
    if (SharedPreUtils.l(((StringBuilder)localObject1).toString()) >= this.a.n)
    {
      setVisibility(8);
      return;
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("ug_prefix_ug_1get3_ug_exp_count");
    ((StringBuilder)localObject1).append(this.a.p);
    if (SharedPreUtils.l(((StringBuilder)localObject1).toString()) >= this.a.o)
    {
      setVisibility(8);
      return;
    }
    if ((this.a.q == 1) && (PackageUtil.a(BaseApplicationImpl.getContext(), this.a.j)))
    {
      setVisibility(8);
      return;
    }
    if ((this.a.q == 2) && (!PackageUtil.a(BaseApplicationImpl.getContext(), this.a.j)))
    {
      setVisibility(8);
      return;
    }
    Object localObject2;
    if (paramBoolean)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("ug_prefix_ug_1get3_ug_exp_count");
      ((StringBuilder)localObject1).append(this.a.p);
      localObject1 = ((StringBuilder)localObject1).toString();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("ug_prefix_ug_1get3_ug_exp_count");
      ((StringBuilder)localObject2).append(this.a.p);
      SharedPreUtils.c((String)localObject1, SharedPreUtils.l(((StringBuilder)localObject2).toString()) + 1);
      KandianUGStatisticUtils.a(KandianUGStatisticUtils.b(this.a.i, "2", this.b));
    }
    setVisibility(0);
    if (this.a.q == 2)
    {
      this.c = 0;
      this.e.setVisibility(0);
      this.g.setVisibility(8);
    }
    else
    {
      localObject1 = DownloadManagerV2.a().b(this.a.f);
      if (localObject1 == null)
      {
        this.c = 0;
        this.e.setVisibility(0);
        this.g.setVisibility(8);
      }
      else
      {
        this.e.setVisibility(8);
        this.g.setVisibility(0);
        if (((DownloadInfo)localObject1).a() == 4)
        {
          this.g.setText(this.a.m);
        }
        else if ((((DownloadInfo)localObject1).a() != 20) && (((DownloadInfo)localObject1).a() != 1) && (((DownloadInfo)localObject1).a() != 2))
        {
          this.g.setText(this.a.l);
        }
        else
        {
          localObject2 = this.g;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(this.a.k);
          localStringBuilder.append(((DownloadInfo)localObject1).t);
          localStringBuilder.append("%");
          ((TextView)localObject2).setText(localStringBuilder.toString());
        }
        this.c = ((DownloadInfo)localObject1).t;
      }
    }
    b();
    invalidate();
  }
  
  private void b()
  {
    Object localObject = this.a;
    if (localObject == null) {
      return;
    }
    try
    {
      this.g.setTextColor(Color.parseColor(((UGDownloadInfo)localObject).e));
      label24:
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = new ColorDrawable(0);
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = new ColorDrawable(0);
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = AIOUtils.b(153.0F, getResources());
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = AIOUtils.b(28.0F, getResources());
      setBackgroundDrawable(URLDrawable.getDrawable(this.a.a, (URLDrawable.URLDrawableOptions)localObject));
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = new ColorDrawable(0);
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = new ColorDrawable(0);
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = AIOUtils.b(24.0F, getResources());
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = AIOUtils.b(24.0F, getResources());
      localObject = URLDrawable.getDrawable(this.a.b, (URLDrawable.URLDrawableOptions)localObject);
      this.d.setImageDrawable((Drawable)localObject);
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = new ColorDrawable(0);
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = new ColorDrawable(0);
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = AIOUtils.b(95.0F, getResources());
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = AIOUtils.b(14.0F, getResources());
      localObject = URLDrawable.getDrawable(this.a.c, (URLDrawable.URLDrawableOptions)localObject);
      this.e.setImageDrawable((Drawable)localObject);
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = new ColorDrawable(0);
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = new ColorDrawable(0);
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = AIOUtils.b(8.0F, getResources());
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = AIOUtils.b(8.0F, getResources());
      localObject = URLDrawable.getDrawable(this.a.d, (URLDrawable.URLDrawableOptions)localObject);
      this.f.setImageDrawable((Drawable)localObject);
      return;
    }
    catch (Exception localException)
    {
      break label24;
    }
  }
  
  public void a()
  {
    this.a = null;
  }
  
  public void installSucceed(String paramString1, String paramString2)
  {
    ThreadManager.getUIHandler().post(new VideoFeedsUGView.8(this, paramString2));
  }
  
  public void onClick(View paramView)
  {
    paramView = this.a;
    if (paramView == null) {
      return;
    }
    Object localObject;
    if (paramView.q == 2)
    {
      paramView = new Intent();
      paramView.setAction("android.intent.action.VIEW");
      paramView.putExtra("big_brother_source_key", "biz_src_kandian_videos");
      paramView.setData(Uri.parse(this.a.g));
      if (VideoFeedsHelper.a(getContext(), paramView)) {
        getContext().startActivity(paramView);
      }
      KandianUGStatisticUtils.a(KandianUGStatisticUtils.b(this.a.i, "7", this.b));
      paramView = new StringBuilder();
      paramView.append("ug_prefix_ug_1get3_ug_click_count");
      paramView.append(this.a.p);
      paramView = paramView.toString();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("ug_prefix_ug_1get3_ug_click_count");
      ((StringBuilder)localObject).append(this.a.p);
      SharedPreUtils.c(paramView, SharedPreUtils.l(((StringBuilder)localObject).toString()) + 1);
      return;
    }
    paramView = new VideoFeedsUGDownloadListener.UGClickData();
    paramView.c = this.a.f;
    paramView.a = this.a.i;
    paramView.b = this.b;
    k.a(this.a.j, paramView);
    DownloadManagerV2.a().a(k);
    paramView = this.a.h;
    try
    {
      ((ClipboardManager)getContext().getSystemService("clipboard")).setText(paramView);
      label258:
      KandianUGStatisticUtils.a(KandianUGStatisticUtils.b(this.a.i, "3", this.b));
      this.g.setVisibility(0);
      this.e.setVisibility(8);
      paramView = DownloadManagerV2.a().b(this.a.f);
      if (paramView == null)
      {
        paramView = new DownloadInfo();
        paramView.d = this.a.f;
        paramView.r = "biz_src_kandian_videos";
        paramView.e = this.a.j;
        DownloadManagerV2.a().b(paramView);
        paramView = new StringBuilder();
        paramView.append("ug_prefix_ug_1get3_ug_click_count");
        paramView.append(this.a.p);
        paramView = paramView.toString();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("ug_prefix_ug_1get3_ug_click_count");
        ((StringBuilder)localObject).append(this.a.p);
        SharedPreUtils.c(paramView, SharedPreUtils.l(((StringBuilder)localObject).toString()) + 1);
        KandianUGStatisticUtils.a(KandianUGStatisticUtils.b(this.a.i, "9", this.b));
        KandianUGStatisticUtils.a(KandianUGStatisticUtils.b(this.a.i, "10", this.b));
        paramView = this.g;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(this.a.k);
        ((StringBuilder)localObject).append("0%");
        paramView.setText(((StringBuilder)localObject).toString());
        this.c = 0;
        return;
      }
      if (paramView.a() == 4)
      {
        KandianUGStatisticUtils.a(KandianUGStatisticUtils.b(this.a.i, "102", this.b));
        KandianUGStatisticUtils.a(KandianUGStatisticUtils.b(this.a.i, "20", this.b));
        if (!DownloadManagerV2.a().d(paramView)) {
          DownloadManagerV2.a().b(paramView);
        }
        paramView = new StringBuilder();
        paramView.append("ug_prefix_ug_1get3_ug_click_count");
        paramView.append(this.a.p);
        paramView = paramView.toString();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("ug_prefix_ug_1get3_ug_click_count");
        ((StringBuilder)localObject).append(this.a.p);
        SharedPreUtils.c(paramView, SharedPreUtils.l(((StringBuilder)localObject).toString()) + 1);
        this.g.setText(this.a.m);
        return;
      }
      if ((paramView.a() != 30) && (paramView.a() != 10) && (paramView.a() != 20) && (paramView.a() != 1) && (paramView.a() != 2))
      {
        DownloadManagerV2.a().b(paramView);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("ug_prefix_ug_1get3_ug_click_count");
        ((StringBuilder)localObject).append(this.a.p);
        localObject = ((StringBuilder)localObject).toString();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("ug_prefix_ug_1get3_ug_click_count");
        localStringBuilder.append(this.a.p);
        SharedPreUtils.c((String)localObject, SharedPreUtils.l(localStringBuilder.toString()) + 1);
        KandianUGStatisticUtils.a(KandianUGStatisticUtils.b(this.a.i, "10", this.b));
        localObject = this.g;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.a.k);
        localStringBuilder.append(paramView.t);
        localStringBuilder.append("%");
        ((TextView)localObject).setText(localStringBuilder.toString());
        this.c = paramView.t;
        return;
      }
      KandianUGStatisticUtils.a(KandianUGStatisticUtils.b(this.a.i, "22", this.b));
      DownloadManagerV2.a().e(this.a.f);
      this.g.setText(this.a.l);
      return;
    }
    catch (Throwable paramView)
    {
      break label258;
    }
  }
  
  public void onDownloadCancel(DownloadInfo paramDownloadInfo)
  {
    ThreadManager.getUIHandler().post(new VideoFeedsUGView.5(this, paramDownloadInfo));
  }
  
  public void onDownloadError(DownloadInfo paramDownloadInfo, int paramInt1, String paramString, int paramInt2)
  {
    ThreadManager.getUIHandler().post(new VideoFeedsUGView.7(this, paramDownloadInfo));
  }
  
  public void onDownloadFinish(DownloadInfo paramDownloadInfo)
  {
    ThreadManager.getUIHandler().post(new VideoFeedsUGView.4(this, paramDownloadInfo));
  }
  
  public void onDownloadPause(DownloadInfo paramDownloadInfo)
  {
    ThreadManager.getUIHandler().post(new VideoFeedsUGView.2(this, paramDownloadInfo));
  }
  
  public void onDownloadUpdate(List<DownloadInfo> paramList)
  {
    ThreadManager.getUIHandler().post(new VideoFeedsUGView.6(this, paramList));
  }
  
  public void onDownloadWait(DownloadInfo paramDownloadInfo)
  {
    ThreadManager.getUIHandler().post(new VideoFeedsUGView.3(this, paramDownloadInfo));
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if ((this.a != null) && (this.c != 0))
    {
      paramCanvas.save();
      if (this.j == null)
      {
        this.j = new Path();
        this.j.addRoundRect(new RectF(0.0F, 0.0F, getWidth(), getHeight()), AIOUtils.b(14.0F, getResources()), AIOUtils.b(14.0F, getResources()), Path.Direction.CW);
      }
      paramCanvas.clipPath(this.j, Region.Op.INTERSECT);
      this.h.set(0.0F, 0.0F, getWidth() * this.c / 100.0F, getHeight());
      this.i.setColor(1291845631);
      paramCanvas.drawRect(this.h, this.i);
      paramCanvas.restore();
    }
  }
  
  public void packageReplaced(String paramString1, String paramString2) {}
  
  public void setActive(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      DownloadManagerV2.a().a(this);
      a(true);
      return;
    }
    DownloadManagerV2.a().b(this);
  }
  
  public void setInfo(UGDownloadInfo paramUGDownloadInfo, String paramString1, String paramString2)
  {
    this.l = paramString1;
    this.b = paramString2;
    this.a = paramUGDownloadInfo;
    a(false);
  }
  
  public void uninstallSucceed(String paramString1, String paramString2)
  {
    ThreadManager.getUIHandler().post(new VideoFeedsUGView.9(this, paramString2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsUGView
 * JD-Core Version:    0.7.0.1
 */