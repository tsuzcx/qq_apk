import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import com.tencent.biz.pubaccount.readinjoy.view.imageloader.ZImageView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.NativeText;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.util.List;
import mqq.app.AppRuntime;

public class orc
{
  private static final Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  private static Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable = new ColorDrawable(Color.parseColor("#E9E9E9"));
  
  public static float a(int paramInt1, int paramInt2)
  {
    paramInt1 = a(paramInt1, paramInt2);
    if (paramInt1 == 1) {
      return 0.5625F;
    }
    if (paramInt1 == 2) {
      return 1.333F;
    }
    return 1.0F;
  }
  
  public static float a(Context paramContext, rjk paramrjk)
  {
    int j = 28;
    int i;
    if (paramrjk != null)
    {
      i = j;
      if (paramrjk.o == 0)
      {
        i = j;
        if (paramrjk.p == 0)
        {
          i = j;
          if (paramrjk.q == 0)
          {
            if (paramrjk.r == 0) {
              break label56;
            }
            i = j;
          }
        }
      }
    }
    for (;;)
    {
      return bdgk.b(paramContext) - bdaq.a(paramContext, i);
      label56:
      if ((paramrjk.a != null) && (paramrjk.a.mChannelID == 56L))
      {
        i = j;
        if (ors.s()) {}
      }
      else
      {
        i = 12;
      }
    }
  }
  
  /* Error */
  public static float a(android.view.View paramView)
  {
    // Byte code:
    //   0: ldc 84
    //   2: fstore_2
    //   3: ldc 2
    //   5: monitorenter
    //   6: aload_0
    //   7: getstatic 31	orc:jdField_a_of_type_AndroidGraphicsRect	Landroid/graphics/Rect;
    //   10: invokevirtual 90	android/view/View:getLocalVisibleRect	(Landroid/graphics/Rect;)Z
    //   13: pop
    //   14: aload_0
    //   15: invokevirtual 94	android/view/View:getHeight	()I
    //   18: istore_3
    //   19: getstatic 31	orc:jdField_a_of_type_AndroidGraphicsRect	Landroid/graphics/Rect;
    //   22: getfield 97	android/graphics/Rect:top	I
    //   25: ifne +24 -> 49
    //   28: getstatic 31	orc:jdField_a_of_type_AndroidGraphicsRect	Landroid/graphics/Rect;
    //   31: getfield 100	android/graphics/Rect:bottom	I
    //   34: istore 4
    //   36: iload 4
    //   38: iload_3
    //   39: if_icmpne +10 -> 49
    //   42: fload_2
    //   43: fstore_1
    //   44: ldc 2
    //   46: monitorexit
    //   47: fload_1
    //   48: freturn
    //   49: getstatic 31	orc:jdField_a_of_type_AndroidGraphicsRect	Landroid/graphics/Rect;
    //   52: getfield 97	android/graphics/Rect:top	I
    //   55: ifle +22 -> 77
    //   58: ldc 84
    //   60: iload_3
    //   61: getstatic 31	orc:jdField_a_of_type_AndroidGraphicsRect	Landroid/graphics/Rect;
    //   64: getfield 97	android/graphics/Rect:top	I
    //   67: isub
    //   68: i2f
    //   69: fmul
    //   70: iload_3
    //   71: i2f
    //   72: fdiv
    //   73: fstore_1
    //   74: goto -30 -> 44
    //   77: fload_2
    //   78: fstore_1
    //   79: getstatic 31	orc:jdField_a_of_type_AndroidGraphicsRect	Landroid/graphics/Rect;
    //   82: getfield 100	android/graphics/Rect:bottom	I
    //   85: ifle -41 -> 44
    //   88: fload_2
    //   89: fstore_1
    //   90: getstatic 31	orc:jdField_a_of_type_AndroidGraphicsRect	Landroid/graphics/Rect;
    //   93: getfield 100	android/graphics/Rect:bottom	I
    //   96: iload_3
    //   97: if_icmpge -53 -> 44
    //   100: getstatic 31	orc:jdField_a_of_type_AndroidGraphicsRect	Landroid/graphics/Rect;
    //   103: getfield 100	android/graphics/Rect:bottom	I
    //   106: istore 4
    //   108: ldc 84
    //   110: iload 4
    //   112: i2f
    //   113: fmul
    //   114: iload_3
    //   115: i2f
    //   116: fdiv
    //   117: fstore_1
    //   118: goto -74 -> 44
    //   121: astore_0
    //   122: ldc 2
    //   124: monitorexit
    //   125: aload_0
    //   126: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	127	0	paramView	android.view.View
    //   43	75	1	f1	float
    //   2	87	2	f2	float
    //   18	97	3	i	int
    //   34	77	4	j	int
    // Exception table:
    //   from	to	target	type
    //   6	36	121	finally
    //   49	74	121	finally
    //   79	88	121	finally
    //   90	108	121	finally
  }
  
