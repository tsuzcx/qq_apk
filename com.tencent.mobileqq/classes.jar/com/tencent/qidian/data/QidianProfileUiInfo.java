package com.tencent.qidian.data;

import bkgt;
import bkii;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;
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
  public static final int CONFIG_INFO_TYPE_GROUP = 3;
  public static final int CONFIG_INFO_TYPE_PA = 2;
  public static final int CONFIG_INFO_TYPE_QZONE = 6;
  public static final int CONFIG_INFO_TYPE_TEXT = 1;
  private static final String TAG = "QidianProfileUiInfo";
  public byte[] infoByte;
  public List<bkii> mConfigGroupInfos;
  @unique
  public String uin = "";
  
  private void initList()
  {
    Object localObject3;
    try
    {
      Object localObject1 = (bkgt)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(165);
      if (this.infoByte != null)
      {
        if (((bkgt)localObject1).c(this.uin, true)) {
          break label164;
        }
        localObject1 = new mobileqq_qidian.GetUserDetailInfoRspBody();
        ((mobileqq_qidian.GetUserDetailInfoRspBody)localObject1).mergeFrom(this.infoByte);
        if (((mobileqq_qidian.GetUserDetailInfoRspBody)localObject1).rpt_msg_config_group_info.has())
        {
          localObject3 = ((mobileqq_qidian.GetUserDetailInfoRspBody)localObject1).rpt_msg_config_group_info.get();
          if ((localObject3 != null) && (((List)localObject3).size() > 0))
          {
            this.infoByte = ((mobileqq_qidian.GetUserDetailInfoRspBody)localObject1).toByteArray();
            this.mConfigGroupInfos = new ArrayList(((List)localObject3).size());
            localObject1 = ((List)localObject3).iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject3 = new bkii((mobileqq_qidian.ConfigGroupInfo)((Iterator)localObject1).next());
              this.mConfigGroupInfos.add(localObject3);
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
    for (;;)
    {
      label164:
      Object localObject2 = new mobileqq_qidian.GetCorpUinDetailInfoRspBody();
      ((mobileqq_qidian.GetCorpUinDetailInfoRspBody)localObject2).mergeFrom(this.infoByte);
      if (((mobileqq_qidian.GetCorpUinDetailInfoRspBody)localObject2).rpt_msg_config_group_info.has())
      {
        localObject3 = ((mobileqq_qidian.GetCorpUinDetailInfoRspBody)localObject2).rpt_msg_config_group_info.get();
        if ((localObject3 != null) && (((List)localObject3).size() > 0))
        {
          this.infoByte = ((mobileqq_qidian.GetCorpUinDetailInfoRspBody)localObject2).toByteArray();
          this.mConfigGroupInfos = new ArrayList(((List)localObject3).size());
          localObject2 = ((List)localObject3).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = new bkii((mobileqq_qidian.ConfigGroupInfo)((Iterator)localObject2).next());
            this.mConfigGroupInfos.add(localObject3);
          }
        }
      }
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return false;
      if (paramObject == this) {
        return true;
      }
    } while (paramObject.getClass() != getClass());
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
  
  public List<bkii> getConfigGroupInfos()
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