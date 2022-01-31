package com.tencent.mobileqq.service.message;

import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import tencent.im.msg.im_msg_body.ApolloActMsg;
import tencent.im.msg.im_msg_body.ArkAppElem;
import tencent.im.msg.im_msg_body.CommonElem;
import tencent.im.msg.im_msg_body.CrmElem;
import tencent.im.msg.im_msg_body.CustomFace;
import tencent.im.msg.im_msg_body.DeliverGiftMsg;
import tencent.im.msg.im_msg_body.Elem;
import tencent.im.msg.im_msg_body.GeneralFlags;
import tencent.im.msg.im_msg_body.GroupFile;
import tencent.im.msg.im_msg_body.GroupPubAccountInfo;
import tencent.im.msg.im_msg_body.LifeOnlineAccount;
import tencent.im.msg.im_msg_body.LightAppElem;
import tencent.im.msg.im_msg_body.MarketFace;
import tencent.im.msg.im_msg_body.MarketTrans;
import tencent.im.msg.im_msg_body.NearByMessageType;
import tencent.im.msg.im_msg_body.NotOnlineImage;
import tencent.im.msg.im_msg_body.QQWalletMsg;
import tencent.im.msg.im_msg_body.RichMsg;
import tencent.im.msg.im_msg_body.ShakeWindow;
import tencent.im.msg.im_msg_body.SourceMsg;
import tencent.im.msg.im_msg_body.TipsInfo;
import tencent.im.msg.im_msg_body.TransElem;
import tencent.im.msg.im_msg_body.VideoFile;
import tencent.im.msg.im_msg_body.WorkflowNotifyMsg;

public class MessagePBDecoderConfig
{
  private static Object jdField_a_of_type_JavaLangObject = new Object();
  private static HashMap jdField_a_of_type_JavaUtilHashMap = ;
  
