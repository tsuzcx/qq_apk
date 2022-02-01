package com.tencent.mobileqq.kandian.biz.pts.view.impl;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.kandian.base.view.widget.SquareCornerTextImageView;
import com.tencent.mobileqq.kandian.base.view.widget.SquareCornerTextImageView.PicInfo;
import com.tencent.widget.AbsListView.LayoutParams;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

class NativeGridImageView$Adapter
  extends BaseAdapter
{
  List<URL> a = new ArrayList();
  List<SquareCornerTextImageView.PicInfo> b = new ArrayList();
  
  public NativeGridImageView$Adapter(NativeGridImageView paramNativeGridImageView) {}
  
  public List<URL> a()
  {
    return this.a;
  }
  
  public void a(NativeGridImageView.GridImageModel paramGridImageModel)
  {
    this.b = paramGridImageModel.a();
    this.a = paramGridImageModel.b();
  }
  
  public int getCount()
  {
    return this.b.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.b.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Context localContext = paramViewGroup.getContext();
    paramViewGroup = paramView;
    if (paramView == null)
    {
      paramViewGroup = new SquareCornerTextImageView(localContext);
      paramViewGroup.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
    }
    ((SquareCornerTextImageView)paramViewGroup).a((SquareCornerTextImageView.PicInfo)this.b.get(paramInt));
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.view.impl.NativeGridImageView.Adapter
 * JD-Core Version:    0.7.0.1
 */