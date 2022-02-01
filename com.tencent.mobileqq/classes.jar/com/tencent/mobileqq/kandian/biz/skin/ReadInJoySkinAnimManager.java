package com.tencent.mobileqq.kandian.biz.skin;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.AudioAttributes.Builder;
import android.media.AudioManager;
import android.media.SoundPool;
import android.media.SoundPool.Builder;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.base.view.widget.pullrefresh.SkinPullRefreshHeader;
import com.tencent.mobileqq.kandian.biz.pullrefresh.ReadInJoyAnimBaseManager;
import com.tencent.mobileqq.kandian.biz.skin.api.IReadInJoySkinAnimManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.widget.IPullRefreshHeader;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ReadInJoySkinAnimManager
  extends ReadInJoyAnimBaseManager
  implements IReadInJoySkinAnimManager
{
  private SoundPool jdField_a_of_type_AndroidMediaSoundPool;
  private ReadInJoySkinAnimManager.ResourceHandler jdField_a_of_type_ComTencentMobileqqKandianBizSkinReadInJoySkinAnimManager$ResourceHandler;
  private Runnable jdField_a_of_type_JavaLangRunnable;
  private String jdField_a_of_type_JavaLangString;
  private ArrayList<ReadInJoySkinAnimManager.PngWrapper> jdField_a_of_type_JavaUtilArrayList;
  private List<String> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = -2;
  private Context jdField_b_of_type_AndroidContentContext;
  private SoundPool jdField_b_of_type_AndroidMediaSoundPool;
  private String jdField_b_of_type_JavaLangString;
  private ArrayList<ReadInJoySkinAnimManager.PngWrapper> jdField_b_of_type_JavaUtilArrayList;
  private volatile boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int = -2;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int;
  private boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int;
  private boolean jdField_e_of_type_Boolean;
  private int jdField_f_of_type_Int;
  private boolean jdField_f_of_type_Boolean;
  private int jdField_g_of_type_Int;
  private boolean jdField_g_of_type_Boolean;
  private int jdField_h_of_type_Int;
  private boolean jdField_h_of_type_Boolean;
  private int jdField_i_of_type_Int;
  private boolean jdField_i_of_type_Boolean;
  private int j;
  private int k;
  private int l;
  
  public ReadInJoySkinAnimManager(Context paramContext)
  {
    super(paramContext);
    boolean bool = false;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_e_of_type_Int = -2;
    this.jdField_f_of_type_Int = -2;
    this.jdField_h_of_type_Int = 0;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.j = -2;
    this.jdField_e_of_type_Boolean = true;
    this.jdField_f_of_type_Boolean = false;
    this.jdField_g_of_type_Boolean = false;
    this.jdField_h_of_type_Boolean = false;
    this.k = 1;
    this.l = -1;
    this.jdField_i_of_type_Boolean = false;
    this.jdField_a_of_type_JavaLangRunnable = new ReadInJoySkinAnimManager.2(this);
    this.jdField_b_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizSkinReadInJoySkinAnimManager$ResourceHandler = new ReadInJoySkinAnimManager.ResourceHandler(this);
    if ((float)Runtime.getRuntime().maxMemory() <= 1.415578E+008F) {
      bool = true;
    }
    this.jdField_i_of_type_Boolean = bool;
    if ((paramContext instanceof BaseActivity))
    {
      paramContext = (BaseActivity)paramContext;
      ReadInJoyRefreshManager localReadInJoyRefreshManager = (ReadInJoyRefreshManager)paramContext.app.getManager(QQManagerFactory.READ_INJOY_REFRESH_MANAGER);
      if ((localReadInJoyRefreshManager.a() == 1) && (localReadInJoyRefreshManager.b()))
      {
        this.jdField_a_of_type_JavaUtilList = RefreshRes.a();
        this.jdField_d_of_type_Int = RefreshRes.a();
        this.jdField_a_of_type_JavaLangString = RefreshRes.c();
        this.jdField_b_of_type_JavaLangString = localReadInJoyRefreshManager.a();
        this.jdField_c_of_type_JavaLangString = RefreshRes.e();
        this.l = 1;
      }
      else
      {
        this.jdField_a_of_type_JavaUtilList = CommonSkinRes.a();
        this.jdField_d_of_type_Int = CommonSkinRes.b();
        this.jdField_a_of_type_JavaLangString = CommonSkinRes.d();
        this.jdField_b_of_type_JavaLangString = ((ReadInJoySkinManager)paramContext.app.getManager(QQManagerFactory.READ_INJOY_SKIN_MANAGER)).a();
        this.jdField_c_of_type_JavaLangString = CommonSkinRes.e();
        this.l = 2;
      }
      if (this.jdField_b_of_type_Int == -2)
      {
        this.jdField_b_of_type_Int = ((int)(paramContext.getWindowManager().getDefaultDisplay().getHeight() * 0.24F));
        int m = this.jdField_d_of_type_Int;
        if (m == 1) {
          this.jdField_c_of_type_Int = ((int)(paramContext.getWindowManager().getDefaultDisplay().getWidth() * 0.53F));
        } else if (m == 2)
        {
          if (localReadInJoyRefreshManager.a()) {
            this.jdField_c_of_type_Int = paramContext.getWindowManager().getDefaultDisplay().getWidth();
          } else {
            this.jdField_c_of_type_Int = ((int)(paramContext.getWindowManager().getDefaultDisplay().getWidth() * 1.0F));
          }
        }
        else if (m == 3) {
          this.jdField_c_of_type_Int = paramContext.getWindowManager().getDefaultDisplay().getWidth();
        }
      }
      if (this.k == 1)
      {
        this.k = 2;
        ThreadManager.post(new ReadInJoySkinAnimManager.InitResourceRunnable(this, true), 8, null, true);
      }
    }
  }
  
  private int a(int paramInt1, int paramInt2)
  {
    if (paramInt2 > 0)
    {
      m = (int)Math.floor(7340032.0F / paramInt2);
      if (paramInt1 > m)
      {
        paramInt1 = (int)Math.ceil(paramInt1 / m);
        break label36;
      }
    }
    paramInt1 = 1;
    label36:
    int m = paramInt1;
    StringBuilder localStringBuilder;
    if (paramInt1 <= 0)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("getSamplingRate invalid samplingRate. Here simpleBitmapSize = ");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(" samplingRate = ");
      localStringBuilder.append(paramInt1);
      QLog.e("ReadInJoySkinAnimManager", 1, localStringBuilder.toString());
      m = 1;
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("getSamplingRate simpleBitmapSize = ");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(" samplingRate = ");
      localStringBuilder.append(m);
      QLog.d("ReadInJoySkinAnimManager", 1, localStringBuilder.toString());
    }
    return m;
  }
  
  private int a(Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return -1;
    }
    if (Build.VERSION.SDK_INT >= 12) {
      return paramBitmap.getByteCount();
    }
    return paramBitmap.getRowBytes() * paramBitmap.getHeight();
  }
  
  private int a(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt3 <= 0) {
      return 1;
    }
    int n = paramOptions.outWidth;
    if (n > paramInt1)
    {
      int m = 2;
      int i1 = n / 2;
      for (;;)
      {
        n = m;
        if (i1 / m < paramInt1) {
          break;
        }
        m *= 2;
      }
    }
    n = 1;
    double d1 = paramInt2 * paramInt3;
    Double.isNaN(d1);
    d1 = Math.sqrt(d1 * 1.0D / 10485760.0D);
    while (n < d1) {
      n *= 2;
    }
    if (QLog.isColorLevel())
    {
      paramOptions = new StringBuilder();
      paramOptions.append("calculateInSampleSize inSampleSize = ");
      paramOptions.append(n);
      QLog.d("ReadInJoySkinAnimManager", 1, paramOptions.toString());
    }
    return n;
  }
  
  private int a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append("refreshAnimatePictures");
    localStringBuilder.append("/");
    localStringBuilder.append(paramString);
    boolean bool = new File(localStringBuilder.toString()).exists();
    int n = 0;
    int m = n;
    if (bool)
    {
      paramString = new BitmapFactory.Options();
      paramString.inJustDecodeBounds = false;
      paramString.inPreferredConfig = Bitmap.Config.ARGB_4444;
      try
      {
        paramString = ImageUtil.a(localStringBuilder.toString(), paramString);
        n = a(paramString);
        m = n;
        if (QLog.isColorLevel())
        {
          paramString = new StringBuilder();
          paramString.append("getSamplingRate simpleBitmapSize = ");
          paramString.append(n);
          QLog.d("ReadInJoySkinAnimManager", 1, paramString.toString());
          return n;
        }
      }
      catch (OutOfMemoryError paramString)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("getPngDrawable oom = ");
        localStringBuilder.append(paramString);
        QLog.e("ReadInJoySkinAnimManager", 1, localStringBuilder.toString());
        m = n;
      }
    }
    return m;
  }
  
  private Drawable a(String paramString1, String paramString2, String paramString3, Resources paramResources, int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramString1);
    localStringBuilder.append(paramString2);
    localStringBuilder.append("/");
    localStringBuilder.append(paramString3);
    if (new File(localStringBuilder.toString()).exists())
    {
      paramString3 = new BitmapFactory.Options();
      if ((this.j == -2) && (this.jdField_c_of_type_Int != -2))
      {
        paramString3.inJustDecodeBounds = true;
        ImageUtil.a(localStringBuilder.toString(), paramString3);
        int m = this.jdField_d_of_type_Int;
        if (m == 1) {
          this.j = a(paramString3, this.jdField_c_of_type_Int, paramInt1, paramInt2);
        } else if (m == 2) {
          this.j = a(paramString3, this.jdField_c_of_type_Int, paramInt1, paramInt2);
        } else if (m == 3) {
          this.j = a(paramString3, this.jdField_c_of_type_Int, paramInt1, paramInt2);
        }
      }
      paramInt2 = this.j;
      if (paramInt2 != -2)
      {
        paramString3.inSampleSize = paramInt2;
        if (QLog.isColorLevel())
        {
          paramString2 = new StringBuilder();
          paramString2.append("mSampleSize = ");
          paramString2.append(this.j);
          QLog.d("ReadInJoySkinAnimManager", 1, paramString2.toString());
        }
      }
      paramString3.inJustDecodeBounds = false;
      paramString3.inPreferredConfig = Bitmap.Config.ARGB_4444;
      try
      {
        paramString2 = ImageUtil.a(localStringBuilder.toString(), paramString3);
        paramString1 = paramString2;
      }
      catch (OutOfMemoryError paramString2)
      {
        ReportController.b(null, "dc00899", "BizTechReport", "", "kan_dian_skin_pull_refresh", "decode_bitmap_oom", paramString3.inSampleSize, paramInt1, this.jdField_b_of_type_JavaLangString, String.valueOf(paramString3.outHeight), String.valueOf(paramString3.outWidth), null);
        paramString3 = new StringBuilder();
        paramString3.append("getPngDrawable oom = ");
        paramString3.append(paramString2);
        paramString3.append(" resFolderPath:");
        paramString3.append(paramString1);
        QLog.e("ReadInJoySkinAnimManager", 1, paramString3.toString());
        return null;
      }
    }
    else
    {
      paramString1 = null;
    }
    if (paramString1 != null) {
      return new BitmapDrawable(paramResources, paramString1);
    }
    QLog.e("ReadInJoySkinAnimManager", 1, "getPngDrawable bitmap = null");
    return null;
  }
  
  private SoundPool a()
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      SoundPool.Builder localBuilder = new SoundPool.Builder();
      localBuilder.setMaxStreams(1);
      localBuilder.setAudioAttributes(new AudioAttributes.Builder().build());
      return localBuilder.build();
    }
    return new SoundPool(1, 3, 0);
  }
  
  private void a(int paramInt)
  {
    ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
    int i2 = 0;
    int n;
    if (localArrayList != null) {
      n = localArrayList.size();
    } else {
      n = 0;
    }
    int m;
    if ((n > 0) && (this.jdField_d_of_type_Int == 1))
    {
      m = this.jdField_b_of_type_Int;
      if (paramInt >= m) {
        paramInt = 100;
      } else if ((paramInt < m) && (paramInt > 0) && (m != 0)) {
        paramInt = paramInt * 100 / m;
      } else {
        paramInt = 0;
      }
      if (paramInt == 100)
      {
        paramInt = this.jdField_e_of_type_Int;
        m = n - 1;
        if (paramInt != m)
        {
          this.jdField_e_of_type_Int = m;
          a(((ReadInJoySkinAnimManager.PngWrapper)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_e_of_type_Int)).jdField_a_of_type_AndroidGraphicsDrawableDrawable);
        }
      }
      else
      {
        m = 0;
        int i1;
        for (;;)
        {
          i1 = i2;
          if (m >= n) {
            break;
          }
          if (((ReadInJoySkinAnimManager.PngWrapper)this.jdField_a_of_type_JavaUtilArrayList.get(m)).jdField_a_of_type_Int >= paramInt)
          {
            i1 = m;
            break;
          }
          m += 1;
        }
        if (i1 != this.jdField_e_of_type_Int)
        {
          this.jdField_e_of_type_Int = i1;
          a(((ReadInJoySkinAnimManager.PngWrapper)this.jdField_a_of_type_JavaUtilArrayList.get(i1)).jdField_a_of_type_AndroidGraphicsDrawableDrawable);
        }
      }
    }
    else if ((n > 0) && (this.jdField_d_of_type_Int == 2))
    {
      if (this.jdField_e_of_type_Int == -2)
      {
        double d1 = Math.random();
        double d2 = n;
        Double.isNaN(d2);
        this.jdField_e_of_type_Int = ((int)Math.floor(d1 * d2));
        paramInt = this.jdField_e_of_type_Int;
        this.jdField_f_of_type_Int = paramInt;
        a(((ReadInJoySkinAnimManager.PngWrapper)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      }
      paramInt = this.jdField_e_of_type_Int;
      m = this.jdField_f_of_type_Int;
      if (paramInt != m)
      {
        this.jdField_e_of_type_Int = m;
        a(((ReadInJoySkinAnimManager.PngWrapper)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_e_of_type_Int)).jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      }
    }
    else if ((n > 0) && (this.jdField_d_of_type_Int == 3) && (!this.jdField_f_of_type_Boolean))
    {
      this.jdField_f_of_type_Boolean = true;
      ((SkinPullRefreshHeader)this.jdField_a_of_type_ComTencentMobileqqWidgetIPullRefreshHeader).removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      ((SkinPullRefreshHeader)this.jdField_a_of_type_ComTencentMobileqqWidgetIPullRefreshHeader).post(this.jdField_a_of_type_JavaLangRunnable);
    }
  }
  
  private void a(Drawable paramDrawable)
  {
    ((SkinPullRefreshHeader)this.jdField_a_of_type_ComTencentMobileqqWidgetIPullRefreshHeader).a(paramDrawable, this.jdField_a_of_type_Boolean ^ true);
  }
  
  private void a(List<String> paramList, ArrayList<ReadInJoySkinAnimManager.PngWrapper> paramArrayList, int paramInt)
  {
    Resources localResources = BaseApplicationImpl.getContext().getResources();
    String str1 = this.jdField_a_of_type_JavaLangString;
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      String str2 = (String)localIterator.next();
      Drawable localDrawable = a(str1, "refreshRandomPictures", str2, localResources, paramList.size(), paramInt);
      if (localDrawable != null) {
        paramArrayList.add(new ReadInJoySkinAnimManager.PngWrapper(str2, 0, localDrawable));
      }
    }
    if (QLog.isColorLevel())
    {
      paramList = new StringBuilder();
      paramList.append("initResources size = ");
      paramList.append(paramArrayList.size());
      QLog.d("ReadInJoySkinAnimManager", 1, paramList.toString());
    }
    this.jdField_b_of_type_JavaUtilArrayList = paramArrayList;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizSkinReadInJoySkinAnimManager$ResourceHandler.sendEmptyMessage(1);
  }
  
  private void a(List<String> paramList, ArrayList<ReadInJoySkinAnimManager.PngWrapper> paramArrayList, int paramInt1, int paramInt2)
  {
    Resources localResources = BaseApplicationImpl.getContext().getResources();
    String str1 = this.jdField_a_of_type_JavaLangString;
    int n = paramList.size();
    Iterator localIterator = paramList.iterator();
    int m = 0;
    while (localIterator.hasNext())
    {
      String str2 = (String)localIterator.next();
      m += 1;
      if ((m % paramInt2 == 0) || (m == n))
      {
        int i1 = b(str2);
        Drawable localDrawable = a(str1, "refreshAnimatePictures", str2, localResources, paramList.size(), paramInt1);
        if ((i1 != -2) && (localDrawable != null)) {
          paramArrayList.add(new ReadInJoySkinAnimManager.PngWrapper(str2, i1, localDrawable));
        }
      }
    }
    Collections.sort(paramArrayList);
    if (QLog.isColorLevel())
    {
      paramList = new StringBuilder();
      paramList.append("initResources size = ");
      paramList.append(paramArrayList.size());
      QLog.d("ReadInJoySkinAnimManager", 1, paramList.toString());
    }
    this.jdField_b_of_type_JavaUtilArrayList = paramArrayList;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizSkinReadInJoySkinAnimManager$ResourceHandler.sendEmptyMessage(1);
  }
  
  private void a(boolean paramBoolean)
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    if (localList != null)
    {
      if (localList.size() <= 0) {
        return;
      }
      b(paramBoolean);
      int n = a((String)localList.get(0));
      if (this.jdField_i_of_type_Boolean)
      {
        m = this.jdField_d_of_type_Int;
        if ((m == 1) || (m == 3))
        {
          m = a(localList.size(), n);
          break label83;
        }
      }
      int m = 1;
      label83:
      ArrayList localArrayList = new ArrayList();
      int i1 = this.jdField_d_of_type_Int;
      if ((i1 == 1) || (i1 == 2) || (i1 == 3)) {
        ReportController.b(null, "dc00899", "BizTechReport", "", "kan_dian_skin_pull_refresh", "decode_bitmap_times", 0, 0, this.jdField_b_of_type_JavaLangString, null, null, null);
      }
      i1 = this.jdField_d_of_type_Int;
      if ((i1 != 1) && (i1 != 3))
      {
        if (i1 == 2) {
          a(localList, localArrayList, n);
        }
      }
      else {
        a(localList, localArrayList, n, m);
      }
    }
  }
  
  private int b(String paramString)
  {
    Object localObject = paramString.substring(0, paramString.length() - 4);
    if (localObject != null) {}
    try
    {
      int m = Integer.parseInt((String)localObject);
      if ((m < 0) || (m > 100)) {
        break label65;
      }
      return m;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      label33:
      break label33;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getPNGIndex NumberFormatException pngName = ");
    ((StringBuilder)localObject).append(paramString);
    QLog.e("ReadInJoySkinAnimManager", 1, ((StringBuilder)localObject).toString());
    label65:
    return -2;
  }
  
  private void b(int paramInt)
  {
    if (this.jdField_b_of_type_Boolean)
    {
      boolean bool;
      if ((paramInt >= this.jdField_i_of_type_Int) && (!this.jdField_c_of_type_Boolean)) {
        bool = true;
      } else {
        bool = false;
      }
      this.jdField_d_of_type_Boolean = bool;
      if (this.jdField_d_of_type_Boolean)
      {
        AppInterface localAppInterface = ((BaseActivity)this.jdField_b_of_type_AndroidContentContext).getAppInterface();
        if ((localAppInterface != null) && (((SharedPreUtils.p(this.jdField_b_of_type_AndroidContentContext, localAppInterface.getCurrentAccountUin())) && (this.l == 2)) || (this.l == 1))) {
          f();
        }
      }
      int m = this.jdField_i_of_type_Int;
      if (paramInt >= m)
      {
        this.jdField_c_of_type_Boolean = true;
        return;
      }
      if (paramInt < m) {
        this.jdField_c_of_type_Boolean = false;
      }
    }
  }
  
  private void b(boolean paramBoolean)
  {
    if (paramBoolean) {
      if (this.jdField_c_of_type_JavaLangString != null)
      {
        SoundPool localSoundPool = a();
        if (localSoundPool != null)
        {
          this.jdField_b_of_type_AndroidMediaSoundPool = localSoundPool;
          this.jdField_a_of_type_ComTencentMobileqqKandianBizSkinReadInJoySkinAnimManager$ResourceHandler.sendEmptyMessage(2);
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoySkinAnimManager", 1, "init soundpool failed");
        }
      }
      else if (QLog.isColorLevel())
      {
        QLog.d("ReadInJoySkinAnimManager", 1, "voicePath = null");
      }
    }
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetIPullRefreshHeader != null)
    {
      ((SkinPullRefreshHeader)this.jdField_a_of_type_ComTencentMobileqqWidgetIPullRefreshHeader).removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_f_of_type_Boolean = false;
    }
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null)
    {
      this.jdField_a_of_type_JavaUtilArrayList = this.jdField_b_of_type_JavaUtilArrayList;
      if ((this.jdField_a_of_type_JavaUtilArrayList.size() > 0) && (this.jdField_a_of_type_ComTencentMobileqqWidgetIPullRefreshHeader != null)) {
        if (this.jdField_h_of_type_Boolean)
        {
          a(((ReadInJoySkinAnimManager.PngWrapper)this.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_AndroidGraphicsDrawableDrawable);
          ((SkinPullRefreshHeader)this.jdField_a_of_type_ComTencentMobileqqWidgetIPullRefreshHeader).removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
          ((SkinPullRefreshHeader)this.jdField_a_of_type_ComTencentMobileqqWidgetIPullRefreshHeader).post(this.jdField_a_of_type_JavaLangRunnable);
        }
        else
        {
          a(((ReadInJoySkinAnimManager.PngWrapper)this.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_AndroidGraphicsDrawableDrawable);
        }
      }
    }
    else
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setPngArray mRefreshPullDownPNGS.size = ");
      localStringBuilder.append(this.jdField_a_of_type_JavaUtilArrayList.size());
      QLog.e("ReadInJoySkinAnimManager", 1, localStringBuilder.toString());
    }
    this.jdField_b_of_type_JavaUtilArrayList = null;
    this.k = 3;
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_AndroidMediaSoundPool == null) {
      this.jdField_a_of_type_AndroidMediaSoundPool = this.jdField_b_of_type_AndroidMediaSoundPool;
    } else {
      QLog.e("ReadInJoySkinAnimManager", 1, "setSoundPool mRefreshPullDownPNGS.size != null");
    }
    this.jdField_b_of_type_AndroidMediaSoundPool = null;
    String str = this.jdField_c_of_type_JavaLangString;
    if ((str != null) && (new File(str).exists()))
    {
      SoundPool localSoundPool = this.jdField_a_of_type_AndroidMediaSoundPool;
      if (localSoundPool != null)
      {
        this.jdField_g_of_type_Int = localSoundPool.load(str, 0);
        long l1 = System.currentTimeMillis();
        this.jdField_a_of_type_AndroidMediaSoundPool.setOnLoadCompleteListener(new ReadInJoySkinAnimManager.1(this, l1));
      }
    }
  }
  
  private void f()
  {
    Object localObject = (AudioManager)this.jdField_b_of_type_AndroidContentContext.getSystemService("audio");
    int m;
    if (localObject != null)
    {
      f1 = ((AudioManager)localObject).getStreamVolume(3);
      m = ((AudioManager)localObject).getStreamMaxVolume(3);
      if (m != 0)
      {
        f1 /= m;
        break label47;
      }
    }
    float f1 = 0.5F;
    label47:
    if (localObject != null) {
      m = ((AudioManager)localObject).getRingerMode();
    } else {
      m = 2;
    }
    if (m == 2) {
      this.jdField_h_of_type_Int = this.jdField_a_of_type_AndroidMediaSoundPool.play(this.jdField_g_of_type_Int, f1, f1, 0, 0, 1.0F);
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("playSound volume = ");
      ((StringBuilder)localObject).append(f1);
      ((StringBuilder)localObject).append(" RINGER_MODE_NORMAL = ");
      ((StringBuilder)localObject).append(2);
      QLog.d("ReadInJoySkinAnimManager", 1, ((StringBuilder)localObject).toString());
    }
  }
  
  public void a()
  {
    Object localObject = this.jdField_a_of_type_AndroidMediaSoundPool;
    if (localObject != null) {
      ((SoundPool)localObject).stop(this.jdField_h_of_type_Int);
    }
    c();
    localObject = this.jdField_a_of_type_JavaUtilArrayList;
    if ((localObject != null) && (!((ArrayList)localObject).isEmpty())) {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
    }
    this.jdField_a_of_type_JavaUtilArrayList = null;
    if (this.k == 3) {
      this.k = 1;
    }
  }
  
  public void a(SlideActiveAnimController paramSlideActiveAnimController)
  {
    super.a(paramSlideActiveAnimController);
    if ((this.jdField_a_of_type_ComTencentMobileqqKandianBizSkinSlideActiveAnimController != null) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizSkinSlideActiveAnimController.b())) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizSkinSlideActiveAnimController.a(this.jdField_b_of_type_JavaLangString, RefreshRes.d(), QQManagerFactory.READ_INJOY_SKIN_MANAGER);
    }
  }
  
  public boolean a()
  {
    if ((this.jdField_g_of_type_Boolean) && (!this.jdField_h_of_type_Boolean)) {
      c();
    }
    this.jdField_e_of_type_Boolean = true;
    if ((this.jdField_a_of_type_ComTencentMobileqqKandianBizSkinSlideActiveAnimController != null) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizSkinSlideActiveAnimController.b()) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizSkinSlideActiveAnimController.a()))
    {
      if (this.jdField_d_of_type_Int == 3) {
        c();
      }
      return true;
    }
    return false;
  }
  
  public void b()
  {
    if (this.k == 1)
    {
      this.k = 2;
      ThreadManager.post(new ReadInJoySkinAnimManager.InitResourceRunnable(this, false), 8, null, true);
    }
  }
  
  public void endOfRefresh()
  {
    super.endOfRefresh();
    if ((this.jdField_a_of_type_ComTencentMobileqqKandianBizSkinSlideActiveAnimController != null) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizSkinSlideActiveAnimController.b())) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizSkinSlideActiveAnimController.c();
    }
    this.jdField_h_of_type_Boolean = false;
    if (!this.jdField_g_of_type_Boolean) {
      c();
    }
  }
  
  public int getPullRefreshAreaHeight()
  {
    this.jdField_i_of_type_Int = this.jdField_b_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298921);
    return this.jdField_i_of_type_Int;
  }
  
  public View getRefreshView(ViewGroup paramViewGroup)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetIPullRefreshHeader == null)
    {
      Object localObject = LayoutInflater.from(this.jdField_b_of_type_AndroidContentContext);
      boolean bool2 = false;
      this.jdField_a_of_type_ComTencentMobileqqWidgetIPullRefreshHeader = ((SkinPullRefreshHeader)((LayoutInflater)localObject).inflate(2131562843, paramViewGroup, false));
      if (((this.jdField_a_of_type_ComTencentMobileqqWidgetIPullRefreshHeader instanceof RelativeLayout)) && (this.jdField_b_of_type_Int > 0))
      {
        localObject = (RelativeLayout)this.jdField_a_of_type_ComTencentMobileqqWidgetIPullRefreshHeader;
        AbsListView.LayoutParams localLayoutParams = (AbsListView.LayoutParams)((RelativeLayout)localObject).getLayoutParams();
        paramViewGroup = null;
        int m = this.jdField_d_of_type_Int;
        if ((m != 1) && (m != 3))
        {
          if (m == 2) {
            paramViewGroup = "refreshRandomPictures";
          }
        }
        else {
          paramViewGroup = "refreshAnimatePictures";
        }
        List localList = this.jdField_a_of_type_JavaUtilList;
        if ((localList != null) && (!localList.isEmpty()) && (paramViewGroup != null))
        {
          StringBuilder localStringBuilder = new StringBuilder(this.jdField_a_of_type_JavaLangString);
          localStringBuilder.append(paramViewGroup);
          localStringBuilder.append("/");
          localStringBuilder.append((String)localList.get(0));
          if (new File(localStringBuilder.toString()).exists())
          {
            paramViewGroup = new BitmapFactory.Options();
            paramViewGroup.inJustDecodeBounds = true;
            ImageUtil.a(localStringBuilder.toString(), paramViewGroup);
            if ((this.jdField_c_of_type_Int != -2) && (paramViewGroup.outWidth != 0)) {
              m = paramViewGroup.outHeight * this.jdField_c_of_type_Int / paramViewGroup.outWidth;
            } else {
              m = 0;
            }
            n = m;
            if (!QLog.isColorLevel()) {
              break label329;
            }
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("getRefreshView options.outHeight = ");
            localStringBuilder.append(paramViewGroup.outHeight);
            localStringBuilder.append(" options.outWidth = ");
            localStringBuilder.append(paramViewGroup.outWidth);
            QLog.d("ReadInJoySkinAnimManager", 1, localStringBuilder.toString());
            n = m;
            break label329;
          }
        }
        int n = 0;
        label329:
        if (n != 0) {
          localLayoutParams.height = n;
        } else {
          localLayoutParams.height = this.jdField_b_of_type_Int;
        }
        ((RelativeLayout)localObject).setLayoutParams(localLayoutParams);
        if (this.jdField_c_of_type_Int != -2)
        {
          paramViewGroup = (ImageView)((RelativeLayout)localObject).findViewById(2131376346);
          localObject = paramViewGroup.getLayoutParams();
          ((ViewGroup.LayoutParams)localObject).width = this.jdField_c_of_type_Int;
          paramViewGroup.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
        if (QLog.isColorLevel())
        {
          paramViewGroup = new StringBuilder();
          paramViewGroup.append("getRefreshView sDisplayHeight = ");
          paramViewGroup.append(this.jdField_b_of_type_Int);
          paramViewGroup.append(" sDisplayWidth = ");
          paramViewGroup.append(this.jdField_c_of_type_Int);
          paramViewGroup.append(" refreshType = ");
          paramViewGroup.append(this.jdField_d_of_type_Int);
          QLog.d("ReadInJoySkinAnimManager", 1, paramViewGroup.toString());
        }
        paramViewGroup = this.jdField_b_of_type_AndroidContentContext;
        if ((paramViewGroup instanceof BaseActivity))
        {
          paramViewGroup = (ReadInJoyRefreshManager)((BaseActivity)paramViewGroup).app.getManager(QQManagerFactory.READ_INJOY_REFRESH_MANAGER);
          localObject = paramViewGroup.a(this.jdField_b_of_type_AndroidContentContext, 0);
          if ((localObject != null) && (((RefreshData)localObject).isAD)) {
            bool1 = true;
          } else {
            bool1 = false;
          }
          this.jdField_a_of_type_Boolean = bool1;
          localObject = (SkinPullRefreshHeader)this.jdField_a_of_type_ComTencentMobileqqWidgetIPullRefreshHeader;
          boolean bool1 = bool2;
          if (paramViewGroup.a() == 1)
          {
            bool1 = bool2;
            if (this.jdField_a_of_type_Boolean) {
              bool1 = true;
            }
          }
          ((SkinPullRefreshHeader)localObject).setAdTabVisibility(bool1);
        }
      }
    }
    return (View)this.jdField_a_of_type_ComTencentMobileqqWidgetIPullRefreshHeader;
  }
  
  public boolean isSkinAnimManager()
  {
    return true;
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoySkinAnimManager", 1, "resource onDestroy");
    }
    Object localObject = this.jdField_a_of_type_AndroidMediaSoundPool;
    if (localObject != null)
    {
      ((SoundPool)localObject).stop(this.jdField_h_of_type_Int);
      this.jdField_a_of_type_AndroidMediaSoundPool.release();
      this.jdField_a_of_type_AndroidMediaSoundPool = null;
    }
    this.jdField_b_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    localObject = this.jdField_a_of_type_JavaUtilArrayList;
    if ((localObject != null) && (!((ArrayList)localObject).isEmpty()))
    {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_JavaUtilArrayList = null;
    }
    this.k = 1;
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizSkinSlideActiveAnimController != null) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizSkinSlideActiveAnimController.h();
    }
    c();
  }
  
  public void onPullRefreshCancel()
  {
    c();
    super.onPullRefreshCancel();
  }
  
  public void onPullRefreshComplete(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetIPullRefreshHeader == null) {
      return;
    }
    this.jdField_h_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqWidgetIPullRefreshHeader.a(0L);
    if ((this.jdField_a_of_type_ComTencentMobileqqKandianBizSkinSlideActiveAnimController != null) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizSkinSlideActiveAnimController.b())) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizSkinSlideActiveAnimController.a((SkinPullRefreshHeader)this.jdField_a_of_type_ComTencentMobileqqWidgetIPullRefreshHeader);
    }
    int m = 0;
    ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
    if (localArrayList != null) {
      m = localArrayList.size();
    }
    if (m > 0)
    {
      double d1 = Math.random();
      double d2 = m;
      Double.isNaN(d2);
      this.jdField_f_of_type_Int = ((int)Math.floor(d1 * d2));
    }
    super.onPullRefreshComplete(paramBoolean);
  }
  
  public void onPullRefreshing(int paramInt, boolean paramBoolean)
  {
    super.onPullRefreshing(paramInt, paramBoolean);
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetIPullRefreshHeader == null) {
      return;
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetIPullRefreshHeader.f();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetIPullRefreshHeader.c(0L);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0) {
      this.jdField_g_of_type_Boolean = this.jdField_h_of_type_Boolean;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqKandianBizSkinSlideActiveAnimController != null) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizSkinSlideActiveAnimController.b()) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizSkinSlideActiveAnimController.a(paramMotionEvent))) {
      return true;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void onTouchPullDistance(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetIPullRefreshHeader == null) {
      return;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqKandianBizSkinSlideActiveAnimController != null) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizSkinSlideActiveAnimController.b())) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizSkinSlideActiveAnimController.a((SkinPullRefreshHeader)this.jdField_a_of_type_ComTencentMobileqqWidgetIPullRefreshHeader, paramInt1, paramInt2);
    }
    a(paramInt1);
    b(paramInt1);
    if (this.jdField_e_of_type_Boolean)
    {
      paramInt1 = this.jdField_d_of_type_Int;
      if ((paramInt1 == 2) || (paramInt1 == 1) || (paramInt1 == 3))
      {
        Object localObject = this.jdField_a_of_type_JavaUtilArrayList;
        if (localObject != null) {
          paramInt1 = ((ArrayList)localObject).size();
        } else {
          paramInt1 = 0;
        }
        ReportController.b(null, "dc00899", "BizTechReport", "", "kan_dian_skin_pull_refresh", "refresh_times", this.jdField_d_of_type_Int, paramInt1, this.jdField_b_of_type_JavaLangString, null, null, null);
        localObject = this.jdField_c_of_type_JavaLangString;
        if ((localObject != null) && (new File((String)localObject).exists()))
        {
          if (this.jdField_b_of_type_Boolean) {
            paramInt1 = 2;
          } else {
            paramInt1 = 1;
          }
          ReportController.b(null, "dc00899", "BizTechReport", "", "kan_dian_skin_pull_refresh", "sound_play_times", paramInt1, 0, this.jdField_b_of_type_JavaLangString, null, null, null);
        }
        this.jdField_e_of_type_Boolean = false;
      }
    }
  }
  
  public void showPullRefresh()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetIPullRefreshHeader == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetIPullRefreshHeader.a(0L);
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetIPullRefreshHeader instanceof SkinPullRefreshHeader)) {
      ((SkinPullRefreshHeader)this.jdField_a_of_type_ComTencentMobileqqWidgetIPullRefreshHeader).a(false, "");
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetIPullRefreshHeader.f();
    if ((this.jdField_a_of_type_ComTencentMobileqqKandianBizSkinSlideActiveAnimController != null) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizSkinSlideActiveAnimController.b())) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizSkinSlideActiveAnimController.a((SkinPullRefreshHeader)this.jdField_a_of_type_ComTencentMobileqqWidgetIPullRefreshHeader);
    }
    ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
    int n;
    if (localArrayList != null) {
      n = localArrayList.size();
    } else {
      n = 0;
    }
    int m;
    if ((n > 0) && (this.jdField_d_of_type_Int == 1))
    {
      int i1 = this.jdField_i_of_type_Int * 100 / this.jdField_b_of_type_Int;
      m = 0;
      while (m < n)
      {
        if (((ReadInJoySkinAnimManager.PngWrapper)this.jdField_a_of_type_JavaUtilArrayList.get(m)).jdField_a_of_type_Int >= i1) {
          break label178;
        }
        m += 1;
      }
      m = 0;
      label178:
      this.jdField_e_of_type_Int = m;
      a(((ReadInJoySkinAnimManager.PngWrapper)this.jdField_a_of_type_JavaUtilArrayList.get(m)).jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    }
    else if ((n > 0) && (this.jdField_d_of_type_Int == 2))
    {
      double d1 = Math.random();
      double d2 = n;
      Double.isNaN(d2);
      this.jdField_e_of_type_Int = ((int)Math.floor(d1 * d2));
      m = this.jdField_e_of_type_Int;
      this.jdField_f_of_type_Int = m;
      a(((ReadInJoySkinAnimManager.PngWrapper)this.jdField_a_of_type_JavaUtilArrayList.get(m)).jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    }
    else if ((n > 0) && (this.jdField_d_of_type_Int == 3))
    {
      this.jdField_e_of_type_Int = 0;
      ((SkinPullRefreshHeader)this.jdField_a_of_type_ComTencentMobileqqWidgetIPullRefreshHeader).removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      ((SkinPullRefreshHeader)this.jdField_a_of_type_ComTencentMobileqqWidgetIPullRefreshHeader).post(this.jdField_a_of_type_JavaLangRunnable);
    }
    this.jdField_c_of_type_Boolean = false;
  }
  
  public void showRefreshResult(boolean paramBoolean, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetIPullRefreshHeader == null) {
      return;
    }
    if ((paramBoolean) && (!TextUtils.isEmpty(paramString)))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetIPullRefreshHeader.a(0, paramString);
      return;
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetIPullRefreshHeader.a(0);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetIPullRefreshHeader.a(2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.skin.ReadInJoySkinAnimManager
 * JD-Core Version:    0.7.0.1
 */