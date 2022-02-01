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
import benq;
import bepd;
import bepi;
import bepj;
import bepk;
import bepl;
import bepo;
import bgas;
import bgat;
import bjng;
import bkxx;
import bkyl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;
import java.io.File;
import wkp;

public class HWReciteItem
  extends bepd<bepl, benq>
  implements Handler.Callback, bgat
{
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new bepj(this);
  private final Context jdField_a_of_type_AndroidContentContext;
  private benq jdField_a_of_type_Benq;
  public bepl a;
  private bgas jdField_a_of_type_Bgas;
  private final bjng jdField_a_of_type_Bjng;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  
  public HWReciteItem(XMediaEditor paramXMediaEditor, Context paramContext)
  {
    super(paramXMediaEditor);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Bjng = new bjng(this);
    this.jdField_a_of_type_JavaLangString = paramXMediaEditor.a("troopuin");
  }
  
  private String a(String paramString)
  {
    return bkyl.a(this.jdField_a_of_type_AndroidContentContext).getString(paramString, null);
  }
  
  private void a(String paramString)
  {
    bkyl.a(this.jdField_a_of_type_AndroidContentContext).edit().remove(paramString).commit();
  }
  
  private void a(String paramString1, String paramString2)
  {
    bkyl.a(this.jdField_a_of_type_AndroidContentContext).edit().putString(paramString1, paramString2).commit();
  }
  
  private void f(benq parambenq)
  {
    if ((!TextUtils.isEmpty(parambenq.e)) || (parambenq.g != 0)) {
      return;
    }
    h(parambenq);
    ThreadManager.post(new HWReciteItem.1(this, parambenq), 8, null, true);
  }
  
  private void g(benq parambenq)
  {
    if ((!TextUtils.isEmpty(parambenq.e)) || (parambenq.g != 2)) {
      return;
    }
    h(parambenq);
    ThreadManager.post(new HWReciteItem.2(this, parambenq), 8, null, true);
  }
  
  private void h(benq parambenq)
  {
    if (parambenq.jdField_a_of_type_Bkxx == null)
    {
      parambenq.jdField_a_of_type_Bkxx = new bkxx(wkp.a(), parambenq.d, parambenq.f);
      parambenq.jdField_a_of_type_Bkxx.a(new bepk(this, parambenq));
    }
    parambenq.g = 1;
  }
  
  private void i(benq parambenq)
  {
    if ((parambenq != null) && (parambenq.jdField_a_of_type_Boolean)) {
      b();
    }
  }
  
  public bepl a(ViewGroup paramViewGroup)
  {
    paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560650, paramViewGroup, false);
    try
    {
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("com.tnecnet.mobileqq.homework.recite.stopAudio");
      this.jdField_a_of_type_AndroidContentContext.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
      label42:
      return new bepl(paramViewGroup);
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
    paramInt1 = this.jdField_a_of_type_Benq.c;
    b();
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.getAdapter().notifyItemChanged(paramInt1);
  }
  
  public void a(View paramView, bepl parambepl)
  {
    if (parambepl != null) {
      parambepl.a(paramView, this);
    }
  }
  
  public void a(benq parambenq)
  {
    if (parambenq.jdField_a_of_type_Int == 1) {
      f(parambenq);
    }
  }
  
  public void a(bepl parambepl, benq parambenq, int paramInt)
  {
    if (TextUtils.isEmpty(parambenq.f)) {
      parambenq.f = this.jdField_a_of_type_JavaLangString;
    }
    parambepl.a(this, parambenq, paramInt);
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a() != 0) && ((parambepl.jdField_a_of_type_Bepo.a.getVisibility() == 0) || (parambepl.jdField_a_of_type_Bepi.a.getVisibility() == 0))) {
      parambepl.itemView.setPadding(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a(), 0, this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a(), 0);
    }
    for (;;)
    {
      this.jdField_a_of_type_Bepl = parambepl;
      return;
      parambepl.itemView.setPadding(0, 0, 0, 0);
    }
  }
  
  public void a(String paramString, int paramInt1, int paramInt2) {}
  
  public void b()
  {
    if (this.jdField_a_of_type_Bgas != null)
    {
      this.jdField_a_of_type_Bgas.e();
      this.jdField_a_of_type_Bgas = null;
    }
    this.jdField_a_of_type_Boolean = false;
    if (this.jdField_a_of_type_Benq != null)
    {
      this.jdField_a_of_type_Benq.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_Benq = null;
    }
  }
  
  public void b(benq parambenq)
  {
    g(parambenq);
  }
  
  public void b(String paramString, int paramInt1, int paramInt2) {}
  
  public void c(benq parambenq)
  {
    super.d(parambenq);
    i(parambenq);
  }
  
  public void d(benq parambenq)
  {
    parambenq.b = 1;
    if (!TextUtils.isEmpty(parambenq.e))
    {
      String str2 = a(parambenq.e);
      String str1 = str2;
      if (!TextUtils.isEmpty(str2))
      {
        str1 = str2;
        if (!new File(str2).exists())
        {
          a(parambenq.e);
          str1 = null;
        }
      }
      if (!TextUtils.isEmpty(str1))
      {
        parambenq.d = str1;
        parambenq.b = 2;
        return;
      }
      ThreadManager.postImmediately(new HWReciteItem.DownloadAudioTask(this, parambenq), null, false);
      return;
    }
    parambenq.b = 3;
  }
  
  public void e(benq parambenq)
  {
    if (this.jdField_a_of_type_Boolean) {
      b();
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Benq = parambenq;
    parambenq.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Bgas = new bgas(parambenq.d, new Handler(), 1);
    this.jdField_a_of_type_Bgas.a(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_Bgas.a(this);
    this.jdField_a_of_type_Bgas.b();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return false;
    } while ((paramMessage.obj == null) || (!(paramMessage.obj instanceof benq)));
    paramMessage = (benq)paramMessage.obj;
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