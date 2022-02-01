package com.tencent.mobileqq.statistics;

class StatisticCollector$CrashControl
{
  int controlFreq = 5;
  int controlLevel = 1;
  boolean controlSwitch = true;
  int controlWindow = 86400;
  
  void reset()
  {
    this.controlSwitch = true;
    this.controlLevel = 1;
    this.controlWindow = 86400;
    this.controlFreq = 5;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.StatisticCollector.CrashControl
 * JD-Core Version:    0.7.0.1
 */