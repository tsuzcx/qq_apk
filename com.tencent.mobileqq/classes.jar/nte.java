import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.common.WxShareHelperFromReadInjoy;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.QLog;

public class nte
{
  private static Bitmap a(Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return null;
    }
    try
    {
      int i = paramBitmap.getWidth();
      int j = paramBitmap.getHeight();
      localBitmap = paramBitmap;
      if (i * j > 8000)
      {
        double d = Math.sqrt(8000.0D / (i * j));
        localBitmap = Bitmap.createScaledBitmap(paramBitmap, (int)(i * d), (int)(j * d), true);
      }
    }
    catch (OutOfMemoryError paramBitmap)
    {
      for (;;)
      {
        System.gc();
        paramBitmap.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.d("VideoShareUtils", 2, "scaleBitmapForWeChat ERROR OutOfMemoryError");
        }
        localBitmap = null;
      }
    }
    catch (Exception paramBitmap)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("VideoShareUtils", 2, "scaleBitmapForWeChat ERROR e=" + paramBitmap.getMessage());
        }
        Bitmap localBitmap = null;
      }
    }
    return localBitmap;
  }
  
  public static void a(BaseActivity paramBaseActivity, String paramString1, String paramString2, String paramString3, Bitmap paramBitmap, boolean paramBoolean, String paramString4, syx paramsyx)
  {
    int k = 0;
    int j = 0;
    if (paramString1 == null) {}
    for (paramBaseActivity = "";; paramBaseActivity = paramString1)
    {
      if (paramString2 == null) {}
      for (paramString1 = "";; paramString1 = paramString2)
      {
        int i;
        if (!WXShareHelper.a().a()) {
          i = 2131721478;
        }
        for (;;)
        {
          if (i != -1) {
            xxb.a(0, i);
          }
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.d("VideoShareUtils", 2, "title=" + paramBaseActivity + ", description=" + paramString1 + ", shareUrl=" + paramString3 + ", toWeChat=" + paramBoolean);
            }
            return;
            if (WXShareHelper.a().b()) {
              break label274;
            }
            i = 2131721479;
            break;
            paramString2 = String.valueOf(System.currentTimeMillis());
            paramsyx = new ntf(paramString2, paramsyx);
            WXShareHelper.a().a(paramsyx);
            if ((!paramBoolean) || (TextUtils.isEmpty(paramString4))) {
              break label178;
            }
            WxShareHelperFromReadInjoy.a().b(paramString2, paramBaseActivity, paramBitmap, paramString1, paramString3, paramString4);
          }
          label178:
          if (bjxj.t(ors.a()) == 1)
          {
            paramString4 = WXShareHelper.a();
            paramBitmap = a(paramBitmap);
            if (paramBoolean) {}
            for (i = j;; i = 1)
            {
              paramString4.c(paramString2, paramBaseActivity, paramBitmap, paramString1, paramString3, i);
              break;
            }
          }
          paramString4 = WxShareHelperFromReadInjoy.a();
          paramBitmap = a(paramBitmap);
          if (paramBoolean) {}
          for (i = k;; i = 1)
          {
            paramString4.b(paramString2, paramBaseActivity, paramBitmap, paramString1, paramString3, i);
            break;
          }
          label274:
          i = -1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     nte
 * JD-Core Version:    0.7.0.1
 */