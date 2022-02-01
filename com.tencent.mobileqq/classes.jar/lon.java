import android.text.TextUtils;
import com.tencent.av.opengl.effects.AEFilterSupport;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.config.BeautyRealConfig.TYPE;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class lon
{
  private final LinkedHashMap<String, loo> jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap(12);
  private boolean jdField_a_of_type_Boolean;
  private boolean b = true;
  
  public lon()
  {
    d();
  }
  
  private void d()
  {
    if (AEFilterSupport.a() >= 7) {
      this.b = false;
    }
    this.jdField_a_of_type_JavaUtilLinkedHashMap.clear();
    this.jdField_a_of_type_JavaUtilLinkedHashMap.put("BEAUTY_SKIN", new loo(null, 1, 50, 0));
    if (this.b)
    {
      this.jdField_a_of_type_JavaUtilLinkedHashMap.put("COLOR_TONE", new loo(BeautyRealConfig.TYPE.COLOR_TONE, 2, 50, 50));
      this.jdField_a_of_type_JavaUtilLinkedHashMap.put("EYE_LIGHTEN", new loo(BeautyRealConfig.TYPE.EYE_LIGHTEN, 2, 0, 0));
      this.jdField_a_of_type_JavaUtilLinkedHashMap.put("TOOTH_WHITEN", new loo(BeautyRealConfig.TYPE.TOOTH_WHITEN, 2, 0, 0));
      this.jdField_a_of_type_JavaUtilLinkedHashMap.put("ENLARGE_EYE", new loo(BeautyRealConfig.TYPE.EYE, 3, 0, 0));
      this.jdField_a_of_type_JavaUtilLinkedHashMap.put("MOUTH_SHAPE", new loo(BeautyRealConfig.TYPE.MOUTH_SHAPE, 3, 50, 50));
      this.jdField_a_of_type_JavaUtilLinkedHashMap.put("CHIN", new loo(BeautyRealConfig.TYPE.CHIN, 3, 50, 50));
      this.jdField_a_of_type_JavaUtilLinkedHashMap.put("FACE_THIN", new loo(BeautyRealConfig.TYPE.FACE_THIN, 3, 0, 0));
      this.jdField_a_of_type_JavaUtilLinkedHashMap.put("FACE_V", new loo(BeautyRealConfig.TYPE.FACE_V, 3, 0, 0));
      this.jdField_a_of_type_JavaUtilLinkedHashMap.put("FACE_SHAPE_4", new loo(BeautyRealConfig.TYPE.BASIC4, 3, 0, 0));
      this.jdField_a_of_type_JavaUtilLinkedHashMap.put("FACE_SHORTEN", new loo(BeautyRealConfig.TYPE.FACE_SHORTEN, 3, 0, 0));
      this.jdField_a_of_type_JavaUtilLinkedHashMap.put("NOSE_THIN", new loo(BeautyRealConfig.TYPE.NOSE, 3, 0, 0));
      return;
    }
    this.jdField_a_of_type_JavaUtilLinkedHashMap.put("COLOR_TONE", new loo(BeautyRealConfig.TYPE.COLOR_TONE, 2, 50, 50));
    this.jdField_a_of_type_JavaUtilLinkedHashMap.put("EYE_LIGHTEN", new loo(BeautyRealConfig.TYPE.EYE_LIGHTEN, 2, 0, 0));
    this.jdField_a_of_type_JavaUtilLinkedHashMap.put("TOOTH_WHITEN", new loo(BeautyRealConfig.TYPE.TOOTH_WHITEN, 2, 0, 0));
    this.jdField_a_of_type_JavaUtilLinkedHashMap.put("ENLARGE_EYE", new loo(BeautyRealConfig.TYPE.EYE, 3, 0, 0));
    this.jdField_a_of_type_JavaUtilLinkedHashMap.put("MOUTH_SHAPE", new loo(BeautyRealConfig.TYPE.MOUTH_SHAPE, 3, 50, 50));
    this.jdField_a_of_type_JavaUtilLinkedHashMap.put("CHIN", new loo(BeautyRealConfig.TYPE.CHIN, 3, 50, 50));
    this.jdField_a_of_type_JavaUtilLinkedHashMap.put("FACE_THIN", new loo(BeautyRealConfig.TYPE.FACE_THIN, 3, 0, 0));
    this.jdField_a_of_type_JavaUtilLinkedHashMap.put("FACE_V", new loo(BeautyRealConfig.TYPE.FACE_V, 3, 0, 0));
    this.jdField_a_of_type_JavaUtilLinkedHashMap.put("FACE_SHAPE_4", new loo(BeautyRealConfig.TYPE.BASIC4, 3, 40, 0));
    this.jdField_a_of_type_JavaUtilLinkedHashMap.put("FACE_SHORTEN", new loo(BeautyRealConfig.TYPE.FACE_SHORTEN, 3, 0, 0));
    this.jdField_a_of_type_JavaUtilLinkedHashMap.put("NOSE_THIN", new loo(BeautyRealConfig.TYPE.NOSE, 3, 0, 0));
  }
  
  public int a(String paramString)
  {
    paramString = (loo)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(paramString);
    if (paramString != null) {
      return paramString.d;
    }
    return 0;
  }
  
  public String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    ArrayList localArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilLinkedHashMap.keySet());
    Collections.sort(localArrayList);
    localStringBuilder.append("VERSION").append(":").append(1);
    int i = 0;
    if (i < localArrayList.size())
    {
      String str = (String)localArrayList.get(i);
      loo localloo = (loo)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(str);
      if (localloo == null) {}
      for (;;)
      {
        i += 1;
        break;
        if (localloo.d != localloo.b) {
          localStringBuilder.append(",").append(str).append(":").append(localloo.d);
        }
      }
    }
    if (QLog.isDevelopLevel()) {
      QLog.i("BeautyConfig", 4, "getConfigStr, config[" + localStringBuilder.toString() + "]");
    }
    return localStringBuilder.toString();
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  void a(int paramInt, List<loo> paramList)
  {
    if (paramList == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedHashMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        loo localloo = (loo)((Map.Entry)localIterator.next()).getValue();
        if ((localloo != null) && ((paramInt == 0) || (localloo.jdField_a_of_type_Int == paramInt))) {
          paramList.add(localloo);
        }
      }
    }
  }
  
  public void a(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return;
    }
    int i = -1;
    Object localObject1 = paramString.split(",");
    int m = localObject1.length;
    int j = 0;
    label29:
    Object localObject2;
    int k;
    if (j < m)
    {
      localObject2 = localObject1[j];
      if (localObject2 == null) {
        k = i;
      }
    }
    for (;;)
    {
      j += 1;
      i = k;
      break label29;
      localObject2 = ((String)localObject2).split(":");
      k = i;
      if (localObject2.length == 2)
      {
        CharSequence localCharSequence = localObject2[0];
        try
        {
          k = Integer.parseInt(localObject2[1]);
          if (TextUtils.equals(localCharSequence, "VERSION"))
          {
            i = k;
          }
          else
          {
            localObject2 = (loo)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(localCharSequence);
            if (localObject2 != null) {
              ((loo)localObject2).d = k;
            }
          }
        }
        catch (NumberFormatException localNumberFormatException)
        {
          localNumberFormatException.printStackTrace();
          k = i;
        }
        continue;
        if ((i < 1) && (this.b))
        {
          localObject1 = this.jdField_a_of_type_JavaUtilLinkedHashMap.entrySet().iterator();
          for (i = 1; ((Iterator)localObject1).hasNext(); i = 0)
          {
            label179:
            loo localloo = (loo)((Map.Entry)((Iterator)localObject1).next()).getValue();
            if ((localloo == null) || (localloo.jdField_a_of_type_Int == 1) || (localloo.jdField_a_of_type_ComTencentTtpicOpenapiConfigBeautyRealConfig$TYPE == BeautyRealConfig.TYPE.BASIC4)) {
              break label179;
            }
            if (localloo.d == localloo.b) {
              break label321;
            }
          }
        }
        label321:
        for (;;)
        {
          break label179;
          j = i;
          if (i != 0)
          {
            j = i;
            if (a("FACE_SHAPE_4") != 40) {
              j = 0;
            }
          }
          if (j != 0) {
            a("FACE_SHAPE_4", 0);
          }
          if (!QLog.isDevelopLevel()) {
            break;
          }
          QLog.i("BeautyConfig", 4, "parseConfig, config[" + paramString + "]");
          return;
        }
        k = i;
      }
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    paramString = (loo)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(paramString);
    if ((paramString != null) && (paramString.d != paramInt))
    {
      paramString.d = paramInt;
      this.jdField_a_of_type_Boolean = true;
    }
  }
  
  public void a(lon paramlon)
  {
    if (paramlon == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = paramlon.jdField_a_of_type_JavaUtilLinkedHashMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        loo localloo = (loo)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(str);
        if (localloo != null) {
          localloo.d = paramlon.a(str);
        }
      }
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public int b(String paramString)
  {
    paramString = (loo)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(paramString);
    if (paramString != null) {
      return paramString.c;
    }
    return 0;
  }
  
  public void b()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedHashMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      loo localloo = (loo)((Map.Entry)localIterator.next()).getValue();
      if ((localloo != null) && (localloo.d != localloo.b))
      {
        localloo.d = localloo.b;
        this.jdField_a_of_type_Boolean = true;
      }
    }
  }
  
  public boolean b()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedHashMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      loo localloo = (loo)((Map.Entry)localIterator.next()).getValue();
      if ((localloo != null) && (localloo.d != localloo.c)) {
        return true;
      }
    }
    return false;
  }
  
  public void c()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedHashMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      loo localloo = (loo)((Map.Entry)localIterator.next()).getValue();
      if ((localloo != null) && (localloo.d != localloo.c))
      {
        localloo.d = localloo.c;
        this.jdField_a_of_type_Boolean = true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lon
 * JD-Core Version:    0.7.0.1
 */