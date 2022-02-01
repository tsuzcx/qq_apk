package com.tencent.mobileqq.listentogether;

import awlt;
import bdmc;
import com.tencent.common.app.BaseApplicationImpl;
import java.util.HashMap;

public class ListenTogetherHandler$1
  implements Runnable
{
  public ListenTogetherHandler$1(awlt paramawlt, long paramLong1, long paramLong2, int paramInt, long paramLong3) {}
  
  public void run()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("server_request", String.valueOf(this.jdField_a_of_type_Long - this.b));
    localHashMap.put("serverInterval", String.valueOf(this.jdField_a_of_type_Long));
    localHashMap.put("requestInterval", String.valueOf(this.b));
    localHashMap.put("reportType", String.valueOf(this.jdField_a_of_type_Int));
    localHashMap.put("interval", String.valueOf(this.c));
    bdmc.a(BaseApplicationImpl.getContext()).a("", "listen_together_seek_adjust", true, 0L, 0L, localHashMap, "", false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.ListenTogetherHandler.1
 * JD-Core Version:    0.7.0.1
 */