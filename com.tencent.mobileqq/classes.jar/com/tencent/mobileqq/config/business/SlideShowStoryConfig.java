package com.tencent.mobileqq.config.business;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;

public class SlideShowStoryConfig
  extends IQConfigProcessor<SlideShowStoryConfigBean>
{
  @NonNull
  public SlideShowStoryConfigBean a(int paramInt)
  {
    return new SlideShowStoryConfigBean();
  }
  
  @Nullable
  public SlideShowStoryConfigBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0))
    {
      SlideShowStoryConfigBean localSlideShowStoryConfigBean = SlideShowStoryConfigBean.a(paramArrayOfQConfItem[0].a);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onParsed ");
        localStringBuilder.append(paramArrayOfQConfItem[0].a);
        QLog.d("SlideShowStoryConfig", 2, localStringBuilder.toString());
      }
      return localSlideShowStoryConfigBean;
    }
    return null;
  }
  
  public void a(SlideShowStoryConfigBean paramSlideShowStoryConfigBean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SlideShowStoryConfig", 2, new Object[] { paramSlideShowStoryConfigBean });
    }
  }
  
  public Class<SlideShowStoryConfigBean> clazz()
  {
    return SlideShowStoryConfigBean.class;
  }
  
  public boolean isNeedCompressed()
  {
    return true;
  }
  
  public boolean isNeedStoreLargeFile()
  {
    return false;
  }
  
  public int migrateOldVersion()
  {
    return 0;
  }
  
  public void onReqFailed(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SlideShowStoryConfig", 2, "onReqFailed");
    }
  }
  
  public int type()
  {
    return 362;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.SlideShowStoryConfig
 * JD-Core Version:    0.7.0.1
 */