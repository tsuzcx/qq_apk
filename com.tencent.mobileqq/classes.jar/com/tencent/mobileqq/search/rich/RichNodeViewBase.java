package com.tencent.mobileqq.search.rich;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public abstract class RichNodeViewBase
  implements IRichNodeView
{
  public IRichNode a;
  private RichNodeRootLayout b;
  private View c;
  private View d;
  
  public RichNodeViewBase(IRichNode paramIRichNode, Context paramContext)
  {
    this.a = paramIRichNode;
    b(paramContext);
  }
  
  public abstract View a(Context paramContext);
  
  public View a(String paramString)
  {
    return null;
  }
  
  public void a(boolean paramBoolean)
  {
    View localView = this.d;
    if (localView != null)
    {
      if (paramBoolean)
      {
        localView.setVisibility(0);
        return;
      }
      localView.setVisibility(8);
    }
  }
  
  public TextView b()
  {
    return null;
  }
  
  public void b(Context paramContext)
  {
    View localView = LayoutInflater.from(paramContext).inflate(2131627781, null, false);
    this.b = ((RichNodeRootLayout)localView.findViewById(2131445148));
    this.d = localView.findViewById(2131432003);
    this.c = a(paramContext);
    paramContext = this.c;
    if (paramContext != null) {
      this.b.addView(paramContext);
    }
  }
  
  public void b(boolean paramBoolean) {}
  
  public TextView c()
  {
    return null;
  }
  
  public TextView d()
  {
    return null;
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
    return null;
  }
  
  public final View h()
  {
    return this.b;
  }
  
  public void i()
  {
    this.a = null;
    this.b = null;
    this.c = null;
    this.d = null;
  }
  
  public void l()
  {
    i();
  }
  
  public IRichNode m()
  {
    return this.a;
  }
  
  public String n()
  {
    IRichNode localIRichNode = m();
    if (localIRichNode != null) {
      return localIRichNode.j();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.rich.RichNodeViewBase
 * JD-Core Version:    0.7.0.1
 */