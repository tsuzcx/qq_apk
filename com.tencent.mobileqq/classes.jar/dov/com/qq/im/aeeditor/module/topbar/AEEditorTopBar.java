package dov.com.qq.im.aeeditor.module.topbar;

import amtj;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import bmby;
import bmnl;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.ae.view.AECompoundButton;

public class AEEditorTopBar
  extends RelativeLayout
  implements View.OnClickListener
{
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bmnl jdField_a_of_type_Bmnl;
  private AECompoundButton jdField_a_of_type_DovComQqImAeViewAECompoundButton;
  private boolean jdField_a_of_type_Boolean;
  private TextView b;
  private TextView c;
  private TextView d;
  
  public AEEditorTopBar(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public AEEditorTopBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public AEEditorTopBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    this.jdField_a_of_type_Boolean = bmby.a();
    paramContext = View.inflate(paramContext, 2131558566, this);
    this.jdField_a_of_type_DovComQqImAeViewAECompoundButton = ((AECompoundButton)paramContext.findViewById(2131362260));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramContext.findViewById(2131362261));
    this.b = ((TextView)paramContext.findViewById(2131362264));
    this.c = ((TextView)paramContext.findViewById(2131362262));
    this.d = ((TextView)paramContext.findViewById(2131362263));
    this.jdField_a_of_type_DovComQqImAeViewAECompoundButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.c.setOnClickListener(this);
    this.d.setOnClickListener(this);
  }
  
  public void a()
  {
    this.jdField_a_of_type_DovComQqImAeViewAECompoundButton.setVisibility(0);
    this.c.setVisibility(0);
  }
  
  public void b()
  {
    this.jdField_a_of_type_DovComQqImAeViewAECompoundButton.setVisibility(4);
    this.c.setVisibility(4);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.jdField_a_of_type_Bmnl != null)
      {
        this.jdField_a_of_type_Bmnl.aB_();
        continue;
        if (this.jdField_a_of_type_Bmnl != null) {
          this.jdField_a_of_type_Bmnl.aC_();
        }
      }
    }
  }
  
  public void setLeftButtonAsBackArray()
  {
    this.jdField_a_of_type_DovComQqImAeViewAECompoundButton.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
    this.c.setVisibility(0);
    this.d.setVisibility(4);
    this.c.setText(amtj.a(2131689715));
  }
  
  public void setStyleAsCancelAndFinish()
  {
    this.jdField_a_of_type_DovComQqImAeViewAECompoundButton.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
    this.c.setVisibility(4);
    this.d.setVisibility(0);
    this.d.setText(amtj.a(2131689707));
  }
  
  public void setTitle(String paramString)
  {
    this.b.setText(paramString);
  }
  
  public void setTopBarClickListener(bmnl parambmnl)
  {
    this.jdField_a_of_type_Bmnl = parambmnl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.topbar.AEEditorTopBar
 * JD-Core Version:    0.7.0.1
 */