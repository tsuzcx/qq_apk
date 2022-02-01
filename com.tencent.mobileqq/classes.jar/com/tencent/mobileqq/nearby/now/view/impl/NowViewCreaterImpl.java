package com.tencent.mobileqq.nearby.now.view.impl;

import android.content.Context;
import com.tencent.mobileqq.nearby.now.view.INowViewCreater;
import com.tencent.mobileqq.nearby.now.view.IShortVideoCommentsView;
import com.tencent.mobileqq.nearby.now.view.ShortVideoCommentsView;

public class NowViewCreaterImpl
  implements INowViewCreater
{
  public IShortVideoCommentsView createShortVideoCommentsView(Context paramContext)
  {
    return new ShortVideoCommentsView(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.impl.NowViewCreaterImpl
 * JD-Core Version:    0.7.0.1
 */