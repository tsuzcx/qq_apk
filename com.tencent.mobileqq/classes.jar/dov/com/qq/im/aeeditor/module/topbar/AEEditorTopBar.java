package dov.com.qq.im.aeeditor.module.topbar;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.ae.util.AEThemeUtil;
import dov.com.qq.im.ae.view.AECompoundButton;

public class AEEditorTopBar
  extends RelativeLayout
  implements View.OnClickListener
{
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private AECompoundButton jdField_a_of_type_DovComQqImAeViewAECompoundButton;
  private AEEditorTopBar.TopBarClickListener jdField_a_of_type_DovComQqImAeeditorModuleTopbarAEEditorTopBar$TopBarClickListener;
  private boolean jdField_a_of_type_Boolean = false;
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
    this.jdField_a_of_type_Boolean = AEThemeUtil.a();
    paramContext = View.inflate(paramContext, 2131558600, this);
    this.jdField_a_of_type_DovComQqImAeViewAECompoundButton = ((AECompoundButton)paramContext.findViewById(2131362288));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramContext.findViewById(2131362289));
    this.b = ((TextView)paramContext.findViewById(2131362292));
    this.c = ((TextView)paramContext.findViewById(2131362290));
    this.d = ((TextView)paramContext.findViewById(2131362291));
    this.jdField_a_of_type_DovComQqImAeViewAECompoundButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.c.setOnClickListener(this);
    this.d.setOnClickListener(this);
  }
  
  public void a()
  {
    setTitle(getResources().getString(2131689740));
    this.jdField_a_of_type_DovComQqImAeViewAECompoundButton.setVisibility(8);
    this.c.setVisibility(8);
  }
  
  public void b()
  {
    setTitle(getResources().getString(2131689734));
    this.jdField_a_of_type_DovComQqImAeViewAECompoundButton.setVisibility(0);
    this.c.setVisibility(0);
  }
  
  public void c()
  {
    this.jdField_a_of_type_DovComQqImAeViewAECompoundButton.setVisibility(0);
    this.c.setVisibility(0);
  }
  
  public void d()
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
      if (this.jdField_a_of_type_DovComQqImAeeditorModuleTopbarAEEditorTopBar$TopBarClickListener != null)
      {
        this.jdField_a_of_type_DovComQqImAeeditorModuleTopbarAEEditorTopBar$TopBarClickListener.p();
        continue;
        if (this.jdField_a_of_type_DovComQqImAeeditorModuleTopbarAEEditorTopBar$TopBarClickListener != null) {
          this.jdField_a_of_type_DovComQqImAeeditorModuleTopbarAEEditorTopBar$TopBarClickListener.q();
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
    this.c.setText(HardCodeUtil.a(2131689755));
  }
  
  public void setStyleAsCancelAndFinish()
  {
    this.jdField_a_of_type_DovComQqImAeViewAECompoundButton.setVisibility(0);
    this.jdField_a_of_type_DovComQqImAeViewAECompoundButton.setForegroundResource(2130844214);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
    this.c.setVisibility(4);
    this.b.setText(2131689768);
    this.d.setVisibility(0);
    this.d.setText(HardCodeUtil.a(2131689737));
  }
  
  public void setTitle(String paramString)
  {
    this.b.setText(paramString);
  }
  
  public void setTopBarClickListener(AEEditorTopBar.TopBarClickListener paramTopBarClickListener)
  {
    this.jdField_a_of_type_DovComQqImAeeditorModuleTopbarAEEditorTopBar$TopBarClickListener = paramTopBarClickListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.topbar.AEEditorTopBar
 * JD-Core Version:    0.7.0.1
 */