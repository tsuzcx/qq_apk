package com.tencent.mobileqq.forward.api.impl;

import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.ForwardRecentTranslucentActivity;
import com.tencent.mobileqq.forward.api.IForwardApi;

public class ForwardApiImpl
  implements IForwardApi
{
  public String KEY_DIRECT_SHOW_UIN()
  {
    return "key_direct_show_uin";
  }
  
  public String KEY_DIRECT_SHOW_UIN_TYPE()
  {
    return "key_direct_show_uin_type";
  }
  
  public String KEY_REQ()
  {
    return "key_req";
  }
  
  public int REQ_DIRECT_SHOW_DIALOG()
  {
    return ForwardRecentActivity.f;
  }
  
  public Class getForwardRecentActivityClass()
  {
    return ForwardRecentActivity.class;
  }
  
  public Class getForwardRecentTranslucentActivityClass()
  {
    return ForwardRecentTranslucentActivity.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.forward.api.impl.ForwardApiImpl
 * JD-Core Version:    0.7.0.1
 */