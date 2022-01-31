package com.tencent.mobileqq.shortvideo.filter;

import android.os.Build.VERSION;
import com.tencent.sveffects.SLog;
import java.util.ArrayList;
import java.util.Arrays;

public final class QQFilterRenderManager$ChainBuilder
{
  ArrayList<QQFilterRenderManager.ChainBuilder.Entry> mEntry = new ArrayList();
  boolean mNeedSort = false;
  
  QQFilterRenderManager$ChainBuilder(QQFilterRenderManager paramQQFilterRenderManager) {}
  
  private void sort()
  {
    j = 1;
    QQFilterRenderManager.ChainBuilder.1 local1 = new QQFilterRenderManager.ChainBuilder.1(this);
    i = j;
    if (Build.VERSION.SDK_INT >= 24) {}
    try
    {
      this.mEntry.sort(local1);
      i = 0;
    }
    catch (NoSuchMethodError localNoSuchMethodError)
    {
      for (;;)
      {
        QQFilterRenderManager.ChainBuilder.Entry[] arrayOfEntry;
        i = j;
      }
    }
    if (i != 0)
    {
      arrayOfEntry = new QQFilterRenderManager.ChainBuilder.Entry[this.mEntry.size()];
      this.mEntry.toArray(arrayOfEntry);
      Arrays.sort(arrayOfEntry, 0, arrayOfEntry.length, local1);
      this.mEntry.clear();
      this.mEntry.addAll(Arrays.asList(arrayOfEntry));
    }
  }
  
  public void addFilter(int paramInt, Object paramObject)
  {
    this.mEntry.add(new QQFilterRenderManager.ChainBuilder.Entry(this, paramInt, paramObject));
  }
  
  public void commit()
  {
    if (this.mEntry.size() <= 0)
    {
      this.mNeedSort = false;
      SLog.i("QQFilterRenderManager", "QQFilterRenderManager ChainBuilder commit: size=" + this.mEntry.size());
      return;
    }
    if (this.mNeedSort) {
      sort();
    }
    int[] arrayOfInt = new int[this.mEntry.size()];
    Object[] arrayOfObject = new Object[this.mEntry.size()];
    int i = 0;
    while (i < this.mEntry.size())
    {
      arrayOfInt[i] = ((QQFilterRenderManager.ChainBuilder.Entry)this.mEntry.get(i)).type;
      arrayOfObject[i] = ((QQFilterRenderManager.ChainBuilder.Entry)this.mEntry.get(i)).param;
      i += 1;
    }
    QQFilterRenderManager.access$000(this.this$0).push(arrayOfInt, arrayOfObject);
  }
  
  Object getParam(Object[] paramArrayOfObject, int paramInt)
  {
    if ((paramArrayOfObject != null) && (paramInt >= 0) && (paramInt < paramArrayOfObject.length)) {
      return paramArrayOfObject[paramInt];
    }
    return null;
  }
  
  public void setUseSort(boolean paramBoolean)
  {
    this.mNeedSort = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager.ChainBuilder
 * JD-Core Version:    0.7.0.1
 */