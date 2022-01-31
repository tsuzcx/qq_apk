package com.tencent.upload.uinterface;

import android.content.Context;
import android.content.Intent;
import com.tencent.upload.common.UploadConfiguration;
import com.tencent.upload.network.route.UploadRoute;
import com.tencent.upload.network.route.c.a;
import java.util.StringTokenizer;

public class Utility
{
  public static final boolean clearUploadTempCache(Context paramContext)
  {
    return IUploadService.UploadServiceCreator.getInstance().clearCacheWhenIdle(paramContext);
  }
  
  public static String decrypt(String paramString)
  {
    try
    {
      String str = new String();
      StringTokenizer localStringTokenizer = new StringTokenizer(paramString, "%");
      int i;
      for (paramString = str; localStringTokenizer.hasMoreElements(); paramString = paramString + (char)(i - 27)) {
        i = Integer.parseInt((String)localStringTokenizer.nextElement());
      }
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public static final long getCurrentUploadServerTime()
  {
    long[] arrayOfLong = UploadConfiguration.getUploadServerTimePair();
    if ((arrayOfLong == null) || (arrayOfLong.length != 2) || (arrayOfLong[0] <= 0L) || (arrayOfLong[1] <= 0L)) {
      return System.currentTimeMillis() / 1000L;
    }
    return arrayOfLong[0] + System.currentTimeMillis() / 1000L - arrayOfLong[1];
  }
  
  public static final void keepLongConnection(Context paramContext, Long paramLong, String paramString)
  {
    keepLongConnection(paramContext, paramLong, paramString, "126%138%136%73%140%149%138%137%128%", "126%138%136%73%143%128%137%126%128%137%143%73%146%137%142%73%128%147%139%138%141%143%73%96%136%139%143%148%110%128%141%145%132%126%128%");
  }
  
  public static final void keepLongConnection(Context paramContext, Long paramLong, String paramString1, String paramString2, String paramString3)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("param_from", 0);
    localIntent.putExtra("param_uin", paramLong);
    localIntent.putExtra("param_scene", 2);
    localIntent.putExtra("param_push_data", paramString1);
    localIntent.setClassName(decrypt(paramString2), decrypt(paramString3));
    paramContext.startService(localIntent);
  }
  
  public static final boolean needCompress2Webp(int paramInt1, int paramInt2)
  {
    if ((paramInt2 == 2) && ((paramInt1 & 0x10) == 16)) {}
    while ((paramInt2 != 2) && (paramInt2 != 3) && ((paramInt1 & 0x1) == 1)) {
      return true;
    }
    return false;
  }
  
  public static class AlbumTypeID
  {
    public static final int ALBUM_BLOG = 2;
    public static final int ALBUM_BLOGFACE = 9;
    public static final int ALBUM_CAMPUS = 5;
    public static final int ALBUM_COMMON = 0;
    public static final int ALBUM_KING = 24;
    public static final int ALBUM_MICRO = 11;
    public static final int ALBUM_MOBILE = 1;
    public static final int ALBUM_OLDMICRO = 12;
    public static final int ALBUM_OLDPYHEAD = 18;
    public static final int ALBUM_OLDQPAI = 14;
    public static final int ALBUM_OLDQPAI_SYNC = 16;
    public static final int ALBUM_OLDQZONEAPP = 20;
    public static final int ALBUM_PPT = 10;
    public static final int ALBUM_PRIVBLOG = 7;
    public static final int ALBUM_PYHEAD = 17;
    public static final int ALBUM_QPAI = 13;
    public static final int ALBUM_QPAI_SYNC = 15;
    public static final int ALBUM_QQSHOW = 4;
    public static final int ALBUM_QZONEAPP = 19;
    public static final int ALBUM_SHARE = 23;
    public static final int ALBUM_SHARE_OLD = 21;
    public static final int ALBUM_SYSTEM = 22;
    public static final int ALBUM_WEAPP = 25;
  }
  
  public static enum TestServerCategory
  {
    private int a;
    private String b;
    private String c;
    private int d;
    
    static
    {
      DB = new TestServerCategory("DB", 1, 1, "DB", "113.108.67.20", 14000);
      DEV = new TestServerCategory("DEV", 2, 2, "开发", "113.108.67.16", 14000);
      DEBUG1 = new TestServerCategory("DEBUG1", 3, 3, "联调1", "183.61.56.21", 14000);
      DEBUG2 = new TestServerCategory("DEBUG2", 4, 4, "联调2", "183.61.56.21", 14000);
      DEBUG3 = new TestServerCategory("DEBUG3", 5, 5, "联调3", "113.108.84.33", 14000);
      DEBUG4 = new TestServerCategory("DEBUG4", 6, 6, "联调4", "113.108.89.186", 14000);
      DEBUG5 = new TestServerCategory("DEBUG5", 7, 7, "联调5", "59.37.116.68", 14000);
      DEBUG6 = new TestServerCategory("DEBUG6", 8, 8, "联调6", "183.61.56.21", 14000);
      DEBUG7 = new TestServerCategory("DEBUG7", 9, 9, "联调7", "58.250.9.61", 14000);
      DEBUG8 = new TestServerCategory("DEBUG8", 10, 10, "联调8", "58.250.9.60", 14000);
      DEBUG9 = new TestServerCategory("DEBUG9", 11, 11, "联调9", "58.251.80.171", 14000);
    }
    
    private TestServerCategory(int paramInt1, String paramString1, String paramString2, int paramInt2)
    {
      this.a = paramInt1;
      this.b = paramString1;
      this.c = paramString2;
      this.d = paramInt2;
    }
    
    public String getName()
    {
      return this.b;
    }
    
    public String getServerIp()
    {
      return this.c;
    }
    
    public int getServerPort()
    {
      return this.d;
    }
    
    public int getType()
    {
      return this.a;
    }
    
    public UploadRoute getUploadRoute()
    {
      return new UploadRoute(this.c, this.d, c.a.c);
    }
    
    public void setServerIp(String paramString)
    {
      if (this.a != CUSTOM.getType()) {
        return;
      }
      this.c = paramString;
    }
    
    public void setServerPort(int paramInt)
    {
      if (this.a != CUSTOM.getType()) {
        return;
      }
      this.d = paramInt;
    }
    
    public String toString()
    {
      return this.b + "(" + this.c + ":" + this.d + ")";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.upload.uinterface.Utility
 * JD-Core Version:    0.7.0.1
 */