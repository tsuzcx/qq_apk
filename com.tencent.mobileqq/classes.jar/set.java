import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.view.headers.ReadInJoyTabTopSearchHeaderController.3;
import com.tencent.biz.pubaccount.readinjoy.view.headers.ReadInJoyTabTopSearchHeaderController.4;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.AbstractGifImage;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.model.HotWordSearchEntryDataModel;
import com.tencent.mobileqq.search.model.HotWordSearchEntryDataModel.HotSearchItem;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.os.MqqHandler;
import org.json.JSONException;

public class set
  implements View.OnClickListener, rxg
{
  protected static int a;
  protected amfg a;
  protected BroadcastReceiver a;
  private Context jdField_a_of_type_AndroidContentContext;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  protected HotWordSearchEntryDataModel.HotSearchItem a;
  public HotWordSearchEntryDataModel a;
  public String a;
  public boolean a;
  private TextView b;
  public String b;
  protected boolean b;
  
  public set(Context paramContext, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_Amfg = new seu(this);
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_JavaLangString = "search_word_prefix_search_change_times";
    this.jdField_b_of_type_JavaLangString = "search_word_prefix_refresh_times";
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new sew(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
    this.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131378990));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131378989));
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
      ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).addObserver(this.jdField_a_of_type_Amfg);
      b(false, -1, -1);
      paramViewGroup = new IntentFilter("mqq.intent.action.ACCOUNT_CHANGED");
      paramContext.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramViewGroup);
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
    String str = ors.a();
    QLog.d("ReadInJoyTabTopSearchHeaderController", 1, new Object[] { "actionName = ", paramString1, "\n", "r2 = ", str, " r5 = ", paramString2 });
    nrt.a(null, "", paramString1, paramString1, 0, 0, str, "", "", paramString2, false);
  }
  
  public void a()
  {
    if (this.jdField_b_of_type_Boolean) {
      this.jdField_b_of_type_Boolean = false;
    }
    for (;;)
    {
      AbstractGifImage.resumeAll();
      return;
      if (!TextUtils.isEmpty(aoqz.a().jdField_a_of_type_JavaLangString))
      {
        a(false, -1, -1);
        QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
        new amfe(localQQAppInterface).a(localQQAppInterface, 10);
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 0) || (paramInt1 == 1) || ((paramInt2 == 0) && (paramInt1 != 2))) {
      ThreadManager.getUIHandler().postDelayed(new ReadInJoyTabTopSearchHeaderController.3(this, paramInt1, paramInt2), 200L);
    }
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel == null) || (this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel.jdField_a_of_type_JavaUtilList.size() == 0))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131719603);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(2131719603);
      this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$HotSearchItem = null;
    }
    Object localObject1;
    do
    {
      return;
      if (HotWordSearchEntryDataModel.a(10, false))
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131719603);
        this.jdField_b_of_type_AndroidWidgetTextView.setText(2131719603);
        this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$HotSearchItem = null;
        return;
      }
      int i = this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel.jdField_a_of_type_JavaUtilList.size();
      this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$HotSearchItem = ((HotWordSearchEntryDataModel.HotSearchItem)this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel.jdField_a_of_type_JavaUtilList.get(jdField_a_of_type_Int % i));
      localObject1 = ayvj.a("kFTSReadInJoySearchPlaceholderPrefix");
      if (!paramBoolean) {
        break;
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setText((String)localObject1 + this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$HotSearchItem.title);
      localObject2 = ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidWidgetTextView, "translationY", new float[] { 0.0F, -Utils.dp2px(43.0D) });
      ((ObjectAnimator)localObject2).setDuration(150L);
      ((ObjectAnimator)localObject2).start();
      ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.jdField_b_of_type_AndroidWidgetTextView, "translationY", new float[] { Utils.dp2px(43.0D), 0.0F });
      localObjectAnimator.setDuration(150L);
      localObjectAnimator.start();
      ((ObjectAnimator)localObject2).addListener(new sev(this, (String)localObject1));
      jdField_a_of_type_Int += 1;
      aysc.a(null, new ReportModelDC02528().module("hot_list").action("exp_default_word").ver2(aysc.a(25)).ver4(this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$HotSearchItem.title));
      localObject1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      new amfe((QQAppInterface)localObject1).a((QQAppInterface)localObject1, "exp_default_word", this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$HotSearchItem.title, aysc.a(25), null);
    } while ((paramInt1 == -1) || (paramInt2 == -1));
    Object localObject2 = new ReportModelDC02528().module("hot_list").action("feeds_hotword_wording");
    if (paramInt1 == 0)
    {
      localObject1 = "1";
      label420:
      aysc.a(null, ((ReportModelDC02528)localObject2).ver1((String)localObject1).obj3(paramInt2 + ""));
      localObject2 = ors.a();
    }
    for (;;)
    {
      try
      {
        ((orz)localObject2).a("channelid", paramInt2 + "");
        if (paramInt1 != 0) {
          continue;
        }
        localObject1 = "1";
        ((orz)localObject2).a("refresh_way", (String)localObject1);
      }
      catch (JSONException localJSONException)
      {
        continue;
      }
      a("0X800A4C5", ((orz)localObject2).a());
      return;
      this.jdField_b_of_type_AndroidWidgetTextView.setText((String)localObject1 + this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$HotSearchItem.title);
      this.jdField_a_of_type_AndroidWidgetTextView.setText((String)localObject1 + this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$HotSearchItem.title);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setTranslationY(Utils.dp2px(43.0D));
      this.jdField_a_of_type_AndroidWidgetTextView.setTranslationY(0.0F);
      break;
      localObject1 = "2";
      break label420;
      localObject1 = "2";
    }
  }
  
  public void b() {}
  
  public void b(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (!TextUtils.isEmpty(aoqz.a().jdField_a_of_type_JavaLangString))
    {
      this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel = new HotWordSearchEntryDataModel(localQQAppInterface, 1, 10, false);
      ThreadManager.post(new ReadInJoyTabTopSearchHeaderController.4(this, paramBoolean, paramInt1, paramInt2, localQQAppInterface), 5, null, true);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel = null;
  }
  
  public void c()
  {
    this.jdField_b_of_type_Boolean = false;
    ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).removeObserver(this.jdField_a_of_type_Amfg);
    this.jdField_a_of_type_AndroidContentContext.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel != null) {}
    for (paramView = this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$GIFInfo;; paramView = null)
    {
      UniteSearchActivity.a((Activity)this.jdField_a_of_type_AndroidContentContext, null, 25, 0L, this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$HotSearchItem, 0, paramView);
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      ReportModelDC02528 localReportModelDC02528 = new ReportModelDC02528().opername("Kdian_inner_search").module("kd_web_search").action("active_search");
      if (this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$HotSearchItem == null) {}
      for (paramView = "";; paramView = this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$HotSearchItem.title)
      {
        aysc.a(localQQAppInterface, localReportModelDC02528.ver1(paramView).ver7("{experiment_id:" + aysc.jdField_b_of_type_JavaLangString + "}"));
        aysc.a(null, 0, 25, "0X8009D15", 0, 0, null, null);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     set
 * JD-Core Version:    0.7.0.1
 */