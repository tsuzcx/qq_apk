import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeInfo;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodePullVideoBasicInfoSegment;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeVideoInfo;
import com.tencent.biz.qqstory.msgTabNode.network.MsgTabNodeVidListRequest.MsgTabNodeVidListResponse;
import com.tencent.biz.qqstory.playmode.util.BatchGetVideoInfo.IBatchGetVideoInfoCallback;
import com.tencent.biz.qqstory.playmode.util.MsgTabVideoData;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.AssertUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class nii
  implements BatchGetVideoInfo.IBatchGetVideoInfoCallback
{
  public nii(MsgTabNodePullVideoBasicInfoSegment paramMsgTabNodePullVideoBasicInfoSegment, List paramList, MsgTabNodeVidListRequest.MsgTabNodeVidListResponse paramMsgTabNodeVidListResponse) {}
  
  public void a()
  {
    QLog.e("Q.qqstory.msgTab.jobPullBasicInfo", 1, "pull video info failed, info=" + this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeNetworkMsgTabNodeVidListRequest$MsgTabNodeVidListResponse.a);
    MsgTabNodePullVideoBasicInfoSegment.b(this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodePullVideoBasicInfoSegment, new ErrorMessage(102, "pull video info failed"));
  }
  
  public void a(ArrayList paramArrayList)
  {
    if (paramArrayList == null)
    {
      SLog.e("Q.qqstory.msgTab.jobPullBasicInfo", "video list empty !");
      MsgTabNodePullVideoBasicInfoSegment.a(this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodePullVideoBasicInfoSegment, new ErrorMessage(102, "video list empty !"));
      return;
    }
    if (this.jdField_a_of_type_JavaUtilList.size() == paramArrayList.size()) {}
    HashMap localHashMap;
    Object localObject1;
    for (boolean bool = true;; bool = false)
    {
      AssertUtils.a(bool);
      localHashMap = new HashMap();
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        localObject1 = (StoryVideoItem)paramArrayList.next();
        localHashMap.put(((StoryVideoItem)localObject1).mVid, localObject1);
      }
    }
    paramArrayList = new ArrayList();
    int j = this.jdField_a_of_type_JavaUtilList.size();
    int i = 0;
    while (i < j)
    {
      localObject1 = (MsgTabVideoData)this.jdField_a_of_type_JavaUtilList.get(i);
      Object localObject2 = (StoryVideoItem)localHashMap.get(((MsgTabVideoData)localObject1).b);
      if (localObject2 == null)
      {
        SLog.e("Q.qqstory.msgTab.jobPullBasicInfo", "not found video!");
        i += 1;
      }
      else
      {
        ((MsgTabVideoData)localObject1).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = ((StoryVideoItem)localObject2);
        localObject2 = MsgTabNodeVideoInfo.a(this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeNetworkMsgTabNodeVidListRequest$MsgTabNodeVidListResponse.a.jdField_a_of_type_JavaUtilList, ((StoryVideoItem)localObject2).mVideoIndex);
        if ((localObject2 == null) || (((MsgTabNodeVideoInfo)localObject2).jdField_a_of_type_Boolean)) {}
        for (bool = true;; bool = false)
        {
          ((MsgTabVideoData)localObject1).jdField_a_of_type_Boolean = bool;
          paramArrayList.add(localObject1);
          break;
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.msgTab.jobPullBasicInfo", 2, "pull video info succeed, info=" + this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeNetworkMsgTabNodeVidListRequest$MsgTabNodeVidListResponse.a);
    }
    MsgTabNodePullVideoBasicInfoSegment.a(this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodePullVideoBasicInfoSegment, paramArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nii
 * JD-Core Version:    0.7.0.1
 */