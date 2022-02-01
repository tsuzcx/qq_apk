package dov.com.qq.im.aeeditor.module.aifilter;

import android.content.Context;
import bmbx;
import bmgj;
import bmgp;
import com.tencent.tavcut.session.TAVCutVideoSession;
import com.tencent.tavcut.util.Logger;
import java.util.List;

public class MultiVideoAIFilterProxy$1
  implements Runnable
{
  public MultiVideoAIFilterProxy$1(bmgp parambmgp, List paramList, Context paramContext, bmgj parambmgj) {}
  
  public void run()
  {
    if (this.this$0.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession != null)
    {
      bmbx.a(bmgp.a(), "getVideoFrame start");
      this.this$0.jdField_a_of_type_JavaUtilList = this.this$0.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getMultiVideoFrame(this.jdField_a_of_type_JavaUtilList, 250);
      bmbx.a(bmgp.a(), "getVideoFrame end");
      Logger.i("Cover", "get covers num =" + this.this$0.jdField_a_of_type_JavaUtilList.size());
      this.this$0.jdField_a_of_type_Int = this.this$0.jdField_a_of_type_JavaUtilList.size();
      this.this$0.a(this.jdField_a_of_type_AndroidContentContext, this.this$0.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_Bmgj);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.aifilter.MultiVideoAIFilterProxy.1
 * JD-Core Version:    0.7.0.1
 */