package com.tencent.mobileqq.troop.robot;

import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.oidb.cmd0xce5.Oidb_0xce5.RobotInfo;

public class TroopRobotInfo
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private String jdField_a_of_type_JavaLangString;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  private int jdField_c_of_type_Int;
  private String jdField_c_of_type_JavaLangString;
  private int jdField_d_of_type_Int;
  private String jdField_d_of_type_JavaLangString;
  private String e;
  
  public static TroopRobotInfo a(Oidb_0xce5.RobotInfo paramRobotInfo)
  {
    if (paramRobotInfo != null)
    {
      TroopRobotInfo localTroopRobotInfo = new TroopRobotInfo();
      localTroopRobotInfo.jdField_a_of_type_Long = paramRobotInfo.robot_uin.get();
      localTroopRobotInfo.jdField_a_of_type_JavaLangString = paramRobotInfo.name.get();
      localTroopRobotInfo.jdField_a_of_type_Int = paramRobotInfo.status.get();
      localTroopRobotInfo.jdField_b_of_type_JavaLangString = paramRobotInfo.desc.get();
      localTroopRobotInfo.jdField_b_of_type_Int = paramRobotInfo.enabled_groups.get();
      localTroopRobotInfo.jdField_c_of_type_JavaLangString = paramRobotInfo.welcome_msg.get();
      localTroopRobotInfo.jdField_d_of_type_JavaLangString = paramRobotInfo.call_name.get();
      localTroopRobotInfo.jdField_c_of_type_Int = paramRobotInfo.show_invite.get();
      localTroopRobotInfo.jdField_d_of_type_Int = paramRobotInfo.offline.get();
      localTroopRobotInfo.e = paramRobotInfo.verify.get();
      return localTroopRobotInfo;
    }
    return null;
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Int == 1;
  }
  
  public String b()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public boolean b()
  {
    return this.jdField_d_of_type_Int == 1;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("robot_uin:");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append(" name:");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(" status:");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(" desc:");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append(" enabled_groups:");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuilder.append(" welcome_msg:");
    localStringBuilder.append(this.jdField_c_of_type_JavaLangString);
    localStringBuilder.append(" call_name:");
    localStringBuilder.append(this.jdField_d_of_type_JavaLangString);
    localStringBuilder.append(" show_invite:");
    localStringBuilder.append(this.jdField_c_of_type_Int);
    localStringBuilder.append(" offline:");
    localStringBuilder.append(this.jdField_d_of_type_Int);
    localStringBuilder.append(" verify:");
    localStringBuilder.append(this.e);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.robot.TroopRobotInfo
 * JD-Core Version:    0.7.0.1
 */