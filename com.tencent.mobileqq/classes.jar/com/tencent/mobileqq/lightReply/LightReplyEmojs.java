package com.tencent.mobileqq.lightReply;

import java.io.Serializable;

public class LightReplyEmojs
  implements Serializable
{
  public String android_key;
  public String bigUrl;
  public String emoCode;
  public String smallUrl;
  
  public LightReplyEmojs(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.emoCode = paramString1;
    this.smallUrl = paramString2;
    this.bigUrl = paramString3;
    this.android_key = paramString4;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = true;
    boolean bool3 = false;
    boolean bool1;
    if (this == paramObject) {
      bool1 = true;
    }
    label88:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return bool1;
              bool1 = bool3;
            } while (paramObject == null);
            bool1 = bool3;
          } while (getClass() != paramObject.getClass());
          paramObject = (LightReplyEmojs)paramObject;
          if (this.emoCode == null) {
            break;
          }
          bool1 = bool3;
        } while (!this.emoCode.equals(paramObject.emoCode));
        if (this.smallUrl == null) {
          break label142;
        }
        bool1 = bool3;
      } while (!this.smallUrl.equals(paramObject.smallUrl));
      if (this.bigUrl == null) {
        break label151;
      }
      bool1 = bool3;
    } while (!this.bigUrl.equals(paramObject.bigUrl));
    label112:
    if (this.android_key != null) {
      bool1 = this.android_key.equals(paramObject.android_key);
    }
    for (;;)
    {
      return bool1;
      if (paramObject.emoCode == null) {
        break;
      }
      return false;
      label142:
      if (paramObject.smallUrl == null) {
        break label88;
      }
      return false;
      label151:
      if (paramObject.bigUrl == null) {
        break label112;
      }
      return false;
      bool1 = bool2;
      if (paramObject.android_key != null) {
        bool1 = false;
      }
    }
  }
  
  public int hashCode()
  {
    int m = 0;
    int i;
    int j;
    if (this.emoCode != null)
    {
      i = this.emoCode.hashCode();
      if (this.smallUrl == null) {
        break label87;
      }
      j = this.smallUrl.hashCode();
      label33:
      if (this.bigUrl == null) {
        break label92;
      }
    }
    label87:
    label92:
    for (int k = this.bigUrl.hashCode();; k = 0)
    {
      if (this.android_key != null) {
        m = this.android_key.hashCode();
      }
      return (k + (j + i * 31) * 31) * 31 + m;
      i = 0;
      break;
      j = 0;
      break label33;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\com33.jar
 * Qualified Name:     com.tencent.mobileqq.lightReply.LightReplyEmojs
 * JD-Core Version:    0.7.0.1
 */