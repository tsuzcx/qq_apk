package com.tencent.plato.sdk.render;

import com.tencent.plato.IPlatoRuntime;
import com.tencent.plato.core.IReadableMap;
import com.tencent.plato.core.IWritableMap;
import com.tencent.plato.core.utils.PLog;
import com.tencent.plato.sdk.render.data.BlockElementData;
import com.tencent.plato.sdk.render.data.ElementItem;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PBlockView
  extends PDivView
  implements IBlockView
{
  private static final String TAG = "PBlockView";
  public boolean isDirty = false;
  Map<Integer, BlockElementData> mBlockDatas = null;
  BlockElementData mBlockRoot = null;
  
  public static BlockElementData createData(BlockElementData paramBlockElementData, int paramInt, ElementItem paramElementItem)
  {
    BlockElementData localBlockElementData = new BlockElementData();
    localBlockElementData.mId = paramInt;
    localBlockElementData.parent = paramBlockElementData;
    localBlockElementData.mChildren = null;
    if (paramElementItem != null)
    {
      localBlockElementData.uiStyles = paramElementItem.uiStyles;
      localBlockElementData.mEvents = paramElementItem.getEvents();
      localBlockElementData.rc = paramElementItem.rc;
      localBlockElementData.rect = new PRect(paramElementItem.rc);
      localBlockElementData.mIndex = paramElementItem.mIndex;
      localBlockElementData.elementType = paramElementItem.elementType;
    }
    return localBlockElementData;
  }
  
  public void addBlockEvent(int paramInt, List<String> paramList)
  {
    if (this.mBlockDatas.containsKey(Integer.valueOf(paramInt)))
    {
      this.isDirty = true;
      ((BlockElementData)this.mBlockDatas.get(Integer.valueOf(paramInt))).mEvents = paramList;
    }
  }
  
  public void createBlockFinish() {}
  
  public void createBlockView(ElementItem paramElementItem, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((this.mBlockRoot == null) || (this.mBlockDatas == null)) {
      initBlock(paramInt2);
    }
    this.isDirty = true;
    if (paramInt2 == getId())
    {
      paramElementItem = createData(null, paramInt1, paramElementItem);
      this.mBlockDatas.put(Integer.valueOf(paramInt1), paramElementItem);
      if (this.mBlockRoot.mChildren == null) {
        this.mBlockRoot.mChildren = new ArrayList();
      }
      this.mBlockRoot.mChildren.add(paramInt3, paramElementItem);
    }
    while (!this.mBlockDatas.containsKey(Integer.valueOf(paramInt2))) {
      return;
    }
    BlockElementData localBlockElementData = (BlockElementData)this.mBlockDatas.get(Integer.valueOf(paramInt2));
    paramElementItem = createData(localBlockElementData, paramInt1, paramElementItem);
    this.mBlockDatas.put(Integer.valueOf(paramInt1), paramElementItem);
    if (localBlockElementData.mChildren == null) {
      localBlockElementData.mChildren = new ArrayList();
    }
    localBlockElementData.mChildren.add(paramInt3, paramElementItem);
  }
  
  public void init(IPlatoRuntime paramIPlatoRuntime, IPView paramIPView, ElementItem paramElementItem)
  {
    super.init(paramIPlatoRuntime, paramIPView, paramElementItem);
  }
  
  protected void initBlock(int paramInt) {}
  
  public boolean isBlockViewContainID(int paramInt)
  {
    return this.mBlockDatas.containsKey(Integer.valueOf(paramInt));
  }
  
  public void moveBlockView(int paramInt1, int paramInt2, int paramInt3, ElementItem paramElementItem)
  {
    if ((paramElementItem != null) && (this.mBlockDatas.containsKey(Integer.valueOf(paramInt2))))
    {
      this.isDirty = true;
      if (this.mBlockDatas.containsKey(Integer.valueOf(paramInt1)))
      {
        BlockElementData localBlockElementData = (BlockElementData)this.mBlockDatas.get(Integer.valueOf(paramInt1));
        localBlockElementData.uiStyles = paramElementItem.uiStyles;
        localBlockElementData.mEvents = paramElementItem.getEvents();
        localBlockElementData.rc = paramElementItem.rc;
        localBlockElementData.mIndex = paramElementItem.mIndex;
        localBlockElementData.elementType = paramElementItem.elementType;
        if (((BlockElementData)this.mBlockDatas.get(Integer.valueOf(paramInt2))).mChildren == null) {
          ((BlockElementData)this.mBlockDatas.get(Integer.valueOf(paramInt2))).mChildren = new ArrayList();
        }
        ((BlockElementData)this.mBlockDatas.get(Integer.valueOf(paramInt2))).mChildren.add(paramInt3, localBlockElementData);
        ((BlockElementData)this.mBlockDatas.get(Integer.valueOf(paramInt1))).parent.mChildren.remove(this.mBlockDatas.get(Integer.valueOf(paramInt1)));
        this.mBlockDatas.remove(Integer.valueOf(paramInt1));
      }
      do
      {
        return;
        paramElementItem = createData((BlockElementData)this.mBlockDatas.get(Integer.valueOf(paramInt2)), paramInt1, paramElementItem);
      } while (paramElementItem == null);
      if (((BlockElementData)this.mBlockDatas.get(Integer.valueOf(paramInt2))).mChildren == null) {
        ((BlockElementData)this.mBlockDatas.get(Integer.valueOf(paramInt2))).mChildren = new ArrayList();
      }
      ((BlockElementData)this.mBlockDatas.get(Integer.valueOf(paramInt2))).mChildren.add(paramInt3, paramElementItem);
      return;
    }
    PLog.e("PBlockView", "moveBlockView failed ");
  }
  
  public void removeBlockView(int paramInt)
  {
    if (this.mBlockDatas.containsKey(Integer.valueOf(paramInt)))
    {
      this.isDirty = true;
      BlockElementData localBlockElementData1 = (BlockElementData)this.mBlockDatas.get(Integer.valueOf(paramInt));
      if (localBlockElementData1 != null)
      {
        BlockElementData localBlockElementData2 = localBlockElementData1.parent;
        if (localBlockElementData2 != null) {
          localBlockElementData2.mChildren.remove(localBlockElementData1);
        }
      }
      this.mBlockDatas.remove(Integer.valueOf(paramInt));
    }
  }
  
  public void setBlockData(int paramInt, ElementItem paramElementItem) {}
  
  public void setStyles(IReadableMap paramIReadableMap) {}
  
  public void updateBlockStyles(int paramInt, Object paramObject)
  {
    if (this.mBlockDatas.containsKey(Integer.valueOf(paramInt)))
    {
      this.isDirty = true;
      ((BlockElementData)this.mBlockDatas.get(Integer.valueOf(paramInt))).uiStyles = ((IWritableMap)paramObject);
    }
  }
  
  public void updateRects(int paramInt, PRect paramPRect)
  {
    if (this.mBlockDatas.containsKey(Integer.valueOf(paramInt)))
    {
      this.isDirty = true;
      ((BlockElementData)this.mBlockDatas.get(Integer.valueOf(paramInt))).rc = paramPRect;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.plato.sdk.render.PBlockView
 * JD-Core Version:    0.7.0.1
 */