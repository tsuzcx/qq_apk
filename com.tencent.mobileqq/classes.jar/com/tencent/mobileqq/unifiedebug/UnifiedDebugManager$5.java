package com.tencent.mobileqq.unifiedebug;

import android.content.Context;
import bgcs;
import bgcx;
import com.tencent.qphone.base.util.QLog;
import java.util.Queue;

public class UnifiedDebugManager$5
  implements Runnable
{
  public UnifiedDebugManager$5(bgcs parambgcs, long paramLong1, Context paramContext, String paramString1, int paramInt, long paramLong2, String paramString2) {}
  
  public void run()
  {
    synchronized (this.this$0.a)
    {
      bgcx localbgcx = (bgcx)this.this$0.a.peek();
      if ((localbgcx != null) && (localbgcx.jdField_b_of_type_Long == this.jdField_a_of_type_Long))
      {
        this.this$0.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_b_of_type_Long, this.jdField_a_of_type_Long, this.jdField_b_of_type_JavaLangString);
        if (QLog.isColorLevel()) {
          QLog.d("UnifiedDebugManager", 2, "start debug(retry): seq=" + this.jdField_a_of_type_Long);
        }
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.unifiedebug.UnifiedDebugManager.5
 * JD-Core Version:    0.7.0.1
 */