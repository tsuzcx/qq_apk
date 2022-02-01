package cooperation.qzone.contentbox;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.viewpager.widget.ViewPager;
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
  private static final int IMAGE_HEIGHT = ViewUtils.dpToPx(230.0F);
  private static final int IMAGE_WIDTH = ViewUtils.getScreenWidth() - ViewUtils.dpToPx(24.0F);
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(bool);
      localStringBuilder.append(",");
      localStringBuilder.append(i);
      paramBundle.mMemoryCacheKeySuffix = localStringBuilder.toString();
      i = paramAppRuntime.getInt("key_width", 0);
      int j = paramAppRuntime.getInt("key_height", 0);
      if ((i > 0) && (j > 0))
      {
        paramBundle.mRequestWidth = i;
        paramBundle.mRequestHeight = j;
      }
      else
      {
        paramBundle.mRequestWidth = IMAGE_WIDTH;
        paramBundle.mRequestHeight = IMAGE_HEIGHT;
      }
      paramBundle.mLoadingDrawable = paramDrawable;
      paramBundle.mFailedDrawable = paramDrawable;
      paramAppRuntime.putIntArray("key_tagId_arr", paramArrayOfInt);
      paramAppRuntime.putString("key_name", paramString3);
      paramBundle.mExtraInfo = paramAppRuntime;
      paramAppRuntime = URLDrawable.getDrawable(new URL("qzonecontentboxdownloader", paramString1, paramString2), paramBundle);
      if (QLog.isColorLevel())
      {
        paramString2 = new StringBuilder();
        paramString2.append("getApngDrawable ApngImage ok path:");
        paramString2.append(paramString1);
        paramString2.append(", name=");
        paramString2.append(paramString3);
        QLog.d("QZoneMsgManager.BaseMsgView", 2, paramString2.toString());
      }
      return paramAppRuntime;
    }
    catch (Exception paramAppRuntime)
    {
      paramString2 = new StringBuilder();
      paramString2.append("getApngDrawable ApngImage err:");
      paramString2.append(paramAppRuntime.toString());
      paramString2.append(", path:");
      paramString2.append(paramString1);
      paramString2.append(", name=");
      paramString2.append(paramString3);
      QLog.e("QZoneMsgManager.BaseMsgView", 1, paramString2.toString());
    }
    return null;
  }
  
  protected boolean doHandleMessage(Message paramMessage)
  {
    return false;
  }
  
  protected URLDrawable getApngDrawable()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(this.mContext.getFilesDir());
    ((StringBuilder)localObject1).append("/qzone_msg_content_box/");
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject2 = new File((String)localObject1);
    if (!((File)localObject2).exists()) {
      ((File)localObject2).mkdir();
    }
    localObject2 = ((MQPhotoCell)this.mData.msgBody.photolist.get(0)).coverUrl;
    String str = MD5.toMD5((String)localObject2).substring(0, 20);
    this.apngTag = (this.position + 10000);
    QQAppInterface localQQAppInterface = this.app;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject1);
    localStringBuilder.append(str);
    return getApngDrawable(localQQAppInterface, localStringBuilder.toString(), (String)localObject2, null, new int[] { this.apngTag }, "content-box", null);
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
      Field localField = Class.forName("androidx.viewpager.widget.ViewPager").getDeclaredField("mScroller");
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
    MQMsg localMQMsg = this.mData;
    if (localMQMsg == null) {
      return false;
    }
    return localMQMsg.msgType != 6;
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
    Object localObject = this.viewPager;
    if ((localObject != null) && (((QzoneMsgViewPager)localObject).getVisibility() == 0))
    {
      localObject = this.pagerAdapter;
      if ((localObject != null) && (((QzoneMsgPagerAdapter)localObject).getCount() > 1))
      {
        this.reference = new WeakReference(this.viewPager);
        localObject = this.mUiHandler.obtainMessage(10000, this.pagerAdapter.getCount(), 0, this.reference);
        this.mUiHandler.removeMessages(10000);
        this.mUiHandler.sendMessageDelayed((Message)localObject, 3000L);
        return;
      }
    }
    ApngImage.playByTag(this.apngTag);
  }
  
  public void stopAll()
  {
    BaseMsgView.MyHandler localMyHandler = this.mUiHandler;
    if (localMyHandler == null) {
      return;
    }
    localMyHandler.removeMessages(10000);
  }
  
  public void stopPlay()
  {
    BaseMsgView.MyHandler localMyHandler = this.mUiHandler;
    if (localMyHandler != null)
    {
      WeakReference localWeakReference = this.reference;
      if (localWeakReference == null) {
        return;
      }
      localMyHandler.removeMessages(10000, localWeakReference);
      ApngImage.pauseByTag(this.apngTag);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     cooperation.qzone.contentbox.BaseMsgView
 * JD-Core Version:    0.7.0.1
 */