package com.tencent.qqmini.proxyimpl;

import amgo;
import bbgg;
import begz;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

class ColorNotePlugin$1
  implements Runnable
{
  ColorNotePlugin$1(ColorNotePlugin paramColorNotePlugin, amgo paramamgo) {}
  
  public void run()
  {
    bbgg localbbgg = new bbgg(ColorNotePlugin.access$000(this.this$0).a(), 2131755791);
    localbbgg.setContentView(2131559251);
    localbbgg.setMessage("是否将" + ColorNotePlugin.access$100(this.this$0).name + "添加到彩签？");
    localbbgg.setPositiveButton("确定", new ColorNotePlugin.1.1(this));
    localbbgg.setNegativeButton("取消", new ColorNotePlugin.1.2(this));
    localbbgg.setCanceledOnTouchOutside(false);
    localbbgg.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.ColorNotePlugin.1
 * JD-Core Version:    0.7.0.1
 */