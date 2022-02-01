package com.tencent.mobileqq.kandian.biz.skin;

import android.content.Context;
import com.tencent.mobileqq.kandian.biz.pullrefresh.ReadInJoyAnimBaseManager;
import com.tencent.mobileqq.kandian.biz.pullrefresh.ReadInJoyAnimDefaultManager;
import com.tencent.mobileqq.kandian.biz.pullrefresh.ReadInJoyAnimOldManager;
import com.tencent.mobileqq.kandian.biz.skin.api.IReadInJoyRefreshAnimFactory;

public class ReadInJoyRefreshAnimFactory
  implements IReadInJoyRefreshAnimFactory
{
  public static final int PULL_REFRESH_TYPE_DEFAULT = 0;
  public static final int PULL_REFRESH_TYPE_OLD = 1;
  public static final int PULL_REFRESH_TYPE_SKIN = 2;
  
  public ReadInJoyAnimBaseManager getAnimManger(Context paramContext, int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2) {
        return new ReadInJoyAnimDefaultManager(paramContext);
      }
      return new ReadInJoySkinAnimManager(paramContext);
    }
    return new ReadInJoyAnimOldManager(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.skin.ReadInJoyRefreshAnimFactory
 * JD-Core Version:    0.7.0.1
 */