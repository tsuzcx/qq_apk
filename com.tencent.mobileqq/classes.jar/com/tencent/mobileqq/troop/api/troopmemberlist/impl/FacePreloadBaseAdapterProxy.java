package com.tencent.mobileqq.troop.api.troopmemberlist.impl;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.mobileqq.adapter.FacePreloadBaseAdapter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.api.troopmemberlist.IFacePreloadBaseAdapter;
import com.tencent.mobileqq.troop.api.troopmemberlist.IFacePreloadBaseAdapterProxy;
import com.tencent.widget.ListView;

public class FacePreloadBaseAdapterProxy
  extends FacePreloadBaseAdapter
  implements IFacePreloadBaseAdapterProxy
{
  private IFacePreloadBaseAdapter a;
  
  public FacePreloadBaseAdapterProxy(IFacePreloadBaseAdapter paramIFacePreloadBaseAdapter, Context paramContext, QQAppInterface paramQQAppInterface, ListView paramListView, int paramInt, boolean paramBoolean)
  {
    super(paramContext, paramQQAppInterface, paramListView, paramInt, paramBoolean);
    this.a = paramIFacePreloadBaseAdapter;
  }
  
  public Bitmap a(int paramInt, String paramString)
  {
    return super.a(paramInt, paramString);
  }
  
  public void c()
  {
    super.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.troopmemberlist.impl.FacePreloadBaseAdapterProxy
 * JD-Core Version:    0.7.0.1
 */