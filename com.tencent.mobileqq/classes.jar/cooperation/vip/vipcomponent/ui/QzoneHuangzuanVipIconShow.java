package cooperation.vip.vipcomponent.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.text.TextUtils;
import android.util.LruCache;
import com.tencent.mobileqq.utils.ViewUtils;
import cooperation.qzone.statistic.Singleton;
import cooperation.vip.vipcomponent.VipUtils;
import cooperation.vip.vipcomponent.util.AdapterConst;
import cooperation.vip.vipcomponent.util.VLog;
import cooperation.vip.vipcomponent.util.VipResources;
import cooperation.vip.vipcomponent.util.VipResourcesListener;
import cooperation.vip.vipcomponent.util.ZipResLoadListener;

public class QzoneHuangzuanVipIconShow
{
  public static int ANUAL_ICON_MARGIN_LEFT = 0;
  public static int ANUAL_ICON_MARGIN_LEFT_IF_LV9 = 0;
  public static final int HIGHEST_LEVEL = 8;
  public static int ICON_ADJUST_ANNUALVIP_MARGIN_TOP = (int)(ViewUtils.getDensity() * 9.0F);
  public static int ICON_ANNUALVIP_HEIGHT = 0;
  public static int ICON_ANNUALVIP_WIDTH = (int)(ViewUtils.getDensity() * 27.0F);
  public static int ICON_DEFAULT_SIZE = AdapterConst.b;
  public static final int LOWEST_LEVEL = 1;
  public static int LV9_GUAN_ICON_HEIGHT = 0;
  public static int LV9_GUAN_ICON_MARGIN_LEFT = 0;
  public static int LV9_GUAN_ICON_MARGIN_TOP = 0;
  public static int LV9_GUAN_ICON_WIDTH = 0;
  public static int LV9_WINDS_HEIGHT = 0;
  public static int LV9_WINDS_MARGIN_LEFT = 0;
  public static int LV9_WINDS_MARGIN_TOP = 0;
  public static int LV9_WINDS_WIDTH = 0;
  public static int PERSONALIZED_ICON_ANUAL_LEFT = 0;
  public static int PERSONALIZED_ICON_AVATAR_TOP = 0;
  public static int PERSONALIZED_ICON_HEAD_HEIGHT = 0;
  public static int PERSONALIZED_ICON_HEAD_WIDTH = 0;
  public static int PERSONALIZED_ICON_LV_HEIGHT = 0;
  public static int PERSONALIZED_ICON_LV_MARGIN_TOP = 0;
  public static int PERSONALIZED_ICON_LV_WIDTH = (int)(ViewUtils.getDensity() * 26.0F);
  public static int PERSONALIZED_ICON_YEAR_HEIGHT = 0;
  public static int PERSONALIZED_ICON_YEAR_WIDTH = 0;
  private static final int RES_BG = 1;
  private static final int RES_CUSTOM_DIAMOND = 10;
  private static final int RES_KINGBG = 9;
  private static final int RES_LEVEL = 2;
  private static final int RES_LV9_GUAN = 7;
  private static final int RES_LV9_WINDS = 8;
  private static final int RES_NORMAL_ANNUAL = 5;
  private static final int RES_PERSONALIZED_ANNUAL = 6;
  private static final int RES_PERSONALIZED_HEAD = 0;
  private static final int RES_PERSONALIZED_LEVEL = 4;
  private static final int RES_RIBBON_LEVEL = 3;
  public static int RIBBON_ICON_BG_MARGIN_LEFT;
  public static final int RIBBON_ICON_LEVEL_MARGIN_TOP;
  private static final Singleton<QzoneHuangzuanVipIconShow, Context> sSingleton = new QzoneHuangzuanVipIconShow.1();
  private Context context;
  private LruCache<String, Drawable.ConstantState> layerCache;
  private int[] mAnunalGrayVipIdListInAvatar = { 9, 10, 11, 12, 13, 14, 15, 16, 17 };
  private int[] mAnunalVipIdListInAvatar = { 27, 28, 29, 30, 31, 32, 33, 34, 35 };
  private int[] mAnunalVipIdListInRibbon = { 85, 86, 87, 88, 89, 90, 91, 92, 93 };
  private int[] mNormalGrayVipIdListInAvatar = { 18, 19, 20, 21, 22, 23, 24, 25, 26 };
  private int[] mNormalVipIdListInAvatar = { 36, 37, 38, 39, 40, 41, 42, 43, 44 };
  private int[] mNormalVipIdListInRibbon = { 94, 95, 96, 97, 98, 99, 100, 101, 102 };
  
  static
  {
    PERSONALIZED_ICON_LV_HEIGHT = (int)(ViewUtils.getDensity() * 9.0F);
    PERSONALIZED_ICON_HEAD_HEIGHT = (int)(ViewUtils.getDensity() * 23.0F);
    PERSONALIZED_ICON_HEAD_WIDTH = (int)(ViewUtils.getDensity() * 11.0F);
    PERSONALIZED_ICON_YEAR_WIDTH = (int)(ViewUtils.getDensity() * 40.0F);
    PERSONALIZED_ICON_YEAR_HEIGHT = (int)(ViewUtils.getDensity() * 24.0F);
    PERSONALIZED_ICON_LV_MARGIN_TOP = (int)(ViewUtils.getDensity() * 21.0F);
    RIBBON_ICON_BG_MARGIN_LEFT = (int)(ViewUtils.getDensity() * 1.0F);
    ANUAL_ICON_MARGIN_LEFT = (int)(ViewUtils.getDensity() * 2.0F);
    ANUAL_ICON_MARGIN_LEFT_IF_LV9 = (int)(ViewUtils.getDensity() * 5.0F);
    PERSONALIZED_ICON_AVATAR_TOP = (int)(ViewUtils.getDensity() * 1.0F);
    LV9_GUAN_ICON_MARGIN_LEFT = (int)(ViewUtils.getDensity() * 1.0F);
    LV9_GUAN_ICON_MARGIN_TOP = (int)(ViewUtils.getDensity() * -3.0F);
    LV9_GUAN_ICON_WIDTH = (int)(ViewUtils.getDensity() * 22.0F);
    double d = ViewUtils.getDensity();
    Double.isNaN(d);
    LV9_GUAN_ICON_HEIGHT = (int)(d * 10.5D);
    d = ViewUtils.getDensity();
    Double.isNaN(d);
    LV9_WINDS_MARGIN_TOP = (int)(d * 4.5D);
    LV9_WINDS_MARGIN_LEFT = (int)(ViewUtils.getDensity() * -8.0F);
    d = ViewUtils.getDensity();
    Double.isNaN(d);
    LV9_WINDS_HEIGHT = (int)(d * 9.5D);
    LV9_WINDS_WIDTH = (int)(ViewUtils.getDensity() * 40.0F);
    PERSONALIZED_ICON_ANUAL_LEFT = (int)(ViewUtils.getDensity() * 10.0F);
    RIBBON_ICON_LEVEL_MARGIN_TOP = (int)(ViewUtils.getDensity() * 6.0F);
    ICON_ANNUALVIP_HEIGHT = (int)(ViewUtils.getDensity() * 12.0F);
  }
  
  public QzoneHuangzuanVipIconShow(Context paramContext)
  {
    if (paramContext != null) {
      this.context = paramContext.getApplicationContext();
    }
    this.layerCache = new LruCache(5120);
  }
  
