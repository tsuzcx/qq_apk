import android.text.TextUtils;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.video.bandwidth.VideoBufferRangeController.1;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class rmc
  implements Comparator<Integer[]>
{
  private static rmc a;
  
  private int a(List<Integer[]> paramList, long paramLong, int paramInt)
  {
    if ((paramLong > 0L) && (paramInt > 0))
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        Integer[] arrayOfInteger = (Integer[])localIterator.next();
        if (paramLong > arrayOfInteger[0].intValue() * paramInt / 8) {
          return arrayOfInteger[1].intValue();
        }
      }
    }
    if (!paramList.isEmpty())
    {
      paramList = (Integer[])paramList.get(paramList.size() - 1);
      if (paramList[0].intValue() <= 0) {
        return paramList[1].intValue();
      }
    }
    return 0;
  }
  
  private List<Integer[]> a()
  {
    return a("emergency_time_config");
  }
  
  private List<Integer[]> a(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = Aladdin.getConfig(288).getString(paramString, null);
    if (QLog.isColorLevel()) {
      QLog.d("VideoBufferRangeController", 2, "decodeConfigs: key=" + paramString + ", configStr=" + (String)localObject);
    }
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return localArrayList;
    }
    paramString = ((String)localObject).split("\\|");
    int j = paramString.length;
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        localObject = paramString[i].split(",");
        if (localObject.length == 2) {}
        try
        {
          localArrayList.add(new Integer[] { Integer.valueOf(localObject[0]), Integer.valueOf(localObject[1]) });
          i += 1;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.e("VideoBufferRangeController", 2, "getConfigs: ", localException);
            }
          }
        }
      }
    }
    Collections.sort(localArrayList, this);
    return localArrayList;
  }
  
  public static rmc a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new rmc();
      }
      return a;
    }
    finally {}
  }
  
  private List<Integer[]> b()
  {
    return a("safe_play_time_config");
  }
  
  public int a(Integer[] paramArrayOfInteger1, Integer[] paramArrayOfInteger2)
  {
    return paramArrayOfInteger2[0].intValue() - paramArrayOfInteger1[0].intValue();
  }
  
  public String a()
  {
    return Aladdin.getConfig(288).getString("buffer_range_report_tag", null);
  }
  
  public void a(rjn paramrjn, int paramInt, long paramLong)
  {
    rdm.a(new VideoBufferRangeController.1(this, paramrjn, a().a(paramInt, paramLong)));
  }
  
  public int[] a(long paramLong1, long paramLong2)
  {
    long l = rlt.a().a();
    if ((paramLong2 > 0L) && (paramLong1 > 0L)) {}
    for (int i = (int)(paramLong2 / 1024L * 8L / paramLong1);; i = 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoBufferRangeController", 2, "getBufferRange: fileSize=" + paramLong2 + ", duration=" + paramLong1);
      }
      List localList1 = a();
      List localList2 = b();
      int j = a(localList1, l, i);
      int k = a(localList2, l, i);
      if (QLog.isColorLevel()) {
        QLog.d("VideoBufferRangeController", 2, "getBufferRange: bandwidth=" + l + ", bitrate=" + i + ", range=" + j + ", " + k);
      }
      return new int[] { j, k };
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rmc
 * JD-Core Version:    0.7.0.1
 */