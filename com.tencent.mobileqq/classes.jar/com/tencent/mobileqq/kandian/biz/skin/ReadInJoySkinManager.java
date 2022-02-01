package com.tencent.mobileqq.kandian.biz.skin;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.SparseArray;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.kandian.biz.skin.entity.BaseResData;
import com.tencent.mobileqq.kandian.biz.skin.entity.SkinData;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.surfaceviewaction.builder.SceneBuilder;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloaderInterface;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.app.MobileQQ;
import org.json.JSONObject;

public class ReadInJoySkinManager
  extends ReadInJoyBaseResManager
{
  protected int a;
  protected Handler a;
  protected SparseArray<BaseSkinRes[]> a;
  protected String a;
  protected ArrayList<ReadInJoySkinManager.OnSkinChangedListener> b = new ArrayList();
  
  public ReadInJoySkinManager(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    a(3, new BaseSkinRes[] { new BaseSkinRes(), new ReadInJoySkinManager.1(this) });
    a(2, new BaseSkinRes[] { new BaseSkinRes(), new ReadInJoySkinManager.2(this) });
    a(4, new BaseSkinRes[] { new ReadInJoySkinManager.3(this), new ReadInJoySkinManager.4(this, paramAppInterface) });
    a(5, new BaseSkinRes[] { new ReadInJoySkinManager.5(this), new ReadInJoySkinManager.6(this, paramAppInterface) });
    a(6, new BaseSkinRes[] { new ReadInJoySkinManager.7(this), new ReadInJoySkinManager.8(this, paramAppInterface) });
    a(7, new BaseSkinRes[] { new ReadInJoySkinManager.9(this), new ReadInJoySkinManager.10(this, paramAppInterface) });
    a(8, new BaseSkinRes[] { new ReadInJoySkinManager.11(this), new ReadInJoySkinManager.12(this) });
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public BaseSkinRes a(int paramInt)
  {
    BaseSkinRes[] arrayOfBaseSkinRes = (BaseSkinRes[])this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (arrayOfBaseSkinRes != null)
    {
      paramInt = this.jdField_a_of_type_Int;
      if (paramInt < arrayOfBaseSkinRes.length) {
        return arrayOfBaseSkinRes[paramInt];
      }
    }
    return null;
  }
  
  public SkinData a(Context paramContext)
  {
    paramContext = SharedPreUtils.m(paramContext, this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin());
    SkinData localSkinData = null;
    if (paramContext != null) {}
    try
    {
      paramContext = new JSONObject(paramContext);
    }
    catch (Exception paramContext)
    {
      label30:
      break label30;
    }
    paramContext = null;
    if (paramContext != null) {
      localSkinData = new SkinData(paramContext);
    }
    return localSkinData;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public String a(String paramString)
  {
    if ("skin".equals(paramString)) {
      return CommonSkinRes.a();
    }
    if ("guide".equals(paramString)) {
      return CommonSkinRes.c();
    }
    return CommonSkinRes.c();
  }
  
  public String a(String paramString1, String paramString2)
  {
    if ("skin".equals(paramString1)) {
      return CommonSkinRes.a(paramString2);
    }
    if ("guide".equals(paramString1)) {
      return CommonSkinRes.b(paramString2);
    }
    return CommonSkinRes.b(paramString2);
  }
  
  public void a()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  public void a(int paramInt, BaseSkinRes... paramVarArgs)
  {
    this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, paramVarArgs);
  }
  
  public void a(Context paramContext, String paramString, BaseResData paramBaseResData)
  {
    SharedPreUtils.d(paramContext, paramString, paramBaseResData.seq);
  }
  
  public void a(ReadInJoySkinManager.OnSkinChangedListener paramOnSkinChangedListener)
  {
    synchronized (this.b)
    {
      if (!this.b.contains(paramOnSkinChangedListener)) {
        this.b.add(paramOnSkinChangedListener);
      }
      return;
    }
  }
  
  public void a(String[] paramArrayOfString)
  {
    ReportController.b(null, "dc00899", "BizTechReport", "", "skin_download", "skin_guide", 0, 0, paramArrayOfString[0], paramArrayOfString[1], paramArrayOfString[2], String.valueOf(NetworkUtil.getSystemNetwork(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication())));
  }
  
  public boolean a(GuideData paramGuideData)
  {
    return super.c("guide", paramGuideData);
  }
  
  public boolean a(SkinData paramSkinData)
  {
    return super.c("skin", paramSkinData);
  }
  
  public boolean a(String paramString)
  {
    HashMap localHashMap = this.jdField_a_of_type_JavaUtilHashMap;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("skin_");
    localStringBuilder.append(paramString);
    paramString = (String)localHashMap.remove(localStringBuilder.toString());
    if (paramString != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqVipDownloaderInterface.cancelTask(false, paramString);
      return true;
    }
    return false;
  }
  
  public boolean a(String paramString, BaseResData paramBaseResData)
  {
    int i = a();
    boolean bool = true;
    if (i == 1)
    {
      if (!paramBaseResData.id.equals(a())) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  public boolean a(String paramString1, String paramString2, String paramString3, long paramLong1, long paramLong2, long paramLong3, DownloadListener paramDownloadListener)
  {
    paramString1 = new SkinData(paramString1, paramString3, paramLong1, (int)paramLong2, (int)paramLong3);
    paramString2 = a(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication().getBaseContext());
    if ((paramString2 != null) && (paramString2.id.equals(paramString1.id)) && (paramString2.seq != paramString1.seq) && (!this.jdField_a_of_type_JavaLangString.equals(paramString1.id))) {
      FileUtils.deleteDirectory(CommonSkinRes.a(paramString2.id));
    }
    a(paramDownloadListener);
    return super.a("skin", paramString1, 3);
  }
  
  public void b(ReadInJoySkinManager.OnSkinChangedListener paramOnSkinChangedListener)
  {
    synchronized (this.b)
    {
      this.b.remove(paramOnSkinChangedListener);
      return;
    }
  }
  
  public void b(String paramString, BaseResData paramBaseResData)
  {
    SharedPreUtils.p(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp(), this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), paramBaseResData.id);
    SharedPreUtils.r(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp(), this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin());
  }
  
  public boolean b(String paramString, BaseResData paramBaseResData)
  {
    paramString = a(paramString, paramBaseResData.id);
    long l1 = SharedPreUtils.e(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp(), this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin()) / 86400000L;
    long l2 = System.currentTimeMillis() / 86400000L;
    return (SceneBuilder.a(new File(paramString))) && (CommonSkinRes.a(paramBaseResData.id)) && (!SharedPreUtils.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp(), this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), paramBaseResData.id)) && (l2 > l1);
  }
  
  public boolean c(String paramString, BaseResData paramBaseResData)
  {
    boolean bool2 = paramBaseResData instanceof GuideData;
    boolean bool1 = true;
    if (bool2)
    {
      paramString = (GuideData)paramBaseResData;
      bool1 = a(paramString) & true & a(paramString.skinData);
    }
    return bool1;
  }
  
  public void onDestroy()
  {
    this.b.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.skin.ReadInJoySkinManager
 * JD-Core Version:    0.7.0.1
 */