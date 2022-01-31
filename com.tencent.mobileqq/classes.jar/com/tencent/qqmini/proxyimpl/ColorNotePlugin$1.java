package com.tencent.qqmini.proxyimpl;

import aobw;
import bdjz;
import bglv;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

class ColorNotePlugin$1
  implements Runnable
{
  ColorNotePlugin$1(ColorNotePlugin paramColorNotePlugin, aobw paramaobw) {}
  
  public void run()
  {
    bdjz localbdjz = new bdjz(ColorNotePlugin.access$000(this.this$0).a(), 2131755801);
    localbdjz.setContentView(2131559294);
    localbdjz.setMessage("是否将" + ColorNotePlugin.access$100(this.this$0).name + "添加到彩签？");
    localbdjz.setPositiveButton("确定", new ColorNotePlugin.1.1(this));
    localbdjz.setNegativeButton("取消", new ColorNotePlugin.1.2(this));
    localbdjz.setCanceledOnTouchOutside(false);
    localbdjz.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.ColorNotePlugin.1
 * JD-Core Version:    0.7.0.1
 */