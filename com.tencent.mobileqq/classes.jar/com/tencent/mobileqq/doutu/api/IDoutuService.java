package com.tencent.mobileqq.doutu.api;

import android.widget.RelativeLayout;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.doutu.DoutuData;
import com.tencent.mobileqq.doutu.DoutuItem;
import com.tencent.mobileqq.doutu.DoutuMsgItem;
import com.tencent.mobileqq.doutu.IDoutuListener;
import com.tencent.mobileqq.qroute.annotation.Service;
import java.util.List;
import mqq.app.api.IRuntimeService;
import mqq.os.MqqHandler;

@Service(process={""})
public abstract interface IDoutuService
  extends IRuntimeService
{
  public abstract boolean checkLocalResFiles();
  
  public abstract void clearComboViews();
  
  public abstract void doOnChatDestory();
  
  public abstract void doOnLogin(boolean paramBoolean);
  
  public abstract MqqHandler getDoutuAnimationHandler();
  
  public abstract int handleAioMsgForDoutu(List<DoutuMsgItem> paramList, int paramInt);
  
  public abstract void handleGetDoutuList(boolean paramBoolean, List<DoutuData> paramList);
  
  public abstract void handleGetRecommendPicList(boolean paramBoolean, List<DoutuData> paramList, long paramLong);
  
  public abstract void handleGetRecommendPicTimeOut(long paramLong);
  
  public abstract boolean hasInited();
  
  public abstract void hideDoutuEmotionLayout();
  
  public abstract void init(RelativeLayout paramRelativeLayout, BaseQQAppInterface paramBaseQQAppInterface, QBaseActivity paramQBaseActivity, IDoutuListener paramIDoutuListener, String paramString1, String paramString2, String paramString3);
  
  public abstract void interruptAnimation();
  
  public abstract boolean isDoutuConfigOpen();
  
  public abstract boolean isDoutuSettingOpen();
  
  public abstract void refreshDoutuEmoData();
  
  public abstract void removeDoutuEmoLayout();
  
  public abstract void setApp(BaseQQAppInterface paramBaseQQAppInterface);
  
  public abstract void setComboShowSwitch(boolean paramBoolean);
  
  public abstract void showDoutuEmotionLayout(MqqHandler paramMqqHandler, DoutuItem paramDoutuItem, int paramInt);
  
  public abstract void updataDoutuConfig(boolean paramBoolean1, boolean paramBoolean2, long paramLong1, long paramLong2, long paramLong3, boolean paramBoolean3, int paramInt);
  
  public abstract void updateDoutuSetting(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.doutu.api.IDoutuService
 * JD-Core Version:    0.7.0.1
 */