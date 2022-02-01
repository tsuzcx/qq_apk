package com.tencent.mobileqq.resourcesgrab.strategy;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer.DrawableContainerState;
import android.view.View;
import com.tencent.mobileqq.resourcesgrab.ResourceGrabSkinData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.BaseConstantState;
import java.util.List;

public abstract class ResourceNameGrabStrategy
{
  public abstract List<ResourceGrabSkinData> a(View paramView);
  
  void a(Drawable paramDrawable, List<ResourceGrabSkinData> paramList, int paramInt)
  {
    if ((paramDrawable != null) && (paramDrawable.getConstantState() != null) && (paramList != null))
    {
      paramDrawable = paramDrawable.getConstantState();
      if (!(paramDrawable instanceof BaseConstantState)) {
        break label81;
      }
      paramList.add(new ResourceGrabSkinData(paramInt, ((BaseConstantState)paramDrawable).skinData));
      if (QLog.isColorLevel()) {
        QLog.d("SpecialResourceNameGrab", 2, "getFileNameByConstantState BaseConstantState resourceNames -> " + paramList);
      }
    }
    for (;;)
    {
      return;
      label81:
      if ((paramDrawable instanceof DrawableContainer.DrawableContainerState))
      {
        if (QLog.isColorLevel()) {
          QLog.d("SpecialResourceNameGrab", 2, "getFileNameByConstantState DrawableContainerState");
        }
        paramDrawable = ((DrawableContainer.DrawableContainerState)paramDrawable).getChildren();
        int j = paramDrawable.length;
        int i = 0;
        while (i < j)
        {
          Drawable localDrawable = paramDrawable[i];
          if (localDrawable != null) {
            a(localDrawable, paramList, paramInt);
          }
          i += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.resourcesgrab.strategy.ResourceNameGrabStrategy
 * JD-Core Version:    0.7.0.1
 */