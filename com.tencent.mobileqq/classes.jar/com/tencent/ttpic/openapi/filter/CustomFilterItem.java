package com.tencent.ttpic.openapi.filter;

import java.util.ArrayList;
import java.util.Map;

public class CustomFilterItem
{
  public String filterName;
  public int filterType;
  public float filterValue;
  public String fragment;
  public String id;
  public int[] inputFrameSize = new int[2];
  public Map<String, String> lutPaths;
  public Map<String, String> materialPaths;
  public int[] outputFrameSize = new int[2];
  public ArrayList<String> preFilterId;
  public String vertex;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.CustomFilterItem
 * JD-Core Version:    0.7.0.1
 */