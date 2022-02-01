package com.tencent.statemachine;

import android.text.TextUtils;
import com.tencent.hippy.qq.preload.TabPreloadManager;
import com.tencent.mobileqq.activity.home.impl.FrameControllerUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.statemachine.api.StateObserver;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class MainStateManager
{
  private static final String TAG = "MainStateManager";
  private static volatile MainStateManager sMainStateManager;
  private String mCurrentState;
  private int mCurrentTabIndex = -2147483648;
  private boolean mIsDrawerOpened = false;
  private Object mObserverLock = new Object();
  private ArrayList<StateObserver> mStateObservers = new ArrayList();
  
  private MainStateManager()
  {
    registerObservers();
  }
  
  private String convertTabIndexToState(int paramInt)
  {
    if (paramInt == FrameControllerUtil.a) {
      return "main_message_tab_show";
    }
    if (paramInt == FrameControllerUtil.c) {
      return "main_contacts_tab_show";
    }
    if (paramInt == FrameControllerUtil.g) {
      return "main_kandian_tab_show";
    }
    if (paramInt == FrameControllerUtil.d) {
      return "main_dynamic_tab_show";
    }
    return null;
  }
  
  public static MainStateManager getInstance()
  {
    if (sMainStateManager == null) {
      try
      {
        if (sMainStateManager == null) {
          sMainStateManager = new MainStateManager();
        }
      }
      finally {}
    }
    return sMainStateManager;
  }
  
  private void onMainFragmentShow()
  {
    if (this.mIsDrawerOpened)
    {
      changeMainState("main_drawer_tab_show");
      return;
    }
    int i = this.mCurrentTabIndex;
    if (i != -2147483648)
    {
      String str = convertTabIndexToState(i);
      if (!TextUtils.isEmpty(str)) {
        changeMainState(str);
      }
    }
  }
  
  private void registerObservers()
  {
    addMainStateObserver(TabPreloadManager.getInstance().getStateObserver());
  }
  
  public void addMainStateObserver(StateObserver paramStateObserver)
  {
    if (paramStateObserver == null) {
      return;
    }
    synchronized (this.mObserverLock)
    {
      if (!this.mStateObservers.contains(paramStateObserver)) {
        this.mStateObservers.add(paramStateObserver);
      }
      return;
    }
  }
  
  public void changeMainState(String paramString)
  {
    if (!MobileQQ.sMobileQQ.waitAppRuntime(null).isLogin()) {
      return;
    }
    if ((paramString != null) && (paramString.equals(this.mCurrentState))) {
      return;
    }
    synchronized (this.mObserverLock)
    {
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("changeMainState newState:");
        ((StringBuilder)localObject2).append(paramString);
        ((StringBuilder)localObject2).append(" oldState:");
        ((StringBuilder)localObject2).append(this.mCurrentState);
        QLog.i("MainStateManager", 2, ((StringBuilder)localObject2).toString());
      }
      Object localObject2 = this.mStateObservers.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        StateObserver localStateObserver = (StateObserver)((Iterator)localObject2).next();
        try
        {
          localStateObserver.onStateChanged(paramString, this.mCurrentState);
        }
        catch (Throwable localThrowable)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("changeMainState newState:");
          localStringBuilder.append(paramString);
          localStringBuilder.append(" oldState:");
          localStringBuilder.append(this.mCurrentState);
          localStringBuilder.append(" error:");
          localStringBuilder.append(localThrowable);
          QLog.e("MainStateManager", 1, localStringBuilder.toString());
        }
      }
      this.mCurrentState = paramString;
      return;
    }
    for (;;)
    {
      throw paramString;
    }
  }
  
  public void doAfterLogin()
  {
    if (QLog.isColorLevel()) {
      QLog.i("MainStateManager", 2, "doAfterLogin");
    }
    synchronized (this.mObserverLock)
    {
      this.mStateObservers.clear();
      registerObservers();
      return;
    }
  }
  
  public String getCurrentState()
  {
    return this.mCurrentState;
  }
  
  public void onMainDrawerChange(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.mIsDrawerOpened = true;
      changeMainState("main_drawer_tab_show");
      return;
    }
    this.mIsDrawerOpened = false;
    onMainFragmentShow();
  }
  
  public void onMainFragmentChange(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      onMainFragmentShow();
      return;
    }
    changeMainState("main_activity_hide");
  }
  
  public void onMainTabChange(int paramInt)
  {
    String str = convertTabIndexToState(paramInt);
    if (!TextUtils.isEmpty(str))
    {
      this.mCurrentTabIndex = paramInt;
      changeMainState(str);
    }
  }
  
  public void removeMainStateObserver(StateObserver paramStateObserver)
  {
    synchronized (this.mObserverLock)
    {
      this.mStateObservers.remove(paramStateObserver);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.statemachine.MainStateManager
 * JD-Core Version:    0.7.0.1
 */