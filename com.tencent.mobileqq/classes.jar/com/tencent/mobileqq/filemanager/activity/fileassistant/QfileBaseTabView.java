package com.tencent.mobileqq.filemanager.activity.fileassistant;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.api.ITabViewEvent;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.widget.HeaderScrollHelper.ScrollableContainer;
import com.tencent.mobileqq.filemanageraux.data.WeiYunFileInfo;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.Set;
import mqq.os.MqqHandler;

public class QfileBaseTabView
  extends RelativeLayout
  implements IBaseTabViewEvent, ITabViewEvent, HeaderScrollHelper.ScrollableContainer
{
  public BaseFileAssistantActivity C;
  protected BaseQQAppInterface D;
  View E;
  boolean F;
  protected boolean G = true;
  protected int H = -1;
  boolean I = true;
  protected Runnable J = null;
  
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
    this.C = ((BaseFileAssistantActivity)paramContext);
    this.D = ((BaseQQAppInterface)this.C.getAppRuntime());
  }
  
  protected boolean A()
  {
    return getActivity().C();
  }
  
  protected boolean B()
  {
    return (A()) || (z());
  }
  
  protected void C()
  {
    getActivity().B();
  }
  
  public void a() {}
  
  public void a(FileManagerEntity paramFileManagerEntity) {}
  
  protected void a(Runnable paramRunnable)
  {
    getActivity().runOnUiThread(paramRunnable);
  }
  
  public void a(ArrayList<FileManagerEntity> paramArrayList) {}
  
  public void a(Set<FileInfo> paramSet) {}
  
  public void b() {}
  
  public void b(FileInfo paramFileInfo) {}
  
  public void b(ArrayList<WeiYunFileInfo> paramArrayList) {}
  
  public boolean b(FileManagerEntity paramFileManagerEntity)
  {
    return false;
  }
  
  public boolean b(WeiYunFileInfo paramWeiYunFileInfo)
  {
    return false;
  }
  
  public void c() {}
  
  public void c(ArrayList<FileManagerEntity> paramArrayList) {}
  
  public boolean c(FileInfo paramFileInfo)
  {
    return false;
  }
  
  public void ci_() {}
  
  public void d() {}
  
  protected BaseFileAssistantActivity getActivity()
  {
    return this.C;
  }
  
  public int getFootHeight()
  {
    return 0;
  }
  
  public ListView getListView()
  {
    return null;
  }
  
  public View getScrollableView()
  {
    return null;
  }
  
  public int getSortType()
  {
    return this.H;
  }
  
  public int[] getSupportSortType()
  {
    return null;
  }
  
  public void i() {}
  
  public void j() {}
  
  public void m() {}
  
  public void n() {}
  
  protected void setContentView(int paramInt)
  {
    this.E = ((LayoutInflater)this.C.getSystemService("layout_inflater")).inflate(paramInt, null);
    this.E.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
    addView(this.E);
  }
  
  public void setEditbarButton(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    this.C.a(paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4, paramBoolean5);
  }
  
  protected void setEnableDelete(boolean paramBoolean)
  {
    this.F = paramBoolean;
  }
  
  public void setExpandGroup(boolean paramBoolean)
  {
    this.G = paramBoolean;
  }
  
  public void setFromWeiXin(boolean paramBoolean)
  {
    this.C.i(paramBoolean);
  }
  
  public void setPos(int paramInt1, int paramInt2) {}
  
  public void setSelect(int paramInt) {}
  
  public void setSortType(int paramInt)
  {
    this.H = paramInt;
  }
  
  public void t() {}
  
  public void u()
  {
    this.G = false;
  }
  
  protected boolean v()
  {
    return this.I;
  }
  
  protected void w()
  {
    this.I = false;
    new Handler().postDelayed(new QfileBaseTabView.1(this), 2000L);
  }
  
  public void x()
  {
    if (this.J != null)
    {
      ThreadManager.getFileThreadHandler().removeCallbacks(this.J);
      this.J = null;
    }
  }
  
  public boolean y()
  {
    return this.J == null;
  }
  
  protected boolean z()
  {
    return getActivity().q();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.fileassistant.QfileBaseTabView
 * JD-Core Version:    0.7.0.1
 */