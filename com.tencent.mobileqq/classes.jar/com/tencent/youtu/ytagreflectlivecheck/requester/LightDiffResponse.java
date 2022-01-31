package com.tencent.youtu.ytagreflectlivecheck.requester;

public class LightDiffResponse
{
  public int action_live_status;
  public String best_image;
  private String business_name;
  public int compare_code;
  public String compare_msg;
  public int compare_status;
  private int error_code;
  private String error_msg;
  public int errorcode;
  public String errormsg;
  public int facein_score;
  public int facein_status;
  private int live_type;
  private String person_id;
  public int picture_live_code;
  public String picture_live_msg;
  public int picture_live_status;
  public int reflect_live_code;
  public String reflect_live_msg;
  public int reflect_live_status;
  public int sim;
  public int similarity;
  public double similarity_float;
  public int type;
  private String wx_open_business_id;
  
  public String getBusiness_name()
  {
    return this.business_name;
  }
  
  public int getError_code()
  {
    return this.error_code;
  }
  
  public String getError_msg()
  {
    return this.error_msg;
  }
  
  public int getLive_type()
  {
    return this.live_type;
  }
  
  public String getPerson_id()
  {
    return this.person_id;
  }
  
  public String getWx_open_business_id()
  {
    return this.wx_open_business_id;
  }
  
  public void setBusiness_name(String paramString)
  {
    this.business_name = paramString;
  }
  
  public void setError_code(int paramInt)
  {
    this.error_code = paramInt;
  }
  
  public void setError_msg(String paramString)
  {
    this.error_msg = paramString;
  }
  
  public void setLive_type(int paramInt)
  {
    this.live_type = paramInt;
  }
  
  public void setPerson_id(String paramString)
  {
    this.person_id = paramString;
  }
  
  public void setWx_open_business_id(String paramString)
  {
    this.wx_open_business_id = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.youtu.ytagreflectlivecheck.requester.LightDiffResponse
 * JD-Core Version:    0.7.0.1
 */