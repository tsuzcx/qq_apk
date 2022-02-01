package com.tencent.ttpic.filter.aifilter;

import com.google.gson.annotations.SerializedName;
import java.util.HashMap;

public class FilterBean
{
  @SerializedName("gid")
  public String group;
  @SerializedName("fid")
  public String id;
  @SerializedName("params")
  public HashMap<String, String> params = new HashMap();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.filter.aifilter.FilterBean
 * JD-Core Version:    0.7.0.1
 */