  protected static int a(ArrayList paramArrayList)
  {
    if (jdField_a_of_type_JavaUtilHashMap == null) {}
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_JavaUtilHashMap == null) {
        jdField_a_of_type_JavaUtilHashMap = a();
      }
      if ((paramArrayList == null) || (paramArrayList.isEmpty())) {
        return 0;
      }
    }
    ??? = paramArrayList.iterator();
    while (((Iterator)???).hasNext())
    {
      String str = (String)((Iterator)???).next();
      if ((jdField_a_of_type_JavaUtilHashMap != null) && (jdField_a_of_type_JavaUtilHashMap.containsKey(str))) {
        return ((Integer)jdField_a_of_type_JavaUtilHashMap.get(str)).intValue();
      }
    }
    if (paramArrayList.contains("nearbyGift")) {
      return 26;
    }
    if (paramArrayList.contains("richMsg")) {
      return 17;
    }
    if (paramArrayList.contains("marketFace")) {
      return 18;
    }
    if ((paramArrayList.contains("notOnlineImage")) || (paramArrayList.contains("customFace"))) {
      return 19;
    }
    if (paramArrayList.contains("srcMsg")) {
      return 20;
    }
    if (paramArrayList.contains("flashchat")) {
      return 30;
    }
    if (paramArrayList.contains("troopConfessMsg")) {
      return 34;
    }
    if (paramArrayList.contains("textMsg")) {
      return 21;
    }
    return 0;
  }
  
  protected static ArrayList a(List paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      im_msg_body.Elem localElem = (im_msg_body.Elem)paramList.next();
      if (localElem.shake_window.has())
      {
        localArrayList.add("shakeWindow");
      }
      else if (localElem.deliver_gift_msg.has())
      {
        localArrayList.add("deliverGift");
      }
      else if (localElem.apollo_msg.has())
      {
        localArrayList.add("apolloMsg");
      }
      else if (localElem.group_file.has())
      {
        localArrayList.add("groupFile");
      }
      else if (localElem.ark_app.has())
      {
        localArrayList.add("arkApp");
      }
      else if (localElem.light_app.has())
      {
        localArrayList.add("lightApp");
      }
      else if (localElem.market_trans.has())
      {
        localArrayList.add("marketTrans");
      }
      else if (localElem.video_file.has())
      {
        localArrayList.add("videoFile");
      }
      else if (localElem.life_online.has())
      {
        localArrayList.add("lifeOnline");
      }
      else if (localElem.tips_info.has())
      {
        localArrayList.add("tipsInfo");
      }
      else if (localElem.msg_workflow_notify.has())
      {
        localArrayList.add("msgWorkFolwNotify");
      }
      else if ((localElem.group_pub_acc_info.has()) && (localElem.group_pub_acc_info.uint64_pub_account.has()))
      {
        localArrayList.add("groupPubAcc");
      }
      else if (localElem.trans_elem_info.has())
      {
        localArrayList.add("transElemInfo");
      }
      else if (localElem.qqwallet_msg.has())
      {
        localArrayList.add("qqWalletMsg");
      }
      else if ((localElem.common_elem.has()) && (1 == localElem.common_elem.uint32_service_type.get()))
      {
        localArrayList.add("troopReward");
      }
      else if ((localElem.common_elem.has()) && (2 == localElem.common_elem.uint32_service_type.get()))
      {
        localArrayList.add("pokeMsg");
      }
      else if ((localElem.common_elem.has()) && (3 == localElem.common_elem.uint32_service_type.get()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("flashs", 2, "pbdecodeConfig getElemStrs ==FlashPicMsg");
        }
        localArrayList.add("FlashPicMsg");
      }
      else if ((localElem.common_elem.has()) && (4 == localElem.common_elem.uint32_service_type.get()))
      {
        localArrayList.add("qqStoryMsg");
      }
      else if ((localElem.common_elem.has()) && (5 == localElem.common_elem.uint32_service_type.get()))
      {
        localArrayList.add("qqStoryCommentMsg");
      }
      else if ((localElem.common_elem.has()) && (15 == localElem.common_elem.uint32_service_type.get()))
      {
        localArrayList.add("troopStoryCommentMsg");
      }
      else if ((localElem.common_elem.has()) && (8 == localElem.common_elem.uint32_service_type.get()))
      {
        localArrayList.add("nearbyGift");
      }
      else if ((localElem.common_elem.has()) && (14 == localElem.common_elem.uint32_service_type.get()))
      {
        localArrayList.add("flashchat");
      }
      else if ((localElem.common_elem.has()) && (19 == localElem.common_elem.uint32_service_type.get()))
      {
        localArrayList.add("arkBabyqMsg");
      }
      else if ((localElem.common_elem.has()) && (20 == localElem.common_elem.uint32_service_type.get()))
      {
        localArrayList.add("arkSdkStructMsg");
      }
      else if (localElem.rich_msg.has())
      {
        localArrayList.add("richMsg");
      }
      else if (localElem.market_face.has())
      {
        localArrayList.add("marketFace");
      }
      else if (localElem.not_online_image.has())
      {
        localArrayList.add("notOnlineImage");
      }
      else if (localElem.custom_face.has())
      {
        localArrayList.add("customFace");
      }
      else if (localElem.hc_flash_pic.has())
      {
        localArrayList.add("hcFlashPic");
      }
      else if (localElem.src_msg.has())
      {
        localArrayList.add("srcMsg");
      }
      else if (MessagePBElemDecoder.a(localElem).booleanValue())
      {
        localArrayList.add("textMsg");
      }
      else if (localElem.near_by_msg.has())
      {
        localArrayList.add("nearByMsg");
      }
      else if (localElem.general_flags.has())
      {
        localArrayList.add("generalFlags");
      }
      else if (localElem.crm_elem.has())
      {
        localArrayList.add("crmElemFlags");
      }
      else if ((localElem.common_elem.has()) && (13 == localElem.common_elem.uint32_service_type.get()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("updateavatar", 2, "pb decode hummer_commelem == UpdateStrangerAvatar");
        }
        localArrayList.add("updateAvatar");
      }
      else if ((localElem.common_elem.has()) && (16 == localElem.common_elem.uint32_service_type.get()))
      {
        localArrayList.add("troopStoryMsg");
      }
      else if ((localElem.common_elem.has()) && (18 == localElem.common_elem.uint32_service_type.get()))
      {
        localArrayList.add("goldMsg");
      }
      else if ((localElem.common_elem.has()) && (11 == localElem.common_elem.uint32_service_type.get()))
      {
        localArrayList.add("scribbleMsg");
      }
      else if ((localElem.common_elem.has()) && (21 == localElem.common_elem.uint32_service_type.get()) && (3 == localElem.common_elem.uint32_business_type.get()))
      {
        localArrayList.add("troopConfessMsg");
      }
      else if ((localElem.common_elem.has()) && (21 == localElem.common_elem.uint32_service_type.get()))
      {
        localArrayList.add("confessMsg");
      }
      else if ((localElem.common_elem.has()) && (23 == localElem.common_elem.uint32_service_type.get()))
      {
        localArrayList.add("pokeEmoMsg");
      }
    }
    return localArrayList;
  }
  
  protected static HashMap a()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("shakeWindow", Integer.valueOf(1));
    localHashMap.put("deliverGift", Integer.valueOf(2));
    localHashMap.put("lolaMsg", Integer.valueOf(3));
    localHashMap.put("apolloMsg", Integer.valueOf(4));
    localHashMap.put("groupFile", Integer.valueOf(5));
    localHashMap.put("arkApp", Integer.valueOf(6));
    localHashMap.put("lightApp", Integer.valueOf(6));
    localHashMap.put("marketTrans", Integer.valueOf(7));
    localHashMap.put("videoFile", Integer.valueOf(8));
    localHashMap.put("tipsInfo", Integer.valueOf(10));
    localHashMap.put("msgWorkFolwNotify", Integer.valueOf(11));
    localHashMap.put("groupPubAcc", Integer.valueOf(12));
    localHashMap.put("transElemInfo", Integer.valueOf(13));
    localHashMap.put("qqWalletMsg", Integer.valueOf(14));
    localHashMap.put("troopReward", Integer.valueOf(15));
    localHashMap.put("pokeMsg", Integer.valueOf(16));
    localHashMap.put("hcFlashPic", Integer.valueOf(22));
    localHashMap.put("FlashPicMsg", Integer.valueOf(23));
    localHashMap.put("qqStoryMsg", Integer.valueOf(24));
    localHashMap.put("qqStoryCommentMsg", Integer.valueOf(25));
    localHashMap.put("troopStoryCommentMsg", Integer.valueOf(27));
    localHashMap.put("troopStoryMsg", Integer.valueOf(28));
    localHashMap.put("scribbleMsg", Integer.valueOf(29));
    localHashMap.put("arkBabyqMsg", Integer.valueOf(31));
    localHashMap.put("arkSdkStructMsg", Integer.valueOf(32));
    localHashMap.put("pokeEmoMsg", Integer.valueOf(33));
    return localHashMap;
  }
  
  protected static boolean a(ArrayList paramArrayList)
  {
    return (paramArrayList.contains("lifeOnline")) || (paramArrayList.contains("nearByMsg")) || (paramArrayList.contains("generalFlags")) || (paramArrayList.contains("crmElemFlags")) || (paramArrayList.contains("updateAvatar")) || (paramArrayList.contains("goldMsg")) || (paramArrayList.contains("confessMsg"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.service.message.MessagePBDecoderConfig
 * JD-Core Version:    0.7.0.1
 */