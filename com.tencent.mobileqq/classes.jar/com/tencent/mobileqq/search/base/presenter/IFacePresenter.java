package com.tencent.mobileqq.search.base.presenter;

import android.graphics.Bitmap;
import com.tencent.mobileqq.search.base.view.IFaceView;
import com.tencent.mobileqq.search.model.IFaceModel;

public abstract interface IFacePresenter<M extends IFaceModel, V extends IFaceView>
  extends IPresenter<M, V>
{
  public abstract void a(M paramM, V paramV);
  
  public abstract void a(M paramM, V paramV, Bitmap paramBitmap);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.base.presenter.IFacePresenter
 * JD-Core Version:    0.7.0.1
 */