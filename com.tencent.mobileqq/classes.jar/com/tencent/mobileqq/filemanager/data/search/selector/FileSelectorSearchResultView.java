package com.tencent.mobileqq.filemanager.data.search.selector;

import android.text.TextUtils.TruncateAt;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.search.base.view.ISearchResultView;
import com.tencent.mobileqq.troop.widget.EllipsizingTextView;

public class FileSelectorSearchResultView
  implements ISearchResultView
{
  private View a;
  private ImageView b;
  private EllipsizingTextView c;
  private TextView d;
  private CheckBox e;
  
  public FileSelectorSearchResultView(ViewGroup paramViewGroup)
  {
    this.a = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131627080, paramViewGroup, false);
    this.b = ((ImageView)this.a.findViewById(2131433103));
    this.c = ((EllipsizingTextView)this.a.findViewById(2131433114));
    this.d = ((TextView)this.a.findViewById(2131431733));
    this.c.setMaxLines(1);
    this.c.a();
    this.c.setEllipsize(TextUtils.TruncateAt.MIDDLE);
    this.e = ((CheckBox)this.a.findViewById(2131433116));
    this.e.setVisibility(0);
  }
  
  public View a(String paramString)
  {
    return null;
  }
  
  public TextView b()
  {
    return this.c;
  }
  
  public TextView c()
  {
    return null;
  }
  
  public TextView d()
  {
    return this.d;
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
    return this.b;
  }
  
  public View h()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.search.selector.FileSelectorSearchResultView
 * JD-Core Version:    0.7.0.1
 */