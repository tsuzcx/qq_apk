package cooperation.qzone.contentbox;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.tencent.image.ApngImage;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.contentbox.model.CubicBezierInterpolator;
import cooperation.qzone.contentbox.model.MQMsg;
import cooperation.qzone.contentbox.model.MQMsgBody;
import cooperation.qzone.contentbox.model.MQPhotoCell;
import java.io.File;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.ArrayList;
import mqq.app.AppRuntime;

public abstract class BaseMsgView
  extends FrameLayout
{
  private static final int IMAGE_HEIGHT = ViewUtils.b(230.0F);
  private static final int IMAGE_WIDTH = ViewUtils.a() - ViewUtils.b(24.0F);
  private static final int MSG_PAGER_NEXT_ITEM = 10000;
  protected static final int PAGER_ITEM_TIME = 3000;
  private static final String TAG = "QZoneMsgManager.BaseMsgView";
  protected int apngTag;
  protected QQAppInterface app;
  protected Context mContext;
  protected MQMsg mData;
  protected BaseMsgView.MyHandler mUiHandler;
  protected QzoneMsgPagerAdapter pagerAdapter;
  protected int position;
  private WeakReference<ViewPager> reference;
  protected QzoneMsgViewPager viewPager;
  
  public BaseMsgView(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  public BaseMsgView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public BaseMsgView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public static URLDrawable getApngDrawable(AppRuntime paramAppRuntime, String paramString1, String paramString2, Drawable paramDrawable, int[] paramArrayOfInt, String paramString3, Bundle paramBundle)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return null;
    }
    paramAppRuntime = paramBundle;
    if (paramBundle == null) {}
    try
    {
      paramAppRuntime = new Bundle();
      boolean bool = paramAppRuntime.getBoolean("key_play_apng", true);
      int i = paramAppRuntime.getInt("key_loop");
      paramBundle = URLDrawable.URLDrawableOptions.obtain();
      paramBundle.mUseApngImage = bool;
      paramBundle.mUseMemoryCache = true;
      paramBundle.mMemoryCacheKeySuffix = (bool + "," + i);
      i = paramAppRuntime.getInt("key_width", 0);
      int j = paramAppRuntime.getInt("key_height", 0);
      if ((i > 0) && (j > 0)) {
        paramBundle.mRequestWidth = i;
      }
      for (paramBundle.mRequestHeight = j;; paramBundle.mRequestHeight = IMAGE_HEIGHT)
      {
        paramBundle.mLoadingDrawable = paramDrawable;
        paramBundle.mFailedDrawable = paramDrawable;
        paramAppRuntime.putIntArray("key_tagId_arr", paramArrayOfInt);
        paramAppRuntime.putString("key_name", paramString3);
        paramBundle.mExtraInfo = paramAppRuntime;
        paramAppRuntime = URLDrawable.getDrawable(new URL("qzonecontentboxdownloader", paramString1, paramString2), paramBundle);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("QZoneMsgManager.BaseMsgView", 2, "getApngDrawable ApngImage ok path:" + paramString1 + ", name=" + paramString3);
        break;
        paramBundle.mRequestWidth = IMAGE_WIDTH;
      }
      return paramAppRuntime;
    }
    catch (Exception paramAppRuntime)
    {
      QLog.e("QZoneMsgManager.BaseMsgView", 1, "getApngDrawable ApngImage err:" + paramAppRuntime.toString() + ", path:" + paramString1 + ", name=" + paramString3);
      return null;
    }
  }
  
  protected boolean doHandleMessage(Message paramMessage)
  {
    return false;
  }
  
  protected URLDrawable getApngDrawable()
  {
    String str1 = this.mContext.getFilesDir() + "/qzone_msg_content_box/";
    Object localObject = new File(str1);
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdir();
    }
    localObject = ((MQPhotoCell)this.mData.msgBody.photolist.get(0)).coverUrl;
    String str2 = MD5.toMD5((String)localObject).substring(0, 20);
    this.apngTag = (this.position + 10000);
    return getApngDrawable(this.app, str1 + str2, (String)localObject, null, new int[] { this.apngTag }, "content-box", null);
  }
  
  protected URLDrawable getUrlDrawable(String paramString)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mRequestWidth = IMAGE_WIDTH;
    localURLDrawableOptions.mRequestHeight = IMAGE_HEIGHT;
    return URLDrawable.getDrawable(paramString, localURLDrawableOptions);
  }
  
  protected void initViewPager()
  {
    try
    {
      Field localField = Class.forName("android.support.v4.view.ViewPager").getDeclaredField("mScroller");
      BaseMsgView.CustumScroller localCustumScroller = new BaseMsgView.CustumScroller(this.mContext, new CubicBezierInterpolator(0.25D, 0.1000000014901161D, 0.25D, 1.0D));
      localCustumScroller.setmDuration(400);
      localField.setAccessible(true);
      localField.set(this.viewPager, localCustumScroller);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("QZoneMsgManager.BaseMsgView", 1, "initViewPager error:", localException);
    }
  }
  
  public boolean isLargePhoto()
  {
    if (this.mData == null) {}
    while (this.mData.msgType == 6) {
      return false;
    }
    return true;
  }
  
  public void recycle()
  {
    stopAll();
    this.mContext = null;
    this.viewPager = null;
    this.reference = null;
    this.pagerAdapter = null;
    this.app = null;
    this.mData = null;
  }
  
  public void setApp(QQAppInterface paramQQAppInterface)
  {
    this.app = paramQQAppInterface;
  }
  
  public void setPosition(int paramInt)
  {
    this.position = paramInt;
  }
  
  public void startPlay()
  {
    if (this.mUiHandler == null) {
      return;
    }
    if ((this.viewPager != null) && (this.viewPager.getVisibility() == 0) && (this.pagerAdapter != null) && (this.pagerAdapter.getCount() > 1))
    {
      this.reference = new WeakReference(this.viewPager);
      Message localMessage = this.mUiHandler.obtainMessage(10000, this.pagerAdapter.getCount(), 0, this.reference);
      this.mUiHandler.removeMessages(10000);
      this.mUiHandler.sendMessageDelayed(localMessage, 3000L);
      return;
    }
    ApngImage.playByTag(this.apngTag);
  }
  
  public void stopAll()
  {
    if (this.mUiHandler == null) {
      return;
    }
    this.mUiHandler.removeMessages(10000);
  }
  
  public void stopPlay()
  {
    if ((this.mUiHandler == null) || (this.reference == null)) {
      return;
    }
    this.mUiHandler.removeMessages(10000, this.reference);
    ApngImage.pauseByTag(this.apngTag);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.contentbox.BaseMsgView
 * JD-Core Version:    0.7.0.1
 */