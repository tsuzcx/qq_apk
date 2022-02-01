package com.tencent.mobileqq.flashshow.part;

import android.app.Activity;
import android.graphics.Color;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.flashshow.api.bean.FSPageListBean;
import com.tencent.mobileqq.flashshow.api.data.DataBuilder;
import com.tencent.mobileqq.flashshow.launcher.FSNativeLauncher;
import com.tencent.mobileqq.flashshow.personal.viewmodel.FSPersonalViewModel;
import com.tencent.mobileqq.flashshow.report.dc.FSLpReportDc11001;
import com.tencent.mobileqq.flashshow.utils.FSCommonUtil;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import feedcloud.FeedCloudMeta.StUser;

public class FSPersonTitlePart
  extends FSBasePart
  implements View.OnClickListener
{
  private TextView a;
  private ImageView b;
  private ViewStub c;
  private FeedCloudMeta.StUser d;
  private int e;
  private FSPersonalViewModel f;
  
  public FSPersonTitlePart(FeedCloudMeta.StUser paramStUser)
  {
    this.d = paramStUser;
  }
  
  private void a(FeedCloudMeta.StUser paramStUser)
  {
    if (paramStUser != null)
    {
      this.a.setText(paramStUser.nick.get());
      if (!FSCommonUtil.a(paramStUser))
      {
        this.a.setVisibility(0);
        return;
      }
      this.a.setVisibility(8);
    }
  }
  
  private void b(View paramView)
  {
    if (FSCommonUtil.a(this.d))
    {
      this.c.inflate();
      paramView.findViewById(2131436455).setOnClickListener(this);
      f();
    }
  }
  
  private void f()
  {
    FSLpReportDc11001.a(new DataBuilder(null).setActionType(11).setSubActionType(2).setThrActionType(1));
  }
  
  public String a()
  {
    return "FSTitlePart";
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    this.b = ((ImageView)paramView.findViewById(2131436275));
    this.c = ((ViewStub)paramView.findViewById(2131450018));
    this.a = ((TextView)paramView.findViewById(2131448818));
    this.e = this.a.getCurrentTextColor();
    b(paramView);
    e();
    d();
  }
  
  public void a(String paramString, Object paramObject)
  {
    super.a(paramString, paramObject);
    if (this.d == null) {
      return;
    }
    if ((TextUtils.equals(paramString, "personal_page_action_title_bar_animation")) && ((paramObject instanceof Message)))
    {
      int i = ((Message)paramObject).what;
      this.a.setAlpha(i);
      this.a.setTextColor(Color.argb(i, Color.red(this.e), Color.green(this.e), Color.blue(this.e)));
      if (!FSCommonUtil.a(this.d)) {
        this.a.setVisibility(0);
      } else {
        this.a.setVisibility(8);
      }
      if (i == 0)
      {
        this.a.setVisibility(8);
        return;
      }
      if (i >= Color.alpha(this.e)) {
        this.a.setTextColor(this.e);
      }
    }
  }
  
  protected void d()
  {
    this.b.setOnClickListener(this);
  }
  
  protected void e()
  {
    this.f = ((FSPersonalViewModel)a(FSPersonalViewModel.class));
    this.f.d().observe(j(), new FSPersonTitlePart.1(this));
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == 2131436275)
    {
      if (c() != null) {
        c().finish();
      }
    }
    else if (i == 2131436455)
    {
      FSNativeLauncher.a(g(), new FSPageListBean(l()));
      FSLpReportDc11001.a(new DataBuilder(l()).setActionType(11).setSubActionType(2).setThrActionType(2));
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.part.FSPersonTitlePart
 * JD-Core Version:    0.7.0.1
 */