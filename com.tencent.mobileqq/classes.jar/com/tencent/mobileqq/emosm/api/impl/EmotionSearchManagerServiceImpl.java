package com.tencent.mobileqq.emosm.api.impl;

import android.content.Intent;
import android.os.SystemClock;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.emosm.api.IEmotionSearchManagerService;
import com.tencent.mobileqq.emosm.api.IEmotionSearchManagerService.EmotionSearchResult;
import com.tencent.mobileqq.emosm.api.IEmotionSearchManagerService.EmotionSearchTask;
import com.tencent.mobileqq.emosm.api.IEmotionSearchManagerService.IEmotionSearchCallBack;
import com.tencent.mobileqq.emosm.emosearch.EmotionSearchItem;
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
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import mqq.util.WeakReference;

public class EmotionSearchManagerServiceImpl
  implements IEmotionSearchManagerService
{
  public static final String TAG = "EmotionSearchManager";
  volatile IEmotionSearchManagerService.EmotionSearchTask currentSearchingTask;
  List<EmotionSearchItem> emotionSearchItems = new ArrayList();
  WeakReference<IEmotionSearchManagerService.EmotionSearchResult> hotPicResultWR;
  volatile IEmotionSearchManagerService.EmotionSearchTask lastSearchTask;
  BaseQQAppInterface mApp;
  IEmotionSearchManagerService.IEmotionSearchCallBack searchCallBack;
  private Object statusLock = new Object();
  
  private void handleResponsData(IEmotionSearchManagerService.EmotionSearchTask paramEmotionSearchTask, List<EmotionSearchItem> arg2, int paramInt)
  {
    if (!paramEmotionSearchTask.isSame(this.currentSearchingTask))
    {
      if (QLog.isColorLevel())
      {
        ??? = new StringBuilder();
        ???.append("handleResponsData requestTask not current error, requestTask = ");
        ???.append(paramEmotionSearchTask.taskType);
        ???.append("|");
        ???.append(paramEmotionSearchTask.searchKeyWords);
        QLog.e("EmotionSearchManager", 2, ???.toString());
      }
      return;
    }
    IEmotionSearchManagerService.EmotionSearchResult localEmotionSearchResult = new IEmotionSearchManagerService.EmotionSearchResult(paramInt);
    paramEmotionSearchTask.hasMore = false;
    if ((paramInt == 0) && (???.size() > 0) && (this.emotionSearchItems.size() == ((EmotionSearchItem)???.get(0)).picIndex))
    {
      this.emotionSearchItems.addAll(???);
      paramEmotionSearchTask.hasMore = true;
    }
    localEmotionSearchResult.searchTask = paramEmotionSearchTask;
    localEmotionSearchResult.itemList = new ArrayList();
    localEmotionSearchResult.itemList.addAll(this.emotionSearchItems);
    synchronized (this.statusLock)
    {
      this.lastSearchTask = this.currentSearchingTask;
      this.currentSearchingTask = null;
      if ((paramEmotionSearchTask.taskType == 0) && (paramInt == 0)) {
        this.hotPicResultWR = new WeakReference(localEmotionSearchResult);
      }
      notifySearchCallBack(localEmotionSearchResult);
      return;
    }
  }
  
  private void notifySearchCallBack(IEmotionSearchManagerService.EmotionSearchResult paramEmotionSearchResult)
  {
    if (paramEmotionSearchResult == null) {
      return;
    }
    int i;
    if (paramEmotionSearchResult.searchTask == null) {
      i = 0;
    } else {
      i = paramEmotionSearchResult.searchTask.taskType;
    }
    if (paramEmotionSearchResult.searchTask == null) {
      localObject = "";
    } else {
      localObject = paramEmotionSearchResult.searchTask.searchKeyWords;
    }
    reportEmoSearchMonitor(paramEmotionSearchResult.nResult, i, (String)localObject);
    Object localObject = this.searchCallBack;
    if (localObject != null) {
      ((IEmotionSearchManagerService.IEmotionSearchCallBack)localObject).onSearchCallBack(paramEmotionSearchResult);
    }
  }
  
  private void requestData()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmotionSearchManager", 2, "requestData start");
    }
    Object localObject1 = this.currentSearchingTask;
    if (localObject1 == null)
    {
      QLog.e("EmotionSearchManager", 2, "requestData currentSearchingTask is null");
      return;
    }
    int i = ((IEmotionSearchManagerService.EmotionSearchTask)localObject1).startIndex;
    int j = ((IEmotionSearchManagerService.EmotionSearchTask)localObject1).startIndex;
    int k = ((IEmotionSearchManagerService.EmotionSearchTask)localObject1).buildver;
    Object localObject2 = new HotPicMsg.ReqBody();
    Object localObject3 = new HotPicMsg.GetImgInfoReq();
    ((HotPicMsg.ReqBody)localObject2).setHasFlag(true);
    ((HotPicMsg.GetImgInfoReq)localObject3).uint64_src_uin.set(Long.parseLong(this.mApp.getCurrentAccountUin()));
    ((HotPicMsg.GetImgInfoReq)localObject3).uint32_src_term.set(3);
    ((HotPicMsg.GetImgInfoReq)localObject3).uint32_start_pic_index.set(i);
    ((HotPicMsg.GetImgInfoReq)localObject3).uint32_end_pic_index.set(j + 16 - 1);
    ((HotPicMsg.GetImgInfoReq)localObject3).uint32_build_ver.set(k);
    if (((IEmotionSearchManagerService.EmotionSearchTask)localObject1).taskType == 1)
    {
      ((HotPicMsg.GetImgInfoReq)localObject3).uint32_search_req.set(1);
      ((HotPicMsg.GetImgInfoReq)localObject3).str_search_word.set(((IEmotionSearchManagerService.EmotionSearchTask)localObject1).searchKeyWords);
    }
    else
    {
      ((HotPicMsg.GetImgInfoReq)localObject3).uint32_pic_tag.set(2);
    }
    ((HotPicMsg.GetImgInfoReq)localObject3).bytes_client_ver.set(ByteStringMicro.copyFromUtf8("8.7.0"));
    ((HotPicMsg.GetImgInfoReq)localObject3).uint32_need_update.set(0);
    Object localObject4 = new StringBuilder();
    ((StringBuilder)localObject4).append(this.mApp.getCurrentAccountUin());
    ((StringBuilder)localObject4).append(SystemClock.uptimeMillis());
    localObject4 = ((StringBuilder)localObject4).toString();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("sessionId:");
      localStringBuilder.append((String)localObject4);
      QLog.d("EmotionSearchManager", 2, localStringBuilder.toString());
    }
    ((HotPicMsg.GetImgInfoReq)localObject3).bytes_session_id.set(ByteStringMicro.copyFromUtf8((String)localObject4));
    ((HotPicMsg.ReqBody)localObject2).msg_get_imginfo_req.set((MessageMicro)localObject3);
    localObject2 = ((HotPicMsg.ReqBody)localObject2).toByteArray();
    localObject3 = ByteBuffer.allocate(localObject2.length + 4);
    ((ByteBuffer)localObject3).putInt(localObject2.length + 4).put((byte[])localObject2);
    localObject3 = ((ByteBuffer)localObject3).array();
    localObject2 = new NewIntent(this.mApp.getApp(), HotPicServlet.class);
    ((NewIntent)localObject2).putExtra("key_body", (byte[])localObject3);
    ((NewIntent)localObject2).putExtra("key_cmd", "ImagePopular.GetInfo");
    ((NewIntent)localObject2).putExtra("isFrom_EmoSearch", true);
    ((NewIntent)localObject2).putExtra("EmoSearch_reqType", ((IEmotionSearchManagerService.EmotionSearchTask)localObject1).taskType);
    if (((IEmotionSearchManagerService.EmotionSearchTask)localObject1).searchKeyWords == null) {
      localObject1 = "";
    } else {
      localObject1 = ((IEmotionSearchManagerService.EmotionSearchTask)localObject1).searchKeyWords;
    }
    ((NewIntent)localObject2).putExtra("EmoSearch_reqKeywords", (String)localObject1);
    this.mApp.startServlet((NewIntent)localObject2);
  }
  
  public IEmotionSearchManagerService.IEmotionSearchCallBack getSearchCallBack()
  {
    return this.searchCallBack;
  }
  
  public void handleResonpse(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    int k = 0;
    try
    {
      int i = paramIntent.getIntExtra("EmoSearch_reqType", 0);
      paramIntent = paramIntent.getStringExtra("EmoSearch_reqKeywords");
      IEmotionSearchManagerService.EmotionSearchTask localEmotionSearchTask = this.currentSearchingTask;
      if (localEmotionSearchTask == null)
      {
        QLog.e("EmotionSearchManager", 2, "handleResonpse currentSearchingTask is null");
        return;
      }
      if (!localEmotionSearchTask.checkIsThisTask(i, paramIntent))
      {
        if (QLog.isColorLevel()) {
          QLog.d("EmotionSearchManager", 2, "handleResonpse resp not current task current");
        }
        return;
      }
      ArrayList localArrayList = new ArrayList();
      int j = -100;
      if (paramFromServiceMsg.getResultCode() == 1000)
      {
        i = paramFromServiceMsg.getWupBuffer().length - 4;
        paramIntent = new byte[i];
        PkgTools.copyData(paramIntent, 0, paramFromServiceMsg.getWupBuffer(), 4, i);
        paramFromServiceMsg.putWupBuffer(paramIntent);
        try
        {
          paramIntent = paramFromServiceMsg.getWupBuffer();
          paramFromServiceMsg = new HotPicMsg.RspBody();
          paramFromServiceMsg.mergeFrom(paramIntent);
          paramFromServiceMsg = (HotPicMsg.GetImgInfoRsp)paramFromServiceMsg.msg_get_imginfo_rsp.get();
          if ((paramFromServiceMsg != null) && ((paramFromServiceMsg.int32_result.get() == 0) || (paramFromServiceMsg.int32_result.get() == -5)))
          {
            int m = paramFromServiceMsg.uint32_build_ver.get();
            paramIntent = new ArrayList();
            paramFromServiceMsg = paramFromServiceMsg.rpt_msg_img_info.get();
            if ((paramFromServiceMsg != null) && (paramFromServiceMsg.size() > 0))
            {
              i = 0;
              while (i < paramFromServiceMsg.size())
              {
                Object localObject = (HotPicMsg.ImgInfo)paramFromServiceMsg.get(i);
                EmotionSearchItem localEmotionSearchItem = new EmotionSearchItem();
                localEmotionSearchItem.version = m;
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
              }
            }
            localArrayList.addAll(paramIntent);
            i = k;
            try
            {
              if (!QLog.isColorLevel()) {
                break label679;
              }
              paramIntent = new StringBuilder();
              paramIntent.append("handleResonpse,REQ_GET_PIC success,size:");
              paramIntent.append(localArrayList.size());
              QLog.d("EmotionSearchManager", 2, paramIntent.toString());
              i = k;
            }
            catch (InvalidProtocolBufferMicroException paramIntent)
            {
              i = 0;
              break label686;
            }
          }
          else if (paramFromServiceMsg != null)
          {
            k = paramFromServiceMsg.int32_result.get();
            i = k;
            try
            {
              if (!QLog.isColorLevel()) {
                break label679;
              }
              paramIntent = new StringBuilder();
              paramIntent.append("handleResonpse,REQ_GET_PIC error,result:");
              paramIntent.append(paramFromServiceMsg.int32_result.get());
              QLog.d("EmotionSearchManager", 2, paramIntent.toString());
              i = k;
            }
            catch (InvalidProtocolBufferMicroException paramIntent)
            {
              i = k;
              break label686;
            }
          }
          else
          {
            i = -100;
          }
        }
        catch (InvalidProtocolBufferMicroException paramIntent)
        {
          label679:
          i = j;
          label686:
          paramIntent.printStackTrace();
        }
      }
      else
      {
        i = j;
        if (QLog.isColorLevel())
        {
          paramIntent = new StringBuilder();
          paramIntent.append("handleResonpse,msg.getResultCode() error:");
          paramIntent.append(paramFromServiceMsg.getResultCode());
          QLog.d("EmotionSearchManager", 2, paramIntent.toString());
          i = j;
        }
      }
      handleResponsData(localEmotionSearchTask, localArrayList, i);
      return;
    }
    finally {}
    for (;;)
    {
      throw paramIntent;
    }
  }
  
  public void loadMore()
  {
    if (this.currentSearchingTask != null)
    {
      notifySearchCallBack(new IEmotionSearchManagerService.EmotionSearchResult(-103));
      return;
    }
    if (this.lastSearchTask == null)
    {
      notifySearchCallBack(new IEmotionSearchManagerService.EmotionSearchResult(-102));
      return;
    }
    if (!this.lastSearchTask.hasMore)
    {
      notifySearchCallBack(new IEmotionSearchManagerService.EmotionSearchResult(-104));
      return;
    }
    synchronized (this.statusLock)
    {
      this.currentSearchingTask = this.lastSearchTask;
      this.currentSearchingTask.startIndex = this.emotionSearchItems.size();
      requestData();
      return;
    }
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    this.mApp = ((BaseQQAppInterface)paramAppRuntime);
  }
  
  public void onDestroy()
  {
    resetData();
    this.mApp = null;
  }
  
  public void pushEmotionSearchTask(IEmotionSearchManagerService.EmotionSearchTask arg1)
  {
    if (??? == null) {
      return;
    }
    if (QLog.isColorLevel())
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("pushEmotionSearchTask start task = ");
      ((StringBuilder)???).append(???.taskType);
      ((StringBuilder)???).append("|");
      ((StringBuilder)???).append(???.searchKeyWords);
      if (((StringBuilder)???).toString() == null) {
        ??? = "";
      } else {
        ??? = ???.searchKeyWords;
      }
      QLog.d("EmotionSearchManager", 2, (String)???);
    }
    if (???.isSame(this.currentSearchingTask))
    {
      if (QLog.isColorLevel()) {
        QLog.d("EmotionSearchManager", 2, "pushEmotionSearchTask isSame task");
      }
      ??? = new IEmotionSearchManagerService.EmotionSearchResult(-101);
      ((IEmotionSearchManagerService.EmotionSearchResult)???).searchTask = ???;
      notifySearchCallBack((IEmotionSearchManagerService.EmotionSearchResult)???);
      return;
    }
    synchronized (this.statusLock)
    {
      this.currentSearchingTask = ???;
      this.emotionSearchItems.clear();
      if (???.taskType == 0)
      {
        ??? = this.hotPicResultWR;
        if (??? != null)
        {
          ??? = (IEmotionSearchManagerService.EmotionSearchResult)???.get();
          if (??? != null) {
            synchronized (this.statusLock)
            {
              this.emotionSearchItems.addAll(((IEmotionSearchManagerService.EmotionSearchResult)???).itemList);
              this.lastSearchTask = this.currentSearchingTask;
              this.currentSearchingTask = null;
              reportEmoSearchCatchUseMonitor(true);
              notifySearchCallBack((IEmotionSearchManagerService.EmotionSearchResult)???);
              return;
            }
          }
        }
        reportEmoSearchCatchUseMonitor(false);
      }
      requestData();
      return;
    }
  }
  
  public void reportEmoSearchCatchUseMonitor(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("reportEmoSearchCatchUseMonitor isUse: ");
      localStringBuilder.append(paramBoolean);
      QLog.d("EmotionSearchManager", 2, localStringBuilder.toString());
    }
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "emo_search_catch_use_monitor", paramBoolean, 0L, 0L, null, null);
  }
  
  public void reportEmoSearchMonitor(int paramInt1, int paramInt2, String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("reportEmoSearchMonitor result: ");
      ((StringBuilder)localObject).append(paramInt1);
      QLog.d("EmotionSearchManager", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new HashMap();
    if (paramString == null) {
      paramString = "";
    }
    ((HashMap)localObject).put("keywords", paramString);
    paramString = new StringBuilder();
    paramString.append(paramInt2);
    paramString.append("");
    ((HashMap)localObject).put("searchType", paramString.toString());
    paramString = new StringBuilder();
    paramString.append(paramInt1);
    paramString.append("");
    ((HashMap)localObject).put("result", paramString.toString());
    paramString = StatisticCollector.getInstance(BaseApplication.getContext());
    boolean bool;
    if (paramInt1 == 0) {
      bool = true;
    } else {
      bool = false;
    }
    paramString.collectPerformance(null, "emo_search_monitor", bool, 0L, 0L, (HashMap)localObject, null);
  }
  
  public void resetData()
  {
    synchronized (this.statusLock)
    {
      this.lastSearchTask = null;
      this.currentSearchingTask = null;
      this.emotionSearchItems.clear();
      this.searchCallBack = null;
      return;
    }
  }
  
  public void setSearchCallBack(IEmotionSearchManagerService.IEmotionSearchCallBack paramIEmotionSearchCallBack)
  {
    this.searchCallBack = paramIEmotionSearchCallBack;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.api.impl.EmotionSearchManagerServiceImpl
 * JD-Core Version:    0.7.0.1
 */