package com.tencent.mobileqq.kandian.biz.fastweb.util;

import android.text.TextUtils;
import com.tencent.mobileqq.kandian.biz.fastweb.FastWebActivity;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport;
import com.tencent.mobileqq.kandian.glue.report.dt.RIJDtParamBuilder;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.BaseData;
import com.tencent.mobileqq.kandian.repo.feeds.entity.FastWebArticleInfo;
import com.tencent.mobileqq.kandian.repo.pts.entity.ProteusItemData;
import com.tencent.mobileqq.troop.jsp.TroopNoticeJsHandler;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public class FastWebImageItemUtils
{
  public static String a(String paramString)
  {
    String str = paramString;
    if (!TextUtils.isEmpty(paramString))
    {
      if (!paramString.contains("&tp=webp")) {
        return paramString;
      }
      str = paramString.replace("&tp=webp", "");
    }
    return str;
  }
  
  public static void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, FastWebArticleInfo paramFastWebArticleInfo, FastWebActivity paramFastWebActivity, JSONObject paramJSONObject, List<BaseData> paramList, ArrayList<String> paramArrayList)
  {
    if (paramFastWebActivity != null) {
      if (paramJSONObject == null) {
        return;
      }
    }
    for (;;)
    {
      try
      {
        paramJSONObject = paramJSONObject.getString("articleImageUrl");
        if (paramArrayList.isEmpty())
        {
          paramList = paramList.iterator();
          if (paramList.hasNext())
          {
            Object localObject = (BaseData)paramList.next();
            boolean bool = localObject instanceof ProteusItemData;
            if (!bool) {
              continue;
            }
            try
            {
              localObject = (ProteusItemData)localObject;
              if (((ProteusItemData)localObject).be != 2) {
                continue;
              }
              paramArrayList.add(a(((ProteusItemData)localObject).bb.getString("articleImageUrl")));
            }
            catch (Exception localException)
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("handlerImageClick error!!! msg=");
              localStringBuilder.append(localException);
              QLog.d("FastWebImageItemUtils", 1, localStringBuilder.toString());
            }
            continue;
          }
        }
        int i = paramArrayList.indexOf(a(paramJSONObject));
        paramJSONObject = (HashMap)new RIJDtParamBuilder().e(paramAbsBaseArticleInfo.innerUniqueID).a(Long.valueOf(paramAbsBaseArticleInfo.mChannelID)).a("ref_channel", Long.valueOf(paramAbsBaseArticleInfo.mChannelID)).b(Integer.valueOf(paramAbsBaseArticleInfo.dtReportContentType)).c();
        try
        {
          TroopNoticeJsHandler.a(paramFastWebActivity, i, paramArrayList, null, null, false, true, "4", 1000, null, null, null, null, "", true, "999", paramJSONObject);
          if (!paramFastWebArticleInfo.a()) {
            break label304;
          }
          paramFastWebArticleInfo = "2";
          ReportUtil.a(paramAbsBaseArticleInfo, "0X8008996", RIJTransMergeKanDianReport.a(paramFastWebActivity, paramAbsBaseArticleInfo, 0, paramFastWebArticleInfo).toString());
          return;
        }
        catch (Exception paramAbsBaseArticleInfo) {}
        paramFastWebArticleInfo = new StringBuilder();
      }
      catch (Exception paramAbsBaseArticleInfo) {}
      paramFastWebArticleInfo.append("handlerImageClick error! msg=");
      paramFastWebArticleInfo.append(paramAbsBaseArticleInfo);
      QLog.d("FastWebImageItemUtils", 1, paramFastWebArticleInfo.toString());
      return;
      label304:
      paramFastWebArticleInfo = "1";
    }
  }
  
  private static boolean a(int paramInt)
  {
    return paramInt < 100;
  }
  
  /* Error */
  public static boolean a(JSONObject paramJSONObject, String paramString1, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 8
    //   3: invokestatic 196	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   6: invokestatic 201	com/tencent/mobileqq/kandian/biz/fastweb/util/FastWebPTSUtils:a	(Landroid/content/Context;)I
    //   9: istore 4
    //   11: aload_1
    //   12: invokestatic 205	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   15: istore 5
    //   17: aload_2
    //   18: invokestatic 205	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   21: istore 6
    //   23: iload 5
    //   25: invokestatic 207	com/tencent/mobileqq/kandian/biz/fastweb/util/FastWebImageItemUtils:a	(I)Z
    //   28: ifeq +14 -> 42
    //   31: iload 5
    //   33: i2d
    //   34: invokestatic 213	com/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/utils/Utils:dp2px	(D)I
    //   37: istore 4
    //   39: goto +20 -> 59
    //   42: ldc2_w 214
    //   45: invokestatic 213	com/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/utils/Utils:dp2px	(D)I
    //   48: istore 7
    //   50: iload 4
    //   52: iload 7
    //   54: iconst_2
    //   55: imul
    //   56: isub
    //   57: istore 4
    //   59: iload 6
    //   61: iload 4
    //   63: imul
    //   64: iload 5
    //   66: idiv
    //   67: istore 6
    //   69: iload 6
    //   71: ifle +52 -> 123
    //   74: iload 4
    //   76: ifle +47 -> 123
    //   79: aload_0
    //   80: ldc 217
    //   82: ldc 219
    //   84: invokevirtual 223	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   87: pop
    //   88: aload_0
    //   89: ldc 225
    //   91: iload 6
    //   93: invokevirtual 228	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   96: pop
    //   97: aload_0
    //   98: ldc 230
    //   100: iload 4
    //   102: invokevirtual 228	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   105: pop
    //   106: aload_0
    //   107: ldc 35
    //   109: aload_3
    //   110: invokevirtual 223	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   113: pop
    //   114: aload_0
    //   115: ldc 232
    //   117: ldc 234
    //   119: invokevirtual 223	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   122: pop
    //   123: new 80	java/lang/StringBuilder
    //   126: dup
    //   127: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   130: astore_0
    //   131: aload_0
    //   132: ldc 236
    //   134: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: pop
    //   138: aload_0
    //   139: iload 4
    //   141: invokevirtual 239	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   144: pop
    //   145: aload_0
    //   146: ldc 241
    //   148: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: pop
    //   152: aload_0
    //   153: iload 6
    //   155: invokevirtual 239	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   158: pop
    //   159: ldc 92
    //   161: iconst_1
    //   162: aload_0
    //   163: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   166: invokestatic 102	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   169: goto +76 -> 245
    //   172: astore_0
    //   173: iload 4
    //   175: istore 5
    //   177: iload 6
    //   179: istore 4
    //   181: goto +25 -> 206
    //   184: astore_0
    //   185: iconst_0
    //   186: istore 6
    //   188: iload 4
    //   190: istore 5
    //   192: iload 6
    //   194: istore 4
    //   196: goto +10 -> 206
    //   199: astore_0
    //   200: iconst_0
    //   201: istore 4
    //   203: iconst_0
    //   204: istore 5
    //   206: new 80	java/lang/StringBuilder
    //   209: dup
    //   210: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   213: astore_1
    //   214: aload_1
    //   215: ldc 243
    //   217: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   220: pop
    //   221: aload_1
    //   222: aload_0
    //   223: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   226: pop
    //   227: ldc 92
    //   229: iconst_1
    //   230: aload_1
    //   231: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   234: invokestatic 102	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   237: iload 4
    //   239: istore 6
    //   241: iload 5
    //   243: istore 4
    //   245: aload_3
    //   246: invokestatic 17	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   249: ifne +13 -> 262
    //   252: iload 6
    //   254: ifle +8 -> 262
    //   257: iload 4
    //   259: ifgt +6 -> 265
    //   262: iconst_0
    //   263: istore 8
    //   265: iload 8
    //   267: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	268	0	paramJSONObject	JSONObject
    //   0	268	1	paramString1	String
    //   0	268	2	paramString2	String
    //   0	268	3	paramString3	String
    //   9	249	4	i	int
    //   15	227	5	j	int
    //   21	232	6	k	int
    //   48	8	7	m	int
    //   1	265	8	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   79	123	172	java/lang/Exception
    //   123	169	172	java/lang/Exception
    //   59	69	184	java/lang/Exception
    //   3	39	199	java/lang/Exception
    //   42	50	199	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.util.FastWebImageItemUtils
 * JD-Core Version:    0.7.0.1
 */