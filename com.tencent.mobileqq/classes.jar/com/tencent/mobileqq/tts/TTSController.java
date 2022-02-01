package com.tencent.mobileqq.tts;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qqaudio.QQAudioUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.util.WeakReferenceHandler;
import mqq.manager.TicketManager;

public class TTSController
  implements Handler.Callback
{
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private SilkStreamPlayer.OnSilkStreamPlay jdField_a_of_type_ComTencentMobileqqTtsSilkStreamPlayer$OnSilkStreamPlay;
  private SilkStreamPlayer jdField_a_of_type_ComTencentMobileqqTtsSilkStreamPlayer;
  private TTSController.OnTTSPlayListener jdField_a_of_type_ComTencentMobileqqTtsTTSController$OnTTSPlayListener;
  protected QQProgressDialog a;
  private TicketManager jdField_a_of_type_MqqManagerTicketManager;
  
  public TTSController(AppInterface paramAppInterface, Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_MqqManagerTicketManager = ((TicketManager)paramAppInterface.getManager(2));
    this.jdField_a_of_type_AndroidOsHandler = new WeakReferenceHandler(this);
    this.jdField_a_of_type_ComTencentMobileqqTtsSilkStreamPlayer$OnSilkStreamPlay = new TTSController.1(this);
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299166));
    }
    if (!((Activity)this.jdField_a_of_type_AndroidContentContext).isFinishing()) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
    }
  }
  
  private void d()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTtsSilkStreamPlayer != null) {
      this.jdField_a_of_type_ComTencentMobileqqTtsSilkStreamPlayer.a();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTtsSilkStreamPlayer$OnSilkStreamPlay != null) {
      if (this.jdField_a_of_type_ComTencentMobileqqTtsSilkStreamPlayer == null) {
        break label71;
      }
    }
    label71:
    for (String str = this.jdField_a_of_type_ComTencentMobileqqTtsSilkStreamPlayer.a();; str = "")
    {
      this.jdField_a_of_type_ComTencentMobileqqTtsSilkStreamPlayer$OnSilkStreamPlay.b(str);
      if (this.jdField_a_of_type_ComTencentMobileqqTtsTTSController$OnTTSPlayListener != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqTtsTTSController$OnTTSPlayListener.b();
        QQAudioUtils.a(BaseApplicationImpl.getContext(), false);
      }
      return;
    }
  }
  
  public void a(TTSController.OnTTSPlayListener paramOnTTSPlayListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqTtsTTSController$OnTTSPlayListener = paramOnTTSPlayListener;
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    if (!NetworkUtil.g(this.jdField_a_of_type_AndroidContentContext)) {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, HardCodeUtil.a(2131715690), 1).a();
    }
    do
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqTtsSilkStreamPlayer = new SilkStreamPlayer(this.jdField_a_of_type_AndroidContentContext, paramString1, paramString2, this.jdField_a_of_type_MqqManagerTicketManager.getSkey(paramString2));
      this.jdField_a_of_type_ComTencentMobileqqTtsSilkStreamPlayer.a(paramString3);
      this.jdField_a_of_type_ComTencentMobileqqTtsSilkStreamPlayer.a(this.jdField_a_of_type_ComTencentMobileqqTtsSilkStreamPlayer$OnSilkStreamPlay, 0, 0);
    } while (this.jdField_a_of_type_ComTencentMobileqqTtsTTSController$OnTTSPlayListener == null);
    QQAudioUtils.a(BaseApplicationImpl.getContext(), true);
    this.jdField_a_of_type_ComTencentMobileqqTtsTTSController$OnTTSPlayListener.a();
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTtsSilkStreamPlayer != null) {
      return this.jdField_a_of_type_ComTencentMobileqqTtsSilkStreamPlayer.a();
    }
    return false;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTtsSilkStreamPlayer != null) {
      this.jdField_a_of_type_ComTencentMobileqqTtsSilkStreamPlayer.b();
    }
    this.jdField_a_of_type_ComTencentMobileqqTtsTTSController$OnTTSPlayListener = null;
    this.jdField_a_of_type_ComTencentMobileqqTtsSilkStreamPlayer$OnSilkStreamPlay = null;
    QQAudioUtils.a(BaseApplicationImpl.getContext(), false);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      c();
      continue;
      d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.tts.TTSController
 * JD-Core Version:    0.7.0.1
 */