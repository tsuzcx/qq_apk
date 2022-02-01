package dov.com.qq.im.aeeditor.module.topbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import anzj;
import bpan;
import bpkp;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.ae.view.AECompoundButton;

public class AEEditorTopBar
  extends RelativeLayout
  implements View.OnClickListener
{
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bpkp jdField_a_of_type_Bpkp;
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
    this.jdField_a_of_type_Boolean = bpan.a();
    paramContext = View.inflate(paramContext, 2131558564, this);
    this.jdField_a_of_type_DovComQqImAeViewAECompoundButton = ((AECompoundButton)paramContext.findViewById(2131362257));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramContext.findViewById(2131362258));
    this.b = ((TextView)paramContext.findViewById(2131362261));
    this.c = ((TextView)paramContext.findViewById(2131362259));
    this.d = ((TextView)paramContext.findViewById(2131362260));
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
      if (this.jdField_a_of_type_Bpkp != null)
      {
        this.jdField_a_of_type_Bpkp.aQ_();
        continue;
        if (this.jdField_a_of_type_Bpkp != null) {
          this.jdField_a_of_type_Bpkp.aR_();
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
    this.c.setText(anzj.a(2131689705));
  }
  
  public void setStyleAsCancelAndFinish()
  {
    this.jdField_a_of_type_DovComQqImAeViewAECompoundButton.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
    this.c.setVisibility(4);
    this.d.setVisibility(0);
    this.d.setText(anzj.a(2131689697));
  }
  
  public void setTitle(String paramString)
  {
    this.b.setText(paramString);
  }
  
  public void setTopBarClickListener(bpkp parambpkp)
  {
    this.jdField_a_of_type_Bpkp = parambpkp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.topbar.AEEditorTopBar
 * JD-Core Version:    0.7.0.1
 */