package cooperation.qqreader.view;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import azvv;
import com.tencent.widget.immersive.ImmersiveUtils;

public class FrameLoading
  extends FrameLayout
{
  public TextView a;
  public LoadingImageView a;
  
  public FrameLoading(@NonNull Context paramContext)
  {
    this(paramContext, null, 0);
  }
  
  public FrameLoading(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public FrameLoading(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    RelativeLayout localRelativeLayout = new RelativeLayout(paramContext);
    localRelativeLayout.setGravity(17);
    RelativeLayout.LayoutParams localLayoutParams1 = new RelativeLayout.LayoutParams(-1, -1);
    this.jdField_a_of_type_CooperationQqreaderViewLoadingImageView = new LoadingImageView(paramContext);
    int i = azvv.a(paramContext, 35.0F);
    RelativeLayout.LayoutParams localLayoutParams2 = new RelativeLayout.LayoutParams(i, i);
    localLayoutParams2.addRule(14);
    localRelativeLayout.addView(this.jdField_a_of_type_CooperationQqreaderViewLoadingImageView, localLayoutParams2);
    this.jdField_a_of_type_AndroidWidgetTextView = new TextView(paramContext);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(2, 16.0F);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(1426063360);
    this.jdField_a_of_type_AndroidWidgetTextView.setGravity(17);
    localLayoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
    localLayoutParams2.addRule(3, this.jdField_a_of_type_CooperationQqreaderViewLoadingImageView.getId());
    localLayoutParams2.setMargins(0, azvv.a(paramContext, 15.0F) + ImmersiveUtils.getStatusBarHeight(getContext()), 0, 0);
    localRelativeLayout.addView(this.jdField_a_of_type_AndroidWidgetTextView, localLayoutParams2);
    addView(localRelativeLayout, localLayoutParams1);
  }
  
  public void setLoadingText(int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(getResources().getString(2131651385, new Object[] { Integer.valueOf(paramInt) }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     cooperation.qqreader.view.FrameLoading
 * JD-Core Version:    0.7.0.1
 */