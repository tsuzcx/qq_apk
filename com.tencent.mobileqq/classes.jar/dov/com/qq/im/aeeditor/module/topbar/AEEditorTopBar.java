package dov.com.qq.im.aeeditor.module.topbar;

import alpo;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import bllj;

public class AEEditorTopBar
  extends RelativeLayout
  implements View.OnClickListener
{
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bllj jdField_a_of_type_Bllj;
  private TextView b;
  private TextView c;
  
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
    paramContext = View.inflate(paramContext, 2131558538, this);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramContext.findViewById(2131362178));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramContext.findViewById(2131362179));
    this.b = ((TextView)paramContext.findViewById(2131362181));
    this.c = ((TextView)paramContext.findViewById(2131362180));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.c.setOnClickListener(this);
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.c.setVisibility(0);
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
    this.c.setVisibility(4);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_Bllj == null);
      this.jdField_a_of_type_Bllj.aV_();
      return;
    } while (this.jdField_a_of_type_Bllj == null);
    this.jdField_a_of_type_Bllj.aW_();
  }
  
  public void setLeftButtonAsBackArray()
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
    this.c.setText(alpo.a(2131689803));
  }
  
  public void setStyleAsCancelAndFinish()
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.c.setText(alpo.a(2131689800));
  }
  
  public void setTitle(String paramString)
  {
    this.b.setText(paramString);
  }
  
  public void setTopBarClickListener(bllj parambllj)
  {
    this.jdField_a_of_type_Bllj = parambllj;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.topbar.AEEditorTopBar
 * JD-Core Version:    0.7.0.1
 */