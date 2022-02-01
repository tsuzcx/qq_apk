package com.tencent.tkd.topicsdk.adapter.widget;

import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/adapter/widget/PublishVideoDeliverTypeLayout$DeliverType;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "Default", "SelfDeliverType", "ReprintDeliverType", "qq-adapter_release"}, k=1, mv={1, 1, 16})
public enum PublishVideoDeliverTypeLayout$DeliverType
{
  private final int value;
  
  static
  {
    DeliverType localDeliverType1 = new DeliverType("Default", 0, 0);
    Default = localDeliverType1;
    DeliverType localDeliverType2 = new DeliverType("SelfDeliverType", 1, 1);
    SelfDeliverType = localDeliverType2;
    DeliverType localDeliverType3 = new DeliverType("ReprintDeliverType", 2, 2);
    ReprintDeliverType = localDeliverType3;
    $VALUES = new DeliverType[] { localDeliverType1, localDeliverType2, localDeliverType3 };
  }
  
  private PublishVideoDeliverTypeLayout$DeliverType(int paramInt)
  {
    this.value = paramInt;
  }
  
  public final int getValue()
  {
    return this.value;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.adapter.widget.PublishVideoDeliverTypeLayout.DeliverType
 * JD-Core Version:    0.7.0.1
 */