  private void addToCache(DiamondIconDrawable paramDiamondIconDrawable, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, String paramString, int paramInt4, boolean paramBoolean2, int paramInt5)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("_");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append("_");
    localStringBuilder.append(paramInt3);
    localStringBuilder.append("_");
    localStringBuilder.append(paramBoolean1);
    localStringBuilder.append("_");
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append(paramInt4);
    localStringBuilder.append("_");
    if (paramBoolean2) {
      paramInt1 = 1;
    } else {
      paramInt1 = 2;
    }
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("_");
    localStringBuilder.append(paramInt5);
    paramString = localStringBuilder.toString();
    if (paramDiamondIconDrawable != null) {
      this.layerCache.put(paramString, paramDiamondIconDrawable.d());
    }
  }
  
  private static Drawable getBGForLuxuryVip(int paramInt1, int paramInt2, int paramInt3, String paramString, ZipResLoadListener paramZipResLoadListener, int paramInt4)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramInt3 == 4)) {
      return VipResources.a(2, paramInt2, paramZipResLoadListener);
    }
    if (8 == paramInt1)
    {
      if (paramInt4 != 1) {
        return VipResources.a(3, paramInt2, paramZipResLoadListener);
      }
      return VipResources.a(2, paramInt2, paramZipResLoadListener);
    }
    return VipResources.a(2, paramInt2, paramZipResLoadListener);
  }
  
  private static Drawable getBGForOthers(int paramInt1, int paramInt2, int paramInt3, ZipResLoadListener paramZipResLoadListener)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramInt3 != 6)
    {
      localObject1 = localObject2;
      if (paramInt3 != 7)
      {
        if (paramInt3 == 8) {
          return null;
        }
        if (8 == paramInt1) {
          return VipResources.a(5, paramInt2, paramZipResLoadListener);
        }
        if (paramInt1 == 0)
        {
          if (paramInt3 != 4)
          {
            if (paramInt3 == 6) {
              return null;
            }
            localObject1 = localObject2;
            if (paramInt3 == 5) {
              return VipResources.a(6, paramInt2, paramZipResLoadListener);
            }
          }
          else
          {
            return null;
          }
        }
        else {
          localObject1 = VipResources.a(6, paramInt2, paramZipResLoadListener);
        }
      }
    }
    return localObject1;
  }
  
  private static Drawable getBGForVip(int paramInt1, int paramInt2, int paramInt3, String paramString, ZipResLoadListener paramZipResLoadListener, int paramInt4)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramInt3 == 4)) {
      return VipResources.a(1, paramInt2, paramZipResLoadListener);
    }
    if (8 == paramInt1)
    {
      if (paramInt4 != 1) {
        return VipResources.a(4, paramInt2, paramZipResLoadListener);
      }
      return VipResources.a(1, paramInt2, paramZipResLoadListener);
    }
    return VipResources.a(1, paramInt2, paramZipResLoadListener);
  }
  
  private static Drawable getBackground(int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString, ZipResLoadListener paramZipResLoadListener, int paramInt5)
  {
    if (paramInt1 != 1)
    {
      if (paramInt1 != 2) {
        return getBGForOthers(paramInt2, paramInt3, paramInt4, paramZipResLoadListener);
      }
      return getBGForLuxuryVip(paramInt2, paramInt3, paramInt4, paramString, paramZipResLoadListener, paramInt5);
    }
    return getBGForVip(paramInt2, paramInt3, paramInt4, paramString, paramZipResLoadListener, paramInt5);
  }
  
  private Drawable getDefaultDrawable(int paramInt, ZipResLoadListener paramZipResLoadListener)
  {
    DiamondIconDrawable localDiamondIconDrawable = new DiamondIconDrawable();
    paramZipResLoadListener = VipResources.a(1, 1, paramZipResLoadListener);
    paramZipResLoadListener.setBounds(0, 0, getRealSize(ICON_DEFAULT_SIZE, paramInt), getRealSize(ICON_DEFAULT_SIZE, paramInt));
    localDiamondIconDrawable.a(paramZipResLoadListener);
    return localDiamondIconDrawable;
  }
  
  private boolean getDefaultDrawableFromUrl(int paramInt1, boolean paramBoolean1, int paramInt2, int paramInt3, String paramString, DiamondIconDrawable paramDiamondIconDrawable, ZipResLoadListener paramZipResLoadListener, boolean paramBoolean2, boolean paramBoolean3, Drawable paramDrawable1, Drawable paramDrawable2, Drawable paramDrawable3, Drawable paramDrawable4)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (handlePersonalized(paramInt1, paramInt2, paramInt3, paramString, paramDiamondIconDrawable, paramZipResLoadListener, paramBoolean2, paramBoolean3, paramDrawable1, paramDrawable2, paramDrawable3, paramDrawable4)) {
        return true;
      }
    }
    else if (paramBoolean1)
    {
      if (handleAnunalVip(paramInt3, paramDiamondIconDrawable, paramZipResLoadListener, paramBoolean2, paramBoolean3, paramDrawable1, paramDrawable2, paramDrawable3, paramDrawable4)) {
        return true;
      }
    }
    else
    {
      if ((paramDrawable3 == null) || (paramDrawable4 == null) || ((paramBoolean3) && (paramDrawable1 == null))) {
        break label104;
      }
      if ((paramBoolean2) && (paramDrawable2 == null)) {
        return true;
      }
    }
    return false;
    label104:
    return true;
  }
  
  private Drawable getFromCache(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, String paramString, int paramInt4, boolean paramBoolean2, int paramInt5)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("_");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append("_");
    localStringBuilder.append(paramInt3);
    localStringBuilder.append("_");
    localStringBuilder.append(paramBoolean1);
    localStringBuilder.append("_");
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append(paramInt4);
    localStringBuilder.append("_");
    if (paramBoolean2) {
      paramInt1 = 1;
    } else {
      paramInt1 = 2;
    }
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("_");
    localStringBuilder.append(paramInt5);
    paramString = localStringBuilder.toString();
    paramString = (Drawable.ConstantState)this.layerCache.get(paramString);
    if (paramString != null) {
      return paramString.newDrawable();
    }
    return null;
  }
  
  public static QzoneHuangzuanVipIconShow getInstance()
  {
    return (QzoneHuangzuanVipIconShow)sSingleton.get(null);
  }
  
  private Drawable getLevelDrawable(int paramInt1, int paramInt2, boolean paramBoolean1, int paramInt3, boolean paramBoolean2, ZipResLoadListener paramZipResLoadListener)
  {
    if ((paramInt3 > 0) && (paramInt3 <= 9))
    {
      if (paramBoolean2)
      {
        if ((paramBoolean1) && (paramInt1 == 4)) {
          return VipResources.a(this.mAnunalGrayVipIdListInAvatar[(paramInt3 - 1)], paramInt2, paramZipResLoadListener);
        }
        return VipResources.a(this.mNormalGrayVipIdListInAvatar[(paramInt3 - 1)], paramInt2, paramZipResLoadListener);
      }
      if ((paramBoolean1) && (paramInt1 == 7)) {
        return VipResources.a(this.mAnunalVipIdListInRibbon[(paramInt3 - 1)], paramInt2, paramZipResLoadListener);
      }
      if ((!paramBoolean1) && (paramInt1 == 7)) {
        return VipResources.a(this.mNormalVipIdListInRibbon[(paramInt3 - 1)], paramInt2, paramZipResLoadListener);
      }
      if ((paramBoolean1) && (paramInt1 == 4)) {
        return VipResources.a(this.mAnunalVipIdListInAvatar[(paramInt3 - 1)], paramInt2, paramZipResLoadListener);
      }
      return VipResources.a(this.mNormalVipIdListInAvatar[(paramInt3 - 1)], paramInt2, paramZipResLoadListener);
    }
    return null;
  }
  
  private static Drawable getLv9Guan(int paramInt1, int paramInt2, int paramInt3, int paramInt4, ZipResLoadListener paramZipResLoadListener)
  {
    if (paramInt1 != 0)
    {
      if ((paramInt1 != 1) && (paramInt1 != 2)) {
        return null;
      }
      return VipResources.a(121, paramInt4, paramZipResLoadListener);
    }
    return VipResources.a(122, paramInt4, paramZipResLoadListener);
  }
  
  private static int getRealSize(int paramInt1, int paramInt2)
  {
    double d1 = paramInt2;
    Double.isNaN(d1);
    d1 /= 100.0D;
    double d2 = paramInt1;
    Double.isNaN(d2);
    return (int)(d1 * d2);
  }
  
  private static Drawable getWindsDrawalbe(int paramInt1, int paramInt2, int paramInt3, ZipResLoadListener paramZipResLoadListener)
  {
    if (paramInt2 != 9) {
      return null;
    }
    if (paramInt1 != 0)
    {
      if ((paramInt1 != 1) && (paramInt1 != 2)) {
        return null;
      }
      return VipResources.a(119, paramInt3, paramZipResLoadListener);
    }
    return VipResources.a(120, paramInt3, paramZipResLoadListener);
  }
  
  private boolean handleAnunalVip(int paramInt, DiamondIconDrawable paramDiamondIconDrawable, ZipResLoadListener paramZipResLoadListener, boolean paramBoolean1, boolean paramBoolean2, Drawable paramDrawable1, Drawable paramDrawable2, Drawable paramDrawable3, Drawable paramDrawable4)
  {
    paramZipResLoadListener = VipResources.a(7, 5, paramZipResLoadListener);
    if (paramZipResLoadListener != null)
    {
      int i;
      if ((paramBoolean1) && (paramDrawable2 != null)) {
        i = ANUAL_ICON_MARGIN_LEFT_IF_LV9;
      } else {
        i = 0;
      }
      paramZipResLoadListener.setBounds(getRealSize(ICON_DEFAULT_SIZE / 2 + ANUAL_ICON_MARGIN_LEFT + i, paramInt), getRealSize(ICON_ADJUST_ANNUALVIP_MARGIN_TOP, paramInt), getRealSize(ICON_ANNUALVIP_WIDTH + ICON_DEFAULT_SIZE / 2 + ANUAL_ICON_MARGIN_LEFT + i, paramInt), getRealSize(ICON_ADJUST_ANNUALVIP_MARGIN_TOP + ICON_ANNUALVIP_HEIGHT, paramInt));
      paramDiamondIconDrawable.c(paramZipResLoadListener);
    }
    if ((paramDrawable3 != null) && (paramDrawable4 != null) && (paramZipResLoadListener != null) && ((!paramBoolean2) || (paramDrawable1 != null)) && ((!paramBoolean1) || (paramDrawable2 != null))) {
      return false;
    }
    VLog.c("vipIconShow", "nameplateDrawable is null");
    return true;
  }
  
  private Drawable handleCustomDiamond(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, String paramString, int paramInt3, int paramInt4, int paramInt5, DiamondIconDrawable paramDiamondIconDrawable, ZipResLoadListener paramZipResLoadListener)
  {
    Drawable localDrawable = VipResources.a(paramString, paramInt2, 10, paramInt1, paramBoolean1, paramInt3, paramZipResLoadListener);
    if (localDrawable != null)
    {
      localDrawable.setBounds(0, 0, getRealSize(localDrawable.getIntrinsicWidth(), paramInt4), getRealSize(localDrawable.getIntrinsicHeight(), paramInt4));
      paramDiamondIconDrawable.g(localDrawable);
      addToCache(paramDiamondIconDrawable, paramInt5, paramInt4, paramInt1, paramBoolean2, paramString, paramInt3, paramBoolean1, paramInt2);
      return paramDiamondIconDrawable;
    }
    return getDefaultDrawable(paramInt4, paramZipResLoadListener);
  }
  
  private void handleDownloadSuccess(int paramInt1, Drawable paramDrawable, int paramInt2, DiamondIconDrawable paramDiamondIconDrawable, int paramInt3)
  {
    if (paramDrawable == null) {
      return;
    }
    int i = 0;
    switch (paramInt1)
    {
    default: 
      return;
    case 10: 
      paramDrawable.setBounds(0, 0, getRealSize(paramDrawable.getIntrinsicWidth(), paramInt2), getRealSize(paramDrawable.getIntrinsicHeight(), paramInt2));
      paramDiamondIconDrawable.g(paramDrawable);
      return;
    case 9: 
      paramDrawable.setBounds(getRealSize((ICON_DEFAULT_SIZE - paramDrawable.getIntrinsicWidth()) / 2, paramInt2), getRealSize(ICON_DEFAULT_SIZE - paramDrawable.getIntrinsicHeight(), paramInt2), getRealSize((ICON_DEFAULT_SIZE + paramDrawable.getIntrinsicWidth()) / 2, paramInt2), getRealSize(ICON_DEFAULT_SIZE, paramInt2));
      paramDiamondIconDrawable.f(paramDrawable);
      paramDiamondIconDrawable = new StringBuilder();
      paramDiamondIconDrawable.append("left=");
      paramDiamondIconDrawable.append((ICON_DEFAULT_SIZE - paramDrawable.getIntrinsicWidth()) / 2);
      paramDiamondIconDrawable.append(" width = ");
      paramDiamondIconDrawable.append(paramDrawable.getIntrinsicWidth());
      paramDiamondIconDrawable.append(" defualt_width =");
      paramDiamondIconDrawable.append(ICON_DEFAULT_SIZE);
      paramDiamondIconDrawable.append(" height = ");
      paramDiamondIconDrawable.append(paramDrawable.getIntrinsicHeight());
      paramDiamondIconDrawable.append(" bitmapwith =");
      paramDrawable = (BitmapDrawable)paramDrawable;
      paramDiamondIconDrawable.append((int)(paramDrawable.getBitmap().getWidth() / 2 * ViewUtils.getDensity()));
      paramDiamondIconDrawable.append("bitmapheight =");
      paramDiamondIconDrawable.append((int)(paramDrawable.getBitmap().getHeight() / 2 * ViewUtils.getDensity()));
      VLog.b("@vipIcon KINGBG", paramDiamondIconDrawable.toString());
      return;
    case 8: 
      paramDrawable.setBounds(getRealSize(LV9_WINDS_MARGIN_LEFT, paramInt2), getRealSize(LV9_WINDS_MARGIN_TOP, paramInt2), getRealSize(LV9_WINDS_WIDTH + LV9_WINDS_MARGIN_LEFT, paramInt2), getRealSize(LV9_WINDS_HEIGHT + LV9_WINDS_MARGIN_TOP, paramInt2));
      paramDiamondIconDrawable.e(paramDrawable);
      return;
    case 7: 
      paramDrawable.setBounds(getRealSize(LV9_GUAN_ICON_MARGIN_LEFT, paramInt2), getRealSize(LV9_GUAN_ICON_MARGIN_TOP, paramInt2), getRealSize(LV9_GUAN_ICON_WIDTH + LV9_GUAN_ICON_MARGIN_LEFT, paramInt2), getRealSize(LV9_GUAN_ICON_HEIGHT + LV9_GUAN_ICON_MARGIN_TOP, paramInt2));
      paramDiamondIconDrawable.d(paramDrawable);
      return;
    case 6: 
      paramDrawable.setBounds(getRealSize(ICON_DEFAULT_SIZE - PERSONALIZED_ICON_ANUAL_LEFT, paramInt2), getRealSize(ICON_DEFAULT_SIZE - paramDrawable.getIntrinsicHeight(), paramInt2), getRealSize(ICON_DEFAULT_SIZE - PERSONALIZED_ICON_ANUAL_LEFT + paramDrawable.getIntrinsicWidth(), paramInt2), getRealSize(ICON_DEFAULT_SIZE, paramInt2));
      paramDiamondIconDrawable.c(paramDrawable);
      paramDiamondIconDrawable = new StringBuilder();
      paramDiamondIconDrawable.append("left");
      paramDiamondIconDrawable.append(ICON_DEFAULT_SIZE / 2);
      paramDiamondIconDrawable.append(" width = ");
      paramDiamondIconDrawable.append(paramDrawable.getIntrinsicWidth());
      paramDiamondIconDrawable.append(" defualt_width =");
      paramDiamondIconDrawable.append(ICON_DEFAULT_SIZE);
      paramDiamondIconDrawable.append(" height = ");
      paramDiamondIconDrawable.append(paramDrawable.getIntrinsicHeight());
      VLog.b("@vipIcon", paramDiamondIconDrawable.toString());
      return;
    case 5: 
      paramInt1 = i;
      if (paramInt3 == 9) {
        paramInt1 = ANUAL_ICON_MARGIN_LEFT_IF_LV9;
      }
      paramDrawable.setBounds(getRealSize(ICON_DEFAULT_SIZE / 2 + ANUAL_ICON_MARGIN_LEFT + paramInt1, paramInt2), getRealSize(ICON_ADJUST_ANNUALVIP_MARGIN_TOP, paramInt2), getRealSize(ICON_ANNUALVIP_WIDTH + ICON_DEFAULT_SIZE / 2 + ANUAL_ICON_MARGIN_LEFT + paramInt1, paramInt2), getRealSize(ICON_ADJUST_ANNUALVIP_MARGIN_TOP + ICON_ANNUALVIP_HEIGHT, paramInt2));
      paramDiamondIconDrawable.c(paramDrawable);
      return;
    case 4: 
      paramDrawable.setBounds(0, getRealSize(PERSONALIZED_ICON_LV_MARGIN_TOP, paramInt2), getRealSize(PERSONALIZED_ICON_LV_WIDTH, paramInt2), getRealSize(PERSONALIZED_ICON_LV_HEIGHT + PERSONALIZED_ICON_LV_MARGIN_TOP, paramInt2));
      paramDiamondIconDrawable.b(paramDrawable);
      return;
    case 3: 
      paramDrawable.setBounds(0, getRealSize(RIBBON_ICON_LEVEL_MARGIN_TOP, paramInt2), getRealSize(ICON_DEFAULT_SIZE, paramInt2), getRealSize(ICON_DEFAULT_SIZE + RIBBON_ICON_LEVEL_MARGIN_TOP, paramInt2));
      paramDiamondIconDrawable.b(paramDrawable);
      return;
    case 2: 
      paramDrawable.setBounds(0, 0, getRealSize(ICON_DEFAULT_SIZE, paramInt2), getRealSize(ICON_DEFAULT_SIZE, paramInt2));
      paramDiamondIconDrawable.b(paramDrawable);
      return;
    case 1: 
      paramDrawable.setBounds(0, 0, getRealSize(ICON_DEFAULT_SIZE, paramInt2), getRealSize(ICON_DEFAULT_SIZE, paramInt2));
      paramDiamondIconDrawable.a(paramDrawable);
      return;
    }
    paramDrawable.setBounds(getRealSize(ICON_DEFAULT_SIZE - paramDrawable.getIntrinsicWidth(), paramInt2) / 2, getRealSize(-PERSONALIZED_ICON_AVATAR_TOP, paramInt2), getRealSize(ICON_DEFAULT_SIZE + paramDrawable.getIntrinsicWidth(), paramInt2) / 2, getRealSize(paramDrawable.getIntrinsicHeight() - PERSONALIZED_ICON_AVATAR_TOP, paramInt2));
    paramDiamondIconDrawable.d(paramDrawable);
  }
  
  private boolean handleIfNeedDefaultDrawable(int paramInt1, int paramInt2, int paramInt3, String paramString, DiamondIconDrawable paramDiamondIconDrawable, ZipResLoadListener paramZipResLoadListener, boolean paramBoolean1, boolean paramBoolean2, Drawable paramDrawable1, Drawable paramDrawable2, Drawable paramDrawable3, boolean paramBoolean3, Drawable paramDrawable4)
  {
    if ((paramDrawable3 != null) && (paramDrawable4 != null) && ((!paramBoolean2) || (paramDrawable1 != null)) && ((!paramBoolean1) || (paramDrawable2 != null))) {
      return false;
    }
    if (paramBoolean3) {
      return handlePersonalizedAvatar(paramInt1, paramInt2, paramInt3, paramString, paramDiamondIconDrawable, paramZipResLoadListener);
    }
    return true;
  }
  
  private Drawable handleLocationAvatar(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, String paramString1, int paramInt3, int paramInt4, String paramString2, int paramInt5, DiamondIconDrawable paramDiamondIconDrawable, ZipResLoadListener paramZipResLoadListener, boolean paramBoolean3, boolean paramBoolean4, Drawable paramDrawable1, Drawable paramDrawable2, Drawable paramDrawable3, boolean paramBoolean5, Drawable paramDrawable4)
  {
    if (paramInt3 != 4) {
      return paramDiamondIconDrawable;
    }
    if (paramDrawable3 != null)
    {
      paramDrawable3.setBounds(0, 0, getRealSize(ICON_DEFAULT_SIZE, paramInt4), getRealSize(ICON_DEFAULT_SIZE, paramInt4));
      paramDiamondIconDrawable.a(paramDrawable3);
    }
    if (paramDrawable4 != null)
    {
      paramDrawable4.setBounds(0, 0, getRealSize(ICON_DEFAULT_SIZE, paramInt4), getRealSize(ICON_DEFAULT_SIZE, paramInt4));
      paramDiamondIconDrawable.b(paramDrawable4);
    }
    if (handleIfNeedDefaultDrawable(paramInt1, paramInt3, paramInt4, paramString2, paramDiamondIconDrawable, paramZipResLoadListener, paramBoolean3, paramBoolean4, paramDrawable1, paramDrawable2, paramDrawable3, paramBoolean5, paramDrawable4)) {
      return getDefaultDrawable(paramInt4, paramZipResLoadListener);
    }
    addToCache(paramDiamondIconDrawable, paramInt5, paramInt4, paramInt1, paramBoolean2, paramString1, paramInt3, paramBoolean1, paramInt2);
    return paramDiamondIconDrawable;
  }
  
  private Drawable handleLocationRibbon(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, String paramString1, int paramInt3, int paramInt4, String paramString2, int paramInt5, int paramInt6, DiamondIconDrawable paramDiamondIconDrawable, ZipResLoadListener paramZipResLoadListener, boolean paramBoolean3, boolean paramBoolean4, Drawable paramDrawable1, Drawable paramDrawable2)
  {
    Drawable localDrawable2 = getBackground(paramInt2, paramInt1, 1, paramInt3, paramString2, paramZipResLoadListener, paramInt5);
    if (localDrawable2 != null)
    {
      localDrawable2.setBounds(0, 0, getRealSize(ICON_DEFAULT_SIZE, paramInt4), getRealSize(ICON_DEFAULT_SIZE, paramInt4));
      paramDiamondIconDrawable.a(localDrawable2);
    }
    Drawable localDrawable1;
    if (!TextUtils.isEmpty(paramString2))
    {
      localDrawable1 = VipResources.a(paramString2, 4, paramInt1, paramInt3, paramZipResLoadListener);
      paramString2 = localDrawable1;
      if (localDrawable1 != null)
      {
        localDrawable1.setBounds(0, getRealSize(PERSONALIZED_ICON_LV_MARGIN_TOP, paramInt4), getRealSize(PERSONALIZED_ICON_LV_WIDTH, paramInt4), getRealSize(PERSONALIZED_ICON_LV_HEIGHT + PERSONALIZED_ICON_LV_MARGIN_TOP, paramInt4));
        paramDiamondIconDrawable.b(localDrawable1);
        paramString2 = localDrawable1;
      }
    }
    else
    {
      boolean bool;
      if ((paramInt1 != 0) && (paramInt2 != 0)) {
        bool = false;
      } else {
        bool = true;
      }
      localDrawable1 = getLevelDrawable(paramInt3, 3, paramBoolean1, paramInt1, bool, paramZipResLoadListener);
      paramString2 = localDrawable1;
      if (localDrawable1 != null)
      {
        localDrawable1.setBounds(0, getRealSize(RIBBON_ICON_LEVEL_MARGIN_TOP, paramInt4), getRealSize(ICON_DEFAULT_SIZE, paramInt4), getRealSize(ICON_DEFAULT_SIZE + RIBBON_ICON_LEVEL_MARGIN_TOP, paramInt4));
        paramDiamondIconDrawable.b(localDrawable1);
        paramString2 = localDrawable1;
      }
    }
    if ((paramString2 != null) && (localDrawable2 != null) && ((!paramBoolean4) || (paramDrawable1 != null)) && ((!paramBoolean3) || (paramDrawable2 != null)))
    {
      addToCache(paramDiamondIconDrawable, paramInt6, paramInt4, paramInt1, paramBoolean2, paramString1, paramInt3, paramBoolean1, paramInt2);
      return paramDiamondIconDrawable;
    }
    return getDefaultDrawable(paramInt4, paramZipResLoadListener);
  }
  
  private Drawable handleNotLocationAvatar(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, String paramString1, int paramInt3, int paramInt4, String paramString2, int paramInt5, int paramInt6, DiamondIconDrawable paramDiamondIconDrawable, ZipResLoadListener paramZipResLoadListener, boolean paramBoolean3, boolean paramBoolean4, Drawable paramDrawable1, Drawable paramDrawable2, Drawable paramDrawable3, Drawable paramDrawable4)
  {
    VLog.b("vipIcon", "come to annual vip icon show");
    if ((paramInt5 == 1) && (!TextUtils.isEmpty(paramString2)))
    {
      Drawable localDrawable = VipResources.a(paramString2, 9, paramInt1, paramInt3, paramZipResLoadListener, paramInt5);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("get is kingtype  url = ");
      localStringBuilder.append(paramString2);
      VLog.b("@vipIcon", localStringBuilder.toString());
      if (localDrawable != null)
      {
        localDrawable.setBounds(getRealSize((ICON_DEFAULT_SIZE - localDrawable.getIntrinsicWidth()) / 2, paramInt4), getRealSize(ICON_DEFAULT_SIZE - localDrawable.getIntrinsicHeight(), paramInt4), getRealSize((ICON_DEFAULT_SIZE + localDrawable.getIntrinsicWidth()) / 2, paramInt4), getRealSize(ICON_DEFAULT_SIZE, paramInt4));
        paramDiamondIconDrawable.f(localDrawable);
      }
    }
    if (paramDrawable3 != null)
    {
      paramDrawable3.setBounds(0, 0, getRealSize(ICON_DEFAULT_SIZE, paramInt4), getRealSize(ICON_DEFAULT_SIZE, paramInt4));
      paramDiamondIconDrawable.a(paramDrawable3);
    }
    if (paramDrawable4 != null)
    {
      paramDrawable4.setBounds(0, 0, getRealSize(ICON_DEFAULT_SIZE, paramInt4), getRealSize(ICON_DEFAULT_SIZE, paramInt4));
      paramDiamondIconDrawable.b(paramDrawable4);
    }
    if (getDefaultDrawableFromUrl(paramInt1, paramBoolean1, paramInt3, paramInt4, paramString2, paramDiamondIconDrawable, paramZipResLoadListener, paramBoolean3, paramBoolean4, paramDrawable1, paramDrawable2, paramDrawable3, paramDrawable4)) {
      return getDefaultDrawable(paramInt4, paramZipResLoadListener);
    }
    addToCache(paramDiamondIconDrawable, paramInt6, paramInt4, paramInt1, paramBoolean2, paramString1, paramInt3, paramBoolean1, paramInt2);
    return paramDiamondIconDrawable;
  }
  
  private Drawable handleNotRibbon(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, String paramString1, int paramInt3, int paramInt4, String paramString2, int paramInt5, int paramInt6, DiamondIconDrawable paramDiamondIconDrawable, ZipResLoadListener paramZipResLoadListener, boolean paramBoolean3, boolean paramBoolean4, Drawable paramDrawable1, Drawable paramDrawable2)
  {
    boolean bool1;
    if ((!TextUtils.isEmpty(paramString2)) && (paramInt3 == 4)) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    Drawable localDrawable1 = getBackground(paramInt2, paramInt1, 1, paramInt3, paramString2, paramZipResLoadListener, paramInt5);
    boolean bool2;
    if ((paramInt1 != 0) && (paramInt2 != 0)) {
      bool2 = false;
    } else {
      bool2 = true;
    }
    Drawable localDrawable2 = getLevelDrawable(paramInt3, 2, paramBoolean1, paramInt1, bool2, paramZipResLoadListener);
    if ((paramInt3 != 6) && (paramInt3 != 5) && (paramInt3 != 8)) {
      return handleLocationAvatar(paramInt1, paramInt2, paramBoolean1, paramBoolean2, paramString1, paramInt3, paramInt4, paramString2, paramInt6, paramDiamondIconDrawable, paramZipResLoadListener, paramBoolean3, paramBoolean4, paramDrawable1, paramDrawable2, localDrawable1, bool1, localDrawable2);
    }
    return handleNotLocationAvatar(paramInt1, paramInt2, paramBoolean1, paramBoolean2, paramString1, paramInt3, paramInt4, paramString2, paramInt5, paramInt6, paramDiamondIconDrawable, paramZipResLoadListener, paramBoolean3, paramBoolean4, paramDrawable1, paramDrawable2, localDrawable1, localDrawable2);
  }
  
  private boolean handlePersonalized(int paramInt1, int paramInt2, int paramInt3, String paramString, DiamondIconDrawable paramDiamondIconDrawable, ZipResLoadListener paramZipResLoadListener, boolean paramBoolean1, boolean paramBoolean2, Drawable paramDrawable1, Drawable paramDrawable2, Drawable paramDrawable3, Drawable paramDrawable4)
  {
    paramZipResLoadListener = VipResources.a(paramString, 6, paramInt1, paramInt2, paramZipResLoadListener);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("feeds personalized  url = ");
    localStringBuilder.append(paramString);
    VLog.b("@vipIcon", localStringBuilder.toString());
    if (paramZipResLoadListener != null)
    {
      paramZipResLoadListener.setBounds(getRealSize(ICON_DEFAULT_SIZE - PERSONALIZED_ICON_ANUAL_LEFT, paramInt3), getRealSize(ICON_DEFAULT_SIZE - paramZipResLoadListener.getIntrinsicHeight(), paramInt3), getRealSize(ICON_DEFAULT_SIZE - PERSONALIZED_ICON_ANUAL_LEFT + paramZipResLoadListener.getIntrinsicWidth(), paramInt3), getRealSize(ICON_DEFAULT_SIZE, paramInt3));
      paramDiamondIconDrawable.c(paramZipResLoadListener);
    }
    if ((paramDrawable3 != null) && (paramDrawable4 != null) && (paramZipResLoadListener != null) && ((!paramBoolean2) || (paramDrawable1 != null)) && ((!paramBoolean1) || (paramDrawable2 != null))) {
      return false;
    }
    VLog.c("vipIconShow", "personalized Drawable is null");
    return true;
  }
  
  private boolean handlePersonalizedAvatar(int paramInt1, int paramInt2, int paramInt3, String paramString, DiamondIconDrawable paramDiamondIconDrawable, ZipResLoadListener paramZipResLoadListener)
  {
    boolean bool = false;
    paramString = VipResources.a(paramString, 0, paramInt1, paramInt2, paramZipResLoadListener);
    if (paramString != null)
    {
      paramString.setBounds(getRealSize(ICON_DEFAULT_SIZE - paramString.getIntrinsicWidth(), paramInt3) / 2, getRealSize(-PERSONALIZED_ICON_AVATAR_TOP, paramInt3), getRealSize(ICON_DEFAULT_SIZE + paramString.getIntrinsicWidth(), paramInt3) / 2, getRealSize(paramString.getIntrinsicHeight() - PERSONALIZED_ICON_AVATAR_TOP, paramInt3));
      paramDiamondIconDrawable.d(paramString);
    }
    if (paramString == null) {
      bool = true;
    }
    return bool;
  }
  
  private boolean isVipIcon(int paramInt1, int paramInt2, int paramInt3)
  {
    if (1 != paramInt1)
    {
      if (2 == paramInt1) {
        return true;
      }
      if ((6 != paramInt2) && (7 != paramInt2))
      {
        if (8 == paramInt2) {
          return false;
        }
        return (paramInt3 != 0) || (4 != paramInt2);
      }
      return false;
    }
    return true;
  }
  
  private static boolean showCustomDiamond(int paramInt, boolean paramBoolean, String paramString)
  {
    return ((paramInt == 1) || (paramInt == 2)) && (paramBoolean) && (!TextUtils.isEmpty(paramString));
  }
  
  public float getDensity()
  {
    return ViewUtils.getDensity();
  }
  
  public Drawable getLayers(int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3, int paramInt4, String paramString, VipResourcesListener paramVipResourcesListener, int paramInt5)
  {
    try
    {
      paramString = getLayers(paramInt1, paramInt2, paramBoolean, false, null, paramInt3, paramInt4, paramString, paramVipResourcesListener, paramInt5);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public Drawable getLayers(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, String paramString1, int paramInt3, int paramInt4, String paramString2, VipResourcesListener paramVipResourcesListener, int paramInt5)
  {
    boolean bool1;
    int j;
    Object localObject2;
    QzoneHuangzuanVipIconShow.2 local2;
    try
    {
      bool1 = isVipIcon(paramInt2, paramInt3, paramInt1);
      localObject1 = null;
      if (!bool1) {
        return null;
      }
      j = VipUtils.a(paramString2);
      localObject2 = getFromCache(j, paramInt4, paramInt1, paramBoolean2, paramString1, paramInt3, paramBoolean1, paramInt2);
      if (localObject2 != null) {
        return localObject2;
      }
      localObject2 = new DiamondIconDrawable();
      local2 = new QzoneHuangzuanVipIconShow.2(this, paramVipResourcesListener, paramInt4, (DiamondIconDrawable)localObject2, paramInt1, j, paramBoolean2, paramString1, paramInt3, paramBoolean1, paramInt2);
      if (showCustomDiamond(paramInt2, paramBoolean2, paramString1))
      {
        paramString1 = handleCustomDiamond(paramInt1, paramInt2, paramBoolean1, paramBoolean2, paramString1, paramInt3, paramInt4, j, (DiamondIconDrawable)localObject2, local2);
        return paramString1;
      }
      bool1 = false;
      if (paramInt1 != 9) {
        break label443;
      }
      if (!TextUtils.isEmpty(paramString2)) {
        if (paramInt3 == 4) {
          break label417;
        }
      }
      if (paramInt5 == 1) {
        break label426;
      }
      paramVipResourcesListener = getLv9Guan(paramInt2, paramInt1, paramInt3, 7, local2);
      if (paramVipResourcesListener == null) {
        break label420;
      }
      int k = LV9_GUAN_ICON_MARGIN_LEFT;
      i = paramInt4;
      paramVipResourcesListener.setBounds(getRealSize(k, i), getRealSize(LV9_GUAN_ICON_MARGIN_TOP, i), getRealSize(LV9_GUAN_ICON_WIDTH + LV9_GUAN_ICON_MARGIN_LEFT, i), getRealSize(LV9_GUAN_ICON_HEIGHT + LV9_GUAN_ICON_MARGIN_TOP, i));
      ((DiamondIconDrawable)localObject2).d(paramVipResourcesListener);
    }
    finally {}
    int i = paramInt4;
    Object localObject1 = getWindsDrawalbe(paramInt2, paramInt1, 8, local2);
    if (localObject1 != null)
    {
      ((Drawable)localObject1).setBounds(getRealSize(LV9_WINDS_MARGIN_LEFT, i), getRealSize(LV9_WINDS_MARGIN_TOP, i), getRealSize(LV9_WINDS_WIDTH + LV9_WINDS_MARGIN_LEFT, i), getRealSize(LV9_WINDS_HEIGHT + LV9_WINDS_MARGIN_TOP, i));
      ((DiamondIconDrawable)localObject2).e((Drawable)localObject1);
    }
    for (;;)
    {
      if (paramInt3 == 7)
      {
        paramString1 = handleLocationRibbon(paramInt1, paramInt2, paramBoolean1, paramBoolean2, paramString1, paramInt3, paramInt4, paramString2, paramInt5, j, (DiamondIconDrawable)localObject2, local2, bool1, bool2, paramVipResourcesListener, (Drawable)localObject1);
        return paramString1;
      }
      paramString1 = handleNotRibbon(paramInt1, paramInt2, paramBoolean1, paramBoolean2, paramString1, paramInt3, paramInt4, paramString2, paramInt5, j, (DiamondIconDrawable)localObject2, local2, bool1, bool2, paramVipResourcesListener, (Drawable)localObject1);
      return paramString1;
      label417:
      break label426;
      label420:
      bool1 = true;
      break;
      label426:
      paramVipResourcesListener = (VipResourcesListener)localObject1;
      break;
      boolean bool2 = bool1;
      bool1 = true;
      continue;
      label443:
      paramVipResourcesListener = null;
      localObject1 = paramVipResourcesListener;
      bool1 = false;
      bool2 = false;
    }
  }
  
  public void releaseResources()
  {
    this.context = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.vip.vipcomponent.ui.QzoneHuangzuanVipIconShow
 * JD-Core Version:    0.7.0.1
 */