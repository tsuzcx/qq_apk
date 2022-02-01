package com.tencent.mobileqq.troop.data;

import com.tencent.mobileqq.utils.StringUtil;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public class TroopFeedsDataManager$ProclamationXmlHandler
  extends DefaultHandler
{
  public String a;
  public String b;
  public String c;
  public String d;
  protected String e = null;
  
  public TroopFeedsDataManager$ProclamationXmlHandler(TroopFeedsDataManager paramTroopFeedsDataManager) {}
  
  public void characters(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    if (this.e != null)
    {
      paramArrayOfChar = new String(paramArrayOfChar, paramInt1, paramInt2);
      if (this.e.equals("title"))
      {
        if (StringUtil.isEmpty(this.a)) {
          this.a = paramArrayOfChar;
        }
      }
      else if (this.e.equals("summary")) {
        this.c = paramArrayOfChar;
      }
    }
  }
  
  public void endElement(String paramString1, String paramString2, String paramString3)
  {
    this.e = null;
  }
  
  public void startElement(String paramString1, String paramString2, String paramString3, Attributes paramAttributes)
  {
    if (paramString2.equals("picture")) {
      this.b = paramAttributes.getValue("cover");
    } else if (paramString2.equals("msg")) {
      this.d = paramAttributes.getValue("url");
    }
    this.e = paramString2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopFeedsDataManager.ProclamationXmlHandler
 * JD-Core Version:    0.7.0.1
 */