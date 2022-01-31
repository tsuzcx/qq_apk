import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeListLoader;
import com.tencent.qphone.base.util.QLog;

class ncu
  implements Runnable
{
  ncu(nct paramnct) {}
  
  public void run()
  {
    boolean bool = this.a.a.a(true, true);
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.msgTab.nodeList", 2, "refresh msg node, change=" + bool);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ncu
 * JD-Core Version:    0.7.0.1
 */