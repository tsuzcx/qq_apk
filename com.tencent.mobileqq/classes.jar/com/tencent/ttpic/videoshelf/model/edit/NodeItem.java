package com.tencent.ttpic.videoshelf.model.edit;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;

public class NodeItem
{
  public Bitmap bitmap;
  public String coverURL;
  public Bitmap cropBitmap;
  public int[] indexLayerForPag;
  public RectF maskRect = new RectF();
  public Matrix matrix = new Matrix();
  public int nodeGroupID;
  public int nodeID;
  public NodeText nodeTextGroup = new NodeText();
  public int nodeTextMaxCount;
  public boolean once = true;
  public int type = 0;
  public int zIndex;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.videoshelf.model.edit.NodeItem
 * JD-Core Version:    0.7.0.1
 */