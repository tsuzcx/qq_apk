package com.tencent.mobileqq.mini.entry.search.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.biz.common.util.NetworkUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.mini.entry.MiniAppExposureManager;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.mini.entry.search.data.MiniAppSearchDataManager;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.Iterator;
import java.util.List;

public class MiniAppSearchFragment
  extends PublicBaseFragment
  implements View.OnClickListener, SearchResultAdapter.DataChangedListener
{
  public static final String KEY_RECOMMEND_WORD = "recommend_word";
  public static final String KEY_REFER = "key_refer";
  public static final String SEARCH_KEYWORD = "search_keyword";
  public static final String TAG = "MiniAppSearchFragment";
  private boolean hasSendHotSearchRequest;
  private TextView mCancelButton;
  private ImageView mClearHistoryButton;
  private ImageButton mClearInputTextButton;
  private EditText mEditTextView;
  private ViewGroup mHistoryAndRecommendContainer;
  private ViewGroup mHistoryListViewGroup;
  private ViewGroup mHistorySearchContainer;
  private SearchRecommendAdapter mHotSearchAdapter;
  private ViewGroup mNoSearchResultViewGroup;
  private RecyclerView mRecommendRecyclerView;
  private int mRefer;
  private SearchResultAdapter mResultAdapter;
  private ListView mResultListView;
  private ViewGroup mSearchResultContainer;
  private TextView mSearchResultExceptionText;
  private TextView mSearchResultTitle;
  private String mTianShuKeyword;
  
  private void initData()
  {
    Object localObject = getBaseActivity().getIntent();
    this.mTianShuKeyword = ((Intent)localObject).getStringExtra("recommend_word");
    localObject = ((Intent)localObject).getStringExtra("search_keyword");
    if (!TextUtils.isEmpty(this.mTianShuKeyword)) {
      this.mEditTextView.setHint(this.mTianShuKeyword);
    }
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      this.mEditTextView.setText((CharSequence)localObject);
      this.mEditTextView.setSelection(((String)localObject).length());
    }
    localObject = (MiniAppSearchDataManager)MiniAppUtils.getAppInterface().getManager(QQManagerFactory.MINI_APP_SEARCH_MANAGER);
    if (((MiniAppSearchDataManager)localObject).getHotSearchData().size() > 0) {
      this.mHotSearchAdapter.setData(((MiniAppSearchDataManager)localObject).getHotSearchData());
    }
  }
  
  private void initHistorySearch()
  {
    MiniAppSearchDataManager localMiniAppSearchDataManager = (MiniAppSearchDataManager)MiniAppUtils.getAppInterface().getManager(QQManagerFactory.MINI_APP_SEARCH_MANAGER);
    this.mEditTextView.setOnEditorActionListener(new MiniAppSearchFragment.4(this, localMiniAppSearchDataManager));
    updateSearchRecord(localMiniAppSearchDataManager, localMiniAppSearchDataManager.getCachedHistorySearchList());
  }
  
  private void sendHotSearchRequest()
  {
    ((MiniAppSearchDataManager)MiniAppUtils.getAppInterface().getManager(QQManagerFactory.MINI_APP_SEARCH_MANAGER)).sendHotSearchAppRequest();
  }
  
  private void updateHistorySearchRecordLayout()
  {
    MiniAppSearchDataManager localMiniAppSearchDataManager = (MiniAppSearchDataManager)MiniAppUtils.getAppInterface().getManager(QQManagerFactory.MINI_APP_SEARCH_MANAGER);
    this.mHistoryListViewGroup.removeAllViews();
    updateSearchRecord(localMiniAppSearchDataManager, localMiniAppSearchDataManager.getHistorySearchList());
  }
  
  private void updateSearchRecord(MiniAppSearchDataManager paramMiniAppSearchDataManager, List<String> paramList)
  {
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      TextView localTextView = new TextView(getBaseActivity());
      localTextView.setText(str);
      localTextView.setTextColor(-16578534);
      localTextView.setBackgroundResource(2130841848);
      localTextView.setOnClickListener(new MiniAppSearchFragment.5(this, localTextView, paramMiniAppSearchDataManager));
      this.mHistoryListViewGroup.addView(localTextView);
    }
    if (paramList.size() > 0)
    {
      this.mHistorySearchContainer.setVisibility(0);
      this.mHistorySearchContainer.requestLayout();
      MiniProgramLpReportDC04239.reportAsync("desktop", "search", "history_expo", null);
      return;
    }
    this.mHistorySearchContainer.setVisibility(8);
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131438545: 
      this.mEditTextView.setText("");
      this.mSearchResultContainer.setVisibility(8);
      this.mHistoryAndRecommendContainer.setVisibility(0);
      this.mClearInputTextButton.setVisibility(8);
      return;
    case 2131438544: 
      this.mHistorySearchContainer.setVisibility(8);
      ((MiniAppSearchDataManager)MiniAppUtils.getAppInterface().getManager(QQManagerFactory.MINI_APP_SEARCH_MANAGER)).clearHistorySearch();
      MiniProgramLpReportDC04239.reportAsync("desktop", "search", "history_delete", null);
      return;
    }
    if (getBaseActivity() != null) {
      getBaseActivity().finish();
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = LayoutInflater.from(getBaseActivity()).inflate(2131625356, null);
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      paramLayoutInflater.setFitsSystemWindows(true);
    } else {
      paramLayoutInflater.setPadding(0, ImmersiveUtils.getStatusBarHeight(getBaseActivity()), 0, 0);
    }
    this.mRefer = getBaseActivity().getIntent().getIntExtra("key_refer", 2077);
    paramViewGroup = new StringBuilder();
    paramViewGroup.append("onCreateView, refer: ");
    paramViewGroup.append(this.mRefer);
    QLog.d("MiniAppSearchFragment", 1, paramViewGroup.toString());
    if (this.mRefer != 1005)
    {
      this.hasSendHotSearchRequest = true;
      sendHotSearchRequest();
    }
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    QLog.d("MiniAppSearchFragment", 1, "onDestroy");
  }
  
  public void onDetach()
  {
    super.onDetach();
  }
  
  public void onFinish()
  {
    super.onFinish();
    QLog.d("MiniAppSearchFragment", 1, "onFinish");
    MiniAppSearchDataManager localMiniAppSearchDataManager = (MiniAppSearchDataManager)MiniAppUtils.getAppInterface().getManager(QQManagerFactory.MINI_APP_SEARCH_MANAGER);
    localMiniAppSearchDataManager.clearSearchResult();
    localMiniAppSearchDataManager.setDataChangedListener(null);
    localMiniAppSearchDataManager.setHotSearchDataChangedListener(null);
    this.hasSendHotSearchRequest = false;
  }
  
  public void onResultDataChanged(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (TextUtils.isEmpty(this.mEditTextView.getText().toString())) {
        return;
      }
      if (this.mHistoryAndRecommendContainer.getVisibility() == 0)
      {
        this.mHistoryAndRecommendContainer.setVisibility(8);
        this.mSearchResultContainer.setVisibility(0);
        this.mClearInputTextButton.setVisibility(0);
        QLog.d("MiniAppSearchFragment", 1, "onResultDataChanged, history and recommend is gone");
      }
      MiniAppSearchDataManager localMiniAppSearchDataManager = (MiniAppSearchDataManager)MiniAppUtils.getAppInterface().getManager(QQManagerFactory.MINI_APP_SEARCH_MANAGER);
      this.mSearchResultTitle.setText(2131891799);
      if ((!localMiniAppSearchDataManager.getSearchResultData().isEmpty()) && (!localMiniAppSearchDataManager.isNoResult()))
      {
        this.mNoSearchResultViewGroup.setVisibility(8);
        return;
      }
      this.mNoSearchResultViewGroup.setVisibility(0);
      this.mSearchResultTitle.setText(2131891798);
      MiniProgramLpReportDC04239.reportAsync("desktop", "search", "recom_expo", null);
      if (!NetworkUtil.a(BaseApplicationImpl.getContext()))
      {
        this.mSearchResultExceptionText.setText(2131896023);
        return;
      }
      this.mSearchResultExceptionText.setText(2131891796);
      return;
    }
    if (!this.hasSendHotSearchRequest)
    {
      sendHotSearchRequest();
      this.hasSendHotSearchRequest = true;
    }
    this.mHistoryAndRecommendContainer.setVisibility(0);
    this.mSearchResultContainer.setVisibility(8);
    this.mClearInputTextButton.setVisibility(8);
    updateHistorySearchRecordLayout();
    this.mResultListView.smoothScrollToPositionFromTop(0, 0, 0);
  }
  
  public void onStop()
  {
    super.onStop();
    QLog.d("MiniAppSearchFragment", 1, "onStop");
    AppInterface localAppInterface = MiniAppUtils.getAppInterface();
    if (localAppInterface != null) {
      ((MiniAppExposureManager)localAppInterface.getManager(QQManagerFactory.MINI_APP_EXPOSURE_MANAGER)).submitSearchReportData();
    }
  }
  
  public void onTextChanged(String paramString)
  {
    SearchResultAdapter localSearchResultAdapter = this.mResultAdapter;
    if (localSearchResultAdapter != null) {
      localSearchResultAdapter.setKeyword(paramString);
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.mHistoryAndRecommendContainer = ((ViewGroup)paramView.findViewById(2131438465));
    this.mSearchResultContainer = ((ViewGroup)paramView.findViewById(2131438573));
    this.mHistorySearchContainer = ((ViewGroup)paramView.findViewById(2131438551));
    this.mHistoryListViewGroup = ((ViewGroup)paramView.findViewById(2131438550));
    this.mNoSearchResultViewGroup = ((ViewGroup)paramView.findViewById(2131438559));
    this.mSearchResultExceptionText = ((TextView)paramView.findViewById(2131438575));
    this.mSearchResultTitle = ((TextView)paramView.findViewById(2131438579));
    this.mRecommendRecyclerView = ((RecyclerView)paramView.findViewById(2131438563));
    paramBundle = (MiniAppSearchDataManager)MiniAppUtils.getAppInterface().getManager(QQManagerFactory.MINI_APP_SEARCH_MANAGER);
    this.mHotSearchAdapter = new SearchRecommendAdapter(getBaseActivity(), this.mRefer);
    paramBundle.setHotSearchDataChangedListener(this.mHotSearchAdapter);
    this.mRecommendRecyclerView.setAdapter(this.mHotSearchAdapter);
    GridLayoutManager localGridLayoutManager = new GridLayoutManager(getBaseActivity(), 2);
    localGridLayoutManager.setSpanSizeLookup(new MiniAppSearchFragment.1(this));
    this.mRecommendRecyclerView.setLayoutManager(localGridLayoutManager);
    this.mRecommendRecyclerView.addItemDecoration(new SearchRecommendAdapter.TitleDecoration());
    this.mResultListView = ((ListView)paramView.findViewById(2131438577));
    this.mResultAdapter = new SearchResultAdapter(getBaseActivity(), this.mRefer);
    this.mResultAdapter.setDataChangedListener(this);
    paramBundle.setDataChangedListener(this.mResultAdapter);
    this.mResultListView.setAdapter(this.mResultAdapter);
    this.mCancelButton = ((TextView)paramView.findViewById(2131438418));
    this.mCancelButton.setOnClickListener(this);
    this.mClearInputTextButton = ((ImageButton)paramView.findViewById(2131438545));
    this.mClearInputTextButton.setOnClickListener(this);
    this.mClearHistoryButton = ((ImageView)paramView.findViewById(2131438544));
    this.mClearHistoryButton.setOnClickListener(this);
    this.mEditTextView = ((EditText)paramView.findViewById(2131438543));
    this.mEditTextView.addTextChangedListener(new MiniAppSearchFragment.SearchEditTextWatcher(this));
    this.mEditTextView.postDelayed(new MiniAppSearchFragment.2(this), 300L);
    this.mResultListView.setOnScrollListener(new MiniAppSearchFragment.3(this));
    initData();
    initHistorySearch();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.search.ui.MiniAppSearchFragment
 * JD-Core Version:    0.7.0.1
 */