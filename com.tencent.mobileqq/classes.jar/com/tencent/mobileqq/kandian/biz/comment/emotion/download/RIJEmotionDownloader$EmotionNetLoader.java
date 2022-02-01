package com.tencent.mobileqq.kandian.biz.comment.emotion.download;

import android.text.TextUtils;
import com.tencent.biz.ProtoUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import tencent.im.oidb.cmd0xf7a.oidb_cmd0xf7a.EmojiDetail;
import tencent.im.oidb.cmd0xf7a.oidb_cmd0xf7a.EmojiInfo;
import tencent.im.oidb.cmd0xf7a.oidb_cmd0xf7a.ReqBody;
import tencent.im.oidb.cmd0xf7a.oidb_cmd0xf7a.RspBody;

class RIJEmotionDownloader$EmotionNetLoader
{
  private RIJEmotionDownloader$EmotionNetLoader(RIJEmotionDownloader paramRIJEmotionDownloader) {}
  
  private void a(RIJEmotionDownloader.ServerEmotionHolder paramServerEmotionHolder)
  {
    ThreadManager.getFileThreadHandler().post(new RIJEmotionDownloader.EmotionNetLoader.2(this, paramServerEmotionHolder));
  }
  
  private void a(Iterable<oidb_cmd0xf7a.EmojiInfo> paramIterable, Collection<RIJEmotionDownloader.ServerEmotion> paramCollection)
  {
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext())
    {
      Object localObject1 = (oidb_cmd0xf7a.EmojiInfo)paramIterable.next();
      String str1 = ((oidb_cmd0xf7a.EmojiInfo)localObject1).emoji_id.get();
      String str2 = ((oidb_cmd0xf7a.EmojiInfo)localObject1).emoji_name.get();
      localObject1 = ((oidb_cmd0xf7a.EmojiInfo)localObject1).emoji_icon_url.get();
      Object localObject2;
      if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)) && (!TextUtils.isEmpty((CharSequence)localObject1)))
      {
        localObject2 = new RIJEmotionDownloader.ServerEmotion(null);
        ((RIJEmotionDownloader.ServerEmotion)localObject2).id = str1;
        ((RIJEmotionDownloader.ServerEmotion)localObject2).name = str2;
        ((RIJEmotionDownloader.ServerEmotion)localObject2).emotionUrl = ((String)localObject1);
        paramCollection.add(localObject2);
      }
      else
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("fillServerEmotions: invalid data, emojiId=");
        ((StringBuilder)localObject2).append(str1);
        ((StringBuilder)localObject2).append(" emojiName=");
        ((StringBuilder)localObject2).append(str2);
        ((StringBuilder)localObject2).append(" emojiUrl=");
        ((StringBuilder)localObject2).append((String)localObject1);
        QLog.d("RIJEmotionDownloader", 1, ((StringBuilder)localObject2).toString());
      }
    }
  }
  
  private void a(List<oidb_cmd0xf7a.EmojiDetail> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("doOnSuccess: size=");
      ((StringBuilder)localObject).append(paramList.size());
      QLog.d("RIJEmotionDownloader", 1, ((StringBuilder)localObject).toString());
      localObject = new RIJEmotionDownloader.ServerEmotionHolder(null);
      ((RIJEmotionDownloader.ServerEmotionHolder)localObject).updateTime = System.currentTimeMillis();
      ((RIJEmotionDownloader.ServerEmotionHolder)localObject).serverEmotionTabs = new ArrayList(paramList.size());
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        a((oidb_cmd0xf7a.EmojiDetail)paramList.next(), ((RIJEmotionDownloader.ServerEmotionHolder)localObject).serverEmotionTabs);
      }
      this.a.a((RIJEmotionDownloader.ServerEmotionHolder)localObject);
      a((RIJEmotionDownloader.ServerEmotionHolder)localObject);
      paramList = new StringBuilder();
      paramList.append("doOnSuccess: serverEmotionHolder=");
      paramList.append(localObject);
      QLog.d("RIJEmotionDownloader", 4, paramList.toString());
      return;
    }
    QLog.d("RIJEmotionDownloader", 1, "doOnSuccess: no emojiDetails or emojiDetails is empty");
  }
  
  private void a(oidb_cmd0xf7a.EmojiDetail paramEmojiDetail, Collection<RIJEmotionDownloader.ServerEmotionTab> paramCollection)
  {
    String str1 = paramEmojiDetail.tab_id.get();
    String str2 = paramEmojiDetail.tab_name.get();
    String str3 = paramEmojiDetail.tab_icon_url.get();
    int i = paramEmojiDetail.emoji_size.get();
    paramEmojiDetail = paramEmojiDetail.emoji_list.get();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("fillServerTabs: tabId=");
    ((StringBuilder)localObject).append(str1);
    ((StringBuilder)localObject).append(" tabName=");
    ((StringBuilder)localObject).append(str2);
    ((StringBuilder)localObject).append(" tabIconUrl=");
    ((StringBuilder)localObject).append(str3);
    ((StringBuilder)localObject).append(" emojiSize=");
    ((StringBuilder)localObject).append(i);
    ((StringBuilder)localObject).append(" emojiInfos=");
    ((StringBuilder)localObject).append(paramEmojiDetail);
    QLog.d("RIJEmotionDownloader", 1, ((StringBuilder)localObject).toString());
    if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)) && (!TextUtils.isEmpty(str3)) && (paramEmojiDetail != null))
    {
      if (paramEmojiDetail.isEmpty()) {
        return;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("fillServerTabs: emojiInfo size=");
      ((StringBuilder)localObject).append(paramEmojiDetail.size());
      QLog.d("RIJEmotionDownloader", 1, ((StringBuilder)localObject).toString());
      localObject = new ArrayList(paramEmojiDetail.size());
      a(paramEmojiDetail, (Collection)localObject);
      if (!((List)localObject).isEmpty())
      {
        paramEmojiDetail = new RIJEmotionDownloader.ServerEmotionTab(null);
        paramEmojiDetail.id = str1;
        paramEmojiDetail.name = str2;
        paramEmojiDetail.iconUrl = str3;
        paramEmojiDetail.size = i;
        paramEmojiDetail.serverEmotions = ((List)localObject);
        paramCollection.add(paramEmojiDetail);
      }
    }
  }
  
  private void a(byte[] paramArrayOfByte)
  {
    Object localObject = new oidb_cmd0xf7a.RspBody();
    try
    {
      ((oidb_cmd0xf7a.RspBody)localObject).mergeFrom(paramArrayOfByte);
      int i = ((oidb_cmd0xf7a.RspBody)localObject).ret.get();
      paramArrayOfByte = ((oidb_cmd0xf7a.RspBody)localObject).err_message.get();
      if ((i == 0) && (TextUtils.isEmpty(paramArrayOfByte)))
      {
        a(((oidb_cmd0xf7a.RspBody)localObject).emoji_detail_list.get());
        return;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("parseData: fail to parse data. retCode=");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append(" errorMsg=");
      ((StringBuilder)localObject).append(paramArrayOfByte);
      QLog.d("RIJEmotionDownloader", 1, ((StringBuilder)localObject).toString());
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      QLog.w("RIJEmotionDownloader", 1, "parseData: fail to parse data", paramArrayOfByte);
    }
  }
  
  void a()
  {
    QLog.d("RIJEmotionDownloader", 1, "EmotionNetLoader#loadData: start load net data");
    oidb_cmd0xf7a.ReqBody localReqBody = new oidb_cmd0xf7a.ReqBody();
    ProtoUtils.a(RIJQQAppInterfaceUtil.a(), new RIJEmotionDownloader.EmotionNetLoader.1(this), localReqBody.toByteArray(), "OidbSvc.0xf7a", 3962, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.emotion.download.RIJEmotionDownloader.EmotionNetLoader
 * JD-Core Version:    0.7.0.1
 */