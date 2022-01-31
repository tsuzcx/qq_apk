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
import java.util.List;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.InnerMsg;

public class omj
{
  private static SparseArray<omk> a = new SparseArray();
  private static SparseArray<String> b = new SparseArray();
  
  private static void a(int paramInt)
  {
    QLog.i("ReadInJoyChannelGuidingManager", 1, "[clearInsertedArticleInfo], channelID = " + paramInt);
    a.remove(paramInt);
  }
  
  public static void a(BaseArticleInfo paramBaseArticleInfo, ReadInJoyXListView paramReadInJoyXListView, qoe paramqoe)
  {
    if ((paramBaseArticleInfo == null) || (paramReadInJoyXListView == null) || (paramqoe == null))
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
    obz.b().post(new ReadInJoyChannelGuidingManager.1(paramReadInJoyXListView, paramqoe));
  }
  
  public static void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    Object localObject2;
    do
    {
      return;
      localObject2 = Uri.parse(paramString);
      paramString = ((Uri)localObject2).getQueryParameter("channelid");
      localObject1 = ((Uri)localObject2).getQueryParameter("algorithmid");
      localObject2 = ((Uri)localObject2).getQueryParameter("rowkey");
      QLog.i("ReadInJoyChannelGuidingManager", 1, "[parseJumpToChannelScheme], channelid = " + paramString + ", algorithmID = " + (String)localObject1 + ", rowKey = " + (String)localObject2);
    } while ((TextUtils.isEmpty(paramString)) || (TextUtils.isEmpty((CharSequence)localObject1)) || (TextUtils.isEmpty((CharSequence)localObject2)));
    Object localObject1 = new omk((String)localObject1, (String)localObject2);
    try
    {
      int i = Integer.valueOf(paramString).intValue();
      a.put(i, localObject1);
      b.put(i, localObject2);
      return;
    }
    catch (NumberFormatException paramString)
    {
      QLog.e("ReadInJoyChannelGuidingManager", 1, "[parseJumpToChannelScheme], e = " + paramString);
    }
  }
  
  public static void a(pdh parampdh, List<oidb_cmd0x68b.InnerMsg> paramList)
  {
    if ((parampdh == null) || (paramList == null)) {
      QLog.i("ReadInJoyChannelGuidingManager", 1, "[addRequestParams], params is null or innerMsgList is null.");
    }
    int i;
    do
    {
      return;
      if (parampdh.a != -1L)
      {
        QLog.i("ReadInJoyChannelGuidingManager", 1, "[addRequestParams], is not pull down refresh, do not insert.");
        return;
      }
      i = parampdh.b;
    } while (!a(i));
    parampdh = (omk)a.get(i);
    oidb_cmd0x68b.InnerMsg localInnerMsg = new oidb_cmd0x68b.InnerMsg();
    localInnerMsg.uint32_jump_src_type.set(12);
    localInnerMsg.bytes_inner_uniq_id.set(ByteStringMicro.copyFromUtf8(String.valueOf(parampdh.b)));
    try
    {
      localInnerMsg.uint64_algorithm_id.set(Long.valueOf(parampdh.a).longValue());
      QLog.i("ReadInJoyChannelGuidingManager", 1, "[addRequestParams], insertArticle = " + parampdh);
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
    omk localomk = (omk)a.get(paramInt);
    if (localomk != null)
    {
      QLog.i("ReadInJoyChannelGuidingManager", 1, "[isNeedToInsertArticle], " + localomk);
      return localomk.a();
    }
    QLog.i("ReadInJoyChannelGuidingManager", 1, "[isNeedToInsertArticle], channelID = " + paramInt + ", insertArticle is null.");
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     omj
 * JD-Core Version:    0.7.0.1
 */