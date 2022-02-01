package com.tencent.mobileqq.search;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.tencent.biz.widgets.HotWordTipsContainer;
import com.tencent.biz.widgets.HotWordTipsContainer.OnTipClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener2;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.SearchWordHistoryManager;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.UniteSearchHandler;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyUtils;
import com.tencent.mobileqq.kandian.glue.router.api.IRIJJumpUtils;
import com.tencent.mobileqq.qcircle.api.IQCircleReportApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.base.api.SearchEntryConfigManager;
import com.tencent.mobileqq.search.fragment.SearchEntryFragment;
import com.tencent.mobileqq.search.model.HotWordSearchEntryDataModel;
import com.tencent.mobileqq.search.model.HotWordSearchEntryDataModel.GIFInfo;
import com.tencent.mobileqq.search.model.HotWordSearchEntryDataModel.HotSearchItem;
import com.tencent.mobileqq.search.model.HotWordSearchEntryDataModel.TitleHeaderItem;
import com.tencent.mobileqq.search.model.SearchEntryDataModel;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.mobileqq.search.report.UniteSearchReportController;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

public class HotWordSearchEntryModel
  extends BaseSearchEntryModel
  implements View.OnClickListener
{
  protected static int b = -1;
  protected Context a;
  protected View a;
  protected RelativeLayout a;
  protected TextView a;
  HotWordTipsContainer.OnTipClickListener a;
  protected HotWordTipsContainer a;
  protected URLImageView a;
  protected QQAppInterface a;
  protected HotWordSearchEntryDataModel a;
  protected List<HotWordSearchEntryDataModel.HotSearchItem> a;
  protected View b;
  protected TextView b;
  protected URLImageView b;
  private boolean b;
  private int jdField_c_of_type_Int = 0;
  protected View c;
  protected TextView c;
  private boolean jdField_c_of_type_Boolean = false;
  
  public HotWordSearchEntryModel(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    super(paramInt2);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentBizWidgetsHotWordTipsContainer$OnTipClickListener = new HotWordSearchEntryModel.1(this);
    this.jdField_c_of_type_Int = paramInt1;
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public static void a(Context paramContext, URLImageView paramURLImageView, String paramString1, String paramString2, HotWordSearchEntryModel.OnGifPlayListener paramOnGifPlayListener)
  {
    if ((paramContext != null) && (paramURLImageView != null))
    {
      if (TextUtils.isEmpty(paramString1)) {
        return;
      }
      paramURLImageView = new SoftReference(paramURLImageView);
      ColorDrawable localColorDrawable = new ColorDrawable();
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mLoadingDrawable = localColorDrawable;
      localURLDrawableOptions.mFailedDrawable = localColorDrawable;
      localURLDrawableOptions.mPlayGifImage = true;
      localURLDrawableOptions.mUseMemoryCache = false;
      if (ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime()))
      {
        if (TextUtils.isEmpty(paramString2)) {
          return;
        }
        localColorDrawable.setColor(ContextCompat.getColor(paramContext, 2131167365));
        paramContext = URLDrawable.getDrawable(paramString2, localURLDrawableOptions);
      }
      else
      {
        localColorDrawable.setColor(ContextCompat.getColor(paramContext, 2131167364));
        paramContext = URLDrawable.getDrawable(paramString1, localURLDrawableOptions);
      }
      if (paramContext == null) {
        return;
      }
      paramURLImageView = new HotWordSearchEntryModel.6(paramURLImageView, paramContext, paramOnGifPlayListener);
      paramContext.setURLDrawableListener(paramURLImageView);
      if (paramContext.getStatus() == 1)
      {
        paramURLImageView.onLoadSuccessed(paramContext);
        return;
      }
      ThreadManager.getFileThreadHandler().post(new HotWordSearchEntryModel.7(paramContext));
    }
  }
  
  private void a(HotWordSearchEntryDataModel.GIFInfo paramGIFInfo)
  {
    if (paramGIFInfo == null) {
      return;
    }
    HotWordSearchEntryModel.3 local3 = new HotWordSearchEntryModel.3(this, paramGIFInfo);
    this.jdField_a_of_type_AndroidViewView.post(new HotWordSearchEntryModel.4(this, paramGIFInfo, local3));
    this.jdField_b_of_type_Boolean = true;
  }
  
  private void a(HotWordSearchEntryDataModel.HotSearchItem paramHotSearchItem, String paramString)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    UniteSearchHandler localUniteSearchHandler = new UniteSearchHandler(localQQAppInterface);
    int i = paramHotSearchItem.type;
    Object localObject;
    StringBuilder localStringBuilder;
    if (i != 7)
    {
      if (i != 8)
      {
        localObject = new ReportModelDC02528().module("hot_list").action("clk_hot_list");
        if (this.jdField_a_of_type_Int == 3) {
          i = 21;
        } else {
          i = this.jdField_a_of_type_Int;
        }
        localObject = ((ReportModelDC02528)localObject).ver2(UniteSearchReportController.a(i)).ver4(paramHotSearchItem.title).ver7(paramString);
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(localQQAppInterface.getCurrentAccountUin());
        localStringBuilder.append(this.jdField_a_of_type_Long);
        UniteSearchReportController.a(null, ((ReportModelDC02528)localObject).session_id(localStringBuilder.toString()));
        if (this.jdField_a_of_type_Int == 3) {
          i = 21;
        } else {
          i = this.jdField_a_of_type_Int;
        }
        localUniteSearchHandler.b(localQQAppInterface, "clk_hot_list", "hot_list", UniteSearchReportController.a(i), paramHotSearchItem.sAppend, paramHotSearchItem.title, paramString);
      }
      else
      {
        try
        {
          paramString = new JSONObject(paramHotSearchItem.sExtInfo);
          localObject = new HashMap();
          ((HashMap)localObject).put("ext5", paramString.optString("ext5"));
          ((HashMap)localObject).put("ext6", paramString.optString("ext6"));
          ((HashMap)localObject).put("ext7", paramString.optString("ext7"));
          ((HashMap)localObject).put("ext8", paramString.optString("ext8"));
          ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504("", 104, 1, 2, (HashMap)localObject, null, null);
        }
        catch (JSONException paramString)
        {
          paramString.printStackTrace();
        }
      }
    }
    else
    {
      localObject = new ReportModelDC02528().module("recom_list").action("clk_recom_list");
      if (this.jdField_a_of_type_Int == 3) {
        i = 21;
      } else {
        i = this.jdField_a_of_type_Int;
      }
      localObject = ((ReportModelDC02528)localObject).ver2(UniteSearchReportController.a(i)).ver4(paramHotSearchItem.title).ver7(paramString);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(localQQAppInterface.getCurrentAccountUin());
      localStringBuilder.append(this.jdField_a_of_type_Long);
      UniteSearchReportController.a(null, ((ReportModelDC02528)localObject).session_id(localStringBuilder.toString()));
      if (this.jdField_a_of_type_Int == 3) {
        i = 21;
      } else {
        i = this.jdField_a_of_type_Int;
      }
      localUniteSearchHandler.b(localQQAppInterface, "clk_recom_list", "recom_list", UniteSearchReportController.a(i), paramHotSearchItem.sAppend, paramHotSearchItem.title, paramString);
    }
    if ((UniteSearchActivity.a != null) && (TextUtils.equals(UniteSearchActivity.a.title, paramHotSearchItem.title)))
    {
      paramString = new ReportModelDC02528().module("default_word").action("clk_default_word");
      if (this.jdField_a_of_type_Int == 3) {
        i = 21;
      } else {
        i = this.jdField_a_of_type_Int;
      }
      UniteSearchReportController.a(null, paramString.ver2(UniteSearchReportController.a(i)).ver4(paramHotSearchItem.title).ver7(SearchEntryConfigManager.b));
      if (this.jdField_a_of_type_Int == 3) {
        i = 21;
      } else {
        i = this.jdField_a_of_type_Int;
      }
      localUniteSearchHandler.b(localQQAppInterface, "clk_default_word", "default_word", UniteSearchReportController.a(i), paramHotSearchItem.sAppend, paramHotSearchItem.title, SearchEntryConfigManager.b);
    }
    UniteSearchReportController.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0, SearchEntryFragment.a(this.jdField_a_of_type_Int), "0X8009D28", 0, 0, null, null);
    paramString = (SearchWordHistoryManager)((QQAppInterface)((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getAppRuntime()).getManager(QQManagerFactory.SEARCH_WORD_HISTORY_MANAGER);
    if (paramHotSearchItem.type != 8) {
      paramString.a(paramHotSearchItem.recallWord);
    }
  }
  
  private void a(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      JumpAction localJumpAction = JumpParser.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramString1);
      if (localJumpAction != null)
      {
        localJumpAction.a();
        SearchUtil.jdField_a_of_type_Boolean = true;
        return;
      }
      if ((!paramString1.startsWith("http://")) && (!paramString1.startsWith("https://")))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.uniteSearch.HotWordSearchEntryModel", 2, "OnTipClickListener jumpUrl is illegal");
        }
      }
      else
      {
        ((IRIJJumpUtils)QRoute.api(IRIJJumpUtils.class)).jumpToNativeSearchResultPage(this.jdField_a_of_type_AndroidContentContext, paramString2, paramString1);
        SearchUtil.jdField_a_of_type_Boolean = true;
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.d("Q.uniteSearch.HotWordSearchEntryModel", 2, "OnTipClickListener jumpUrl is empty");
    }
  }
  
  public static boolean a(HotWordSearchEntryDataModel.GIFInfo paramGIFInfo)
  {
    if ((paramGIFInfo != null) && (!TextUtils.isEmpty(paramGIFInfo.hotSearchGifID)))
    {
      if (TextUtils.isEmpty(paramGIFInfo.hotSearchGifUrl)) {
        return false;
      }
      Object localObject = PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext());
      if (TextUtils.equals(((SharedPreferences)localObject).getString("HotWordSearchEntryModel.psk_hot_search_last_show_id", ""), paramGIFInfo.hotSearchGifID)) {
        return false;
      }
      int i = ((SharedPreferences)localObject).getInt("HotWordSearchEntryModel.psk_hot_search_try_time", 0);
      localObject = ((SharedPreferences)localObject).getString("HotWordSearchEntryModel.psk_hot_search_try_id", "");
      return (!TextUtils.equals(paramGIFInfo.hotSearchGifID, (CharSequence)localObject)) || (i < 2);
    }
    return false;
  }
  
  private void b(HotWordSearchEntryDataModel.TitleHeaderItem paramTitleHeaderItem)
  {
    if (paramTitleHeaderItem == null) {
      return;
    }
    Object localObject2 = paramTitleHeaderItem.b;
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = "https://wezone-theme.cdn-go.cn/url-resource/latest/defaultmode/870/qsearch_qcircle/logo_qcircle@3x.png";
    }
    localObject2 = new ColorDrawable();
    if (ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime())) {
      ((ColorDrawable)localObject2).setColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167365));
    } else {
      ((ColorDrawable)localObject2).setColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167364));
    }
    localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject2);
    localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject2);
    localObject1 = URLDrawable.getDrawable((String)localObject1, localURLDrawableOptions);
    this.jdField_b_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject1);
    localObject1 = this.jdField_b_of_type_ComTencentImageURLImageView.getLayoutParams();
    int i = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 22.0F);
    ((ViewGroup.LayoutParams)localObject1).width = i;
    ((ViewGroup.LayoutParams)localObject1).height = i;
    this.jdField_b_of_type_ComTencentImageURLImageView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    localObject1 = this.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject1).height = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 50.0F);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setPadding(DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 10.0F), 0, DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 16.0F), 0);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    if (!TextUtils.isEmpty(paramTitleHeaderItem.jdField_a_of_type_JavaLangString)) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramTitleHeaderItem.jdField_a_of_type_JavaLangString);
    } else {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131711160));
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_c_of_type_AndroidViewView.setVisibility(8);
  }
  
  private void c(HotWordSearchEntryDataModel.TitleHeaderItem paramTitleHeaderItem)
  {
    if (paramTitleHeaderItem == null) {
      return;
    }
    Object localObject2 = paramTitleHeaderItem.b;
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = "https://res.imtt.qq.com/res_mtt/KDhotword/xiaohuomiao.png";
    }
    localObject2 = new ColorDrawable();
    if (ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime())) {
      ((ColorDrawable)localObject2).setColor(ContextCompat.getColor(this.jdField_a_of_type_AndroidContentContext, 2131167365));
    } else {
      ((ColorDrawable)localObject2).setColor(ContextCompat.getColor(this.jdField_a_of_type_AndroidContentContext, 2131167364));
    }
    localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject2);
    localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject2);
    localObject1 = URLDrawable.getDrawable((String)localObject1, localURLDrawableOptions);
    this.jdField_b_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject1);
    if (!TextUtils.isEmpty(paramTitleHeaderItem.jdField_a_of_type_JavaLangString)) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramTitleHeaderItem.jdField_a_of_type_JavaLangString);
    } else {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131705716));
    }
    if (!TextUtils.isEmpty(paramTitleHeaderItem.c)) {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(paramTitleHeaderItem.c);
    } else {
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    if ((paramTitleHeaderItem.jdField_a_of_type_Int == 1) && (!TextUtils.isEmpty(paramTitleHeaderItem.e)))
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    else
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new HotWordSearchEntryModel.2(this, paramTitleHeaderItem));
    this.jdField_c_of_type_AndroidViewView.setVisibility(8);
  }
  
  private void d(HotWordSearchEntryDataModel.TitleHeaderItem paramTitleHeaderItem)
  {
    if (paramTitleHeaderItem == null) {
      return;
    }
    this.jdField_b_of_type_ComTencentImageURLImageView.setVisibility(8);
    if (!TextUtils.isEmpty(paramTitleHeaderItem.jdField_a_of_type_JavaLangString)) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramTitleHeaderItem.jdField_a_of_type_JavaLangString);
    } else {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(BaseApplication.getContext().getResources().getString(2131718017));
    }
    paramTitleHeaderItem = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
    paramTitleHeaderItem.leftMargin = 0;
    this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams(paramTitleHeaderItem);
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_c_of_type_AndroidViewView.setVisibility(8);
  }
  
  public View a(Context paramContext, QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    paramBundle = paramQQAppInterface;
    if (paramQQAppInterface == null)
    {
      if ((paramContext instanceof BaseActivity)) {
        paramViewGroup = ((BaseActivity)paramContext).getAppRuntime();
      } else {
        paramViewGroup = null;
      }
      paramBundle = paramQQAppInterface;
      if ((paramViewGroup instanceof QQAppInterface)) {
        paramBundle = (QQAppInterface)paramViewGroup;
      }
    }
    if (paramBundle == null) {
      return new View(paramContext);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramBundle;
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(paramContext).inflate(2131560893, null);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131378791));
    this.jdField_b_of_type_ComTencentImageURLImageView = ((URLImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131378832));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131378876));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131371512));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131374257));
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizWidgetsHotWordTipsContainer = ((HotWordTipsContainer)this.jdField_a_of_type_AndroidViewView.findViewById(2131378745));
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131365769);
    this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131365770);
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368290));
    if (!this.jdField_a_of_type_Boolean) {
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    } else {
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
    }
    this.jdField_a_of_type_ComTencentBizWidgetsHotWordTipsContainer.setOnTipsClickListener(this.jdField_a_of_type_ComTencentBizWidgetsHotWordTipsContainer$OnTipClickListener);
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public void a()
  {
    int i = this.jdField_c_of_type_Int;
    HotWordSearchEntryDataModel localHotWordSearchEntryDataModel;
    if (i != 7)
    {
      if (i != 8) {
        localHotWordSearchEntryDataModel = new HotWordSearchEntryDataModel(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, this.jdField_a_of_type_Int, this.jdField_c_of_type_Boolean);
      } else {
        localHotWordSearchEntryDataModel = new HotWordSearchEntryDataModel(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 8, this.jdField_a_of_type_Int, this.jdField_c_of_type_Boolean);
      }
    }
    else {
      localHotWordSearchEntryDataModel = new HotWordSearchEntryDataModel(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 7, this.jdField_a_of_type_Int, this.jdField_c_of_type_Boolean);
    }
    ThreadManager.post(new HotWordSearchEntryModel.5(this, localHotWordSearchEntryDataModel), 5, null, true);
  }
  
  public void a(HotWordSearchEntryDataModel.TitleHeaderItem paramTitleHeaderItem)
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel.jdField_c_of_type_Int;
    if (i != 1)
    {
      if (i != 8)
      {
        d(paramTitleHeaderItem);
        return;
      }
      b(paramTitleHeaderItem);
      return;
    }
    c(paramTitleHeaderItem);
  }
  
  public void a(SearchEntryDataModel paramSearchEntryDataModel)
  {
    b(paramSearchEntryDataModel);
  }
  
  public void b()
  {
    super.b();
  }
  
  public void b(SearchEntryDataModel paramSearchEntryDataModel)
  {
    Object localObject2 = (HotWordSearchEntryDataModel)paramSearchEntryDataModel;
    if ((localObject2 != null) && (((HotWordSearchEntryDataModel)localObject2).jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList != null) && (((HotWordSearchEntryDataModel)localObject2).jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() != 0))
    {
      this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel = ((HotWordSearchEntryDataModel)localObject2);
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_JavaUtilList.addAll(((HotWordSearchEntryDataModel)localObject2).jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList);
      this.jdField_a_of_type_ComTencentBizWidgetsHotWordTipsContainer.a((HotWordSearchEntryDataModel)localObject2, this.jdField_a_of_type_Int);
      if (((HotWordSearchEntryDataModel)localObject2).jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$TitleHeaderItem == null)
      {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      }
      else
      {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        a(((HotWordSearchEntryDataModel)localObject2).jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$TitleHeaderItem);
      }
      if ((!this.jdField_b_of_type_Boolean) && (a(this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$GIFInfo)) && (this.jdField_a_of_type_Int == 10)) {
        a(this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$GIFInfo);
      }
      Object localObject1 = (Boolean)SearchEntryFragment.mIsModelsReported.get(Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel.jdField_c_of_type_Int));
      if ((localObject1 == null) || (!((Boolean)localObject1).booleanValue()))
      {
        localObject1 = "";
        StringBuilder localStringBuilder1 = new StringBuilder("");
        if ((((HotWordSearchEntryDataModel)localObject2).b() != null) && (((HotWordSearchEntryDataModel)localObject2).b().size() > 0))
        {
          j = ((HotWordSearchEntryDataModel)localObject2).b().size();
          i = 0;
          int k;
          for (;;)
          {
            k = j - 1;
            if (i >= k) {
              break;
            }
            localStringBuilder1.append(((HotWordSearchEntryDataModel.HotSearchItem)((HotWordSearchEntryDataModel)localObject2).b().get(i)).title);
            localStringBuilder1.append("::");
            i += 1;
          }
          localStringBuilder1.append(((HotWordSearchEntryDataModel.HotSearchItem)((HotWordSearchEntryDataModel)localObject2).b().get(k)).title);
        }
        SearchUtils.a("hot_list", "exp_hot_list", new String[] { localStringBuilder1.toString(), String.valueOf(this.jdField_a_of_type_Int) });
        SearchEntryFragment.mIsModelsReported.put(Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel.jdField_c_of_type_Int), Boolean.valueOf(true));
        localObject2 = new StringBuilder();
        if (this.jdField_a_of_type_JavaUtilList.size() > 0)
        {
          i = 0;
          while (i < this.jdField_a_of_type_JavaUtilList.size() - 1)
          {
            ((StringBuilder)localObject2).append(((HotWordSearchEntryDataModel.HotSearchItem)this.jdField_a_of_type_JavaUtilList.get(i)).title);
            ((StringBuilder)localObject2).append("::");
            i += 1;
          }
          List localList = this.jdField_a_of_type_JavaUtilList;
          ((StringBuilder)localObject2).append(localList.get(localList.size() - 1));
        }
        localObject2 = new JSONObject();
        try
        {
          ((JSONObject)localObject2).put("project", UniteSearchReportController.a());
          ((JSONObject)localObject2).put("event_src", "client");
          ((JSONObject)localObject2).put("experiment_id", UniteSearchReportController.b);
        }
        catch (JSONException localJSONException)
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("e = ");
          ((StringBuilder)localObject3).append(localJSONException);
          QLog.e("Q.uniteSearch.HotWordSearchEntryModel", 2, ((StringBuilder)localObject3).toString());
        }
        QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
        Object localObject3 = new UniteSearchHandler(localQQAppInterface);
        if (this.jdField_a_of_type_JavaUtilList.size() > 0) {
          localObject1 = ((HotWordSearchEntryDataModel.HotSearchItem)this.jdField_a_of_type_JavaUtilList.get(0)).sAppend;
        }
        int j = paramSearchEntryDataModel.jdField_c_of_type_Int;
        int i = 21;
        StringBuilder localStringBuilder2;
        if (j == 7)
        {
          paramSearchEntryDataModel = new ReportModelDC02528().module("recom_list").action("exp_recom_list");
          if (this.jdField_a_of_type_Int == 3) {
            j = 21;
          } else {
            j = this.jdField_a_of_type_Int;
          }
          paramSearchEntryDataModel = paramSearchEntryDataModel.ver2(UniteSearchReportController.a(j)).ver4(localStringBuilder1.toString()).ver7(((JSONObject)localObject2).toString());
          localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append(localQQAppInterface.getCurrentAccountUin());
          localStringBuilder2.append(this.jdField_a_of_type_Long);
          UniteSearchReportController.a(null, paramSearchEntryDataModel.session_id(localStringBuilder2.toString()));
          if (this.jdField_a_of_type_Int != 3) {
            i = this.jdField_a_of_type_Int;
          }
          ((UniteSearchHandler)localObject3).b(localQQAppInterface, "exp_recom_list", "recom_list", UniteSearchReportController.a(i), (String)localObject1, localStringBuilder1.toString(), ((JSONObject)localObject2).toString());
        }
        else
        {
          paramSearchEntryDataModel = new ReportModelDC02528().module("hot_list").action("exp_hot_list");
          if (this.jdField_a_of_type_Int == 3) {
            j = 21;
          } else {
            j = this.jdField_a_of_type_Int;
          }
          paramSearchEntryDataModel = paramSearchEntryDataModel.ver2(UniteSearchReportController.a(j)).ver4(localStringBuilder1.toString()).ver7(((JSONObject)localObject2).toString());
          localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append(localQQAppInterface.getCurrentAccountUin());
          localStringBuilder2.append(this.jdField_a_of_type_Long);
          UniteSearchReportController.a(null, paramSearchEntryDataModel.session_id(localStringBuilder2.toString()));
          if (this.jdField_a_of_type_Int != 3) {
            i = this.jdField_a_of_type_Int;
          }
          ((UniteSearchHandler)localObject3).b(localQQAppInterface, "exp_hot_list", "hot_list", UniteSearchReportController.a(i), (String)localObject1, localStringBuilder1.toString(), ((JSONObject)localObject2).toString());
        }
        UniteSearchReportController.a(localQQAppInterface, 0, SearchEntryFragment.a(this.jdField_a_of_type_Int), "0X8009D27", 0, 0, null, null);
      }
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentImageURLImageView.getVisibility() != 8)
    {
      this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(null);
      this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131374257)
    {
      Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel;
      if ((localObject1 != null) && (((HotWordSearchEntryDataModel)localObject1).jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$TitleHeaderItem != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$TitleHeaderItem.e))) {
        a(this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$TitleHeaderItem.e, "");
      } else if (QLog.isColorLevel()) {
        QLog.d("Q.uniteSearch.HotWordSearchEntryModel", 2, "qq_index_text jumpUrl is illegal");
      }
      localObject1 = new JSONObject();
      try
      {
        ((JSONObject)localObject1).put("project", UniteSearchReportController.a());
        ((JSONObject)localObject1).put("event_src", "client");
      }
      catch (JSONException localJSONException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("e = ");
        localStringBuilder.append(localJSONException);
        QLog.e("Q.uniteSearch.HotWordSearchEntryModel", 2, localStringBuilder.toString());
      }
      SearchUtils.a("hot_list", "clk_qq_index", new String[] { "", String.valueOf(this.jdField_a_of_type_Int) });
      Object localObject2 = new ReportModelDC02528().module("hot_list").action("clk_qq_index");
      int i;
      if (this.jdField_a_of_type_Int == 3) {
        i = 21;
      } else {
        i = this.jdField_a_of_type_Int;
      }
      localObject1 = ((ReportModelDC02528)localObject2).ver2(UniteSearchReportController.a(i)).ver7(((JSONObject)localObject1).toString());
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      ((StringBuilder)localObject2).append(this.jdField_a_of_type_Long);
      UniteSearchReportController.a(null, ((ReportModelDC02528)localObject1).session_id(((StringBuilder)localObject2).toString()));
      UniteSearchReportController.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0, SearchEntryFragment.a(this.jdField_a_of_type_Int), "0X8009D28", 0, 0, null, null);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.HotWordSearchEntryModel
 * JD-Core Version:    0.7.0.1
 */