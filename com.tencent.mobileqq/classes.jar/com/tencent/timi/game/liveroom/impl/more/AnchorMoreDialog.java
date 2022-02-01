package com.tencent.timi.game.liveroom.impl.more;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.datareport.api.ILiveReportService;
import com.tencent.timi.game.liveroom.impl.inscription.LivingInscriptionSettingHelper;
import com.tencent.timi.game.liveroom.impl.inscription.LivingInscriptionSettingListener;
import com.tencent.timi.game.liveroom.impl.notice.TimiNoticeDialog;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.ui.widget.BaseSlideUpDialog;
import com.tencent.timi.game.ui.widget.CustomToastView;
import com.tencent.timi.game.utils.ThreadPool;
import java.util.concurrent.ConcurrentHashMap;

public class AnchorMoreDialog
  extends BaseSlideUpDialog
  implements View.OnClickListener
{
  private long a;
  private int b;
  private boolean c = false;
  private LivingInscriptionSettingHelper d;
  private LivingInscriptionSettingListener i;
  private View j;
  private View k;
  private View l;
  private View m;
  private View n;
  
  public AnchorMoreDialog(Context paramContext)
  {
    super(paramContext);
  }
  
  public static AnchorMoreDialog a(Context paramContext, long paramLong, int paramInt, boolean paramBoolean, LivingInscriptionSettingListener paramLivingInscriptionSettingListener)
  {
    if (paramContext == null)
    {
      CustomToastView.a("参数为空");
      return null;
    }
    paramContext = AnchorMoreDialog.Builder.a(paramContext, paramLong, paramInt, paramBoolean).a();
    paramContext.i = paramLivingInscriptionSettingListener;
    paramContext.b(false);
    paramContext.show();
    return paramContext;
  }
  
  private ConcurrentHashMap<String, String> a()
  {
    ConcurrentHashMap localConcurrentHashMap = new ConcurrentHashMap();
    localConcurrentHashMap.put("zengzhi_moduleid", "em_qqlive_morefunction_entrance");
    return localConcurrentHashMap;
  }
  
  private void c(boolean paramBoolean)
  {
    String str;
    if (paramBoolean) {
      str = "imp";
    } else {
      str = "imp_end";
    }
    ConcurrentHashMap localConcurrentHashMap = a();
    ((ILiveReportService)ServiceCenter.a(ILiveReportService.class)).a(str, this.j, localConcurrentHashMap);
    ((ILiveReportService)ServiceCenter.a(ILiveReportService.class)).a(str, this.k, localConcurrentHashMap);
    ((ILiveReportService)ServiceCenter.a(ILiveReportService.class)).a(str, this.l, localConcurrentHashMap);
    ((ILiveReportService)ServiceCenter.a(ILiveReportService.class)).a(str, this.m, localConcurrentHashMap);
    ((ILiveReportService)ServiceCenter.a(ILiveReportService.class)).a(str, this.n, localConcurrentHashMap);
  }
  
  private void d(boolean paramBoolean)
  {
    View localView = findViewById(2131428325);
    int i2 = 0;
    int i1;
    if (paramBoolean) {
      i1 = 0;
    } else {
      i1 = 8;
    }
    localView.setVisibility(i1);
    localView = findViewById(2131428331);
    if (paramBoolean) {
      i1 = i2;
    } else {
      i1 = 8;
    }
    localView.setVisibility(i1);
  }
  
  public void a(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void a(long paramLong)
  {
    this.a = paramLong;
  }
  
  public void a(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  public void dismiss()
  {
    c(false);
    super.dismiss();
  }
  
  public void onClick(View paramView)
  {
    int i1 = paramView.getId();
    if (i1 == 2131428323) {
      dismiss();
    } else if (i1 != 2131428324) {
      if (i1 == 2131428328)
      {
        AnchorRoomSettingFragment.a(this.e, this.a);
        dismiss();
      }
      else if (i1 == 2131428329)
      {
        Context localContext = this.e;
        long l1 = this.a;
        dismiss();
        ThreadPool.a(new AnchorMoreDialog.1(this, localContext, l1), 300L);
      }
      else if (i1 == 2131428325)
      {
        if (this.d == null) {
          this.d = new LivingInscriptionSettingHelper();
        }
        this.d.a(this.e, this.a, this.b, this.i);
        dismiss();
      }
      else if (i1 == 2131428327)
      {
        TimiNoticeDialog.a(this.e, this.a);
        dismiss();
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131629409);
    findViewById(2131428324).setOnClickListener(this);
    findViewById(2131428323).setOnClickListener(this);
    this.k = findViewById(2131428325);
    this.l = findViewById(2131428329);
    this.m = findViewById(2131428328);
    this.n = findViewById(2131428327);
    this.k.setOnClickListener(this);
    this.l.setOnClickListener(this);
    this.m.setOnClickListener(this);
    this.n.setOnClickListener(this);
    d(this.c);
    this.j = findViewById(2131428324);
    b(this.j);
    s();
    paramBundle = AnchorMoreSettingUtil.a(this.a);
    paramBundle.put("qqlive_coming_way", "");
    ((ILiveReportService)ServiceCenter.a(ILiveReportService.class)).a(this.j, "pg_qqlive_anchorlive", paramBundle);
    paramBundle = a();
    ((ILiveReportService)ServiceCenter.a(ILiveReportService.class)).b(this.j, true, null, "em_qqlive_morefunction_board", paramBundle);
    ((ILiveReportService)ServiceCenter.a(ILiveReportService.class)).b(this.k, true, null, "em_qqlive_equipshow_entrance", paramBundle);
    ((ILiveReportService)ServiceCenter.a(ILiveReportService.class)).b(this.l, true, null, "em_qqlive_share", paramBundle);
    ((ILiveReportService)ServiceCenter.a(ILiveReportService.class)).b(this.m, true, null, "em_qqlive_roomset_entrance", paramBundle);
    ((ILiveReportService)ServiceCenter.a(ILiveReportService.class)).b(this.n, true, null, "em_qqlive_announceset_entrance", paramBundle);
    c(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.more.AnchorMoreDialog
 * JD-Core Version:    0.7.0.1
 */