package com.tencent.mobileqq.qqlive.prepare;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider.Factory;
import com.tencent.mobileqq.mvvm.BaseViewModel;
import com.tencent.mobileqq.qqlive.data.CoverInfo;
import com.tencent.mobileqq.qqlive.data.anchor.room.QQLiveAnchorRoomGameInfo;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataPrepare;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataRoomAttr;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataRoomInfo;
import java.util.List;

public class PrepareFragmentViewModel
  extends BaseViewModel<PrepareDataRepository>
{
  public static ViewModelProvider.Factory k = new PrepareFragmentViewModel.2();
  public QQLiveAnchorDataPrepare a = new QQLiveAnchorDataPrepare();
  public boolean b = false;
  public MutableLiveData<List<GameItem>> c = new MutableLiveData();
  public final MutableLiveData<CoverInfo> d = new MutableLiveData();
  public final MutableLiveData<String> e = new MutableLiveData();
  public final MutableLiveData<Integer> f = new MutableLiveData();
  public final MutableLiveData<Boolean> g = new MutableLiveData();
  public final MutableLiveData<GameItem> h = new MutableLiveData();
  public final MutableLiveData<LocationData> i = new MutableLiveData();
  public final MutableLiveData<ThirdPushRtmpData> j = new MutableLiveData();
  
  public PrepareFragmentViewModel(PrepareDataRepository paramPrepareDataRepository)
  {
    super(paramPrepareDataRepository);
    e();
    this.a.roomInfo = new QQLiveAnchorDataRoomInfo();
    this.a.roomAttr = new QQLiveAnchorDataRoomAttr();
  }
  
  private void e()
  {
    this.i.setValue(new LocationData());
    this.h.setValue(new GameItem());
    this.d.setValue(new CoverInfo());
    this.e.setValue("");
    this.f.setValue(Integer.valueOf(1));
    this.g.setValue(Boolean.valueOf(false));
    this.j.setValue(null);
  }
  
  public QQLiveAnchorDataPrepare a()
  {
    QQLiveAnchorDataRoomAttr localQQLiveAnchorDataRoomAttr = this.a.roomAttr;
    if (localQQLiveAnchorDataRoomAttr == null) {
      return this.a;
    }
    if (this.d.getValue() != null)
    {
      localQQLiveAnchorDataRoomAttr.poster = ((CoverInfo)this.d.getValue()).roomLogo;
      localQQLiveAnchorDataRoomAttr.poster3v4 = ((CoverInfo)this.d.getValue()).roomLogo3v4;
      localQQLiveAnchorDataRoomAttr.poster16v9 = ((CoverInfo)this.d.getValue()).roomLogo16v9;
      localQQLiveAnchorDataRoomAttr.posterTime = ((CoverInfo)this.d.getValue()).roomLogoTime;
      localQQLiveAnchorDataRoomAttr.posterTime3v4 = ((CoverInfo)this.d.getValue()).roomLogoTime3v4;
      localQQLiveAnchorDataRoomAttr.posterTime16v9 = ((CoverInfo)this.d.getValue()).roomLogoTime16v9;
    }
    if (this.i.getValue() != null)
    {
      localQQLiveAnchorDataRoomAttr.city = ((LocationData)this.i.getValue()).b;
      localQQLiveAnchorDataRoomAttr.locationAT = ((LocationData)this.i.getValue()).d;
      localQQLiveAnchorDataRoomAttr.locationNG = ((LocationData)this.i.getValue()).c;
    }
    QQLiveAnchorDataPrepare localQQLiveAnchorDataPrepare = this.a;
    localQQLiveAnchorDataPrepare.roomAttr = localQQLiveAnchorDataRoomAttr;
    return localQQLiveAnchorDataPrepare;
  }
  
  public QQLiveAnchorDataPrepare a(int paramInt)
  {
    this.a = a();
    if (this.a.roomAttr != null)
    {
      this.a.roomAttr.liveRoomType = paramInt;
      if ((paramInt == 1) && (this.h.getValue() != null))
      {
        QQLiveAnchorRoomGameInfo localQQLiveAnchorRoomGameInfo = new QQLiveAnchorRoomGameInfo();
        localQQLiveAnchorRoomGameInfo.id = ((GameItem)this.h.getValue()).a();
        localQQLiveAnchorRoomGameInfo.icon = ((GameItem)this.h.getValue()).c();
        localQQLiveAnchorRoomGameInfo.name = ((GameItem)this.h.getValue()).b();
        this.a.roomAttr.gameInfo = localQQLiveAnchorRoomGameInfo;
      }
      else
      {
        this.a.roomAttr.gameInfo = null;
      }
    }
    return this.a;
  }
  
  public void a(QQLiveAnchorDataPrepare paramQQLiveAnchorDataPrepare)
  {
    if (paramQQLiveAnchorDataPrepare != null)
    {
      if (paramQQLiveAnchorDataPrepare.roomAttr == null) {
        paramQQLiveAnchorDataPrepare.roomAttr = new QQLiveAnchorDataRoomAttr();
      }
      if (paramQQLiveAnchorDataPrepare.roomInfo == null) {
        paramQQLiveAnchorDataPrepare.roomInfo = new QQLiveAnchorDataRoomInfo();
      }
      this.a = paramQQLiveAnchorDataPrepare;
      Object localObject1 = new CoverInfo();
      if (paramQQLiveAnchorDataPrepare.roomAttr != null)
      {
        ((CoverInfo)localObject1).roomLogo = paramQQLiveAnchorDataPrepare.roomAttr.poster;
        ((CoverInfo)localObject1).roomLogo3v4 = paramQQLiveAnchorDataPrepare.roomAttr.poster3v4;
        ((CoverInfo)localObject1).roomLogo16v9 = paramQQLiveAnchorDataPrepare.roomAttr.poster16v9;
        ((CoverInfo)localObject1).roomLogoTime = paramQQLiveAnchorDataPrepare.roomAttr.posterTime;
        ((CoverInfo)localObject1).roomLogoTime3v4 = paramQQLiveAnchorDataPrepare.roomAttr.posterTime3v4;
        ((CoverInfo)localObject1).roomLogoTime16v9 = paramQQLiveAnchorDataPrepare.roomAttr.posterTime16v9;
        Object localObject2 = new GameItem();
        if (paramQQLiveAnchorDataPrepare.roomAttr.gameInfo != null)
        {
          ((GameItem)localObject2).a(paramQQLiveAnchorDataPrepare.roomAttr.gameInfo.id);
          ((GameItem)localObject2).a(paramQQLiveAnchorDataPrepare.roomAttr.gameInfo.name);
          ((GameItem)localObject2).b(paramQQLiveAnchorDataPrepare.roomAttr.gameInfo.icon);
          ((GameItem)localObject2).b(paramQQLiveAnchorDataPrepare.roomAttr.gameInfo.secondTagId);
        }
        this.h.setValue(localObject2);
        localObject2 = new LocationData();
        ((LocationData)localObject2).b = paramQQLiveAnchorDataPrepare.roomAttr.city;
        ((LocationData)localObject2).d = paramQQLiveAnchorDataPrepare.roomAttr.locationAT;
        ((LocationData)localObject2).c = paramQQLiveAnchorDataPrepare.roomAttr.locationNG;
        this.i.setValue(localObject2);
      }
      else
      {
        e();
      }
      this.d.setValue(localObject1);
      localObject1 = this.e;
      if (paramQQLiveAnchorDataPrepare.roomInfo != null) {
        paramQQLiveAnchorDataPrepare = paramQQLiveAnchorDataPrepare.roomInfo.name;
      } else {
        paramQQLiveAnchorDataPrepare = "";
      }
      ((MutableLiveData)localObject1).setValue(paramQQLiveAnchorDataPrepare);
      this.f.setValue(Integer.valueOf(1));
      this.g.setValue(Boolean.valueOf(((PrepareDataRepository)v()).c()));
      this.j.setValue(null);
      return;
    }
    e();
  }
  
  public void a(LocationData paramLocationData)
  {
    if (paramLocationData != null) {
      ((PrepareDataRepository)v()).a(paramLocationData);
    }
  }
  
  public void a(String paramString)
  {
    if (this.a.roomAttr != null) {
      this.a.roomAttr.roomName = paramString;
    }
    if (this.a.roomInfo != null) {
      this.a.roomInfo.name = paramString;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    ((PrepareDataRepository)this.z).a(new PrepareFragmentViewModel.1(this, paramBoolean));
  }
  
  protected void b()
  {
    if (((Integer)this.f.getValue()).intValue() == 1)
    {
      this.f.setValue(Integer.valueOf(2));
      return;
    }
    this.f.setValue(Integer.valueOf(1));
  }
  
  public boolean c()
  {
    boolean bool2 = this.b;
    boolean bool1 = true;
    if ((bool2) && (((Boolean)this.g.getValue()).booleanValue()))
    {
      if (((Integer)this.f.getValue()).intValue() == 1) {
        return bool1;
      }
      if ((((Integer)this.f.getValue()).intValue() == 2) && (this.j.getValue() != null) && (((ThirdPushRtmpData)this.j.getValue()).c)) {
        return true;
      }
    }
    bool1 = false;
    return bool1;
  }
  
  public LocationData d()
  {
    return ((PrepareDataRepository)v()).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.prepare.PrepareFragmentViewModel
 * JD-Core Version:    0.7.0.1
 */