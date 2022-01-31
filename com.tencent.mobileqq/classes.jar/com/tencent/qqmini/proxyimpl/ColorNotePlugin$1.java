package com.tencent.qqmini.proxyimpl;

import amgn;
import bbgu;
import behq;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

class ColorNotePlugin$1
  implements Runnable
{
  ColorNotePlugin$1(ColorNotePlugin paramColorNotePlugin, amgn paramamgn) {}
  
  public void run()
  {
    bbgu localbbgu = new bbgu(ColorNotePlugin.access$000(this.this$0).a(), 2131755791);
    localbbgu.setContentView(2131559251);
    localbbgu.setMessage("是否将" + ColorNotePlugin.access$100(this.this$0).name + "添加到彩签？");
    localbbgu.setPositiveButton("确定", new ColorNotePlugin.1.1(this));
    localbbgu.setNegativeButton("取消", new ColorNotePlugin.1.2(this));
    localbbgu.setCanceledOnTouchOutside(false);
    localbbgu.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.ColorNotePlugin.1
 * JD-Core Version:    0.7.0.1
 */