package com.tencent.mobileqq.richmedia;

import android.os.Bundle;
import axnh;
import axnn;
import bdif;

public class CompoundProcessor$1
  implements Runnable
{
  public CompoundProcessor$1(axnh paramaxnh) {}
  
  public void run()
  {
    axnn localaxnn = axnn.a();
    String str = this.this$0.a(this.this$0.jdField_b_of_type_JavaLangString);
    Bundle localBundle = new Bundle();
    localBundle.putString("vidoe_record_uniseq", this.this$0.a);
    localBundle.putString("full_video_path", str);
    localBundle.putInt("video_slices_total_time_length", this.this$0.jdField_b_of_type_Int);
    localaxnn.a(103, -1, localBundle);
    bdif.a(this.this$0.a, "clicompCompoundProcessor.compressSourceYUV", "path = " + str + ",totalTime = " + this.this$0.jdField_b_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.CompoundProcessor.1
 * JD-Core Version:    0.7.0.1
 */