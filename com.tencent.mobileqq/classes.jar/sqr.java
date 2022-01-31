import android.support.annotation.NonNull;
import android.text.TextUtils;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.List<Lspz;>;

public class sqr
  extends sqn<sqv>
{
  static SimpleDateFormat jdField_a_of_type_JavaTextSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
  private int jdField_a_of_type_Int = 1;
  private sqm jdField_a_of_type_Sqm;
  
  private int a(List<spz> paramList)
  {
    int i = 1;
    new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    long l2 = -1L;
    int m = 0;
    for (;;)
    {
      int j;
      long l1;
      int k;
      if (m < paramList.size())
      {
        if (l2 < 0L) {
          j = i;
        }
        try
        {
          l1 = a(((spz)paramList.get(m)).b);
          k = i;
        }
        catch (ParseException localParseException)
        {
          localParseException.printStackTrace();
          vxp.a("we found the error time pic:" + paramList.get(m), new Object[0]);
          k = j;
          l1 = l2;
        }
        j = i;
        k = i;
        l1 = l2;
        if (((spz)paramList.get(m)).b - l2 > 86400L)
        {
          k = i + 1;
          j = k;
          l1 = a(((spz)paramList.get(m)).b);
        }
      }
      else
      {
        ved.d("Q.qqstory.recommendAlbum.logic.StoryScanManager.KMeansSplitStrategy", "caculatePictureDistribution=" + i);
        return i;
      }
      m += 1;
      i = k;
      l2 = l1;
    }
  }
  
  private long a(long paramLong)
  {
    return jdField_a_of_type_JavaTextSimpleDateFormat.parse(jdField_a_of_type_JavaTextSimpleDateFormat.format(Long.valueOf(paramLong * 1000L))).getTime() / 1000L;
  }
  
  protected List<spy> a(@NonNull List<spz> paramList)
  {
    Object localObject1 = new sri();
    paramList = new ArrayList(paramList);
    spn.b(paramList);
    int i = a(paramList) / this.jdField_a_of_type_Int;
    String[] arrayOfString = new String[1];
    ((sri)localObject1).a(i + 1);
    paramList = ((sri)localObject1).a(paramList, arrayOfString);
    ArrayList localArrayList = new ArrayList();
    i = 0;
    while (i < paramList.size())
    {
      localObject1 = (List)paramList.get(i);
      Collections.sort((List)localObject1, new sqs(this));
      localObject2 = new spy(this.jdField_a_of_type_Spy.jdField_a_of_type_Int, (List)localObject1);
      ((spy)localObject2).a(((spz)((List)localObject1).get(0)).b, ((spz)((List)localObject1).get(((List)localObject1).size() - 1)).b);
      localArrayList.add(localObject2);
      i += 1;
    }
    paramList = "k means split : k=" + localArrayList.size();
    Collections.sort(localArrayList, new sqt(this));
    localObject1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Object localObject2 = localArrayList.iterator();
    Object localObject3;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (spy)((Iterator)localObject2).next();
      paramList = paramList + "[ s=" + ((SimpleDateFormat)localObject1).format(Long.valueOf(((spy)localObject3).f() * 1000L)) + " e=" + ((SimpleDateFormat)localObject1).format(Long.valueOf(((spy)localObject3).g() * 1000L)) + " c=" + ((spy)localObject3).b() + "]";
    }
    ved.d("Q.qqstory.recommendAlbum.logic.StoryScanManager.KMeansSplitStrategy", paramList);
    localObject2 = "(k=" + localArrayList.size() + " " + paramList + ");";
    paramList = (String)((tcs)tcz.a(10)).b("key_album_debug_k", "");
    if (!TextUtils.isEmpty(paramList))
    {
      localObject3 = paramList.split(";");
      paramList = "";
      i = 0;
      localObject1 = paramList;
      if (i < localObject3.length)
      {
        paramList = localObject3[i] + paramList;
        if (i != 8) {
          break label500;
        }
        localObject1 = paramList;
      }
    }
    for (paramList = (String)localObject2 + (String)localObject1;; paramList = (List<spz>)localObject2)
    {
      this.jdField_a_of_type_Sqm.a = paramList;
      this.jdField_a_of_type_Sqm.b = arrayOfString[0];
      return localArrayList;
      label500:
      i += 1;
      break;
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(sqm paramsqm)
  {
    this.jdField_a_of_type_Sqm = paramsqm;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     sqr
 * JD-Core Version:    0.7.0.1
 */