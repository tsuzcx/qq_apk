package com.tencent.ttpic.filter.aifilter;

import com.tencent.ttpic.openapi.model.BridgeMaterial;
import java.util.Comparator;

final class MultiFilterParamConnect$1
  implements Comparator<BridgeMaterial>
{
  public int compare(BridgeMaterial paramBridgeMaterial1, BridgeMaterial paramBridgeMaterial2)
  {
    return new Integer(paramBridgeMaterial1.index).compareTo(Integer.valueOf(paramBridgeMaterial2.index));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.filter.aifilter.MultiFilterParamConnect.1
 * JD-Core Version:    0.7.0.1
 */