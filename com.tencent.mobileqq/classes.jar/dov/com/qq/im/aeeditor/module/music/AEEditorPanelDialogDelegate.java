package dov.com.qq.im.aeeditor.module.music;

import android.app.Dialog;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;

public class AEEditorPanelDialogDelegate
{
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private View jdField_a_of_type_AndroidViewView;
  private AEEditorPanelDialogDelegate.DialogListener jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorPanelDialogDelegate$DialogListener;
  private boolean jdField_a_of_type_Boolean;
  
  public AEEditorPanelDialogDelegate(Dialog paramDialog, View paramView, AEEditorPanelDialogDelegate.DialogListener paramDialogListener)
  {
    this.jdField_a_of_type_AndroidAppDialog = paramDialog;
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorPanelDialogDelegate$DialogListener = paramDialogListener;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidAppDialog == null) {
      return;
    }
    if (this.jdField_a_of_type_AndroidAppDialog.getWindow() != null) {}
    for (WindowManager.LayoutParams localLayoutParams = this.jdField_a_of_type_AndroidAppDialog.getWindow().getAttributes();; localLayoutParams = null)
    {
      if (localLayoutParams != null)
      {
        localLayoutParams.gravity = 81;
        localLayoutParams.height = -1;
        localLayoutParams.width = -1;
        this.jdField_a_of_type_AndroidAppDialog.getWindow().setAttributes(localLayoutParams);
      }
      this.jdField_a_of_type_AndroidAppDialog.setCancelable(false);
      this.jdField_a_of_type_AndroidAppDialog.setCanceledOnTouchOutside(false);
      return;
    }
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_AndroidAppDialog == null) || (this.jdField_a_of_type_AndroidViewView == null)) {
      return;
    }
    if (this.jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorPanelDialogDelegate$DialogListener != null) {
      this.jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorPanelDialogDelegate$DialogListener.a();
    }
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 1.0F, 1, 0.0F);
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    AnimationSet localAnimationSet = new AnimationSet(true);
    localAnimationSet.addAnimation(localTranslateAnimation);
    localAnimationSet.addAnimation(localAlphaAnimation);
    localAnimationSet.setInterpolator(new DecelerateInterpolator());
    localAnimationSet.setDuration(200L);
    localAnimationSet.setFillAfter(true);
    this.jdField_a_of_type_AndroidViewView.startAnimation(localAnimationSet);
  }
  
  public void c()
  {
    if ((this.jdField_a_of_type_AndroidAppDialog == null) || (this.jdField_a_of_type_AndroidViewView == null)) {}
    while (this.jdField_a_of_type_Boolean) {
      return;
    }
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 0.0F, 1, 1.0F);
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    AnimationSet localAnimationSet = new AnimationSet(true);
    localAnimationSet.addAnimation(localTranslateAnimation);
    localAnimationSet.addAnimation(localAlphaAnimation);
    localAnimationSet.setInterpolator(new DecelerateInterpolator());
    localAnimationSet.setDuration(200L);
    localAnimationSet.setFillAfter(true);
    localAnimationSet.setAnimationListener(new AEEditorPanelDialogDelegate.1(this));
    this.jdField_a_of_type_AndroidViewView.startAnimation(localAnimationSet);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.music.AEEditorPanelDialogDelegate
 * JD-Core Version:    0.7.0.1
 */