package com.tencent.mobileqq.flashshow.part;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.qcircleshadow.lib.variation.HostDataTransUtils;
import com.tencent.biz.richframework.delegate.impl.RFThreadManager;
import com.tencent.mobileqq.flashshow.bean.FSShareInfo;
import com.tencent.mobileqq.flashshow.utils.FSTransUtils;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StImage;
import feedcloud.FeedCloudMeta.StShare;
import feedcloud.FeedCloudMeta.StUser;
import java.util.Map;

class FSSharePart$10
  implements Runnable
{
  FSSharePart$10(FSSharePart paramFSSharePart, Map paramMap, Runnable paramRunnable) {}
  
  private void a(Bitmap paramBitmap)
  {
    if (paramBitmap != null)
    {
      int j = paramBitmap.getWidth();
      int i = paramBitmap.getHeight();
      int k = j * i;
      Bitmap localBitmap = paramBitmap;
      if (k > 8000)
      {
        double d1 = k;
        Double.isNaN(d1);
        d1 = Math.sqrt(8000.0D / d1);
        double d2 = j;
        Double.isNaN(d2);
        j = (int)(d2 * d1);
        d2 = i;
        Double.isNaN(d2);
        localBitmap = Bitmap.createScaledBitmap(paramBitmap, j, (int)(d2 * d1), true);
        if (FSSharePart.m(this.this$0).d != 1) {
          paramBitmap.recycle();
        }
      }
      this.a.put("image", localBitmap);
      RFThreadManager.getUIHandler().post(this.b);
    }
  }
  
  public void run()
  {
    try
    {
      if (FSSharePart.m(this.this$0) == null) {
        return;
      }
      if (FSSharePart.m(this.this$0).d == 1)
      {
        QLog.d("FSSharePart", 1, "shareToWeChat share user icon");
        HostDataTransUtils.getUserFaceBitmap(FSSharePart.m(this.this$0).a.poster.id.get(), new FSSharePart.10.1(this));
        return;
      }
      QLog.d("FSSharePart", 1, "shareToWeChat share url icon");
      byte[] arrayOfByte = HttpUtil.openUrlForByte(FSTransUtils.f(), FSSharePart.m(this.this$0).a.share.cover.picUrl.get(), "GET", null, null);
      if (arrayOfByte != null)
      {
        a(BitmapFactory.decodeByteArray(arrayOfByte, 0, arrayOfByte.length));
        return;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("shareToWeChat  OutOfMemoryError : ");
      localStringBuilder.append(localOutOfMemoryError.getMessage());
      QLog.e("FSSharePart", 1, localStringBuilder.toString());
      return;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("shareToWeChat  Exception : ");
      localStringBuilder.append(localException.getMessage());
      QLog.e("FSSharePart", 1, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.part.FSSharePart.10
 * JD-Core Version:    0.7.0.1
 */