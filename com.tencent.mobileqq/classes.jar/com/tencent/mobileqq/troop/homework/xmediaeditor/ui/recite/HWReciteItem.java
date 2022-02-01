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
import bgei;
import bgfv;
import bgga;
import bggb;
import bggc;
import bggd;
import bggg;
import bhud;
import bhue;
import blhq;
import bnsq;
import bnte;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;
import java.io.File;
import xiz;

public class HWReciteItem
  extends bgfv<bggd, bgei>
  implements Handler.Callback, bhue
{
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new bggb(this);
  private final Context jdField_a_of_type_AndroidContentContext;
  private bgei jdField_a_of_type_Bgei;
  public bggd a;
  private bhud jdField_a_of_type_Bhud;
  private final blhq jdField_a_of_type_Blhq;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  
  public HWReciteItem(XMediaEditor paramXMediaEditor, Context paramContext)
  {
    super(paramXMediaEditor);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Blhq = new blhq(this);
    this.jdField_a_of_type_JavaLangString = paramXMediaEditor.a("troopuin");
  }
  
  private String a(String paramString)
  {
    return bnte.a(this.jdField_a_of_type_AndroidContentContext).getString(paramString, null);
  }
  
  private void a(String paramString)
  {
    bnte.a(this.jdField_a_of_type_AndroidContentContext).edit().remove(paramString).commit();
  }
  
  private void a(String paramString1, String paramString2)
  {
    bnte.a(this.jdField_a_of_type_AndroidContentContext).edit().putString(paramString1, paramString2).commit();
  }
  
  private void f(bgei parambgei)
  {
    if ((!TextUtils.isEmpty(parambgei.e)) || (parambgei.g != 0)) {
      return;
    }
    h(parambgei);
    ThreadManager.post(new HWReciteItem.1(this, parambgei), 8, null, true);
  }
  
  private void g(bgei parambgei)
  {
    if ((!TextUtils.isEmpty(parambgei.e)) || (parambgei.g != 2)) {
      return;
    }
    h(parambgei);
    ThreadManager.post(new HWReciteItem.2(this, parambgei), 8, null, true);
  }
  
  private void h(bgei parambgei)
  {
    if (parambgei.jdField_a_of_type_Bnsq == null)
    {
      parambgei.jdField_a_of_type_Bnsq = new bnsq(xiz.a(), parambgei.d, parambgei.f);
      parambgei.jdField_a_of_type_Bnsq.a(new bggc(this, parambgei));
    }
    parambgei.g = 1;
  }
  
  private void i(bgei parambgei)
  {
    if ((parambgei != null) && (parambgei.jdField_a_of_type_Boolean)) {
      b();
    }
  }
  
  public bggd a(ViewGroup paramViewGroup)
  {
    paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560640, paramViewGroup, false);
    try
    {
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("com.tnecnet.mobileqq.homework.recite.stopAudio");
      this.jdField_a_of_type_AndroidContentContext.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
      label42:
      return new bggd(paramViewGroup);
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
    paramInt1 = this.jdField_a_of_type_Bgei.c;
    b();
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.getAdapter().notifyItemChanged(paramInt1);
  }
  
  public void a(View paramView, bggd parambggd)
  {
    if (parambggd != null) {
      parambggd.a(paramView, this);
    }
  }
  
  public void a(bgei parambgei)
  {
    if (parambgei.jdField_a_of_type_Int == 1) {
      f(parambgei);
    }
  }
  
  public void a(bggd parambggd, bgei parambgei, int paramInt)
  {
    if (TextUtils.isEmpty(parambgei.f)) {
      parambgei.f = this.jdField_a_of_type_JavaLangString;
    }
    parambggd.a(this, parambgei, paramInt);
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a() != 0) && ((parambggd.jdField_a_of_type_Bggg.a.getVisibility() == 0) || (parambggd.jdField_a_of_type_Bgga.a.getVisibility() == 0))) {
      parambggd.itemView.setPadding(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a(), 0, this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a(), 0);
    }
    for (;;)
    {
      this.jdField_a_of_type_Bggd = parambggd;
      return;
      parambggd.itemView.setPadding(0, 0, 0, 0);
    }
  }
  
  public void a(String paramString, int paramInt1, int paramInt2) {}
  
  public void b()
  {
    if (this.jdField_a_of_type_Bhud != null)
    {
      this.jdField_a_of_type_Bhud.e();
      this.jdField_a_of_type_Bhud = null;
    }
    this.jdField_a_of_type_Boolean = false;
    if (this.jdField_a_of_type_Bgei != null)
    {
      this.jdField_a_of_type_Bgei.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_Bgei = null;
    }
  }
  
  public void b(bgei parambgei)
  {
    g(parambgei);
  }
  
  public void b(String paramString, int paramInt1, int paramInt2) {}
  
  public void c(bgei parambgei)
  {
    super.d(parambgei);
    i(parambgei);
  }
  
  public void d(bgei parambgei)
  {
    parambgei.b = 1;
    if (!TextUtils.isEmpty(parambgei.e))
    {
      String str2 = a(parambgei.e);
      String str1 = str2;
      if (!TextUtils.isEmpty(str2))
      {
        str1 = str2;
        if (!new File(str2).exists())
        {
          a(parambgei.e);
          str1 = null;
        }
      }
      if (!TextUtils.isEmpty(str1))
      {
        parambgei.d = str1;
        parambgei.b = 2;
        return;
      }
      ThreadManager.postImmediately(new HWReciteItem.DownloadAudioTask(this, parambgei), null, false);
      return;
    }
    parambgei.b = 3;
  }
  
  public void e(bgei parambgei)
  {
    if (this.jdField_a_of_type_Boolean) {
      b();
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Bgei = parambgei;
    parambgei.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Bhud = new bhud(parambgei.d, new Handler(), 1);
    this.jdField_a_of_type_Bhud.a(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_Bhud.a(this);
    this.jdField_a_of_type_Bhud.b();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return false;
    } while ((paramMessage.obj == null) || (!(paramMessage.obj instanceof bgei)));
    paramMessage = (bgei)paramMessage.obj;
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