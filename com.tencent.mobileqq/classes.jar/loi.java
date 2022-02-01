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

public class loi
{
  private final LinkedHashMap<String, loj> jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap(12);
  private boolean jdField_a_of_type_Boolean;
  private boolean b = true;
  
  public loi()
  {
    d();
  }
  
  private void d()
  {
    if (AEFilterSupport.a() >= 7) {
      this.b = false;
    }
    this.jdField_a_of_type_JavaUtilLinkedHashMap.clear();
    this.jdField_a_of_type_JavaUtilLinkedHashMap.put("BEAUTY_SKIN", new loj(null, 1, 50, 0));
    if (this.b)
    {
      this.jdField_a_of_type_JavaUtilLinkedHashMap.put("COLOR_TONE", new loj(BeautyRealConfig.TYPE.COLOR_TONE, 2, 50, 50));
      this.jdField_a_of_type_JavaUtilLinkedHashMap.put("EYE_LIGHTEN", new loj(BeautyRealConfig.TYPE.EYE_LIGHTEN, 2, 0, 0));
      this.jdField_a_of_type_JavaUtilLinkedHashMap.put("TOOTH_WHITEN", new loj(BeautyRealConfig.TYPE.TOOTH_WHITEN, 2, 0, 0));
      this.jdField_a_of_type_JavaUtilLinkedHashMap.put("ENLARGE_EYE", new loj(BeautyRealConfig.TYPE.EYE, 3, 0, 0));
      this.jdField_a_of_type_JavaUtilLinkedHashMap.put("MOUTH_SHAPE", new loj(BeautyRealConfig.TYPE.MOUTH_SHAPE, 3, 50, 50));
      this.jdField_a_of_type_JavaUtilLinkedHashMap.put("CHIN", new loj(BeautyRealConfig.TYPE.CHIN, 3, 50, 50));
      this.jdField_a_of_type_JavaUtilLinkedHashMap.put("FACE_THIN", new loj(BeautyRealConfig.TYPE.FACE_THIN, 3, 0, 0));
      this.jdField_a_of_type_JavaUtilLinkedHashMap.put("FACE_V", new loj(BeautyRealConfig.TYPE.FACE_V, 3, 0, 0));
      this.jdField_a_of_type_JavaUtilLinkedHashMap.put("FACE_SHAPE_4", new loj(BeautyRealConfig.TYPE.BASIC4, 3, 0, 0));
      this.jdField_a_of_type_JavaUtilLinkedHashMap.put("FACE_SHORTEN", new loj(BeautyRealConfig.TYPE.FACE_SHORTEN, 3, 0, 0));
      this.jdField_a_of_type_JavaUtilLinkedHashMap.put("NOSE_THIN", new loj(BeautyRealConfig.TYPE.NOSE, 3, 0, 0));
      return;
    }
    this.jdField_a_of_type_JavaUtilLinkedHashMap.put("COLOR_TONE", new loj(BeautyRealConfig.TYPE.COLOR_TONE, 2, 50, 50));
    this.jdField_a_of_type_JavaUtilLinkedHashMap.put("EYE_LIGHTEN", new loj(BeautyRealConfig.TYPE.EYE_LIGHTEN, 2, 0, 0));
    this.jdField_a_of_type_JavaUtilLinkedHashMap.put("TOOTH_WHITEN", new loj(BeautyRealConfig.TYPE.TOOTH_WHITEN, 2, 0, 0));
    this.jdField_a_of_type_JavaUtilLinkedHashMap.put("ENLARGE_EYE", new loj(BeautyRealConfig.TYPE.EYE, 3, 0, 0));
    this.jdField_a_of_type_JavaUtilLinkedHashMap.put("MOUTH_SHAPE", new loj(BeautyRealConfig.TYPE.MOUTH_SHAPE, 3, 50, 50));
    this.jdField_a_of_type_JavaUtilLinkedHashMap.put("CHIN", new loj(BeautyRealConfig.TYPE.CHIN, 3, 50, 50));
    this.jdField_a_of_type_JavaUtilLinkedHashMap.put("FACE_THIN", new loj(BeautyRealConfig.TYPE.FACE_THIN, 3, 0, 0));
    this.jdField_a_of_type_JavaUtilLinkedHashMap.put("FACE_V", new loj(BeautyRealConfig.TYPE.FACE_V, 3, 0, 0));
    this.jdField_a_of_type_JavaUtilLinkedHashMap.put("FACE_SHAPE_4", new loj(BeautyRealConfig.TYPE.BASIC4, 3, 40, 0));
    this.jdField_a_of_type_JavaUtilLinkedHashMap.put("FACE_SHORTEN", new loj(BeautyRealConfig.TYPE.FACE_SHORTEN, 3, 0, 0));
    this.jdField_a_of_type_JavaUtilLinkedHashMap.put("NOSE_THIN", new loj(BeautyRealConfig.TYPE.NOSE, 3, 0, 0));
  }
  
  public int a(String paramString)
  {
    paramString = (loj)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(paramString);
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
      loj localloj = (loj)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(str);
      if (localloj == null) {}
      for (;;)
      {
        i += 1;
        break;
        if (localloj.d != localloj.b) {
          localStringBuilder.append(",").append(str).append(":").append(localloj.d);
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
  
  void a(int paramInt, List<loj> paramList)
  {
    if (paramList == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedHashMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        loj localloj = (loj)((Map.Entry)localIterator.next()).getValue();
        if ((localloj != null) && ((paramInt == 0) || (localloj.jdField_a_of_type_Int == paramInt))) {
          paramList.add(localloj);
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
            localObject2 = (loj)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(localCharSequence);
            if (localObject2 != null) {
              ((loj)localObject2).d = k;
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
            loj localloj = (loj)((Map.Entry)((Iterator)localObject1).next()).getValue();
            if ((localloj == null) || (localloj.jdField_a_of_type_Int == 1) || (localloj.jdField_a_of_type_ComTencentTtpicOpenapiConfigBeautyRealConfig$TYPE == BeautyRealConfig.TYPE.BASIC4)) {
              break label179;
            }
            if (localloj.d == localloj.b) {
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
    paramString = (loj)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(paramString);
    if ((paramString != null) && (paramString.d != paramInt))
    {
      paramString.d = paramInt;
      this.jdField_a_of_type_Boolean = true;
    }
  }
  
  public void a(loi paramloi)
  {
    if (paramloi == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = paramloi.jdField_a_of_type_JavaUtilLinkedHashMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        loj localloj = (loj)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(str);
        if (localloj != null) {
          localloj.d = paramloi.a(str);
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
    paramString = (loj)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(paramString);
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
      loj localloj = (loj)((Map.Entry)localIterator.next()).getValue();
      if ((localloj != null) && (localloj.d != localloj.b))
      {
        localloj.d = localloj.b;
        this.jdField_a_of_type_Boolean = true;
      }
    }
  }
  
  public boolean b()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedHashMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      loj localloj = (loj)((Map.Entry)localIterator.next()).getValue();
      if ((localloj != null) && (localloj.d != localloj.c)) {
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
      loj localloj = (loj)((Map.Entry)localIterator.next()).getValue();
      if ((localloj != null) && (localloj.d != localloj.c))
      {
        localloj.d = localloj.c;
        this.jdField_a_of_type_Boolean = true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     loi
 * JD-Core Version:    0.7.0.1
 */