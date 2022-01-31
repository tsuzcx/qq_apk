import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeListLoader;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeListLoader.OnMsgTabNodeListLoadListener;
import com.tencent.biz.qqstory.network.handler.GetUserInfoHandler.UpdateUserInfoEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class nhz
  implements Runnable
{
  nhz(nhy paramnhy, GetUserInfoHandler.UpdateUserInfoEvent paramUpdateUserInfoEvent) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryNetworkHandlerGetUserInfoHandler$UpdateUserInfoEvent.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem != null) {
      this.jdField_a_of_type_Nhy.a.a(this.jdField_a_of_type_ComTencentBizQqstoryNetworkHandlerGetUserInfoHandler$UpdateUserInfoEvent.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem);
    }
    Object localObject2;
    if (this.jdField_a_of_type_ComTencentBizQqstoryNetworkHandlerGetUserInfoHandler$UpdateUserInfoEvent.jdField_a_of_type_JavaUtilList != null)
    {
      ??? = this.jdField_a_of_type_ComTencentBizQqstoryNetworkHandlerGetUserInfoHandler$UpdateUserInfoEvent.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)???).hasNext())
      {
        localObject2 = (QQUserUIItem)((Iterator)???).next();
        this.jdField_a_of_type_Nhy.a.a(this.jdField_a_of_type_ComTencentBizQqstoryNetworkHandlerGetUserInfoHandler$UpdateUserInfoEvent.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem);
      }
    }
    synchronized (this.jdField_a_of_type_Nhy.a.c)
    {
      localObject2 = this.jdField_a_of_type_Nhy.a.c.iterator();
      if (((Iterator)localObject2).hasNext()) {
        ((MsgTabNodeListLoader.OnMsgTabNodeListLoadListener)((Iterator)localObject2).next()).a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nhz
 * JD-Core Version:    0.7.0.1
 */