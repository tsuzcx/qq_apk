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
import com.tencent.mobileqq.qcircle.api.constant.QCircleLpReportDc05504DataBuilder;
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
  protected static int o = -1;
  protected View d;
  protected URLImageView e;
  protected RelativeLayout f;
  protected URLImageView g;
  protected TextView h;
  protected TextView i;
  protected HotWordTipsContainer j;
  protected View k;
  protected View l;
  protected TextView m;
  protected List<HotWordSearchEntryDataModel.HotSearchItem> n = new ArrayList();
  protected QQAppInterface p;
  protected Context q;
  protected HotWordSearchEntryDataModel r;
  HotWordTipsContainer.OnTipClickListener s = new HotWordSearchEntryModel.1(this);
  private boolean t = false;
  private boolean u = false;
  private int v = 0;
  
  public HotWordSearchEntryModel(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    super(paramInt2);
    this.v = paramInt1;
    this.u = paramBoolean;
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
        localColorDrawable.setColor(ContextCompat.getColor(paramContext, 2131168420));
        paramContext = URLDrawable.getDrawable(paramString2, localURLDrawableOptions);
      }
      else
      {
        localColorDrawable.setColor(ContextCompat.getColor(paramContext, 2131168419));
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
  
  private void a(HotWordSearchEntryDataModel.HotSearchItem paramHotSearchItem, String paramString)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    UniteSearchHandler localUniteSearchHandler = new UniteSearchHandler(localQQAppInterface);
    int i1 = paramHotSearchItem.type;
    Object localObject;
    StringBuilder localStringBuilder;
    if (i1 != 7)
    {
      if (i1 != 8)
      {
        localObject = new ReportModelDC02528().module("hot_list").action("clk_hot_list");
        if (this.a == 3) {
          i1 = 21;
        } else {
          i1 = this.a;
        }
        localObject = ((ReportModelDC02528)localObject).ver2(UniteSearchReportController.a(i1)).ver4(paramHotSearchItem.title).ver7(paramString);
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(localQQAppInterface.getCurrentAccountUin());
        localStringBuilder.append(this.b);
        UniteSearchReportController.a(null, ((ReportModelDC02528)localObject).session_id(localStringBuilder.toString()));
        if (this.a == 3) {
          i1 = 21;
        } else {
          i1 = this.a;
        }
        localUniteSearchHandler.b(localQQAppInterface, "clk_hot_list", "hot_list", UniteSearchReportController.a(i1), paramHotSearchItem.sAppend, paramHotSearchItem.title, paramString);
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
          ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504(new QCircleLpReportDc05504DataBuilder().setActionType(104).setSubActionType(1).setThrActionType(2).setExtras((HashMap)localObject));
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
      if (this.a == 3) {
        i1 = 21;
      } else {
        i1 = this.a;
      }
      localObject = ((ReportModelDC02528)localObject).ver2(UniteSearchReportController.a(i1)).ver4(paramHotSearchItem.title).ver7(paramString);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(localQQAppInterface.getCurrentAccountUin());
      localStringBuilder.append(this.b);
      UniteSearchReportController.a(null, ((ReportModelDC02528)localObject).session_id(localStringBuilder.toString()));
      if (this.a == 3) {
        i1 = 21;
      } else {
        i1 = this.a;
      }
      localUniteSearchHandler.b(localQQAppInterface, "clk_recom_list", "recom_list", UniteSearchReportController.a(i1), paramHotSearchItem.sAppend, paramHotSearchItem.title, paramString);
    }
    if ((UniteSearchActivity.h != null) && (TextUtils.equals(UniteSearchActivity.h.title, paramHotSearchItem.title)))
    {
      paramString = new ReportModelDC02528().module("default_word").action("clk_default_word");
      if (this.a == 3) {
        i1 = 21;
      } else {
        i1 = this.a;
      }
      UniteSearchReportController.a(null, paramString.ver2(UniteSearchReportController.a(i1)).ver4(paramHotSearchItem.title).ver7(SearchEntryConfigManager.c));
      if (this.a == 3) {
        i1 = 21;
      } else {
        i1 = this.a;
      }
      localUniteSearchHandler.b(localQQAppInterface, "clk_default_word", "default_word", UniteSearchReportController.a(i1), paramHotSearchItem.sAppend, paramHotSearchItem.title, SearchEntryConfigManager.c);
    }
    UniteSearchReportController.a(this.p, 0, SearchEntryFragment.b(this.a), "0X8009D28", 0, 0, null, null);
    paramString = (SearchWordHistoryManager)((QQAppInterface)((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getAppRuntime()).getManager(QQManagerFactory.SEARCH_WORD_HISTORY_MANAGER);
    if (paramHotSearchItem.type != 8) {
      paramString.a(paramHotSearchItem.recallWord);
    }
  }
  
  private void a(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      JumpAction localJumpAction = JumpParser.a(this.p, this.q, paramString1);
      if (localJumpAction != null)
      {
        localJumpAction.a();
        SearchUtil.a = true;
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
        ((IRIJJumpUtils)QRoute.api(IRIJJumpUtils.class)).jumpToNativeSearchResultPage(this.q, paramString2, paramString1);
        SearchUtil.a = true;
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
      int i1 = ((SharedPreferences)localObject).getInt("HotWordSearchEntryModel.psk_hot_search_try_time", 0);
      localObject = ((SharedPreferences)localObject).getString("HotWordSearchEntryModel.psk_hot_search_try_id", "");
      return (!TextUtils.equals(paramGIFInfo.hotSearchGifID, (CharSequence)localObject)) || (i1 < 2);
    }
    return false;
  }
  
  private void b(HotWordSearchEntryDataModel.GIFInfo paramGIFInfo)
  {
    if (paramGIFInfo == null) {
      return;
    }
    HotWordSearchEntryModel.3 local3 = new HotWordSearchEntryModel.3(this, paramGIFInfo);
    this.d.post(new HotWordSearchEntryModel.4(this, paramGIFInfo, local3));
    this.t = true;
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
      ((ColorDrawable)localObject2).setColor(this.q.getResources().getColor(2131168420));
    } else {
      ((ColorDrawable)localObject2).setColor(this.q.getResources().getColor(2131168419));
    }
    localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject2);
    localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject2);
    localObject1 = URLDrawable.getDrawable((String)localObject1, localURLDrawableOptions);
    this.g.setImageDrawable((Drawable)localObject1);
    localObject1 = this.g.getLayoutParams();
    int i1 = DisplayUtil.a(this.q, 22.0F);
    ((ViewGroup.LayoutParams)localObject1).width = i1;
    ((ViewGroup.LayoutParams)localObject1).height = i1;
    this.g.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    localObject1 = this.f.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject1).height = DisplayUtil.a(this.q, 50.0F);
    this.f.setPadding(DisplayUtil.a(this.q, 10.0F), 0, DisplayUtil.a(this.q, 16.0F), 0);
    this.f.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    if (!TextUtils.isEmpty(paramTitleHeaderItem.a)) {
      this.h.setText(paramTitleHeaderItem.a);
    } else {
      this.h.setText(HardCodeUtil.a(2131908825));
    }
    this.i.setVisibility(8);
    this.m.setVisibility(8);
    this.l.setVisibility(8);
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
      ((ColorDrawable)localObject2).setColor(ContextCompat.getColor(this.q, 2131168420));
    } else {
      ((ColorDrawable)localObject2).setColor(ContextCompat.getColor(this.q, 2131168419));
    }
    localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject2);
    localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject2);
    localObject1 = URLDrawable.getDrawable((String)localObject1, localURLDrawableOptions);
    this.g.setImageDrawable((Drawable)localObject1);
    if (!TextUtils.isEmpty(paramTitleHeaderItem.a)) {
      this.h.setText(paramTitleHeaderItem.a);
    } else {
      this.h.setText(HardCodeUtil.a(2131903601));
    }
    if (!TextUtils.isEmpty(paramTitleHeaderItem.c)) {
      this.i.setText(paramTitleHeaderItem.c);
    } else {
      this.i.setVisibility(8);
    }
    if ((paramTitleHeaderItem.e == 1) && (!TextUtils.isEmpty(paramTitleHeaderItem.f)))
    {
      this.m.setVisibility(0);
      this.i.setVisibility(8);
    }
    else
    {
      this.m.setVisibility(8);
    }
    this.f.setOnClickListener(new HotWordSearchEntryModel.2(this, paramTitleHeaderItem));
    this.l.setVisibility(8);
  }
  
  private void d(HotWordSearchEntryDataModel.TitleHeaderItem paramTitleHeaderItem)
  {
    if (paramTitleHeaderItem == null) {
      return;
    }
    this.g.setVisibility(8);
    if (!TextUtils.isEmpty(paramTitleHeaderItem.a)) {
      this.h.setText(paramTitleHeaderItem.a);
    } else {
      this.h.setText(BaseApplication.getContext().getResources().getString(2131915498));
    }
    paramTitleHeaderItem = (RelativeLayout.LayoutParams)this.h.getLayoutParams();
    paramTitleHeaderItem.leftMargin = 0;
    this.h.setLayoutParams(paramTitleHeaderItem);
    this.m.setVisibility(8);
    this.i.setVisibility(8);
    this.l.setVisibility(8);
  }
  
  public View a(Context paramContext, QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.q = paramContext;
    this.b = System.currentTimeMillis();
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
    this.p = paramBundle;
    this.d = LayoutInflater.from(paramContext).inflate(2131627234, null);
    this.f = ((RelativeLayout)this.d.findViewById(2131447470));
    this.g = ((URLImageView)this.d.findViewById(2131447529));
    this.h = ((TextView)this.d.findViewById(2131447576));
    this.i = ((TextView)this.d.findViewById(2131438889));
    this.m = ((TextView)this.d.findViewById(2131442352));
    this.m.setOnClickListener(this);
    this.j = ((HotWordTipsContainer)this.d.findViewById(2131447419));
    this.k = this.d.findViewById(2131432026);
    this.l = this.d.findViewById(2131432027);
    this.e = ((URLImageView)this.d.findViewById(2131435163));
    if (!this.c) {
      this.k.setVisibility(8);
    } else {
      this.k.setVisibility(0);
    }
    this.j.setOnTipsClickListener(this.s);
    return this.d;
  }
  
  public void a()
  {
    int i1 = this.v;
    HotWordSearchEntryDataModel localHotWordSearchEntryDataModel;
    if (i1 != 7)
    {
      if (i1 != 8) {
        localHotWordSearchEntryDataModel = new HotWordSearchEntryDataModel(this.p, 1, this.a, this.u);
      } else {
        localHotWordSearchEntryDataModel = new HotWordSearchEntryDataModel(this.p, 8, this.a, this.u);
      }
    }
    else {
      localHotWordSearchEntryDataModel = new HotWordSearchEntryDataModel(this.p, 7, this.a, this.u);
    }
    ThreadManager.post(new HotWordSearchEntryModel.5(this, localHotWordSearchEntryDataModel), 5, null, true);
  }
  
  public void a(HotWordSearchEntryDataModel.TitleHeaderItem paramTitleHeaderItem)
  {
    int i1 = this.r.g;
    if (i1 != 1)
    {
      if (i1 != 8)
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
    if ((localObject2 != null) && (((HotWordSearchEntryDataModel)localObject2).b != null) && (((HotWordSearchEntryDataModel)localObject2).b.size() != 0))
    {
      this.r = ((HotWordSearchEntryDataModel)localObject2);
      this.d.setVisibility(0);
      this.n.clear();
      this.n.addAll(((HotWordSearchEntryDataModel)localObject2).b);
      this.j.a((HotWordSearchEntryDataModel)localObject2, this.a);
      if (((HotWordSearchEntryDataModel)localObject2).c == null)
      {
        this.f.setVisibility(8);
      }
      else
      {
        this.f.setVisibility(0);
        a(((HotWordSearchEntryDataModel)localObject2).c);
      }
      if ((!this.t) && (a(this.r.d)) && (this.a == 10)) {
        b(this.r.d);
      }
      Object localObject1 = (Boolean)SearchEntryFragment.mIsModelsReported.get(Integer.valueOf(this.r.g));
      if ((localObject1 == null) || (!((Boolean)localObject1).booleanValue()))
      {
        localObject1 = "";
        StringBuilder localStringBuilder1 = new StringBuilder("");
        if ((((HotWordSearchEntryDataModel)localObject2).b() != null) && (((HotWordSearchEntryDataModel)localObject2).b().size() > 0))
        {
          i2 = ((HotWordSearchEntryDataModel)localObject2).b().size();
          i1 = 0;
          int i3;
          for (;;)
          {
            i3 = i2 - 1;
            if (i1 >= i3) {
              break;
            }
            localStringBuilder1.append(((HotWordSearchEntryDataModel.HotSearchItem)((HotWordSearchEntryDataModel)localObject2).b().get(i1)).title);
            localStringBuilder1.append("::");
            i1 += 1;
          }
          localStringBuilder1.append(((HotWordSearchEntryDataModel.HotSearchItem)((HotWordSearchEntryDataModel)localObject2).b().get(i3)).title);
        }
        SearchUtils.a("hot_list", "exp_hot_list", new String[] { localStringBuilder1.toString(), String.valueOf(this.a) });
        SearchEntryFragment.mIsModelsReported.put(Integer.valueOf(this.r.g), Boolean.valueOf(true));
        localObject2 = new StringBuilder();
        if (this.n.size() > 0)
        {
          i1 = 0;
          while (i1 < this.n.size() - 1)
          {
            ((StringBuilder)localObject2).append(((HotWordSearchEntryDataModel.HotSearchItem)this.n.get(i1)).title);
            ((StringBuilder)localObject2).append("::");
            i1 += 1;
          }
          List localList = this.n;
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
        if (this.n.size() > 0) {
          localObject1 = ((HotWordSearchEntryDataModel.HotSearchItem)this.n.get(0)).sAppend;
        }
        int i2 = paramSearchEntryDataModel.g;
        int i1 = 21;
        StringBuilder localStringBuilder2;
        if (i2 == 7)
        {
          paramSearchEntryDataModel = new ReportModelDC02528().module("recom_list").action("exp_recom_list");
          if (this.a == 3) {
            i2 = 21;
          } else {
            i2 = this.a;
          }
          paramSearchEntryDataModel = paramSearchEntryDataModel.ver2(UniteSearchReportController.a(i2)).ver4(localStringBuilder1.toString()).ver7(((JSONObject)localObject2).toString());
          localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append(localQQAppInterface.getCurrentAccountUin());
          localStringBuilder2.append(this.b);
          UniteSearchReportController.a(null, paramSearchEntryDataModel.session_id(localStringBuilder2.toString()));
          if (this.a != 3) {
            i1 = this.a;
          }
          ((UniteSearchHandler)localObject3).b(localQQAppInterface, "exp_recom_list", "recom_list", UniteSearchReportController.a(i1), (String)localObject1, localStringBuilder1.toString(), ((JSONObject)localObject2).toString());
        }
        else
        {
          paramSearchEntryDataModel = new ReportModelDC02528().module("hot_list").action("exp_hot_list");
          if (this.a == 3) {
            i2 = 21;
          } else {
            i2 = this.a;
          }
          paramSearchEntryDataModel = paramSearchEntryDataModel.ver2(UniteSearchReportController.a(i2)).ver4(localStringBuilder1.toString()).ver7(((JSONObject)localObject2).toString());
          localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append(localQQAppInterface.getCurrentAccountUin());
          localStringBuilder2.append(this.b);
          UniteSearchReportController.a(null, paramSearchEntryDataModel.session_id(localStringBuilder2.toString()));
          if (this.a != 3) {
            i1 = this.a;
          }
          ((UniteSearchHandler)localObject3).b(localQQAppInterface, "exp_hot_list", "hot_list", UniteSearchReportController.a(i1), (String)localObject1, localStringBuilder1.toString(), ((JSONObject)localObject2).toString());
        }
        UniteSearchReportController.a(localQQAppInterface, 0, SearchEntryFragment.b(this.a), "0X8009D27", 0, 0, null, null);
      }
      return;
    }
    this.d.setVisibility(8);
  }
  
  public void d()
  {
    if (this.e.getVisibility() != 8)
    {
      this.e.setImageDrawable(null);
      this.e.setVisibility(8);
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131442352)
    {
      Object localObject1 = this.r;
      if ((localObject1 != null) && (((HotWordSearchEntryDataModel)localObject1).c != null) && (!TextUtils.isEmpty(this.r.c.f))) {
        a(this.r.c.f, "");
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
      SearchUtils.a("hot_list", "clk_qq_index", new String[] { "", String.valueOf(this.a) });
      Object localObject2 = new ReportModelDC02528().module("hot_list").action("clk_qq_index");
      int i1;
      if (this.a == 3) {
        i1 = 21;
      } else {
        i1 = this.a;
      }
      localObject1 = ((ReportModelDC02528)localObject2).ver2(UniteSearchReportController.a(i1)).ver7(((JSONObject)localObject1).toString());
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(this.p.getCurrentAccountUin());
      ((StringBuilder)localObject2).append(this.b);
      UniteSearchReportController.a(null, ((ReportModelDC02528)localObject1).session_id(((StringBuilder)localObject2).toString()));
      UniteSearchReportController.a(this.p, 0, SearchEntryFragment.b(this.a), "0X8009D28", 0, 0, null, null);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.HotWordSearchEntryModel
 * JD-Core Version:    0.7.0.1
 */