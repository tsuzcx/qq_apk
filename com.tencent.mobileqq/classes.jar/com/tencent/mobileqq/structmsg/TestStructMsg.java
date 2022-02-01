package com.tencent.mobileqq.structmsg;

import com.tencent.mm.vfs.VFSFileInputStream;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;

public class TestStructMsg
{
  public static AbsStructMsg a(String paramString)
  {
    paramString = new ByteArrayInputStream(paramString.getBytes());
    StructMsgParserHandler localStructMsgParserHandler = new StructMsgParserHandler();
    SAXParserFactory localSAXParserFactory = SAXParserFactory.newInstance();
    try
    {
      localSAXParserFactory.newSAXParser().parse(paramString, localStructMsgParserHandler);
      paramString.close();
      paramString = localStructMsgParserHandler.a();
      return paramString;
    }
    catch (IOException paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TestStructMsg", 2, "getStructMsgFromXmlBuffByStream", paramString);
      }
    }
    catch (SAXException paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TestStructMsg", 2, "getStructMsgFromXmlBuffByStream", paramString);
      }
    }
    catch (ParserConfigurationException paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TestStructMsg", 2, "getStructMsgFromXmlBuffByStream", paramString);
      }
    }
    return null;
  }
  
  public static String b(String paramString)
  {
    try
    {
      paramString = new VFSFileInputStream(paramString);
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      byte[] arrayOfByte = new byte[1024];
      for (;;)
      {
        int i = paramString.read(arrayOfByte, 0, 1024);
        if (i == -1) {
          break;
        }
        localByteArrayOutputStream.write(arrayOfByte, 0, i);
      }
      paramString = new String(localByteArrayOutputStream.toByteArray(), "utf-8");
      return paramString;
    }
    catch (IOException paramString)
    {
      paramString.printStackTrace();
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.TestStructMsg
 * JD-Core Version:    0.7.0.1
 */