package com.tencent.mobileqq.winkpublish.viewmodel;

import NS_MOBILE_OPERATION.LbsInfo;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.qcircleshadow.lib.QCircleHostLbsHelper;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.BasePartFragment;
import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.image.JpegExifReader;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.qcircle.api.event.QcircleLbsEvent;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.winkpublish.account.LoginData;
import com.tencent.mobileqq.winkpublish.api.IPublishLauncher;
import com.tencent.mobileqq.winkpublish.common.UploadConstants;
import com.tencent.mobileqq.winkpublish.model.DynamicArrayList;
import com.tencent.mobileqq.winkpublish.util.ExtendExifInterface;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.LbsDataV2;
import cooperation.qzone.LbsDataV2.GpsInfo;
import cooperation.qzone.LbsDataV2.PoiInfo;
import cooperation.qzone.LbsDataV2.PoiList;
import cooperation.qzone.model.GpsInfo4LocalImage;
import cooperation.qzone.model.LocalImageShootInfo;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class PublishPoiViewModel
  extends BaseViewModel
  implements SimpleEventReceiver
{
  public static final String a;
  public int b = 0;
  public MutableLiveData<List<LbsDataV2.PoiInfo>> c = new MutableLiveData();
  public MutableLiveData<LbsDataV2.PoiInfo> d = new MutableLiveData();
  public MutableLiveData<LbsDataV2.PoiInfo> e = new MutableLiveData();
  public List<LbsDataV2.PoiInfo> f = null;
  public List<LbsDataV2.PoiInfo> g = null;
  public LbsDataV2.PoiInfo h = null;
  public LocalImageShootInfo i;
  public ArrayList<LocalImageShootInfo> j;
  public int k = -1;
  public boolean l = false;
  public boolean m = false;
  private long n;
  private long o;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(UploadConstants.a);
    localStringBuilder.append("FSPoiViewModel");
    a = localStringBuilder.toString();
  }
  
  private ArrayList<LbsDataV2.PoiInfo> a(List<LbsDataV2.PoiInfo> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add((LbsDataV2.PoiInfo)paramList.next());
    }
    return localArrayList;
  }
  
  private void a(BasePartFragment paramBasePartFragment, Context paramContext)
  {
    Bundle localBundle = new Bundle();
    Object localObject2 = this.i;
    Object localObject3 = this.j;
    Object localObject1 = ((PublishViewModel)paramBasePartFragment.a(PublishViewModel.class)).g;
    b();
    if ((localObject2 != null) && (localObject1 != null) && (((DynamicArrayList)localObject1).contains(((LocalImageShootInfo)localObject2).path))) {
      localBundle.putParcelable("key_current_img_shoot_info", (Parcelable)localObject2);
    }
    if ((localObject3 != null) && (((ArrayList)localObject3).size() > 0)) {
      localBundle.putParcelableArrayList("key_current_image_shoot_infos", (ArrayList)localObject3);
    }
    localObject2 = this.f;
    if ((localObject2 != null) && (((List)localObject2).size() > 0)) {
      localBundle.putParcelableArrayList("key_current_poi_list_infos", a(this.f));
    }
    localObject2 = this.h;
    if (localObject2 != null)
    {
      localBundle.putParcelable("key_current_poi", (Parcelable)localObject2);
      this.b = 1;
    }
    localBundle.putBoolean("key_sync_weishi", false);
    localBundle.putBoolean("key_show_local_geo", false);
    localBundle.putInt("key_app_id", 100203);
    localBundle.putInt("key_lbs_state", this.b);
    localBundle.putBoolean("key_is_from_circle", true);
    localBundle.putBoolean("key_is_test_case", true);
    if ((((PublishViewModel)paramBasePartFragment.a(PublishViewModel.class)).h != null) && (localObject1 != null))
    {
      localObject1 = new ArrayList((Collection)localObject1);
      localObject2 = new ArrayList();
      int i1 = 0;
      while (i1 < ((ArrayList)localObject1).size())
      {
        localObject3 = (String)((ArrayList)localObject1).get(i1);
        localObject3 = (LocalMediaInfo)((PublishViewModel)paramBasePartFragment.a(PublishViewModel.class)).h.get(localObject3);
        if ((localObject3 != null) && (((LocalMediaInfo)localObject3).aiTextLabel != null))
        {
          int i2 = 0;
          while (i2 < ((LocalMediaInfo)localObject3).aiTextLabel.size())
          {
            String str = (String)((LocalMediaInfo)localObject3).aiTextLabel.get(i2);
            if (!((ArrayList)localObject2).contains(str)) {
              ((ArrayList)localObject2).add(str);
            }
            i2 += 1;
          }
        }
        i1 += 1;
      }
      localBundle.putStringArrayList("key_is_from_circle_for_aitextlabel", (ArrayList)localObject2);
    }
    ((IPublishLauncher)QRoute.api(IPublishLauncher.class)).forwardToMoodSelectLocation(paramContext, LoginData.a().c(), 1208, localBundle);
  }
  
  private void a(HashMap<String, LocalMediaInfo> paramHashMap)
  {
    this.k = -1;
    ArrayList localArrayList = new ArrayList();
    if ((paramHashMap != null) && (paramHashMap.size() > 0))
    {
      paramHashMap = paramHashMap.values().iterator();
      int i1 = 0;
      while (paramHashMap.hasNext())
      {
        LocalMediaInfo localLocalMediaInfo = (LocalMediaInfo)paramHashMap.next();
        int i2 = i1 + 1;
        if (localLocalMediaInfo == null) {
          i1 = i2;
        } else {
          i1 = i2;
        }
        try
        {
          if (JpegExifReader.isCrashJpeg(localLocalMediaInfo.path)) {
            continue;
          }
          i1 = i2;
          if (localLocalMediaInfo.mMimeType.contains("video")) {
            continue;
          }
          Object localObject = new ExtendExifInterface(localLocalMediaInfo.path);
          float[] arrayOfFloat = new float[2];
          if (((ExtendExifInterface)localObject).getLatLong(arrayOfFloat))
          {
            localObject = new LocalImageShootInfo();
            ((LocalImageShootInfo)localObject).captureTime = localLocalMediaInfo.addedDate;
            ((LocalImageShootInfo)localObject).modifyTime = localLocalMediaInfo.modifiedDate;
            GpsInfo4LocalImage localGpsInfo4LocalImage = new GpsInfo4LocalImage();
            localGpsInfo4LocalImage.latitude = arrayOfFloat[0];
            localGpsInfo4LocalImage.longtitude = arrayOfFloat[1];
            ((LocalImageShootInfo)localObject).gpsInfo = localGpsInfo4LocalImage;
            ((LocalImageShootInfo)localObject).path = localLocalMediaInfo.path;
            localArrayList.add(localObject);
            if (this.k == -1)
            {
              this.k = (i2 - 1);
              this.i = ((LocalImageShootInfo)localObject);
            }
            i1 = i2;
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d(a, 2, String.format("LocalImageShootInfo.latitude=%f, LocalImageShootInfo.longtitude=%f, LocalImageShootInfo.path=%s", new Object[] { Float.valueOf(arrayOfFloat[0]), Float.valueOf(arrayOfFloat[1]), localLocalMediaInfo.path }));
            i1 = i2;
            continue;
          }
          i1 = i2;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.e(a, 2, "exif.getLatLong==false");
          i1 = i2;
        }
        catch (Exception localException)
        {
          label311:
          break label311;
        }
        QLog.e(a, 1, "read pic exif error");
        i1 = i2;
      }
    }
    this.j = localArrayList;
  }
  
  private void f()
  {
    this.o = System.currentTimeMillis();
    ArrayList localArrayList = this.j;
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      localArrayList = new ArrayList();
      Iterator localIterator = this.j.iterator();
      while (localIterator.hasNext())
      {
        LocalImageShootInfo localLocalImageShootInfo = (LocalImageShootInfo)localIterator.next();
        if (localLocalImageShootInfo.gpsInfo != null) {
          localArrayList.add(localLocalImageShootInfo.gpsInfo);
        }
      }
      QLog.d(a, 2, "[fetchPOI] fetch Batch poi");
      QCircleHostLbsHelper.getBatchPoiFromServer(localArrayList, true);
      return;
    }
    QLog.d(a, 2, new Object[] { "[fetchPOI] fetch Batch poi no image poi hasRequestLocalPoi:", Boolean.valueOf(this.l) });
    QCircleHostLbsHelper.getBatchPoiFromServer(null, true);
  }
  
  public String a()
  {
    return a;
  }
  
  public void a(Intent paramIntent)
  {
    LbsDataV2.PoiInfo localPoiInfo = (LbsDataV2.PoiInfo)paramIntent.getExtras().getParcelable("key_select_poi");
    paramIntent.getExtras().getBoolean("key_has_shoot_info");
    if ((localPoiInfo != null) && (!localPoiInfo.poiId.equals("invalide_poi_id")))
    {
      this.h = localPoiInfo;
      this.d.postValue(this.h);
    }
  }
  
  public void a(BasePartFragment paramBasePartFragment)
  {
    a(paramBasePartFragment, paramBasePartFragment.getActivity());
  }
  
  public void a(HashMap<String, LocalMediaInfo> paramHashMap, boolean paramBoolean)
  {
    this.n = (QCircleConfigHelper.a("QZoneSetting", "LBSPOIListFrequency", Integer.valueOf(20)).intValue() * 1000L);
    if ((System.currentTimeMillis() - this.o > this.n) || (paramBoolean))
    {
      a(paramHashMap);
      f();
    }
  }
  
  public LbsDataV2.PoiInfo b()
  {
    Object localObject = this.h;
    if (localObject != null) {
      return localObject;
    }
    localObject = this.g;
    if ((localObject != null) && (((List)localObject).size() > 0)) {
      return (LbsDataV2.PoiInfo)this.g.get(0);
    }
    return null;
  }
  
  public LbsDataV2.GpsInfo c()
  {
    LbsDataV2.PoiInfo localPoiInfo = b();
    if (localPoiInfo != null) {
      return localPoiInfo.gpsInfo;
    }
    return null;
  }
  
  public Map<String, String> d()
  {
    HashMap localHashMap = new HashMap();
    if (b() != null)
    {
      Object localObject1 = LbsDataV2.parceToLbsInfo(b());
      String str = "";
      if (localObject1 != null)
      {
        localHashMap.put("geo_x", ((LbsInfo)localObject1).lbs_x);
        localHashMap.put("geo_y", ((LbsInfo)localObject1).lbs_y);
        localHashMap.put("geo_id", String.valueOf(((LbsInfo)localObject1).lbs_id));
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(((LbsInfo)localObject1).lbs_idnm);
        ((StringBuilder)localObject2).append("");
        localHashMap.put("geo_idname", ((StringBuilder)localObject2).toString());
        localHashMap.put("geo_name", ((LbsInfo)localObject1).lbs_nm);
      }
      Object localObject2 = this.i;
      localObject1 = str;
      if (localObject2 != null)
      {
        localObject1 = str;
        if (((LocalImageShootInfo)localObject2).captureTime > 0L)
        {
          localHashMap.put("capturetime", String.valueOf(this.i.captureTime));
          localObject1 = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss").format(new Date(this.i.captureTime));
        }
      }
      localHashMap.put("shoottime", localObject1);
      localHashMap.put("jump_type", "1");
      localHashMap.put("jump_id", b().dianPingId);
      localHashMap.put("targetShootIndex", String.valueOf(this.k));
    }
    return localHashMap;
  }
  
  public boolean e()
  {
    int i1 = QCircleConfigHelper.a("qqcircle", "qcircle_selected_poi_info", Integer.valueOf(0)).intValue();
    boolean bool;
    if (i1 == 1) {
      bool = true;
    } else {
      bool = false;
    }
    QLog.d(a, 1, new Object[] { "[isSelectedFirstPoiInfo] selectedPoiInfo: ", Integer.valueOf(i1), " | isSelectedFirstPoiInfo: ", Boolean.valueOf(bool) });
    return bool;
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QcircleLbsEvent.class);
    return localArrayList;
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof QcircleLbsEvent))
    {
      paramSimpleBaseEvent = (QcircleLbsEvent)paramSimpleBaseEvent;
      if (paramSimpleBaseEvent.mPoiList == null) {
        return;
      }
      this.f = paramSimpleBaseEvent.mPoiList.poiInfos;
      if (this.f == null)
      {
        QLog.w(a, 1, "[Lbs-onReceiveEvent] invalid poiInfos");
        return;
      }
      StringBuilder localStringBuilder;
      if ((this.h == null) && (!this.m))
      {
        int i1 = Math.min(QCircleConfigHelper.a("qqcircle", "qqcircle_publish_show_lbs_count", Integer.valueOf(5)).intValue(), this.f.size());
        if (i1 > 0)
        {
          paramSimpleBaseEvent = a;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("[Lbs-onReceiveEvent] show def poi count: ");
          localStringBuilder.append(i1);
          QLog.d(paramSimpleBaseEvent, 2, localStringBuilder.toString());
          this.g = this.f.subList(0, i1);
          this.c.postValue(this.g);
        }
        paramSimpleBaseEvent = this.f;
        if ((paramSimpleBaseEvent != null) && (!paramSimpleBaseEvent.isEmpty()))
        {
          QLog.d(a, 1, "[Lbs-onReceiveEvent] def selected first poi info.");
          this.e.postValue(this.f.get(0));
        }
      }
      else
      {
        paramSimpleBaseEvent = a;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("[Lbs-onReceiveEvent] mSelectPoiData is selected || hasOperate:");
        localStringBuilder.append(this.m);
        QLog.w(paramSimpleBaseEvent, 1, localStringBuilder.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.viewmodel.PublishPoiViewModel
 * JD-Core Version:    0.7.0.1
 */