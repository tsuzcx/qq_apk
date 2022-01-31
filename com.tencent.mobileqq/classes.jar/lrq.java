import com.tencent.ttpic.openapi.config.BeautyRealConfig.TYPE;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class lrq
{
  private final LinkedHashMap<String, lrr> jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap(12);
  private boolean jdField_a_of_type_Boolean;
  
  public lrq()
  {
    d();
  }
  
  private void d()
  {
    this.jdField_a_of_type_JavaUtilLinkedHashMap.clear();
    this.jdField_a_of_type_JavaUtilLinkedHashMap.put("BEAUTY_SKIN", new lrr(null, 1, 50, 0));
    this.jdField_a_of_type_JavaUtilLinkedHashMap.put("COLOR_TONE", new lrr(BeautyRealConfig.TYPE.COLOR_TONE, 2, 50, 50));
    this.jdField_a_of_type_JavaUtilLinkedHashMap.put("EYE_LIGHTEN", new lrr(BeautyRealConfig.TYPE.EYE_LIGHTEN, 2, 0, 0));
    this.jdField_a_of_type_JavaUtilLinkedHashMap.put("TOOTH_WHITEN", new lrr(BeautyRealConfig.TYPE.TOOTH_WHITEN, 2, 0, 0));
    this.jdField_a_of_type_JavaUtilLinkedHashMap.put("ENLARGE_EYE", new lrr(BeautyRealConfig.TYPE.EYE, 3, 0, 0));
    this.jdField_a_of_type_JavaUtilLinkedHashMap.put("MOUTH_SHAPE", new lrr(BeautyRealConfig.TYPE.MOUTH_SHAPE, 3, 50, 50));
    this.jdField_a_of_type_JavaUtilLinkedHashMap.put("CHIN", new lrr(BeautyRealConfig.TYPE.CHIN, 3, 50, 50));
    this.jdField_a_of_type_JavaUtilLinkedHashMap.put("FACE_THIN", new lrr(BeautyRealConfig.TYPE.FACE_THIN, 3, 0, 0));
    this.jdField_a_of_type_JavaUtilLinkedHashMap.put("FACE_V", new lrr(BeautyRealConfig.TYPE.FACE_V, 3, 0, 0));
    this.jdField_a_of_type_JavaUtilLinkedHashMap.put("FACE_SHAPE_4", new lrr(BeautyRealConfig.TYPE.BASIC4, 3, 40, 0));
    this.jdField_a_of_type_JavaUtilLinkedHashMap.put("FACE_SHORTEN", new lrr(BeautyRealConfig.TYPE.FACE_SHORTEN, 3, 0, 0));
    this.jdField_a_of_type_JavaUtilLinkedHashMap.put("NOSE_THIN", new lrr(BeautyRealConfig.TYPE.NOSE, 3, 0, 0));
  }
  
  public int a(String paramString)
  {
    paramString = (lrr)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(paramString);
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
    int i = 0;
    if (i < localArrayList.size())
    {
      String str = (String)localArrayList.get(i);
      lrr locallrr = (lrr)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(str);
      if (locallrr == null) {}
      for (;;)
      {
        i += 1;
        break;
        if (i != 0) {
          localStringBuilder.append(",");
        }
        localStringBuilder.append(str).append(":").append(locallrr.d);
      }
    }
    return localStringBuilder.toString();
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  void a(int paramInt, List<lrr> paramList)
  {
    if (paramList == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedHashMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        lrr locallrr = (lrr)((Map.Entry)localIterator.next()).getValue();
        if ((locallrr != null) && ((paramInt == 0) || (locallrr.a == paramInt))) {
          paramList.add(locallrr);
        }
      }
    }
  }
  
  public void a(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return;
    }
    paramString = paramString.split(",");
    int j = paramString.length;
    int i = 0;
    label24:
    Object localObject1;
    if (i < j)
    {
      localObject1 = paramString[i];
      if (localObject1 != null) {
        break label46;
      }
    }
    for (;;)
    {
      i += 1;
      break label24;
      break;
      label46:
      localObject1 = ((String)localObject1).split(":");
      if (localObject1.length == 2)
      {
        Object localObject2 = localObject1[0];
        try
        {
          int k = Integer.parseInt(localObject1[1]);
          localObject1 = (lrr)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(localObject2);
          if (localObject1 != null) {
            ((lrr)localObject1).d = k;
          }
        }
        catch (NumberFormatException localNumberFormatException)
        {
          localNumberFormatException.printStackTrace();
        }
      }
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    paramString = (lrr)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(paramString);
    if ((paramString != null) && (paramString.d != paramInt))
    {
      paramString.d = paramInt;
      this.jdField_a_of_type_Boolean = true;
    }
  }
  
  public void a(lrq paramlrq)
  {
    if (paramlrq == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = paramlrq.jdField_a_of_type_JavaUtilLinkedHashMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        lrr locallrr = (lrr)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(str);
        if (locallrr != null) {
          locallrr.d = paramlrq.a(str);
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
    paramString = (lrr)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(paramString);
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
      lrr locallrr = (lrr)((Map.Entry)localIterator.next()).getValue();
      if ((locallrr != null) && (locallrr.d != locallrr.b))
      {
        locallrr.d = locallrr.b;
        this.jdField_a_of_type_Boolean = true;
      }
    }
  }
  
  public boolean b()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedHashMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      lrr locallrr = (lrr)((Map.Entry)localIterator.next()).getValue();
      if ((locallrr != null) && (locallrr.d != locallrr.c)) {
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
      lrr locallrr = (lrr)((Map.Entry)localIterator.next()).getValue();
      if ((locallrr != null) && (locallrr.d != locallrr.c))
      {
        locallrr.d = locallrr.c;
        this.jdField_a_of_type_Boolean = true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     lrq
 * JD-Core Version:    0.7.0.1
 */