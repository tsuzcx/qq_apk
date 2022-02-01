package cooperation.qqcircle.utils;

import android.text.TextUtils;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.VSBaseRequest;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.beans.Friend;
import feedcloud.FeedCloudCommon.Entry;
import feedcloud.FeedCloudCommon.StCommonExt;
import feedcloud.FeedCloudMeta.StRelationInfo;
import feedcloud.FeedCloudRead.StGetFollowListRsp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import qqcircle.QQCircleRelation.RelationBiz;
import vvv;

class QCircleDoubleFollowUserHepler$1
  implements VSDispatchObserver.onVSRspCallBack<FeedCloudRead.StGetFollowListRsp>
{
  QCircleDoubleFollowUserHepler$1(QCircleDoubleFollowUserHepler paramQCircleDoubleFollowUserHepler) {}
  
  public void onReceive(VSBaseRequest paramVSBaseRequest, boolean paramBoolean, long paramLong, String paramString, FeedCloudRead.StGetFollowListRsp paramStGetFollowListRsp)
  {
    long l = 0L;
    Object localObject;
    if (paramBoolean) {
      if (paramLong == 0L)
      {
        if (paramStGetFollowListRsp != null) {}
        for (;;)
        {
          try
          {
            paramVSBaseRequest = paramStGetFollowListRsp.relationInfo.get().iterator();
            if (!paramVSBaseRequest.hasNext()) {
              break;
            }
            localObject = (FeedCloudMeta.StRelationInfo)paramVSBaseRequest.next();
            paramString = new Friend();
            paramString.mUin = Long.parseLong(((FeedCloudMeta.StRelationInfo)localObject).id.get());
            if (((FeedCloudMeta.StRelationInfo)localObject).busiData.get() != null)
            {
              QQCircleRelation.RelationBiz localRelationBiz = new QQCircleRelation.RelationBiz();
              localRelationBiz.mergeFrom(((FeedCloudMeta.StRelationInfo)localObject).busiData.get().toByteArray());
              localObject = localRelationBiz.nick.get();
              if (TextUtils.isEmpty((CharSequence)localObject)) {
                paramString.mName = (paramString.mUin + "");
              }
            }
            else
            {
              QCircleDoubleFollowUserHepler.access$000(this.this$0).add(paramString);
              continue;
              return;
            }
          }
          catch (Exception paramVSBaseRequest)
          {
            QLog.e("QCircleDoubleFollowUserHepler", 1, paramVSBaseRequest, new Object[0]);
          }
          paramString.mName = ((String)localObject);
        }
        paramVSBaseRequest = paramStGetFollowListRsp.attachInfo.get();
        paramString = paramStGetFollowListRsp.extInfo.mapInfo.get().iterator();
        paramLong = l;
      }
    }
    for (;;)
    {
      if (paramString.hasNext())
      {
        localObject = (FeedCloudCommon.Entry)paramString.next();
        if ((localObject != null) && ("timestamp".equals(((FeedCloudCommon.Entry)localObject).key.get()))) {
          paramLong = Long.parseLong(((FeedCloudCommon.Entry)localObject).value.get());
        }
      }
      else
      {
        if (paramStGetFollowListRsp.hasNext.get() == 1)
        {
          QCircleDoubleFollowUserHepler.access$100(this.this$0, paramVSBaseRequest, paramLong);
          return;
        }
        QCircleDoubleFollowUserHepler.access$202(this.this$0, (List)QCircleDoubleFollowUserHepler.access$000(this.this$0).clone());
        this.this$0.updateFollowUserList(QCircleDoubleFollowUserHepler.access$200(this.this$0));
        vvv.a(System.currentTimeMillis());
        return;
        QLog.e("QCircleDoubleFollowUserHepler", 1, "doGetFollowUser fail: retCode:" + paramLong);
        return;
        QLog.e("QCircleDoubleFollowUserHepler", 1, "doGetFollowUser fail: stGetFollowListRsp is null");
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqcircle.utils.QCircleDoubleFollowUserHepler.1
 * JD-Core Version:    0.7.0.1
 */