package com.tencent.mobileqq.gamecenter.view;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import asjl;
import com.tencent.ark.open.ArkView;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.gamecenter.web.QQGameMsgInfo;

public class GameArkView
  extends RelativeLayout
  implements asjl
{
  private ArkView a;
  
  public GameArkView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    LayoutInflater.from(getContext()).inflate(2131559136, this);
    this.a = ((ArkView)findViewById(2131373617));
  }
  
  public void a()
  {
    if (this.a != null) {
      this.a.onDestroy();
    }
  }
  
  public void a(MessageRecord paramMessageRecord, Activity paramActivity) {}
  
  public void a(QQGameMsgInfo paramQQGameMsgInfo, Activity paramActivity, int paramInt)
  {
    if (this.a != null) {
      this.a.load(paramQQGameMsgInfo.arkAppName, paramQQGameMsgInfo.arkAppView, paramQQGameMsgInfo.arkAppMinVersion, paramQQGameMsgInfo.arkMetaList, paramQQGameMsgInfo.arkAppConfig, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.view.GameArkView
 * JD-Core Version:    0.7.0.1
 */