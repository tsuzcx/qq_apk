package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
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
  protected IEmoticonMainPanelApp app;
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
  
  public BaseEmotionAdapter(IEmoticonMainPanelApp paramIEmoticonMainPanelApp, Context paramContext, int paramInt1, int paramInt2, int paramInt3, EmoticonCallback paramEmoticonCallback)
  {
    this.app = paramIEmoticonMainPanelApp;
    this.mContext = paramContext;
    this.columnNum = paramInt1;
    this.panelType = paramInt2;
    this.emotionType = paramInt3;
    this.callback = paramEmoticonCallback;
    this.recycleViewMap = new ConcurrentHashMap();
    this.emoticonTextColor = this.mContext.getResources().getColor(2131166554);
    this.density = this.mContext.getResources().getDisplayMetrics().density;
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
            Integer localInteger = (Integer)localView.getTag(2131378201);
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
  
  public int getCount()
  {
    List localList = this.data;
    if (localList != null)
    {
      int k = localList.size();
      int m = this.columnNum;
      int j = k / m;
      int i = j;
      if (k % m > 0) {
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
    if (paramView == null) {
      localObject = newHolder();
    } else {
      localObject = (BaseEmotionAdapter.ViewHolder)paramView.getTag();
    }
    Object localObject = getEmotionView((BaseEmotionAdapter.ViewHolder)localObject, paramInt, paramView, paramViewGroup);
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return localObject;
  }
  
  public abstract BaseEmotionAdapter.ViewHolder newHolder();
  
  public void onAdapterSelected() {}
  
  public void recycleView(int paramInt, View paramView)
  {
    if (paramView == null) {
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("recycleView viewType = ");
      localStringBuilder.append(paramInt);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    paramView.setTag(2131378201, Integer.valueOf(this.widthPixels));
    Object localObject = (ArrayList)this.recycleViewMap.get(Integer.valueOf(paramInt));
    if (localObject == null)
    {
      localObject = new ArrayList();
      ((ArrayList)localObject).add(paramView);
      this.recycleViewMap.put(Integer.valueOf(paramInt), localObject);
      return;
    }
    if (!((ArrayList)localObject).contains(paramView)) {
      ((ArrayList)localObject).add(paramView);
    }
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.BaseEmotionAdapter
 * JD-Core Version:    0.7.0.1
 */