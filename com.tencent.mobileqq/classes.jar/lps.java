import com.tencent.ttpic.openapi.config.BeautyRealConfig.TYPE;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class lps
{
  private final LinkedHashMap<String, lpt> jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap(12);
  private boolean jdField_a_of_type_Boolean;
  
  public lps()
  {
    d();
  }
  
  private void d()
  {
    this.jdField_a_of_type_JavaUtilLinkedHashMap.clear();
    this.jdField_a_of_type_JavaUtilLinkedHashMap.put("BEAUTY_SKIN", new lpt(null, 1, 50, 0));
    this.jdField_a_of_type_JavaUtilLinkedHashMap.put("COLOR_TONE", new lpt(BeautyRealConfig.TYPE.COLOR_TONE, 2, 50, 50));
    this.jdField_a_of_type_JavaUtilLinkedHashMap.put("EYE_LIGHTEN", new lpt(BeautyRealConfig.TYPE.EYE_LIGHTEN, 2, 0, 0));
    this.jdField_a_of_type_JavaUtilLinkedHashMap.put("TOOTH_WHITEN", new lpt(BeautyRealConfig.TYPE.TOOTH_WHITEN, 2, 0, 0));
    this.jdField_a_of_type_JavaUtilLinkedHashMap.put("ENLARGE_EYE", new lpt(BeautyRealConfig.TYPE.EYE, 3, 0, 0));
    this.jdField_a_of_type_JavaUtilLinkedHashMap.put("MOUTH_SHAPE", new lpt(BeautyRealConfig.TYPE.MOUTH_SHAPE, 3, 50, 50));
    this.jdField_a_of_type_JavaUtilLinkedHashMap.put("CHIN", new lpt(BeautyRealConfig.TYPE.CHIN, 3, 50, 50));
    this.jdField_a_of_type_JavaUtilLinkedHashMap.put("FACE_THIN", new lpt(BeautyRealConfig.TYPE.FACE_THIN, 3, 0, 0));
    this.jdField_a_of_type_JavaUtilLinkedHashMap.put("FACE_V", new lpt(BeautyRealConfig.TYPE.FACE_V, 3, 0, 0));
    this.jdField_a_of_type_JavaUtilLinkedHashMap.put("FACE_SHAPE_4", new lpt(BeautyRealConfig.TYPE.BASIC4, 3, 40, 0));
    this.jdField_a_of_type_JavaUtilLinkedHashMap.put("FACE_SHORTEN", new lpt(BeautyRealConfig.TYPE.FACE_SHORTEN, 3, 0, 0));
    this.jdField_a_of_type_JavaUtilLinkedHashMap.put("NOSE_THIN", new lpt(BeautyRealConfig.TYPE.NOSE, 3, 0, 0));
  }
  
  public int a(String paramString)
  {
    paramString = (lpt)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(paramString);
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
      lpt locallpt = (lpt)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(str);
      if (locallpt == null) {}
      for (;;)
      {
        i += 1;
        break;
        if (i != 0) {
          localStringBuilder.append(",");
        }
        localStringBuilder.append(str).append(":").append(locallpt.d);
      }
    }
    return localStringBuilder.toString();
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  void a(int paramInt, List<lpt> paramList)
  {
    if (paramList == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedHashMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        lpt locallpt = (lpt)((Map.Entry)localIterator.next()).getValue();
        if ((locallpt != null) && ((paramInt == 0) || (locallpt.a == paramInt))) {
          paramList.add(locallpt);
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
          localObject1 = (lpt)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(localObject2);
          if (localObject1 != null) {
            ((lpt)localObject1).d = k;
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
    paramString = (lpt)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(paramString);
    if ((paramString != null) && (paramString.d != paramInt))
    {
      paramString.d = paramInt;
      this.jdField_a_of_type_Boolean = true;
    }
  }
  
  public void a(lps paramlps)
  {
    if (paramlps == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = paramlps.jdField_a_of_type_JavaUtilLinkedHashMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        lpt locallpt = (lpt)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(str);
        if (locallpt != null) {
          locallpt.d = paramlps.a(str);
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
    paramString = (lpt)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(paramString);
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
      lpt locallpt = (lpt)((Map.Entry)localIterator.next()).getValue();
      if ((locallpt != null) && (locallpt.d != locallpt.b))
      {
        locallpt.d = locallpt.b;
        this.jdField_a_of_type_Boolean = true;
      }
    }
  }
  
  public boolean b()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedHashMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      lpt locallpt = (lpt)((Map.Entry)localIterator.next()).getValue();
      if ((locallpt != null) && (locallpt.d != locallpt.c)) {
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
      lpt locallpt = (lpt)((Map.Entry)localIterator.next()).getValue();
      if ((locallpt != null) && (locallpt.d != locallpt.c))
      {
        locallpt.d = locallpt.c;
        this.jdField_a_of_type_Boolean = true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lps
 * JD-Core Version:    0.7.0.1
 */