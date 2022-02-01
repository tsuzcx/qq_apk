package com.tencent.mobileqq.qqexpand.feed;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.mini.api.data.SimpleMiniAppConfig;
import com.tencent.mobileqq.mini.api.data.SimpleMiniAppConfig.SimpleMiniAppInfo;
import com.tencent.mobileqq.qqexpand.bean.feed.MiniAppRecommInfo.MiniApp;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.widget.ThemeImageView;
import com.tencent.widget.ThemeImageWrapper;
import java.lang.ref.WeakReference;

class MiniAppRecommViewHolder$MicroAppViewHolder
  extends RecyclerView.ViewHolder
  implements View.OnClickListener
{
  MiniAppRecommInfo.MiniApp a;
  int b;
  ImageView c;
  TextView d;
  private final WeakReference<Activity> e;
  
  public MiniAppRecommViewHolder$MicroAppViewHolder(Activity paramActivity, View paramView)
  {
    super(paramView);
    this.e = new WeakReference(paramActivity);
    this.c = ((ImageView)paramView.findViewById(2131438721));
    paramActivity = this.c;
    if ((paramActivity instanceof ThemeImageView)) {
      ((ThemeImageView)paramActivity).setMaskShape(ThemeImageWrapper.MODE_OTHER);
    }
    this.d = ((TextView)paramView.findViewById(2131438724));
    this.c.setOnClickListener(this);
    this.d.setOnClickListener(this);
  }
  
  public void a(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void a(MiniAppRecommInfo.MiniApp paramMiniApp)
  {
    if (paramMiniApp == null) {
      return;
    }
    this.a = paramMiniApp;
    Drawable localDrawable = ((IMiniAppService)QRoute.api(IMiniAppService.class)).getIcon(this.c.getContext(), paramMiniApp.c, true, 2130841992, 48);
    this.c.setImageDrawable(localDrawable);
    this.d.setText(paramMiniApp.b);
  }
  
  public void onClick(View paramView)
  {
    paramView = this.a;
    if ((paramView != null) && (paramView.e != null))
    {
      paramView = new SimpleMiniAppConfig(SimpleMiniAppConfig.SimpleMiniAppInfo.from(this.a.e));
      paramView.launchParam.scene = 2065;
      ((IMiniAppService)QRoute.api(IMiniAppService.class)).startApp((Activity)this.e.get(), paramView, null);
      MiniAppRecommViewHolder.a(102, this.b, this.a.f);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.feed.MiniAppRecommViewHolder.MicroAppViewHolder
 * JD-Core Version:    0.7.0.1
 */