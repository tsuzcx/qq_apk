package com.tencent.plato.sdk.render.adapter;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.plato.IPlatoRuntime;
import com.tencent.plato.core.utils.PLog;
import com.tencent.plato.sdk.render.IPView;
import com.tencent.plato.sdk.render.PDivView;
import com.tencent.plato.sdk.render.PListView.InternalListView;
import com.tencent.plato.sdk.render.PRect;
import com.tencent.plato.sdk.render.PScrollView.PVScrollView;
import com.tencent.plato.sdk.render.PView;
import com.tencent.plato.sdk.render.PViewFactory;
import com.tencent.plato.sdk.render.data.BlockElementData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ListBaseAdapter
  extends BaseAdapter
{
  private int TOUCH_INTERVAL = 15;
  ArrayList<ItemElementData> allDatas = new ArrayList();
  ArrayList<Integer> hashDatas = new ArrayList();
  private int lastTouchPosX = 0;
  private int lastTouchPosY = 0;
  ItemEventCallback mCallback;
  IPlatoRuntime mRuntime;
  
  public ListBaseAdapter(IPlatoRuntime paramIPlatoRuntime, ItemEventCallback paramItemEventCallback)
  {
    this.mRuntime = paramIPlatoRuntime;
    this.mCallback = paramItemEventCallback;
  }
  
  private void paresItemType()
  {
    Iterator localIterator = this.allDatas.iterator();
    while (localIterator.hasNext())
    {
      ItemElementData localItemElementData = (ItemElementData)localIterator.next();
      if (localItemElementData != null)
      {
        int i = localItemElementData.itemType;
        if (!this.hashDatas.contains(Integer.valueOf(i))) {
          this.hashDatas.add(Integer.valueOf(i));
        }
      }
    }
  }
  
  private PView paresView(IPlatoRuntime paramIPlatoRuntime, BlockElementData paramBlockElementData)
  {
    if (paramBlockElementData != null)
    {
      PDivView localPDivView = new PDivView();
      localPDivView.init(paramIPlatoRuntime, null, null);
      localPDivView.addChild(PViewFactory.createView(paramIPlatoRuntime, paramBlockElementData), -1);
      localPDivView.getView().setTag(localPDivView);
      return localPDivView;
    }
    return null;
  }
  
  private void setChildData(final BlockElementData paramBlockElementData, final IPView paramIPView)
  {
    LinkedList localLinkedList1 = new LinkedList();
    LinkedList localLinkedList2 = new LinkedList();
    localLinkedList1.offer(paramBlockElementData);
    localLinkedList2.offer(paramIPView);
    while ((!localLinkedList1.isEmpty()) && (!localLinkedList2.isEmpty()))
    {
      paramBlockElementData = (BlockElementData)localLinkedList1.poll();
      paramIPView = (IPView)localLinkedList2.poll();
      if ((paramBlockElementData.getEvents() != null) && (paramBlockElementData.getEvents().contains("click"))) {
        paramIPView.getView().setOnClickListener(new View.OnClickListener()
        {
          public void onClick(View paramAnonymousView)
          {
            if (ListBaseAdapter.this.mCallback != null)
            {
              int[] arrayOfInt = new int[2];
              paramAnonymousView.getLocationOnScreen(arrayOfInt);
              ListBaseAdapter.this.mCallback.click(paramBlockElementData.getElementId(), "click", PView.getClickInfo(arrayOfInt[0], arrayOfInt[1], paramBlockElementData.getElementId(), paramAnonymousView.getWidth(), paramAnonymousView.getHeight()));
            }
          }
        });
      }
      if ((paramBlockElementData.getEvents() != null) && ((paramBlockElementData.getEvents().contains("touchstart")) || (paramBlockElementData.getEvents().contains("touchend")) || (paramBlockElementData.getEvents().contains("touchmove")) || (paramBlockElementData.getEvents().contains("touchcancel")))) {
        paramIPView.getView().setOnTouchListener(new View.OnTouchListener()
        {
          public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
          {
            switch (paramAnonymousMotionEvent.getActionMasked())
            {
            }
            while ((paramIPView.getView() instanceof PScrollView.PVScrollView))
            {
              return false;
              PLog.e("MotionEvent", "ACTION_DOWN id:" + paramBlockElementData.getElementId());
              if (paramBlockElementData.getEvents().contains("touchstart"))
              {
                ListBaseAdapter.access$202(ListBaseAdapter.this, (int)paramAnonymousMotionEvent.getRawX());
                ListBaseAdapter.access$302(ListBaseAdapter.this, (int)paramAnonymousMotionEvent.getRawY());
                if (ListBaseAdapter.this.mCallback != null)
                {
                  ListBaseAdapter.this.mCallback.click(paramBlockElementData.getElementId(), "touchstart", PView.getTouchMotionInfo(paramAnonymousMotionEvent, paramBlockElementData.getElementId(), paramAnonymousView.getWidth(), paramAnonymousView.getHeight()));
                  continue;
                  PLog.e("MotionEvent", "ACTION_MOVE id:" + paramBlockElementData.getElementId());
                  if ((paramBlockElementData.getEvents().contains("touchmove")) && (ListBaseAdapter.this.mCallback != null))
                  {
                    ListBaseAdapter.this.mCallback.click(paramBlockElementData.getElementId(), "touchmove", PView.getTouchMotionInfo(paramAnonymousMotionEvent, paramBlockElementData.getElementId(), paramAnonymousView.getWidth(), paramAnonymousView.getHeight()));
                    continue;
                    PLog.e("MotionEvent", "ACTION_UP id:" + paramBlockElementData.getElementId());
                    if (paramBlockElementData.getEvents().contains("touchend"))
                    {
                      if (ListBaseAdapter.this.mCallback != null) {
                        ListBaseAdapter.this.mCallback.click(paramBlockElementData.getElementId(), "touchend", PView.getTouchMotionInfo(paramAnonymousMotionEvent, paramBlockElementData.getElementId(), paramAnonymousView.getWidth(), paramAnonymousView.getHeight()));
                      }
                      int j = (int)paramAnonymousMotionEvent.getRawX();
                      int i = (int)paramAnonymousMotionEvent.getRawY();
                      j = Math.abs(ListBaseAdapter.this.lastTouchPosX - j);
                      i = Math.abs(ListBaseAdapter.this.lastTouchPosY - i);
                      double d = Math.sqrt(j * j + i * i);
                      PLog.e("MotionEvent", "ACTION_UP distance:" + d);
                      if (d < ListBaseAdapter.this.TOUCH_INTERVAL)
                      {
                        paramIPView.getView().performClick();
                        continue;
                        PLog.e("MotionEvent", "ACTION_CANCEL id:" + paramBlockElementData.getElementId());
                        if (paramBlockElementData.getEvents().contains("touchcancel"))
                        {
                          if (ListBaseAdapter.this.mCallback != null) {
                            ListBaseAdapter.this.mCallback.click(paramBlockElementData.getElementId(), "touchcancel", PView.getTouchMotionInfo(paramAnonymousMotionEvent, paramBlockElementData.getElementId(), paramAnonymousView.getWidth(), paramAnonymousView.getHeight()));
                          }
                          j = (int)paramAnonymousMotionEvent.getRawX();
                          i = (int)paramAnonymousMotionEvent.getRawY();
                          j = Math.abs(ListBaseAdapter.this.lastTouchPosX - j);
                          i = Math.abs(ListBaseAdapter.this.lastTouchPosY - i);
                          d = Math.sqrt(j * j + i * i);
                          PLog.e("MotionEvent", "ACTION_CANCEL distance:" + d);
                          if (d < ListBaseAdapter.this.TOUCH_INTERVAL) {
                            paramIPView.getView().performClick();
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
            return true;
          }
        });
      }
      paramIPView.updateRect(paramBlockElementData.rc.left, paramBlockElementData.rc.top, paramBlockElementData.rc.width, paramBlockElementData.rc.height);
      paramIPView.setStyles(paramBlockElementData.getUIStyles());
      if ((paramBlockElementData.mChildren != null) && (paramBlockElementData.mChildren.size() > 0))
      {
        int i = 0;
        while (i < paramBlockElementData.mChildren.size())
        {
          localLinkedList1.offer(paramBlockElementData.mChildren.get(i));
          localLinkedList2.offer(paramIPView.getChild(i));
          i += 1;
        }
      }
    }
  }
  
  private void setHolderData(ListBaseHolder paramListBaseHolder, int paramInt)
  {
    ItemElementData localItemElementData = (ItemElementData)getItem(paramInt);
    if (localItemElementData == null) {}
    while ((localItemElementData.blockData == null) || (!localItemElementData.blockData.getElementType().equals("item"))) {
      return;
    }
    setChildData(localItemElementData.blockData, paramListBaseHolder.container.getChild(0));
  }
  
  public int getCount()
  {
    if (this.allDatas != null) {
      return this.allDatas.size();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    if ((this.allDatas == null) || (paramInt < 0) || (paramInt >= this.allDatas.size())) {
      return null;
    }
    return (ItemElementData)this.allDatas.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (this.allDatas == null) {
      return super.getItemViewType(paramInt);
    }
    return ((ItemElementData)this.allDatas.get(paramInt)).itemType;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = getItemViewType(paramInt);
    ListBaseHolder localListBaseHolder;
    if ((paramView == null) || (((ListBaseHolder)paramView.getTag()).viewType != i))
    {
      paramView = paresView(this.mRuntime, ((ItemElementData)this.allDatas.get(paramInt)).blockData).getView();
      localListBaseHolder = new ListBaseHolder();
      ListBaseHolder.access$102(localListBaseHolder, (PView)paramView.getTag());
      ListBaseHolder.access$002(localListBaseHolder, i);
      paramView.setTag(localListBaseHolder);
    }
    while ((paramView != null) && ((paramViewGroup instanceof PListView.InternalListView)) && (((PListView.InternalListView)paramViewGroup).getMeasureState()))
    {
      return paramView;
      localListBaseHolder = (ListBaseHolder)paramView.getTag();
    }
    setHolderData(localListBaseHolder, paramInt);
    return paramView;
  }
  
  public int getViewTypeCount()
  {
    if (this.hashDatas.size() > 0) {
      return this.hashDatas.size();
    }
    return 1;
  }
  
  public void setData(ArrayList<ItemElementData> paramArrayList)
  {
    if (this.allDatas != null) {
      this.allDatas.clear();
    }
    this.allDatas.addAll(paramArrayList);
    paresItemType();
    notifyDataSetChanged();
  }
  
  class ListBaseHolder
  {
    private PView container;
    private int viewType;
    
    ListBaseHolder() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.plato.sdk.render.adapter.ListBaseAdapter
 * JD-Core Version:    0.7.0.1
 */