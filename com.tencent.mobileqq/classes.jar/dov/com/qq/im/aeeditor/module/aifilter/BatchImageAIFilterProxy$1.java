package dov.com.qq.im.aeeditor.module.aifilter;

import android.content.Context;
import java.util.List;

class BatchImageAIFilterProxy$1
  implements Runnable
{
  BatchImageAIFilterProxy$1(BatchImageAIFilterProxy paramBatchImageAIFilterProxy, List paramList, Context paramContext, AIFilterProxyBase.AIFilterProxyCallback paramAIFilterProxyCallback) {}
  
  public void run()
  {
    this.this$0.b = AIFilterProxyBase.a(this.jdField_a_of_type_JavaUtilList, BatchImageAIFilterProxy.a(this.this$0));
    this.this$0.a(this.jdField_a_of_type_AndroidContentContext, this.this$0.b, this.jdField_a_of_type_DovComQqImAeeditorModuleAifilterAIFilterProxyBase$AIFilterProxyCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.aifilter.BatchImageAIFilterProxy.1
 * JD-Core Version:    0.7.0.1
 */