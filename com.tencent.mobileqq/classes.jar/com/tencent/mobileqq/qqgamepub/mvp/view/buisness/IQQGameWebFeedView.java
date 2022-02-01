package com.tencent.mobileqq.qqgamepub.mvp.view.buisness;

import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qqgamepub.data.GmpEnterInfoRsp;
import com.tencent.mobileqq.qqgamepub.mvp.presenter.buisness.QQGameWebPresenter;
import com.tencent.mobileqq.qqgamepub.mvp.view.base.IView;
import eipc.EIPCResult;
import java.util.Map;

public abstract interface IQQGameWebFeedView
  extends IView<QQGameWebPresenter>
{
  public abstract void a();
  
  public abstract void a(GmpEnterInfoRsp paramGmpEnterInfoRsp, boolean paramBoolean);
  
  public abstract void a(EIPCResult paramEIPCResult);
  
  public abstract void a(String paramString);
  
  public abstract void a(Map<String, Object> paramMap);
  
  public abstract void a(boolean paramBoolean, int paramInt);
  
  public abstract void b();
  
  public abstract void b(int paramInt);
  
  public abstract void c(int paramInt);
  
  public abstract void d(int paramInt);
  
  public abstract void f();
  
  public abstract int g();
  
  public abstract int k();
  
  public abstract QBaseActivity l();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.mvp.view.buisness.IQQGameWebFeedView
 * JD-Core Version:    0.7.0.1
 */