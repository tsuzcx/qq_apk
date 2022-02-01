package com.tencent.tkd.comment.publisher.bridge;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;

public abstract interface ImageLoaderAdapter
{
  public abstract View fetchImage(Context paramContext, String paramString, ImageLoaderAdapterOption paramImageLoaderAdapterOption, View paramView, ResultCallback<Drawable> paramResultCallback);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.comment.publisher.bridge.ImageLoaderAdapter
 * JD-Core Version:    0.7.0.1
 */