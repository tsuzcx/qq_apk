package dov.com.qq.im.aeeditor.module.aifilter;

import android.content.Context;
import bnrh;
import bnwb;
import bnwn;
import com.tencent.tavcut.session.TAVCutVideoSession;
import com.tencent.tavcut.util.Logger;
import java.util.List;

public class VideoAIFilterProxy$1
  implements Runnable
{
  public VideoAIFilterProxy$1(bnwn parambnwn, List paramList, Context paramContext, bnwb parambnwb) {}
  
  public void run()
  {
    if (this.this$0.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession != null)
    {
      bnrh.a(bnwn.b(), "getVideoFrame start");
      this.this$0.jdField_a_of_type_JavaUtilList = this.this$0.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getVideoFrame(this.jdField_a_of_type_JavaUtilList, 250);
      bnrh.a(bnwn.b(), "getVideoFrame end");
      Logger.i("Cover", "get covers num =" + this.this$0.jdField_a_of_type_JavaUtilList.size());
      this.this$0.jdField_a_of_type_Int = this.this$0.jdField_a_of_type_JavaUtilList.size();
      this.this$0.a(this.jdField_a_of_type_AndroidContentContext, this.this$0.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_Bnwb);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.aifilter.VideoAIFilterProxy.1
 * JD-Core Version:    0.7.0.1
 */