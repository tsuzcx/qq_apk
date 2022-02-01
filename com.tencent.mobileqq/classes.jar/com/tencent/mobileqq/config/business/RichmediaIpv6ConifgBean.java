package com.tencent.mobileqq.config.business;

import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class RichmediaIpv6ConifgBean
{
  public boolean a;
  public boolean b;
  public boolean c;
  public boolean d;
  
  public RichmediaIpv6ConifgBean() {}
  
  public RichmediaIpv6ConifgBean(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    this.a = paramBoolean1;
    this.b = paramBoolean2;
    this.c = paramBoolean3;
    this.d = paramBoolean4;
  }
  
  public static RichmediaIpv6ConifgBean a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    for (;;)
    {
      try
      {
        paramString = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(paramString.getBytes("utf-8")));
        localObject = paramString.getElementsByTagName("bdh_ipv6_switch");
        boolean bool5 = false;
        if ((localObject != null) && (((NodeList)localObject).getLength() > 0) && (Integer.valueOf(((Element)((NodeList)localObject).item(0)).getFirstChild().getNodeValue()).intValue() > 0))
        {
          bool1 = true;
          localObject = paramString.getElementsByTagName("bdh_dual_ipv6_switch");
          if ((localObject == null) || (((NodeList)localObject).getLength() <= 0) || (Integer.valueOf(((Element)((NodeList)localObject).item(0)).getFirstChild().getNodeValue()).intValue() <= 0)) {
            break label413;
          }
          bool2 = true;
          localObject = paramString.getElementsByTagName("richmedia_down_ipv6_switch");
          if ((localObject == null) || (((NodeList)localObject).getLength() <= 0) || (Integer.valueOf(((Element)((NodeList)localObject).item(0)).getFirstChild().getNodeValue()).intValue() <= 0)) {
            break label418;
          }
          bool3 = true;
          paramString = paramString.getElementsByTagName("richmedia_down_dual_ipv6_switch");
          boolean bool4 = bool5;
          if (paramString != null)
          {
            bool4 = bool5;
            if (paramString.getLength() > 0)
            {
              bool4 = bool5;
              if (Integer.valueOf(((Element)paramString.item(0)).getFirstChild().getNodeValue()).intValue() > 0) {
                bool4 = true;
              }
            }
          }
          if (QLog.isColorLevel())
          {
            paramString = new StringBuilder();
            paramString.append("parse, bdh_ipv6_switch = ");
            paramString.append(bool1);
            paramString.append(", bdh_dual_ipv6_switch = ");
            paramString.append(bool2);
            paramString.append(", richmedia_down_ipv6_switch = ");
            paramString.append(bool3);
            paramString.append(", richmedia_down_dual_ipv6_switch = ");
            paramString.append(bool4);
            QLog.d("RichmediaIpv6ConifgBean", 2, paramString.toString());
          }
          paramString = new RichmediaIpv6ConifgBean(bool1, bool2, bool3, bool4);
          return paramString;
        }
      }
      catch (Exception paramString)
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onParsed failed");
        ((StringBuilder)localObject).append(paramString);
        QLog.e("RichmediaIpv6ConifgBean", 1, ((StringBuilder)localObject).toString());
        return null;
      }
      boolean bool1 = false;
      continue;
      label413:
      boolean bool2 = false;
      continue;
      label418:
      boolean bool3 = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.RichmediaIpv6ConifgBean
 * JD-Core Version:    0.7.0.1
 */