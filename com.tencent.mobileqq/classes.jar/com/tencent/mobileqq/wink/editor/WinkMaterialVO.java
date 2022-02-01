package com.tencent.mobileqq.wink.editor;

import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import java.util.List;

public class WinkMaterialVO
{
  private final List<MetaCategory> a;
  private final List<MetaMaterial> b;
  
  public WinkMaterialVO(List<MetaCategory> paramList, List<MetaMaterial> paramList1)
  {
    this.a = paramList;
    this.b = paramList1;
  }
  
  public List<MetaCategory> a()
  {
    return this.a;
  }
  
  public List<MetaMaterial> b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.WinkMaterialVO
 * JD-Core Version:    0.7.0.1
 */