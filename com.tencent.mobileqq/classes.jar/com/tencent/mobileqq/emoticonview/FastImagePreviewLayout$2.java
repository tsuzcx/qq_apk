package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.SystemClock;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.rebuild.PlusPanelUtils;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MediaFileFilter;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.AlbumThumbDownloader;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.util.EmptyStackException;
import java.util.List;
import mqq.os.MqqHandler;

class FastImagePreviewLayout$2
  implements Runnable
{
  FastImagePreviewLayout$2(FastImagePreviewLayout paramFastImagePreviewLayout) {}
  
  public void run()
  {
    SystemClock.elapsedRealtime();
    if (QLog.isColorLevel()) {
      QLog.d(FastImagePreviewLayout.TAG, 2, "queryFastImage called start!");
    }
    Object localObject1 = AlbumUtil.a(this.this$0.context, 210, 1, MediaFileFilter.MEDIA_FILTER_SHOW_IMAGE);
    if ((localObject1 != null) && (((List)localObject1).size() > 0))
    {
      int i = 0;
      LocalMediaInfo localLocalMediaInfo = (LocalMediaInfo)((List)localObject1).get(0);
      if (QLog.isColorLevel())
      {
        localObject1 = FastImagePreviewLayout.TAG;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("queryFastImage, imageInfo.path = ");
        ((StringBuilder)localObject2).append(localLocalMediaInfo.path);
        QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
      }
      if ((PlusPanelUtils.b != null) && (PlusPanelUtils.b.equals(localLocalMediaInfo.path)))
      {
        if (QLog.isColorLevel()) {
          QLog.d(FastImagePreviewLayout.TAG, 2, "queryFastImage return 1");
        }
        return;
      }
      PlusPanelUtils.b = localLocalMediaInfo.path;
      localObject1 = BaseApplication.getContext();
      if (Build.VERSION.SDK_INT > 10) {
        i = 4;
      }
      localObject1 = ((BaseApplication)localObject1).getSharedPreferences("presend_config_sp", i).getString("shot_photo_path", "");
      if (PlusPanelUtils.b.equals(localObject1))
      {
        if (QLog.isColorLevel()) {
          QLog.d(FastImagePreviewLayout.TAG, 2, "queryFastImage return 2，peak shot photo");
        }
        return;
      }
      if ((PlusPanelUtils.a != null) && (PlusPanelUtils.b.equals(PlusPanelUtils.a)))
      {
        if (QLog.isColorLevel()) {
          QLog.d(FastImagePreviewLayout.TAG, 2, "queryFastImage return 2.dataline shot photo");
        }
        return;
      }
      if (localLocalMediaInfo.path.contains("/tencent/zebra/cache/"))
      {
        if (QLog.isColorLevel()) {
          QLog.d(FastImagePreviewLayout.TAG, 2, "queryFastImage return 3");
        }
        return;
      }
      ColorDrawable localColorDrawable = new ColorDrawable(570425344);
      Object localObject2 = null;
      Object localObject3;
      try
      {
        localObject1 = this.this$0.context.getResources().getDrawable(2130849738);
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        localObject1 = localObject2;
        if (QLog.isColorLevel())
        {
          localObject1 = FastImagePreviewLayout.TAG;
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("queryFastImage OutOfMemoryError = ");
          ((StringBuilder)localObject3).append(localOutOfMemoryError);
          QLog.d((String)localObject1, 2, ((StringBuilder)localObject3).toString());
          localObject1 = localObject2;
        }
      }
      catch (NullPointerException localNullPointerException)
      {
        localObject1 = localObject2;
        if (QLog.isColorLevel())
        {
          localObject1 = FastImagePreviewLayout.TAG;
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("queryFastImage NullPointerException = ");
          ((StringBuilder)localObject3).append(localNullPointerException);
          QLog.d((String)localObject1, 2, ((StringBuilder)localObject3).toString());
          localObject1 = localObject2;
        }
      }
      catch (EmptyStackException localEmptyStackException)
      {
        localObject1 = localObject2;
        if (QLog.isColorLevel())
        {
          localObject1 = FastImagePreviewLayout.TAG;
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("queryFastImage EmptyStackException = ");
          ((StringBuilder)localObject3).append(localEmptyStackException);
          QLog.d((String)localObject1, 2, ((StringBuilder)localObject3).toString());
          localObject1 = localObject2;
        }
      }
      localObject2 = AlbumUtil.generateAlbumThumbURL(localLocalMediaInfo);
      i = AlbumThumbDownloader.THUMB_WIDHT;
      localLocalMediaInfo.thumbHeight = i;
      localLocalMediaInfo.thumbWidth = i;
      long l1 = System.currentTimeMillis();
      long l2 = l1 - localLocalMediaInfo.addedDate * 1000L;
      String str1;
      if (QLog.isColorLevel())
      {
        str1 = FastImagePreviewLayout.TAG;
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("queryFastImage called, spentTime = ");
        ((StringBuilder)localObject3).append(l2);
        ((StringBuilder)localObject3).append(",currentTime = ");
        ((StringBuilder)localObject3).append(l1);
        ((StringBuilder)localObject3).append(",addedTime = ");
        ((StringBuilder)localObject3).append(localLocalMediaInfo.addedDate);
        ((StringBuilder)localObject3).append(",modifiedTime = ");
        ((StringBuilder)localObject3).append(localLocalMediaInfo.modifiedDate);
        QLog.d(str1, 2, ((StringBuilder)localObject3).toString());
      }
      if (this.this$0.mPicTimeInterval == 0L)
      {
        str1 = ((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.aio_fastimage.name(), "120000");
        try
        {
          this.this$0.mPicTimeInterval = Long.valueOf(str1).longValue();
        }
        catch (NumberFormatException localNumberFormatException)
        {
          if (QLog.isColorLevel())
          {
            localObject3 = FastImagePreviewLayout.TAG;
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("queryFastImage NumberFormatException = ");
            localStringBuilder.append(localNumberFormatException);
            QLog.d((String)localObject3, 2, localStringBuilder.toString());
          }
          this.this$0.mPicTimeInterval = 120000L;
        }
      }
      if (QLog.isColorLevel())
      {
        String str2 = FastImagePreviewLayout.TAG;
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("queryFastImage called, mPicTimeInterval = ");
        ((StringBuilder)localObject3).append(this.this$0.mPicTimeInterval);
        QLog.d(str2, 2, ((StringBuilder)localObject3).toString());
      }
      if (l2 < this.this$0.mPicTimeInterval)
      {
        this.this$0.fastImgDrawable = URLDrawableHelper.getDrawable((URL)localObject2, localColorDrawable, (Drawable)localObject1);
        this.this$0.fastImgDrawable.setTag(localLocalMediaInfo);
        this.this$0.fastImgDrawable.startDownload();
        this.this$0.mHandler.sendMessage(this.this$0.mHandler.obtainMessage(32));
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d(FastImagePreviewLayout.TAG, 2, "queryFastImage called end!");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.FastImagePreviewLayout.2
 * JD-Core Version:    0.7.0.1
 */