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

public class mzu
  implements aqgu
{
  public static String a;
  private aqgr jdField_a_of_type_Aqgr;
  private mzw jdField_a_of_type_Mzw;
  
  public mzu(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_Aqgr = new aqgr(paramAppInterface);
    this.jdField_a_of_type_Aqgr.a(this);
  }
  
  public static URLDrawable a(String paramString)
  {
    paramString = c() + paramString;
    if (QLog.isColorLevel()) {
      QLog.d("AvGameResDownloadManager", 2, "getDrawableByImageName path = " + paramString);
    }
    if (!bhmi.a(paramString))
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
    if (this.jdField_a_of_type_Mzw != null)
    {
      if (paramInt == 0) {
        this.jdField_a_of_type_Mzw.a(paramString);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_Mzw.b(paramInt);
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
    this.jdField_a_of_type_Mzw = null;
    this.jdField_a_of_type_Aqgr.b(this);
  }
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AvGameResDownloadManager", 2, "onDownloadUpdate,url =   " + paramString1 + ",md5 = " + paramString2 + ",percent = " + paramInt);
    }
    if (this.jdField_a_of_type_Mzw != null) {
      this.jdField_a_of_type_Mzw.a(paramInt);
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
  
  public void a(List<myp> paramList, String paramString, boolean paramBoolean)
  {
    if (paramList != null) {}
    for (;;)
    {
      int i;
      try
      {
        if ((paramList.size() < 1) || (((mzo)paramList.get(0)).b == null))
        {
          QLog.d("AvGameResDownloadManager", 1, "startDownload() topicList is empty just return");
          return;
        }
        mzy.a();
        i = 0;
        if (i >= paramList.size()) {
          continue;
        }
        Iterator localIterator = ((mzo)paramList.get(i)).b.iterator();
        if (!localIterator.hasNext()) {
          break label212;
        }
        mzd localmzd = (mzd)localIterator.next();
        String str1 = localmzd.b();
        String str2 = mzy.a(str1, paramString);
        if ((bhmi.a(str2)) || (TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(localmzd.a())))
        {
          QLog.d("AvGameResDownloadManager", 1, String.format("startDownload() [isExist,avResUrl,avResMd5] %b , %s , %s", new Object[] { Boolean.valueOf(bhmi.a(str2)), localmzd.a(), str1 }));
          continue;
        }
        this.jdField_a_of_type_Aqgr.a(localmzd.a(), str1, paramString, paramBoolean, 6);
      }
      finally {}
      continue;
      label212:
      i += 1;
    }
  }
  
  public void a(mzx parammzx)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("AvGameResDownloadManager", 2, "startDownload res...");
      }
      this.jdField_a_of_type_Aqgr.a(parammzx.jdField_a_of_type_JavaLangString, parammzx.b, ".zip", true, 6);
      return;
    }
    finally {}
  }
  
  public void a(mzx parammzx, mzw parammzw)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("checkResDownloadReady resUrl is ");
      if (parammzx != null) {
        break label129;
      }
      str = "emptyUrl";
      localStringBuilder = localStringBuilder.append(str).append(" resMd5 is ");
      if (parammzx != null) {
        break label137;
      }
    }
    label129:
    label137:
    for (String str = "emptyMd5";; str = parammzx.b)
    {
      QLog.d("AvGameResDownloadManager", 2, str);
      this.jdField_a_of_type_Mzw = parammzw;
      if ((!TextUtils.isEmpty(parammzx.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(parammzx.b))) {
        break label145;
      }
      if (QLog.isColorLevel()) {
        QLog.i("AvGameResDownloadManager", 2, "need pull config");
      }
      ((ardc)aran.a().a(642)).a(new mzv(this));
      return;
      str = parammzx.jdField_a_of_type_JavaLangString;
      break;
    }
    label145:
    a(parammzx);
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AvGameResDownloadManager", 2, "onDownloadStart()");
    }
    if (this.jdField_a_of_type_Mzw != null) {
      this.jdField_a_of_type_Mzw.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mzu
 * JD-Core Version:    0.7.0.1
 */