  public static int a(int paramInt1, int paramInt2)
  {
    return 1;
  }
  
  public static int a(int paramInt, Resources paramResources)
  {
    return (paramInt - (aepi.a(24.0F, paramResources) + aepi.a(3.0F, paramResources))) / 2;
  }
  
  public static Drawable a(String paramString)
  {
    int i = Color.parseColor(paramString);
    paramString = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[] { i, i & 0x14FFFFFF });
    paramString.setShape(0);
    paramString.setGradientType(0);
    paramString.setBounds(0, 0, 400, 400);
    return paramString;
  }
  
  public static Pair<Integer, Integer> a()
  {
    Resources localResources = BaseApplicationImpl.getApplication().getResources();
    return new Pair(Integer.valueOf((localResources.getDisplayMetrics().widthPixels - aepi.a(3.0F, localResources)) / 3), Integer.valueOf(localResources.getDimensionPixelSize(2131298578)));
  }
  
  public static Pair<Integer, Integer> a(int paramInt1, int paramInt2)
  {
    Resources localResources = BaseApplicationImpl.getApplication().getResources();
    int i = aepi.a(1.5F, localResources);
    if (paramInt2 == 56) {
      i = aepi.a(3.0F, localResources);
    }
    bkbu localbkbu = bkbq.a(BaseApplicationImpl.getApplication().getRuntime());
    float f1;
    float f2;
    if (localbkbu != null)
    {
      f1 = localbkbu.a;
      f2 = localbkbu.jdField_b_of_type_Float;
      paramInt2 = aepi.a(localbkbu.jdField_b_of_type_Int, localResources);
    }
    for (;;)
    {
      switch (paramInt1)
      {
      default: 
        if (paramInt2 != 0) {
          break;
        }
      }
      for (paramInt1 = (int)((localResources.getDisplayMetrics().widthPixels - aepi.a(6, localResources) - i * 2) / 2.1F);; paramInt1 = paramInt2)
      {
        i = (int)(paramInt1 / f2);
        paramInt2 = paramInt1;
        paramInt1 = i;
        for (;;)
        {
          return new Pair(Integer.valueOf(paramInt2), Integer.valueOf(paramInt1));
          paramInt2 = localResources.getDisplayMetrics().widthPixels - aepi.a(12, localResources);
          paramInt1 = (int)((localResources.getDisplayMetrics().widthPixels - aepi.a(6, localResources) - i * 2) / 2.5F * 1.3356F);
          continue;
          paramInt2 = (int)((localResources.getDisplayMetrics().widthPixels - aepi.a(12, localResources) - i) * 0.5F);
          paramInt1 = (int)(paramInt2 / f1);
        }
      }
      paramInt2 = 0;
      f1 = 0.7511F;
      f2 = 0.7487F;
    }
  }
  
  public static String a(int paramInt)
  {
    int k = paramInt / 3600;
    int j = paramInt / 60;
    int i = j;
    if (k > 0) {
      i = j - k * 60;
    }
    paramInt %= 60;
    String str1;
    String str2;
    if (i >= 10)
    {
      str1 = String.valueOf(i);
      if (paramInt < 10) {
        break label115;
      }
      str2 = String.valueOf(paramInt);
      label53:
      if (k <= 0) {
        break label157;
      }
      if (k < 10) {
        break label136;
      }
    }
    label136:
    for (String str3 = String.valueOf(k);; str3 = String.format("0%d", new Object[] { Integer.valueOf(k) }))
    {
      return String.format("%s:%s:%s", new Object[] { str3, str1, str2 });
      str1 = String.format("0%d", new Object[] { Integer.valueOf(i) });
      break;
      label115:
      str2 = String.format("0%d", new Object[] { Integer.valueOf(paramInt) });
      break label53;
    }
    label157:
    return String.format("%s:%s", new Object[] { str1, str2 });
  }
  
  public static String a(String paramString)
  {
    String str;
    if (TextUtils.isEmpty(paramString)) {
      str = "";
    }
    do
    {
      return str;
      str = paramString;
    } while (!banh.a(paramString));
    paramString = new StringBuilder(paramString);
    int i = 0;
    while (i < bamd.a.length)
    {
      str = bamd.a[i];
      int j = -1;
      for (;;)
      {
        int k = paramString.indexOf(str, j + 1);
        if (k == -1) {
          break;
        }
        j = k;
        if (k != 0)
        {
          j = k;
          if (paramString.codePointAt(k - 1) == 20)
          {
            char c = (char)i;
            paramString.replace(k, str.length() + k, String.valueOf(c));
            j = k;
          }
        }
      }
      i += 1;
    }
    return paramString.toString();
  }
  
  public static String a(String paramString, int paramInt)
  {
    String str = paramString;
    if (paramString.length() > paramInt) {
      str = paramString.substring(0, paramInt - 1) + "…";
    }
    return str;
  }
  
  public static void a()
  {
    if (BaseApplicationImpl.sProcessId == 1)
    {
      BaseApplicationImpl.sImageCache.evict(0);
      return;
    }
    BaseApplicationImpl.sImageCache.evictAll();
  }
  
  public static void a(ImageView paramImageView, String paramString, Context paramContext)
  {
    a(paramImageView, ors.a(paramString), paramContext);
  }
  
  public static void a(ImageView paramImageView, URL paramURL, Context paramContext)
  {
    if (paramURL == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.ui", 2, "configImage url is empty! use default preload image");
      }
      paramImageView.setImageResource(2130841378);
      return;
    }
    if ((paramContext instanceof BaseActivity)) {}
    for (Object localObject = (BaseActivity)paramContext;; localObject = null)
    {
      if (localObject != null) {}
      for (boolean bool = SettingCloneUtil.readValue((Context)localObject, ((BaseActivity)localObject).app.getCurrentAccountUin(), null, "qqsetting_kandian_download_pic_flag", false);; bool = false)
      {
        if ((!bdin.h(paramContext)) && (bool) && (!sff.a().a(paramURL)))
        {
          paramImageView.setImageResource(2130841378);
          return;
        }
        localObject = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = paramContext.getResources().getDrawable(2130841378);
        ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = paramContext.getResources().getDrawable(2130841378);
        paramImageView.setImageDrawable(URLDrawable.getDrawable(paramURL, (URLDrawable.URLDrawableOptions)localObject));
        return;
      }
    }
  }
  
  public static void a(KandianUrlImageView paramKandianUrlImageView, URL paramURL, Context paramContext)
  {
    a(paramKandianUrlImageView, paramURL, paramContext, false);
  }
  
  public static void a(KandianUrlImageView paramKandianUrlImageView, URL paramURL, Context paramContext, boolean paramBoolean)
  {
    if (paramURL == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.ui", 2, "configImage url is empty! use default preload image");
      }
      paramKandianUrlImageView.setImageResource(2130841378);
      return;
    }
    if ((paramContext instanceof BaseActivity)) {}
    for (BaseActivity localBaseActivity = (BaseActivity)paramContext;; localBaseActivity = null)
    {
      String str;
      if (localBaseActivity != null) {
        if (localBaseActivity.app != null) {
          str = localBaseActivity.app.getCurrentAccountUin();
        }
      }
      for (boolean bool = SettingCloneUtil.readValue(localBaseActivity, str, null, "qqsetting_kandian_download_pic_flag", false);; bool = false)
      {
        if ((bool) && (!bdin.h(paramContext)) && (!sff.a().a(paramURL)))
        {
          if (!paramBoolean)
          {
            paramKandianUrlImageView.setImageResource(2130841378);
            return;
            str = ors.a();
            break;
          }
          paramKandianUrlImageView.setImageDrawable(new ColorDrawable(paramContext.getResources().getColor(2131165307)));
          return;
        }
        if (!paramBoolean)
        {
          if (paramKandianUrlImageView.a())
          {
            paramKandianUrlImageView.a(paramContext.getResources().getDrawable(2130840213)).a(paramURL);
            return;
          }
          paramKandianUrlImageView.a(paramContext.getResources().getDrawable(2130841378)).a(paramURL);
          return;
        }
        paramKandianUrlImageView.setBackgroundDrawable(new ColorDrawable(paramContext.getResources().getColor(2131165307)));
        paramKandianUrlImageView.a(new ColorDrawable(paramContext.getResources().getColor(2131165307))).a(paramURL);
        return;
      }
    }
  }
  
  public static void a(ViewBase paramViewBase, BaseArticleInfo paramBaseArticleInfo)
  {
    if (paramBaseArticleInfo == null) {
      return;
    }
    pga localpga = owy.a().a();
    if ((localpga != null) && (localpga.b()))
    {
      a(false, paramViewBase, null);
      paramBaseArticleInfo.isShowFreeNetFlow = false;
      return;
    }
    if (paramBaseArticleInfo.isShowFreeNetFlow)
    {
      a(true, paramViewBase, localpga);
      return;
    }
    if ((localpga != null) && (localpga.a()))
    {
      a(true, paramViewBase, localpga);
      paramBaseArticleInfo.isShowFreeNetFlow = true;
      localpga.a(true);
      return;
    }
    a(false, paramViewBase, null);
  }
  
  public static void a(List<KandianUrlImageView> paramList, List<URL> paramList1, Context paramContext)
  {
    int j = paramList.size();
    if (j != paramList1.size()) {
      throw new IllegalArgumentException("imageViewListSize != urlListSize");
    }
    if (paramContext != null) {}
    for (boolean bool = SettingCloneUtil.readValue(paramContext, BaseApplicationImpl.getApplication().getRuntime().getAccount(), null, "qqsetting_kandian_download_pic_flag", false);; bool = false)
    {
      int i;
      if ((!bool) || (bdin.h(paramContext))) {
        i = 0;
      }
      while (i < j)
      {
        ((KandianUrlImageView)paramList.get(i)).a(jdField_a_of_type_AndroidGraphicsDrawableDrawable).a((URL)paramList1.get(i));
        i += 1;
        continue;
        i = 0;
        while (i < j)
        {
          ((KandianUrlImageView)paramList.get(i)).setImageDrawable(jdField_a_of_type_AndroidGraphicsDrawableDrawable);
          i += 1;
        }
      }
      return;
    }
  }
  
  public static void a(boolean paramBoolean, ViewBase paramViewBase, pga parampga)
  {
    if (paramViewBase == null) {}
    ViewBase localViewBase1;
    ViewBase localViewBase2;
    do
    {
      return;
      localViewBase1 = paramViewBase.findViewBaseByName("id_large_video_activity_wrapper");
      localViewBase2 = paramViewBase.findViewBaseByName("id_large_video_activity_img");
      paramViewBase = (NativeText)paramViewBase.findViewBaseByName("id_large_video_activity_label");
    } while ((localViewBase1 == null) || (paramViewBase == null) || (localViewBase2 == null));
    if ((paramBoolean) && (parampga != null))
    {
      localViewBase1.setVisibility(0);
      localViewBase2.setVisibility(0);
      paramViewBase.setVisibility(0);
      paramViewBase.setText(parampga.a());
      pga.a("0X8009660");
      return;
    }
    localViewBase1.setVisibility(8);
    localViewBase2.setVisibility(8);
    paramViewBase.setVisibility(8);
  }
  
  public static boolean a(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 0) || (paramInt2 == 0)) {}
    while (paramInt1 > paramInt2) {
      return false;
    }
    return true;
  }
  
  public static boolean a(rjk paramrjk)
  {
    if (paramrjk == null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("ReadInJoyDisplayUtils", 2, "isProtraitVideo return false for videoPlayParam is null.");
      }
      return false;
    }
    return a(paramrjk.c, paramrjk.d);
  }
  
  public static Pair<Integer, Integer> b()
  {
    Resources localResources = BaseApplicationImpl.getApplication().getResources();
    int i = (localResources.getDisplayMetrics().widthPixels - aepi.a(3.0F, localResources)) / 2;
    return new Pair(Integer.valueOf(i), Integer.valueOf((int)(i * 1.33F)));
  }
  
  public static Pair<Integer, Integer> c()
  {
    int i = BaseApplicationImpl.getApplication().getResources().getDisplayMetrics().widthPixels;
    return new Pair(Integer.valueOf(i), Integer.valueOf((int)(i * 0.597F)));
  }
  
  public static Pair<Integer, Integer> d()
  {
    Resources localResources = BaseApplicationImpl.getApplication().getResources();
    int i = (localResources.getDisplayMetrics().widthPixels - aepi.a(3.0F, localResources)) / 3;
    return new Pair(Integer.valueOf(i), Integer.valueOf(i));
  }
  
  public static Pair<Integer, Integer> e()
  {
    int i = BaseApplicationImpl.getApplication().getResources().getDisplayMetrics().widthPixels;
    return new Pair(Integer.valueOf(i), Integer.valueOf((int)(i * 0.562F)));
  }
  
  public static Pair<Integer, Integer> f()
  {
    int i = BaseApplicationImpl.getApplication().getResources().getDisplayMetrics().widthPixels;
    return new Pair(Integer.valueOf(i), Integer.valueOf((int)(i * 0.5625F)));
  }
  
  public static Pair<Integer, Integer> g()
  {
    int i = (int)(BaseApplicationImpl.getApplication().getResources().getDisplayMetrics().widthPixels * 0.5F);
    return new Pair(Integer.valueOf(i), Integer.valueOf((int)(i * 1.3333F)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     orc
 * JD-Core Version:    0.7.0.1
 */