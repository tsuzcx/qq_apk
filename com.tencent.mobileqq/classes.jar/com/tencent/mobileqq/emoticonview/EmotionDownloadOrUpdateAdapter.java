package com.tencent.mobileqq.emoticonview;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.EmoticonHandler;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emosm.EmosmUtils;
import com.tencent.mobileqq.emoticon.api.IEmojiManagerService;
import com.tencent.mobileqq.emoticon.api.IVasEmojiManagerService;
import com.tencent.mobileqq.emoticonview.api.IBigEmotionService;
import com.tencent.mobileqq.emoticonview.ipc.proxy.EmojiManagerServiceProxy;
import com.tencent.mobileqq.emoticonview.ipc.proxy.EmoticonHandlerProxy;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.ProgressButton;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.MqqWeakReferenceHandler;
import java.net.MalformedURLException;
import java.net.URL;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class EmotionDownloadOrUpdateAdapter
  extends EmotionNeedDownloadAdapter
  implements Handler.Callback, View.OnClickListener
{
  private static final int MSG_DOWNLOAD_END = 102;
  private static final int MSG_REFRESH_COVER = 100;
  private static final int MSG_REFRESH_PROGRESS = 101;
  public static final int TYPE_DATA = 1;
  public static final int TYPE_UPDATE = 0;
  private boolean authType;
  private int businessType;
  protected EmoticonPackage emotionPkg;
  protected EmotionDownloadOrUpdateAdapter.EmotionDownloadOrUpdateViewHolder holder;
  protected boolean isSmallEmotion;
  protected boolean isUpdatePanel;
  private MqqHandler mUiHandler;
  
  public EmotionDownloadOrUpdateAdapter(IEmoticonMainPanelApp paramIEmoticonMainPanelApp, Context paramContext, int paramInt1, int paramInt2, int paramInt3, EmoticonPackage paramEmoticonPackage, EmoticonCallback paramEmoticonCallback, int paramInt4)
  {
    super(paramIEmoticonMainPanelApp, paramContext, paramInt1, paramInt2, paramInt3, paramEmoticonCallback);
    boolean bool = true;
    this.authType = true;
    this.mUiHandler = new MqqWeakReferenceHandler(Looper.getMainLooper(), this, true);
    this.emotionPkg = paramEmoticonPackage;
    if (paramEmoticonPackage.jobType != 4) {
      bool = false;
    }
    this.isSmallEmotion = bool;
    this.businessType = paramInt4;
  }
  
  private void doDownloadOpr(boolean paramBoolean)
  {
    if (this.emotionPkg != null)
    {
      if (this.holder == null) {
        return;
      }
      if (QLog.isColorLevel())
      {
        localObject1 = TAG;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("doDownloadOpr epid = ");
        ((StringBuilder)localObject2).append(this.emotionPkg.epId);
        QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
      }
      Object localObject2 = this.holder.downloadBtn;
      if (localObject2 == null) {
        return;
      }
      if (paramBoolean)
      {
        isAuthorized();
        if (!this.authType) {
          return;
        }
      }
      if ((this.emotionPkg.epId != null) && (this.emotionPkg.epId.equals("10278")))
      {
        ((EmoticonHandlerProxy)this.app.getBusinessHandler(EmoticonHandler.a)).reportAddEmoticonPkg(this.emotionPkg.epId, this.businessType);
        ReportController.b(this.app.getQQAppInterface(), "CliOper", "", "", "ep_mall", "Ep_endoffer_click", 0, 0, "", "", "", "");
      }
      ((ProgressButton)localObject2).setProgressDrawable(((ProgressButton)localObject2).a(-16745986));
      Object localObject3 = (EmojiManagerServiceProxy)this.app.getRuntimeService(IEmojiManagerService.class);
      float f = ((EmojiManagerServiceProxy)localObject3).getEmoticonPackageLoadingProgress(this.emotionPkg.epId);
      int j = this.downBtnStatus;
      int i = 1;
      if (j == 2)
      {
        ((ProgressButton)localObject2).setText(MobileQQ.getContext().getString(2131699719));
        ((ProgressButton)localObject2).setProgress((int)f);
        ((EmojiManagerServiceProxy)localObject3).pullEmoticonPackage(this.emotionPkg, true, this.businessType);
        this.downBtnStatus = 1;
      }
      else if (this.downBtnStatus == 1)
      {
        localObject1 = MobileQQ.getContext().getString(2131699724);
        if (this.isUpdatePanel) {
          localObject1 = MobileQQ.getContext().getString(2131699774);
        }
        ((ProgressButton)localObject2).setText((CharSequence)localObject1);
        ((ProgressButton)localObject2).setProgress(0);
        this.downBtnStatus = 2;
        ((EmojiManagerServiceProxy)localObject3).stopEmoticonPackageDownload(this.emotionPkg.epId);
        this.mContext.getSharedPreferences("mobileQQ", 0).edit().remove("LAST_ADD_EMO_PACKAGE").commit();
        i = 2;
      }
      Object localObject1 = this.app.getQQAppInterface();
      localObject2 = this.emotionPkg.epId;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(i);
      ((StringBuilder)localObject3).append("");
      ReportController.b((AppRuntime)localObject1, "CliOper", "", "", "ep_mall", "0X80057B1", 0, 0, "", (String)localObject2, ((StringBuilder)localObject3).toString(), "");
    }
  }
  
  private void isAuthorized()
  {
    if (this.emotionPkg == null) {
      return;
    }
    this.authType = ((IVasEmojiManagerService)QRoute.api(IVasEmojiManagerService.class)).isAuthorized(this.app, this.emotionPkg.mobileFeetype);
  }
  
  private boolean isCurrentPanel()
  {
    if ((this.curPanelInfo != null) && (this.curPanelInfo.emotionPkg != null))
    {
      EmoticonPackage localEmoticonPackage = this.emotionPkg;
      if ((localEmoticonPackage != null) && (!TextUtils.isEmpty(localEmoticonPackage.epId)))
      {
        localEmoticonPackage = this.curPanelInfo.emotionPkg;
        if (this.emotionPkg.epId.equals(localEmoticonPackage.epId)) {
          return true;
        }
      }
    }
    return false;
  }
  
  public View getEmotionView(BaseEmotionAdapter.ViewHolder paramViewHolder, int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    return null;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (this.isUpdatePanel)
    {
      if (paramInt == 0) {
        return 0;
      }
      return 1;
    }
    return super.getItemViewType(paramInt);
  }
  
  public int getViewTypeCount()
  {
    if (this.isUpdatePanel) {
      return 2;
    }
    return super.getViewTypeCount();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    Object localObject1 = (EmoticonPackage)paramMessage.obj;
    Object localObject2 = this.holder;
    if ((localObject2 != null) && (((EmotionDownloadOrUpdateAdapter.EmotionDownloadOrUpdateViewHolder)localObject2).cover != null))
    {
      localObject2 = this.emotionPkg;
      if ((localObject2 != null) && (!TextUtils.isEmpty(((EmoticonPackage)localObject2).epId)))
      {
        if (localObject1 == null) {
          return true;
        }
        if (!this.emotionPkg.epId.equals(((EmoticonPackage)localObject1).epId)) {
          return true;
        }
        switch (paramMessage.what)
        {
        default: 
          return true;
        case 102: 
          if (QLog.isColorLevel())
          {
            paramMessage = TAG;
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("handleMessage packageDownloadEnd epid = ");
            ((StringBuilder)localObject1).append(this.emotionPkg.epId);
            QLog.d(paramMessage, 2, ((StringBuilder)localObject1).toString());
          }
          if (this.isUpdatePanel) {
            this.holder.downloadBtn.setText(MobileQQ.getContext().getString(2131699774));
          }
          this.holder.downloadBtn.setText(MobileQQ.getContext().getString(2131699724));
          this.holder.downloadBtn.setProgress(0);
          this.downBtnStatus = 2;
          return true;
        case 101: 
          if (QLog.isColorLevel())
          {
            paramMessage = TAG;
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("handleMessage refreshprogress epid = ");
            ((StringBuilder)localObject2).append(this.emotionPkg.epId);
            QLog.d(paramMessage, 2, ((StringBuilder)localObject2).toString());
          }
          int i = (int)((EmojiManagerServiceProxy)this.app.getRuntimeService(IEmojiManagerService.class)).getStatusPercent(((EmoticonPackage)localObject1).epId);
          if (i < 0) {
            return true;
          }
          this.holder.downloadBtn.setText(MobileQQ.getContext().getString(2131699719));
          this.downBtnStatus = 1;
          this.holder.downloadBtn.setProgressDrawable(this.holder.downloadBtn.a(-16745986));
          this.holder.downloadBtn.setProgress(i);
          return true;
        }
        if (QLog.isColorLevel())
        {
          paramMessage = TAG;
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("handleMessage refreshCover epid = ");
          ((StringBuilder)localObject1).append(this.emotionPkg.epId);
          QLog.d(paramMessage, 2, ((StringBuilder)localObject1).toString());
        }
        paramMessage = EmosmUtils.a(2, this.emotionPkg.epId);
        if (paramMessage != null) {
          this.holder.cover.setImageDrawable(paramMessage);
        }
      }
      return true;
    }
    QLog.e(TAG, 1, "packageDownloadEnd view is null");
    return true;
  }
  
  public BaseEmotionAdapter.ViewHolder newHolder()
  {
    return new EmotionDownloadOrUpdateAdapter.EmotionDownloadOrUpdateViewHolder();
  }
  
  public void onAdapterSelected()
  {
    Object localObject = this.emotionPkg;
    if ((localObject != null) && (!TextUtils.isEmpty(((EmoticonPackage)localObject).epId)))
    {
      if ((this.emotionPkg.mobileFeetype != 4) && (this.emotionPkg.mobileFeetype != 5))
      {
        if (this.emotionPkg.valid) {}
      }
      else
      {
        isAuthorized();
        if (!this.authType) {
          return;
        }
      }
      localObject = (EmojiManagerServiceProxy)this.app.getRuntimeService(IEmojiManagerService.class);
      if ((((EmojiManagerServiceProxy)localObject).getEmoticonPackageLoadingProgress(this.emotionPkg.epId) < 0.0F) && (NetworkUtil.getSystemNetwork(MobileQQ.getContext()) == 1))
      {
        if (QLog.isColorLevel())
        {
          String str = TAG;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("wifi auto download emotion , epid = ");
          localStringBuilder.append(this.emotionPkg.epId);
          QLog.d(str, 2, localStringBuilder.toString());
        }
        ((EmojiManagerServiceProxy)localObject).pullEmoticonPackage(this.emotionPkg, false, this.businessType);
        localObject = this.holder;
        if ((localObject != null) && (((EmotionDownloadOrUpdateAdapter.EmotionDownloadOrUpdateViewHolder)localObject).downloadBtn != null))
        {
          this.holder.downloadBtn.setVisibility(0);
          this.holder.downloadBtn.setText(MobileQQ.getContext().getString(2131699719));
          this.downBtnStatus = 1;
        }
        ReportController.b(this.app.getQQAppInterface(), "CliOper", "", "", "ep_mall", "0X80057B1", 0, 0, this.emotionPkg.epId, "", "", "");
      }
      return;
    }
    QLog.e(TAG, 1, "onAdapterSelected emotionpkg = null");
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131365365)
    {
      Object localObject1 = this.emotionPkg;
      if (localObject1 != null)
      {
        if ((((EmoticonPackage)localObject1).mobileFeetype != 4) && (this.emotionPkg.mobileFeetype != 5))
        {
          if (!this.emotionPkg.valid)
          {
            boolean bool;
            if (this.emotionPkg.jobType == 4) {
              bool = true;
            } else {
              bool = false;
            }
            ((IBigEmotionService)QRoute.api(IBigEmotionService.class)).openEmojiDetailPage(this.mContext, this.app, this.app.getAccount(), 0, String.valueOf(this.emotionPkg.epId), false, null, bool);
            break label344;
          }
        }
        else
        {
          isAuthorized();
          if (!this.authType)
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("mvip.g.a.bq_");
            ((StringBuilder)localObject1).append(this.emotionPkg.epId);
            Object localObject2 = ((StringBuilder)localObject1).toString();
            if (this.emotionPkg.mobileFeetype == 5) {
              localObject1 = "!svip";
            } else {
              localObject1 = "!vip";
            }
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("https://mc.vip.qq.com/qqwallet/index?aid=");
            localStringBuilder.append((String)localObject2);
            localStringBuilder.append("&type=");
            localStringBuilder.append((String)localObject1);
            localStringBuilder.append("&send=0&return_url=jsbridge://qw_charge/emojiPayResultOk");
            localObject1 = localStringBuilder.toString();
            if ((this.mContext instanceof Activity))
            {
              localObject2 = new Intent();
              ((Intent)localObject2).putExtra("url", (String)localObject1);
              RouteUtils.a((Activity)this.mContext, (Intent)localObject2, "/base/browser", 4813);
            }
            if (this.isSmallEmotion) {
              break label344;
            }
            ReportController.b(this.app.getQQAppInterface(), "CliOper", "", "", "ep_mall", "0X80057B3", 0, 0, this.emotionPkg.epId, "", "", "");
            break label344;
          }
        }
        doDownloadOpr(false);
      }
    }
    label344:
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void packageDownloadEnd(EmoticonPackage paramEmoticonPackage, int paramInt)
  {
    if (paramInt == 0)
    {
      if (paramEmoticonPackage == null) {
        return;
      }
      Message localMessage = Message.obtain();
      localMessage.what = 102;
      localMessage.obj = paramEmoticonPackage;
      localMessage.arg1 = paramInt;
      this.mUiHandler.sendMessage(localMessage);
    }
  }
  
  public void payBack(int paramInt)
  {
    if (paramInt == 18)
    {
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "payback");
      }
      if (isCurrentPanel())
      {
        doDownloadOpr(true);
        if ((this.isSmallEmotion) && (this.emotionPkg != null)) {
          ReportController.b(this.app.getQQAppInterface(), "CliOper", "", "", "ep_mall", "0X80057AD", 0, 0, this.emotionPkg.epId, "", "", "");
        }
      }
    }
  }
  
  public void refreashProgress(EmoticonPackage paramEmoticonPackage, int paramInt1, int paramInt2)
  {
    if (paramEmoticonPackage == null) {
      return;
    }
    Message localMessage = Message.obtain();
    localMessage.what = 101;
    localMessage.obj = paramEmoticonPackage;
    this.mUiHandler.sendMessage(localMessage);
  }
  
  public void refreshCover(EmoticonPackage paramEmoticonPackage)
  {
    if (paramEmoticonPackage == null) {
      return;
    }
    Message localMessage = Message.obtain();
    localMessage.what = 100;
    localMessage.obj = paramEmoticonPackage;
    this.mUiHandler.sendMessage(localMessage);
  }
  
  public void updateDownloadUI(EmotionDownloadOrUpdateAdapter.EmotionDownloadOrUpdateViewHolder paramEmotionDownloadOrUpdateViewHolder)
  {
    Object localObject1;
    Object localObject2;
    if (paramEmotionDownloadOrUpdateViewHolder != null)
    {
      localObject1 = this.emotionPkg;
      if ((localObject1 != null) && (!TextUtils.isEmpty(((EmoticonPackage)localObject1).epId)))
      {
        if (QLog.isColorLevel())
        {
          localObject1 = TAG;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("updateUI epid = ");
          ((StringBuilder)localObject2).append(this.emotionPkg.epId);
          QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
        }
        paramEmotionDownloadOrUpdateViewHolder.name.setText(this.emotionPkg.name);
        paramEmotionDownloadOrUpdateViewHolder.name.setVisibility(0);
        localObject1 = EmosmUtils.a(2, this.emotionPkg.epId);
      }
    }
    try
    {
      localObject2 = MobileQQ.getContext().getResources().getDrawable(2130846447);
      Drawable localDrawable = MobileQQ.getContext().getResources().getDrawable(2130846453);
      if (FileUtils.fileExists((String)localObject1))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("file:///");
        localStringBuilder.append((String)localObject1);
        localObject1 = URLDrawable.getDrawable(new URL(localStringBuilder.toString()), (Drawable)localObject2, localDrawable);
      }
      else
      {
        if (this.isSmallEmotion) {
          localObject1 = EmosmUtils.b(19, this.emotionPkg.epId);
        } else {
          localObject1 = EmosmUtils.b(2, this.emotionPkg.epId);
        }
        localObject1 = URLDrawable.getDrawable((String)localObject1, (Drawable)localObject2, localDrawable);
      }
      if (localObject1 != null) {
        paramEmotionDownloadOrUpdateViewHolder.cover.setImageDrawable((Drawable)localObject1);
      } else {
        paramEmotionDownloadOrUpdateViewHolder.cover.setImageResource(2130846453);
      }
    }
    catch (MalformedURLException localMalformedURLException)
    {
      float f;
      break label279;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      label266:
      label279:
      break label266;
    }
    paramEmotionDownloadOrUpdateViewHolder.cover.setImageResource(2130846453);
    break label289;
    paramEmotionDownloadOrUpdateViewHolder.cover.setImageResource(2130846453);
    label289:
    paramEmotionDownloadOrUpdateViewHolder.cover.setVisibility(0);
    f = ((EmojiManagerServiceProxy)this.app.getRuntimeService(IEmojiManagerService.class)).getEmoticonPackageLoadingProgress(this.emotionPkg.epId);
    if (QLog.isColorLevel())
    {
      localObject1 = TAG;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("Ep id=");
      ((StringBuilder)localObject2).append(this.emotionPkg.epId);
      ((StringBuilder)localObject2).append(", progress=");
      ((StringBuilder)localObject2).append(f);
      QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    if (f >= 0.0F)
    {
      paramEmotionDownloadOrUpdateViewHolder.downloadBtn.setVisibility(0);
      paramEmotionDownloadOrUpdateViewHolder.downloadBtn.setProgress((int)(f * 100.0F));
      paramEmotionDownloadOrUpdateViewHolder.downloadBtn.setText(MobileQQ.getContext().getString(2131699719));
      this.downBtnStatus = 1;
    }
    else
    {
      localObject1 = MobileQQ.getContext().getString(2131699724);
      if (this.isUpdatePanel)
      {
        localObject1 = MobileQQ.getContext().getString(2131699774);
      }
      else if ((this.emotionPkg.mobileFeetype != 4) && (this.emotionPkg.mobileFeetype != 5))
      {
        if (!this.emotionPkg.valid) {
          localObject1 = MobileQQ.getContext().getString(2131699775);
        }
      }
      else
      {
        isAuthorized();
        if (!this.authType) {
          localObject1 = MobileQQ.getContext().getString(2131699751);
        }
      }
      paramEmotionDownloadOrUpdateViewHolder.downloadBtn.setVisibility(0);
      paramEmotionDownloadOrUpdateViewHolder.downloadBtn.setProgress(0);
      paramEmotionDownloadOrUpdateViewHolder.downloadBtn.setText((CharSequence)localObject1);
      this.downBtnStatus = 2;
      if (isCurrentPanel()) {
        onAdapterSelected();
      }
    }
    paramEmotionDownloadOrUpdateViewHolder.downloadBtn.setOnClickListener(this);
    return;
    QLog.e(TAG, 1, "updateUI holder is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmotionDownloadOrUpdateAdapter
 * JD-Core Version:    0.7.0.1
 */