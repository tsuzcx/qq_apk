package com.tencent.tkd.topicsdk.mediaselector;

import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/mediaselector/PanelType;", "", "(Ljava/lang/String;I)V", "NONE", "PHOTO", "VIDEO", "EMOJI", "topicsdk_release"}, k=1, mv={1, 1, 16})
public enum PanelType
{
  static
  {
    PanelType localPanelType1 = new PanelType("NONE", 0);
    NONE = localPanelType1;
    PanelType localPanelType2 = new PanelType("PHOTO", 1);
    PHOTO = localPanelType2;
    PanelType localPanelType3 = new PanelType("VIDEO", 2);
    VIDEO = localPanelType3;
    PanelType localPanelType4 = new PanelType("EMOJI", 3);
    EMOJI = localPanelType4;
    $VALUES = new PanelType[] { localPanelType1, localPanelType2, localPanelType3, localPanelType4 };
  }
  
  private PanelType() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.mediaselector.PanelType
 * JD-Core Version:    0.7.0.1
 */