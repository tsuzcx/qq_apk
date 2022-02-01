package com.tencent.qidian.data;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.qidian.QidianManager;
import com.tencent.qidian.proto.mobileqq_qidian.ConfigGroupInfo;
import com.tencent.qidian.proto.mobileqq_qidian.GetCorpUinDetailInfoRspBody;
import com.tencent.qidian.proto.mobileqq_qidian.GetUserDetailInfoRspBody;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class QidianProfileUiInfo
  extends Entity
{
  public static final int CONFIG_INFO_EVENT_CALL_MOBILE = 2;
  public static final int CONFIG_INFO_EVENT_CALL_TEL = 1;
  public static final int CONFIG_INFO_EVENT_MAIL = 3;
  public static final int CONFIG_INFO_EVENT_NONE = 0;
  public static final int CONFIG_INFO_EVENT_OPEN_BROWSER = 6;
  public static final int CONFIG_INFO_EVENT_OPEN_MAP = 5;
  public static final int CONFIG_INFO_EVENT_PLUGIN_APP = 7;
  public static final int CONFIG_INFO_EVENT_QZONE = 9;
  public static final int CONFIG_INFO_EVENT_SHOW_ALL_TEXT = 4;
  public static final int CONFIG_INFO_TITLE_TYPE_ACCOUNT = 4;
  public static final int CONFIG_INFO_TITLE_TYPE_ADDRESS = 5;
  public static final int CONFIG_INFO_TITLE_TYPE_COMPANY = 7;
  public static final int CONFIG_INFO_TITLE_TYPE_DEFAULT = 0;
  public static final int CONFIG_INFO_TITLE_TYPE_ENTERPRISE_FULL_NAME = 11;
  public static final int CONFIG_INFO_TITLE_TYPE_LINK = 6;
  public static final int CONFIG_INFO_TITLE_TYPE_MAIL = 3;
  public static final int CONFIG_INFO_TITLE_TYPE_MOBILE = 2;
  public static final int CONFIG_INFO_TITLE_TYPE_PEOPLE = 8;
  public static final int CONFIG_INFO_TITLE_TYPE_QZONE = 10;
  public static final int CONFIG_INFO_TITLE_TYPE_RECOMMENDED_ATTENTION = 12;
  public static final int CONFIG_INFO_TITLE_TYPE_RECOMMENDED_GROUP = 13;
  public static final int CONFIG_INFO_TITLE_TYPE_SIGN = 9;
  public static final int CONFIG_INFO_TITLE_TYPE_TEL = 1;
  public static final int CONFIG_INFO_TYPE_GROUP = 3;
  public static final int CONFIG_INFO_TYPE_PA = 2;
  public static final int CONFIG_INFO_TYPE_QZONE = 6;
  public static final int CONFIG_INFO_TYPE_TEXT = 1;
  private static final String TAG = "QidianProfileUiInfo";
  public byte[] infoByte;
  public List<QidianProfileUiInfo.ConfigGroupInfo> mConfigGroupInfos = null;
  @unique
  public String uin = "";
  
  private void initList()
  {
    try
    {
      Object localObject1 = (QidianManager)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(QQManagerFactory.QIDIAN_MANAGER);
      if (this.infoByte != null)
      {
        Object localObject2;
        if (!((QidianManager)localObject1).c(this.uin, true))
        {
          localObject1 = new mobileqq_qidian.GetUserDetailInfoRspBody();
          ((mobileqq_qidian.GetUserDetailInfoRspBody)localObject1).mergeFrom(this.infoByte);
          if (((mobileqq_qidian.GetUserDetailInfoRspBody)localObject1).rpt_msg_config_group_info.has())
          {
            localObject2 = ((mobileqq_qidian.GetUserDetailInfoRspBody)localObject1).rpt_msg_config_group_info.get();
            if ((localObject2 != null) && (((List)localObject2).size() > 0))
            {
              this.infoByte = ((mobileqq_qidian.GetUserDetailInfoRspBody)localObject1).toByteArray();
              this.mConfigGroupInfos = new ArrayList(((List)localObject2).size());
              localObject1 = ((List)localObject2).iterator();
              while (((Iterator)localObject1).hasNext())
              {
                localObject2 = new QidianProfileUiInfo.ConfigGroupInfo((mobileqq_qidian.ConfigGroupInfo)((Iterator)localObject1).next());
                this.mConfigGroupInfos.add(localObject2);
              }
            }
          }
        }
        else
        {
          localObject1 = new mobileqq_qidian.GetCorpUinDetailInfoRspBody();
          ((mobileqq_qidian.GetCorpUinDetailInfoRspBody)localObject1).mergeFrom(this.infoByte);
          if (((mobileqq_qidian.GetCorpUinDetailInfoRspBody)localObject1).rpt_msg_config_group_info.has())
          {
            localObject2 = ((mobileqq_qidian.GetCorpUinDetailInfoRspBody)localObject1).rpt_msg_config_group_info.get();
            if ((localObject2 != null) && (((List)localObject2).size() > 0))
            {
              this.infoByte = ((mobileqq_qidian.GetCorpUinDetailInfoRspBody)localObject1).toByteArray();
              this.mConfigGroupInfos = new ArrayList(((List)localObject2).size());
              localObject1 = ((List)localObject2).iterator();
              while (((Iterator)localObject1).hasNext())
              {
                localObject2 = new QidianProfileUiInfo.ConfigGroupInfo((mobileqq_qidian.ConfigGroupInfo)((Iterator)localObject1).next());
                this.mConfigGroupInfos.add(localObject2);
              }
            }
          }
        }
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {
      return false;
    }
    if (paramObject == this) {
      return true;
    }
    if (paramObject.getClass() != getClass()) {
      return false;
    }
    paramObject = (QidianProfileUiInfo)paramObject;
    return Arrays.equals(this.infoByte, paramObject.infoByte);
  }
  
  public void from(String paramString, mobileqq_qidian.GetCorpUinDetailInfoRspBody paramGetCorpUinDetailInfoRspBody)
  {
    this.uin = paramString;
    this.infoByte = paramGetCorpUinDetailInfoRspBody.toByteArray();
    initList();
  }
  
  public void from(String paramString, mobileqq_qidian.GetUserDetailInfoRspBody paramGetUserDetailInfoRspBody)
  {
    this.uin = paramString;
    this.infoByte = paramGetUserDetailInfoRspBody.toByteArray();
    initList();
  }
  
  public List<QidianProfileUiInfo.ConfigGroupInfo> getConfigGroupInfos()
  {
    if (this.mConfigGroupInfos == null)
    {
      initList();
      if (this.mConfigGroupInfos == null) {
        this.mConfigGroupInfos = new ArrayList();
      }
    }
    return this.mConfigGroupInfos;
  }
  
  public int hashCode()
  {
    return Arrays.hashCode(this.infoByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qidian.data.QidianProfileUiInfo
 * JD-Core Version:    0.7.0.1
 */