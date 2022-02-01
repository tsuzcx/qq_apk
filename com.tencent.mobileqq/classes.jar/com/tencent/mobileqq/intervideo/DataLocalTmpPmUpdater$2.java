package com.tencent.mobileqq.intervideo;

import java.io.File;
import java.util.concurrent.Callable;

class DataLocalTmpPmUpdater$2
  implements Callable<Boolean>
{
  DataLocalTmpPmUpdater$2(DataLocalTmpPmUpdater paramDataLocalTmpPmUpdater, File paramFile) {}
  
  public Boolean a()
  {
    boolean bool;
    if ((DataLocalTmpPmUpdater.a(this.jdField_a_of_type_ComTencentMobileqqIntervideoDataLocalTmpPmUpdater).exists()) && (this.jdField_a_of_type_JavaIoFile == DataLocalTmpPmUpdater.a(this.jdField_a_of_type_ComTencentMobileqqIntervideoDataLocalTmpPmUpdater))) {
      bool = true;
    } else {
      bool = false;
    }
    return Boolean.valueOf(bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.DataLocalTmpPmUpdater.2
 * JD-Core Version:    0.7.0.1
 */