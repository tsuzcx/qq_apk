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
  private boolean b()
  {
    return TroopBusinessUtil.a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage) != null;
  }
  
  public boolean a()
  {
    return b();
  }
  
  protected void b()
  {
    TroopBusinessUtil.TroopBusinessMessage localTroopBusinessMessage = TroopBusinessUtil.a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
    Drawable localDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130840321);
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mFailedDrawable = localDrawable;
    localURLDrawableOptions.mLoadingDrawable = localDrawable;
    Object localObject2 = null;
    URLDrawable localURLDrawable = null;
    Object localObject1 = localObject2;
    if (localTroopBusinessMessage != null)
    {
      localObject1 = localObject2;
      if (localTroopBusinessMessage.a != null)
      {
        localObject1 = localURLDrawable;
        try
        {
          localURLDrawable = URLDrawable.getDrawable(new URL(localTroopBusinessMessage.a), localURLDrawableOptions);
          localObject1 = localURLDrawable;
          localURLDrawable.setTag(URLDrawableDecodeHandler.b(100, 100, 6));
          localObject1 = localURLDrawable;
          localURLDrawable.setDecodeHandler(URLDrawableDecodeHandler.a);
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
    a(this.jdField_a_of_type_AndroidViewView$OnClickListener);
  }
  
  protected void d()
  {
    a(null);
  }
  
  protected void g() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.troop.aiobubbleheadicon.TroopBusinessMsgHeadIconController
 * JD-Core Version:    0.7.0.1
 */