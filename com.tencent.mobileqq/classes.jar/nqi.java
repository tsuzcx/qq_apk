import android.util.Log;
import com.tencent.biz.qqstory.playvideo.player.mediaplayer.MediaPlayer.SeekMode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class nqi
{
  private List jdField_a_of_type_JavaUtilList = new ArrayList();
  private nqj jdField_a_of_type_Nqj;
  private nqn jdField_a_of_type_Nqn;
  
  public long a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    long l1 = 9223372036854775807L;
    if (localIterator.hasNext())
    {
      long l2 = ((nqk)localIterator.next()).a();
      if ((l2 == -9223372036854775808L) || (l1 <= l2)) {
        break label60;
      }
      l1 = l2;
    }
    label60:
    for (;;)
    {
      break;
      return l1;
    }
  }
  
  public List a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public nql a(boolean paramBoolean)
  {
    Object localObject2 = null;
    int i = 0;
    Object localObject1;
    label24:
    nqk localnqk;
    label46:
    nql localnql;
    if (i == 0)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      localObject1 = null;
      i = 0;
      if (localIterator.hasNext())
      {
        localnqk = (nqk)localIterator.next();
        localnql = localnqk.a();
        if (localnql == null) {
          break label151;
        }
        if (localnqk == this.jdField_a_of_type_Nqn)
        {
          localObject1 = localnql;
          label70:
          if (localnqk.a(false)) {
            break label152;
          }
          if (!localnqk.b()) {
            break label154;
          }
          i += 1;
        }
      }
    }
    label151:
    label152:
    label154:
    for (;;)
    {
      break label24;
      localnqk.a(localnql, 0L);
      break label46;
      if (localObject1 != null) {}
      do
      {
        return localObject1;
        localObject1 = localObject2;
      } while (!paramBoolean);
      if (i == this.jdField_a_of_type_JavaUtilList.size())
      {
        i = 1;
        break;
      }
      i = 0;
      break;
      Log.d("Decoders", "EOS NULL");
      return null;
      break label70;
      break label70;
    }
  }
  
  public nqn a()
  {
    return this.jdField_a_of_type_Nqn;
  }
  
  public void a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((nqk)localIterator.next()).e();
    }
    this.jdField_a_of_type_JavaUtilList.clear();
  }
  
  public void a(MediaPlayer.SeekMode paramSeekMode, long paramLong)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((nqk)localIterator.next()).a(paramSeekMode, paramLong);
    }
  }
  
  public void a(nqk paramnqk)
  {
    this.jdField_a_of_type_JavaUtilList.add(paramnqk);
    if ((paramnqk instanceof nqn)) {
      this.jdField_a_of_type_Nqn = ((nqn)paramnqk);
    }
    while (!(paramnqk instanceof nqj)) {
      return;
    }
    this.jdField_a_of_type_Nqj = ((nqj)paramnqk);
  }
  
  public boolean a()
  {
    boolean bool = false;
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      if (!((nqk)localIterator.next()).b()) {
        break label62;
      }
      i += 1;
    }
    label62:
    for (;;)
    {
      break;
      if (i == this.jdField_a_of_type_JavaUtilList.size()) {
        bool = true;
      }
      return bool;
    }
  }
  
  public long b()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    for (long l1 = 9223372036854775807L; localIterator.hasNext(); l1 = Math.min(((nqk)localIterator.next()).b(), l1)) {}
    long l2 = l1;
    if (l1 == 9223372036854775807L) {
      l2 = -1L;
    }
    return l2;
  }
  
  public void b()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((nqk)localIterator.next()).c();
    }
  }
  
  public boolean b()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      if (!((nqk)localIterator.next()).d()) {
        return false;
      }
    }
    return true;
  }
  
  public void c()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((nqk)localIterator.next()).d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nqi
 * JD-Core Version:    0.7.0.1
 */