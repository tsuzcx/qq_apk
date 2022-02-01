package com.tencent.mobileqq.emosm.favroaming;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecManager;
import com.tencent.mobileqq.activity.history.ChatHistoryEmotionBaseFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.mobileqq.multimsg.save.FileSaveDialog;
import com.tencent.mobileqq.multimsg.save.FileSaveDialog.IFileSaveCancelInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mqq.os.MqqHandler;

public class EmoBatchAddedHandler
  implements Handler.Callback
{
  int jdField_a_of_type_Int;
  Handler jdField_a_of_type_AndroidOsHandler;
  ChatHistoryEmotionBaseFragment jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryEmotionBaseFragment;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  FileSaveDialog.IFileSaveCancelInterface jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveDialog$IFileSaveCancelInterface;
  FileSaveDialog jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveDialog;
  public Map<String, Integer> a;
  boolean jdField_a_of_type_Boolean = false;
  int b;
  public boolean b;
  int c;
  int d;
  int e;
  int f;
  public int g;
  int h;
  
  public EmoBatchAddedHandler(ChatHistoryEmotionBaseFragment paramChatHistoryEmotionBaseFragment, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryEmotionBaseFragment = paramChatHistoryEmotionBaseFragment;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveDialog$IFileSaveCancelInterface = new EmoBatchAddedHandler.1(this);
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
  }
  
  public static void a(EmoBatchAddedCallback paramEmoBatchAddedCallback, int paramInt)
  {
    if ((paramEmoBatchAddedCallback != null) && (paramEmoBatchAddedCallback.a != null)) {
      paramEmoBatchAddedCallback.a.b(paramInt);
    }
  }
  
  private void b()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = true;
      if (this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveDialog.isShowing())
      {
        this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveDialog.dismiss();
        this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveDialog = null;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryEmotionBaseFragment.v();
      MqqHandler localMqqHandler = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(ChatActivity.class);
      if (localMqqHandler != null) {
        localMqqHandler.obtainMessage(10).sendToTarget();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryEmotionBaseFragment != null)
      {
        if (this.c <= 0) {
          break label115;
        }
        QQToast.a(BaseApplicationImpl.getApplication(), 1, BaseApplicationImpl.getApplication().getString(2131691399), 1).a();
      }
    }
    for (;;)
    {
      StickerRecManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).h();
      EmoticonManager.c("0", 1);
      return;
      label115:
      if (this.e == this.jdField_a_of_type_Int) {
        QQToast.a(BaseApplicationImpl.getApplication(), 1, BaseApplicationImpl.getApplication().getString(2131691981), 1).a();
      } else if (this.d == 0) {
        QQToast.a(BaseApplicationImpl.getApplication(), 1, BaseApplicationImpl.getApplication().getString(2131691975), 1).a();
      } else if (this.d > 0) {
        if (this.f > 0) {
          QQToast.a(BaseApplicationImpl.getApplication(), 0, BaseApplicationImpl.getApplication().getString(2131691977), 1).a();
        } else {
          QQToast.a(BaseApplicationImpl.getApplication(), 2, BaseApplicationImpl.getApplication().getString(2131691982), 1).a();
        }
      }
    }
  }
  
  public int a(Integer paramInteger)
  {
    return this.h + paramInteger.intValue();
  }
  
  public int a(String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilMap != null) {
      return ((Integer)this.jdField_a_of_type_JavaUtilMap.get(paramString)).intValue();
    }
    return -1;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveDialog = new FileSaveDialog(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryEmotionBaseFragment.getActivity());
    this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveDialog.a(this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveDialog$IFileSaveCancelInterface);
    this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveDialog.show();
  }
  
  public void a(int paramInt)
  {
    int i = 0;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_b_of_type_Int = paramInt;
    this.c = 0;
    this.d = 0;
    this.e = 0;
    this.f = 0;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilMap.clear();
    this.h = 1;
    this.g = 0;
    List localList = ((FavroamingDBManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FAVROAMING_DB_MANAGER)).a();
    if (localList != null)
    {
      paramInt = i;
      while (paramInt < localList.size())
      {
        i = ((CustomEmotionData)localList.get(paramInt)).emoId;
        if (this.h < i) {
          this.h = i;
        }
        if ((TextUtils.isEmpty(((CustomEmotionData)localList.get(paramInt)).RomaingType)) || (!"needDel".equals(((CustomEmotionData)localList.get(paramInt)).RomaingType))) {
          this.g += 1;
        }
        paramInt += 1;
      }
    }
    this.h += 1;
  }
  
  public void a(String paramString, Integer paramInteger)
  {
    this.jdField_a_of_type_JavaUtilMap.put(paramString, Integer.valueOf(this.h + paramInteger.intValue()));
  }
  
  public boolean a(String paramString)
  {
    return this.jdField_a_of_type_JavaUtilMap.containsKey(paramString);
  }
  
  public void b(int paramInt)
  {
    try
    {
      if (this.jdField_a_of_type_AndroidOsHandler != null) {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(paramInt);
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (this.jdField_b_of_type_Boolean) {
      return false;
    }
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      this.jdField_b_of_type_Int -= 1;
      if (this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveDialog != null) {
        this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveDialog.a((this.jdField_a_of_type_Int - this.jdField_b_of_type_Int) * 100 / this.jdField_a_of_type_Int);
      }
      if ((this.jdField_b_of_type_Int <= 0) || (paramMessage.what == 1)) {
        b();
      }
      QLog.d("EmoBatchAdded", 2, "ahandleMessage =" + paramMessage.what + ",mNeedAddCount:" + this.jdField_b_of_type_Int + ",mTotalCount:" + this.jdField_a_of_type_Int);
      return true;
      a();
      return true;
      this.c += 1;
      continue;
      this.f += 1;
      continue;
      this.e += 1;
      continue;
      this.d += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.favroaming.EmoBatchAddedHandler
 * JD-Core Version:    0.7.0.1
 */