package com.tencent.mobileqq.kandian.repo.ugc.srtutils;

public class SRTFactory
{
  public static ReadInJoySrtHandler.IRuleManager a(int paramInt)
  {
    if (paramInt == ReadInJoySrtHandler.a) {
      return new UGRuleManager();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.ugc.srtutils.SRTFactory
 * JD-Core Version:    0.7.0.1
 */