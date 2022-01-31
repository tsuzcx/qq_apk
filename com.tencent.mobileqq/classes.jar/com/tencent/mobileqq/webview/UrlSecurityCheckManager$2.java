package com.tencent.mobileqq.webview;

import aelz;
import beai;
import com.tencent.widget.ListView;
import java.lang.ref.WeakReference;

public class UrlSecurityCheckManager$2
  implements Runnable
{
  public UrlSecurityCheckManager$2(beai parambeai, WeakReference paramWeakReference1, WeakReference paramWeakReference2) {}
  
  public void run()
  {
    ListView localListView = (ListView)this.a.get();
    aelz localaelz = (aelz)this.b.get();
    if ((localListView != null) && (localaelz != null)) {
      beai.a(this.this$0, localListView, localaelz);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.webview.UrlSecurityCheckManager.2
 * JD-Core Version:    0.7.0.1
 */