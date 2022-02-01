package com.tencent.mobileqq.emoticonview.relateemo;

import amtj;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.widget.EditText;
import awhn;
import bcef;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.photo.SendPhotoTask;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.EmoticonUtils;
import com.tencent.mobileqq.hotpic.HotPicPageView;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;

public class RelatedEmoSearchEmoticonInfo
  extends EmoticonInfo
{
  static final long ONE_SEC = 1000L;
  public static final String TAG = "HotPicSearchEmoticonInfo";
  static long sLastTime;
  private String mCurFriendUin = "";
  private int mCurType;
  public int mDefaultCount;
  public int mReportPosition;
  public RelatedEmoticonManager.RelatedEmotionSearchResult.SearchResultItem mResultItem;
  
  public RelatedEmoSearchEmoticonInfo(RelatedEmoticonManager.RelatedEmotionSearchResult.SearchResultItem paramSearchResultItem, int paramInt)
  {
    this.mResultItem = paramSearchResultItem;
    this.mDefaultCount = paramInt;
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
    return URLDrawable.getDrawable(this.mResultItem.url, paramContext);
  }
  
  public void send(QQAppInterface paramQQAppInterface, Context paramContext, EditText paramEditText, SessionInfo paramSessionInfo)
  {
    long l = System.currentTimeMillis();
    if (l - sLastTime < 1000L) {
      if (QLog.isColorLevel()) {
        QLog.e("HotPicSearchEmoticonInfo", 2, "send to offen,please try it later");
      }
    }
    do
    {
      do
      {
        return;
        sLastTime = l;
        if (((paramContext instanceof BaseActivity)) && (awhn.a(paramSessionInfo.curType, paramSessionInfo.curFriendUin)))
        {
          paramContext = (BaseActivity)paramContext;
          QQToast.a(paramQQAppInterface.getApp(), amtj.a(2131700455), 0).b(paramContext.getTitleBarHeight());
          return;
        }
      } while (!(paramContext instanceof BaseActivity));
      Object localObject1 = null;
      Object localObject2 = AbsDownloader.getFile(this.mResultItem.url);
      paramEditText = (EditText)localObject1;
      if (localObject2 != null)
      {
        paramEditText = (EditText)localObject1;
        if (FileUtils.fileExistsAndNotEmpty(((File)localObject2).getAbsolutePath()))
        {
          localObject1 = ((File)localObject2).getAbsolutePath();
          paramEditText = (EditText)localObject1;
          if (QLog.isColorLevel())
          {
            QLog.d("HotPicSearchEmoticonInfo", 2, "senHotPic, urlHotPicOringinal = " + this.mResultItem.url + ", paths = " + (String)localObject1);
            paramEditText = (EditText)localObject1;
          }
        }
      }
      if ((paramEditText == null) && (paramSessionInfo.curType != 1008))
      {
        QQToast.a(paramContext, 2131698294, 0).a();
        return;
      }
      localObject1 = new Intent();
      localObject2 = new ArrayList();
      ((ArrayList)localObject2).add(paramEditText);
      ((Intent)localObject1).putStringArrayListExtra("PhotoConst.PHOTO_PATHS", (ArrayList)localObject2);
      ((Intent)localObject1).putExtra("uin", paramSessionInfo.curFriendUin);
      ((Intent)localObject1).putExtra("uintype", paramSessionInfo.curType);
      ((Intent)localObject1).putExtra("troop_uin", paramSessionInfo.troopUin);
      ((Intent)localObject1).putExtra("key_confess_topicid", paramSessionInfo.topicId);
      ((Intent)localObject1).putExtra("PhotoConst.SEND_SIZE_SPEC", 0);
      ((Intent)localObject1).putExtra("send_in_background", true);
      ((Intent)localObject1).putExtra("PhotoConst.SINGLE_PHOTO_PATH", (Serializable)localObject2);
      ((Intent)localObject1).putExtra("PicContants.NEED_COMPRESS", false);
      ((Intent)localObject1).putExtra("quick_send_original_md5", this.mResultItem.md5);
      ((Intent)localObject1).putExtra("quick_send_original_size", this.mResultItem.imgSize);
      ((Intent)localObject1).putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1054);
      ThreadManager.post(new SendPhotoTask((BaseActivity)paramContext, (Intent)localObject1, null), 8, null, false);
      bcef.b(paramQQAppInterface, "dc00898", "", this.mCurFriendUin, "0X800B117", "0X800B117", EmoticonUtils.getRelatedEmotionReportFromType(this.mCurType), 0, "", this.mReportPosition + 1 + "", this.mResultItem.md5, this.mResultItem.url);
    } while (this.mDefaultCount <= 0);
    bcef.b(paramQQAppInterface, "dc00898", "", this.mCurFriendUin, "0X800B11E", "0X800B11E", this.mDefaultCount, 0, "", this.mReportPosition + 1 + "", this.mResultItem.md5, this.mResultItem.url);
  }
  
  public void setReportMessage(String paramString, int paramInt1, int paramInt2)
  {
    this.mCurFriendUin = paramString;
    this.mCurType = paramInt1;
    this.mReportPosition = paramInt2;
  }
  
  public String toString()
  {
    return String.format("RelatedEmoSearchEmoticonInfo, SearchItem %s", new Object[] { this.mResultItem.toString() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.relateemo.RelatedEmoSearchEmoticonInfo
 * JD-Core Version:    0.7.0.1
 */