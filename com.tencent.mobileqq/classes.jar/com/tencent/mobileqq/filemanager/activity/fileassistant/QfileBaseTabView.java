package com.tencent.mobileqq.filemanager.activity.fileassistant;

import ajjp;
import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import atdd;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanageraux.data.WeiYunFileInfo;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.Set;
import mqq.os.MqqHandler;

public class QfileBaseTabView
  extends RelativeLayout
  implements ajjp, atdd
{
  View a;
  public QQAppInterface a;
  public BaseFileAssistantActivity a;
  protected Runnable a;
  public int d;
  public boolean d;
  boolean e = true;
  
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
    this.jdField_d_of_type_Boolean = true;
    this.jdField_d_of_type_Int = -1;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity = ((BaseFileAssistantActivity)paramContext);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.app;
  }
  
  public int a()
  {
    return 0;
  }
  
  public View a()
  {
    return null;
  }
  
  public BaseFileAssistantActivity a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity;
  }
  
  public ListView a()
  {
    return null;
  }
  
  public void a(FileInfo paramFileInfo) {}
  
  public void a(FileManagerEntity paramFileManagerEntity) {}
  
  public void a(Runnable paramRunnable)
  {
    a().runOnUiThread(paramRunnable);
  }
  
  public void a(ArrayList<FileManagerEntity> paramArrayList) {}
  
  public void a(Set<FileInfo> paramSet) {}
  
  public boolean a(FileInfo paramFileInfo)
  {
    return false;
  }
  
  public boolean a(FileManagerEntity paramFileManagerEntity)
  {
    return false;
  }
  
  public int[] a()
  {
    return null;
  }
  
  public void ap_() {}
  
  public void b() {}
  
  public void b(ArrayList<WeiYunFileInfo> paramArrayList) {}
  
  public boolean b(WeiYunFileInfo paramWeiYunFileInfo)
  {
    return false;
  }
  
  public void c() {}
  
  public void c(ArrayList<FileManagerEntity> paramArrayList) {}
  
  public boolean c()
  {
    return this.e;
  }
  
  public int d()
  {
    return this.jdField_d_of_type_Int;
  }
  
  public void d() {}
  
  protected void d(int paramInt)
  {
    this.jdField_a_of_type_AndroidViewView = ((LayoutInflater)this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getSystemService("layout_inflater")).inflate(paramInt, null);
    this.jdField_a_of_type_AndroidViewView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
    addView(this.jdField_a_of_type_AndroidViewView);
  }
  
  public boolean d()
  {
    return this.jdField_a_of_type_JavaLangRunnable == null;
  }
  
  public void e() {}
  
  protected boolean e()
  {
    return a().c();
  }
  
  protected boolean f()
  {
    return a().e();
  }
  
  public boolean g()
  {
    return (f()) || (e());
  }
  
  public void i() {}
  
  public void j() {}
  
  public void m() {}
  
  public void n() {}
  
  public void s() {}
  
  public void setEditbarButton(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.a(paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4, paramBoolean5);
  }
  
  public void setExpandGroup(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
  }
  
  public void setFromWeiXin(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.i(paramBoolean);
  }
  
  public void setPos(int paramInt1, int paramInt2) {}
  
  public void setSelect(int paramInt) {}
  
  public void setSortType(int paramInt)
  {
    this.jdField_d_of_type_Int = paramInt;
  }
  
  public void t()
  {
    this.jdField_d_of_type_Boolean = false;
  }
  
  public void u()
  {
    this.e = false;
    new Handler().postDelayed(new QfileBaseTabView.1(this), 2000L);
  }
  
  public void v()
  {
    if (this.jdField_a_of_type_JavaLangRunnable != null)
    {
      ThreadManager.getFileThreadHandler().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_JavaLangRunnable = null;
    }
  }
  
  public void w()
  {
    a().l();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.fileassistant.QfileBaseTabView
 * JD-Core Version:    0.7.0.1
 */