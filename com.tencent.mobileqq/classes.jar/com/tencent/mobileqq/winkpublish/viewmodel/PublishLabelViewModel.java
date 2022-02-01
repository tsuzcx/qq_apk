package com.tencent.mobileqq.winkpublish.viewmodel;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import circlesearch.CircleSearchExhibition.StExhTag;
import circlesearch.CircleSearchExhibition.StMoreDataReq;
import circlesearch.CircleSearchExhibition.StMoreDataRsp;
import com.tencent.biz.qcircleshadow.lib.QCircleHostConstants._QAlbumConstants;
import com.tencent.biz.qcircleshadow.lib.QCircleHostLbsHelper;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.image.JpegExifReader;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.winkpublish.common.UploadConstants;
import com.tencent.mobileqq.winkpublish.qcircle.request.FSGetAssociateTagRequest;
import com.tencent.mobileqq.winkpublish.qcircle.request.QCircleGetRecommendTagRequest;
import com.tencent.mobileqq.winkpublish.util.ExifUtil;
import com.tencent.mobileqq.winkpublish.util.ExtendExifInterface;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import cooperation.qqcircle.report.QCircleReportHelper;
import cooperation.qzone.LbsDataV2.GpsInfo;
import cooperation.qzone.model.LabelInfo;
import feedcloud.FeedCloudCommon.StCommonExt;
import feedcloud.FeedCloudMeta.StExifInfo;
import feedcloud.FeedCloudMeta.StGPSV2;
import feedcloud.FeedCloudMeta.StTagInfo;
import feedcloud.FeedCloudMeta.StTagMedalInfo;
import feedcloud.FeedCloudTagcategorysvr.PicRecomEntry;
import feedcloud.FeedCloudTagcategorysvr.StTagCategoryRecomRsp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class PublishLabelViewModel
  extends BaseViewModel
{
  public static final String a;
  public static final int b = QCircleConfigHelper.aI();
  public MutableLiveData<ArrayList<LabelInfo>> c = new MutableLiveData();
  public MutableLiveData<PublishLabelViewModel.UpdateLabelInfoOnChange> d = new MutableLiveData();
  public MutableLiveData<String> e = new MutableLiveData();
  public MutableLiveData<String> f = new MutableLiveData();
  public ArrayList<LabelInfo> g = new ArrayList();
  FeedCloudCommon.StCommonExt h;
  private ArrayList<FeedCloudMeta.StTagInfo> i;
  private ArrayList<String> j = new ArrayList();
  private boolean k = false;
  private String l = "";
  private String m;
  private MutableLiveData<UIStateData<List<FeedCloudMeta.StTagInfo>>> n = new MutableLiveData();
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(UploadConstants.a);
    localStringBuilder.append("FSLabelViewModel");
    a = localStringBuilder.toString();
  }
  
  private void a(BaseRequest paramBaseRequest, boolean paramBoolean1, boolean paramBoolean2, long paramLong, String paramString, CircleSearchExhibition.StMoreDataRsp paramStMoreDataRsp)
  {
    boolean bool = VSNetworkHelper.isProtocolCache(paramString);
    if ((paramBoolean2) && (paramLong == 0L) && (paramStMoreDataRsp != null))
    {
      this.h = paramStMoreDataRsp.ext_info;
      Object localObject = paramStMoreDataRsp.tags.get();
      paramString = new ArrayList();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        CircleSearchExhibition.StExhTag localStExhTag = (CircleSearchExhibition.StExhTag)((Iterator)localObject).next();
        if ((localStExhTag != null) && (localStExhTag.tag.get() != null)) {
          paramString.add(localStExhTag.tag.get());
        }
      }
      if ((paramBaseRequest instanceof FSGetAssociateTagRequest)) {
        paramBaseRequest = ((FSGetAssociateTagRequest)paramBaseRequest).getmReq().query.get();
      } else {
        paramBaseRequest = "";
      }
      if (paramString.size() > 0)
      {
        localObject = this.n;
        paramString = UIStateData.a(bool).a(paramBoolean1, paramString);
        int i1 = paramStMoreDataRsp.is_end.get();
        paramBoolean1 = true;
        if (i1 != 1) {
          paramBoolean1 = false;
        }
        ((MutableLiveData)localObject).setValue(paramString.c(paramBoolean1).b(paramBaseRequest));
        return;
      }
      this.n.setValue(UIStateData.a().b(paramBoolean1).b(paramBaseRequest));
      return;
    }
    this.n.setValue(UIStateData.a(paramString).b(paramBoolean1));
  }
  
  private void a(ArrayList<FeedCloudTagcategorysvr.PicRecomEntry> paramArrayList, FeedCloudMeta.StGPSV2 paramStGPSV2)
  {
    paramArrayList = new QCircleGetRecommendTagRequest(paramStGPSV2, paramArrayList);
    VSNetworkHelper.getInstance().sendRequest(paramArrayList, new PublishLabelViewModel.2(this));
  }
  
  private void a(boolean paramBoolean, long paramLong, String paramString, FeedCloudTagcategorysvr.StTagCategoryRecomRsp paramStTagCategoryRecomRsp)
  {
    if (paramBoolean) {}
    label512:
    label517:
    label526:
    label539:
    for (;;)
    {
      int i3;
      int i2;
      try
      {
        if (paramStTagCategoryRecomRsp.tagList != null)
        {
          if (this.i == null) {
            this.i = new ArrayList();
          }
          this.i.clear();
          this.i.addAll(paramStTagCategoryRecomRsp.tagList.get());
          i3 = paramStTagCategoryRecomRsp.tagList.size();
          paramString = new ArrayList();
          localObject1 = a;
          Object localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("hanldeCallbackForQcircleRecommendTag... rsp.tagList.size:");
          ((StringBuilder)localObject2).append(i3);
          QLog.d((String)localObject1, 1, ((StringBuilder)localObject2).toString());
          i2 = 0;
          i1 = 0;
          if (i1 < i3)
          {
            localObject1 = (FeedCloudMeta.StTagInfo)paramStTagCategoryRecomRsp.tagList.get(i1);
            if ((localObject1 == null) || (((FeedCloudMeta.StTagInfo)localObject1).tagId == null) || (((FeedCloudMeta.StTagInfo)localObject1).tagName == null)) {
              break label517;
            }
            localObject2 = new LabelInfo();
            ((LabelInfo)localObject2).id = ((FeedCloudMeta.StTagInfo)localObject1).tagId.get();
            ((LabelInfo)localObject2).name = ((FeedCloudMeta.StTagInfo)localObject1).tagName.get();
            ((LabelInfo)localObject2).rank = String.valueOf(((FeedCloudMeta.StTagInfo)localObject1).medal.rank.get());
            if (((FeedCloudMeta.StTagInfo)localObject1).isSelected.get() != 1) {
              break label512;
            }
            paramBoolean = true;
            ((LabelInfo)localObject2).hasSelected = paramBoolean;
            QLog.d(a, 1, new Object[] { "requestRecommendLabelCallback... i:", Integer.valueOf(i1), " labelInfo:", ((LabelInfo)localObject2).toString() });
            paramString.add(localObject2);
            break label517;
          }
          i1 = i2;
          if (!paramString.isEmpty())
          {
            i2 = 0;
            i1 = 0;
            if (i2 >= paramString.size()) {
              break label539;
            }
            i3 = i1;
            if (this.g.contains(paramString.get(i2))) {
              break label526;
            }
            i3 = i1;
            if (this.g.size() >= b) {
              break label526;
            }
            i3 = i1;
            if (this.j.contains(((LabelInfo)paramString.get(i2)).name)) {
              break label526;
            }
            this.g.add(0, paramString.get(i2));
            i3 = i1 + 1;
            break label526;
          }
          this.d.postValue(new PublishLabelViewModel.UpdateLabelInfoOnChange(this.g, i1));
          return;
        }
        QLog.w(a, 1, "hanldeCallbackForQcircleRecommendTag... rsp.taglist == null");
        return;
      }
      catch (Exception paramString)
      {
        QLog.e(a, 1, "parse response data failed!", paramString);
        return;
      }
      paramStTagCategoryRecomRsp = a;
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("get recommend tag failed. retCode=");
      ((StringBuilder)localObject1).append(paramLong);
      ((StringBuilder)localObject1).append(" errMsg=");
      ((StringBuilder)localObject1).append(paramString);
      QLog.e(paramStTagCategoryRecomRsp, 1, ((StringBuilder)localObject1).toString());
      return;
      paramBoolean = false;
      continue;
      i1 += 1;
      continue;
      i2 += 1;
      int i1 = i3;
    }
  }
  
  private ArrayList<FeedCloudTagcategorysvr.PicRecomEntry> b(HashMap<String, LocalMediaInfo> paramHashMap)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramHashMap != null) && (!paramHashMap.isEmpty()))
    {
      paramHashMap = paramHashMap.values().iterator();
      while (paramHashMap.hasNext())
      {
        Object localObject1 = (LocalMediaInfo)paramHashMap.next();
        FeedCloudTagcategorysvr.PicRecomEntry localPicRecomEntry = new FeedCloudTagcategorysvr.PicRecomEntry();
        Object localObject2 = a;
        Object localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("toPicRecomEntry... path:");
        ((StringBuilder)localObject3).append(((LocalMediaInfo)localObject1).path);
        ((StringBuilder)localObject3).append(" aiTextLabel:");
        ((StringBuilder)localObject3).append(((LocalMediaInfo)localObject1).aiTextLabel);
        QLog.d((String)localObject2, 1, ((StringBuilder)localObject3).toString());
        if (((LocalMediaInfo)localObject1).aiTextLabel != null) {
          localPicRecomEntry.recomTags.set(((LocalMediaInfo)localObject1).aiTextLabel);
        }
        if (!TextUtils.isEmpty(((LocalMediaInfo)localObject1).materialID)) {
          localPicRecomEntry.materialId.set(((LocalMediaInfo)localObject1).materialID);
        }
        try
        {
          if ((JpegExifReader.isCrashJpeg(((LocalMediaInfo)localObject1).path)) || (((LocalMediaInfo)localObject1).mMimeType == null) || (((LocalMediaInfo)localObject1).mMimeType.contains("video"))) {
            break label309;
          }
          localObject2 = ExifUtil.b(new ExtendExifInterface(((LocalMediaInfo)localObject1).path));
          localObject1 = new FeedCloudMeta.StExifInfo();
          if ((localObject2 == null) || (((HashMap)localObject2).size() <= 0)) {
            break label309;
          }
          localObject2 = ((HashMap)localObject2).entrySet().iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (Map.Entry)((Iterator)localObject2).next();
            ((FeedCloudMeta.StExifInfo)localObject1).kvs.add(QCircleReportHelper.newEntry((Map.Entry)localObject3));
          }
          localPicRecomEntry.exifInfo.set((MessageMicro)localObject1);
        }
        catch (Exception localException)
        {
          label299:
          break label299;
        }
        QLog.e(a, 1, "read pic exif error");
        label309:
        localArrayList.add(localPicRecomEntry);
      }
    }
    else
    {
      return localArrayList;
    }
  }
  
  private void b(Intent paramIntent)
  {
    if (this.k) {
      return;
    }
    Object localObject = (HashMap)paramIntent.getSerializableExtra(QCircleHostConstants._QAlbumConstants.SELECTED_MEDIA_INFO_HASH_MAP());
    if (localObject == null) {
      return;
    }
    paramIntent = new StringBuilder();
    localObject = ((HashMap)localObject).values().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Iterator localIterator = ((LocalMediaInfo)((Iterator)localObject).next()).mHashTagList.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if ((!TextUtils.isEmpty(str)) && (!this.j.contains(str)))
        {
          paramIntent.append("#");
          paramIntent.append(str);
          paramIntent.append(" ");
          b(str);
        }
      }
    }
    if (paramIntent.length() > 0)
    {
      this.f.postValue(this.l);
      this.l = paramIntent.toString();
      this.e.postValue(paramIntent.toString());
    }
  }
  
  private void b(String paramString)
  {
    if (!this.j.contains(paramString)) {
      this.j.add(paramString);
    }
  }
  
  private FeedCloudMeta.StGPSV2 f()
  {
    LbsDataV2.GpsInfo localGpsInfo = QCircleHostLbsHelper.getCurrGps("qqcircle");
    FeedCloudMeta.StGPSV2 localStGPSV2 = new FeedCloudMeta.StGPSV2();
    if (localGpsInfo != null)
    {
      localStGPSV2.alt.set(localGpsInfo.alt);
      localStGPSV2.lat.set(localGpsInfo.lat);
      localStGPSV2.lon.set(localGpsInfo.lon);
      localStGPSV2.eType.set(localGpsInfo.gpsType);
      String str = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getCurrentGps... gpsInfo.lon:");
      localStringBuilder.append(localGpsInfo.lon);
      localStringBuilder.append(" gpsInfo.lat:");
      localStringBuilder.append(localGpsInfo.lat);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    return localStGPSV2;
  }
  
  public String a()
  {
    return a;
  }
  
  public void a(int paramInt)
  {
    if (paramInt < this.g.size())
    {
      this.g.remove(paramInt);
      this.c.postValue(this.g);
    }
  }
  
  public void a(Activity paramActivity, Intent paramIntent)
  {
    b(paramIntent);
  }
  
  public void a(Intent paramIntent)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    String str = paramIntent.getStringExtra("key_qcircle_publish_default_tag_name");
    if ((!TextUtils.isEmpty(str)) && (!this.j.contains(str)))
    {
      localStringBuffer.append("#");
      localStringBuffer.append(str);
      localStringBuffer.append(" ");
      b(str);
      this.k = true;
    }
    paramIntent = (HashMap)paramIntent.getSerializableExtra("key_attrs");
    if ((paramIntent != null) && (paramIntent.containsKey("tag")))
    {
      paramIntent = ((String)paramIntent.get("tag")).split(";");
      int i1 = 0;
      while (i1 < paramIntent.length)
      {
        if ((!TextUtils.isEmpty(paramIntent[i1])) && (!this.j.contains(paramIntent[i1])))
        {
          localStringBuffer.append("#");
          localStringBuffer.append(paramIntent[i1]);
          localStringBuffer.append(" ");
          b(paramIntent[i1]);
          this.k = true;
        }
        i1 += 1;
      }
    }
    if (localStringBuffer.length() > 0) {
      this.e.postValue(localStringBuffer.toString());
    }
    QLog.d(a, 1, new Object[] { "initData... taglist:", localStringBuffer.toString() });
  }
  
  public void a(String paramString)
  {
    this.m = paramString;
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      this.m = paramString;
      this.h = null;
    }
    paramString = new FSGetAssociateTagRequest(this.h, this.m);
    VSNetworkHelper.getInstance().sendRequest(paramString, new PublishLabelViewModel.1(this, paramBoolean));
  }
  
  public void a(HashMap<String, LocalMediaInfo> paramHashMap)
  {
    a(b(paramHashMap), f());
  }
  
  public MutableLiveData<UIStateData<List<FeedCloudMeta.StTagInfo>>> b()
  {
    return this.n;
  }
  
  public String c()
  {
    return this.m;
  }
  
  public void d()
  {
    ArrayList localArrayList = this.i;
    if ((localArrayList != null) && (localArrayList.size() > 0)) {
      this.n.setValue(UIStateData.a(true).a(false, this.i).c(true));
    }
  }
  
  public void e()
  {
    ArrayList localArrayList = this.g;
    if (localArrayList != null) {
      localArrayList.clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.viewmodel.PublishLabelViewModel
 * JD-Core Version:    0.7.0.1
 */