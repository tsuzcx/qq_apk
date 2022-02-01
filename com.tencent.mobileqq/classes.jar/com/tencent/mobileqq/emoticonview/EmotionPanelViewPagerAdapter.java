package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.content.res.Resources;
import android.os.Looper;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import androidx.viewpager.widget.PagerAdapter;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.AIODepend.IPanelInteractionListener;
import com.tencent.mobileqq.EmotionPanelInjectionInfoManager;
import com.tencent.mobileqq.activity.aio.core.BaseAIOContext;
import com.tencent.mobileqq.app.EmoticonHandler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emosm.api.IEmoticonManagerService;
import com.tencent.mobileqq.emoticonview.api.IEmosmService;
import com.tencent.mobileqq.emoticonview.ipc.QQEmoticonMainPanelApp;
import com.tencent.mobileqq.emoticonview.ipc.proxy.EmoticonHandlerProxy;
import com.tencent.mobileqq.emoticonview.ipc.proxy.EmoticonManagerServiceProxy;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.HeaderViewListAdapter;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;

public class EmotionPanelViewPagerAdapter
  extends PagerAdapter
  implements View.OnClickListener
{
  public static final int PRELOAD_LINE_NUM = 5;
  public static final String TAG = "EmotionPanelViewPagerAdapter";
  BaseAIOContext aioContext;
  public QQEmoticonMainPanelApp app;
  public Map<String, BaseEmotionAdapter> bigEmotionAdapters;
  public int businessType = 0;
  public EmoticonCallback callback;
  public EmotionPanelInfo curItemInfo;
  public List<EmotionPanelInfo> data;
  public float density;
  public SparseArray<ImageButton> emotionDeleteButtons;
  IPanelInteractionListener interactionListener;
  boolean isFilterSysFaceBeyond255 = false;
  boolean isOnlySysEmotion = false;
  public HashSet<String> justDownload = new HashSet();
  public boolean kanDianBiu = false;
  public Context mContext;
  public int mainPanelWidth;
  public boolean multiWindowMode;
  public Map<Integer, BaseEmotionAdapter> otherEmotionAdapters;
  IEmoticonPanelController panelController;
  EmotionPanelInjectionInfoManager panelInjectionInfoManager;
  boolean showDescInPreview = false;
  int[] sysEmotionOrder = null;
  
  public EmotionPanelViewPagerAdapter(QQEmoticonMainPanelApp paramQQEmoticonMainPanelApp, IPanelInteractionListener paramIPanelInteractionListener, Context paramContext, EmoticonCallback paramEmoticonCallback, int paramInt, boolean paramBoolean)
  {
    this.businessType = paramInt;
    this.app = paramQQEmoticonMainPanelApp;
    this.mContext = paramContext;
    this.callback = paramEmoticonCallback;
    this.kanDianBiu = paramBoolean;
    this.interactionListener = paramIPanelInteractionListener;
    this.density = this.mContext.getResources().getDisplayMetrics().density;
    this.data = new ArrayList();
    this.otherEmotionAdapters = new HashMap();
    this.emotionDeleteButtons = new SparseArray();
    this.bigEmotionAdapters = new HashMap();
    if (paramIPanelInteractionListener != null) {
      this.aioContext = paramIPanelInteractionListener.getAIOContext();
    }
  }
  
  private void asyncGetPanelData(int paramInt, EmotionPanelInfo paramEmotionPanelInfo, BaseEmotionAdapter paramBaseEmotionAdapter, ListView paramListView)
  {
    if (paramInt == 14)
    {
      asyncFetchEmotionSearchData();
      return;
    }
    ThreadManager.post(new EmotionPanelViewPagerAdapter.1(this, paramInt, paramBaseEmotionAdapter, paramEmotionPanelInfo, paramListView), 5, null, true);
  }
  
  @NotNull
  private RelativeLayout getSystemSmallEmoticonRelativeLayout(int paramInt, EmotionPanelListView paramEmotionPanelListView, BaseEmotionAdapter paramBaseEmotionAdapter)
  {
    RelativeLayout localRelativeLayout = new RelativeLayout(this.mContext);
    localRelativeLayout.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
    localRelativeLayout.addView(paramEmotionPanelListView, new RelativeLayout.LayoutParams(-1, -1));
    paramEmotionPanelListView = new RelativeLayout.LayoutParams(-2, -2);
    ImageButton localImageButton = new ImageButton(this.mContext);
    localImageButton.setContentDescription(this.mContext.getString(2131886494));
    localImageButton.setBackgroundResource(2130837979);
    localImageButton.setOnClickListener(this);
    int i;
    if (TextUtils.isEmpty(this.interactionListener.getAIOInput().getText())) {
      i = 8;
    } else {
      i = 0;
    }
    localImageButton.setVisibility(i);
    paramEmotionPanelListView.rightMargin = ViewUtils.dip2px(5.0F);
    paramEmotionPanelListView.bottomMargin = ViewUtils.dip2px(7.0F);
    paramEmotionPanelListView.addRule(11);
    paramEmotionPanelListView.addRule(12);
    localRelativeLayout.addView(localImageButton, paramEmotionPanelListView);
    this.emotionDeleteButtons.put(paramInt, localImageButton);
    localImageButton.measure(0, 0);
    if ((paramBaseEmotionAdapter instanceof SystemAndEmojiAdapter)) {
      ((SystemAndEmojiAdapter)paramBaseEmotionAdapter).setLastItemAddPaddingBottom(localImageButton.getMeasuredHeight());
    }
    return localRelativeLayout;
  }
  
  private void handleIPSite(EmoticonPackage paramEmoticonPackage, BaseEmotionAdapter paramBaseEmotionAdapter, List<EmotionPanelData> paramList)
  {
    if (paramEmoticonPackage != null)
    {
      Object localObject = EmoticonRecDressup.getEmotionRecommend(paramEmoticonPackage.epId, false);
      if ((localObject == null) || (System.currentTimeMillis() - ((EmoticonRecDressup)localObject).lastLookupTime > EmoticonRecDressup.RECOMMEND_EXPIRED_TIME)) {
        ((EmoticonHandlerProxy)this.app.getBusinessHandler(EmoticonHandler.a)).fetchEmoticonRecommend(Integer.parseInt(paramEmoticonPackage.epId));
      }
      if ((paramBaseEmotionAdapter instanceof BigEmotionDownloadedAdapter))
      {
        fetchIPSite((EmoticonManagerServiceProxy)this.app.getRuntimeService(IEmoticonManagerService.class), Collections.singleton(paramEmoticonPackage), false);
        return;
      }
      if (((paramBaseEmotionAdapter instanceof MagicFaceAdapter)) && (paramList != null))
      {
        paramEmoticonPackage = (EmoticonManagerServiceProxy)this.app.getRuntimeService(IEmoticonManagerService.class);
        paramBaseEmotionAdapter = new ArrayList();
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          localObject = (EmotionPanelData)paramList.next();
          if ((localObject instanceof PicEmoticonInfo))
          {
            localObject = (PicEmoticonInfo)localObject;
            if (((PicEmoticonInfo)localObject).emoticon != null)
            {
              localObject = paramEmoticonPackage.syncFindEmoticonPackageById(((PicEmoticonInfo)localObject).emoticon.epId);
              if (localObject != null) {
                paramBaseEmotionAdapter.add(localObject);
              }
            }
          }
        }
        fetchIPSite(paramEmoticonPackage, paramBaseEmotionAdapter, true);
      }
    }
  }
  
  private void preloadSystemEmotion(List<EmotionPanelData> paramList, ListView paramListView)
  {
    if ((paramListView != null) && (paramList != null) && (paramList.size() > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("EmotionPanelViewPagerAdapter", 2, "onScrollStateChanged preload systemEmotion");
      }
      int k = paramListView.getFirstVisiblePosition();
      int j = (paramListView.getLastVisiblePosition() + 1) * 7;
      int i = j;
      while ((i < j + 35) && (i < paramList.size()))
      {
        paramListView = (EmotionPanelData)paramList.get(i);
        if ((paramListView instanceof SystemAndEmojiEmoticonInfo))
        {
          paramListView = (SystemAndEmojiEmoticonInfo)paramListView;
          if ((paramListView.type != 3) && (paramListView.code != -1))
          {
            paramListView = paramListView.getDrawable(false);
            if ((paramListView instanceof URLDrawable))
            {
              paramListView = (URLDrawable)paramListView;
              if ((paramListView != null) && (paramListView.getStatus() != 1)) {
                paramListView.startDownload();
              }
            }
          }
        }
        i += 1;
      }
      j = k * 7 - 1;
      i = j;
      while ((i >= 0) && (i > j - 35) && (i < paramList.size()))
      {
        paramListView = (EmotionPanelData)paramList.get(i);
        if ((paramListView instanceof SystemAndEmojiEmoticonInfo))
        {
          paramListView = (SystemAndEmojiEmoticonInfo)paramListView;
          if ((paramListView.type != 3) && (paramListView.code != -1))
          {
            paramListView = paramListView.getDrawable(this.mContext, this.density);
            if ((paramListView instanceof URLDrawable))
            {
              paramListView = (URLDrawable)paramListView;
              if ((paramListView != null) && (paramListView.getStatus() != 1)) {
                paramListView.startDownload();
              }
            }
          }
        }
        i -= 1;
      }
    }
  }
  
  private void setBigEmotionDownloadedAdapterTabIdx(BaseEmotionAdapter paramBaseEmotionAdapter, int paramInt)
  {
    if ((paramBaseEmotionAdapter instanceof BigEmotionDownloadedAdapter)) {
      ((BigEmotionDownloadedAdapter)paramBaseEmotionAdapter).setTabIdx(paramInt);
    }
  }
  
  private void setSystemAndEmojiAdapterLocalId(BaseEmotionAdapter paramBaseEmotionAdapter)
  {
    if (this.interactionListener == null) {
      return;
    }
    EmoticonMainPanel localEmoticonMainPanel = (EmoticonMainPanel)((IEmosmService)QRoute.api(IEmosmService.class)).tryGetEmoticonMainPanel(this.interactionListener);
    if (localEmoticonMainPanel == null) {
      return;
    }
    if ((paramBaseEmotionAdapter instanceof SystemAndEmojiAdapter))
    {
      paramBaseEmotionAdapter = (SystemAndEmojiAdapter)paramBaseEmotionAdapter;
      paramBaseEmotionAdapter.mLocalId = localEmoticonMainPanel.mLocalId;
      paramBaseEmotionAdapter.mEmotionType = localEmoticonMainPanel.mEmotionType;
      localEmoticonMainPanel.mLocalId = -1;
      localEmoticonMainPanel.mEmotionType = -1;
    }
  }
  
  protected void addHeaderAndFooterView(EmotionPanelListView paramEmotionPanelListView, BaseEmotionAdapter paramBaseEmotionAdapter, View paramView, int paramInt)
  {
    if (paramEmotionPanelListView != null)
    {
      if (this.interactionListener == null) {
        return;
      }
      Object localObject = (EmoticonMainPanel)((IEmosmService)QRoute.api(IEmosmService.class)).tryGetEmoticonMainPanel(this.interactionListener);
      if (localObject == null) {
        return;
      }
      localObject = (EmoticonPanelHotPicSearchHelper)((EmoticonMainPanel)localObject).getEmoController().getHelper(7);
      ((EmoticonPanelHotPicSearchHelper)localObject).addHeaderAndFooterView(paramEmotionPanelListView, paramBaseEmotionAdapter, paramInt);
      ((EmoticonPanelHotPicSearchHelper)localObject).setEmptyView(paramView);
      paramEmotionPanelListView.addOnScrollListener((AbsListView.OnScrollListener)localObject);
    }
  }
  
  protected void asyncFetchEmotionSearchData()
  {
    if (this.interactionListener == null) {
      return;
    }
    EmoticonMainPanel localEmoticonMainPanel = (EmoticonMainPanel)((IEmosmService)QRoute.api(IEmosmService.class)).tryGetEmoticonMainPanel(this.interactionListener);
    if (localEmoticonMainPanel == null) {
      return;
    }
    ((EmoticonPanelHotPicSearchHelper)localEmoticonMainPanel.getEmoController().getHelper(7)).loadPicData();
  }
  
  public void destroyItem(View paramView, int paramInt, Object paramObject)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("destroyItem position = ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("EmotionPanelViewPagerAdapter", 2, ((StringBuilder)localObject).toString());
    }
    if ((paramView != null) && (paramObject != null))
    {
      ((ViewGroup)paramView).removeView((View)paramObject);
      if ((paramObject instanceof RelativeLayout))
      {
        paramView = (EmotionPanelListView)((RelativeLayout)paramObject).findViewById(2131427958);
        ((ViewGroup)paramView.getParent()).removeView(paramView);
      }
      else
      {
        paramView = (EmotionPanelListView)paramObject;
      }
      paramObject = paramView.getAdapter();
      if ((paramObject instanceof HeaderViewListAdapter)) {
        paramObject = (BaseEmotionAdapter)((HeaderViewListAdapter)paramObject).getWrappedAdapter();
      } else {
        paramObject = (BaseEmotionAdapter)paramObject;
      }
      paramView.setAdapter(null);
      paramView.setOnScrollListener(null);
      paramView.setEnableExtendPanle(false);
      paramView.setPullAndFastScrollListener(null);
      removeHeaderAndFooterView(paramView);
      if (paramObject != null)
      {
        int i = paramObject.emotionType;
        if ((i != 6) && (i != 10))
        {
          if (this.otherEmotionAdapters.containsKey(Integer.valueOf(i))) {
            this.otherEmotionAdapters.remove(Integer.valueOf(i));
          }
        }
        else
        {
          localObject = paramObject.getEmoticonPackage();
          if ((localObject != null) && (!TextUtils.isEmpty(((EmoticonPackage)localObject).epId)) && (this.bigEmotionAdapters.containsKey(((EmoticonPackage)localObject).epId))) {
            this.bigEmotionAdapters.remove(((EmoticonPackage)localObject).epId);
          }
        }
        localObject = this.emotionDeleteButtons;
        if (localObject != null) {
          ((SparseArray)localObject).remove(paramInt);
        }
        paramObject.destory();
      }
      EmotionPanelListViewPool.getInstance().relase(paramView);
      return;
    }
    QLog.e("EmotionPanelViewPagerAdapter", 1, "container or object = null");
  }
  
  public void fetchIPSite(EmoticonManagerServiceProxy paramEmoticonManagerServiceProxy, Collection<EmoticonPackage> paramCollection, boolean paramBoolean)
  {
    long l2 = System.currentTimeMillis();
    EmoticonHandlerProxy localEmoticonHandlerProxy = (EmoticonHandlerProxy)this.app.getBusinessHandler(EmoticonHandler.a);
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      EmoticonPackage localEmoticonPackage = (EmoticonPackage)paramCollection.next();
      if (localEmoticonPackage.status == 2)
      {
        long l1;
        if (localEmoticonPackage.richIPReqTime == 0L) {
          l1 = 86400L;
        } else {
          l1 = localEmoticonPackage.richIPReqTime;
        }
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("rich ip emoticon, richReqTime = ");
          localStringBuilder.append(l1);
          localStringBuilder.append(" epId = ");
          localStringBuilder.append(localEmoticonPackage.epId);
          QLog.d("EmotionPanelViewPagerAdapter", 2, localStringBuilder.toString());
        }
        if (l2 - localEmoticonPackage.richIPLastReqTime > l1 * 1000L)
        {
          localEmoticonPackage.richIPLastReqTime = l2;
          localEmoticonHandlerProxy.fetchEmoticonIPSiteInformationEx(localEmoticonPackage.epId, paramBoolean);
          paramEmoticonManagerServiceProxy.saveEmoticonPackage(localEmoticonPackage);
        }
      }
    }
  }
  
  BaseEmotionAdapter getAdapterFromCache(EmotionPanelInfo paramEmotionPanelInfo)
  {
    if (paramEmotionPanelInfo == null) {
      return null;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getAdapterFromCache type = ");
      localStringBuilder.append(paramEmotionPanelInfo.type);
      QLog.d("EmotionPanelViewPagerAdapter", 2, localStringBuilder.toString());
    }
    if ((paramEmotionPanelInfo.type != 6) && (paramEmotionPanelInfo.type != 10))
    {
      if (this.otherEmotionAdapters.containsKey(Integer.valueOf(paramEmotionPanelInfo.type))) {
        return (BaseEmotionAdapter)this.otherEmotionAdapters.get(Integer.valueOf(paramEmotionPanelInfo.type));
      }
    }
    else
    {
      paramEmotionPanelInfo = paramEmotionPanelInfo.emotionPkg;
      if ((paramEmotionPanelInfo != null) && (!TextUtils.isEmpty(paramEmotionPanelInfo.epId)) && (this.bigEmotionAdapters.containsKey(paramEmotionPanelInfo.epId))) {
        return (BaseEmotionAdapter)this.bigEmotionAdapters.get(paramEmotionPanelInfo.epId);
      }
    }
    return null;
  }
  
  public int getCount()
  {
    List localList = this.data;
    if (localList != null) {
      return localList.size();
    }
    QLog.e("EmotionPanelViewPagerAdapter", 1, "getCount count = 0");
    return 0;
  }
  
  public ImageButton getDeleteButtonFromCache(int paramInt)
  {
    if (this.emotionDeleteButtons == null) {
      return null;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getDeleteButtonFromCache position = ");
      localStringBuilder.append(paramInt);
      QLog.d("EmotionPanelViewPagerAdapter", 2, localStringBuilder.toString());
    }
    return (ImageButton)this.emotionDeleteButtons.get(paramInt);
  }
  
  protected RelativeLayout getHotPicSearchEmoticonLayout(EmotionPanelListView paramEmotionPanelListView, int paramInt, BaseEmotionAdapter paramBaseEmotionAdapter)
  {
    if (paramInt == 14)
    {
      RelativeLayout localRelativeLayout = new RelativeLayout(this.mContext);
      localRelativeLayout.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
      Object localObject = new LinearLayout(this.mContext);
      ((LinearLayout)localObject).setOrientation(1);
      paramEmotionPanelListView.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
      ((LinearLayout)localObject).addView(paramEmotionPanelListView);
      localRelativeLayout.addView((View)localObject, new RelativeLayout.LayoutParams(-1, -1));
      localObject = new RelativeLayout.LayoutParams(-1, -1);
      ((RelativeLayout.LayoutParams)localObject).topMargin = ViewUtils.dip2px(60.0F);
      ((RelativeLayout.LayoutParams)localObject).addRule(12);
      View localView = View.inflate(this.mContext, 2131624089, null);
      localRelativeLayout.addView(localView, (ViewGroup.LayoutParams)localObject);
      addHeaderAndFooterView(paramEmotionPanelListView, paramBaseEmotionAdapter, localView, paramInt);
      paramEmotionPanelListView.setVerticalScrollBarEnabled(false);
      return localRelativeLayout;
    }
    removeHeaderAndFooterView(paramEmotionPanelListView);
    return null;
  }
  
  public int getItemPosition(Object paramObject)
  {
    if ((paramObject instanceof View))
    {
      View localView = (View)paramObject;
      EmotionPanelInfo localEmotionPanelInfo = (EmotionPanelInfo)localView.getTag();
      if (localEmotionPanelInfo != null)
      {
        if ((localEmotionPanelInfo.emotionPkg != null) && (this.justDownload.contains(localEmotionPanelInfo.emotionPkg.epId)))
        {
          if (QLog.isColorLevel())
          {
            paramObject = new StringBuilder();
            paramObject.append("getItemPosition destroy ");
            paramObject.append(localView.getTag());
            QLog.d("EmotionPanelViewPagerAdapter", 2, paramObject.toString());
          }
          return -2;
        }
        int j = this.data.indexOf(localEmotionPanelInfo);
        int i = j;
        if (j < 0) {
          i = -2;
        }
        return i;
      }
    }
    return super.getItemPosition(paramObject);
  }
  
  public Object instantiateItem(View paramView, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("instantiateItem position = ");
      ((StringBuilder)localObject1).append(paramInt);
      QLog.d("EmotionPanelViewPagerAdapter", 2, ((StringBuilder)localObject1).toString());
    }
    EmotionPanelListView localEmotionPanelListView = EmotionPanelListViewPool.getInstance().getListView(this.mContext);
    if (localEmotionPanelListView == null)
    {
      QLog.e("EmotionPanelViewPagerAdapter", 1, "instantiateItem listView is null");
      return null;
    }
    localEmotionPanelListView.setDivider(null);
    localEmotionPanelListView.setVerticalScrollBarEnabled(true);
    localEmotionPanelListView.setEdgeEffectEnabled(false);
    localEmotionPanelListView.setSelector(2130853313);
    localEmotionPanelListView.setId(2131427958);
    localEmotionPanelListView.setMotionEventSplittingEnabled(false);
    EmotionPanelInfo localEmotionPanelInfo = (EmotionPanelInfo)this.data.get(paramInt);
    int k = EmotionPanelConstans.getPanelType(this.app, localEmotionPanelInfo);
    int j = localEmotionPanelInfo.columnNum;
    int i = j;
    if (this.multiWindowMode)
    {
      j = Math.max(1, j * 4 / 7);
      i = j;
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("multiWindowMode: ");
        ((StringBuilder)localObject1).append(localEmotionPanelInfo.columnNum);
        ((StringBuilder)localObject1).append("->");
        ((StringBuilder)localObject1).append(j);
        QLog.d("EmotionPanelViewPagerAdapter", 2, ((StringBuilder)localObject1).toString());
        i = j;
      }
    }
    BaseEmotionAdapter localBaseEmotionAdapter = EmotionPanelListViewAdapterBuilder.getInstance().getAdapter(this.app, this.mContext, this.panelInjectionInfoManager, this.interactionListener, i, k, localEmotionPanelInfo.type, localEmotionPanelInfo.emotionPkg, this.callback, this.businessType, this.kanDianBiu);
    if (localBaseEmotionAdapter == null)
    {
      paramView = new StringBuilder();
      paramView.append("instantiateItem adapter is null, panelType = ");
      paramView.append(k);
      QLog.e("EmotionPanelViewPagerAdapter", 1, paramView.toString());
      return null;
    }
    setSystemAndEmojiAdapterLocalId(localBaseEmotionAdapter);
    setBigEmotionDownloadedAdapterTabIdx(localBaseEmotionAdapter, paramInt);
    if ((localBaseEmotionAdapter instanceof SystemAndEmojiAdapter))
    {
      localObject1 = (SystemAndEmojiAdapter)localBaseEmotionAdapter;
      ((SystemAndEmojiAdapter)localObject1).isOnlySysEmotion = this.isOnlySysEmotion;
      ((SystemAndEmojiAdapter)localObject1).setPanelController(this.panelController);
      ((SystemAndEmojiAdapter)localObject1).setShowDescribeInPreview(this.showDescInPreview);
    }
    else if ((localBaseEmotionAdapter instanceof EmotionHotPicSearchAdapter))
    {
      ((EmotionHotPicSearchAdapter)localBaseEmotionAdapter).setEmoPanelController(this.panelController);
    }
    if (this.interactionListener != null)
    {
      localObject1 = (EmoticonMainPanel)((IEmosmService)QRoute.api(IEmosmService.class)).tryGetEmoticonMainPanel(this.interactionListener);
      if (localObject1 != null)
      {
        localObject2 = this.interactionListener;
        if ((localObject2 != null) && (((IPanelInteractionListener)localObject2).getAIOInput() != null) && (((EmoticonMainPanel)localObject1).isShowExtendPanel()))
        {
          localEmotionPanelListView.setEnableExtendPanle(true);
          localEmotionPanelListView.setPullAndFastScrollListener((EmotionPanelListView.PullAndFastScrollListener)localObject1);
          localObject2 = localEmotionPanelListView.getOnScrollListener();
          if (!(localObject2 instanceof EmoticonPanelOnScrollListener)) {
            localEmotionPanelListView.setOnScrollListener(new EmoticonPanelOnScrollListener(localEmotionPanelListView, (EmotionPanelListView.PullAndFastScrollListener)localObject1, (AbsListView.OnScrollListener)localObject2));
          }
          if ((k != 1) && (k != 2))
          {
            localObject1 = getHotPicSearchEmoticonLayout(localEmotionPanelListView, k, localBaseEmotionAdapter);
            break label559;
          }
          localObject1 = getSystemSmallEmoticonRelativeLayout(paramInt, localEmotionPanelListView, localBaseEmotionAdapter);
          break label559;
        }
      }
    }
    Object localObject1 = null;
    label559:
    localBaseEmotionAdapter.widthPixels = this.mainPanelWidth;
    localBaseEmotionAdapter.curPanelInfo = this.curItemInfo;
    localBaseEmotionAdapter.setCurrentListView(localEmotionPanelListView);
    localEmotionPanelListView.setAdapter(localBaseEmotionAdapter);
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("instantiateItem start get data, panelType = ");
    ((StringBuilder)localObject2).append(k);
    ((StringBuilder)localObject2).append(", position = ");
    ((StringBuilder)localObject2).append(paramInt);
    ((StringBuilder)localObject2).append(", panelInfo = ");
    ((StringBuilder)localObject2).append(localEmotionPanelInfo);
    QLog.d("EmotionPanelViewPagerAdapter", 1, ((StringBuilder)localObject2).toString());
    if ((localEmotionPanelInfo.type != 6) && (localEmotionPanelInfo.type != 10))
    {
      this.otherEmotionAdapters.put(Integer.valueOf(localEmotionPanelInfo.type), localBaseEmotionAdapter);
    }
    else
    {
      localObject2 = localEmotionPanelInfo.emotionPkg;
      if ((localObject2 != null) && (!TextUtils.isEmpty(((EmoticonPackage)localObject2).epId))) {
        this.bigEmotionAdapters.put(((EmoticonPackage)localObject2).epId, localBaseEmotionAdapter);
      } else {
        QLog.e("EmotionPanelViewPagerAdapter", 1, "instantiateItem put adapter to map error");
      }
    }
    if (localObject1 != null)
    {
      ViewParent localViewParent = ((RelativeLayout)localObject1).getParent();
      localObject2 = paramView;
      if ((localViewParent != localObject2) && (paramInt < getCount()))
      {
        ((ViewGroup)localObject2).addView((View)localObject1);
        break label828;
      }
    }
    if ((localEmotionPanelListView.getParent() != paramView) && (paramInt < getCount())) {
      ((ViewGroup)paramView).addView(localEmotionPanelListView);
    }
    label828:
    localEmotionPanelListView.setTag(localEmotionPanelInfo);
    asyncGetPanelData(k, localEmotionPanelInfo, localBaseEmotionAdapter, localEmotionPanelListView);
    if (localObject1 != null) {
      return localObject1;
    }
    return localEmotionPanelListView;
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
  
  public void onClick(View paramView)
  {
    if (this.interactionListener != null)
    {
      EmoticonMainPanel localEmoticonMainPanel = (EmoticonMainPanel)((IEmosmService)QRoute.api(IEmosmService.class)).tryGetEmoticonMainPanel(this.interactionListener);
      if (localEmoticonMainPanel != null) {
        localEmoticonMainPanel.deleteEmoticonClick();
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmotionPanelViewPagerAdapter", 2, "onDestroy");
    }
    Object localObject = this.data;
    if (localObject != null)
    {
      ((List)localObject).clear();
      notifyDataSetChanged();
    }
    if (this.callback != null) {
      this.callback = null;
    }
    localObject = this.otherEmotionAdapters;
    if (localObject != null) {
      ((Map)localObject).clear();
    }
    localObject = this.emotionDeleteButtons;
    if (localObject != null) {
      ((SparseArray)localObject).clear();
    }
    localObject = this.bigEmotionAdapters;
    if (localObject != null) {
      ((Map)localObject).clear();
    }
    EmotionPanelListViewPool.getInstance().destory();
    EmotionPanelViewPool.getInstance().destory();
  }
  
  public void onDownload(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.justDownload.add(paramString);
    }
  }
  
  protected void onGetPanelDataResult(int paramInt, EmotionPanelInfo paramEmotionPanelInfo, BaseEmotionAdapter paramBaseEmotionAdapter, ListView paramListView, List<EmotionPanelData> paramList)
  {
    ThreadManager.getUIHandler().post(new EmotionPanelViewPagerAdapter.2(this, paramInt, paramEmotionPanelInfo, paramListView, paramList, paramBaseEmotionAdapter));
  }
  
  public void onPageSelected(EmotionPanelInfo paramEmotionPanelInfo)
  {
    this.curItemInfo = paramEmotionPanelInfo;
    if (paramEmotionPanelInfo == null) {
      return;
    }
    int i = EmotionPanelConstans.getPanelType(this.app, paramEmotionPanelInfo);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onPageSelected panelType = ");
      localStringBuilder.append(i);
      QLog.d("EmotionPanelViewPagerAdapter", 2, localStringBuilder.toString());
    }
    paramEmotionPanelInfo = getAdapterFromCache(paramEmotionPanelInfo);
    if (paramEmotionPanelInfo != null)
    {
      paramEmotionPanelInfo.curPanelInfo = this.curItemInfo;
      paramEmotionPanelInfo.onAdapterSelected();
    }
  }
  
  public void refreshListViewAdapter(EmotionPanelInfo paramEmotionPanelInfo)
  {
    if (paramEmotionPanelInfo == null) {
      return;
    }
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      QLog.e("EmotionPanelViewPagerAdapter", 1, "refreshListViewAdapter error not in main thread");
      return;
    }
    int i = EmotionPanelConstans.getPanelType(this.app, paramEmotionPanelInfo);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("refreshListViewAdapter panelType = ");
      localStringBuilder.append(i);
      QLog.d("EmotionPanelViewPagerAdapter", 2, localStringBuilder.toString());
    }
    paramEmotionPanelInfo = getAdapterFromCache(paramEmotionPanelInfo);
    if (paramEmotionPanelInfo != null)
    {
      paramEmotionPanelInfo.refreshPanelData();
      notifyDataSetChanged();
    }
  }
  
  protected void removeHeaderAndFooterView(EmotionPanelListView paramEmotionPanelListView)
  {
    if (paramEmotionPanelListView != null)
    {
      if (this.interactionListener == null) {
        return;
      }
      Object localObject = (EmoticonMainPanel)((IEmosmService)QRoute.api(IEmosmService.class)).tryGetEmoticonMainPanel(this.interactionListener);
      if (localObject == null) {
        return;
      }
      localObject = (EmoticonPanelHotPicSearchHelper)((EmoticonMainPanel)localObject).getEmoController().getHelper(7);
      ((EmoticonPanelHotPicSearchHelper)localObject).removeHeaderAndFooterView(paramEmotionPanelListView);
      paramEmotionPanelListView.removeOnScrollListener((AbsListView.OnScrollListener)localObject);
    }
  }
  
  public void setData(List<EmotionPanelInfo> paramList)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setData justDownload:");
      localStringBuilder.append(this.justDownload.toString());
      QLog.d("EmotionPanelViewPagerAdapter", 2, localStringBuilder.toString());
    }
    this.data = paramList;
    notifyDataSetChanged();
    this.justDownload.clear();
  }
  
  public void setPanelController(IEmoticonPanelController paramIEmoticonPanelController)
  {
    this.panelController = paramIEmoticonPanelController;
  }
  
  public void setPanelInjectionInfoManager(EmotionPanelInjectionInfoManager paramEmotionPanelInjectionInfoManager)
  {
    this.panelInjectionInfoManager = paramEmotionPanelInjectionInfoManager;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmotionPanelViewPagerAdapter
 * JD-Core Version:    0.7.0.1
 */