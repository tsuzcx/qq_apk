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
    if (sInstance == null) {
      try
      {
        if (sInstance == null) {
          sInstance = new EmotionPanelViewPool();
        }
      }
      finally {}
    }
    return sInstance;
  }
  
  public void destory()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmotionPanelViewPool", 2, "destory");
    }
    Object localObject = this.views;
    if ((localObject != null) && (((Map)localObject).size() > 0))
    {
      localObject = this.views.entrySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        ArrayList localArrayList = (ArrayList)((Map.Entry)((Iterator)localObject).next()).getValue();
        if (localArrayList != null) {
          localArrayList.clear();
        }
      }
      this.views.clear();
    }
  }
  
  public View getView(int paramInt)
  {
    Object localObject = this.views;
    if ((localObject != null) && (((Map)localObject).containsKey(Integer.valueOf(paramInt))))
    {
      localObject = (ArrayList)this.views.get(Integer.valueOf(paramInt));
      if ((localObject != null) && (((ArrayList)localObject).size() > 0))
      {
        localObject = (View)((ArrayList)localObject).remove(0);
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("getView from pool : paneyType = ");
          localStringBuilder.append(paramInt);
          Log.d("EmotionPanelViewPool", localStringBuilder.toString());
        }
        return localObject;
      }
    }
    return null;
  }
  
  public void release(int paramInt, View paramView)
  {
    if (paramView == null) {
      return;
    }
    Object localObject = this.views;
    if (localObject == null)
    {
      this.views = new ConcurrentHashMap();
      localObject = new ArrayList();
      ((ArrayList)localObject).add(paramView);
      this.views.put(Integer.valueOf(paramInt), localObject);
      return;
    }
    if (((Map)localObject).containsKey(Integer.valueOf(paramInt)))
    {
      localObject = (ArrayList)this.views.get(Integer.valueOf(paramInt));
      if ((localObject != null) && (!((ArrayList)localObject).contains(paramView))) {
        ((ArrayList)localObject).add(0, paramView);
      }
    }
    else
    {
      localObject = new ArrayList();
      ((ArrayList)localObject).add(0, paramView);
      this.views.put(Integer.valueOf(paramInt), localObject);
    }
    if (QLog.isColorLevel())
    {
      paramView = new StringBuilder();
      paramView.append("relase view panelType = ");
      paramView.append(paramInt);
      Log.d("EmotionPanelViewPool", paramView.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmotionPanelViewPool
 * JD-Core Version:    0.7.0.1
 */