import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.ac.ArticleComment.ArticleLikeRequest;
import com.tencent.mobileqq.ac.ArticleComment.ArticleLikeRespond;
import com.tencent.mobileqq.ac.ArticleComment.CheckArticleLikeRequest;
import com.tencent.mobileqq.ac.ArticleComment.CheckArticleLikeRespond;
import com.tencent.mobileqq.ac.ArticleComment.CreateArticleCommentRequest;
import com.tencent.mobileqq.ac.ArticleComment.CreateArticleCommentRespond;
import com.tencent.mobileqq.ac.ArticleComment.GetArticleCommentCountRequest;
import com.tencent.mobileqq.ac.ArticleComment.GetArticleCommentCountRespond;
import com.tencent.mobileqq.ac.ArticleComment.GetArticleLikeCountRequest;
import com.tencent.mobileqq.ac.ArticleComment.GetArticleLikeCountRespond;
import com.tencent.mobileqq.ac.ArticleComment.GetPhotoCollectionInfoRequest;
import com.tencent.mobileqq.ac.ArticleComment.GetPhotoCollectionInfoResponse;
import com.tencent.mobileqq.ac.ArticleComment.GetRecommendInfoRequest;
import com.tencent.mobileqq.ac.ArticleComment.GetRecommendInfoResponse;
import com.tencent.mobileqq.ac.ArticleComment.LikeRet;
import com.tencent.mobileqq.ac.ArticleComment.PhotoFirstItemInfo;
import com.tencent.mobileqq.ac.ArticleComment.PhotoItemInfo;
import com.tencent.mobileqq.ac.ArticleComment.RecommendInfo;
import com.tencent.mobileqq.ac.ArticleComment.RecommendItemInfo;
import com.tencent.mobileqq.ac.ArticleComment.ReportGalleryInfoRequest;
import com.tencent.mobileqq.ac.ArticleComment.ReportGalleryInfoResponse;
import com.tencent.mobileqq.ac.ArticleComment.RetInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import tencent.im.oidb.cmd0x6a6.oidb_0x6a6.ReqBody;
import tencent.im.oidb.cmd0x6a6.oidb_0x6a6.RspBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class nyq
  extends anii
{
  private final long jdField_a_of_type_Long = 30000L;
  public String a;
  protected Set<String> a;
  nyr jdField_a_of_type_Nyr;
  
  public nyq(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
    this.jdField_a_of_type_JavaLangString = "image_collection_article_id";
  }
  
  public nyq(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_JavaLangString = "image_collection_article_id";
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int j = 0;
    String str = "";
    Bundle localBundle = new Bundle();
    boolean bool;
    ArticleComment.GetArticleLikeCountRequest localGetArticleLikeCountRequest;
    ArticleComment.GetArticleLikeCountRespond localGetArticleLikeCountRespond;
    if (paramFromServiceMsg.isSuccess())
    {
      bool = true;
      localGetArticleLikeCountRequest = new ArticleComment.GetArticleLikeCountRequest();
      localGetArticleLikeCountRespond = new ArticleComment.GetArticleLikeCountRespond();
    }
    for (;;)
    {
      try
      {
        localGetArticleLikeCountRequest.mergeFrom(paramToServiceMsg.getWupBuffer(), 4, paramToServiceMsg.getWupBuffer().length - 4);
        localGetArticleLikeCountRespond.mergeFrom((byte[])paramObject);
        paramToServiceMsg = str;
        i = j;
        if (!localGetArticleLikeCountRespond.ret.has()) {
          break label258;
        }
        if ((!localGetArticleLikeCountRespond.ret.ret_code.has()) || (localGetArticleLikeCountRespond.ret.ret_code.get() != 0))
        {
          bool = false;
          i = 0;
          paramToServiceMsg = "";
          if (this.jdField_a_of_type_Nyr == null) {
            break label261;
          }
          this.jdField_a_of_type_Nyr.a(bool, paramToServiceMsg, i);
          return;
        }
      }
      catch (Exception paramToServiceMsg)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("Q.pubaccount.video.PublicAccountArticleHandler", 2, "handleQueryArticleLikeCount() ERROR e=" + paramToServiceMsg.getMessage());
        return;
      }
      paramFromServiceMsg = str;
      if (localGetArticleLikeCountRequest.article_id.has())
      {
        paramFromServiceMsg = localGetArticleLikeCountRequest.article_id.get().toStringUtf8();
        localBundle.putString("VALUE_ARTICLE_ID", paramFromServiceMsg);
      }
      paramToServiceMsg = paramFromServiceMsg;
      int i = j;
      if (localGetArticleLikeCountRespond.count.has())
      {
        i = localGetArticleLikeCountRespond.count.get();
        localBundle.putInt("VALUE_ARTICLE_LIKE_COUNT", i);
        paramToServiceMsg = paramFromServiceMsg;
      }
      label258:
      continue;
      label261:
      super.notifyUI(2, bool, localBundle);
      return;
      bool = false;
      i = 0;
      paramToServiceMsg = "";
    }
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool2 = false;
    Bundle localBundle = new Bundle();
    String str = "";
    ArticleComment.CheckArticleLikeRequest localCheckArticleLikeRequest;
    if (paramFromServiceMsg.isSuccess())
    {
      localCheckArticleLikeRequest = new ArticleComment.CheckArticleLikeRequest();
      paramFromServiceMsg = new ArticleComment.CheckArticleLikeRespond();
    }
    for (;;)
    {
      boolean bool1;
      try
      {
        localCheckArticleLikeRequest.mergeFrom(paramToServiceMsg.getWupBuffer(), 4, paramToServiceMsg.getWupBuffer().length - 4);
        paramFromServiceMsg.mergeFrom((byte[])paramObject);
        if (!paramFromServiceMsg.ret.has()) {
          break label315;
        }
        if ((!paramFromServiceMsg.ret.ret_code.has()) || (paramFromServiceMsg.ret.ret_code.get() != 0))
        {
          paramToServiceMsg = "";
          bool1 = false;
          if (this.jdField_a_of_type_Nyr == null) {
            break label296;
          }
          this.jdField_a_of_type_Nyr.a(bool2, paramToServiceMsg, bool1);
          return;
        }
      }
      catch (Exception paramToServiceMsg)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("Q.pubaccount.video.PublicAccountArticleHandler", 2, "handleCheckIsArticleLiked() ERROR e=" + paramToServiceMsg.getMessage());
        return;
      }
      paramToServiceMsg = str;
      if (localCheckArticleLikeRequest.article_id.has())
      {
        paramToServiceMsg = localCheckArticleLikeRequest.article_id.get().toStringUtf8();
        localBundle.putString("VALUE_ARTICLE_ID", paramToServiceMsg);
      }
      if ((paramFromServiceMsg.data.has()) && (paramFromServiceMsg.data.size() > 0) && (((ArticleComment.LikeRet)paramFromServiceMsg.data.get(0)).like.has()))
      {
        if (((ArticleComment.LikeRet)paramFromServiceMsg.data.get(0)).like.get() == 0)
        {
          localBundle.putBoolean("VALUE_ARTICLE_IS_LIKED", false);
          bool1 = false;
          bool2 = true;
        }
        else
        {
          localBundle.putBoolean("VALUE_ARTICLE_IS_LIKED", true);
          bool1 = true;
          bool2 = true;
          continue;
          label296:
          super.notifyUI(1, bool2, localBundle);
        }
      }
      else
      {
        bool1 = false;
        bool2 = true;
        continue;
        label315:
        paramToServiceMsg = "";
        bool1 = false;
        bool2 = true;
        continue;
        paramToServiceMsg = "";
        bool1 = false;
      }
    }
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool1 = true;
    boolean bool2 = true;
    String str = "";
    Bundle localBundle = new Bundle();
    ArticleComment.ArticleLikeRespond localArticleLikeRespond;
    if (paramFromServiceMsg.isSuccess())
    {
      paramFromServiceMsg = new ArticleComment.ArticleLikeRequest();
      localArticleLikeRespond = new ArticleComment.ArticleLikeRespond();
    }
    for (;;)
    {
      try
      {
        paramFromServiceMsg.mergeFrom(paramToServiceMsg.getWupBuffer(), 4, paramToServiceMsg.getWupBuffer().length - 4);
        localArticleLikeRespond.mergeFrom((byte[])paramObject);
        paramToServiceMsg = str;
        if (localArticleLikeRespond.ret.has())
        {
          if ((localArticleLikeRespond.ret.ret_code.has()) && (localArticleLikeRespond.ret.ret_code.get() != 0)) {
            break label217;
          }
          localBundle.putBoolean("VALUE_ARTICLE_IS_LIKE_SUCCESS", true);
          bool1 = bool2;
          paramToServiceMsg = str;
          if (paramFromServiceMsg.article_id.has())
          {
            paramToServiceMsg = paramFromServiceMsg.article_id.get().toStringUtf8();
            localBundle.putString("VALUE_ARTICLE_ID", paramToServiceMsg);
            bool1 = bool2;
          }
        }
        if (this.jdField_a_of_type_Nyr == null) {
          break label231;
        }
        this.jdField_a_of_type_Nyr.a(bool1, paramToServiceMsg);
        return;
      }
      catch (Exception paramToServiceMsg)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("Q.pubaccount.video.PublicAccountArticleHandler", 2, "handleSendArticleLikeReq() ERROR e=" + paramToServiceMsg.getMessage());
        return;
      }
      label217:
      localBundle.putBoolean("VALUE_ARTICLE_IS_LIKE_SUCCESS", false);
      bool2 = false;
      continue;
      label231:
      super.notifyUI(0, bool1, localBundle);
      return;
      paramToServiceMsg = "";
      bool1 = false;
    }
  }
  
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramFromServiceMsg.isSuccess()) {
      paramToServiceMsg = new ArticleComment.ReportGalleryInfoResponse();
    }
    try
    {
      paramToServiceMsg.mergeFrom((byte[])paramObject);
      bool1 = bool2;
      if (paramToServiceMsg.ret.has()) {
        if (paramToServiceMsg.ret.ret_code.has())
        {
          bool1 = bool2;
          if (paramToServiceMsg.ret.ret_code.get() != 0) {}
        }
        else
        {
          bool1 = true;
        }
      }
      if (this.jdField_a_of_type_Nyr != null) {
        this.jdField_a_of_type_Nyr.a(bool1);
      }
      return;
    }
    catch (Exception paramToServiceMsg)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("Q.pubaccount.video.PublicAccountArticleHandler", 2, "handleReportReadPhotoCollectionReq() ERROR e=" + paramToServiceMsg.getMessage());
    }
  }
  
  private void e(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool2 = false;
    int j = -1;
    int i = j;
    boolean bool1 = bool2;
    if (paramFromServiceMsg.isSuccess()) {
      paramToServiceMsg = new ArticleComment.CreateArticleCommentRespond();
    }
    try
    {
      paramToServiceMsg.mergeFrom((byte[])paramObject);
      i = j;
      bool1 = bool2;
      if (paramToServiceMsg.ret.has())
      {
        i = j;
        bool1 = bool2;
        if (paramToServiceMsg.ret.ret_code.has())
        {
          j = paramToServiceMsg.ret.ret_code.get();
          i = j;
          bool1 = bool2;
          if (j == 0)
          {
            bool1 = true;
            i = j;
          }
        }
      }
      if (this.jdField_a_of_type_Nyr != null) {
        this.jdField_a_of_type_Nyr.a(bool1, i);
      }
      return;
    }
    catch (Exception paramToServiceMsg)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("Q.pubaccount.video.PublicAccountArticleHandler", 2, "handleCreateArticleCommentReq() ERROR e=" + paramToServiceMsg.getMessage());
    }
  }
  
  private void f(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = 0;
    if (paramFromServiceMsg.isSuccess()) {
      paramToServiceMsg = new ArticleComment.GetArticleCommentCountRespond();
    }
    for (;;)
    {
      try
      {
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        if (!paramToServiceMsg.ret.has()) {
          break label157;
        }
        if ((!paramToServiceMsg.ret.ret_code.has()) || (paramToServiceMsg.ret.ret_code.get() == 0))
        {
          bool1 = true;
          bool2 = bool1;
          if (paramToServiceMsg.count.has())
          {
            i = paramToServiceMsg.count.get();
            bool2 = bool1;
          }
          if (this.jdField_a_of_type_Nyr != null) {
            this.jdField_a_of_type_Nyr.b(bool2, i);
          }
          return;
        }
      }
      catch (Exception paramToServiceMsg)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("Q.pubaccount.video.PublicAccountArticleHandler", 2, "handleGetArticleCommentCountReq() ERROR e=" + paramToServiceMsg.getMessage());
        return;
      }
      boolean bool1 = false;
      continue;
      label157:
      boolean bool2 = false;
    }
  }
  
  private void g(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = 0;
    uwr localuwr = new uwr();
    uwt localuwt = null;
    boolean bool;
    if (paramFromServiceMsg.isSuccess())
    {
      paramFromServiceMsg = new ArticleComment.GetPhotoCollectionInfoResponse();
      try
      {
        paramFromServiceMsg.mergeFrom((byte[])paramObject);
        localuwr.jdField_a_of_type_JavaLangString = ((String)paramToServiceMsg.extraData.get(this.jdField_a_of_type_JavaLangString));
        paramToServiceMsg = localuwr.jdField_a_of_type_JavaLangString;
        if (paramFromServiceMsg.ret.has()) {
          if ((!paramFromServiceMsg.ret.ret_code.has()) || (paramFromServiceMsg.ret.ret_code.get() == 0))
          {
            bool = true;
            if (paramFromServiceMsg.article_share_url.has()) {
              localuwr.jdField_b_of_type_JavaLangString = paramFromServiceMsg.article_share_url.get().toStringUtf8();
            }
            if (paramFromServiceMsg.puin.has()) {
              localuwr.c = (paramFromServiceMsg.puin.get() + "");
            }
            if (paramFromServiceMsg.article_img_url.has()) {
              localuwr.d = paramFromServiceMsg.article_img_url.get().toStringUtf8();
            }
            if (paramFromServiceMsg.article_title.has()) {
              localuwr.e = paramFromServiceMsg.article_title.get().toStringUtf8();
            }
            if (paramFromServiceMsg.enable_comment.has()) {
              localuwr.jdField_a_of_type_Int = paramFromServiceMsg.enable_comment.get();
            }
            if (paramFromServiceMsg.comment_url.has()) {
              localuwr.f = paramFromServiceMsg.comment_url.get().toStringUtf8();
            }
            if (paramFromServiceMsg.firstItem.has())
            {
              localuwr.jdField_a_of_type_Uws = new uws();
              localuwr.jdField_a_of_type_Uws.jdField_a_of_type_JavaLangString = paramFromServiceMsg.firstItem.url.get().toStringUtf8();
              localuwr.jdField_a_of_type_Uws.d = paramFromServiceMsg.firstItem.photo_author_name.get().toStringUtf8();
              localuwr.jdField_a_of_type_Uws.c = paramFromServiceMsg.firstItem.photo_time.get().toStringUtf8();
              localuwr.jdField_a_of_type_Uws.jdField_b_of_type_JavaLangString = paramFromServiceMsg.firstItem.publicaccount_name.get().toStringUtf8();
            }
            if ((!paramFromServiceMsg.item.has()) || (paramFromServiceMsg.item.get().size() <= 0)) {
              break label628;
            }
            localuwr.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
            int j = paramFromServiceMsg.item.get().size();
            while (i < j)
            {
              localuwt = new uwt();
              localuwt.jdField_a_of_type_JavaLangString = ((ArticleComment.PhotoItemInfo)paramFromServiceMsg.item.get(i)).url.get().toStringUtf8();
              localuwt.jdField_b_of_type_JavaLangString = ((ArticleComment.PhotoItemInfo)paramFromServiceMsg.item.get(i)).content.get().toStringUtf8();
              localuwt.c = ((ArticleComment.PhotoItemInfo)paramFromServiceMsg.item.get(i)).static_url.get().toStringUtf8();
              localuwt.jdField_a_of_type_Int = ((ArticleComment.PhotoItemInfo)paramFromServiceMsg.item.get(i)).width.get();
              localuwt.jdField_b_of_type_Int = ((ArticleComment.PhotoItemInfo)paramFromServiceMsg.item.get(i)).height.get();
              localuwr.jdField_a_of_type_JavaUtilArrayList.add(localuwt);
              i += 1;
              continue;
              return;
            }
          }
        }
      }
      catch (Exception paramToServiceMsg)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.pubaccount.video.PublicAccountArticleHandler", 2, "handleGetPhotoCollectionInfoReq() ERROR e=" + paramToServiceMsg.getMessage());
        }
      }
    }
    for (;;)
    {
      bool = false;
      break;
      label628:
      while (this.jdField_a_of_type_Nyr != null)
      {
        this.jdField_a_of_type_Nyr.a(bool, localuwr, (byte[])paramObject, paramToServiceMsg);
        return;
        bool = false;
        continue;
        bool = false;
        paramToServiceMsg = localuwt;
      }
    }
  }
  
  private void h(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool = false;
    paramToServiceMsg = new ArrayList();
    if (paramFromServiceMsg.isSuccess())
    {
      paramFromServiceMsg = new ArticleComment.GetRecommendInfoResponse();
      try
      {
        paramFromServiceMsg.mergeFrom((byte[])paramObject);
        if ((paramFromServiceMsg.ret.has()) && (((!paramFromServiceMsg.ret.ret_code.has()) || (paramFromServiceMsg.ret.ret_code.get() != 0)) || ((paramFromServiceMsg.item.has()) && (paramFromServiceMsg.item.get().size() > 0))))
        {
          int j = paramFromServiceMsg.item.get().size();
          int i = 0;
          while (i < j)
          {
            paramObject = new uwu();
            paramObject.d = ((ArticleComment.RecommendItemInfo)paramFromServiceMsg.item.get(i)).article_id.get().toStringUtf8();
            paramObject.c = ((ArticleComment.RecommendItemInfo)paramFromServiceMsg.item.get(i)).recommend_source.get().toStringUtf8();
            paramObject.jdField_b_of_type_JavaLangString = ((ArticleComment.RecommendItemInfo)paramFromServiceMsg.item.get(i)).title.get().toStringUtf8();
            paramObject.jdField_a_of_type_JavaLangString = ((ArticleComment.RecommendItemInfo)paramFromServiceMsg.item.get(i)).url.get().toStringUtf8();
            paramToServiceMsg.add(paramObject);
            i += 1;
            continue;
            return;
          }
        }
      }
      catch (Exception paramToServiceMsg)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.pubaccount.video.PublicAccountArticleHandler", 2, "handleGetRecommendInfoReq ERROR e=" + paramToServiceMsg.getMessage());
        }
      }
    }
    do
    {
      bool = true;
      if ((paramToServiceMsg != null) && (QLog.isColorLevel())) {
        QLog.e("Q.pubaccount.video.PublicAccountArticleHandler", 2, "handleGetRecommendInfoReq success, size " + paramToServiceMsg.size());
      }
    } while (this.jdField_a_of_type_Nyr == null);
    this.jdField_a_of_type_Nyr.a(bool, paramToServiceMsg);
  }
  
  private void i(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int j = 0;
    boolean bool;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      bool = true;
      if (QLog.isColorLevel()) {
        QLog.d("Q.pubaccount.video.PublicAccountArticleHandler", 2, "handleArticleReadCount:" + bool);
      }
      if (!bool) {
        break label319;
      }
    }
    for (;;)
    {
      try
      {
        paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        paramToServiceMsg = paramToServiceMsg.bytes_bodybuffer.get().toByteArray();
        paramFromServiceMsg = new oidb_0x6a6.RspBody();
        paramFromServiceMsg.mergeFrom(paramToServiceMsg);
        if ((paramFromServiceMsg.uint32_ret_code.has()) && (paramFromServiceMsg.uint32_ret_code.get() == 0))
        {
          if (paramFromServiceMsg.uint32_read_count.has())
          {
            i = paramFromServiceMsg.uint32_read_count.get();
            if (QLog.isColorLevel()) {
              QLog.d("Q.pubaccount.video.PublicAccountArticleHandler", 2, "handleArticleReadCount playCount :" + i);
            }
            if (this.jdField_a_of_type_Nyr != null) {
              this.jdField_a_of_type_Nyr.c(bool, i);
            }
            return;
            bool = false;
            break;
          }
          if (paramFromServiceMsg.uint64_read_count.has())
          {
            i = (int)paramFromServiceMsg.uint64_read_count.get();
            continue;
          }
          i = j;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.e("Q.pubaccount.video.PublicAccountArticleHandler", 2, "handleArticleReadCount 获取失败, read_count 为空");
          i = j;
          continue;
        }
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        i = j;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("Q.pubaccount.video.PublicAccountArticleHandler", 2, "handleArticleReadCount, ERROR e=" + paramToServiceMsg.getMessage());
        i = j;
        continue;
        i = j;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("Q.pubaccount.video.PublicAccountArticleHandler", 2, "handleArticleReadCount 获取失败, ret_code 为空或 ret_code == 1");
        i = j;
        continue;
      }
      label319:
      int i = j;
      if (QLog.isColorLevel())
      {
        QLog.e("Q.pubaccount.video.PublicAccountArticleHandler", 2, "handleArticleReadCount, 返回直接出错了");
        i = j;
      }
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_Nyr = null;
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return;
      localObject = AccountDetailActivity.a(paramString);
    } while (TextUtils.isEmpty((CharSequence)localObject));
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.PublicAccountArticleHandler", 2, "getArticleCommentCount() articleId = " + (String)localObject);
    }
    paramString = new ArticleComment.GetArticleCommentCountRequest();
    Object localObject = ByteStringMicro.copyFromUtf8((String)localObject);
    paramString.article_id.set((ByteStringMicro)localObject);
    localObject = createToServiceMsg("PubAccountArticleCenter.GetArticleCommentCount");
    ((ToServiceMsg)localObject).putWupBuffer(paramString.toByteArray());
    ((ToServiceMsg)localObject).setTimeout(30000L);
    super.sendPbReq((ToServiceMsg)localObject);
  }
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    if (TextUtils.isEmpty(paramString1)) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("Q.pubaccount.video.PublicAccountArticleHandler", 2, "createArticleComment() articleId = " + paramString1);
      }
      localObject = AccountDetailActivity.a(paramString1);
    } while (TextUtils.isEmpty((CharSequence)localObject));
    paramString1 = new ArticleComment.CreateArticleCommentRequest();
    Object localObject = ByteStringMicro.copyFromUtf8((String)localObject);
    paramString1.article_id.set((ByteStringMicro)localObject);
    paramString2 = ByteStringMicro.copyFromUtf8(paramString2);
    paramString1.comment.set(paramString2);
    paramString1.uin.set(Long.valueOf(getCurrentAccountUin()).longValue());
    paramString1.hide_name.set(paramInt);
    paramString2 = createToServiceMsg("PubAccountArticleCenter.CreateArticleComment");
    paramString2.putWupBuffer(paramString1.toByteArray());
    paramString2.setTimeout(30000L);
    super.sendPbReq(paramString2);
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.PublicAccountArticleHandler", 2, "getPhotoCollectionInfo() articleId = " + paramString1);
    }
    ArticleComment.GetPhotoCollectionInfoRequest localGetPhotoCollectionInfoRequest = new ArticleComment.GetPhotoCollectionInfoRequest();
    ByteStringMicro localByteStringMicro = ByteStringMicro.copyFromUtf8(paramString1);
    localGetPhotoCollectionInfoRequest.article_id.set(localByteStringMicro);
    localGetPhotoCollectionInfoRequest.cuin.set(Long.valueOf(getCurrentAccountUin()).longValue());
    localGetPhotoCollectionInfoRequest.versionInfo.set("8.4.1,3,4680");
    localGetPhotoCollectionInfoRequest.click_source.set(paramInt2);
    localGetPhotoCollectionInfoRequest.recommend_position.set(paramInt1);
    localGetPhotoCollectionInfoRequest.recommend_source.set(paramString2);
    paramString2 = createToServiceMsg("PubAccountArticleCenter.PictureInfo");
    paramString2.putWupBuffer(localGetPhotoCollectionInfoRequest.toByteArray());
    paramString2.setTimeout(30000L);
    paramString2.extraData.putString(this.jdField_a_of_type_JavaLangString, paramString1);
    super.sendPbReq(paramString2);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String paramString4, int paramInt3, ArrayList<uwu> paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.PublicAccountArticleHandler", 2, "reportReadPhotoCollection() articleId = " + paramString1);
    }
    ArticleComment.ReportGalleryInfoRequest localReportGalleryInfoRequest = new ArticleComment.ReportGalleryInfoRequest();
    String str = AccountDetailActivity.a(paramString3);
    localReportGalleryInfoRequest.article_id.set(Integer.valueOf(str).intValue());
    localReportGalleryInfoRequest.uin.set(Long.valueOf(getCurrentAccountUin()).longValue());
    localReportGalleryInfoRequest.puin.set(Long.valueOf(paramString2).longValue());
    paramString2 = ByteStringMicro.copyFromUtf8(paramString3);
    localReportGalleryInfoRequest.article_url.set(paramString2);
    paramString2 = ByteStringMicro.copyFromUtf8("Android");
    localReportGalleryInfoRequest.os.set(paramString2);
    localReportGalleryInfoRequest.is_qq.set(1);
    paramString2 = ByteStringMicro.copyFromUtf8("8.4.1");
    localReportGalleryInfoRequest.mv.set(paramString2);
    paramString2 = ByteStringMicro.copyFromUtf8("4680");
    localReportGalleryInfoRequest.subv.set(paramString2);
    paramString2 = ByteStringMicro.copyFromUtf8(anhk.c[bgnt.a(this.mApp.getApp().getBaseContext())]);
    localReportGalleryInfoRequest.network.set(paramString2);
    paramString1 = ByteStringMicro.copyFromUtf8(paramString1);
    localReportGalleryInfoRequest.rowkey.set(paramString1);
    localReportGalleryInfoRequest.ts.set((int)(System.currentTimeMillis() / 1000L));
    localReportGalleryInfoRequest.site_id.set(paramInt1);
    if (paramInt1 == 2)
    {
      localReportGalleryInfoRequest.recommend_index.set(paramInt2);
      paramString1 = ByteStringMicro.copyFromUtf8(paramString4);
      localReportGalleryInfoRequest.echo_info.set(paramString1);
    }
    localReportGalleryInfoRequest.browse_time.set(paramInt3);
    if ((paramArrayList != null) && (paramArrayList.size() > 0) && (paramInt1 == 2))
    {
      paramString1 = new ArticleComment.RecommendInfo();
      paramString2 = paramArrayList.iterator();
      while (paramString2.hasNext())
      {
        paramString3 = (uwu)paramString2.next();
        paramString4 = ByteStringMicro.copyFromUtf8(paramString3.d);
        paramString1.rowkey.set(paramString4);
        paramString3 = ByteStringMicro.copyFromUtf8(paramString3.c);
        paramString1.echo_info.set(paramString3);
        localReportGalleryInfoRequest.recommend_info.add(paramString1);
      }
    }
    paramString1 = createToServiceMsg("PubAccountArticleCenter.GalleryReport");
    paramString1.putWupBuffer(localReportGalleryInfoRequest.toByteArray());
    paramString1.setTimeout(30000L);
    super.sendPbReq(paramString1);
  }
  
  public void a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    ArticleComment.ArticleLikeRequest localArticleLikeRequest = new ArticleComment.ArticleLikeRequest();
    paramString = ByteStringMicro.copyFromUtf8(paramString);
    localArticleLikeRequest.article_id.set(paramString);
    localArticleLikeRequest.uin.set(Long.valueOf(getCurrentAccountUin()).longValue());
    if (paramBoolean1)
    {
      localArticleLikeRequest.like.set(1);
      if (!paramBoolean2) {
        break label109;
      }
      localArticleLikeRequest.pin.set(1);
    }
    for (;;)
    {
      paramString = createToServiceMsg("PubAccountArticleCenter.ArticleLike");
      paramString.putWupBuffer(localArticleLikeRequest.toByteArray());
      paramString.setTimeout(30000L);
      super.sendPbReq(paramString);
      return;
      localArticleLikeRequest.like.set(0);
      break;
      label109:
      localArticleLikeRequest.pin.set(0);
    }
  }
  
  public void a(nyr paramnyr)
  {
    this.jdField_a_of_type_Nyr = paramnyr;
  }
  
  public void b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.PublicAccountArticleHandler", 2, "getRecommendInfo() articleId = " + paramString);
    }
    ArticleComment.GetRecommendInfoRequest localGetRecommendInfoRequest = new ArticleComment.GetRecommendInfoRequest();
    paramString = ByteStringMicro.copyFromUtf8(paramString);
    localGetRecommendInfoRequest.article_id.set(paramString);
    localGetRecommendInfoRequest.cuin.set(Long.valueOf(getCurrentAccountUin()).longValue());
    localGetRecommendInfoRequest.versionInfo.set("8.4.1,3,4680");
    paramString = createToServiceMsg("PubAccountArticleCenter.GetRecommendInfo");
    paramString.putWupBuffer(localGetRecommendInfoRequest.toByteArray());
    paramString.setTimeout(30000L);
    super.sendPbReq(paramString);
  }
  
  public void c(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.PublicAccountArticleHandler", 2, "queryArticleLikeCount() articleId = " + paramString);
    }
    ArticleComment.GetArticleLikeCountRequest localGetArticleLikeCountRequest = new ArticleComment.GetArticleLikeCountRequest();
    paramString = ByteStringMicro.copyFromUtf8(paramString);
    localGetArticleLikeCountRequest.article_id.set(paramString);
    paramString = createToServiceMsg("PubAccountArticleCenter.GetArticleLikeCount");
    paramString.putWupBuffer(localGetArticleLikeCountRequest.toByteArray());
    paramString.setTimeout(30000L);
    super.sendPbReq(paramString);
  }
  
  public void d(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.PublicAccountArticleHandler", 2, "queryArticleReadCount()  articleId" + paramString);
    }
    oidb_0x6a6.ReqBody localReqBody = new oidb_0x6a6.ReqBody();
    paramString = ByteStringMicro.copyFromUtf8(paramString);
    localReqBody.bytes_article_id.set(paramString);
    localReqBody.uint32_req_type.set(0);
    super.sendPbReq(super.makeOIDBPkg("OidbSvc.0x6a6", 1702, 0, localReqBody.toByteArray()));
  }
  
  public void e(String paramString)
  {
    ArticleComment.CheckArticleLikeRequest localCheckArticleLikeRequest = new ArticleComment.CheckArticleLikeRequest();
    paramString = ByteStringMicro.copyFromUtf8(paramString);
    localCheckArticleLikeRequest.article_id.set(paramString);
    localCheckArticleLikeRequest.uins.add(Long.valueOf(getCurrentAccountUin()));
    paramString = createToServiceMsg("PubAccountArticleCenter.CheckArticleLike");
    paramString.putWupBuffer(localCheckArticleLikeRequest.toByteArray());
    paramString.setTimeout(30000L);
    super.sendPbReq(paramString);
  }
  
  protected boolean msgCmdFilter(String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilSet == null)
    {
      this.jdField_a_of_type_JavaUtilSet = new HashSet();
      this.jdField_a_of_type_JavaUtilSet.add("PubAccountArticleCenter.ArticleLike");
      this.jdField_a_of_type_JavaUtilSet.add("PubAccountArticleCenter.CheckArticleLike");
      this.jdField_a_of_type_JavaUtilSet.add("PubAccountArticleCenter.GetArticleLikeCount");
      this.jdField_a_of_type_JavaUtilSet.add("PubAccountArticleCenter.CreateArticleComment");
      this.jdField_a_of_type_JavaUtilSet.add("PubAccountArticleCenter.GetArticleCommentCount");
      this.jdField_a_of_type_JavaUtilSet.add("PubAccountArticleCenter.PictureInfo");
      this.jdField_a_of_type_JavaUtilSet.add("PubAccountArticleCenter.GetRecommendInfo");
      this.jdField_a_of_type_JavaUtilSet.add("PubAccountArticleCenter.GalleryReport");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x6a6");
    }
    return !this.jdField_a_of_type_JavaUtilSet.contains(paramString);
  }
  
  protected Class<? extends anil> observerClass()
  {
    return nyr.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.PublicAccountArticleHandler", 2, "onReceive() getServiceCmd=" + paramFromServiceMsg.getServiceCmd());
    }
    if (msgCmdFilter(paramFromServiceMsg.getServiceCmd())) {}
    do
    {
      do
      {
        return;
        try
        {
          if (!paramFromServiceMsg.getServiceCmd().equals("PubAccountArticleCenter.GetArticleLikeCount")) {
            break;
          }
          a(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        }
        catch (Exception paramToServiceMsg) {}
      } while (!QLog.isColorLevel());
      QLog.e("Q.pubaccount.video.PublicAccountArticleHandler", 2, "onReceive ERROR e=" + paramToServiceMsg.getMessage() + paramFromServiceMsg.getServiceCmd());
      return;
      if (paramFromServiceMsg.getServiceCmd().equals("PubAccountArticleCenter.CheckArticleLike"))
      {
        b(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if (paramFromServiceMsg.getServiceCmd().equals("PubAccountArticleCenter.ArticleLike"))
      {
        c(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if (paramFromServiceMsg.getServiceCmd().equals("PubAccountArticleCenter.GalleryReport"))
      {
        d(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if (paramFromServiceMsg.getServiceCmd().equals("PubAccountArticleCenter.CreateArticleComment"))
      {
        e(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if (paramFromServiceMsg.getServiceCmd().equals("PubAccountArticleCenter.GetArticleCommentCount"))
      {
        f(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if (paramFromServiceMsg.getServiceCmd().equals("PubAccountArticleCenter.PictureInfo"))
      {
        g(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if (paramFromServiceMsg.getServiceCmd().equals("PubAccountArticleCenter.GetRecommendInfo"))
      {
        h(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
    } while (!paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0x6a6"));
    i(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nyq
 * JD-Core Version:    0.7.0.1
 */