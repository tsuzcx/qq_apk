import android.content.Context;
import android.os.Handler;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.widget.EditText;
import com.tencent.biz.pubaccount.readinjoy.biu.BiuNicknameSpan;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyDraftboxItem;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyDraftboxItem.PicData;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyDraftboxItem.ReadInJoyDraftboxContent;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadInJoyUserInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.BiuCommentInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.JumpInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.TopicInfo;
import com.tencent.biz.pubaccount.readinjoy.view.text.TopicSpan;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;

public class pbg
  extends pbh
{
  private String a;
  
  public pbg(AppInterface paramAppInterface, aukn paramaukn, ExecutorService paramExecutorService, pou parampou, Handler paramHandler)
  {
    super(paramAppInterface, paramaukn, paramExecutorService, parampou, paramHandler);
    this.jdField_a_of_type_JavaLangString = "ReadInJoyDraftboxModule";
  }
  
  private List<ReadInJoyDraftboxItem> a()
  {
    List localList = this.jdField_a_of_type_Aukn.a(ReadInJoyDraftboxItem.class);
    if ((localList != null) && (localList.size() > 0))
    {
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext())
      {
        ReadInJoyDraftboxItem localReadInJoyDraftboxItem = (ReadInJoyDraftboxItem)localIterator.next();
        localReadInJoyDraftboxItem.firstPicData = ((ReadInJoyDraftboxItem.PicData)bbfe.a(localReadInJoyDraftboxItem.firstPic, ReadInJoyDraftboxItem.PicData.CREATOR));
      }
    }
    return localList;
  }
  
  public long a(long paramLong, ReadInJoyDraftboxItem.ReadInJoyDraftboxContent paramReadInJoyDraftboxContent)
  {
    if (paramReadInJoyDraftboxContent == null) {}
    label169:
    label323:
    label359:
    label369:
    label375:
    do
    {
      return -1L;
      ReadInJoyDraftboxItem localReadInJoyDraftboxItem = new ReadInJoyDraftboxItem();
      localReadInJoyDraftboxItem.type = paramReadInJoyDraftboxContent.articleType;
      localReadInJoyDraftboxItem.setId(paramLong);
      int i;
      if (paramLong == -1L)
      {
        i = 1000;
        localReadInJoyDraftboxItem.setStatus(i);
        String str = paramReadInJoyDraftboxContent.commentString;
        paramLong = System.currentTimeMillis() / 1000L;
        localReadInJoyDraftboxItem.time = paramLong;
        localReadInJoyDraftboxItem.digest = str;
        localReadInJoyDraftboxItem.title = paramReadInJoyDraftboxContent.answerTitle;
        if (TextUtils.isEmpty(localReadInJoyDraftboxItem.title))
        {
          if ((str == null) || (str.length() != 0) || (paramReadInJoyDraftboxContent == null) || (paramReadInJoyDraftboxContent.adapterList == null) || (paramReadInJoyDraftboxContent.adapterList.size() <= 0) || (((ReadInJoyDraftboxItem.PicData)paramReadInJoyDraftboxContent.adapterList.get(0)).a == -1) || (paramReadInJoyDraftboxContent.articleType == 3)) {
            break label359;
          }
          localReadInJoyDraftboxItem.title = ajyc.a(2131712745);
        }
        localReadInJoyDraftboxItem.content = bbfe.a(paramReadInJoyDraftboxContent);
        localReadInJoyDraftboxItem.firstPic = null;
        paramReadInJoyDraftboxContent = paramReadInJoyDraftboxContent.adapterList;
        if ((paramReadInJoyDraftboxContent != null) && (paramReadInJoyDraftboxContent.size() > 0)) {
          localReadInJoyDraftboxItem.firstPic = bbfe.a((ReadInJoyDraftboxItem.PicData)paramReadInJoyDraftboxContent.get(0));
        }
        if (!a(localReadInJoyDraftboxItem)) {
          continue;
        }
        localReadInJoyDraftboxItem = (ReadInJoyDraftboxItem)this.jdField_a_of_type_Aukn.a(ReadInJoyDraftboxItem.class, "time = ?", new String[] { paramLong + "" });
        if (QLog.isColorLevel())
        {
          str = this.jdField_a_of_type_JavaLangString;
          StringBuilder localStringBuilder = new StringBuilder().append("saveDraftBox: ");
          if (localReadInJoyDraftboxItem == null) {
            break label369;
          }
          paramReadInJoyDraftboxContent = "success " + localReadInJoyDraftboxItem;
          QLog.d(str, 2, paramReadInJoyDraftboxContent);
        }
        if (localReadInJoyDraftboxItem == null) {
          break label375;
        }
      }
      for (paramLong = localReadInJoyDraftboxItem.getId();; paramLong = -1L)
      {
        return paramLong;
        i = 1001;
        break;
        localReadInJoyDraftboxItem.title = "";
        break label169;
        paramReadInJoyDraftboxContent = "failed: -1";
        break label323;
      }
    } while (!QLog.isColorLevel());
    QLog.d(this.jdField_a_of_type_JavaLangString, 2, "saveDraftBox: failed: -1");
    return -1L;
  }
  
  public SpannableStringBuilder a(List<SocializeFeedsInfo.BiuCommentInfo> paramList, Context paramContext, EditText paramEditText, int paramInt)
  {
    StringBuilder localStringBuilder;
    ArrayList localArrayList;
    int j;
    int i;
    SocializeFeedsInfo.BiuCommentInfo localBiuCommentInfo;
    if (paramList != null)
    {
      localStringBuilder = new StringBuilder();
      localArrayList = new ArrayList();
      j = localStringBuilder.length();
      int k = paramList.size();
      i = 0;
      if (i <= k - 1)
      {
        localBiuCommentInfo = (SocializeFeedsInfo.BiuCommentInfo)paramList.get(i);
        switch (localBiuCommentInfo.c)
        {
        default: 
          if (i <= 0) {
            break;
          }
        }
      }
    }
    for (;;)
    {
      try
      {
        localObject = ReadInJoyUserInfoModule.a(localBiuCommentInfo.jdField_a_of_type_JavaLangLong.longValue(), null);
        if (localObject == null) {
          continue;
        }
        localObject = ((ReadInJoyUserInfo)localObject).nick;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        Object localObject;
        String str2;
        String str3;
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, localNumberFormatException.getMessage());
        continue;
      }
      localObject = BiuNicknameSpan.a((CharSequence)localObject);
      str2 = "@" + (String)localObject;
      localObject = str2;
      if (localBiuCommentInfo.c == 1) {
        localObject = str2 + " ";
      }
      localStringBuilder.append((String)localObject);
      if (localBiuCommentInfo.jdField_a_of_type_JavaLangString == null)
      {
        str2 = "";
        localStringBuilder.append(str2);
        localArrayList.add(new rrh(j, j + ((String)localObject).length(), new BiuNicknameSpan(localBiuCommentInfo.jdField_a_of_type_JavaLangLong.toString(), localBiuCommentInfo.b.longValue(), (CharSequence)localObject, paramContext, paramEditText.getPaint(), paramInt)));
        j = localStringBuilder.length();
        i += 1;
        break;
        if (localBiuCommentInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$JumpInfo == null) {
          continue;
        }
        str2 = localBiuCommentInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$JumpInfo.a();
        str3 = localBiuCommentInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$JumpInfo.b();
        if (localBiuCommentInfo.jdField_a_of_type_JavaLangString == null)
        {
          localObject = "";
          localStringBuilder.append(str2).append((String)localObject);
          localArrayList.add(new rrh(j, str2.length() + j, new rrf(str3, 13421772)));
          continue;
        }
        localObject = localBiuCommentInfo.jdField_a_of_type_JavaLangString;
        continue;
        if (localBiuCommentInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$JumpInfo == null) {
          continue;
        }
        str2 = localBiuCommentInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$JumpInfo.a();
        localBiuCommentInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$JumpInfo.b();
        if (localBiuCommentInfo.jdField_a_of_type_JavaLangString == null)
        {
          localObject = "";
          localStringBuilder.append(str2).append((String)localObject);
          localObject = TopicInfo.a().a(Long.valueOf(localBiuCommentInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$JumpInfo.a()).longValue()).a(str2).a();
          localArrayList.add(new rrh(j, str2.length() + j, new TopicSpan((TopicInfo)localObject)));
          continue;
        }
        localObject = localBiuCommentInfo.jdField_a_of_type_JavaLangString;
        continue;
        localObject = ReadInJoyUserInfoModule.a();
        break label667;
      }
      str2 = axas.b(localBiuCommentInfo.jdField_a_of_type_JavaLangString);
      continue;
      if (localBiuCommentInfo.jdField_a_of_type_JavaLangString == null) {}
      for (String str1 = "";; str1 = axas.b(localBiuCommentInfo.jdField_a_of_type_JavaLangString))
      {
        localStringBuilder.append(str1);
        break;
      }
      paramList = new SpannableStringBuilder(new ayki(localStringBuilder, 7, 20));
      paramContext = localArrayList.iterator();
      while (paramContext.hasNext())
      {
        paramEditText = (rrh)paramContext.next();
        paramList.setSpan(paramEditText.a(), paramEditText.a(), paramEditText.b(), 33);
      }
      return paramList;
      return null;
      label667:
      if (str1 == null) {
        str1 = "";
      }
    }
  }
  
  public ReadInJoyDraftboxItem.ReadInJoyDraftboxContent a(long paramLong)
  {
    ReadInJoyDraftboxItem localReadInJoyDraftboxItem = a(paramLong);
    ReadInJoyDraftboxItem.ReadInJoyDraftboxContent localReadInJoyDraftboxContent2 = null;
    ReadInJoyDraftboxItem.ReadInJoyDraftboxContent localReadInJoyDraftboxContent1 = localReadInJoyDraftboxContent2;
    if (localReadInJoyDraftboxItem != null)
    {
      localReadInJoyDraftboxContent1 = localReadInJoyDraftboxContent2;
      if (localReadInJoyDraftboxItem.content != null)
      {
        localReadInJoyDraftboxContent1 = localReadInJoyDraftboxContent2;
        if (localReadInJoyDraftboxItem.content.length > 0)
        {
          localReadInJoyDraftboxContent2 = (ReadInJoyDraftboxItem.ReadInJoyDraftboxContent)bbfe.a(localReadInJoyDraftboxItem.content, ReadInJoyDraftboxItem.ReadInJoyDraftboxContent.CREATOR);
          localReadInJoyDraftboxContent1 = localReadInJoyDraftboxContent2;
          if (QLog.isColorLevel())
          {
            QLog.d(this.jdField_a_of_type_JavaLangString, 2, "getReadInJoyContentById: " + paramLong + " " + localReadInJoyDraftboxContent2.toString());
            localReadInJoyDraftboxContent1 = localReadInJoyDraftboxContent2;
          }
        }
      }
    }
    return localReadInJoyDraftboxContent1;
  }
  
  public ReadInJoyDraftboxItem a(long paramLong)
  {
    ReadInJoyDraftboxItem localReadInJoyDraftboxItem = (ReadInJoyDraftboxItem)this.jdField_a_of_type_Aukn.a(ReadInJoyDraftboxItem.class, paramLong);
    String str2;
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      str2 = this.jdField_a_of_type_JavaLangString;
      localStringBuilder = new StringBuilder().append("loadDraftboxFromDbById: ").append(paramLong).append(" ");
      if (localReadInJoyDraftboxItem == null) {
        break label112;
      }
    }
    label112:
    for (String str1 = localReadInJoyDraftboxItem.toString();; str1 = "null")
    {
      QLog.d(str2, 2, str1);
      if ((localReadInJoyDraftboxItem != null) && (localReadInJoyDraftboxItem.firstPic != null)) {
        localReadInJoyDraftboxItem.firstPicData = ((ReadInJoyDraftboxItem.PicData)bbfe.a(localReadInJoyDraftboxItem.firstPic, ReadInJoyDraftboxItem.PicData.CREATOR));
      }
      return localReadInJoyDraftboxItem;
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject) {}
  
  public void a(qfj paramqfj)
  {
    List localList = a();
    if (QLog.isColorLevel())
    {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "loadAllDraftsFromDb:\n");
      if (localList != null)
      {
        Iterator localIterator = localList.iterator();
        while (localIterator.hasNext())
        {
          ReadInJoyDraftboxItem localReadInJoyDraftboxItem = (ReadInJoyDraftboxItem)localIterator.next();
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, new Object[] { localReadInJoyDraftboxItem });
        }
      }
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "loadAllDraftsFromDb: empty\n");
    }
    paramqfj.a(localList);
  }
  
  public boolean a()
  {
    boolean bool = this.jdField_a_of_type_Aukn.a(ReadInJoyDraftboxItem.class);
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "deleteAllDraftsFromDb: " + bool);
    }
    return bool;
  }
  
  public boolean a(long paramLong)
  {
    Object localObject = a(paramLong);
    localObject = Boolean.valueOf(this.jdField_a_of_type_Aukn.b((aukm)localObject));
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "deleteDraftboxFromDb: " + paramLong + " : " + localObject);
    }
    return ((Boolean)localObject).booleanValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pbg
 * JD-Core Version:    0.7.0.1
 */