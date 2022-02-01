package com.tencent.mobileqq.filemanager.data.search;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.search.base.view.ISearchResultView;
import com.tencent.mobileqq.text.QQTextBuilder;

public class FileSearchResultView
  implements ISearchResultView
{
  protected int a;
  protected View b;
  protected ImageView c;
  protected TextView d;
  protected TextView e;
  
  public FileSearchResultView() {}
  
  public FileSearchResultView(ViewGroup paramViewGroup)
  {
    this.a = 2131629244;
    this.b = LayoutInflater.from(paramViewGroup.getContext()).inflate(this.a, paramViewGroup, false);
    a();
  }
  
  public View a(String paramString)
  {
    return null;
  }
  
  protected void a()
  {
    this.c = ((ImageView)this.b.findViewById(2131435357));
    this.d = ((TextView)this.b.findViewById(2131447463));
    this.d.setEditableFactory(QQTextBuilder.EMOCTATION_FACORY);
    this.e = ((TextView)this.b.findViewById(2131431757));
    this.b.findViewById(2131447560).setVisibility(8);
  }
  
  public TextView b()
  {
    return this.d;
  }
  
  public TextView c()
  {
    return null;
  }
  
  public TextView d()
  {
    return this.e;
  }
  
  public TextView e()
  {
    return null;
  }
  
  public ImageView f()
  {
    return null;
  }
  
  public ImageView g()
  {
    return this.c;
  }
  
  public View h()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.search.FileSearchResultView
 * JD-Core Version:    0.7.0.1
 */