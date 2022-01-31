package dov.com.qq.im.aeeditor.module.toolbar;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import bdoo;
import blpp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class AEEditorToolBar
  extends LinearLayout
  implements View.OnClickListener
{
  private static final String jdField_a_of_type_JavaLangString = AEEditorToolBar.class.getSimpleName();
  protected blpp a;
  private List<ToolbarButton> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public AEEditorToolBar(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public AEEditorToolBar(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public AEEditorToolBar(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    setOrientation(1);
    a();
  }
  
  abstract void a();
  
  protected void a(int paramInt1, String paramString, int paramInt2)
  {
    ToolbarButton localToolbarButton = new ToolbarButton(getContext());
    localToolbarButton.setTag(paramString);
    localToolbarButton.setOnClickListener(this);
    localToolbarButton.setBackgroundColor(0);
    localToolbarButton.setImageResource(paramInt2);
    paramString = new LinearLayout.LayoutParams(-2, -2);
    paramString.width = bdoo.a(50.0F);
    paramString.height = bdoo.a(50.0F);
    addView(localToolbarButton, paramInt1, paramString);
    this.jdField_a_of_type_JavaUtilList.add(paramInt1, localToolbarButton);
  }
  
  abstract void a(String paramString);
  
  public void a(String paramString, int paramInt)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      ToolbarButton localToolbarButton = (ToolbarButton)localIterator.next();
      if (paramString.equals(localToolbarButton.getTag())) {
        localToolbarButton.setImageResource(paramInt);
      }
    }
  }
  
  public void b()
  {
    setVisibility(4);
  }
  
  public void c()
  {
    setVisibility(0);
  }
  
  public void onClick(View paramView)
  {
    a((String)paramView.getTag());
  }
  
  public void setToolBarListener(blpp paramblpp)
  {
    this.jdField_a_of_type_Blpp = paramblpp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.toolbar.AEEditorToolBar
 * JD-Core Version:    0.7.0.1
 */