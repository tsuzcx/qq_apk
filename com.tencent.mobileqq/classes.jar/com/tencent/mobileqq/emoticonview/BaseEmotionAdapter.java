package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public abstract class BaseEmotionAdapter
  extends BaseAdapter
{
  public static final int BIG_EMOTION_CONTENT_HIGHT = 72;
  public static final int BIG_EMOTION_IMG_HEIGHT = 56;
  public static final String TAG = BaseAdapter.class.getSimpleName();
  protected QQAppInterface app;
  protected EmoticonCallback callback;
  protected int columnNum;
  protected EmotionPanelInfo curPanelInfo;
  protected EmotionPanelListView currentView;
  protected List<EmotionPanelData> data = Collections.emptyList();
  protected List<EmotionPanelData> dataHasWhiteFace = new ArrayList();
  protected List<EmotionPanelData> dataNoWhiteFace = new ArrayList();
  protected float density;
  protected int emoticonTextColor;
  protected int emotionType;
  protected Context mContext;
  protected int panelType;
  protected Map<Integer, ArrayList<View>> recycleViewMap;
  public int widthPixels;
  
  public BaseEmotionAdapter(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt1, int paramInt2, int paramInt3, EmoticonCallback paramEmoticonCallback)
  {
    this.app = paramQQAppInterface;
    this.mContext = paramContext;
    this.columnNum = paramInt1;
    this.panelType = paramInt2;
    this.emotionType = paramInt3;
    this.callback = paramEmoticonCallback;
    this.recycleViewMap = new ConcurrentHashMap();
    this.emoticonTextColor = paramContext.getResources().getColor(2131166523);
    this.density = paramContext.getResources().getDisplayMetrics().density;
  }
  
  public void destory()
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "destory");
    }
    if (this.recycleViewMap.size() > 0)
    {
      Iterator localIterator = this.recycleViewMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (Map.Entry)localIterator.next();
        int j = ((Integer)((Map.Entry)localObject).getKey()).intValue();
        localObject = (ArrayList)((Map.Entry)localObject).getValue();
        if ((localObject != null) && (((ArrayList)localObject).size() > 0))
        {
          int i = 0;
          while (i < ((ArrayList)localObject).size())
          {
            View localView = (View)((ArrayList)localObject).get(i);
            if (localView.getParent() != null) {
              ((ViewGroup)localView.getParent()).removeView(localView);
            }
            localView.setTag(null);
            if ((localView instanceof EmoticonPanelLinearLayout)) {
              ((EmoticonPanelLinearLayout)localView).setCallBack(null);
            }
            Integer localInteger = (Integer)localView.getTag(2131366025);
            if (EmotionPanelViewPool.widthPixels == localInteger.intValue()) {
              EmotionPanelViewPool.getInstance().release(j, localView);
            }
            i += 1;
          }
        }
      }
    }
    this.recycleViewMap.clear();
    this.currentView = null;
    if (this.callback != null) {
      this.callback = null;
    }
  }
  
  public RelativeLayout getBigEmotionContentViewLayout()
  {
    long l = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "getEmotionLayout");
    }
    RelativeLayout localRelativeLayout = new RelativeLayout(this.mContext);
    localRelativeLayout.setLayoutParams(new LinearLayout.LayoutParams(this.widthPixels / this.columnNum, (int)(72.0F * this.density)));
    try
    {
      Object localObject1 = new TextView(this.mContext);
      if (localObject1 != null)
      {
        ((TextView)localObject1).setVisibility(8);
        ((TextView)localObject1).setId(2131365982);
        ((TextView)localObject1).setTextColor(this.emoticonTextColor);
        ((TextView)localObject1).setTextSize(11.0F);
        localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
        localLayoutParams.addRule(12);
        localLayoutParams.topMargin = ((int)(5.0F * this.density));
        ((TextView)localObject1).setGravity(17);
        localRelativeLayout.addView((View)localObject1, localLayoutParams);
      }
      localObject1 = new URLImageView(this.mContext);
      ((URLImageView)localObject1).setId(2131365977);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams((int)(this.density * 56.0F), (int)(this.density * 56.0F));
      localLayoutParams.addRule(13, -1);
      localLayoutParams.addRule(2, 2131365982);
      localLayoutParams.addRule(14);
      ((URLImageView)localObject1).setVisibility(8);
      ((URLImageView)localObject1).setScaleType(ImageView.ScaleType.FIT_XY);
      ((URLImageView)localObject1).setAdjustViewBounds(false);
      localRelativeLayout.addView((View)localObject1, localLayoutParams);
      localObject1 = new ImageView(this.mContext);
      ((ImageView)localObject1).setVisibility(8);
      ((ImageView)localObject1).setId(2131365983);
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(7, 2131365977);
      localLayoutParams.addRule(8, 2131365977);
      localRelativeLayout.addView((View)localObject1, localLayoutParams);
      if (AppSetting.c) {
        localRelativeLayout.setFocusable(true);
      }
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "getEmotionlayout cost = " + (System.currentTimeMillis() - l));
      }
      return localRelativeLayout;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject2 = null;
      }
    }
  }
  
  public int getCount()
  {
    if (this.data != null)
    {
      int k = this.data.size();
      int j = k / this.columnNum;
      int i = j;
      if (k % this.columnNum > 0) {
        i = j + 1;
      }
      return i;
    }
    QLog.e(TAG, 1, "get count len = 0");
    return 0;
  }
  
  public EmotionPanelListView getCurrentListView()
  {
    return this.currentView;
  }
  
  public EmoticonPackage getEmoticonPackage()
  {
    return null;
  }
  
  public abstract View getEmotionView(BaseEmotionAdapter.ViewHolder paramViewHolder, int paramInt, View paramView, ViewGroup paramViewGroup);
  
  public Object getItem(int paramInt)
  {
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null) {}
    for (Object localObject = newHolder();; localObject = (BaseEmotionAdapter.ViewHolder)paramView.getTag())
    {
      localObject = getEmotionView((BaseEmotionAdapter.ViewHolder)localObject, paramInt, paramView, paramViewGroup);
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return localObject;
    }
  }
  
  public abstract BaseEmotionAdapter.ViewHolder newHolder();
  
  public void onAdapterSelected() {}
  
  public void recycleView(int paramInt, View paramView)
  {
    if (paramView == null) {}
    ArrayList localArrayList;
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "recycleView viewType = " + paramInt);
      }
      paramView.setTag(2131366025, Integer.valueOf(this.widthPixels));
      localArrayList = (ArrayList)this.recycleViewMap.get(Integer.valueOf(paramInt));
      if (localArrayList == null)
      {
        localArrayList = new ArrayList();
        localArrayList.add(paramView);
        this.recycleViewMap.put(Integer.valueOf(paramInt), localArrayList);
        return;
      }
    } while (localArrayList.contains(paramView));
    localArrayList.add(paramView);
  }
  
  public void refreshPanelData() {}
  
  public void setCurrentListView(EmotionPanelListView paramEmotionPanelListView)
  {
    this.currentView = paramEmotionPanelListView;
  }
  
  public void setData(List<EmotionPanelData> paramList)
  {
    this.data = paramList;
    super.notifyDataSetChanged();
  }
  
  public void updateBigEmotionContentViewData(View paramView, EmotionPanelData paramEmotionPanelData)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "updateBigEmotionContentViewData");
    }
    if ((paramView != null) && (paramEmotionPanelData != null))
    {
      paramView.setVisibility(0);
      localObject1 = null;
      if ((paramEmotionPanelData instanceof EmoticonInfo)) {
        localObject1 = (EmoticonInfo)paramEmotionPanelData;
      }
      if (localObject1 != null) {
        break label61;
      }
      QLog.e(TAG, 1, "emotionInfo = null");
    }
    label61:
    Object localObject2;
    do
    {
      return;
      paramView.setTag(localObject1);
      paramEmotionPanelData = (URLImageView)paramView.findViewById(2131365977);
      long l = System.currentTimeMillis();
      localObject2 = ((EmoticonInfo)localObject1).getDrawable(this.mContext, this.density);
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "getDrawable cost = " + (System.currentTimeMillis() - l));
      }
      paramEmotionPanelData.setImageDrawable((Drawable)localObject2);
      paramEmotionPanelData.setVisibility(0);
    } while (!(localObject1 instanceof PicEmoticonInfo));
    paramEmotionPanelData = (PicEmoticonInfo)localObject1;
    Object localObject1 = (TextView)paramView.findViewById(2131365982);
    if (paramEmotionPanelData.emoticon != null)
    {
      localObject2 = paramEmotionPanelData.emoticon.name;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        break label288;
      }
      ((TextView)localObject1).setVisibility(0);
      if (((String)localObject2).length() > 5) {
        ((TextView)localObject1).setText(((String)localObject2).substring(0, 4) + "...");
      }
    }
    else
    {
      paramView = (ImageView)paramView.findViewById(2131365983);
      if (!paramEmotionPanelData.isSound()) {
        break label308;
      }
      if (!paramEmotionPanelData.isNewSoundType()) {
        break label298;
      }
      paramView.setImageResource(2130838322);
    }
    for (;;)
    {
      paramView.setVisibility(0);
      return;
      ((TextView)localObject1).setText((CharSequence)localObject2);
      break;
      label288:
      ((TextView)localObject1).setVisibility(8);
      break;
      label298:
      paramView.setImageResource(2130850356);
    }
    label308:
    paramView.setVisibility(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.BaseEmotionAdapter
 * JD-Core Version:    0.7.0.1
 */