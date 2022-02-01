package com.tencent.mobileqq.kandian.glue.router;

import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.mobileqq.kandian.base.utils.RIJThreadHandler;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyXListView;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.repo.common.RIJShowKanDianTabSp;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ReadInJoyRequestParams.Request0x68bParams;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.InnerMsg;

public class ReadInJoyChannelGuidingManager
{
  private static SparseArray<ReadInJoyChannelGuidingManager.InsertedArticleInfo> a = new SparseArray();
  private static SparseArray<String> b = new SparseArray();
  private static SparseArray<RIJDailyJumpParser.RIJDailyScheme> c = new SparseArray();
  
  public static void a(int paramInt, RIJDailyJumpParser.RIJDailyScheme paramRIJDailyScheme)
  {
    if (paramRIJDailyScheme != null) {
      c.put(paramInt, paramRIJDailyScheme);
    }
  }
  
  public static void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, ReadInJoyXListView paramReadInJoyXListView, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter)
  {
    if ((paramAbsBaseArticleInfo != null) && (paramReadInJoyXListView != null) && (paramReadInJoyBaseAdapter != null))
    {
      int i = (int)paramAbsBaseArticleInfo.mChannelID;
      String str = (String)b.get(i);
      b.remove(i);
      if (!TextUtils.equals(paramAbsBaseArticleInfo.innerUniqueID, str))
      {
        paramReadInJoyXListView = new StringBuilder();
        paramReadInJoyXListView.append("[openFirstInsertedArticle], rowKey not equal, do not open; channelID = ");
        paramReadInJoyXListView.append(i);
        paramReadInJoyXListView.append(", lastRowKey = ");
        paramReadInJoyXListView.append(str);
        paramReadInJoyXListView.append(", innerUniqueID = ");
        paramReadInJoyXListView.append(paramAbsBaseArticleInfo.innerUniqueID);
        QLog.i("ReadInJoyChannelGuidingManager", 1, paramReadInJoyXListView.toString());
        return;
      }
      QLog.i("ReadInJoyChannelGuidingManager", 1, "[openFirstInsertedArticle], click first article.");
      RIJThreadHandler.b().post(new ReadInJoyChannelGuidingManager.1(paramReadInJoyXListView, paramReadInJoyBaseAdapter));
      return;
    }
    QLog.e("ReadInJoyChannelGuidingManager", 1, "[openFirstInsertedArticle], articleInfo is null or listView is null, or adapter is null.");
  }
  
  public static void a(ReadInJoyRequestParams.Request0x68bParams paramRequest0x68bParams, List<oidb_cmd0x68b.InnerMsg> paramList)
  {
    if ((paramRequest0x68bParams != null) && (paramList != null))
    {
      if (paramRequest0x68bParams.c != -1L)
      {
        QLog.i("ReadInJoyChannelGuidingManager", 1, "[addRequestParams], is not pull down refresh, do not insert.");
        return;
      }
      int i = paramRequest0x68bParams.b;
      paramRequest0x68bParams = (RIJDailyJumpParser.RIJDailyScheme)c.get(i);
      if ((paramRequest0x68bParams != null) && (TextUtils.equals("0", paramRequest0x68bParams.g())))
      {
        paramRequest0x68bParams = new StringBuilder();
        paramRequest0x68bParams.append("[addRequestParams] channelId = ");
        paramRequest0x68bParams.append(i);
        paramRequest0x68bParams.append(", insert_card = 0");
        QLog.i("ReadInJoyChannelGuidingManager", 1, paramRequest0x68bParams.toString());
        b(i);
        return;
      }
      if (a(i))
      {
        paramRequest0x68bParams = (ReadInJoyChannelGuidingManager.InsertedArticleInfo)a.get(i);
        oidb_cmd0x68b.InnerMsg localInnerMsg = new oidb_cmd0x68b.InnerMsg();
        localInnerMsg.uint32_jump_src_type.set(12);
        localInnerMsg.bytes_inner_uniq_id.set(ByteStringMicro.copyFromUtf8(String.valueOf(paramRequest0x68bParams.b)));
        if (i == 0) {
          localInnerMsg.uint32_jump_src_type.set(13);
        }
        try
        {
          localInnerMsg.uint64_algorithm_id.set(Long.valueOf(paramRequest0x68bParams.a).longValue());
        }
        catch (NumberFormatException localNumberFormatException)
        {
          StringBuilder localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append("[addRequestParams], e = ");
          localStringBuilder2.append(localNumberFormatException);
          QLog.e("ReadInJoyChannelGuidingManager", 1, localStringBuilder2.toString());
        }
        StringBuilder localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("[addRequestParams], insertArticle = ");
        localStringBuilder1.append(paramRequest0x68bParams);
        QLog.i("ReadInJoyChannelGuidingManager", 1, localStringBuilder1.toString());
        paramList.add(0, localInnerMsg);
        b(i);
      }
      return;
    }
    QLog.i("ReadInJoyChannelGuidingManager", 1, "[addRequestParams], params is null or innerMsgList is null.");
  }
  
  public static void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    Object localObject2 = Uri.parse(paramString);
    paramString = ((Uri)localObject2).getQueryParameter("channelid");
    Object localObject1 = ((Uri)localObject2).getQueryParameter("algorithmid");
    localObject2 = ((Uri)localObject2).getQueryParameter("rowkey");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[parseJumpToChannelScheme], channelid = ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(", algorithmID = ");
    localStringBuilder.append((String)localObject1);
    localStringBuilder.append(", rowKey = ");
    localStringBuilder.append((String)localObject2);
    QLog.i("ReadInJoyChannelGuidingManager", 1, localStringBuilder.toString());
    if ((!TextUtils.isEmpty(paramString)) && (!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty((CharSequence)localObject2)))
    {
      localObject1 = new ReadInJoyChannelGuidingManager.InsertedArticleInfo((String)localObject1, (String)localObject2);
      try
      {
        int i = Integer.valueOf(paramString).intValue();
        a.put(i, localObject1);
        b.put(i, localObject2);
        try
        {
          b.remove(i);
          QLog.i("ReadInJoyChannelGuidingManager", 1, "[parseJumpToChannelScheme], remove last rowKey.");
          if ((i == 0) && (!RIJShowKanDianTabSp.c()))
          {
            a.remove(i);
            b.remove(i);
            QLog.i("ReadInJoyChannelGuidingManager", 1, "[parseJumpToChannelScheme], remove insertInfo and last rowKey.");
            return;
          }
        }
        catch (Exception paramString)
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("[parseJumpToChannelScheme], e = ");
          ((StringBuilder)localObject1).append(paramString);
          QLog.e("ReadInJoyChannelGuidingManager", 1, ((StringBuilder)localObject1).toString());
          return;
        }
        return;
      }
      catch (NumberFormatException paramString)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("[parseJumpToChannelScheme], e = ");
        ((StringBuilder)localObject1).append(paramString);
        QLog.e("ReadInJoyChannelGuidingManager", 1, ((StringBuilder)localObject1).toString());
      }
    }
  }
  
  public static boolean a(int paramInt)
  {
    Object localObject = (ReadInJoyChannelGuidingManager.InsertedArticleInfo)a.get(paramInt);
    if (localObject != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[isNeedToInsertArticle], ");
      localStringBuilder.append(localObject);
      QLog.i("ReadInJoyChannelGuidingManager", 1, localStringBuilder.toString());
      return ((ReadInJoyChannelGuidingManager.InsertedArticleInfo)localObject).a();
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[isNeedToInsertArticle], channelID = ");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(", insertArticle is null.");
    QLog.i("ReadInJoyChannelGuidingManager", 1, ((StringBuilder)localObject).toString());
    return false;
  }
  
  private static void b(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[clearInsertedArticleInfo], channelID = ");
    localStringBuilder.append(paramInt);
    QLog.i("ReadInJoyChannelGuidingManager", 1, localStringBuilder.toString());
    a.remove(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.router.ReadInJoyChannelGuidingManager
 * JD-Core Version:    0.7.0.1
 */