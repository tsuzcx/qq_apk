package com.tencent.oskplayer.util;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ContentTypeFixer
  implements Fixer<Map<String, List<String>>>
{
  public static final String GENERAL_CONTENT_TYPE = "application/octet-stream";
  private final String mLogTag;
  private final String mPreferredContentType;
  
  public ContentTypeFixer(String paramString1, String paramString2)
  {
    this.mPreferredContentType = paramString1;
    this.mLogTag = paramString2;
  }
  
  public String fix(String paramString)
  {
    String str = paramString;
    if (paramString.equals("application/octet-stream"))
    {
      str = paramString;
      if (!TextUtils.isEmpty(this.mPreferredContentType))
      {
        PlayerUtils.log(5, this.mLogTag, "modify contentType from " + paramString + " to " + this.mPreferredContentType);
        str = this.mPreferredContentType;
      }
    }
    return str;
  }
  
  public Map<String, List<String>> fix(Map<String, List<String>> paramMap)
  {
    Object localObject1 = paramMap;
    if (paramMap != null)
    {
      Object localObject2 = (List)paramMap.get("Content-Type");
      localObject1 = paramMap;
      if (localObject2 != null)
      {
        localObject1 = paramMap;
        if (((List)localObject2).size() > 0)
        {
          localObject2 = (String)((List)localObject2).get(0);
          localObject1 = paramMap;
          if (((String)localObject2).equals("application/octet-stream"))
          {
            localObject1 = paramMap;
            if (!TextUtils.isEmpty(this.mPreferredContentType))
            {
              localObject1 = new HashMap();
              paramMap = paramMap.entrySet().iterator();
              while (paramMap.hasNext())
              {
                Object localObject3 = (Map.Entry)paramMap.next();
                if ((((Map.Entry)localObject3).getKey() != null) && (((String)((Map.Entry)localObject3).getKey()).equals("Content-Type")))
                {
                  localObject3 = new ArrayList();
                  ((ArrayList)localObject3).add(this.mPreferredContentType);
                  ((HashMap)localObject1).put("Content-Type", localObject3);
                  PlayerUtils.log(5, this.mLogTag, "fix Content-Type from " + (String)localObject2 + " to " + this.mPreferredContentType);
                }
                else
                {
                  ((HashMap)localObject1).put(((Map.Entry)localObject3).getKey(), ((Map.Entry)localObject3).getValue());
                }
              }
              localObject1 = Collections.unmodifiableMap((Map)localObject1);
            }
          }
        }
      }
    }
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.oskplayer.util.ContentTypeFixer
 * JD-Core Version:    0.7.0.1
 */