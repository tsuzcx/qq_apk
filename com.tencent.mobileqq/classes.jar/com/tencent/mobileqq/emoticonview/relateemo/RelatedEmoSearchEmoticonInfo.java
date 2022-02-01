package com.tencent.mobileqq.emoticonview.relateemo;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.widget.EditText;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.core.util.EmoticonPanelUtils;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.api.IEmosmService;
import com.tencent.mobileqq.nearby.api.IHotChatUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import mqq.app.AppRuntime;

public class RelatedEmoSearchEmoticonInfo
  extends EmoticonInfo
  implements Parcelable, IRelatedEmoSearchEmoticonInfo
{
  public static final Parcelable.Creator<RelatedEmoSearchEmoticonInfo> CREATOR = new RelatedEmoSearchEmoticonInfo.1();
  static final long ONE_SEC = 1000L;
  public static final String TAG = "HotPicSearchEmoticonInfo";
  static long sLastTime;
  public static Drawable sLoadingDrawable = new ColorDrawable(-855310);
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
    Drawable localDrawable = sLoadingDrawable;
    paramContext.mLoadingDrawable = localDrawable;
    paramContext.mFailedDrawable = localDrawable;
    paramContext.mPlayGifImage = true;
    return URLDrawable.getDrawable(this.mResultItem.url, paramContext);
  }
  
  public void send(AppRuntime paramAppRuntime, Context paramContext, EditText paramEditText, Parcelable paramParcelable)
  {
    if (paramAppRuntime == null)
    {
      QLog.e("HotPicSearchEmoticonInfo", 2, "app is null.");
      return;
    }
    long l = System.currentTimeMillis();
    if (l - sLastTime < 1000L)
    {
      if (QLog.isColorLevel()) {
        QLog.e("HotPicSearchEmoticonInfo", 2, "send to offen,please try it later");
      }
      return;
    }
    if (!(paramAppRuntime instanceof BaseQQAppInterface)) {
      return;
    }
    BaseQQAppInterface localBaseQQAppInterface = (BaseQQAppInterface)paramAppRuntime;
    paramParcelable = (BaseSessionInfo)paramParcelable;
    sLastTime = l;
    boolean bool = paramContext instanceof QBaseActivity;
    if ((bool) && (((IHotChatUtil)QRoute.api(IHotChatUtil.class)).isHotChatMsg(paramParcelable.jdField_a_of_type_Int, paramParcelable.jdField_a_of_type_JavaLangString)))
    {
      paramAppRuntime = (QBaseActivity)paramContext;
      QQToast.a(localBaseQQAppInterface.getApp(), HardCodeUtil.a(2131701523), 0).b(paramAppRuntime.getTitleBarHeight());
      return;
    }
    if (!bool) {
      return;
    }
    paramAppRuntime = AbsDownloader.getFile(this.mResultItem.url);
    if ((paramAppRuntime != null) && (FileUtils.fileExistsAndNotEmpty(paramAppRuntime.getAbsolutePath())))
    {
      paramEditText = paramAppRuntime.getAbsolutePath();
      paramAppRuntime = paramEditText;
      if (QLog.isColorLevel())
      {
        paramAppRuntime = new StringBuilder();
        paramAppRuntime.append("senHotPic, urlHotPicOringinal = ");
        paramAppRuntime.append(this.mResultItem.url);
        paramAppRuntime.append(", paths = ");
        paramAppRuntime.append(paramEditText);
        QLog.d("HotPicSearchEmoticonInfo", 2, paramAppRuntime.toString());
        paramAppRuntime = paramEditText;
      }
    }
    else
    {
      paramAppRuntime = null;
    }
    if ((paramAppRuntime == null) && (paramParcelable.jdField_a_of_type_Int != 1008))
    {
      QQToast.a(paramContext, 2131698963, 0).a();
      return;
    }
    paramEditText = new Intent();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramAppRuntime);
    paramEditText.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", localArrayList);
    paramEditText.putExtra("uin", paramParcelable.jdField_a_of_type_JavaLangString);
    paramEditText.putExtra("uintype", paramParcelable.jdField_a_of_type_Int);
    paramEditText.putExtra("troop_uin", paramParcelable.b);
    paramEditText.putExtra("key_confess_topicid", paramParcelable.e);
    paramEditText.putExtra("PhotoConst.SEND_SIZE_SPEC", 0);
    paramEditText.putExtra("send_in_background", true);
    paramEditText.putExtra("PhotoConst.SINGLE_PHOTO_PATH", localArrayList);
    paramEditText.putExtra("PicContants.NEED_COMPRESS", false);
    paramEditText.putExtra("quick_send_original_md5", this.mResultItem.md5);
    paramEditText.putExtra("quick_send_original_size", this.mResultItem.imgSize);
    paramEditText.putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1054);
    ThreadManager.post(((IEmosmService)QRoute.api(IEmosmService.class)).createSendPhotoTask((QBaseActivity)paramContext, paramEditText, null), 8, null, false);
    paramAppRuntime = this.mCurFriendUin;
    int i = EmoticonPanelUtils.a(this.mCurType);
    paramContext = new StringBuilder();
    paramContext.append(this.mReportPosition + 1);
    paramContext.append("");
    ReportController.b(localBaseQQAppInterface, "dc00898", "", paramAppRuntime, "0X800B117", "0X800B117", i, 0, "", paramContext.toString(), this.mResultItem.md5, this.mResultItem.url);
    i = this.mDefaultCount;
    if (i > 0)
    {
      paramAppRuntime = this.mCurFriendUin;
      paramContext = new StringBuilder();
      paramContext.append(this.mReportPosition + 1);
      paramContext.append("");
      ReportController.b(localBaseQQAppInterface, "dc00898", "", paramAppRuntime, "0X800B11E", "0X800B11E", i, 0, "", paramContext.toString(), this.mResultItem.md5, this.mResultItem.url);
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.relateemo.RelatedEmoSearchEmoticonInfo
 * JD-Core Version:    0.7.0.1
 */