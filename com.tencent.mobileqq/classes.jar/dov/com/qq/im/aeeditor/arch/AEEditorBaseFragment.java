package dov.com.qq.im.aeeditor.arch;

import android.app.Dialog;
import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.Lifecycle.Event;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.LifecycleRegistry;
import android.arch.lifecycle.ViewModelStore;
import android.arch.lifecycle.ViewModelStoreOwner;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.aeeditor.AEEditorActivity;
import dov.com.qq.im.aeeditor.AEEditorModuleManager;
import dov.com.qq.im.aeeditor.view.ProgressView;
import org.jetbrains.annotations.NotNull;

public abstract class AEEditorBaseFragment
  extends PublicBaseFragment
  implements LifecycleOwner, ViewModelStoreOwner, IAEEditorModule
{
  protected Dialog a;
  private final LifecycleRegistry jdField_a_of_type_AndroidArchLifecycleLifecycleRegistry = new LifecycleRegistry(this);
  private ViewModelStore jdField_a_of_type_AndroidArchLifecycleViewModelStore;
  protected Handler a;
  private AEEditorModuleManager jdField_a_of_type_DovComQqImAeeditorAEEditorModuleManager;
  protected ProgressView a;
  public String a;
  
  public AEEditorBaseFragment()
  {
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  }
  
  private void a(Lifecycle.Event paramEvent)
  {
    try
    {
      this.jdField_a_of_type_AndroidArchLifecycleLifecycleRegistry.handleLifecycleEvent(paramEvent);
      return;
    }
    catch (Throwable paramEvent)
    {
      QLog.e("AEEditorBaseFragment", 1, "mLifecycleRegistry 初始化失败");
    }
  }
  
  @NonNull
  public AEEditorModuleManager a()
  {
    if (this.jdField_a_of_type_DovComQqImAeeditorAEEditorModuleManager == null) {
      throw new RuntimeException("moduleManager not set");
    }
    return this.jdField_a_of_type_DovComQqImAeeditorAEEditorModuleManager;
  }
  
  public abstract String a();
  
  public void a() {}
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void a(AEEditorModuleManager paramAEEditorModuleManager)
  {
    this.jdField_a_of_type_DovComQqImAeeditorAEEditorModuleManager = paramAEEditorModuleManager;
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
  
  @NotNull
  public Lifecycle getLifecycle()
  {
    return this.jdField_a_of_type_AndroidArchLifecycleLifecycleRegistry;
  }
  
  @NonNull
  public ViewModelStore getViewModelStore()
  {
    if (BaseApplicationImpl.getApplication() == null) {
      throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
    }
    if (this.jdField_a_of_type_AndroidArchLifecycleViewModelStore == null) {
      this.jdField_a_of_type_AndroidArchLifecycleViewModelStore = new ViewModelStore();
    }
    return this.jdField_a_of_type_AndroidArchLifecycleViewModelStore;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    a(Lifecycle.Event.ON_CREATE);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    a(Lifecycle.Event.ON_DESTROY);
  }
  
  public void onPause()
  {
    super.onPause();
    a(Lifecycle.Event.ON_PAUSE);
  }
  
  public void onResume()
  {
    super.onResume();
    a(Lifecycle.Event.ON_RESUME);
    if ((this.jdField_a_of_type_DovComQqImAeeditorAEEditorModuleManager == null) && (getActivity() != null) && ((getActivity() instanceof AEEditorActivity))) {
      this.jdField_a_of_type_DovComQqImAeeditorAEEditorModuleManager = ((AEEditorActivity)getActivity()).a();
    }
  }
  
  public void onStart()
  {
    super.onStart();
    a(Lifecycle.Event.ON_START);
  }
  
  public void onStop()
  {
    super.onStop();
    a(Lifecycle.Event.ON_STOP);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.arch.AEEditorBaseFragment
 * JD-Core Version:    0.7.0.1
 */