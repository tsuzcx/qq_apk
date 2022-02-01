package com.tencent.mobileqq.emoticonview;

import android.content.Context;
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
    if (sInstance == null) {
      try
      {
        if (sInstance == null) {
          sInstance = new EmotionPanelListViewPool();
        }
      }
      finally {}
    }
    return sInstance;
  }
  
  public void destory()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmotionPanelListViewPool", 4, "destory");
    }
    List localList = this.listViews;
    if (localList != null)
    {
      localList.clear();
      this.listViews = null;
    }
  }
  
  public EmotionPanelListView getListView(Context paramContext)
  {
    Object localObject = this.listViews;
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      paramContext = (EmotionPanelListView)this.listViews.remove(0);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("from listview pool and poolSize = ");
        ((StringBuilder)localObject).append(this.listViews.size());
        QLog.d("EmotionPanelListViewPool", 4, ((StringBuilder)localObject).toString());
      }
      return paramContext;
    }
    return new EmotionPanelListView(paramContext);
  }
  
  public void relase(EmotionPanelListView paramEmotionPanelListView)
  {
    if (paramEmotionPanelListView == null) {
      return;
    }
    List localList = this.listViews;
    if (localList == null)
    {
      this.listViews = new ArrayList();
      this.listViews.add(paramEmotionPanelListView);
    }
    else if (!localList.contains(paramEmotionPanelListView))
    {
      this.listViews.add(0, paramEmotionPanelListView);
    }
    if (QLog.isColorLevel()) {
      QLog.d("EmotionPanelListViewPool", 4, "relase listview");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmotionPanelListViewPool
 * JD-Core Version:    0.7.0.1
 */