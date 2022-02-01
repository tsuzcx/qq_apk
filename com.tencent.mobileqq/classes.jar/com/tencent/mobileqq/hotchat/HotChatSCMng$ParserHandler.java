package com.tencent.mobileqq.hotchat;

import android.text.TextUtils;
import android.util.Base64;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;

class HotChatSCMng$ParserHandler
{
  private HotChatSCMng.HotchatNotice b;
  private HotChatNote c;
  private XmlPullParser d;
  
  public HotChatSCMng$ParserHandler(HotChatSCMng paramHotChatSCMng, HotChatSCMng.HotchatNotice paramHotchatNotice, HotChatNote paramHotChatNote, XmlPullParser paramXmlPullParser)
  {
    this.b = paramHotchatNotice;
    this.c = paramHotChatNote;
    this.d = paramXmlPullParser;
  }
  
  public HotChatSCMng.HotchatNotice a()
  {
    return this.b;
  }
  
  public HotChatNote b()
  {
    return this.c;
  }
  
  public ParserHandler c()
  {
    Object localObject1 = this.d.getName();
    if ("activity".equals(localObject1))
    {
      localObject1 = this.b;
      if (localObject1 == null)
      {
        this.b = new HotChatSCMng.HotchatNotice();
        return this;
      }
      ((HotChatSCMng.HotchatNotice)localObject1).a();
      return this;
    }
    if ("note".equals(localObject1))
    {
      this.c = new HotChatNote();
      return this;
    }
    if ("activityid".equals(localObject1))
    {
      localObject1 = this.b;
      if (localObject1 != null)
      {
        ((HotChatSCMng.HotchatNotice)localObject1).a = this.d.nextText();
        return this;
      }
    }
    else
    {
      Object localObject3;
      if ("stime".equals(localObject1))
      {
        localObject1 = this.d.nextText();
        localObject3 = this.c;
        if (localObject3 != null)
        {
          ((HotChatNote)localObject3).e = HotChatNote.a((String)localObject1);
          return this;
        }
      }
      else if ("content".equals(localObject1))
      {
        try
        {
          localObject3 = this.d.nextText();
          localObject1 = localObject3;
          if (localObject3 != null) {
            localObject1 = ((String)localObject3).trim();
          }
          if (this.c == null) {
            return this;
          }
          this.c.c = ((String)localObject1);
          return this;
        }
        catch (Exception localException1)
        {
          localException1.printStackTrace();
          if (!QLog.isColorLevel()) {
            return this;
          }
        }
        NearbyUtils.a("HotchatSCMng", new Object[] { "parseNotice exception", localException1.toString() });
        return this;
      }
      else
      {
        Object localObject2;
        if ("endtime".equals(localException1))
        {
          localObject2 = this.d.nextText();
          localObject3 = this.c;
          if (localObject3 != null)
          {
            ((HotChatNote)localObject3).f = HotChatNote.a((String)localObject2);
            return this;
          }
        }
        else if ("url".equals(localObject2))
        {
          try
          {
            localObject3 = this.d.nextText();
            localObject2 = localObject3;
            if (localObject3 != null) {
              localObject2 = ((String)localObject3).trim();
            }
            localObject3 = localObject2;
            if (localObject2 != null)
            {
              localObject3 = localObject2;
              if (!((String)localObject2).startsWith("http://"))
              {
                localObject3 = localObject2;
                if (!((String)localObject2).contains("&")) {
                  localObject3 = new String(Base64.decode(((String)localObject2).getBytes(), 0));
                }
              }
            }
            if (this.c != null)
            {
              this.c.d = ((String)localObject3);
              return this;
            }
          }
          catch (Exception localException2)
          {
            localException2.printStackTrace();
            if (QLog.isColorLevel()) {
              NearbyUtils.a("HotchatSCMng", new Object[] { "parseNotice exception", localException2.toString() });
            }
          }
        }
      }
    }
    return this;
  }
  
  public ParserHandler d()
  {
    Object localObject;
    if ("activity".equals(this.d.getName()))
    {
      localObject = this.b;
      if ((localObject != null) && (!TextUtils.isEmpty(((HotChatSCMng.HotchatNotice)localObject).a)))
      {
        HotChatSCMng.HotchatNotice localHotchatNotice = (HotChatSCMng.HotchatNotice)this.a.mConfigs.get(this.b.a);
        if (localHotchatNotice == null) {
          localObject = "null";
        } else {
          localObject = "not null";
        }
        NearbyUtils.a("HotchatSCMng", "parse", new Object[] { localObject, this.b });
        if (localHotchatNotice == null)
        {
          this.a.mConfigs.put(this.b.a, this.b);
          this.b = null;
          return this;
        }
        localHotchatNotice.b = -1;
        localHotchatNotice.c.addAll(this.b.c);
        this.b.a();
        return this;
      }
    }
    else if (("note".equals(this.d.getName())) && (this.c != null))
    {
      localObject = this.b;
      if (localObject != null)
      {
        ((HotChatSCMng.HotchatNotice)localObject).c.add(this.c);
        this.c = null;
      }
    }
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.hotchat.HotChatSCMng.ParserHandler
 * JD-Core Version:    0.7.0.1
 */