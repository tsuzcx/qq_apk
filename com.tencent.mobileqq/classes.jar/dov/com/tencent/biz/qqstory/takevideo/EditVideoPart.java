package dov.com.tencent.biz.qqstory.takevideo;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Message;
import android.support.annotation.NonNull;
import android.view.View;
import com.tencent.mobileqq.richmedia.mediacodec.utils.ShortVideoExceptionReporter;
import com.tribe.async.dispatch.IEventReceiver;
import dov.com.qq.im.capture.QIMManager;
import dov.com.qq.im.capture.data.CaptureComboManager;
import dov.com.tencent.biz.qqstory.takevideo.publish.GenerateContext;

public abstract class EditVideoPart
  implements IEventReceiver
{
  @NonNull
  public final EditVideoPartManager a;
  public EditVideoUi a;
  public long c;
  
  public EditVideoPart(@NonNull EditVideoPartManager paramEditVideoPartManager)
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager = paramEditVideoPartManager;
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi == null) {
      ShortVideoExceptionReporter.a(new IllegalStateException("have not attached ui"));
    }
  }
  
  @NonNull
  public Context a()
  {
    c();
    return this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.a();
  }
  
  @NonNull
  public Resources a()
  {
    c();
    return this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.a().getResources();
  }
  
  @NonNull
  public View a(int paramInt)
  {
    c();
    View localView = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.a().findViewById(paramInt);
    if (localView == null) {
      throw new IllegalArgumentException("can not find view by id " + paramInt);
    }
    return localView;
  }
  
  public EditVideoPart.EditExport a(Class paramClass)
  {
    c();
    return this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(paramClass);
  }
  
  @NonNull
  public EditVideoUi a()
  {
    c();
    return this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi;
  }
  
  public void a()
  {
    c();
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    c();
  }
  
  public void a(int paramInt1, int paramInt2, Object paramObject)
  {
    a_(paramInt2, paramObject);
  }
  
  public void a(int paramInt, @NonNull GenerateContext paramGenerateContext)
  {
    a(paramGenerateContext);
  }
  
  public void a(Bundle paramBundle)
  {
    c();
  }
  
  public void a(EditVideoUi paramEditVideoUi)
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi != null) {
      throw new IllegalStateException("attach context duplicate");
    }
    if (paramEditVideoUi == null) {
      throw new IllegalArgumentException("ui should not be null");
    }
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi = paramEditVideoUi;
  }
  
  @Deprecated
  public void a(@NonNull GenerateContext paramGenerateContext) {}
  
  public void a(Class paramClass, EditVideoPart.EditExport paramEditExport)
  {
    c();
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(paramClass, paramEditExport);
  }
  
  public void a(@NonNull Error paramError) {}
  
  public boolean a()
  {
    c();
    return false;
  }
  
  public boolean a(Message paramMessage)
  {
    return false;
  }
  
  public void aB_()
  {
    c();
  }
  
  public void aE_()
  {
    c();
  }
  
  public void aF_()
  {
    c();
  }
  
  public void a_(int paramInt, Object paramObject) {}
  
  public void aw_() {}
  
  public void ax_()
  {
    c();
  }
  
  public void b(Bundle paramBundle)
  {
    c();
  }
  
  public void b(@NonNull GenerateContext paramGenerateContext)
  {
    ((CaptureComboManager)QIMManager.a(5)).a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.getActivity());
  }
  
  public final boolean b(@NonNull Message paramMessage)
  {
    boolean bool = a(paramMessage);
    paramMessage.recycle();
    return bool;
  }
  
  public void h()
  {
    q();
  }
  
  public void i() {}
  
  public boolean isValidate()
  {
    return this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.isValidate();
  }
  
  public void q()
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi = null;
  }
  
  public void r() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditVideoPart
 * JD-Core Version:    0.7.0.1
 */