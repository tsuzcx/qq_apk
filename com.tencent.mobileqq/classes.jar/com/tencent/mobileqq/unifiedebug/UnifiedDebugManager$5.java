package com.tencent.mobileqq.unifiedebug;

import android.content.Context;
import com.tencent.qphone.base.util.QLog;
import java.util.Queue;

class UnifiedDebugManager$5
  implements Runnable
{
  UnifiedDebugManager$5(UnifiedDebugManager paramUnifiedDebugManager, long paramLong1, Context paramContext, String paramString1, int paramInt, long paramLong2, String paramString2) {}
  
  public void run()
  {
    synchronized (this.this$0.a)
    {
      Object localObject1 = (UnifiedDebugManager.Command)this.this$0.a.peek();
      if ((localObject1 != null) && (((UnifiedDebugManager.Command)localObject1).jdField_b_of_type_Long == this.jdField_a_of_type_Long))
      {
        this.this$0.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_b_of_type_Long, this.jdField_a_of_type_Long, this.jdField_b_of_type_JavaLangString);
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("start debug(retry): seq=");
          ((StringBuilder)localObject1).append(this.jdField_a_of_type_Long);
          QLog.d("UnifiedDebugManager", 2, ((StringBuilder)localObject1).toString());
        }
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.unifiedebug.UnifiedDebugManager.5
 * JD-Core Version:    0.7.0.1
 */