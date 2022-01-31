package dov.com.qq.im.aeeditor.arch;

import android.app.Dialog;
import android.content.DialogInterface.OnDismissListener;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import bljy;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.widget.immersive.SystemBarCompact;
import dov.com.qq.im.aeeditor.view.ProgressView;

public abstract class AEEditorBaseFragment
  extends PublicBaseFragment
{
  private static final String b = AEEditorBaseFragment.class.getSimpleName();
  protected Dialog a;
  protected Handler a;
  private bljy a;
  protected ProgressView a;
  public String a;
  
  public AEEditorBaseFragment()
  {
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  }
  
  @NonNull
  public bljy a()
  {
    if (this.jdField_a_of_type_Bljy == null) {
      throw new RuntimeException("moduleManager not set");
    }
    return this.jdField_a_of_type_Bljy;
  }
  
  public abstract String a();
  
  public void a() {}
  
  protected void a(int paramInt)
  {
    if (getActivity().mSystemBarComp != null) {
      getActivity().mSystemBarComp.setStatusBarColor(getResources().getColor(paramInt));
    }
  }
  
  public void a(bljy parambljy)
  {
    this.jdField_a_of_type_Bljy = parambljy;
  }
  
  public void a(CharSequence paramCharSequence, boolean paramBoolean, long paramLong, DialogInterface.OnDismissListener paramOnDismissListener)
  {
    if (getActivity() == null) {
      return;
    }
    FragmentActivity localFragmentActivity = getActivity();
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new AEEditorBaseFragment.1(this, localFragmentActivity, paramOnDismissListener, paramBoolean, paramCharSequence), paramLong);
  }
  
  public boolean a()
  {
    return false;
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_AndroidOsHandler.post(new AEEditorBaseFragment.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.arch.AEEditorBaseFragment
 * JD-Core Version:    0.7.0.1
 */