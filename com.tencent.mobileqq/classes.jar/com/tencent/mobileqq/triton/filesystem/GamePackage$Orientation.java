package com.tencent.mobileqq.triton.filesystem;

import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/triton/filesystem/GamePackage$Orientation;", "", "(Ljava/lang/String;I)V", "PORTRAIT", "LANDSCAPE", "TritonAPI_release"}, k=1, mv={1, 1, 16})
public enum GamePackage$Orientation
{
  static
  {
    Orientation localOrientation1 = new Orientation("PORTRAIT", 0);
    PORTRAIT = localOrientation1;
    Orientation localOrientation2 = new Orientation("LANDSCAPE", 1);
    LANDSCAPE = localOrientation2;
    $VALUES = new Orientation[] { localOrientation1, localOrientation2 };
  }
  
  private GamePackage$Orientation() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.triton.filesystem.GamePackage.Orientation
 * JD-Core Version:    0.7.0.1
 */