package cooperation.qqfav.globalsearch;

import alzc;
import alzd;
import android.database.Cursor;
import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.search.searchengine.ISearchEngine;
import com.tencent.mobileqq.search.searchengine.ISearchListener;
import com.tencent.mobileqq.search.searchengine.SearchRequest;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqfav.QfavHelper;
import java.util.ArrayList;
import java.util.List;

public class FavoriteSearchEngine
  implements ISearchEngine
{
  private static boolean jdField_a_of_type_Boolean;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private final alzc jdField_a_of_type_Alzc = new alzc(this, null);
  private final alzd jdField_a_of_type_Alzd = new alzd(this, null);
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private String jdField_a_of_type_JavaLangString;
  private Thread jdField_a_of_type_JavaLangThread;
  private List jdField_a_of_type_JavaUtilList = new ArrayList();
  private Thread b;
  
  public FavoriteSearchEngine(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public List a(SearchRequest paramSearchRequest)
  {
    int i;
    long l;
    boolean bool2;
    boolean bool1;
    label115:
    Object localObject1;
    for (;;)
    {
      try
      {
        if ((!jdField_a_of_type_Boolean) || (paramSearchRequest == null) || (paramSearchRequest.jdField_a_of_type_JavaLangString == null) || (paramSearchRequest.jdField_a_of_type_JavaLangString.trim().length() == 0))
        {
          if (!jdField_a_of_type_Boolean) {
            jdField_a_of_type_Boolean = QfavHelper.a(false);
          }
          paramSearchRequest = null;
          return paramSearchRequest;
        }
        this.jdField_a_of_type_Alzd.jdField_a_of_type_ComTencentMobileqqSearchSearchengineSearchRequest = paramSearchRequest;
        if (paramSearchRequest.jdField_a_of_type_AndroidOsBundle == null) {
          break label1094;
        }
        i = paramSearchRequest.jdField_a_of_type_AndroidOsBundle.getInt("iNumber", 1);
        l = paramSearchRequest.jdField_a_of_type_AndroidOsBundle.getLong("lModifyTime", 9223372036854775807L);
        bool2 = paramSearchRequest.jdField_a_of_type_AndroidOsBundle.getBoolean("bMore", false);
        bool1 = paramSearchRequest.jdField_a_of_type_AndroidOsBundle.getBoolean("bSearchNet", false);
        if ((!paramSearchRequest.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_JavaLangString)) || ((bool1) && (this.jdField_a_of_type_Int == 1)))
        {
          this.jdField_a_of_type_JavaLangString = paramSearchRequest.jdField_a_of_type_JavaLangString;
          this.jdField_a_of_type_Long = 9223372036854775807L;
          this.jdField_a_of_type_JavaUtilList.clear();
          this.jdField_a_of_type_Int = 0;
        }
        if ((this.jdField_a_of_type_Int != 2) && ((bool1) || (this.jdField_a_of_type_Int != 1))) {
          break;
        }
        localObject1 = new ArrayList(this.jdField_a_of_type_JavaUtilList);
        paramSearchRequest = (SearchRequest)localObject1;
        if (!bool2) {
          if (this.jdField_a_of_type_JavaUtilList.size() > 1)
          {
            ((ArrayList)localObject1).remove(((ArrayList)localObject1).size() - 1);
            paramSearchRequest = (SearchRequest)localObject1;
          }
          else
          {
            paramSearchRequest = null;
          }
        }
      }
      finally {}
    }
    label283:
    label431:
    boolean bool3;
    label631:
    int j;
    label768:
    int m;
    label799:
    int k;
    if ((bool2) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      l = Math.min(l, this.jdField_a_of_type_Long);
      this.jdField_a_of_type_Int = 0;
      this.jdField_a_of_type_JavaLangThread = Thread.currentThread();
      this.jdField_a_of_type_Alzc.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
      this.jdField_a_of_type_Alzc.jdField_a_of_type_Int = i;
      this.jdField_a_of_type_Alzc.jdField_a_of_type_Long = l;
      this.jdField_a_of_type_Alzc.jdField_a_of_type_Boolean = bool1;
      this.jdField_a_of_type_Alzc.jdField_a_of_type_AndroidDatabaseCursor = null;
      for (;;)
      {
        synchronized (this.jdField_a_of_type_Alzc)
        {
          this.b = new Thread(this.jdField_a_of_type_Alzc);
          this.b.start();
          try
          {
            this.jdField_a_of_type_Alzc.wait();
            localObject1 = this.jdField_a_of_type_Alzc.jdField_a_of_type_AndroidDatabaseCursor;
            if (localObject1 == null) {
              break label1078;
            }
            if (!((Cursor)localObject1).moveToFirst()) {
              break;
            }
            if ((this.jdField_a_of_type_JavaUtilList.size() >= 5) || (((Cursor)localObject1).getCount() <= 1)) {
              break label1138;
            }
            i = 1;
            if (this.jdField_a_of_type_JavaUtilList.size() > 0) {
              this.jdField_a_of_type_JavaUtilList.remove(this.jdField_a_of_type_JavaUtilList.size() - 1);
            }
            ??? = new FavoriteSearchResultModel();
            ((FavoriteSearchResultModel)???).jdField_a_of_type_JavaLangString = paramSearchRequest.jdField_a_of_type_JavaLangString;
            ((FavoriteSearchResultModel)???).jdField_a_of_type_Long = ((Cursor)localObject1).getLong(0);
            ((FavoriteSearchResultModel)???).jdField_b_of_type_Long = ((Cursor)localObject1).getLong(4);
            ((FavoriteSearchResultModel)???).jdField_c_of_type_Long = ((Cursor)localObject1).getLong(5);
            ((FavoriteSearchResultModel)???).jdField_b_of_type_JavaLangString = ((Cursor)localObject1).getString(1);
            ((FavoriteSearchResultModel)???).jdField_c_of_type_JavaLangString = ((Cursor)localObject1).getString(2);
            ((FavoriteSearchResultModel)???).jdField_d_of_type_JavaLangString = ((Cursor)localObject1).getString(3);
            ((FavoriteSearchResultModel)???).e = ((Cursor)localObject1).getInt(6);
            ((FavoriteSearchResultModel)???).jdField_d_of_type_Int = ((Cursor)localObject1).getInt(8);
            ((FavoriteSearchResultModel)???).jdField_a_of_type_ArrayOfByte = ((Cursor)localObject1).getBlob(7);
            ((FavoriteSearchResultModel)???).f = ((Cursor)localObject1).getInt(9);
            if (((Cursor)localObject1).getInt(10) <= 0) {
              break label1143;
            }
            bool3 = true;
            ((FavoriteSearchResultModel)???).jdField_a_of_type_Boolean = bool3;
            ((FavoriteSearchResultModel)???).jdField_b_of_type_Int = ((Cursor)localObject1).getInt(11);
            ((FavoriteSearchResultModel)???).jdField_c_of_type_Int = ((Cursor)localObject1).getInt(12);
            ((FavoriteSearchResultModel)???).jdField_a_of_type_Int = ((Cursor)localObject1).getInt(13);
            ((FavoriteSearchResultModel)???).g = ((Cursor)localObject1).getInt(14);
            ((FavoriteSearchResultModel)???).h = this.jdField_a_of_type_JavaUtilList.size();
            this.jdField_a_of_type_JavaUtilList.add(???);
            if (((Cursor)localObject1).moveToNext()) {
              continue;
            }
            if (((FavoriteSearchResultModel)???).jdField_a_of_type_Long < 0L)
            {
              if (((FavoriteSearchResultModel)???).jdField_a_of_type_Long != -2L) {
                break label922;
              }
              this.jdField_a_of_type_Long = ((FavoriteSearchResultModel)???).jdField_b_of_type_Long;
              if (!bool1) {
                break label1149;
              }
              j = 2;
              this.jdField_a_of_type_Int = j;
            }
            if (i == 0) {
              break label969;
            }
            m = Math.min(4, this.jdField_a_of_type_JavaUtilList.size() - 1);
            i = 0;
          }
          catch (InterruptedException localInterruptedException)
          {
            int n;
            if (!QLog.isColorLevel()) {
              break label1132;
            }
          }
          if (j <= 0) {
            break label1154;
          }
          n = k - j;
          paramSearchRequest = (FavoriteSearchResultModel)this.jdField_a_of_type_JavaUtilList.get(n);
          if (paramSearchRequest.g > ((FavoriteSearchResultModel)this.jdField_a_of_type_JavaUtilList.get(n + 1)).g)
          {
            this.jdField_a_of_type_JavaUtilList.set(n, this.jdField_a_of_type_JavaUtilList.get(n + 1));
            this.jdField_a_of_type_JavaUtilList.set(n + 1, paramSearchRequest);
          }
          j -= 1;
          continue;
          QLog.d("qqfav", 2, "InterruptedException, search cancel.");
        }
        label922:
        if ((localInterruptedException.getCount() > 1) || (l > ((FavoriteSearchResultModel)???).jdField_b_of_type_Long)) {
          this.jdField_a_of_type_Long = ((FavoriteSearchResultModel)???).jdField_b_of_type_Long;
        } else {
          this.jdField_a_of_type_Int = -1;
        }
      }
      this.jdField_a_of_type_Int = -1;
    }
    label1154:
    label1159:
    for (;;)
    {
      label969:
      localInterruptedException.close();
      ArrayList localArrayList;
      for (;;)
      {
        if ((this.jdField_a_of_type_Int == -1) && (this.jdField_a_of_type_JavaUtilList.size() > 0)) {
          ((FavoriteSearchResultModel)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_JavaUtilList.size() - 1)).jdField_a_of_type_Long = -3L;
        }
        localArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilList);
        paramSearchRequest = localArrayList;
        if (bool2) {
          break;
        }
        if (this.jdField_a_of_type_JavaUtilList.size() <= 1) {
          break label1086;
        }
        localArrayList.remove(localArrayList.size() - 1);
        paramSearchRequest = localArrayList;
        break;
        label1078:
        this.jdField_a_of_type_Int = -1;
      }
      label1086:
      paramSearchRequest = null;
      break;
      break label283;
      label1094:
      bool2 = false;
      i = 1;
      bool1 = false;
      l = 9223372036854775807L;
      break label115;
      for (;;)
      {
        if (i >= m - 1) {
          break label1159;
        }
        k = m - i - 1;
        j = k;
        break label799;
        label1132:
        localArrayList = null;
        break;
        label1138:
        i = 0;
        break label431;
        label1143:
        bool3 = false;
        break label631;
        label1149:
        j = 1;
        break label768;
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
  
  public void a(SearchRequest paramSearchRequest, ISearchListener paramISearchListener)
  {
    if ((paramSearchRequest == null) || (paramSearchRequest.jdField_a_of_type_JavaLangString == null) || (paramSearchRequest.jdField_a_of_type_JavaLangString.trim().length() == 0)) {
      return;
    }
    synchronized (this.jdField_a_of_type_Alzd)
    {
      this.jdField_a_of_type_Alzd.jdField_a_of_type_ComTencentMobileqqSearchSearchengineSearchRequest = paramSearchRequest;
      this.jdField_a_of_type_Alzd.jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchListener = paramISearchListener;
      ThreadManager.remove(this.jdField_a_of_type_Alzd);
      ThreadManager.postImmediately(this.jdField_a_of_type_Alzd, null, false);
      return;
    }
  }
  
  public void b()
  {
    synchronized (this.jdField_a_of_type_Alzd)
    {
      this.jdField_a_of_type_Alzd.jdField_a_of_type_ComTencentMobileqqSearchSearchengineSearchRequest = null;
      this.jdField_a_of_type_Alzd.jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchListener = null;
      ThreadManager.remove(this.jdField_a_of_type_Alzd);
      if (this.jdField_a_of_type_JavaLangThread != null) {
        this.jdField_a_of_type_JavaLangThread.interrupt();
      }
      return;
    }
  }
  
  public void c() {}
  
  public void d() {}
  
  public void e() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qqfav.globalsearch.FavoriteSearchEngine
 * JD-Core Version:    0.7.0.1
 */