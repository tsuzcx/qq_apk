package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.support.v4.util.LruCache;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import aseg;
import awyr;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import mqq.app.MobileQQ;

public class EmoticonTabAdapter
  extends BaseAdapter
{
  public static LruCache<String, URL> urlCache = new LruCache(50);
  QQAppInterface app;
  private int mBusinessType;
  protected Context mContext;
  List<EmoticonTabAdapter.EmoticonTabItem> mData;
  LayoutInflater mInflater;
  Drawable mItemNormalDrawable;
  Drawable mItemSelectedDrawable;
  Drawable mNormalDrawable;
  Drawable mSelectedDrawable;
  private boolean mStyleChange;
  
  public EmoticonTabAdapter(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt)
  {
    this.app = paramQQAppInterface;
    this.mContext = paramContext;
    this.mInflater = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    this.mData = new ArrayList();
    this.mNormalDrawable = paramContext.getResources().getDrawable(2130838057);
    this.mSelectedDrawable = paramContext.getResources().getDrawable(2130838058);
    this.mItemSelectedDrawable = ViewUtils.getShapeDrawable(this.mContext.getResources().getColor(2131166536), ViewUtils.dip2px(18.0F));
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
        break label726;
      }
      paramView = this.mInflater.inflate(2131559180, paramViewGroup, false);
    }
    label726:
    for (;;)
    {
      localViewHolder.tabImage = ((URLImageView)paramView.findViewById(2131378394));
      localViewHolder.redImage = ((ImageView)paramView.findViewById(2131376444));
      localViewHolder.emoContainer = paramView.findViewById(2131366056);
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
        label235:
        switch (((EmoticonTabAdapter.EmoticonTabItem)localObject).type)
        {
        case 5: 
        default: 
          paramView = null;
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
        localView.setBackgroundDrawable(this.mContext.getResources().getDrawable(2130839697));
        break label235;
        paramView = this.mContext.getResources().getDrawable(2130847160);
        if (this.app != null)
        {
          localObject = (awyr)this.app.getManager(QQManagerFactory.EMOTICON_MANAGER);
          if ((localObject != null) && (((awyr)localObject).a(this.mBusinessType)))
          {
            localViewHolder.redImage.setVisibility(0);
            this.app.getApplication().getSharedPreferences("recommendEmotion_sp_name", 0).edit().putBoolean("recommemd_red_effect", true).apply();
            VasWebviewUtil.reportCommercialDrainage(this.app.getCurrentUin(), "ep_mall", "j_redshow", "", 0, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
          }
          else
          {
            continue;
            paramView = this.mContext.getResources().getDrawable(2130847144);
            continue;
            paramView = this.mContext.getResources().getDrawable(2130847143);
            continue;
            if (((aseg)this.app.getManager(QQManagerFactory.CAMERA_EMOTION_MANAGER)).b()) {
              localViewHolder.redImage.setVisibility(0);
            }
            paramView = this.mContext.getResources().getDrawable(2130838038);
            continue;
            paramView = this.mContext.getResources().getDrawable(2130838056);
            continue;
            paramView = this.mContext.getResources().getDrawable(2130838041);
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
              paramView = this.mContext.getResources().getDrawable(2130847152);
              continue;
              paramView = this.mContext.getResources().getDrawable(2130847153);
            }
            else {}
          }
        }
      }
    }
  }
  
  public void setAIOShowStyleChange(boolean paramBoolean)
  {
    this.mStyleChange = paramBoolean;
  }
  
  public void updateData(List<EmoticonTabAdapter.EmoticonTabItem> paramList)
  {
    this.mData.clear();
    this.mData.addAll(paramList);
    notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonTabAdapter
 * JD-Core Version:    0.7.0.1
 */