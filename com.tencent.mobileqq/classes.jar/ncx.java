import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeListLoader;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeListLoader.OnMsgTabNodeListLoadListener;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class ncx
  implements Runnable
{
  public ncx(MsgTabNodeListLoader paramMsgTabNodeListLoader, ArrayList paramArrayList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3) {}
  
  public void run()
  {
    Iterator localIterator = this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeListLoader.c.iterator();
    while (localIterator.hasNext()) {
      ((MsgTabNodeListLoader.OnMsgTabNodeListLoadListener)localIterator.next()).a(this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_Boolean, this.b, this.c);
    }
    if ((QLog.isDevelopLevel()) && (this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeListLoader.c.isEmpty())) {
      QLog.d("Q.qqstory.msgTab.nodeList", 2, "mListeners is empty!");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ncx
 * JD-Core Version:    0.7.0.1
 */