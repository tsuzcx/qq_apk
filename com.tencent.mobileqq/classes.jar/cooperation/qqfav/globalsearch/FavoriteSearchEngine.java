package cooperation.qqfav.globalsearch;

import android.database.Cursor;
import android.os.Bundle;
import bbfe;
import bbff;
import bbfs;
import bkox;
import bkpu;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class FavoriteSearchEngine
  implements bbfe<bkpu>
{
  private static boolean jdField_a_of_type_Boolean;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private final FavoriteSearchEngine.QueryRunnable jdField_a_of_type_CooperationQqfavGlobalsearchFavoriteSearchEngine$QueryRunnable = new FavoriteSearchEngine.QueryRunnable(this, null);
  private final FavoriteSearchEngine.SearchRunnable jdField_a_of_type_CooperationQqfavGlobalsearchFavoriteSearchEngine$SearchRunnable = new FavoriteSearchEngine.SearchRunnable(this, null);
  private String jdField_a_of_type_JavaLangString;
  private Thread jdField_a_of_type_JavaLangThread;
  private List<bkpu> jdField_a_of_type_JavaUtilList = new ArrayList();
  private Thread b;
  
  public FavoriteSearchEngine(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public List<bkpu> a(bbfs parambbfs)
  {
    if (parambbfs != null) {}
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
        if (parambbfs.jdField_a_of_type_JavaLangString != null)
        {
          i = parambbfs.jdField_a_of_type_JavaLangString.trim().length();
          if (i != 0) {}
        }
        else
        {
          parambbfs = null;
          return parambbfs;
        }
        if (!jdField_a_of_type_Boolean) {
          jdField_a_of_type_Boolean = bkox.a(false);
        }
        this.jdField_a_of_type_CooperationQqfavGlobalsearchFavoriteSearchEngine$SearchRunnable.jdField_a_of_type_Bbfs = parambbfs;
        if (parambbfs.jdField_a_of_type_AndroidOsBundle == null) {
          break label1090;
        }
        i = parambbfs.jdField_a_of_type_AndroidOsBundle.getInt("iNumber", 1);
        l = parambbfs.jdField_a_of_type_AndroidOsBundle.getLong("lModifyTime", 9223372036854775807L);
        bool2 = parambbfs.jdField_a_of_type_AndroidOsBundle.getBoolean("bMore", false);
        bool1 = parambbfs.jdField_a_of_type_AndroidOsBundle.getBoolean("bSearchNet", false);
        if ((!parambbfs.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_JavaLangString)) || ((bool1) && (this.jdField_a_of_type_Int == 1)))
        {
          this.jdField_a_of_type_JavaLangString = parambbfs.jdField_a_of_type_JavaLangString;
          this.jdField_a_of_type_Long = 9223372036854775807L;
          this.jdField_a_of_type_JavaUtilList.clear();
          this.jdField_a_of_type_Int = 0;
        }
        if ((this.jdField_a_of_type_Int != 2) && ((bool1) || (this.jdField_a_of_type_Int != 1))) {
          break;
        }
        localObject1 = new ArrayList(this.jdField_a_of_type_JavaUtilList);
        parambbfs = (bbfs)localObject1;
        if (!bool2) {
          if (this.jdField_a_of_type_JavaUtilList.size() > 1)
          {
            ((ArrayList)localObject1).remove(((ArrayList)localObject1).size() - 1);
            parambbfs = (bbfs)localObject1;
          }
          else
          {
            parambbfs = null;
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
            ??? = new bkpu();
            ((bkpu)???).jdField_a_of_type_JavaLangString = parambbfs.jdField_a_of_type_JavaLangString;
            ((bkpu)???).jdField_a_of_type_Long = ((Cursor)localObject1).getLong(0);
            ((bkpu)???).jdField_b_of_type_Long = ((Cursor)localObject1).getLong(4);
            ((bkpu)???).jdField_c_of_type_Long = ((Cursor)localObject1).getLong(5);
            ((bkpu)???).jdField_b_of_type_JavaLangString = ((Cursor)localObject1).getString(1);
            ((bkpu)???).jdField_c_of_type_JavaLangString = ((Cursor)localObject1).getString(2);
            ((bkpu)???).jdField_d_of_type_JavaLangString = ((Cursor)localObject1).getString(3);
            ((bkpu)???).e = ((Cursor)localObject1).getInt(6);
            ((bkpu)???).jdField_d_of_type_Int = ((Cursor)localObject1).getInt(8);
            ((bkpu)???).jdField_a_of_type_ArrayOfByte = ((Cursor)localObject1).getBlob(7);
            ((bkpu)???).f = ((Cursor)localObject1).getInt(9);
            if (((Cursor)localObject1).getInt(10) <= 0) {
              break label1139;
            }
            bool3 = true;
            ((bkpu)???).jdField_a_of_type_Boolean = bool3;
            ((bkpu)???).jdField_b_of_type_Int = ((Cursor)localObject1).getInt(11);
            ((bkpu)???).jdField_c_of_type_Int = ((Cursor)localObject1).getInt(12);
            ((bkpu)???).jdField_a_of_type_Int = ((Cursor)localObject1).getInt(13);
            ((bkpu)???).g = ((Cursor)localObject1).getInt(14);
            ((bkpu)???).h = this.jdField_a_of_type_JavaUtilList.size();
            this.jdField_a_of_type_JavaUtilList.add(???);
            if (((Cursor)localObject1).moveToNext()) {
              continue;
            }
            if (((bkpu)???).jdField_a_of_type_Long < 0L)
            {
              if (((bkpu)???).jdField_a_of_type_Long != -2L) {
                break label918;
              }
              this.jdField_a_of_type_Long = ((bkpu)???).jdField_b_of_type_Long;
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
          parambbfs = (bkpu)this.jdField_a_of_type_JavaUtilList.get(n);
          if (parambbfs.g > ((bkpu)this.jdField_a_of_type_JavaUtilList.get(n + 1)).g)
          {
            this.jdField_a_of_type_JavaUtilList.set(n, this.jdField_a_of_type_JavaUtilList.get(n + 1));
            this.jdField_a_of_type_JavaUtilList.set(n + 1, parambbfs);
          }
          j -= 1;
          continue;
          QLog.d("qqfav", 2, "InterruptedException, search cancel.");
        }
        label918:
        if ((localInterruptedException.getCount() > 1) || (l > ((bkpu)???).jdField_b_of_type_Long)) {
          this.jdField_a_of_type_Long = ((bkpu)???).jdField_b_of_type_Long;
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
          ((bkpu)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_JavaUtilList.size() - 1)).jdField_a_of_type_Long = -3L;
        }
        localArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilList);
        parambbfs = localArrayList;
        if (bool2) {
          break;
        }
        if (this.jdField_a_of_type_JavaUtilList.size() <= 1) {
          break label1082;
        }
        localArrayList.remove(localArrayList.size() - 1);
        parambbfs = localArrayList;
        break;
        label1074:
        this.jdField_a_of_type_Int = -1;
      }
      label1082:
      parambbfs = null;
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
      jdField_a_of_type_Boolean = bkox.a(false);
    }
  }
  
  public void a(bbfs parambbfs, bbff<bkpu> parambbff)
  {
    if ((parambbfs == null) || (parambbfs.jdField_a_of_type_JavaLangString == null) || (parambbfs.jdField_a_of_type_JavaLangString.trim().length() == 0)) {
      return;
    }
    synchronized (this.jdField_a_of_type_CooperationQqfavGlobalsearchFavoriteSearchEngine$SearchRunnable)
    {
      this.jdField_a_of_type_CooperationQqfavGlobalsearchFavoriteSearchEngine$SearchRunnable.jdField_a_of_type_Bbfs = parambbfs;
      this.jdField_a_of_type_CooperationQqfavGlobalsearchFavoriteSearchEngine$SearchRunnable.jdField_a_of_type_Bbff = parambbff;
      ThreadManager.removeJobFromThreadPool(this.jdField_a_of_type_CooperationQqfavGlobalsearchFavoriteSearchEngine$SearchRunnable, 32);
      ThreadManager.excute(this.jdField_a_of_type_CooperationQqfavGlobalsearchFavoriteSearchEngine$SearchRunnable, 32, null, false);
      return;
    }
  }
  
  public void b()
  {
    synchronized (this.jdField_a_of_type_CooperationQqfavGlobalsearchFavoriteSearchEngine$SearchRunnable)
    {
      this.jdField_a_of_type_CooperationQqfavGlobalsearchFavoriteSearchEngine$SearchRunnable.jdField_a_of_type_Bbfs = null;
      this.jdField_a_of_type_CooperationQqfavGlobalsearchFavoriteSearchEngine$SearchRunnable.jdField_a_of_type_Bbff = null;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqfav.globalsearch.FavoriteSearchEngine
 * JD-Core Version:    0.7.0.1
 */