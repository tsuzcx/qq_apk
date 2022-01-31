package com.tencent.mobileqq.webview;

import acup;
import bcbh;
import com.tencent.widget.ListView;
import java.lang.ref.WeakReference;

public class UrlSecurityCheckManager$2
  implements Runnable
{
  public UrlSecurityCheckManager$2(bcbh parambcbh, WeakReference paramWeakReference1, WeakReference paramWeakReference2) {}
  
  public void run()
  {
    ListView localListView = (ListView)this.a.get();
    acup localacup = (acup)this.b.get();
    if ((localListView != null) && (localacup != null)) {
      bcbh.a(this.this$0, localListView, localacup);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.webview.UrlSecurityCheckManager.2
 * JD-Core Version:    0.7.0.1
 */