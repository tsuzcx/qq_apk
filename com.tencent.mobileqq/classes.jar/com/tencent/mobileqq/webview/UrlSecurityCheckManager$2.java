package com.tencent.mobileqq.webview;

import aggs;
import bimo;
import com.tencent.widget.ListView;
import java.lang.ref.WeakReference;

public class UrlSecurityCheckManager$2
  implements Runnable
{
  public UrlSecurityCheckManager$2(bimo parambimo, WeakReference paramWeakReference1, WeakReference paramWeakReference2) {}
  
  public void run()
  {
    ListView localListView = (ListView)this.a.get();
    aggs localaggs = (aggs)this.b.get();
    if ((localListView != null) && (localaggs != null)) {
      bimo.a(this.this$0, localListView, localaggs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.webview.UrlSecurityCheckManager.2
 * JD-Core Version:    0.7.0.1
 */