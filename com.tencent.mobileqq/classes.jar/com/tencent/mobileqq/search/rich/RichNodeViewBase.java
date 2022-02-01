package com.tencent.mobileqq.search.rich;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public abstract class RichNodeViewBase
  implements IRichNodeView
{
  private View jdField_a_of_type_AndroidViewView;
  public IRichNode a;
  private RichNodeRootLayout jdField_a_of_type_ComTencentMobileqqSearchRichRichNodeRootLayout;
  private View b;
  
  public RichNodeViewBase(IRichNode paramIRichNode, Context paramContext)
  {
    this.jdField_a_of_type_ComTencentMobileqqSearchRichIRichNode = paramIRichNode;
    a(paramContext);
  }
  
  public final View a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqSearchRichRichNodeRootLayout;
  }
  
  public abstract View a(Context paramContext);
  
  public View a(String paramString)
  {
    return null;
  }
  
  public ImageView a()
  {
    return null;
  }
  
  public TextView a()
  {
    return null;
  }
  
  public IRichNode a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqSearchRichIRichNode;
  }
  
  public String a()
  {
    IRichNode localIRichNode = a();
    if (localIRichNode != null) {
      return localIRichNode.a();
    }
    return null;
  }
  
  public void a(Context paramContext)
  {
    View localView = LayoutInflater.from(paramContext).inflate(2131561425, null, false);
    this.jdField_a_of_type_ComTencentMobileqqSearchRichRichNodeRootLayout = ((RichNodeRootLayout)localView.findViewById(2131376818));
    this.b = localView.findViewById(2131365759);
    this.jdField_a_of_type_AndroidViewView = a(paramContext);
    paramContext = this.jdField_a_of_type_AndroidViewView;
    if (paramContext != null) {
      this.jdField_a_of_type_ComTencentMobileqqSearchRichRichNodeRootLayout.addView(paramContext);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    View localView = this.b;
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
  
  public ImageView b()
  {
    return null;
  }
  
  public TextView b()
  {
    return null;
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
  
  public void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqSearchRichIRichNode = null;
    this.jdField_a_of_type_ComTencentMobileqqSearchRichRichNodeRootLayout = null;
    this.jdField_a_of_type_AndroidViewView = null;
    this.b = null;
  }
  
  public void f()
  {
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.rich.RichNodeViewBase
 * JD-Core Version:    0.7.0.1
 */