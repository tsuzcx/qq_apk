package com.tencent.mobileqq.kandian.biz.pts.item;

import android.content.Context;
import android.graphics.Color;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.StringCommon;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsHelper;
import com.tencent.mobileqq.kandian.biz.pts.ProteusItem;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.report.ReadinjoyReportUtils;
import com.tencent.mobileqq.kandian.glue.video.report.VideoR5;
import com.tencent.mobileqq.kandian.glue.video.report.VideoR5.Builder;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.UrlJumpInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.mobileqq.kandian.repo.video.entity.VideoColumnInfo;
import java.util.List;
import org.json.JSONObject;
import tencent.im.oidb.articlesummary.articlesummary.VideoDownloadBarInfo;

public class DoubleShortVideoProteusItem
  implements ProteusItem
{
  private void a(Context paramContext, AbsBaseArticleInfo paramAbsBaseArticleInfo, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter)
  {
    if ((paramAbsBaseArticleInfo != null) && (paramAbsBaseArticleInfo.mVideoDownloadBarInfo != null) && (paramAbsBaseArticleInfo.mVideoDownloadBarInfo.get() != null))
    {
      VideoFeedsHelper.a(paramContext, UrlJumpInfo.a(paramAbsBaseArticleInfo.mVideoDownloadBarInfo.msg_url_jump_info));
      return;
    }
    if ((paramReadInJoyBaseAdapter != null) && (paramAbsBaseArticleInfo != null)) {
      paramReadInJoyBaseAdapter.a(ReadInJoyBaseAdapter.a(paramAbsBaseArticleInfo), paramAbsBaseArticleInfo, false, false);
    }
  }
  
  private void a(ViewBase paramViewBase, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if ((paramAbsBaseArticleInfo != null) && (paramViewBase != null) && ((paramViewBase.getNativeView() instanceof TextView)))
    {
      TextView localTextView = (TextView)paramViewBase.getNativeView();
      if (ReadInJoyLogicEngine.a().a(paramAbsBaseArticleInfo.mArticleID)) {
        paramViewBase = "#999999";
      } else {
        paramViewBase = "#000000";
      }
      localTextView.setTextColor(Color.parseColor(paramViewBase));
    }
  }
  
  private void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (paramAbsBaseArticleInfo != null)
    {
      if (paramJSONObject == null) {
        return;
      }
      int i;
      if (paramAbsBaseArticleInfo.mVideoColumnInfo != null) {
        i = paramAbsBaseArticleInfo.mVideoColumnInfo.b;
      } else {
        i = -1;
      }
      int j = 1;
      paramJSONObject = new VideoR5.Builder(null, null, null, null).X(Integer.valueOf("1031").intValue()).k(paramAbsBaseArticleInfo.getInnerUniqueID()).aa(paramBoolean ^ true).s(paramJSONObject.optString("double_videocard_jump_page")).t(paramJSONObject.optString("double_videocard_jump_src")).u(paramAbsBaseArticleInfo.mSubscribeName).a((int)paramAbsBaseArticleInfo.mChannelID);
      if (ReadinjoyReportUtils.e() > 0) {
        j = 0;
      }
      paramAbsBaseArticleInfo = paramJSONObject.ah(j).f(paramAbsBaseArticleInfo);
      if (i != -1) {
        paramAbsBaseArticleInfo.Z(i);
      }
      paramAbsBaseArticleInfo = paramAbsBaseArticleInfo.b().a();
      PublicAccountReportUtils.a(null, null, "0X8007625", "0X8007625", 0, 0, "", "", "", paramAbsBaseArticleInfo, false);
      PublicAccountReportUtils.a(null, null, "0X800A5A9", "0X800A5A9", 0, 0, "", "", "", paramAbsBaseArticleInfo, false);
    }
  }
  
  public TemplateBean a(int paramInt, JSONObject paramJSONObject)
  {
    return null;
  }
  
  /* Error */
  public JSONObject a(int paramInt, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnull +1596 -> 1597
    //   4: aload_2
    //   5: getfield 200	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:mSubArticleList	Ljava/util/List;
    //   8: ifnull +1589 -> 1597
    //   11: aload_2
    //   12: getfield 200	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:mSubArticleList	Ljava/util/List;
    //   15: invokeinterface 205 1 0
    //   20: ifeq +1577 -> 1597
    //   23: aload_2
    //   24: getfield 200	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:mSubArticleList	Ljava/util/List;
    //   27: iconst_0
    //   28: invokeinterface 208 2 0
    //   33: ifnonnull +6 -> 39
    //   36: goto +1561 -> 1597
    //   39: aload_2
    //   40: invokevirtual 212	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:getProteusItemData	()Lorg/json/JSONObject;
    //   43: astore 12
    //   45: aconst_null
    //   46: astore 7
    //   48: aconst_null
    //   49: astore 11
    //   51: aconst_null
    //   52: astore 10
    //   54: aload 12
    //   56: ifnonnull +5 -> 61
    //   59: aconst_null
    //   60: areturn
    //   61: new 135	org/json/JSONObject
    //   64: dup
    //   65: invokespecial 213	org/json/JSONObject:<init>	()V
    //   68: astore 13
    //   70: aload_2
    //   71: getfield 200	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:mSubArticleList	Ljava/util/List;
    //   74: iconst_0
    //   75: invokeinterface 208 2 0
    //   80: checkcast 15	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo
    //   83: astore 14
    //   85: aload_2
    //   86: invokevirtual 124	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:getInnerUniqueID	()Ljava/lang/String;
    //   89: astore 15
    //   91: aload 14
    //   93: invokevirtual 124	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:getInnerUniqueID	()Ljava/lang/String;
    //   96: astore 16
    //   98: new 215	java/lang/StringBuilder
    //   101: dup
    //   102: invokespecial 216	java/lang/StringBuilder:<init>	()V
    //   105: astore 4
    //   107: aload 4
    //   109: ldc 218
    //   111: invokevirtual 222	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: pop
    //   115: aload 4
    //   117: aload 15
    //   119: invokevirtual 222	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: pop
    //   123: aload 4
    //   125: ldc 224
    //   127: invokevirtual 222	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: pop
    //   131: aload 4
    //   133: aload 16
    //   135: invokevirtual 222	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: pop
    //   139: aload 4
    //   141: ldc 226
    //   143: invokevirtual 222	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: pop
    //   147: aload 4
    //   149: invokevirtual 229	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   152: astore 17
    //   154: new 135	org/json/JSONObject
    //   157: dup
    //   158: invokespecial 213	org/json/JSONObject:<init>	()V
    //   161: astore 18
    //   163: aload 18
    //   165: ldc 231
    //   167: aload 17
    //   169: invokevirtual 235	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   172: pop
    //   173: aload_2
    //   174: getfield 93	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:mVideoColumnInfo	Lcom/tencent/mobileqq/kandian/repo/video/entity/VideoColumnInfo;
    //   177: ifnull +20 -> 197
    //   180: aload_2
    //   181: getfield 93	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:mVideoColumnInfo	Lcom/tencent/mobileqq/kandian/repo/video/entity/VideoColumnInfo;
    //   184: getfield 99	com/tencent/mobileqq/kandian/repo/video/entity/VideoColumnInfo:b	I
    //   187: istore_1
    //   188: iload_1
    //   189: invokestatic 240	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   192: astore 4
    //   194: goto +6 -> 200
    //   197: aconst_null
    //   198: astore 4
    //   200: aload 14
    //   202: getfield 93	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:mVideoColumnInfo	Lcom/tencent/mobileqq/kandian/repo/video/entity/VideoColumnInfo;
    //   205: ifnull +21 -> 226
    //   208: aload 14
    //   210: getfield 93	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:mVideoColumnInfo	Lcom/tencent/mobileqq/kandian/repo/video/entity/VideoColumnInfo;
    //   213: getfield 99	com/tencent/mobileqq/kandian/repo/video/entity/VideoColumnInfo:b	I
    //   216: istore_1
    //   217: iload_1
    //   218: invokestatic 240	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   221: astore 5
    //   223: goto +6 -> 229
    //   226: aconst_null
    //   227: astore 5
    //   229: aload 10
    //   231: astore 7
    //   233: aload 11
    //   235: astore 6
    //   237: aload 4
    //   239: astore 9
    //   241: aload 5
    //   243: astore 8
    //   245: aload 4
    //   247: invokestatic 246	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   250: ifne +220 -> 470
    //   253: aload 10
    //   255: astore 7
    //   257: aload 11
    //   259: astore 6
    //   261: aload 4
    //   263: astore 9
    //   265: aload 5
    //   267: astore 8
    //   269: aload 5
    //   271: invokestatic 246	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   274: ifne +196 -> 470
    //   277: aload 10
    //   279: astore 7
    //   281: new 215	java/lang/StringBuilder
    //   284: dup
    //   285: invokespecial 216	java/lang/StringBuilder:<init>	()V
    //   288: astore 6
    //   290: aload 10
    //   292: astore 7
    //   294: aload 6
    //   296: ldc 218
    //   298: invokevirtual 222	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   301: pop
    //   302: aload 10
    //   304: astore 7
    //   306: aload 6
    //   308: aload 4
    //   310: invokevirtual 222	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   313: pop
    //   314: aload 10
    //   316: astore 7
    //   318: aload 6
    //   320: ldc 224
    //   322: invokevirtual 222	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   325: pop
    //   326: aload 10
    //   328: astore 7
    //   330: aload 6
    //   332: aload 5
    //   334: invokevirtual 222	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   337: pop
    //   338: aload 10
    //   340: astore 7
    //   342: aload 6
    //   344: ldc 226
    //   346: invokevirtual 222	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   349: pop
    //   350: aload 10
    //   352: astore 7
    //   354: aload 6
    //   356: invokevirtual 229	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   359: astore 6
    //   361: aload 6
    //   363: astore 7
    //   365: aload 18
    //   367: ldc 248
    //   369: aload 6
    //   371: invokevirtual 235	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   374: pop
    //   375: aload 4
    //   377: astore 9
    //   379: aload 5
    //   381: astore 8
    //   383: goto +87 -> 470
    //   386: astore 6
    //   388: goto +20 -> 408
    //   391: astore 6
    //   393: aconst_null
    //   394: astore 5
    //   396: goto +12 -> 408
    //   399: astore 6
    //   401: aconst_null
    //   402: astore 4
    //   404: aload 4
    //   406: astore 5
    //   408: invokestatic 254	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   411: ifeq +47 -> 458
    //   414: new 215	java/lang/StringBuilder
    //   417: dup
    //   418: invokespecial 216	java/lang/StringBuilder:<init>	()V
    //   421: astore 8
    //   423: aload 8
    //   425: ldc_w 256
    //   428: invokevirtual 222	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   431: pop
    //   432: aload 8
    //   434: aload 6
    //   436: invokevirtual 259	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   439: invokevirtual 222	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   442: pop
    //   443: ldc_w 261
    //   446: iconst_2
    //   447: aload 8
    //   449: invokevirtual 229	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   452: invokestatic 265	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   455: goto +3 -> 458
    //   458: aload 7
    //   460: astore 6
    //   462: aload 5
    //   464: astore 8
    //   466: aload 4
    //   468: astore 9
    //   470: aload 18
    //   472: ldc 133
    //   474: aload 12
    //   476: ldc 133
    //   478: invokevirtual 139	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   481: invokevirtual 235	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   484: pop
    //   485: aload 18
    //   487: ldc 144
    //   489: aload 12
    //   491: ldc 144
    //   493: invokevirtual 139	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   496: invokevirtual 235	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   499: pop
    //   500: aload 13
    //   502: ldc_w 267
    //   505: aload 18
    //   507: invokevirtual 235	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   510: pop
    //   511: new 135	org/json/JSONObject
    //   514: dup
    //   515: invokespecial 213	org/json/JSONObject:<init>	()V
    //   518: astore 4
    //   520: aload 4
    //   522: ldc_w 269
    //   525: aload 15
    //   527: invokevirtual 235	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   530: pop
    //   531: aload 4
    //   533: ldc_w 271
    //   536: aload 9
    //   538: invokevirtual 235	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   541: pop
    //   542: aload 4
    //   544: ldc 133
    //   546: aload 12
    //   548: ldc 133
    //   550: invokevirtual 139	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   553: invokevirtual 235	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   556: pop
    //   557: aload 4
    //   559: ldc 144
    //   561: aload 12
    //   563: ldc 144
    //   565: invokevirtual 139	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   568: invokevirtual 235	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   571: pop
    //   572: aload 4
    //   574: ldc_w 273
    //   577: aload 12
    //   579: ldc_w 273
    //   582: invokevirtual 139	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   585: invokevirtual 235	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   588: pop
    //   589: aload 13
    //   591: ldc_w 275
    //   594: aload 4
    //   596: invokevirtual 235	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   599: pop
    //   600: new 135	org/json/JSONObject
    //   603: dup
    //   604: invokespecial 213	org/json/JSONObject:<init>	()V
    //   607: astore 4
    //   609: aload 4
    //   611: ldc_w 277
    //   614: aload_2
    //   615: getfield 280	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:mFirstPagePicUrl	Ljava/lang/String;
    //   618: ldc_w 281
    //   621: invokestatic 287	com/tencent/mobileqq/utils/ViewUtils:dpToPx	(F)I
    //   624: ldc_w 288
    //   627: invokestatic 287	com/tencent/mobileqq/utils/ViewUtils:dpToPx	(F)I
    //   630: invokestatic 293	com/tencent/mobileqq/kandian/glue/utils/RIJSmartCropUtils:a	(Ljava/lang/String;II)Ljava/lang/String;
    //   633: invokevirtual 235	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   636: pop
    //   637: aload 13
    //   639: ldc_w 295
    //   642: aload 4
    //   644: invokevirtual 235	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   647: pop
    //   648: aload 13
    //   650: ldc_w 297
    //   653: new 135	org/json/JSONObject
    //   656: dup
    //   657: invokespecial 213	org/json/JSONObject:<init>	()V
    //   660: invokevirtual 235	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   663: pop
    //   664: new 135	org/json/JSONObject
    //   667: dup
    //   668: invokespecial 213	org/json/JSONObject:<init>	()V
    //   671: astore 4
    //   673: aload_2
    //   674: getfield 300	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:mVideoDuration	I
    //   677: sipush 1000
    //   680: imul
    //   681: i2l
    //   682: invokestatic 303	com/tencent/mobileqq/kandian/biz/playfeeds/VideoFeedsHelper:a	(J)Ljava/lang/StringBuilder;
    //   685: astore 5
    //   687: aload 5
    //   689: ifnull +40 -> 729
    //   692: aload 5
    //   694: invokevirtual 229	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   697: astore 5
    //   699: aload 5
    //   701: invokestatic 246	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   704: ifne +25 -> 729
    //   707: aload 4
    //   709: ldc_w 305
    //   712: aload 5
    //   714: invokevirtual 235	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   717: pop
    //   718: aload 13
    //   720: ldc_w 307
    //   723: aload 4
    //   725: invokevirtual 235	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   728: pop
    //   729: new 135	org/json/JSONObject
    //   732: dup
    //   733: invokespecial 213	org/json/JSONObject:<init>	()V
    //   736: astore 7
    //   738: aload 7
    //   740: ldc_w 309
    //   743: aload_2
    //   744: getfield 312	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:mTitle	Ljava/lang/String;
    //   747: invokevirtual 235	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   750: pop
    //   751: invokestatic 61	com/tencent/mobileqq/kandian/glue/businesshandler/engine/ReadInJoyLogicEngine:a	()Lcom/tencent/mobileqq/kandian/glue/businesshandler/engine/ReadInJoyLogicEngine;
    //   754: aload_2
    //   755: getfield 65	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:mArticleID	J
    //   758: invokevirtual 68	com/tencent/mobileqq/kandian/glue/businesshandler/engine/ReadInJoyLogicEngine:a	(J)Z
    //   761: istore_3
    //   762: ldc 72
    //   764: astore 5
    //   766: iload_3
    //   767: ifeq +10 -> 777
    //   770: ldc 70
    //   772: astore 4
    //   774: goto +7 -> 781
    //   777: ldc 72
    //   779: astore 4
    //   781: aload 7
    //   783: ldc_w 314
    //   786: aload 4
    //   788: invokevirtual 235	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   791: pop
    //   792: aload 7
    //   794: ldc_w 316
    //   797: invokestatic 319	com/tencent/mobileqq/kandian/repo/aladdin/handlers/DoubleShortVideoFontSizeConfigHandler:a	()Ljava/lang/String;
    //   800: invokevirtual 235	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   803: pop
    //   804: aload 13
    //   806: ldc_w 321
    //   809: aload 7
    //   811: invokevirtual 235	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   814: pop
    //   815: new 135	org/json/JSONObject
    //   818: dup
    //   819: invokespecial 213	org/json/JSONObject:<init>	()V
    //   822: astore 7
    //   824: aload 7
    //   826: ldc_w 323
    //   829: aload_2
    //   830: getfield 151	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:mSubscribeName	Ljava/lang/String;
    //   833: invokevirtual 235	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   836: pop
    //   837: aload_2
    //   838: getfield 326	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:mArticleSubscriptColor	Ljava/lang/String;
    //   841: invokestatic 246	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   844: ifne +12 -> 856
    //   847: aload_2
    //   848: getfield 326	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:mArticleSubscriptColor	Ljava/lang/String;
    //   851: astore 4
    //   853: goto +8 -> 861
    //   856: ldc_w 328
    //   859: astore 4
    //   861: aload 7
    //   863: ldc_w 330
    //   866: aload 4
    //   868: invokevirtual 235	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   871: pop
    //   872: aload 13
    //   874: ldc_w 332
    //   877: aload 7
    //   879: invokevirtual 235	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   882: pop
    //   883: new 135	org/json/JSONObject
    //   886: dup
    //   887: invokespecial 213	org/json/JSONObject:<init>	()V
    //   890: astore 4
    //   892: aload_2
    //   893: getfield 335	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:mVideoCommentCount	I
    //   896: invokestatic 337	com/tencent/mobileqq/kandian/biz/playfeeds/VideoFeedsHelper:d	(I)Ljava/lang/String;
    //   899: astore 7
    //   901: aload 7
    //   903: invokestatic 246	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   906: ifne +57 -> 963
    //   909: new 215	java/lang/StringBuilder
    //   912: dup
    //   913: invokespecial 216	java/lang/StringBuilder:<init>	()V
    //   916: astore 10
    //   918: aload 10
    //   920: aload 7
    //   922: invokevirtual 222	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   925: pop
    //   926: aload 10
    //   928: ldc_w 338
    //   931: invokestatic 342	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   934: invokevirtual 222	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   937: pop
    //   938: aload 4
    //   940: ldc_w 344
    //   943: aload 10
    //   945: invokevirtual 229	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   948: invokevirtual 235	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   951: pop
    //   952: aload 13
    //   954: ldc_w 346
    //   957: aload 4
    //   959: invokevirtual 235	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   962: pop
    //   963: new 135	org/json/JSONObject
    //   966: dup
    //   967: invokespecial 213	org/json/JSONObject:<init>	()V
    //   970: astore 4
    //   972: aload 4
    //   974: ldc_w 348
    //   977: aload 16
    //   979: invokevirtual 235	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   982: pop
    //   983: aload 4
    //   985: ldc_w 350
    //   988: aload 8
    //   990: invokevirtual 235	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   993: pop
    //   994: aload 4
    //   996: ldc 133
    //   998: aload 12
    //   1000: ldc 133
    //   1002: invokevirtual 139	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1005: invokevirtual 235	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1008: pop
    //   1009: aload 4
    //   1011: ldc 144
    //   1013: aload 12
    //   1015: ldc 144
    //   1017: invokevirtual 139	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1020: invokevirtual 235	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1023: pop
    //   1024: aload 4
    //   1026: ldc_w 352
    //   1029: aload 12
    //   1031: ldc_w 352
    //   1034: invokevirtual 139	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1037: invokevirtual 235	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1040: pop
    //   1041: aload 13
    //   1043: ldc_w 275
    //   1046: aload 4
    //   1048: invokevirtual 235	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1051: pop
    //   1052: new 135	org/json/JSONObject
    //   1055: dup
    //   1056: invokespecial 213	org/json/JSONObject:<init>	()V
    //   1059: astore 4
    //   1061: aload 4
    //   1063: ldc_w 354
    //   1066: aload 14
    //   1068: getfield 280	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:mFirstPagePicUrl	Ljava/lang/String;
    //   1071: ldc_w 281
    //   1074: invokestatic 287	com/tencent/mobileqq/utils/ViewUtils:dpToPx	(F)I
    //   1077: ldc_w 288
    //   1080: invokestatic 287	com/tencent/mobileqq/utils/ViewUtils:dpToPx	(F)I
    //   1083: invokestatic 293	com/tencent/mobileqq/kandian/glue/utils/RIJSmartCropUtils:a	(Ljava/lang/String;II)Ljava/lang/String;
    //   1086: invokevirtual 235	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1089: pop
    //   1090: aload 13
    //   1092: ldc_w 356
    //   1095: aload 4
    //   1097: invokevirtual 235	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1100: pop
    //   1101: aload 13
    //   1103: ldc_w 358
    //   1106: new 135	org/json/JSONObject
    //   1109: dup
    //   1110: invokespecial 213	org/json/JSONObject:<init>	()V
    //   1113: invokevirtual 235	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1116: pop
    //   1117: new 135	org/json/JSONObject
    //   1120: dup
    //   1121: invokespecial 213	org/json/JSONObject:<init>	()V
    //   1124: astore 4
    //   1126: aload 14
    //   1128: getfield 300	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:mVideoDuration	I
    //   1131: sipush 1000
    //   1134: imul
    //   1135: i2l
    //   1136: invokestatic 303	com/tencent/mobileqq/kandian/biz/playfeeds/VideoFeedsHelper:a	(J)Ljava/lang/StringBuilder;
    //   1139: astore 7
    //   1141: aload 7
    //   1143: ifnull +40 -> 1183
    //   1146: aload 7
    //   1148: invokevirtual 229	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1151: astore 7
    //   1153: aload 7
    //   1155: invokestatic 246	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1158: ifne +25 -> 1183
    //   1161: aload 4
    //   1163: ldc_w 360
    //   1166: aload 7
    //   1168: invokevirtual 235	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1171: pop
    //   1172: aload 13
    //   1174: ldc_w 362
    //   1177: aload 4
    //   1179: invokevirtual 235	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1182: pop
    //   1183: new 135	org/json/JSONObject
    //   1186: dup
    //   1187: invokespecial 213	org/json/JSONObject:<init>	()V
    //   1190: astore 7
    //   1192: aload 7
    //   1194: ldc_w 364
    //   1197: aload 14
    //   1199: getfield 312	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:mTitle	Ljava/lang/String;
    //   1202: invokevirtual 235	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1205: pop
    //   1206: aload 5
    //   1208: astore 4
    //   1210: invokestatic 61	com/tencent/mobileqq/kandian/glue/businesshandler/engine/ReadInJoyLogicEngine:a	()Lcom/tencent/mobileqq/kandian/glue/businesshandler/engine/ReadInJoyLogicEngine;
    //   1213: aload 14
    //   1215: getfield 65	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:mArticleID	J
    //   1218: invokevirtual 68	com/tencent/mobileqq/kandian/glue/businesshandler/engine/ReadInJoyLogicEngine:a	(J)Z
    //   1221: ifeq +7 -> 1228
    //   1224: ldc 70
    //   1226: astore 4
    //   1228: aload 7
    //   1230: ldc_w 366
    //   1233: aload 4
    //   1235: invokevirtual 235	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1238: pop
    //   1239: aload 7
    //   1241: ldc_w 368
    //   1244: invokestatic 319	com/tencent/mobileqq/kandian/repo/aladdin/handlers/DoubleShortVideoFontSizeConfigHandler:a	()Ljava/lang/String;
    //   1247: invokevirtual 235	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1250: pop
    //   1251: aload 13
    //   1253: ldc_w 370
    //   1256: aload 7
    //   1258: invokevirtual 235	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1261: pop
    //   1262: new 135	org/json/JSONObject
    //   1265: dup
    //   1266: invokespecial 213	org/json/JSONObject:<init>	()V
    //   1269: astore 5
    //   1271: aload 14
    //   1273: getfield 326	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:mArticleSubscriptColor	Ljava/lang/String;
    //   1276: invokestatic 246	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1279: ifne +13 -> 1292
    //   1282: aload 14
    //   1284: getfield 326	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:mArticleSubscriptColor	Ljava/lang/String;
    //   1287: astore 4
    //   1289: goto +8 -> 1297
    //   1292: ldc_w 328
    //   1295: astore 4
    //   1297: aload 5
    //   1299: ldc_w 372
    //   1302: aload 4
    //   1304: invokevirtual 235	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1307: pop
    //   1308: aload 5
    //   1310: ldc_w 374
    //   1313: aload 14
    //   1315: getfield 151	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:mSubscribeName	Ljava/lang/String;
    //   1318: invokevirtual 235	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1321: pop
    //   1322: aload 13
    //   1324: ldc_w 376
    //   1327: aload 5
    //   1329: invokevirtual 235	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1332: pop
    //   1333: new 135	org/json/JSONObject
    //   1336: dup
    //   1337: invokespecial 213	org/json/JSONObject:<init>	()V
    //   1340: astore 4
    //   1342: aload 14
    //   1344: getfield 335	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:mVideoCommentCount	I
    //   1347: invokestatic 337	com/tencent/mobileqq/kandian/biz/playfeeds/VideoFeedsHelper:d	(I)Ljava/lang/String;
    //   1350: astore 5
    //   1352: aload 5
    //   1354: invokestatic 246	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1357: ifne +57 -> 1414
    //   1360: new 215	java/lang/StringBuilder
    //   1363: dup
    //   1364: invokespecial 216	java/lang/StringBuilder:<init>	()V
    //   1367: astore 7
    //   1369: aload 7
    //   1371: aload 5
    //   1373: invokevirtual 222	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1376: pop
    //   1377: aload 7
    //   1379: ldc_w 377
    //   1382: invokestatic 342	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   1385: invokevirtual 222	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1388: pop
    //   1389: aload 4
    //   1391: ldc_w 379
    //   1394: aload 7
    //   1396: invokevirtual 229	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1399: invokevirtual 235	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1402: pop
    //   1403: aload 13
    //   1405: ldc_w 381
    //   1408: aload 4
    //   1410: invokevirtual 235	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1413: pop
    //   1414: aload 13
    //   1416: ldc_w 383
    //   1419: ldc_w 385
    //   1422: invokevirtual 235	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1425: pop
    //   1426: aload 12
    //   1428: ldc 231
    //   1430: aload 17
    //   1432: invokevirtual 235	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1435: pop
    //   1436: aload 12
    //   1438: ldc 248
    //   1440: aload 6
    //   1442: invokevirtual 235	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1445: pop
    //   1446: aload 12
    //   1448: ldc_w 387
    //   1451: aload 9
    //   1453: invokevirtual 235	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1456: pop
    //   1457: aload 12
    //   1459: ldc_w 389
    //   1462: aload 8
    //   1464: invokevirtual 235	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1467: pop
    //   1468: aload 12
    //   1470: ldc_w 391
    //   1473: aload 15
    //   1475: invokevirtual 235	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1478: pop
    //   1479: aload 12
    //   1481: ldc_w 393
    //   1484: aload 16
    //   1486: invokevirtual 235	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1489: pop
    //   1490: new 215	java/lang/StringBuilder
    //   1493: dup
    //   1494: invokespecial 216	java/lang/StringBuilder:<init>	()V
    //   1497: astore 4
    //   1499: aload 4
    //   1501: ldc 218
    //   1503: invokevirtual 222	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1506: pop
    //   1507: aload 4
    //   1509: aload_2
    //   1510: getfield 151	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:mSubscribeName	Ljava/lang/String;
    //   1513: invokevirtual 222	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1516: pop
    //   1517: aload 4
    //   1519: ldc 224
    //   1521: invokevirtual 222	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1524: pop
    //   1525: aload 4
    //   1527: aload 14
    //   1529: getfield 151	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:mSubscribeName	Ljava/lang/String;
    //   1532: invokevirtual 222	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1535: pop
    //   1536: aload 4
    //   1538: ldc 226
    //   1540: invokevirtual 222	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1543: pop
    //   1544: aload 12
    //   1546: ldc_w 395
    //   1549: aload 4
    //   1551: invokevirtual 229	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1554: invokevirtual 235	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1557: pop
    //   1558: aload 12
    //   1560: ldc_w 397
    //   1563: aload_2
    //   1564: getfield 151	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:mSubscribeName	Ljava/lang/String;
    //   1567: invokevirtual 235	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1570: pop
    //   1571: aload 12
    //   1573: ldc_w 399
    //   1576: aload 14
    //   1578: getfield 151	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:mSubscribeName	Ljava/lang/String;
    //   1581: invokevirtual 235	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1584: pop
    //   1585: aload_2
    //   1586: aload 12
    //   1588: invokevirtual 400	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1591: putfield 403	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:proteusItemsData	Ljava/lang/String;
    //   1594: aload 13
    //   1596: areturn
    //   1597: new 135	org/json/JSONObject
    //   1600: dup
    //   1601: invokespecial 213	org/json/JSONObject:<init>	()V
    //   1604: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1605	0	this	DoubleShortVideoProteusItem
    //   0	1605	1	paramInt	int
    //   0	1605	2	paramAbsBaseArticleInfo	AbsBaseArticleInfo
    //   761	6	3	bool	boolean
    //   105	1445	4	localObject1	Object
    //   221	1151	5	localObject2	Object
    //   235	135	6	localObject3	Object
    //   386	1	6	localException1	java.lang.Exception
    //   391	1	6	localException2	java.lang.Exception
    //   399	36	6	localException3	java.lang.Exception
    //   460	981	6	localObject4	Object
    //   46	1349	7	localObject5	Object
    //   243	1220	8	localObject6	Object
    //   239	1213	9	localObject7	Object
    //   52	892	10	localStringBuilder	java.lang.StringBuilder
    //   49	209	11	localObject8	Object
    //   43	1544	12	localJSONObject1	JSONObject
    //   68	1527	13	localJSONObject2	JSONObject
    //   83	1494	14	localAbsBaseArticleInfo	AbsBaseArticleInfo
    //   89	1385	15	str1	java.lang.String
    //   96	1389	16	str2	java.lang.String
    //   152	1279	17	str3	java.lang.String
    //   161	345	18	localJSONObject3	JSONObject
    // Exception table:
    //   from	to	target	type
    //   245	253	386	java/lang/Exception
    //   269	277	386	java/lang/Exception
    //   281	290	386	java/lang/Exception
    //   294	302	386	java/lang/Exception
    //   306	314	386	java/lang/Exception
    //   318	326	386	java/lang/Exception
    //   330	338	386	java/lang/Exception
    //   342	350	386	java/lang/Exception
    //   354	361	386	java/lang/Exception
    //   365	375	386	java/lang/Exception
    //   200	217	391	java/lang/Exception
    //   173	188	399	java/lang/Exception
  }
  
  public void a(int paramInt1, Container paramContainer, IReadInJoyModel paramIReadInJoyModel, int paramInt2)
  {
    paramContainer = paramContainer.getVirtualView();
    if (paramContainer == null) {
      return;
    }
    a(paramContainer.findViewBaseByName("id_artilce_title_1"), paramIReadInJoyModel.k());
    if ((paramIReadInJoyModel.k() != null) && (paramIReadInJoyModel.k().mSubArticleList != null) && (paramIReadInJoyModel.k().mSubArticleList.size() > 0) && (paramIReadInJoyModel.k().mSubArticleList.get(0) != null)) {
      a(paramContainer.findViewBaseByName("id_artilce_title_2"), (AbsBaseArticleInfo)paramIReadInJoyModel.k().mSubArticleList.get(0));
    }
  }
  
  public boolean a(int paramInt, Container paramContainer, IReadInJoyModel paramIReadInJoyModel, ViewBase paramViewBase)
  {
    paramInt = StringCommon.getStrIdFromString(paramViewBase.getClickEvnet());
    if ((paramInt != 1131) && (paramInt != 1132)) {
      return false;
    }
    paramViewBase.setOnClickListener(new DoubleShortVideoProteusItem.1(this, paramIReadInJoyModel, paramInt, paramContainer));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.item.DoubleShortVideoProteusItem
 * JD-Core Version:    0.7.0.1
 */