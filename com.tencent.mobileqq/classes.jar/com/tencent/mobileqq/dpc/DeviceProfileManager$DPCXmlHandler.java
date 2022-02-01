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
    if ((paramString != null) && (paramString.length() != 0)) {
      return this.checkPattern.matcher(paramString).matches();
    }
    return false;
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
        if (QLog.isColorLevel())
        {
          paramString1 = new StringBuilder();
          paramString1.append("DPCXmlHandler format is error: ");
          paramString1.append(paramString2);
          paramString1.append("-");
          paramString1.append(this.sb.toString());
          QLog.e("DeviceProfileManager", 2, paramString1.toString());
        }
        return;
      }
      if (this.tempMap.containsKey(paramString2))
      {
        paramString1 = (DeviceProfileManager.DPCXmlHandler.DPCXMLParseInfo)this.tempMap.get(paramString2);
        if (QLog.isColorLevel())
        {
          paramString3 = new StringBuilder();
          paramString3.append("DPCXmlHandler parse to TEMPMAP update oldInfo: ");
          paramString3.append(paramString2);
          paramString3.append("-");
          paramString3.append(paramString1.toString());
          QLog.d("DeviceProfileManager", 2, paramString3.toString());
        }
        int i = paramString1.weight;
        int j = this.weight;
        if (i < j)
        {
          paramString1.weight = j;
          paramString1.value = this.sb.toString();
          paramString1.taskId = this.taskId;
          paramString1.testType = this.testType;
        }
        if (QLog.isColorLevel())
        {
          paramString3 = new StringBuilder();
          paramString3.append("DPCXmlHandler parse to TEMPMAP update newInfo: ");
          paramString3.append(paramString2);
          paramString3.append("-");
          paramString3.append(paramString1.toString());
          QLog.d("DeviceProfileManager", 2, paramString3.toString());
        }
      }
      else
      {
        paramString1 = new DeviceProfileManager.DPCXmlHandler.DPCXMLParseInfo();
        paramString1.key = paramString2;
        paramString1.value = this.sb.toString();
        paramString1.taskId = this.taskId;
        paramString1.weight = this.weight;
        paramString1.testType = this.testType;
        this.tempMap.put(paramString2, paramString1);
        if (QLog.isColorLevel())
        {
          paramString3 = new StringBuilder();
          paramString3.append("DPCXmlHandler parse to TEMPMAP add: ");
          paramString3.append(paramString2);
          paramString3.append("-");
          paramString3.append(paramString1.toString());
          QLog.d("DeviceProfileManager", 2, paramString3.toString());
        }
      }
    }
    this.mIsText = false;
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
    boolean bool = paramString2.equals("features");
    int i = 0;
    if (bool)
    {
      while (i < paramAttributes.getLength())
      {
        if (paramAttributes.getLocalName(i).equals("weight")) {
          this.weight = Integer.parseInt(paramAttributes.getValue(i));
        } else if (paramAttributes.getLocalName(i).equals("taskId")) {
          this.taskId = paramAttributes.getValue(i);
        } else if (paramAttributes.getLocalName(i).equals("testType")) {
          this.testType = paramAttributes.getValue(i);
        }
        i += 1;
      }
      return;
    }
    this.mIsText = true;
    paramString1 = this.sb;
    paramString1.delete(0, paramString1.length());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.dpc.DeviceProfileManager.DPCXmlHandler
 * JD-Core Version:    0.7.0.1
 */