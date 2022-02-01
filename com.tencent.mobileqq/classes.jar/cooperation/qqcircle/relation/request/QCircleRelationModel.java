package cooperation.qqcircle.relation.request;

import android.text.TextUtils;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qcircle.api.requests.QCircleRelationGroupRequest;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.QCircleConfig;
import cooperation.qqcircle.relation.entitys.NewRelationInfo;
import feedcloud.FeedCloudCommon.StCommonExt;
import feedcloud.FeedCloudMeta.StRelationInfo;
import feedcloud.FeedCloudRead.RelationGroup;
import feedcloud.FeedCloudRead.StGetRelationGroupListRsp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class QCircleRelationModel
  implements VSDispatchObserver.onVSRspCallBack<FeedCloudRead.StGetRelationGroupListRsp>, IQCircleRelationModel
{
  private static final int MAX_LOAD_NEXT_COUNT = 50;
  private static final int RSP_EMPTY_ERROR_CODE = 1000009;
  private static final String RSP_EMPTY_ERROR_MSG = "load fail, callback rsp is null.";
  private static final String TAG = "RFL-QCircleRelationModel";
  private int mMaxLoadNextCount = QCircleConfig.getInstance().getConfigValue("qqcircle", "qqcircle_load_max_next_count", Integer.valueOf(50)).intValue();
  private int mNextLoadCount = 0;
  private IQCircleRelationModel.OnLoadAtRelationListener mOnLoadAtRelationListener;
  private int mRequestScene = 0;
  private final Map<String, List<NewRelationInfo>> mResults = new HashMap();
  private String mTraceId = "";
  private long mUpdateTimeInterval;
  
  private void assemblyAtRelationList(FeedCloudRead.RelationGroup paramRelationGroup)
  {
    if (paramRelationGroup == null)
    {
      QLog.d("RFL-QCircleRelationModel", 1, "[assemblyAtRelationList] group is null.");
      return;
    }
    String str = paramRelationGroup.name.get();
    if (TextUtils.isEmpty(str))
    {
      QLog.d("RFL-QCircleRelationModel", 1, "[assemblyAtRelationList] group name not is empty.");
      return;
    }
    int i = paramRelationGroup.groupFlag.get();
    Object localObject = convertNewRelationInfo(i, paramRelationGroup.relationInfo.get());
    if (localObject == null)
    {
      QLog.d("RFL-QCircleRelationModel", 1, "[assemblyAtRelationList] relation list not is null.");
      return;
    }
    paramRelationGroup = (List)this.mResults.get(str);
    if (paramRelationGroup == null)
    {
      paramRelationGroup = new ArrayList((Collection)localObject);
      this.mResults.put(str, paramRelationGroup);
    }
    else
    {
      paramRelationGroup.addAll((Collection)localObject);
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[assemblyAtRelationList] relation history list count: ");
    ((StringBuilder)localObject).append(paramRelationGroup.size());
    ((StringBuilder)localObject).append(" | groupName: ");
    ((StringBuilder)localObject).append(str);
    ((StringBuilder)localObject).append(" | groupFlag: ");
    ((StringBuilder)localObject).append(i);
    QLog.d("RFL-QCircleRelationModel", 1, ((StringBuilder)localObject).toString());
  }
  
  private List<NewRelationInfo> convertNewRelationInfo(int paramInt, List<FeedCloudMeta.StRelationInfo> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      FeedCloudMeta.StRelationInfo localStRelationInfo = (FeedCloudMeta.StRelationInfo)paramList.next();
      NewRelationInfo localNewRelationInfo = new NewRelationInfo();
      localNewRelationInfo.setRelationInfo(localStRelationInfo);
      localNewRelationInfo.setGroupFlag(paramInt);
      localArrayList.add(localNewRelationInfo);
    }
    return localArrayList;
  }
  
  private void handleRspResult(FeedCloudCommon.StCommonExt paramStCommonExt, List<FeedCloudRead.RelationGroup> paramList, long paramLong)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      if (this.mNextLoadCount >= this.mMaxLoadNextCount)
      {
        notifyLoadAtRelationFinish();
        paramStCommonExt = new StringBuilder();
        paramStCommonExt.append("[handleRspResult] load count out of the maximum range. traceId: ");
        paramStCommonExt.append(this.mTraceId);
        QLog.w("RFL-QCircleRelationModel", 1, paramStCommonExt.toString());
        return;
      }
      ArrayList localArrayList = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        FeedCloudRead.RelationGroup localRelationGroup = (FeedCloudRead.RelationGroup)paramList.next();
        assemblyAtRelationList(localRelationGroup);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[handleRspResult] group hasNext: ");
        localStringBuilder.append(localRelationGroup.hasNext.get());
        localStringBuilder.append(" | name: ");
        localStringBuilder.append(localRelationGroup.name.get());
        localStringBuilder.append(" | traceId: ");
        localStringBuilder.append(this.mTraceId);
        QLog.d("RFL-QCircleRelationModel", 1, localStringBuilder.toString());
        if (localRelationGroup.hasNext.get() == 1) {
          localArrayList.add(localRelationGroup);
        }
      }
      this.mNextLoadCount += 1;
      this.mUpdateTimeInterval = paramLong;
      loadNextPageData(paramStCommonExt, localArrayList);
      return;
    }
    paramStCommonExt = new StringBuilder();
    paramStCommonExt.append("[handleRspResult] current relation group list is empty. traceId: ");
    paramStCommonExt.append(this.mTraceId);
    QLog.w("RFL-QCircleRelationModel", 1, paramStCommonExt.toString());
  }
  
  private void loadNextPageData(FeedCloudCommon.StCommonExt paramStCommonExt, List<FeedCloudRead.RelationGroup> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      paramStCommonExt = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        FeedCloudRead.RelationGroup localRelationGroup = (FeedCloudRead.RelationGroup)paramList.next();
        HashMap localHashMap = new HashMap();
        localHashMap.put("gid", localRelationGroup.gid.get());
        localHashMap.put("attachInfo", localRelationGroup.attachInfo.get());
        paramStCommonExt.add(localHashMap);
      }
      paramList = new StringBuilder();
      paramList.append("[loadNextPageData] load next page, scene: ");
      paramList.append(this.mRequestScene);
      paramList.append(" | loadParams: ");
      paramList.append(paramStCommonExt);
      paramList.append(" | traceId: ");
      paramList.append(this.mTraceId);
      QLog.d("RFL-QCircleRelationModel", 1, paramList.toString());
      loadRelationData(this.mRequestScene, paramStCommonExt);
      return;
    }
    QLog.d("RFL-QCircleRelationModel", 1, "[loadNextPageData] load next data finish.");
    notifyLoadAtRelationFinish();
  }
  
  private void loadRelationData(int paramInt, List<Map<String, Object>> paramList)
  {
    this.mRequestScene = paramInt;
    sendDataRequest(paramInt, paramList);
  }
  
  private void notifyLoadAtRelationFail(long paramLong, String paramString)
  {
    IQCircleRelationModel.OnLoadAtRelationListener localOnLoadAtRelationListener = this.mOnLoadAtRelationListener;
    if (localOnLoadAtRelationListener == null)
    {
      QLog.w("RFL-QCircleRelationModel", 1, "[notifyLoadAtRelationFail] load at relation listener not is null.");
      return;
    }
    localOnLoadAtRelationListener.onLoadAtRelationFail(this.mRequestScene, paramLong, paramString);
  }
  
  private void notifyLoadAtRelationFinish()
  {
    Object localObject = this.mOnLoadAtRelationListener;
    if (localObject == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[notifyLoadAtRelationFinish] load at relation listener not is null. traceId: ");
      ((StringBuilder)localObject).append(this.mTraceId);
      QLog.w("RFL-QCircleRelationModel", 1, ((StringBuilder)localObject).toString());
      return;
    }
    ((IQCircleRelationModel.OnLoadAtRelationListener)localObject).onLoadAtRelationFinish(this.mRequestScene, this.mResults, this.mUpdateTimeInterval);
  }
  
  private void sendDataRequest(int paramInt, List<Map<String, Object>> paramList)
  {
    int i;
    if (paramList == null) {
      i = 0;
    } else {
      i = paramList.size();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[sendDataRequest] scene: ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" | param count: ");
    localStringBuilder.append(i);
    QLog.d("RFL-QCircleRelationModel", 1, localStringBuilder.toString());
    paramList = new QCircleRelationGroupRequest(paramInt, paramList);
    VSNetworkHelper.getInstance().sendRequest(paramList, this);
  }
  
  public void loadRelationData(int paramInt)
  {
    loadRelationData(paramInt, new ArrayList());
  }
  
  public void onReceive(BaseRequest paramBaseRequest, boolean paramBoolean, long paramLong, String paramString, FeedCloudRead.StGetRelationGroupListRsp paramStGetRelationGroupListRsp)
  {
    if (paramBaseRequest == null) {
      paramBaseRequest = "";
    } else {
      paramBaseRequest = paramBaseRequest.getTraceId();
    }
    this.mTraceId = paramBaseRequest;
    if ((paramBoolean) && (paramLong == 0L))
    {
      if (paramStGetRelationGroupListRsp == null)
      {
        notifyLoadAtRelationFail(1000009L, "load fail, callback rsp is null.");
        paramBaseRequest = new StringBuilder();
        paramBaseRequest.append("[onReceive] response result not is null | traceId: ");
        paramBaseRequest.append(this.mTraceId);
        QLog.w("RFL-QCircleRelationModel", 1, paramBaseRequest.toString());
        return;
      }
      handleRspResult(paramStGetRelationGroupListRsp.extInfo, paramStGetRelationGroupListRsp.groupList.get(), paramStGetRelationGroupListRsp.timeInterval.get());
      return;
    }
    notifyLoadAtRelationFail(paramLong, paramString);
    paramBaseRequest = new StringBuilder();
    paramBaseRequest.append("[onReceive] request fail, error code: ");
    paramBaseRequest.append(paramLong);
    paramBaseRequest.append(" | error msg: ");
    paramBaseRequest.append(paramString);
    paramBaseRequest.append(" | traceId: ");
    paramBaseRequest.append(this.mTraceId);
    QLog.w("RFL-QCircleRelationModel", 1, paramBaseRequest.toString());
  }
  
  public void setOnLoadAtRelationListener(IQCircleRelationModel.OnLoadAtRelationListener paramOnLoadAtRelationListener)
  {
    this.mOnLoadAtRelationListener = paramOnLoadAtRelationListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.qqcircle.relation.request.QCircleRelationModel
 * JD-Core Version:    0.7.0.1
 */