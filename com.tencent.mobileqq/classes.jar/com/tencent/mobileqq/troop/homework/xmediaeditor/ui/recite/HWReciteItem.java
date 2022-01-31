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
import azac;
import azbp;
import azbu;
import azbv;
import azbw;
import azbx;
import azca;
import baka;
import bakb;
import befq;
import bgny;
import bgoj;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;
import java.io.File;
import tfy;

public class HWReciteItem
  extends azbp<azbx, azac>
  implements Handler.Callback, bakb
{
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new azbv(this);
  private final Context jdField_a_of_type_AndroidContentContext;
  private azac jdField_a_of_type_Azac;
  public azbx a;
  private baka jdField_a_of_type_Baka;
  private final befq jdField_a_of_type_Befq;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  
  public HWReciteItem(XMediaEditor paramXMediaEditor, Context paramContext)
  {
    super(paramXMediaEditor);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Befq = new befq(this);
    this.jdField_a_of_type_JavaLangString = paramXMediaEditor.a("troopuin");
  }
  
  private String a(String paramString)
  {
    return bgoj.a(this.jdField_a_of_type_AndroidContentContext).getString(paramString, null);
  }
  
  private void a(String paramString)
  {
    bgoj.a(this.jdField_a_of_type_AndroidContentContext).edit().remove(paramString).commit();
  }
  
  private void a(String paramString1, String paramString2)
  {
    bgoj.a(this.jdField_a_of_type_AndroidContentContext).edit().putString(paramString1, paramString2).commit();
  }
  
  private void f(azac paramazac)
  {
    if ((!TextUtils.isEmpty(paramazac.e)) || (paramazac.g != 0)) {
      return;
    }
    h(paramazac);
    ThreadManager.post(new HWReciteItem.1(this, paramazac), 8, null, true);
  }
  
  private void g(azac paramazac)
  {
    if ((!TextUtils.isEmpty(paramazac.e)) || (paramazac.g != 2)) {
      return;
    }
    h(paramazac);
    ThreadManager.post(new HWReciteItem.2(this, paramazac), 8, null, true);
  }
  
  private void h(azac paramazac)
  {
    if (paramazac.jdField_a_of_type_Bgny == null)
    {
      paramazac.jdField_a_of_type_Bgny = new bgny(tfy.a(), paramazac.d, paramazac.f);
      paramazac.jdField_a_of_type_Bgny.a(new azbw(this, paramazac));
    }
    paramazac.g = 1;
  }
  
  private void i(azac paramazac)
  {
    if ((paramazac != null) && (paramazac.jdField_a_of_type_Boolean)) {
      b();
    }
  }
  
  public azbx a(ViewGroup paramViewGroup)
  {
    paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131494791, paramViewGroup, false);
    try
    {
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("com.tnecnet.mobileqq.homework.recite.stopAudio");
      this.jdField_a_of_type_AndroidContentContext.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
      label42:
      return new azbx(paramViewGroup);
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
    paramInt1 = this.jdField_a_of_type_Azac.c;
    b();
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.getAdapter().notifyItemChanged(paramInt1);
  }
  
  public void a(View paramView, azbx paramazbx)
  {
    if (paramazbx != null) {
      paramazbx.a(paramView, this);
    }
  }
  
  public void a(azac paramazac)
  {
    if (paramazac.jdField_a_of_type_Int == 1) {
      f(paramazac);
    }
  }
  
  public void a(azbx paramazbx, azac paramazac, int paramInt)
  {
    if (TextUtils.isEmpty(paramazac.f)) {
      paramazac.f = this.jdField_a_of_type_JavaLangString;
    }
    paramazbx.a(this, paramazac, paramInt);
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a() != 0) && ((paramazbx.jdField_a_of_type_Azca.a.getVisibility() == 0) || (paramazbx.jdField_a_of_type_Azbu.a.getVisibility() == 0))) {
      paramazbx.itemView.setPadding(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a(), 0, this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a(), 0);
    }
    for (;;)
    {
      this.jdField_a_of_type_Azbx = paramazbx;
      return;
      paramazbx.itemView.setPadding(0, 0, 0, 0);
    }
  }
  
  public void a(String paramString, int paramInt1, int paramInt2) {}
  
  public void b()
  {
    if (this.jdField_a_of_type_Baka != null)
    {
      this.jdField_a_of_type_Baka.f();
      this.jdField_a_of_type_Baka = null;
    }
    this.jdField_a_of_type_Boolean = false;
    if (this.jdField_a_of_type_Azac != null)
    {
      this.jdField_a_of_type_Azac.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_Azac = null;
    }
  }
  
  public void b(azac paramazac)
  {
    g(paramazac);
  }
  
  public void b(String paramString, int paramInt1, int paramInt2) {}
  
  public void c(azac paramazac)
  {
    super.d(paramazac);
    i(paramazac);
  }
  
  public void d(azac paramazac)
  {
    paramazac.b = 1;
    if (!TextUtils.isEmpty(paramazac.e))
    {
      String str2 = a(paramazac.e);
      String str1 = str2;
      if (!TextUtils.isEmpty(str2))
      {
        str1 = str2;
        if (!new File(str2).exists())
        {
          a(paramazac.e);
          str1 = null;
        }
      }
      if (!TextUtils.isEmpty(str1))
      {
        paramazac.d = str1;
        paramazac.b = 2;
        return;
      }
      ThreadManager.postImmediately(new HWReciteItem.DownloadAudioTask(this, paramazac), null, false);
      return;
    }
    paramazac.b = 3;
  }
  
  public void e(azac paramazac)
  {
    if (this.jdField_a_of_type_Boolean) {
      b();
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Azac = paramazac;
    paramazac.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Baka = new baka(paramazac.d, new Handler(), 1);
    this.jdField_a_of_type_Baka.a(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_Baka.a(this);
    this.jdField_a_of_type_Baka.c();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return false;
    } while ((paramMessage.obj == null) || (!(paramMessage.obj instanceof azac)));
    paramMessage = (azac)paramMessage.obj;
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