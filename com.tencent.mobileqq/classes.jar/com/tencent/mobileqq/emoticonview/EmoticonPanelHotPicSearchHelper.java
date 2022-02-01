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
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.AIODepend.IPanelInteractionListener;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.business.EmoticonSearchTagsConfProcessor;
import com.tencent.mobileqq.config.business.EmoticonSearchTagsConfProcessor.EmoticonSearchTagConfBean;
import com.tencent.mobileqq.core.util.EmotionSharedPreUtils;
import com.tencent.mobileqq.emosm.IAIOEmoticonUIHelper;
import com.tencent.mobileqq.emosm.IEmoticonPanelHotPicSearchHelper;
import com.tencent.mobileqq.emosm.api.IEmotionSearchManagerService;
import com.tencent.mobileqq.emosm.api.IEmotionSearchManagerService.EmotionSearchResult;
import com.tencent.mobileqq.emosm.api.IEmotionSearchManagerService.EmotionSearchTask;
import com.tencent.mobileqq.emosm.api.IEmotionSearchManagerService.IEmotionSearchCallBack;
import com.tencent.mobileqq.emosm.emosearch.EmotionSearchItem;
import com.tencent.mobileqq.emosm.emosearch.IEmoticonSearchHelper;
import com.tencent.mobileqq.emoticonview.api.IEmosmService;
import com.tencent.mobileqq.emoticonview.ipc.QQEmoticonMainPanelApp;
import com.tencent.mobileqq.emoticonview.ipc.proxy.EmotionSearchManagerServiceProxy;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.ListView;
import com.tencent.widget.XPanelContainer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class EmoticonPanelHotPicSearchHelper
  extends AbstractEmoticonPanelHelper<EmoticonPanelController>
  implements View.OnClickListener, IEmoticonPanelHotPicSearchHelper, IEmotionSearchManagerService.IEmotionSearchCallBack, IEmoticonSearchHelper, AbsListView.OnScrollListener
{
  public static final int ITEM_TYPE_LOAD_INIT = 0;
  public static final String TAG = "EmoticonPanelHotPicSearchHelper";
  protected static int sLastShowPageType = 1;
  protected static boolean sNeedPullUp = false;
  protected static boolean sPrepareSearch = false;
  protected static int sSearchVisibility;
  protected static String sSearchWord;
  protected List<String> mEmoticonTags;
  protected View mFooterView;
  protected View mHeaderView;
  protected IPanelInteractionListener mInteractionListener;
  protected boolean mIsClearWords = false;
  protected EmotionLabelFlowLayout mLabelFlowLayout;
  protected int mLastScrollState = 0;
  protected ListView mListView;
  protected boolean mLoadMore = false;
  protected View mLoadingEmptyView;
  protected int mLoadingStatus = 0;
  protected BaseEmotionAdapter mSearchAdapter;
  protected ViewGroup mSearchResultTitleCon;
  protected ViewGroup mSearchTitleCon;
  protected TextView mSearchTv;
  protected View mSearchView;
  View searchBoxView;
  
  public EmoticonPanelHotPicSearchHelper(IPanelInteractionListener paramIPanelInteractionListener)
  {
    super(null);
    this.mInteractionListener = paramIPanelInteractionListener;
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
          this.mSearchView = View.inflate(getContext(), 2131561597, null);
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
    BaseEmotionAdapter localBaseEmotionAdapter = this.mSearchAdapter;
    if ((localBaseEmotionAdapter instanceof EmotionHotPicSearchAdapter)) {
      ((EmotionHotPicSearchAdapter)localBaseEmotionAdapter).clearReportedMD5List();
    }
  }
  
  public void clearSearchWords()
  {
    sSearchWord = null;
  }
  
  protected int dip2px(int paramInt)
  {
    return ViewUtils.a(paramInt);
  }
  
  public IAIOEmoticonUIHelper getAIOEmoticonUIHelper()
  {
    IPanelInteractionListener localIPanelInteractionListener = this.mInteractionListener;
    if (localIPanelInteractionListener != null) {
      return localIPanelInteractionListener.getAIOEmoticonUIHelper();
    }
    return null;
  }
  
  public QQEmoticonMainPanelApp getApp()
  {
    if (this.mPanelController == null) {
      return new QQEmoticonMainPanelApp(MobileQQ.sMobileQQ.waitAppRuntime(null));
    }
    return ((EmoticonPanelController)this.mPanelController).app;
  }
  
  public Context getContext()
  {
    if (this.mPanelController == null) {
      return MobileQQ.getContext();
    }
    return ((EmoticonPanelController)this.mPanelController).context;
  }
  
  protected View getFooterView()
  {
    if (this.mFooterView == null)
    {
      this.mFooterView = View.inflate(getContext(), 2131561596, null);
      this.mFooterView.setBackgroundColor(0);
      this.mFooterView.setLayoutParams(new AbsListView.LayoutParams(-1, ViewUtils.a(74.0F)));
    }
    notifyFooterViewChange();
    return this.mFooterView;
  }
  
  @NonNull
  public View getHeaderView()
  {
    Object localObject = this.mHeaderView;
    if (localObject != null) {
      return localObject;
    }
    this.mHeaderView = View.inflate(getContext(), 2131561598, null);
    this.mLabelFlowLayout = ((EmotionLabelFlowLayout)this.mHeaderView.findViewById(2131367029));
    localObject = EmoticonSearchTagsConfProcessor.a();
    if (localObject != null)
    {
      localObject = ((EmoticonSearchTagsConfProcessor.EmoticonSearchTagConfBean)localObject).a;
      this.mEmoticonTags = ((List)localObject);
      if ((localObject != null) && (!this.mEmoticonTags.isEmpty()))
      {
        this.mLabelFlowLayout.setAdapter(new EmoticonPanelHotPicSearchHelper.LabelFlowAdapter(this, getContext(), this.mEmoticonTags));
        break label144;
      }
    }
    this.mEmoticonTags = Arrays.asList(getContext().getResources().getStringArray(2130968663));
    this.mLabelFlowLayout.setAdapter(new EmoticonPanelHotPicSearchHelper.LabelFlowAdapter(this, getContext(), this.mEmoticonTags));
    label144:
    if (this.mEmoticonTags == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonPanelHotPicSearchHelper", 4, "emoticonTags is null. ");
      }
    }
    else if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("emoticonTags size: ");
      ((StringBuilder)localObject).append(this.mEmoticonTags.size());
      QLog.d("EmoticonPanelHotPicSearchHelper", 4, ((StringBuilder)localObject).toString());
    }
    return this.mHeaderView;
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
    String str;
    if (ThemeUtil.isNowThemeIsNight(getApp().getAppRuntime(), false, null)) {
      str = "#1C1C1C";
    } else {
      str = "#F5F6FA";
    }
    return ViewUtils.a(Color.parseColor(str), ViewUtils.a(paramInt));
  }
  
  public String getTag()
  {
    return "EmoticonPanelHotPicSearchHelper";
  }
  
  public void initBefore()
  {
    this.mInteractionListener = ((EmoticonPanelController)this.mPanelController).mInteractionListener;
  }
  
  protected void initHeader(View paramView)
  {
    this.mSearchResultTitleCon = ((ViewGroup)paramView.findViewById(2131370348));
    this.mSearchTv = ((TextView)paramView.findViewById(2131379864));
    ImageView localImageView = (ImageView)paramView.findViewById(2131369487);
    Button localButton = (Button)paramView.findViewById(2131363867);
    this.mSearchTitleCon = ((ViewGroup)paramView.findViewById(2131366916));
    this.searchBoxView = paramView.findViewById(2131376780);
    this.searchBoxView.setBackgroundDrawable(getShapeDrawable(18));
    this.mSearchTitleCon.setBackgroundDrawable(getShapeDrawable(18));
    TextView localTextView = this.mSearchTv;
    if (ThemeUtil.isNowThemeIsNight(getApp().getAppRuntime(), false, null)) {
      paramView = "#B0B3BF";
    } else {
      paramView = "#03081A";
    }
    localTextView.setTextColor(Color.parseColor(paramView));
    localImageView.setOnClickListener(this);
    this.mSearchTitleCon.setOnClickListener(this);
    localButton.setOnClickListener(this);
    this.mSearchTv.setOnClickListener(this);
    setSearchContainerVisibility(sSearchVisibility);
  }
  
  protected void initListener()
  {
    ListView localListView = this.mListView;
    if (localListView == null) {
      return;
    }
    localListView.setOnScrollListener(new EmoticonPanelHotPicSearchHelper.2(this));
  }
  
  public int[] interestedIn()
  {
    return new int[] { 8, 4, 5, 3, 1 };
  }
  
  protected boolean isInEmoticonSearchPanel()
  {
    return (getPageType() == 1) && (this.mPanelController != null) && (((EmoticonPanelController)this.mPanelController).findIndexByPanelType(12) == BasePanelModel.sLastSelectedSecondTabIndex);
  }
  
  protected boolean isInRichTextSearchPanel()
  {
    int i = EmotionSharedPreUtils.a(getContext(), getApp().getCurrentAccountUin());
    return (getPageType() == 2) && (i == ((IEmosmService)QRoute.api(IEmosmService.class)).getRichTextChatManagerEmoSearchConfig());
  }
  
  public boolean isInSearchPage()
  {
    return StringUtil.a(getSearchWord()) ^ true;
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
    IEmotionSearchManagerService.EmotionSearchTask localEmotionSearchTask = new IEmotionSearchManagerService.EmotionSearchTask(0);
    pushEmotionSearchTask(getApp(), localEmotionSearchTask, this);
  }
  
  public void loadPicData()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("start loadPicData word is null: ");
      localStringBuilder.append(TextUtils.isEmpty(getSearchWord()));
      localStringBuilder.append(" sPrepareSearch: ");
      localStringBuilder.append(sPrepareSearch);
      QLog.d("EmoticonPanelHotPicSearchHelper", 4, localStringBuilder.toString());
    }
    if (TextUtils.isEmpty(getSearchWord()))
    {
      loadHotPicData();
      return;
    }
    if (!sPrepareSearch)
    {
      onSearchPullUp();
      loadSearchPicData();
      return;
    }
    if (this.mLoadingStatus != 5)
    {
      setLoadingStatus(5);
      notifyHeaderViewChange();
      notifyFooterViewChange();
      updateLoadingView();
      onSearchPullUp();
    }
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
    IEmotionSearchManagerService.EmotionSearchTask localEmotionSearchTask = new IEmotionSearchManagerService.EmotionSearchTask(1, getSearchWord());
    pushEmotionSearchTask(getApp(), localEmotionSearchTask, this);
  }
  
  protected void notifyFooterViewChange()
  {
    if (this.mFooterView != null)
    {
      if (this.mInteractionListener == null) {
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonPanelHotPicSearchHelper", 2, "notifyFooterViewChange.");
      }
      TextView localTextView1 = (TextView)this.mFooterView.findViewById(2131368306);
      localTextView1.setTextSize(12.0F);
      View localView = this.mFooterView.findViewById(2131368305);
      TextView localTextView2 = (TextView)this.mFooterView.findViewById(2131370392);
      localTextView2.setTextSize(12.0F);
      localTextView1.setOnClickListener(this);
      ViewGroup.LayoutParams localLayoutParams = this.mFooterView.getLayoutParams();
      int i = dip2px(74);
      if (localLayoutParams.height != i)
      {
        localLayoutParams.height = i;
        this.mFooterView.setLayoutParams(localLayoutParams);
      }
      i = this.mLoadingStatus;
      if ((i != 1) && (i != 0))
      {
        if (i == 7)
        {
          localTextView1.setVisibility(0);
          localTextView1.setText(2131689858);
          localView.setVisibility(4);
          reportRequestErrorExposed();
          return;
        }
        if ((i != 2) && ((i != 4) || (dip2px(XPanelContainer.b()) < XPanelContainer.a) || (!"EmoticonPanelHotPicSearchHelper".equals(getTag()))))
        {
          localTextView1.setVisibility(8);
          localView.setVisibility(8);
          localLayoutParams.height = -2;
          this.mFooterView.setLayoutParams(localLayoutParams);
          return;
        }
        localTextView1.setVisibility(0);
        localTextView1.setText(2131689859);
        localView.setVisibility(4);
        reportRequestErrorExposed();
        return;
      }
      localView.setVisibility(0);
      localTextView2.setText(2131689854);
      localTextView1.setVisibility(4);
      reportLoading();
    }
  }
  
  protected void notifyHeaderViewChange()
  {
    if (this.mHeaderView == null) {
      return;
    }
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("notifyHeaderViewChange loadingStatus:");
      ((StringBuilder)localObject).append(this.mLoadingStatus);
      QLog.d("EmoticonPanelHotPicSearchHelper", 2, ((StringBuilder)localObject).toString());
    }
    if (TextUtils.isEmpty(getSearchWord()))
    {
      this.mSearchResultTitleCon.setVisibility(8);
      this.mSearchTitleCon.setVisibility(0);
      this.mLabelFlowLayout.setVisibility(0);
    }
    else
    {
      this.mSearchTv.setText(getSearchWord());
      this.mSearchResultTitleCon.setVisibility(0);
      this.mSearchTitleCon.setVisibility(8);
      this.mLabelFlowLayout.setVisibility(8);
      if (this.mPanelController != null)
      {
        localObject = this.mInteractionListener;
        if ((localObject != null) && (((IPanelInteractionListener)localObject).getAIOInput() != null) && (this.mInteractionListener.getAIOInput().isFocused())) {
          try
          {
            this.mInteractionListener.getAIOInput().clearFocus();
          }
          catch (Exception localException)
          {
            QLog.e("EmoticonPanelHotPicSearchHelper", 2, localException, new Object[0]);
          }
        }
      }
    }
    setSearchContainerVisibility(sSearchVisibility);
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    Rect localRect;
    IAIOEmoticonUIHelper localIAIOEmoticonUIHelper;
    if (i == 2131369487)
    {
      if (this.mPanelController != null)
      {
        this.mIsClearWords = true;
        clearSearchWords();
        localRect = new Rect();
        this.mSearchResultTitleCon.getGlobalVisibleRect(localRect);
        localIAIOEmoticonUIHelper = getAIOEmoticonUIHelper();
        if (localIAIOEmoticonUIHelper != null) {
          localIAIOEmoticonUIHelper.a(true, localRect.bottom, true, null, this.searchBoxView.getWidth());
        }
      }
    }
    else if (i == 2131363867)
    {
      clearSearchWords();
      onPullDown();
      loadHotPicData();
      report("0X800AE30", 0);
    }
    else if (i == 2131366916)
    {
      if (this.mPanelController != null)
      {
        report("0X800AE2F", 0);
        localRect = new Rect();
        this.mSearchTitleCon.getGlobalVisibleRect(localRect);
        localIAIOEmoticonUIHelper = getAIOEmoticonUIHelper();
        if (localIAIOEmoticonUIHelper != null) {
          localIAIOEmoticonUIHelper.a(true, localRect.bottom, false, null, this.mSearchTitleCon.getWidth());
        }
        reportClickEvent("0X800AE1E");
      }
    }
    else if (i == 2131379864)
    {
      if (this.mPanelController != null)
      {
        localRect = new Rect();
        this.mSearchTv.getGlobalVisibleRect(localRect);
        localIAIOEmoticonUIHelper = getAIOEmoticonUIHelper();
        if (localIAIOEmoticonUIHelper != null) {
          localIAIOEmoticonUIHelper.a(true, localRect.bottom, false, getSearchWord(), this.searchBoxView.getWidth());
        }
      }
    }
    else if (i == 2131368306)
    {
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
      }
    }
    else if (i == 2131366135)
    {
      loadPicData();
      reportNetworkErrorClickEvent();
    }
    EventCollector.getInstance().onViewClicked(paramView);
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
  
  protected void onHandleResult(IEmotionSearchManagerService.EmotionSearchResult paramEmotionSearchResult)
  {
    if (this.mSearchAdapter != null)
    {
      if (paramEmotionSearchResult == null) {
        return;
      }
      if (paramEmotionSearchResult.getResult() == 0)
      {
        Object localObject1;
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("onSearchCallBack success isHasMore: ");
          ((StringBuilder)localObject1).append(paramEmotionSearchResult.isHasMore());
          QLog.d("EmoticonPanelHotPicSearchHelper", 2, ((StringBuilder)localObject1).toString());
        }
        Object localObject2 = paramEmotionSearchResult.getItemList();
        if ((localObject2 != null) && (!((List)localObject2).isEmpty()))
        {
          localObject1 = new ArrayList();
          localObject2 = ((List)localObject2).iterator();
          int i;
          for (;;)
          {
            boolean bool = ((Iterator)localObject2).hasNext();
            i = 1;
            if (!bool) {
              break;
            }
            EmotionSearchItem localEmotionSearchItem = (EmotionSearchItem)((Iterator)localObject2).next();
            ((List)localObject1).add(new HotPicSearchEmoticonInfo(getPageType(), ((List)localObject1).size() + 1, getSearchWord(), localEmotionSearchItem));
          }
          int j = this.mLoadingStatus;
          if ((j == 0) || (j == 5)) {
            initListener();
          }
          if (!paramEmotionSearchResult.isHasMore()) {
            i = 3;
          }
          setLoadingStatus(i);
          notifyHeaderViewChange();
          notifyFooterViewChange();
          this.mSearchAdapter.setData((List)localObject1);
          updateLoadingView();
        }
        else
        {
          if ((isInSearchPage()) && (isInEmoticonSearchPanel())) {
            EmoticonUtils.report("0X800AE2B", 0);
          }
          setLoadingStatus(8);
          this.mSearchAdapter.setData(new ArrayList());
          updateLoadingView();
          notifyHeaderViewChange();
          notifyFooterViewChange();
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("EmoticonPanelHotPicSearchHelper", 2, "onSearchCallBack fail");
        }
        onRequestFail(paramEmotionSearchResult);
      }
      this.mLoadMore = false;
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
    } else if (isInEmoticonSearchPanel()) {
      if (isInSearchPage()) {
        EmoticonUtils.report("0X800AE2C", 0);
      } else {
        EmoticonUtils.report("0X800AE21", 0);
      }
    }
    IEmotionSearchManagerService localIEmotionSearchManagerService = (IEmotionSearchManagerService)getApp().getService(IEmotionSearchManagerService.class);
    if (localIEmotionSearchManagerService == null) {
      return;
    }
    localIEmotionSearchManagerService.loadMore();
  }
  
  public void onPageSelected(int paramInt)
  {
    updateAllTabs();
    if (this.mPanelController != null)
    {
      paramInt = ((EmoticonPanelController)this.mPanelController).findIndexByPanelType(12);
      if (BasePanelModel.sLastSelectedSecondTabIndex == paramInt) {
        reportItemExposed();
      }
    }
  }
  
  public void onPullDown()
  {
    if (this.mPanelController == null) {
      return;
    }
    ((EmoticonPanelExtendHelper)((EmoticonPanelController)this.mPanelController).getHelper(1)).onPullDown();
  }
  
  public void onPullUp()
  {
    if (this.mPanelController == null) {
      return;
    }
    ((EmoticonPanelExtendHelper)((EmoticonPanelController)this.mPanelController).getHelper(1)).onPullUp();
  }
  
  protected void onRequestFail(IEmotionSearchManagerService.EmotionSearchResult paramEmotionSearchResult)
  {
    int i = this.mLoadingStatus;
    if ((i != 0) && (i != 5))
    {
      if ((paramEmotionSearchResult.getResult() != -102) && (paramEmotionSearchResult.getResult() != -100))
      {
        if (paramEmotionSearchResult.getResult() == -104) {
          setLoadingStatus(3);
        } else {
          setLoadingStatus(2);
        }
      }
      else {
        setLoadingStatus(7);
      }
    }
    else {
      setLoadingStatus(4);
    }
    notifyHeaderViewChange();
    updateLoadingView();
    notifyFooterViewChange();
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      return;
    }
    if ((paramInt1 + paramInt2 >= paramInt3) && (this.mLoadingStatus == 1) && (!this.mLoadMore))
    {
      this.mLoadMore = true;
      if (((paramAbsListView instanceof EmotionPanelListView)) && (this.mLastScrollState == 2)) {
        ((EmotionPanelListView)paramAbsListView).abordFling();
      }
      if (QLog.isColorLevel())
      {
        paramAbsListView = new StringBuilder();
        paramAbsListView.append("firstVisibleItem: ");
        paramAbsListView.append(paramInt1);
        paramAbsListView.append(" visibleItemCount: ");
        paramAbsListView.append(paramInt2);
        paramAbsListView.append(" totalItemCount: ");
        paramAbsListView.append(paramInt3);
        QLog.d("EmoticonPanelHotPicSearchHelper", 4, paramAbsListView.toString());
      }
      onLoadMore();
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt) {}
  
  public void onSearchCallBack(IEmotionSearchManagerService.EmotionSearchResult paramEmotionSearchResult)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonPanelHotPicSearchHelper", 2, "onSearchCallBack ");
    }
    if ((this.mSearchAdapter != null) && (this.mListView != null))
    {
      if (paramEmotionSearchResult == null)
      {
        this.mLoadMore = false;
        return;
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onSearchCallBack result： ");
        localStringBuilder.append(paramEmotionSearchResult.getResult());
        QLog.d("EmoticonPanelHotPicSearchHelper", 2, localStringBuilder.toString());
      }
      if ((paramEmotionSearchResult.getResult() != -101) && (paramEmotionSearchResult.getResult() != -103))
      {
        ThreadManager.getUIHandler().post(new EmoticonPanelHotPicSearchHelper.1(this, paramEmotionSearchResult));
        return;
      }
      this.mLoadMore = false;
      return;
    }
    this.mLoadMore = false;
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
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonPanelHotPicSearchHelper", 4, "onShow ");
    }
    int i = sLastShowPageType;
    int j = getPageType();
    int k = 1;
    if ((i == j) && (getPageType() != 2)) {
      i = 0;
    } else {
      i = 1;
    }
    j = k;
    if (i == 0) {
      if (sLastShowPageType != getPageType())
      {
        j = k;
        if (isInEmoticonSearchPanel()) {}
      }
      else if (this.mIsClearWords)
      {
        j = k;
      }
      else
      {
        j = 0;
      }
    }
    if ((j != 0) && (this.mListView != null) && (this.mSearchAdapter != null)) {
      if (TextUtils.isEmpty(getSearchWord()))
      {
        loadHotPicData();
      }
      else
      {
        boolean bool = sNeedPullUp;
        onSearchPullUp();
        if (!bool) {
          loadSearchPicData();
        }
      }
    }
    this.mIsClearWords = false;
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
  
  protected void pushEmotionSearchTask(QQEmoticonMainPanelApp paramQQEmoticonMainPanelApp, IEmotionSearchManagerService.EmotionSearchTask paramEmotionSearchTask, IEmotionSearchManagerService.IEmotionSearchCallBack paramIEmotionSearchCallBack)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonPanelHotPicSearchHelper", 2, "pushEmotionSearchTask ");
    }
    paramQQEmoticonMainPanelApp = (EmotionSearchManagerServiceProxy)paramQQEmoticonMainPanelApp.getRuntimeService(IEmotionSearchManagerService.class);
    paramQQEmoticonMainPanelApp.resetData();
    paramQQEmoticonMainPanelApp.setSearchCallBack(paramIEmotionSearchCallBack);
    paramQQEmoticonMainPanelApp.pushEmotionSearchTask(paramEmotionSearchTask);
  }
  
  public void removeHeaderAndFooterView(EmotionPanelListView paramEmotionPanelListView)
  {
    View localView = this.mHeaderView;
    if (localView != null) {
      paramEmotionPanelListView.removeHeaderView(localView);
    }
    localView = this.mFooterView;
    if (localView != null) {
      paramEmotionPanelListView.removeFooterView(localView);
    }
  }
  
  protected void report(String paramString, int paramInt)
  {
    EmoticonUtils.report(paramString, paramInt);
  }
  
  protected void reportClickEvent(String paramString)
  {
    ReportController.b(getApp().getQQAppInterface(), "dc00898", "", "", paramString, paramString, 0, 0, "2", "", "", "");
  }
  
  protected void reportEvent(String paramString)
  {
    ReportController.b(getApp().getQQAppInterface(), "dc00898", "", "", paramString, paramString, 0, 0, "", "", "", "");
  }
  
  public void reportItemExposed()
  {
    BaseEmotionAdapter localBaseEmotionAdapter = this.mSearchAdapter;
    if (localBaseEmotionAdapter != null)
    {
      ListView localListView = this.mListView;
      if ((localListView != null) && ((localBaseEmotionAdapter instanceof EmotionHotPicSearchAdapter)))
      {
        int i = localListView.getFirstVisiblePosition();
        int j = this.mListView.getLastVisiblePosition();
        ((EmotionHotPicSearchAdapter)this.mSearchAdapter).reportDefaultExposeEvent(i, j);
      }
    }
  }
  
  protected void reportLoading()
  {
    if (isInEmoticonSearchPanel())
    {
      if (isInSearchPage())
      {
        EmoticonUtils.report("0X800AE31", 0);
        return;
      }
      EmoticonUtils.report("0X800AE22", 0);
      return;
    }
    if (isInRichTextSearchPanel()) {
      reportEvent("0X800AE38");
    }
  }
  
  protected void reportNetworkErrorClickEvent()
  {
    if (isInRichTextSearchPanel())
    {
      reportEvent("0X800AE3A");
      return;
    }
    if (isInEmoticonSearchPanel())
    {
      if (isInSearchPage())
      {
        EmoticonUtils.report("0X800AE33", 0);
        return;
      }
      EmoticonUtils.report("0X800AE24", 0);
    }
  }
  
  protected void reportRequestErrorExposed()
  {
    if (isInRichTextSearchPanel())
    {
      reportEvent("0X800AE39");
      return;
    }
    if (isInEmoticonSearchPanel())
    {
      if (isInSearchPage())
      {
        EmoticonUtils.report("0X800AE32", 0);
        return;
      }
      EmoticonUtils.report("0X800AE23", 0);
    }
  }
  
  public void resetEmoticonSearch()
  {
    IEmotionSearchManagerService localIEmotionSearchManagerService = (IEmotionSearchManagerService)getApp().getService(IEmotionSearchManagerService.class);
    if (localIEmotionSearchManagerService == null) {
      return;
    }
    localIEmotionSearchManagerService.resetData();
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
    if ((QLog.isColorLevel()) && (sSearchVisibility != paramInt))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setSearchContainerVisibility visibility= ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" mLoadingStatus: ");
      localStringBuilder.append(this.mLoadingStatus);
      QLog.d("EmoticonPanelHotPicSearchHelper", 4, localStringBuilder.toString());
    }
    sSearchVisibility = paramInt;
    if ((this.mSearchTitleCon != null) && (this.mSearchResultTitleCon != null))
    {
      if (TextUtils.isEmpty(getSearchWord()))
      {
        this.mSearchResultTitleCon.setVisibility(8);
        this.mSearchTitleCon.setVisibility(paramInt);
        return;
      }
      this.mSearchTitleCon.setVisibility(8);
      this.mSearchResultTitleCon.setVisibility(paramInt);
    }
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
    if (!TextUtils.isEmpty(paramString))
    {
      if (this.mSearchAdapter == null) {
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
  }
  
  protected void updateAllTabs()
  {
    if (this.mPanelController == null) {
      return;
    }
    if ((isInEmoticonSearchPanel()) && (!TextUtils.isEmpty(getSearchWord())))
    {
      ((EmoticonPanelController)this.mPanelController).hideAllTabs();
      ((EmoticonPanelController)this.mPanelController).getViewPager().setLeftScrollDisEnable(true);
      ((EmoticonPanelController)this.mPanelController).getViewPager().setRightScrollDisEnable(true);
      return;
    }
    ((EmoticonPanelController)this.mPanelController).showAllTabs();
    ((EmoticonPanelController)this.mPanelController).mPanelTabSortHelper.updateViewPagerScrollEnable(BasePanelModel.sLastSelectedSecondTabIndex);
  }
  
  protected boolean updateEmptyViewLayoutParams()
  {
    if ("EmoticonPanelHotPicSearchHelper".equals(getTag()))
    {
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.mLoadingEmptyView.getLayoutParams();
      if (localLayoutParams == null) {
        return true;
      }
      int i = localLayoutParams.topMargin;
      Object localObject = this.mEmoticonTags;
      if ((localObject != null) && (!((List)localObject).isEmpty()))
      {
        localObject = this.mLabelFlowLayout;
        if ((localObject != null) && (((EmotionLabelFlowLayout)localObject).getVisibility() == 0))
        {
          localLayoutParams.topMargin = (ViewUtils.a(60.0F) + this.mLabelFlowLayout.getHeight());
          break label99;
        }
      }
      localLayoutParams.topMargin = ViewUtils.a(60.0F);
      label99:
      if (localLayoutParams.topMargin != i) {
        this.mLoadingEmptyView.setLayoutParams(localLayoutParams);
      }
    }
    return false;
  }
  
  protected void updateLoadingView()
  {
    if ((this.mListView != null) && (this.mLoadingEmptyView != null))
    {
      if (this.mInteractionListener == null) {
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonPanelHotPicSearchHelper", 2, "updateLoadingView.");
      }
      if (updateEmptyViewLayoutParams()) {
        return;
      }
      TextView localTextView = (TextView)this.mLoadingEmptyView.findViewById(2131366135);
      View localView = this.mLoadingEmptyView.findViewById(2131366146);
      this.mLoadingEmptyView.setVisibility(0);
      if ((this.mLoadingStatus == 4) && ((ViewUtils.a(XPanelContainer.b()) < XPanelContainer.a) || (getPageType() == 2)))
      {
        localView.setVisibility(8);
        localTextView.setText(2131689859);
        localTextView.setOnClickListener(this);
        reportRequestErrorExposed();
        return;
      }
      int i = this.mLoadingStatus;
      if (i == 5)
      {
        localView.setVisibility(0);
        localTextView.setText(2131689854);
        reportLoading();
        return;
      }
      if (i == 8)
      {
        localView.setVisibility(8);
        localTextView.setText(2131689857);
        return;
      }
      this.mLoadingEmptyView.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonPanelHotPicSearchHelper
 * JD-Core Version:    0.7.0.1
 */