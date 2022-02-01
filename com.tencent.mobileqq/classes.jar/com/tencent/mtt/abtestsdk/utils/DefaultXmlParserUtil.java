package com.tencent.mtt.abtestsdk.utils;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import com.tencent.mtt.abtestsdk.entity.ConfigValue;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserException;

public class DefaultXmlParserUtil
{
  private static final String XML_TAG_ENTRY = "entry";
  private static final String XML_TAG_KEY = "key";
  private static final String XML_TAG_VALUE = "value";
  
  public static Map<String, ConfigValue> getDefaultsFromXml(Context paramContext, int paramInt)
  {
    HashMap localHashMap = new HashMap();
    for (;;)
    {
      Object localObject1;
      try
      {
        paramContext = paramContext.getResources();
        if (paramContext == null)
        {
          ABTestLog.error("Could not find the resources of the current context while trying to set defaults from an XML.", new Object[0]);
          return localHashMap;
        }
        XmlResourceParser localXmlResourceParser = paramContext.getXml(paramInt);
        paramInt = localXmlResourceParser.getEventType();
        Object localObject5 = null;
        localObject1 = localObject5;
        paramContext = (Context)localObject1;
        if (paramInt == 1) {
          break label354;
        }
        if (paramInt == 2)
        {
          localObject2 = localXmlResourceParser.getName();
          localObject3 = localObject1;
          localObject4 = paramContext;
        }
        else
        {
          if (paramInt == 3)
          {
            localObject3 = localObject1;
            localObject4 = paramContext;
            if (!localXmlResourceParser.getName().equals("entry")) {
              break label364;
            }
            if ((localObject1 != null) && (paramContext != null))
            {
              localHashMap.put(localObject1, new ConfigValue(paramContext));
              break label357;
            }
            ABTestLog.error("An entry in the defaults XML has an invalid key and/or value tag.", new Object[0]);
            break label357;
          }
          localObject2 = localObject5;
          localObject3 = localObject1;
          localObject4 = paramContext;
          if (paramInt == 4)
          {
            localObject2 = localObject5;
            localObject3 = localObject1;
            localObject4 = paramContext;
            if (localObject5 != null)
            {
              paramInt = -1;
              int i = localObject5.hashCode();
              if (i != 106079)
              {
                if ((i == 111972721) && (localObject5.equals("value"))) {
                  paramInt = 1;
                }
              }
              else if (localObject5.equals("key")) {
                paramInt = 0;
              }
              if (paramInt != 0)
              {
                if (paramInt != 1)
                {
                  ABTestLog.error("Encountered an unexpected tag while parsing the defaults XML.", new Object[0]);
                  localObject2 = localObject5;
                  localObject3 = localObject1;
                  localObject4 = paramContext;
                }
                else
                {
                  localObject4 = localXmlResourceParser.getText();
                  localObject2 = localObject5;
                  localObject3 = localObject1;
                }
              }
              else
              {
                localObject3 = localXmlResourceParser.getText();
                localObject4 = paramContext;
                localObject2 = localObject5;
              }
            }
          }
        }
        paramInt = localXmlResourceParser.next();
        localObject5 = localObject2;
        localObject1 = localObject3;
        paramContext = (Context)localObject4;
        continue;
        localObject1 = new StringBuilder();
      }
      catch (IOException paramContext) {}catch (XmlPullParserException paramContext) {}
      ((StringBuilder)localObject1).append("Encountered an error while parsing the defaults XML file.");
      ((StringBuilder)localObject1).append(paramContext.getMessage());
      ABTestLog.error(((StringBuilder)localObject1).toString(), new Object[0]);
      label354:
      return localHashMap;
      label357:
      Object localObject3 = null;
      Object localObject4 = localObject3;
      label364:
      Object localObject2 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mtt.abtestsdk.utils.DefaultXmlParserUtil
 * JD-Core Version:    0.7.0.1
 */