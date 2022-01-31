package com.tencent.mobileqq.search;

import ahrc;
import ahrd;
import ahre;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.widgets.HotWordTipsContainer;
import com.tencent.biz.widgets.HotWordTipsContainer.OnTipClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.search.fragment.SearchEntryFragment;
import com.tencent.mobileqq.search.model.HotWordSearchEntryDataModel;
import com.tencent.mobileqq.search.model.HotWordSearchEntryDataModel.HotSearchItem;
import com.tencent.mobileqq.search.model.HotWordSearchEntryDataModel.TitleHeaderItem;
import com.tencent.mobileqq.search.model.SearchEntryDataModel;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.mobileqq.search.report.UniteSearchReportController;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class HotWordSearchEntryModel
  extends BaseSearchEntryModel
{
  protected static int b;
  public Context a;
  protected View a;
  protected RelativeLayout a;
  protected TextView a;
  HotWordTipsContainer.OnTipClickListener a;
  protected HotWordTipsContainer a;
  protected URLImageView a;
  public QQAppInterface a;
  public List a;
  public boolean a;
  protected View b;
  protected TextView b;
  protected View c;
  
  static
  {
    jdField_b_of_type_Int = -1;
  }
  
  public HotWordSearchEntryModel(int paramInt)
  {
    super(paramInt);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentBizWidgetsHotWordTipsContainer$OnTipClickListener = new ahrc(this);
  }
  
  public View a(Context paramContext, QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    paramBundle = paramQQAppInterface;
    if (paramQQAppInterface == null) {
      if (!(paramContext instanceof BaseActivity)) {
        break label295;
      }
    }
    label284:
    label295:
    for (paramViewGroup = ((BaseActivity)paramContext).getAppRuntime();; paramViewGroup = null)
    {
      paramBundle = paramQQAppInterface;
      if ((paramViewGroup instanceof QQAppInterface)) {
        paramBundle = (QQAppInterface)paramViewGroup;
      }
      if (paramBundle == null) {
        return new View(paramContext);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramBundle;
      this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(paramContext).inflate(2130970166, null);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131362777));
      this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369392));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369393));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369394));
      this.jdField_a_of_type_ComTencentBizWidgetsHotWordTipsContainer = ((HotWordTipsContainer)this.jdField_a_of_type_AndroidViewView.findViewById(2131362728));
      this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131369391);
      this.c = this.jdField_a_of_type_AndroidViewView.findViewById(2131369395);
      if (ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime()))
      {
        this.jdField_b_of_type_AndroidViewView.setBackgroundColor(Color.parseColor("#040E1C"));
        this.c.findViewById(2131369395).setBackgroundColor(Color.parseColor("#040E1C"));
        this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130838580);
        if (this.jdField_a_of_type_Boolean) {
          break label284;
        }
        this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentBizWidgetsHotWordTipsContainer.setOnTipsClickListener(this.jdField_a_of_type_ComTencentBizWidgetsHotWordTipsContainer$OnTipClickListener);
        return this.jdField_a_of_type_AndroidViewView;
        this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130838579);
        break;
        this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      }
    }
  }
  
  public void a()
  {
    ThreadManager.post(new ahre(this, new HotWordSearchEntryDataModel(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, this.jdField_a_of_type_Int)), 5, null, true);
  }
  
  public void a(HotWordSearchEntryDataModel.TitleHeaderItem paramTitleHeaderItem)
  {
    Object localObject;
    if (!TextUtils.isEmpty(paramTitleHeaderItem.b))
    {
      localObject = new ColorDrawable();
      if (ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime()))
      {
        ((ColorDrawable)localObject).setColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131492956));
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject);
        localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject);
        localObject = URLDrawable.getDrawable(paramTitleHeaderItem.b, localURLDrawableOptions);
        this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
        label77:
        if (TextUtils.isEmpty(paramTitleHeaderItem.a)) {
          break label167;
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setText(paramTitleHeaderItem.a);
        label98:
        if (TextUtils.isEmpty(paramTitleHeaderItem.c)) {
          break label179;
        }
        this.jdField_b_of_type_AndroidWidgetTextView.setText(paramTitleHeaderItem.c);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new ahrd(this, paramTitleHeaderItem));
      return;
      ((ColorDrawable)localObject).setColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131492955));
      break;
      this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
      break label77;
      label167:
      this.jdField_a_of_type_AndroidWidgetTextView.setText("热搜");
      break label98;
      label179:
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    }
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
    Object localObject = (HotWordSearchEntryDataModel)paramSearchEntryDataModel;
    if ((localObject == null) || (((HotWordSearchEntryDataModel)localObject).jdField_a_of_type_JavaUtilList == null) || (((HotWordSearchEntryDataModel)localObject).jdField_a_of_type_JavaUtilList.size() == 0))
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(((HotWordSearchEntryDataModel)localObject).jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_ComTencentBizWidgetsHotWordTipsContainer.a((HotWordSearchEntryDataModel)localObject);
    if (((HotWordSearchEntryDataModel)localObject).jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$TitleHeaderItem == null) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    }
    int i;
    for (;;)
    {
      paramSearchEntryDataModel = (Boolean)SearchEntryFragment.a.get(Integer.valueOf(1));
      if ((paramSearchEntryDataModel != null) && (paramSearchEntryDataModel.booleanValue())) {
        break;
      }
      paramSearchEntryDataModel = new StringBuilder("");
      if (((HotWordSearchEntryDataModel)localObject).jdField_a_of_type_JavaUtilList.size() <= 0) {
        break label288;
      }
      int j = ((HotWordSearchEntryDataModel)localObject).jdField_a_of_type_JavaUtilList.size();
      i = j;
      if (((HotWordSearchEntryDataModel.HotSearchItem)((HotWordSearchEntryDataModel)localObject).jdField_a_of_type_JavaUtilList.get(((HotWordSearchEntryDataModel)localObject).jdField_a_of_type_JavaUtilList.size() - 1)).showType == 2) {
        i = j - 1;
      }
      j = 0;
      while (j < i - 1)
      {
        paramSearchEntryDataModel.append(((HotWordSearchEntryDataModel.HotSearchItem)((HotWordSearchEntryDataModel)localObject).jdField_a_of_type_JavaUtilList.get(j)).title).append("::");
        j += 1;
      }
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      a(((HotWordSearchEntryDataModel)localObject).jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$TitleHeaderItem);
    }
    paramSearchEntryDataModel.append(((HotWordSearchEntryDataModel.HotSearchItem)((HotWordSearchEntryDataModel)localObject).jdField_a_of_type_JavaUtilList.get(i - 1)).title);
    label288:
    SearchUtils.a("hot_list", "exp_hot_list", new String[] { paramSearchEntryDataModel.toString(), String.valueOf(this.jdField_a_of_type_Int) });
    SearchEntryFragment.a.put(Integer.valueOf(1), Boolean.valueOf(true));
    localObject = new StringBuilder();
    if (this.jdField_a_of_type_JavaUtilList.size() > 0)
    {
      i = 0;
      while (i < this.jdField_a_of_type_JavaUtilList.size() - 1)
      {
        ((StringBuilder)localObject).append(((HotWordSearchEntryDataModel.HotSearchItem)this.jdField_a_of_type_JavaUtilList.get(i)).title).append("::");
        i += 1;
      }
      ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_JavaUtilList.size() - 1));
    }
    localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("project", UniteSearchReportController.a());
      ((JSONObject)localObject).put("event_src", "client");
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      ReportModelDC02528 localReportModelDC02528 = new ReportModelDC02528().module("hot_list").action("exp_hot_list");
      if (this.jdField_a_of_type_Int == 3)
      {
        i = 21;
        UniteSearchReportController.a(null, localReportModelDC02528.ver2(UniteSearchReportController.a(i)).ver4(paramSearchEntryDataModel.toString()).ver7(((JSONObject)localObject).toString()).session_id(localQQAppInterface.getCurrentAccountUin() + this.jdField_a_of_type_Long));
        return;
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QLog.e("Q.uniteSearch.HotWordSearchEntryModel", 2, "e = " + localJSONException);
        continue;
        i = this.jdField_a_of_type_Int;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.search.HotWordSearchEntryModel
 * JD-Core Version:    0.7.0.1
 */