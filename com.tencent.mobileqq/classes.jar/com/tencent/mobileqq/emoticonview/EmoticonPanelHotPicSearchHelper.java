package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import aram;
import aran;
import aseo;
import asep;
import aseq;
import aser;
import bdla;
import bhhr;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.emosm.emosearch.EmotionSearchItem;
import com.tencent.mobileqq.extendfriend.wiget.ExtendFriendLabelFlowLayout;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.ListView;
import com.tencent.widget.XEditTextEx;
import com.tencent.widget.XPanelContainer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class EmoticonPanelHotPicSearchHelper
  extends AbstractEmoticonPanelHelper
  implements View.OnClickListener, aser, AbsListView.OnScrollListener
{
  public static final int ITEM_TYPE_FIRST_LOAD_ERROR = 4;
  public static final int ITEM_TYPE_LOAD_EMPTY = 8;
  public static final int ITEM_TYPE_LOAD_INIT = 0;
  public static final int ITEM_TYPE_LOAD_INNER_ERROR = 7;
  public static final int ITEM_TYPE_LOAD_MORE = 1;
  public static final int ITEM_TYPE_LOAD_MORE_ERROR = 2;
  public static final int ITEM_TYPE_NO_MORE = 3;
  public static final int ITEM_TYPE_SEARCH_EXIT = 6;
  public static final int ITEM_TYPE_SEARCH_LOADING = 5;
  public static final String TAG = "EmoticonPanelHotPicSearchHelper";
  protected static int sLastShowPageType = 1;
  protected static boolean sNeedPullUp;
  protected static boolean sPrepareSearch;
  protected static int sSearchVisibility = 0;
  protected static String sSearchWord;
  protected List<String> mEmoticonTags;
  protected View mFooterView;
  protected View mHeaderView;
  protected boolean mIsClearWords;
  protected ExtendFriendLabelFlowLayout mLabelFlowLayout;
  protected int mLastScrollState = 0;
  protected ListView mListView;
  protected boolean mLoadMore;
  protected View mLoadingEmptyView;
  protected int mLoadingStatus = 0;
  protected BaseEmotionAdapter mSearchAdapter;
  protected ViewGroup mSearchResultTitleCon;
  protected ViewGroup mSearchTitleCon;
  protected TextView mSearchTv;
  protected View mSearchView;
  View searchBoxView;
  
  public EmoticonPanelHotPicSearchHelper()
  {
    super(null);
  }
  
  public EmoticonPanelHotPicSearchHelper(EmoticonPanelController paramEmoticonPanelController)
  {
    super(paramEmoticonPanelController);
  }
  
  public void addHeaderAndFooterView(EmotionPanelListView paramEmotionPanelListView, BaseEmotionAdapter paramBaseEmotionAdapter, int paramInt)
  {
    if ((paramEmotionPanelListView != null) && (paramInt == 14))
    {
      attach(paramEmotionPanelListView, paramBaseEmotionAdapter);
      paramBaseEmotionAdapter = getHeaderView();
      ViewParent localViewParent = paramEmotionPanelListView.getParent();
      if ((localViewParent instanceof ViewGroup))
      {
        if (this.mSearchView == null)
        {
          this.mSearchView = View.inflate(getContext(), 2131559163, null);
          initHeader(this.mSearchView);
        }
        if (this.mSearchView.getParent() != null) {
          ((ViewGroup)this.mSearchView.getParent()).removeView(this.mSearchView);
        }
        ((ViewGroup)localViewParent).addView(this.mSearchView, 0);
      }
      if ((paramBaseEmotionAdapter.getParent() == null) && (paramEmotionPanelListView.findHeaderViewPosition(paramBaseEmotionAdapter) == -1)) {
        paramEmotionPanelListView.addHeaderView(paramBaseEmotionAdapter);
      }
      paramBaseEmotionAdapter = getFooterView();
      if (paramBaseEmotionAdapter.getParent() == null) {
        paramEmotionPanelListView.addFooterView(paramBaseEmotionAdapter);
      }
    }
  }
  
  protected void attach(ListView paramListView, BaseEmotionAdapter paramBaseEmotionAdapter)
  {
    this.mListView = paramListView;
    this.mSearchAdapter = paramBaseEmotionAdapter;
  }
  
  protected void clearReportedMD5List()
  {
    if ((this.mSearchAdapter instanceof EmotionHotPicSearchAdapter)) {
      ((EmotionHotPicSearchAdapter)this.mSearchAdapter).clearReportedMD5List();
    }
  }
  
  public void clearSearchWords()
  {
    sSearchWord = null;
  }
  
  protected int dip2px(int paramInt)
  {
    return ViewUtils.dip2px(paramInt);
  }
  
  public QQAppInterface getApp()
  {
    if (this.mPanelController == null) {
      return (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
    }
    return this.mPanelController.app;
  }
  
  public Context getContext()
  {
    if (this.mPanelController == null) {
      return BaseApplicationImpl.sApplication;
    }
    return this.mPanelController.context;
  }
  
  protected View getFooterView()
  {
    if (this.mFooterView == null)
    {
      this.mFooterView = View.inflate(getContext(), 2131558628, null);
      this.mFooterView.setBackgroundColor(0);
      this.mFooterView.setLayoutParams(new AbsListView.LayoutParams(-1, ViewUtils.dip2px(74.0F)));
    }
    notifyFooterViewChange();
    return this.mFooterView;
  }
  
  @NonNull
  public View getHeaderView()
  {
    if (this.mHeaderView != null) {
      return this.mHeaderView;
    }
    this.mHeaderView = View.inflate(getContext(), 2131559164, null);
    this.mLabelFlowLayout = ((ExtendFriendLabelFlowLayout)this.mHeaderView.findViewById(2131367048));
    Object localObject = aram.a();
    if (localObject != null)
    {
      localObject = ((aran)localObject).a;
      this.mEmoticonTags = ((List)localObject);
      if ((localObject != null) && (!this.mEmoticonTags.isEmpty()))
      {
        this.mLabelFlowLayout.setAdapter(new EmoticonPanelHotPicSearchHelper.LabelFlowAdapter(this, getContext(), this.mEmoticonTags));
        if (this.mEmoticonTags != null) {
          break label171;
        }
        if (QLog.isColorLevel()) {
          QLog.d("EmoticonPanelHotPicSearchHelper", 4, "emoticonTags is null. ");
        }
      }
    }
    for (;;)
    {
      return this.mHeaderView;
      this.mEmoticonTags = Arrays.asList(getContext().getResources().getStringArray(2130968579));
      this.mLabelFlowLayout.setAdapter(new EmoticonPanelHotPicSearchHelper.LabelFlowAdapter(this, getContext(), this.mEmoticonTags));
      break;
      label171:
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonPanelHotPicSearchHelper", 4, "emoticonTags size: " + this.mEmoticonTags.size());
      }
    }
  }
  
  public int getPageType()
  {
    return 1;
  }
  
  public String getSearchWord()
  {
    return sSearchWord;
  }
  
  protected Drawable getShapeDrawable(int paramInt)
  {
    if (ThemeUtil.isNowThemeIsNight(getApp(), false, null)) {}
    for (String str = "#1C1C1C";; str = "#F5F6FA") {
      return ViewUtils.getShapeDrawable(Color.parseColor(str), ViewUtils.dip2px(paramInt));
    }
  }
  
  public String getTag()
  {
    return "EmoticonPanelHotPicSearchHelper";
  }
  
  protected void initHeader(View paramView)
  {
    this.mSearchResultTitleCon = ((ViewGroup)paramView.findViewById(2131370432));
    this.mSearchTv = ((TextView)paramView.findViewById(2131380143));
    ImageView localImageView = (ImageView)paramView.findViewById(2131369534);
    Button localButton = (Button)paramView.findViewById(2131363844);
    this.mSearchTitleCon = ((ViewGroup)paramView.findViewById(2131366881));
    this.searchBoxView = paramView.findViewById(2131376919);
    this.searchBoxView.setBackgroundDrawable(getShapeDrawable(18));
    this.mSearchTitleCon.setBackgroundDrawable(getShapeDrawable(18));
    TextView localTextView = this.mSearchTv;
    if (ThemeUtil.isNowThemeIsNight(getApp(), false, null)) {}
    for (paramView = "#B0B3BF";; paramView = "#03081A")
    {
      localTextView.setTextColor(Color.parseColor(paramView));
      localImageView.setOnClickListener(this);
      this.mSearchTitleCon.setOnClickListener(this);
      localButton.setOnClickListener(this);
      this.mSearchTv.setOnClickListener(this);
      setSearchContainerVisibility(sSearchVisibility);
      return;
    }
  }
  
  protected void initListener()
  {
    if (this.mListView == null) {
      return;
    }
    this.mListView.setOnScrollListener(new EmoticonPanelHotPicSearchHelper.2(this));
  }
  
  public int[] interestedIn()
  {
    return new int[] { 8, 4, 5, 3 };
  }
  
  protected boolean isInEmoticonSearchPanel()
  {
    return (getPageType() == 1) && (this.mPanelController != null) && (this.mPanelController.findIndexByPanelType(12) == EmoticonPanelController.sLastSelectedSecondTabIndex);
  }
  
  protected boolean isInRichTextSearchPanel()
  {
    int i = bhhr.aK(getContext(), getApp().getCurrentAccountUin());
    return (getPageType() == 2) && (i == 5);
  }
  
  public boolean isInSearchPage()
  {
    return !StringUtil.isEmpty(getSearchWord());
  }
  
  protected void loadHotPicData()
  {
    setLoadingStatus(0);
    sNeedPullUp = false;
    sPrepareSearch = false;
    clearReportedMD5List();
    clearSearchWords();
    notifyFooterViewChange();
    notifyHeaderViewChange();
    updateLoadingView();
    updateAllTabs();
    aseq localaseq = new aseq(0);
    pushEmotionSearchTask(getApp(), localaseq, this);
  }
  
  public void loadPicData()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonPanelHotPicSearchHelper", 4, "start loadPicData word is null: " + TextUtils.isEmpty(getSearchWord()) + " sPrepareSearch: " + sPrepareSearch);
    }
    if (TextUtils.isEmpty(getSearchWord())) {
      loadHotPicData();
    }
    do
    {
      return;
      if (!sPrepareSearch)
      {
        onSearchPullUp();
        loadSearchPicData();
        return;
      }
    } while (this.mLoadingStatus == 5);
    setLoadingStatus(5);
    notifyHeaderViewChange();
    notifyFooterViewChange();
    updateLoadingView();
    onSearchPullUp();
  }
  
  public void loadSearchPicData()
  {
    if (TextUtils.isEmpty(getSearchWord())) {
      return;
    }
    if ((isInSearchPage()) && (isInEmoticonSearchPanel())) {
      EmoticonUtils.report("0X800AE2A", 0);
    }
    sNeedPullUp = false;
    sPrepareSearch = false;
    clearReportedMD5List();
    setLoadingStatus(5);
    notifyFooterViewChange();
    notifyHeaderViewChange();
    updateAllTabs();
    updateLoadingView();
    aseq localaseq = new aseq(1, getSearchWord());
    pushEmotionSearchTask(getApp(), localaseq, this);
  }
  
  protected void notifyFooterViewChange()
  {
    if (this.mFooterView == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonPanelHotPicSearchHelper", 2, "notifyFooterViewChange.");
    }
    TextView localTextView1 = (TextView)this.mFooterView.findViewById(2131368345);
    localTextView1.setTextSize(12.0F);
    View localView = this.mFooterView.findViewById(2131368344);
    TextView localTextView2 = (TextView)this.mFooterView.findViewById(2131370474);
    localTextView2.setTextSize(12.0F);
    localTextView1.setOnClickListener(this);
    ViewGroup.LayoutParams localLayoutParams = this.mFooterView.getLayoutParams();
    int i = dip2px(74);
    if (localLayoutParams.height != i)
    {
      localLayoutParams.height = i;
      this.mFooterView.setLayoutParams(localLayoutParams);
    }
    if ((this.mLoadingStatus == 1) || (this.mLoadingStatus == 0))
    {
      localView.setVisibility(0);
      localTextView2.setText(2131689898);
      localTextView1.setVisibility(4);
      reportLoading();
      return;
    }
    if (this.mLoadingStatus == 7)
    {
      localTextView1.setVisibility(0);
      localTextView1.setText(2131689902);
      localView.setVisibility(4);
      reportRequestErrorExposed();
      return;
    }
    if ((this.mLoadingStatus == 2) || ((this.mLoadingStatus == 4) && (dip2px(XPanelContainer.b()) >= XPanelContainer.a) && ("EmoticonPanelHotPicSearchHelper".equals(getTag()))))
    {
      localTextView1.setVisibility(0);
      localTextView1.setText(2131689903);
      localView.setVisibility(4);
      reportRequestErrorExposed();
      return;
    }
    localTextView1.setVisibility(8);
    localView.setVisibility(8);
    localLayoutParams.height = -2;
    this.mFooterView.setLayoutParams(localLayoutParams);
  }
  
  protected void notifyHeaderViewChange()
  {
    if (this.mHeaderView == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonPanelHotPicSearchHelper", 2, "notifyHeaderViewChange loadingStatus:" + this.mLoadingStatus);
    }
    if (TextUtils.isEmpty(getSearchWord()))
    {
      this.mSearchResultTitleCon.setVisibility(8);
      this.mSearchTitleCon.setVisibility(0);
      this.mLabelFlowLayout.setVisibility(0);
    }
    for (;;)
    {
      setSearchContainerVisibility(sSearchVisibility);
      return;
      this.mSearchTv.setText(getSearchWord());
      this.mSearchResultTitleCon.setVisibility(0);
      this.mSearchTitleCon.setVisibility(8);
      this.mLabelFlowLayout.setVisibility(8);
      if ((this.mPanelController != null) && (this.mPanelController.mBaseChatPie != null) && (this.mPanelController.mBaseChatPie.input != null)) {
        this.mPanelController.mBaseChatPie.input.clearFocus();
      }
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.mPanelController != null)
      {
        this.mIsClearWords = true;
        clearSearchWords();
        Rect localRect = new Rect();
        this.mSearchResultTitleCon.getGlobalVisibleRect(localRect);
        this.mPanelController.mBaseChatPie.setEmotionSearchPanelVisible(true, localRect.bottom, true, null, this.searchBoxView.getWidth());
        continue;
        clearSearchWords();
        onPullDown();
        loadHotPicData();
        report("0X800AE30", 0);
        continue;
        if (this.mPanelController != null)
        {
          report("0X800AE2F", 0);
          localRect = new Rect();
          this.mSearchTitleCon.getGlobalVisibleRect(localRect);
          this.mPanelController.mBaseChatPie.setEmotionSearchPanelVisible(true, localRect.bottom, false, null, this.mSearchTitleCon.getWidth());
          reportClickEvent("0X800AE1E");
          continue;
          if (this.mPanelController != null)
          {
            localRect = new Rect();
            this.mSearchTv.getGlobalVisibleRect(localRect);
            this.mPanelController.mBaseChatPie.setEmotionSearchPanelVisible(true, localRect.bottom, false, getSearchWord(), this.searchBoxView.getWidth());
            continue;
            if (this.mLoadingStatus == 4)
            {
              loadPicData();
              reportNetworkErrorClickEvent();
            }
            else
            {
              setLoadingStatus(1);
              notifyFooterViewChange();
              onLoadMore();
              continue;
              loadPicData();
              reportNetworkErrorClickEvent();
            }
          }
        }
      }
    }
  }
  
  public void onDestory()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonPanelHotPicSearchHelper", 4, "onDestory.");
    }
    clearReportedMD5List();
    clearSearchWords();
    resetEmoticonSearch();
    sSearchVisibility = 0;
    sPrepareSearch = false;
    this.mLoadMore = false;
    this.mSearchAdapter = null;
    this.mListView = null;
  }
  
  protected void onHandleResult(asep paramasep)
  {
    if ((this.mSearchAdapter == null) || (paramasep == null)) {
      return;
    }
    int i;
    if (paramasep.a() == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonPanelHotPicSearchHelper", 2, "onSearchCallBack success isHasMore: " + paramasep.a());
      }
      Object localObject = paramasep.a();
      if ((localObject == null) || (((List)localObject).isEmpty()))
      {
        if ((isInSearchPage()) && (isInEmoticonSearchPanel())) {
          EmoticonUtils.report("0X800AE2B", 0);
        }
        setLoadingStatus(8);
        this.mSearchAdapter.setData(new ArrayList());
        updateLoadingView();
        notifyHeaderViewChange();
        notifyFooterViewChange();
        return;
      }
      ArrayList localArrayList = new ArrayList();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        EmotionSearchItem localEmotionSearchItem = (EmotionSearchItem)((Iterator)localObject).next();
        localArrayList.add(new HotPicSearchEmoticonInfo(getPageType(), localArrayList.size() + 1, getSearchWord(), localEmotionSearchItem));
      }
      if ((this.mLoadingStatus == 0) || (this.mLoadingStatus == 5)) {
        initListener();
      }
      if (paramasep.a())
      {
        i = 1;
        setLoadingStatus(i);
        notifyHeaderViewChange();
        notifyFooterViewChange();
        this.mSearchAdapter.setData(localArrayList);
        updateLoadingView();
      }
    }
    for (;;)
    {
      this.mLoadMore = false;
      return;
      i = 3;
      break;
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonPanelHotPicSearchHelper", 2, "onSearchCallBack fail");
      }
      onRequestFail(paramasep);
    }
  }
  
  public void onHide(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonPanelHotPicSearchHelper", 4, "onHide.");
    }
    sLastShowPageType = getPageType();
    clearReportedMD5List();
  }
  
  protected void onLoadMore()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonPanelHotPicSearchHelper", 4, "start onLoadMore");
    }
    if (isInRichTextSearchPanel()) {
      reportEvent("0X800AE37");
    }
    for (;;)
    {
      aseo.a(getApp()).a();
      return;
      if (isInEmoticonSearchPanel()) {
        if (isInSearchPage()) {
          EmoticonUtils.report("0X800AE2C", 0);
        } else {
          EmoticonUtils.report("0X800AE21", 0);
        }
      }
    }
  }
  
  public void onPageSelected(int paramInt)
  {
    updateAllTabs();
    if (this.mPanelController != null)
    {
      paramInt = this.mPanelController.findIndexByPanelType(12);
      if (EmoticonPanelController.sLastSelectedSecondTabIndex == paramInt) {
        reportItemExposed();
      }
    }
  }
  
  public void onPullDown()
  {
    if (this.mPanelController == null) {
      return;
    }
    ((EmoticonPanelExtendHelper)this.mPanelController.getHelper(1)).onPullDown();
  }
  
  public void onPullUp()
  {
    if (this.mPanelController == null) {
      return;
    }
    ((EmoticonPanelExtendHelper)this.mPanelController.getHelper(1)).onPullUp();
  }
  
  protected void onRequestFail(asep paramasep)
  {
    if ((this.mLoadingStatus == 0) || (this.mLoadingStatus == 5)) {
      setLoadingStatus(4);
    }
    for (;;)
    {
      notifyHeaderViewChange();
      updateLoadingView();
      notifyFooterViewChange();
      return;
      if ((paramasep.a() == -102) || (paramasep.a() == -100)) {
        setLoadingStatus(7);
      } else if (paramasep.a() == -104) {
        setLoadingStatus(3);
      } else {
        setLoadingStatus(2);
      }
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt1 == 0) && (paramInt2 == 0)) {}
    while ((paramInt1 + paramInt2 < paramInt3) || (this.mLoadingStatus != 1) || (this.mLoadMore)) {
      return;
    }
    this.mLoadMore = true;
    if (((paramAbsListView instanceof EmotionPanelListView)) && (this.mLastScrollState == 2)) {
      ((EmotionPanelListView)paramAbsListView).abordFling();
    }
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonPanelHotPicSearchHelper", 4, "firstVisibleItem: " + paramInt1 + " visibleItemCount: " + paramInt2 + " totalItemCount: " + paramInt3);
    }
    onLoadMore();
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt) {}
  
  public void onSearchCallBack(asep paramasep)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonPanelHotPicSearchHelper", 2, "onSearchCallBack ");
    }
    if ((this.mSearchAdapter == null) || (this.mListView == null))
    {
      this.mLoadMore = false;
      return;
    }
    if (paramasep == null)
    {
      this.mLoadMore = false;
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonPanelHotPicSearchHelper", 2, "onSearchCallBack result： " + paramasep.a());
    }
    if ((paramasep.a() == -101) || (paramasep.a() == -103))
    {
      this.mLoadMore = false;
      return;
    }
    ThreadManager.getUIHandler().post(new EmoticonPanelHotPicSearchHelper.1(this, paramasep));
  }
  
  protected void onSearchPullUp()
  {
    if (sNeedPullUp)
    {
      sNeedPullUp = false;
      onPullUp();
    }
  }
  
  public void onShow()
  {
    int k = 1;
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonPanelHotPicSearchHelper", 4, "onShow ");
    }
    int i;
    int j;
    if ((sLastShowPageType != getPageType()) || (getPageType() == 2))
    {
      i = 1;
      j = k;
      if (i == 0) {
        if (sLastShowPageType != getPageType())
        {
          j = k;
          if (isInEmoticonSearchPanel()) {}
        }
        else
        {
          if (!this.mIsClearWords) {
            break label114;
          }
          j = k;
        }
      }
      label71:
      if ((j != 0) && (this.mListView != null) && (this.mSearchAdapter != null))
      {
        if (!TextUtils.isEmpty(getSearchWord())) {
          break label119;
        }
        loadHotPicData();
      }
    }
    for (;;)
    {
      this.mIsClearWords = false;
      return;
      i = 0;
      break;
      label114:
      j = 0;
      break label71;
      label119:
      boolean bool = sNeedPullUp;
      onSearchPullUp();
      if (!bool) {
        loadSearchPicData();
      }
    }
  }
  
  public void prepareSearch()
  {
    sPrepareSearch = true;
    setLoadingStatus(5);
    if (this.mSearchAdapter != null)
    {
      this.mSearchResultTitleCon.setVisibility(8);
      this.mSearchTitleCon.setVisibility(8);
      this.mLabelFlowLayout.setVisibility(8);
      this.mSearchAdapter.setData(new ArrayList());
    }
  }
  
  protected void pushEmotionSearchTask(QQAppInterface paramQQAppInterface, aseq paramaseq, aser paramaser)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonPanelHotPicSearchHelper", 2, "pushEmotionSearchTask ");
    }
    paramQQAppInterface = (aseo)paramQQAppInterface.getManager(QQManagerFactory.EMOTION_SEARCH_MANAGER);
    paramQQAppInterface.b();
    paramQQAppInterface.a(paramaser);
    paramQQAppInterface.a(paramaseq);
  }
  
  public void removeHeaderAndFooterView(EmotionPanelListView paramEmotionPanelListView)
  {
    if (this.mHeaderView != null) {
      paramEmotionPanelListView.removeHeaderView(this.mHeaderView);
    }
    if (this.mFooterView != null) {
      paramEmotionPanelListView.removeFooterView(this.mFooterView);
    }
  }
  
  protected void report(String paramString, int paramInt)
  {
    EmoticonUtils.report(paramString, paramInt);
  }
  
  protected void reportClickEvent(String paramString)
  {
    bdla.b(getApp(), "dc00898", "", "", paramString, paramString, 0, 0, "2", "", "", "");
  }
  
  protected void reportEvent(String paramString)
  {
    bdla.b(getApp(), "dc00898", "", "", paramString, paramString, 0, 0, "", "", "", "");
  }
  
  public void reportItemExposed()
  {
    if ((this.mSearchAdapter != null) && (this.mListView != null) && ((this.mSearchAdapter instanceof EmotionHotPicSearchAdapter)))
    {
      int i = this.mListView.getFirstVisiblePosition();
      int j = this.mListView.getLastVisiblePosition();
      ((EmotionHotPicSearchAdapter)this.mSearchAdapter).reportDefaultExposeEvent(i, j);
    }
  }
  
  protected void reportLoading()
  {
    if (isInEmoticonSearchPanel()) {
      if (isInSearchPage()) {
        EmoticonUtils.report("0X800AE31", 0);
      }
    }
    while (!isInRichTextSearchPanel())
    {
      return;
      EmoticonUtils.report("0X800AE22", 0);
      return;
    }
    reportEvent("0X800AE38");
  }
  
  protected void reportNetworkErrorClickEvent()
  {
    if (isInRichTextSearchPanel()) {
      reportEvent("0X800AE3A");
    }
    while (!isInEmoticonSearchPanel()) {
      return;
    }
    if (isInSearchPage())
    {
      EmoticonUtils.report("0X800AE33", 0);
      return;
    }
    EmoticonUtils.report("0X800AE24", 0);
  }
  
  protected void reportRequestErrorExposed()
  {
    if (isInRichTextSearchPanel()) {
      reportEvent("0X800AE39");
    }
    while (!isInEmoticonSearchPanel()) {
      return;
    }
    if (isInSearchPage())
    {
      EmoticonUtils.report("0X800AE32", 0);
      return;
    }
    EmoticonUtils.report("0X800AE23", 0);
  }
  
  public void resetEmoticonSearch()
  {
    aseo.a(getApp()).b();
  }
  
  public void setEmptyView(View paramView)
  {
    this.mLoadingEmptyView = paramView;
  }
  
  public void setLoadingStatus(int paramInt)
  {
    this.mLoadingStatus = paramInt;
  }
  
  public void setNeedPullUp(boolean paramBoolean)
  {
    sNeedPullUp = paramBoolean;
  }
  
  public void setSearchContainerVisibility(int paramInt)
  {
    if ((QLog.isColorLevel()) && (sSearchVisibility != paramInt)) {
      QLog.d("EmoticonPanelHotPicSearchHelper", 4, "setSearchContainerVisibility visibility= " + paramInt + " mLoadingStatus: " + this.mLoadingStatus);
    }
    sSearchVisibility = paramInt;
    if ((this.mSearchTitleCon != null) && (this.mSearchResultTitleCon != null))
    {
      if (TextUtils.isEmpty(getSearchWord()))
      {
        this.mSearchResultTitleCon.setVisibility(8);
        this.mSearchTitleCon.setVisibility(paramInt);
      }
    }
    else {
      return;
    }
    this.mSearchTitleCon.setVisibility(8);
    this.mSearchResultTitleCon.setVisibility(paramInt);
  }
  
  public void setSearchWords(String paramString)
  {
    sSearchWord = paramString;
    if (sNeedPullUp) {
      notifyHeaderViewChange();
    }
  }
  
  public void startSearch(String paramString)
  {
    sPrepareSearch = false;
    if ((TextUtils.isEmpty(paramString)) || (this.mSearchAdapter == null)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonPanelHotPicSearchHelper", 4, "startSearch.");
    }
    setSearchWords(paramString);
    this.mSearchAdapter.setData(new ArrayList());
    loadSearchPicData();
    onPullUp();
  }
  
  protected void updateAllTabs()
  {
    if (this.mPanelController == null) {
      return;
    }
    if ((isInEmoticonSearchPanel()) && (!TextUtils.isEmpty(getSearchWord())))
    {
      this.mPanelController.hideAllTabs();
      this.mPanelController.viewPager.setLeftScrollDisEnable(true);
      this.mPanelController.viewPager.setRightScrollDisEnable(true);
      return;
    }
    this.mPanelController.showAllTabs();
    this.mPanelController.mPanelTabSortHelper.updateViewPagerScrollEnable(EmoticonPanelController.sLastSelectedSecondTabIndex);
  }
  
  protected boolean updateEmptyViewLayoutParams()
  {
    RelativeLayout.LayoutParams localLayoutParams;
    int i;
    if ("EmoticonPanelHotPicSearchHelper".equals(getTag()))
    {
      localLayoutParams = (RelativeLayout.LayoutParams)this.mLoadingEmptyView.getLayoutParams();
      if (localLayoutParams == null) {
        return true;
      }
      i = localLayoutParams.topMargin;
      if ((this.mEmoticonTags == null) || (this.mEmoticonTags.isEmpty()) || (this.mLabelFlowLayout == null) || (this.mLabelFlowLayout.getVisibility() != 0)) {
        break label106;
      }
    }
    label106:
    for (localLayoutParams.topMargin = (ViewUtils.dip2px(60.0F) + this.mLabelFlowLayout.getHeight());; localLayoutParams.topMargin = ViewUtils.dip2px(60.0F))
    {
      if (localLayoutParams.topMargin != i) {
        this.mLoadingEmptyView.setLayoutParams(localLayoutParams);
      }
      return false;
    }
  }
  
  protected void updateLoadingView()
  {
    if ((this.mListView == null) || (this.mLoadingEmptyView == null)) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonPanelHotPicSearchHelper", 2, "updateLoadingView.");
      }
    } while (updateEmptyViewLayoutParams());
    TextView localTextView = (TextView)this.mLoadingEmptyView.findViewById(2131366075);
    View localView = this.mLoadingEmptyView.findViewById(2131366086);
    this.mLoadingEmptyView.setVisibility(0);
    if ((this.mLoadingStatus == 4) && ((ViewUtils.dip2px(XPanelContainer.b()) < XPanelContainer.a) || ("RichTextPanelEmoticonSearchLayoutHelper".equals(getTag()))))
    {
      localView.setVisibility(8);
      localTextView.setText(2131689903);
      localTextView.setOnClickListener(this);
      reportRequestErrorExposed();
      return;
    }
    if (this.mLoadingStatus == 5)
    {
      localView.setVisibility(0);
      localTextView.setText(2131689898);
      reportLoading();
      return;
    }
    if (this.mLoadingStatus == 8)
    {
      localView.setVisibility(8);
      localTextView.setText(2131689901);
      return;
    }
    this.mLoadingEmptyView.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonPanelHotPicSearchHelper
 * JD-Core Version:    0.7.0.1
 */