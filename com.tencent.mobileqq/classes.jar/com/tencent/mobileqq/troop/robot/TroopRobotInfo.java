package com.tencent.mobileqq.troop.robot;

import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.oidb.cmd0xce5.Oidb_0xce5.RobotInfo;

public class TroopRobotInfo
{
  private long a;
  private String b;
  private int c;
  private String d;
  private int e;
  private String f;
  private String g;
  private int h;
  private int i;
  private String j;
  
  public static TroopRobotInfo a(Oidb_0xce5.RobotInfo paramRobotInfo)
  {
    if (paramRobotInfo != null)
    {
      TroopRobotInfo localTroopRobotInfo = new TroopRobotInfo();
      localTroopRobotInfo.a = paramRobotInfo.robot_uin.get();
      localTroopRobotInfo.b = paramRobotInfo.name.get();
      localTroopRobotInfo.c = paramRobotInfo.status.get();
      localTroopRobotInfo.d = paramRobotInfo.desc.get();
      localTroopRobotInfo.e = paramRobotInfo.enabled_groups.get();
      localTroopRobotInfo.f = paramRobotInfo.welcome_msg.get();
      localTroopRobotInfo.g = paramRobotInfo.call_name.get();
      localTroopRobotInfo.h = paramRobotInfo.show_invite.get();
      localTroopRobotInfo.i = paramRobotInfo.offline.get();
      localTroopRobotInfo.j = paramRobotInfo.verify.get();
      return localTroopRobotInfo;
    }
    return null;
  }
  
  public long a()
  {
    return this.a;
  }
  
  public void a(int paramInt)
  {
    this.c = paramInt;
  }
  
  public String b()
  {
    return this.b;
  }
  
  public String c()
  {
    return this.d;
  }
  
  public boolean d()
  {
    return this.c == 1;
  }
  
  public boolean e()
  {
    return this.i == 1;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("robot_uin:");
    localStringBuilder.append(this.a);
    localStringBuilder.append(" name:");
    localStringBuilder.append(this.b);
    localStringBuilder.append(" status:");
    localStringBuilder.append(this.c);
    localStringBuilder.append(" desc:");
    localStringBuilder.append(this.d);
    localStringBuilder.append(" enabled_groups:");
    localStringBuilder.append(this.e);
    localStringBuilder.append(" welcome_msg:");
    localStringBuilder.append(this.f);
    localStringBuilder.append(" call_name:");
    localStringBuilder.append(this.g);
    localStringBuilder.append(" show_invite:");
    localStringBuilder.append(this.h);
    localStringBuilder.append(" offline:");
    localStringBuilder.append(this.i);
    localStringBuilder.append(" verify:");
    localStringBuilder.append(this.j);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.robot.TroopRobotInfo
 * JD-Core Version:    0.7.0.1
 */