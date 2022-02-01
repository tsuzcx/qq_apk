package com.tencent.mobileqq.emoticonview;

import android.app.Activity;
import android.content.Context;
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
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticonview.api.IBigEmotionService;
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
  private boolean authType = true;
  private int businessType;
  protected EmoticonPackage emotionPkg;
  protected EmotionDownloadOrUpdateAdapter.EmotionDownloadOrUpdateViewHolder holder;
  protected boolean isSmallEmotion;
  protected boolean isUpdatePanel;
  private MqqHandler mUiHandler = new MqqWeakReferenceHandler(Looper.getMainLooper(), this, true);
  
  public EmotionDownloadOrUpdateAdapter(IEmoticonMainPanelApp paramIEmoticonMainPanelApp, Context paramContext, int paramInt1, int paramInt2, int paramInt3, EmoticonPackage paramEmoticonPackage, EmoticonCallback paramEmoticonCallback, int paramInt4)
  {
    super(paramIEmoticonMainPanelApp, paramContext, paramInt1, paramInt2, paramInt3, paramEmoticonCallback);
    this.emotionPkg = paramEmoticonPackage;
    if (paramEmoticonPackage.jobType == 4) {}
    for (boolean bool = true;; bool = false)
    {
      this.isSmallEmotion = bool;
      this.businessType = paramInt4;
      return;
    }
  }
  
  private void doDownloadOpr(boolean paramBoolean)
  {
    if ((this.emotionPkg == null) || (this.holder == null)) {}
    ProgressButton localProgressButton;
    do
    {
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.d(TAG, 2, "doDownloadOpr epid = " + this.emotionPkg.epId);
        }
        localProgressButton = this.holder.downloadBtn;
      } while (localProgressButton == null);
      if (!paramBoolean) {
        break;
      }
      isAuthorized();
    } while (!this.authType);
    if ((this.emotionPkg.epId != null) && (this.emotionPkg.epId.equals("10278")))
    {
      ((IBigEmotionService)QRoute.api(IBigEmotionService.class)).reportAddEmoticonPkg(this.app, this.emotionPkg.epId, this.businessType);
      ReportController.b(this.app.getQQAppInterface(), "CliOper", "", "", "ep_mall", "Ep_endoffer_click", 0, 0, "", "", "", "");
    }
    localProgressButton.setProgressDrawable(localProgressButton.a(-16745986));
    float f = ((IBigEmotionService)QRoute.api(IBigEmotionService.class)).getEmoticonPackageLoadingProgress(this.app, this.emotionPkg.epId);
    int i;
    if (this.downBtnStatus == 2)
    {
      localProgressButton.setText(MobileQQ.getContext().getString(2131699611));
      localProgressButton.setProgress((int)f);
      ((IBigEmotionService)QRoute.api(IBigEmotionService.class)).pullEmoticonPackage(this.app, this.emotionPkg, true, this.businessType);
      this.downBtnStatus = 1;
      i = 1;
    }
    for (;;)
    {
      ReportController.b(this.app.getQQAppInterface(), "CliOper", "", "", "ep_mall", "0X80057B1", 0, 0, "", this.emotionPkg.epId, i + "", "");
      return;
      if (this.downBtnStatus == 1)
      {
        String str = MobileQQ.getContext().getString(2131699614);
        if (this.isUpdatePanel) {
          str = MobileQQ.getContext().getString(2131699644);
        }
        localProgressButton.setText(str);
        localProgressButton.setProgress(0);
        this.downBtnStatus = 2;
        ((IBigEmotionService)QRoute.api(IBigEmotionService.class)).stopEmoticonPackageDownload(this.app, this.emotionPkg.epId);
        this.mContext.getSharedPreferences("mobileQQ", 0).edit().remove("LAST_ADD_EMO_PACKAGE").commit();
        i = 2;
      }
      else
      {
        i = 1;
      }
    }
  }
  
  private void isAuthorized()
  {
    if (this.emotionPkg == null) {
      return;
    }
    this.authType = ((IBigEmotionService)QRoute.api(IBigEmotionService.class)).isAuthorized(this.app, this.emotionPkg.mobileFeetype);
  }
  
  private boolean isCurrentPanel()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.curPanelInfo != null)
    {
      bool1 = bool2;
      if (this.curPanelInfo.emotionPkg != null)
      {
        bool1 = bool2;
        if (this.emotionPkg != null)
        {
          bool1 = bool2;
          if (!TextUtils.isEmpty(this.emotionPkg.epId))
          {
            EmoticonPackage localEmoticonPackage = this.curPanelInfo.emotionPkg;
            bool1 = bool2;
            if (this.emotionPkg.epId.equals(localEmoticonPackage.epId)) {
              bool1 = true;
            }
          }
        }
      }
    }
    return bool1;
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
    EmoticonPackage localEmoticonPackage = (EmoticonPackage)paramMessage.obj;
    if ((this.holder == null) || (this.holder.cover == null)) {
      QLog.e(TAG, 1, "packageDownloadEnd view is null");
    }
    int i;
    do
    {
      do
      {
        do
        {
          return true;
        } while ((this.emotionPkg == null) || (TextUtils.isEmpty(this.emotionPkg.epId)) || (localEmoticonPackage == null) || (!this.emotionPkg.epId.equals(localEmoticonPackage.epId)));
        switch (paramMessage.what)
        {
        default: 
          return true;
        case 100: 
          if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "handleMessage refreshCover epid = " + this.emotionPkg.epId);
          }
          paramMessage = ((IBigEmotionService)QRoute.api(IBigEmotionService.class)).getCoverBitmap(2, this.emotionPkg.epId);
        }
      } while (paramMessage == null);
      this.holder.cover.setImageDrawable(paramMessage);
      return true;
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "handleMessage refreshprogress epid = " + this.emotionPkg.epId);
      }
      i = (int)((IBigEmotionService)QRoute.api(IBigEmotionService.class)).getStatusPercent(this.app, localEmoticonPackage.epId);
    } while (i < 0);
    this.holder.downloadBtn.setText(MobileQQ.getContext().getString(2131699611));
    this.downBtnStatus = 1;
    this.holder.downloadBtn.setProgressDrawable(this.holder.downloadBtn.a(-16745986));
    this.holder.downloadBtn.setProgress(i);
    return true;
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "handleMessage packageDownloadEnd epid = " + this.emotionPkg.epId);
    }
    if (this.isUpdatePanel) {
      this.holder.downloadBtn.setText(MobileQQ.getContext().getString(2131699644));
    }
    this.holder.downloadBtn.setText(MobileQQ.getContext().getString(2131699614));
    this.holder.downloadBtn.setProgress(0);
    this.downBtnStatus = 2;
    return true;
  }
  
  public BaseEmotionAdapter.ViewHolder newHolder()
  {
    return new EmotionDownloadOrUpdateAdapter.EmotionDownloadOrUpdateViewHolder();
  }
  
  public void onAdapterSelected()
  {
    if ((this.emotionPkg == null) || (TextUtils.isEmpty(this.emotionPkg.epId))) {
      QLog.e(TAG, 1, "onAdapterSelected emotionpkg = null");
    }
    do
    {
      return;
      while ((((IBigEmotionService)QRoute.api(IBigEmotionService.class)).getEmoticonPackageLoadingProgress(this.app, this.emotionPkg.epId) >= 0.0F) || (NetworkUtil.a(MobileQQ.getContext()) != 1)) {
        do
        {
          if ((this.emotionPkg.mobileFeetype != 4) && (this.emotionPkg.mobileFeetype != 5)) {
            break;
          }
          isAuthorized();
        } while (!this.authType);
      }
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "wifi auto download emotion , epid = " + this.emotionPkg.epId);
      }
      ((IBigEmotionService)QRoute.api(IBigEmotionService.class)).pullEmoticonPackage(this.app, this.emotionPkg, false, this.businessType);
      if ((this.holder != null) && (this.holder.downloadBtn != null))
      {
        this.holder.downloadBtn.setVisibility(0);
        this.holder.downloadBtn.setText(MobileQQ.getContext().getString(2131699611));
        this.downBtnStatus = 1;
      }
      ReportController.b(this.app.getQQAppInterface(), "CliOper", "", "", "ep_mall", "0X80057B1", 0, 0, this.emotionPkg.epId, "", "", "");
      return;
    } while (this.emotionPkg.valid);
  }
  
  public void onClick(View paramView)
  {
    if ((paramView.getId() != 2131365519) || (this.emotionPkg == null)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((this.emotionPkg.mobileFeetype == 4) || (this.emotionPkg.mobileFeetype == 5))
      {
        isAuthorized();
        if (!this.authType)
        {
          String str2 = "mvip.g.a.bq_" + this.emotionPkg.epId;
          String str1 = "!vip";
          if (this.emotionPkg.mobileFeetype == 5) {
            str1 = "!svip";
          }
          str1 = "https://mc.vip.qq.com/qqwallet/index?aid=" + str2 + "&type=" + str1 + "&send=0&return_url=jsbridge://qw_charge/emojiPayResultOk";
          if ((this.mContext instanceof Activity)) {
            ((IBigEmotionService)QRoute.api(IBigEmotionService.class)).startActivityForResult((Activity)this.mContext, str1, 4813);
          }
          if (this.isSmallEmotion) {
            continue;
          }
          ReportController.b(this.app.getQQAppInterface(), "CliOper", "", "", "ep_mall", "0X80057B3", 0, 0, this.emotionPkg.epId, "", "", "");
        }
      }
      else if (!this.emotionPkg.valid)
      {
        if (this.emotionPkg.jobType == 4) {}
        for (boolean bool = true;; bool = false)
        {
          ((IBigEmotionService)QRoute.api(IBigEmotionService.class)).openEmojiDetailPage(this.mContext, this.app, this.app.getAccount(), 0, String.valueOf(this.emotionPkg.epId), false, null, bool);
          break;
        }
      }
      doDownloadOpr(false);
    }
  }
  
  public void packageDownloadEnd(EmoticonPackage paramEmoticonPackage, int paramInt)
  {
    if ((paramInt != 0) || (paramEmoticonPackage == null)) {
      return;
    }
    Message localMessage = Message.obtain();
    localMessage.what = 102;
    localMessage.obj = paramEmoticonPackage;
    localMessage.arg1 = paramInt;
    this.mUiHandler.sendMessage(localMessage);
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
    if ((paramEmotionDownloadOrUpdateViewHolder == null) || (this.emotionPkg == null) || (TextUtils.isEmpty(this.emotionPkg.epId)))
    {
      QLog.e(TAG, 1, "updateUI holder is null");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "updateUI epid = " + this.emotionPkg.epId);
    }
    paramEmotionDownloadOrUpdateViewHolder.name.setText(this.emotionPkg.name);
    paramEmotionDownloadOrUpdateViewHolder.name.setVisibility(0);
    Object localObject = ((IBigEmotionService)QRoute.api(IBigEmotionService.class)).getCoverPath(2, this.emotionPkg.epId);
    String str;
    for (;;)
    {
      try
      {
        localDrawable1 = MobileQQ.getContext().getResources().getDrawable(2130846568);
        localDrawable2 = MobileQQ.getContext().getResources().getDrawable(2130846574);
        if (!FileUtils.a((String)localObject)) {
          continue;
        }
        localObject = URLDrawable.getDrawable(new URL("file:///" + (String)localObject), localDrawable1, localDrawable2);
        if (localObject == null) {
          continue;
        }
        paramEmotionDownloadOrUpdateViewHolder.cover.setImageDrawable((Drawable)localObject);
      }
      catch (MalformedURLException localMalformedURLException)
      {
        Drawable localDrawable1;
        Drawable localDrawable2;
        float f;
        paramEmotionDownloadOrUpdateViewHolder.cover.setImageResource(2130846574);
        continue;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        paramEmotionDownloadOrUpdateViewHolder.cover.setImageResource(2130846574);
        continue;
        str = MobileQQ.getContext().getString(2131699614);
        if (!this.isUpdatePanel) {
          break;
        }
      }
      paramEmotionDownloadOrUpdateViewHolder.cover.setVisibility(0);
      f = ((IBigEmotionService)QRoute.api(IBigEmotionService.class)).getEmoticonPackageLoadingProgress(this.app, this.emotionPkg.epId);
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "Ep id=" + this.emotionPkg.epId + ", progress=" + f);
      }
      if (f >= 0.0F)
      {
        paramEmotionDownloadOrUpdateViewHolder.downloadBtn.setVisibility(0);
        paramEmotionDownloadOrUpdateViewHolder.downloadBtn.setProgress((int)(f * 100.0F));
        paramEmotionDownloadOrUpdateViewHolder.downloadBtn.setText(MobileQQ.getContext().getString(2131699611));
        this.downBtnStatus = 1;
        paramEmotionDownloadOrUpdateViewHolder.downloadBtn.setOnClickListener(this);
        return;
        if (this.isSmallEmotion)
        {
          localObject = ((IBigEmotionService)QRoute.api(IBigEmotionService.class)).getCoverUrl(19, this.emotionPkg.epId);
          localObject = URLDrawable.getDrawable((String)localObject, localDrawable1, localDrawable2);
        }
        else
        {
          localObject = ((IBigEmotionService)QRoute.api(IBigEmotionService.class)).getCoverUrl(2, this.emotionPkg.epId);
          continue;
          paramEmotionDownloadOrUpdateViewHolder.cover.setImageResource(2130846574);
        }
      }
      else
      {
        str = MobileQQ.getContext().getString(2131699644);
      }
    }
    for (;;)
    {
      paramEmotionDownloadOrUpdateViewHolder.downloadBtn.setVisibility(0);
      paramEmotionDownloadOrUpdateViewHolder.downloadBtn.setProgress(0);
      paramEmotionDownloadOrUpdateViewHolder.downloadBtn.setText(str);
      this.downBtnStatus = 2;
      if (!isCurrentPanel()) {
        break;
      }
      onAdapterSelected();
      break;
      if ((this.emotionPkg.mobileFeetype == 4) || (this.emotionPkg.mobileFeetype == 5))
      {
        isAuthorized();
        if (!this.authType) {
          str = MobileQQ.getContext().getString(2131699632);
        }
      }
      else if (!this.emotionPkg.valid)
      {
        str = MobileQQ.getContext().getString(2131699645);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmotionDownloadOrUpdateAdapter
 * JD-Core Version:    0.7.0.1
 */