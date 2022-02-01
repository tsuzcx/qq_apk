package com.tencent.mobileqq.emoticonview;

import amrg;
import android.content.Context;
import android.content.res.Resources;
import android.os.Looper;
import android.support.v4.view.PagerAdapter;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import avsq;
import bjqx;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.ListView;
import com.tencent.widget.XEditTextEx;
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
  public QQAppInterface app;
  public Map<String, BaseEmotionAdapter> bigEmotionAdapters;
  public int businessType = 0;
  public EmoticonCallback callback;
  public EmotionPanelInfo curItemInfo;
  public List<EmotionPanelInfo> data;
  public float density;
  public SparseArray<ImageButton> emotionDeleteButtons;
  boolean isFilterSysFaceBeyond255 = false;
  boolean isOnlySysEmotion = false;
  public HashSet<String> justDownload = new HashSet();
  public boolean kanDianBiu;
  public BaseChatPie mBaseChatPie;
  public Context mContext;
  public int mainPanelWidth;
  public boolean multiWindowMode;
  public Map<Integer, BaseEmotionAdapter> otherEmotionAdapters;
  int[] sysEmotionOrder = null;
  
  public EmotionPanelViewPagerAdapter(QQAppInterface paramQQAppInterface, Context paramContext, EmoticonCallback paramEmoticonCallback, BaseChatPie paramBaseChatPie, int paramInt, boolean paramBoolean)
  {
    this.mBaseChatPie = paramBaseChatPie;
    this.businessType = paramInt;
    this.app = paramQQAppInterface;
    this.mContext = paramContext;
    this.callback = paramEmoticonCallback;
    this.kanDianBiu = paramBoolean;
    this.density = paramContext.getResources().getDisplayMetrics().density;
    this.data = new ArrayList();
    this.otherEmotionAdapters = new HashMap();
    this.emotionDeleteButtons = new SparseArray();
    this.bigEmotionAdapters = new HashMap();
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
    localImageButton.setContentDescription(this.mContext.getString(2131689868));
    localImageButton.setBackgroundResource(2130838020);
    localImageButton.setOnClickListener(this);
    if (TextUtils.isEmpty(this.mBaseChatPie.input.getText())) {}
    for (int i = 8;; i = 0)
    {
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
  }
  
  private void handleIPSite(EmoticonPackage paramEmoticonPackage, BaseEmotionAdapter paramBaseEmotionAdapter, List<EmotionPanelData> paramList)
  {
    Object localObject;
    if (paramEmoticonPackage != null)
    {
      localObject = EmoticonRecDressup.getEmotionRecommend(paramEmoticonPackage.epId, false);
      if ((localObject == null) || (System.currentTimeMillis() - ((EmoticonRecDressup)localObject).lastLookupTime > EmoticonRecDressup.RECOMMEND_EXPIRED_TIME)) {
        ((amrg)this.app.getBusinessHandler(12)).b(Integer.parseInt(paramEmoticonPackage.epId));
      }
      if (!(paramBaseEmotionAdapter instanceof BigEmotionDownloadedAdapter)) {
        break label86;
      }
      fetchIPSite((avsq)this.app.getManager(14), Collections.singleton(paramEmoticonPackage), false);
    }
    label86:
    while ((!(paramBaseEmotionAdapter instanceof MagicFaceAdapter)) || (paramList == null)) {
      return;
    }
    paramEmoticonPackage = (avsq)this.app.getManager(14);
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
          localObject = paramEmoticonPackage.a(((PicEmoticonInfo)localObject).emoticon.epId);
          if (localObject != null) {
            paramBaseEmotionAdapter.add(localObject);
          }
        }
      }
    }
    fetchIPSite(paramEmoticonPackage, paramBaseEmotionAdapter, true);
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
  
  private void setSystemAndEmojiAdapterLocalId(BaseEmotionAdapter paramBaseEmotionAdapter)
  {
    if ((this.mBaseChatPie != null) && (this.mBaseChatPie.getEmoPanel() != null) && ((paramBaseEmotionAdapter instanceof SystemAndEmojiAdapter)))
    {
      ((SystemAndEmojiAdapter)paramBaseEmotionAdapter).mLocalId = this.mBaseChatPie.getEmoPanel().mLocalId;
      ((SystemAndEmojiAdapter)paramBaseEmotionAdapter).mEmotionType = this.mBaseChatPie.getEmoPanel().mEmotionType;
      this.mBaseChatPie.getEmoPanel().mLocalId = -1;
      this.mBaseChatPie.getEmoPanel().mEmotionType = -1;
    }
  }
  
  protected void addHeaderAndFooterView(EmotionPanelListView paramEmotionPanelListView, BaseEmotionAdapter paramBaseEmotionAdapter, View paramView, int paramInt)
  {
    if ((paramEmotionPanelListView == null) || (this.mBaseChatPie == null) || (this.mBaseChatPie.getEmoPanel() == null)) {
      return;
    }
    EmoticonPanelHotPicSearchHelper localEmoticonPanelHotPicSearchHelper = (EmoticonPanelHotPicSearchHelper)this.mBaseChatPie.getEmoPanel().getEmoController().getHelper(7);
    localEmoticonPanelHotPicSearchHelper.addHeaderAndFooterView(paramEmotionPanelListView, paramBaseEmotionAdapter, paramInt);
    localEmoticonPanelHotPicSearchHelper.setEmptyView(paramView);
    paramEmotionPanelListView.addOnScrollListener(localEmoticonPanelHotPicSearchHelper);
  }
  
  protected void asyncFetchEmotionSearchData()
  {
    if ((this.mBaseChatPie == null) || (this.mBaseChatPie.getEmoPanel() == null)) {
      return;
    }
    ((EmoticonPanelHotPicSearchHelper)this.mBaseChatPie.getEmoPanel().getEmoController().getHelper(7)).loadPicData();
  }
  
  public void destroyItem(View paramView, int paramInt, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmotionPanelViewPagerAdapter", 2, "destroyItem position = " + paramInt);
    }
    if ((paramView == null) || (paramObject == null))
    {
      QLog.e("EmotionPanelViewPagerAdapter", 1, "container or object = null");
      return;
    }
    ((ViewGroup)paramView).removeView((View)paramObject);
    label111:
    int i;
    if ((paramObject instanceof RelativeLayout))
    {
      paramView = (EmotionPanelListView)((RelativeLayout)paramObject).getChildAt(0);
      ((RelativeLayout)paramObject).removeViewAt(0);
      paramObject = paramView.getAdapter();
      if (!(paramObject instanceof bjqx)) {
        break label249;
      }
      paramObject = (BaseEmotionAdapter)((bjqx)paramObject).getWrappedAdapter();
      paramView.setAdapter(null);
      paramView.setOnScrollListener(null);
      paramView.setEnableExtendPanle(false);
      paramView.setPullAndFastScrollListener(null);
      removeHeaderAndFooterView(paramView);
      if (paramObject != null)
      {
        i = paramObject.emotionType;
        if ((i != 6) && (i != 10)) {
          break label257;
        }
        EmoticonPackage localEmoticonPackage = paramObject.getEmoticonPackage();
        if ((localEmoticonPackage != null) && (!TextUtils.isEmpty(localEmoticonPackage.epId)) && (this.bigEmotionAdapters.containsKey(localEmoticonPackage.epId))) {
          this.bigEmotionAdapters.remove(localEmoticonPackage.epId);
        }
      }
    }
    for (;;)
    {
      if (this.emotionDeleteButtons != null) {
        this.emotionDeleteButtons.remove(paramInt);
      }
      paramObject.destory();
      EmotionPanelListViewPool.getInstance().relase(paramView);
      return;
      paramView = (EmotionPanelListView)paramObject;
      break;
      label249:
      paramObject = (BaseEmotionAdapter)paramObject;
      break label111;
      label257:
      if (this.otherEmotionAdapters.containsKey(Integer.valueOf(i))) {
        this.otherEmotionAdapters.remove(Integer.valueOf(i));
      }
    }
  }
  
  public void fetchIPSite(avsq paramavsq, Collection<EmoticonPackage> paramCollection, boolean paramBoolean)
  {
    long l2 = System.currentTimeMillis();
    amrg localamrg = (amrg)this.app.getBusinessHandler(12);
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      EmoticonPackage localEmoticonPackage = (EmoticonPackage)paramCollection.next();
      if (localEmoticonPackage.status == 2)
      {
        if (localEmoticonPackage.richIPReqTime == 0L) {}
        for (long l1 = 86400L;; l1 = localEmoticonPackage.richIPReqTime)
        {
          if (QLog.isColorLevel()) {
            QLog.d("EmotionPanelViewPagerAdapter", 2, "rich ip emoticon, richReqTime = " + l1 + " epId = " + localEmoticonPackage.epId);
          }
          if (l2 - localEmoticonPackage.richIPLastReqTime <= l1 * 1000L) {
            break;
          }
          localEmoticonPackage.richIPLastReqTime = l2;
          localamrg.a(localEmoticonPackage.epId, paramBoolean);
          paramavsq.a(localEmoticonPackage);
          break;
        }
      }
    }
  }
  
  BaseEmotionAdapter getAdapterFromCache(EmotionPanelInfo paramEmotionPanelInfo)
  {
    if (paramEmotionPanelInfo == null) {}
    do
    {
      do
      {
        return null;
        if (QLog.isColorLevel()) {
          QLog.d("EmotionPanelViewPagerAdapter", 2, "getAdapterFromCache type = " + paramEmotionPanelInfo.type);
        }
        if ((paramEmotionPanelInfo.type != 6) && (paramEmotionPanelInfo.type != 10)) {
          break;
        }
        paramEmotionPanelInfo = paramEmotionPanelInfo.emotionPkg;
      } while ((paramEmotionPanelInfo == null) || (TextUtils.isEmpty(paramEmotionPanelInfo.epId)) || (!this.bigEmotionAdapters.containsKey(paramEmotionPanelInfo.epId)));
      return (BaseEmotionAdapter)this.bigEmotionAdapters.get(paramEmotionPanelInfo.epId);
    } while (!this.otherEmotionAdapters.containsKey(Integer.valueOf(paramEmotionPanelInfo.type)));
    return (BaseEmotionAdapter)this.otherEmotionAdapters.get(Integer.valueOf(paramEmotionPanelInfo.type));
  }
  
  public int getCount()
  {
    if (this.data != null) {
      return this.data.size();
    }
    QLog.e("EmotionPanelViewPagerAdapter", 1, "getCount count = 0");
    return 0;
  }
  
  public ImageButton getDeleteButtonFromCache(int paramInt)
  {
    if (this.emotionDeleteButtons == null) {
      return null;
    }
    if (QLog.isColorLevel()) {
      QLog.d("EmotionPanelViewPagerAdapter", 2, "getDeleteButtonFromCache position = " + paramInt);
    }
    return (ImageButton)this.emotionDeleteButtons.get(paramInt);
  }
  
  protected RelativeLayout getHotPicSearchEmoticonLayout(EmotionPanelListView paramEmotionPanelListView, int paramInt, BaseEmotionAdapter paramBaseEmotionAdapter)
  {
    if (paramInt == 14)
    {
      RelativeLayout localRelativeLayout = new RelativeLayout(this.mContext);
      localRelativeLayout.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
      localRelativeLayout.addView(paramEmotionPanelListView, new RelativeLayout.LayoutParams(-1, -1));
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      localLayoutParams.topMargin = ViewUtils.dip2px(60.0F);
      localLayoutParams.addRule(12);
      View localView = View.inflate(this.mContext, 2131558600, null);
      localRelativeLayout.addView(localView, localLayoutParams);
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
          if (QLog.isColorLevel()) {
            QLog.d("EmotionPanelViewPagerAdapter", 2, "getItemPosition destroy " + localView.getTag());
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
    if (QLog.isColorLevel()) {
      QLog.d("EmotionPanelViewPagerAdapter", 2, "instantiateItem position = " + paramInt);
    }
    EmotionPanelListView localEmotionPanelListView = EmotionPanelListViewPool.getInstance().getListView(this.mContext);
    if (localEmotionPanelListView == null)
    {
      QLog.e("EmotionPanelViewPagerAdapter", 1, "instantiateItem listView is null");
      paramView = null;
      return paramView;
    }
    localEmotionPanelListView.setDivider(null);
    localEmotionPanelListView.setVerticalScrollBarEnabled(true);
    localEmotionPanelListView.setEdgeEffectEnabled(false);
    localEmotionPanelListView.setSelector(2130850608);
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
        QLog.d("EmotionPanelViewPagerAdapter", 2, "multiWindowMode: " + localEmotionPanelInfo.columnNum + "->" + j);
        i = j;
      }
    }
    BaseEmotionAdapter localBaseEmotionAdapter = EmotionPanelListViewAdapterBuilder.getInstance().getAdapter(this.app, this.mContext, i, k, localEmotionPanelInfo.type, localEmotionPanelInfo.emotionPkg, this.callback, this.mBaseChatPie, this.businessType, this.kanDianBiu);
    if (localBaseEmotionAdapter == null)
    {
      QLog.e("EmotionPanelViewPagerAdapter", 1, "instantiateItem adapter is null, panelType = " + k);
      return null;
    }
    setSystemAndEmojiAdapterLocalId(localBaseEmotionAdapter);
    if ((localBaseEmotionAdapter instanceof SystemAndEmojiAdapter)) {
      ((SystemAndEmojiAdapter)localBaseEmotionAdapter).isOnlySysEmotion = this.isOnlySysEmotion;
    }
    EmoticonPackage localEmoticonPackage = null;
    Object localObject = localEmoticonPackage;
    if (this.mBaseChatPie != null)
    {
      localObject = localEmoticonPackage;
      if (this.mBaseChatPie.getEmoPanel() != null)
      {
        localObject = localEmoticonPackage;
        if (this.mBaseChatPie.input != null)
        {
          localObject = localEmoticonPackage;
          if (this.mBaseChatPie.getEmoPanel().isShowExtendPanel())
          {
            localEmotionPanelListView.setEnableExtendPanle(true);
            localEmotionPanelListView.setPullAndFastScrollListener(this.mBaseChatPie.getEmoPanel());
            localObject = localEmotionPanelListView.getOnScrollListener();
            if (!(localObject instanceof EmoticonPanelOnScrollListener)) {
              localEmotionPanelListView.setOnScrollListener(new EmoticonPanelOnScrollListener(localEmotionPanelListView, this.mBaseChatPie.getEmoPanel(), (AbsListView.OnScrollListener)localObject));
            }
            if ((k != 1) && (k != 2)) {
              break label641;
            }
            localObject = getSystemSmallEmoticonRelativeLayout(paramInt, localEmotionPanelListView, localBaseEmotionAdapter);
          }
        }
      }
    }
    label440:
    localBaseEmotionAdapter.widthPixels = this.mainPanelWidth;
    localBaseEmotionAdapter.curPanelInfo = this.curItemInfo;
    localBaseEmotionAdapter.setCurrentListView(localEmotionPanelListView);
    localEmotionPanelListView.setAdapter(localBaseEmotionAdapter);
    QLog.d("EmotionPanelViewPagerAdapter", 1, "instantiateItem start get data, panelType = " + k + ", position = " + paramInt + ", panelInfo = " + localEmotionPanelInfo);
    if ((localEmotionPanelInfo.type == 6) || (localEmotionPanelInfo.type == 10))
    {
      localEmoticonPackage = localEmotionPanelInfo.emotionPkg;
      if ((localEmoticonPackage != null) && (!TextUtils.isEmpty(localEmoticonPackage.epId)))
      {
        this.bigEmotionAdapters.put(localEmoticonPackage.epId, localBaseEmotionAdapter);
        label580:
        if ((localObject == null) || (((RelativeLayout)localObject).getParent() == paramView) || (paramInt >= getCount())) {
          break label691;
        }
        ((ViewGroup)paramView).addView((View)localObject);
      }
    }
    for (;;)
    {
      localEmotionPanelListView.setTag(localEmotionPanelInfo);
      asyncGetPanelData(k, localEmotionPanelInfo, localBaseEmotionAdapter, localEmotionPanelListView);
      paramView = (View)localObject;
      if (localObject != null) {
        break;
      }
      return localEmotionPanelListView;
      label641:
      localObject = getHotPicSearchEmoticonLayout(localEmotionPanelListView, k, localBaseEmotionAdapter);
      break label440;
      QLog.e("EmotionPanelViewPagerAdapter", 1, "instantiateItem put adapter to map error");
      break label580;
      this.otherEmotionAdapters.put(Integer.valueOf(localEmotionPanelInfo.type), localBaseEmotionAdapter);
      break label580;
      label691:
      if ((localEmotionPanelListView.getParent() != paramView) && (paramInt < getCount())) {
        ((ViewGroup)paramView).addView(localEmotionPanelListView);
      }
    }
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
  
  public void onClick(View paramView)
  {
    if ((this.mBaseChatPie != null) && (this.mBaseChatPie.getEmoPanel() != null)) {
      this.mBaseChatPie.getEmoPanel().deleteEmoticonClick();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmotionPanelViewPagerAdapter", 2, "onDestroy");
    }
    if (this.data != null)
    {
      this.data.clear();
      notifyDataSetChanged();
    }
    if (this.callback != null) {
      this.callback = null;
    }
    if (this.otherEmotionAdapters != null) {
      this.otherEmotionAdapters.clear();
    }
    if (this.emotionDeleteButtons != null) {
      this.emotionDeleteButtons.clear();
    }
    if (this.bigEmotionAdapters != null) {
      this.bigEmotionAdapters.clear();
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
    if (paramEmotionPanelInfo == null) {}
    do
    {
      return;
      int i = EmotionPanelConstans.getPanelType(this.app, paramEmotionPanelInfo);
      if (QLog.isColorLevel()) {
        QLog.d("EmotionPanelViewPagerAdapter", 2, "onPageSelected panelType = " + i);
      }
      paramEmotionPanelInfo = getAdapterFromCache(paramEmotionPanelInfo);
    } while (paramEmotionPanelInfo == null);
    paramEmotionPanelInfo.curPanelInfo = this.curItemInfo;
    paramEmotionPanelInfo.onAdapterSelected();
  }
  
  public void refreshListViewAdapter(EmotionPanelInfo paramEmotionPanelInfo)
  {
    if (paramEmotionPanelInfo == null) {}
    do
    {
      return;
      if (Looper.myLooper() != Looper.getMainLooper())
      {
        QLog.e("EmotionPanelViewPagerAdapter", 1, "refreshListViewAdapter error not in main thread");
        return;
      }
      int i = EmotionPanelConstans.getPanelType(this.app, paramEmotionPanelInfo);
      if (QLog.isColorLevel()) {
        QLog.d("EmotionPanelViewPagerAdapter", 2, "refreshListViewAdapter panelType = " + i);
      }
      paramEmotionPanelInfo = getAdapterFromCache(paramEmotionPanelInfo);
    } while (paramEmotionPanelInfo == null);
    paramEmotionPanelInfo.refreshPanelData();
    notifyDataSetChanged();
  }
  
  protected void removeHeaderAndFooterView(EmotionPanelListView paramEmotionPanelListView)
  {
    if ((paramEmotionPanelListView == null) || (this.mBaseChatPie == null) || (this.mBaseChatPie.getEmoPanel() == null)) {
      return;
    }
    EmoticonPanelHotPicSearchHelper localEmoticonPanelHotPicSearchHelper = (EmoticonPanelHotPicSearchHelper)this.mBaseChatPie.getEmoPanel().getEmoController().getHelper(7);
    localEmoticonPanelHotPicSearchHelper.removeHeaderAndFooterView(paramEmotionPanelListView);
    paramEmotionPanelListView.removeOnScrollListener(localEmoticonPanelHotPicSearchHelper);
  }
  
  public void setData(List<EmotionPanelInfo> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmotionPanelViewPagerAdapter", 2, "setData justDownload:" + this.justDownload.toString());
    }
    this.data = paramList;
    notifyDataSetChanged();
    this.justDownload.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmotionPanelViewPagerAdapter
 * JD-Core Version:    0.7.0.1
 */