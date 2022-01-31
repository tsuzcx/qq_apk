package com.tencent.mobileqq.vas;

import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.pb.scupdate.SCUpdatePB.ItemVersion;
import java.util.ArrayList;
import java.util.List;

public class VasQuickUpdateManager$SCPreloadOrReport
{
  public long a;
  public List a = new ArrayList();
  
  public void a(PBRepeatMessageField paramPBRepeatMessageField)
  {
    int i = 0;
    while (i < paramPBRepeatMessageField.size())
    {
      VasQuickUpdateManager.ItemVersion localItemVersion = new VasQuickUpdateManager.ItemVersion();
      SCUpdatePB.ItemVersion localItemVersion1 = (SCUpdatePB.ItemVersion)paramPBRepeatMessageField.get(i);
      localItemVersion.jdField_a_of_type_Long = localItemVersion1.bid.get();
      localItemVersion.jdField_a_of_type_JavaLangString = localItemVersion1.scid.get();
      localItemVersion.jdField_b_of_type_JavaLangString = localItemVersion1.version.get();
      localItemVersion.jdField_b_of_type_Long = localItemVersion1.flag.get();
      this.a.add(localItemVersion);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp2\com34.jar
 * Qualified Name:     com.tencent.mobileqq.vas.VasQuickUpdateManager.SCPreloadOrReport
 * JD-Core Version:    0.7.0.1
 */