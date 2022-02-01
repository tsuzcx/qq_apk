package com.tencent.qapmsdk.base.config;

import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/base/config/DefaultPluginConfig$ResourcePlugin$ResourceType;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "OPEN_RESOURCE", "OPEN_TAG", "OPEN_AUTO", "qapmbase_release"}, k=1, mv={1, 1, 15})
public enum DefaultPluginConfig$ResourcePlugin$ResourceType
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
    $VALUES = new ResourceType[] { localResourceType1, localResourceType2, localResourceType3 };
  }
  
  private DefaultPluginConfig$ResourcePlugin$ResourceType(int paramInt)
  {
    this.value = paramInt;
  }
  
  public final int getValue()
  {
    return this.value;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qapmsdk.base.config.DefaultPluginConfig.ResourcePlugin.ResourceType
 * JD-Core Version:    0.7.0.1
 */