package com.tencent.mobileqq.search.presenter;

import android.graphics.Bitmap;
import com.tencent.mobileqq.search.model.IFaceModel;
import com.tencent.mobileqq.search.view.IFaceView;

public abstract interface IFacePresenter<M extends IFaceModel, V extends IFaceView>
  extends IPresenter<M, V>
{
  public abstract void a(M paramM, V paramV);
  
  public abstract void a(M paramM, V paramV, Bitmap paramBitmap);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.presenter.IFacePresenter
 * JD-Core Version:    0.7.0.1
 */