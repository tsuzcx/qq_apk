package com.tencent.mobileqq.kandian.biz.feeds.controller;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Color;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.UniteSearchHandler;
import com.tencent.mobileqq.app.UniteSearchObserver;
import com.tencent.mobileqq.kandian.base.utils.RIJLogUtil;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.framework.CallHotwordChange;
import com.tencent.mobileqq.kandian.biz.search.entity.ReadInJoySearchWord;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport.ReportR5Builder;
import com.tencent.mobileqq.kandian.glue.report.dt.RIJDtParamBuilder;
import com.tencent.mobileqq.search.HotWordSearchEntryModel;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.base.api.SearchEntryConfigManager;
import com.tencent.mobileqq.search.model.HotWordSearchEntryDataModel;
import com.tencent.mobileqq.search.model.HotWordSearchEntryDataModel.HotSearchItem;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.mobileqq.search.report.UniteSearchReportController;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ReportPolicy;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.os.MqqHandler;
import org.json.JSONException;

public class ReadInJoyTabTopSearchHeaderController
  implements View.OnClickListener, CallHotwordChange
{
  protected boolean a = false;
  HotWordSearchEntryDataModel b;
  protected UniteSearchObserver c = new ReadInJoyTabTopSearchHeaderController.1(this);
  protected HotWordSearchEntryDataModel.HotSearchItem d;
  protected boolean e = true;
  String f = "search_word_prefix_search_change_times";
  String g = "search_word_prefix_refresh_times";
  protected BroadcastReceiver h = new ReadInJoyTabTopSearchHeaderController.7(this);
  private Context i;
  private ViewGroup j;
  private TextView k;
  private TextView l;
  private URLImageView m;
  private boolean n = false;
  private int o = 1;
  
  public ReadInJoyTabTopSearchHeaderController(Context paramContext, ViewGroup paramViewGroup)
  {
    this.i = paramContext;
    this.j = paramViewGroup;
    this.j.setOnClickListener(this);
    this.k = ((TextView)this.j.findViewById(2131448726));
    this.l = ((TextView)this.j.findViewById(2131448725));
    this.m = ((URLImageView)this.j.findViewById(2131429406));
    paramViewGroup = Aladdin.getConfig(182);
    if ((paramViewGroup != null) && (this.i != null))
    {
      int i1 = paramViewGroup.getIntegerFromString("search_text_size", 14);
      paramViewGroup = paramViewGroup.getString("search_text_colour", "#737373");
      try
      {
        this.k.setTextColor(Color.parseColor(paramViewGroup));
        this.l.setTextColor(Color.parseColor(paramViewGroup));
      }
      catch (Exception paramViewGroup)
      {
        paramViewGroup.printStackTrace();
      }
      paramViewGroup = this.k;
      float f1 = i1;
      paramViewGroup.setTextSize(f1);
      this.l.setTextSize(f1);
    }
    paramViewGroup = Aladdin.getConfig(313);
    if (paramViewGroup != null) {
      SearchEntryConfigManager.c = paramViewGroup.getString("SBWord_Source", "Hot_word");
    }
    ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).addObserver(this.c);
    b(false, -1, -1);
    paramViewGroup = new IntentFilter("mqq.intent.action.ACCOUNT_CHANGED");
    paramContext.registerReceiver(this.h, paramViewGroup);
    f();
  }
  
  private static void a(String paramString1, String paramString2)
  {
    String str = RIJQQAppInterfaceUtil.d();
    QLog.d("ReadInJoyTabTopSearchHeaderController", 1, new Object[] { "actionName = ", paramString1, "\n", "r2 = ", RIJLogUtil.a.a(str), " r5 = ", paramString2 });
    PublicAccountReportUtils.a(null, "", paramString1, paramString1, 0, 0, str, "", "", paramString2, false);
  }
  
  private void f()
  {
    VideoReport.setElementId(this.j, "search_box_button");
    VideoReport.setElementParams(this.j, new RIJDtParamBuilder().a("14").a().b("search_box").c("click_search_box").c());
    VideoReport.setElementReportPolicy(this.j, ReportPolicy.REPORT_POLICY_CLICK);
  }
  
  protected void a()
  {
    HotWordSearchEntryDataModel.HotSearchItem localHotSearchItem = this.d;
    if (localHotSearchItem != null)
    {
      this.l.setText(localHotSearchItem.title);
      this.k.setText(this.d.title);
    }
    else
    {
      this.k.setText(2131916124);
      this.l.setText(2131916124);
    }
    this.l.setVisibility(8);
    this.k.setVisibility(0);
    this.l.setTranslationY(Utils.dp2px(43.0D));
    this.k.setTranslationY(0.0F);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 != 2) {
      ThreadManager.getUIHandler().postDelayed(new ReadInJoyTabTopSearchHeaderController.5(this, paramInt1, paramInt2), 200L);
    }
  }
  
  protected void a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    Object localObject1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    Object localObject2 = PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext());
    if (this.n) {
      return;
    }
    long l1 = ((SharedPreferences)localObject2).getLong("search_hotword_show_lasttime", 0L);
    long l2 = this.o * 1000;
    if (System.currentTimeMillis() - l1 < l2) {
      return;
    }
    this.o = 1;
    localObject2 = Aladdin.getConfig(313);
    if (localObject2 != null) {
      this.o = ((AladdinConfig)localObject2).getIntegerFromString("SearchBox_CarouselTime", 1);
    }
    boolean bool = HotWordSearchEntryDataModel.a(10, false);
    localObject2 = this.b;
    Object localObject3;
    if ((localObject2 != null) && (((HotWordSearchEntryDataModel)localObject2).b != null) && (this.b.b.size() != 0) && (!bool))
    {
      int i1 = this.b.b.size();
      this.d = ((HotWordSearchEntryDataModel.HotSearchItem)this.b.b.get(ReadInJoySearchWord.a % i1));
      if (!SearchEntryConfigManager.a((AppInterface)localObject1))
      {
        this.k.setText(2131916124);
        this.l.setText(2131916124);
        return;
      }
      if (this.d.showType == 3)
      {
        localObject2 = this.d.detailText;
        if (this.d.showCount == 0) {
          i1 = 1;
        } else {
          i1 = this.d.showCount;
        }
        bool = SearchEntryConfigManager.a((AppInterface)localObject1, (String)localObject2, i1);
        if (((!ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime())) || (!TextUtils.isEmpty(this.d.imgBgUrl))) && (!TextUtils.isEmpty(this.d.imgUrl))) {}
      }
      else
      {
        bool = false;
      }
      if (bool)
      {
        b();
      }
      else
      {
        this.m.setVisibility(8);
        if (paramBoolean)
        {
          this.l.setVisibility(0);
          this.k.setVisibility(0);
          this.l.setText(this.d.title);
          localObject2 = ObjectAnimator.ofFloat(this.k, "translationY", new float[] { 0.0F, -Utils.dp2px(43.0D) });
          ((ObjectAnimator)localObject2).setDuration(200L);
          ((ObjectAnimator)localObject2).start();
          localObject3 = ObjectAnimator.ofFloat(this.l, "translationY", new float[] { Utils.dp2px(43.0D), 0.0F });
          ((ObjectAnimator)localObject3).setDuration(200L);
          ((ObjectAnimator)localObject3).start();
          ((ObjectAnimator)localObject2).addListener(new ReadInJoyTabTopSearchHeaderController.3(this));
        }
        else
        {
          a();
        }
      }
      ReadInJoySearchWord.a += 1;
      UniteSearchReportController.a(null, new ReportModelDC02528().module("search_box").action("exp_default_word").ver2(UniteSearchReportController.a(25)).ver4(this.d.title).ver7(SearchEntryConfigManager.c));
      new UniteSearchHandler((QQAppInterface)localObject1).b((QQAppInterface)localObject1, "exp_default_word", "search_box", UniteSearchReportController.a(25), this.d.sAppend, this.d.title, SearchEntryConfigManager.c);
      if ((paramInt1 != -1) && (paramInt2 != -1))
      {
        localObject3 = new ReportModelDC02528().module("hot_list").action("feeds_hotword_wording");
        localObject2 = "1";
        if (paramInt1 == 0) {
          localObject1 = "1";
        } else {
          localObject1 = "2";
        }
        localObject1 = ((ReportModelDC02528)localObject3).ver1((String)localObject1);
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(paramInt2);
        ((StringBuilder)localObject3).append("");
        UniteSearchReportController.a(null, ((ReportModelDC02528)localObject1).obj3(((StringBuilder)localObject3).toString()));
        localObject3 = RIJTransMergeKanDianReport.g();
      }
    }
    try
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramInt2);
      ((StringBuilder)localObject1).append("");
      ((RIJTransMergeKanDianReport.ReportR5Builder)localObject3).addString("channelid", ((StringBuilder)localObject1).toString());
      if (paramInt1 != 0) {
        break label800;
      }
      localObject1 = localObject2;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        continue;
        String str = "2";
      }
    }
    ((RIJTransMergeKanDianReport.ReportR5Builder)localObject3).addString("refresh_way", (String)localObject1);
    a("0X800A4C5", ((RIJTransMergeKanDianReport.ReportR5Builder)localObject3).build());
    PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext()).edit().putLong("search_hotword_show_lasttime", System.currentTimeMillis()).commit();
    return;
    this.k.setText(2131916124);
    this.l.setText(2131916124);
    this.d = null;
  }
  
  protected void b()
  {
    this.n = true;
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    ReadInJoyTabTopSearchHeaderController.2 local2 = new ReadInJoyTabTopSearchHeaderController.2(this);
    this.m.setVisibility(8);
    HotWordSearchEntryModel.a(this.i, this.m, this.d.imgUrl, this.d.imgBgUrl, local2);
    SearchEntryConfigManager.a(localQQAppInterface, BaseApplicationImpl.getContext(), this.d.detailText, 0);
    UniteSearchReportController.a(null, new ReportModelDC02528().module("search_light").action("exp_search_light").ver2(UniteSearchReportController.a(25)).ver4(this.d.detailText).ver7(SearchEntryConfigManager.c));
    new UniteSearchHandler(localQQAppInterface).b(localQQAppInterface, "exp_search_light", "search_light", UniteSearchReportController.a(25), this.d.sAppend, this.d.detailText, SearchEntryConfigManager.c);
  }
  
  protected void b(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    this.b = new HotWordSearchEntryDataModel(localQQAppInterface, SearchEntryConfigManager.d(), 10, false);
    ThreadManager.post(new ReadInJoyTabTopSearchHeaderController.6(this, paramBoolean, paramInt1, paramInt2, localQQAppInterface), 5, null, true);
  }
  
  public void c()
  {
    if (this.e)
    {
      this.e = false;
    }
    else
    {
      ThreadManager.getUIHandler().postDelayed(new ReadInJoyTabTopSearchHeaderController.4(this), 400L);
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      new UniteSearchHandler(localQQAppInterface).a(localQQAppInterface, 10);
    }
    AbstractGifImage.resumeAll();
  }
  
  public void d()
  {
    AbstractGifImage.pauseAll();
    this.m.setVisibility(8);
    this.n = false;
  }
  
  public void e()
  {
    this.e = false;
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    localQQAppInterface.removeObserver(this.c);
    this.i.unregisterReceiver(this.h);
    this.a = true;
    SharedPreUtils.a(localQQAppInterface.getCurrentAccountUin(), 10, 0);
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() != 2131447745) {
      return;
    }
    paramView = this.d;
    if ((paramView != null) && (paramView.showType == 3)) {
      SearchEntryConfigManager.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), BaseApplicationImpl.getContext(), this.d.detailText, this.d.showCount);
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    Object localObject2 = new ReportModelDC02528().module("search_box").action("clk_default_word");
    paramView = this.d;
    Object localObject1 = "";
    if (paramView == null) {
      paramView = "";
    } else {
      paramView = paramView.title;
    }
    paramView = ((ReportModelDC02528)localObject2).ver4(paramView);
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("{experiment_id:");
    ((StringBuilder)localObject2).append(UniteSearchReportController.b);
    ((StringBuilder)localObject2).append(",source:");
    ((StringBuilder)localObject2).append(SearchEntryConfigManager.c);
    ((StringBuilder)localObject2).append("}");
    UniteSearchReportController.a(localQQAppInterface, paramView.ver7(((StringBuilder)localObject2).toString()));
    UniteSearchReportController.a(null, 0, 25, "0X8009D15", 0, 0, null, null);
    localObject2 = new UniteSearchHandler(localQQAppInterface);
    String str = UniteSearchReportController.a(25);
    paramView = this.d;
    if (paramView == null) {
      paramView = "";
    } else {
      paramView = paramView.sAppend;
    }
    Object localObject3 = this.d;
    if (localObject3 != null) {
      localObject1 = ((HotWordSearchEntryDataModel.HotSearchItem)localObject3).title;
    }
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("{experiment_id:");
    ((StringBuilder)localObject3).append(UniteSearchReportController.b);
    ((StringBuilder)localObject3).append(",source:");
    ((StringBuilder)localObject3).append(SearchEntryConfigManager.c);
    ((StringBuilder)localObject3).append("}");
    ((UniteSearchHandler)localObject2).b(localQQAppInterface, "clk_default_word", "search_box", str, paramView, (String)localObject1, ((StringBuilder)localObject3).toString());
    this.o = 1;
    paramView = null;
    localObject1 = this.b;
    if (localObject1 != null) {
      paramView = ((HotWordSearchEntryDataModel)localObject1).d;
    }
    UniteSearchActivity.a((Activity)this.i, null, 25, 0L, this.d, 0, paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.controller.ReadInJoyTabTopSearchHeaderController
 * JD-Core Version:    0.7.0.1
 */