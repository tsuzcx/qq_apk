package com.tencent.mobileqq.minigame.publicaccount.view;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.ark.ArkViewImplement.LoadCallback;
import com.tencent.ark.open.ArkView;
import com.tencent.gamecenter.wadl.biz.entity.WadlReportBuilder;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.minigame.publicaccount.model.QQGameMsgInfo;
import com.tencent.mobileqq.qqgamepub.utils.GamePubAccountHelper;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;

public class GameArkView
  extends RelativeLayout
  implements ArkViewImplement.LoadCallback, IHeaderView
{
  public static final int STATE_VIDEO_ARK_INVISIBLE = 102;
  public static final int STATE_VIDEO_ARK_VISIBLE = 101;
  private static final String TAG = "GameArkView";
  private String appName;
  private ArkView arkView;
  private View arkViewContainer;
  private boolean isPrePause = true;
  private int mCurArkState = 101;
  private QQGameMsgInfo mGameMsgInfo;
  private WeakReference<GameArkView.LoadGameArkCallback> mLoadCallbackRef = new WeakReference(null);
  private int mPosition;
  private String mPubType;
  
  public GameArkView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    LayoutInflater.from(getContext()).inflate(2030305281, this);
    this.arkViewContainer = findViewById(2030239764);
    this.arkView = ((ArkView)findViewById(2030239763));
    for (;;)
    {
      try
      {
        paramContext = getResources().getDisplayMetrics();
        if (QLog.isColorLevel())
        {
          paramAttributeSet = new StringBuilder();
          paramAttributeSet.append(" density= ");
          paramAttributeSet.append(paramContext);
          if (paramAttributeSet.toString() == null) {
            break label235;
          }
          f = paramContext.density;
          QLog.d("GameArkView", 4, new Object[] { Float.valueOf(f) });
        }
        f = FontSettingManager.systemMetrics.density;
        if (paramContext != null)
        {
          f = Math.min(f, paramContext.density);
          if (QLog.isColorLevel())
          {
            paramContext = new StringBuilder();
            paramContext.append("min density= ");
            paramContext.append(f);
            QLog.d("GameArkView", 4, paramContext.toString());
          }
          this.arkView.setScaleDensity(f);
          return;
        }
      }
      catch (Throwable paramContext)
      {
        paramAttributeSet = new StringBuilder();
        paramAttributeSet.append("set ark density fail:");
        paramAttributeSet.append(paramContext.getMessage());
        QLog.d("GameArkView", 4, paramAttributeSet.toString());
      }
      return;
      label235:
      float f = -1.0F;
    }
  }
  
  public void destory()
  {
    ArkView localArkView = this.arkView;
    if (localArkView != null) {
      localArkView.onDestroy();
    }
  }
  
  public String getAppName()
  {
    return this.appName;
  }
  
  public ArkView getArkView()
  {
    return this.arkView;
  }
  
  public View getArkViewContainer()
  {
    return this.arkViewContainer;
  }
  
  public void init(MessageRecord paramMessageRecord, Activity paramActivity)
  {
    if (this.arkView != null)
    {
      paramMessageRecord = (MessageForArkApp)paramMessageRecord;
      if (paramMessageRecord != null)
      {
        this.appName = paramMessageRecord.ark_app_message.appName;
        this.arkView.load(paramMessageRecord.ark_app_message.appName, paramMessageRecord.ark_app_message.appView, paramMessageRecord.ark_app_message.appMinVersion, paramMessageRecord.ark_app_message.metaList, paramMessageRecord.ark_app_message.config, this);
      }
    }
  }
  
  public void init(QQGameMsgInfo paramQQGameMsgInfo, Activity paramActivity, int paramInt, String paramString)
  {
    this.mPosition = paramInt;
    this.mPubType = paramString;
    if (this.arkView != null)
    {
      this.mGameMsgInfo = paramQQGameMsgInfo;
      this.appName = paramQQGameMsgInfo.arkAppName;
      this.arkView.load(paramQQGameMsgInfo.arkAppName, paramQQGameMsgInfo.arkAppView, paramQQGameMsgInfo.arkAppMinVersion, paramQQGameMsgInfo.arkMetaList, paramQQGameMsgInfo.arkAppConfig, this);
    }
  }
  
  public boolean isVisible()
  {
    return this.mCurArkState == 101;
  }
  
  public void onDestory()
  {
    if (this.arkView != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("GameArkView", 1, "GameArkView onDestory");
      }
      this.arkView.onDestroy();
    }
  }
  
  public void onLoadFailed(int paramInt1, int paramInt2, String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onLoadFailed state=");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append("|errCode=");
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append("|errMsg=");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("|canRetry=");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("GameArkView", 1, ((StringBuilder)localObject).toString());
    }
    Object localObject = (GameArkView.LoadGameArkCallback)this.mLoadCallbackRef.get();
    if (localObject != null) {
      ((GameArkView.LoadGameArkCallback)localObject).onLoadFinish(paramInt1, this.mPosition);
    }
    localObject = GamePubAccountHelper.a(this.mPubType).d("76918").c("207984").a(2, this.mGameMsgInfo.advId).b(this.mGameMsgInfo.gameAppId).a(18, this.mGameMsgInfo.arkAppName);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("");
    localObject = ((WadlReportBuilder)localObject).a(19, localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt2);
    localStringBuilder.append("");
    paramString = ((WadlReportBuilder)localObject).a(20, localStringBuilder.toString()).a(21, paramString);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramBoolean);
    ((StringBuilder)localObject).append("");
    paramString.a(22, ((StringBuilder)localObject).toString()).a();
  }
  
  public void onLoadState(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onLoadState state=");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("GameArkView", 1, ((StringBuilder)localObject).toString());
    }
    Object localObject = (GameArkView.LoadGameArkCallback)this.mLoadCallbackRef.get();
    if (localObject != null) {
      ((GameArkView.LoadGameArkCallback)localObject).onLoadFinish(paramInt, this.mPosition);
    }
    ThreadManagerV2.getUIHandlerV2().postDelayed(new GameArkView.1(this), 500L);
    localObject = GamePubAccountHelper.a(this.mPubType).d("76918").c("207984").a(2, this.mGameMsgInfo.advId).b(this.mGameMsgInfo.gameAppId).a(18, this.mGameMsgInfo.arkAppName);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt);
    localStringBuilder.append("");
    ((WadlReportBuilder)localObject).a(29, localStringBuilder.toString()).a();
  }
  
  public void onPause()
  {
    if (this.arkView != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("GameArkView", 1, "GameArkView onPause");
      }
      this.mCurArkState = 102;
      this.arkView.onPause();
    }
  }
  
  public void onResume()
  {
    if (this.arkView != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("GameArkView", 1, "GameArkView onResume");
      }
      this.mCurArkState = 101;
      this.arkView.onResume();
    }
  }
  
  public void onStop() {}
  
  public void setLoadCallback(GameArkView.LoadGameArkCallback paramLoadGameArkCallback)
  {
    this.mLoadCallbackRef = new WeakReference(paramLoadGameArkCallback);
  }
  
  public void setPrePause(boolean paramBoolean)
  {
    this.isPrePause = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.publicaccount.view.GameArkView
 * JD-Core Version:    0.7.0.1
 */