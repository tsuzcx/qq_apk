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
  private RecyclerView a;
  private ReadInJoyDailySettingAdapter b;
  private List<ReadInJoyDailySettingModel> c = new ArrayList();
  private List<ReadInJoyDailySettingModel> d = new ArrayList();
  
  private void a()
  {
    if (this.mContentView != null)
    {
      this.a = ((RecyclerView)this.mContentView.findViewById(2131436720));
      LinearLayoutManager localLinearLayoutManager = new LinearLayoutManager(getBaseActivity());
      this.a.setLayoutManager(localLinearLayoutManager);
      this.b = new ReadInJoyDailySettingAdapter(getBaseActivity(), this.c, this.d);
      this.a.setAdapter(this.b);
      setTitle(HardCodeUtil.a(2131910595));
      d();
    }
  }
  
  private void b()
  {
    ReadInJoyDailySettingModel localReadInJoyDailySettingModel = new ReadInJoyDailySettingModel();
    localReadInJoyDailySettingModel.b = HardCodeUtil.a(2131910558);
    localReadInJoyDailySettingModel.a = "open_reason";
    localReadInJoyDailySettingModel.c = ((String)RIJSPUtils.b("readinjoy_show_recommend_reason_in_title_b", ""));
    String str = (String)RIJSPUtils.b("readinjoy_show_recommend_reason_in_title_b", "");
    if ("1".equals(str)) {
      localReadInJoyDailySettingModel.d = HardCodeUtil.a(2131910319);
    } else if ("0".equals(str)) {
      localReadInJoyDailySettingModel.d = HardCodeUtil.a(2131910599);
    } else {
      localReadInJoyDailySettingModel.d = "";
    }
    localReadInJoyDailySettingModel.f = new ArrayList();
    localReadInJoyDailySettingModel.f.add("");
    localReadInJoyDailySettingModel.f.add(HardCodeUtil.a(2131910242));
    localReadInJoyDailySettingModel.f.add(HardCodeUtil.a(2131910260));
    localReadInJoyDailySettingModel.e = new ArrayList();
    localReadInJoyDailySettingModel.e.add("");
    localReadInJoyDailySettingModel.e.add("1");
    localReadInJoyDailySettingModel.e.add("0");
    this.d.add(localReadInJoyDailySettingModel);
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
          this.c.add(localReadInJoyDailySettingModel);
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
    this.b.notifyDataSetChanged();
  }
  
  protected int getContentLayoutId()
  {
    return 2131626215;
  }
  
  public void onDestroy()
  {
    int i = this.d.size();
    int j = 0;
    JSONArray localJSONArray;
    if (i > 0)
    {
      localJSONArray = new JSONArray();
      i = 0;
      while (i < this.d.size())
      {
        localJSONArray.put(((ReadInJoyDailySettingModel)this.d.get(i)).a());
        i += 1;
      }
      RIJSPUtils.a("KANDIAN_DAILY_LCAOL_SETTING_CONFIG", localJSONArray.toString());
    }
    if (this.c.size() > 0)
    {
      localJSONArray = new JSONArray();
      i = j;
      while (i < this.c.size())
      {
        localJSONArray.put(((ReadInJoyDailySettingModel)this.c.get(i)).a());
        i += 1;
      }
      ReadInJoyMMapKvStorage.getInstance().update("KANDIAN_DAILY_SETTING_CONFIG", localJSONArray.toString());
    }
    ReadInJoyDailySettingModel.b();
    super.onDestroy();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    a();
    RIJDtReportHelper.a.a(getBaseActivity());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.daily.ReadInJoyDailySettingFragment
 * JD-Core Version:    0.7.0.1
 */