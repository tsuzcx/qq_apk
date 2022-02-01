package com.tencent.mobileqq.hotpic;

import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class HotPicConfBean
{
  int a = 0;
  
  public static HotPicConfBean a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    try
    {
      paramString = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(paramString.getBytes("utf-8")));
      localObject = paramString.getElementsByTagName("hotpic_config");
      if ((localObject != null) && (((NodeList)localObject).getLength() > 0))
      {
        localObject = new HotPicConfBean();
        ((HotPicConfBean)localObject).a = Integer.parseInt(paramString.getElementsByTagName("entry").item(0).getFirstChild().getNodeValue());
        return localObject;
      }
    }
    catch (Exception paramString)
    {
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("handleHotPicConfig failed");
        ((StringBuilder)localObject).append(paramString);
        QLog.e("HotPicConfProcessor", 1, ((StringBuilder)localObject).toString());
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.hotpic.HotPicConfBean
 * JD-Core Version:    0.7.0.1
 */