package com.tencent.mobileqq.webview;

import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.widget.ListView;
import java.lang.ref.WeakReference;

class UrlSecurityCheckManager$2
  implements Runnable
{
  UrlSecurityCheckManager$2(UrlSecurityCheckManager paramUrlSecurityCheckManager, WeakReference paramWeakReference1, WeakReference paramWeakReference2) {}
  
  public void run()
  {
    ListView localListView = (ListView)this.a.get();
    ChatAdapter1 localChatAdapter1 = (ChatAdapter1)this.b.get();
    if ((localListView != null) && (localChatAdapter1 != null)) {
      UrlSecurityCheckManager.a(this.this$0, localListView, localChatAdapter1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.webview.UrlSecurityCheckManager.2
 * JD-Core Version:    0.7.0.1
 */