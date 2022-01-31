package kotlin.io;

import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/io/FileWalkDirection;", "", "(Ljava/lang/String;I)V", "TOP_DOWN", "BOTTOM_UP", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
public enum FileWalkDirection
{
  static
  {
    FileWalkDirection localFileWalkDirection1 = new FileWalkDirection("TOP_DOWN", 0);
    TOP_DOWN = localFileWalkDirection1;
    FileWalkDirection localFileWalkDirection2 = new FileWalkDirection("BOTTOM_UP", 1);
    BOTTOM_UP = localFileWalkDirection2;
    $VALUES = new FileWalkDirection[] { localFileWalkDirection1, localFileWalkDirection2 };
  }
  
  private FileWalkDirection() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     kotlin.io.FileWalkDirection
 * JD-Core Version:    0.7.0.1
 */