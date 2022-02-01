package com.tencent.mobileqq.dpc;

import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

class DeviceProfileManager$DPCXmlHandler
  extends DefaultHandler
{
  private Pattern checkPattern = Pattern.compile("^([0-9]{1,5}|\\{([\\s\\S]*)\\})$");
  private boolean mIsText = false;
  private StringBuffer sb = new StringBuffer();
  private String taskId = "0";
  public HashMap<String, DeviceProfileManager.DPCXmlHandler.DPCXMLParseInfo> tempMap;
  public String testType = "";
  private int weight = 0;
  
  public DeviceProfileManager$DPCXmlHandler(HashMap<String, DeviceProfileManager.DPCXmlHandler.DPCXMLParseInfo> paramHashMap)
  {
    this.tempMap = paramHashMap;
  }
  
  private boolean checkFormat(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return false;
    }
    return this.checkPattern.matcher(paramString).matches();
  }
  
  public void characters(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    if (this.mIsText) {
      this.sb.append(paramArrayOfChar, paramInt1, paramInt2);
    }
  }
  
  public void endElement(String paramString1, String paramString2, String paramString3)
  {
    if (this.mIsText)
    {
      if (!checkFormat(this.sb.toString()))
      {
        if (QLog.isColorLevel()) {
          QLog.e("DeviceProfileManager", 2, "DPCXmlHandler format is error: " + paramString2 + "-" + this.sb.toString());
        }
        return;
      }
      if (!this.tempMap.containsKey(paramString2)) {
        break label229;
      }
      paramString1 = (DeviceProfileManager.DPCXmlHandler.DPCXMLParseInfo)this.tempMap.get(paramString2);
      if (QLog.isColorLevel()) {
        QLog.d("DeviceProfileManager", 2, "DPCXmlHandler parse to TEMPMAP update oldInfo: " + paramString2 + "-" + paramString1.toString());
      }
      if (paramString1.weight < this.weight)
      {
        paramString1.weight = this.weight;
        paramString1.value = this.sb.toString();
        paramString1.taskId = this.taskId;
        paramString1.testType = this.testType;
      }
      if (QLog.isColorLevel()) {
        QLog.d("DeviceProfileManager", 2, "DPCXmlHandler parse to TEMPMAP update newInfo: " + paramString2 + "-" + paramString1.toString());
      }
    }
    for (;;)
    {
      this.mIsText = false;
      return;
      label229:
      paramString1 = new DeviceProfileManager.DPCXmlHandler.DPCXMLParseInfo();
      paramString1.key = paramString2;
      paramString1.value = this.sb.toString();
      paramString1.taskId = this.taskId;
      paramString1.weight = this.weight;
      paramString1.testType = this.testType;
      this.tempMap.put(paramString2, paramString1);
      if (QLog.isColorLevel()) {
        QLog.d("DeviceProfileManager", 2, "DPCXmlHandler parse to TEMPMAP add: " + paramString2 + "-" + paramString1.toString());
      }
    }
  }
  
  public void startDocument()
  {
    super.startDocument();
    if (this.tempMap == null) {
      this.tempMap = new HashMap();
    }
  }
  
  public void startElement(String paramString1, String paramString2, String paramString3, Attributes paramAttributes)
  {
    int i = 0;
    if (paramString2.equals("features"))
    {
      if (i < paramAttributes.getLength())
      {
        if (paramAttributes.getLocalName(i).equals("weight")) {
          this.weight = Integer.parseInt(paramAttributes.getValue(i));
        }
        for (;;)
        {
          i += 1;
          break;
          if (paramAttributes.getLocalName(i).equals("taskId")) {
            this.taskId = paramAttributes.getValue(i);
          } else if (paramAttributes.getLocalName(i).equals("testType")) {
            this.testType = paramAttributes.getValue(i);
          }
        }
      }
    }
    else
    {
      this.mIsText = true;
      this.sb.delete(0, this.sb.length());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dpc.DeviceProfileManager.DPCXmlHandler
 * JD-Core Version:    0.7.0.1
 */