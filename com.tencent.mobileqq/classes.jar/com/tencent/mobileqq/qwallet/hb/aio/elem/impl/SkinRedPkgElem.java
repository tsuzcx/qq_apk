package com.tencent.mobileqq.qwallet.hb.aio.elem.impl;

import android.graphics.Bitmap;
import android.os.Bundle;
import com.qwallet.temp.IQWalletTemp;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.hb.aio.elem.RedPacketInfo;
import com.tencent.mobileqq.widget.AnimationView.AnimationInfo;
import java.util.HashMap;

public class SkinRedPkgElem
  extends BaseRedPkgElem
{
  public static String[] b = { "icon_def", "icon_txt", "icon_voice", "icon_video", "icon_sp" };
  public String c;
  public Bitmap d;
  public String e;
  public int f;
  public String g;
  public HashMap<String, Bitmap> h = new HashMap();
  public AnimationView.AnimationInfo i;
  
  public SkinRedPkgElem(String paramString)
  {
    super(paramString);
  }
  
  public void a(RedPacketInfo paramRedPacketInfo)
  {
    if (paramRedPacketInfo != null)
    {
      this.c = paramRedPacketInfo.background;
      this.d = paramRedPacketInfo.corner;
      this.i = paramRedPacketInfo.animInfo;
      this.e = paramRedPacketInfo.title;
      this.f = paramRedPacketInfo.isHideTitle;
      this.g = paramRedPacketInfo.resPath;
      String[] arrayOfString = b;
      int k = arrayOfString.length;
      int j = 0;
      while (j < k)
      {
        String str = arrayOfString[j];
        if (paramRedPacketInfo.attribute.containsKey(str))
        {
          Bitmap localBitmap = (Bitmap)paramRedPacketInfo.attribute.getParcelable(str);
          this.h.put(str, localBitmap);
        }
        j += 1;
      }
    }
  }
  
  public boolean a()
  {
    return (this.c != null) || (this.i != null);
  }
  
  public Bitmap b(RedPacketInfo paramRedPacketInfo)
  {
    Object localObject = null;
    if (paramRedPacketInfo == null) {
      return null;
    }
    String str = ((IQWalletTemp)QRoute.api(IQWalletTemp.class)).MessageForQQWalletMsg$icon_name(paramRedPacketInfo);
    paramRedPacketInfo = (RedPacketInfo)localObject;
    if (str != null) {
      paramRedPacketInfo = (Bitmap)this.h.get(str);
    }
    localObject = paramRedPacketInfo;
    if (paramRedPacketInfo == null) {
      localObject = (Bitmap)this.h.get("icon_def");
    }
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.aio.elem.impl.SkinRedPkgElem
 * JD-Core Version:    0.7.0.1
 */