package com.tencent.mobileqq.troop.enterEffect;

public class TroopEnterEffectController$TroopEnterEffectData
{
  public int a;
  public long a;
  public String a;
  public int b;
  public long b;
  public String b;
  public int c;
  public int d;
  
  public TroopEnterEffectController$TroopEnterEffectData(int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, int paramInt4, long paramLong)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_b_of_type_Int = paramInt2;
    this.c = paramInt3;
    this.d = paramInt4;
    this.jdField_b_of_type_Long = paramLong;
    this.jdField_a_of_type_Long = System.currentTimeMillis();
  }
  
  public String toString()
  {
    return String.format("{id: %d, uin: %s, troopUin: %s, createTime: %d, svipLevel: %d, svipType: %d, globalTroopLevel: %d, mode: %d}", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int), this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, Long.valueOf(this.jdField_a_of_type_Long), Integer.valueOf(this.jdField_b_of_type_Int), Integer.valueOf(this.c), Integer.valueOf(this.d), Long.valueOf(this.jdField_b_of_type_Long) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\a2.jar
 * Qualified Name:     com.tencent.mobileqq.troop.enterEffect.TroopEnterEffectController.TroopEnterEffectData
 * JD-Core Version:    0.7.0.1
 */