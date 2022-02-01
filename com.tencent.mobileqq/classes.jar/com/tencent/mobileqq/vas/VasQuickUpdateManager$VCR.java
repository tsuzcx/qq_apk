package com.tencent.mobileqq.vas;

import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.pb.scupdate.SCUpdatePB.ItemExtend;
import com.tencent.pb.scupdate.SCUpdatePB.VCR;

public class VasQuickUpdateManager$VCR
{
  public String appVersion;
  public long bid;
  public int optype;
  public String scid;
  public long seq;
  public String version;
  
  public void set(SCUpdatePB.VCR paramVCR)
  {
    this.seq = paramVCR.seq.get();
    this.bid = paramVCR.bid.get();
    this.scid = paramVCR.scid.get();
    this.optype = paramVCR.optype.get();
    this.version = paramVCR.version.get();
    this.appVersion = paramVCR.extendinfo.app_version.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.VasQuickUpdateManager.VCR
 * JD-Core Version:    0.7.0.1
 */