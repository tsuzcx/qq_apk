package dov.com.qq.im.aeeditor.view;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class AEEditorQcircleBubbleView
  extends RelativePopupWindow
  implements View.OnClickListener
{
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ImageView b;
  private ImageView c;
  
  public AEEditorQcircleBubbleView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    a(2131558568);
    setOutsideTouchable(true);
    setFocusable(true);
    setTouchable(true);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(paramInt, null);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362303));
    this.c = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362305));
    this.b = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362304));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362265));
    setBackgroundDrawable(new ColorDrawable(0));
    this.jdField_a_of_type_AndroidViewView.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    super.setContentView(this.jdField_a_of_type_AndroidViewView);
  }
  
  public void b(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      this.b.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      this.c.setVisibility(8);
      return;
    case 0: 
      this.b.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      this.c.setVisibility(8);
      return;
    case 1: 
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.b.setVisibility(8);
      this.c.setVisibility(8);
      return;
    }
    this.c.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.b.setVisibility(8);
  }
  
  public void c(int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramInt);
  }
  
  public void onClick(View paramView)
  {
    dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.view.AEEditorQcircleBubbleView
 * JD-Core Version:    0.7.0.1
 */