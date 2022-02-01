import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ngl
  implements aqdj
{
  public static String a;
  private aqdg jdField_a_of_type_Aqdg;
  private ngn jdField_a_of_type_Ngn;
  
  public ngl(AppInterface paramAppInterface)
  {
    if ((paramAppInterface instanceof QQAppInterface)) {}
    for (this.jdField_a_of_type_Aqdg = ((aqdg)paramAppInterface.getManager(QQManagerFactory.ARMAP_RES_DOWNLOAD));; this.jdField_a_of_type_Aqdg = new aqdg(paramAppInterface))
    {
      this.jdField_a_of_type_Aqdg.a(this);
      return;
    }
  }
  
  public static URLDrawable a(String paramString)
  {
    paramString = c() + paramString;
    if (QLog.isColorLevel()) {
      QLog.d("AvGameResDownloadManager", 2, "getDrawableByImageName path = " + paramString);
    }
    if (!FileUtils.fileExists(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AvGameResDownloadManager", 2, "getDrawableByImageName return null,path = " + paramString);
      }
      return null;
    }
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mFailedDrawable = new ColorDrawable(0);
    localURLDrawableOptions.mLoadingDrawable = new ColorDrawable(0);
    paramString = URLDrawable.getDrawable(new File(paramString), localURLDrawableOptions);
    paramString.downloadImediatly(true);
    return paramString;
  }
  
  public static String a()
  {
    if (TextUtils.isEmpty(jdField_a_of_type_JavaLangString)) {
      jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getSharedPreferences("av_game_sp", 4).getString("resPath", jdField_a_of_type_JavaLangString);
    }
    return jdField_a_of_type_JavaLangString + "lottie" + File.separator;
  }
  
  private void a(int paramInt, String paramString)
  {
    if (this.jdField_a_of_type_Ngn != null)
    {
      if (paramInt == 0) {
        this.jdField_a_of_type_Ngn.a(paramString);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_Ngn.b(paramInt);
  }
  
  public static String b()
  {
    if (TextUtils.isEmpty(jdField_a_of_type_JavaLangString)) {
      jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getSharedPreferences("av_game_sp", 4).getString("resPath", jdField_a_of_type_JavaLangString);
    }
    return jdField_a_of_type_JavaLangString + "sounds" + File.separator;
  }
  
  public static String c()
  {
    if (TextUtils.isEmpty(jdField_a_of_type_JavaLangString)) {
      jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getSharedPreferences("av_game_sp", 4).getString("resPath", jdField_a_of_type_JavaLangString);
    }
    return jdField_a_of_type_JavaLangString + "images" + File.separator;
  }
  
  public static String d()
  {
    if (TextUtils.isEmpty(jdField_a_of_type_JavaLangString)) {
      jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getSharedPreferences("av_game_sp", 4).getString("resPath", jdField_a_of_type_JavaLangString);
    }
    return jdField_a_of_type_JavaLangString + "fonts" + File.separator;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Ngn = null;
    this.jdField_a_of_type_Aqdg.b(this);
  }
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AvGameResDownloadManager", 2, "onDownloadUpdate,url =   " + paramString1 + ",md5 = " + paramString2 + ",percent = " + paramInt);
    }
    if (this.jdField_a_of_type_Ngn != null) {
      this.jdField_a_of_type_Ngn.a(paramInt);
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt, String paramString3, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AvGameResDownloadManager", 2, "onDownloadFinish,url =   " + paramString1 + ",md5 = " + paramString2 + ",errCode = " + paramInt + ",path = " + paramString3 + ",userData = " + paramObject);
    }
    if (paramString3.endsWith("/")) {}
    for (;;)
    {
      a(paramInt, paramString3);
      return;
      paramString3 = paramString3 + File.separator;
    }
  }
  
  public void a(List<nfh> paramList, String paramString, boolean paramBoolean)
  {
    if (paramList != null) {}
    for (;;)
    {
      int i;
      try
      {
        if ((paramList.size() < 1) || (((ngf)paramList.get(0)).b == null))
        {
          QLog.d("AvGameResDownloadManager", 1, "startDownload() topicList is empty just return");
          return;
        }
        ngp.a();
        i = 0;
        if (i >= paramList.size()) {
          continue;
        }
        Iterator localIterator = ((ngf)paramList.get(i)).b.iterator();
        if (!localIterator.hasNext()) {
          break label212;
        }
        nfu localnfu = (nfu)localIterator.next();
        String str1 = localnfu.b();
        String str2 = ngp.a(str1, paramString);
        if ((FileUtils.fileExists(str2)) || (TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(localnfu.a())))
        {
          QLog.d("AvGameResDownloadManager", 1, String.format("startDownload() [isExist,avResUrl,avResMd5] %b , %s , %s", new Object[] { Boolean.valueOf(FileUtils.fileExists(str2)), localnfu.a(), str1 }));
          continue;
        }
        this.jdField_a_of_type_Aqdg.a(localnfu.a(), str1, paramString, paramBoolean, 6);
      }
      finally {}
      continue;
      label212:
      i += 1;
    }
  }
  
  public void a(ngo paramngo)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("AvGameResDownloadManager", 2, "startDownload res...");
      }
      this.jdField_a_of_type_Aqdg.a(paramngo.jdField_a_of_type_JavaLangString, paramngo.b, ".zip", true, 6);
      return;
    }
    finally {}
  }
  
  public void a(ngo paramngo, ngn paramngn)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("checkResDownloadReady resUrl is ");
      if (paramngo != null) {
        break label134;
      }
      str = "emptyUrl";
      localStringBuilder = localStringBuilder.append(str).append(" resMd5 is ");
      if (paramngo != null) {
        break label142;
      }
    }
    label134:
    label142:
    for (String str = "emptyMd5";; str = paramngo.b)
    {
      QLog.d("AvGameResDownloadManager", 2, str);
      this.jdField_a_of_type_Ngn = paramngn;
      if ((paramngo != null) && (!TextUtils.isEmpty(paramngo.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(paramngo.b))) {
        break label150;
      }
      if (QLog.isColorLevel()) {
        QLog.i("AvGameResDownloadManager", 2, "need pull config");
      }
      ((aqzv)aqxe.a().a(642)).a(new ngm(this));
      return;
      str = paramngo.jdField_a_of_type_JavaLangString;
      break;
    }
    label150:
    a(paramngo);
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AvGameResDownloadManager", 2, "onDownloadStart()");
    }
    if (this.jdField_a_of_type_Ngn != null) {
      this.jdField_a_of_type_Ngn.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ngl
 * JD-Core Version:    0.7.0.1
 */