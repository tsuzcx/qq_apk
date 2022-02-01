package com.tencent.mobileqq.wink.editor.music.viewmodel;

import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/wink/editor/music/viewmodel/MusicVolumeControlViewModel$VolumeType;", "", "(Ljava/lang/String;I)V", "ORIGIN", "BGM", "TEMPLATE", "NONE", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public enum MusicVolumeControlViewModel$VolumeType
{
  static
  {
    VolumeType localVolumeType1 = new VolumeType("ORIGIN", 0);
    ORIGIN = localVolumeType1;
    VolumeType localVolumeType2 = new VolumeType("BGM", 1);
    BGM = localVolumeType2;
    VolumeType localVolumeType3 = new VolumeType("TEMPLATE", 2);
    TEMPLATE = localVolumeType3;
    VolumeType localVolumeType4 = new VolumeType("NONE", 3);
    NONE = localVolumeType4;
    $VALUES = new VolumeType[] { localVolumeType1, localVolumeType2, localVolumeType3, localVolumeType4 };
  }
  
  private MusicVolumeControlViewModel$VolumeType() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.music.viewmodel.MusicVolumeControlViewModel.VolumeType
 * JD-Core Version:    0.7.0.1
 */