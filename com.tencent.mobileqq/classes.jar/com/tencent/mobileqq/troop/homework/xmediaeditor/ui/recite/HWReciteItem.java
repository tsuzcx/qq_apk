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
import bcea;
import bcfn;
import bcfs;
import bcft;
import bcfu;
import bcfv;
import bcfy;
import bdpb;
import bdpc;
import bhtd;
import bkdb;
import bkdp;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;
import java.io.File;
import vls;

public class HWReciteItem
  extends bcfn<bcfv, bcea>
  implements Handler.Callback, bdpc
{
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new bcft(this);
  private final Context jdField_a_of_type_AndroidContentContext;
  private bcea jdField_a_of_type_Bcea;
  public bcfv a;
  private bdpb jdField_a_of_type_Bdpb;
  private final bhtd jdField_a_of_type_Bhtd;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  
  public HWReciteItem(XMediaEditor paramXMediaEditor, Context paramContext)
  {
    super(paramXMediaEditor);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Bhtd = new bhtd(this);
    this.jdField_a_of_type_JavaLangString = paramXMediaEditor.a("troopuin");
  }
  
  private String a(String paramString)
  {
    return bkdp.a(this.jdField_a_of_type_AndroidContentContext).getString(paramString, null);
  }
  
  private void a(String paramString)
  {
    bkdp.a(this.jdField_a_of_type_AndroidContentContext).edit().remove(paramString).commit();
  }
  
  private void a(String paramString1, String paramString2)
  {
    bkdp.a(this.jdField_a_of_type_AndroidContentContext).edit().putString(paramString1, paramString2).commit();
  }
  
  private void f(bcea parambcea)
  {
    if ((!TextUtils.isEmpty(parambcea.e)) || (parambcea.g != 0)) {
      return;
    }
    h(parambcea);
    ThreadManager.post(new HWReciteItem.1(this, parambcea), 8, null, true);
  }
  
  private void g(bcea parambcea)
  {
    if ((!TextUtils.isEmpty(parambcea.e)) || (parambcea.g != 2)) {
      return;
    }
    h(parambcea);
    ThreadManager.post(new HWReciteItem.2(this, parambcea), 8, null, true);
  }
  
  private void h(bcea parambcea)
  {
    if (parambcea.jdField_a_of_type_Bkdb == null)
    {
      parambcea.jdField_a_of_type_Bkdb = new bkdb(vls.a(), parambcea.d, parambcea.f);
      parambcea.jdField_a_of_type_Bkdb.a(new bcfu(this, parambcea));
    }
    parambcea.g = 1;
  }
  
  private void i(bcea parambcea)
  {
    if ((parambcea != null) && (parambcea.jdField_a_of_type_Boolean)) {
      b();
    }
  }
  
  public bcfv a(ViewGroup paramViewGroup)
  {
    paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560470, paramViewGroup, false);
    try
    {
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("com.tnecnet.mobileqq.homework.recite.stopAudio");
      this.jdField_a_of_type_AndroidContentContext.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
      label42:
      return new bcfv(paramViewGroup);
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
    paramInt1 = this.jdField_a_of_type_Bcea.c;
    b();
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.getAdapter().notifyItemChanged(paramInt1);
  }
  
  public void a(View paramView, bcfv parambcfv)
  {
    if (parambcfv != null) {
      parambcfv.a(paramView, this);
    }
  }
  
  public void a(bcea parambcea)
  {
    if (parambcea.jdField_a_of_type_Int == 1) {
      f(parambcea);
    }
  }
  
  public void a(bcfv parambcfv, bcea parambcea, int paramInt)
  {
    if (TextUtils.isEmpty(parambcea.f)) {
      parambcea.f = this.jdField_a_of_type_JavaLangString;
    }
    parambcfv.a(this, parambcea, paramInt);
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a() != 0) && ((parambcfv.jdField_a_of_type_Bcfy.a.getVisibility() == 0) || (parambcfv.jdField_a_of_type_Bcfs.a.getVisibility() == 0))) {
      parambcfv.itemView.setPadding(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a(), 0, this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a(), 0);
    }
    for (;;)
    {
      this.jdField_a_of_type_Bcfv = parambcfv;
      return;
      parambcfv.itemView.setPadding(0, 0, 0, 0);
    }
  }
  
  public void a(String paramString, int paramInt1, int paramInt2) {}
  
  public void b()
  {
    if (this.jdField_a_of_type_Bdpb != null)
    {
      this.jdField_a_of_type_Bdpb.f();
      this.jdField_a_of_type_Bdpb = null;
    }
    this.jdField_a_of_type_Boolean = false;
    if (this.jdField_a_of_type_Bcea != null)
    {
      this.jdField_a_of_type_Bcea.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_Bcea = null;
    }
  }
  
  public void b(bcea parambcea)
  {
    g(parambcea);
  }
  
  public void b(String paramString, int paramInt1, int paramInt2) {}
  
  public void c(bcea parambcea)
  {
    super.d(parambcea);
    i(parambcea);
  }
  
  public void d(bcea parambcea)
  {
    parambcea.b = 1;
    if (!TextUtils.isEmpty(parambcea.e))
    {
      String str2 = a(parambcea.e);
      String str1 = str2;
      if (!TextUtils.isEmpty(str2))
      {
        str1 = str2;
        if (!new File(str2).exists())
        {
          a(parambcea.e);
          str1 = null;
        }
      }
      if (!TextUtils.isEmpty(str1))
      {
        parambcea.d = str1;
        parambcea.b = 2;
        return;
      }
      ThreadManager.postImmediately(new HWReciteItem.DownloadAudioTask(this, parambcea), null, false);
      return;
    }
    parambcea.b = 3;
  }
  
  public void e(bcea parambcea)
  {
    if (this.jdField_a_of_type_Boolean) {
      b();
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Bcea = parambcea;
    parambcea.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Bdpb = new bdpb(parambcea.d, new Handler(), 1);
    this.jdField_a_of_type_Bdpb.a(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_Bdpb.a(this);
    this.jdField_a_of_type_Bdpb.c();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return false;
    } while ((paramMessage.obj == null) || (!(paramMessage.obj instanceof bcea)));
    paramMessage = (bcea)paramMessage.obj;
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