package com.tencent.ttpic.filter.aifilter;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

public class FilterMaterialNew
{
  @SerializedName("filters")
  ArrayList<FilterBean> baseFilterMaterials = new ArrayList();
  @SerializedName("cpulevel")
  public String cpuLevel = "";
  @SerializedName("desc")
  public String desc = "";
  @SerializedName("name")
  public String name = "";
  @SerializedName("path")
  public String path = "";
  @SerializedName("strength")
  public int strength = 100;
  @SerializedName("thumbnail")
  public String thumbnail = "";
  @SerializedName("version")
  public int version = 1;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.filter.aifilter.FilterMaterialNew
 * JD-Core Version:    0.7.0.1
 */