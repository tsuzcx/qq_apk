package com.tencent.mobileqq.flashshow.utils;

import android.os.Build;
import android.view.MotionEvent;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.richframework.part.block.base.NestScrollRecyclerView.TransDispatchDelegate;

final class FSCompatUtil$1
  implements NestScrollRecyclerView.TransDispatchDelegate
{
  public boolean a(MotionEvent paramMotionEvent, RecyclerView paramRecyclerView)
  {
    return ((Build.BRAND.equalsIgnoreCase("HUAWEI")) || (Build.BRAND.equalsIgnoreCase("HONOR"))) && (paramMotionEvent.getAction() == 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.utils.FSCompatUtil.1
 * JD-Core Version:    0.7.0.1
 */