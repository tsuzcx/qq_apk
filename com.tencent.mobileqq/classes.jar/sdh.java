import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.qphone.base.util.QLog;
import java.io.Reader;
import java.util.Map;
import java.util.Stack;
import org.xmlpull.v1.XmlPullParser;

class sdh
{
  XmlPullParser jdField_a_of_type_OrgXmlpullV1XmlPullParser;
  sdg jdField_a_of_type_Sdg;
  
  public sdh(XmlPullParser paramXmlPullParser, sdg paramsdg)
  {
    this.jdField_a_of_type_OrgXmlpullV1XmlPullParser = paramXmlPullParser;
    this.jdField_a_of_type_Sdg = paramsdg;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_OrgXmlpullV1XmlPullParser.getDepth();
  }
  
  public String a()
  {
    return this.jdField_a_of_type_OrgXmlpullV1XmlPullParser.getText();
  }
  
  public String a(int paramInt)
  {
    return this.jdField_a_of_type_OrgXmlpullV1XmlPullParser.getAttributeName(paramInt);
  }
  
  public void a()
  {
    int i = this.jdField_a_of_type_OrgXmlpullV1XmlPullParser.getEventType();
    int m = this.jdField_a_of_type_OrgXmlpullV1XmlPullParser.getDepth();
    switch (i)
    {
    default: 
    case 2: 
      String str;
      do
      {
        for (;;)
        {
          return;
          str = this.jdField_a_of_type_OrgXmlpullV1XmlPullParser.getName();
          this.jdField_a_of_type_Sdg.jdField_a_of_type_JavaUtilStack.push(str);
          QLog.d("fast_web", 2, new Object[] { "【start】 depth : ", Integer.valueOf(m), ", name : ", str });
          if (!sdc.c().equals(str)) {
            break;
          }
          i = 0;
          while (i < this.jdField_a_of_type_OrgXmlpullV1XmlPullParser.getAttributeCount())
          {
            if (this.jdField_a_of_type_OrgXmlpullV1XmlPullParser.getAttributeName(i).trim().equals("style"))
            {
              this.jdField_a_of_type_Sdg.b.put(m, sdc.a(this.jdField_a_of_type_OrgXmlpullV1XmlPullParser.getAttributeValue(i).trim()));
              return;
            }
            i += 1;
          }
        }
        if (sdc.d().equals(str))
        {
          this.jdField_a_of_type_Sdg.b.put(m, sdf.a(4, new Object[] { Integer.valueOf(1) }));
          return;
        }
        if (sdc.e().equals(str))
        {
          this.jdField_a_of_type_Sdg.b.put(m, sdf.a(3, new Object[0]));
          return;
        }
        if (sdc.f().equals(str))
        {
          this.jdField_a_of_type_Sdg.b.put(m, sdf.a(4, new Object[] { Integer.valueOf(2) }));
          return;
        }
      } while ((!sdc.g().equals(str)) && (!sdc.h().equals(str)));
      int j = 0;
      int k = 0;
      if (j < this.jdField_a_of_type_OrgXmlpullV1XmlPullParser.getAttributeCount())
      {
        if (!this.jdField_a_of_type_OrgXmlpullV1XmlPullParser.getAttributeName(j).trim().equals("style")) {
          i = k;
        }
        for (;;)
        {
          j += 1;
          k = i;
          break;
          str = (String)sdc.a(this.jdField_a_of_type_OrgXmlpullV1XmlPullParser.getAttributeValue(j)).get("text-align");
          i = k;
          if (!TextUtils.isEmpty(str)) {
            if ("right".equals(str))
            {
              i = 2;
            }
            else if ("left".equals(str))
            {
              i = 0;
            }
            else
            {
              i = k;
              if ("center".equals(str)) {
                i = 1;
              }
            }
          }
        }
      }
      this.jdField_a_of_type_Sdg.jdField_a_of_type_AndroidUtilSparseArray.put(m, Integer.valueOf(k));
      return;
    }
    QLog.d("fast_web", 2, new Object[] { "【remove】 depth : ", Integer.valueOf(m), ", name : ", this.jdField_a_of_type_OrgXmlpullV1XmlPullParser.getName(), " size : ", Integer.valueOf(this.jdField_a_of_type_Sdg.b.size()) });
    if (!this.jdField_a_of_type_Sdg.jdField_a_of_type_JavaUtilStack.isEmpty())
    {
      this.jdField_a_of_type_Sdg.jdField_a_of_type_JavaUtilStack.pop();
      this.jdField_a_of_type_Sdg.b.remove(m);
      this.jdField_a_of_type_Sdg.jdField_a_of_type_AndroidUtilSparseArray.remove(m);
      return;
    }
    throw new RuntimeException("tag is not close !");
  }
  
  public void a(Reader paramReader)
  {
    this.jdField_a_of_type_OrgXmlpullV1XmlPullParser.setInput(paramReader);
  }
  
  public int b()
  {
    return this.jdField_a_of_type_OrgXmlpullV1XmlPullParser.getAttributeCount();
  }
  
  public String b()
  {
    return this.jdField_a_of_type_OrgXmlpullV1XmlPullParser.getName();
  }
  
  public String b(int paramInt)
  {
    return this.jdField_a_of_type_OrgXmlpullV1XmlPullParser.getAttributeValue(paramInt);
  }
  
  public int c()
  {
    return this.jdField_a_of_type_OrgXmlpullV1XmlPullParser.getEventType();
  }
  
  public int d()
  {
    int i = this.jdField_a_of_type_OrgXmlpullV1XmlPullParser.next();
    a();
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     sdh
 * JD-Core Version:    0.7.0.1
 */