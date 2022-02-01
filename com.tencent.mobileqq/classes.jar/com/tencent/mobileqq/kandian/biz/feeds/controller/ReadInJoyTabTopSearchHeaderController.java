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
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.framework.CallHotwordChange;
import com.tencent.mobileqq.kandian.biz.search.entity.ReadInJoySearchWord;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport.ReportR5Builder;
import com.tencent.mobileqq.kandian.glue.report.dt.RIJDtParamBuilder;
import com.tencent.mobileqq.qroute.QRoute;
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
  private int jdField_a_of_type_Int = 1;
  protected BroadcastReceiver a;
  private Context jdField_a_of_type_AndroidContentContext;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  protected UniteSearchObserver a;
  protected HotWordSearchEntryDataModel.HotSearchItem a;
  HotWordSearchEntryDataModel jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel;
  String jdField_a_of_type_JavaLangString = "search_word_prefix_search_change_times";
  protected boolean a;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  String jdField_b_of_type_JavaLangString = "search_word_prefix_refresh_times";
  protected boolean b;
  private boolean c = false;
  
  public ReadInJoyTabTopSearchHeaderController(Context paramContext, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqAppUniteSearchObserver = new ReadInJoyTabTopSearchHeaderController.1(this);
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new ReadInJoyTabTopSearchHeaderController.7(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
    this.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131379868));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131379867));
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131363504));
    paramViewGroup = Aladdin.getConfig(182);
    if ((paramViewGroup != null) && (this.jdField_a_of_type_AndroidContentContext != null))
    {
      int i = paramViewGroup.getIntegerFromString("search_text_size", 14);
      paramViewGroup = paramViewGroup.getString("search_text_colour", "#737373");
      try
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor(paramViewGroup));
        this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor(paramViewGroup));
      }
      catch (Exception paramViewGroup)
      {
        paramViewGroup.printStackTrace();
      }
      paramViewGroup = this.jdField_a_of_type_AndroidWidgetTextView;
      float f = i;
      paramViewGroup.setTextSize(f);
      this.jdField_b_of_type_AndroidWidgetTextView.setTextSize(f);
    }
    paramViewGroup = Aladdin.getConfig(313);
    if (paramViewGroup != null) {
      SearchEntryConfigManager.jdField_b_of_type_JavaLangString = paramViewGroup.getString("SBWord_Source", "Hot_word");
    }
    ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).addObserver(this.jdField_a_of_type_ComTencentMobileqqAppUniteSearchObserver);
    b(false, -1, -1);
    paramViewGroup = new IntentFilter("mqq.intent.action.ACCOUNT_CHANGED");
    paramContext.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramViewGroup);
    f();
  }
  
  private static void a(String paramString1, String paramString2)
  {
    String str = RIJQQAppInterfaceUtil.a();
    QLog.d("ReadInJoyTabTopSearchHeaderController", 1, new Object[] { "actionName = ", paramString1, "\n", "r2 = ", str, " r5 = ", paramString2 });
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", paramString1, paramString1, 0, 0, str, "", "", paramString2, false);
  }
  
  private void f()
  {
    VideoReport.setElementId(this.jdField_a_of_type_AndroidViewViewGroup, "search_box_button");
    VideoReport.setElementParams(this.jdField_a_of_type_AndroidViewViewGroup, new RIJDtParamBuilder().a("14").a().b("search_box").c("click_search_box").a());
    VideoReport.setElementReportPolicy(this.jdField_a_of_type_AndroidViewViewGroup, ReportPolicy.REPORT_POLICY_CLICK);
  }
  
  protected void a()
  {
    HotWordSearchEntryDataModel.HotSearchItem localHotSearchItem = this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$HotSearchItem;
    if (localHotSearchItem != null)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(localHotSearchItem.title);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$HotSearchItem.title);
    }
    else
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131718623);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(2131718623);
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetTextView.setTranslationY(Utils.dp2px(43.0D));
    this.jdField_a_of_type_AndroidWidgetTextView.setTranslationY(0.0F);
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
    if (this.c) {
      return;
    }
    long l1 = ((SharedPreferences)localObject2).getLong("search_hotword_show_lasttime", 0L);
    long l2 = this.jdField_a_of_type_Int * 1000;
    if (System.currentTimeMillis() - l1 < l2) {
      return;
    }
    this.jdField_a_of_type_Int = 1;
    localObject2 = Aladdin.getConfig(313);
    if (localObject2 != null) {
      this.jdField_a_of_type_Int = ((AladdinConfig)localObject2).getIntegerFromString("SearchBox_CarouselTime", 1);
    }
    boolean bool = HotWordSearchEntryDataModel.a(10, false);
    localObject2 = this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel;
    Object localObject3;
    if ((localObject2 != null) && (((HotWordSearchEntryDataModel)localObject2).jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList != null) && (this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() != 0) && (!bool))
    {
      int i = this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size();
      this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$HotSearchItem = ((HotWordSearchEntryDataModel.HotSearchItem)this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.get(ReadInJoySearchWord.jdField_a_of_type_Int % i));
      if (!SearchEntryConfigManager.a((AppInterface)localObject1))
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131718623);
        this.jdField_b_of_type_AndroidWidgetTextView.setText(2131718623);
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$HotSearchItem.showType == 3)
      {
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$HotSearchItem.detailText;
        if (this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$HotSearchItem.showCount == 0) {
          i = 1;
        } else {
          i = this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$HotSearchItem.showCount;
        }
        bool = SearchEntryConfigManager.a((AppInterface)localObject1, (String)localObject2, i);
        if (((!ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime())) || (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$HotSearchItem.imgBgUrl))) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$HotSearchItem.imgUrl))) {}
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
        this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
        if (paramBoolean)
        {
          this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
          this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$HotSearchItem.title);
          localObject2 = ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidWidgetTextView, "translationY", new float[] { 0.0F, -Utils.dp2px(43.0D) });
          ((ObjectAnimator)localObject2).setDuration(200L);
          ((ObjectAnimator)localObject2).start();
          localObject3 = ObjectAnimator.ofFloat(this.jdField_b_of_type_AndroidWidgetTextView, "translationY", new float[] { Utils.dp2px(43.0D), 0.0F });
          ((ObjectAnimator)localObject3).setDuration(200L);
          ((ObjectAnimator)localObject3).start();
          ((ObjectAnimator)localObject2).addListener(new ReadInJoyTabTopSearchHeaderController.3(this));
        }
        else
        {
          a();
        }
      }
      ReadInJoySearchWord.jdField_a_of_type_Int += 1;
      UniteSearchReportController.a(null, new ReportModelDC02528().module("search_box").action("exp_default_word").ver2(UniteSearchReportController.a(25)).ver4(this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$HotSearchItem.title).ver7(SearchEntryConfigManager.jdField_b_of_type_JavaLangString));
      new UniteSearchHandler((QQAppInterface)localObject1).b((QQAppInterface)localObject1, "exp_default_word", "search_box", UniteSearchReportController.a(25), this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$HotSearchItem.sAppend, this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$HotSearchItem.title, SearchEntryConfigManager.jdField_b_of_type_JavaLangString);
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
        localObject3 = RIJTransMergeKanDianReport.a();
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
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131718623);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(2131718623);
    this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$HotSearchItem = null;
  }
  
  protected void b()
  {
    this.c = true;
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    ReadInJoyTabTopSearchHeaderController.2 local2 = new ReadInJoyTabTopSearchHeaderController.2(this);
    this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
    HotWordSearchEntryModel.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentImageURLImageView, this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$HotSearchItem.imgUrl, this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$HotSearchItem.imgBgUrl, local2);
    SearchEntryConfigManager.a(localQQAppInterface, BaseApplicationImpl.getContext(), this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$HotSearchItem.detailText, 0);
    UniteSearchReportController.a(null, new ReportModelDC02528().module("search_light").action("exp_search_light").ver2(UniteSearchReportController.a(25)).ver4(this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$HotSearchItem.detailText).ver7(SearchEntryConfigManager.jdField_b_of_type_JavaLangString));
    new UniteSearchHandler(localQQAppInterface).b(localQQAppInterface, "exp_search_light", "search_light", UniteSearchReportController.a(25), this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$HotSearchItem.sAppend, this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$HotSearchItem.detailText, SearchEntryConfigManager.jdField_b_of_type_JavaLangString);
  }
  
  protected void b(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel = new HotWordSearchEntryDataModel(localQQAppInterface, SearchEntryConfigManager.b(), 10, false);
    ThreadManager.post(new ReadInJoyTabTopSearchHeaderController.6(this, paramBoolean, paramInt1, paramInt2, localQQAppInterface), 5, null, true);
  }
  
  public void c()
  {
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_b_of_type_Boolean = false;
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
    this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
    this.c = false;
  }
  
  public void e()
  {
    this.jdField_b_of_type_Boolean = false;
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    localQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppUniteSearchObserver);
    this.jdField_a_of_type_AndroidContentContext.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
    this.jdField_a_of_type_Boolean = true;
    SharedPreUtils.a(localQQAppInterface.getCurrentAccountUin(), 10, 0);
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() != 2131379023) {
      return;
    }
    paramView = this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$HotSearchItem;
    if ((paramView != null) && (paramView.showType == 3)) {
      SearchEntryConfigManager.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), BaseApplicationImpl.getContext(), this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$HotSearchItem.detailText, this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$HotSearchItem.showCount);
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    Object localObject2 = new ReportModelDC02528().module("search_box").action("clk_default_word");
    paramView = this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$HotSearchItem;
    Object localObject1 = "";
    if (paramView == null) {
      paramView = "";
    } else {
      paramView = paramView.title;
    }
    paramView = ((ReportModelDC02528)localObject2).ver4(paramView);
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("{experiment_id:");
    ((StringBuilder)localObject2).append(UniteSearchReportController.jdField_b_of_type_JavaLangString);
    ((StringBuilder)localObject2).append(",source:");
    ((StringBuilder)localObject2).append(SearchEntryConfigManager.jdField_b_of_type_JavaLangString);
    ((StringBuilder)localObject2).append("}");
    UniteSearchReportController.a(localQQAppInterface, paramView.ver7(((StringBuilder)localObject2).toString()));
    UniteSearchReportController.a(null, 0, 25, "0X8009D15", 0, 0, null, null);
    localObject2 = new UniteSearchHandler(localQQAppInterface);
    String str = UniteSearchReportController.a(25);
    paramView = this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$HotSearchItem;
    if (paramView == null) {
      paramView = "";
    } else {
      paramView = paramView.sAppend;
    }
    Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$HotSearchItem;
    if (localObject3 != null) {
      localObject1 = ((HotWordSearchEntryDataModel.HotSearchItem)localObject3).title;
    }
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("{experiment_id:");
    ((StringBuilder)localObject3).append(UniteSearchReportController.jdField_b_of_type_JavaLangString);
    ((StringBuilder)localObject3).append(",source:");
    ((StringBuilder)localObject3).append(SearchEntryConfigManager.jdField_b_of_type_JavaLangString);
    ((StringBuilder)localObject3).append("}");
    ((UniteSearchHandler)localObject2).b(localQQAppInterface, "clk_default_word", "search_box", str, paramView, (String)localObject1, ((StringBuilder)localObject3).toString());
    this.jdField_a_of_type_Int = 1;
    paramView = null;
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel;
    if (localObject1 != null) {
      paramView = ((HotWordSearchEntryDataModel)localObject1).jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$GIFInfo;
    }
    UniteSearchActivity.a((Activity)this.jdField_a_of_type_AndroidContentContext, null, 25, 0L, this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$HotSearchItem, 0, paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.controller.ReadInJoyTabTopSearchHeaderController
 * JD-Core Version:    0.7.0.1
 */