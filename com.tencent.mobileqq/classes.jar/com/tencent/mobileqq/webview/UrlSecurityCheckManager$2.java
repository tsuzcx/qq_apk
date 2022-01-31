package com.tencent.mobileqq.webview;

import acka;
import baxz;
import com.tencent.widget.ListView;
import java.lang.ref.WeakReference;

public class UrlSecurityCheckManager$2
  implements Runnable
{
  public UrlSecurityCheckManager$2(baxz parambaxz, WeakReference paramWeakReference1, WeakReference paramWeakReference2) {}
  
  public void run()
  {
    ListView localListView = (ListView)this.a.get();
    acka localacka = (acka)this.b.get();
    if ((localListView != null) && (localacka != null)) {
      baxz.a(this.this$0, localListView, localacka);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.webview.UrlSecurityCheckManager.2
 * JD-Core Version:    0.7.0.1
 */