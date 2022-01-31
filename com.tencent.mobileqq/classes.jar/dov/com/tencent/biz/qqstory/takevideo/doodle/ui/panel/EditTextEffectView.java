package dov.com.tencent.biz.qqstory.takevideo.doodle.ui.panel;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.DisplayMetrics;
import android.view.View;
import aojy;
import aojz;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.flashchat.OnHolderItemClickListener;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.QIMManager;
import dov.com.qq.im.capture.music.CaptureConfigUpdateObserver;
import dov.com.qq.im.capture.text.DynamicTextConfigManager;
import dov.com.qq.im.capture.text.DynamicTextConfigManager.DynamicTextConfigBean;
import java.util.Collection;
import java.util.List;
import java.util.Vector;
import mqq.app.AppRuntime;

public class EditTextEffectView
  extends RecyclerView
  implements Handler.Callback
{
  public static int b;
  public static int c;
  public static final int d;
  public static final int e;
  int jdField_a_of_type_Int = -1;
  public Handler a;
  public StaggeredGridLayoutManager a;
  OnHolderItemClickListener jdField_a_of_type_ComTencentMobileqqFlashchatOnHolderItemClickListener;
  CaptureConfigUpdateObserver jdField_a_of_type_DovComQqImCaptureMusicCaptureConfigUpdateObserver = new aojy(this);
  EditTextEffectView.EditTextAdapter jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiPanelEditTextEffectView$EditTextAdapter = null;
  public Vector a;
  
  static
  {
    float f = FontSettingManager.a() / 16.0F;
    Resources localResources = BaseApplicationImpl.sApplication.getResources();
    b = (int)(AIOUtils.a(100.0F, localResources) / f + 0.5F);
    c = (int)(AIOUtils.a(100.0F, localResources) / f + 0.5F);
    d = (localResources.getDisplayMetrics().widthPixels - (int)(AIOUtils.a(20.0F, localResources) / f + 0.5F) - b * 3) / 2;
    e = (int)(AIOUtils.a(5.0F, localResources) / f + 0.5F);
  }
  
  public EditTextEffectView(Context paramContext, OnHolderItemClickListener paramOnHolderItemClickListener)
  {
    super(paramContext);
    this.jdField_a_of_type_JavaUtilVector = new Vector();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this);
    this.jdField_a_of_type_ComTencentMobileqqFlashchatOnHolderItemClickListener = paramOnHolderItemClickListener;
    setClipToPadding(false);
    b();
    a();
  }
  
  public int a(int paramInt)
  {
    if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiPanelEditTextEffectView$EditTextAdapter != null) && (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiPanelEditTextEffectView$EditTextAdapter.a != null))
    {
      int j = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiPanelEditTextEffectView$EditTextAdapter.a.size();
      int i = 0;
      while (i < j)
      {
        if (((DynamicTextConfigManager.DynamicTextConfigBean)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiPanelEditTextEffectView$EditTextAdapter.a.get(i)).text_id == paramInt) {
          return i;
        }
        i += 1;
      }
    }
    return -1;
  }
  
  public DynamicTextConfigManager.DynamicTextConfigBean a(int paramInt)
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiPanelEditTextEffectView$EditTextAdapter.a == null) {
      return null;
    }
    return (DynamicTextConfigManager.DynamicTextConfigBean)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiPanelEditTextEffectView$EditTextAdapter.a.get(paramInt);
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EditTextEffectView", 2, "loadData");
    }
    Object localObject = (DynamicTextConfigManager)QIMManager.a(7);
    if (!((DynamicTextConfigManager)localObject).a()) {
      ((DynamicTextConfigManager)localObject).c();
    }
    this.jdField_a_of_type_JavaUtilVector.clear();
    localObject = ((DynamicTextConfigManager)localObject).a();
    localObject = ((List)localObject).subList(0, Math.min(((List)localObject).size(), 20));
    this.jdField_a_of_type_JavaUtilVector.addAll((Collection)localObject);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiPanelEditTextEffectView$EditTextAdapter.a(this.jdField_a_of_type_JavaUtilVector);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiPanelEditTextEffectView$EditTextAdapter.notifyDataSetChanged();
  }
  
  public void a(int paramInt)
  {
    if (paramInt == -1) {
      return;
    }
    if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiPanelEditTextEffectView$EditTextAdapter.a != null) && (paramInt < this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiPanelEditTextEffectView$EditTextAdapter.a.size()))
    {
      this.jdField_a_of_type_Int = ((DynamicTextConfigManager.DynamicTextConfigBean)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiPanelEditTextEffectView$EditTextAdapter.a.get(paramInt)).text_id;
      int j = this.jdField_a_of_type_AndroidSupportV7WidgetStaggeredGridLayoutManager.getChildCount();
      int i = 0;
      label65:
      aojz localaojz;
      if (i < j)
      {
        localaojz = (aojz)getChildViewHolder(this.jdField_a_of_type_AndroidSupportV7WidgetStaggeredGridLayoutManager.getChildAt(i));
        if (localaojz.jdField_a_of_type_Int == paramInt) {
          break label109;
        }
        localaojz.b(false);
      }
      for (;;)
      {
        i += 1;
        break label65;
        break;
        label109:
        localaojz.b(true);
      }
    }
    QLog.e("EditTextEffectView", 1, "select position = " + paramInt + " no item");
  }
  
  @TargetApi(9)
  public void b()
  {
    setOverScrollMode(2);
    this.jdField_a_of_type_AndroidSupportV7WidgetStaggeredGridLayoutManager = new StaggeredGridLayoutManager(3, 1);
    setLayoutManager(this.jdField_a_of_type_AndroidSupportV7WidgetStaggeredGridLayoutManager);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiPanelEditTextEffectView$EditTextAdapter = new EditTextEffectView.EditTextAdapter(this, this.jdField_a_of_type_ComTencentMobileqqFlashchatOnHolderItemClickListener);
    setAdapter(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiPanelEditTextEffectView$EditTextAdapter);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      a();
    }
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().waitAppRuntime(null);
    this.jdField_a_of_type_DovComQqImCaptureMusicCaptureConfigUpdateObserver = new CaptureConfigUpdateObserver();
    localAppRuntime.registObserver(this.jdField_a_of_type_DovComQqImCaptureMusicCaptureConfigUpdateObserver);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    BaseApplicationImpl.getApplication().waitAppRuntime(null).unRegistObserver(this.jdField_a_of_type_DovComQqImCaptureMusicCaptureConfigUpdateObserver);
  }
  
  protected void onVisibilityChanged(View paramView, int paramInt)
  {
    if (paramInt == 0) {
      if (QLog.isColorLevel()) {
        QLog.d("EditTextEffectView", 2, "exittext panel visible");
      }
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("EditTextEffectView", 2, "exittext panel gone");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.ui.panel.EditTextEffectView
 * JD-Core Version:    0.7.0.1
 */