package dov.com.tencent.biz.qqstory.takevideo.interact;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.widget.FitSystemWindowsRelativeLayout;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import dov.com.tencent.biz.qqstory.takevideo.doodle.util.DisplayUtil;

public class InteractPasterEditDialog
  extends Dialog
  implements View.OnClickListener, InteractPasterItem.InteractPasterEditListener
{
  private int jdField_a_of_type_Int;
  private View jdField_a_of_type_AndroidViewView;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private FitSystemWindowsRelativeLayout jdField_a_of_type_ComTencentWidgetFitSystemWindowsRelativeLayout;
  private EditVideoInteract jdField_a_of_type_DovComTencentBizQqstoryTakevideoInteractEditVideoInteract;
  private InteractPasterItem.InteractPasterInfo jdField_a_of_type_DovComTencentBizQqstoryTakevideoInteractInteractPasterItem$InteractPasterInfo;
  private InteractPasterItem jdField_a_of_type_DovComTencentBizQqstoryTakevideoInteractInteractPasterItem;
  
  public InteractPasterEditDialog(@NonNull Context paramContext, @NonNull EditVideoInteract paramEditVideoInteract, int paramInt)
  {
    super(paramContext, 2131624201);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoInteractEditVideoInteract = paramEditVideoInteract;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  private void b()
  {
    Object localObject = super.getWindow();
    WindowManager.LayoutParams localLayoutParams = ((Window)localObject).getAttributes();
    localLayoutParams.width = -1;
    localLayoutParams.height = DisplayUtil.b(getContext());
    localLayoutParams.flags |= 0x20;
    localLayoutParams.gravity = 80;
    ((Window)localObject).setAttributes(localLayoutParams);
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      getWindow().addFlags(67108864);
      localObject = new SystemBarCompact(this, true, getContext().getResources().getColor(17170445));
      ((SystemBarCompact)localObject).setStatusBarDrawable(null);
      ((SystemBarCompact)localObject).init();
    }
    setCanceledOnTouchOutside(true);
  }
  
  private void c()
  {
    this.jdField_a_of_type_ComTencentWidgetFitSystemWindowsRelativeLayout = ((FitSystemWindowsRelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131364404));
    this.jdField_a_of_type_ComTencentWidgetFitSystemWindowsRelativeLayout.setFitsSystemWindows(true);
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131372175));
    this.jdField_a_of_type_AndroidViewView.findViewById(2131371833).setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.jdField_a_of_type_AndroidViewView.findViewById(2131372174));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131372173));
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoInteractInteractPasterItem = InteractPasterItem.a(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoInteractInteractPasterItem.a(getContext(), this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoInteractInteractPasterItem$InteractPasterInfo, this.jdField_a_of_type_AndroidWidgetEditText, this.jdField_a_of_type_AndroidWidgetTextView, this);
    View localView = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoInteractInteractPasterItem.a();
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    localLayoutParams.gravity = 17;
    localView.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(localView);
  }
  
  public void a()
  {
    dismiss();
  }
  
  public void a(InteractPasterItem.InteractPasterInfo paramInteractPasterInfo)
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoInteractInteractPasterItem$InteractPasterInfo = paramInteractPasterInfo;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    dismiss();
  }
  
  public void onDetachedFromWindow()
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoInteractInteractPasterItem.a();
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoInteractEditVideoInteract.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoInteractInteractPasterItem.a());
    super.onDetachedFromWindow();
  }
  
  public void setContentView(int paramInt)
  {
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(getContext()).inflate(2130970920, null);
    b();
    c();
    super.setContentView(this.jdField_a_of_type_AndroidViewView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.interact.InteractPasterEditDialog
 * JD-Core Version:    0.7.0.1
 */