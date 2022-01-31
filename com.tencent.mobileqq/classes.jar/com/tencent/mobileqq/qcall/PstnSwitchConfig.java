package com.tencent.mobileqq.qcall;

public class PstnSwitchConfig
{
  public int a;
  public int b;
  public int c;
  public int d;
  public int e;
  public int f;
  public int g;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("PstnSwitchConfig : ");
    localStringBuilder.append("pstn_c2c_aio_flag | ").append(this.a).append(",pstn_c2c_profile_card_flag | ").append(this.b).append(",pstn_c2c_ip_call_flag | ").append(this.c).append(",pstn_multi_aio_flag | ").append(this.d).append(",pstn_multi_auto_trans_time | ").append(this.e).append(",pstn_miss_delay_time | ").append(this.f).append(",pstn_miss_show_time | ").append(this.g);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.qcall.PstnSwitchConfig
 * JD-Core Version:    0.7.0.1
 */