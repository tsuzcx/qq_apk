package com.tencent.mobileqq.troop.aiobubbleheadicon;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.coreui.basebubblebuilderheadicon.BaseBubbleBuilderHeadIconController;
import com.tencent.mobileqq.troop.utils.TroopBusinessUtil;
import com.tencent.mobileqq.troop.utils.TroopBusinessUtil.TroopBusinessMessage;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import java.net.MalformedURLException;
import java.net.URL;

public class TroopBusinessMsgHeadIconController
  extends BaseBubbleBuilderHeadIconController
{
  private boolean k()
  {
    return TroopBusinessUtil.a(this.a) != null;
  }
  
  protected void b()
  {
    TroopBusinessUtil.TroopBusinessMessage localTroopBusinessMessage = TroopBusinessUtil.a(this.a);
    Drawable localDrawable = this.c.getResources().getDrawable(2130841060);
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mFailedDrawable = localDrawable;
    localURLDrawableOptions.mLoadingDrawable = localDrawable;
    Object localObject2 = null;
    URLDrawable localURLDrawable = null;
    Object localObject1 = localObject2;
    if (localTroopBusinessMessage != null)
    {
      localObject1 = localObject2;
      if (localTroopBusinessMessage.b != null)
      {
        localObject1 = localURLDrawable;
        try
        {
          localURLDrawable = URLDrawable.getDrawable(new URL(localTroopBusinessMessage.b), localURLDrawableOptions);
          localObject1 = localURLDrawable;
          localURLDrawable.setTag(URLDrawableDecodeHandler.b(100, 100, 6));
          localObject1 = localURLDrawable;
          localURLDrawable.setDecodeHandler(URLDrawableDecodeHandler.b);
          localObject1 = localURLDrawable;
        }
        catch (MalformedURLException localMalformedURLException)
        {
          localMalformedURLException.printStackTrace();
        }
      }
    }
    if (localObject1 != null)
    {
      b(localObject1);
      return;
    }
    b(localDrawable);
  }
  
  protected void c()
  {
    a(this.h);
  }
  
  protected void d()
  {
    a(null);
  }
  
  protected void g() {}
  
  public boolean h()
  {
    return k();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.aiobubbleheadicon.TroopBusinessMsgHeadIconController
 * JD-Core Version:    0.7.0.1
 */