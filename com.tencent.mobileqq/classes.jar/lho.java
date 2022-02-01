import android.text.TextUtils;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class lho
{
  public static lho a;
  public int a;
  public List<lhp> a;
  public boolean a;
  public int b = 0;
  
  public lho()
  {
    this.jdField_a_of_type_Int = 0;
  }
  
  public static int a()
  {
    lho locallho = a();
    if (locallho != null) {
      return locallho.b;
    }
    return 3;
  }
  
  public static List<lhp> a()
  {
    lho locallho = a();
    if (locallho != null) {
      return locallho.jdField_a_of_type_JavaUtilList;
    }
    return null;
  }
  
  public static lho a()
  {
    if ((jdField_a_of_type_Lho == null) || (jdField_a_of_type_Lho.jdField_a_of_type_Boolean)) {
      jdField_a_of_type_Lho = b();
    }
    return jdField_a_of_type_Lho;
  }
  
  public static boolean a()
  {
    lho locallho = a();
    return (locallho != null) && (locallho.jdField_a_of_type_Int == 1);
  }
  
  private static lho b()
  {
    int i1 = 3;
    boolean bool = false;
    if (QLog.isColorLevel()) {
      QLog.d("PanoramaEffectDPC", 2, "loadPanoramaEffectDPC!");
    }
    String str = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.AVPanCfg.name());
    QLog.i("PanoramaEffectDPC", 2, "loadPanoramaEffectDPC dpcValue: " + str);
    ArrayList localArrayList = new ArrayList();
    int i;
    int k;
    int m;
    int n;
    if (!TextUtils.isEmpty(str)) {
      for (;;)
      {
        try
        {
          Object localObject1 = str.split("\\|");
          if ((localObject1 != null) && (localObject1.length >= 3))
          {
            j = avuq.a(localObject1[0], 0);
            localObject3 = localObject1[1];
            i = j;
          }
          try
          {
            if (!TextUtils.isEmpty((CharSequence)localObject3))
            {
              i = j;
              localObject3 = ((String)localObject3).split("-");
              k = 0;
              i = j;
              if (k < localObject3.length)
              {
                Object localObject4 = localObject3[k];
                i = j;
                if (TextUtils.isEmpty((CharSequence)localObject4)) {
                  break label623;
                }
                i = j;
                localObject4 = ((String)localObject4).split("_");
                i = j;
                if (localObject4.length < 2) {
                  break label615;
                }
                i = j;
                m = avuq.a(localObject4[0], 0);
                i = j;
                n = avuq.a(localObject4[1], 0);
                label204:
                if ((m <= 0) || (n <= 0)) {
                  break label623;
                }
                i = j;
                localArrayList.add(new lhp(n, m));
                break label623;
              }
            }
            i = j;
            k = avuq.a(localObject1[2], 3);
            i = j;
            label249:
            if (localArrayList.size() == 0)
            {
              localArrayList.add(new lhp(215, 4));
              localArrayList.add(new lhp(150, 8));
            }
            localObject1 = new lho();
            ((lho)localObject1).jdField_a_of_type_Int = i;
            ((lho)localObject1).b = k;
            ((lho)localObject1).jdField_a_of_type_JavaUtilList = localArrayList;
            if ((str == null) || (str.isEmpty())) {
              bool = true;
            }
            ((lho)localObject1).jdField_a_of_type_Boolean = bool;
            return localObject1;
          }
          catch (Exception localException1)
          {
            j = i;
          }
          if ((localObject1 == null) || (localObject1.length != 1)) {
            continue;
          }
          j = avuq.a(localObject1[0], 0);
          i = j;
          QLog.i("PanoramaEffectDPC", 2, "loadPanoramaEffectDPC configs.length == 1");
          k = i1;
          i = j;
          continue;
        }
        catch (Exception localException2)
        {
          Object localObject3;
          Object localObject2;
          int j = 0;
          continue;
          m = 0;
          n = 0;
          continue;
        }
        k = i1;
        i = j;
        if (QLog.isColorLevel())
        {
          QLog.e("PanoramaEffectDPC", 2, "loadPanoramaEffectDPC exception:", localException1);
          k = i1;
          i = j;
          continue;
          if ((localException1 != null) && (localException1.length == 2))
          {
            j = avuq.a(localException1[0], 0);
            localObject2 = localException1[1];
            i = j;
            if (!TextUtils.isEmpty((CharSequence)localObject2))
            {
              i = j;
              localObject2 = ((String)localObject2).split("-");
              k = 0;
            }
          }
        }
      }
    }
    for (;;)
    {
      i = j;
      if (k < localObject2.length)
      {
        localObject3 = localObject2[k];
        i = j;
        if (TextUtils.isEmpty((CharSequence)localObject3)) {
          break label630;
        }
        i = j;
        localObject3 = ((String)localObject3).split("_");
        i = j;
        if (localObject3.length >= 2)
        {
          i = j;
          m = avuq.a(localObject3[0], 0);
          i = j;
          n = avuq.a(localObject3[1], 0);
          if ((m <= 0) || (n <= 0)) {
            break label630;
          }
          i = j;
          localArrayList.add(new lhp(n, m));
          break label630;
        }
      }
      else
      {
        i = j;
        QLog.i("PanoramaEffectDPC", 2, "loadPanoramaEffectDPC configs.length == 2");
        k = i1;
        i = j;
        break label249;
      }
      i = 0;
      k = i1;
      break label249;
      label615:
      m = 0;
      n = 0;
      break label204;
      label623:
      k += 1;
      break;
      label630:
      k += 1;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("hotVideoSwitch: ").append(this.jdField_a_of_type_Int);
    localStringBuilder.append(" mPanoramaEffectMemory: ").append(this.b);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    String str = "";
    while (localIterator.hasNext())
    {
      lhp locallhp = (lhp)localIterator.next();
      if (locallhp != null) {
        str = str + locallhp.b + "_" + locallhp.jdField_a_of_type_Int + "-";
      }
    }
    localStringBuilder.append(" hotVideoBlurMemory: ").append(str);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lho
 * JD-Core Version:    0.7.0.1
 */