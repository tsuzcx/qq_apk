package com.tencent.mobileqq.pluspanel.appinfo;

import afcm;
import android.app.Activity;
import android.content.res.Resources;
import android.os.Build.VERSION;
import ayfu;
import aygh;
import bfur;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mum;

public class ShareScreenAppInfo
  extends PlusPanelAppInfo
{
  public ShareScreenAppInfo() {}
  
  public ShareScreenAppInfo(int paramInt)
  {
    this.uinType = paramInt;
  }
  
  public int defaultDrawableID()
  {
    return 2130839205;
  }
  
  public int getAppID()
  {
    if (isC2C()) {
      return 221;
    }
    return 101850591;
  }
  
  public int getManageConfigID()
  {
    if (isC2C()) {
      return 600;
    }
    return 0;
  }
  
  public int getRedDotID()
  {
    if (isC2C()) {
      return 130221;
    }
    return getAppID();
  }
  
  public String getTitle()
  {
    return BaseApplicationImpl.getContext().getString(2131697969);
  }
  
  public void onPlusPanelAppClick(ayfu paramayfu, BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo)
  {
    int i;
    if (Build.VERSION.SDK_INT >= 21)
    {
      i = 1;
      if (i != 0) {
        break label78;
      }
    }
    label78:
    do
    {
      do
      {
        try
        {
          paramayfu = paramBaseChatPie.getActivity();
          paramBaseChatPie = paramayfu.getResources();
          bfur.a(paramayfu, 230, paramBaseChatPie.getString(2131691511), paramBaseChatPie.getString(2131695382), 0, 2131695151, new aygh(this), null).show();
          return;
        }
        catch (Throwable paramayfu)
        {
          QLog.i("ShareScreenAppInfo", 1, "clickToolShareScreen", paramayfu);
          return;
        }
        i = 0;
        break;
      } while (paramBaseChatPie.app.getAVNotifyCenter().a(paramBaseChatPie.getActivity(), 3, paramSessionInfo.curType, paramSessionInfo.curFriendUin));
      if (paramSessionInfo.curType == 1)
      {
        showSelGAudioChatEntryActionSheet(paramBaseChatPie, paramSessionInfo, 10, false, "AIOShareScreen");
        mum.a("0X800AD8E", 2);
        return;
      }
      if (paramSessionInfo.curType == 0)
      {
        paramBaseChatPie.hidePanel();
        paramayfu.b(paramBaseChatPie);
        afcm.a(paramBaseChatPie.app, paramBaseChatPie.getActivity(), paramSessionInfo, true, "AIOShareScreen", null);
        mum.a("0X800AD8E", 1);
        paramBaseChatPie.getActivity().setCanLock(false);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.i("ShareScreenAppInfo", 2, "clickToolShareScreen, not support chat, [" + paramSessionInfo.curType + "]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.pluspanel.appinfo.ShareScreenAppInfo
 * JD-Core Version:    0.7.0.1
 */