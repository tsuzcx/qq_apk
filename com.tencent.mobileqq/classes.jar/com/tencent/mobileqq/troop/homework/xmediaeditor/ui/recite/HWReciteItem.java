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
import bfut;
import bfwg;
import bfwl;
import bfwm;
import bfwn;
import bfwo;
import bfwr;
import bhjj;
import bhjk;
import bkys;
import bmjg;
import bmju;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;
import java.io.File;
import wzk;

public class HWReciteItem
  extends bfwg<bfwo, bfut>
  implements Handler.Callback, bhjk
{
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new bfwm(this);
  private final Context jdField_a_of_type_AndroidContentContext;
  private bfut jdField_a_of_type_Bfut;
  public bfwo a;
  private bhjj jdField_a_of_type_Bhjj;
  private final bkys jdField_a_of_type_Bkys;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  
  public HWReciteItem(XMediaEditor paramXMediaEditor, Context paramContext)
  {
    super(paramXMediaEditor);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Bkys = new bkys(this);
    this.jdField_a_of_type_JavaLangString = paramXMediaEditor.a("troopuin");
  }
  
  private String a(String paramString)
  {
    return bmju.a(this.jdField_a_of_type_AndroidContentContext).getString(paramString, null);
  }
  
  private void a(String paramString)
  {
    bmju.a(this.jdField_a_of_type_AndroidContentContext).edit().remove(paramString).commit();
  }
  
  private void a(String paramString1, String paramString2)
  {
    bmju.a(this.jdField_a_of_type_AndroidContentContext).edit().putString(paramString1, paramString2).commit();
  }
  
  private void f(bfut parambfut)
  {
    if ((!TextUtils.isEmpty(parambfut.e)) || (parambfut.g != 0)) {
      return;
    }
    h(parambfut);
    ThreadManager.post(new HWReciteItem.1(this, parambfut), 8, null, true);
  }
  
  private void g(bfut parambfut)
  {
    if ((!TextUtils.isEmpty(parambfut.e)) || (parambfut.g != 2)) {
      return;
    }
    h(parambfut);
    ThreadManager.post(new HWReciteItem.2(this, parambfut), 8, null, true);
  }
  
  private void h(bfut parambfut)
  {
    if (parambfut.jdField_a_of_type_Bmjg == null)
    {
      parambfut.jdField_a_of_type_Bmjg = new bmjg(wzk.a(), parambfut.d, parambfut.f);
      parambfut.jdField_a_of_type_Bmjg.a(new bfwn(this, parambfut));
    }
    parambfut.g = 1;
  }
  
  private void i(bfut parambfut)
  {
    if ((parambfut != null) && (parambfut.jdField_a_of_type_Boolean)) {
      b();
    }
  }
  
  public bfwo a(ViewGroup paramViewGroup)
  {
    paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560703, paramViewGroup, false);
    try
    {
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("com.tnecnet.mobileqq.homework.recite.stopAudio");
      this.jdField_a_of_type_AndroidContentContext.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
      label42:
      return new bfwo(paramViewGroup);
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
    paramInt1 = this.jdField_a_of_type_Bfut.c;
    b();
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.getAdapter().notifyItemChanged(paramInt1);
  }
  
  public void a(View paramView, bfwo parambfwo)
  {
    if (parambfwo != null) {
      parambfwo.a(paramView, this);
    }
  }
  
  public void a(bfut parambfut)
  {
    if (parambfut.jdField_a_of_type_Int == 1) {
      f(parambfut);
    }
  }
  
  public void a(bfwo parambfwo, bfut parambfut, int paramInt)
  {
    if (TextUtils.isEmpty(parambfut.f)) {
      parambfut.f = this.jdField_a_of_type_JavaLangString;
    }
    parambfwo.a(this, parambfut, paramInt);
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a() != 0) && ((parambfwo.jdField_a_of_type_Bfwr.a.getVisibility() == 0) || (parambfwo.jdField_a_of_type_Bfwl.a.getVisibility() == 0))) {
      parambfwo.itemView.setPadding(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a(), 0, this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a(), 0);
    }
    for (;;)
    {
      this.jdField_a_of_type_Bfwo = parambfwo;
      return;
      parambfwo.itemView.setPadding(0, 0, 0, 0);
    }
  }
  
  public void a(String paramString, int paramInt1, int paramInt2) {}
  
  public void b()
  {
    if (this.jdField_a_of_type_Bhjj != null)
    {
      this.jdField_a_of_type_Bhjj.e();
      this.jdField_a_of_type_Bhjj = null;
    }
    this.jdField_a_of_type_Boolean = false;
    if (this.jdField_a_of_type_Bfut != null)
    {
      this.jdField_a_of_type_Bfut.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_Bfut = null;
    }
  }
  
  public void b(bfut parambfut)
  {
    g(parambfut);
  }
  
  public void b(String paramString, int paramInt1, int paramInt2) {}
  
  public void c(bfut parambfut)
  {
    super.d(parambfut);
    i(parambfut);
  }
  
  public void d(bfut parambfut)
  {
    parambfut.b = 1;
    if (!TextUtils.isEmpty(parambfut.e))
    {
      String str2 = a(parambfut.e);
      String str1 = str2;
      if (!TextUtils.isEmpty(str2))
      {
        str1 = str2;
        if (!new File(str2).exists())
        {
          a(parambfut.e);
          str1 = null;
        }
      }
      if (!TextUtils.isEmpty(str1))
      {
        parambfut.d = str1;
        parambfut.b = 2;
        return;
      }
      ThreadManager.postImmediately(new HWReciteItem.DownloadAudioTask(this, parambfut), null, false);
      return;
    }
    parambfut.b = 3;
  }
  
  public void e(bfut parambfut)
  {
    if (this.jdField_a_of_type_Boolean) {
      b();
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Bfut = parambfut;
    parambfut.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Bhjj = new bhjj(parambfut.d, new Handler(), 1);
    this.jdField_a_of_type_Bhjj.a(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_Bhjj.a(this);
    this.jdField_a_of_type_Bhjj.b();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return false;
    } while ((paramMessage.obj == null) || (!(paramMessage.obj instanceof bfut)));
    paramMessage = (bfut)paramMessage.obj;
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