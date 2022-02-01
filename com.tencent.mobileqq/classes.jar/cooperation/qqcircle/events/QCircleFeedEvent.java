package cooperation.qqcircle.events;

import android.text.TextUtils;
import com.tencent.biz.qcircleshadow.lib.QCircleHostGlobalInfo;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import cooperation.qqcircle.beans.QCircleFakeFeed;
import cooperation.qzone.LbsDataV2.PoiInfo;
import cooperation.qzone.model.LabelInfo;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StImage;
import feedcloud.FeedCloudMeta.StPoiInfoV2;
import feedcloud.FeedCloudMeta.StTagInfo;
import feedcloud.FeedCloudMeta.StUser;
import feedcloud.FeedCloudMeta.StVideo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import qqcircle.QQCircleFeedBase.StSimulateData;
import qqcircle.QQCircleFeedBase.StVideoBusiData;
import vvw;

public class QCircleFeedEvent
  extends SimpleBaseEvent
{
  public static final int STATE_COMPLETE = 2;
  public static final int STATE_COMPOSITE_SUCCESS = 5;
  public static final int STATE_CREATE = 1;
  public static final int STATE_DELETE = 3;
  public static final int STATE_DELETE_FEEDS_BY_UID = 6;
  public static final int STATE_INIT_FAKE_DATA = 4;
  public static final int TARGET_ALL_PAGE = -1;
  public List<byte[]> mFakeFeedDataList;
  public byte[] mSingleFakeFeed;
  public int mState;
  public String mTargetId;
  public int mTargetPage = -1;
  
  public QCircleFeedEvent(int paramInt)
  {
    this.mState = paramInt;
  }
  
  public QCircleFeedEvent(QCircleFakeFeed paramQCircleFakeFeed, int paramInt)
  {
    this.mState = paramInt;
    if (paramQCircleFakeFeed != null)
    {
      this.mTargetId = ("qcircle_fakeid_" + paramQCircleFakeFeed.getClientKey());
      this.mSingleFakeFeed = assembleFakeStFeed(paramQCircleFakeFeed, paramInt);
    }
  }
  
  public QCircleFeedEvent(String paramString, int paramInt)
  {
    this.mState = paramInt;
    if (paramString != null) {
      this.mTargetId = paramString;
    }
  }
  
  public QCircleFeedEvent(List<QCircleFakeFeed> paramList)
  {
    if (paramList == null) {}
    for (;;)
    {
      return;
      this.mState = 4;
      this.mFakeFeedDataList = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        QCircleFakeFeed localQCircleFakeFeed = (QCircleFakeFeed)paramList.next();
        this.mFakeFeedDataList.add(assembleFakeStFeed(localQCircleFakeFeed, 1));
      }
    }
  }
  
  private byte[] assembleFakeStFeed(QCircleFakeFeed paramQCircleFakeFeed, int paramInt)
  {
    FeedCloudMeta.StFeed localStFeed = new FeedCloudMeta.StFeed();
    Object localObject2 = localStFeed.id;
    if (paramInt == 2)
    {
      localObject1 = paramQCircleFakeFeed.getFeedId();
      ((PBStringField)localObject2).set((String)localObject1);
      localStFeed.title.set(vvw.a(paramQCircleFakeFeed.getTitle()));
      localStFeed.content.set(vvw.a(paramQCircleFakeFeed.getContent()));
      localStFeed.type.set(paramQCircleFakeFeed.getFeedType());
      localObject1 = localStFeed.createTime;
      if (paramQCircleFakeFeed.getCreateTime() != 0L) {
        break label246;
      }
    }
    label246:
    for (long l = System.currentTimeMillis() / 1000L;; l = paramQCircleFakeFeed.getCreateTime())
    {
      ((PBUInt64Field)localObject1).set(l);
      localStFeed.setHasFlag(true);
      if (paramQCircleFakeFeed.getLabelInfos() == null) {
        break label265;
      }
      localObject1 = new ArrayList();
      localObject2 = paramQCircleFakeFeed.getLabelInfos().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (LabelInfo)((Iterator)localObject2).next();
        localObject4 = new FeedCloudMeta.StTagInfo();
        ((FeedCloudMeta.StTagInfo)localObject4).tagName.set(vvw.a(((LabelInfo)localObject3).name));
        ((FeedCloudMeta.StTagInfo)localObject4).tagId.set(vvw.a(((LabelInfo)localObject3).id));
        ((ArrayList)localObject1).add(localObject4);
        ((FeedCloudMeta.StTagInfo)localObject4).setHasFlag(true);
      }
      localObject1 = "qcircle_fakeid_" + paramQCircleFakeFeed.getClientKey();
      break;
    }
    localStFeed.tagInfos.set((List)localObject1);
    label265:
    if (paramQCircleFakeFeed.getPoiInfo() != null)
    {
      localStFeed.poiInfo.address.set(vvw.a(paramQCircleFakeFeed.getPoiInfo().address));
      localStFeed.poiInfo.defaultName.set(vvw.a(paramQCircleFakeFeed.getPoiInfo().poiDefaultName));
      localStFeed.poiInfo.name.set(vvw.a(paramQCircleFakeFeed.getPoiInfo().poiName));
      localStFeed.poiInfo.setHasFlag(true);
    }
    localStFeed.poster.set(QCircleHostGlobalInfo.getCurrentUser());
    if (!TextUtils.isEmpty(QCircleHostGlobalInfo.getCurrentNickName())) {
      localStFeed.poster.nick.set(vvw.a(QCircleHostGlobalInfo.getCurrentNickName()));
    }
    localStFeed.cover.picUrl.set(vvw.a(paramQCircleFakeFeed.getCoverPath()));
    localStFeed.cover.setHasFlag(true);
    Object localObject1 = paramQCircleFakeFeed.getMaterialId();
    localObject2 = paramQCircleFakeFeed.getFilterId();
    Object localObject3 = paramQCircleFakeFeed.getSimulateName();
    Object localObject4 = paramQCircleFakeFeed.getSimulateSchema();
    ArrayList localArrayList1 = paramQCircleFakeFeed.getShowCircleTakeSame();
    switch (paramQCircleFakeFeed.getFeedType())
    {
    }
    for (;;)
    {
      return localStFeed.toByteArray();
      localStFeed.video.width.set(paramQCircleFakeFeed.getWidth());
      localStFeed.video.height.set(paramQCircleFakeFeed.getHeight());
      localStFeed.video.duration.set(paramQCircleFakeFeed.getDuration());
      localStFeed.video.playUrl.set(vvw.a(paramQCircleFakeFeed.getVideoPath()));
      if ((localArrayList1 != null) && (localArrayList1.size() == 1))
      {
        paramInt = 1;
        label549:
        if (!TextUtils.isEmpty((CharSequence)((ArrayList)localObject4).get(0)))
        {
          paramQCircleFakeFeed = new QQCircleFeedBase.StSimulateData();
          paramQCircleFakeFeed.material_id.set((String)((ArrayList)localObject1).get(0));
          paramQCircleFakeFeed.filter_id.set((String)((ArrayList)localObject2).get(0));
          paramQCircleFakeFeed.simulate_name.set((String)((ArrayList)localObject3).get(0));
          paramQCircleFakeFeed.simulate_schema.set((String)((ArrayList)localObject4).get(0));
          if (paramInt == 0) {
            break label724;
          }
          paramQCircleFakeFeed.is_show_button.set(((Integer)localArrayList1.get(0)).intValue());
        }
      }
      for (;;)
      {
        paramQCircleFakeFeed.setHasFlag(true);
        localObject1 = new QQCircleFeedBase.StVideoBusiData();
        ((QQCircleFeedBase.StVideoBusiData)localObject1).simulate_date.set(paramQCircleFakeFeed);
        localStFeed.video.busiData.set(ByteStringMicro.copyFrom(((QQCircleFeedBase.StVideoBusiData)localObject1).toByteArray()));
        ((QQCircleFeedBase.StVideoBusiData)localObject1).setHasFlag(true);
        localStFeed.video.setHasFlag(true);
        break;
        paramInt = 0;
        break label549;
        label724:
        paramQCircleFakeFeed.is_show_button.set(0);
      }
      localStFeed.cover.width.set(paramQCircleFakeFeed.getWidth());
      localStFeed.cover.height.set(paramQCircleFakeFeed.getHeight());
      ArrayList localArrayList2 = new ArrayList();
      if (paramQCircleFakeFeed.getImgLists() != null)
      {
        int i;
        label805:
        Object localObject5;
        FeedCloudMeta.StImage localStImage;
        if ((localArrayList1 != null) && (localArrayList1.size() == paramQCircleFakeFeed.getImgLists().size()))
        {
          paramInt = 1;
          i = 0;
          if (i >= paramQCircleFakeFeed.getImgLists().size()) {
            break label1069;
          }
          localObject5 = (String)paramQCircleFakeFeed.getImgLists().get(i);
          localStImage = new FeedCloudMeta.StImage();
          localStImage.picUrl.set((String)localObject5);
          localStImage.width.set(paramQCircleFakeFeed.getWidth());
          localStImage.height.set(paramQCircleFakeFeed.getHeight());
          if (!TextUtils.isEmpty((CharSequence)((ArrayList)localObject4).get(i)))
          {
            localObject5 = new QQCircleFeedBase.StSimulateData();
            ((QQCircleFeedBase.StSimulateData)localObject5).material_id.set((String)((ArrayList)localObject1).get(i));
            ((QQCircleFeedBase.StSimulateData)localObject5).filter_id.set((String)((ArrayList)localObject2).get(i));
            ((QQCircleFeedBase.StSimulateData)localObject5).simulate_name.set((String)((ArrayList)localObject3).get(i));
            ((QQCircleFeedBase.StSimulateData)localObject5).simulate_schema.set((String)((ArrayList)localObject4).get(i));
            if (paramInt == 0) {
              break label1057;
            }
            ((QQCircleFeedBase.StSimulateData)localObject5).is_show_button.set(((Integer)localArrayList1.get(i)).intValue());
          }
        }
        for (;;)
        {
          ((QQCircleFeedBase.StSimulateData)localObject5).setHasFlag(true);
          QQCircleFeedBase.StVideoBusiData localStVideoBusiData = new QQCircleFeedBase.StVideoBusiData();
          localStVideoBusiData.simulate_date.set((MessageMicro)localObject5);
          localStVideoBusiData.setHasFlag(true);
          localStImage.busiData.set(ByteStringMicro.copyFrom(localStVideoBusiData.toByteArray()));
          localArrayList2.add(localStImage);
          i += 1;
          break label805;
          paramInt = 0;
          break;
          label1057:
          ((QQCircleFeedBase.StSimulateData)localObject5).is_show_button.set(0);
        }
      }
      label1069:
      localStFeed.images.set(localArrayList2);
    }
  }
  
  public void setTargetPage(int paramInt)
  {
    this.mTargetPage = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqcircle.events.QCircleFeedEvent
 * JD-Core Version:    0.7.0.1
 */