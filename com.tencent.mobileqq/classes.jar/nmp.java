import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeInfo;
import com.tencent.biz.qqstory.playmode.util.MsgTabVideoData;
import com.tencent.biz.qqstory.playmode.util.MsgTabVideoDataProvider;
import com.tencent.biz.qqstory.playmode.util.MsgTabVideoDataProvider.MsgTabVideoDataEvent;
import com.tencent.biz.qqstory.playmode.util.MsgTabVideoDataProvider.OnRequestVideoListListener;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class nmp
  implements Runnable
{
  public nmp(MsgTabVideoDataProvider paramMsgTabVideoDataProvider, MsgTabNodeInfo paramMsgTabNodeInfo1, MsgTabNodeInfo paramMsgTabNodeInfo2, int paramInt1, boolean paramBoolean1, List paramList, int paramInt2, boolean paramBoolean2) {}
  
  public void run()
  {
    MsgTabVideoDataProvider.MsgTabVideoDataEvent localMsgTabVideoDataEvent = new MsgTabVideoDataProvider.MsgTabVideoDataEvent();
    localMsgTabVideoDataEvent.jdField_b_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeInfo = this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeInfo;
    localMsgTabVideoDataEvent.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeInfo = this.jdField_b_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeInfo;
    localMsgTabVideoDataEvent.jdField_b_of_type_Int = this.jdField_a_of_type_Int;
    Object localObject;
    int i;
    if (!this.jdField_a_of_type_Boolean) {
      if (QLog.isColorLevel())
      {
        localObject = this.jdField_b_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeInfo.jdField_a_of_type_JavaLangString;
        if (this.jdField_a_of_type_JavaUtilList == null)
        {
          i = 0;
          QLog.d("Q.qqstory.msgTab.MsgTabVideoDataProvider", 2, new Object[] { "request video list not success. nodeId=", localObject, ", videolist size=", Integer.valueOf(i) });
        }
      }
      else
      {
        localMsgTabVideoDataEvent.c = this.jdField_b_of_type_Int;
        if (this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeUtilMsgTabVideoDataProvider.jdField_a_of_type_ComTencentBizQqstoryPlaymodeUtilMsgTabVideoDataProvider$OnRequestVideoListListener != null) {
          this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeUtilMsgTabVideoDataProvider.jdField_a_of_type_ComTencentBizQqstoryPlaymodeUtilMsgTabVideoDataProvider$OnRequestVideoListListener.b(localMsgTabVideoDataEvent);
        }
      }
    }
    label323:
    do
    {
      return;
      i = this.jdField_a_of_type_JavaUtilList.size();
      break;
      if (!this.jdField_b_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeUtilMsgTabVideoDataProvider.jdField_a_of_type_JavaUtilMap.put(this.jdField_b_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaUtilList);
        if (QLog.isColorLevel())
        {
          localObject = this.jdField_b_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeInfo.jdField_a_of_type_JavaLangString;
          if (this.jdField_a_of_type_JavaUtilList != null) {
            break label323;
          }
        }
      }
      for (i = 0;; i = this.jdField_a_of_type_JavaUtilList.size())
      {
        QLog.d("Q.qqstory.msgTab.MsgTabVideoDataProvider", 2, new Object[] { "add memory cache. nodeId=", localObject, ", videolist size=", Integer.valueOf(i) });
        localMsgTabVideoDataEvent.jdField_a_of_type_Boolean = true;
        if (this.jdField_a_of_type_JavaUtilList == null) {
          break label430;
        }
        localObject = this.jdField_a_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject).hasNext())
        {
          MsgTabVideoData localMsgTabVideoData = (MsgTabVideoData)((Iterator)localObject).next();
          localMsgTabVideoDataEvent.jdField_a_of_type_JavaUtilList.add(localMsgTabVideoData.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem);
          if ((!localMsgTabVideoData.jdField_b_of_type_Boolean) && (!localMsgTabVideoDataEvent.jdField_b_of_type_JavaUtilList.contains(localMsgTabVideoData.jdField_a_of_type_JavaLangString))) {
            localMsgTabVideoDataEvent.jdField_b_of_type_JavaUtilList.add(localMsgTabVideoData.jdField_a_of_type_JavaLangString);
          }
        }
      }
      localMsgTabVideoDataEvent.jdField_a_of_type_Int = MsgTabVideoDataProvider.a(this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_Int);
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.msgTab.MsgTabVideoDataProvider", 2, new Object[] { "findFirstPlayIndex=", Integer.valueOf(localMsgTabVideoDataEvent.jdField_a_of_type_Int), ", nodeId=", this.jdField_b_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeInfo.jdField_a_of_type_JavaLangString, ", currentNodeId=", this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeInfo.jdField_a_of_type_JavaLangString, ", requestType=", Integer.valueOf(this.jdField_a_of_type_Int) });
      }
    } while (this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeUtilMsgTabVideoDataProvider.jdField_a_of_type_ComTencentBizQqstoryPlaymodeUtilMsgTabVideoDataProvider$OnRequestVideoListListener == null);
    label430:
    this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeUtilMsgTabVideoDataProvider.jdField_a_of_type_ComTencentBizQqstoryPlaymodeUtilMsgTabVideoDataProvider$OnRequestVideoListListener.b(localMsgTabVideoDataEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nmp
 * JD-Core Version:    0.7.0.1
 */