package com.tencent.mobileqq.emoticonview.relateemo;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.widget.EditText;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.photo.SendPhotoTask;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.EmoticonUtils;
import com.tencent.mobileqq.hotpic.HotPicPageView;
import com.tencent.mobileqq.nearby.HotChatUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import mqq.app.AppRuntime;

public class RelatedEmoSearchEmoticonInfo
  extends EmoticonInfo
  implements Parcelable
{
  public static final Parcelable.Creator<RelatedEmoSearchEmoticonInfo> CREATOR = new RelatedEmoSearchEmoticonInfo.1();
  static final long ONE_SEC = 1000L;
  public static final String TAG = "HotPicSearchEmoticonInfo";
  static long sLastTime;
  private String mCurFriendUin = "";
  private int mCurType = 0;
  public int mDefaultCount;
  public int mReportPosition = 0;
  public RelatedEmoticonManager.RelatedEmotionSearchResult.SearchResultItem mResultItem;
  
  protected RelatedEmoSearchEmoticonInfo(Parcel paramParcel)
  {
    super(paramParcel);
    this.mDefaultCount = paramParcel.readInt();
    this.mResultItem = ((RelatedEmoticonManager.RelatedEmotionSearchResult.SearchResultItem)paramParcel.readParcelable(RelatedEmoticonManager.RelatedEmotionSearchResult.SearchResultItem.class.getClassLoader()));
    this.mCurFriendUin = paramParcel.readString();
    this.mCurType = paramParcel.readInt();
    this.mReportPosition = paramParcel.readInt();
  }
  
  public RelatedEmoSearchEmoticonInfo(RelatedEmoticonManager.RelatedEmotionSearchResult.SearchResultItem paramSearchResultItem, int paramInt)
  {
    this.mResultItem = paramSearchResultItem;
    this.mDefaultCount = paramInt;
  }
  
  public int describeContents()
  {
    return 0;
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
  
  public void send(AppRuntime paramAppRuntime, Context paramContext, EditText paramEditText, Parcelable paramParcelable)
  {
    if (paramAppRuntime == null) {
      QLog.e("HotPicSearchEmoticonInfo", 2, "app is null.");
    }
    QQAppInterface localQQAppInterface;
    do
    {
      do
      {
        long l;
        do
        {
          do
          {
            return;
            l = System.currentTimeMillis();
            if (l - sLastTime >= 1000L) {
              break;
            }
          } while (!QLog.isColorLevel());
          QLog.e("HotPicSearchEmoticonInfo", 2, "send to offen,please try it later");
          return;
        } while (!(paramAppRuntime instanceof QQAppInterface));
        localQQAppInterface = (QQAppInterface)paramAppRuntime;
        paramParcelable = (SessionInfo)paramParcelable;
        sLastTime = l;
        if (((paramContext instanceof BaseActivity)) && (HotChatUtil.a(paramParcelable.jdField_a_of_type_Int, paramParcelable.jdField_a_of_type_JavaLangString)))
        {
          paramAppRuntime = (BaseActivity)paramContext;
          QQToast.a(localQQAppInterface.getApp(), HardCodeUtil.a(2131701383), 0).b(paramAppRuntime.getTitleBarHeight());
          return;
        }
      } while (!(paramContext instanceof BaseActivity));
      paramEditText = null;
      Object localObject = AbsDownloader.getFile(this.mResultItem.url);
      paramAppRuntime = paramEditText;
      if (localObject != null)
      {
        paramAppRuntime = paramEditText;
        if (FileUtils.b(((File)localObject).getAbsolutePath()))
        {
          paramEditText = ((File)localObject).getAbsolutePath();
          paramAppRuntime = paramEditText;
          if (QLog.isColorLevel())
          {
            QLog.d("HotPicSearchEmoticonInfo", 2, "senHotPic, urlHotPicOringinal = " + this.mResultItem.url + ", paths = " + paramEditText);
            paramAppRuntime = paramEditText;
          }
        }
      }
      if ((paramAppRuntime == null) && (paramParcelable.jdField_a_of_type_Int != 1008))
      {
        QQToast.a(paramContext, 2131698884, 0).a();
        return;
      }
      paramEditText = new Intent();
      localObject = new ArrayList();
      ((ArrayList)localObject).add(paramAppRuntime);
      paramEditText.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", (ArrayList)localObject);
      paramEditText.putExtra("uin", paramParcelable.jdField_a_of_type_JavaLangString);
      paramEditText.putExtra("uintype", paramParcelable.jdField_a_of_type_Int);
      paramEditText.putExtra("troop_uin", paramParcelable.b);
      paramEditText.putExtra("key_confess_topicid", paramParcelable.e);
      paramEditText.putExtra("PhotoConst.SEND_SIZE_SPEC", 0);
      paramEditText.putExtra("send_in_background", true);
      paramEditText.putExtra("PhotoConst.SINGLE_PHOTO_PATH", (Serializable)localObject);
      paramEditText.putExtra("PicContants.NEED_COMPRESS", false);
      paramEditText.putExtra("quick_send_original_md5", this.mResultItem.md5);
      paramEditText.putExtra("quick_send_original_size", this.mResultItem.imgSize);
      paramEditText.putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1054);
      ThreadManager.post(new SendPhotoTask((BaseActivity)paramContext, paramEditText, null), 8, null, false);
      ReportController.b(localQQAppInterface, "dc00898", "", this.mCurFriendUin, "0X800B117", "0X800B117", EmoticonUtils.getRelatedEmotionReportFromType(this.mCurType), 0, "", this.mReportPosition + 1 + "", this.mResultItem.md5, this.mResultItem.url);
    } while (this.mDefaultCount <= 0);
    ReportController.b(localQQAppInterface, "dc00898", "", this.mCurFriendUin, "0X800B11E", "0X800B11E", this.mDefaultCount, 0, "", this.mReportPosition + 1 + "", this.mResultItem.md5, this.mResultItem.url);
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
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeInt(this.mDefaultCount);
    paramParcel.writeParcelable(this.mResultItem, paramInt);
    paramParcel.writeString(this.mCurFriendUin);
    paramParcel.writeInt(this.mCurType);
    paramParcel.writeInt(this.mReportPosition);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.relateemo.RelatedEmoSearchEmoticonInfo
 * JD-Core Version:    0.7.0.1
 */