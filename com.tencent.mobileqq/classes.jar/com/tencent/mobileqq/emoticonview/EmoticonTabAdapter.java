package com.tencent.mobileqq.emoticonview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.support.v4.util.LruCache;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.EmotionInjectionInfo;
import com.tencent.mobileqq.EmotionPanelManager;
import com.tencent.mobileqq.abtest.ABTestController;
import com.tencent.mobileqq.abtest.ExpEntityInfo;
import com.tencent.mobileqq.apollo.statistics.product.ApolloDtReportUtil;
import com.tencent.mobileqq.apollo.statistics.product.ApolloDtReportUtil.DtReportParamsBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.business.EmoticonTabSortConfProcessor;
import com.tencent.mobileqq.emoticonview.ipc.QQEmoticonMainPanelApp;
import com.tencent.mobileqq.emoticonview.ipc.proxy.CameraEmoRoamingManagerProxy;
import com.tencent.mobileqq.emoticonview.ipc.proxy.EmoticonManagerProxy;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class EmoticonTabAdapter
  extends BaseAdapter
{
  public static LruCache<String, URL> urlCache = new LruCache(50);
  QQEmoticonMainPanelApp app;
  private int mBusinessType;
  private int mCmShowPosition = -1;
  private ImageView mCmShowRedDot;
  protected Context mContext;
  List<EmoticonTabAdapter.EmoticonTabItem> mData;
  private Drawable mGifEntranceIconDrawable = null;
  LayoutInflater mInflater;
  private boolean mIsEmojiTabCmshowRedDotOn = false;
  Drawable mItemNormalDrawable;
  Drawable mItemSelectedDrawable;
  Drawable mNormalDrawable;
  Drawable mSelectedDrawable;
  private boolean mStyleChange;
  
  public EmoticonTabAdapter(QQEmoticonMainPanelApp paramQQEmoticonMainPanelApp, Context paramContext, int paramInt)
  {
    this.app = paramQQEmoticonMainPanelApp;
    this.mContext = paramContext;
    this.mInflater = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    this.mData = new ArrayList();
    this.mNormalDrawable = paramContext.getResources().getDrawable(2130838129);
    this.mSelectedDrawable = paramContext.getResources().getDrawable(2130838130);
    this.mItemSelectedDrawable = ViewUtils.a(this.mContext.getResources().getColor(2131166539), ViewUtils.a(18.0F));
    this.mItemNormalDrawable = new ColorDrawable(0);
    this.mBusinessType = paramInt;
  }
  
  public static URL generateTabUrl(String paramString, boolean paramBoolean)
  {
    Object localObject2;
    if (paramString == null)
    {
      localObject2 = null;
      return localObject2;
    }
    label98:
    for (;;)
    {
      try
      {
        Object localObject1 = (URL)urlCache.get(paramString + "_" + paramBoolean);
        localObject2 = localObject1;
        if (localObject1 != null) {
          break;
        }
        QLog.e("EmoticonTabAdapter", 2, "generateTabUrl error = " + localMalformedURLException1.getMessage());
      }
      catch (MalformedURLException localMalformedURLException1)
      {
        try
        {
          localObject2 = new URL("protocol_vas_extension_image", "EMOTICON_TAB", paramString + "_" + paramBoolean);
          localObject1 = localObject2;
          urlCache.put(paramString, localObject1);
          return localObject1;
        }
        catch (MalformedURLException localMalformedURLException2)
        {
          break label98;
        }
        localMalformedURLException1 = localMalformedURLException1;
        localObject1 = null;
      }
    }
  }
  
  public static void removeTabDrawableCache(String paramString) {}
  
  public int getCount()
  {
    return this.mData.size();
  }
  
  public Object getItem(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.mData.size()))
    {
      QLog.e("EmoticonTabAdapter", 1, "getItem error");
      return null;
    }
    return this.mData.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public Drawable getTabDrawable(EmoticonTabAdapter.EmoticonTabItem paramEmoticonTabItem)
  {
    URL localURL = generateTabUrl(paramEmoticonTabItem.epId, paramEmoticonTabItem.completed);
    Object localObject = null;
    if (localURL != null)
    {
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.mNormalDrawable;
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.mNormalDrawable;
      if (10 != paramEmoticonTabItem.type) {
        break label130;
      }
    }
    label130:
    for (boolean bool = true;; bool = false)
    {
      ((URLDrawable.URLDrawableOptions)localObject).mExtraInfo = Boolean.valueOf(bool);
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonTabAdapter", 2, "getTabDrawable, completed = " + paramEmoticonTabItem.completed + ", epId = " + paramEmoticonTabItem.epId);
      }
      paramEmoticonTabItem = URLDrawable.getDrawable(localURL, (URLDrawable.URLDrawableOptions)localObject);
      localObject = paramEmoticonTabItem;
      if (paramEmoticonTabItem.getStatus() == 2)
      {
        paramEmoticonTabItem.restartDownload();
        localObject = paramEmoticonTabItem;
      }
      return localObject;
    }
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    EmoticonTabAdapter.ViewHolder localViewHolder;
    if (paramView == null)
    {
      localViewHolder = new EmoticonTabAdapter.ViewHolder(this);
      paramView = HorizontalListViewEx.consumeView();
      if (paramView != null) {
        break label849;
      }
      paramView = this.mInflater.inflate(2131559214, paramViewGroup, false);
    }
    label849:
    for (;;)
    {
      localViewHolder.tabImage = ((URLImageView)paramView.findViewById(2131378822));
      localViewHolder.redImage = ((ImageView)paramView.findViewById(2131376837));
      localViewHolder.emoContainer = paramView.findViewById(2131366227);
      paramView.setTag(localViewHolder);
      Object localObject;
      for (View localView = paramView;; localView = paramView)
      {
        localObject = (EmoticonTabAdapter.EmoticonTabItem)getItem(paramInt);
        if (localObject != null) {
          break;
        }
        QLog.e("EmoticonTabAdapter", 1, "getView item is null ,position = " + paramInt);
        paramView = null;
        EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
        return paramView;
        localViewHolder = (EmoticonTabAdapter.ViewHolder)paramView.getTag();
      }
      localViewHolder.redImage.setVisibility(8);
      Drawable localDrawable;
      if (this.mStyleChange)
      {
        localView.setBackgroundDrawable(null);
        paramView = new StateListDrawable();
        localDrawable = this.mItemSelectedDrawable;
        paramView.addState(new int[] { 16842913 }, localDrawable);
        localDrawable = this.mItemNormalDrawable;
        paramView.addState(new int[0], localDrawable);
        localViewHolder.emoContainer.setBackgroundDrawable(paramView);
        label236:
        switch (((EmoticonTabAdapter.EmoticonTabItem)localObject).type)
        {
        case 5: 
        default: 
          paramView = EmoticonTabSortConfProcessor.a(((EmoticonTabAdapter.EmoticonTabItem)localObject).type);
          paramView = EmotionPanelManager.a().a(paramView);
          if ((paramView != null) && (paramView.c > 0)) {
            paramView = this.mContext.getResources().getDrawable(paramView.c);
          }
          break;
        }
      }
      for (;;)
      {
        if (paramView != null) {
          localViewHolder.tabImage.setImageDrawable(paramView);
        }
        paramView = localView;
        break;
        localViewHolder.emoContainer.setBackgroundDrawable(null);
        localView.setBackgroundDrawable(this.mContext.getResources().getDrawable(2130839775));
        break label236;
        paramView = this.mContext.getResources().getDrawable(2130847517);
        if (this.app != null)
        {
          localObject = (EmoticonManagerProxy)this.app.getManager(QQManagerFactory.EMOTICON_MANAGER);
          if ((localObject != null) && (((EmoticonManagerProxy)localObject).isShowRecommendTabRedPoint(this.mBusinessType)))
          {
            localViewHolder.redImage.setVisibility(0);
            this.app.getApplication().getSharedPreferences("recommendEmotion_sp_name", 0).edit().putBoolean("recommemd_red_effect", true).apply();
            VasWebviewUtil.reportCommercialDrainage(this.app.getCurrentUin(), "ep_mall", "j_redshow", "", 0, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
          }
          else
          {
            continue;
            paramView = this.mContext.getResources().getDrawable(2130847499);
            continue;
            paramView = this.mContext.getResources().getDrawable(2130847498);
            continue;
            if (((CameraEmoRoamingManagerProxy)this.app.getManager(QQManagerFactory.CAMERA_EMOTION_MANAGER)).getIsNeedShowGuide()) {
              localViewHolder.redImage.setVisibility(0);
            }
            paramView = this.mContext.getResources().getDrawable(2130838109);
            continue;
            paramView = this.mContext.getResources().getDrawable(2130838128);
            continue;
            if (this.mGifEntranceIconDrawable != null)
            {
              paramView = this.mGifEntranceIconDrawable;
            }
            else
            {
              paramView = this.mContext.getResources().getDrawable(2130838113);
              continue;
              paramView = getTabDrawable((EmoticonTabAdapter.EmoticonTabItem)localObject);
              if (paramView == null)
              {
                paramView = new StateListDrawable();
                localDrawable = this.mSelectedDrawable;
                paramView.addState(new int[] { 16842913 }, localDrawable);
                localDrawable = this.mNormalDrawable;
                paramView.addState(new int[0], localDrawable);
                ThreadManager.post(new EmoticonTabAdapter.1(this, (EmoticonTabAdapter.EmoticonTabItem)localObject), 5, null, false);
                continue;
                if (EmoticonStoreTabEntryUtils.checkIsMergeStoryEntry())
                {
                  paramView = this.mContext.getResources().getDrawable(2130839789);
                }
                else
                {
                  paramView = this.mContext.getResources().getDrawable(2130847509);
                  continue;
                  paramView = this.mContext.getResources().getDrawable(2130847510);
                  continue;
                  paramView = this.mContext.getResources().getDrawable(2130838111);
                  this.mCmShowRedDot = localViewHolder.redImage;
                  this.mCmShowPosition = paramInt;
                  updateCmShowRedDot();
                  continue;
                  paramView = null;
                }
              }
              else {}
            }
          }
        }
      }
    }
  }
  
  public void onCmShowRedDotClick(int paramInt)
  {
    if ((this.mCmShowRedDot == null) || (this.app == null) || (this.app.getQQAppInterface() == null) || (this.mCmShowPosition != paramInt)) {
      return;
    }
    QLog.i("EmoticonTabAdapter", 1, "onCmShowRedDotClick");
    if (this.mIsEmojiTabCmshowRedDotOn) {
      SharedPreUtils.b(this.mContext);
    }
    ((RedTouchManager)this.app.getQQAppInterface().getManager(QQManagerFactory.MGR_RED_TOUCH)).b("130105001");
    this.mCmShowRedDot.setVisibility(8);
    ApolloDtReportUtil.a("aio", "emojicmtab", "click", new ApolloDtReportUtil.DtReportParamsBuilder().a(ApolloDtReportUtil.a(this.app.getQQAppInterface())).a());
  }
  
  public void setAIOShowStyleChange(boolean paramBoolean)
  {
    this.mStyleChange = paramBoolean;
  }
  
  @SuppressLint({"UseCompatLoadingForDrawables"})
  public void setGifEntranceIconUrl(String paramString)
  {
    ExpEntityInfo localExpEntityInfo = ABTestController.a("exp_qq_msg_marketface_gif_icon");
    Map localMap = localExpEntityInfo.getParams();
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonTabAdapter", 2, "setGifEntranceIconUrl:" + paramString + ", exp:" + localExpEntityInfo.a());
    }
    this.mGifEntranceIconDrawable = this.mContext.getResources().getDrawable(2130838113);
    if ((localExpEntityInfo.c()) && (localMap != null) && (localMap.containsKey("gif_entrance_icon_url")))
    {
      paramString = ABTestController.a((String)localMap.get("gif_entrance_icon_url"), 48, 48);
      if ((paramString != null) && (paramString.getCurrDrawable() != null)) {
        this.mGifEntranceIconDrawable = paramString;
      }
    }
    do
    {
      do
      {
        return;
      } while (TextUtils.isEmpty(paramString));
      paramString = ABTestController.a(paramString, 48, 48);
    } while ((paramString == null) || (paramString.getCurrDrawable() == null));
    this.mGifEntranceIconDrawable = paramString;
  }
  
  public void updateCmShowRedDot()
  {
    if ((this.mCmShowRedDot == null) || (this.app == null) || (this.app.getQQAppInterface() == null)) {}
    RedTouchManager localRedTouchManager;
    BusinessInfoCheckUpdate.AppInfo localAppInfo;
    do
    {
      return;
      this.mIsEmojiTabCmshowRedDotOn = SharedPreUtils.a(this.mContext);
      if (this.mIsEmojiTabCmshowRedDotOn)
      {
        this.mCmShowRedDot.setVisibility(0);
        QLog.i("EmoticonTabAdapter", 1, "updateCmShowRedDot");
        return;
      }
      localRedTouchManager = (RedTouchManager)this.app.getQQAppInterface().getManager(QQManagerFactory.MGR_RED_TOUCH);
      localAppInfo = localRedTouchManager.a("130105001");
    } while (localAppInfo == null);
    QLog.i("EmoticonTabAdapter", 1, "updateCmShowRedDot2 " + localAppInfo.iNewFlag.get());
    if (localAppInfo.iNewFlag.get() == 1)
    {
      this.mCmShowRedDot.setVisibility(0);
      localRedTouchManager.b(localAppInfo, "");
      return;
    }
    this.mCmShowRedDot.setVisibility(8);
  }
  
  public void updateData(List<EmoticonTabAdapter.EmoticonTabItem> paramList)
  {
    this.mData.clear();
    this.mData.addAll(paramList);
    notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonTabAdapter
 * JD-Core Version:    0.7.0.1
 */