package dov.com.qq.im.aeeditor.module.aifilter;

import android.content.Context;
import bljn;
import bllh;
import bllp;
import com.tencent.tavcut.session.TAVCutVideoSession;
import com.tencent.tavcut.util.Logger;
import java.util.List;

public class VideoAIFilterProxy$1
  implements Runnable
{
  public VideoAIFilterProxy$1(bllp parambllp, List paramList, Context paramContext, bllh parambllh) {}
  
  public void run()
  {
    if (bllp.a(this.this$0) != null)
    {
      bljn.a(bllp.a(), "getVideoFrame start");
      this.this$0.jdField_a_of_type_JavaUtilList = bllp.a(this.this$0).getVideoFrame(this.jdField_a_of_type_JavaUtilList, 250);
      bljn.a(bllp.a(), "getVideoFrame end");
      Logger.i("Cover", "get covers num =" + this.this$0.jdField_a_of_type_JavaUtilList.size());
      this.this$0.jdField_a_of_type_Int = this.this$0.jdField_a_of_type_JavaUtilList.size();
      this.this$0.a(this.jdField_a_of_type_AndroidContentContext, this.this$0.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_Bllh);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.aifilter.VideoAIFilterProxy.1
 * JD-Core Version:    0.7.0.1
 */