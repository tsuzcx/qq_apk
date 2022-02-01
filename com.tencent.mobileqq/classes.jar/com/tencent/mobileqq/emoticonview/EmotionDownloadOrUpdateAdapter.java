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
import antu;
import anvx;
import aocy;
import asdi;
import asih;
import asjr;
import bdla;
import bkyc;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vaswebviewplugin.EmojiHomeUiPlugin;
import com.tencent.mobileqq.widget.ProgressButton;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.net.MalformedURLException;
import java.net.URL;
import mqq.os.MqqHandler;

public class EmotionDownloadOrUpdateAdapter
  extends EmotionNeedDownloadAdapter
  implements Handler.Callback, View.OnClickListener
{
  private static final int AUTH_OK = 2;
  private static final int AUTH_SHOULD_SVIP = 1;
  private static final int AUTH_SHOULD_VIP = 0;
  private static final int MSG_DOWNLOAD_END = 102;
  private static final int MSG_REFRESH_COVER = 100;
  private static final int MSG_REFRESH_PROGRESS = 101;
  public static final int TYPE_DATA = 1;
  public static final int TYPE_UPDATE = 0;
  private int authType = 2;
  private int businessType;
  protected EmoticonPackage emotionPkg;
  protected EmotionDownloadOrUpdateAdapter.EmotionDownloadOrUpdateViewHolder holder;
  protected boolean isSmallEmotion;
  protected boolean isUpdatePanel;
  private MqqHandler mUiHandler = new bkyc(Looper.getMainLooper(), this, true);
  
  public EmotionDownloadOrUpdateAdapter(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt1, int paramInt2, int paramInt3, EmoticonPackage paramEmoticonPackage, EmoticonCallback paramEmoticonCallback, int paramInt4)
  {
    super(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramEmoticonCallback);
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
    } while (this.authType != 2);
    asih localasih = (asih)this.app.getManager(QQManagerFactory.CHAT_EMOTION_MANAGER);
    if ((this.emotionPkg.epId != null) && (this.emotionPkg.epId.equals("10278")))
    {
      ((antu)this.app.getBusinessHandler(BusinessHandlerFactory.HANDLER_EMOSM)).a(this.emotionPkg.epId, this.businessType);
      bdla.b(this.app, "CliOper", "", "", "ep_mall", "Ep_endoffer_click", 0, 0, "", "", "", "");
    }
    localProgressButton.setProgressDrawable(localProgressButton.a(-16745986));
    float f = localasih.a(this.emotionPkg.epId);
    int i;
    if (this.downBtnStatus == 2)
    {
      localProgressButton.setText(anvx.a(2131703600));
      localProgressButton.setProgress((int)f);
      localasih.a(this.emotionPkg, true, this.businessType);
      this.downBtnStatus = 1;
      i = 1;
    }
    for (;;)
    {
      bdla.b(this.app, "CliOper", "", "", "ep_mall", "0X80057B1", 0, 0, "", this.emotionPkg.epId, i + "", "");
      return;
      if (this.downBtnStatus == 1)
      {
        String str = anvx.a(2131703595);
        if (this.isUpdatePanel) {
          str = anvx.a(2131703592);
        }
        localProgressButton.setText(str);
        localProgressButton.setProgress(0);
        this.downBtnStatus = 2;
        localasih.a(this.emotionPkg.epId);
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
    int i = ((aocy)this.app.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).g();
    if (this.emotionPkg.mobileFeetype == 4)
    {
      if ((i == 1) || (i == 3))
      {
        this.authType = 2;
        return;
      }
      this.authType = 0;
      return;
    }
    if (this.emotionPkg.mobileFeetype == 5)
    {
      if (i == 3)
      {
        this.authType = 2;
        return;
      }
      this.authType = 1;
      return;
    }
    this.authType = 2;
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
          paramMessage = asdi.a(2, this.emotionPkg.epId);
        }
      } while (paramMessage == null);
      this.holder.cover.setImageDrawable(paramMessage);
      return true;
      paramMessage = asih.a(((BaseActivity)this.mContext).getAppRuntime(), localEmoticonPackage.epId);
    } while (paramMessage == null);
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "handleMessage refreshprogress epid = " + this.emotionPkg.epId);
    }
    int i = (int)paramMessage.a();
    this.holder.downloadBtn.setText(anvx.a(2131703590));
    this.downBtnStatus = 1;
    this.holder.downloadBtn.setProgressDrawable(this.holder.downloadBtn.a(-16745986));
    this.holder.downloadBtn.setProgress(i);
    return true;
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "handleMessage packageDownloadEnd epid = " + this.emotionPkg.epId);
    }
    if (this.isUpdatePanel) {
      this.holder.downloadBtn.setText(anvx.a(2131703591));
    }
    this.holder.downloadBtn.setText(anvx.a(2131703589));
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
      if ((this.emotionPkg.mobileFeetype != 4) && (this.emotionPkg.mobileFeetype != 5)) {
        break;
      }
      isAuthorized();
    } while (this.authType != 2);
    while (this.emotionPkg.valid)
    {
      asih localasih = (asih)this.app.getManager(QQManagerFactory.CHAT_EMOTION_MANAGER);
      if ((localasih.a(this.emotionPkg.epId) >= 0.0F) || (!EmoticonUtils.isWifi())) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "wifi auto download emotion , epid = " + this.emotionPkg.epId);
      }
      localasih.a(this.emotionPkg, false, this.businessType);
      if ((this.holder != null) && (this.holder.downloadBtn != null))
      {
        this.holder.downloadBtn.setVisibility(0);
        this.holder.downloadBtn.setText(anvx.a(2131703597));
        this.downBtnStatus = 1;
      }
      bdla.b(this.app, "CliOper", "", "", "ep_mall", "0X80057B1", 0, 0, this.emotionPkg.epId, "", "", "");
      return;
    }
  }
  
  public void onClick(View paramView)
  {
    if ((paramView.getId() != 2131365369) || (this.emotionPkg == null)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((this.emotionPkg.mobileFeetype == 4) || (this.emotionPkg.mobileFeetype == 5))
      {
        isAuthorized();
        if (this.authType != 2)
        {
          Object localObject = "mvip.g.a.bq_" + this.emotionPkg.epId;
          String str = "!vip";
          if (this.emotionPkg.mobileFeetype == 5) {
            str = "!svip";
          }
          str = "https://mc.vip.qq.com/qqwallet/index?aid=" + (String)localObject + "&type=" + str + "&send=0&return_url=jsbridge://qw_charge/emojiPayResultOk";
          localObject = new Intent(this.mContext, QQBrowserActivity.class);
          ((Intent)localObject).putExtra("url", str);
          if ((this.mContext instanceof Activity)) {
            ((Activity)this.mContext).startActivityForResult((Intent)localObject, 4813);
          }
          if (this.isSmallEmotion) {
            continue;
          }
          bdla.b(this.app, "CliOper", "", "", "ep_mall", "0X80057B3", 0, 0, this.emotionPkg.epId, "", "", "");
        }
      }
      else if (!this.emotionPkg.valid)
      {
        if (this.emotionPkg.jobType == 4) {}
        for (boolean bool = true;; bool = false)
        {
          EmojiHomeUiPlugin.openEmojiDetailPage((Activity)this.mContext, this.app.getAccount(), 8, String.valueOf(this.emotionPkg.epId), false, bool);
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
          bdla.b(this.app, "CliOper", "", "", "ep_mall", "0X80057AD", 0, 0, this.emotionPkg.epId, "", "", "");
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
    Object localObject = asdi.a(2, this.emotionPkg.epId);
    String str;
    for (;;)
    {
      try
      {
        localDrawable1 = BaseApplicationImpl.getApplication().getResources().getDrawable(2130838049);
        localDrawable2 = BaseApplicationImpl.getApplication().getResources().getDrawable(2130843819);
        if (!FileUtils.fileExists((String)localObject)) {
          continue;
        }
        localObject = URLDrawableHelper.getDrawable(new URL("file:///" + (String)localObject), localDrawable1, localDrawable2);
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
        paramEmotionDownloadOrUpdateViewHolder.cover.setImageResource(2130843819);
        continue;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        paramEmotionDownloadOrUpdateViewHolder.cover.setImageResource(2130843819);
        continue;
        str = anvx.a(2131703599);
        if (!this.isUpdatePanel) {
          break;
        }
      }
      paramEmotionDownloadOrUpdateViewHolder.cover.setVisibility(0);
      f = ((asih)this.app.getManager(QQManagerFactory.CHAT_EMOTION_MANAGER)).a(this.emotionPkg.epId);
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "Ep id=" + this.emotionPkg.epId + ", progress=" + f);
      }
      if (f >= 0.0F)
      {
        paramEmotionDownloadOrUpdateViewHolder.downloadBtn.setVisibility(0);
        paramEmotionDownloadOrUpdateViewHolder.downloadBtn.setProgress((int)(f * 100.0F));
        paramEmotionDownloadOrUpdateViewHolder.downloadBtn.setText(anvx.a(2131703593));
        this.downBtnStatus = 1;
        paramEmotionDownloadOrUpdateViewHolder.downloadBtn.setOnClickListener(this);
        return;
        if (this.isSmallEmotion)
        {
          localObject = asdi.b(19, this.emotionPkg.epId);
          localObject = URLDrawableHelper.getDrawable((String)localObject, localDrawable1, localDrawable2);
        }
        else
        {
          localObject = asdi.b(2, this.emotionPkg.epId);
          continue;
          paramEmotionDownloadOrUpdateViewHolder.cover.setImageResource(2130843819);
        }
      }
      else
      {
        str = anvx.a(2131703596);
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
        if (this.authType != 2) {
          str = anvx.a(2131703598);
        }
      }
      else if (!this.emotionPkg.valid)
      {
        str = anvx.a(2131703594);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmotionDownloadOrUpdateAdapter
 * JD-Core Version:    0.7.0.1
 */