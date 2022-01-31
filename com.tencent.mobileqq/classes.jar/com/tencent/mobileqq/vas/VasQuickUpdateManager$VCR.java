package com.tencent.mobileqq.vas;

import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.pb.scupdate.SCUpdatePB.VCR;

public class VasQuickUpdateManager$VCR
{
  public int a;
  public long a;
  public String a;
  public long b;
  public String b;
  
  public void a(SCUpdatePB.VCR paramVCR)
  {
    this.jdField_a_of_type_Long = paramVCR.seq.get();
    this.jdField_b_of_type_Long = paramVCR.bid.get();
    this.jdField_a_of_type_JavaLangString = paramVCR.scid.get();
    this.jdField_a_of_type_Int = paramVCR.optype.get();
    this.jdField_b_of_type_JavaLangString = paramVCR.version.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\a2.jar
 * Qualified Name:     com.tencent.mobileqq.vas.VasQuickUpdateManager.VCR
 * JD-Core Version:    0.7.0.1
 */