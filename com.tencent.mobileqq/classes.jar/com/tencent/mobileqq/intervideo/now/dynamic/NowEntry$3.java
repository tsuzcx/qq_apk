package com.tencent.mobileqq.intervideo.now.dynamic;

import android.os.Bundle;
import awbt;
import awcz;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

public class NowEntry$3
  implements Runnable
{
  public NowEntry$3(awcz paramawcz, AtomicBoolean paramAtomicBoolean, Bundle paramBundle) {}
  
  public void run()
  {
    this.this$0.a.b("download_cover").c("2").b();
    if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      QLog.i("DynamicNow | NowEntry", 1, "download cover pic timeout!");
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
      awcz.a(this.this$0, this.jdField_a_of_type_AndroidOsBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.now.dynamic.NowEntry.3
 * JD-Core Version:    0.7.0.1
 */