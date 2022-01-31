package com.tencent.qqmini.sdk.core.plugins.engine;

import android.view.View;
import android.view.View.OnClickListener;
import bgmn;

class BaseJsPluginEngine$4$1$2
  implements View.OnClickListener
{
  BaseJsPluginEngine$4$1$2(BaseJsPluginEngine.4.1 param1) {}
  
  public void onClick(View paramView)
  {
    if (this.this$2.this$1.this$0.authDialog != null)
    {
      this.this$2.this$1.this$0.authDialog.a(true);
      this.this$2.this$1.this$0.authDialog.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.engine.BaseJsPluginEngine.4.1.2
 * JD-Core Version:    0.7.0.1
 */