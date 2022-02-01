package com.tencent.mobileqq.winkpublish.part;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.winkpublish.base.BaseBlockPart;
import com.tencent.mobileqq.winkpublish.view.PublishPreviewVideo;
import com.tencent.mobileqq.winkpublish.widget.PublishCustomDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class QCircleVideoPreviewPart
  extends BaseBlockPart
  implements View.OnClickListener
{
  private PublishPreviewVideo a;
  private TextView b;
  private TextView e;
  private ImageView f;
  private List<String> g;
  private int h;
  private int i;
  
  private void d()
  {
    PublishPreviewVideo localPublishPreviewVideo = this.a;
    if ((localPublishPreviewVideo != null) && (localPublishPreviewVideo.o())) {
      this.a.i();
    }
  }
  
  private void e()
  {
    PublishCustomDialog.a(g(), g().getResources().getString(2131895942), null, 2131887648, 2131888010, new QCircleVideoPreviewPart.2(this), new QCircleVideoPreviewPart.3(this)).show();
  }
  
  public String a()
  {
    return super.a();
  }
  
  public void a(Intent paramIntent)
  {
    if (paramIntent == null)
    {
      QLog.e("[QcirclePublish]QCircleVideoPreviewPart", 1, "QCircleVideoPreviewPart... intent == null");
      c().finish();
      return;
    }
    this.g = paramIntent.getStringArrayListExtra("key_photo_previewer_list");
    this.i = paramIntent.getIntExtra("key_photo_previewer_video_cover_width", 0);
    this.h = paramIntent.getIntExtra("key_photo_previewer_video_cover_height", 0);
    paramIntent = this.g;
    if ((paramIntent != null) && (paramIntent.size() != 0))
    {
      QLog.d("[QcirclePublish]QCircleVideoPreviewPart", 1, new Object[] { "QCircleVideoPreviewPart... list:", this.g, " mWidth:", Integer.valueOf(this.i), " mHeight:", Integer.valueOf(this.h) });
      return;
    }
    QLog.w("[QcirclePublish]QCircleVideoPreviewPart", 1, "QCircleVideoPreviewPart... mList == null || mList.size() == 0");
    c().finish();
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    QLog.d("[QcirclePublish]QCircleVideoPreviewPart", 1, "onInitView...");
    this.b = ((TextView)paramView.findViewById(2131441735));
    this.e = ((TextView)paramView.findViewById(2131441736));
    this.f = ((ImageView)paramView.findViewById(2131431689));
    this.b.setOnClickListener(this);
    this.f.setOnClickListener(this);
    this.a = ((PublishPreviewVideo)paramView.findViewById(2131441796));
    this.a.setVisibility(0);
    paramView.findViewById(2131441818).setVisibility(8);
    this.a.setLoopBack(false);
    this.a.setData(this.g.get(0));
    this.a.setBaseVideoViewListenerSets(new QCircleVideoPreviewPart.1(this));
  }
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    super.onActivityCreated(paramActivity, paramBundle);
  }
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    super.onActivityDestroyed(paramActivity);
    paramActivity = this.a;
    if (paramActivity != null) {
      paramActivity.release();
    }
  }
  
  public void onActivityPaused(Activity paramActivity)
  {
    super.onActivityPaused(paramActivity);
    QLog.i("[QcirclePublish]QCircleVideoPreviewPart", 1, "onActivityPaused");
    this.a.j();
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    super.onActivityResumed(paramActivity);
    QLog.d("[QcirclePublish]QCircleVideoPreviewPart", 1, "onActivityResumed...");
    d();
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131441735) {
      c().finish();
    } else if (paramView.getId() == 2131431689) {
      e();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.part.QCircleVideoPreviewPart
 * JD-Core Version:    0.7.0.1
 */