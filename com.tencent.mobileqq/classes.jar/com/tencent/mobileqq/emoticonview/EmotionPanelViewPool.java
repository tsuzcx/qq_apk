package com.tencent.mobileqq.emoticonview;

import android.util.Log;
import android.view.View;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class EmotionPanelViewPool
{
  public static final String TAG = "EmotionPanelViewPool";
  private static EmotionPanelViewPool sInstance;
  public static int widthPixels;
  private Map<Integer, ArrayList<View>> views = new ConcurrentHashMap();
  
  public static EmotionPanelViewPool getInstance()
  {
    if (sInstance == null) {}
    try
    {
      if (sInstance == null) {
        sInstance = new EmotionPanelViewPool();
      }
      return sInstance;
    }
    finally {}
  }
  
  public void destory()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmotionPanelViewPool", 2, "destory");
    }
    if ((this.views != null) && (this.views.size() > 0))
    {
      Iterator localIterator = this.views.entrySet().iterator();
      while (localIterator.hasNext())
      {
        ArrayList localArrayList = (ArrayList)((Map.Entry)localIterator.next()).getValue();
        if (localArrayList != null) {
          localArrayList.clear();
        }
      }
      this.views.clear();
    }
  }
  
  public View getView(int paramInt)
  {
    if ((this.views != null) && (this.views.containsKey(Integer.valueOf(paramInt))))
    {
      Object localObject = (ArrayList)this.views.get(Integer.valueOf(paramInt));
      if ((localObject != null) && (((ArrayList)localObject).size() > 0))
      {
        localObject = (View)((ArrayList)localObject).remove(0);
        if (QLog.isColorLevel()) {
          Log.d("EmotionPanelViewPool", "getView from pool : paneyType = " + paramInt);
        }
        return localObject;
      }
    }
    return null;
  }
  
  public void release(int paramInt, View paramView)
  {
    if (paramView == null) {}
    for (;;)
    {
      return;
      ArrayList localArrayList;
      if (this.views == null)
      {
        this.views = new ConcurrentHashMap();
        localArrayList = new ArrayList();
        localArrayList.add(paramView);
        this.views.put(Integer.valueOf(paramInt), localArrayList);
        return;
      }
      if (this.views.containsKey(Integer.valueOf(paramInt)))
      {
        localArrayList = (ArrayList)this.views.get(Integer.valueOf(paramInt));
        if ((localArrayList != null) && (!localArrayList.contains(paramView))) {
          localArrayList.add(0, paramView);
        }
      }
      while (QLog.isColorLevel())
      {
        Log.d("EmotionPanelViewPool", "relase view panelType = " + paramInt);
        return;
        localArrayList = new ArrayList();
        localArrayList.add(0, paramView);
        this.views.put(Integer.valueOf(paramInt), localArrayList);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmotionPanelViewPool
 * JD-Core Version:    0.7.0.1
 */