package com.tencent.mobileqq.kandian.repo.fastweb;

import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.base.utils.RIJPBFieldUtils;
import com.tencent.mobileqq.kandian.repo.fastweb.entity.AuthorData;
import com.tencent.mobileqq.kandian.repo.fastweb.entity.ProteusBookData;
import com.tencent.mobileqq.kandian.repo.fastweb.entity.TitleData;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.BaseData;
import com.tencent.mobileqq.kandian.repo.feeds.entity.FastWebArticleInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0xad6.oidb_cmd0xad6.Article;
import tencent.im.oidb.cmd0xad6.oidb_cmd0xad6.ArticleCommonInfo;
import tencent.im.oidb.cmd0xad6.oidb_cmd0xad6.ArticleCover;
import tencent.im.oidb.cmd0xad6.oidb_cmd0xad6.ArticleExtInfo;
import tencent.im.oidb.cmd0xad6.oidb_cmd0xad6.RspArticle;
import tencent.im.oidb.cmd0xad6.oidb_cmd0xad6.RspBody;

public class FastWebArticleInfoUtils
{
  public static AuthorData a(FastWebArticleInfo paramFastWebArticleInfo, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    AuthorData localAuthorData = new AuthorData(paramAbsBaseArticleInfo, paramFastWebArticleInfo);
    if (paramFastWebArticleInfo.a())
    {
      localAuthorData.jdField_b_of_type_JavaLangString = paramAbsBaseArticleInfo.mSubscribeName;
      localAuthorData.jdField_c_of_type_JavaLangString = paramAbsBaseArticleInfo.getSubscribeUin();
      localAuthorData.jdField_a_of_type_JavaLangString = "";
      if (TextUtils.isEmpty(localAuthorData.jdField_b_of_type_JavaLangString))
      {
        String str;
        if (TextUtils.isEmpty(paramFastWebArticleInfo.jdField_e_of_type_JavaLangString)) {
          str = paramFastWebArticleInfo.h;
        } else {
          str = paramFastWebArticleInfo.jdField_e_of_type_JavaLangString;
        }
        localAuthorData.jdField_b_of_type_JavaLangString = str;
        paramAbsBaseArticleInfo.mSubscribeName = localAuthorData.jdField_b_of_type_JavaLangString;
      }
    }
    else
    {
      localAuthorData.jdField_b_of_type_JavaLangString = paramFastWebArticleInfo.jdField_e_of_type_JavaLangString;
      localAuthorData.jdField_c_of_type_JavaLangString = paramAbsBaseArticleInfo.getSubscribeUin();
      localAuthorData.jdField_a_of_type_JavaLangString = paramFastWebArticleInfo.g;
      localAuthorData.jdField_e_of_type_JavaLangString = paramFastWebArticleInfo.h;
    }
    localAuthorData.jdField_d_of_type_JavaLangString = paramFastWebArticleInfo.f;
    localAuthorData.jdField_a_of_type_Long = paramFastWebArticleInfo.jdField_a_of_type_Long;
    localAuthorData.ad = paramFastWebArticleInfo.q;
    localAuthorData.A = 1;
    localAuthorData.z = 1;
    return localAuthorData;
  }
  
  public static TitleData a(FastWebArticleInfo paramFastWebArticleInfo, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    TitleData localTitleData = new TitleData();
    localTitleData.jdField_a_of_type_JavaLangString = paramFastWebArticleInfo.jdField_c_of_type_JavaLangString;
    localTitleData.b = paramAbsBaseArticleInfo;
    localTitleData.ad = paramFastWebArticleInfo.q;
    localTitleData.A = 1;
    localTitleData.z = 1;
    return localTitleData;
  }
  
  public static void a(FastWebArticleInfo paramFastWebArticleInfo, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    ThreadManager.executeOnNetWorkThread(new FastWebArticleInfoUtils.1(paramAbsBaseArticleInfo, paramFastWebArticleInfo));
  }
  
