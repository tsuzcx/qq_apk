package com.tencent.ttpic.openapi.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CosmeticsDataTemplate
{
  public static final int PARAM_ATTACH = 3;
  public static final int PARAM_COLOR = 0;
  public static final int PARAM_ENUM = 2;
  public static final int PARAM_IMAGE = 1;
  public static final int PARAM_PALACE = 4;
  public ArrayList<CosmeticsDataTemplate.CosmeticsParam> cosmetic_param = null;
  public final Map<String, ArrayList<CosmeticsDataTemplate.CosmeticsParam>> eyebrowAttach = new HashMap();
  public String folder = null;
  public String respath = null;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.openapi.model.CosmeticsDataTemplate
 * JD-Core Version:    0.7.0.1
 */