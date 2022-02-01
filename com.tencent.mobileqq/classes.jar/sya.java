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
import com.tencent.biz.pubaccount.readinjoy.view.headers.ReadInJoyTabTopSearchHeaderController.4;
import com.tencent.biz.pubaccount.readinjoy.view.headers.ReadInJoyTabTopSearchHeaderController.5;
import com.tencent.biz.pubaccount.readinjoy.view.headers.ReadInJoyTabTopSearchHeaderController.6;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.model.HotWordSearchEntryDataModel;
import com.tencent.mobileqq.search.model.HotWordSearchEntryDataModel.GIFInfo;
import com.tencent.mobileqq.search.model.HotWordSearchEntryDataModel.HotSearchItem;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ReportPolicy;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.os.MqqHandler;
import org.json.JSONException;

public class sya
  implements View.OnClickListener, sqh
{
  public static int a;
  protected BroadcastReceiver a;
  private Context jdField_a_of_type_AndroidContentContext;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  protected andt a;
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  protected HotWordSearchEntryDataModel.HotSearchItem a;
  public HotWordSearchEntryDataModel a;
  public String a;
  public boolean a;
  private int jdField_b_of_type_Int = 1;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  public String b;
  protected boolean b;
  private boolean c;
  
  public sya(Context paramContext, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_Andt = new syb(this);
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_JavaLangString = "search_word_prefix_search_change_times";
    this.jdField_b_of_type_JavaLangString = "search_word_prefix_refresh_times";
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new sye(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
    this.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131379821));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131379820));
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131363425));
    paramViewGroup = Aladdin.getConfig(182);
    int i;
    if ((paramViewGroup != null) && (this.jdField_a_of_type_AndroidContentContext != null))
    {
      i = paramViewGroup.getIntegerFromString("search_text_size", 14);
      paramViewGroup = paramViewGroup.getString("search_text_colour", "#737373");
    }
    try
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor(paramViewGroup));
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor(paramViewGroup));
      this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(i);
      this.jdField_b_of_type_AndroidWidgetTextView.setTextSize(i);
      paramViewGroup = Aladdin.getConfig(313);
      if (paramViewGroup != null) {
        bass.jdField_b_of_type_JavaLangString = paramViewGroup.getString("SBWord_Source", "Hot_word");
      }
      ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).addObserver(this.jdField_a_of_type_Andt);
      b(false, -1, -1);
      paramViewGroup = new IntentFilter("mqq.intent.action.ACCOUNT_CHANGED");
      paramContext.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramViewGroup);
      f();
      return;
    }
    catch (Exception paramViewGroup)
    {
      for (;;)
      {
        paramViewGroup.printStackTrace();
      }
    }
  }
  
  private static void a(String paramString1, String paramString2)
  {
    String str = pay.a();
    QLog.d("ReadInJoyTabTopSearchHeaderController", 1, new Object[] { "actionName = ", paramString1, "\n", "r2 = ", str, " r5 = ", paramString2 });
    odq.a(null, "", paramString1, paramString1, 0, 0, str, "", "", paramString2, false);
  }
  
  private void f()
  {
    VideoReport.setElementId(this.jdField_a_of_type_AndroidViewViewGroup, "search_box_button");
    VideoReport.setElementParams(this.jdField_a_of_type_AndroidViewViewGroup, new pil().a("14").a().b("search_box").c("click_search_box").a());
    VideoReport.setElementReportPolicy(this.jdField_a_of_type_AndroidViewViewGroup, ReportPolicy.REPORT_POLICY_CLICK);
  }
  
  protected void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$HotSearchItem != null)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$HotSearchItem.title);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$HotSearchItem.title);
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setTranslationY(Utils.dp2px(43.0D));
      this.jdField_a_of_type_AndroidWidgetTextView.setTranslationY(0.0F);
      return;
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131718003);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(2131718003);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 != 2) {
      ThreadManager.getUIHandler().postDelayed(new ReadInJoyTabTopSearchHeaderController.5(this, paramInt1, paramInt2), 200L);
    }
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    Object localObject1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    Object localObject2 = PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext());
    if (this.c) {}
    long l1;
    long l2;
    do
    {
      return;
      l1 = ((SharedPreferences)localObject2).getLong("search_hotword_show_lasttime", 0L);
      l2 = this.jdField_b_of_type_Int * 1000;
    } while (System.currentTimeMillis() - l1 < l2);
    this.jdField_b_of_type_Int = 1;
    localObject2 = Aladdin.getConfig(313);
    if (localObject2 != null) {
      this.jdField_b_of_type_Int = ((AladdinConfig)localObject2).getIntegerFromString("SearchBox_CarouselTime", 1);
    }
    boolean bool = HotWordSearchEntryDataModel.a(10, false);
    if ((this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel == null) || (this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList == null) || (this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() == 0) || (bool))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131718003);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(2131718003);
      this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$HotSearchItem = null;
      return;
    }
    int i = this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size();
    this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$HotSearchItem = ((HotWordSearchEntryDataModel.HotSearchItem)this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.get(jdField_a_of_type_Int % i));
    if (!bass.a((QQAppInterface)localObject1))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131718003);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(2131718003);
      return;
    }
    bool = false;
    if (this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$HotSearchItem.showType == 3)
    {
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$HotSearchItem.detailText;
      if (this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$HotSearchItem.showCount == 0)
      {
        i = 1;
        bool = bass.a((QQAppInterface)localObject1, (String)localObject2, i);
        if ((!ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime())) || (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$HotSearchItem.imgBgUrl))) {
          break label584;
        }
        bool = false;
      }
    }
    else
    {
      label302:
      if (!bool) {
        break label603;
      }
      b();
      label311:
      jdField_a_of_type_Int += 1;
      bbda.a(null, new ReportModelDC02528().module("search_box").action("exp_default_word").ver2(bbda.a(25)).ver4(this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$HotSearchItem.title).ver7(bass.jdField_b_of_type_JavaLangString));
      new andr((QQAppInterface)localObject1).b((QQAppInterface)localObject1, "exp_default_word", "search_box", bbda.a(25), this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$HotSearchItem.sAppend, this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$HotSearchItem.title, bass.jdField_b_of_type_JavaLangString);
      if ((paramInt1 != -1) && (paramInt2 != -1))
      {
        localObject2 = new ReportModelDC02528().module("hot_list").action("feeds_hotword_wording");
        if (paramInt1 != 0) {
          break label756;
        }
        localObject1 = "1";
        label446:
        bbda.a(null, ((ReportModelDC02528)localObject2).ver1((String)localObject1).obj3(paramInt2 + ""));
        localObject2 = pay.a();
      }
    }
    for (;;)
    {
      try
      {
        ((pbg)localObject2).a("channelid", paramInt2 + "");
        if (paramInt1 != 0) {
          continue;
        }
        localObject1 = "1";
        ((pbg)localObject2).a("refresh_way", (String)localObject1);
      }
      catch (JSONException localJSONException)
      {
        label584:
        label603:
        ObjectAnimator localObjectAnimator;
        label756:
        continue;
      }
      a("0X800A4C5", ((pbg)localObject2).a());
      PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext()).edit().putLong("search_hotword_show_lasttime", System.currentTimeMillis()).commit();
      return;
      i = this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$HotSearchItem.showCount;
      break;
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$HotSearchItem.imgUrl)) {
        break label302;
      }
      bool = false;
      break label302;
      this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
      if (paramBoolean)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$HotSearchItem.title);
        localObject2 = ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidWidgetTextView, "translationY", new float[] { 0.0F, -Utils.dp2px(43.0D) });
        ((ObjectAnimator)localObject2).setDuration(200L);
        ((ObjectAnimator)localObject2).start();
        localObjectAnimator = ObjectAnimator.ofFloat(this.jdField_b_of_type_AndroidWidgetTextView, "translationY", new float[] { Utils.dp2px(43.0D), 0.0F });
        localObjectAnimator.setDuration(200L);
        localObjectAnimator.start();
        ((ObjectAnimator)localObject2).addListener(new syd(this));
        break label311;
      }
      a();
      break label311;
      localObject1 = "2";
      break label446;
      localObject1 = "2";
    }
  }
  
  protected void b()
  {
    this.c = true;
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    syc localsyc = new syc(this);
    this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
    basg.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentImageURLImageView, this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$HotSearchItem.imgUrl, this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$HotSearchItem.imgBgUrl, localsyc);
    bass.a(localQQAppInterface, BaseApplicationImpl.getContext(), this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$HotSearchItem.detailText, 0);
    bbda.a(null, new ReportModelDC02528().module("search_light").action("exp_search_light").ver2(bbda.a(25)).ver4(this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$HotSearchItem.detailText).ver7(bass.jdField_b_of_type_JavaLangString));
    new andr(localQQAppInterface).b(localQQAppInterface, "exp_search_light", "search_light", bbda.a(25), this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$HotSearchItem.sAppend, this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$HotSearchItem.detailText, bass.jdField_b_of_type_JavaLangString);
  }
  
  public void b(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel = new HotWordSearchEntryDataModel(localQQAppInterface, bass.b(), 10, false);
    ThreadManager.post(new ReadInJoyTabTopSearchHeaderController.6(this, paramBoolean, paramInt1, paramInt2, localQQAppInterface), 5, null, true);
  }
  
  public void c()
  {
    if (this.jdField_b_of_type_Boolean) {
      this.jdField_b_of_type_Boolean = false;
    }
    for (;;)
    {
      AbstractGifImage.resumeAll();
      return;
      ThreadManager.getUIHandler().postDelayed(new ReadInJoyTabTopSearchHeaderController.4(this), 400L);
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      new andr(localQQAppInterface).a(localQQAppInterface, 10);
    }
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
    localQQAppInterface.removeObserver(this.jdField_a_of_type_Andt);
    this.jdField_a_of_type_AndroidContentContext.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
    this.jdField_a_of_type_Boolean = true;
    bfyz.a(localQQAppInterface.getCurrentAccountUin(), 10, 0);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$HotSearchItem != null) && (this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$HotSearchItem.showType == 3)) {
      bass.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), BaseApplicationImpl.getContext(), this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$HotSearchItem.detailText, this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$HotSearchItem.showCount);
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    Object localObject2 = new ReportModelDC02528().module("search_box").action("clk_default_word");
    if (this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$HotSearchItem == null)
    {
      localObject1 = "";
      label119:
      bbda.a(localQQAppInterface, ((ReportModelDC02528)localObject2).ver4((String)localObject1).ver7("{experiment_id:" + bbda.jdField_b_of_type_JavaLangString + ",source:" + bass.jdField_b_of_type_JavaLangString + "}"));
      bbda.a(null, 0, 25, "0X8009D15", 0, 0, null, null);
      andr localandr = new andr(localQQAppInterface);
      String str = bbda.a(25);
      if (this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$HotSearchItem != null) {
        break label334;
      }
      localObject1 = "";
      label214:
      if (this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$HotSearchItem != null) {
        break label345;
      }
      localObject2 = "";
      label224:
      localandr.b(localQQAppInterface, "clk_default_word", "search_box", str, (String)localObject1, (String)localObject2, "{experiment_id:" + bbda.jdField_b_of_type_JavaLangString + ",source:" + bass.jdField_b_of_type_JavaLangString + "}");
      this.jdField_b_of_type_Int = 1;
      if (this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel == null) {
        break label356;
      }
    }
    label334:
    label345:
    label356:
    for (Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$GIFInfo;; localObject1 = null)
    {
      UniteSearchActivity.a((Activity)this.jdField_a_of_type_AndroidContentContext, null, 25, 0L, this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$HotSearchItem, 0, (HotWordSearchEntryDataModel.GIFInfo)localObject1);
      break;
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$HotSearchItem.title;
      break label119;
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$HotSearchItem.sAppend;
      break label214;
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$HotSearchItem.title;
      break label224;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sya
 * JD-Core Version:    0.7.0.1
 */