  public static void a(FastWebArticleInfo paramFastWebArticleInfo, List<BaseData> paramList)
  {
    if (paramList != null)
    {
      paramFastWebArticleInfo.jdField_c_of_type_JavaUtilList.clear();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Object localObject = (BaseData)paramList.next();
        if (((BaseData)localObject).u == 18)
        {
          localObject = (ProteusBookData)localObject;
          if (((ProteusBookData)localObject).jdField_b_of_type_JavaLangString != null) {
            paramFastWebArticleInfo.jdField_c_of_type_JavaUtilList.add(((ProteusBookData)localObject).jdField_b_of_type_JavaLangString);
          }
        }
      }
    }
  }
  
  public static boolean a(FastWebArticleInfo paramFastWebArticleInfo, oidb_cmd0xad6.RspBody paramRspBody, int paramInt)
  {
    for (;;)
    {
      try
      {
        Object localObject = (oidb_cmd0xad6.Article)((oidb_cmd0xad6.RspArticle)paramRspBody.msg_rsp_article.get()).msg_article.get();
        oidb_cmd0xad6.ArticleCommonInfo localArticleCommonInfo = (oidb_cmd0xad6.ArticleCommonInfo)((oidb_cmd0xad6.Article)localObject).msg_article_common.get();
        paramFastWebArticleInfo.jdField_c_of_type_JavaLangString = localArticleCommonInfo.bytes_title.get().toStringUtf8();
        paramFastWebArticleInfo.jdField_d_of_type_JavaLangString = localArticleCommonInfo.bytes_desc.get().toStringUtf8();
        paramFastWebArticleInfo.jdField_e_of_type_JavaLangString = localArticleCommonInfo.bytes_account_name.get().toStringUtf8();
        paramFastWebArticleInfo.g = localArticleCommonInfo.bytes_account_icon.get().toStringUtf8();
        paramFastWebArticleInfo.h = localArticleCommonInfo.bytes_account_author.get().toStringUtf8();
        paramFastWebArticleInfo.f = localArticleCommonInfo.bytes_date.get().toStringUtf8();
        paramFastWebArticleInfo.i = localArticleCommonInfo.bytes_share_words.get().toStringUtf8();
        paramFastWebArticleInfo.j = localArticleCommonInfo.bytes_row_key.get().toStringUtf8();
        paramFastWebArticleInfo.jdField_b_of_type_Int = localArticleCommonInfo.uint32_article_flag.get();
        paramFastWebArticleInfo.l = localArticleCommonInfo.bytes_tags.get().toStringUtf8();
        paramFastWebArticleInfo.o = localArticleCommonInfo.bytes_article_id.get().toStringUtf8();
        paramFastWebArticleInfo.jdField_e_of_type_Long = localArticleCommonInfo.uint64_public_uin.get();
        paramFastWebArticleInfo.q = localArticleCommonInfo.bytes_proteus_json_data.get().toStringUtf8();
        if (localArticleCommonInfo.bytes_article_url.has()) {
          paramFastWebArticleInfo.s = localArticleCommonInfo.bytes_article_url.get().toStringUtf8();
        }
        paramFastWebArticleInfo.jdField_d_of_type_Int = RIJPBFieldUtils.a(localArticleCommonInfo.uint32_source, 0);
        paramFastWebArticleInfo.jdField_d_of_type_Boolean = RIJPBFieldUtils.a(paramRspBody.bool_use_webview);
        if ((localArticleCommonInfo.msg_cover.has()) && (((oidb_cmd0xad6.ArticleCover)localArticleCommonInfo.msg_cover.get()).bytes_cover_url.has())) {
          paramFastWebArticleInfo.r = ((oidb_cmd0xad6.ArticleCover)localArticleCommonInfo.msg_cover.get()).bytes_cover_url.get().toStringUtf8();
        }
        if (localArticleCommonInfo.bytes_original_url.has()) {
          paramFastWebArticleInfo.k = localArticleCommonInfo.bytes_original_url.get().toStringUtf8();
        }
        paramRspBody = (oidb_cmd0xad6.ArticleExtInfo)paramRspBody.msg_ext_info.get();
        if (((oidb_cmd0xad6.Article)localObject).uint32_zip.get() == 1)
        {
          localObject = a(paramFastWebArticleInfo, ((oidb_cmd0xad6.Article)localObject).bytes_html.get().toByteArray());
          if (localObject.length > 0)
          {
            paramFastWebArticleInfo.jdField_a_of_type_JavaLangString = new String((byte[])localObject, "UTF-8");
          }
          else
          {
            QLog.d(FastWebModule.jdField_a_of_type_JavaLangString, 1, "uncompress article content data error !");
            return false;
          }
        }
        else
        {
          paramFastWebArticleInfo.jdField_a_of_type_JavaLangString = ((oidb_cmd0xad6.Article)localObject).bytes_html.get().toStringUtf8();
        }
        paramFastWebArticleInfo.jdField_a_of_type_Long = paramRspBody.uint64_read_count.get();
        paramFastWebArticleInfo.jdField_b_of_type_Long = paramRspBody.uint64_comment.get();
        paramFastWebArticleInfo.jdField_b_of_type_JavaLangString = paramRspBody.bytes_comment_url.get().toStringUtf8();
        if (paramInt == 3)
        {
          bool = true;
          paramFastWebArticleInfo.jdField_b_of_type_Boolean = bool;
          paramFastWebArticleInfo.jdField_c_of_type_Boolean = false;
          return true;
        }
      }
      catch (Exception paramFastWebArticleInfo)
      {
        paramFastWebArticleInfo.printStackTrace();
        paramRspBody = new StringBuilder();
        paramRspBody.append("parse server resp value error : ");
        paramRspBody.append(paramFastWebArticleInfo);
        QLog.d("Q.readinjoy.fast_web", 2, paramRspBody.toString());
        return false;
      }
      boolean bool = false;
    }
  }
  
  private static byte[] a(FastWebArticleInfo paramFastWebArticleInfo, byte[] paramArrayOfByte)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.useAs(TypeTransformer.java:868)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:668)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.fastweb.FastWebArticleInfoUtils
 * JD-Core Version:    0.7.0.1
 */