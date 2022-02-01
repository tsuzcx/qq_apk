package com.tencent.mobileqq.flashshow.manager;

import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tencent.mobileqq.flashshow.bean.FSFeedSelectInfo;
import com.tencent.mobileqq.flashshow.manager.scroller.FSLayerBaseScroller;
import com.tencent.mobileqq.flashshow.widgets.feed.FSLayerFeedItemView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class FSLayerScrollStatusManager
  implements IFSLayerScrollerStatus
{
  private HashSet<RecyclerView.ViewHolder> a = new HashSet();
  private ArrayList<FSLayerBaseScroller> b = new ArrayList();
  
  private void b()
  {
    Object localObject = this.b;
    if (localObject == null) {
      return;
    }
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((FSLayerBaseScroller)((Iterator)localObject).next()).a(this.a);
    }
  }
  
  public void a()
  {
    QLog.i("FSLayerScrollStatusManager", 1, "fs_lifecycle onDestroy");
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      RecyclerView.ViewHolder localViewHolder = (RecyclerView.ViewHolder)localIterator.next();
      if ((localViewHolder.itemView instanceof FSLayerFeedItemView)) {
        ((FSLayerFeedItemView)localViewHolder.itemView).a();
      }
    }
    localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((FSLayerBaseScroller)localIterator.next()).a();
    }
    this.a = null;
    this.b = null;
  }
  
  public void a(int paramInt1, float paramFloat, int paramInt2)
  {
    Object localObject1 = this.a;
    if (localObject1 != null)
    {
      if (this.b == null) {
        return;
      }
      localObject1 = ((HashSet)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (RecyclerView.ViewHolder)((Iterator)localObject1).next();
        if (((RecyclerView.ViewHolder)localObject2).getAdapterPosition() == paramInt1)
        {
          if ((((RecyclerView.ViewHolder)localObject2).itemView instanceof FSLayerFeedItemView)) {
            ((FSLayerFeedItemView)((RecyclerView.ViewHolder)localObject2).itemView).a(paramInt1, paramFloat, paramInt2);
          }
          localObject2 = this.b.iterator();
          while (((Iterator)localObject2).hasNext()) {
            ((FSLayerBaseScroller)((Iterator)localObject2).next()).a(paramInt1, paramFloat, paramInt2);
          }
        }
      }
    }
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder)
  {
    HashSet localHashSet = this.a;
    if ((localHashSet != null) && (paramViewHolder != null))
    {
      if (localHashSet.contains(paramViewHolder)) {
        return;
      }
      this.a.add(paramViewHolder);
      b();
      paramViewHolder = new StringBuilder();
      paramViewHolder.append("addViewHolder  holderNum = ");
      paramViewHolder.append(this.a.size());
      QLog.i("FSLayerScrollStatusManager", 1, paramViewHolder.toString());
    }
  }
  
  public void a(FSFeedSelectInfo paramFSFeedSelectInfo)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("fs_lifecycle onResumed  position = ");
    ((StringBuilder)localObject).append(paramFSFeedSelectInfo);
    QLog.i("FSLayerScrollStatusManager", 1, ((StringBuilder)localObject).toString());
    localObject = this.a.iterator();
    while (((Iterator)localObject).hasNext())
    {
      RecyclerView.ViewHolder localViewHolder = (RecyclerView.ViewHolder)((Iterator)localObject).next();
      if ((localViewHolder.itemView instanceof FSLayerFeedItemView)) {
        ((FSLayerFeedItemView)localViewHolder.itemView).a(paramFSFeedSelectInfo);
      }
    }
    localObject = this.b.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((FSLayerBaseScroller)((Iterator)localObject).next()).a(paramFSFeedSelectInfo);
    }
  }
  
  public void a(FSLayerBaseScroller paramFSLayerBaseScroller)
  {
    ArrayList localArrayList = this.b;
    if (localArrayList != null)
    {
      if (paramFSLayerBaseScroller == null) {
        return;
      }
      localArrayList.add(paramFSLayerBaseScroller);
    }
  }
  
  public void b(FSFeedSelectInfo paramFSFeedSelectInfo)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("fs_lifecycle onPaused  position = ");
    ((StringBuilder)localObject).append(paramFSFeedSelectInfo);
    QLog.i("FSLayerScrollStatusManager", 1, ((StringBuilder)localObject).toString());
    localObject = this.a.iterator();
    while (((Iterator)localObject).hasNext())
    {
      RecyclerView.ViewHolder localViewHolder = (RecyclerView.ViewHolder)((Iterator)localObject).next();
      if ((localViewHolder.itemView instanceof FSLayerFeedItemView)) {
        ((FSLayerFeedItemView)localViewHolder.itemView).b(paramFSFeedSelectInfo);
      }
    }
    localObject = this.b.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((FSLayerBaseScroller)((Iterator)localObject).next()).b(paramFSFeedSelectInfo);
    }
  }
  
  public void c(FSFeedSelectInfo paramFSFeedSelectInfo)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("fs_lifecycle onPaused  position = ");
    ((StringBuilder)localObject).append(paramFSFeedSelectInfo);
    QLog.i("FSLayerScrollStatusManager", 1, ((StringBuilder)localObject).toString());
    localObject = this.a.iterator();
    while (((Iterator)localObject).hasNext())
    {
      RecyclerView.ViewHolder localViewHolder = (RecyclerView.ViewHolder)((Iterator)localObject).next();
      if ((localViewHolder.itemView instanceof FSLayerFeedItemView)) {
        ((FSLayerFeedItemView)localViewHolder.itemView).c(paramFSFeedSelectInfo);
      }
    }
    localObject = this.b.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((FSLayerBaseScroller)((Iterator)localObject).next()).c(paramFSFeedSelectInfo);
    }
  }
  
  public void d(FSFeedSelectInfo paramFSFeedSelectInfo)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("fs_lifecycle onSelected  position = ");
    ((StringBuilder)localObject).append(paramFSFeedSelectInfo);
    QLog.i("FSLayerScrollStatusManager", 1, ((StringBuilder)localObject).toString());
    localObject = this.a;
    if ((localObject != null) && (this.b != null))
    {
      if (paramFSFeedSelectInfo == null) {
        return;
      }
      localObject = ((HashSet)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        RecyclerView.ViewHolder localViewHolder = (RecyclerView.ViewHolder)((Iterator)localObject).next();
        if (localViewHolder.getAdapterPosition() == paramFSFeedSelectInfo.b())
        {
          if ((localViewHolder.itemView instanceof FSLayerFeedItemView)) {
            ((FSLayerFeedItemView)localViewHolder.itemView).d(paramFSFeedSelectInfo);
          }
          Iterator localIterator = this.b.iterator();
          while (localIterator.hasNext()) {
            ((FSLayerBaseScroller)localIterator.next()).a(paramFSFeedSelectInfo, localViewHolder);
          }
        }
      }
    }
  }
  
  public void e(FSFeedSelectInfo paramFSFeedSelectInfo)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("fs_lifecycle onUnSelected  position = ");
    ((StringBuilder)localObject).append(paramFSFeedSelectInfo);
    QLog.i("FSLayerScrollStatusManager", 1, ((StringBuilder)localObject).toString());
    localObject = this.a;
    if ((localObject != null) && (this.b != null))
    {
      if (paramFSFeedSelectInfo == null) {
        return;
      }
      localObject = ((HashSet)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        RecyclerView.ViewHolder localViewHolder = (RecyclerView.ViewHolder)((Iterator)localObject).next();
        if (localViewHolder.getAdapterPosition() == paramFSFeedSelectInfo.b())
        {
          if ((localViewHolder.itemView instanceof FSLayerFeedItemView)) {
            ((FSLayerFeedItemView)localViewHolder.itemView).e(paramFSFeedSelectInfo);
          }
          Iterator localIterator = this.b.iterator();
          while (localIterator.hasNext()) {
            ((FSLayerBaseScroller)localIterator.next()).a(paramFSFeedSelectInfo, localViewHolder);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.manager.FSLayerScrollStatusManager
 * JD-Core Version:    0.7.0.1
 */