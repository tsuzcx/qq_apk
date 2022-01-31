package com.tencent.mobileqq.filemanager.activity.fileassistant;

import acqn;
import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.activity.FMActivity;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.WeiYunFileInfo;
import java.util.ArrayList;
import mqq.os.MqqHandler;

public class QfileBaseTabView
  extends RelativeLayout
  implements IBaseTabViewEvent
{
  View a;
  public QQAppInterface a;
  public FMActivity a;
  public Runnable a;
  public boolean d = true;
  public boolean e = true;
  
  public QfileBaseTabView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public QfileBaseTabView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public QfileBaseTabView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity = ((FMActivity)paramContext);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.app;
  }
  
  public int a()
  {
    return 0;
  }
  
  public BaseFileAssistantActivity a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_AndroidViewView = ((LayoutInflater)this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.getSystemService("layout_inflater")).inflate(paramInt, null);
    this.jdField_a_of_type_AndroidViewView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
    addView(this.jdField_a_of_type_AndroidViewView);
  }
  
  public void a(FileInfo paramFileInfo) {}
  
  public void a(FileManagerEntity paramFileManagerEntity) {}
  
  public void a(Runnable paramRunnable)
  {
    a().runOnUiThread(paramRunnable);
  }
  
  public void a(ArrayList paramArrayList) {}
  
  public boolean a(FileInfo paramFileInfo)
  {
    return false;
  }
  
  public boolean a(FileManagerEntity paramFileManagerEntity)
  {
    return false;
  }
  
  public void b() {}
  
  public void b(ArrayList paramArrayList) {}
  
  public boolean b()
  {
    return this.e;
  }
  
  public boolean b(WeiYunFileInfo paramWeiYunFileInfo)
  {
    return false;
  }
  
  public void c() {}
  
  public void c(ArrayList paramArrayList) {}
  
  public boolean c()
  {
    return this.jdField_a_of_type_JavaLangRunnable == null;
  }
  
  public void d(ArrayList paramArrayList) {}
  
  protected boolean d()
  {
    return a().c();
  }
  
  protected boolean e()
  {
    return a().e();
  }
  
  public boolean f()
  {
    return (e()) || (d());
  }
  
  public void i() {}
  
  public void j() {}
  
  public void m() {}
  
  public void n() {}
  
  public void p() {}
  
  public void q()
  {
    this.d = false;
  }
  
  public void r() {}
  
  public void s() {}
  
  public void setEditbarButton(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.a(paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4, paramBoolean5);
  }
  
  public void setExpandGroup(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  public void setPos(int paramInt1, int paramInt2) {}
  
  public void setSelect(int paramInt) {}
  
  public void t()
  {
    this.e = false;
    new Handler().postDelayed(new acqn(this), 2000L);
  }
  
  public void u()
  {
    if (this.jdField_a_of_type_JavaLangRunnable != null)
    {
      ThreadManager.getFileThreadHandler().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_JavaLangRunnable = null;
    }
  }
  
  public void v()
  {
    a().k();
  }
  
  public void w() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.fileassistant.QfileBaseTabView
 * JD-Core Version:    0.7.0.1
 */