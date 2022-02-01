package com.tencent.ttpic.filament;

import com.google.android.filament.IndirectLight;
import com.google.android.filament.Skybox;
import com.google.android.filament.Texture;

public class IblLoader$Ibl
{
  public IndirectLight indirectLight;
  public Texture indirectLightTexture;
  public Skybox skybox;
  public Texture skyboxTexture;
  
  public IblLoader$Ibl(IndirectLight paramIndirectLight, Texture paramTexture1, Skybox paramSkybox, Texture paramTexture2)
  {
    this.indirectLight = paramIndirectLight;
    this.indirectLightTexture = paramTexture1;
    this.skybox = paramSkybox;
    this.skyboxTexture = paramTexture2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.filament.IblLoader.Ibl
 * JD-Core Version:    0.7.0.1
 */