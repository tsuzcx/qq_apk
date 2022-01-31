package com.tencent.mobileqq.filemanager.core;

import aqvu;
import aqvw;
import java.util.LinkedHashMap;
import java.util.List;

public class ThumbDownloadManager$3
  implements Runnable
{
  public ThumbDownloadManager$3(aqvu paramaqvu) {}
  
  public void run()
  {
    if (aqvu.a(this.this$0).size() >= 8) {}
    while (aqvu.a(this.this$0).size() == 0) {
      return;
    }
    aqvw localaqvw = (aqvw)aqvu.a(this.this$0).get(0);
    if (localaqvw == null)
    {
      aqvu.a(this.this$0).remove(0);
      aqvu.a(this.this$0);
      return;
    }
    aqvu.a(this.this$0).remove(localaqvw);
    aqvu.a(this.this$0, localaqvw);
    aqvu.b(this.this$0, localaqvw);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.ThumbDownloadManager.3
 * JD-Core Version:    0.7.0.1
 */