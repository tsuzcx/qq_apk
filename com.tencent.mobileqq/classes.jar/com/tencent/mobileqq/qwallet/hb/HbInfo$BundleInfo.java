package com.tencent.mobileqq.qwallet.hb;

public class HbInfo$BundleInfo
{
  public String biz_params;
  public String bus_type;
  public String panel_name;
  public String people_num;
  public String pick_entry;
  public String recv_type;
  
  public String toString()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("people_num: ");
    ((StringBuilder)localObject).append(this.people_num);
    localObject = new StringBuffer(((StringBuilder)localObject).toString());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("recv_type: ");
    localStringBuilder.append(this.recv_type);
    ((StringBuffer)localObject).append(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("bus_type: ");
    localStringBuilder.append(this.bus_type);
    ((StringBuffer)localObject).append(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("pick_entry: ");
    localStringBuilder.append(this.pick_entry);
    ((StringBuffer)localObject).append(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("biz_params: ");
    localStringBuilder.append(this.biz_params);
    ((StringBuffer)localObject).append(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("panel_name: ");
    localStringBuilder.append(this.panel_name);
    ((StringBuffer)localObject).append(localStringBuilder.toString());
    return ((StringBuffer)localObject).toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.HbInfo.BundleInfo
 * JD-Core Version:    0.7.0.1
 */