package com.tencent.ttpic.openapi.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FilterMaterial
{
  public List<BaseFilterMaterial> baseFilterMaterials = new ArrayList();
  public Map<Integer, List<BridgeMaterial>> bridgeMaterialMap = new HashMap();
  public String cpuLevel = "";
  public String name = "";
  public String path = "";
  public int strength = 100;
  public String thumbnail = "";
  public MaterialUtil.FILTER_TYPE type = MaterialUtil.FILTER_TYPE.GPU;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.openapi.model.FilterMaterial
 * JD-Core Version:    0.7.0.1
 */