package com.tencent.qqmini.sdk.core.plugins;

import bglv;
import bgok;
import bgow;
import bgrb;

class ImageJsPlugin$1
  implements Runnable
{
  ImageJsPlugin$1(ImageJsPlugin paramImageJsPlugin, bgok parambgok, int paramInt) {}
  
  public void run()
  {
    bgrb localbgrb = bgow.a(this.this$0.mMiniAppContext.a(), 230, "图片选择", "请选择获取图片方式", "相册", "拍照", new ImageJsPlugin.1.1(this), new ImageJsPlugin.1.2(this));
    localbgrb.setCanceledOnTouchOutside(false);
    localbgrb.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.ImageJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */