package com.tencent.qqmini.sdk.utils;

import com.tencent.qqmini.sdk.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;

public class MiniAppReportShareUtil
{
  public static final int DEST_TYPE_C2C = 0;
  public static final int DEST_TYPE_GROUP = 2;
  public static final int DEST_TYPE_TROOP = 1;
  public static final int SHARE_SCENE_DETAIL = 0;
  public static final int SHARE_SCENE_FIRST_PAGE = 1;
  public static final int SHARE_SCENE_OTHER_PAGE = 2;
  public static final int SHARE_TYPE_ARK = 0;
  public static final int SHARE_TYPE_ARK_TEMPLATE = 2;
  public static final int SHARE_TYPE_QZONE = 1;
  public static final int SHARE_TYPE_WECHAT = 3;
  public static final int SHARE_TYPE_WECHAT_ZONE = 4;
  private static final String TAG = "MiniAppReportShareUtil";
  private static MiniAppReportShareUtil mInstance;
  
  public static MiniAppReportShareUtil getInstance()
  {
    if (mInstance == null) {
      mInstance = new MiniAppReportShareUtil();
    }
    return mInstance;
  }
  
  public void reportShare(String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString2)
  {
    long l = System.currentTimeMillis();
    if (paramInt2 == 10) {}
    for (paramInt2 = 0;; paramInt2 = 1)
    {
      ((ChannelProxy)ProxyManager.get(ChannelProxy.class)).reportShare(null, l, paramString1, paramInt1, paramInt2, 0, paramInt4, paramString2, new MiniAppReportShareUtil.1(this, l, paramString1, paramInt1, paramInt2, paramInt4, paramString2));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.utils.MiniAppReportShareUtil
 * JD-Core Version:    0.7.0.1
 */