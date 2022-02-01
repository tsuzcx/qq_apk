package com.tencent.mobileqq.qqaudio;

import java.io.File;
import java.io.FileFilter;
import java.util.regex.Pattern;

class QQAudioSystemInfo$1CpuFilter
  implements FileFilter
{
  public boolean accept(File paramFile)
  {
    return Pattern.matches("cpu[0-9]", paramFile.getName());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqaudio.QQAudioSystemInfo.1CpuFilter
 * JD-Core Version:    0.7.0.1
 */