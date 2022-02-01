package com.tencent.mobileqq.hotchat;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotchat.api.IHotChatSCHelper;
import com.tencent.mobileqq.hotchat.api.IHotChatSCHelper.OnShowNoteListener;
import com.tencent.mobileqq.hotchat.api.IHotChatSCMng;
import com.tencent.mobileqq.hotchat.helper.HotChatHelper;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;

public class HotChatSCHelper
  implements Handler.Callback, HotChatSCMng.HCSCObserver, IHotChatSCHelper
{
  static final long MIN_INTERVAL = 60000L;
  static final int MSG_GET_NOTE_TOSHOW = 0;
  static final int MSG_START_DELAY = 2;
  public String mActID;
  public QQAppInterface mApp;
  public boolean mCurShowingNote;
  Handler mHandler;
  IHotChatSCHelper.OnShowNoteListener mListener;
  public HotChatSCMng mMang;
  public long mStartTime;
  public boolean mStarting;
  
  public HotChatSCHelper(QQAppInterface paramQQAppInterface, IHotChatSCHelper.OnShowNoteListener paramOnShowNoteListener, String paramString)
  {
    this.mApp = paramQQAppInterface;
    this.mMang = ((HotChatSCMng)paramQQAppInterface.getManager(QQManagerFactory.HOTCHAT_SCENE_CONFIG_MANAGER));
    this.mListener = paramOnShowNoteListener;
    this.mActID = paramString;
    this.mHandler = new WeakReferenceHandler(Looper.getMainLooper(), this);
    if (QLog.isDevelopLevel()) {
      NearbyUtils.a("HotchatSCMng", "HotchatSCHelper", new Object[] { paramString, this.mListener });
    }
  }
  
  public void destroy()
  {
    stopCheck();
    this.mListener = null;
    NearbyUtils.a("HotchatSCMng", "destroy", new Object[0]);
  }
  
  public String getActID()
  {
    return this.mActID;
  }
  
  public boolean getCurShowingNote()
  {
    return this.mCurShowingNote;
  }
  
  public IHotChatSCMng getHotChatSCMng()
  {
    return this.mMang;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (!this.mStarting) {
      return true;
    }
    if (paramMessage.what == 0)
    {
      long l2 = HotChatHelper.a();
      paramMessage = this.mMang.getHotChatNote(this.mActID, 0, l2);
      NearbyUtils.a("HotchatSCMng", "MSG_GET_NOTE_TOSHOW", new Object[] { "cur", paramMessage });
      IHotChatSCHelper.OnShowNoteListener localOnShowNoteListener = this.mListener;
      if (localOnShowNoteListener != null)
      {
        if (paramMessage != null) {
          paramMessage.g = localOnShowNoteListener.a(paramMessage);
        } else {
          localOnShowNoteListener.a(null);
        }
      }
      else {
        NearbyUtils.a("HotchatSCMng", "MSG_GET_NOTE_TOSHOW", new Object[] { "listener is null" });
      }
      long l1;
      if (paramMessage != null) {
        l1 = paramMessage.f - l2;
      } else {
        l1 = 0L;
      }
      if (l1 > 0L)
      {
        this.mHandler.sendEmptyMessageDelayed(0, l1 + 100L);
        return true;
      }
      paramMessage = this.mMang.getHotChatNote(this.mActID, 2, l2);
      NearbyUtils.a("HotchatSCMng", "MSG_GET_NOTE_TOSHOW", new Object[] { "next", paramMessage });
      if (paramMessage != null)
      {
        l1 = Math.max(60000L, paramMessage.e - l2);
        this.mHandler.sendEmptyMessageDelayed(0, l1);
        return true;
      }
      this.mStarting = false;
      NearbyUtils.a("HotchatSCMng", "MSG_GET_NOTE_TOSHOW", new Object[] { "stop check" });
      return true;
    }
    if (paramMessage.what == 2) {
      startCheck(100L);
    }
    return true;
  }
  
  public void onConfigUpdate()
  {
    NearbyUtils.a("HotchatSCMng", "onConfigUpdate", new Object[0]);
    startCheck(500L);
  }
  
  public void setCurShowingNote(boolean paramBoolean)
  {
    this.mCurShowingNote = paramBoolean;
  }
  
  public void startCheck(long paramLong)
  {
    NearbyUtils.a("HotchatSCMng", "startCheck", new Object[] { Boolean.valueOf(this.mStarting), Long.valueOf(paramLong), Boolean.valueOf(this.mMang.mIsInitCache) });
    this.mHandler.removeMessages(2);
    if (this.mStarting) {
      return;
    }
    this.mStarting = true;
    if (this.mMang.mIsInitCache)
    {
      this.mHandler.removeMessages(0);
      this.mHandler.sendEmptyMessageDelayed(0, paramLong);
    }
    else
    {
      ThreadManager.post(new HotChatSCHelper.1(this, paramLong, System.currentTimeMillis()), 8, null, true);
    }
    this.mMang.addObserver(this);
  }
  
  public void startCheckDelay(long paramLong)
  {
    NearbyUtils.a("HotchatSCMng", "startCheckDelay", new Object[] { Boolean.valueOf(this.mStarting), Long.valueOf(paramLong), Boolean.valueOf(this.mMang.mIsInitCache) });
    this.mHandler.sendEmptyMessageDelayed(2, paramLong);
  }
  
  public void stopCheck()
  {
    this.mStarting = false;
    this.mHandler.removeCallbacksAndMessages(null);
    this.mMang.removeObserver(this);
    NearbyUtils.a("HotchatSCMng", "stopCheck", new Object[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.hotchat.HotChatSCHelper
 * JD-Core Version:    0.7.0.1
 */