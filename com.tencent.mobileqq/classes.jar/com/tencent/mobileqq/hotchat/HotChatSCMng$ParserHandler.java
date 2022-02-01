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
  private HotChatNote jdField_a_of_type_ComTencentMobileqqHotchatHotChatNote;
  private HotChatSCMng.HotchatNotice jdField_a_of_type_ComTencentMobileqqHotchatHotChatSCMng$HotchatNotice;
  private XmlPullParser jdField_a_of_type_OrgXmlpullV1XmlPullParser;
  
  public HotChatSCMng$ParserHandler(HotChatSCMng paramHotChatSCMng, HotChatSCMng.HotchatNotice paramHotchatNotice, HotChatNote paramHotChatNote, XmlPullParser paramXmlPullParser)
  {
    this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatSCMng$HotchatNotice = paramHotchatNotice;
    this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatNote = paramHotChatNote;
    this.jdField_a_of_type_OrgXmlpullV1XmlPullParser = paramXmlPullParser;
  }
  
  public HotChatNote a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatNote;
  }
  
  public HotChatSCMng.HotchatNotice a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatSCMng$HotchatNotice;
  }
  
  public ParserHandler a()
  {
    Object localObject1 = this.jdField_a_of_type_OrgXmlpullV1XmlPullParser.getName();
    if ("activity".equals(localObject1))
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatSCMng$HotchatNotice;
      if (localObject1 == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatSCMng$HotchatNotice = new HotChatSCMng.HotchatNotice();
        return this;
      }
      ((HotChatSCMng.HotchatNotice)localObject1).a();
      return this;
    }
    if ("note".equals(localObject1))
    {
      this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatNote = new HotChatNote();
      return this;
    }
    if ("activityid".equals(localObject1))
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatSCMng$HotchatNotice;
      if (localObject1 != null)
      {
        ((HotChatSCMng.HotchatNotice)localObject1).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_OrgXmlpullV1XmlPullParser.nextText();
        return this;
      }
    }
    else
    {
      Object localObject3;
      if ("stime".equals(localObject1))
      {
        localObject1 = this.jdField_a_of_type_OrgXmlpullV1XmlPullParser.nextText();
        localObject3 = this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatNote;
        if (localObject3 != null)
        {
          ((HotChatNote)localObject3).jdField_a_of_type_Long = HotChatNote.a((String)localObject1);
          return this;
        }
      }
      else if ("content".equals(localObject1))
      {
        try
        {
          localObject3 = this.jdField_a_of_type_OrgXmlpullV1XmlPullParser.nextText();
          localObject1 = localObject3;
          if (localObject3 != null) {
            localObject1 = ((String)localObject3).trim();
          }
          if (this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatNote == null) {
            return this;
          }
          this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatNote.jdField_a_of_type_JavaLangString = ((String)localObject1);
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
          localObject2 = this.jdField_a_of_type_OrgXmlpullV1XmlPullParser.nextText();
          localObject3 = this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatNote;
          if (localObject3 != null)
          {
            ((HotChatNote)localObject3).jdField_b_of_type_Long = HotChatNote.a((String)localObject2);
            return this;
          }
        }
        else if ("url".equals(localObject2))
        {
          try
          {
            localObject3 = this.jdField_a_of_type_OrgXmlpullV1XmlPullParser.nextText();
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
            if (this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatNote != null)
            {
              this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatNote.jdField_b_of_type_JavaLangString = ((String)localObject3);
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
  
  public ParserHandler b()
  {
    Object localObject;
    if ("activity".equals(this.jdField_a_of_type_OrgXmlpullV1XmlPullParser.getName()))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatSCMng$HotchatNotice;
      if ((localObject != null) && (!TextUtils.isEmpty(((HotChatSCMng.HotchatNotice)localObject).jdField_a_of_type_JavaLangString)))
      {
        HotChatSCMng.HotchatNotice localHotchatNotice = (HotChatSCMng.HotchatNotice)this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatSCMng.mConfigs.get(this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatSCMng$HotchatNotice.jdField_a_of_type_JavaLangString);
        if (localHotchatNotice == null) {
          localObject = "null";
        } else {
          localObject = "not null";
        }
        NearbyUtils.a("HotchatSCMng", "parse", new Object[] { localObject, this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatSCMng$HotchatNotice });
        if (localHotchatNotice == null)
        {
          this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatSCMng.mConfigs.put(this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatSCMng$HotchatNotice.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatSCMng$HotchatNotice);
          this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatSCMng$HotchatNotice = null;
          return this;
        }
        localHotchatNotice.jdField_a_of_type_Int = -1;
        localHotchatNotice.jdField_a_of_type_JavaUtilArrayList.addAll(this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatSCMng$HotchatNotice.jdField_a_of_type_JavaUtilArrayList);
        this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatSCMng$HotchatNotice.a();
        return this;
      }
    }
    else if (("note".equals(this.jdField_a_of_type_OrgXmlpullV1XmlPullParser.getName())) && (this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatNote != null))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatSCMng$HotchatNotice;
      if (localObject != null)
      {
        ((HotChatSCMng.HotchatNotice)localObject).jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatNote);
        this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatNote = null;
      }
    }
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.hotchat.HotChatSCMng.ParserHandler
 * JD-Core Version:    0.7.0.1
 */