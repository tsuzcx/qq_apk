import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class myr
  implements apte
{
  public static String a;
  private aptb jdField_a_of_type_Aptb;
  private myt jdField_a_of_type_Myt;
  
  public myr(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_Aptb = new aptb(paramAppInterface);
    this.jdField_a_of_type_Aptb.a(this);
  }
  
  public static URLDrawable a(String paramString)
  {
    paramString = c() + paramString;
    if (QLog.isColorLevel()) {
      QLog.d("AvGameResDownloadManager", 2, "getDrawableByImageName path = " + paramString);
    }
    if (!bgmg.a(paramString))
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
    if (this.jdField_a_of_type_Myt != null)
    {
      if (paramInt == 0) {
        this.jdField_a_of_type_Myt.a(paramString);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_Myt.b(paramInt);
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
  
  public void a()
  {
    this.jdField_a_of_type_Myt = null;
    this.jdField_a_of_type_Aptb.b(this);
  }
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AvGameResDownloadManager", 2, "onDownloadUpdate,url =   " + paramString1 + ",md5 = " + paramString2 + ",percent = " + paramInt);
    }
    if (this.jdField_a_of_type_Myt != null) {
      this.jdField_a_of_type_Myt.a(paramInt);
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
  
  public void a(List<mxq> paramList, String paramString, boolean paramBoolean)
  {
    if (paramList != null) {}
    for (;;)
    {
      int i;
      try
      {
        if ((paramList.size() < 1) || (((myl)paramList.get(0)).b == null))
        {
          QLog.d("AvGameResDownloadManager", 1, "startDownload() topicList is empty just return");
          return;
        }
        myv.a();
        i = 0;
        if (i >= paramList.size()) {
          continue;
        }
        Iterator localIterator = ((myl)paramList.get(i)).b.iterator();
        if (!localIterator.hasNext()) {
          break label212;
        }
        myb localmyb = (myb)localIterator.next();
        String str1 = localmyb.b();
        String str2 = myv.a(str1, paramString);
        if ((bgmg.a(str2)) || (TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(localmyb.a())))
        {
          QLog.d("AvGameResDownloadManager", 1, String.format("startDownload() [isExist,avResUrl,avResMd5] %b , %s , %s", new Object[] { Boolean.valueOf(bgmg.a(str2)), localmyb.a(), str1 }));
          continue;
        }
        this.jdField_a_of_type_Aptb.a(localmyb.a(), str1, paramString, paramBoolean, 6);
      }
      finally {}
      continue;
      label212:
      i += 1;
    }
  }
  
  public void a(myu parammyu)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("AvGameResDownloadManager", 2, "startDownload res...");
      }
      this.jdField_a_of_type_Aptb.a(parammyu.jdField_a_of_type_JavaLangString, parammyu.b, ".zip", true, 6);
      return;
    }
    finally {}
  }
  
  public void a(myu parammyu, myt parammyt)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("checkResDownloadReady resUrl is ");
      if (parammyu != null) {
        break label128;
      }
      str = "emptyUrl";
      localStringBuilder = localStringBuilder.append(str).append(" resMd5 is ");
      if (parammyu != null) {
        break label136;
      }
    }
    label128:
    label136:
    for (String str = "emptyMd5";; str = parammyu.b)
    {
      QLog.d("AvGameResDownloadManager", 2, str);
      this.jdField_a_of_type_Myt = parammyt;
      if ((!TextUtils.isEmpty(parammyu.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(parammyu.b))) {
        break label144;
      }
      if (QLog.isColorLevel()) {
        QLog.i("AvGameResDownloadManager", 2, "need pull config");
      }
      ((aqnx)aqlk.a().a(642)).a(new mys(this));
      return;
      str = parammyu.jdField_a_of_type_JavaLangString;
      break;
    }
    label144:
    a(parammyu);
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AvGameResDownloadManager", 2, "onDownloadStart()");
    }
    if (this.jdField_a_of_type_Myt != null) {
      this.jdField_a_of_type_Myt.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     myr
 * JD-Core Version:    0.7.0.1
 */