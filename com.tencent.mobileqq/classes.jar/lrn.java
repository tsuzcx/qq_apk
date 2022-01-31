import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.VideoControlUI;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class lrn
{
  Resources jdField_a_of_type_AndroidContentResResources = null;
  ViewGroup jdField_a_of_type_AndroidViewViewGroup = null;
  Button jdField_a_of_type_AndroidWidgetButton = null;
  VideoController jdField_a_of_type_ComTencentAvVideoController = null;
  VideoAppInterface jdField_a_of_type_ComTencentAvAppVideoAppInterface = null;
  VideoControlUI jdField_a_of_type_ComTencentAvUiVideoControlUI;
  WeakReference<Context> jdField_a_of_type_JavaLangRefWeakReference = null;
  boolean jdField_a_of_type_Boolean = false;
  
  lrn(VideoAppInterface paramVideoAppInterface, AVActivity paramAVActivity, VideoControlUI paramVideoControlUI, ViewGroup paramViewGroup)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("ChildGuideUi", 2, "ChildGuideUi");
    }
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramAVActivity);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
    this.jdField_a_of_type_ComTencentAvUiVideoControlUI = paramVideoControlUI;
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
    this.jdField_a_of_type_ComTencentAvVideoController = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
  }
  
  void a()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("ChildGuideUi", 2, "initUI");
    }
    if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null))
    {
      AVActivity localAVActivity = (AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localAVActivity != null)
      {
        localAVActivity.getLayoutInflater().inflate(2131493931, this.jdField_a_of_type_AndroidViewViewGroup);
        this.jdField_a_of_type_AndroidContentResResources = localAVActivity.getResources();
      }
    }
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131306530));
  }
  
  public void a(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    b();
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void b()
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = null;
    this.jdField_a_of_type_ComTencentAvVideoController = null;
    this.jdField_a_of_type_AndroidViewViewGroup = null;
    this.jdField_a_of_type_AndroidContentResResources = null;
    this.jdField_a_of_type_AndroidWidgetButton = null;
  }
  
  public boolean b()
  {
    f();
    return true;
  }
  
  public void c() {}
  
  boolean c()
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getContext().getSharedPreferences("com.tencent.av.count", 0);
    String str = "DoubleVideoChildLock_ShowGuide";
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
      str = "DoubleVideoChildLock_ShowGuide" + this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin();
    }
    if (localSharedPreferences.getInt(str, 0) == 0)
    {
      localSharedPreferences.edit().putInt(str, 1).commit();
      return true;
    }
    return false;
  }
  
  public void d() {}
  
  void e()
  {
    if ((this.jdField_a_of_type_AndroidContentResResources == null) || (this.jdField_a_of_type_AndroidWidgetButton == null)) {
      a();
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentAvUiVideoControlUI.I();
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
  }
  
  void f()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentAvUiVideoControlUI.J();
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lrn
 * JD-Core Version:    0.7.0.1
 */