package com.tencent.mobileqq.kandian.repo.db.struct;

import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.mobileqq.kandian.repo.reddot.KandianMsgBoxRedPntInfo;

public class KandianMsgBoxRedPntInfoImpl
  extends KandianMsgBoxRedPntInfo
{
  public static final String TAG = "KandianMsgBoxRedPntInfoImpl";
  
  public void asyncWriteToSP()
  {
    RIJSPUtils.a("kandian_msg_box_sp_key_new", this, true);
  }
  
  public void removeFromSP()
  {
    RIJSPUtils.a("kandian_msg_box_sp_key_new", true);
  }
  
  public void writeToSP()
  {
    RIJSPUtils.b("kandian_msg_box_sp_key_new", this, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.db.struct.KandianMsgBoxRedPntInfoImpl
 * JD-Core Version:    0.7.0.1
 */