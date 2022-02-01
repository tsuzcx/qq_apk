package cooperation.qqfav.globalsearch;

import android.database.Cursor;
import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.search.base.engine.ISearchEngine;
import com.tencent.mobileqq.search.base.engine.ISearchListener;
import com.tencent.mobileqq.search.base.model.SearchRequest;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqfav.QfavHelper;
import java.util.ArrayList;
import java.util.List;

public class FavoriteSearchEngine
  implements ISearchEngine<FavoriteSearchResultModel>
{
  private static boolean jdField_a_of_type_Boolean;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private final FavoriteSearchEngine.QueryRunnable jdField_a_of_type_CooperationQqfavGlobalsearchFavoriteSearchEngine$QueryRunnable = new FavoriteSearchEngine.QueryRunnable(this, null);
  private final FavoriteSearchEngine.SearchRunnable jdField_a_of_type_CooperationQqfavGlobalsearchFavoriteSearchEngine$SearchRunnable = new FavoriteSearchEngine.SearchRunnable(this, null);
  private String jdField_a_of_type_JavaLangString;
  private Thread jdField_a_of_type_JavaLangThread;
  private List<FavoriteSearchResultModel> jdField_a_of_type_JavaUtilList = new ArrayList();
  private Thread b;
  
  public FavoriteSearchEngine(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  /* Error */
  public static void a(com.tencent.common.app.AppInterface paramAppInterface)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 58	com/tencent/common/app/AppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   4: invokevirtual 64	mqq/app/MobileQQ:getContentResolver	()Landroid/content/ContentResolver;
    //   7: astore_1
    //   8: new 66	java/lang/StringBuilder
    //   11: dup
    //   12: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   15: astore_2
    //   16: aload_2
    //   17: ldc 69
    //   19: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: pop
    //   23: aload_2
    //   24: aload_0
    //   25: invokevirtual 77	com/tencent/common/app/AppInterface:getAccount	()Ljava/lang/String;
    //   28: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: pop
    //   32: aload_2
    //   33: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   36: invokestatic 86	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   39: astore_0
    //   40: aload_1
    //   41: aload_0
    //   42: aconst_null
    //   43: aconst_null
    //   44: aconst_null
    //   45: aconst_null
    //   46: invokevirtual 92	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   49: astore_0
    //   50: aload_0
    //   51: ifnull +24 -> 75
    //   54: aload_0
    //   55: invokeinterface 97 1 0
    //   60: return
    //   61: astore_0
    //   62: goto +14 -> 76
    //   65: astore_0
    //   66: ldc 99
    //   68: iconst_1
    //   69: ldc 101
    //   71: aload_0
    //   72: invokestatic 107	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   75: return
    //   76: aload_0
    //   77: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	78	0	paramAppInterface	com.tencent.common.app.AppInterface
    //   7	34	1	localContentResolver	android.content.ContentResolver
    //   15	18	2	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   40	50	61	finally
    //   66	75	61	finally
    //   40	50	65	java/lang/Exception
  }
  
  public List<FavoriteSearchResultModel> a(SearchRequest paramSearchRequest)
  {
    if (paramSearchRequest != null) {}
    label1153:
    label1158:
    label1180:
    label1187:
    label1192:
    label1194:
    for (;;)
    {
      int k;
      int m;
      try
      {
        if ((paramSearchRequest.jdField_a_of_type_JavaLangString != null) && (paramSearchRequest.jdField_a_of_type_JavaLangString.trim().length() != 0))
        {
          bool1 = jdField_a_of_type_Boolean;
          k = 0;
          if (!bool1) {
            jdField_a_of_type_Boolean = QfavHelper.a(false);
          }
          this.jdField_a_of_type_CooperationQqfavGlobalsearchFavoriteSearchEngine$SearchRunnable.jdField_a_of_type_ComTencentMobileqqSearchBaseModelSearchRequest = paramSearchRequest;
          if (paramSearchRequest.jdField_a_of_type_AndroidOsBundle == null) {
            break label1120;
          }
          i = paramSearchRequest.jdField_a_of_type_AndroidOsBundle.getInt("iNumber", 1);
          l1 = paramSearchRequest.jdField_a_of_type_AndroidOsBundle.getLong("lModifyTime", 9223372036854775807L);
          bool1 = paramSearchRequest.jdField_a_of_type_AndroidOsBundle.getBoolean("bMore", false);
          bool2 = paramSearchRequest.jdField_a_of_type_AndroidOsBundle.getBoolean("bSearchNet", false);
          if ((!paramSearchRequest.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_JavaLangString)) || ((bool2) && (this.jdField_a_of_type_Int == 1)))
          {
            this.jdField_a_of_type_JavaLangString = paramSearchRequest.jdField_a_of_type_JavaLangString;
            this.jdField_a_of_type_Long = 9223372036854775807L;
            this.jdField_a_of_type_JavaUtilList.clear();
            this.jdField_a_of_type_Int = 0;
          }
          if ((this.jdField_a_of_type_Int != 2) && ((bool2) || (this.jdField_a_of_type_Int != 1)))
          {
            long l2 = l1;
            if (bool1)
            {
              l2 = l1;
              if (this.jdField_a_of_type_JavaUtilList.size() > 0) {
                l2 = Math.min(l1, this.jdField_a_of_type_Long);
              }
            }
            this.jdField_a_of_type_Int = 0;
            this.jdField_a_of_type_JavaLangThread = Thread.currentThread();
            this.jdField_a_of_type_CooperationQqfavGlobalsearchFavoriteSearchEngine$QueryRunnable.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
            this.jdField_a_of_type_CooperationQqfavGlobalsearchFavoriteSearchEngine$QueryRunnable.jdField_a_of_type_Int = i;
            this.jdField_a_of_type_CooperationQqfavGlobalsearchFavoriteSearchEngine$QueryRunnable.jdField_a_of_type_Long = l2;
            this.jdField_a_of_type_CooperationQqfavGlobalsearchFavoriteSearchEngine$QueryRunnable.jdField_a_of_type_Boolean = bool2;
            this.jdField_a_of_type_CooperationQqfavGlobalsearchFavoriteSearchEngine$QueryRunnable.jdField_a_of_type_AndroidDatabaseCursor = null;
            synchronized (this.jdField_a_of_type_CooperationQqfavGlobalsearchFavoriteSearchEngine$QueryRunnable)
            {
              this.b = new Thread(this.jdField_a_of_type_CooperationQqfavGlobalsearchFavoriteSearchEngine$QueryRunnable);
              this.b.start();
              try
              {
                this.jdField_a_of_type_CooperationQqfavGlobalsearchFavoriteSearchEngine$QueryRunnable.wait();
                localCursor = this.jdField_a_of_type_CooperationQqfavGlobalsearchFavoriteSearchEngine$QueryRunnable.jdField_a_of_type_AndroidDatabaseCursor;
              }
              catch (InterruptedException localInterruptedException)
              {
                Cursor localCursor;
                int n;
                int i1;
                int i2;
                continue;
              }
              if (!QLog.isColorLevel()) {
                break label1136;
              }
              QLog.d("qqfav", 2, "InterruptedException, search cancel.");
              break label1136;
              if (localCursor != null)
              {
                if (localCursor.moveToFirst())
                {
                  if ((this.jdField_a_of_type_JavaUtilList.size() >= 5) || (localCursor.getCount() <= 1)) {
                    break label1142;
                  }
                  i = 1;
                  if (this.jdField_a_of_type_JavaUtilList.size() > 0) {
                    this.jdField_a_of_type_JavaUtilList.remove(this.jdField_a_of_type_JavaUtilList.size() - 1);
                  }
                  ??? = new FavoriteSearchResultModel();
                  ((FavoriteSearchResultModel)???).jdField_a_of_type_JavaLangString = paramSearchRequest.jdField_a_of_type_JavaLangString;
                  ((FavoriteSearchResultModel)???).jdField_a_of_type_Long = localCursor.getLong(0);
                  ((FavoriteSearchResultModel)???).jdField_b_of_type_Long = localCursor.getLong(4);
                  ((FavoriteSearchResultModel)???).jdField_c_of_type_Long = localCursor.getLong(5);
                  ((FavoriteSearchResultModel)???).jdField_b_of_type_JavaLangString = localCursor.getString(1);
                  j = 2;
                  ((FavoriteSearchResultModel)???).jdField_c_of_type_JavaLangString = localCursor.getString(2);
                  ((FavoriteSearchResultModel)???).jdField_d_of_type_JavaLangString = localCursor.getString(3);
                  ((FavoriteSearchResultModel)???).e = localCursor.getInt(6);
                  ((FavoriteSearchResultModel)???).jdField_d_of_type_Int = localCursor.getInt(8);
                  ((FavoriteSearchResultModel)???).jdField_a_of_type_ArrayOfByte = localCursor.getBlob(7);
                  ((FavoriteSearchResultModel)???).f = localCursor.getInt(9);
                  if (localCursor.getInt(10) <= 0) {
                    break label1147;
                  }
                  bool3 = true;
                  ((FavoriteSearchResultModel)???).jdField_a_of_type_Boolean = bool3;
                  ((FavoriteSearchResultModel)???).jdField_b_of_type_Int = localCursor.getInt(11);
                  ((FavoriteSearchResultModel)???).jdField_c_of_type_Int = localCursor.getInt(12);
                  ((FavoriteSearchResultModel)???).jdField_a_of_type_Int = localCursor.getInt(13);
                  ((FavoriteSearchResultModel)???).g = localCursor.getInt(14);
                  ((FavoriteSearchResultModel)???).h = this.jdField_a_of_type_JavaUtilList.size();
                  this.jdField_a_of_type_JavaUtilList.add(???);
                  if (localCursor.moveToNext()) {
                    break label1194;
                  }
                  if (((FavoriteSearchResultModel)???).jdField_a_of_type_Long < 0L) {
                    if (((FavoriteSearchResultModel)???).jdField_a_of_type_Long == -2L)
                    {
                      this.jdField_a_of_type_Long = ((FavoriteSearchResultModel)???).jdField_b_of_type_Long;
                      if (!bool2) {
                        break label1153;
                      }
                      this.jdField_a_of_type_Int = j;
                    }
                    else if ((localCursor.getCount() <= 1) && (l2 <= ((FavoriteSearchResultModel)???).jdField_b_of_type_Long))
                    {
                      this.jdField_a_of_type_Int = -1;
                    }
                    else
                    {
                      this.jdField_a_of_type_Long = ((FavoriteSearchResultModel)???).jdField_b_of_type_Long;
                    }
                  }
                  if (i != 0)
                  {
                    m = Math.min(4, this.jdField_a_of_type_JavaUtilList.size() - 1);
                    i = k;
                    break label1158;
                    if (j <= 0) {
                      break label1187;
                    }
                    n = k - j;
                    paramSearchRequest = (FavoriteSearchResultModel)this.jdField_a_of_type_JavaUtilList.get(n);
                    i1 = paramSearchRequest.g;
                    ??? = this.jdField_a_of_type_JavaUtilList;
                    i2 = n + 1;
                    if (i1 <= ((FavoriteSearchResultModel)((List)???).get(i2)).g) {
                      break label1180;
                    }
                    this.jdField_a_of_type_JavaUtilList.set(n, this.jdField_a_of_type_JavaUtilList.get(i2));
                    this.jdField_a_of_type_JavaUtilList.set(i2, paramSearchRequest);
                    break label1180;
                  }
                }
                else
                {
                  this.jdField_a_of_type_Int = -1;
                }
                localCursor.close();
              }
              else
              {
                this.jdField_a_of_type_Int = -1;
              }
              if ((this.jdField_a_of_type_Int == -1) && (this.jdField_a_of_type_JavaUtilList.size() > 0)) {
                ((FavoriteSearchResultModel)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_JavaUtilList.size() - 1)).jdField_a_of_type_Long = -3L;
              }
              paramSearchRequest = new ArrayList(this.jdField_a_of_type_JavaUtilList);
              if (!bool1) {
                if (this.jdField_a_of_type_JavaUtilList.size() > 1) {
                  paramSearchRequest.remove(paramSearchRequest.size() - 1);
                } else {
                  paramSearchRequest = null;
                }
              }
              return paramSearchRequest;
            }
          }
          paramSearchRequest = new ArrayList(this.jdField_a_of_type_JavaUtilList);
          if (!bool1) {
            if (this.jdField_a_of_type_JavaUtilList.size() > 1) {
              paramSearchRequest.remove(paramSearchRequest.size() - 1);
            } else {
              paramSearchRequest = null;
            }
          }
          return paramSearchRequest;
        }
      }
      finally {}
      return null;
      label1120:
      long l1 = 9223372036854775807L;
      int i = 1;
      boolean bool1 = false;
      boolean bool2 = false;
      continue;
      label1136:
      Object localObject1 = null;
      continue;
      label1142:
      i = 0;
      continue;
      label1147:
      boolean bool3 = false;
      continue;
      int j = 1;
      continue;
      for (;;)
      {
        if (i >= m - 1) {
          break label1192;
        }
        k = m - i - 1;
        j = k;
        break;
        j -= 1;
        break;
        i += 1;
      }
    }
  }
  
  public void a()
  {
    if (!jdField_a_of_type_Boolean) {
      jdField_a_of_type_Boolean = QfavHelper.a(false);
    }
  }
  
  public void a(SearchRequest paramSearchRequest, ISearchListener<FavoriteSearchResultModel> paramISearchListener)
  {
    if ((paramSearchRequest != null) && (paramSearchRequest.jdField_a_of_type_JavaLangString != null))
    {
      if (paramSearchRequest.jdField_a_of_type_JavaLangString.trim().length() == 0) {
        return;
      }
      synchronized (this.jdField_a_of_type_CooperationQqfavGlobalsearchFavoriteSearchEngine$SearchRunnable)
      {
        this.jdField_a_of_type_CooperationQqfavGlobalsearchFavoriteSearchEngine$SearchRunnable.jdField_a_of_type_ComTencentMobileqqSearchBaseModelSearchRequest = paramSearchRequest;
        this.jdField_a_of_type_CooperationQqfavGlobalsearchFavoriteSearchEngine$SearchRunnable.jdField_a_of_type_ComTencentMobileqqSearchBaseEngineISearchListener = paramISearchListener;
        ThreadManager.removeJobFromThreadPool(this.jdField_a_of_type_CooperationQqfavGlobalsearchFavoriteSearchEngine$SearchRunnable, 32);
        ThreadManager.excute(this.jdField_a_of_type_CooperationQqfavGlobalsearchFavoriteSearchEngine$SearchRunnable, 32, null, false);
        return;
      }
    }
  }
  
  public void b()
  {
    synchronized (this.jdField_a_of_type_CooperationQqfavGlobalsearchFavoriteSearchEngine$SearchRunnable)
    {
      this.jdField_a_of_type_CooperationQqfavGlobalsearchFavoriteSearchEngine$SearchRunnable.jdField_a_of_type_ComTencentMobileqqSearchBaseModelSearchRequest = null;
      this.jdField_a_of_type_CooperationQqfavGlobalsearchFavoriteSearchEngine$SearchRunnable.jdField_a_of_type_ComTencentMobileqqSearchBaseEngineISearchListener = null;
      ThreadManager.removeJobFromThreadPool(this.jdField_a_of_type_CooperationQqfavGlobalsearchFavoriteSearchEngine$SearchRunnable, 32);
      ??? = this.jdField_a_of_type_JavaLangThread;
      if (??? != null) {
        ((Thread)???).interrupt();
      }
      return;
    }
  }
  
  public void c() {}
  
  public void d() {}
  
  public void e() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.qqfav.globalsearch.FavoriteSearchEngine
 * JD-Core Version:    0.7.0.1
 */