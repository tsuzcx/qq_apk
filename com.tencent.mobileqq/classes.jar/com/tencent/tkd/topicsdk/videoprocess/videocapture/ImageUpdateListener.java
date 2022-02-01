package com.tencent.tkd.topicsdk.videoprocess.videocapture;

import android.graphics.Bitmap;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/videoprocess/videocapture/ImageUpdateListener;", "", "onPreviewImageUpdate", "", "bitmap", "Landroid/graphics/Bitmap;", "topicsdk_release"}, k=1, mv={1, 1, 16})
public abstract interface ImageUpdateListener
{
  public abstract void a(@Nullable Bitmap paramBitmap);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.videoprocess.videocapture.ImageUpdateListener
 * JD-Core Version:    0.7.0.1
 */