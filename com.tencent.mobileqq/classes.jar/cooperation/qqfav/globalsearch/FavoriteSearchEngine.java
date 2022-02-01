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
  private static boolean f;
  private final QQAppInterface a;
  private String b;
  private long c;
  private int d;
  private List<FavoriteSearchResultModel> e = new ArrayList();
  private final FavoriteSearchEngine.QueryRunnable g = new FavoriteSearchEngine.QueryRunnable(this, null);
  private Thread h;
  private Thread i;
  private final FavoriteSearchEngine.SearchRunnable j = new FavoriteSearchEngine.SearchRunnable(this, null);
  
  public FavoriteSearchEngine(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
  }
  
  /* Error */
  public static void a(com.tencent.common.app.AppInterface paramAppInterface)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 62	com/tencent/common/app/AppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   4: invokevirtual 68	mqq/app/MobileQQ:getContentResolver	()Landroid/content/ContentResolver;
    //   7: astore_1
    //   8: new 70	java/lang/StringBuilder
    //   11: dup
    //   12: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   15: astore_2
    //   16: aload_2
    //   17: ldc 73
    //   19: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: pop
    //   23: aload_2
    //   24: aload_0
    //   25: invokevirtual 81	com/tencent/common/app/AppInterface:getAccount	()Ljava/lang/String;
    //   28: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: pop
    //   32: aload_2
    //   33: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   36: invokestatic 90	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   39: astore_0
    //   40: aload_1
    //   41: aload_0
    //   42: aconst_null
    //   43: aconst_null
    //   44: aconst_null
    //   45: aconst_null
    //   46: invokevirtual 96	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   49: astore_0
    //   50: aload_0
    //   51: ifnull +24 -> 75
    //   54: aload_0
    //   55: invokeinterface 101 1 0
    //   60: return
    //   61: astore_0
    //   62: goto +14 -> 76
    //   65: astore_0
    //   66: ldc 103
    //   68: iconst_1
    //   69: ldc 105
    //   71: aload_0
    //   72: invokestatic 110	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
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
      int n;
      int i1;
      try
      {
        if ((paramSearchRequest.a != null) && (paramSearchRequest.a.trim().length() != 0))
        {
          bool1 = f;
          n = 0;
          if (!bool1) {
            f = QfavHelper.a(false);
          }
          this.j.a = paramSearchRequest;
          if (paramSearchRequest.b == null) {
            break label1120;
          }
          k = paramSearchRequest.b.getInt("iNumber", 1);
          l1 = paramSearchRequest.b.getLong("lModifyTime", 9223372036854775807L);
          bool1 = paramSearchRequest.b.getBoolean("bMore", false);
          bool2 = paramSearchRequest.b.getBoolean("bSearchNet", false);
          if ((!paramSearchRequest.a.equals(this.b)) || ((bool2) && (this.d == 1)))
          {
            this.b = paramSearchRequest.a;
            this.c = 9223372036854775807L;
            this.e.clear();
            this.d = 0;
          }
          if ((this.d != 2) && ((bool2) || (this.d != 1)))
          {
            long l2 = l1;
            if (bool1)
            {
              l2 = l1;
              if (this.e.size() > 0) {
                l2 = Math.min(l1, this.c);
              }
            }
            this.d = 0;
            this.h = Thread.currentThread();
            this.g.a = this.b;
            this.g.c = k;
            this.g.b = l2;
            this.g.d = bool2;
            this.g.e = null;
            synchronized (this.g)
            {
              this.i = new Thread(this.g);
              this.i.start();
              try
              {
                this.g.wait();
                localCursor = this.g.e;
              }
              catch (InterruptedException localInterruptedException)
              {
                Cursor localCursor;
                int i2;
                int i3;
                int i4;
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
                  if ((this.e.size() >= 5) || (localCursor.getCount() <= 1)) {
                    break label1142;
                  }
                  k = 1;
                  if (this.e.size() > 0) {
                    this.e.remove(this.e.size() - 1);
                  }
                  ??? = new FavoriteSearchResultModel();
                  ((FavoriteSearchResultModel)???).d = paramSearchRequest.a;
                  ((FavoriteSearchResultModel)???).a = localCursor.getLong(0);
                  ((FavoriteSearchResultModel)???).b = localCursor.getLong(4);
                  ((FavoriteSearchResultModel)???).c = localCursor.getLong(5);
                  ((FavoriteSearchResultModel)???).e = localCursor.getString(1);
                  m = 2;
                  ((FavoriteSearchResultModel)???).f = localCursor.getString(2);
                  ((FavoriteSearchResultModel)???).j = localCursor.getString(3);
                  ((FavoriteSearchResultModel)???).m = localCursor.getInt(6);
                  ((FavoriteSearchResultModel)???).k = localCursor.getInt(8);
                  ((FavoriteSearchResultModel)???).l = localCursor.getBlob(7);
                  ((FavoriteSearchResultModel)???).n = localCursor.getInt(9);
                  if (localCursor.getInt(10) <= 0) {
                    break label1147;
                  }
                  bool3 = true;
                  ((FavoriteSearchResultModel)???).o = bool3;
                  ((FavoriteSearchResultModel)???).h = localCursor.getInt(11);
                  ((FavoriteSearchResultModel)???).i = localCursor.getInt(12);
                  ((FavoriteSearchResultModel)???).g = localCursor.getInt(13);
                  ((FavoriteSearchResultModel)???).p = localCursor.getInt(14);
                  ((FavoriteSearchResultModel)???).q = this.e.size();
                  this.e.add(???);
                  if (localCursor.moveToNext()) {
                    break label1194;
                  }
                  if (((FavoriteSearchResultModel)???).a < 0L) {
                    if (((FavoriteSearchResultModel)???).a == -2L)
                    {
                      this.c = ((FavoriteSearchResultModel)???).b;
                      if (!bool2) {
                        break label1153;
                      }
                      this.d = m;
                    }
                    else if ((localCursor.getCount() <= 1) && (l2 <= ((FavoriteSearchResultModel)???).b))
                    {
                      this.d = -1;
                    }
                    else
                    {
                      this.c = ((FavoriteSearchResultModel)???).b;
                    }
                  }
                  if (k != 0)
                  {
                    i1 = Math.min(4, this.e.size() - 1);
                    k = n;
                    break label1158;
                    if (m <= 0) {
                      break label1187;
                    }
                    i2 = n - m;
                    paramSearchRequest = (FavoriteSearchResultModel)this.e.get(i2);
                    i3 = paramSearchRequest.p;
                    ??? = this.e;
                    i4 = i2 + 1;
                    if (i3 <= ((FavoriteSearchResultModel)((List)???).get(i4)).p) {
                      break label1180;
                    }
                    this.e.set(i2, this.e.get(i4));
                    this.e.set(i4, paramSearchRequest);
                    break label1180;
                  }
                }
                else
                {
                  this.d = -1;
                }
                localCursor.close();
              }
              else
              {
                this.d = -1;
              }
              if ((this.d == -1) && (this.e.size() > 0)) {
                ((FavoriteSearchResultModel)this.e.get(this.e.size() - 1)).a = -3L;
              }
              paramSearchRequest = new ArrayList(this.e);
              if (!bool1) {
                if (this.e.size() > 1) {
                  paramSearchRequest.remove(paramSearchRequest.size() - 1);
                } else {
                  paramSearchRequest = null;
                }
              }
              return paramSearchRequest;
            }
          }
          paramSearchRequest = new ArrayList(this.e);
          if (!bool1) {
            if (this.e.size() > 1) {
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
      int k = 1;
      boolean bool1 = false;
      boolean bool2 = false;
      continue;
      label1136:
      Object localObject1 = null;
      continue;
      label1142:
      k = 0;
      continue;
      label1147:
      boolean bool3 = false;
      continue;
      int m = 1;
      continue;
      for (;;)
      {
        if (k >= i1 - 1) {
          break label1192;
        }
        n = i1 - k - 1;
        m = n;
        break;
        m -= 1;
        break;
        k += 1;
      }
    }
  }
  
  public void a()
  {
    if (!f) {
      f = QfavHelper.a(false);
    }
  }
  
  public void a(SearchRequest paramSearchRequest, ISearchListener<FavoriteSearchResultModel> paramISearchListener)
  {
    if ((paramSearchRequest != null) && (paramSearchRequest.a != null))
    {
      if (paramSearchRequest.a.trim().length() == 0) {
        return;
      }
      synchronized (this.j)
      {
        this.j.a = paramSearchRequest;
        this.j.b = paramISearchListener;
        ThreadManager.removeJobFromThreadPool(this.j, 32);
        ThreadManager.excute(this.j, 32, null, false);
        return;
      }
    }
  }
  
  public void b()
  {
    synchronized (this.j)
    {
      this.j.a = null;
      this.j.b = null;
      ThreadManager.removeJobFromThreadPool(this.j, 32);
      ??? = this.h;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qqfav.globalsearch.FavoriteSearchEngine
 * JD-Core Version:    0.7.0.1
 */