package com.tencent.ttpic.openapi.model;

import com.google.android.filament.Entity;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DynamicBoneItem
{
  public int boneCount;
  public List<Map<String, String>> boneParamsList;
  public List<Map<String, String>> colliderList;
  @Entity
  public List<Integer> entities = new ArrayList();
  public float[] gravity = { 0.0F, 0.0F, 0.0F };
  public boolean noRotateUpdate = false;
  public List<String> rootNames;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.openapi.model.DynamicBoneItem
 * JD-Core Version:    0.7.0.1
 */