package com.tencent.mobileqq.emoticonview;

import android.util.SparseArray;
import android.view.View;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class EmoticonPanelViewPool
{
  private static final int DEFAULT_CAPACITY = 3;
  private static final String LOG_TAG = "EmoticonPanelViewPool";
  private SparseArray<List<View>> recyleViewsMap = new SparseArray();
  
  public boolean addRecyleView(int paramInt, View paramView)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[RecyleView] addRecyleView, type=");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(", view=");
      ((StringBuilder)localObject).append(paramView);
      QLog.d("EmoticonPanelViewPool", 2, ((StringBuilder)localObject).toString());
    }
    if (paramView == null) {
      return false;
    }
    List localList = (List)this.recyleViewsMap.get(paramInt);
    Object localObject = localList;
    if (localList == null)
    {
      localObject = new ArrayList(3);
      this.recyleViewsMap.put(paramInt, localObject);
    }
    if (((List)localObject).size() >= 3)
    {
      if (QLog.isColorLevel())
      {
        paramView = new StringBuilder();
        paramView.append("Capacity full for type ");
        paramView.append(paramInt);
        QLog.w("EmoticonPanelViewPool", 2, paramView.toString());
      }
      return false;
    }
    ((List)localObject).add(paramView);
    return true;
  }
  
  public void destroy()
  {
    int j = this.recyleViewsMap.size();
    int i = 0;
    while (i < j)
    {
      int k = this.recyleViewsMap.keyAt(i);
      ((List)this.recyleViewsMap.get(k)).clear();
      i += 1;
    }
    this.recyleViewsMap.clear();
  }
  
  public View getRecyleView(int paramInt)
  {
    List localList = (List)this.recyleViewsMap.get(paramInt);
    if ((localList != null) && (localList.size() > 0)) {
      return (View)localList.remove(0);
    }
    return null;
  }
  
  public int getSize(int paramInt)
  {
    List localList = (List)this.recyleViewsMap.get(paramInt);
    if (localList != null) {
      return localList.size();
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonPanelViewPool
 * JD-Core Version:    0.7.0.1
 */