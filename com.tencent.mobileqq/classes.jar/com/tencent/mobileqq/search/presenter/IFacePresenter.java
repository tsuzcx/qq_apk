package com.tencent.mobileqq.search.presenter;

import android.graphics.Bitmap;
import com.tencent.mobileqq.search.model.IFaceModel;
import com.tencent.mobileqq.search.view.IFaceView;

public abstract interface IFacePresenter
  extends IPresenter
{
  public abstract void a(IFaceModel paramIFaceModel, IFaceView paramIFaceView);
  
  public abstract void a(IFaceModel paramIFaceModel, IFaceView paramIFaceView, Bitmap paramBitmap);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.search.presenter.IFacePresenter
 * JD-Core Version:    0.7.0.1
 */