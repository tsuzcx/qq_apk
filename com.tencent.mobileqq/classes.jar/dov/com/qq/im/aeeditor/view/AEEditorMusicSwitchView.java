package dov.com.qq.im.aeeditor.view;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import bodm;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class AEEditorMusicSwitchView
  extends FrameLayout
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int = 0;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bodm jdField_a_of_type_Bodm;
  private TextView b;
  
  public AEEditorMusicSwitchView(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AEEditorMusicSwitchView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public AEEditorMusicSwitchView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    b(paramInt);
    c(paramInt);
    if (this.jdField_a_of_type_Bodm != null) {
      this.jdField_a_of_type_Bodm.a(paramInt);
    }
  }
  
  private void a(@NonNull Context paramContext)
  {
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(paramContext).inflate(2131558571, this, true);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131380065));
    this.b = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131379796));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369547));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.b.setOnClickListener(this);
    b(this.jdField_a_of_type_Int);
  }
  
  private void b(int paramInt)
  {
    if (paramInt == 0)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16777216);
      this.b.setTextColor(Color.parseColor("#9699A5"));
    }
    while (paramInt != 1) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#9699A5"));
    this.b.setTextColor(-16777216);
  }
  
  private void c(int paramInt)
  {
    if (paramInt == 0) {
      this.jdField_a_of_type_AndroidWidgetImageView.setTranslationX(0.0F);
    }
    while (paramInt != 1) {
      return;
    }
    paramInt = getMeasuredWidth();
    int i = this.jdField_a_of_type_AndroidWidgetImageView.getMeasuredWidth();
    this.jdField_a_of_type_AndroidWidgetImageView.setTranslationX(paramInt - i);
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == 2131380065) {
      if (this.jdField_a_of_type_Int != 0) {}
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      a(0);
      continue;
      if ((i == 2131379796) && (this.jdField_a_of_type_Int != 1)) {
        a(1);
      }
    }
  }
  
  public void setSwitchClickListener(@Nullable bodm parambodm)
  {
    this.jdField_a_of_type_Bodm = parambodm;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.view.AEEditorMusicSwitchView
 * JD-Core Version:    0.7.0.1
 */