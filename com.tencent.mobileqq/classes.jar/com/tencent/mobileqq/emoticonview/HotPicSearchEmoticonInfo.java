package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.widget.EditText;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.emosm.emosearch.EmotionSearchItem;
import com.tencent.mobileqq.emoticonview.api.IHotPicSearchService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import mqq.app.AppRuntime;

public class HotPicSearchEmoticonInfo
  extends EmoticonInfo
  implements Parcelable
{
  public static final Parcelable.Creator<HotPicSearchEmoticonInfo> CREATOR = new HotPicSearchEmoticonInfo.1();
  static final long ONE_SEC = 1000L;
  public static final String TAG = "HotPicSearchEmoticonInfo";
  static long lastTime;
  public static Drawable sLoadingDrawable = new ColorDrawable(-855310);
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
  
  protected HotPicSearchEmoticonInfo(Parcel paramParcel)
  {
    super(paramParcel);
    this.mSearchItem = ((EmotionSearchItem)paramParcel.readParcelable(EmotionSearchItem.class.getClassLoader()));
    this.mSearchWord = paramParcel.readString();
    this.mPageType = paramParcel.readInt();
    this.mReportPosition = paramParcel.readInt();
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
    paramContext.mLoadingDrawable = sLoadingDrawable;
    paramContext.mFailedDrawable = sLoadingDrawable;
    paramContext.mPlayGifImage = true;
    paramContext.mExtraInfo = this.mSearchItem;
    URL localURL = ((IHotPicSearchService)QRoute.api(IHotPicSearchService.class)).getURL(this.mSearchItem.url);
    if (localURL == null) {
      return null;
    }
    return URLDrawable.getDrawable(localURL, paramContext);
  }
  
  public void send(AppRuntime paramAppRuntime, Context paramContext, EditText paramEditText, Parcelable paramParcelable)
  {
    if (paramAppRuntime == null) {
      QLog.e("HotPicSearchEmoticonInfo", 2, "app is null.");
    }
    long l;
    do
    {
      return;
      l = System.currentTimeMillis();
      if (l - lastTime >= 1000L) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("HotPicSearchEmoticonInfo", 2, "send to offen,please try it later");
    return;
    lastTime = l;
    ((IHotPicSearchService)QRoute.api(IHotPicSearchService.class)).send(paramAppRuntime, paramContext, paramEditText, paramParcelable, this.mSearchItem, this.mSearchWord, this.mPageType, this.mReportPosition);
  }
  
  public String toString()
  {
    return String.format("HotPicSearchEmoticonInfo, SearchItem %s", new Object[] { this.mSearchItem.toString() });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeParcelable(this.mSearchItem, paramInt);
    paramParcel.writeString(this.mSearchWord);
    paramParcel.writeInt(this.mPageType);
    paramParcel.writeInt(this.mReportPosition);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.HotPicSearchEmoticonInfo
 * JD-Core Version:    0.7.0.1
 */