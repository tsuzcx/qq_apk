import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyWebRenderEngine;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyWebRenderStateMachineScheduler;
import com.tencent.qphone.base.util.QLog;

public class lmj
  implements Runnable
{
  public lmj(ReadInJoyWebRenderEngine paramReadInJoyWebRenderEngine) {}
  
  public void run()
  {
    long l = System.currentTimeMillis();
    this.a.jdField_a_of_type_Int = 2;
    this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyWebRenderStateMachineScheduler.a(null);
    if (QLog.isColorLevel()) {
      QLog.i("viola.ReadInJoyWebRenderEngine", 1, "native_render mCreateLoopScheduler schedule finish or fail all cost:" + (System.currentTimeMillis() - l) + "ms");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lmj
 * JD-Core Version:    0.7.0.1
 */