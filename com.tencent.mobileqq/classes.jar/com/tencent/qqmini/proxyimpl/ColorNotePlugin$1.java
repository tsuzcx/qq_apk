package com.tencent.qqmini.proxyimpl;

import alrv;
import bafb;
import bdcz;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

class ColorNotePlugin$1
  implements Runnable
{
  ColorNotePlugin$1(ColorNotePlugin paramColorNotePlugin, alrv paramalrv) {}
  
  public void run()
  {
    bafb localbafb = new bafb(ColorNotePlugin.access$000(this.this$0).a(), 2131690181);
    localbafb.setContentView(2131493682);
    localbafb.setMessage("是否将" + ColorNotePlugin.access$100(this.this$0).name + "添加到彩签？");
    localbafb.setPositiveButton("确定", new ColorNotePlugin.1.1(this));
    localbafb.setNegativeButton("取消", new ColorNotePlugin.1.2(this));
    localbafb.setCanceledOnTouchOutside(false);
    localbafb.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.ColorNotePlugin.1
 * JD-Core Version:    0.7.0.1
 */