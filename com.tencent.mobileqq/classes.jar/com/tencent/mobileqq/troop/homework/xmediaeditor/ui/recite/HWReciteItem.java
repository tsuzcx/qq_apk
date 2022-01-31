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
import babi;
import bacv;
import bada;
import badb;
import badc;
import badd;
import badg;
import bbly;
import bblz;
import bfob;
import bhxj;
import bhxx;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;
import java.io.File;
import tsr;

public class HWReciteItem
  extends bacv<badd, babi>
  implements Handler.Callback, bblz
{
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new badb(this);
  private final Context jdField_a_of_type_AndroidContentContext;
  private babi jdField_a_of_type_Babi;
  public badd a;
  private bbly jdField_a_of_type_Bbly;
  private final bfob jdField_a_of_type_Bfob;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  
  public HWReciteItem(XMediaEditor paramXMediaEditor, Context paramContext)
  {
    super(paramXMediaEditor);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Bfob = new bfob(this);
    this.jdField_a_of_type_JavaLangString = paramXMediaEditor.a("troopuin");
  }
  
  private String a(String paramString)
  {
    return bhxx.a(this.jdField_a_of_type_AndroidContentContext).getString(paramString, null);
  }
  
  private void a(String paramString)
  {
    bhxx.a(this.jdField_a_of_type_AndroidContentContext).edit().remove(paramString).commit();
  }
  
  private void a(String paramString1, String paramString2)
  {
    bhxx.a(this.jdField_a_of_type_AndroidContentContext).edit().putString(paramString1, paramString2).commit();
  }
  
  private void f(babi parambabi)
  {
    if ((!TextUtils.isEmpty(parambabi.e)) || (parambabi.g != 0)) {
      return;
    }
    h(parambabi);
    ThreadManager.post(new HWReciteItem.1(this, parambabi), 8, null, true);
  }
  
  private void g(babi parambabi)
  {
    if ((!TextUtils.isEmpty(parambabi.e)) || (parambabi.g != 2)) {
      return;
    }
    h(parambabi);
    ThreadManager.post(new HWReciteItem.2(this, parambabi), 8, null, true);
  }
  
  private void h(babi parambabi)
  {
    if (parambabi.jdField_a_of_type_Bhxj == null)
    {
      parambabi.jdField_a_of_type_Bhxj = new bhxj(tsr.a(), parambabi.d, parambabi.f);
      parambabi.jdField_a_of_type_Bhxj.a(new badc(this, parambabi));
    }
    parambabi.g = 1;
  }
  
  private void i(babi parambabi)
  {
    if ((parambabi != null) && (parambabi.jdField_a_of_type_Boolean)) {
      b();
    }
  }
  
  public badd a(ViewGroup paramViewGroup)
  {
    paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560363, paramViewGroup, false);
    try
    {
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("com.tnecnet.mobileqq.homework.recite.stopAudio");
      this.jdField_a_of_type_AndroidContentContext.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
      label42:
      return new badd(paramViewGroup);
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
    paramInt1 = this.jdField_a_of_type_Babi.c;
    b();
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.getAdapter().notifyItemChanged(paramInt1);
  }
  
  public void a(View paramView, badd parambadd)
  {
    if (parambadd != null) {
      parambadd.a(paramView, this);
    }
  }
  
  public void a(babi parambabi)
  {
    if (parambabi.jdField_a_of_type_Int == 1) {
      f(parambabi);
    }
  }
  
  public void a(badd parambadd, babi parambabi, int paramInt)
  {
    if (TextUtils.isEmpty(parambabi.f)) {
      parambabi.f = this.jdField_a_of_type_JavaLangString;
    }
    parambadd.a(this, parambabi, paramInt);
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a() != 0) && ((parambadd.jdField_a_of_type_Badg.a.getVisibility() == 0) || (parambadd.jdField_a_of_type_Bada.a.getVisibility() == 0))) {
      parambadd.itemView.setPadding(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a(), 0, this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a(), 0);
    }
    for (;;)
    {
      this.jdField_a_of_type_Badd = parambadd;
      return;
      parambadd.itemView.setPadding(0, 0, 0, 0);
    }
  }
  
  public void a(String paramString, int paramInt1, int paramInt2) {}
  
  public void b()
  {
    if (this.jdField_a_of_type_Bbly != null)
    {
      this.jdField_a_of_type_Bbly.f();
      this.jdField_a_of_type_Bbly = null;
    }
    this.jdField_a_of_type_Boolean = false;
    if (this.jdField_a_of_type_Babi != null)
    {
      this.jdField_a_of_type_Babi.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_Babi = null;
    }
  }
  
  public void b(babi parambabi)
  {
    g(parambabi);
  }
  
  public void b(String paramString, int paramInt1, int paramInt2) {}
  
  public void c(babi parambabi)
  {
    super.d(parambabi);
    i(parambabi);
  }
  
  public void d(babi parambabi)
  {
    parambabi.b = 1;
    if (!TextUtils.isEmpty(parambabi.e))
    {
      String str2 = a(parambabi.e);
      String str1 = str2;
      if (!TextUtils.isEmpty(str2))
      {
        str1 = str2;
        if (!new File(str2).exists())
        {
          a(parambabi.e);
          str1 = null;
        }
      }
      if (!TextUtils.isEmpty(str1))
      {
        parambabi.d = str1;
        parambabi.b = 2;
        return;
      }
      ThreadManager.postImmediately(new HWReciteItem.DownloadAudioTask(this, parambabi), null, false);
      return;
    }
    parambabi.b = 3;
  }
  
  public void e(babi parambabi)
  {
    if (this.jdField_a_of_type_Boolean) {
      b();
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Babi = parambabi;
    parambabi.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Bbly = new bbly(parambabi.d, new Handler(), 1);
    this.jdField_a_of_type_Bbly.a(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_Bbly.a(this);
    this.jdField_a_of_type_Bbly.c();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return false;
    } while ((paramMessage.obj == null) || (!(paramMessage.obj instanceof babi)));
    paramMessage = (babi)paramMessage.obj;
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