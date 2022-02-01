package com.tencent.mobileqq.winkpublish.part;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.BasePartFragment;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.winkpublish.api.IPublishLauncher;
import com.tencent.mobileqq.winkpublish.api.IUploadLocalConfig;
import com.tencent.mobileqq.winkpublish.base.BaseBlockPart;
import com.tencent.mobileqq.winkpublish.common.AUploadCommonSetting;
import com.tencent.mobileqq.winkpublish.common.UploadConstants;
import com.tencent.mobileqq.winkpublish.event.PublishKeyboardEvent;
import com.tencent.mobileqq.winkpublish.viewmodel.PublishJurisdictionViewModel;
import com.tencent.mobileqq.winkpublish.viewmodel.PublishViewModel;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.mobileqq.winkreport.datong.WinkDatongCurrentParams;
import com.tencent.mobileqq.winkreport.datong.WinkNativeSessionManager;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;
import cooperation.qqcircle.report.QCirclePublishQualityReporter;
import cooperation.qqcircle.report.QCircleReportHelper;
import feedcloud.FeedCloudCommon.Entry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public class PublishTitlePart
  extends BaseBlockPart
  implements View.OnClickListener, SimpleEventReceiver
{
  public static final String a;
  protected ActionSheet b;
  private PublishViewModel e;
  private PublishJurisdictionViewModel f;
  private ImageView g;
  private TextView h;
  private boolean i = false;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(UploadConstants.a);
    localStringBuilder.append("FSTitlePart");
    a = localStringBuilder.toString();
  }
  
  private void a(BasePartFragment paramBasePartFragment)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private void a(String paramString, View paramView)
  {
    new WinkDTParamBuilder();
    Map localMap = WinkDTParamBuilder.buildElementParams();
    localMap.put("xsj_camera_session_id", WinkNativeSessionManager.g().getCameraSessionId());
    localMap.put("xsj_operation_activity_id", WinkDatongCurrentParams.getMap().get("xsj_operation_activity_id"));
    localMap.put("xsj_camera_clck_ref_pgid", WinkDatongCurrentParams.getMap().get("xsj_camera_clck_ref_pgid"));
    localMap.put("xsj_eid", paramString);
    VideoReport.setElementId(paramView, paramString);
    VideoReport.reportEvent("ev_xsj_camera_action", paramView, localMap);
  }
  
  private void e()
  {
    if (this.e == null) {
      this.e = ((PublishViewModel)a(PublishViewModel.class));
    }
    this.e.f.observe(j(), new PublishTitlePart.1(this));
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    this.g = ((ImageView)paramView.findViewById(2131441719));
    this.h = ((TextView)paramView.findViewById(2131441820));
    this.g.setOnClickListener(this);
    this.h.setOnClickListener(this);
    this.h.setEnabled(false);
    this.f = ((PublishJurisdictionViewModel)a(PublishJurisdictionViewModel.class));
    e();
  }
  
  public boolean ah_()
  {
    if ((!this.e.f()) && (!this.e.e())) {
      return false;
    }
    if ((!this.e.k()) && (!this.f.c))
    {
      d();
      return true;
    }
    return false;
  }
  
  public void d()
  {
    if (j().getActivity() == null) {
      return;
    }
    if (j().getActivity() == null) {
      return;
    }
    ActionSheet localActionSheet = this.b;
    if ((localActionSheet != null) && (localActionSheet.isShowing())) {
      return;
    }
    int j = c().getIntent().getIntExtra("PUBLISH_ENTRANCE", -1);
    this.b = ActionSheet.create(((IPublishLauncher)QRoute.api(IPublishLauncher.class)).getHostContext(c()));
    if (this.e.e()) {
      if (j == 3)
      {
        this.b.setMainTitle(2131895865);
        this.b.addButton(2131895867, 1);
        this.b.addButton(2131895862, 1);
      }
      else
      {
        this.b.setMainTitle(2131895864);
        this.b.addButton(2131895860, 1);
        this.b.addButton(2131895867, 1);
      }
    }
    this.b.addCancelButton(2131887648);
    this.b.setOnButtonClickListener(new PublishTitlePart.2(this, j));
    if ((!c().isFinishing()) && (!this.b.isShowing())) {
      this.b.show();
    }
  }
  
  public ArrayList<Class> getEventClass()
  {
    return new ArrayList();
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
    int j = paramView.getId();
    if (j == 2131441719)
    {
      SimpleEventBus.getInstance().dispatchEvent(new PublishKeyboardEvent(false));
      if ((!this.e.f()) && (!this.e.e()))
      {
        AUploadCommonSetting.a().uploadQualityReport(QCirclePublishQualityReporter.E_PUBLIC_EXIT_CANCEL, Arrays.asList(new FeedCloudCommon.Entry[] { QCircleReportHelper.newEntry("traceid", this.e.y), QCircleReportHelper.newEntry("ext1", "nothingSave"), QCircleReportHelper.newEntry("ret_code", "0") }));
        c().finish();
      }
      else
      {
        d();
      }
    }
    else if ((j == 2131441820) && (!this.i))
    {
      this.i = true;
      this.e.a(j());
      SimpleEventBus.getInstance().dispatchEvent(new PublishKeyboardEvent(false));
      a(j());
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.part.PublishTitlePart
 * JD-Core Version:    0.7.0.1
 */