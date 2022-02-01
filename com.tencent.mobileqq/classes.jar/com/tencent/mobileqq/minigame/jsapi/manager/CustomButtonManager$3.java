package com.tencent.mobileqq.minigame.jsapi.manager;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.mini.util.ImageUtil;
import com.tencent.mobileqq.minigame.jsapi.callbacks.IGameUI;
import com.tencent.mobileqq.minigame.jsapi.widgets.CustomButton;
import com.tencent.mobileqq.minigame.jsapi.widgets.CustomButton.ButtonParam;
import com.tencent.mobileqq.minigame.jsapi.widgets.CustomButton.ButtonStyle;
import com.tencent.mobileqq.minigame.jsapi.widgets.CustomButton.OnClickListener;
import com.tencent.mobileqq.minigame.utils.GameLog;
import java.util.Map;

class CustomButtonManager$3
  implements Runnable
{
  CustomButtonManager$3(CustomButtonManager paramCustomButtonManager, CustomButton.ButtonParam paramButtonParam, boolean paramBoolean, CustomButton.OnClickListener paramOnClickListener) {}
  
  public void run()
  {
    CustomButton localCustomButton = (CustomButton)CustomButtonManager.access$000(this.this$0).get(Long.valueOf(this.val$param.componentId));
    if ((this.val$isUpdate) && (localCustomButton == null)) {
      return;
    }
    Object localObject;
    if (localCustomButton == null)
    {
      localCustomButton = new CustomButton(CustomButtonManager.access$200(this.this$0));
      localCustomButton.setParam(this.val$param);
      localObject = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject).height = this.val$param.style.height;
      ((RelativeLayout.LayoutParams)localObject).width = this.val$param.style.width;
      ((RelativeLayout.LayoutParams)localObject).leftMargin = this.val$param.style.left;
      ((RelativeLayout.LayoutParams)localObject).topMargin = this.val$param.style.top;
      if (localCustomButton.getButton() != null)
      {
        CustomButtonManager.access$100(this.this$0).getGameParent().addView(localCustomButton.getButton(), (ViewGroup.LayoutParams)localObject);
        CustomButtonManager.access$000(this.this$0).put(Long.valueOf(this.val$param.componentId), localCustomButton);
      }
    }
    for (;;)
    {
      localCustomButton.setOnClickListener(this.val$clickListener);
      if ((!"image".equals(this.val$param.type)) || (TextUtils.isEmpty(this.val$param.image))) {
        break;
      }
      localObject = ImageUtil.getDrawable(this.val$param.image);
      if (localObject != null) {
        break label345;
      }
      GameLog.getInstance().e("CustomButtonManager", "imageDrawable == null");
      return;
      GameLog.getInstance().e("CustomButtonManager", "createCustomButton getButton() == null");
      return;
      localCustomButton.setParam(this.val$param);
      localObject = (RelativeLayout.LayoutParams)localCustomButton.getButton().getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).height = this.val$param.style.height;
      ((RelativeLayout.LayoutParams)localObject).width = this.val$param.style.width;
      ((RelativeLayout.LayoutParams)localObject).leftMargin = this.val$param.style.left;
      ((RelativeLayout.LayoutParams)localObject).topMargin = this.val$param.style.top;
      localCustomButton.getButton().setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    label345:
    localCustomButton.setImageDrawable((Drawable)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.jsapi.manager.CustomButtonManager.3
 * JD-Core Version:    0.7.0.1
 */