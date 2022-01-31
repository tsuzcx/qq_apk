import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.biz.pubaccount.readinjoy.guidingchannel.ReadInJoyChannelGuidingManager.1;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyXListView;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.net.URLDecoder;
import java.util.List;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.InnerMsg;

public class oxx
{
  private static SparseArray<oxy> a = new SparseArray();
  private static SparseArray<String> b = new SparseArray();
  
  private static void a(int paramInt)
  {
    QLog.i("ReadInJoyChannelGuidingManager", 1, "[clearInsertedArticleInfo], channelID = " + paramInt);
    a.remove(paramInt);
  }
  
  public static void a(BaseArticleInfo paramBaseArticleInfo, ReadInJoyXListView paramReadInJoyXListView, rap paramrap)
  {
    if ((paramBaseArticleInfo == null) || (paramReadInJoyXListView == null) || (paramrap == null))
    {
      QLog.e("ReadInJoyChannelGuidingManager", 1, "[openFirstInsertedArticle], articleInfo is null or listView is null, or adapter is null.");
      return;
    }
    int i = (int)paramBaseArticleInfo.mChannelID;
    String str = (String)b.get(i);
    b.remove(i);
    if (!TextUtils.equals(paramBaseArticleInfo.innerUniqueID, str))
    {
      QLog.i("ReadInJoyChannelGuidingManager", 1, "[openFirstInsertedArticle], rowKey not equal, do not open; channelID = " + i + ", lastRowKey = " + str + ", innerUniqueID = " + paramBaseArticleInfo.innerUniqueID);
      return;
    }
    QLog.i("ReadInJoyChannelGuidingManager", 1, "[openFirstInsertedArticle], click first article.");
    onk.b().post(new ReadInJoyChannelGuidingManager.1(paramReadInJoyXListView, paramrap));
  }
  
  public static void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return;
      paramString = Uri.parse(paramString);
      String str1 = paramString.getQueryParameter("channelid");
      Object localObject = paramString.getQueryParameter("algorithmid");
      String str2 = paramString.getQueryParameter("rowkey");
      QLog.i("ReadInJoyChannelGuidingManager", 1, "[parseJumpToChannelScheme], channelid = " + str1 + ", algorithmID = " + (String)localObject + ", rowKey = " + str2);
      if ((TextUtils.isEmpty(str1)) || (TextUtils.isEmpty((CharSequence)localObject)) || (TextUtils.isEmpty(str2))) {
        continue;
      }
      localObject = new oxy((String)localObject, str2);
      try
      {
        int i = Integer.valueOf(str1).intValue();
        a.put(i, localObject);
        b.put(i, str2);
        try
        {
          str1 = paramString.getQueryParameter("article_url");
          paramString = paramString.getQueryParameter("show_floating_window");
          str2 = URLDecoder.decode(str1, "utf-8");
          if ((i == 0) && (!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)) && (TextUtils.equals("1", paramString)) && (bhvh.i()))
          {
            b.remove(i);
            QLog.i("ReadInJoyChannelGuidingManager", 1, "[parseJumpToChannelScheme], remove last rowKey.");
          }
          if ((i != 0) || (bhvh.i())) {
            continue;
          }
          a.remove(i);
          b.remove(i);
          QLog.i("ReadInJoyChannelGuidingManager", 1, "[parseJumpToChannelScheme], remove insertInfo and last rowKey.");
          return;
        }
        catch (Exception paramString)
        {
          QLog.e("ReadInJoyChannelGuidingManager", 1, "[parseJumpToChannelScheme], e = " + paramString);
          return;
        }
        return;
      }
      catch (NumberFormatException paramString)
      {
        QLog.e("ReadInJoyChannelGuidingManager", 1, "[parseJumpToChannelScheme], e = " + paramString);
      }
    }
  }
  
  public static void a(poz parampoz, List<oidb_cmd0x68b.InnerMsg> paramList)
  {
    if ((parampoz == null) || (paramList == null)) {
      QLog.i("ReadInJoyChannelGuidingManager", 1, "[addRequestParams], params is null or innerMsgList is null.");
    }
    int i;
    do
    {
      return;
      if (parampoz.a != -1L)
      {
        QLog.i("ReadInJoyChannelGuidingManager", 1, "[addRequestParams], is not pull down refresh, do not insert.");
        return;
      }
      i = parampoz.b;
    } while (!a(i));
    parampoz = (oxy)a.get(i);
    oidb_cmd0x68b.InnerMsg localInnerMsg = new oidb_cmd0x68b.InnerMsg();
    localInnerMsg.uint32_jump_src_type.set(12);
    localInnerMsg.bytes_inner_uniq_id.set(ByteStringMicro.copyFromUtf8(String.valueOf(parampoz.b)));
    if (i == 0) {
      localInnerMsg.uint32_jump_src_type.set(13);
    }
    try
    {
      localInnerMsg.uint64_algorithm_id.set(Long.valueOf(parampoz.a).longValue());
      QLog.i("ReadInJoyChannelGuidingManager", 1, "[addRequestParams], insertArticle = " + parampoz);
      paramList.add(0, localInnerMsg);
      a(i);
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        QLog.e("ReadInJoyChannelGuidingManager", 1, "[addRequestParams], e = " + localNumberFormatException);
      }
    }
  }
  
  public static boolean a(int paramInt)
  {
    oxy localoxy = (oxy)a.get(paramInt);
    if (localoxy != null)
    {
      QLog.i("ReadInJoyChannelGuidingManager", 1, "[isNeedToInsertArticle], " + localoxy);
      return localoxy.a();
    }
    QLog.i("ReadInJoyChannelGuidingManager", 1, "[isNeedToInsertArticle], channelID = " + paramInt + ", insertArticle is null.");
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oxx
 * JD-Core Version:    0.7.0.1
 */