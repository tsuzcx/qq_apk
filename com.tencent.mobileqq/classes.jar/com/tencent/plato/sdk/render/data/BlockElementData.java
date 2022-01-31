package com.tencent.plato.sdk.render.data;

import com.tencent.plato.sdk.render.PRect;
import java.util.ArrayList;

public class BlockElementData
  extends ElementItem
{
  public ArrayList<BlockElementData> mChildren;
  public boolean needReRect = true;
  public BlockElementData parent;
  public PRect rect;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.plato.sdk.render.data.BlockElementData
 * JD-Core Version:    0.7.0.1
 */