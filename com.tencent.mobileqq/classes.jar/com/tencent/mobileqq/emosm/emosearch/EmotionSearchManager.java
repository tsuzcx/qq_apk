package com.tencent.mobileqq.emosm.emosearch;

import android.content.Intent;
import android.os.SystemClock;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.emoticonview.ipc.QQEmoticonMainPanelApp;
import com.tencent.mobileqq.emoticonview.ipc.proxy.EmotionSearchManagerProxy;
import com.tencent.mobileqq.hotpic.HotPicServlet;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.pb.hotpicmsg.HotPicMsg.GetImgInfoReq;
import com.tencent.pb.hotpicmsg.HotPicMsg.GetImgInfoRsp;
import com.tencent.pb.hotpicmsg.HotPicMsg.ImgInfo;
import com.tencent.pb.hotpicmsg.HotPicMsg.ReqBody;
import com.tencent.pb.hotpicmsg.HotPicMsg.RspBody;
import com.tencent.pb.hotpicmsg.HotPicMsg.ThirdPartyInfo;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mqq.app.NewIntent;
import mqq.manager.Manager;
import mqq.util.WeakReference;

public class EmotionSearchManager
  implements Manager
{
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  volatile EmotionSearchManager.EmotionSearchTask jdField_a_of_type_ComTencentMobileqqEmosmEmosearchEmotionSearchManager$EmotionSearchTask;
  EmotionSearchManager.IEmotionSearchCallBack jdField_a_of_type_ComTencentMobileqqEmosmEmosearchEmotionSearchManager$IEmotionSearchCallBack;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  List<EmotionSearchItem> jdField_a_of_type_JavaUtilList = new ArrayList();
  WeakReference<EmotionSearchManager.EmotionSearchResult> jdField_a_of_type_MqqUtilWeakReference;
  volatile EmotionSearchManager.EmotionSearchTask b;
  
  public EmotionSearchManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public static EmotionSearchManager a(QQAppInterface paramQQAppInterface)
  {
    return (EmotionSearchManager)paramQQAppInterface.getManager(QQManagerFactory.EMOTION_SEARCH_MANAGER);
  }
  
  public static EmotionSearchManagerProxy a(QQEmoticonMainPanelApp paramQQEmoticonMainPanelApp)
  {
    return (EmotionSearchManagerProxy)paramQQEmoticonMainPanelApp.getManager(QQManagerFactory.EMOTION_SEARCH_MANAGER);
  }
  
  private void a(EmotionSearchManager.EmotionSearchResult paramEmotionSearchResult)
  {
    if (paramEmotionSearchResult == null) {
      return;
    }
    int i;
    if (paramEmotionSearchResult.searchTask == null)
    {
      i = 0;
      label14:
      if (paramEmotionSearchResult.searchTask != null) {
        break label63;
      }
    }
    label63:
    for (String str = "";; str = paramEmotionSearchResult.searchTask.searchKeyWords)
    {
      a(paramEmotionSearchResult.nResult, i, str);
      if (this.jdField_a_of_type_ComTencentMobileqqEmosmEmosearchEmotionSearchManager$IEmotionSearchCallBack == null) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqEmosmEmosearchEmotionSearchManager$IEmotionSearchCallBack.onSearchCallBack(paramEmotionSearchResult);
      return;
      i = paramEmotionSearchResult.searchTask.taskType;
      break label14;
    }
  }
  
  private void a(EmotionSearchManager.EmotionSearchTask paramEmotionSearchTask, List<EmotionSearchItem> arg2, int paramInt)
  {
    if (!paramEmotionSearchTask.isSame(this.b))
    {
      if (QLog.isColorLevel()) {
        QLog.e("EmotionSearchManager", 2, "handleResponsData requestTask not current error, requestTask = " + paramEmotionSearchTask.taskType + "|" + paramEmotionSearchTask.searchKeyWords);
      }
      return;
    }
    EmotionSearchManager.EmotionSearchResult localEmotionSearchResult = new EmotionSearchManager.EmotionSearchResult(paramInt);
    paramEmotionSearchTask.hasMore = false;
    if ((paramInt == 0) && (???.size() > 0) && (this.jdField_a_of_type_JavaUtilList.size() == ((EmotionSearchItem)???.get(0)).picIndex))
    {
      this.jdField_a_of_type_JavaUtilList.addAll(???);
      paramEmotionSearchTask.hasMore = true;
    }
    localEmotionSearchResult.searchTask = paramEmotionSearchTask;
    localEmotionSearchResult.itemList = new ArrayList();
    localEmotionSearchResult.itemList.addAll(this.jdField_a_of_type_JavaUtilList);
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_ComTencentMobileqqEmosmEmosearchEmotionSearchManager$EmotionSearchTask = this.b;
      this.b = null;
      if ((paramEmotionSearchTask.taskType == 0) && (paramInt == 0)) {
        this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(localEmotionSearchResult);
      }
      a(localEmotionSearchResult);
      return;
    }
  }
  
  private void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmotionSearchManager", 2, "requestData start");
    }
    Object localObject1 = this.b;
    if (localObject1 == null)
    {
      QLog.e("EmotionSearchManager", 2, "requestData currentSearchingTask is null");
      return;
    }
    int i = ((EmotionSearchManager.EmotionSearchTask)localObject1).startIndex;
    int j = ((EmotionSearchManager.EmotionSearchTask)localObject1).startIndex;
    int k = ((EmotionSearchManager.EmotionSearchTask)localObject1).buildver;
    Object localObject2 = new HotPicMsg.ReqBody();
    Object localObject3 = new HotPicMsg.GetImgInfoReq();
    ((HotPicMsg.ReqBody)localObject2).setHasFlag(true);
    ((HotPicMsg.GetImgInfoReq)localObject3).uint64_src_uin.set(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()));
    ((HotPicMsg.GetImgInfoReq)localObject3).uint32_src_term.set(3);
    ((HotPicMsg.GetImgInfoReq)localObject3).uint32_start_pic_index.set(i);
    ((HotPicMsg.GetImgInfoReq)localObject3).uint32_end_pic_index.set(j + 16 - 1);
    ((HotPicMsg.GetImgInfoReq)localObject3).uint32_build_ver.set(k);
    if (((EmotionSearchManager.EmotionSearchTask)localObject1).taskType == 1)
    {
      ((HotPicMsg.GetImgInfoReq)localObject3).uint32_search_req.set(1);
      ((HotPicMsg.GetImgInfoReq)localObject3).str_search_word.set(((EmotionSearchManager.EmotionSearchTask)localObject1).searchKeyWords);
      ((HotPicMsg.GetImgInfoReq)localObject3).bytes_client_ver.set(ByteStringMicro.copyFromUtf8("8.5.5"));
      ((HotPicMsg.GetImgInfoReq)localObject3).uint32_need_update.set(0);
      String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + SystemClock.uptimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("EmotionSearchManager", 2, "sessionId:" + str);
      }
      ((HotPicMsg.GetImgInfoReq)localObject3).bytes_session_id.set(ByteStringMicro.copyFromUtf8(str));
      ((HotPicMsg.ReqBody)localObject2).msg_get_imginfo_req.set((MessageMicro)localObject3);
      localObject2 = ((HotPicMsg.ReqBody)localObject2).toByteArray();
      localObject3 = ByteBuffer.allocate(localObject2.length + 4);
      ((ByteBuffer)localObject3).putInt(localObject2.length + 4).put((byte[])localObject2);
      localObject3 = ((ByteBuffer)localObject3).array();
      localObject2 = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), HotPicServlet.class);
      ((NewIntent)localObject2).putExtra("key_body", (byte[])localObject3);
      ((NewIntent)localObject2).putExtra("key_cmd", "ImagePopular.GetInfo");
      ((NewIntent)localObject2).putExtra("isFrom_EmoSearch", true);
      ((NewIntent)localObject2).putExtra("EmoSearch_reqType", ((EmotionSearchManager.EmotionSearchTask)localObject1).taskType);
      if (((EmotionSearchManager.EmotionSearchTask)localObject1).searchKeyWords != null) {
        break label423;
      }
    }
    label423:
    for (localObject1 = "";; localObject1 = ((EmotionSearchManager.EmotionSearchTask)localObject1).searchKeyWords)
    {
      ((NewIntent)localObject2).putExtra("EmoSearch_reqKeywords", (String)localObject1);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet((NewIntent)localObject2);
      return;
      ((HotPicMsg.GetImgInfoReq)localObject3).uint32_pic_tag.set(2);
      break;
    }
  }
  
  public EmotionSearchManager.IEmotionSearchCallBack a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqEmosmEmosearchEmotionSearchManager$IEmotionSearchCallBack;
  }
  
  public void a()
  {
    if (this.b != null)
    {
      a(new EmotionSearchManager.EmotionSearchResult(-103));
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqEmosmEmosearchEmotionSearchManager$EmotionSearchTask == null)
    {
      a(new EmotionSearchManager.EmotionSearchResult(-102));
      return;
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqEmosmEmosearchEmotionSearchManager$EmotionSearchTask.hasMore)
    {
      a(new EmotionSearchManager.EmotionSearchResult(-104));
      return;
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.b = this.jdField_a_of_type_ComTencentMobileqqEmosmEmosearchEmotionSearchManager$EmotionSearchTask;
      this.b.startIndex = this.jdField_a_of_type_JavaUtilList.size();
      c();
      return;
    }
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmotionSearchManager", 2, "reportEmoSearchMonitor result: " + paramInt1);
    }
    HashMap localHashMap = new HashMap();
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    localHashMap.put("keywords", str);
    localHashMap.put("searchType", paramInt2 + "");
    localHashMap.put("result", paramInt1 + "");
    paramString = StatisticCollector.getInstance(BaseApplication.getContext());
    if (paramInt1 == 0) {}
    for (boolean bool = true;; bool = false)
    {
      paramString.collectPerformance(null, "emo_search_monitor", bool, 0L, 0L, localHashMap, null);
      return;
    }
  }
  
  public void a(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    int j = 0;
    EmotionSearchManager.EmotionSearchTask localEmotionSearchTask;
    try
    {
      i = paramIntent.getIntExtra("EmoSearch_reqType", 0);
      paramIntent = paramIntent.getStringExtra("EmoSearch_reqKeywords");
      localEmotionSearchTask = this.b;
      if (localEmotionSearchTask == null) {
        QLog.e("EmotionSearchManager", 2, "handleResonpse currentSearchingTask is null");
      }
      for (;;)
      {
        return;
        if (localEmotionSearchTask.checkIsThisTask(i, paramIntent)) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("EmotionSearchManager", 2, "handleResonpse resp not current task current");
        }
      }
      localArrayList = new ArrayList();
    }
    finally {}
    ArrayList localArrayList;
    int k = -100;
    if (paramFromServiceMsg.getResultCode() == 1000)
    {
      i = paramFromServiceMsg.getWupBuffer().length - 4;
      paramIntent = new byte[i];
      PkgTools.copyData(paramIntent, 0, paramFromServiceMsg.getWupBuffer(), 4, i);
      paramFromServiceMsg.putWupBuffer(paramIntent);
    }
    for (;;)
    {
      try
      {
        paramIntent = paramFromServiceMsg.getWupBuffer();
        paramFromServiceMsg = new HotPicMsg.RspBody();
        paramFromServiceMsg.mergeFrom(paramIntent);
        paramFromServiceMsg = (HotPicMsg.GetImgInfoRsp)paramFromServiceMsg.msg_get_imginfo_rsp.get();
        if ((paramFromServiceMsg != null) && ((paramFromServiceMsg.int32_result.get() == 0) || (paramFromServiceMsg.int32_result.get() == -5)))
        {
          k = paramFromServiceMsg.uint32_build_ver.get();
          paramIntent = new ArrayList();
          paramFromServiceMsg = paramFromServiceMsg.rpt_msg_img_info.get();
          if ((paramFromServiceMsg != null) && (paramFromServiceMsg.size() > 0))
          {
            i = 0;
            if (i < paramFromServiceMsg.size())
            {
              Object localObject = (HotPicMsg.ImgInfo)paramFromServiceMsg.get(i);
              EmotionSearchItem localEmotionSearchItem = new EmotionSearchItem();
              localEmotionSearchItem.version = k;
              localEmotionSearchItem.picIndex = ((HotPicMsg.ImgInfo)localObject).uint32_pic_index.get();
              localEmotionSearchItem.fileType = ((HotPicMsg.ImgInfo)localObject).uint32_file_type.get();
              localEmotionSearchItem.sourceType = ((HotPicMsg.ImgInfo)localObject).uint32_source_type.get();
              localEmotionSearchItem.height = ((HotPicMsg.ImgInfo)localObject).uint32_thumb_file_height.get();
              localEmotionSearchItem.width = ((HotPicMsg.ImgInfo)localObject).uint32_thumb_file_width.get();
              localEmotionSearchItem.url = ((HotPicMsg.ImgInfo)localObject).bytes_thumb_down_url.get().toStringUtf8();
              localEmotionSearchItem.md5 = ((HotPicMsg.ImgInfo)localObject).bytes_thumb_file_md5.get().toStringUtf8().toUpperCase();
              localEmotionSearchItem.fileSize = ((HotPicMsg.ImgInfo)localObject).uint64_thumb_file_size.get();
              localEmotionSearchItem.originalMD5 = ((HotPicMsg.ImgInfo)localObject).bytes_file_md5.get().toStringUtf8().toUpperCase();
              localEmotionSearchItem.originalUrl = ((HotPicMsg.ImgInfo)localObject).bytes_pic_down_url.get().toStringUtf8();
              localEmotionSearchItem.originalHeight = ((HotPicMsg.ImgInfo)localObject).uint32_file_height.get();
              localEmotionSearchItem.originalWidth = ((HotPicMsg.ImgInfo)localObject).uint32_file_width.get();
              localEmotionSearchItem.oringinalSize = ((HotPicMsg.ImgInfo)localObject).uint64_file_size.get();
              if (localEmotionSearchItem.sourceType == 3)
              {
                localObject = ((HotPicMsg.ImgInfo)localObject).msg_third_party_info;
                localEmotionSearchItem.iconUrl = ((HotPicMsg.ThirdPartyInfo)localObject).bytes_icon_url.get().toStringUtf8();
                localEmotionSearchItem.name = ((HotPicMsg.ThirdPartyInfo)localObject).bytes_name.get().toStringUtf8();
                localEmotionSearchItem.jumpUrl = ((HotPicMsg.ThirdPartyInfo)localObject).bytes_jump_url.get().toStringUtf8();
                localEmotionSearchItem.appid = ((HotPicMsg.ThirdPartyInfo)localObject).bytes_appid.get().toStringUtf8();
              }
              paramIntent.add(localEmotionSearchItem);
              i += 1;
              continue;
            }
          }
          localArrayList.addAll(paramIntent);
          i = j;
        }
      }
      catch (InvalidProtocolBufferMicroException paramIntent)
      {
        i = -100;
      }
      try
      {
        if (QLog.isColorLevel())
        {
          i = j;
          QLog.d("EmotionSearchManager", 2, "handleResonpse,REQ_GET_PIC success,size:" + localArrayList.size());
        }
        i = 0;
      }
      catch (InvalidProtocolBufferMicroException paramIntent)
      {
        break label674;
        i = -100;
        continue;
      }
      a(localEmotionSearchTask, localArrayList, i);
      break;
      if (paramFromServiceMsg == null) {
        break label729;
      }
      j = paramFromServiceMsg.int32_result.get();
      i = j;
      if (QLog.isColorLevel())
      {
        i = j;
        QLog.d("EmotionSearchManager", 2, "handleResonpse,REQ_GET_PIC error,result:" + paramFromServiceMsg.int32_result.get());
      }
      i = j;
      continue;
      label674:
      paramIntent.printStackTrace();
      continue;
      i = k;
      if (QLog.isColorLevel())
      {
        QLog.d("EmotionSearchManager", 2, "handleResonpse,msg.getResultCode() error:" + paramFromServiceMsg.getResultCode());
        i = k;
      }
    }
  }
  
  public void a(EmotionSearchManager.EmotionSearchTask arg1)
  {
    if (??? == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      if ("pushEmotionSearchTask start task = " + ???.taskType + "|" + ???.searchKeyWords != null) {
        break label106;
      }
    }
    label106:
    for (??? = "";; ??? = ???.searchKeyWords)
    {
      QLog.d("EmotionSearchManager", 2, (String)???);
      if (!???.isSame(this.b)) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("EmotionSearchManager", 2, "pushEmotionSearchTask isSame task");
      }
      ??? = new EmotionSearchManager.EmotionSearchResult(-101);
      ((EmotionSearchManager.EmotionSearchResult)???).searchTask = ???;
      a((EmotionSearchManager.EmotionSearchResult)???);
      return;
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.b = ???;
      this.jdField_a_of_type_JavaUtilList.clear();
      if (???.taskType != 0) {
        break label228;
      }
      if (this.jdField_a_of_type_MqqUtilWeakReference == null) {
        break label223;
      }
      ??? = (EmotionSearchManager.EmotionSearchResult)this.jdField_a_of_type_MqqUtilWeakReference.get();
      if (??? == null) {
        break label223;
      }
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaUtilList.addAll(((EmotionSearchManager.EmotionSearchResult)???).itemList);
      this.jdField_a_of_type_ComTencentMobileqqEmosmEmosearchEmotionSearchManager$EmotionSearchTask = this.b;
      this.b = null;
      a(true);
      a((EmotionSearchManager.EmotionSearchResult)???);
      return;
      ??? = finally;
      throw ???;
    }
    label223:
    a(false);
    label228:
    c();
  }
  
  public void a(EmotionSearchManager.IEmotionSearchCallBack paramIEmotionSearchCallBack)
  {
    this.jdField_a_of_type_ComTencentMobileqqEmosmEmosearchEmotionSearchManager$IEmotionSearchCallBack = paramIEmotionSearchCallBack;
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmotionSearchManager", 2, "reportEmoSearchCatchUseMonitor isUse: " + paramBoolean);
    }
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "emo_search_catch_use_monitor", paramBoolean, 0L, 0L, null, null);
  }
  
  public void b()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_ComTencentMobileqqEmosmEmosearchEmotionSearchManager$EmotionSearchTask = null;
      this.b = null;
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_ComTencentMobileqqEmosmEmosearchEmotionSearchManager$IEmotionSearchCallBack = null;
      return;
    }
  }
  
  public void onDestroy()
  {
    b();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.emosearch.EmotionSearchManager
 * JD-Core Version:    0.7.0.1
 */