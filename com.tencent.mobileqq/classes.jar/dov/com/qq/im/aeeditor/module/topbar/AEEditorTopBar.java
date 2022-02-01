package dov.com.qq.im.aeeditor.module.topbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import anvx;
import bnri;
import bodd;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.ae.view.AECompoundButton;

public class AEEditorTopBar
  extends RelativeLayout
  implements View.OnClickListener
{
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bodd jdField_a_of_type_Bodd;
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
    this.jdField_a_of_type_Boolean = bnri.a();
    paramContext = View.inflate(paramContext, 2131558577, this);
    this.jdField_a_of_type_DovComQqImAeViewAECompoundButton = ((AECompoundButton)paramContext.findViewById(2131362265));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramContext.findViewById(2131362266));
    this.b = ((TextView)paramContext.findViewById(2131362269));
    this.c = ((TextView)paramContext.findViewById(2131362267));
    this.d = ((TextView)paramContext.findViewById(2131362268));
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
      if (this.jdField_a_of_type_Bodd != null)
      {
        this.jdField_a_of_type_Bodd.aD_();
        continue;
        if (this.jdField_a_of_type_Bodd != null) {
          this.jdField_a_of_type_Bodd.aE_();
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
    this.c.setText(anvx.a(2131689723));
  }
  
  public void setStyleAsCancelAndFinish()
  {
    this.jdField_a_of_type_DovComQqImAeViewAECompoundButton.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
    this.c.setVisibility(4);
    this.d.setVisibility(0);
    this.d.setText(anvx.a(2131689715));
  }
  
  public void setTitle(String paramString)
  {
    this.b.setText(paramString);
  }
  
  public void setTopBarClickListener(bodd parambodd)
  {
    this.jdField_a_of_type_Bodd = parambodd;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.topbar.AEEditorTopBar
 * JD-Core Version:    0.7.0.1
 */