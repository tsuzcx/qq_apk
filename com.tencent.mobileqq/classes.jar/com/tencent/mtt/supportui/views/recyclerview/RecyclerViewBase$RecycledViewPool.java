package com.tencent.mtt.supportui.views.recyclerview;

import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import java.util.ArrayList;

public class RecyclerViewBase$RecycledViewPool
{
  public int DEFAULT_MAX_SCRAP = 7;
  int mAttachCount = 0;
  protected SparseIntArray mMaxScrap = new SparseIntArray();
  public SparseArray<RecyclerViewBase.ViewHolderArrayList> mScrap = new SparseArray();
  
  void attach(RecyclerViewBase.Adapter paramAdapter)
  {
    this.mAttachCount += 1;
  }
  
  public void clear()
  {
    this.mScrap.clear();
  }
  
  void detach()
  {
    this.mAttachCount -= 1;
  }
  
  public String dump()
  {
    return "";
  }
  
  public RecyclerViewBase.ViewHolder getRecycledView(int paramInt, String paramString)
  {
    ArrayList localArrayList = (ArrayList)this.mScrap.get(paramInt);
    if ((localArrayList != null) && (!localArrayList.isEmpty()))
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("getRecycledView--> scrapHeap.size : ");
      ((StringBuilder)localObject1).append(localArrayList.size());
      Log.d("RecyclerViewBase", ((StringBuilder)localObject1).toString());
      Object localObject2 = (RecyclerViewBase.ViewHolder)localArrayList.get(localArrayList.size() - 1);
      localObject1 = localObject2;
      if (!TextUtils.isEmpty(paramString))
      {
        paramInt = 0;
        for (;;)
        {
          localObject1 = localObject2;
          if (paramInt >= localArrayList.size()) {
            break;
          }
          localObject1 = (RecyclerViewBase.ViewHolder)localArrayList.get(paramInt);
          if (TextUtils.equals(paramString, ((RecyclerViewBase.ViewHolder)localObject1).mHolderReuseKey))
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("getRecycledView-->reqReuseKey: ");
            ((StringBuilder)localObject2).append(paramString);
            ((StringBuilder)localObject2).append(",found key:");
            ((StringBuilder)localObject2).append(((RecyclerViewBase.ViewHolder)localObject1).mHolderReuseKey);
            Log.d("RecyclerViewBase", ((StringBuilder)localObject2).toString());
            break;
          }
          paramInt += 1;
        }
      }
      ((RecyclerViewBase.ViewHolder)localObject1).mHolderReuseKey = paramString;
      localArrayList.remove(localObject1);
      return localObject1;
    }
    return null;
  }
  
  public ArrayList<RecyclerViewBase.ViewHolder> getScrapHeapForType(int paramInt)
  {
    RecyclerViewBase.ViewHolderArrayList localViewHolderArrayList2 = (RecyclerViewBase.ViewHolderArrayList)this.mScrap.get(paramInt);
    RecyclerViewBase.ViewHolderArrayList localViewHolderArrayList1 = localViewHolderArrayList2;
    if (localViewHolderArrayList2 == null)
    {
      localViewHolderArrayList2 = new RecyclerViewBase.ViewHolderArrayList();
      this.mScrap.put(paramInt, localViewHolderArrayList2);
      localViewHolderArrayList1 = localViewHolderArrayList2;
      if (this.mMaxScrap.indexOfKey(paramInt) < 0)
      {
        this.mMaxScrap.put(paramInt, this.DEFAULT_MAX_SCRAP);
        localViewHolderArrayList1 = localViewHolderArrayList2;
      }
    }
    return localViewHolderArrayList1;
  }
  
  void onAdapterChanged(RecyclerViewBase.Adapter paramAdapter1, RecyclerViewBase.Adapter paramAdapter2)
  {
    if (this.mAttachCount == 1) {
      clear();
    }
  }
  
  public void putRecycledView(RecyclerViewBase.ViewHolder paramViewHolder, RecyclerViewBase.Adapter paramAdapter)
  {
    int i = paramViewHolder.getItemViewType();
    ArrayList localArrayList = getScrapHeapForType(i);
    if (this.mMaxScrap.get(i) <= localArrayList.size())
    {
      if (paramAdapter != null) {
        paramAdapter.onViewAbandon(paramViewHolder);
      }
      return;
    }
    paramViewHolder.mPosition = -2147483648;
    paramViewHolder.mOldPosition = -2147483648;
    paramViewHolder.mItemId = -1L;
    paramViewHolder.clearFlagsForSharedPool();
    localArrayList.add(paramViewHolder);
  }
  
  public void setMaxRecycledViews(int paramInt1, int paramInt2, RecyclerViewBase.Adapter paramAdapter)
  {
    this.mMaxScrap.put(paramInt1, paramInt2);
    ArrayList localArrayList = (ArrayList)this.mScrap.get(paramInt1);
    if (localArrayList != null) {
      while (localArrayList.size() > paramInt2)
      {
        RecyclerViewBase.ViewHolder localViewHolder = (RecyclerViewBase.ViewHolder)localArrayList.remove(localArrayList.size() - 1);
        if (paramAdapter != null) {
          paramAdapter.onViewAbandon(localViewHolder);
        }
      }
    }
  }
  
  @Deprecated
  public void setMaxScrapNum(int paramInt)
  {
    if (paramInt <= this.DEFAULT_MAX_SCRAP) {
      return;
    }
    this.DEFAULT_MAX_SCRAP = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.RecycledViewPool
 * JD-Core Version:    0.7.0.1
 */