import com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.SerialStepExecutor;
import com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.SimpleStepExector.CompletedHandler;
import com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.Step;
import com.tencent.biz.qqstory.support.logging.SLog;
import java.util.concurrent.ConcurrentLinkedQueue;

public class nyd
  implements Runnable
{
  public nyd(SerialStepExecutor paramSerialStepExecutor) {}
  
  public void run()
  {
    if (SerialStepExecutor.a(this.a).size() == 0)
    {
      if (this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestSimpleStepExector$CompletedHandler != null) {
        this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestSimpleStepExector$CompletedHandler.a();
      }
      SerialStepExecutor.a(this.a, 2);
      this.a.d();
      return;
    }
    this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestStep = ((Step)SerialStepExecutor.a(this.a).poll());
    if (this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestStep == null)
    {
      if (this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestSimpleStepExector$CompletedHandler != null) {
        this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestSimpleStepExector$CompletedHandler.a();
      }
      SerialStepExecutor.a(this.a, 2);
      this.a.d();
      return;
    }
    this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestStep.b();
    SLog.b("Q.qqstory.home.SerialStepExecutor", "剩下step:" + SerialStepExecutor.a(this.a).size());
    this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestStep.a(this.a);
    this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestStep.a(this.a);
    if (this.a.jdField_a_of_type_JavaLangObject == null) {
      SLog.e("Q.qqstory.home.SerialStepExecutor", "step:" + this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestStep.a() + ",return null result");
    }
    this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestStep.a(this.a.jdField_a_of_type_JavaLangObject);
    this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestStep.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nyd
 * JD-Core Version:    0.7.0.1
 */