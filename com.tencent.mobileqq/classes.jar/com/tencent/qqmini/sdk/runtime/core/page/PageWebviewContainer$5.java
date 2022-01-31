package com.tencent.qqmini.sdk.runtime.core.page;

import android.support.v4.widget.SwipeRefreshLayout;
import bdfs;
import bdnw;

class PageWebviewContainer$5
  implements Runnable
{
  PageWebviewContainer$5(PageWebviewContainer paramPageWebviewContainer, boolean paramBoolean, bdfs parambdfs) {}
  
  public void run()
  {
    boolean bool2 = true;
    Object localObject;
    if ((PageWebviewContainer.b(this.this$0)) && (PageWebviewContainer.a(this.this$0) != null) && (!PageWebviewContainer.a(this.this$0).isRefreshing()))
    {
      localObject = PageWebviewContainer.a(this.this$0);
      if (this.jdField_a_of_type_Boolean) {
        break label101;
      }
      bool1 = true;
      ((SwipeRefreshLayout)localObject).setEnabled(bool1);
      localObject = new StringBuilder().append("setDisablePullDownRefresh !disable ");
      if (this.jdField_a_of_type_Boolean) {
        break label106;
      }
    }
    label101:
    label106:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      bdnw.a("PageWebviewContainer", bool1);
      this.jdField_a_of_type_Bdfs.a();
      return;
      bool1 = false;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.core.page.PageWebviewContainer.5
 * JD-Core Version:    0.7.0.1
 */