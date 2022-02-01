package com.tencent.ttpic.gameplaysdk.model;

import java.util.HashMap;

public class GameParams
{
  public String animojiBaseNodeId = "";
  public String animojiExpressionMap = "";
  public String animojiExpressionNodeIds = "";
  public HashMap<String, Range> expressionAdjustFactorMap;
  public boolean flattenEar;
  public boolean flattenNose;
  public float fov;
  public float[] mFlip = { 0.0F, 0.0F, 0.0F };
  public String mGameName = "";
  public float[] mPreTranslate = { 0.0F, 0.0F, 0.0F };
  public String nodeInitialTransform = "";
  public String[] textureImages;
  public boolean usePreload;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.gameplaysdk.model.GameParams
 * JD-Core Version:    0.7.0.1
 */