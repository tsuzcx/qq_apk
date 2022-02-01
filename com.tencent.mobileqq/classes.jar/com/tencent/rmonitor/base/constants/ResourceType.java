package com.tencent.rmonitor.base.constants;

import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/rmonitor/base/constants/ResourceType;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "OPEN_RESOURCE", "OPEN_TAG", "OPEN_AUTO", "OUTSIDE_TAG", "rmonitor-base_release"}, k=1, mv={1, 1, 15})
public enum ResourceType
{
  private final int value;
  
  static
  {
    ResourceType localResourceType1 = new ResourceType("OPEN_RESOURCE", 0, 1);
    OPEN_RESOURCE = localResourceType1;
    ResourceType localResourceType2 = new ResourceType("OPEN_TAG", 1, 2);
    OPEN_TAG = localResourceType2;
    ResourceType localResourceType3 = new ResourceType("OPEN_AUTO", 2, 7);
    OPEN_AUTO = localResourceType3;
    ResourceType localResourceType4 = new ResourceType("OUTSIDE_TAG", 3, 8);
    OUTSIDE_TAG = localResourceType4;
    $VALUES = new ResourceType[] { localResourceType1, localResourceType2, localResourceType3, localResourceType4 };
  }
  
  private ResourceType(int paramInt)
  {
    this.value = paramInt;
  }
  
  public final int getValue()
  {
    return this.value;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.base.constants.ResourceType
 * JD-Core Version:    0.7.0.1
 */