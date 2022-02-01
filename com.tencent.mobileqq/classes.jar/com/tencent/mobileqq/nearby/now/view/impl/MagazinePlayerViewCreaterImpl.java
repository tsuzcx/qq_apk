package com.tencent.mobileqq.nearby.now.view.impl;

import android.content.Context;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.now.ActCallBack;
import com.tencent.mobileqq.nearby.now.view.IMagazinePlayerView;
import com.tencent.mobileqq.nearby.now.view.IMagazinePlayerViewCreater;
import com.tencent.mobileqq.nearby.now.view.MagazinePlayerView;

public class MagazinePlayerViewCreaterImpl
  implements IMagazinePlayerViewCreater
{
  public IMagazinePlayerView create(Context paramContext, ActCallBack paramActCallBack, AppInterface paramAppInterface)
  {
    return new MagazinePlayerView(paramContext, paramActCallBack, (QQAppInterface)paramAppInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.impl.MagazinePlayerViewCreaterImpl
 * JD-Core Version:    0.7.0.1
 */