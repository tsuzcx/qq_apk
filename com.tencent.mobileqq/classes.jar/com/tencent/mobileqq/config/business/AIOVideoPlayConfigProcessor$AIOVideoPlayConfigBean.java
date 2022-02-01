package com.tencent.mobileqq.config.business;

import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class AIOVideoPlayConfigProcessor$AIOVideoPlayConfigBean
{
  public boolean a;
  public boolean b;
  public boolean c;
  public boolean d;
  public boolean e;
  
  public AIOVideoPlayConfigProcessor$AIOVideoPlayConfigBean() {}
  
  public AIOVideoPlayConfigProcessor$AIOVideoPlayConfigBean(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    this.a = paramBoolean1;
    this.b = paramBoolean2;
    this.c = paramBoolean3;
    this.d = paramBoolean4;
    this.e = paramBoolean5;
  }
  
  public static AIOVideoPlayConfigBean a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    boolean bool1;
    try
    {
      paramString = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(paramString.getBytes("utf-8")));
      localObject = paramString.getElementsByTagName("shortvideo_troop_auto_play");
      bool6 = false;
      if ((localObject == null) || (((NodeList)localObject).getLength() <= 0)) {
        break label484;
      }
      if (Integer.valueOf(((Element)((NodeList)localObject).item(0)).getFirstChild().getNodeValue()).intValue() <= 0) {
        break label477;
      }
      bool1 = true;
    }
    catch (Exception paramString)
    {
      boolean bool6;
      label152:
      label212:
      Object localObject = new StringBuilder();
      label272:
      ((StringBuilder)localObject).append("onParsed failed");
      ((StringBuilder)localObject).append(paramString);
      QLog.e("AIOVideoPlayConfigProcessor", 1, ((StringBuilder)localObject).toString());
      return null;
    }
    localObject = paramString.getElementsByTagName("shortvideo_not_troop_auto_play");
    if ((localObject != null) && (((NodeList)localObject).getLength() > 0)) {
      if (Integer.valueOf(((Element)((NodeList)localObject).item(0)).getFirstChild().getNodeValue()).intValue() > 0)
      {
        bool1 = true;
        break label491;
        localObject = paramString.getElementsByTagName("shortvideo_real_troop_auto_play");
        if ((localObject == null) || (((NodeList)localObject).getLength() <= 0)) {
          break label509;
        }
        if (Integer.valueOf(((Element)((NodeList)localObject).item(0)).getFirstChild().getNodeValue()).intValue() <= 0) {
          break label501;
        }
        bool1 = true;
        break label503;
        localObject = paramString.getElementsByTagName("shortvideo_real_not_troop_auto_play");
        if ((localObject == null) || (((NodeList)localObject).getLength() <= 0)) {
          break label523;
        }
        if (Integer.valueOf(((Element)((NodeList)localObject).item(0)).getFirstChild().getNodeValue()).intValue() <= 0) {
          break label515;
        }
        bool1 = true;
        break label517;
        paramString = paramString.getElementsByTagName("auto_del_bad_cache");
        if ((paramString == null) || (paramString.getLength() <= 0)) {
          break label532;
        }
        bool1 = bool6;
        if (Integer.valueOf(((Element)paramString.item(0)).getFirstChild().getNodeValue()).intValue() <= 0) {
          break label529;
        }
        bool1 = true;
        break label529;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("parse, shortvideoTroopAutoPlay = ");
        paramString.append(bool2);
        paramString.append(", shortvideoNotTroopAutoPlay = ");
        paramString.append(bool3);
        paramString.append(", shortvideoRealTroopAutoPlay = ");
        paramString.append(bool4);
        paramString.append(", shortvideoRealNotTroopAutoPlay = ");
        paramString.append(bool5);
        paramString.append(", autoDelBadCache = ");
        paramString.append(bool1);
        QLog.d("AIOVideoPlayConfigProcessor", 2, paramString.toString());
      }
      paramString = new AIOVideoPlayConfigBean(bool2, bool3, bool4, bool5, bool1);
      return paramString;
      label477:
      bool1 = false;
      boolean bool2 = bool1;
      break;
      label484:
      bool2 = true;
      break;
      bool1 = false;
      label491:
      boolean bool3 = bool1;
      break label152;
      bool3 = true;
      break label152;
      label501:
      bool1 = false;
      label503:
      boolean bool4 = bool1;
      break label212;
      label509:
      bool4 = true;
      break label212;
      label515:
      bool1 = false;
      label517:
      boolean bool5 = bool1;
      break label272;
      label523:
      bool5 = true;
      break label272;
      label529:
      continue;
      label532:
      bool1 = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.AIOVideoPlayConfigProcessor.AIOVideoPlayConfigBean
 * JD-Core Version:    0.7.0.1
 */