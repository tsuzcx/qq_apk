package com.tencent.qqmini.sdk.core.plugins;

import bgho;
import bgkd;
import bgkp;
import bgmu;

class ImageJsPlugin$1
  implements Runnable
{
  ImageJsPlugin$1(ImageJsPlugin paramImageJsPlugin, bgkd parambgkd, int paramInt) {}
  
  public void run()
  {
    bgmu localbgmu = bgkp.a(this.this$0.mMiniAppContext.a(), 230, "图片选择", "请选择获取图片方式", "相册", "拍照", new ImageJsPlugin.1.1(this), new ImageJsPlugin.1.2(this));
    localbgmu.setCanceledOnTouchOutside(false);
    localbgmu.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.ImageJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */