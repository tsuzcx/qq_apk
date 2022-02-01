package com.tencent.mobileqq.text;

import bdne;
import java.io.File;

public final class EmotcationConstants$1
  implements Runnable
{
  public EmotcationConstants$1(File paramFile1, File paramFile2, File paramFile3) {}
  
  public void run()
  {
    if (this.a.exists()) {
      this.a.delete();
    }
    if (this.b.exists()) {
      this.b.delete();
    }
    bdne.a(this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.text.EmotcationConstants.1
 * JD-Core Version:    0.7.0.1
 */