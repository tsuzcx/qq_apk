package cooperation.qqfav.globalsearch;

import android.database.Cursor;
import android.os.Bundle;
import ayug;
import ayuh;
import ayuu;
import bivc;
import bivz;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class FavoriteSearchEngine
  implements ayug<bivz>
{
  private static boolean jdField_a_of_type_Boolean;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private final FavoriteSearchEngine.QueryRunnable jdField_a_of_type_CooperationQqfavGlobalsearchFavoriteSearchEngine$QueryRunnable = new FavoriteSearchEngine.QueryRunnable(this, null);
  private final FavoriteSearchEngine.SearchRunnable jdField_a_of_type_CooperationQqfavGlobalsearchFavoriteSearchEngine$SearchRunnable = new FavoriteSearchEngine.SearchRunnable(this, null);
  private String jdField_a_of_type_JavaLangString;
  private Thread jdField_a_of_type_JavaLangThread;
  private List<bivz> jdField_a_of_type_JavaUtilList = new ArrayList();
  private Thread b;
  
  public FavoriteSearchEngine(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public List<bivz> a(ayuu paramayuu)
  {
    if (paramayuu != null) {}
    int i;
    long l;
    boolean bool2;
    boolean bool1;
    label111:
    Object localObject1;
    for (;;)
    {
      try
      {
        if (paramayuu.jdField_a_of_type_JavaLangString != null)
        {
          i = paramayuu.jdField_a_of_type_JavaLangString.trim().length();
          if (i != 0) {}
        }
        else
        {
          paramayuu = null;
          return paramayuu;
        }
        if (!jdField_a_of_type_Boolean) {
          jdField_a_of_type_Boolean = bivc.a(false);
        }
        this.jdField_a_of_type_CooperationQqfavGlobalsearchFavoriteSearchEngine$SearchRunnable.jdField_a_of_type_Ayuu = paramayuu;
        if (paramayuu.jdField_a_of_type_AndroidOsBundle == null) {
          break label1090;
        }
        i = paramayuu.jdField_a_of_type_AndroidOsBundle.getInt("iNumber", 1);
        l = paramayuu.jdField_a_of_type_AndroidOsBundle.getLong("lModifyTime", 9223372036854775807L);
        bool2 = paramayuu.jdField_a_of_type_AndroidOsBundle.getBoolean("bMore", false);
        bool1 = paramayuu.jdField_a_of_type_AndroidOsBundle.getBoolean("bSearchNet", false);
        if ((!paramayuu.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_JavaLangString)) || ((bool1) && (this.jdField_a_of_type_Int == 1)))
        {
          this.jdField_a_of_type_JavaLangString = paramayuu.jdField_a_of_type_JavaLangString;
          this.jdField_a_of_type_Long = 9223372036854775807L;
          this.jdField_a_of_type_JavaUtilList.clear();
          this.jdField_a_of_type_Int = 0;
        }
        if ((this.jdField_a_of_type_Int != 2) && ((bool1) || (this.jdField_a_of_type_Int != 1))) {
          break;
        }
        localObject1 = new ArrayList(this.jdField_a_of_type_JavaUtilList);
        paramayuu = (ayuu)localObject1;
        if (!bool2) {
          if (this.jdField_a_of_type_JavaUtilList.size() > 1)
          {
            ((ArrayList)localObject1).remove(((ArrayList)localObject1).size() - 1);
            paramayuu = (ayuu)localObject1;
          }
          else
          {
            paramayuu = null;
          }
        }
      }
      finally {}
    }
    label279:
    label427:
    boolean bool3;
    label627:
    int j;
    label764:
    int m;
    label795:
    int k;
    if ((bool2) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      l = Math.min(l, this.jdField_a_of_type_Long);
      this.jdField_a_of_type_Int = 0;
      this.jdField_a_of_type_JavaLangThread = Thread.currentThread();
      this.jdField_a_of_type_CooperationQqfavGlobalsearchFavoriteSearchEngine$QueryRunnable.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
      this.jdField_a_of_type_CooperationQqfavGlobalsearchFavoriteSearchEngine$QueryRunnable.jdField_a_of_type_Int = i;
      this.jdField_a_of_type_CooperationQqfavGlobalsearchFavoriteSearchEngine$QueryRunnable.jdField_a_of_type_Long = l;
      this.jdField_a_of_type_CooperationQqfavGlobalsearchFavoriteSearchEngine$QueryRunnable.jdField_a_of_type_Boolean = bool1;
      this.jdField_a_of_type_CooperationQqfavGlobalsearchFavoriteSearchEngine$QueryRunnable.jdField_a_of_type_AndroidDatabaseCursor = null;
      for (;;)
      {
        synchronized (this.jdField_a_of_type_CooperationQqfavGlobalsearchFavoriteSearchEngine$QueryRunnable)
        {
          this.b = new Thread(this.jdField_a_of_type_CooperationQqfavGlobalsearchFavoriteSearchEngine$QueryRunnable);
          this.b.start();
          try
          {
            this.jdField_a_of_type_CooperationQqfavGlobalsearchFavoriteSearchEngine$QueryRunnable.wait();
            localObject1 = this.jdField_a_of_type_CooperationQqfavGlobalsearchFavoriteSearchEngine$QueryRunnable.jdField_a_of_type_AndroidDatabaseCursor;
            if (localObject1 == null) {
              break label1074;
            }
            if (!((Cursor)localObject1).moveToFirst()) {
              break;
            }
            if ((this.jdField_a_of_type_JavaUtilList.size() >= 5) || (((Cursor)localObject1).getCount() <= 1)) {
              break label1134;
            }
            i = 1;
            if (this.jdField_a_of_type_JavaUtilList.size() > 0) {
              this.jdField_a_of_type_JavaUtilList.remove(this.jdField_a_of_type_JavaUtilList.size() - 1);
            }
            ??? = new bivz();
            ((bivz)???).jdField_a_of_type_JavaLangString = paramayuu.jdField_a_of_type_JavaLangString;
            ((bivz)???).jdField_a_of_type_Long = ((Cursor)localObject1).getLong(0);
            ((bivz)???).jdField_b_of_type_Long = ((Cursor)localObject1).getLong(4);
            ((bivz)???).jdField_c_of_type_Long = ((Cursor)localObject1).getLong(5);
            ((bivz)???).jdField_b_of_type_JavaLangString = ((Cursor)localObject1).getString(1);
            ((bivz)???).jdField_c_of_type_JavaLangString = ((Cursor)localObject1).getString(2);
            ((bivz)???).jdField_d_of_type_JavaLangString = ((Cursor)localObject1).getString(3);
            ((bivz)???).e = ((Cursor)localObject1).getInt(6);
            ((bivz)???).jdField_d_of_type_Int = ((Cursor)localObject1).getInt(8);
            ((bivz)???).jdField_a_of_type_ArrayOfByte = ((Cursor)localObject1).getBlob(7);
            ((bivz)???).f = ((Cursor)localObject1).getInt(9);
            if (((Cursor)localObject1).getInt(10) <= 0) {
              break label1139;
            }
            bool3 = true;
            ((bivz)???).jdField_a_of_type_Boolean = bool3;
            ((bivz)???).jdField_b_of_type_Int = ((Cursor)localObject1).getInt(11);
            ((bivz)???).jdField_c_of_type_Int = ((Cursor)localObject1).getInt(12);
            ((bivz)???).jdField_a_of_type_Int = ((Cursor)localObject1).getInt(13);
            ((bivz)???).g = ((Cursor)localObject1).getInt(14);
            ((bivz)???).h = this.jdField_a_of_type_JavaUtilList.size();
            this.jdField_a_of_type_JavaUtilList.add(???);
            if (((Cursor)localObject1).moveToNext()) {
              continue;
            }
            if (((bivz)???).jdField_a_of_type_Long < 0L)
            {
              if (((bivz)???).jdField_a_of_type_Long != -2L) {
                break label918;
              }
              this.jdField_a_of_type_Long = ((bivz)???).jdField_b_of_type_Long;
              if (!bool1) {
                break label1145;
              }
              j = 2;
              this.jdField_a_of_type_Int = j;
            }
            if (i == 0) {
              break label965;
            }
            m = Math.min(4, this.jdField_a_of_type_JavaUtilList.size() - 1);
            i = 0;
          }
          catch (InterruptedException localInterruptedException)
          {
            int n;
            if (!QLog.isColorLevel()) {
              break label1128;
            }
          }
          if (j <= 0) {
            break label1150;
          }
          n = k - j;
          paramayuu = (bivz)this.jdField_a_of_type_JavaUtilList.get(n);
          if (paramayuu.g > ((bivz)this.jdField_a_of_type_JavaUtilList.get(n + 1)).g)
          {
            this.jdField_a_of_type_JavaUtilList.set(n, this.jdField_a_of_type_JavaUtilList.get(n + 1));
            this.jdField_a_of_type_JavaUtilList.set(n + 1, paramayuu);
          }
          j -= 1;
          continue;
          QLog.d("qqfav", 2, "InterruptedException, search cancel.");
        }
        label918:
        if ((localInterruptedException.getCount() > 1) || (l > ((bivz)???).jdField_b_of_type_Long)) {
          this.jdField_a_of_type_Long = ((bivz)???).jdField_b_of_type_Long;
        } else {
          this.jdField_a_of_type_Int = -1;
        }
      }
      this.jdField_a_of_type_Int = -1;
    }
    label1155:
    for (;;)
    {
      label965:
      localInterruptedException.close();
      ArrayList localArrayList;
      for (;;)
      {
        if ((this.jdField_a_of_type_Int == -1) && (this.jdField_a_of_type_JavaUtilList.size() > 0)) {
          ((bivz)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_JavaUtilList.size() - 1)).jdField_a_of_type_Long = -3L;
        }
        localArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilList);
        paramayuu = localArrayList;
        if (bool2) {
          break;
        }
        if (this.jdField_a_of_type_JavaUtilList.size() <= 1) {
          break label1082;
        }
        localArrayList.remove(localArrayList.size() - 1);
        paramayuu = localArrayList;
        break;
        label1074:
        this.jdField_a_of_type_Int = -1;
      }
      label1082:
      paramayuu = null;
      break;
      break label279;
      label1090:
      bool2 = false;
      i = 1;
      bool1 = false;
      l = 9223372036854775807L;
      break label111;
      for (;;)
      {
        if (i >= m - 1) {
          break label1155;
        }
        k = m - i - 1;
        j = k;
        break label795;
        label1128:
        localArrayList = null;
        break;
        label1134:
        i = 0;
        break label427;
        label1139:
        bool3 = false;
        break label627;
        label1145:
        j = 1;
        break label764;
        label1150:
        i += 1;
      }
    }
  }
  
  public void a()
  {
    if (!jdField_a_of_type_Boolean) {
      jdField_a_of_type_Boolean = bivc.a(false);
    }
  }
  
  public void a(ayuu paramayuu, ayuh<bivz> paramayuh)
  {
    if ((paramayuu == null) || (paramayuu.jdField_a_of_type_JavaLangString == null) || (paramayuu.jdField_a_of_type_JavaLangString.trim().length() == 0)) {
      return;
    }
    synchronized (this.jdField_a_of_type_CooperationQqfavGlobalsearchFavoriteSearchEngine$SearchRunnable)
    {
      this.jdField_a_of_type_CooperationQqfavGlobalsearchFavoriteSearchEngine$SearchRunnable.jdField_a_of_type_Ayuu = paramayuu;
      this.jdField_a_of_type_CooperationQqfavGlobalsearchFavoriteSearchEngine$SearchRunnable.jdField_a_of_type_Ayuh = paramayuh;
      ThreadManager.removeJobFromThreadPool(this.jdField_a_of_type_CooperationQqfavGlobalsearchFavoriteSearchEngine$SearchRunnable, 32);
      ThreadManager.excute(this.jdField_a_of_type_CooperationQqfavGlobalsearchFavoriteSearchEngine$SearchRunnable, 32, null, false);
      return;
    }
  }
  
  public void b()
  {
    synchronized (this.jdField_a_of_type_CooperationQqfavGlobalsearchFavoriteSearchEngine$SearchRunnable)
    {
      this.jdField_a_of_type_CooperationQqfavGlobalsearchFavoriteSearchEngine$SearchRunnable.jdField_a_of_type_Ayuu = null;
      this.jdField_a_of_type_CooperationQqfavGlobalsearchFavoriteSearchEngine$SearchRunnable.jdField_a_of_type_Ayuh = null;
      ThreadManager.removeJobFromThreadPool(this.jdField_a_of_type_CooperationQqfavGlobalsearchFavoriteSearchEngine$SearchRunnable, 32);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qqfav.globalsearch.FavoriteSearchEngine
 * JD-Core Version:    0.7.0.1
 */