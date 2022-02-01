package com.tencent.mobileqq.text;

import bczq;
import java.io.File;

final class EmotcationConstants$1
  implements Runnable
{
  EmotcationConstants$1(File paramFile1, File paramFile2, File paramFile3) {}
  
  public void run()
  {
    if (this.val$indexFile.exists()) {
      this.val$indexFile.delete();
    }
    if (this.val$emojiFile.exists()) {
      this.val$emojiFile.delete();
    }
    bczq.a(this.val$zipfile);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.text.EmotcationConstants.1
 * JD-Core Version:    0.7.0.1
 */