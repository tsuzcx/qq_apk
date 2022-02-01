package dov.com.qq.im.aeeditor.module.aifilter;

import android.content.Context;
import bnrh;
import bnwb;
import bnwh;
import com.tencent.tavcut.session.TAVCutVideoSession;
import com.tencent.tavcut.util.Logger;
import java.util.List;

public class MultiVideoAIFilterProxy$1
  implements Runnable
{
  public MultiVideoAIFilterProxy$1(bnwh parambnwh, List paramList, Context paramContext, bnwb parambnwb) {}
  
  public void run()
  {
    if (this.this$0.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession != null)
    {
      bnrh.a(bnwh.a(), "getVideoFrame start");
      this.this$0.jdField_a_of_type_JavaUtilList = this.this$0.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getMultiVideoFrame(this.jdField_a_of_type_JavaUtilList, 250);
      bnrh.a(bnwh.a(), "getVideoFrame end");
      Logger.i("Cover", "get covers num =" + this.this$0.jdField_a_of_type_JavaUtilList.size());
      this.this$0.jdField_a_of_type_Int = this.this$0.jdField_a_of_type_JavaUtilList.size();
      this.this$0.a(this.jdField_a_of_type_AndroidContentContext, this.this$0.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_Bnwb);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.aifilter.MultiVideoAIFilterProxy.1
 * JD-Core Version:    0.7.0.1
 */