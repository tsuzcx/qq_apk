package com.tencent.mobileqq.richmedia.capture.view;

import android.hardware.Camera;

public abstract interface OutPreviewCallback
{
  public abstract void onPreviewFrame(byte[] paramArrayOfByte, Camera paramCamera);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.view.OutPreviewCallback
 * JD-Core Version:    0.7.0.1
 */