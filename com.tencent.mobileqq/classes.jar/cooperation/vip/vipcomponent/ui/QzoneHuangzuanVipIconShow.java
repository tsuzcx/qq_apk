package cooperation.vip.vipcomponent.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.text.TextUtils;
import android.util.LruCache;
import bajq;
import bgdp;
import bgra;
import bgrb;
import bgrd;
import bgre;
import bgrf;
import bgrh;
import bgri;
import bgrm;
import cooperation.vip.vipcomponent.util.VipResourcesListener;

public class QzoneHuangzuanVipIconShow
{
  public static int ANUAL_ICON_MARGIN_LEFT = 0;
  public static final int HIGHEST_LEVEL = 8;
  public static int ICON_ADJUST_ANNUALVIP_MARGIN_TOP = (int)(bajq.a() * 9.0F);
  public static int ICON_ANNUALVIP_HEIGHT = 0;
  public static int ICON_ANNUALVIP_WIDTH = (int)(bajq.a() * 21.0F);
  public static int ICON_DEFAULT_SIZE = bgrf.b;
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
  public static int PERSONALIZED_ICON_LV_WIDTH = (int)(26.0F * bajq.a());
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
  private static final bgdp<QzoneHuangzuanVipIconShow, Context> sSingleton = new bgrd();
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
    PERSONALIZED_ICON_LV_HEIGHT = (int)(bajq.a() * 9.0F);
    PERSONALIZED_ICON_HEAD_HEIGHT = (int)(23.0F * bajq.a());
    PERSONALIZED_ICON_HEAD_WIDTH = (int)(11.0F * bajq.a());
    PERSONALIZED_ICON_YEAR_WIDTH = (int)(bajq.a() * 40.0F);
    PERSONALIZED_ICON_YEAR_HEIGHT = (int)(24.0F * bajq.a());
    PERSONALIZED_ICON_LV_MARGIN_TOP = (int)(bajq.a() * 21.0F);
    RIBBON_ICON_BG_MARGIN_LEFT = (int)(bajq.a() * 1.0F);
    ANUAL_ICON_MARGIN_LEFT = (int)(2.0F * bajq.a());
    PERSONALIZED_ICON_AVATAR_TOP = (int)(bajq.a() * 1.0F);
    LV9_GUAN_ICON_MARGIN_LEFT = (int)(bajq.a() * 1.0F);
    LV9_GUAN_ICON_MARGIN_TOP = (int)(-3.0F * bajq.a());
    LV9_GUAN_ICON_WIDTH = (int)(22.0F * bajq.a());
    LV9_GUAN_ICON_HEIGHT = (int)(10.5D * bajq.a());
    LV9_WINDS_MARGIN_TOP = (int)(4.5D * bajq.a());
    LV9_WINDS_MARGIN_LEFT = (int)(-8.0F * bajq.a());
    LV9_WINDS_HEIGHT = (int)(9.5D * bajq.a());
    LV9_WINDS_WIDTH = (int)(bajq.a() * 40.0F);
    PERSONALIZED_ICON_ANUAL_LEFT = (int)(10.0F * bajq.a());
    RIBBON_ICON_LEVEL_MARGIN_TOP = (int)(6.0F * bajq.a());
    ICON_ANNUALVIP_HEIGHT = (int)(12.0F * bajq.a());
  }
  
  public QzoneHuangzuanVipIconShow(Context paramContext)
  {
    if (paramContext != null) {
      this.context = paramContext.getApplicationContext();
    }
    this.layerCache = new LruCache(5120);
  }
  
  private void addToCache(bgrb parambgrb, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, String paramString, int paramInt4, boolean paramBoolean2, int paramInt5)
  {
    paramString = new StringBuilder().append(paramInt1).append("_").append(paramInt2).append("_").append(paramInt3).append("_").append(paramBoolean1).append("_").append(paramString).append("_").append(paramInt4).append("_");
    if (paramBoolean2) {}
    for (paramInt1 = 1;; paramInt1 = 2)
    {
      paramString = paramInt1 + "_" + paramInt5;
      if (parambgrb != null) {
        this.layerCache.put(paramString, parambgrb.a());
      }
      return;
    }
  }
  
  private static Drawable getBackground(int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString, bgrm parambgrm, int paramInt5)
  {
    switch (paramInt1)
    {
    default: 
      if ((paramInt4 != 6) && (paramInt4 != 7) && (paramInt4 != 8)) {
        break;
      }
    }
    do
    {
      return null;
      if ((!TextUtils.isEmpty(paramString)) && (paramInt4 == 4)) {
        return bgri.a(2, paramInt3, parambgrm);
      }
      if (8 == paramInt2)
      {
        if (paramInt5 != 1) {
          return bgri.a(3, paramInt3, parambgrm);
        }
        return bgri.a(2, paramInt3, parambgrm);
      }
      return bgri.a(2, paramInt3, parambgrm);
      if ((!TextUtils.isEmpty(paramString)) && (paramInt4 == 4)) {
        return bgri.a(1, paramInt3, parambgrm);
      }
      if (8 == paramInt2)
      {
        if (paramInt5 != 1) {
          return bgri.a(4, paramInt3, parambgrm);
        }
        return bgri.a(1, paramInt3, parambgrm);
      }
      return bgri.a(1, paramInt3, parambgrm);
      if (8 == paramInt2) {
        return bgri.a(5, paramInt3, parambgrm);
      }
      if (paramInt2 != 0) {
        break;
      }
      if ((paramInt4 == 4) || (paramInt4 == 6)) {
        return null;
      }
    } while (paramInt4 != 5);
    return bgri.a(6, paramInt3, parambgrm);
    return bgri.a(6, paramInt3, parambgrm);
  }
  
  private Drawable getDefaultDrawable(int paramInt, bgrm parambgrm)
  {
    bgrb localbgrb = new bgrb();
    parambgrm = bgri.a(1, 1, parambgrm);
    parambgrm.setBounds(0, 0, getRealSize(ICON_DEFAULT_SIZE, paramInt), getRealSize(ICON_DEFAULT_SIZE, paramInt));
    localbgrb.a(parambgrm);
    return localbgrb;
  }
  
  private Drawable getFromCache(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, String paramString, int paramInt4, boolean paramBoolean2, int paramInt5)
  {
    paramString = new StringBuilder().append(paramInt1).append("_").append(paramInt2).append("_").append(paramInt3).append("_").append(paramBoolean1).append("_").append(paramString).append("_").append(paramInt4).append("_");
    if (paramBoolean2) {}
    for (paramInt1 = 1;; paramInt1 = 2)
    {
      paramString = paramInt1 + "_" + paramInt5;
      paramString = (Drawable.ConstantState)this.layerCache.get(paramString);
      if (paramString == null) {
        break;
      }
      return paramString.newDrawable();
    }
    return null;
  }
  
  public static QzoneHuangzuanVipIconShow getInstance()
  {
    return (QzoneHuangzuanVipIconShow)sSingleton.b(null);
  }
  
  private Drawable getLevelDrawable(int paramInt1, int paramInt2, boolean paramBoolean1, int paramInt3, boolean paramBoolean2, bgrm parambgrm)
  {
    if (paramBoolean2)
    {
      if ((paramBoolean1) && (paramInt1 == 4))
      {
        if ((paramInt3 > 0) && (paramInt3 <= 9)) {
          return bgri.a(this.mAnunalGrayVipIdListInAvatar[(paramInt3 - 1)], paramInt2, parambgrm);
        }
      }
      else if ((paramInt3 > 0) && (paramInt3 <= 9)) {
        return bgri.a(this.mNormalGrayVipIdListInAvatar[(paramInt3 - 1)], paramInt2, parambgrm);
      }
    }
    else
    {
      if ((paramBoolean1) && (paramInt1 == 7))
      {
        if ((paramInt3 > 0) && (paramInt3 <= 9)) {
          return bgri.a(this.mAnunalVipIdListInRibbon[(paramInt3 - 1)], paramInt2, parambgrm);
        }
      }
      else if ((!paramBoolean1) && (paramInt1 == 7) && (paramInt3 > 0) && (paramInt3 <= 9)) {
        return bgri.a(this.mNormalVipIdListInRibbon[(paramInt3 - 1)], paramInt2, parambgrm);
      }
      if ((paramBoolean1) && (paramInt1 == 4))
      {
        if ((paramInt3 > 0) && (paramInt3 <= 9)) {
          return bgri.a(this.mAnunalVipIdListInAvatar[(paramInt3 - 1)], paramInt2, parambgrm);
        }
      }
      else if ((paramInt3 > 0) && (paramInt3 <= 9)) {
        return bgri.a(this.mNormalVipIdListInAvatar[(paramInt3 - 1)], paramInt2, parambgrm);
      }
    }
    return null;
  }
  
  private static Drawable getLv9Guan(int paramInt1, int paramInt2, int paramInt3, int paramInt4, bgrm parambgrm)
  {
    switch (paramInt1)
    {
    default: 
      return null;
    case 1: 
    case 2: 
      return bgri.a(121, paramInt4, parambgrm);
    }
    return bgri.a(122, paramInt4, parambgrm);
  }
  
  private static int getRealSize(int paramInt1, int paramInt2)
  {
    return (int)(paramInt2 / 100.0D * paramInt1);
  }
  
  private static Drawable getWindsDrawalbe(int paramInt1, int paramInt2, int paramInt3, bgrm parambgrm)
  {
    if (paramInt2 != 9) {
      return null;
    }
    switch (paramInt1)
    {
    default: 
      return null;
    case 0: 
      return bgri.a(120, paramInt3, parambgrm);
    }
    return bgri.a(119, paramInt3, parambgrm);
  }
  
  private boolean isVipIcon(int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool2 = false;
    boolean bool1;
    if ((1 == paramInt1) || (2 == paramInt1)) {
      bool1 = true;
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return bool1;
            bool1 = bool2;
          } while (6 == paramInt2);
          bool1 = bool2;
        } while (7 == paramInt2);
        bool1 = bool2;
      } while (8 == paramInt2);
      if (paramInt3 != 0) {
        break;
      }
      bool1 = bool2;
    } while (4 == paramInt2);
    return true;
  }
  
  private static boolean showCustomDiamond(int paramInt, boolean paramBoolean, String paramString)
  {
    return ((paramInt == 1) || (paramInt == 2)) && (paramBoolean) && (!TextUtils.isEmpty(paramString));
  }
  
  public float getDensity()
  {
    return bajq.a();
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
    boolean bool;
    Object localObject1;
    int n;
    Object localObject2;
    bgrb localbgrb;
    bgre localbgre;
    label208:
    int j;
    int i;
    label416:
    Drawable localDrawable1;
    label552:
    label565:
    label637:
    Drawable localDrawable2;
    for (;;)
    {
      try
      {
        bool = isVipIcon(paramInt2, paramInt3, paramInt1);
        if (!bool)
        {
          localObject1 = null;
          return localObject1;
        }
        n = bgra.a(paramString2);
        localObject2 = getFromCache(n, paramInt4, paramInt1, paramBoolean2, paramString1, paramInt3, paramBoolean1, paramInt2);
        localObject1 = localObject2;
        if (localObject2 != null) {
          continue;
        }
        localbgrb = new bgrb();
        localbgre = new bgre(this, paramVipResourcesListener, paramInt4, localbgrb, n, paramInt1, paramBoolean2, paramString1, paramInt3, paramBoolean1, paramInt2);
        if (!showCustomDiamond(paramInt2, paramBoolean2, paramString1)) {
          break label208;
        }
        paramString2 = bgri.a(paramString1, paramInt2, 10, paramInt1, paramBoolean1, paramInt3, localbgre);
        if (paramString2 != null)
        {
          paramString2.setBounds(0, 0, getRealSize(paramString2.getIntrinsicWidth(), paramInt4), getRealSize(paramString2.getIntrinsicHeight(), paramInt4));
          localbgrb.g(paramString2);
          addToCache(localbgrb, n, paramInt4, paramInt1, paramBoolean2, paramString1, paramInt3, paramBoolean1, paramInt2);
          localObject1 = localbgrb;
          continue;
        }
        localObject1 = getDefaultDrawable(paramInt4, localbgre);
      }
      finally {}
      continue;
      j = 0;
      localObject1 = null;
      if (paramInt1 != 9) {
        break;
      }
      if (!TextUtils.isEmpty(paramString2))
      {
        paramVipResourcesListener = (VipResourcesListener)localObject1;
        i = j;
        if (paramInt3 == 4) {}
      }
      else
      {
        paramVipResourcesListener = (VipResourcesListener)localObject1;
        i = j;
        if (paramInt5 != 1)
        {
          j = 1;
          localObject1 = getLv9Guan(paramInt2, paramInt1, paramInt3, 7, localbgre);
          paramVipResourcesListener = (VipResourcesListener)localObject1;
          i = j;
          if (localObject1 != null)
          {
            ((Drawable)localObject1).setBounds(getRealSize(LV9_GUAN_ICON_MARGIN_LEFT, paramInt4), getRealSize(LV9_GUAN_ICON_MARGIN_TOP, paramInt4), getRealSize(LV9_GUAN_ICON_WIDTH + LV9_GUAN_ICON_MARGIN_LEFT, paramInt4), getRealSize(LV9_GUAN_ICON_HEIGHT + LV9_GUAN_ICON_MARGIN_TOP, paramInt4));
            localbgrb.d((Drawable)localObject1);
            i = j;
            paramVipResourcesListener = (VipResourcesListener)localObject1;
          }
        }
      }
      localObject1 = getWindsDrawalbe(paramInt2, paramInt1, 8, localbgre);
      if (localObject1 == null) {
        break label1490;
      }
      ((Drawable)localObject1).setBounds(getRealSize(LV9_WINDS_MARGIN_LEFT, paramInt4), getRealSize(LV9_WINDS_MARGIN_TOP, paramInt4), getRealSize(LV9_WINDS_WIDTH + LV9_WINDS_MARGIN_LEFT, paramInt4), getRealSize(LV9_WINDS_HEIGHT + LV9_WINDS_MARGIN_TOP, paramInt4));
      localbgrb.e((Drawable)localObject1);
      break label1490;
      if (paramInt3 == 7)
      {
        localDrawable1 = getBackground(paramInt2, paramInt1, 1, paramInt3, paramString2, localbgre, paramInt5);
        if (localDrawable1 != null)
        {
          localDrawable1.setBounds(0, 0, getRealSize(ICON_DEFAULT_SIZE, paramInt4), getRealSize(ICON_DEFAULT_SIZE, paramInt4));
          localbgrb.a(localDrawable1);
        }
        if (TextUtils.isEmpty(paramString2)) {
          break label1537;
        }
        localObject1 = bgri.a(paramString2, 4, paramInt1, paramInt3, localbgre);
        paramString2 = (String)localObject1;
        if (localObject1 == null) {
          break label1504;
        }
        ((Drawable)localObject1).setBounds(0, getRealSize(PERSONALIZED_ICON_LV_MARGIN_TOP, paramInt4), getRealSize(PERSONALIZED_ICON_LV_WIDTH, paramInt4), getRealSize(PERSONALIZED_ICON_LV_HEIGHT + PERSONALIZED_ICON_LV_MARGIN_TOP, paramInt4));
        localbgrb.b((Drawable)localObject1);
        paramString2 = (String)localObject1;
        break label1504;
        localObject1 = getDefaultDrawable(paramInt4, localbgre);
        continue;
        localObject1 = getLevelDrawable(paramInt3, 3, paramBoolean1, paramInt1, bool, localbgre);
        paramString2 = (String)localObject1;
        if (localObject1 == null) {
          break label1504;
        }
        ((Drawable)localObject1).setBounds(0, getRealSize(RIBBON_ICON_LEVEL_MARGIN_TOP, paramInt4), getRealSize(ICON_DEFAULT_SIZE, paramInt4), getRealSize(ICON_DEFAULT_SIZE + RIBBON_ICON_LEVEL_MARGIN_TOP, paramInt4));
        localbgrb.b((Drawable)localObject1);
        paramString2 = (String)localObject1;
        break label1504;
        addToCache(localbgrb, n, paramInt4, paramInt1, paramBoolean2, paramString1, paramInt3, paramBoolean1, paramInt2);
        localObject1 = localbgrb;
      }
      else
      {
        int m = 0;
        int k = m;
        if (!TextUtils.isEmpty(paramString2))
        {
          k = m;
          if (paramInt3 == 4) {
            k = 1;
          }
        }
        localDrawable1 = getBackground(paramInt2, paramInt1, 1, paramInt3, paramString2, localbgre, paramInt5);
        if (paramInt1 == 0) {
          break label1557;
        }
        if (paramInt2 != 0) {
          break label1601;
        }
        break label1557;
        label718:
        localDrawable2 = getLevelDrawable(paramInt3, 2, paramBoolean1, paramInt1, bool, localbgre);
        if ((paramInt3 == 6) || (paramInt3 == 5) || (paramInt3 == 8))
        {
          bgrh.b("vipIcon", "come to annual vip icon show");
          if ((paramInt5 == 1) && (!TextUtils.isEmpty(paramString2)))
          {
            localObject1 = bgri.a(paramString2, 9, paramInt1, paramInt3, localbgre, paramInt5);
            bgrh.b("@vipIcon", "get is kingtype  url = " + paramString2);
            if (localObject1 != null)
            {
              ((Drawable)localObject1).setBounds(getRealSize((ICON_DEFAULT_SIZE - ((Drawable)localObject1).getIntrinsicWidth()) / 2, paramInt4), getRealSize(ICON_DEFAULT_SIZE - ((Drawable)localObject1).getIntrinsicHeight(), paramInt4), getRealSize((ICON_DEFAULT_SIZE + ((Drawable)localObject1).getIntrinsicWidth()) / 2, paramInt4), getRealSize(ICON_DEFAULT_SIZE, paramInt4));
              localbgrb.f((Drawable)localObject1);
            }
          }
          if (localDrawable1 != null)
          {
            localDrawable1.setBounds(0, 0, getRealSize(ICON_DEFAULT_SIZE, paramInt4), getRealSize(ICON_DEFAULT_SIZE, paramInt4));
            localbgrb.a(localDrawable1);
          }
          if (localDrawable2 != null)
          {
            localDrawable2.setBounds(0, 0, getRealSize(ICON_DEFAULT_SIZE, paramInt4), getRealSize(ICON_DEFAULT_SIZE, paramInt4));
            localbgrb.b(localDrawable2);
          }
          if (!TextUtils.isEmpty(paramString2))
          {
            localObject1 = bgri.a(paramString2, 6, paramInt1, paramInt3, localbgre);
            bgrh.b("@vipIcon", "feeds personalized  url = " + paramString2);
            if (localObject1 == null) {
              break label1563;
            }
            ((Drawable)localObject1).setBounds(getRealSize(ICON_DEFAULT_SIZE - PERSONALIZED_ICON_ANUAL_LEFT, paramInt4), getRealSize(ICON_DEFAULT_SIZE - ((Drawable)localObject1).getIntrinsicHeight(), paramInt4), getRealSize(ICON_DEFAULT_SIZE - PERSONALIZED_ICON_ANUAL_LEFT + ((Drawable)localObject1).getIntrinsicWidth(), paramInt4), getRealSize(ICON_DEFAULT_SIZE, paramInt4));
            localbgrb.c((Drawable)localObject1);
            break label1563;
            label1081:
            bgrh.c("vipIconShow", "personalized Drawable is null");
            localObject1 = getDefaultDrawable(paramInt4, localbgre);
          }
          else
          {
            if (!paramBoolean1) {
              break label1645;
            }
            paramString2 = bgri.a(7, 5, localbgre);
            if (paramString2 == null) {
              break label1607;
            }
            paramString2.setBounds(getRealSize(ICON_DEFAULT_SIZE / 2 + ANUAL_ICON_MARGIN_LEFT, paramInt4), getRealSize(ICON_ADJUST_ANNUALVIP_MARGIN_TOP, paramInt4), getRealSize(ICON_ANNUALVIP_WIDTH + ICON_DEFAULT_SIZE / 2 + ANUAL_ICON_MARGIN_LEFT, paramInt4), getRealSize(ICON_ADJUST_ANNUALVIP_MARGIN_TOP + ICON_ANNUALVIP_HEIGHT, paramInt4));
            localbgrb.c(paramString2);
            break label1607;
            label1189:
            bgrh.c("vipIconShow", "nameplateDrawable is null");
            localObject1 = getDefaultDrawable(paramInt4, localbgre);
            continue;
            label1211:
            localObject1 = getDefaultDrawable(paramInt4, localbgre);
            continue;
            label1224:
            addToCache(localbgrb, n, paramInt4, paramInt1, paramBoolean2, paramString1, paramInt3, paramBoolean1, paramInt2);
            localObject1 = localbgrb;
          }
        }
        else
        {
          localObject1 = localbgrb;
          if (paramInt3 == 4)
          {
            if (localDrawable1 != null)
            {
              localDrawable1.setBounds(0, 0, getRealSize(ICON_DEFAULT_SIZE, paramInt4), getRealSize(ICON_DEFAULT_SIZE, paramInt4));
              localbgrb.a(localDrawable1);
            }
            if (localDrawable2 != null)
            {
              localDrawable2.setBounds(0, 0, getRealSize(ICON_DEFAULT_SIZE, paramInt4), getRealSize(ICON_DEFAULT_SIZE, paramInt4));
              localbgrb.b(localDrawable2);
            }
            if (k == 0) {
              break label1716;
            }
            paramString2 = bgri.a(paramString2, 0, paramInt1, paramInt3, localbgre);
            if (paramString2 == null) {
              break label1678;
            }
            paramString2.setBounds(getRealSize(ICON_DEFAULT_SIZE - paramString2.getIntrinsicWidth(), paramInt4) / 2, getRealSize(-PERSONALIZED_ICON_AVATAR_TOP, paramInt4), getRealSize(ICON_DEFAULT_SIZE + paramString2.getIntrinsicWidth(), paramInt4) / 2, getRealSize(paramString2.getIntrinsicHeight() - PERSONALIZED_ICON_AVATAR_TOP, paramInt4));
            localbgrb.d(paramString2);
            break label1678;
            label1423:
            localObject1 = getDefaultDrawable(paramInt4, localbgre);
          }
        }
      }
    }
    label1436:
    label1601:
    label1607:
    for (;;)
    {
      localObject1 = getDefaultDrawable(paramInt4, localbgre);
      break;
      label1490:
      label1504:
      label1645:
      do
      {
        do
        {
          addToCache(localbgrb, n, paramInt4, paramInt1, paramBoolean2, paramString1, paramInt3, paramBoolean1, paramInt2);
          localObject1 = localbgrb;
          break;
          j = 0;
          i = 0;
          localObject2 = null;
          paramVipResourcesListener = null;
          break label416;
          j = 1;
          localObject2 = paramVipResourcesListener;
          paramVipResourcesListener = (VipResourcesListener)localObject1;
          break label416;
          if ((paramString2 == null) || (localDrawable1 == null) || ((i != 0) && (localObject2 == null))) {
            break label552;
          }
          if ((j == 0) || (paramVipResourcesListener != null)) {
            break label637;
          }
          break label552;
          if ((paramInt1 == 0) || (paramInt2 == 0))
          {
            bool = true;
            break label565;
          }
          bool = false;
          break label565;
          bool = true;
          break label718;
          if ((localDrawable1 == null) || (localDrawable2 == null) || (localObject1 == null) || ((i != 0) && (localObject2 == null))) {
            break label1081;
          }
          if ((j == 0) || (paramVipResourcesListener != null)) {
            break label1224;
          }
          break label1081;
          bool = false;
          break label718;
          if ((localDrawable1 == null) || (localDrawable2 == null) || (paramString2 == null) || ((i != 0) && (localObject2 == null))) {
            break label1189;
          }
          if ((j == 0) || (paramVipResourcesListener != null)) {
            break label1224;
          }
          break label1189;
          if ((localDrawable1 == null) || (localDrawable2 == null) || ((i != 0) && (localObject2 == null))) {
            break label1211;
          }
          if ((j == 0) || (paramVipResourcesListener != null)) {
            break label1224;
          }
          break label1211;
          if ((localDrawable1 == null) || (localDrawable2 == null) || (paramString2 == null) || ((i != 0) && (localObject2 == null))) {
            break label1423;
          }
        } while ((j == 0) || (paramVipResourcesListener != null));
        break label1423;
        if ((localDrawable1 == null) || (localDrawable2 == null) || ((i != 0) && (localObject2 == null))) {
          break label1436;
        }
      } while ((j == 0) || (paramVipResourcesListener != null));
    }
  }
  
  public void releaseResources()
  {
    this.context = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.vip.vipcomponent.ui.QzoneHuangzuanVipIconShow
 * JD-Core Version:    0.7.0.1
 */