package com.tencent.mobileqq.richmedia;

import android.os.Bundle;
import bbeb;
import bbeh;
import bhnn;

public class CompoundProcessor$1
  implements Runnable
{
  public CompoundProcessor$1(bbeb parambbeb) {}
  
  public void run()
  {
    bbeh localbbeh = bbeh.a();
    String str = this.this$0.a(this.this$0.jdField_b_of_type_JavaLangString);
    Bundle localBundle = new Bundle();
    localBundle.putString("vidoe_record_uniseq", this.this$0.a);
    localBundle.putString("full_video_path", str);
    localBundle.putInt("video_slices_total_time_length", this.this$0.jdField_b_of_type_Int);
    localbbeh.a(103, -1, localBundle);
    bhnn.a(this.this$0.a, "clicompCompoundProcessor.compressSourceYUV", "path = " + str + ",totalTime = " + this.this$0.jdField_b_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.CompoundProcessor.1
 * JD-Core Version:    0.7.0.1
 */