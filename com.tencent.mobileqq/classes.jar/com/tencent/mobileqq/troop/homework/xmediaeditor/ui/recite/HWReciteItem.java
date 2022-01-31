package com.tencent.mobileqq.troop.homework.xmediaeditor.ui.recite;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.v7.widget.RecyclerView.Adapter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import baau;
import bach;
import bacm;
import bacn;
import baco;
import bacp;
import bacs;
import bblk;
import bbll;
import bfnk;
import bhws;
import bhxg;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;
import java.io.File;
import tsu;

public class HWReciteItem
  extends bach<bacp, baau>
  implements Handler.Callback, bbll
{
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new bacn(this);
  private final Context jdField_a_of_type_AndroidContentContext;
  private baau jdField_a_of_type_Baau;
  public bacp a;
  private bblk jdField_a_of_type_Bblk;
  private final bfnk jdField_a_of_type_Bfnk;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  
  public HWReciteItem(XMediaEditor paramXMediaEditor, Context paramContext)
  {
    super(paramXMediaEditor);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Bfnk = new bfnk(this);
    this.jdField_a_of_type_JavaLangString = paramXMediaEditor.a("troopuin");
  }
  
  private String a(String paramString)
  {
    return bhxg.a(this.jdField_a_of_type_AndroidContentContext).getString(paramString, null);
  }
  
  private void a(String paramString)
  {
    bhxg.a(this.jdField_a_of_type_AndroidContentContext).edit().remove(paramString).commit();
  }
  
  private void a(String paramString1, String paramString2)
  {
    bhxg.a(this.jdField_a_of_type_AndroidContentContext).edit().putString(paramString1, paramString2).commit();
  }
  
  private void f(baau parambaau)
  {
    if ((!TextUtils.isEmpty(parambaau.e)) || (parambaau.g != 0)) {
      return;
    }
    h(parambaau);
    ThreadManager.post(new HWReciteItem.1(this, parambaau), 8, null, true);
  }
  
  private void g(baau parambaau)
  {
    if ((!TextUtils.isEmpty(parambaau.e)) || (parambaau.g != 2)) {
      return;
    }
    h(parambaau);
    ThreadManager.post(new HWReciteItem.2(this, parambaau), 8, null, true);
  }
  
  private void h(baau parambaau)
  {
    if (parambaau.jdField_a_of_type_Bhws == null)
    {
      parambaau.jdField_a_of_type_Bhws = new bhws(tsu.a(), parambaau.d, parambaau.f);
      parambaau.jdField_a_of_type_Bhws.a(new baco(this, parambaau));
    }
    parambaau.g = 1;
  }
  
  private void i(baau parambaau)
  {
    if ((parambaau != null) && (parambaau.jdField_a_of_type_Boolean)) {
      b();
    }
  }
  
  public bacp a(ViewGroup paramViewGroup)
  {
    paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560363, paramViewGroup, false);
    try
    {
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("com.tnecnet.mobileqq.homework.recite.stopAudio");
      this.jdField_a_of_type_AndroidContentContext.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
      label42:
      return new bacp(paramViewGroup);
    }
    catch (Exception localException)
    {
      break label42;
    }
  }
  
  public void a()
  {
    super.a();
    b();
    try
    {
      this.jdField_a_of_type_AndroidContentContext.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      return;
    }
    catch (Exception localException) {}
  }
  
  public void a(int paramInt1, String paramString, int paramInt2)
  {
    paramInt1 = this.jdField_a_of_type_Baau.c;
    b();
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.getAdapter().notifyItemChanged(paramInt1);
  }
  
  public void a(View paramView, bacp parambacp)
  {
    if (parambacp != null) {
      parambacp.a(paramView, this);
    }
  }
  
  public void a(baau parambaau)
  {
    if (parambaau.jdField_a_of_type_Int == 1) {
      f(parambaau);
    }
  }
  
  public void a(bacp parambacp, baau parambaau, int paramInt)
  {
    if (TextUtils.isEmpty(parambaau.f)) {
      parambaau.f = this.jdField_a_of_type_JavaLangString;
    }
    parambacp.a(this, parambaau, paramInt);
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a() != 0) && ((parambacp.jdField_a_of_type_Bacs.a.getVisibility() == 0) || (parambacp.jdField_a_of_type_Bacm.a.getVisibility() == 0))) {
      parambacp.itemView.setPadding(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a(), 0, this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a(), 0);
    }
    for (;;)
    {
      this.jdField_a_of_type_Bacp = parambacp;
      return;
      parambacp.itemView.setPadding(0, 0, 0, 0);
    }
  }
  
  public void a(String paramString, int paramInt1, int paramInt2) {}
  
  public void b()
  {
    if (this.jdField_a_of_type_Bblk != null)
    {
      this.jdField_a_of_type_Bblk.f();
      this.jdField_a_of_type_Bblk = null;
    }
    this.jdField_a_of_type_Boolean = false;
    if (this.jdField_a_of_type_Baau != null)
    {
      this.jdField_a_of_type_Baau.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_Baau = null;
    }
  }
  
  public void b(baau parambaau)
  {
    g(parambaau);
  }
  
  public void b(String paramString, int paramInt1, int paramInt2) {}
  
  public void c(baau parambaau)
  {
    super.d(parambaau);
    i(parambaau);
  }
  
  public void d(baau parambaau)
  {
    parambaau.b = 1;
    if (!TextUtils.isEmpty(parambaau.e))
    {
      String str2 = a(parambaau.e);
      String str1 = str2;
      if (!TextUtils.isEmpty(str2))
      {
        str1 = str2;
        if (!new File(str2).exists())
        {
          a(parambaau.e);
          str1 = null;
        }
      }
      if (!TextUtils.isEmpty(str1))
      {
        parambaau.d = str1;
        parambaau.b = 2;
        return;
      }
      ThreadManager.postImmediately(new HWReciteItem.DownloadAudioTask(this, parambaau), null, false);
      return;
    }
    parambaau.b = 3;
  }
  
  public void e(baau parambaau)
  {
    if (this.jdField_a_of_type_Boolean) {
      b();
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Baau = parambaau;
    parambaau.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Bblk = new bblk(parambaau.d, new Handler(), 1);
    this.jdField_a_of_type_Bblk.a(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_Bblk.a(this);
    this.jdField_a_of_type_Bblk.c();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return false;
    } while ((paramMessage.obj == null) || (!(paramMessage.obj instanceof baau)));
    paramMessage = (baau)paramMessage.obj;
    if (!TextUtils.isEmpty(paramMessage.d))
    {
      paramMessage.b = 2;
      a(paramMessage.e, paramMessage.d);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.getAdapter().notifyItemChanged(paramMessage.c);
      break;
      paramMessage.b = 3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.xmediaeditor.ui.recite.HWReciteItem
 * JD-Core Version:    0.7.0.1
 */