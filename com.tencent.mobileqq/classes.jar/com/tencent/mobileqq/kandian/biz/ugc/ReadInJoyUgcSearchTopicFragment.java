package com.tencent.mobileqq.kandian.biz.ugc;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.ListView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.ugc.databinding.ReadInJoyTopicListAdapter;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.report.dt.RIJDtReportHelper;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyObserver;
import com.tencent.mobileqq.kandian.repo.handler.TopicInfo;
import com.tencent.mobileqq.kandian.repo.handler.TopicInfo.Builder;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.os.MqqHandler;

public class ReadInJoyUgcSearchTopicFragment
  extends QPublicBaseFragment
  implements AdapterView.OnItemClickListener
{
  private static final String jdField_b_of_type_JavaLangString = HardCodeUtil.a(2131712915);
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private TextWatcher jdField_a_of_type_AndroidTextTextWatcher = new ReadInJoyUgcSearchTopicFragment.3(this);
  private View jdField_a_of_type_AndroidViewView;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private ListView jdField_a_of_type_AndroidWidgetListView;
  private ReadInJoyTopicListAdapter jdField_a_of_type_ComTencentMobileqqKandianBizUgcDatabindingReadInJoyTopicListAdapter;
  private ReadInJoyObserver jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsReadInJoyObserver = new ReadInJoyUgcSearchTopicFragment.1(this);
  private String jdField_a_of_type_JavaLangString;
  private List<Map<String, CharSequence>> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  private View jdField_b_of_type_AndroidViewView;
  private ReadInJoyObserver jdField_b_of_type_ComTencentMobileqqKandianRepoFeedsReadInJoyObserver = new ReadInJoyUgcSearchTopicFragment.2(this);
  private List<TopicInfo> jdField_b_of_type_JavaUtilList = new ArrayList();
  
  private static List<Map<String, CharSequence>> a(List<TopicInfo> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      TopicInfo localTopicInfo = (TopicInfo)paramList.next();
      HashMap localHashMap = new HashMap();
      localHashMap.put("key_cover_url", localTopicInfo.c());
      localHashMap.put("key_title", localTopicInfo.a());
      localHashMap.put("key_summary", localTopicInfo.b());
      localArrayList.add(localHashMap);
    }
    return localArrayList;
  }
  
  private Map<String, CharSequence> a()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("key_cover_url", "create_topic");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("#");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localHashMap.put("key_title", localStringBuilder.toString());
    localHashMap.put("key_summary", jdField_b_of_type_JavaLangString);
    return localHashMap;
  }
  
  private void a()
  {
    InputMethodManager localInputMethodManager = (InputMethodManager)getQBaseActivity().getSystemService("input_method");
    if (localInputMethodManager != null) {
      localInputMethodManager.hideSoftInputFromWindow(this.jdField_a_of_type_AndroidWidgetListView.getWindowToken(), 0);
    }
  }
  
  private void a(View paramView)
  {
    paramView.setOnClickListener(new ReadInJoyUgcSearchTopicFragment.4(this));
  }
  
  private void a(TopicInfo paramTopicInfo)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("EXTRA_SELECTED_TOPIC", paramTopicInfo);
    getQBaseActivity().setResult(-1, localIntent);
    getQBaseActivity().finish();
    getQBaseActivity().overridePendingTransition(0, 0);
  }
  
  private void a(List<String> paramList, List<TopicInfo> paramList1)
  {
    if ((paramList1.size() > 0) && (paramList.size() > 0) && (TextUtils.equals((CharSequence)paramList.get(0), this.jdField_a_of_type_JavaLangString)))
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.jdField_b_of_type_AndroidViewView.setVisibility(4);
      this.jdField_b_of_type_JavaUtilList.clear();
      this.jdField_b_of_type_JavaUtilList.addAll(paramList1);
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_JavaUtilList.addAll(a(paramList1));
      this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcDatabindingReadInJoyTopicListAdapter.notifyDataSetChanged();
      ReadInJoyUtils.a(this.jdField_a_of_type_Int, this.jdField_b_of_type_JavaUtilList, "0");
      return;
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.jdField_b_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_JavaUtilList.clear();
      if (ReadInJoyHelper.n())
      {
        this.jdField_b_of_type_JavaUtilList.add(TopicInfo.a().a(true).b(this.jdField_a_of_type_Long).c("https://sqimg.qq.com/qq_product_operations/kan/images/topic-cover-default.jpg").d("https://sqimg.qq.com/qq_product_operations/kan/images/topic-head-default.jpg").b(jdField_b_of_type_JavaLangString).a(this.jdField_a_of_type_JavaLangString).a());
        this.jdField_a_of_type_JavaUtilList.add(a());
      }
      this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcDatabindingReadInJoyTopicListAdapter.notifyDataSetChanged();
      ReadInJoyUtils.a(this.jdField_a_of_type_Int, this.jdField_b_of_type_JavaUtilList, "1");
    }
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidWidgetEditText.setText("");
  }
  
  private void b(View paramView)
  {
    paramView.findViewById(2131364166).setOnClickListener(new ReadInJoyUgcSearchTopicFragment.5(this));
  }
  
  private void c(View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetListView = ((ListView)paramView.findViewById(2131370173));
    this.jdField_a_of_type_AndroidWidgetListView.getLayoutParams().height = -1;
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131370155);
    this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131366238);
    this.jdField_a_of_type_AndroidWidgetListView.setOnItemClickListener(this);
    this.jdField_a_of_type_AndroidWidgetListView.setOnTouchListener(new ReadInJoyUgcSearchTopicFragment.6(this));
    this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcDatabindingReadInJoyTopicListAdapter = new ReadInJoyTopicListAdapter(getQBaseActivity(), this.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcDatabindingReadInJoyTopicListAdapter.setViewBinder(new ReadInJoyUgcSearchTopicFragment.7(this));
    paramView = LayoutInflater.from(getQBaseActivity()).inflate(2131560298, this.jdField_a_of_type_AndroidWidgetListView, false);
    this.jdField_a_of_type_AndroidWidgetListView.addFooterView(paramView, null, false);
    this.jdField_a_of_type_AndroidWidgetListView.setDivider(null);
    this.jdField_a_of_type_AndroidWidgetListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcDatabindingReadInJoyTopicListAdapter);
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  private void d(View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)paramView.findViewById(2131378304));
    this.jdField_a_of_type_AndroidWidgetEditText.setHint(2131718019);
    this.jdField_a_of_type_AndroidWidgetEditText.setOnTouchListener(new ReadInJoyUgcSearchTopicFragment.8(this));
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
    this.jdField_a_of_type_AndroidWidgetEditText.requestFocus();
  }
  
  protected void a(int paramInt, CharSequence paramCharSequence)
  {
    ThreadManager.getUIHandler().post(new ReadInJoyUgcSearchTopicFragment.9(this, paramInt, paramCharSequence));
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    paramActivity.getWindow().setBackgroundDrawable(new ColorDrawable(0));
    paramActivity.getWindow().requestFeature(1);
    paramActivity.getWindow().setSoftInputMode(4);
    paramActivity.overridePendingTransition(2130772065, 0);
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_a_of_type_Long = ((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getLongAccountUin();
    ReadInJoyLogicEngineEventDispatcher.a().a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsReadInJoyObserver);
    ReadInJoyLogicEngineEventDispatcher.a().a(this.jdField_b_of_type_ComTencentMobileqqKandianRepoFeedsReadInJoyObserver);
    paramLayoutInflater = paramLayoutInflater.inflate(2131560304, paramViewGroup, false);
    d(paramLayoutInflater);
    c(paramLayoutInflater);
    b(paramLayoutInflater);
    a(paramLayoutInflater);
    paramViewGroup = getArguments();
    if (paramViewGroup != null) {
      this.jdField_a_of_type_Int = paramViewGroup.getInt("searchTopicFrom");
    }
    RIJDtReportHelper.a.a(getQBaseActivity());
    return paramLayoutInflater;
  }
  
  public void onDestroyView()
  {
    ReadInJoyLogicEngineEventDispatcher.a().b(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsReadInJoyObserver);
    ReadInJoyLogicEngineEventDispatcher.a().b(this.jdField_b_of_type_ComTencentMobileqqKandianRepoFeedsReadInJoyObserver);
    super.onDestroyView();
  }
  
  public void onFinish()
  {
    getQBaseActivity().overridePendingTransition(0, 2130772068);
    super.onFinish();
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.jdField_b_of_type_JavaUtilList.size() == paramInt) {
      return;
    }
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    paramAdapterView = null;
    if (this.jdField_b_of_type_JavaUtilList.size() == 1) {
      paramAdapterView = (TopicInfo)this.jdField_b_of_type_JavaUtilList.get(0);
    }
    if ((paramAdapterView != null) && (paramAdapterView.a()))
    {
      this.jdField_a_of_type_Boolean = true;
      ReadInJoyLogicEngine.a().a(paramAdapterView);
      return;
    }
    a((TopicInfo)this.jdField_b_of_type_JavaUtilList.get(paramInt));
    paramView = (TopicInfo)this.jdField_b_of_type_JavaUtilList.get(paramInt);
    paramLong = -1L;
    if (paramAdapterView != null) {
      paramLong = paramView.a();
    }
    ReadInJoyUtils.a("0X800980A", this.jdField_a_of_type_Int, paramLong, "0");
    RIJDeliverUGCReportUtil.a(String.valueOf(paramLong), "1");
  }
  
  public void onResume()
  {
    super.onResume();
    Utils.a(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.ReadInJoyUgcSearchTopicFragment
 * JD-Core Version:    0.7.0.1
 */