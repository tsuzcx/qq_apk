package com.tencent.mobileqq.kandian.biz.daily;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.kandian.base.report.ReadInJoyMMapKvStorage;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.mobileqq.kandian.glue.report.dt.RIJDtReportHelper;
import com.tencent.mobileqq.kandian.repo.daily.ReadInJoyDailySettingModel;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;

public class ReadInJoyDailySettingFragment
  extends IphoneTitleBarFragment
{
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private ReadInJoyDailySettingAdapter jdField_a_of_type_ComTencentMobileqqKandianBizDailyReadInJoyDailySettingAdapter;
  private List<ReadInJoyDailySettingModel> jdField_a_of_type_JavaUtilList = new ArrayList();
  private List<ReadInJoyDailySettingModel> b;
  
  public ReadInJoyDailySettingFragment()
  {
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
  }
  
  private void a()
  {
    if (this.mContentView != null)
    {
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)this.mContentView.findViewById(2131369612));
      LinearLayoutManager localLinearLayoutManager = new LinearLayoutManager(getBaseActivity());
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(localLinearLayoutManager);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizDailyReadInJoyDailySettingAdapter = new ReadInJoyDailySettingAdapter(getBaseActivity(), this.jdField_a_of_type_JavaUtilList, this.jdField_b_of_type_JavaUtilList);
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqKandianBizDailyReadInJoyDailySettingAdapter);
      setTitle(HardCodeUtil.a(2131713034));
      d();
    }
  }
  
  private void b()
  {
    ReadInJoyDailySettingModel localReadInJoyDailySettingModel = new ReadInJoyDailySettingModel();
    localReadInJoyDailySettingModel.jdField_b_of_type_JavaLangString = HardCodeUtil.a(2131712994);
    localReadInJoyDailySettingModel.jdField_a_of_type_JavaLangString = "open_reason";
    localReadInJoyDailySettingModel.c = ((String)RIJSPUtils.a("readinjoy_show_recommend_reason_in_title_b", ""));
    String str = (String)RIJSPUtils.a("readinjoy_show_recommend_reason_in_title_b", "");
    if ("1".equals(str)) {
      localReadInJoyDailySettingModel.d = HardCodeUtil.a(2131712744);
    } else if ("0".equals(str)) {
      localReadInJoyDailySettingModel.d = HardCodeUtil.a(2131713038);
    } else {
      localReadInJoyDailySettingModel.d = "";
    }
    localReadInJoyDailySettingModel.jdField_b_of_type_JavaUtilList = new ArrayList();
    localReadInJoyDailySettingModel.jdField_b_of_type_JavaUtilList.add("");
    localReadInJoyDailySettingModel.jdField_b_of_type_JavaUtilList.add(HardCodeUtil.a(2131712664));
    localReadInJoyDailySettingModel.jdField_b_of_type_JavaUtilList.add(HardCodeUtil.a(2131712682));
    localReadInJoyDailySettingModel.jdField_a_of_type_JavaUtilList = new ArrayList();
    localReadInJoyDailySettingModel.jdField_a_of_type_JavaUtilList.add("");
    localReadInJoyDailySettingModel.jdField_a_of_type_JavaUtilList.add("1");
    localReadInJoyDailySettingModel.jdField_a_of_type_JavaUtilList.add("0");
    this.jdField_b_of_type_JavaUtilList.add(localReadInJoyDailySettingModel);
  }
  
  private void c()
  {
    Object localObject = ReadInJoyMMapKvStorage.getInstance().getValeForKey("KANDIAN_DAILY_SETTING_CONFIG");
    if (localObject != null) {
      try
      {
        localObject = new JSONArray((String)localObject);
        int i = 0;
        while (i < ((JSONArray)localObject).length())
        {
          ReadInJoyDailySettingModel localReadInJoyDailySettingModel = ReadInJoyDailySettingModel.a(((JSONArray)localObject).optJSONObject(i));
          this.jdField_a_of_type_JavaUtilList.add(localReadInJoyDailySettingModel);
          i += 1;
        }
        return;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  private void d()
  {
    b();
    c();
    this.jdField_a_of_type_ComTencentMobileqqKandianBizDailyReadInJoyDailySettingAdapter.notifyDataSetChanged();
  }
  
  protected int getContentLayoutId()
  {
    return 2131560168;
  }
  
  public void onDestroy()
  {
    int i = this.jdField_b_of_type_JavaUtilList.size();
    int j = 0;
    JSONArray localJSONArray;
    if (i > 0)
    {
      localJSONArray = new JSONArray();
      i = 0;
      while (i < this.jdField_b_of_type_JavaUtilList.size())
      {
        localJSONArray.put(((ReadInJoyDailySettingModel)this.jdField_b_of_type_JavaUtilList.get(i)).a());
        i += 1;
      }
      RIJSPUtils.a("KANDIAN_DAILY_LCAOL_SETTING_CONFIG", localJSONArray.toString());
    }
    if (this.jdField_a_of_type_JavaUtilList.size() > 0)
    {
      localJSONArray = new JSONArray();
      i = j;
      while (i < this.jdField_a_of_type_JavaUtilList.size())
      {
        localJSONArray.put(((ReadInJoyDailySettingModel)this.jdField_a_of_type_JavaUtilList.get(i)).a());
        i += 1;
      }
      ReadInJoyMMapKvStorage.getInstance().update("KANDIAN_DAILY_SETTING_CONFIG", localJSONArray.toString());
    }
    ReadInJoyDailySettingModel.a();
    super.onDestroy();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    a();
    RIJDtReportHelper.a.a(getBaseActivity());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.daily.ReadInJoyDailySettingFragment
 * JD-Core Version:    0.7.0.1
 */