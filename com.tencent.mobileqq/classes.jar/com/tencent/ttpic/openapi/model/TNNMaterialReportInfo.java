package com.tencent.ttpic.openapi.model;

public class TNNMaterialReportInfo
{
  public int deviceLevel;
  public boolean isDeviceDowngrade;
  public boolean isTNNAvailable;
  public String materialID;
  public String modelName;
  public int[] netSize;
  
  public void reset()
  {
    this.materialID = "";
    this.modelName = "";
    this.netSize = new int[] { 0, 0 };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.openapi.model.TNNMaterialReportInfo
 * JD-Core Version:    0.7.0.1
 */