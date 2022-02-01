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
import bfeo;
import bfgb;
import bfgg;
import bfgh;
import bfgi;
import bfgj;
import bfgm;
import bgua;
import bgub;
import bkgm;
import bmrl;
import bmrz;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;
import java.io.File;
import xfe;

public class HWReciteItem
  extends bfgb<bfgj, bfeo>
  implements Handler.Callback, bgub
{
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new bfgh(this);
  private final Context jdField_a_of_type_AndroidContentContext;
  private bfeo jdField_a_of_type_Bfeo;
  public bfgj a;
  private bgua jdField_a_of_type_Bgua;
  private final bkgm jdField_a_of_type_Bkgm;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  
  public HWReciteItem(XMediaEditor paramXMediaEditor, Context paramContext)
  {
    super(paramXMediaEditor);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Bkgm = new bkgm(this);
    this.jdField_a_of_type_JavaLangString = paramXMediaEditor.a("troopuin");
  }
  
  private String a(String paramString)
  {
    return bmrz.a(this.jdField_a_of_type_AndroidContentContext).getString(paramString, null);
  }
  
  private void a(String paramString)
  {
    bmrz.a(this.jdField_a_of_type_AndroidContentContext).edit().remove(paramString).commit();
  }
  
  private void a(String paramString1, String paramString2)
  {
    bmrz.a(this.jdField_a_of_type_AndroidContentContext).edit().putString(paramString1, paramString2).commit();
  }
  
  private void f(bfeo parambfeo)
  {
    if ((!TextUtils.isEmpty(parambfeo.e)) || (parambfeo.g != 0)) {
      return;
    }
    h(parambfeo);
    ThreadManager.post(new HWReciteItem.1(this, parambfeo), 8, null, true);
  }
  
  private void g(bfeo parambfeo)
  {
    if ((!TextUtils.isEmpty(parambfeo.e)) || (parambfeo.g != 2)) {
      return;
    }
    h(parambfeo);
    ThreadManager.post(new HWReciteItem.2(this, parambfeo), 8, null, true);
  }
  
  private void h(bfeo parambfeo)
  {
    if (parambfeo.jdField_a_of_type_Bmrl == null)
    {
      parambfeo.jdField_a_of_type_Bmrl = new bmrl(xfe.a(), parambfeo.d, parambfeo.f);
      parambfeo.jdField_a_of_type_Bmrl.a(new bfgi(this, parambfeo));
    }
    parambfeo.g = 1;
  }
  
  private void i(bfeo parambfeo)
  {
    if ((parambfeo != null) && (parambfeo.jdField_a_of_type_Boolean)) {
      b();
    }
  }
  
  public bfgj a(ViewGroup paramViewGroup)
  {
    paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560625, paramViewGroup, false);
    try
    {
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("com.tnecnet.mobileqq.homework.recite.stopAudio");
      this.jdField_a_of_type_AndroidContentContext.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
      label42:
      return new bfgj(paramViewGroup);
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
    paramInt1 = this.jdField_a_of_type_Bfeo.c;
    b();
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.getAdapter().notifyItemChanged(paramInt1);
  }
  
  public void a(View paramView, bfgj parambfgj)
  {
    if (parambfgj != null) {
      parambfgj.a(paramView, this);
    }
  }
  
  public void a(bfeo parambfeo)
  {
    if (parambfeo.jdField_a_of_type_Int == 1) {
      f(parambfeo);
    }
  }
  
  public void a(bfgj parambfgj, bfeo parambfeo, int paramInt)
  {
    if (TextUtils.isEmpty(parambfeo.f)) {
      parambfeo.f = this.jdField_a_of_type_JavaLangString;
    }
    parambfgj.a(this, parambfeo, paramInt);
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a() != 0) && ((parambfgj.jdField_a_of_type_Bfgm.a.getVisibility() == 0) || (parambfgj.jdField_a_of_type_Bfgg.a.getVisibility() == 0))) {
      parambfgj.itemView.setPadding(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a(), 0, this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a(), 0);
    }
    for (;;)
    {
      this.jdField_a_of_type_Bfgj = parambfgj;
      return;
      parambfgj.itemView.setPadding(0, 0, 0, 0);
    }
  }
  
  public void a(String paramString, int paramInt1, int paramInt2) {}
  
  public void b()
  {
    if (this.jdField_a_of_type_Bgua != null)
    {
      this.jdField_a_of_type_Bgua.e();
      this.jdField_a_of_type_Bgua = null;
    }
    this.jdField_a_of_type_Boolean = false;
    if (this.jdField_a_of_type_Bfeo != null)
    {
      this.jdField_a_of_type_Bfeo.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_Bfeo = null;
    }
  }
  
  public void b(bfeo parambfeo)
  {
    g(parambfeo);
  }
  
  public void b(String paramString, int paramInt1, int paramInt2) {}
  
  public void c(bfeo parambfeo)
  {
    super.d(parambfeo);
    i(parambfeo);
  }
  
  public void d(bfeo parambfeo)
  {
    parambfeo.b = 1;
    if (!TextUtils.isEmpty(parambfeo.e))
    {
      String str2 = a(parambfeo.e);
      String str1 = str2;
      if (!TextUtils.isEmpty(str2))
      {
        str1 = str2;
        if (!new File(str2).exists())
        {
          a(parambfeo.e);
          str1 = null;
        }
      }
      if (!TextUtils.isEmpty(str1))
      {
        parambfeo.d = str1;
        parambfeo.b = 2;
        return;
      }
      ThreadManager.postImmediately(new HWReciteItem.DownloadAudioTask(this, parambfeo), null, false);
      return;
    }
    parambfeo.b = 3;
  }
  
  public void e(bfeo parambfeo)
  {
    if (this.jdField_a_of_type_Boolean) {
      b();
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Bfeo = parambfeo;
    parambfeo.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Bgua = new bgua(parambfeo.d, new Handler(), 1);
    this.jdField_a_of_type_Bgua.a(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_Bgua.a(this);
    this.jdField_a_of_type_Bgua.b();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return false;
    } while ((paramMessage.obj == null) || (!(paramMessage.obj instanceof bfeo)));
    paramMessage = (bfeo)paramMessage.obj;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.xmediaeditor.ui.recite.HWReciteItem
 * JD-Core Version:    0.7.0.1
 */