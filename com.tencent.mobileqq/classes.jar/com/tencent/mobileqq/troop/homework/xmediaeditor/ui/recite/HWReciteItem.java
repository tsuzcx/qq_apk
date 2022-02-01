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
import com.tencent.biz.qqstory.playmode.util.PlayModeUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;
import com.tencent.mobileqq.troop.homework.xmediaeditor.model.HWReciteInfo;
import com.tencent.mobileqq.troop.homework.xmediaeditor.ui.UploadEditItem;
import com.tencent.mobileqq.utils.VoicePlayer;
import com.tencent.mobileqq.utils.VoicePlayer.VoicePlayerListener;
import com.tencent.util.WeakReferenceHandler;
import cooperation.troop_homework.TroopHomeworkHelper.UploadFileTask;
import cooperation.troop_homework.jsp.TroopHWVoiceController;
import java.io.File;

public class HWReciteItem
  extends UploadEditItem<HWReciteItem.HWReciteViewHolder, HWReciteInfo>
  implements Handler.Callback, VoicePlayer.VoicePlayerListener
{
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new HWReciteItem.3(this);
  private final Context jdField_a_of_type_AndroidContentContext;
  private HWReciteInfo jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelHWReciteInfo;
  public HWReciteItem.HWReciteViewHolder a;
  private VoicePlayer jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer;
  private final WeakReferenceHandler jdField_a_of_type_ComTencentUtilWeakReferenceHandler;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean = false;
  
  public HWReciteItem(XMediaEditor paramXMediaEditor, Context paramContext)
  {
    super(paramXMediaEditor);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(this);
    this.jdField_a_of_type_JavaLangString = paramXMediaEditor.a("troopuin");
  }
  
  private String a(String paramString)
  {
    return TroopHWVoiceController.a(this.jdField_a_of_type_AndroidContentContext).getString(paramString, null);
  }
  
  private void a(String paramString)
  {
    TroopHWVoiceController.a(this.jdField_a_of_type_AndroidContentContext).edit().remove(paramString).commit();
  }
  
  private void a(String paramString1, String paramString2)
  {
    TroopHWVoiceController.a(this.jdField_a_of_type_AndroidContentContext).edit().putString(paramString1, paramString2).commit();
  }
  
  private void f(HWReciteInfo paramHWReciteInfo)
  {
    if ((!TextUtils.isEmpty(paramHWReciteInfo.e)) || (paramHWReciteInfo.g != 0)) {
      return;
    }
    h(paramHWReciteInfo);
    ThreadManager.post(new HWReciteItem.1(this, paramHWReciteInfo), 8, null, true);
  }
  
  private void g(HWReciteInfo paramHWReciteInfo)
  {
    if ((!TextUtils.isEmpty(paramHWReciteInfo.e)) || (paramHWReciteInfo.g != 2)) {
      return;
    }
    h(paramHWReciteInfo);
    ThreadManager.post(new HWReciteItem.2(this, paramHWReciteInfo), 8, null, true);
  }
  
  private void h(HWReciteInfo paramHWReciteInfo)
  {
    if (paramHWReciteInfo.jdField_a_of_type_CooperationTroop_homeworkTroopHomeworkHelper$UploadFileTask == null)
    {
      paramHWReciteInfo.jdField_a_of_type_CooperationTroop_homeworkTroopHomeworkHelper$UploadFileTask = new TroopHomeworkHelper.UploadFileTask(PlayModeUtils.a(), paramHWReciteInfo.d, paramHWReciteInfo.f);
      paramHWReciteInfo.jdField_a_of_type_CooperationTroop_homeworkTroopHomeworkHelper$UploadFileTask.a(new HWReciteItem.AudioUploadCallback(this, paramHWReciteInfo));
    }
    paramHWReciteInfo.g = 1;
  }
  
  private void i(HWReciteInfo paramHWReciteInfo)
  {
    if ((paramHWReciteInfo != null) && (paramHWReciteInfo.jdField_a_of_type_Boolean)) {
      b();
    }
  }
  
  public HWReciteItem.HWReciteViewHolder a(ViewGroup paramViewGroup)
  {
    paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560793, paramViewGroup, false);
    try
    {
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("com.tnecnet.mobileqq.homework.recite.stopAudio");
      this.jdField_a_of_type_AndroidContentContext.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
      label42:
      return new HWReciteItem.HWReciteViewHolder(paramViewGroup);
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
    paramInt1 = this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelHWReciteInfo.c;
    b();
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.getAdapter().notifyItemChanged(paramInt1);
  }
  
  public void a(View paramView, HWReciteItem.HWReciteViewHolder paramHWReciteViewHolder)
  {
    if (paramHWReciteViewHolder != null) {
      paramHWReciteViewHolder.a(paramView, this);
    }
  }
  
  public void a(HWReciteInfo paramHWReciteInfo)
  {
    if (paramHWReciteInfo.jdField_a_of_type_Int == 1) {
      f(paramHWReciteInfo);
    }
  }
  
  public void a(HWReciteItem.HWReciteViewHolder paramHWReciteViewHolder, HWReciteInfo paramHWReciteInfo, int paramInt)
  {
    if (TextUtils.isEmpty(paramHWReciteInfo.f)) {
      paramHWReciteInfo.f = this.jdField_a_of_type_JavaLangString;
    }
    paramHWReciteViewHolder.a(this, paramHWReciteInfo, paramInt);
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a() != 0) && ((paramHWReciteViewHolder.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiReciteReciteTextSubViewHolder.a.getVisibility() == 0) || (paramHWReciteViewHolder.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiReciteGotoReciteSubViewHolder.a.getVisibility() == 0))) {
      paramHWReciteViewHolder.itemView.setPadding(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a(), 0, this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a(), 0);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiReciteHWReciteItem$HWReciteViewHolder = paramHWReciteViewHolder;
      return;
      paramHWReciteViewHolder.itemView.setPadding(0, 0, 0, 0);
    }
  }
  
  public void a(String paramString, int paramInt1, int paramInt2) {}
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer.f();
      this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer = null;
    }
    this.jdField_a_of_type_Boolean = false;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelHWReciteInfo != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelHWReciteInfo.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelHWReciteInfo = null;
    }
  }
  
  public void b(HWReciteInfo paramHWReciteInfo)
  {
    g(paramHWReciteInfo);
  }
  
  public void b(String paramString, int paramInt1, int paramInt2) {}
  
  public void c(HWReciteInfo paramHWReciteInfo)
  {
    super.d(paramHWReciteInfo);
    i(paramHWReciteInfo);
  }
  
  public void d(HWReciteInfo paramHWReciteInfo)
  {
    paramHWReciteInfo.b = 1;
    if (!TextUtils.isEmpty(paramHWReciteInfo.e))
    {
      String str2 = a(paramHWReciteInfo.e);
      String str1 = str2;
      if (!TextUtils.isEmpty(str2))
      {
        str1 = str2;
        if (!new File(str2).exists())
        {
          a(paramHWReciteInfo.e);
          str1 = null;
        }
      }
      if (!TextUtils.isEmpty(str1))
      {
        paramHWReciteInfo.d = str1;
        paramHWReciteInfo.b = 2;
        return;
      }
      ThreadManager.postImmediately(new HWReciteItem.DownloadAudioTask(this, paramHWReciteInfo), null, false);
      return;
    }
    paramHWReciteInfo.b = 3;
  }
  
  public void e(HWReciteInfo paramHWReciteInfo)
  {
    if (this.jdField_a_of_type_Boolean) {
      b();
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelHWReciteInfo = paramHWReciteInfo;
    paramHWReciteInfo.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer = new VoicePlayer(paramHWReciteInfo.d, new Handler(), 1);
    this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer.a(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer.a(this);
    this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer.b();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return false;
    } while ((paramMessage.obj == null) || (!(paramMessage.obj instanceof HWReciteInfo)));
    paramMessage = (HWReciteInfo)paramMessage.obj;
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