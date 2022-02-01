package com.tencent.qqmini.proxyimpl;

import com.tencent.mobileqq.colornote.ColorNoteController;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

class ColorNotePlugin$3
  implements Runnable
{
  ColorNotePlugin$3(ColorNotePlugin paramColorNotePlugin, ColorNoteController paramColorNoteController, RequestEvent paramRequestEvent) {}
  
  public void run()
  {
    QQCustomDialog localQQCustomDialog = new QQCustomDialog(ColorNotePlugin.a(this.this$0).getAttachedActivity(), 2131755842);
    localQQCustomDialog.setContentView(2131559499);
    localQQCustomDialog.setMessage("是否将" + ColorNotePlugin.a(this.this$0).name + "添加到彩签？");
    localQQCustomDialog.setPositiveButton("确定", new ColorNotePlugin.3.1(this));
    localQQCustomDialog.setNegativeButton("取消", new ColorNotePlugin.3.2(this));
    localQQCustomDialog.setCanceledOnTouchOutside(false);
    localQQCustomDialog.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.ColorNotePlugin.3
 * JD-Core Version:    0.7.0.1
 */