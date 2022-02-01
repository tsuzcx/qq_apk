package com.tencent.qqmini.minigame.manager;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.qqmini.minigame.widget.CustomButton;
import com.tencent.qqmini.minigame.widget.CustomButton.ButtonParam;
import com.tencent.qqmini.minigame.widget.CustomButton.ButtonStyle;
import com.tencent.qqmini.sdk.core.utils.ImageUtil;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.util.Map;

class CustomButtonManager$3
  implements Runnable
{
  CustomButtonManager$3(CustomButtonManager paramCustomButtonManager, CustomButton.ButtonParam paramButtonParam, boolean paramBoolean, View.OnClickListener paramOnClickListener) {}
  
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
      localCustomButton.setParam(this.val$param, this.val$clickListener);
      localObject = new FrameLayout.LayoutParams(-2, -2);
      ((FrameLayout.LayoutParams)localObject).height = this.val$param.style.height;
      ((FrameLayout.LayoutParams)localObject).width = this.val$param.style.width;
      ((FrameLayout.LayoutParams)localObject).leftMargin = this.val$param.style.left;
      ((FrameLayout.LayoutParams)localObject).topMargin = this.val$param.style.top;
      if (localCustomButton.getButton() != null)
      {
        CustomButtonManager.access$100(this.this$0).addView(localCustomButton.getButton(), (ViewGroup.LayoutParams)localObject);
        CustomButtonManager.access$000(this.this$0).put(Long.valueOf(this.val$param.componentId), localCustomButton);
      }
      else
      {
        QMLog.e("CustomButtonManager", "createCustomButton getButton() == null");
      }
    }
    else
    {
      localCustomButton.setParam(this.val$param, this.val$clickListener);
      localObject = (FrameLayout.LayoutParams)localCustomButton.getButton().getLayoutParams();
      ((FrameLayout.LayoutParams)localObject).height = this.val$param.style.height;
      ((FrameLayout.LayoutParams)localObject).width = this.val$param.style.width;
      ((FrameLayout.LayoutParams)localObject).leftMargin = this.val$param.style.left;
      ((FrameLayout.LayoutParams)localObject).topMargin = this.val$param.style.top;
      localCustomButton.getButton().setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    if (("image".equals(this.val$param.type)) && (!TextUtils.isEmpty(this.val$param.image)))
    {
      localObject = ImageUtil.getDrawable(CustomButtonManager.access$200(this.this$0), CustomButtonManager.access$300(this.this$0), this.val$param.image);
      if (localObject == null)
      {
        QMLog.e("CustomButtonManager", "imageDrawable == null");
        return;
      }
      localCustomButton.setImageDrawable((Drawable)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.minigame.manager.CustomButtonManager.3
 * JD-Core Version:    0.7.0.1
 */