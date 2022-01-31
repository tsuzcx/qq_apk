package dov.com.tencent.mobileqq.richmedia.capture.view;

import android.content.Context;
import android.os.Handler;
import android.widget.FrameLayout;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;

public abstract class ProviderView
  extends FrameLayout
{
  protected int a;
  Context a;
  protected Handler a;
  protected AppInterface a;
  protected ProviderView.ProviderViewListener a;
  protected boolean a;
  protected int b = 206;
  
  public ProviderView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper());
  }
  
  public void setAppInterface(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
  }
  
  public void setNeedTabBar(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setProviderViewListener(ProviderView.ProviderViewListener paramProviderViewListener)
  {
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewProviderView$ProviderViewListener = paramProviderViewListener;
  }
  
  public void setTabBarPosition(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.mobileqq.richmedia.capture.view.ProviderView
 * JD-Core Version:    0.7.0.1
 */