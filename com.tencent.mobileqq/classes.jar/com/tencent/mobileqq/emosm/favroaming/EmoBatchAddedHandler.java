package com.tencent.mobileqq.emosm.favroaming;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.aio.stickerrecommended.impl.StickerRecManagerImpl;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.emosm.api.IFavroamingDBManagerService;
import com.tencent.mobileqq.emoticon.EmoticonOperateReport;
import com.tencent.mobileqq.emoticon.IChatHistoryEmotionBaseFragment;
import com.tencent.mobileqq.emoticonview.api.IEmosmService;
import com.tencent.mobileqq.multimsg.save.FileSaveDialog;
import com.tencent.mobileqq.multimsg.save.FileSaveDialog.IFileSaveCancelInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class EmoBatchAddedHandler
  implements Handler.Callback, IEmoBatchAddedHandler
{
  int jdField_a_of_type_Int;
  Handler jdField_a_of_type_AndroidOsHandler;
  BaseQQAppInterface jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface;
  IChatHistoryEmotionBaseFragment jdField_a_of_type_ComTencentMobileqqEmoticonIChatHistoryEmotionBaseFragment;
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
  
  public EmoBatchAddedHandler(IChatHistoryEmotionBaseFragment paramIChatHistoryEmotionBaseFragment, BaseQQAppInterface paramBaseQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqEmoticonIChatHistoryEmotionBaseFragment = paramIChatHistoryEmotionBaseFragment;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
    this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface = paramBaseQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveDialog$IFileSaveCancelInterface = new EmoBatchAddedHandler.1(this);
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
  }
  
  private void b()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = true;
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveDialog;
      if ((localObject != null) && (((FileSaveDialog)localObject).isShowing()))
      {
        this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveDialog.dismiss();
        this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveDialog = null;
      }
      localObject = this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface.getHandler(((IEmosmService)QRoute.api(IEmosmService.class)).getChatActivityClass());
      if (localObject != null) {
        ((MqqHandler)localObject).obtainMessage(10).sendToTarget();
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqEmoticonIChatHistoryEmotionBaseFragment;
      if (localObject != null)
      {
        ((IChatHistoryEmotionBaseFragment)localObject).changeToUnSelected();
        if (this.c > 0)
        {
          QQToast.a(MobileQQ.getContext(), 1, MobileQQ.getContext().getString(2131691321), 1).a();
        }
        else if (this.e == this.jdField_a_of_type_Int)
        {
          QQToast.a(MobileQQ.getContext(), 1, MobileQQ.getContext().getString(2131691902), 1).a();
        }
        else
        {
          int i = this.d;
          if (i == 0) {
            QQToast.a(MobileQQ.getContext(), 1, MobileQQ.getContext().getString(2131691900), 1).a();
          } else if (i > 0) {
            if (this.f > 0) {
              QQToast.a(MobileQQ.getContext(), 0, MobileQQ.getContext().getString(2131691901), 1).a();
            } else {
              QQToast.a(MobileQQ.getContext(), 2, MobileQQ.getContext().getString(2131691903), 1).a();
            }
          }
        }
      }
      StickerRecManagerImpl.get(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface).updateKeywordForFavEmotion();
      EmoticonOperateReport.reportEmoticonOperateMonitorAddStatus("0", 1);
    }
  }
  
  public int a()
  {
    return this.g;
  }
  
  public int a(Integer paramInteger)
  {
    return this.h + paramInteger.intValue();
  }
  
  public int a(String paramString)
  {
    Map localMap = this.jdField_a_of_type_JavaUtilMap;
    if (localMap != null) {
      return ((Integer)localMap.get(paramString)).intValue();
    }
    return -1;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveDialog = new FileSaveDialog(this.jdField_a_of_type_ComTencentMobileqqEmoticonIChatHistoryEmotionBaseFragment.getBaseActivity());
    this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveDialog.a(this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveDialog$IFileSaveCancelInterface);
    this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveDialog.show();
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_b_of_type_Int = paramInt;
    paramInt = 0;
    this.c = 0;
    this.d = 0;
    this.e = 0;
    this.f = 0;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilMap.clear();
    this.h = 1;
    this.g = 0;
    List localList = ((IFavroamingDBManagerService)this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface.getRuntimeService(IFavroamingDBManagerService.class)).getEmoticonDataList();
    if (localList != null) {
      while (paramInt < localList.size())
      {
        int i = ((CustomEmotionData)localList.get(paramInt)).emoId;
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
    int i = paramMessage.what;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4)
          {
            if (i == 100)
            {
              a();
              return true;
            }
          }
          else {
            this.d += 1;
          }
        }
        else {
          this.f += 1;
        }
      }
      else {
        this.e += 1;
      }
    }
    else {
      this.c += 1;
    }
    this.jdField_b_of_type_Int -= 1;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveDialog;
    if (localObject != null)
    {
      i = this.jdField_a_of_type_Int;
      ((FileSaveDialog)localObject).a((i - this.jdField_b_of_type_Int) * 100 / i);
    }
    if ((this.jdField_b_of_type_Int <= 0) || (paramMessage.what == 1)) {
      b();
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("ahandleMessage =");
    ((StringBuilder)localObject).append(paramMessage.what);
    ((StringBuilder)localObject).append(",mNeedAddCount:");
    ((StringBuilder)localObject).append(this.jdField_b_of_type_Int);
    ((StringBuilder)localObject).append(",mTotalCount:");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
    QLog.d("EmoBatchAdded", 2, ((StringBuilder)localObject).toString());
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.favroaming.EmoBatchAddedHandler
 * JD-Core Version:    0.7.0.1
 */