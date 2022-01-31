package com.tencent.qqmini.sdk.minigame.api;

import bdpg;
import com.tencent.mobileqq.triton.sdk.ITSubPackage;

public class APIProxyImpl$2$2
  implements Runnable
{
  public APIProxyImpl$2$2(bdpg parambdpg, float paramFloat, long paramLong) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Bdpg.a != null) {
      this.jdField_a_of_type_Bdpg.a.onProgressChange(this.jdField_a_of_type_Bdpg.b, this.jdField_a_of_type_Float * 100.0F, ((float)this.jdField_a_of_type_Long * this.jdField_a_of_type_Float), this.jdField_a_of_type_Long);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.minigame.api.APIProxyImpl.2.2
 * JD-Core Version:    0.7.0.1
 */