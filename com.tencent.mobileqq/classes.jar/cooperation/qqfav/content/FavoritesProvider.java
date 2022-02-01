package cooperation.qqfav.content;

import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqfav.QfavHelper;
import java.util.HashMap;
import java.util.Map;
import mqq.app.AppContentProvider;

public class FavoritesProvider
  extends AppContentProvider
  implements Favorites
{
  private UriMatcher jdField_a_of_type_AndroidContentUriMatcher;
  private String jdField_a_of_type_JavaLangString;
  private Map<Integer, Favorites.IProxy> jdField_a_of_type_JavaUtilMap;
  
  private Favorites.IProxy a(Uri paramUri)
  {
    int i1 = this.jdField_a_of_type_AndroidContentUriMatcher.match(paramUri);
    if (i1 == -1)
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("getProxy| mismatch! uri=");
        ((StringBuilder)localObject1).append(paramUri.toString());
        QLog.e("qqfav|FavoritesProvider", 2, ((StringBuilder)localObject1).toString());
      }
      return null;
    }
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    long l = Thread.currentThread().getId();
    int i = 1;
    int k;
    if (l == 1L) {
      k = 1;
    } else {
      k = 0;
    }
    Object localObject1 = null;
    int m = 0;
    while (((localBaseApplicationImpl == null) || (localObject1 == null)) && (k == 0) && (m < 10))
    {
      try
      {
        Thread.sleep(30L);
      }
      catch (InterruptedException localInterruptedException)
      {
        localInterruptedException.printStackTrace();
      }
      localBaseApplicationImpl = BaseApplicationImpl.getApplication();
      Object localObject2 = localObject1;
      int n = i;
      if (localBaseApplicationImpl != null)
      {
        int j = i;
        if (i != 0)
        {
          QfavHelper.a(false);
          j = 0;
        }
        localObject2 = localObject1;
        n = j;
        if (QfavHelper.a())
        {
          localObject2 = localBaseApplicationImpl.getRuntime();
          n = j;
        }
      }
      m += 1;
      localObject1 = localObject2;
      i = n;
    }
    if (localBaseApplicationImpl != null)
    {
      if (localObject1 == null) {
        return null;
      }
      paramUri = paramUri.getLastPathSegment();
      if (this.jdField_a_of_type_JavaLangString.equals(paramUri))
      {
        localObject1 = (Favorites.IProxy)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(i1));
        if (localObject1 != null)
        {
          if (i1 != 100)
          {
            if ((i1 == 101) && (localObject1.getClass().getSimpleName().equals("com.qqfav.data.BizRelatedData$GlobalSearchProxy"))) {
              return localObject1;
            }
          }
          else if (localObject1.getClass().getSimpleName().equals("com.qqfav.data.BizRelatedData$Proxy")) {
            return localObject1;
          }
        }
        else if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("getProxy|match cacheuin but provider null, match=");
          ((StringBuilder)localObject1).append(i1);
          ((StringBuilder)localObject1).append(",uin=");
          ((StringBuilder)localObject1).append(paramUri);
          QLog.e("qqfav|FavoritesProvider", 2, ((StringBuilder)localObject1).toString());
        }
      }
      else
      {
        this.jdField_a_of_type_JavaUtilMap.clear();
        this.jdField_a_of_type_JavaLangString = paramUri;
        if (QLog.isDevelopLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("getProxy|cache uin unmatch, match=");
          ((StringBuilder)localObject1).append(i1);
          ((StringBuilder)localObject1).append(",uin=");
          ((StringBuilder)localObject1).append(paramUri);
          QLog.e("qqfav|FavoritesProvider", 4, ((StringBuilder)localObject1).toString());
        }
      }
      if (i1 != 100)
      {
        if (i1 != 101) {
          return null;
        }
        paramUri = (Favorites.IProxy)QfavHelper.a("com.qqfav.data.BizRelatedData$GlobalSearchProxy", null, null);
      }
      else
      {
        paramUri = (Favorites.IProxy)QfavHelper.a("com.qqfav.data.BizRelatedData$Proxy", null, null);
      }
      if (paramUri != null)
      {
        this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(i1), paramUri);
        return paramUri;
      }
      if (QLog.isColorLevel()) {
        QLog.e("qqfav|FavoritesProvider", 2, "getProxy|never should goto here");
      }
    }
    return null;
  }
  
  public int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    Favorites.IProxy localIProxy = a(paramUri);
    if (localIProxy != null) {
      return localIProxy.delete(paramUri, paramString, paramArrayOfString);
    }
    return 0;
  }
  
  public String getType(Uri paramUri)
  {
    return null;
  }
  
  public Uri insert(Uri paramUri, ContentValues paramContentValues)
  {
    Favorites.IProxy localIProxy = a(paramUri);
    if (localIProxy != null) {
      return localIProxy.insert(paramUri, paramContentValues);
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
    Favorites.IProxy localIProxy = a(paramUri);
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("query|");
      localStringBuilder.append(localIProxy);
      localStringBuilder.append(",uri=");
      localStringBuilder.append(paramUri);
      localStringBuilder.append(",selection=");
      localStringBuilder.append(paramString1);
      QLog.d("qqfav|FavoritesProvider", 4, localStringBuilder.toString());
    }
    if (localIProxy != null) {
      return localIProxy.query(paramUri, paramArrayOfString1, paramString1, paramArrayOfString2, paramString2);
    }
    return null;
  }
  
  public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    Favorites.IProxy localIProxy = a(paramUri);
    if (localIProxy != null) {
      return localIProxy.update(paramUri, paramContentValues, paramString, paramArrayOfString);
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.qqfav.content.FavoritesProvider
 * JD-Core Version:    0.7.0.1
 */