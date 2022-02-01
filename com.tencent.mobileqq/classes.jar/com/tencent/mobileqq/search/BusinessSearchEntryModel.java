package com.tencent.mobileqq.search;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.UniteSearchHandler;
import com.tencent.mobileqq.search.fragment.SearchEntryFragment;
import com.tencent.mobileqq.search.model.BusinessSearchEntryDataModel;
import com.tencent.mobileqq.search.model.BusinessSearchEntryDataModel.SearchEntry;
import com.tencent.mobileqq.search.model.SearchEntryDataModel;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.mobileqq.search.report.UniteSearchReportController;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class BusinessSearchEntryModel
  extends BaseSearchEntryModel<View>
{
  private Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private boolean b = false;
  
  public BusinessSearchEntryModel(int paramInt, boolean paramBoolean)
  {
    super(paramInt);
    this.b = paramBoolean;
  }
  
  public View a(Context paramContext, QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
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
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(paramContext).inflate(2131563007, null);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131370270));
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public List<Integer> a()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(2131365699));
    localArrayList.add(Integer.valueOf(2131365703));
    localArrayList.add(Integer.valueOf(2131365704));
    localArrayList.add(Integer.valueOf(2131365705));
    localArrayList.add(Integer.valueOf(2131365706));
    localArrayList.add(Integer.valueOf(2131365707));
    localArrayList.add(Integer.valueOf(2131365708));
    localArrayList.add(Integer.valueOf(2131365709));
    localArrayList.add(Integer.valueOf(2131365710));
    localArrayList.add(Integer.valueOf(2131365700));
    localArrayList.add(Integer.valueOf(2131365701));
    localArrayList.add(Integer.valueOf(2131365702));
    return localArrayList;
  }
  
  public void a()
  {
    ThreadManager.post(new BusinessSearchEntryModel.2(this, new BusinessSearchEntryDataModel(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 3, this.jdField_a_of_type_Int, this.b)), 5, null, true);
  }
  
  public void a(SearchEntryDataModel paramSearchEntryDataModel)
  {
    b(paramSearchEntryDataModel);
  }
  
  public List<Integer> b()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(2131365699));
    localArrayList.add(Integer.valueOf(2131365703));
    localArrayList.add(Integer.valueOf(2131365704));
    localArrayList.add(Integer.valueOf(2131365705));
    localArrayList.add(Integer.valueOf(2131365706));
    localArrayList.add(Integer.valueOf(2131365708));
    localArrayList.add(Integer.valueOf(2131365709));
    localArrayList.add(Integer.valueOf(2131365710));
    localArrayList.add(Integer.valueOf(2131365700));
    localArrayList.add(Integer.valueOf(2131365701));
    return localArrayList;
  }
  
  public void b(SearchEntryDataModel paramSearchEntryDataModel)
  {
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin();
    paramSearchEntryDataModel = (BusinessSearchEntryDataModel)paramSearchEntryDataModel;
    if (paramSearchEntryDataModel == null) {
      return;
    }
    Object localObject1 = paramSearchEntryDataModel.a;
    if (localObject1 != null)
    {
      if (((List)localObject1).size() == 0) {
        return;
      }
      if (((List)localObject1).size() <= 6) {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      } else {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      }
      if (((List)localObject1).size() == 10) {
        paramSearchEntryDataModel = b();
      } else {
        paramSearchEntryDataModel = a();
      }
      int i = 0;
      Object localObject3;
      Object localObject4;
      Object localObject5;
      while (i < ((List)localObject1).size())
      {
        localObject3 = (BusinessSearchEntryDataModel.SearchEntry)((List)localObject1).get(i);
        localObject4 = this.jdField_a_of_type_AndroidViewView.findViewById(((Integer)paramSearchEntryDataModel.get(i)).intValue());
        localObject5 = ((View)localObject4).findViewById(2131376320);
        TextView localTextView = (TextView)((View)localObject4).findViewById(2131365698);
        URLImageView localURLImageView = (URLImageView)((View)localObject4).findViewById(2131365697);
        ((View)localObject4).setVisibility(0);
        Object localObject6 = new ColorDrawable();
        if (ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime())) {
          ((ColorDrawable)localObject6).setColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167365));
        } else {
          ((ColorDrawable)localObject6).setColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167364));
        }
        if (!TextUtils.isEmpty(((BusinessSearchEntryDataModel.SearchEntry)localObject3).jdField_b_of_type_JavaLangString))
        {
          URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
          localURLDrawableOptions.mRequestHeight = AIOUtils.b(28.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
          localURLDrawableOptions.mRequestWidth = AIOUtils.b(28.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
          localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject6);
          localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject6);
          localObject6 = URLDrawable.getDrawable(((BusinessSearchEntryDataModel.SearchEntry)localObject3).jdField_b_of_type_JavaLangString, localURLDrawableOptions);
          if (localURLImageView != null) {
            localURLImageView.setImageDrawable((Drawable)localObject6);
          }
        }
        localTextView.setText(((BusinessSearchEntryDataModel.SearchEntry)localObject3).jdField_a_of_type_JavaLangString);
        int j = SharedPreUtils.a(((BusinessSearchEntryDataModel.SearchEntry)localObject3).c, (String)localObject2);
        boolean bool = SharedPreUtils.a(((BusinessSearchEntryDataModel.SearchEntry)localObject3).c, (String)localObject2);
        if ((((BusinessSearchEntryDataModel.SearchEntry)localObject3).jdField_a_of_type_Int == 1) && ((((BusinessSearchEntryDataModel.SearchEntry)localObject3).jdField_b_of_type_Int > j) || ((((BusinessSearchEntryDataModel.SearchEntry)localObject3).jdField_b_of_type_Int == j) && (!bool)))) {
          ((View)localObject5).setVisibility(0);
        } else {
          ((View)localObject5).setVisibility(8);
        }
        SharedPreUtils.a(((BusinessSearchEntryDataModel.SearchEntry)localObject3).c, ((BusinessSearchEntryDataModel.SearchEntry)localObject3).jdField_b_of_type_Int, (String)localObject2);
        ((View)localObject4).setOnClickListener(new BusinessSearchEntryModel.1(this, (View)localObject4, (BusinessSearchEntryDataModel.SearchEntry)localObject3, (View)localObject5, (String)localObject2, (List)localObject1));
        i += 1;
      }
      if (((List)localObject1).size() < 6)
      {
        i = ((List)localObject1).size();
        while (i < 6)
        {
          this.jdField_a_of_type_AndroidViewView.findViewById(((Integer)paramSearchEntryDataModel.get(i)).intValue()).setVisibility(8);
          i += 1;
        }
      }
      if (((List)localObject1).size() == 6)
      {
        this.jdField_a_of_type_AndroidViewView.findViewById(2131365708).setVisibility(8);
        this.jdField_a_of_type_AndroidViewView.findViewById(2131365709).setVisibility(8);
        this.jdField_a_of_type_AndroidViewView.findViewById(2131365710).setVisibility(8);
        this.jdField_a_of_type_AndroidViewView.findViewById(2131365700).setVisibility(8);
        this.jdField_a_of_type_AndroidViewView.findViewById(2131365701).setVisibility(8);
        this.jdField_a_of_type_AndroidViewView.findViewById(2131365702).setVisibility(8);
      }
      else if (((List)localObject1).size() == 10)
      {
        this.jdField_a_of_type_AndroidViewView.findViewById(2131365707).setVisibility(8);
        this.jdField_a_of_type_AndroidViewView.findViewById(2131365702).setVisibility(8);
      }
      paramSearchEntryDataModel = new StringBuilder("");
      i = 0;
      while (i < ((List)localObject1).size())
      {
        if (i == ((List)localObject1).size() - 1)
        {
          paramSearchEntryDataModel.append(((BusinessSearchEntryDataModel.SearchEntry)((List)localObject1).get(i)).jdField_a_of_type_JavaLangString);
        }
        else
        {
          paramSearchEntryDataModel.append(((BusinessSearchEntryDataModel.SearchEntry)((List)localObject1).get(i)).jdField_a_of_type_JavaLangString);
          paramSearchEntryDataModel.append("::");
        }
        i += 1;
      }
      localObject2 = (Boolean)SearchEntryFragment.mIsModelsReported.get(Integer.valueOf(3));
      if ((localObject2 == null) || (!((Boolean)localObject2).booleanValue()))
      {
        SearchUtils.a("home_page", "exp_entry", new String[] { paramSearchEntryDataModel.toString(), "", String.valueOf(this.jdField_a_of_type_Int) });
        localObject2 = new ReportModelDC02528().module("all_result").action("exp_entry").ver2(UniteSearchReportController.a(this.jdField_a_of_type_Int)).ver4(paramSearchEntryDataModel.toString());
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("{experiment_id:");
        ((StringBuilder)localObject3).append(UniteSearchReportController.jdField_b_of_type_JavaLangString);
        ((StringBuilder)localObject3).append("}");
        UniteSearchReportController.a(null, ((ReportModelDC02528)localObject2).ver7(((StringBuilder)localObject3).toString()));
        localObject2 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
        localObject3 = new UniteSearchHandler((QQAppInterface)localObject2);
        localObject4 = UniteSearchReportController.a(this.jdField_a_of_type_Int);
        paramSearchEntryDataModel = paramSearchEntryDataModel.toString();
        localObject5 = new StringBuilder();
        ((StringBuilder)localObject5).append("{experiment_id:");
        ((StringBuilder)localObject5).append(UniteSearchReportController.jdField_b_of_type_JavaLangString);
        ((StringBuilder)localObject5).append("}");
        ((UniteSearchHandler)localObject3).b((QQAppInterface)localObject2, "exp_entry", "all_result", (String)localObject4, "", paramSearchEntryDataModel, ((StringBuilder)localObject5).toString());
        SearchEntryFragment.mIsModelsReported.put(Integer.valueOf(3), Boolean.valueOf(true));
        i = SearchEntryFragment.a(this.jdField_a_of_type_Int);
        paramSearchEntryDataModel = ((List)localObject1).iterator();
        while (paramSearchEntryDataModel.hasNext())
        {
          localObject1 = (BusinessSearchEntryDataModel.SearchEntry)paramSearchEntryDataModel.next();
          if (localObject1 != null) {
            UniteSearchReportController.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0, i, "0X8009D1B", 0, 0, ((BusinessSearchEntryDataModel.SearchEntry)localObject1).jdField_a_of_type_JavaLangString, null);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.BusinessSearchEntryModel
 * JD-Core Version:    0.7.0.1
 */