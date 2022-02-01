package com.tencent.mobileqq.vas;

import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.vip.IGameCardManager.GameCardInfo;
import com.tencent.mobileqq.vip.IGameCardManager.OnResultCallBack;

class VipGrayConfigHelper$2
  implements IGameCardManager.OnResultCallBack
{
  VipGrayConfigHelper$2(VipGrayConfigHelper paramVipGrayConfigHelper, URLImageView paramURLImageView, IGameCardManager.GameCardInfo paramGameCardInfo) {}
  
  public void a(URLDrawable paramURLDrawable)
  {
    this.c.a(this.a, this.b);
  }
  
  public void b(URLDrawable paramURLDrawable)
  {
    paramURLDrawable = this.a;
    if (paramURLDrawable != null) {
      paramURLDrawable.setVisibility(8);
    }
  }
  
  public void c(URLDrawable paramURLDrawable) {}
  
  public void d(URLDrawable paramURLDrawable)
  {
    paramURLDrawable.restartDownload();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.VipGrayConfigHelper.2
 * JD-Core Version:    0.7.0.1
 */