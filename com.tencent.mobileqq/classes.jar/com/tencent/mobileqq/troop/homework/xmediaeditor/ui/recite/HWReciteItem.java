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
import bbzr;
import bcbe;
import bcbj;
import bcbk;
import bcbl;
import bcbm;
import bcbp;
import bdks;
import bdkt;
import bhow;
import bjyu;
import bjzi;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;
import java.io.File;
import vhj;

public class HWReciteItem
  extends bcbe<bcbm, bbzr>
  implements Handler.Callback, bdkt
{
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new bcbk(this);
  private final Context jdField_a_of_type_AndroidContentContext;
  private bbzr jdField_a_of_type_Bbzr;
  public bcbm a;
  private bdks jdField_a_of_type_Bdks;
  private final bhow jdField_a_of_type_Bhow;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  
  public HWReciteItem(XMediaEditor paramXMediaEditor, Context paramContext)
  {
    super(paramXMediaEditor);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Bhow = new bhow(this);
    this.jdField_a_of_type_JavaLangString = paramXMediaEditor.a("troopuin");
  }
  
  private String a(String paramString)
  {
    return bjzi.a(this.jdField_a_of_type_AndroidContentContext).getString(paramString, null);
  }
  
  private void a(String paramString)
  {
    bjzi.a(this.jdField_a_of_type_AndroidContentContext).edit().remove(paramString).commit();
  }
  
  private void a(String paramString1, String paramString2)
  {
    bjzi.a(this.jdField_a_of_type_AndroidContentContext).edit().putString(paramString1, paramString2).commit();
  }
  
  private void f(bbzr parambbzr)
  {
    if ((!TextUtils.isEmpty(parambbzr.e)) || (parambbzr.g != 0)) {
      return;
    }
    h(parambbzr);
    ThreadManager.post(new HWReciteItem.1(this, parambbzr), 8, null, true);
  }
  
  private void g(bbzr parambbzr)
  {
    if ((!TextUtils.isEmpty(parambbzr.e)) || (parambbzr.g != 2)) {
      return;
    }
    h(parambbzr);
    ThreadManager.post(new HWReciteItem.2(this, parambbzr), 8, null, true);
  }
  
  private void h(bbzr parambbzr)
  {
    if (parambbzr.jdField_a_of_type_Bjyu == null)
    {
      parambbzr.jdField_a_of_type_Bjyu = new bjyu(vhj.a(), parambbzr.d, parambbzr.f);
      parambbzr.jdField_a_of_type_Bjyu.a(new bcbl(this, parambbzr));
    }
    parambbzr.g = 1;
  }
  
  private void i(bbzr parambbzr)
  {
    if ((parambbzr != null) && (parambbzr.jdField_a_of_type_Boolean)) {
      b();
    }
  }
  
  public bcbm a(ViewGroup paramViewGroup)
  {
    paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560471, paramViewGroup, false);
    try
    {
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("com.tnecnet.mobileqq.homework.recite.stopAudio");
      this.jdField_a_of_type_AndroidContentContext.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
      label42:
      return new bcbm(paramViewGroup);
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
    paramInt1 = this.jdField_a_of_type_Bbzr.c;
    b();
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.getAdapter().notifyItemChanged(paramInt1);
  }
  
  public void a(View paramView, bcbm parambcbm)
  {
    if (parambcbm != null) {
      parambcbm.a(paramView, this);
    }
  }
  
  public void a(bbzr parambbzr)
  {
    if (parambbzr.jdField_a_of_type_Int == 1) {
      f(parambbzr);
    }
  }
  
  public void a(bcbm parambcbm, bbzr parambbzr, int paramInt)
  {
    if (TextUtils.isEmpty(parambbzr.f)) {
      parambbzr.f = this.jdField_a_of_type_JavaLangString;
    }
    parambcbm.a(this, parambbzr, paramInt);
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a() != 0) && ((parambcbm.jdField_a_of_type_Bcbp.a.getVisibility() == 0) || (parambcbm.jdField_a_of_type_Bcbj.a.getVisibility() == 0))) {
      parambcbm.itemView.setPadding(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a(), 0, this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a(), 0);
    }
    for (;;)
    {
      this.jdField_a_of_type_Bcbm = parambcbm;
      return;
      parambcbm.itemView.setPadding(0, 0, 0, 0);
    }
  }
  
  public void a(String paramString, int paramInt1, int paramInt2) {}
  
  public void b()
  {
    if (this.jdField_a_of_type_Bdks != null)
    {
      this.jdField_a_of_type_Bdks.f();
      this.jdField_a_of_type_Bdks = null;
    }
    this.jdField_a_of_type_Boolean = false;
    if (this.jdField_a_of_type_Bbzr != null)
    {
      this.jdField_a_of_type_Bbzr.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_Bbzr = null;
    }
  }
  
  public void b(bbzr parambbzr)
  {
    g(parambbzr);
  }
  
  public void b(String paramString, int paramInt1, int paramInt2) {}
  
  public void c(bbzr parambbzr)
  {
    super.d(parambbzr);
    i(parambbzr);
  }
  
  public void d(bbzr parambbzr)
  {
    parambbzr.b = 1;
    if (!TextUtils.isEmpty(parambbzr.e))
    {
      String str2 = a(parambbzr.e);
      String str1 = str2;
      if (!TextUtils.isEmpty(str2))
      {
        str1 = str2;
        if (!new File(str2).exists())
        {
          a(parambbzr.e);
          str1 = null;
        }
      }
      if (!TextUtils.isEmpty(str1))
      {
        parambbzr.d = str1;
        parambbzr.b = 2;
        return;
      }
      ThreadManager.postImmediately(new HWReciteItem.DownloadAudioTask(this, parambbzr), null, false);
      return;
    }
    parambbzr.b = 3;
  }
  
  public void e(bbzr parambbzr)
  {
    if (this.jdField_a_of_type_Boolean) {
      b();
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Bbzr = parambbzr;
    parambbzr.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Bdks = new bdks(parambbzr.d, new Handler(), 1);
    this.jdField_a_of_type_Bdks.a(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_Bdks.a(this);
    this.jdField_a_of_type_Bdks.c();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return false;
    } while ((paramMessage.obj == null) || (!(paramMessage.obj instanceof bbzr)));
    paramMessage = (bbzr)paramMessage.obj;
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