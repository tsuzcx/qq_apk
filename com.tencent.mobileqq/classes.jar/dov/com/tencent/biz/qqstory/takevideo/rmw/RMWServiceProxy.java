package dov.com.tencent.biz.qqstory.takevideo.rmw;

import android.os.Message;
import android.os.Messenger;
import annh;
import java.util.LinkedList;
import java.util.Queue;

public class RMWServiceProxy
{
  private int jdField_a_of_type_Int = 0;
  private final Messenger jdField_a_of_type_AndroidOsMessenger = new Messenger(new annh(this));
  private SimpleObservable jdField_a_of_type_DovComTencentBizQqstoryTakevideoRmwSimpleObservable = new SimpleObservable();
  private Queue jdField_a_of_type_JavaUtilQueue = new LinkedList();
  private int b = 5;
  
  public void a(Message paramMessage)
  {
    RMWLog.a("RMWServiceProxy", "client.handle : " + RMWProto.a(paramMessage));
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoRmwSimpleObservable.notifyObservers(new RMWEvent(paramMessage));
    paramMessage.recycle();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.rmw.RMWServiceProxy
 * JD-Core Version:    0.7.0.1
 */