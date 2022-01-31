package com.tencent.qqmini.proxyimpl;

import anxn;
import bdfq;
import bgho;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

class ColorNotePlugin$1
  implements Runnable
{
  ColorNotePlugin$1(ColorNotePlugin paramColorNotePlugin, anxn paramanxn) {}
  
  public void run()
  {
    bdfq localbdfq = new bdfq(ColorNotePlugin.access$000(this.this$0).a(), 2131755801);
    localbdfq.setContentView(2131559295);
    localbdfq.setMessage("是否将" + ColorNotePlugin.access$100(this.this$0).name + "添加到彩签？");
    localbdfq.setPositiveButton("确定", new ColorNotePlugin.1.1(this));
    localbdfq.setNegativeButton("取消", new ColorNotePlugin.1.2(this));
    localbdfq.setCanceledOnTouchOutside(false);
    localbdfq.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.ColorNotePlugin.1
 * JD-Core Version:    0.7.0.1
 */