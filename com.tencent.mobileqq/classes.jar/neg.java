import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeListLoader;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeListLoader.OnMsgTabNodeListLoadListener;
import java.util.ArrayList;
import java.util.Iterator;

public class neg
  implements Runnable
{
  public neg(MsgTabNodeListLoader paramMsgTabNodeListLoader, boolean paramBoolean) {}
  
  public void run()
  {
    Iterator localIterator = this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeListLoader.c.iterator();
    while (localIterator.hasNext()) {
      ((MsgTabNodeListLoader.OnMsgTabNodeListLoadListener)localIterator.next()).b(this.jdField_a_of_type_Boolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     neg
 * JD-Core Version:    0.7.0.1
 */