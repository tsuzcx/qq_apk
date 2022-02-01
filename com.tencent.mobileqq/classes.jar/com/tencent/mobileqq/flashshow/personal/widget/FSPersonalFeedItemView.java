package com.tencent.mobileqq.flashshow.personal.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.lifecycle.Observer;
import com.tencent.mobileqq.flashshow.api.data.DataBuilder;
import com.tencent.mobileqq.flashshow.data.FSDataCenter;
import com.tencent.mobileqq.flashshow.personal.bean.FSPersonalFeedInfo;
import com.tencent.mobileqq.flashshow.report.dc.FSLpReportDc11001;
import com.tencent.mobileqq.flashshow.utils.FSTextUtils;
import com.tencent.mobileqq.flashshow.widgets.FSBaseWidgetView;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.data.Option;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import feedcloud.FeedCloudMeta.StFeed;

public class FSPersonalFeedItemView
  extends FSBaseWidgetView<FSPersonalFeedInfo>
  implements Observer<FeedCloudMeta.StFeed>
{
  private ImageView a;
  private TextView b;
  private Bundle c;
  private String d;
  private ImageView e;
  private LinearLayout f;
  private FSPersonalFeedInfo g;
  
  public FSPersonalFeedItemView(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  private void a()
  {
    FSPersonalFeedInfo localFSPersonalFeedInfo = this.g;
    if ((localFSPersonalFeedInfo != null) && (localFSPersonalFeedInfo.a() != null))
    {
      FSDataCenter.a().a(this.g.a(), this);
      return;
    }
    QLog.i("FSPersonalFeedItemView", 1, "feed is empty");
  }
  
  private void b()
  {
    Object localObject = this.g;
    if ((localObject != null) && (((FSPersonalFeedInfo)localObject).a() != null))
    {
      this.a.setImageDrawable(null);
      localObject = new Option().setUrl(this.g.e()).setTargetView(this.a);
      ((Option)localObject).setLoadingDrawable(new ColorDrawable(getResources().getColor(2131166091)));
      QCircleFeedPicLoader.g().loadImage((Option)localObject, null);
      return;
    }
    QLog.i("FSPersonalFeedItemView", 1, "feed is empty");
  }
  
  private void c()
  {
    FSPersonalFeedInfo localFSPersonalFeedInfo = this.g;
    if (localFSPersonalFeedInfo != null)
    {
      if (!localFSPersonalFeedInfo.d()) {
        return;
      }
      FSLpReportDc11001.a(new DataBuilder(getReportBean()).setActionType(11).setSubActionType(60).setThrActionType(3).setToUin(this.d).setExt6(this.g.a().id.get()));
    }
  }
  
  private void d()
  {
    Object localObject = this.f;
    if ((localObject != null) && (this.e != null))
    {
      FSPersonalFeedInfo localFSPersonalFeedInfo = this.g;
      if (localFSPersonalFeedInfo == null) {
        return;
      }
      boolean bool = localFSPersonalFeedInfo.d();
      int j = 8;
      if (bool) {
        i = 8;
      } else {
        i = 0;
      }
      ((LinearLayout)localObject).setVisibility(i);
      localObject = this.e;
      int i = j;
      if (this.g.d()) {
        i = 0;
      }
      ((ImageView)localObject).setVisibility(i);
    }
  }
  
  private void e()
  {
    if (this.b != null)
    {
      Object localObject = this.g;
      if (localObject == null) {
        return;
      }
      localObject = FSTextUtils.a(((FSPersonalFeedInfo)localObject).c());
      this.b.setText((CharSequence)localObject);
    }
  }
  
  protected void a(FSPersonalFeedInfo paramFSPersonalFeedInfo, int paramInt)
  {
    if ((paramFSPersonalFeedInfo != null) && (paramFSPersonalFeedInfo.a() != null))
    {
      if (paramFSPersonalFeedInfo.equals(this.g)) {
        return;
      }
      this.g = paramFSPersonalFeedInfo;
      b();
      d();
      a();
      setTag(this.g.b());
    }
  }
  
  public void a(FeedCloudMeta.StFeed paramStFeed)
  {
    if (TextUtils.equals(this.g.b(), paramStFeed.id.get())) {
      e();
    }
  }
  
  public int getLayoutId()
  {
    return 2131624837;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    c();
  }
  
  protected void onInitView(Context paramContext, View paramView)
  {
    this.a = ((ImageView)paramView.findViewById(2131436371));
    this.f = ((LinearLayout)paramView.findViewById(2131437521));
    this.b = ((TextView)paramView.findViewById(2131448653));
    this.e = ((ImageView)paramView.findViewById(2131436334));
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(paramInt1) * 4 / 3, 1073741824));
  }
  
  public void setInitParams(Bundle paramBundle)
  {
    this.c = paramBundle;
  }
  
  public void setUin(String paramString)
  {
    this.d = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.personal.widget.FSPersonalFeedItemView
 * JD-Core Version:    0.7.0.1
 */