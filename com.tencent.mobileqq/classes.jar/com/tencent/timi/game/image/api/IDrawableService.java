package com.tencent.timi.game.image.api;

import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.timi.game.router.IService;

public abstract interface IDrawableService
  extends IService
{
  public abstract URLDrawable a(String paramString, URLDrawable.URLDrawableOptions paramURLDrawableOptions);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.image.api.IDrawableService
 * JD-Core Version:    0.7.0.1
 */