package com.tencent.mobileqq.vip.diy.template;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.profilecard.bussiness.photowall.view.PhotoWallView;

public class TemplatePhotoWall
  extends PhotoWallView
{
  public TemplatePhotoWall(Context paramContext, QQAppInterface paramQQAppInterface, String paramString)
  {
    super(paramContext, paramQQAppInterface, paramString);
    this.mEmptyBgView.setAlpha(0.8F);
  }
  
  protected int getLayout()
  {
    return 2131628449;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vip.diy.template.TemplatePhotoWall
 * JD-Core Version:    0.7.0.1
 */