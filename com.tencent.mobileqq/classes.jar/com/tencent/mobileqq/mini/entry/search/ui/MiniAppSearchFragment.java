package com.tencent.mobileqq.mini.entry.search.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.mini.entry.MiniAppExposureManager;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.mini.entry.search.data.MiniAppSearchDataManager;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.Iterator;
import java.util.List;
import ndk;

public class MiniAppSearchFragment
  extends PublicBaseFragment
  implements View.OnClickListener, SearchResultAdapter.DataChangedListener
{
  public static final String KEY_RECOMMEND_WORD = "recommend_word";
  public static final String TAG = "MiniAppSearchFragment";
  private TextView mCancelButton;
  private ImageView mClearHistoryButton;
  private ImageButton mClearInputTextButton;
  private EditText mEditTextView;
  private ImageView mEmptyBackground;
  private ViewGroup mHistoryAndRecommendContainer;
  private ViewGroup mHistoryListViewGroup;
  private ViewGroup mHistorySearchContainer;
  private HotSearchAdapter mHotSearchAdapter;
  private TextView mHotSearchTitle;
  private ViewGroup mNoSearchResultViewGroup;
  private GridView mRecommendGridView;
  private SearchResultAdapter mResultAdapter;
  private ListView mResultListView;
  private ViewGroup mSearchResultContainer;
  private TextView mSearchResultExceptionText;
  private String mTianShuKeyword;
  
  private void initData()
  {
    this.mTianShuKeyword = getActivity().getIntent().getStringExtra("recommend_word");
    if (!TextUtils.isEmpty(this.mTianShuKeyword)) {
      this.mEditTextView.setHint(this.mTianShuKeyword);
    }
    MiniAppSearchDataManager localMiniAppSearchDataManager = (MiniAppSearchDataManager)MiniAppUtils.getAppInterface().getManager(360);
    String str = localMiniAppSearchDataManager.getHotSearchTitle();
    if (!TextUtils.isEmpty(str)) {
      this.mHotSearchTitle.setText(str);
    }
    if (localMiniAppSearchDataManager.getHotSearchData().size() > 0) {
      this.mHotSearchAdapter.setData(localMiniAppSearchDataManager.getHotSearchData());
    }
  }
  
  private void initHistorySearch()
  {
    MiniAppSearchDataManager localMiniAppSearchDataManager = (MiniAppSearchDataManager)MiniAppUtils.getAppInterface().getManager(360);
    this.mEditTextView.setOnEditorActionListener(new MiniAppSearchFragment.3(this, localMiniAppSearchDataManager));
    updateSearchRecord(localMiniAppSearchDataManager, localMiniAppSearchDataManager.getCachedHistorySearchList());
  }
  
  private void updateHistorySearchRecordLayout()
  {
    MiniAppSearchDataManager localMiniAppSearchDataManager = (MiniAppSearchDataManager)MiniAppUtils.getAppInterface().getManager(360);
    this.mHistoryListViewGroup.removeAllViews();
    updateSearchRecord(localMiniAppSearchDataManager, localMiniAppSearchDataManager.getHistorySearchList());
  }
  
  private void updateSearchRecord(MiniAppSearchDataManager paramMiniAppSearchDataManager, List<String> paramList)
  {
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      TextView localTextView = new TextView(getActivity());
      localTextView.setText(str);
      localTextView.setTextColor(-16578534);
      localTextView.setBackgroundResource(2130840764);
      localTextView.setOnClickListener(new MiniAppSearchFragment.4(this, localTextView, paramMiniAppSearchDataManager));
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
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131370434: 
      do
      {
        return;
      } while (getActivity() == null);
      getActivity().finish();
      return;
    case 2131370518: 
      this.mEditTextView.setText("");
      this.mSearchResultContainer.setVisibility(8);
      this.mHistoryAndRecommendContainer.setVisibility(0);
      this.mClearInputTextButton.setVisibility(8);
      return;
    }
    this.mHistorySearchContainer.setVisibility(8);
    ((MiniAppSearchDataManager)MiniAppUtils.getAppInterface().getManager(360)).clearHistorySearch();
    MiniProgramLpReportDC04239.reportAsync("desktop", "search", "history_delete", null);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = LayoutInflater.from(getActivity()).inflate(2131559316, null);
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      paramLayoutInflater.setFitsSystemWindows(true);
    }
    for (;;)
    {
      ((MiniAppSearchDataManager)MiniAppUtils.getAppInterface().getManager(360)).sendHotSearchAppRequest();
      return paramLayoutInflater;
      paramLayoutInflater.setPadding(0, ImmersiveUtils.getStatusBarHeight(getActivity()), 0, 0);
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    QLog.d("MiniAppSearchFragment", 1, "onDestroy");
    MiniAppSearchDataManager localMiniAppSearchDataManager = (MiniAppSearchDataManager)MiniAppUtils.getAppInterface().getManager(360);
    localMiniAppSearchDataManager.clearSearchResult();
    localMiniAppSearchDataManager.setDataChangedListener(null);
    localMiniAppSearchDataManager.setHotSearchDataChangedListener(null);
  }
  
  public void onDetach()
  {
    super.onDetach();
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
      if (((MiniAppSearchDataManager)MiniAppUtils.getAppInterface().getManager(360)).getSearchResultData().size() == 0)
      {
        this.mEmptyBackground.setImageDrawable(URLDrawable.getDrawable("https://qzonestyle.gtimg.cn/aoi/sola/20200317103714_042EdeeOON.png", null));
        this.mNoSearchResultViewGroup.setVisibility(0);
        if (!ndk.a(BaseApplicationImpl.getContext()))
        {
          this.mSearchResultExceptionText.setText(2131698450);
          return;
        }
        this.mSearchResultExceptionText.setText(2131694421);
        return;
      }
      this.mNoSearchResultViewGroup.setVisibility(8);
      return;
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
      ((MiniAppExposureManager)localAppInterface.getManager(322)).submitSearchReportData();
    }
  }
  
  public void onTextChanged(String paramString)
  {
    if (this.mResultAdapter != null) {
      this.mResultAdapter.setKeyword(paramString);
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.mHistoryAndRecommendContainer = ((ViewGroup)paramView.findViewById(2131370473));
    this.mSearchResultContainer = ((ViewGroup)paramView.findViewById(2131370538));
    this.mHistorySearchContainer = ((ViewGroup)paramView.findViewById(2131370521));
    this.mHistoryListViewGroup = ((ViewGroup)paramView.findViewById(2131370520));
    this.mNoSearchResultViewGroup = ((ViewGroup)paramView.findViewById(2131370525));
    this.mEmptyBackground = ((ImageView)paramView.findViewById(2131370540));
    this.mSearchResultExceptionText = ((TextView)paramView.findViewById(2131370541));
    this.mHotSearchTitle = ((TextView)paramView.findViewById(2131370531));
    this.mRecommendGridView = ((GridView)paramView.findViewById(2131370528));
    paramBundle = (MiniAppSearchDataManager)MiniAppUtils.getAppInterface().getManager(360);
    this.mHotSearchAdapter = new HotSearchAdapter(getActivity(), this.mHotSearchTitle);
    paramBundle.setHotSearchDataChangedListener(this.mHotSearchAdapter);
    this.mRecommendGridView.setAdapter(this.mHotSearchAdapter);
    this.mResultListView = ((ListView)paramView.findViewById(2131370543));
    this.mResultAdapter = new SearchResultAdapter(getActivity());
    this.mResultAdapter.setDataChangedListener(this);
    paramBundle.setDataChangedListener(this.mResultAdapter);
    this.mResultListView.setAdapter(this.mResultAdapter);
    this.mCancelButton = ((TextView)paramView.findViewById(2131370434));
    this.mCancelButton.setOnClickListener(this);
    this.mClearInputTextButton = ((ImageButton)paramView.findViewById(2131370518));
    this.mClearInputTextButton.setOnClickListener(this);
    this.mClearHistoryButton = ((ImageView)paramView.findViewById(2131370517));
    this.mClearHistoryButton.setOnClickListener(this);
    this.mEditTextView = ((EditText)paramView.findViewById(2131370516));
    this.mEditTextView.addTextChangedListener(new MiniAppSearchFragment.SearchEditTextWatcher(this));
    this.mEditTextView.postDelayed(new MiniAppSearchFragment.1(this), 300L);
    this.mResultListView.setOnScrollListener(new MiniAppSearchFragment.2(this));
    initData();
    initHistorySearch();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.search.ui.MiniAppSearchFragment
 * JD-Core Version:    0.7.0.1
 */