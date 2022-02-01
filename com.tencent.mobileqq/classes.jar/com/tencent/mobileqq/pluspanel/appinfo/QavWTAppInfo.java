package com.tencent.mobileqq.pluspanel.appinfo;

import ahvi;
import android.content.Context;
import android.content.res.Resources;
import bdla;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.pluspanel.PlusPanelAppInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mzq;
import nab;
import nad;

public class QavWTAppInfo
  extends PlusPanelAppInfo
{
  public QavWTAppInfo() {}
  
  public QavWTAppInfo(int paramInt)
  {
    this.uinType = paramInt;
  }
  
  public int defaultDrawableID()
  {
    return 2130839220;
  }
  
  public int getAppID()
  {
    if (isC2C()) {
      return 223;
    }
    return 0;
  }
  
  public int getManageConfigID()
  {
    if (isC2C()) {
      return 683;
    }
    return 0;
  }
  
  public int getRedDotID()
  {
    if (isC2C()) {
      return 130223;
    }
    return 0;
  }
  
  public String getTitle()
  {
    return BaseApplicationImpl.getContext().getString(2131698215);
  }
  
  public void onPlusPanelAppClick(ahvi paramahvi, BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo)
  {
    if (paramBaseChatPie.app.getAVNotifyCenter().a(paramBaseChatPie.getActivity(), 4, paramSessionInfo.curType, paramSessionInfo.curFriendUin)) {}
    do
    {
      return;
      int i;
      if (!AppNetConnInfo.isNetSupport())
      {
        paramahvi = BaseApplicationImpl.getContext();
        i = paramahvi.getResources().getDimensionPixelSize(2131299080);
        QQToast.a(paramahvi, -1, paramahvi.getString(2131695738), 0).b(i);
        return;
      }
      if (!nad.a())
      {
        paramahvi = BaseApplicationImpl.getContext();
        i = paramahvi.getResources().getDimensionPixelSize(2131299080);
        QQToast.a(paramahvi, -1, paramahvi.getString(2131695753), 0).b(i);
        return;
      }
      if (paramSessionInfo.curType == 0)
      {
        paramBaseChatPie.hidePanel();
        paramahvi.b(paramBaseChatPie);
        mzq.a().a(paramSessionInfo);
        nab.a(paramBaseChatPie.getActivity(), 1, paramSessionInfo.curType, paramSessionInfo.curFriendUin);
        paramBaseChatPie.getActivity().setCanLock(false);
        bdla.b(paramBaseChatPie.app, "dc00898", "", "", "0X800B61B", "0X800B61B", 0, 0, "", "", "", "");
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.i("QavWTAppInfo", 2, "clickToolQavWatchTogether, not support chat, [" + paramSessionInfo.curType + "]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.pluspanel.appinfo.QavWTAppInfo
 * JD-Core Version:    0.7.0.1
 */