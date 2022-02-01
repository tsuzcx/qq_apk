package com.tencent.mobileqq.winkpublish.part;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.qcircle.api.data.Option;
import com.tencent.mobileqq.qcircle.api.helper.HostUIHelper;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.winkpublish.api.IUploadLocalConfig;
import com.tencent.mobileqq.winkpublish.base.BaseBlockPart;
import com.tencent.mobileqq.winkpublish.common.AUploadCommonSetting;
import com.tencent.mobileqq.winkpublish.common.UploadConstants;
import com.tencent.mobileqq.winkpublish.event.PublishMediaDeleteEvent;
import com.tencent.mobileqq.winkpublish.model.DynamicArrayList;
import com.tencent.mobileqq.winkpublish.view.RoundCornerImageView;
import com.tencent.mobileqq.winkpublish.viewmodel.PublishViewModel;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.report.QCirclePublishQualityReporter;
import cooperation.qqcircle.report.QCircleReportHelper;
import feedcloud.FeedCloudCommon.Entry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class PublishMediaPart
  extends BaseBlockPart
  implements View.OnClickListener, SimpleEventReceiver
{
  public static final String a;
  private PublishViewModel b;
  private RoundCornerImageView e;
  private RoundCornerImageView f;
  private RoundCornerImageView g;
  private ImageView h;
  private ImageView i;
  private RelativeLayout j;
  private TextView k;
  private boolean l = false;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(UploadConstants.a);
    localStringBuilder.append("PublishMediaPart");
    a = localStringBuilder.toString();
  }
  
  private void a(LocalMediaInfo paramLocalMediaInfo)
  {
    this.l = true;
    a(paramLocalMediaInfo.thumbnailPath, this.f);
    if (this.b.b(paramLocalMediaInfo.path)) {
      this.j.setVisibility(0);
    } else {
      this.j.setVisibility(8);
    }
    this.i.setVisibility(0);
    this.g.setVisibility(8);
    this.h.setVisibility(8);
  }
  
  private void a(HashMap<String, LocalMediaInfo> paramHashMap, DynamicArrayList<String> paramDynamicArrayList, LocalMediaInfo paramLocalMediaInfo)
  {
    this.l = false;
    if ((paramDynamicArrayList.size() > 1) && (paramHashMap.get(paramDynamicArrayList.get(1)) != null))
    {
      paramHashMap = (LocalMediaInfo)paramHashMap.get(paramDynamicArrayList.get(1));
      this.e.setVisibility(0);
      a(paramHashMap.path, this.e);
      this.i.setVisibility(8);
      this.j.setVisibility(8);
      this.k.setVisibility(0);
      this.k.setText(String.valueOf(paramDynamicArrayList.size()));
    }
    else
    {
      this.e.setVisibility(8);
      this.i.setVisibility(8);
      this.j.setVisibility(8);
      this.k.setVisibility(8);
    }
    this.g.setVisibility(8);
    this.h.setVisibility(8);
    a(paramLocalMediaInfo.path, this.f);
  }
  
  private void d()
  {
    if (this.b == null) {
      this.b = ((PublishViewModel)a(PublishViewModel.class));
    }
    this.b.b.observe(j(), new PublishMediaPart.1(this));
    this.b.c.observe(j(), new PublishMediaPart.2(this));
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    HostUIHelper.closeHostEnvironment();
    QLog.d(a, 1, new Object[] { "onActivityResult... requestCode:", Integer.valueOf(paramInt1), " resultCode:", Integer.valueOf(paramInt2) });
    if (paramIntent != null) {
      this.b.l = paramIntent.getStringExtra("key_ae_editor_from_photo_picker_tab");
    }
    if ((20000 == paramInt1) && (paramInt2 == 0) && (this.b.J) && ((this.b.g.size() == 0) || (this.b.o)))
    {
      this.b.o = false;
      AUploadCommonSetting.a().uploadQualityReport(QCirclePublishQualityReporter.E_PICKER_EXIT_CANCEL, Arrays.asList(new FeedCloudCommon.Entry[] { QCircleReportHelper.newEntry("traceid", this.b.y), QCircleReportHelper.newEntry("ext1", String.valueOf(this.b.m)), QCircleReportHelper.newEntry("ret_code", "0") }));
      c().finish();
      return;
    }
    if ((20000 == paramInt1) && (paramInt2 == -1))
    {
      AUploadCommonSetting.a().uploadQualityReport(QCirclePublishQualityReporter.E_PICKER_EXIT_NORMAL, Arrays.asList(new FeedCloudCommon.Entry[] { QCircleReportHelper.newEntry("traceid", this.b.y), QCircleReportHelper.newEntry("ext1", String.valueOf(this.b.m)), QCircleReportHelper.newEntry("ret_code", "0") }));
      if (paramIntent.getBooleanExtra("key_qcircle_pulish_use_draft", false)) {
        this.b.a(j(), this.b.g());
      } else {
        this.b.a(paramIntent);
      }
    }
    else if ((paramInt1 == 8) && (paramInt2 == -1))
    {
      this.b.c(paramIntent);
    }
    else if ((paramInt1 == 10078) && (paramInt2 == -1))
    {
      this.b.b(paramIntent);
      this.b.i();
    }
    this.b.o = false;
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    b(paramView);
    d();
  }
  
  protected void a(String paramString, ImageView paramImageView)
  {
    Object localObject = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setImageView... url:");
    localStringBuilder.append(paramString);
    QLog.d((String)localObject, 1, localStringBuilder.toString());
    if (paramImageView.getVisibility() != 0) {
      paramImageView.setVisibility(0);
    }
    localObject = new Option();
    ((Option)localObject).setUrl(paramString).setTargetView(paramImageView).setPredecode(true).setRequestWidth(ViewUtils.dip2px(105.0F)).setRequestHeight(ViewUtils.dip2px(105.0F));
    QCircleFeedPicLoader.g().loadImage((Option)localObject, null);
  }
  
  protected void b(View paramView)
  {
    this.e = ((RoundCornerImageView)paramView.findViewById(2131441814));
    this.f = ((RoundCornerImageView)paramView.findViewById(2131441815));
    this.i = ((ImageView)paramView.findViewById(2131441822));
    this.j = ((RelativeLayout)paramView.findViewById(2131441801));
    this.k = ((TextView)paramView.findViewById(2131441810));
    this.h = ((ImageView)paramView.findViewById(2131441799));
    this.g = ((RoundCornerImageView)paramView.findViewById(2131441813));
    this.g.setCorner(ViewUtils.dip2px(4.0F), ViewUtils.dip2px(4.0F), ViewUtils.dip2px(4.0F), ViewUtils.dip2px(4.0F));
    this.e.setCorner(ViewUtils.dip2px(4.0F), ViewUtils.dip2px(4.0F), ViewUtils.dip2px(4.0F), ViewUtils.dip2px(4.0F));
    this.f.setCorner(ViewUtils.dip2px(4.0F), ViewUtils.dip2px(4.0F), ViewUtils.dip2px(4.0F), ViewUtils.dip2px(4.0F));
    this.f.setOnClickListener(this);
    this.j.setOnClickListener(this);
    this.g.setOnClickListener(this);
    this.h.setOnClickListener(this);
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(PublishMediaDeleteEvent.class);
    return localArrayList;
  }
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    super.onActivityCreated(paramActivity, paramBundle);
    SimpleEventBus.getInstance().registerReceiver(this);
  }
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    SimpleEventBus.getInstance().unRegisterReceiver(this);
    super.onActivityDestroyed(paramActivity);
  }
  
  public void onActivityPaused(Activity paramActivity)
  {
    super.onActivityPaused(paramActivity);
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    super.onActivityResumed(paramActivity);
  }
  
  public void onClick(View paramView)
  {
    if ((paramView.getId() != 2131441815) && (paramView.getId() != 2131441813) && (paramView.getId() != 2131441799))
    {
      if (paramView.getId() == 2131441801) {
        this.b.c(c());
      }
    }
    else
    {
      PublishViewModel localPublishViewModel = this.b;
      localPublishViewModel.J = false;
      if (this.l) {
        localPublishViewModel.a(c());
      } else {
        localPublishViewModel.b(c());
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof PublishMediaDeleteEvent))
    {
      int m = ((PublishMediaDeleteEvent)paramSimpleBaseEvent).position;
      this.b.a(m);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.part.PublishMediaPart
 * JD-Core Version:    0.7.0.1
 */