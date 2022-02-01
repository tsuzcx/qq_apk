package com.tencent.mobileqq.richmedia;

import android.os.Bundle;
import com.tencent.mobileqq.utils.LogTag;

class CompoundProcessor$1
  implements Runnable
{
  CompoundProcessor$1(CompoundProcessor paramCompoundProcessor) {}
  
  public void run()
  {
    Object localObject2 = RichmediaClient.a();
    Object localObject1 = this.this$0;
    localObject1 = ((CompoundProcessor)localObject1).a(((CompoundProcessor)localObject1).jdField_b_of_type_JavaLangString);
    Object localObject3 = new Bundle();
    ((Bundle)localObject3).putString("vidoe_record_uniseq", this.this$0.a);
    ((Bundle)localObject3).putString("full_video_path", (String)localObject1);
    ((Bundle)localObject3).putInt("video_slices_total_time_length", this.this$0.jdField_b_of_type_Int);
    ((RichmediaClient)localObject2).a(103, -1, (Bundle)localObject3);
    localObject2 = this.this$0.a;
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("path = ");
    ((StringBuilder)localObject3).append((String)localObject1);
    ((StringBuilder)localObject3).append(",totalTime = ");
    ((StringBuilder)localObject3).append(this.this$0.jdField_b_of_type_Int);
    LogTag.a((String)localObject2, "clicompCompoundProcessor.compressSourceYUV", ((StringBuilder)localObject3).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.CompoundProcessor.1
 * JD-Core Version:    0.7.0.1
 */