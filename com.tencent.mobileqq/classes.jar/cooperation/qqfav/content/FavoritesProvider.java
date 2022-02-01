package cooperation.qqfav.content;

import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import bmaf;
import bmas;
import bmat;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import mqq.app.AppContentProvider;

public class FavoritesProvider
  extends AppContentProvider
  implements bmas
{
  private UriMatcher jdField_a_of_type_AndroidContentUriMatcher;
  private String jdField_a_of_type_JavaLangString;
  private Map<Integer, bmat> jdField_a_of_type_JavaUtilMap;
  
  private bmat a(Uri paramUri)
  {
    int i = 1;
    int i1 = this.jdField_a_of_type_AndroidContentUriMatcher.match(paramUri);
    if (i1 == -1)
    {
      if (QLog.isColorLevel()) {
        QLog.e("qqfav|FavoritesProvider", 2, "getProxy| mismatch! uri=" + paramUri.toString());
      }
      return null;
    }
    Object localObject2 = BaseApplicationImpl.getApplication();
    int k;
    if (Thread.currentThread().getId() == 1L) {
      k = 1;
    }
    Object localObject1;
    for (;;)
    {
      int m = 0;
      localObject1 = null;
      label79:
      if (((localObject2 == null) || (localObject1 == null)) && (k == 0) && (m < 10)) {
        try
        {
          Thread.sleep(30L);
          BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
          int n = i;
          localObject2 = localObject1;
          if (localBaseApplicationImpl != null)
          {
            int j = i;
            if (i != 0)
            {
              bmaf.a(false);
              j = 0;
            }
            n = j;
            localObject2 = localObject1;
            if (bmaf.a())
            {
              localObject2 = localBaseApplicationImpl.getRuntime();
              n = j;
            }
          }
          m += 1;
          i = n;
          localObject1 = localObject2;
          localObject2 = localBaseApplicationImpl;
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
    if ((localInterruptedException == null) || (localObject1 == null)) {
      return null;
    }
    paramUri = paramUri.getLastPathSegment();
    if (this.jdField_a_of_type_JavaLangString.equals(paramUri))
    {
      localObject1 = (bmat)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(i1));
      if (localObject1 != null) {
        switch (i1)
        {
        }
      }
    }
    for (;;)
    {
      switch (i1)
      {
      default: 
        return null;
        if (localObject1.getClass().getSimpleName().equals("com.qqfav.data.BizRelatedData$Proxy"))
        {
          return localObject1;
          if (localObject1.getClass().getSimpleName().equals("com.qqfav.data.BizRelatedData$GlobalSearchProxy"))
          {
            return localObject1;
            if (QLog.isColorLevel())
            {
              QLog.e("qqfav|FavoritesProvider", 2, "getProxy|match cacheuin but provider null, match=" + i1 + ",uin=" + paramUri);
              continue;
              this.jdField_a_of_type_JavaUtilMap.clear();
              this.jdField_a_of_type_JavaLangString = paramUri;
              if (QLog.isDevelopLevel()) {
                QLog.e("qqfav|FavoritesProvider", 4, "getProxy|cache uin unmatch, match=" + i1 + ",uin=" + paramUri);
              }
            }
          }
        }
        break;
      }
    }
    for (paramUri = (bmat)bmaf.a("com.qqfav.data.BizRelatedData$Proxy", null, null); paramUri != null; paramUri = (bmat)bmaf.a("com.qqfav.data.BizRelatedData$GlobalSearchProxy", null, null))
    {
      this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(i1), paramUri);
      return paramUri;
    }
    if (QLog.isColorLevel()) {
      QLog.e("qqfav|FavoritesProvider", 2, "getProxy|never should goto here");
    }
    return null;
  }
  
  public int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    bmat localbmat = a(paramUri);
    if (localbmat != null) {
      return localbmat.delete(paramUri, paramString, paramArrayOfString);
    }
    return 0;
  }
  
  public String getType(Uri paramUri)
  {
    return null;
  }
  
  public Uri insert(Uri paramUri, ContentValues paramContentValues)
  {
    bmat localbmat = a(paramUri);
    if (localbmat != null) {
      return localbmat.insert(paramUri, paramContentValues);
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
    bmat localbmat = a(paramUri);
    if (QLog.isDevelopLevel()) {
      QLog.d("qqfav|FavoritesProvider", 4, "query|" + localbmat + ",uri=" + paramUri + ",selection=" + paramString1);
    }
    if (localbmat != null) {
      return localbmat.query(paramUri, paramArrayOfString1, paramString1, paramArrayOfString2, paramString2);
    }
    return null;
  }
  
  public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    bmat localbmat = a(paramUri);
    if (localbmat != null) {
      return localbmat.update(paramUri, paramContentValues, paramString, paramArrayOfString);
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     cooperation.qqfav.content.FavoritesProvider
 * JD-Core Version:    0.7.0.1
 */