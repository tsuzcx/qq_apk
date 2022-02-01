package dov.com.qq.im.aeeditor.arch;

import android.app.Dialog;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import bmcu;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import dov.com.qq.im.aeeditor.AEEditorActivity;
import dov.com.qq.im.aeeditor.view.ProgressView;

public abstract class AEEditorBaseFragment
  extends PublicBaseFragment
{
  protected Dialog a;
  protected Handler a;
  private bmcu a;
  protected ProgressView a;
  public String a;
  
  public AEEditorBaseFragment()
  {
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  }
  
  @NonNull
  public bmcu a()
  {
    if (this.jdField_a_of_type_Bmcu == null) {
      throw new RuntimeException("moduleManager not set");
    }
    return this.jdField_a_of_type_Bmcu;
  }
  
  public abstract String a();
  
  public void a() {}
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void a(bmcu parambmcu)
  {
    this.jdField_a_of_type_Bmcu = parambmcu;
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
  
  public void onResume()
  {
    super.onResume();
    if ((this.jdField_a_of_type_Bmcu == null) && (getActivity() != null) && ((getActivity() instanceof AEEditorActivity))) {
      this.jdField_a_of_type_Bmcu = ((AEEditorActivity)getActivity()).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.arch.AEEditorBaseFragment
 * JD-Core Version:    0.7.0.1
 */