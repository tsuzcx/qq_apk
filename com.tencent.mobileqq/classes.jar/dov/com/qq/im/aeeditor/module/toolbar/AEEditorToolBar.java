package dov.com.qq.im.aeeditor.module.toolbar;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import bhtq;
import bozz;
import bpkk;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.ae.view.AECompoundButton;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class AEEditorToolBar
  extends LinearLayout
  implements View.OnClickListener
{
  private static final String jdField_a_of_type_JavaLangString = AEEditorToolBar.class.getSimpleName();
  protected bpkk a;
  private List<AECompoundButton> jdField_a_of_type_JavaUtilList = new ArrayList();
  
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
  
  protected void a(int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    AECompoundButton localAECompoundButton = new AECompoundButton(getContext());
    localAECompoundButton.setTag(paramString);
    localAECompoundButton.setOnClickListener(this);
    localAECompoundButton.setBackgroundResource(paramInt3);
    localAECompoundButton.setForegroundResource(paramInt2);
    localAECompoundButton.setForegroundSize(bhtq.a(32.0F), bhtq.a(32.0F));
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    localLayoutParams.width = bhtq.a(56.0F);
    localLayoutParams.height = bhtq.a(56.0F);
    if ((a(paramString)) && (!b(paramString))) {
      localAECompoundButton.addView(LayoutInflater.from(getContext()).inflate(2131558560, localAECompoundButton, false));
    }
    addView(localAECompoundButton, paramInt1, localLayoutParams);
    this.jdField_a_of_type_JavaUtilList.add(paramInt1, localAECompoundButton);
  }
  
  abstract void a(String paramString);
  
  public void a(String paramString, int paramInt)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      AECompoundButton localAECompoundButton = (AECompoundButton)localIterator.next();
      if (paramString.equals(localAECompoundButton.getTag())) {
        localAECompoundButton.setForegroundResource(paramInt);
      }
    }
  }
  
  protected boolean a(String paramString)
  {
    return false;
  }
  
  public void b()
  {
    setVisibility(4);
  }
  
  public void b(String paramString)
  {
    paramString = findViewById(2131376739);
    if (paramString != null) {
      paramString.setVisibility(8);
    }
  }
  
  protected boolean b(String paramString)
  {
    return bozz.a().a("ae_editor_tool_bar_red_dot_" + paramString, false, 0);
  }
  
  public void c()
  {
    setVisibility(0);
  }
  
  public void onClick(View paramView)
  {
    a((String)paramView.getTag());
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void setToolBarListener(bpkk parambpkk)
  {
    this.jdField_a_of_type_Bpkk = parambpkk;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.toolbar.AEEditorToolBar
 * JD-Core Version:    0.7.0.1
 */