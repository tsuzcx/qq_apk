package org.libpag.reporter;

import java.io.File;

class AVReportCenter$1
  implements Runnable
{
  AVReportCenter$1(AVReportCenter paramAVReportCenter) {}
  
  public void run()
  {
    File[] arrayOfFile = new File(AVReportCenter.access$000(this.this$0)).listFiles();
    int j = 0;
    int k;
    int i;
    if (arrayOfFile != null)
    {
      k = arrayOfFile.length;
      i = 0;
      while (i < k)
      {
        arrayOfFile[i].delete();
        i += 1;
      }
    }
    arrayOfFile = new File(AVReportCenter.access$100(this.this$0)).listFiles();
    if (arrayOfFile != null)
    {
      k = arrayOfFile.length;
      i = j;
      while (i < k)
      {
        arrayOfFile[i].delete();
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     org.libpag.reporter.AVReportCenter.1
 * JD-Core Version:    0.7.0.1
 */