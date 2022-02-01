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
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.SharedPreUtils;
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
    if (paramQQAppInterface == null) {
      if (!(paramContext instanceof BaseActivity)) {
        break label97;
      }
    }
    label97:
    for (paramViewGroup = ((BaseActivity)paramContext).getAppRuntime();; paramViewGroup = null)
    {
      paramBundle = paramQQAppInterface;
      if ((paramViewGroup instanceof QQAppInterface)) {
        paramBundle = (QQAppInterface)paramViewGroup;
      }
      if (paramBundle == null) {
        return new View(paramContext);
      }
      this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(paramContext).inflate(2131563182, null);
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131370617));
      return this.jdField_a_of_type_AndroidViewView;
    }
  }
  
  public List<Integer> a()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(2131365862));
    localArrayList.add(Integer.valueOf(2131365866));
    localArrayList.add(Integer.valueOf(2131365867));
    localArrayList.add(Integer.valueOf(2131365868));
    localArrayList.add(Integer.valueOf(2131365869));
    localArrayList.add(Integer.valueOf(2131365870));
    localArrayList.add(Integer.valueOf(2131365871));
    localArrayList.add(Integer.valueOf(2131365872));
    localArrayList.add(Integer.valueOf(2131365873));
    localArrayList.add(Integer.valueOf(2131365863));
    localArrayList.add(Integer.valueOf(2131365864));
    localArrayList.add(Integer.valueOf(2131365865));
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
    localArrayList.add(Integer.valueOf(2131365862));
    localArrayList.add(Integer.valueOf(2131365866));
    localArrayList.add(Integer.valueOf(2131365867));
    localArrayList.add(Integer.valueOf(2131365868));
    localArrayList.add(Integer.valueOf(2131365869));
    localArrayList.add(Integer.valueOf(2131365871));
    localArrayList.add(Integer.valueOf(2131365872));
    localArrayList.add(Integer.valueOf(2131365873));
    localArrayList.add(Integer.valueOf(2131365863));
    localArrayList.add(Integer.valueOf(2131365864));
    return localArrayList;
  }
  
  public void b(SearchEntryDataModel paramSearchEntryDataModel)
  {
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin();
    paramSearchEntryDataModel = (BusinessSearchEntryDataModel)paramSearchEntryDataModel;
    if (paramSearchEntryDataModel == null) {}
    for (;;)
    {
      return;
      Object localObject1 = paramSearchEntryDataModel.a;
      if ((localObject1 != null) && (((List)localObject1).size() != 0))
      {
        label78:
        int i;
        label80:
        BusinessSearchEntryDataModel.SearchEntry localSearchEntry;
        View localView1;
        View localView2;
        Object localObject3;
        if (((List)localObject1).size() <= 6)
        {
          this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
          if (((List)localObject1).size() != 10) {
            break label424;
          }
          paramSearchEntryDataModel = b();
          i = 0;
          if (i >= ((List)localObject1).size()) {
            break label463;
          }
          localSearchEntry = (BusinessSearchEntryDataModel.SearchEntry)((List)localObject1).get(i);
          localView1 = this.jdField_a_of_type_AndroidViewView.findViewById(((Integer)paramSearchEntryDataModel.get(i)).intValue());
          localView2 = localView1.findViewById(2131376828);
          TextView localTextView = (TextView)localView1.findViewById(2131365861);
          URLImageView localURLImageView = (URLImageView)localView1.findViewById(2131365860);
          localView1.setVisibility(0);
          localObject3 = new ColorDrawable();
          if (!ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime())) {
            break label432;
          }
          ((ColorDrawable)localObject3).setColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167337));
          label209:
          if (!TextUtils.isEmpty(localSearchEntry.jdField_b_of_type_JavaLangString))
          {
            URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
            localURLDrawableOptions.mRequestHeight = AIOUtils.a(28.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
            localURLDrawableOptions.mRequestWidth = AIOUtils.a(28.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
            localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject3);
            localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject3);
            localObject3 = URLDrawable.getDrawable(localSearchEntry.jdField_b_of_type_JavaLangString, localURLDrawableOptions);
            if (localURLImageView != null) {
              localURLImageView.setImageDrawable((Drawable)localObject3);
            }
          }
          localTextView.setText(localSearchEntry.jdField_a_of_type_JavaLangString);
          int j = SharedPreUtils.a(localSearchEntry.c, (String)localObject2);
          boolean bool = SharedPreUtils.a(localSearchEntry.c, (String)localObject2);
          if ((localSearchEntry.jdField_a_of_type_Int != 1) || ((localSearchEntry.jdField_b_of_type_Int <= j) && ((localSearchEntry.jdField_b_of_type_Int != j) || (bool)))) {
            break label453;
          }
          localView2.setVisibility(0);
        }
        for (;;)
        {
          SharedPreUtils.a(localSearchEntry.c, localSearchEntry.jdField_b_of_type_Int, (String)localObject2);
          localView1.setOnClickListener(new BusinessSearchEntryModel.1(this, localView1, localSearchEntry, localView2, (String)localObject2, (List)localObject1));
          i += 1;
          break label80;
          this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
          break;
          label424:
          paramSearchEntryDataModel = a();
          break label78;
          label432:
          ((ColorDrawable)localObject3).setColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167336));
          break label209;
          label453:
          localView2.setVisibility(8);
        }
        label463:
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
          this.jdField_a_of_type_AndroidViewView.findViewById(2131365871).setVisibility(8);
          this.jdField_a_of_type_AndroidViewView.findViewById(2131365872).setVisibility(8);
          this.jdField_a_of_type_AndroidViewView.findViewById(2131365873).setVisibility(8);
          this.jdField_a_of_type_AndroidViewView.findViewById(2131365863).setVisibility(8);
          this.jdField_a_of_type_AndroidViewView.findViewById(2131365864).setVisibility(8);
          this.jdField_a_of_type_AndroidViewView.findViewById(2131365865).setVisibility(8);
          paramSearchEntryDataModel = new StringBuilder("");
          i = 0;
          label630:
          if (i >= ((List)localObject1).size()) {
            break label751;
          }
          if (i != ((List)localObject1).size() - 1) {
            break label723;
          }
          paramSearchEntryDataModel.append(((BusinessSearchEntryDataModel.SearchEntry)((List)localObject1).get(i)).jdField_a_of_type_JavaLangString);
        }
        for (;;)
        {
          i += 1;
          break label630;
          if (((List)localObject1).size() != 10) {
            break;
          }
          this.jdField_a_of_type_AndroidViewView.findViewById(2131365870).setVisibility(8);
          this.jdField_a_of_type_AndroidViewView.findViewById(2131365865).setVisibility(8);
          break;
          label723:
          paramSearchEntryDataModel.append(((BusinessSearchEntryDataModel.SearchEntry)((List)localObject1).get(i)).jdField_a_of_type_JavaLangString).append("::");
        }
        label751:
        localObject2 = (Boolean)SearchEntryFragment.mIsModelsReported.get(Integer.valueOf(3));
        if ((localObject2 == null) || (!((Boolean)localObject2).booleanValue()))
        {
          SearchUtils.a("home_page", "exp_entry", new String[] { paramSearchEntryDataModel.toString(), "", String.valueOf(this.jdField_a_of_type_Int) });
          UniteSearchReportController.a(null, new ReportModelDC02528().module("all_result").action("exp_entry").ver2(UniteSearchReportController.a(this.jdField_a_of_type_Int)).ver4(paramSearchEntryDataModel.toString()).ver7("{experiment_id:" + UniteSearchReportController.jdField_b_of_type_JavaLangString + "}"));
          localObject2 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
          new UniteSearchHandler((QQAppInterface)localObject2).b((QQAppInterface)localObject2, "exp_entry", "all_result", UniteSearchReportController.a(this.jdField_a_of_type_Int), "", paramSearchEntryDataModel.toString(), "{experiment_id:" + UniteSearchReportController.jdField_b_of_type_JavaLangString + "}");
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.BusinessSearchEntryModel
 * JD-Core Version:    0.7.0.1
 */