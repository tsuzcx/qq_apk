import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.qphone.base.util.QLog;
import java.io.Reader;
import java.util.Map;
import java.util.Stack;
import org.xmlpull.v1.XmlPullParser;

class rat
{
  XmlPullParser jdField_a_of_type_OrgXmlpullV1XmlPullParser;
  ras jdField_a_of_type_Ras;
  
  public rat(XmlPullParser paramXmlPullParser, ras paramras)
  {
    this.jdField_a_of_type_OrgXmlpullV1XmlPullParser = paramXmlPullParser;
    this.jdField_a_of_type_Ras = paramras;
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
    int i = 0;
    int j = this.jdField_a_of_type_OrgXmlpullV1XmlPullParser.getEventType();
    int m = this.jdField_a_of_type_OrgXmlpullV1XmlPullParser.getDepth();
    switch (j)
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
          this.jdField_a_of_type_Ras.jdField_a_of_type_JavaUtilStack.push(str);
          QLog.d("fast_web", 2, new Object[] { "【start】 depth : ", Integer.valueOf(m), ", name : ", str });
          if (!rao.c().equals(str)) {
            break;
          }
          while (i < this.jdField_a_of_type_OrgXmlpullV1XmlPullParser.getAttributeCount())
          {
            if (this.jdField_a_of_type_OrgXmlpullV1XmlPullParser.getAttributeName(i).trim().equals("style"))
            {
              this.jdField_a_of_type_Ras.b.put(m, rao.a(this.jdField_a_of_type_OrgXmlpullV1XmlPullParser.getAttributeValue(i).trim()));
              return;
            }
            i += 1;
          }
        }
        if (rao.d().equals(str))
        {
          this.jdField_a_of_type_Ras.b.put(m, rar.a(4, new Object[] { Integer.valueOf(1) }));
          return;
        }
        if (rao.e().equals(str))
        {
          this.jdField_a_of_type_Ras.b.put(m, rar.a(3, new Object[0]));
          return;
        }
        if (rao.f().equals(str))
        {
          this.jdField_a_of_type_Ras.b.put(m, rar.a(4, new Object[] { Integer.valueOf(2) }));
          return;
        }
      } while ((!rao.g().equals(str)) && (!rao.h().equals(str)));
      j = 0;
      int k = 3;
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
          str = (String)rao.a(this.jdField_a_of_type_OrgXmlpullV1XmlPullParser.getAttributeValue(j)).get("text-align");
          i = k;
          if (!TextUtils.isEmpty(str)) {
            if ("right".equals(str))
            {
              i = 5;
            }
            else if ("left".equals(str))
            {
              i = 3;
            }
            else
            {
              i = k;
              if ("center".equals(str)) {
                i = 17;
              }
            }
          }
        }
      }
      this.jdField_a_of_type_Ras.jdField_a_of_type_AndroidUtilSparseArray.put(m, Integer.valueOf(k));
      return;
    }
    QLog.d("fast_web", 2, new Object[] { "【remove】 depth : ", Integer.valueOf(m), ", name : ", this.jdField_a_of_type_OrgXmlpullV1XmlPullParser.getName(), " size : ", Integer.valueOf(this.jdField_a_of_type_Ras.b.size()) });
    if (!this.jdField_a_of_type_Ras.jdField_a_of_type_JavaUtilStack.isEmpty())
    {
      this.jdField_a_of_type_Ras.jdField_a_of_type_JavaUtilStack.pop();
      this.jdField_a_of_type_Ras.b.remove(m);
      this.jdField_a_of_type_Ras.jdField_a_of_type_AndroidUtilSparseArray.remove(m);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rat
 * JD-Core Version:    0.7.0.1
 */