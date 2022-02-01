package com.tencent.mobileqq.shortvideo.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

class HwVideoMerge$LogStream
{
  private BufferedReader br = null;
  private InputStream inputStm = null;
  private InputStreamReader isr = null;
  public Process mProcess = null;
  
  public void initStream()
  {
    if (this.mProcess != null)
    {
      this.inputStm = this.mProcess.getInputStream();
      this.isr = new InputStreamReader(this.inputStm);
      this.br = new BufferedReader(this.isr);
    }
  }
  
  public void printStream()
  {
    if (this.mProcess != null) {}
    try
    {
      for (;;)
      {
        String str = this.br.readLine();
        if (str == null) {
          break;
        }
        HwVideoMerge.access$200("[@] compressVideo log:" + str, null);
      }
      label177:
      return;
    }
    catch (IOException localIOException1)
    {
      for (;;)
      {
        try
        {
          if (this.inputStm != null) {
            this.inputStm.close();
          }
          if (this.isr != null) {
            this.isr.close();
          }
          if (this.br != null) {
            this.br.close();
          }
          return;
        }
        catch (IOException localIOException3) {}
        try
        {
          if (this.inputStm != null) {
            this.inputStm.close();
          }
          if (this.isr != null) {
            this.isr.close();
          }
          if (this.br == null) {
            continue;
          }
          this.br.close();
          return;
        }
        catch (IOException localIOException2)
        {
          return;
        }
      }
    }
    finally
    {
      try
      {
        if (this.inputStm != null) {
          this.inputStm.close();
        }
        if (this.isr != null) {
          this.isr.close();
        }
        if (this.br != null) {
          this.br.close();
        }
      }
      catch (IOException localIOException4)
      {
        break label177;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.util.HwVideoMerge.LogStream
 * JD-Core Version:    0.7.0.1
 */