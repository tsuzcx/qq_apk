package com.tencent.mobileqq.data;

import com.tencent.mobileqq.app.utils.MessagePkgUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.io.StringReader;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

public class MessageForIncompatibleGrayTips
  extends ChatMessage
{
  private String TAG = "Q.msg.IncompatibleGrayTips";
  public int linkEnd = 0;
  public int linkStart = 0;
  public String url = null;
  
  public MessageForIncompatibleGrayTips()
  {
    this.msgtype = -5002;
  }
  
  public void doParse()
  {
    Object localObject;
    try
    {
      IncompatibleGrayTipsMessage localIncompatibleGrayTipsMessage = (IncompatibleGrayTipsMessage)MessagePkgUtils.a(this.msgData);
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      localObject = null;
    }
    if (localObject != null)
    {
      this.linkStart = localObject.linkStart;
      this.linkEnd = localObject.linkEnd;
      this.msg = localObject.msg;
      this.url = localObject.url;
    }
  }
  
  public Boolean parseTextXML(String paramString)
  {
    Object localObject2 = Boolean.valueOf(false);
    Object localObject1 = localObject2;
    try
    {
      XmlPullParser localXmlPullParser = XmlPullParserFactory.newInstance().newPullParser();
      localObject1 = localObject2;
      localXmlPullParser.setInput(new StringReader(paramString));
      localObject1 = localObject2;
      int i = localXmlPullParser.getEventType();
      Object localObject5 = null;
      paramString = localObject5;
      Object localObject3 = paramString;
      Object localObject4 = paramString;
      paramString = (String)localObject2;
      while (i != 1)
      {
        localObject2 = paramString;
        Object localObject8 = localObject5;
        Object localObject7 = localObject4;
        Object localObject6 = localObject3;
        if (i != 0) {
          if (i != 2)
          {
            if (i != 3)
            {
              localObject2 = paramString;
              localObject8 = localObject5;
              localObject7 = localObject4;
              localObject6 = localObject3;
            }
            else
            {
              localObject2 = paramString;
              localObject8 = localObject5;
              localObject7 = localObject4;
              localObject6 = localObject3;
              localObject1 = paramString;
              if ("PromptConfig".equalsIgnoreCase(localXmlPullParser.getName()))
              {
                localObject2 = paramString;
                localObject8 = localObject5;
                localObject7 = localObject4;
                localObject6 = localObject3;
                if (localObject3 != null)
                {
                  localObject1 = paramString;
                  localObject2 = Boolean.valueOf(true);
                  localObject8 = localObject5;
                  localObject7 = localObject4;
                  localObject6 = localObject3;
                }
              }
            }
          }
          else
          {
            localObject2 = paramString;
            localObject8 = localObject5;
            localObject7 = localObject4;
            localObject6 = localObject3;
            localObject1 = paramString;
            if ("PromptConfig".equalsIgnoreCase(localXmlPullParser.getName()))
            {
              localObject1 = paramString;
              localObject6 = localXmlPullParser.getAttributeValue(null, "content").trim();
              localObject1 = paramString;
              localObject7 = localXmlPullParser.getAttributeValue(null, "urlshowtext").trim();
              localObject1 = paramString;
              localObject8 = localXmlPullParser.getAttributeValue(null, "url").trim();
              localObject2 = paramString;
            }
          }
        }
        localObject1 = localObject2;
        i = localXmlPullParser.next();
        paramString = (String)localObject2;
        localObject5 = localObject8;
        localObject4 = localObject7;
        localObject3 = localObject6;
      }
      localObject1 = paramString;
      localObject2 = paramString;
      if (paramString.booleanValue())
      {
        if (localObject5 != null)
        {
          localObject1 = paramString;
          if ((localObject5.length() > 0) && (localObject4 != null))
          {
            localObject1 = paramString;
            if (((String)localObject4).length() > 0)
            {
              localObject1 = paramString;
              i = ((String)localObject3).indexOf("$URL$");
              localObject2 = paramString;
              if (i < 0) {
                break label492;
              }
              localObject1 = paramString;
              this.linkStart = i;
              localObject1 = paramString;
              this.linkEnd = (i + ((String)localObject4).length());
              localObject1 = paramString;
              this.url = localObject5;
              localObject1 = paramString;
              this.msg = ((String)localObject3).replace("$URL$", (CharSequence)localObject4);
              localObject2 = paramString;
              break label492;
            }
          }
        }
        localObject1 = paramString;
        this.linkStart = 0;
        localObject1 = paramString;
        this.linkEnd = 0;
        localObject1 = paramString;
        this.msg = ((String)localObject3);
        localObject1 = paramString;
        this.url = null;
        localObject2 = paramString;
      }
    }
    catch (Exception paramString)
    {
      this.linkStart = 0;
      this.linkEnd = 0;
      this.msg = null;
      this.url = null;
      localObject2 = localObject1;
      if (QLog.isColorLevel())
      {
        QLog.d(this.TAG, 2, paramString.getMessage(), paramString);
        localObject2 = localObject1;
      }
    }
    label492:
    if (((Boolean)localObject2).booleanValue()) {
      serial();
    }
    return localObject2;
  }
  
  protected void postRead()
  {
    parse();
  }
  
  protected void prewrite()
  {
    serial();
    ReportController.b(null, "CliOper", "", String.valueOf(this.frienduin), "0X800491A", "0X800491A", 0, 0, "", "", "", "");
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
      this.msgData = MessagePkgUtils.a(localIncompatibleGrayTipsMessage);
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