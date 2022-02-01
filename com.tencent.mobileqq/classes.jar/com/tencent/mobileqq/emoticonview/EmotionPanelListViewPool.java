package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.util.Log;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class EmotionPanelListViewPool
{
  public static final String TAG = "EmotionPanelListViewPool";
  private static EmotionPanelListViewPool sInstance;
  private List<EmotionPanelListView> listViews = new ArrayList();
  
  public static EmotionPanelListViewPool getInstance()
  {
    if (sInstance == null) {}
    try
    {
      if (sInstance == null) {
        sInstance = new EmotionPanelListViewPool();
      }
      return sInstance;
    }
    finally {}
  }
  
  public void destory()
  {
    if (QLog.isColorLevel()) {
      Log.d("EmotionPanelListViewPool", "destory");
    }
    if (this.listViews != null)
    {
      this.listViews.clear();
      this.listViews = null;
    }
  }
  
  public EmotionPanelListView getListView(Context paramContext)
  {
    if ((this.listViews != null) && (this.listViews.size() > 0))
    {
      paramContext = (EmotionPanelListView)this.listViews.remove(0);
      if (QLog.isColorLevel()) {
        Log.d("EmotionPanelListViewPool", "from listview pool and poolSize = " + this.listViews.size());
      }
      return paramContext;
    }
    return new EmotionPanelListView(paramContext);
  }
  
  public void relase(EmotionPanelListView paramEmotionPanelListView)
  {
    if (paramEmotionPanelListView == null) {}
    for (;;)
    {
      return;
      if (this.listViews == null)
      {
        this.listViews = new ArrayList();
        this.listViews.add(paramEmotionPanelListView);
      }
      while (QLog.isColorLevel())
      {
        Log.d("EmotionPanelListViewPool", "relase listview");
        return;
        if (!this.listViews.contains(paramEmotionPanelListView)) {
          this.listViews.add(0, paramEmotionPanelListView);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmotionPanelListViewPool
 * JD-Core Version:    0.7.0.1
 */