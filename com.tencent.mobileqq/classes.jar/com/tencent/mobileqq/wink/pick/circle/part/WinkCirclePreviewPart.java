package com.tencent.mobileqq.wink.pick.circle.part;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.OnItemTouchListener;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.activity.photo.album.photolist.PhotoListBaseData;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.widget.NumberCheckBox;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wink.pick.AlbumUtil;
import com.tencent.mobileqq.wink.pick.album.data.WinkAlbumLogicData;
import com.tencent.mobileqq.wink.pick.circle.WinkCirclePhotoListLogic;
import com.tencent.mobileqq.wink.pick.circle.adapter.PhotoGridAdapter;
import com.tencent.mobileqq.wink.pick.circle.adapter.PhotoPreviewAdapter;
import com.tencent.mobileqq.wink.pick.circle.event.WinkCircleChangeBottomTabVisibleEvent;
import com.tencent.mobileqq.wink.pick.circle.event.WinkCircleClosePreviewLayerEvent;
import com.tencent.mobileqq.wink.pick.circle.event.WinkCircleSelectChangeEvent;
import com.tencent.mobileqq.wink.pick.circle.event.WinkCircleShowPhotoPreviewEvent;
import com.tencent.mobileqq.wink.pick.circle.part.base.WinkCircleBasePart;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.pull2refresh.PagerSnapHelper;
import com.tencent.widget.pull2refresh.PagerSnapHelper.PagerEventListener;
import com.tencent.widget.pull2refresh.RecyclerViewCompat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

