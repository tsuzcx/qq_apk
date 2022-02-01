package com.tencent.mobileqq.troop.roamsetting;

import com.tencent.mobileqq.troop.api.config.AbsRoamSettingProcessor;
import java.util.ArrayList;

public class TroopRoamSettingProcessor
  extends AbsRoamSettingProcessor
{
  public int a(String paramString)
  {
    if (paramString.contains("message.group.policy.")) {
      return 1;
    }
    if (paramString.contains("message.group.ring")) {
      return 2;
    }
    if (paramString.contains("message.group.vibrate")) {
      return 3;
    }
    return -1;
  }
  
  public String a(int paramInt)
  {
    if (paramInt == 2) {
      return "message.group.ring";
    }
    if (paramInt == 3) {
      return "message.group.vibrate";
    }
    return null;
  }
  
  public void a(ArrayList<String> paramArrayList)
  {
    if (paramArrayList == null) {
      return;
    }
    paramArrayList.add("message.group.policy_pc.*");
    paramArrayList.add("message.group.ring");
    paramArrayList.add("message.group.vibrate");
  }
  
  public String b(int paramInt)
  {
    if (paramInt == 1) {
      return String.valueOf(1);
    }
    if (paramInt == 2) {
      return String.valueOf(0);
    }
    if (paramInt == 3) {
      return String.valueOf(0);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.roamsetting.TroopRoamSettingProcessor
 * JD-Core Version:    0.7.0.1
 */