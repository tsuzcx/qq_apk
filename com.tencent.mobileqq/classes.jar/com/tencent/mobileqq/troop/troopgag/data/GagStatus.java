package com.tencent.mobileqq.troop.troopgag.data;

import java.util.ArrayList;

public class GagStatus
{
  public String a;
  public int b;
  public TroopGagInfo c;
  public SelfGagInfo d;
  public ArrayList<MemberGagInfo> e;
  public GagTroopResult f;
  public GagTroopMemberResult g;
  public int h = -1;
  
  public GagStatus(String paramString, GagTroopMemberResult paramGagTroopMemberResult)
  {
    this.a = paramString;
    this.g = paramGagTroopMemberResult;
    this.b = 5;
  }
  
  public GagStatus(String paramString, GagTroopResult paramGagTroopResult)
  {
    this.a = paramString;
    this.f = paramGagTroopResult;
    this.b = 4;
  }
  
  public GagStatus(String paramString, SelfGagInfo paramSelfGagInfo)
  {
    this.a = paramString;
    this.d = paramSelfGagInfo;
    this.b = 2;
  }
  
  public GagStatus(String paramString, TroopGagInfo paramTroopGagInfo)
  {
    this.a = paramString;
    this.c = paramTroopGagInfo;
    this.b = 1;
  }
  
  public GagStatus(String paramString, ArrayList<MemberGagInfo> paramArrayList)
  {
    this.a = paramString;
    this.e = paramArrayList;
    this.b = 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopgag.data.GagStatus
 * JD-Core Version:    0.7.0.1
 */