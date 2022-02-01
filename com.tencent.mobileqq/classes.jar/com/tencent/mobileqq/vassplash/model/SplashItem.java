package com.tencent.mobileqq.vassplash.model;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.vassplash.common.VasSplashUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class SplashItem
{
  public int a;
  public String a;
  public boolean a;
  public int b;
  public String b;
  public boolean b;
  public int c;
  public String c;
  public int d;
  public String d;
  public int e;
  public String e;
  public String f = "";
  public String g = "";
  public String h;
  public String i;
  public String j;
  public String k;
  public String l = "-1";
  public String m;
  public String n;
  public String o;
  
  public SplashItem(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, String paramString5, int paramInt2, String paramString6, int paramInt3, String paramString7, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString8, int paramInt4, String paramString9, String paramString10, int paramInt5, String paramString11)
  {
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_d_of_type_JavaLangString = "";
    this.jdField_a_of_type_Int = -1;
    this.jdField_e_of_type_JavaLangString = "";
    this.jdField_b_of_type_Int = -1;
    this.jdField_c_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_c_of_type_JavaLangString = paramString3;
    this.jdField_d_of_type_JavaLangString = paramString4;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_e_of_type_JavaLangString = paramString5;
    this.jdField_b_of_type_Int = paramInt2;
    this.f = paramString6;
    this.jdField_c_of_type_Int = paramInt3;
    this.g = paramString7;
    this.jdField_a_of_type_Boolean = paramBoolean1;
    this.jdField_b_of_type_Boolean = paramBoolean3;
    this.h = paramString8;
    this.jdField_d_of_type_Int = paramInt4;
    this.j = paramString9;
    this.k = paramString10;
    this.jdField_e_of_type_Int = paramInt5;
    this.l = paramString11;
  }
  
  private boolean a(String paramString)
  {
    SharedPreferences localSharedPreferences = VasSplashUtil.a(BaseApplicationImpl.getContext(), this.jdField_a_of_type_JavaLangString);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("splash_union_banner_res_path_");
    localStringBuilder.append(paramString);
    paramString = localSharedPreferences.getString(localStringBuilder.toString(), "");
    if (!TextUtils.isEmpty(paramString)) {
      return a(paramString, true);
    }
    return false;
  }
  
  public static boolean a(String paramString, boolean paramBoolean)
  {
    boolean bool = false;
    try
    {
      paramString = new File(paramString);
      if (paramString.exists())
      {
        if (paramBoolean)
        {
          paramBoolean = paramString.getAbsolutePath().endsWith(".splashtemp");
          return paramBoolean ^ true;
        }
        bool = true;
      }
      return bool;
    }
    catch (Exception paramString) {}
    return false;
  }
  
  public boolean a()
  {
    boolean bool1;
    if ((this.jdField_b_of_type_Boolean) && (a(this.h, true))) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    boolean bool2 = bool1;
    if (bool1)
    {
      bool2 = bool1;
      if (c())
      {
        bool2 = bool1;
        if (!a(this.jdField_b_of_type_JavaLangString))
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("adid [");
          localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
          localStringBuilder.append("] union banner res not ready.");
          QLog.i("QSplash@SplashItem", 1, localStringBuilder.toString());
          bool2 = false;
        }
      }
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("adid [");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append("] shouldSplash ");
    localStringBuilder.append(bool2);
    QLog.i("QSplash@SplashItem", 1, localStringBuilder.toString());
    return bool2;
  }
  
  public boolean b()
  {
    boolean bool;
    if ((!a(this.h, true)) && (!this.jdField_a_of_type_Boolean) && (!VasSplashUtil.a(this.jdField_d_of_type_JavaLangString))) {
      bool = true;
    } else {
      bool = false;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("adid [");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append("] shouldRequestRes result = ");
    localStringBuilder.append(bool);
    QLog.i("QSplash@VasSplashUtil", 1, localStringBuilder.toString());
    return bool;
  }
  
  public boolean c()
  {
    return ("1".equals(this.l)) || ("2".equals(this.l));
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SplashADEntry{, mAdID='");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mBeginTime='");
    localStringBuilder.append(this.jdField_c_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mEndTime='");
    localStringBuilder.append(this.jdField_d_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mContentType=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", mDownloadUrl='");
    localStringBuilder.append(this.jdField_e_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mJumpType=");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuilder.append(", mJumpH5Url='");
    localStringBuilder.append(this.f);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mExposureUrl='");
    localStringBuilder.append(this.g);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mResPath='");
    localStringBuilder.append(this.h);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mVideoPath='");
    localStringBuilder.append(this.i);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mShowpriority");
    localStringBuilder.append(this.jdField_d_of_type_Int);
    localStringBuilder.append('\'');
    localStringBuilder.append(", isLowerDeviceLimit=");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mCanShow=");
    localStringBuilder.append(this.jdField_b_of_type_Boolean);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mResTraceinfo=");
    localStringBuilder.append(this.j);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mResMD5=");
    localStringBuilder.append(this.k);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mShowAdMark=");
    localStringBuilder.append(this.jdField_e_of_type_Int);
    localStringBuilder.append(", mBannerType=");
    localStringBuilder.append(this.l);
    localStringBuilder.append(", mEntryText=");
    localStringBuilder.append(this.m);
    localStringBuilder.append(", mEntryTextColor=");
    localStringBuilder.append(this.n);
    localStringBuilder.append(", mEntryBgColor=");
    localStringBuilder.append(this.o);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vassplash.model.SplashItem
 * JD-Core Version:    0.7.0.1
 */