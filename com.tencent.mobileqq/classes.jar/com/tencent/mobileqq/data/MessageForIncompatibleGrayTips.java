package com.tencent.mobileqq.data;

import anwz;
import bcef;
import com.tencent.qphone.base.util.QLog;
import java.io.StringReader;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

public class MessageForIncompatibleGrayTips
  extends ChatMessage
{
  private String TAG = "Q.msg.IncompatibleGrayTips";
  public int linkEnd;
  public int linkStart;
  public String url;
  
  public MessageForIncompatibleGrayTips()
  {
    this.msgtype = -5002;
  }
  
  public void doParse()
  {
    try
    {
      IncompatibleGrayTipsMessage localIncompatibleGrayTipsMessage = (IncompatibleGrayTipsMessage)anwz.a(this.msgData);
      if (localIncompatibleGrayTipsMessage != null)
      {
        this.linkStart = localIncompatibleGrayTipsMessage.linkStart;
        this.linkEnd = localIncompatibleGrayTipsMessage.linkEnd;
        this.msg = localIncompatibleGrayTipsMessage.msg;
        this.url = localIncompatibleGrayTipsMessage.url;
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        Object localObject = null;
      }
    }
  }
  
  public Boolean parseTextXML(String paramString)
  {
    Object localObject1 = Boolean.valueOf(false);
    localObject2 = localObject1;
    for (;;)
    {
      try
      {
        localXmlPullParser = XmlPullParserFactory.newInstance().newPullParser();
        localObject2 = localObject1;
        localXmlPullParser.setInput(new StringReader(paramString));
        localObject2 = localObject1;
        i = localXmlPullParser.getEventType();
        localObject2 = null;
        str = null;
        paramString = (String)localObject1;
        localObject1 = null;
      }
      catch (Exception localException2)
      {
        XmlPullParser localXmlPullParser;
        int i;
        String str;
        paramString = (String)localObject2;
        continue;
        if (i == 1) {
          continue;
        }
        switch (i)
        {
        }
        Object localObject3 = localObject2;
        continue;
      }
      localObject2 = paramString;
      i = localXmlPullParser.next();
      localObject2 = localObject3;
      continue;
      localObject3 = localObject2;
      continue;
      try
      {
        if (!"PromptConfig".equalsIgnoreCase(localXmlPullParser.getName())) {
          continue;
        }
        str = localXmlPullParser.getAttributeValue(null, "content").trim();
        localObject3 = localXmlPullParser.getAttributeValue(null, "urlshowtext").trim();
        localObject1 = localXmlPullParser.getAttributeValue(null, "url").trim();
      }
      catch (Exception localException1) {}
      if ((!"PromptConfig".equalsIgnoreCase(localXmlPullParser.getName())) || (str == null)) {
        continue;
      }
      localObject3 = Boolean.valueOf(true);
      paramString = (String)localObject3;
      localObject3 = localObject2;
    }
    localObject3 = paramString;
    if (paramString.booleanValue())
    {
      if ((localObject1 == null) || (((String)localObject1).length() <= 0) || (localObject2 == null) || (((String)localObject2).length() <= 0)) {
        break label282;
      }
      i = str.indexOf("$URL$");
      localObject3 = paramString;
      if (i >= 0)
      {
        this.linkStart = i;
        this.linkEnd = (i + ((String)localObject2).length());
        this.url = ((String)localObject1);
        this.msg = str.replace("$URL$", (CharSequence)localObject2);
        localObject3 = paramString;
      }
    }
    for (;;)
    {
      if (((Boolean)localObject3).booleanValue()) {
        serial();
      }
      return localObject3;
      label282:
      this.linkStart = 0;
      this.linkEnd = 0;
      this.msg = str;
      this.url = null;
      localObject3 = paramString;
      continue;
      this.linkStart = 0;
      this.linkEnd = 0;
      this.msg = null;
      this.url = null;
      localObject3 = paramString;
      if (QLog.isColorLevel())
      {
        QLog.d(this.TAG, 2, localException1.getMessage(), localException1);
        localObject3 = paramString;
      }
    }
  }
  
  public void postRead()
  {
    parse();
  }
  
  public void prewrite()
  {
    serial();
    bcef.b(null, "CliOper", "", String.valueOf(this.frienduin), "0X800491A", "0X800491A", 0, 0, "", "", "", "");
  }
  
  public void serial()
  {
    IncompatibleGrayTipsMessage localIncompatibleGrayTipsMessage = new IncompatibleGrayTipsMessage();
    localIncompatibleGrayTipsMessage.linkStart = this.linkStart;
    localIncompatibleGrayTipsMessage.linkEnd = this.linkEnd;
    localIncompatibleGrayTipsMessage.msg = this.msg;
    localIncompatibleGrayTipsMessage.url = this.url;
    try
    {
      this.msgData = anwz.a(localIncompatibleGrayTipsMessage);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForIncompatibleGrayTips
 * JD-Core Version:    0.7.0.1
 */