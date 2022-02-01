package com.tencent.widget;

import android.database.DataSetObservable;
import android.database.DataSetObserver;
import java.util.ArrayList;

class XBaseAdapter$ListDataSetObservable
  extends DataSetObservable
{
  XBaseAdapter$ListDataSetObservable(XBaseAdapter paramXBaseAdapter) {}
  
  public void notifyRowDeleted(int paramInt1, int paramInt2)
  {
    int i;
    synchronized (this.mObservers)
    {
      i = this.mObservers.size() - 1;
      if (i >= 0)
      {
        DataSetObserver localDataSetObserver = (DataSetObserver)this.mObservers.get(i);
        if ((localDataSetObserver instanceof XBaseAdapter.ListDataSetListener)) {
          ((XBaseAdapter.ListDataSetListener)localDataSetObserver).onRowDeleted(paramInt1, paramInt2);
        } else {
          localDataSetObserver.onChanged();
        }
      }
      else
      {
        return;
      }
    }
  }
  
  public void notifyRowDeleted(int... paramVarArgs)
  {
    int i;
    synchronized (this.mObservers)
    {
      i = this.mObservers.size() - 1;
      if (i >= 0)
      {
        DataSetObserver localDataSetObserver = (DataSetObserver)this.mObservers.get(i);
        if ((localDataSetObserver instanceof XBaseAdapter.ListDataSetListener)) {
          ((XBaseAdapter.ListDataSetListener)localDataSetObserver).onRowDeleted(paramVarArgs);
        } else {
          localDataSetObserver.onChanged();
        }
      }
      else
      {
        return;
      }
    }
  }
  
  public void notifyRowInserted(int paramInt1, int paramInt2)
  {
    int i;
    synchronized (this.mObservers)
    {
      i = this.mObservers.size() - 1;
      if (i >= 0)
      {
        DataSetObserver localDataSetObserver = (DataSetObserver)this.mObservers.get(i);
        if ((localDataSetObserver instanceof XBaseAdapter.ListDataSetListener)) {
          ((XBaseAdapter.ListDataSetListener)localDataSetObserver).onRowInserted(paramInt1, paramInt2);
        } else {
          localDataSetObserver.onChanged();
        }
      }
      else
      {
        return;
      }
    }
  }
  
  public void notifyRowUpdated(int paramInt1, int paramInt2)
  {
    int i = this.mObservers.size() - 1;
    while (i >= 0)
    {
      DataSetObserver localDataSetObserver = (DataSetObserver)this.mObservers.get(i);
      if ((localDataSetObserver instanceof XBaseAdapter.ListDataSetListener)) {
        ((XBaseAdapter.ListDataSetListener)localDataSetObserver).onRowUpdated(paramInt1, paramInt2);
      } else {
        localDataSetObserver.onChanged();
      }
      i -= 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.widget.XBaseAdapter.ListDataSetObservable
 * JD-Core Version:    0.7.0.1
 */