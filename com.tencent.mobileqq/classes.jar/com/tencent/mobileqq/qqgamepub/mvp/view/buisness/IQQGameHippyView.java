package com.tencent.mobileqq.qqgamepub.mvp.view.buisness;

import androidx.viewpager.widget.ViewPager;
import com.tencent.mobileqq.qqgamepub.data.GmpEnterInfoRsp;
import com.tencent.mobileqq.qqgamepub.mvp.presenter.buisness.QQGameHippyBasePresenter;

public abstract interface IQQGameHippyView<P extends QQGameHippyBasePresenter>
  extends IQQGameHippyBaseView<P>
{
  public abstract void a(GmpEnterInfoRsp paramGmpEnterInfoRsp, boolean paramBoolean);
  
  public abstract void a(boolean paramBoolean, int paramInt);
  
  public abstract void b(int paramInt);
  
  public abstract void c(int paramInt);
  
  public abstract void d(int paramInt);
  
  public abstract ViewPager g();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.mvp.view.buisness.IQQGameHippyView
 * JD-Core Version:    0.7.0.1
 */