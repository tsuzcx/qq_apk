package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.widget.EditText;
import anvx;
import avlz;
import axnp;
import bdla;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.photo.SendPhotoTask;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.emosm.emosearch.EmotionSearchItem;
import com.tencent.mobileqq.hotpic.HotPicPageView;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;

public class HotPicSearchEmoticonInfo
  extends EmoticonInfo
{
  static final long ONE_SEC = 1000L;
  public static final String TAG = "HotPicSearchEmoticonInfo";
  static long lastTime;
  protected int mPageType;
  protected int mReportPosition;
  public EmotionSearchItem mSearchItem;
  protected String mSearchWord;
  
  public HotPicSearchEmoticonInfo(int paramInt1, int paramInt2, String paramString, EmotionSearchItem paramEmotionSearchItem)
  {
    this.mPageType = paramInt1;
    this.mSearchWord = paramString;
    this.mSearchItem = paramEmotionSearchItem;
    this.mReportPosition = paramInt2;
  }
  
  public Drawable getBigDrawable(Context paramContext, float paramFloat)
  {
    return getDrawable(paramContext, paramFloat);
  }
  
  public Drawable getDrawable(Context paramContext, float paramFloat)
  {
    paramContext = URLDrawable.URLDrawableOptions.obtain();
    paramContext.mLoadingDrawable = HotPicPageView.a;
    paramContext.mFailedDrawable = HotPicPageView.a;
    paramContext.mPlayGifImage = true;
    paramContext.mExtraInfo = this.mSearchItem;
    URL localURL = avlz.a(this.mSearchItem.url);
    if (localURL == null) {
      return null;
    }
    return URLDrawable.getDrawable(localURL, paramContext);
  }
  
  protected void reportEvent(QQAppInterface paramQQAppInterface)
  {
    if (this.mPageType == 1)
    {
      if (!StringUtil.isEmpty(this.mSearchWord)) {
        bdla.b(paramQQAppInterface, "dc00898", "", "", "0X800AE2E", "0X800AE2E", 0, 0, this.mReportPosition + "", "", this.mSearchItem.getEmoMd5(), "");
      }
      if (StringUtil.isEmpty(this.mSearchWord))
      {
        i = 1;
        bdla.b(paramQQAppInterface, "dc00898", "", "", "0X800AE20", "0X800AE20", i, 0, this.mReportPosition + "", "", this.mSearchItem.getEmoMd5(), "");
      }
    }
    while (this.mPageType != 2) {
      for (;;)
      {
        return;
        int i = 2;
      }
    }
    bdla.b(paramQQAppInterface, "dc00898", "", "", "0X800AE36", "0X800AE36", 0, 0, this.mReportPosition + "", "", this.mSearchItem.getEmoMd5(), "");
  }
  
  public void send(QQAppInterface paramQQAppInterface, Context paramContext, EditText paramEditText, SessionInfo paramSessionInfo)
  {
    long l = System.currentTimeMillis();
    if (l - lastTime < 1000L) {
      if (QLog.isColorLevel()) {
        QLog.e("HotPicSearchEmoticonInfo", 2, "send to offen,please try it later");
      }
    }
    do
    {
      return;
      lastTime = l;
      if (((paramContext instanceof BaseActivity)) && (axnp.a(paramSessionInfo.curType, paramSessionInfo.curFriendUin)))
      {
        paramContext = (BaseActivity)paramContext;
        QQToast.a(paramQQAppInterface.getApp(), anvx.a(2131700806), 0).b(paramContext.getTitleBarHeight());
        return;
      }
    } while (!(paramContext instanceof BaseActivity));
    int j = 0;
    paramEditText = null;
    Object localObject = avlz.a(this.mSearchItem.originalUrl);
    int i;
    if ((localObject != null) && (FileUtils.fileExistsAndNotEmpty(((File)localObject).getAbsolutePath())))
    {
      localObject = ((File)localObject).getAbsolutePath();
      j = 1;
      paramEditText = (EditText)localObject;
      i = j;
      if (QLog.isColorLevel())
      {
        QLog.d("HotPicSearchEmoticonInfo", 2, "senHotPic, urlHotPicOringinal = " + this.mSearchItem.originalUrl + ", paths = " + (String)localObject);
        i = j;
        paramEditText = (EditText)localObject;
      }
    }
    while ((paramEditText == null) && (paramSessionInfo.curType != 1008))
    {
      QQToast.a(paramContext, 2131698586, 0).a();
      return;
      i = j;
      if (HotPicPageView.a(this.mSearchItem) == 0)
      {
        localObject = avlz.a(this.mSearchItem.url).getAbsolutePath();
        paramEditText = (EditText)localObject;
        i = j;
        if (QLog.isColorLevel())
        {
          QLog.d("HotPicSearchEmoticonInfo", 2, "senHotPic, urlHotPic = " + this.mSearchItem.url + ", paths = " + (String)localObject);
          paramEditText = (EditText)localObject;
          i = j;
        }
      }
    }
    reportEvent(paramQQAppInterface);
    paramQQAppInterface = new Intent();
    localObject = new ArrayList();
    ((ArrayList)localObject).add(paramEditText);
    paramQQAppInterface.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", (ArrayList)localObject);
    paramQQAppInterface.putExtra("uin", paramSessionInfo.curFriendUin);
    paramQQAppInterface.putExtra("uintype", paramSessionInfo.curType);
    paramQQAppInterface.putExtra("troop_uin", paramSessionInfo.troopUin);
    paramQQAppInterface.putExtra("key_confess_topicid", paramSessionInfo.topicId);
    paramQQAppInterface.putExtra("PhotoConst.SEND_SIZE_SPEC", 0);
    paramQQAppInterface.putExtra("send_in_background", true);
    paramQQAppInterface.putExtra("PhotoConst.SINGLE_PHOTO_PATH", (Serializable)localObject);
    paramQQAppInterface.putExtra("PicContants.NEED_COMPRESS", false);
    paramQQAppInterface.putExtra("quick_send_is_emo_search", true);
    if (i == 0)
    {
      paramQQAppInterface.putExtra("quick_send_original_md5", this.mSearchItem.originalMD5);
      paramQQAppInterface.putExtra("quick_send_original_size", this.mSearchItem.oringinalSize);
      paramQQAppInterface.putExtra("quick_send_thumb_md5", this.mSearchItem.md5);
      paramQQAppInterface.putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1042);
    }
    for (;;)
    {
      ThreadManager.post(new SendPhotoTask((BaseActivity)paramContext, paramQQAppInterface, null), 8, null, false);
      return;
      paramQQAppInterface.putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1031);
    }
  }
  
  public String toString()
  {
    return String.format("HotPicSearchEmoticonInfo, SearchItem %s", new Object[] { this.mSearchItem.toString() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.HotPicSearchEmoticonInfo
 * JD-Core Version:    0.7.0.1
 */