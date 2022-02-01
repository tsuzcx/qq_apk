package cooperation.qqfav.content;

import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import bmkq;
import bmld;
import bmle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import mqq.app.AppContentProvider;

public class FavoritesProvider
  extends AppContentProvider
  implements bmld
{
  private UriMatcher jdField_a_of_type_AndroidContentUriMatcher;
  private String jdField_a_of_type_JavaLangString;
  private Map<Integer, bmle> jdField_a_of_type_JavaUtilMap;
  
  private bmle a(Uri paramUri)
  {
    int i = 1;
    int n = this.jdField_a_of_type_AndroidContentUriMatcher.match(paramUri);
    if (n == -1)
    {
      if (QLog.isColorLevel()) {
        QLog.e("qqfav|FavoritesProvider", 2, "getProxy| mismatch! uri=" + paramUri.toString());
      }
      return null;
    }
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    int k;
    if (Thread.currentThread().getId() == 1L) {
      k = 1;
    }
    Object localObject;
    for (;;)
    {
      int m = 0;
      localObject = null;
      label79:
      if (((localBaseApplicationImpl == null) || (localObject == null)) && (k == 0) && (m < 10)) {
        try
        {
          Thread.sleep(30L);
          localBaseApplicationImpl = BaseApplicationImpl.getApplication();
          int j = i;
          if (localBaseApplicationImpl != null)
          {
            j = i;
            if (i != 0)
            {
              bmkq.a(false);
              j = 0;
            }
            localObject = localBaseApplicationImpl.getRuntime();
          }
          m += 1;
          i = j;
          break label79;
          k = 0;
        }
        catch (InterruptedException localInterruptedException)
        {
          for (;;)
          {
            localInterruptedException.printStackTrace();
          }
        }
      }
    }
    if ((localInterruptedException == null) || (localObject == null)) {
      return null;
    }
    paramUri = paramUri.getLastPathSegment();
    if (this.jdField_a_of_type_JavaLangString.equals(paramUri))
    {
      localObject = (bmle)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(n));
      if (localObject != null) {
        switch (n)
        {
        }
      }
    }
    for (;;)
    {
      switch (n)
      {
      default: 
        return null;
        if (localObject.getClass().getSimpleName().equals("com.qqfav.data.BizRelatedData$Proxy"))
        {
          return localObject;
          if (localObject.getClass().getSimpleName().equals("com.qqfav.data.BizRelatedData$GlobalSearchProxy"))
          {
            return localObject;
            if (QLog.isColorLevel())
            {
              QLog.e("qqfav|FavoritesProvider", 2, "getProxy|match cacheuin but provider null, match=" + n + ",uin=" + paramUri);
              continue;
              this.jdField_a_of_type_JavaUtilMap.clear();
              this.jdField_a_of_type_JavaLangString = paramUri;
              if (QLog.isDevelopLevel()) {
                QLog.e("qqfav|FavoritesProvider", 4, "getProxy|cache uin unmatch, match=" + n + ",uin=" + paramUri);
              }
            }
          }
        }
        break;
      }
    }
    for (paramUri = (bmle)bmkq.a("com.qqfav.data.BizRelatedData$Proxy", null, null); paramUri != null; paramUri = (bmle)bmkq.a("com.qqfav.data.BizRelatedData$GlobalSearchProxy", null, null))
    {
      this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(n), paramUri);
      return paramUri;
    }
    if (QLog.isColorLevel()) {
      QLog.e("qqfav|FavoritesProvider", 2, "getProxy|never should goto here");
    }
    return null;
  }
  
  public int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    bmle localbmle = a(paramUri);
    if (localbmle != null) {
      return localbmle.delete(paramUri, paramString, paramArrayOfString);
    }
    return 0;
  }
  
  public String getType(Uri paramUri)
  {
    return null;
  }
  
  public Uri insert(Uri paramUri, ContentValues paramContentValues)
  {
    bmle localbmle = a(paramUri);
    if (localbmle != null) {
      return localbmle.insert(paramUri, paramContentValues);
    }
    return null;
  }
  
  public boolean onCreate()
  {
    super.onCreate();
    this.jdField_a_of_type_AndroidContentUriMatcher = new UriMatcher(-1);
    this.jdField_a_of_type_AndroidContentUriMatcher.addURI("qq.favorites", "biz_related/#", 100);
    this.jdField_a_of_type_AndroidContentUriMatcher.addURI("qq.favorites", "global_search/#", 101);
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_JavaLangString = "";
    return true;
  }
  
  public Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    bmle localbmle = a(paramUri);
    if (QLog.isDevelopLevel()) {
      QLog.d("qqfav|FavoritesProvider", 4, "query|" + localbmle + ",uri=" + paramUri + ",selection=" + paramString1);
    }
    if (localbmle != null) {
      return localbmle.query(paramUri, paramArrayOfString1, paramString1, paramArrayOfString2, paramString2);
    }
    return null;
  }
  
  public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    bmle localbmle = a(paramUri);
    if (localbmle != null) {
      return localbmle.update(paramUri, paramContentValues, paramString, paramArrayOfString);
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     cooperation.qqfav.content.FavoritesProvider
 * JD-Core Version:    0.7.0.1
 */