public class WinkCirclePreviewPart
  extends WinkCircleBasePart
  implements View.OnClickListener, SimpleEventReceiver, PagerSnapHelper.PagerEventListener
{
  private RecyclerViewCompat a;
  private PhotoPreviewAdapter b;
  private LinearLayoutManager c;
  private NumberCheckBox f;
  private PagerSnapHelper g;
  private List<LocalMediaInfo> h = new ArrayList();
  private FrameLayout i;
  private FrameLayout j;
  private Button k;
  private float l;
  private int m;
  
  public WinkCirclePreviewPart(WinkCirclePhotoListLogic paramWinkCirclePhotoListLogic)
  {
    super(paramWinkCirclePhotoListLogic);
    this.d.a(this);
  }
  
  private boolean b(LocalMediaInfo paramLocalMediaInfo)
  {
    if (QAlbumUtil.getMediaType(paramLocalMediaInfo) == 1)
    {
      if (!this.d.g().canPickVideo)
      {
        QQToast.makeText(g(), HardCodeUtil.a(2131886371), 0).show();
        this.f.setChecked(false);
        return false;
      }
      if (!this.d.a(g(), paramLocalMediaInfo))
      {
        this.f.setChecked(false);
        return false;
      }
    }
    return true;
  }
  
  private RecyclerView.OnItemTouchListener i()
  {
    return new WinkCirclePreviewPart.1(this);
  }
  
  private void l()
  {
    this.i.setVisibility(8);
    SimpleEventBus.getInstance().dispatchEvent(new WinkCircleClosePreviewLayerEvent());
    SimpleEventBus.getInstance().dispatchEvent(new WinkCircleSelectChangeEvent());
  }
  
  private void m()
  {
    Object localObject1 = (LocalMediaInfo)this.h.get(this.c.findFirstVisibleItemPosition());
    if (((LocalMediaInfo)localObject1).selectStatus == 1) {
      return;
    }
    if (this.d.e().selectedPhotoList.size() + this.d.g().initialHasPickedNum >= this.d.e().maxSelectNum)
    {
      long l1 = System.currentTimeMillis();
      if (l1 - this.d.f().H >= 1000L)
      {
        QQToast.makeText(g(), a((LocalMediaInfo)localObject1), 0).show();
        this.f.setChecked(false);
        this.d.f().H = l1;
      }
      return;
    }
    if (!b((LocalMediaInfo)localObject1)) {
      return;
    }
    ((LocalMediaInfo)localObject1).selectStatus = 1;
    String str = ((LocalMediaInfo)localObject1).path;
    Object localObject2 = MimeHelper.getMimeType(((LocalMediaInfo)localObject1).mMimeType);
    if ((this.d.f().B) && (localObject2 != null) && ("video".equals(localObject2[0])))
    {
      localObject2 = this.d.f();
      ((PhotoListBaseData)localObject2).C += 1;
      if (this.d.f().C == 1) {
        this.d.f().E = ((LocalMediaInfo)localObject1);
      }
    }
    if ((!TextUtils.isEmpty(((LocalMediaInfo)localObject1).mMimeType)) && ("image/gif".equals(((LocalMediaInfo)localObject1).mMimeType)))
    {
      localObject2 = this.d.f();
      ((PhotoListBaseData)localObject2).D += 1;
    }
    this.d.e().selectedPhotoList.add(str);
    this.d.e().selectedIndex.add(((LocalMediaInfo)localObject1).position);
    this.d.e().selectedMediaInfoHashMap.put(str, localObject1);
    localObject2 = (LinkedHashMap)AlbumUtil.sSelectItemPosMap.get(this.d.e().albumId);
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new LinkedHashMap();
      AlbumUtil.sSelectItemPosMap.put(this.d.e().albumId, localObject1);
    }
    ((LinkedHashMap)localObject1).put(str, Integer.valueOf(this.c.findFirstVisibleItemPosition()));
    localObject1 = AlbumUtil.sSelectItemAlbum;
    if (!((HashMap)localObject1).containsKey(str)) {
      ((HashMap)localObject1).put(str, new Pair(this.d.e().albumId, this.d.e().albumName));
    }
    SimpleEventBus.getInstance().dispatchEvent(new WinkCircleSelectChangeEvent());
  }
  
  private void n()
  {
    LocalMediaInfo localLocalMediaInfo = (LocalMediaInfo)this.h.get(this.c.findFirstVisibleItemPosition());
    if (!PhotoGridAdapter.a(localLocalMediaInfo).booleanValue())
    {
      QQToast.makeText(g(), HardCodeUtil.a(2131914004), 0).show();
      this.f.setChecked(false);
      return;
    }
    if (!PhotoGridAdapter.b(localLocalMediaInfo).booleanValue())
    {
      QQToast.makeText(g(), HardCodeUtil.a(2131914005), 0).show();
      this.f.setChecked(false);
      return;
    }
    try
    {
      if (!PhotoGridAdapter.c(localLocalMediaInfo).booleanValue())
      {
        QQToast.makeText(g(), HardCodeUtil.a(2131914006), 0).show();
        this.f.setChecked(false);
        return;
      }
      int n = localLocalMediaInfo.selectStatus;
      if ((n != 1) && (this.d.e().selectedPhotoList.size() + this.d.g().initialHasPickedNum >= this.d.e().maxSelectNum))
      {
        long l1 = System.currentTimeMillis();
        if (l1 - this.d.f().H >= 1000L)
        {
          QQToast.makeText(g(), a(localLocalMediaInfo), 0).show();
          this.f.setChecked(false);
          this.d.f().H = l1;
        }
        return;
      }
      if (!b(localLocalMediaInfo)) {
        return;
      }
      if (n == 1) {
        n = 2;
      } else {
        n = 1;
      }
      localLocalMediaInfo.selectStatus = n;
      if (localLocalMediaInfo.selectStatus == 1) {
        n = 1;
      } else {
        n = 0;
      }
      String str = localLocalMediaInfo.path;
      Object localObject = MimeHelper.getMimeType(localLocalMediaInfo.mMimeType);
      if (n != 0)
      {
        if ((this.d.f().B) && (localObject != null) && ("video".equals(localObject[0])))
        {
          localObject = this.d.f();
          ((PhotoListBaseData)localObject).C += 1;
          if (this.d.f().C == 1) {
            this.d.f().E = localLocalMediaInfo;
          }
        }
        if ((!TextUtils.isEmpty(localLocalMediaInfo.mMimeType)) && ("image/gif".equals(localLocalMediaInfo.mMimeType)))
        {
          localObject = this.d.f();
          ((PhotoListBaseData)localObject).D += 1;
        }
        this.d.e().selectedPhotoList.add(str);
        this.d.e().selectedIndex.add(localLocalMediaInfo.position);
        this.d.e().selectedMediaInfoHashMap.put(str, localLocalMediaInfo);
        LinkedHashMap localLinkedHashMap = (LinkedHashMap)AlbumUtil.sSelectItemPosMap.get(this.d.e().albumId);
        localObject = localLinkedHashMap;
        if (localLinkedHashMap == null)
        {
          localObject = new LinkedHashMap();
          AlbumUtil.sSelectItemPosMap.put(this.d.e().albumId, localObject);
        }
        ((LinkedHashMap)localObject).put(str, Integer.valueOf(this.c.findFirstVisibleItemPosition()));
        localObject = AlbumUtil.sSelectItemAlbum;
        if (!((HashMap)localObject).containsKey(str)) {
          ((HashMap)localObject).put(str, new Pair(this.d.e().albumId, this.d.e().albumName));
        }
      }
      else
      {
        if ((this.d.f().B) && (localObject != null) && ("video".equals(localObject[0])))
        {
          localObject = this.d.f();
          ((PhotoListBaseData)localObject).C -= 1;
          if (this.d.f().C == 1) {
            this.d.f().E = localLocalMediaInfo;
          }
        }
        if ((!TextUtils.isEmpty(localLocalMediaInfo.mMimeType)) && ("image/gif".equals(localLocalMediaInfo.mMimeType)))
        {
          localObject = this.d.f();
          ((PhotoListBaseData)localObject).D -= 1;
        }
        this.d.e().selectedPhotoList.remove(str);
        this.d.e().selectedIndex.remove(localLocalMediaInfo.position);
        this.d.e().selectedMediaInfoHashMap.remove(str);
        localObject = (HashMap)AlbumUtil.sSelectItemPosMap.get(this.d.e().albumId);
        if (localObject != null) {
          ((HashMap)localObject).remove(str);
        }
        localObject = AlbumUtil.sSelectItemAlbum;
        if (((HashMap)localObject).containsKey(str)) {
          ((HashMap)localObject).remove(str);
        }
      }
      n = localLocalMediaInfo.selectStatus;
      if (n == 1) {
        this.f.setCheckedNumber(this.d.e().selectedPhotoList.indexOf(localLocalMediaInfo.path) + 1 + this.d.g().initialHasPickedNum);
      } else if (n == 3) {
        this.f.setChecked(false);
      } else {
        this.f.setChecked(false);
      }
      SimpleEventBus.getInstance().dispatchEvent(new WinkCircleSelectChangeEvent());
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public String a()
  {
    return "WinkCirclePreviewPart";
  }
  
  protected String a(LocalMediaInfo paramLocalMediaInfo)
  {
    int n = this.d.e().maxSelectNum;
    return g().getResources().getString(2131892559, new Object[] { Integer.valueOf(n) });
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder)
  {
    int n = paramViewHolder.getAdapterPosition();
    paramViewHolder = (LocalMediaInfo)this.h.get(n);
    if (paramViewHolder.selectStatus == 1) {
      this.f.setCheckedNumber(this.d.e().selectedPhotoList.indexOf(paramViewHolder.path) + 1 + this.d.g().initialHasPickedNum);
    } else {
      this.f.setChecked(false);
    }
    if (this.d != null) {
      this.d.i();
    }
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    this.a = ((RecyclerViewCompat)paramView.findViewById(2131440144));
    this.f = ((NumberCheckBox)paramView.findViewById(2131440183));
    this.i = ((FrameLayout)paramView.findViewById(2131440187));
    this.j = ((FrameLayout)paramView.findViewById(2131440182));
    this.k = ((Button)paramView.findViewById(2131440184));
    this.k.setOnClickListener(this);
    this.j.setOnClickListener(this);
    this.f.setOnClickListener(this);
    this.g = new PagerSnapHelper();
    this.g.a(this);
    this.b = new PhotoPreviewAdapter(g(), this.d);
    this.a.setAdapter(this.b);
    this.c = new LinearLayoutManager(g(), 0, false);
    this.a.setLayoutManager(this.c);
    this.g.a(this.a);
    this.a.addOnItemTouchListener(i());
  }
  
  public void a(List<LocalMediaInfo> paramList)
  {
    this.h.clear();
    this.h.addAll(paramList);
    paramList = this.h.iterator();
    int n = 0;
    while (paramList.hasNext())
    {
      LocalMediaInfo localLocalMediaInfo = (LocalMediaInfo)paramList.next();
      if ((QAlbumUtil.getMediaType(localLocalMediaInfo) != 2) && ((TextUtils.isEmpty(localLocalMediaInfo.mMimeType)) || (!"image/gif".equals(localLocalMediaInfo.mMimeType))))
      {
        n += 1;
      }
      else
      {
        paramList.remove();
        int i1 = this.m;
        if (i1 > n) {
          this.m = (i1 - 1);
        }
      }
    }
    paramList = this.b;
    if (paramList != null) {
      paramList.a(this.h);
    }
  }
  
  public boolean ah_()
  {
    if (this.i.getVisibility() == 0)
    {
      l();
      return true;
    }
    return false;
  }
  
  public void b(RecyclerView.ViewHolder paramViewHolder) {}
  
  public void d() {}
  
  public Boolean e()
  {
    FrameLayout localFrameLayout = this.i;
    boolean bool = false;
    if ((localFrameLayout != null) && (localFrameLayout.getVisibility() == 0)) {
      bool = true;
    }
    return Boolean.valueOf(bool);
  }
  
  public void f()
  {
    FrameLayout localFrameLayout = this.i;
    if (localFrameLayout != null) {
      localFrameLayout.setVisibility(8);
    }
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(WinkCircleShowPhotoPreviewEvent.class);
    return localArrayList;
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131440183)
    {
      n();
    }
    else if (paramView.getId() == 2131440184)
    {
      LocalMediaInfo localLocalMediaInfo = (LocalMediaInfo)this.h.get(this.c.findFirstVisibleItemPosition());
      if (!PhotoGridAdapter.a(localLocalMediaInfo).booleanValue())
      {
        QQToast.makeText(g(), HardCodeUtil.a(2131914004), 0).show();
      }
      else if (!PhotoGridAdapter.b(localLocalMediaInfo).booleanValue())
      {
        QQToast.makeText(g(), HardCodeUtil.a(2131914005), 0).show();
      }
      else if (!PhotoGridAdapter.c(localLocalMediaInfo).booleanValue())
      {
        QQToast.makeText(paramView.getContext(), HardCodeUtil.a(2131914006), 0).show();
      }
      else
      {
        if (this.d.e().selectedPhotoList.size() + this.d.g().initialHasPickedNum < 1) {
          m();
        }
        l();
      }
    }
    else if (paramView.getId() == 2131440182)
    {
      l();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof WinkCircleShowPhotoPreviewEvent))
    {
      paramSimpleBaseEvent = (WinkCircleShowPhotoPreviewEvent)paramSimpleBaseEvent;
      this.m = paramSimpleBaseEvent.mPosition;
      a(paramSimpleBaseEvent.mPhotoInfoList);
      if (this.m >= this.h.size()) {
        return;
      }
      this.a.scrollToPosition(this.m);
      this.i.setVisibility(0);
      SimpleEventBus.getInstance().dispatchEvent(new WinkCircleChangeBottomTabVisibleEvent(Boolean.valueOf(false)));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.pick.circle.part.WinkCirclePreviewPart
 * JD-Core Version:    0.7.0.1
 */