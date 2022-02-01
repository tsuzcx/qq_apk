package com.tencent.mobileqq.emoticonview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Color;
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
import com.tencent.mobileqq.EmotionPanelInjectionInfoManager;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.emosm.api.ICameraEmoRoamingManagerService;
import com.tencent.mobileqq.emosm.api.IEmoticonManagerService;
import com.tencent.mobileqq.emoticon.EmotionInjectionInfo;
import com.tencent.mobileqq.emoticon.IEmotionTabCreateListener;
import com.tencent.mobileqq.emoticonview.ipc.proxy.CameraEmoRoamingManagerServiceProxy;
import com.tencent.mobileqq.emoticonview.ipc.proxy.EmoticonManagerServiceProxy;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.abtest.ABTestController;
import com.tencent.mobileqq.utils.abtest.ABTestUtil;
import com.tencent.mobileqq.utils.abtest.ExpEntityInfo;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;

public class EmoticonTabAdapter
  extends BaseAdapter
{
  public static LruCache<String, URL> urlCache = new LruCache(50);
  IEmoticonMainPanelApp app;
  private boolean inGuildLiveRoom = false;
  private int mBusinessType;
  protected Context mContext;
  List<EmoticonTabAdapter.EmoticonTabItem> mData;
  private Drawable mGifEntranceIconDrawable = null;
  LayoutInflater mInflater;
  Drawable mItemNormalDrawable;
  Drawable mItemSelectedDrawable;
  Drawable mNormalDrawable;
  private EmotionPanelInjectionInfoManager mPanelInjectionInfoManager;
  Drawable mSelectedDrawable;
  private boolean mStyleChange;
  
  public EmoticonTabAdapter(IEmoticonMainPanelApp paramIEmoticonMainPanelApp, EmotionPanelInjectionInfoManager paramEmotionPanelInjectionInfoManager, Context paramContext, int paramInt)
  {
    this.app = paramIEmoticonMainPanelApp;
    this.mContext = paramContext;
    this.mPanelInjectionInfoManager = paramEmotionPanelInjectionInfoManager;
    this.mInflater = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    this.mData = new ArrayList();
    this.mNormalDrawable = paramContext.getResources().getDrawable(2130838002);
    this.mSelectedDrawable = paramContext.getResources().getDrawable(2130838003);
    this.mItemSelectedDrawable = ViewUtils.getShapeDrawable(this.mContext.getResources().getColor(2131167473), ViewUtils.dip2px(18.0F));
    this.mItemNormalDrawable = new ColorDrawable(0);
    this.mBusinessType = paramInt;
  }
  
  public static URL generateTabUrl(String paramString, boolean paramBoolean)
  {
    Object localObject1 = null;
    if (paramString == null) {
      return null;
    }
    try
    {
      Object localObject2 = urlCache;
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append(paramString);
      localStringBuilder1.append("_");
      localStringBuilder1.append(paramBoolean);
      localObject2 = (URL)((LruCache)localObject2).get(localStringBuilder1.toString());
      if (localObject2 != null) {
        return localObject2;
      }
      try
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(paramString);
        ((StringBuilder)localObject1).append("_");
        ((StringBuilder)localObject1).append(paramBoolean);
        localObject1 = new URL("protocol_vas_extension_image", "EMOTICON_TAB", ((StringBuilder)localObject1).toString());
      }
      catch (MalformedURLException localMalformedURLException2)
      {
        localObject1 = localObject2;
        localObject2 = localMalformedURLException2;
      }
      localStringBuilder2 = new StringBuilder();
    }
    catch (MalformedURLException localMalformedURLException1) {}
    StringBuilder localStringBuilder2;
    localStringBuilder2.append("generateTabUrl error = ");
    localStringBuilder2.append(localMalformedURLException1.getMessage());
    QLog.e("EmoticonTabAdapter", 2, localStringBuilder2.toString());
    urlCache.put(paramString, localObject1);
    return localObject1;
  }
  
  private Drawable getCmShowIcon(int paramInt)
  {
    String str = ((IApolloManagerService)this.app.getQQAppInterface().getRuntimeService(IApolloManagerService.class, "all")).getTabActionAvatar();
    if (!TextUtils.isEmpty(str)) {
      return Drawable.createFromPath(str);
    }
    if (paramInt > 0) {
      return this.mContext.getResources().getDrawable(paramInt);
    }
    return null;
  }
  
  public static void removeTabDrawableCache(String paramString) {}
  
  private void setEmoMallDTReport(View paramView)
  {
    if (this.mBusinessType != 0) {
      return;
    }
    VideoReport.setElementId(paramView, "em_aio_stickers_mall_below_textbox");
    VideoReport.setElementExposePolicy(paramView, ExposurePolicy.REPORT_ALL);
    VideoReport.setElementClickPolicy(paramView, ClickPolicy.REPORT_ALL);
    VideoReport.setElementReuseIdentifier(paramView, "em_aio_stickers_mall_below_textbox");
  }
  
  private void setEmoSettingDTReport(View paramView)
  {
    if (this.mBusinessType != 0) {
      return;
    }
    VideoReport.setElementId(paramView, "em_aio_setting_below_textbox");
    VideoReport.setElementExposePolicy(paramView, ExposurePolicy.REPORT_ALL);
    VideoReport.setElementClickPolicy(paramView, ClickPolicy.REPORT_ALL);
    VideoReport.setElementReuseIdentifier(paramView, "em_aio_setting_below_textbox");
  }
  
  public int getCount()
  {
    return this.mData.size();
  }
  
  public Object getItem(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.mData.size())) {
      return this.mData.get(paramInt);
    }
    QLog.e("EmoticonTabAdapter", 1, "getItem error");
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public Drawable getTabDrawable(EmoticonTabAdapter.EmoticonTabItem paramEmoticonTabItem)
  {
    Object localObject1 = generateTabUrl(paramEmoticonTabItem.epId, paramEmoticonTabItem.completed);
    if (localObject1 != null)
    {
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      Object localObject2 = this.mNormalDrawable;
      localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject2);
      localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject2);
      boolean bool;
      if (10 == paramEmoticonTabItem.type) {
        bool = true;
      } else {
        bool = false;
      }
      localURLDrawableOptions.mExtraInfo = Boolean.valueOf(bool);
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("getTabDrawable, completed = ");
        ((StringBuilder)localObject2).append(paramEmoticonTabItem.completed);
        ((StringBuilder)localObject2).append(", epId = ");
        ((StringBuilder)localObject2).append(paramEmoticonTabItem.epId);
        QLog.d("EmoticonTabAdapter", 2, ((StringBuilder)localObject2).toString());
      }
      localObject1 = URLDrawable.getDrawable((URL)localObject1, localURLDrawableOptions);
      paramEmoticonTabItem = (EmoticonTabAdapter.EmoticonTabItem)localObject1;
      if (((URLDrawable)localObject1).getStatus() == 2)
      {
        ((URLDrawable)localObject1).restartDownload();
        return localObject1;
      }
    }
    else
    {
      paramEmoticonTabItem = null;
    }
    return paramEmoticonTabItem;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    EmoticonTabAdapter.ViewHolder localViewHolder;
    View localView;
    if (paramView == null)
    {
      localViewHolder = new EmoticonTabAdapter.ViewHolder(this);
      localView = HorizontalListViewEx.consumeView();
      if (localView == null) {
        localView = this.mInflater.inflate(2131627954, paramViewGroup, false);
      }
      localViewHolder.tabImage = ((URLImageView)localView.findViewById(2131446729));
      localViewHolder.redImage = ((ImageView)localView.findViewById(2131444541));
      localViewHolder.emoContainer = localView.findViewById(2131432402);
      localView.setTag(localViewHolder);
    }
    else
    {
      localViewHolder = (EmoticonTabAdapter.ViewHolder)paramView.getTag();
      localView = paramView;
    }
    Object localObject3 = (EmoticonTabAdapter.EmoticonTabItem)getItem(paramInt);
    Object localObject1 = null;
    paramView = null;
    Object localObject2 = null;
    if (localObject3 == null)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("getView item is null ,position = ");
      ((StringBuilder)localObject1).append(paramInt);
      QLog.e("EmoticonTabAdapter", 1, ((StringBuilder)localObject1).toString());
    }
    else
    {
      localViewHolder.redImage.setVisibility(8);
      Object localObject4;
      if (this.mStyleChange)
      {
        localView.setBackgroundDrawable(null);
        paramView = new StateListDrawable();
        if (this.inGuildLiveRoom) {
          this.mItemSelectedDrawable = ViewUtils.getShapeDrawable(Color.parseColor("#2F3033"), ViewUtils.dip2px(18.0F));
        }
        localObject4 = this.mItemSelectedDrawable;
        paramView.addState(new int[] { 16842913 }, (Drawable)localObject4);
        localObject4 = this.mItemNormalDrawable;
        paramView.addState(new int[0], (Drawable)localObject4);
        localViewHolder.emoContainer.setBackgroundDrawable(paramView);
      }
      else
      {
        localViewHolder.emoContainer.setBackgroundDrawable(null);
        localView.setBackgroundDrawable(this.mContext.getResources().getDrawable(2130847916));
      }
      switch (((EmoticonTabAdapter.EmoticonTabItem)localObject3).type)
      {
      case 5: 
      default: 
        localObject4 = this.mPanelInjectionInfoManager;
        paramView = (View)localObject1;
        if (localObject4 == null) {
          break label980;
        }
        localObject3 = ((EmotionPanelInjectionInfoManager)localObject4).a(((EmoticonTabAdapter.EmoticonTabItem)localObject3).type);
        paramView = (View)localObject1;
        if (localObject3 == null) {
          break label980;
        }
        localObject1 = localObject2;
        if (((EmotionInjectionInfo)localObject3).iconResId > 0) {
          localObject1 = this.mContext.getResources().getDrawable(((EmotionInjectionInfo)localObject3).iconResId);
        }
        break;
      case 15: 
        localObject2 = this.mPanelInjectionInfoManager;
        paramView = (View)localObject1;
        if (localObject2 == null) {
          break label980;
        }
        localObject2 = ((EmotionPanelInjectionInfoManager)localObject2).a(((EmoticonTabAdapter.EmoticonTabItem)localObject3).type);
        paramView = (View)localObject1;
        if (localObject2 == null) {
          break label980;
        }
        localObject1 = getCmShowIcon(((EmotionInjectionInfo)localObject2).iconResId);
        paramView = (View)localObject1;
        if (((EmotionInjectionInfo)localObject2).emotionTabListener == null) {
          break label980;
        }
        ((EmotionInjectionInfo)localObject2).emotionTabListener.onCreateTabView(localView, localViewHolder.tabImage, localViewHolder.redImage, paramInt);
        paramView = (View)localObject1;
        break;
      case 14: 
        paramView = this.mContext.getResources().getDrawable(2130847936);
        setEmoSettingDTReport(localViewHolder.emoContainer);
        break;
      case 13: 
        paramView = this.mContext.getResources().getDrawable(2130847918);
        setEmoMallDTReport(localViewHolder.emoContainer);
        break;
      case 12: 
        paramView = this.mGifEntranceIconDrawable;
        if (paramView != null) {
          break label980;
        }
        paramView = this.mContext.getResources().getDrawable(2130837987);
        break;
      case 11: 
        if (((CameraEmoRoamingManagerServiceProxy)this.app.getRuntimeService(ICameraEmoRoamingManagerService.class)).getIsNeedShowGuide()) {
          localViewHolder.redImage.setVisibility(0);
        }
        paramView = this.mContext.getResources().getDrawable(2130837983);
        break;
      case 9: 
        paramView = this.mContext.getResources().getDrawable(2130849020);
        break;
      case 8: 
        localObject1 = this.mContext.getResources().getDrawable(2130849036);
        localObject2 = this.app;
        paramView = (View)localObject1;
        if (localObject2 == null) {
          break label980;
        }
        localObject2 = (EmoticonManagerServiceProxy)((IEmoticonMainPanelApp)localObject2).getRuntimeService(IEmoticonManagerService.class);
        paramView = (View)localObject1;
        if (localObject2 == null) {
          break label980;
        }
        paramView = (View)localObject1;
        if (!((EmoticonManagerServiceProxy)localObject2).isShowRecommendTabRedPoint(this.mBusinessType)) {
          break label980;
        }
        localViewHolder.redImage.setVisibility(0);
        this.app.getApplication().getSharedPreferences("recommendEmotion_sp_name", 0).edit().putBoolean("recommemd_red_effect", true).apply();
        VasWebviewUtil.a(this.app.getCurrentUin(), "ep_mall", "j_redshow", "", 0, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
        paramView = (View)localObject1;
        break;
      case 7: 
        paramView = this.mContext.getResources().getDrawable(2130838001);
        break;
      case 6: 
      case 10: 
        localObject1 = getTabDrawable((EmoticonTabAdapter.EmoticonTabItem)localObject3);
        paramView = (View)localObject1;
        if (localObject1 == null)
        {
          paramView = new StateListDrawable();
          localObject1 = this.mSelectedDrawable;
          paramView.addState(new int[] { 16842913 }, (Drawable)localObject1);
          localObject1 = this.mNormalDrawable;
          paramView.addState(new int[0], (Drawable)localObject1);
          ThreadManager.post(new EmoticonTabAdapter.1(this, (EmoticonTabAdapter.EmoticonTabItem)localObject3), 5, null, false);
        }
        break;
      case 4: 
        paramView = this.mContext.getResources().getDrawable(2130849019);
        break;
      }
      paramView = (View)localObject1;
      if (((EmotionInjectionInfo)localObject3).emotionTabListener != null)
      {
        ((EmotionInjectionInfo)localObject3).emotionTabListener.onCreateTabView(localView, localViewHolder.tabImage, localViewHolder.redImage, paramInt);
        paramView = (View)localObject1;
      }
      label980:
      if (paramView != null) {
        localViewHolder.tabImage.setImageDrawable(paramView);
      }
      paramView = localView;
    }
    EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
    return paramView;
  }
  
  public void setAIOShowStyleChange(boolean paramBoolean)
  {
    this.mStyleChange = paramBoolean;
  }
  
  @SuppressLint({"UseCompatLoadingForDrawables"})
  public void setGifEntranceIconUrl(String paramString)
  {
    ExpEntityInfo localExpEntityInfo = ABTestController.a().a("exp_qq_msg_marketface_gif_icon");
    Map localMap = localExpEntityInfo.a();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setGifEntranceIconUrl:");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", exp:");
      localStringBuilder.append(localExpEntityInfo.k());
      QLog.d("EmoticonTabAdapter", 2, localStringBuilder.toString());
    }
    this.mGifEntranceIconDrawable = this.mContext.getResources().getDrawable(2130837987);
    if ((localExpEntityInfo.i()) && (localMap != null) && (localMap.containsKey("gif_entrance_icon_url")))
    {
      paramString = ABTestUtil.a((String)localMap.get("gif_entrance_icon_url"), 48, 48);
      if ((paramString != null) && (paramString.getCurrDrawable() != null)) {
        this.mGifEntranceIconDrawable = paramString;
      }
    }
    else if (!TextUtils.isEmpty(paramString))
    {
      paramString = ABTestUtil.a(paramString, 48, 48);
      if ((paramString != null) && (paramString.getCurrDrawable() != null)) {
        this.mGifEntranceIconDrawable = paramString;
      }
    }
  }
  
  public void setInGuildLiveRoom(boolean paramBoolean)
  {
    this.inGuildLiveRoom = paramBoolean;
  }
  
  protected void setNoSkinDrawable()
  {
    this.mItemSelectedDrawable = ViewUtils.getShapeDrawable(Color.parseColor("#EAEAEA"), ViewUtils.dip2px(18.0F));
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