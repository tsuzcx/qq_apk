import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeInfo;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeListLoader;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeListLoader.OnMsgTabNodeListLoadListener;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class nei
  implements Runnable
{
  public nei(MsgTabNodeListLoader paramMsgTabNodeListLoader, MsgTabNodeInfo paramMsgTabNodeInfo, boolean paramBoolean, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    Iterator localIterator = this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeListLoader.c.iterator();
    while (localIterator.hasNext()) {
      ((MsgTabNodeListLoader.OnMsgTabNodeListLoadListener)localIterator.next()).a(this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeInfo, this.jdField_a_of_type_Boolean, this.jdField_a_of_type_Int, this.b);
    }
    if ((QLog.isDevelopLevel()) && (this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeListLoader.c.isEmpty())) {
      QLog.d("Q.qqstory.msgTab.nodeList", 2, "mListeners is empty!");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nei
 * JD-Core Version:    0.7.0.1
 */